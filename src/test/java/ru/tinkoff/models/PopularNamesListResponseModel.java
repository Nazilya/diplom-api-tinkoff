
package ru.tinkoff.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@SuppressWarnings("unused")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PopularNamesListResponseModel {
    @JsonProperty ("payload")
    private List<PopularNames> popularNames;
    private String resultCode;
    private String trackingId;

    @Data
    @SuppressWarnings("unused")
    public static class PopularNames {
        private String value;
        private String gender;
    }

}

/*
{
    "payload": [
        {
            "value": "Иванова",
            "gender": "female"
        },
        {
            "value": "Иванов",
            "gender": "male"
        },
        {
            "value": "Иванникова",
            "gender": "female"
        }
    ],
    "trackingId": "HM5R0CKGM",
    "resultCode": "OK"
}
 */
