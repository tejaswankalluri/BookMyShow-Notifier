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
        "Crime",
        "Drama",
        "GenreMeta"
})
public class EventGenre {

    @JsonProperty("Crime")
    private List<Object> crime;
    @JsonProperty("Drama")
    private List<Object> drama;
    @JsonProperty("GenreMeta")
    private List<Object> genreMeta;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("Crime")
    public List<Object> getCrime() {
        return crime;
    }

    @JsonProperty("Crime")
    public void setCrime(List<Object> crime) {
        this.crime = crime;
    }

    @JsonProperty("Drama")
    public List<Object> getDrama() {
        return drama;
    }

    @JsonProperty("Drama")
    public void setDrama(List<Object> drama) {
        this.drama = drama;
    }

    @JsonProperty("GenreMeta")
    public List<Object> getGenreMeta() {
        return genreMeta;
    }

    @JsonProperty("GenreMeta")
    public void setGenreMeta(List<Object> genreMeta) {
        this.genreMeta = genreMeta;
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
