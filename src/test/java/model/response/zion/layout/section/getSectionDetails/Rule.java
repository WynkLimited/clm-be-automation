
package model.response.zion.layout.section.getSectionDetails;

import lombok.Data;

import java.util.List;

@Data
public class Rule {
    private String attributeName;
    private List<String> attributeValue;
    private Boolean multiValueAttribute;
    private String operator;
    private String type;
}
