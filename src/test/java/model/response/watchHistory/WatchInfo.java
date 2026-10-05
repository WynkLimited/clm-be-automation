
package model.response.watchHistory;

import java.util.List;


import lombok.Data;


@Data
public class WatchInfo {
    private List<Object> favourites;
    private List<WatchHistory>watchHistories;
}
