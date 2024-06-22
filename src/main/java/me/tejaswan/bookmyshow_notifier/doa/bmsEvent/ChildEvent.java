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
        "Event_strIsDefault",
        "EventSyn",
        "EventRAT",
        "EventSEQ",
        "EventTrailer",
        "EventName",
        "EventGenre",
        "ApplicableTimeFilters",
        "EventCensor",
        "EventGroup",
        "EventCode",
        "EventImageCode",
        "EventDimension",
        "ShowTimes",
        "IsMovieClubEnabled",
        "EventIsAtmosEnabled",
        "Event_strPopUpDesc",
        "EventLanguage",
        "EventUrl",
        "ApplicablePriceFilters"
})
public class ChildEvent {

    @JsonProperty("Event_strIsDefault")
    private String eventStrIsDefault;
    @JsonProperty("EventSyn")
    private String eventSyn;
    @JsonProperty("EventRAT")
    private String eventRAT;
    @JsonProperty("EventSEQ")
    private String eventSEQ;
    @JsonProperty("EventTrailer")
    private String eventTrailer;
    @JsonProperty("EventName")
    private String eventName;
    @JsonProperty("EventGenre")
    private EventGenre eventGenre;
    @JsonProperty("ApplicableTimeFilters")
    private List<String> applicableTimeFilters;
    @JsonProperty("EventCensor")
    private String eventCensor;
    @JsonProperty("EventGroup")
    private String eventGroup;
    @JsonProperty("EventCode")
    private String eventCode;
    @JsonProperty("EventImageCode")
    private String eventImageCode;
    @JsonProperty("EventDimension")
    private String eventDimension;
    @JsonProperty("ShowTimes")
    private List<ShowTime> showTimes;
    @JsonProperty("IsMovieClubEnabled")
    private String isMovieClubEnabled;
    @JsonProperty("EventIsAtmosEnabled")
    private String eventIsAtmosEnabled;
    @JsonProperty("Event_strPopUpDesc")
    private String eventStrPopUpDesc;
    @JsonProperty("EventLanguage")
    private String eventLanguage;
    @JsonProperty("EventUrl")
    private String eventUrl;
    @JsonProperty("ApplicablePriceFilters")
    private List<String> applicablePriceFilters;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("Event_strIsDefault")
    public String getEventStrIsDefault() {
        return eventStrIsDefault;
    }

    @JsonProperty("Event_strIsDefault")
    public void setEventStrIsDefault(String eventStrIsDefault) {
        this.eventStrIsDefault = eventStrIsDefault;
    }

    @JsonProperty("EventSyn")
    public String getEventSyn() {
        return eventSyn;
    }

    @JsonProperty("EventSyn")
    public void setEventSyn(String eventSyn) {
        this.eventSyn = eventSyn;
    }

    @JsonProperty("EventRAT")
    public String getEventRAT() {
        return eventRAT;
    }

    @JsonProperty("EventRAT")
    public void setEventRAT(String eventRAT) {
        this.eventRAT = eventRAT;
    }

    @JsonProperty("EventSEQ")
    public String getEventSEQ() {
        return eventSEQ;
    }

    @JsonProperty("EventSEQ")
    public void setEventSEQ(String eventSEQ) {
        this.eventSEQ = eventSEQ;
    }

    @JsonProperty("EventTrailer")
    public String getEventTrailer() {
        return eventTrailer;
    }

    @JsonProperty("EventTrailer")
    public void setEventTrailer(String eventTrailer) {
        this.eventTrailer = eventTrailer;
    }

    @JsonProperty("EventName")
    public String getEventName() {
        return eventName;
    }

    @JsonProperty("EventName")
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @JsonProperty("EventGenre")
    public EventGenre getEventGenre() {
        return eventGenre;
    }

    @JsonProperty("EventGenre")
    public void setEventGenre(EventGenre eventGenre) {
        this.eventGenre = eventGenre;
    }

    @JsonProperty("ApplicableTimeFilters")
    public List<String> getApplicableTimeFilters() {
        return applicableTimeFilters;
    }

    @JsonProperty("ApplicableTimeFilters")
    public void setApplicableTimeFilters(List<String> applicableTimeFilters) {
        this.applicableTimeFilters = applicableTimeFilters;
    }

    @JsonProperty("EventCensor")
    public String getEventCensor() {
        return eventCensor;
    }

    @JsonProperty("EventCensor")
    public void setEventCensor(String eventCensor) {
        this.eventCensor = eventCensor;
    }

    @JsonProperty("EventGroup")
    public String getEventGroup() {
        return eventGroup;
    }

    @JsonProperty("EventGroup")
    public void setEventGroup(String eventGroup) {
        this.eventGroup = eventGroup;
    }

    @JsonProperty("EventCode")
    public String getEventCode() {
        return eventCode;
    }

    @JsonProperty("EventCode")
    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    @JsonProperty("EventImageCode")
    public String getEventImageCode() {
        return eventImageCode;
    }

    @JsonProperty("EventImageCode")
    public void setEventImageCode(String eventImageCode) {
        this.eventImageCode = eventImageCode;
    }

    @JsonProperty("EventDimension")
    public String getEventDimension() {
        return eventDimension;
    }

    @JsonProperty("EventDimension")
    public void setEventDimension(String eventDimension) {
        this.eventDimension = eventDimension;
    }

    @JsonProperty("ShowTimes")
    public List<ShowTime> getShowTimes() {
        return showTimes;
    }

    @JsonProperty("ShowTimes")
    public void setShowTimes(List<ShowTime> showTimes) {
        this.showTimes = showTimes;
    }

    @JsonProperty("IsMovieClubEnabled")
    public String getIsMovieClubEnabled() {
        return isMovieClubEnabled;
    }

    @JsonProperty("IsMovieClubEnabled")
    public void setIsMovieClubEnabled(String isMovieClubEnabled) {
        this.isMovieClubEnabled = isMovieClubEnabled;
    }

    @JsonProperty("EventIsAtmosEnabled")
    public String getEventIsAtmosEnabled() {
        return eventIsAtmosEnabled;
    }

    @JsonProperty("EventIsAtmosEnabled")
    public void setEventIsAtmosEnabled(String eventIsAtmosEnabled) {
        this.eventIsAtmosEnabled = eventIsAtmosEnabled;
    }

    @JsonProperty("Event_strPopUpDesc")
    public String getEventStrPopUpDesc() {
        return eventStrPopUpDesc;
    }

    @JsonProperty("Event_strPopUpDesc")
    public void setEventStrPopUpDesc(String eventStrPopUpDesc) {
        this.eventStrPopUpDesc = eventStrPopUpDesc;
    }

    @JsonProperty("EventLanguage")
    public String getEventLanguage() {
        return eventLanguage;
    }

    @JsonProperty("EventLanguage")
    public void setEventLanguage(String eventLanguage) {
        this.eventLanguage = eventLanguage;
    }

    @JsonProperty("EventUrl")
    public String getEventUrl() {
        return eventUrl;
    }

    @JsonProperty("EventUrl")
    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    @JsonProperty("ApplicablePriceFilters")
    public List<String> getApplicablePriceFilters() {
        return applicablePriceFilters;
    }

    @JsonProperty("ApplicablePriceFilters")
    public void setApplicablePriceFilters(List<String> applicablePriceFilters) {
        this.applicablePriceFilters = applicablePriceFilters;
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