package ru.tinkoff.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.tinkoff.models.VacanciesListRequestModel;
import ru.tinkoff.models.VacanciesListResponseModel;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Nazilya")
@Tag("Api")
public class VacanciesListTests extends TestBase {
    @Story("VacanciesList")
    @DisplayName("Проверка получения списка вакансий по спец-сти")
    @Test
    void getVacanciesListBySpecialtyAndCategoryTest() {
        VacanciesListRequestModel vacancyParams = step(
                "Получить модель для запроса вакансий с заданными параметрами", () ->
                        testData.getParamsWithSpecAndCategoryForSearchVacancy(new String[]{"testirovanie"}, "it"));

        List<VacanciesListResponseModel.Response.ItemOut> vacanciesList = step(
                "Получить вакансии по спец-сти: " + testData.getSpeciality(), () ->
                        steps.getVacanciesList(vacancyParams));

        step("Проверить, что название специальности 'Тестирование'", () ->
                assertTrue(vacanciesList.stream().allMatch(x -> x.getTitle().contains("Тестирование"))));
        step("Проверить, что id полученных вакансий '" + testData.getSpeciality() + "'", () ->
                assertTrue(vacanciesList.stream().allMatch(x -> x.getId().contains("testirovanie"))));
    }

    @Story("VacanciesList")
    @DisplayName("Проверка получения списка вакансий по спец-сти и по грэйду")
    @Test
    void getVacanciesListBySpecialtyCategoryAndGradeTest() {
        VacanciesListRequestModel vacancyParams = step(
                "Получить модель для запроса вакансий с заданными параметрами", () ->
                        testData.getParamsWithSpecCategoryAndGradeForSearchVacancy(
                                new String[]{"testirovanie"}, new String[]{"junior"}, "it"));

        List<VacanciesListResponseModel.Response.ItemOut> vacanciesList = step(
                "Получить вакансии по спец-сти: " + testData.getSpeciality() + " для junior-ов", () ->
                        steps.getVacanciesList(vacancyParams));

        step("проверить, что в IT по спец-сти 'Тестирование' нет вакансий для junior-ов", () ->
                assertTrue(vacanciesList.isEmpty()));
    }
}





