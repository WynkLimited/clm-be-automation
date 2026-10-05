
package model.response.zion.layoutConfig.getPage;

import lombok.Data;

import java.util.List;


@Data
public class Page {

    private String[] adapterKeys;
    private Object adbCommand;
    private Object androidTestUid;
    private String createdBy;
    private Long createdOn;
    private String id;
    private Object isEmptyAllowed;
    private String key;
    private String lastUpdatedBy;
    private Long lastUpdatedOn;
    private Object live;
    private String pageType;
    private String realm;
    private Object sectionIds;
    private List<Page> segmentPages;
    private List<SegmentSection> segmentSections;
    private String title;
}
