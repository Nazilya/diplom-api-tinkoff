package ru.tinkoff.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class VacanciesListRequestModel {
    private String category;
    private int limit;
    private Filters filters;

    @Setter
    @Builder
    public static class Filters {
        private String [] specialties;
        private String [] grades;

    }
}

/*
{
    "category": "it",
    "limit": 5,
    "filters": {
        "specialties": [
            "testirovanie",
            "Fullstack"
        ],
        "grades": [
            "middle"
        ]
    }
}
*/