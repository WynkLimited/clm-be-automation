package model.response.userPersona;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
public class CpCostDistributionLtmtd  {
    @SerializedName("playtime_total")
    private Double playtimeTotal;

    @SerializedName("lifetime_quality_count")
    private Integer lifetimeQualityCount;

    @SerializedName("lifetime_savings")
    private Double lifetimeSavings;

    @SerializedName("cp_name")
    private String cpName;
}
