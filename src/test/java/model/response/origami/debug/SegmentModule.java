
package model.response.origami.debug;

import lombok.Data;
import com.google.gson.annotations.Expose;

@Data
public class SegmentModule {
    private String moduleId;
    private String segmentId;
    private Long weight;

}
