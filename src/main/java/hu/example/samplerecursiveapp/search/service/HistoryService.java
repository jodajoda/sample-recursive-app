package hu.example.samplerecursiveapp.search.service;

import hu.example.samplerecursiveapp.search.dto.HistoryDto;
import hu.example.samplerecursiveapp.search.entity.History;
import hu.example.samplerecursiveapp.search.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private HistoryRepository historyRepository;

    public HistoryDto getHistory() {
        //TODO
        return historyRepository.findAll().stream()
                .map(this::toHistoryDto)
                .findFirst()
                .get();
    }

    private HistoryDto toHistoryDto(History history) {
        return HistoryDto.builder()
                .name(history.getName())
                .searchConditions(history.getSearchConditions())
                .searchTime(history.getSearchTime())
                .build();
    }

}
