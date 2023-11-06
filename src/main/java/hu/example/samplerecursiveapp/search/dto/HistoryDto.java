package hu.example.samplerecursiveapp.search.dto;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;


@Builder
@Data
public class HistoryDto {

    private String name;
    private String searchConditions;
    private ZonedDateTime searchTime;

}
