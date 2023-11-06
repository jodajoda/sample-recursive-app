package hu.example.samplerecursiveapp.search.service;

import hu.example.samplerecursiveapp.search.dto.HistoryDto;
import hu.example.samplerecursiveapp.search.entity.History;
import hu.example.samplerecursiveapp.search.repository.HistoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Stream;

import static java.time.ZoneId.systemDefault;
import static java.time.ZonedDateTime.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HistoryServiceTest {

    public static final ZonedDateTime SEARCH_TIME = of(2023, 11, 6, 10, 0, 0, 0, systemDefault());
    public static final String DIR_NAME = "etc";
    public static final String USER_NAME = "root";
    @InjectMocks
    HistoryService historyService;

    @Mock
    HistoryRepository historyRepository;


    @Test
    void getHistoryTest() {
        History history = new History();
        history.setName(USER_NAME);
        history.setSearchConditions(DIR_NAME);
        history.setSearchTime(SEARCH_TIME);

        when(historyRepository.findAllBySearchConditions(DIR_NAME)).thenReturn(Stream.of(history));

        List<HistoryDto> result = historyService.getHistory(DIR_NAME);

        assertEquals(1, result.size());
        assertEquals(USER_NAME, result.get(0).getName());
        assertEquals(DIR_NAME, result.get(0).getSearchConditions());
        assertEquals(SEARCH_TIME, result.get(0).getSearchTime());
    }

    @Test
    void getHistoryWithoutDataTest() {
        assertEquals(0, historyService.getHistory(DIR_NAME).size());
    }
}
