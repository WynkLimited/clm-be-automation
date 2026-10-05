
package model.response.zion.layoutConfig.getPage;

import java.util.List;


import lombok.Data;


@Data
public class Section {
    private String createdBy;
    private Long createdOn;
    private String id;
    private String lastUpdatedBy;
    private Long lastUpdatedOn;
    private Long moduleLimit;
    private String realm;
    private List<SegmentModule> segmentModules;
    private Object tagKeys;
    private String title;
    private String type;
}
