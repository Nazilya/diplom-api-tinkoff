package ru.tinkoff.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.tinkoff.models.VacanciesListRequestModel;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VacanciesListTests extends TestBase{
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
}





