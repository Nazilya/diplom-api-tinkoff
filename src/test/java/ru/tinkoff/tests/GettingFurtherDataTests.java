package ru.tinkoff.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.tinkoff.models.AddressRequestModel;
import ru.tinkoff.models.AddressResponseModel;
import ru.tinkoff.models.PopularNamesListResponseModel;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Nazilya")
@Tag("Api")
public class GettingFurtherDataTests extends TestBase {
    @Story("FIO")
    @DisplayName("Проверка получения распространенных фамилий по первым буквам")
    @Test
    void getPopularNamesTest() {
        List<PopularNamesListResponseModel.PopularNames> popularNames = step(
                "Получить распространенные фамилии по первым буквам: " + testData.getPopularName(), () ->
                        steps.getPopularNamesList("Иван", "surname"));

        step("Проверить, что в списке полученных значений все фамилии начинаются с 'Иван'", () ->
                assertTrue(popularNames.stream().allMatch(x -> x.getValue().startsWith("Иван"))));
        step("Проверить, что в списке значения поля 'пол' не пустые ", () ->
                assertTrue(popularNames.stream().allMatch(x -> (!x.getGender().isEmpty()))));
    }

    @Story("Address")
    @DisplayName("Проверка получения адреса")
    @Test
    void getAddressTest() {
        AddressRequestModel addressParams = step(
                "Получить модель для получения адреса с заданными параметрами: '" + testData.getCityForSearch() + "'", () ->
                        testData.getAddressParamsForSearch("Сан", "city", "city"));

        List<AddressResponseModel.FullAddress.CityData> cityData = step("Получить адреса по модели запроса", () ->
                steps.getAddress(addressParams));

        step("Проверить, что тип адреса 'город' (city)", () ->
                assertTrue(cityData.stream().allMatch(x -> x.getCityTypeFull().contains("город"))));
        step("Проверить, что в названиях городов присутствует сочетание букв 'Сан'", () ->
                assertTrue(cityData.stream().allMatch(x -> x.getCityWithType().contains("Сан"))));
        step("Проверить, что значения 'долгота' и 'широта' присутствуют (не пустые)", () ->
                assertTrue(cityData.stream().allMatch(x -> ((!x.getGeoLon().isEmpty()) && (!x.getGeoLat().isEmpty())))));
    }
}





