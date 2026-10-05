
package model.response.zion.layout.section.getSectionDetails;

import lombok.Data;

@Data
public class SegmentModule {
    private Module module;
    private String moduleId;
    private Segment segment;
    private String segmentId;
    private Long weight;
}
