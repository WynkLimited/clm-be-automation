package model.Common.arsenalCollection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

import model.Common.arsenalCollection.constants.Operator;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class SourceCollection  {
    private String collectionId;
    private String title;
    private String type;
    private Operator operator;
    private Double score;
    private Long order;
    private Integer contentCount;
    private Map<String, List<String>> params;
    private List<CollectionFilter> filters;
    private List<Content> contents;
    private List<String> languages;

    @Override
    public String toString() {
        return "SourceCollection{" +
                "collectionId='" + collectionId + '\'' +
                ", order=" + order +
                '}';
    }
}