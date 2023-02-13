package ru.tinkoff.models;

import com.google.gson.annotations.SerializedName;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

import java.util.List;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class AddressRequestModel {
    private Long count;
    @SerializedName("from_bound")
    private FromBound fromBound;
    private List<Location> locations;
    private String query;
    @SerializedName("restrict_value")
    private Boolean restrictValue;
    @SerializedName("to_bound")
    private ToBound toBound;


    @Builder
    @SuppressWarnings("unused")
    public static class FromBound {
        private String value;
    }

    @Builder
    @SuppressWarnings("unused")
    public static class ToBound {
        private String value;
    }

    @Builder
    @SuppressWarnings("unused")
    public static class Location {
        @SerializedName("city_type_full")
        private String cityTypeFull;
        @SerializedName("country_iso_code")
        private String countryIsoCode;
    }
}

/*
{
    "from_bound": {
        "value": "city"
    },
    "locations": [
        {
            "city_type_full": "город",
            "country_iso_code": "RU"
        },
        {
            "city_type_full": "город",
            "country_iso_code": "UA"
        }
    ],
    "query": "Сан",
    "to_bound": {
        "value": "city"
    }
}
 */
