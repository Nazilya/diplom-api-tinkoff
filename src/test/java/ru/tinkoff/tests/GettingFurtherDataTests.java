package ru.tinkoff.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.tinkoff.models.AddressRequestModel;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GettingFurtherDataTests extends TestBase{
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

}





