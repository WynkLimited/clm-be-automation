
package model.response.zion.layoutConfig.getTemplates;

import java.util.List;
import lombok.Data;
import model.response.common.SupportedClient;


@Data
public class ADVERTISEMENT {
    private String collectionIdRequired;
    private String contentType;
    private String defaultAction;
    private Object defaultContentAction;
    private Object defaultSource;
    private String endpointRequired;
    private String fixedSource;
    private String id;
    private String key;
    private String label;
    private Object meta;
    private String realm;
    private List<SupportedClient> supportedClients;
    private String title;
}
