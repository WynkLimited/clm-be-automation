
package model.response.zion.layoutConfig.PostNewField;

import lombok.Data;

@Data
public class PostNewFieldRes {
    private String action;
    private Attributes attributes;
    private String category;
    private Boolean frequentlyUsed;
    private String id;
    private String key;
    private Meta meta;
    private String realm;
    private String source;
    private String templateKey;
    private String title;
    private String type;
}
