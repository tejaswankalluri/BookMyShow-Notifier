package me.tejaswan.bookmyshow_notifier.doa.bmsEvent;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "PercentAvail",
        "PriceCode",
        "AdditionalData",
        "CurPrice",
        "UpdatedPrice",
        "AreaCatCode",
        "AvailStatus",
        "MaxSeats",
        "BestAvailableSeats",
        "SeatLayout",
        "PriceDesc",
        "SeatsAvail",
        "CategoryRange",
        "intCategoryMaxTickets"
})
public class Category {

    @JsonProperty("PercentAvail")
    private String percentAvail;
    @JsonProperty("PriceCode")
    private String priceCode;
    @JsonProperty("AdditionalData")
    private String additionalData;
    @JsonProperty("CurPrice")
    private String curPrice;
    @JsonProperty("UpdatedPrice")
    private Object updatedPrice;
    @JsonProperty("AreaCatCode")
    private String areaCatCode;
    @JsonProperty("AvailStatus")
    private String availStatus;
    @JsonProperty("MaxSeats")
    private String maxSeats;
    @JsonProperty("BestAvailableSeats")
    private String bestAvailableSeats;
    @JsonProperty("SeatLayout")
    private String seatLayout;
    @JsonProperty("PriceDesc")
    private String priceDesc;
    @JsonProperty("SeatsAvail")
    private String seatsAvail;
    @JsonProperty("CategoryRange")
    private String categoryRange;
    @JsonProperty("intCategoryMaxTickets")
    private String intCategoryMaxTickets;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("PercentAvail")
    public String getPercentAvail() {
        return percentAvail;
    }

    @JsonProperty("PercentAvail")
    public void setPercentAvail(String percentAvail) {
        this.percentAvail = percentAvail;
    }

    @JsonProperty("PriceCode")
    public String getPriceCode() {
        return priceCode;
    }

    @JsonProperty("PriceCode")
    public void setPriceCode(String priceCode) {
        this.priceCode = priceCode;
    }

    @JsonProperty("AdditionalData")
    public String getAdditionalData() {
        return additionalData;
    }

    @JsonProperty("AdditionalData")
    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    @JsonProperty("CurPrice")
    public String getCurPrice() {
        return curPrice;
    }

    @JsonProperty("CurPrice")
    public void setCurPrice(String curPrice) {
        this.curPrice = curPrice;
    }

    @JsonProperty("UpdatedPrice")
    public Object getUpdatedPrice() {
        return updatedPrice;
    }

    @JsonProperty("UpdatedPrice")
    public void setUpdatedPrice(Object updatedPrice) {
        this.updatedPrice = updatedPrice;
    }

    @JsonProperty("AreaCatCode")
    public String getAreaCatCode() {
        return areaCatCode;
    }

    @JsonProperty("AreaCatCode")
    public void setAreaCatCode(String areaCatCode) {
        this.areaCatCode = areaCatCode;
    }

    @JsonProperty("AvailStatus")
    public String getAvailStatus() {
        return availStatus;
    }

    @JsonProperty("AvailStatus")
    public void setAvailStatus(String availStatus) {
        this.availStatus = availStatus;
    }

    @JsonProperty("MaxSeats")
    public String getMaxSeats() {
        return maxSeats;
    }

    @JsonProperty("MaxSeats")
    public void setMaxSeats(String maxSeats) {
        this.maxSeats = maxSeats;
    }

    @JsonProperty("BestAvailableSeats")
    public String getBestAvailableSeats() {
        return bestAvailableSeats;
    }

    @JsonProperty("BestAvailableSeats")
    public void setBestAvailableSeats(String bestAvailableSeats) {
        this.bestAvailableSeats = bestAvailableSeats;
    }

    @JsonProperty("SeatLayout")
    public String getSeatLayout() {
        return seatLayout;
    }

    @JsonProperty("SeatLayout")
    public void setSeatLayout(String seatLayout) {
        this.seatLayout = seatLayout;
    }

    @JsonProperty("PriceDesc")
    public String getPriceDesc() {
        return priceDesc;
    }

    @JsonProperty("PriceDesc")
    public void setPriceDesc(String priceDesc) {
        this.priceDesc = priceDesc;
    }

    @JsonProperty("SeatsAvail")
    public String getSeatsAvail() {
        return seatsAvail;
    }

    @JsonProperty("SeatsAvail")
    public void setSeatsAvail(String seatsAvail) {
        this.seatsAvail = seatsAvail;
    }

    @JsonProperty("CategoryRange")
    public String getCategoryRange() {
        return categoryRange;
    }

    @JsonProperty("CategoryRange")
    public void setCategoryRange(String categoryRange) {
        this.categoryRange = categoryRange;
    }

    @JsonProperty("intCategoryMaxTickets")
    public String getIntCategoryMaxTickets() {
        return intCategoryMaxTickets;
    }

    @JsonProperty("intCategoryMaxTickets")
    public void setIntCategoryMaxTickets(String intCategoryMaxTickets) {
        this.intCategoryMaxTickets = intCategoryMaxTickets;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
