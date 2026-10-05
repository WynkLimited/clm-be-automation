package model.Common.arsenalCollection.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Operator {
    include("include"),
    exclude("exclude");
    private final String operator;
}