package model.response.userPersona;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DpClickWatchHistory  {

    @SerializedName("content_id")
    private String contentId;

    @SerializedName("first_timestamp")
    private String firstTimestamp;

    @SerializedName("latest_timestamp")
    private String latestTimestamp;

    @SerializedName("watch_intent")
    private Double watchIntent;

    @SerializedName("app_redirection_click_sum")
    private Double appRedirectionClickSum;

    @SerializedName("content_tile_click_sum")
    private Double contentTileClickSum;

    @SerializedName("tournamentName")
    private String tournamentName;

    @SerializedName("tournamentId")
    private String tournamentId;

    @SerializedName("series_id")
    private String seriesId;

    @SerializedName("season_id")
    private String seasonId;

    @SerializedName("partner_type")
    private String partnerType;

    @SerializedName("streaming_lang")
    private String streamingLang;

    @SerializedName("content_type")
    private String contentType;

    @SerializedName("quality_click_flag")
    private Double qualityClickFlag;

    @SerializedName("max_time_to_come_back_to_app")
    private Double maxTimeToComeBackToApp;

    @SerializedName("download_event")
    private Double downloadEvent;

    @SerializedName("latest_time_to_come_back_to_app")
    private Double latestTimeToComeBackToApp;

    @SerializedName("data_as_on_date")
    private String dataAsOnDate;

    @SerializedName("watchlist_count")
    private Double Watchlist;

    @SerializedName("trailer_quality_watch")
    private Double trailerQualityWatch;

    @SerializedName("cp")
    private String cp;
}
