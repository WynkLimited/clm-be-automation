
package model.response.zion.getTileList;

import lombok.Data;

import java.util.List;

@Data
public class GetTilesListRes {
    private List<Datum> data;
    private Long pageNo;
    private Long pageSize;
    private Long total;
}
