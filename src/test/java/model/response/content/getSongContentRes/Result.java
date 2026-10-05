
package model.response.content.getSongContentRes;

import java.util.List;
import lombok.Data;

@Data
public class Result {
    private String album;
    private String albumObjectId;
    private String contentId;
    private String contentType;
    private Long creationDate;
    private Long durationSeconds;
    private String featureArtwork;
    private String id;
    private Boolean isHt;
    private String language;
    private Double popularity;
    private List<String> region;
    private Long releaseDate;
    private Object songPlacement;
    private String status;
    private Double streams;
    private String thumbnailUrl;
    private String title;
}
