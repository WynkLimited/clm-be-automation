
package model.response.zion.layoutConfig.getTemplates;

import java.util.List;
import lombok.Data;
import model.response.common.SupportedClient;


@Data
public class FABBUTTON {
    private String collectionIdRequired;
    private String contentType;
    private Object defaultAction;
    private Object defaultContentAction;
    private String defaultSource;
    private String endpointRequired;
    private Object fixedSource;
    private String id;
    private String key;
    private String label;
    private Object meta;
    private String realm;
    private List<SupportedClient> supportedClients;
    private String title;
}
