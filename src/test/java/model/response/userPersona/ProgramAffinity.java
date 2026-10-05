package model.response.userPersona;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Data
public class ProgramAffinity {

    @SerializedName("program_streamtime")
    private Long programStreamtime;

    @SerializedName("content_id")
    private String contentId;

    @SerializedName("program_latest_interaction_timestamp")
    private String programLatestInteractionTimestamp;

    @SerializedName("program_unique_days_count")
    private Long programUniqueDaysCount;

    @SerializedName("platform")
    private List<String> platform;
}
