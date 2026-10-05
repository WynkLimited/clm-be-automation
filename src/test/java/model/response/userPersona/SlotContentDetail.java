package model.response.userPersona;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class SlotContentDetail {
    private String sessionId;
    private int sessionCount;
    private List<Integer> positions;
    private Map<String, Integer> packageMap;
}
