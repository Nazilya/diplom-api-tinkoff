package ru.tinkoff.tests;

import ru.tinkoff.helpers.TestData;
import ru.tinkoff.models.AddressResponseModel;
import ru.tinkoff.models.PopularNamesListResponseModel;
import ru.tinkoff.models.VacanciesListResponseModel;
import ru.tinkoff.models.VacansiesResponseModel;
import ru.tinkoff.steps.Steps;

import java.util.List;

public class TestBase {
    TestData testData = new TestData();
    Steps steps = new Steps();
    VacansiesResponseModel vacansy;
    List<VacanciesListResponseModel.Response.ItemOut> vacanciesList;
    List<PopularNamesListResponseModel.PopularNames> popularNames;
    List<AddressResponseModel.FullAddress.CityData> cityData;
}
