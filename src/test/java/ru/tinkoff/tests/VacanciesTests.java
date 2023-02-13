package ru.tinkoff.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.tinkoff.models.RezumeRequestModel;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VacanciesTests extends TestBase{
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
    @Story("Send rezume")
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





