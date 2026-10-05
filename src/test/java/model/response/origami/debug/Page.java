
package model.response.origami.debug;

import java.util.List;
import lombok.Data;

@Data
public class Page {
    private String client;
    private String id;
    private Boolean isEmptyAllowed;
    private String key;
    private String realm;
    private List<String> sectionIds;
    private List<Object> segmentPages;
    private List<SegmentSection> segmentSections;
}
