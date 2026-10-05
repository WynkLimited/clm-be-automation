
package model.response.zion.layout.module.getModles;

import java.util.List;
import lombok.Data;
import model.response.common.SupportedClient;


@Data
public class Datum {
    private String actionType;
    private Boolean active;
    private Collection collection;
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
    private List<String> segmentIds;
    private List<Segment> segments;
    private List<SupportedClient> supportedClients;
    private Object tagKeys;
    private String templateKey;
    private String title;
    private Object welContext;
}
