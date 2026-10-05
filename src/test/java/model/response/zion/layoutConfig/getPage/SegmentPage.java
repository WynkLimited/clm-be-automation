
package model.response.zion.layoutConfig.getPage;

import lombok.Data;

@Data
public class SegmentPage {
    private Boolean isFallback;
    private Page page;
    private Segment segment;
    private Boolean tagRank;
}
