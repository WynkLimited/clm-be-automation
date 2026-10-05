
package model.response.zion.layout.section.getSectionDetails;

import lombok.Data;

import java.util.List;

@Data
public class GetSectionDetailsResponse {
    private String createdBy;
    private Long createdOn;
    private String id;
    private String lastUpdatedBy;
    private Long lastUpdatedOn;
    private Long moduleLimit;
    private String realm;
    private List<SegmentModule> segmentModules;
    private Object tagKeys;
    private String title;
    private String type;
}
