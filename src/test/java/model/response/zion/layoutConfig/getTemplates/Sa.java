
package model.response.zion.layoutConfig.getTemplates;

import java.util.List;
import lombok.Data;
import model.response.common.SupportedClient;


@Data
public class Sa {
    private String collectionIdRequired;
    private Object contentType;
    private Object defaultAction;
    private Object defaultContentAction;
    private Object defaultSource;
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
