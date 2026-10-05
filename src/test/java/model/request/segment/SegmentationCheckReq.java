
package model.request.segment;

import java.util.List;
import lombok.Data;

@Data
public class SegmentationCheckReq {
    private String realm;
    private List<String> segmentsToBeMatched;
    private String uid;

}
