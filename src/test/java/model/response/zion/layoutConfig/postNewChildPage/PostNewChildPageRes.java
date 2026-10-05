
package model.response.zion.layoutConfig.postNewChildPage;

import java.util.List;


import lombok.Data;


@Data
public class PostNewChildPageRes {
    private Object adapterKeys;
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
    private Object segmentPages;
    private List<SegmentSection> segmentSections;
    private String title;
}
