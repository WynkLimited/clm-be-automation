package model.response.userPersona;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.List;
import lombok.*;

@Data
public class UserSegmentsResponse  {
    private String uid;
    private List<String> segmentIds;
}
