package hu.example.samplerecursiveapp.search;

import hu.example.samplerecursiveapp.search.dto.HistoryDto;
import hu.example.samplerecursiveapp.search.service.HistoryService;
import hu.example.samplerecursiveapp.search.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/search")
@AllArgsConstructor
public class SearchController {

    private SearchService searchService;
    private HistoryService historyService;

    @GetMapping("/getUnique")
    public ResponseEntity<Set<String>> getUnique(@RequestParam String folderName) {
        return ResponseEntity.ok(searchService.getUniqueFileNames(folderName));
    }

    @GetMapping("history")
    public ResponseEntity<HistoryDto> history(@RequestParam String folderName) {
        return ResponseEntity.ok(historyService.getHistory());
    }

}
