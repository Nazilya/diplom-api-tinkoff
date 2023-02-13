package ru.tinkoff.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.tinkoff.models.AddressRequestModel;
import ru.tinkoff.models.RezumeRequestModel;
import ru.tinkoff.models.VacanciesListRequestModel;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TinkoffTests extends TestBase{
    private String response;

    @Test
    @Owner("Nazilya")
    @Tag("Api")
    @Story("Get vacancy")
    @DisplayName("Проверка получения вакансии по названию")
    void getVacancyTest() {
        step("Получить вакансию " + testData.getVacanciesName(), () -> {
            vacansy = steps.getVacancy("qa-backend");
        });
        step("Проверить, что вакансия опубликована", () -> {
            assertEquals("published", vacansy.getResponse().getStatus());
        });
        step("Проверить, что категория вакансии '" + testData.getVacanciesCategory() + "'", () -> {
            assertEquals("Работа в IT", vacansy.getResponse().getCategory().getName());
        });
        step("Проверить, что название вакансии '" + testData.getVacanciesName() + "'", () -> {
        assertEquals("qa-backend", vacansy.getResponse().getUrlSlug());
        });
    }
    @Test
    @Owner("Nazilya")
    @Tag("Api")
    @Story("VacanciesList")
    @DisplayName("Проверка получения списка вакансий по спец-сти")
    void getVacanciesListBySpecialtyAndCategoryTest() {
        step("Получить вакансии по спец-сти: " + testData.getSpeciality() , () -> {
            VacanciesListRequestModel vacancyParams = testData
                    .getParamsWithSpecAndCategoryForSearchVacancy(new String[]{"testirovanie"}, "it");
            vacanciesList = steps.getVacanciesList(vacancyParams);
        });
        step("Проверить, что название специальности 'Тестирование'", () -> {
            assertTrue(vacanciesList.stream().allMatch(x -> x.getTitle().contains("Тестирование")));
        });
        step("Проверить, что id полученных вакансий '" + testData.getSpeciality() + "'", () -> {
            assertTrue(vacanciesList.stream().allMatch(x -> x.getId().contains("testirovanie")));
        });
    }
    @Test
    @Owner("Nazilya")
    @Tag("Api")
    @Story("VacanciesList")
    @DisplayName("Проверка получения списка вакансий по спец-сти и по грэйду")
    void getVacanciesListBySpecialtyCategoryAndGradeTest() {
        step("Получить вакансии по спец-сти: " + testData.getSpeciality()+" для junior-ов", () -> {
            VacanciesListRequestModel vacancyParams = testData
                    .getParamsWithSpecCategoryAndGradeForSearchVacancy(
                    new String[]{"testirovanie"}, new String[]{"junior"}, "it");
            vacanciesList = steps.getVacanciesList(vacancyParams);
        });
        step("проверить, что в IT по спец-сти 'Тестирование' нет вакансий для junior-ов", () -> {
            assertTrue(vacanciesList.isEmpty());
        });
    }
    @Test
    @Owner("Nazilya")
    @Tag("Api")
    @Story("FIO")
    @DisplayName("Проверка получения распространенных фамилий по первым буквам")
    void getPopularNamesTest() {
        step("Получить распространенные фамилии по первым буквам: " + testData.getPopularName(), () -> {
            popularNames = steps.getPopularNamesList("Иван", "surname");
        });
        step("Проверить, что в списке полученных значений все фамилии начинаются с 'Иван'", () -> {
            assertTrue(popularNames.stream().allMatch(x -> x.getValue().startsWith("Иван")));
        });
        step("Проверить, что в списке значения поля 'пол' не пустые ", () -> {
            assertTrue(popularNames.stream().allMatch(x -> (!x.getGender().isEmpty())));
        });
    }
    @Test
    @Owner("Nazilya")
    @Tag("Api")
    @Story("Address")
    @DisplayName("Проверка получения адреса")
    void getAddressTest() {
        step("Получить адреса по первым буквам в названии: '" + testData.getCityForSearch() + "'", () -> {
            AddressRequestModel addressParams = testData
                    .getAddressParamsForSearch("Сан", "city", "city");
            cityData = steps.getAddress(addressParams);
        });
        step("Проверить, что тип адреса 'город' (city)", () -> {
            assertTrue(cityData.stream().allMatch(x -> x.getCityTypeFull().contains("город")));
        });
        step("Проверить, что в названиях городов присутствует сочетание букв 'Сан'", () -> {
            assertTrue(cityData.stream().allMatch(x -> x.getCityWithType().contains("Сан")));
        });
        step("Проверить, что значения 'долгота' и 'широта' присутствуют (не пустые)", () -> {
            assertTrue(cityData.stream().allMatch(x -> ((!x.getGeoLon().isEmpty()) && (!x.getGeoLat().isEmpty()))));
        });
    }
    @Test
    @Owner("Nazilya")
    @Tag("Api")
    @Story("Send Vacancy")
    @DisplayName("Проверка отклика на вакансию с пустым полем Email")
    void sendRezumeWithEmptyEmailTest() {
        step("Отправить отклик на вакансию с незаполненным полем Email", () -> {
            RezumeRequestModel rezume = testData.getRezumeForSend();
            response = steps.sendRezumeWithEmptyEmailTest(rezume);
        });
        step("Проверить текст ошибки: " + testData.getErrorMessage(), () -> {
            assertTrue(response.contains("email must be an email"));
        });
    }

}





