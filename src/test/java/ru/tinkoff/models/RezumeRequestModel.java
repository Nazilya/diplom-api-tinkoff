package ru.tinkoff.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class RezumeRequestModel {
    private String vacancyId;
    private String name;
    private String phone;
    private String email;
    private String city;
    private String vacancyUrl;
}

/* request
{
    "vacancyId": "7268a34c-ded3-4a2b-b6c7-a9259d01664e",
    "name": "Иванов Иван",
    "phone": "2095420665",
    "email": "",
    "city": "Москва",
    "vacancyUrl": "https://www.tinkoff.ru/career/it/testirovanie/qa-backend/"
}
 */

