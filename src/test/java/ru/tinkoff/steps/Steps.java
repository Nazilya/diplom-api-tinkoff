package ru.tinkoff.steps;

import io.restassured.response.Response;
import ru.tinkoff.models.*;
import java.util.List;
import static io.restassured.RestAssured.given;
import static ru.tinkoff.helpers.Endpoints.*;
import static ru.tinkoff.specs.Specs.*;

public class Steps {
    public VacansiesResponseModel getVacancy(String vacanciesName) {
        VacansiesResponseModel vacansy =  given()
                .spec(request)
                .when()
                .param("urlSlug", vacanciesName)
                .get(VACANCY_ENDPOINT)
                .then()
                .spec(responseSpec)
                .log().status()
                .log().body()
                .extract().as(VacansiesResponseModel.class);
        return vacansy;
    }
    public List<VacanciesListResponseModel.Response.ItemOut> getVacanciesList(VacanciesListRequestModel searchParams) {

        return given()
                .spec(request)
                .body(searchParams)
                .when()
                .post(VACANCIES_LIST_ENDPOINT)
                .prettyPeek()
                .then()
                .spec(responseSpec)
                .extract().body().jsonPath().getList("response.items", VacanciesListResponseModel.Response.ItemOut.class);
    }
    public List<PopularNamesListResponseModel.PopularNames> getPopularNamesList(String searchName, String type) {
        return given()
                .spec(requestForBaseUrlTinkoff)
                .when()
                .param("name", searchName)
                .param("type", type)
                .get(NAMES_ENDPOINT)
                .prettyPeek()
                .then()
                .spec(responseSpec)
                .extract().body().jsonPath().getList("payload", PopularNamesListResponseModel.PopularNames.class);
    }
    public List<AddressResponseModel.FullAddress.CityData> getAddress(AddressRequestModel address) {

        return given()
                .spec(requestForApiUrlTinkoff)
                .body(address)
                .log().all()
                .when()
                .post(ADDRESS_ENDPOINT)
                .prettyPeek()
                .then()
                .spec(responseSpec)
                .extract().body().jsonPath().getList("suggestions.data", AddressResponseModel.FullAddress.CityData.class);
    }
    public String sendRezumeWithEmptyEmailTest(RezumeRequestModel rezume) {

        Response response = given()
                .spec(request)
                .headers("Referer", URL_TINKOFF)
                .body(rezume)
                .when()
                .post(SEND_REZUME_ENDPOINT)
                .prettyPeek()
                .then()
                .statusCode(400)
                .extract().response();

        String message = response.jsonPath().getString("errors.constraints.findAll{it.isEmail}.isEmail.flatten()");
        return message;
    }

}
