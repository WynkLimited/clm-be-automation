package model.response.userPersona;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Data
public class ChannelAffinity {

    @SerializedName("channel_streamtime")
    private Long channelStreamtime;

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("channel_latest_interaction_timestamp")
    private String channelLatestInteractionTimestamp;

    @SerializedName("channel_unique_days_count")
    private Long channelUniqueDaysCount;

    @SerializedName("platform")
    private List<String> platform;
}