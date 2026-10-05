package model.response.origami.crud.pages;

import lombok.Data;

@Data
public class SegmentPages {
    private String segmentId;
    private String pageId;
    private boolean tagRank;
    private boolean isFallback;
}
