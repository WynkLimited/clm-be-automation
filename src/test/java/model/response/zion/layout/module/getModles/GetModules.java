
package model.response.zion.layout.module.getModles;

import java.util.List;
import lombok.Data;


@Data
public class GetModules {
    private List<Datum> data;
    private Long pageNo;
    private Long pageSize;
    private Long total;
}
