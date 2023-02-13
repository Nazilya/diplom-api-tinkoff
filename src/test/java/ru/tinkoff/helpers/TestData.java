package ru.tinkoff.helpers;

import com.github.javafaker.Faker;
import lombok.Getter;
import ru.tinkoff.models.AddressRequestModel;
import ru.tinkoff.models.RezumeRequestModel;
import ru.tinkoff.models.VacanciesListRequestModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Getter
public class TestData {
    Faker faker = new Faker(new Locale("ru"));

    private String name = faker.name().fullName(),
            email = faker.internet().emailAddress(),
            phone = "+7" + faker.phoneNumber().subscriberNumber(10),
            city = faker.address().cityName();
    private String vacancyId = "7268a34c-ded3-4a2b-b6c7-a9259d01664e",
            vacanciesUrl = "https://www.tinkoff.ru/career/it/testirovanie/qa-backend/",
            vacanciesName = "qa-backend",
            vacanciesCategory = "Работа в IT",
            speciality = "testirovanie",
            grade = "junior",
            popularName = "Иван",
            cityForSearch = "Сан",
            addressTypeFromBound = "city",
            addressTypeToBound = "city",
            cityTypeFull = "город",
            errorMessage = "email must be an email";


    public RezumeRequestModel getRezumeForSend() {
        RezumeRequestModel rezume = RezumeRequestModel.builder()
                .vacancyId(vacancyId)
                .phone(phone)
                .email("")
                .vacancyUrl(vacanciesUrl)
                .name(name)
                .city(city)
                .build();
        return rezume;
    }

    public AddressRequestModel getAddressParamsForSearch(String query, String fromBoundValue, String toBoundValue) {
        AddressRequestModel.FromBound fromBound = AddressRequestModel.FromBound.builder().value(fromBoundValue).build();
        AddressRequestModel.ToBound toBound = AddressRequestModel.ToBound.builder().value(toBoundValue).build();

        List<AddressRequestModel.Location> location = new ArrayList<>();
        AddressRequestModel.Location locRU = AddressRequestModel.Location.builder().cityTypeFull("город").countryIsoCode("RU").build();
        AddressRequestModel.Location locUA = AddressRequestModel.Location.builder().cityTypeFull("город").countryIsoCode("UA").build();
        location.add(locRU);
        location.add(locUA);

        AddressRequestModel address = AddressRequestModel.builder()
                .query(query)
                .fromBound(fromBound)
                .toBound(toBound)
                .locations(location)
                .build();
        return address;
    }
    public VacanciesListRequestModel getParamsWithSpecCategoryAndGradeForSearchVacancy(String[] specialities, String[] grades, String category) {
        VacanciesListRequestModel.Filters filters = VacanciesListRequestModel
                .Filters.builder()
                .specialties(specialities)
                .grades(grades)
                .build();
        VacanciesListRequestModel searchParams = VacanciesListRequestModel
                .builder()
                .category(category)
                .limit(2)
                .filters(filters)
                .build();
        return searchParams;
    }
    public VacanciesListRequestModel getParamsWithSpecAndCategoryForSearchVacancy(String[] specialities, String category) {
        VacanciesListRequestModel.Filters filters = VacanciesListRequestModel
                .Filters.builder()
                .specialties(specialities)
                .build();
        VacanciesListRequestModel searchParams = VacanciesListRequestModel
                .builder()
                .category(category)
                .limit(2)
                .filters(filters)
                .build();
        return searchParams;
    }
}
