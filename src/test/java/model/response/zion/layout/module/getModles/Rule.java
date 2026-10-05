
package model.response.zion.layout.module.getModles;

import java.util.List;
import lombok.Data;


@Data
public class Rule {
    private String attributeName;
    private List<String> attributeValue;
    private Boolean multiValueAttribute;
    private String operator;
    private String type;

}
