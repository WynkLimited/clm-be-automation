
package model.response.origami.debug;

import lombok.Data;
import com.google.gson.annotations.Expose;

@Data
public class SegmentSection {
    private String sectionId;
    private String segmentId;
    private Boolean tagRank;
    private Long weight;
}
