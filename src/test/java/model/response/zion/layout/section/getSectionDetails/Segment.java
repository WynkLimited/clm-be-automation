
package model.response.zion.layout.section.getSectionDetails;

import lombok.Data;
import java.util.List;

@Data
public class Segment {

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
    private Rule rule;
    private String segmentType;
    private Long splitPercentage;
}
