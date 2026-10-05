package model.Common.arsenalCollection;

import model.Common.arsenalCollection.constants.BucketOperation;
import lombok.Data;
import model.Common.arsenalCollection.constants.ContentBucket;

import java.util.List;

@Data
public class Bucket {
    private ContentBucket bucket;
    private BucketOperation operation;
    private List<String> data;
    private Boolean useDefaultKey;
    private Bucket internalBucket;
    private String targetBucketKey;
    private Double promotionFactor;
}
