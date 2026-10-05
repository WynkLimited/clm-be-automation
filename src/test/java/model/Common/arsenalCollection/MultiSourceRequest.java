package model.Common.arsenalCollection;

import java.util.List;

import model.Common.arsenalCollection.constants.CollectionSortingMethod;
import model.Common.arsenalCollection.constants.ScoringMethod;
import lombok.*;

@Data
public class MultiSourceRequest {
    private List<SourceCollection> collections;
    private ScoringMethod scoringMethod;
    private Double minimumScore;
    private Boolean reducer;
    private Boolean tileOutput;
    private Boolean enrichMeta;
    private Boolean excludeByDedupId;
    private CollectionSortingMethod sortingMethod;
}