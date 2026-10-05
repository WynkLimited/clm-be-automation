
package model.response.watchHistory;

import lombok.Data;

@Data
public class WatchHistory {
    private String contentId;
    private Double lastWatchPosition;
    private Boolean manuallyRemovedFromCW;
    private String parentContentId;
    private String updatedAt;
}
