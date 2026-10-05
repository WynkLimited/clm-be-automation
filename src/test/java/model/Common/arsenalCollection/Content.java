package model.Common.arsenalCollection;

import model.constant.ContentType;
import lombok.Data;

import java.util.Map;

@Data
public class Content {
    private String contentId;
    private Long position;
    private ContentType type;
    private Map<String,String> extras;
}
