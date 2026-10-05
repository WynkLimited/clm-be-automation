package model.response.userPersona;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import lombok.*;

@Data
public class UserSegmentRequest  {
    private String uid;
    private Set<String> segmentsToBeMatched;
    private Map<String, Object> liveContext;
    private String realm;
}
