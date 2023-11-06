package hu.example.samplerecursiveapp.search.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SearchService {


    public Set<String> getUniqueFileNames(String folderName) {
        return new HashSet<>();
    }

}
