package hu.example.samplerecursiveapp.search.repository;

import hu.example.samplerecursiveapp.search.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    Stream<History> findAllBySearchConditions(String searchConditions);

}
