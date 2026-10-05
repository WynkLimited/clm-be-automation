
package model.response.zion.layout.segment.PostNewSegment;

import java.util.List;

import lombok.Data;


@Data
public class Rule {
    private String attributeName;
    private List<String> attributeValue;
    private List<Rule> rules;
    private Boolean multiValueAttribute;
    private String operator;
    private String type;
}
