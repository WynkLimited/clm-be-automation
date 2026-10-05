package model.Common;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import model.Common.arsenalCollection.ArsenalCollection;
import model.response.userPersona.UserPersonaDTO;

import java.util.List;
import java.util.Map;

@Data
public class UserInfo {
    public static UserPersonaDTO userPersona;
    public static JsonNode watchHistory, experiment, userLogs;
    public static ArsenalCollection userEncounter;
    public static Map<String,String> liveAttribute;
    public static Map<String, Map<String,Map<String,Integer>>> slotPersona;
    public static Map<String,Map<String, List<String>>> slotPersonaFlatten;

}
