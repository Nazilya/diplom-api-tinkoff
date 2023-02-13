package ru.tinkoff.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.tinkoff.config.Config;

import static io.restassured.RestAssured.with;
import static ru.tinkoff.helpers.CustomApiListener.withCustomTemplates;

public class Specs {
    public static RequestSpecification request = with()
            .baseUri(Config.baseURL())
            .log().all()
            .log().uri()
            .log().method()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON);

    public static RequestSpecification requestForBaseUrlTinkoff = with()
            .baseUri(Config.baseURL_Tinkoff())
            .log().all()
            .log().uri()
            .log().method()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON);
    public static RequestSpecification requestForApiUrlTinkoff = with()
            .baseUri(Config.apiURLTinkoff())
            .log().all()
            .log().uri()
            .log().method()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
