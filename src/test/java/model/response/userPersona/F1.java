package model.response.userPersona;

import com.google.gson.annotations.SerializedName;

import lombok.*;

@Data
public class F1  {
    @SerializedName("xstream__xstream_click_user_feature")
    private XstreamXstreamClickUserFeature xstreamXstreamClickUserFeature;

    @SerializedName("xstream__xstream_consumption_user_feature")
    private XstreamXstreamConsumptionUserFeature xstreamXstreamConsumptionUserFeature;
}
