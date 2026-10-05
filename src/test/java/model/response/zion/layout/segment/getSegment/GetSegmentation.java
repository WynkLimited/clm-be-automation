
package model.response.zion.layout.segment.getSegment;

import java.util.List;


import lombok.Data;

@Data
public class GetSegmentation {
    private List<Datum> data;
    private Long pageNo;
    private Long pageSize;
    private Long total;

}
