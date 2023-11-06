package hu.example.samplerecursiveapp.search.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Log4j2
public class SearchService {

    private final HistoryService historyService;


    public Set<String> getUniqueFileNames(String directoryName) {
        String path = "/" + directoryName;

        historyService.saveHistory(directoryName);

        return listAllFiles(path);
    }


//    public Set<String> listFiles(String path) throws IOException {
//        try (Stream<Path> stream = Files.list(Paths.get(path))) {
//            return stream
//                    .filter(file -> !Files.isDirectory(file))
//                    .map(Path::getFileName)
//                    .map(Path::toString)
//                    .collect(Collectors.toSet());
//        }
//    }

    protected Set<String> listAllFiles(String path) {
        Set<String> result = new HashSet<>();

        try (Stream<Path> stream = Files.list(Paths.get(path))) {
            stream.forEach(file -> {
                if (Files.isDirectory(file)) {
                    result.addAll(listAllFiles(file.toString()));
                } else
                    result.add(file.getFileName().toString());
            });
        } catch (IOException e) {
            log.error("Error while list files or directories", e);
        }

        return result;
    }
}
