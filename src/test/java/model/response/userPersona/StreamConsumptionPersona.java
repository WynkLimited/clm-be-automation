package model.response.userPersona;


import com.google.gson.annotations.SerializedName;
import lombok.Data;


@Data
public class StreamConsumptionPersona {

    @SerializedName("content_id")
    private String contentId;

    @SerializedName("trailer_quality_watchtime_flag")
    private Integer trailerQualityWatchTimeFlag;

    @SerializedName("content_type")
    private String contentType;

    @SerializedName("appid")
    private String appId;

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("playtime_sum")
    private Double playtimeSum;

}
