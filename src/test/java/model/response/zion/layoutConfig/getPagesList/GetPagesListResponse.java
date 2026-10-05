
package model.response.zion.layoutConfig.getPagesList;

import java.util.List;


import lombok.Data;
import model.response.zion.layoutConfig.getPage.GetPageResponce;

@Data
public class GetPagesListResponse {
    private List<GetPageResponce> data;
    private Long pageNo;
    private Long pageSize;
    private Long total;
}
