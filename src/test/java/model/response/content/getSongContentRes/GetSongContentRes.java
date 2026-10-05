
package model.response.content.getSongContentRes;

import java.util.List;

import lombok.Data;

@Data
public class GetSongContentRes {
    private List<Result> result;
    private Long total;
}
