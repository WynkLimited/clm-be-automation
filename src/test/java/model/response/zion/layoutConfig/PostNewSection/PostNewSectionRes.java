
package model.response.zion.layoutConfig.PostNewSection;

import java.util.List;
import lombok.Data;

@Data
public class PostNewSectionRes {
    private String createdBy;
    private Long createdOn;
    private String id;
    private String lastUpdatedBy;
    private Long lastUpdatedOn;
    private Long moduleLimit;
    private String realm;
    private List<Object> segmentModules;
    private Object tagKeys;
    private String title;
    private String type;
}
