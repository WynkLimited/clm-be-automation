
package model.response.zion.layout.section.getSectionDetails;

import lombok.Data;
import model.response.common.SupportedClient;

import java.util.List;

@Data
public class Module {
    private String actionType;
    private Boolean active;
    private Content content;
    private String contentActionType;
    private String createdBy;
    private Long createdOn;
    private String id;
    private String lastUpdatedBy;
    private Long lastUpdatedOn;
    private Meta meta;
    private String realm;
    private Object schedule;
    private List<String> segmentIds;
    private List<SupportedClient> supportedClients;
    private Object tagKeys;
    private String templateKey;
    private String title;
    private Object welContext;

}
