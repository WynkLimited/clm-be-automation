package model.Common.arsenalCollection;

import lombok.Data;

import java.util.Map;

@Data
public class MixParam {
    private Object sourceStrategy;
    private String useCase;
    private String sortStrategy;
    private String filterStrategy;
    private Object mixOperator;
    private int itemPerMix;
    private int minItemPerMix;
    private int mixCount;
    private MultiSourceRequest multiSourceRequest;
    private PostProcessing postProcessing;
    private Object noir;
    private Object zionUIDisplay;
    private Map<String,String[]> params;
}
