
package model.Common.arsenalCollection;

import lombok.Data;


@Data
public class DynamicMeta {
    private Object collectionId;
    private String functionName;
    private Object functionType;
    private Boolean isFollowable;
    private MixParam mixParam;
    private String protocol;
    private String refreshType;
    private Object url;
    private String useCase;
}
