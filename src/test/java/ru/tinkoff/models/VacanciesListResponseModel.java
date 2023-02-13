package ru.tinkoff.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class VacanciesListResponseModel {
    private Response response;

    @Data
    @SuppressWarnings("unused")
    public static class Response {
        private List<ItemOut> itemsOut;

        @Data
        @SuppressWarnings("unused")
        public static class ItemOut {
            private String title;
            private String id;
            private Long total;
            private List<ItemIn> itemInList;

        }

        @Data
        @SuppressWarnings("unused")
        public static class ItemIn {
            private String title;
            private String id;
            private String grade;
            private List<String> cities;
            private Boolean isResumeRequired;
            private Object shortDescription;
        }

    }
}



/*
{
    "response": {
        "items": [
            {
                "title": "Тестирование",
                "id": "testirovanie",
                "total": 14,
                "items": [
                    {
                        "title": "Инженер по автоматизации (JavaScript)",
                        "id": "qa-auto-javascript",
                        "grade": "Middle",
                        "cities": [
                            "Любой город"
                        ],
                        "isResumeRequired": true,
                        "shortDescription": null
                    },
                    {
                        "title": "Инженер по тестированию (backend)",
                        "id": "qa-backend",
                        "grade": "Middle",
                        "cities": [
                            "Любой город"
                        ],
                        "isResumeRequired": true,
                        "shortDescription": null
                    }
                ]
            }
        ]
    }
}
 */