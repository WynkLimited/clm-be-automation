
package model.response.origami.debug;

import java.util.List;
import lombok.Data;
import model.response.common.SupportedClient;

@Data
public class Module {
    private String actionType;
    private Boolean active;
    private Content content;
    private String contentActionType;
    private String id;
    private Meta meta;
    private Schedule schedule;
    private List<SupportedClient> supportedClients;
    private List<String> tagKeys;
    private String templateKey;
    private String title;
    private Object welContext;
}
