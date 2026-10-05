
package model.response.zion.layout.segment.PostNewSegment;


import lombok.Data;

@Data
public class PostNewSegmentRes {
    private Object active;
    private Boolean allUserSegment;
    private Object childSegments;
    private String createdBy;
    private Long createdOn;
    private Object editable;
    private Object experimentId;
    private Object fallback;
    private String id;
    private String lastUpdatedBy;
    private Object lastUpdatedExperimentId;
    private Long lastUpdatedOn;
    private String name;
    private Object parentSegmentId;
    private String realm;
    private Rule rule;
    private Object segmentType;
    private Long splitPercentage;
}
