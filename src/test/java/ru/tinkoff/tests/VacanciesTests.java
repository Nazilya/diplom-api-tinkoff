package ru.tinkoff.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.tinkoff.models.RezumeRequestModel;
import ru.tinkoff.models.VacansiesResponseModel;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Nazilya")
@Tag("Api")
public class VacanciesTests extends TestBase {
    private String response;

    @Story("Get vacancy")
    @DisplayName("Проверка получения вакансии по названию")
    @Test
    void getVacancyTest() {
        VacansiesResponseModel vacansy = step("Получить вакансию " + testData.getVacanciesName(), () ->
                steps.getVacancy("qa-backend"));

        step("Проверить, что вакансия опубликована", () ->
                assertEquals("published", vacansy.getResponse().getStatus()));
        step("Проверить, что категория вакансии '" + testData.getVacanciesCategory() + "'", () ->
                assertEquals("Работа в IT", vacansy.getResponse().getCategory().getName()));
        step("Проверить, что название вакансии '" + testData.getVacanciesName() + "'", () ->
                assertEquals("qa-backend", vacansy.getResponse().getUrlSlug()));
    }

    @Story("Send rezume")
    @DisplayName("Проверка отклика на вакансию с пустым полем Email")
    @Test
    void sendRezumeWithEmptyEmailTest() {
        step("Отправить отклик на вакансию с незаполненным полем Email", () -> {
            RezumeRequestModel rezume = testData.getRezumeForSend();
            response = steps.sendRezumeWithEmptyEmailTest(rezume);
        });
        step("Проверить текст ошибки: " + testData.getErrorMessage(), () ->
                assertTrue(response.contains("email must be an email")));
    }
}





