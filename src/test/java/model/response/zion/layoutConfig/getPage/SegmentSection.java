
package model.response.zion.layoutConfig.getPage;

import lombok.Data;

@Data
public class SegmentSection {
    private Section section;
    private Segment segment;
    private Boolean tagRank;
    private Long weight;
}
