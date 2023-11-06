package hu.example.samplerecursiveapp.search;

import hu.example.samplerecursiveapp.search.dto.HistoryDto;
import hu.example.samplerecursiveapp.search.service.HistoryService;
import hu.example.samplerecursiveapp.search.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/search")
@AllArgsConstructor
public class SearchController {

    private final SearchService searchService;
    private final HistoryService historyService;

    @GetMapping("/getUnique")
    public ResponseEntity<Set<String>> getUnique(@RequestParam String directoryName) {
        return ResponseEntity.ok(searchService.getUniqueFileNames(directoryName));
    }

    @GetMapping("history")
    public ResponseEntity<List<HistoryDto>> history(@RequestParam String directoryName) {
        return ResponseEntity.ok(historyService.getHistory(directoryName));
    }

}
