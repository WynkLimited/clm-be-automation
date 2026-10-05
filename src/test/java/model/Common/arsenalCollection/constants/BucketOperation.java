package model.Common.arsenalCollection.constants;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BucketOperation {
    merge,
    sort_merge,
    append,
    merge_append,
    sort_merge_append,
    sort_merge_promote;
}
