package model.response.userPersona;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedHashMap;
import java.util.List;

import lombok.*;

import java.util.Map;

@Data
public class RealtimePersona  {
    @SerializedName("amData")
    private List<Object> amData;

    @SerializedName("clickBasedPersonas")
    private LinkedHashMap<String, RtClickWatchHistory> clickBasedPersonas;

    @SerializedName("userDataBreacher")
    private Object userDataBreacher;

    @SerializedName("persona")
    private LinkedHashMap<String, LinkedHashMap<String, RTPersonaIntentDetails>> persona;

    @SerializedName("sessionMetas")
    private List<Object> sessionMetas;

    @SerializedName("msisdn")
    private String msisdn;

    @SerializedName("userId")
    private String userId;

    @SerializedName("personaUpdateTimestamp")
    private Long personaUpdateTimestamp;

    @SerializedName("slotPersonaPayload")
    private Map<String, Map<String, Map<String, Integer>>> slotPersona;

    @SerializedName("slotContentVisiblePersona")
    private Map<String, Map<String, List<SlotContentDetail>>> slotContentVisiblePersona;
}
