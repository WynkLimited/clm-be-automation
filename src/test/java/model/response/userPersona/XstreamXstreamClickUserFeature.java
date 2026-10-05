package model.response.userPersona;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.io.Serializable;

@Data
public class XstreamXstreamClickUserFeature  {
    @SerializedName("user_id")
    private String userId;

    @SerializedName("xstream__xstream_click_user_feature__content_data")
    private String xstreamXstreamClickUserFeatureContentData;
}
