package model.Common.arsenalCollection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Collection;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)@Builder
public class CollectionFilter  {
    private Collection<String> languages;
    @Builder.Default private boolean uslBasedFilter = true;
    private Collection<String> segmentIds;

    @Override
    public String toString() {
        return "CollectionFilter{"
                + "languages="
                + languages
                + ", uslBasedFilter="
                + uslBasedFilter
                + ", segmentIds="
                + segmentIds
                + '}';
    }
}