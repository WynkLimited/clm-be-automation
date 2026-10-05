
package model.response.zion.layoutConfig.getPage;
import java.util.List;


import lombok.Data;


@Data
public class GetPageResponce {
    private String[] adapterKeys;
    private Object adbCommand;
    private Object androidTestUid;
    private String createdBy;
    private Long createdOn;
    private String id;
    private Boolean isEmptyAllowed;
    private String key;
    private String lastUpdatedBy;
    private Long lastUpdatedOn;
    private Object live;
    private String pageType;
    private String realm;
    private Object sectionIds;
    private List<Section> sections;
    private List<SegmentPage> segmentPages;
    private List<SegmentSection> segmentSections;
    private String title;
}
