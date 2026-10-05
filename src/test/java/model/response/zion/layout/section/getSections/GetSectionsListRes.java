
package model.response.zion.layout.section.getSections;

import java.util.List;


import lombok.Data;
import model.response.zion.layout.section.getSectionDetails.GetSectionDetailsResponse;

@Data
public class GetSectionsListRes {
    private List<GetSectionDetailsResponse> data;
    private Long pageNo;
    private Long pageSize;
    private Long total;
}
