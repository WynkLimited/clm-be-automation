package model.response.userPersona;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Data
public class UserAttribute  {
    private String realm;
    private String label;
    private String displayTitle;
    private String key;
    private boolean isLive;
    private String clientKey;
    private String dataType;
}


