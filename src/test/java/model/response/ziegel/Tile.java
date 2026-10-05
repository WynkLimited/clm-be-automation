package model.response.ziegel;

import lombok.Data;
import model.Common.arsenalCollection.DynamicMeta;
import org.bson.Document;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class Tile {

    private String tileId;
    private Integer version;
    private Integer count;
    private String uid;
    private String thumbnailUrl;
    private String shortUrl;
    private String basicShortUrl;
    private String type;
    private String title;
    private String iptvDisplayTitle;
    private String subtitle;
    private Map<String, String> featureFlags;
    private TileEntity entity;
    private String entityId;
    private String deepLink;
    private DynamicMeta dynamicMeta;
    private String segmentId;
    private Object aspectRatio;
    private long lastUpdatedOn;
    private String lastUpdatedBy;
    private String status;
    private String hydrationSource;
    private String hydrationId;
    private String hydrationType;
    private String displayTitle;
    private Document deepLinkJson;
    private Document thumbnailUrlJson;
    private String realm;
    private Set<String> cps;
    private Set<String> regions;
    private String tag;
    private String tagType;
    private String tagSource;
    private String tagImg;
    private String description;
    private Boolean showTextCTA;
    private Boolean deleted;
    private Boolean searchable;
    private String redirectToLatest;
    private Document bgImgUrlMap;
    private Map<String, List<String>> meta;
    private Document dynamicArtwork;
    private Boolean showContentAgeRating;
    private Boolean showContentGenres;
    private Boolean showContentLanguage;
    private Boolean showReleaseDate;
    private Boolean showProgramName;
    private Boolean showStartEndDate;
    private Boolean showDuration;
    private Boolean autoPlay;
    private Boolean promoVideo;
    private List<String> customTags;
    private Document deepLinkBannerJson;
    private String promoVideoUrl;
    private Document subtitleConfig;
    private Document titleConfig;
    private Document ctaConfig;
    private Boolean showShimmerOnCTA;
    private Boolean programTile;
    private Boolean enableSecondCta;
    private String secondCtaAction;
    private Document secondCtaConfig;
    private ProgramData programData;
}