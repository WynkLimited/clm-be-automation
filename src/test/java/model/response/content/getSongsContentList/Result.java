
package model.response.content.getSongsContentList;

import java.util.List;

import lombok.Data;

@Data
public class Result {
    private Object album;
    private String albumObjectId;
    private String contentId;
    private String contentType;
    private Long creationDate;
    private Long durationSeconds;
    private Object featureArtwork;
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
