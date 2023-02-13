
package ru.tinkoff.models;

import com.google.gson.annotations.SerializedName;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@SuppressWarnings("unused")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressResponseModel {
    @JsonProperty("suggestions")
    private List<FullAddress> fullAddresses;

    @Data
    public static class FullAddress {
        @SerializedName("data")
        private List<CityData> cityData;
        @SerializedName("unrestricted_value")
        private String unrestrictedValue;
        private String value;

        @Data
        public static class CityData {
            @SerializedName("postal_code")
            private String postalCode;
            private String country;
            @SerializedName("country_iso_code")
            private String countryIsoCode;
            @SerializedName("federal_district")
            private String federalDistrict;
            @SerializedName("region_fias_id")
            private String regionFiasId;
            @SerializedName("region_kladr_id")
            private String regionKladrId;
            @SerializedName("region_iso_code")
            private String regionIsoCode;
            @SerializedName("region_with_type")
            private String regionWithType;
            @SerializedName("region_type")
            private String regionType;
            @SerializedName("region_type_full")
            private String regionTypeFull;
            private String region;
            @SerializedName("area_fias_id")
            private String areaFiasId;
            @SerializedName("area_kladr_id")
            private String areaKladrId;
            @SerializedName("area_with_type")
            private String areaWithType;
            @SerializedName("area_type")
            private String areaType;
            @SerializedName("area_type_full")
            private String areaTypeFull;
            private String area;
            @SerializedName("city_fias_id")
            private String cityFiasId;
            @SerializedName("city_kladr_id")
            private String cityKladrId;
            @SerializedName("city_type")
            private String cityType;
            @SerializedName("city_type_full")
            private String cityTypeFull;
            @SerializedName("city_with_type")
            private String cityWithType;
            private String city;
            @SerializedName("city_area")
            private String cityArea;
            @SerializedName("city_district")
            private String cityDistrict;
            @SerializedName("city_district_fias_id")
            private String cityDistrictFiasId;
            @SerializedName("city_district_kladr_id")
            private String cityDistrictKladrId;
            @SerializedName("city_district_type")
            private String cityDistrictType;
            @SerializedName("city_district_type_full")
            private String cityDistrictTypeFull;
            @SerializedName("city_district_with_type")
            private String cityDistrictWithType;
            private String settlement;
            @SerializedName("settlement_fias_id")
            private String settlementFiasId;
            @SerializedName("settlement_kladr_id")
            private String settlementKladrId;
            @SerializedName("settlement_type")
            private String settlementType;
            @SerializedName("settlement_type_full")
            private String settlementTypeFull;
            @SerializedName("settlement_with_type")
            private String settlementWithType;
            private String street;
            @SerializedName("street_fias_id")
            private String streetFiasId;
            @SerializedName("street_kladr_id")
            private String streetKladrId;
            @SerializedName("street_type")
            private String streetType;
            @SerializedName("street_type_full")
            private String streetTypeFull;
            @SerializedName("street_with_type")
            private String streetWithType;
            private String stead;
            @SerializedName("stead_cadnum")
            private String steadCadnum;
            @SerializedName("stead_fias_id")
            private String steadFiasId;
            @SerializedName("stead_type")
            private String steadType;
            @SerializedName("stead_type_full")
            private String steadTypeFull;
            private String house;
            @SerializedName("house_cadnum")
            private String houseCadnum;
            @SerializedName("house_fias_id")
            private String houseFiasId;
            @SerializedName("house_kladr_id")
            private String houseKladrId;
            @SerializedName("house_type")
            private String houseType;
            @SerializedName("house_type_full")
            private String houseTypeFull;
            private String block;
            @SerializedName("block_type")
            private String blockType;
            @SerializedName("block_type_full")
            private String blockTypeFull;
            private String entrance;
            private String floor;
            private String flat;
            @SerializedName("flat_area")
            private String flatArea;
            @SerializedName("flat_cadnum")
            private String flatCadnum;
            @SerializedName("flat_fias_id")
            private String flatFiasId;
            @SerializedName("flat_price")
            private String flatPrice;
            @SerializedName("flat_type")
            private String flatType;
            @SerializedName("flat_type_full")
            private String flatTypeFull;
            @SerializedName("square_meter_price")
            private String squareMeterPrice;
            @SerializedName("postal_box")
            private String postalBox;
            @SerializedName("fias_id")
            private String fiasId;
            @SerializedName("fias_actuality_state")
            private String fiasActualityState;
            @SerializedName("fias_code")
            private String fiasCode;
            @SerializedName("fias_level")
            private String fiasLevel;
            @SerializedName("kladr_id")
            private String kladrId;
            @SerializedName("geoname_id")
            private String geonameId;
            @SerializedName("capital_marker")
            private String capitalMarker;
            private String okato;
            private String oktmo;
            @SerializedName("tax_office")
            private String taxOffice;
            @SerializedName("tax_office_legal")
            private String taxOfficeLegal;
            private String timezone;
            @SerializedName("geo_lat")
            private String geoLat;
            @SerializedName("geo_lon")
            private String geoLon;
            @SerializedName("beltway_distance")
            private String beltwayDistance;
            @SerializedName("beltway_hit")
            private String beltwayHit;
            private String metro;
            private String divisions;
            @SerializedName("qc_complete")
            private String qcComplete;
            @SerializedName("qc_geo")
            private String qcGeo;
            @SerializedName("qc_house")
            private String qcHouse;
            @SerializedName("history_values")
            private String[] historyValues;
            @SerializedName("unparsed_parts")
            private String unparsedParts;
            private String source;
            private String qc;
        }

    }

}



// Пример ответа
/*
{
    "suggestions": [
        {
            "value": "Россия, г Санкт-Петербург",
            "unrestricted_value": "190000, Россия, г Санкт-Петербург",
            "data": {
                "postal_code": "190000",
                "country": "Россия",
                "country_iso_code": "RU",
                "federal_district": null,
                "region_fias_id": "c2deb16a-0330-4f05-821f-1d09c93331e6",
                "region_kladr_id": "7800000000000",
                "region_iso_code": "RU-SPE",
                "region_with_type": "г Санкт-Петербург",
                "region_type": "г",
                "region_type_full": "город",
                "region": "Санкт-Петербург",
                "area_fias_id": null,
                "area_kladr_id": null,
                "area_with_type": null,
                "area_type": null,
                "area_type_full": null,
                "area": null,
                "city_fias_id": "c2deb16a-0330-4f05-821f-1d09c93331e6",
                "city_kladr_id": "7800000000000",
                "city_with_type": "г Санкт-Петербург",
                "city_type": "г",
                "city_type_full": "город",
                "city": "Санкт-Петербург",
                "city_area": null,
                "city_district_fias_id": null,
                "city_district_kladr_id": null,
                "city_district_with_type": null,
                "city_district_type": null,
                "city_district_type_full": null,
                "city_district": null,
                "settlement_fias_id": null,
                "settlement_kladr_id": null,
                "settlement_with_type": null,
                "settlement_type": null,
                "settlement_type_full": null,
                "settlement": null,
                "street_fias_id": null,
                "street_kladr_id": null,
                "street_with_type": null,
                "street_type": null,
                "street_type_full": null,
                "street": null,
                "stead_fias_id": null,
                "stead_cadnum": null,
                "stead_type": null,
                "stead_type_full": null,
                "stead": null,
                "house_fias_id": null,
                "house_kladr_id": null,
                "house_cadnum": null,
                "house_type": null,
                "house_type_full": null,
                "house": null,
                "block_type": null,
                "block_type_full": null,
                "block": null,
                "entrance": null,
                "floor": null,
                "flat_fias_id": null,
                "flat_cadnum": null,
                "flat_type": null,
                "flat_type_full": null,
                "flat": null,
                "flat_area": null,
                "square_meter_price": null,
                "flat_price": null,
                "postal_box": null,
                "fias_id": "c2deb16a-0330-4f05-821f-1d09c93331e6",
                "fias_code": null,
                "fias_level": "1",
                "fias_actuality_state": "0",
                "kladr_id": "7800000000000",
                "geoname_id": "498817",
                "capital_marker": "0",
                "okato": "40000000000",
                "oktmo": "40000000",
                "tax_office": "7800",
                "tax_office_legal": "7800",
                "timezone": null,
                "geo_lat": "59.939084",
                "geo_lon": "30.315879",
                "beltway_hit": null,
                "beltway_distance": null,
                "metro": null,
                "divisions": null,
                "qc_geo": "4",
                "qc_complete": null,
                "qc_house": null,
                "history_values": [
                    "г Ленинград"
                ],
                "unparsed_parts": null,
                "source": null,
                "qc": null
            }
        },
        {
            "value": "Украина, Полтавская обл, г Новые Санжары",
            "unrestricted_value": "39300, Украина, Полтавская обл, г Новые Санжары",
            "data": {
                "postal_code": "39300",
                "country": "Украина",
                "country_iso_code": "UA",
                "federal_district": null,
                "region_fias_id": null,
                "region_kladr_id": null,
                "region_iso_code": "UA-53",
                "region_with_type": "Полтавская обл",
                "region_type": "обл",
                "region_type_full": "область",
                "region": "Полтавская",
                "area_fias_id": null,
                "area_kladr_id": null,
                "area_with_type": null,
                "area_type": null,
                "area_type_full": null,
                "area": null,
                "city_fias_id": null,
                "city_kladr_id": null,
                "city_with_type": "г Новые Санжары",
                "city_type": "г",
                "city_type_full": "город",
                "city": "Новые Санжары",
                "city_area": null,
                "city_district_fias_id": null,
                "city_district_kladr_id": null,
                "city_district_with_type": null,
                "city_district_type": null,
                "city_district_type_full": null,
                "city_district": null,
                "settlement_fias_id": null,
                "settlement_kladr_id": null,
                "settlement_with_type": null,
                "settlement_type": null,
                "settlement_type_full": null,
                "settlement": null,
                "street_fias_id": null,
                "street_kladr_id": null,
                "street_with_type": null,
                "street_type": null,
                "street_type_full": null,
                "street": null,
                "stead_fias_id": null,
                "stead_cadnum": null,
                "stead_type": null,
                "stead_type_full": null,
                "stead": null,
                "house_fias_id": null,
                "house_kladr_id": null,
                "house_cadnum": null,
                "house_type": null,
                "house_type_full": null,
                "house": null,
                "block_type": null,
                "block_type_full": null,
                "block": null,
                "entrance": null,
                "floor": null,
                "flat_fias_id": null,
                "flat_cadnum": null,
                "flat_type": null,
                "flat_type_full": null,
                "flat": null,
                "flat_area": null,
                "square_meter_price": null,
                "flat_price": null,
                "postal_box": null,
                "fias_id": null,
                "fias_code": null,
                "fias_level": "-1",
                "fias_actuality_state": null,
                "kladr_id": null,
                "geoname_id": "698927",
                "capital_marker": "0",
                "okato": null,
                "oktmo": null,
                "tax_office": null,
                "tax_office_legal": null,
                "timezone": "UTC+2",
                "geo_lat": "49.33379",
                "geo_lon": "34.31496",
                "beltway_hit": null,
                "beltway_distance": null,
                "metro": null,
                "divisions": null,
                "qc_geo": "4",
                "qc_complete": null,
                "qc_house": null,
                "history_values": null,
                "unparsed_parts": null,
                "source": null,
                "qc": null
            }
        }
    ]
}

 */