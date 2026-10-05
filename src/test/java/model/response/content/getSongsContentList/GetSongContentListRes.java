
package model.response.content.getSongsContentList;

import java.util.List;

import lombok.Data;

@Data
public class GetSongContentListRes {
    private List<Result> result;
    private Long total;
}
