
package model.response.origami.debug;

import java.util.List;
import lombok.Data;

@Data
public class PageSection {
    private String id;
    private Long moduleLimit;
    private String pageId;
    private List<SegmentModule> segmentModules;
    private List<String> tagKeys;
    private String title;
    private String type;
}
