package hu.example.samplerecursiveapp.search.service;

import hu.example.samplerecursiveapp.search.dto.HistoryDto;
import hu.example.samplerecursiveapp.search.entity.History;
import hu.example.samplerecursiveapp.search.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.System.getProperty;
import static java.time.ZonedDateTime.now;

@Service
@RequiredArgsConstructor
public class HistoryService {

    public static final String USER_NAME_PROPERTY = "user.name";
    private final HistoryRepository historyRepository;

    @Transactional
    public List<HistoryDto> getHistory(String searchCondition) {
        return historyRepository.findAllBySearchConditions(searchCondition)
                .map(this::toHistoryDto)
                .toList();
    }

    public void saveHistory(String directoryName) {
        History history = new History();

        history.setName(getProperty(USER_NAME_PROPERTY));
        history.setSearchConditions(directoryName);
        history.setSearchTime(now());

        historyRepository.save(history);
    }

    private HistoryDto toHistoryDto(History history) {
        return HistoryDto.builder()
                .name(history.getName())
                .searchConditions(history.getSearchConditions())
                .searchTime(history.getSearchTime())
                .build();
    }

}
