package me.tejaswan.bookmyshow_notifier.doa.bmsEvent;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ShowDateTime",
        "CategoryRange",
        "Attributes",
        "ApplicableTimeFilters",
        "MinPrice",
        "UpdatedMinPrice",
        "SessionCopQuota",
        "SessionCodFlag",
        "CutOffDateTime",
        "ChildSeats",
        "BestAvailableSeats",
        "CutOffFlag",
        "SessionCodQuota",
        "SessionId",
        "BestBuy",
        "SessionCopFlag",
        "Availability",
        "AvailStatus",
        "ShowTime",
        "SessionPopUpDesc",
        "Categories",
        "ShowDateCode",
        "SessionUnpaidFlag",
        "CoupleSeats",
        "SessionUnpaidQuota",
        "IsAtmosEnabled",
        "MaxPrice",
        "UpdatedMaxPrice",
        "Offers",
        "ApplicablePriceFilters",
        "ShowTimeCode",
        "SessionSubTitle",
        "SessionSubTitleAcronym"
})
public class ShowTime {

    @JsonProperty("ShowDateTime")
    private String showDateTime;
    @JsonProperty("CategoryRange")
    private String categoryRange;
    @JsonProperty("Attributes")
    private String attributes;
    @JsonProperty("ApplicableTimeFilters")
    private List<String> applicableTimeFilters;
    @JsonProperty("MinPrice")
    private String minPrice;
    @JsonProperty("UpdatedMinPrice")
    private Object updatedMinPrice;
    @JsonProperty("SessionCopQuota")
    private String sessionCopQuota;
    @JsonProperty("SessionCodFlag")
    private String sessionCodFlag;
    @JsonProperty("CutOffDateTime")
    private String cutOffDateTime;
    @JsonProperty("ChildSeats")
    private String childSeats;
    @JsonProperty("BestAvailableSeats")
    private Integer bestAvailableSeats;
    @JsonProperty("CutOffFlag")
    private String cutOffFlag;
    @JsonProperty("SessionCodQuota")
    private String sessionCodQuota;
    @JsonProperty("SessionId")
    private String sessionId;
    @JsonProperty("BestBuy")
    private String bestBuy;
    @JsonProperty("SessionCopFlag")
    private String sessionCopFlag;
    @JsonProperty("Availability")
    private String availability;
    @JsonProperty("AvailStatus")
    private String availStatus;
    @JsonProperty("ShowTime")
    private String showTime;
    @JsonProperty("SessionPopUpDesc")
    private String sessionPopUpDesc;
    @JsonProperty("Categories")
    private List<Category> categories;
    @JsonProperty("ShowDateCode")
    private String showDateCode;
    @JsonProperty("SessionUnpaidFlag")
    private String sessionUnpaidFlag;
    @JsonProperty("CoupleSeats")
    private String coupleSeats;
    @JsonProperty("SessionUnpaidQuota")
    private String sessionUnpaidQuota;
    @JsonProperty("IsAtmosEnabled")
    private String isAtmosEnabled;
    @JsonProperty("MaxPrice")
    private String maxPrice;
    @JsonProperty("UpdatedMaxPrice")
    private Object updatedMaxPrice;
    @JsonProperty("Offers")
    private Object offers;
    @JsonProperty("ApplicablePriceFilters")
    private List<String> applicablePriceFilters;
    @JsonProperty("ShowTimeCode")
    private String showTimeCode;
    @JsonProperty("SessionSubTitle")
    private String sessionSubTitle;
    @JsonProperty("SessionSubTitleAcronym")
    private String sessionSubTitleAcronym;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("ShowDateTime")
    public String getShowDateTime() {
        return showDateTime;
    }

    @JsonProperty("ShowDateTime")
    public void setShowDateTime(String showDateTime) {
        this.showDateTime = showDateTime;
    }

    @JsonProperty("CategoryRange")
    public String getCategoryRange() {
        return categoryRange;
    }

    @JsonProperty("CategoryRange")
    public void setCategoryRange(String categoryRange) {
        this.categoryRange = categoryRange;
    }

    @JsonProperty("Attributes")
    public String getAttributes() {
        return attributes;
    }

    @JsonProperty("Attributes")
    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("ApplicableTimeFilters")
    public List<String> getApplicableTimeFilters() {
        return applicableTimeFilters;
    }

    @JsonProperty("ApplicableTimeFilters")
    public void setApplicableTimeFilters(List<String> applicableTimeFilters) {
        this.applicableTimeFilters = applicableTimeFilters;
    }

    @JsonProperty("MinPrice")
    public String getMinPrice() {
        return minPrice;
    }

    @JsonProperty("MinPrice")
    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    @JsonProperty("UpdatedMinPrice")
    public Object getUpdatedMinPrice() {
        return updatedMinPrice;
    }

    @JsonProperty("UpdatedMinPrice")
    public void setUpdatedMinPrice(Object updatedMinPrice) {
        this.updatedMinPrice = updatedMinPrice;
    }

    @JsonProperty("SessionCopQuota")
    public String getSessionCopQuota() {
        return sessionCopQuota;
    }

    @JsonProperty("SessionCopQuota")
    public void setSessionCopQuota(String sessionCopQuota) {
        this.sessionCopQuota = sessionCopQuota;
    }

    @JsonProperty("SessionCodFlag")
    public String getSessionCodFlag() {
        return sessionCodFlag;
    }

    @JsonProperty("SessionCodFlag")
    public void setSessionCodFlag(String sessionCodFlag) {
        this.sessionCodFlag = sessionCodFlag;
    }

    @JsonProperty("CutOffDateTime")
    public String getCutOffDateTime() {
        return cutOffDateTime;
    }

    @JsonProperty("CutOffDateTime")
    public void setCutOffDateTime(String cutOffDateTime) {
        this.cutOffDateTime = cutOffDateTime;
    }

    @JsonProperty("ChildSeats")
    public String getChildSeats() {
        return childSeats;
    }

    @JsonProperty("ChildSeats")
    public void setChildSeats(String childSeats) {
        this.childSeats = childSeats;
    }

    @JsonProperty("BestAvailableSeats")
    public Integer getBestAvailableSeats() {
        return bestAvailableSeats;
    }

    @JsonProperty("BestAvailableSeats")
    public void setBestAvailableSeats(Integer bestAvailableSeats) {
        this.bestAvailableSeats = bestAvailableSeats;
    }

    @JsonProperty("CutOffFlag")
    public String getCutOffFlag() {
        return cutOffFlag;
    }

    @JsonProperty("CutOffFlag")
    public void setCutOffFlag(String cutOffFlag) {
        this.cutOffFlag = cutOffFlag;
    }

    @JsonProperty("SessionCodQuota")
    public String getSessionCodQuota() {
        return sessionCodQuota;
    }

    @JsonProperty("SessionCodQuota")
    public void setSessionCodQuota(String sessionCodQuota) {
        this.sessionCodQuota = sessionCodQuota;
    }

    @JsonProperty("SessionId")
    public String getSessionId() {
        return sessionId;
    }

    @JsonProperty("SessionId")
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @JsonProperty("BestBuy")
    public String getBestBuy() {
        return bestBuy;
    }

    @JsonProperty("BestBuy")
    public void setBestBuy(String bestBuy) {
        this.bestBuy = bestBuy;
    }

    @JsonProperty("SessionCopFlag")
    public String getSessionCopFlag() {
        return sessionCopFlag;
    }

    @JsonProperty("SessionCopFlag")
    public void setSessionCopFlag(String sessionCopFlag) {
        this.sessionCopFlag = sessionCopFlag;
    }

    @JsonProperty("Availability")
    public String getAvailability() {
        return availability;
    }

    @JsonProperty("Availability")
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @JsonProperty("AvailStatus")
    public String getAvailStatus() {
        return availStatus;
    }

    @JsonProperty("AvailStatus")
    public void setAvailStatus(String availStatus) {
        this.availStatus = availStatus;
    }

    @JsonProperty("ShowTime")
    public String getShowTime() {
        return showTime;
    }

    @JsonProperty("ShowTime")
    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    @JsonProperty("SessionPopUpDesc")
    public String getSessionPopUpDesc() {
        return sessionPopUpDesc;
    }

    @JsonProperty("SessionPopUpDesc")
    public void setSessionPopUpDesc(String sessionPopUpDesc) {
        this.sessionPopUpDesc = sessionPopUpDesc;
    }

    @JsonProperty("Categories")
    public List<Category> getCategories() {
        return categories;
    }

    @JsonProperty("Categories")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @JsonProperty("ShowDateCode")
    public String getShowDateCode() {
        return showDateCode;
    }

    @JsonProperty("ShowDateCode")
    public void setShowDateCode(String showDateCode) {
        this.showDateCode = showDateCode;
    }

    @JsonProperty("SessionUnpaidFlag")
    public String getSessionUnpaidFlag() {
        return sessionUnpaidFlag;
    }

    @JsonProperty("SessionUnpaidFlag")
    public void setSessionUnpaidFlag(String sessionUnpaidFlag) {
        this.sessionUnpaidFlag = sessionUnpaidFlag;
    }

    @JsonProperty("CoupleSeats")
    public String getCoupleSeats() {
        return coupleSeats;
    }

    @JsonProperty("CoupleSeats")
    public void setCoupleSeats(String coupleSeats) {
        this.coupleSeats = coupleSeats;
    }

    @JsonProperty("SessionUnpaidQuota")
    public String getSessionUnpaidQuota() {
        return sessionUnpaidQuota;
    }

    @JsonProperty("SessionUnpaidQuota")
    public void setSessionUnpaidQuota(String sessionUnpaidQuota) {
        this.sessionUnpaidQuota = sessionUnpaidQuota;
    }

    @JsonProperty("IsAtmosEnabled")
    public String getIsAtmosEnabled() {
        return isAtmosEnabled;
    }

    @JsonProperty("IsAtmosEnabled")
    public void setIsAtmosEnabled(String isAtmosEnabled) {
        this.isAtmosEnabled = isAtmosEnabled;
    }

    @JsonProperty("MaxPrice")
    public String getMaxPrice() {
        return maxPrice;
    }

    @JsonProperty("MaxPrice")
    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    @JsonProperty("UpdatedMaxPrice")
    public Object getUpdatedMaxPrice() {
        return updatedMaxPrice;
    }

    @JsonProperty("UpdatedMaxPrice")
    public void setUpdatedMaxPrice(Object updatedMaxPrice) {
        this.updatedMaxPrice = updatedMaxPrice;
    }

    @JsonProperty("Offers")
    public Object getOffers() {
        return offers;
    }

    @JsonProperty("Offers")
    public void setOffers(Object offers) {
        this.offers = offers;
    }

    @JsonProperty("ApplicablePriceFilters")
    public List<String> getApplicablePriceFilters() {
        return applicablePriceFilters;
    }

    @JsonProperty("ApplicablePriceFilters")
    public void setApplicablePriceFilters(List<String> applicablePriceFilters) {
        this.applicablePriceFilters = applicablePriceFilters;
    }

    @JsonProperty("ShowTimeCode")
    public String getShowTimeCode() {
        return showTimeCode;
    }

    @JsonProperty("ShowTimeCode")
    public void setShowTimeCode(String showTimeCode) {
        this.showTimeCode = showTimeCode;
    }

    @JsonProperty("SessionSubTitle")
    public String getSessionSubTitle() {
        return sessionSubTitle;
    }

    @JsonProperty("SessionSubTitle")
    public void setSessionSubTitle(String sessionSubTitle) {
        this.sessionSubTitle = sessionSubTitle;
    }

    @JsonProperty("SessionSubTitleAcronym")
    public String getSessionSubTitleAcronym() {
        return sessionSubTitleAcronym;
    }

    @JsonProperty("SessionSubTitleAcronym")
    public void setSessionSubTitleAcronym(String sessionSubTitleAcronym) {
        this.sessionSubTitleAcronym = sessionSubTitleAcronym;
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
