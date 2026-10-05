
package model.response.zion.layout.module.createModule;

import lombok.Data;
import model.response.common.SupportedClient;

import java.util.List;

@Data
public class CreateModuleRes {
    private String actionType;
    private Boolean active;
    private Content content;
    private Object contentActionType;
    private String createdBy;
    private Long createdOn;
    private String id;
    private String lastUpdatedBy;
    private Long lastUpdatedOn;
    private Meta meta;
    private String realm;
    private Object schedule;
    private Object segmentIds;
    private List<SupportedClient> supportedClients;
    private Object tagKeys;
    private String templateKey;
    private String title;
    private Object welContext;
}
