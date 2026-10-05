
package model.response.zion.layout.segment.getSegment;

import java.util.List;


import lombok.Data;


@Data
public class Datum {
    private Object active;
    private Boolean allUserSegment;
    private List<ChildSegment> childSegments;
    private Object createdBy;
    private Object createdOn;
    private Object editable;
    private Object experimentId;
    private Object fallback;
    private String id;
    private String lastUpdatedBy;
    private String lastUpdatedExperimentId;
    private Long lastUpdatedOn;
    private String name;
    private Object parentSegmentId;
    private String realm;
    private Object rule;
    private String segmentType;
    private Long splitPercentage;
}
