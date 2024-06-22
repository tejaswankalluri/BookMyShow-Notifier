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
        "EventTitle",
        "EventDuration",
        "ChildEvents",
        "EventSynopsis",
        "EventGenre",
        "ApplicablePriceFilters",
        "ApplicableTimeFilters",
        "EventCensor",
        "EventGroup"
})
public class BmsEvent {

    @JsonProperty("EventTitle")
    private String eventTitle;
    @JsonProperty("EventDuration")
    private String eventDuration;
    @JsonProperty("ChildEvents")
    private List<ChildEvent> childEvents;
    @JsonProperty("EventSynopsis")
    private String eventSynopsis;
    @JsonProperty("EventGenre")
    private String eventGenre;
    @JsonProperty("ApplicablePriceFilters")
    private List<String> applicablePriceFilters;
    @JsonProperty("ApplicableTimeFilters")
    private List<String> applicableTimeFilters;
    @JsonProperty("EventCensor")
    private String eventCensor;
    @JsonProperty("EventGroup")
    private String eventGroup;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("EventTitle")
    public String getEventTitle() {
        return eventTitle;
    }

    @JsonProperty("EventTitle")
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    @JsonProperty("EventDuration")
    public String getEventDuration() {
        return eventDuration;
    }

    @JsonProperty("EventDuration")
    public void setEventDuration(String eventDuration) {
        this.eventDuration = eventDuration;
    }

    @JsonProperty("ChildEvents")
    public List<ChildEvent> getChildEvents() {
        return childEvents;
    }

    @JsonProperty("ChildEvents")
    public void setChildEvents(List<ChildEvent> childEvents) {
        this.childEvents = childEvents;
    }

    @JsonProperty("EventSynopsis")
    public String getEventSynopsis() {
        return eventSynopsis;
    }

    @JsonProperty("EventSynopsis")
    public void setEventSynopsis(String eventSynopsis) {
        this.eventSynopsis = eventSynopsis;
    }

    @JsonProperty("EventGenre")
    public String getEventGenre() {
        return eventGenre;
    }

    @JsonProperty("EventGenre")
    public void setEventGenre(String eventGenre) {
        this.eventGenre = eventGenre;
    }

    @JsonProperty("ApplicablePriceFilters")
    public List<String> getApplicablePriceFilters() {
        return applicablePriceFilters;
    }

    @JsonProperty("ApplicablePriceFilters")
    public void setApplicablePriceFilters(List<String> applicablePriceFilters) {
        this.applicablePriceFilters = applicablePriceFilters;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}