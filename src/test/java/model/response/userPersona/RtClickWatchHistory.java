package model.response.userPersona;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Data
public class RtClickWatchHistory  {

    @SerializedName("contentId")
    private String contentId;

    @SerializedName("cpId")
    private String cpId;

    @SerializedName("title")
    private String title;

    @SerializedName("languages")
    private List<String> languages;

    @SerializedName("streamingLang")
    private String streamingLanguage;

    @SerializedName("contentType")
    private String contentType;

    @SerializedName("clickCount")
    private Double clickCount;

    @SerializedName("streamTime")
    private Double streamTime;

    @SerializedName("sessionId")
    private String sessionId;

    @SerializedName("ts")
    private Long ts;

    @SerializedName("firstTimeStamp")
    private Long firstTimeStamp;

    @SerializedName("lastTimeStamp")
    private Long lastTimeStamp;

    @SerializedName("addedToWatchlist")
    private Double addedToWatchlist;

    @SerializedName("lastWatchlistUpdateDate")
    private Double lastWatchlistUpdateDate;

    @SerializedName("watchIntent")
    private Double watchIntent;

    @SerializedName("download")
    private Double download;

    @SerializedName("appInAppRedirection")
    private Double appInAppRedirection;

    @SerializedName("appInAppRedirectionTriggerTimeStamp")
    private Double appInAppRedirectionTriggerTimeStamp;

    @SerializedName("appInAppRedirectionState")
    private Double appInAppRedirectionState;

    @SerializedName("qualityClick")
    private Double qualityClick;

    @SerializedName("lastTimeToComebackToApp")
    private Double lastTimeToComebackToApp;

    @SerializedName("maxTimeToComebackToApp")
    private Double maxTimeToComebackToApp;

    @SerializedName("partnerType")
    private String partnerType;

    @SerializedName("trailerWatchTimeQuality")
    private Double trailerWatchTimeQuality;
}
