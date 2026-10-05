
package model.response.zion.postNewCollectionRes;

import java.util.List;


import lombok.Data;

@Data
public class PostNewCollectionRes {
    private Object archivedAt;
    private Artworks artworks;
    private Object availableFrom;
    private Object availableTill;
    private Object cacheTime;
    private String category;
    private String collectionId;
    private Object contentTypes;
    private Object contents;
    private Object cps;
    private String createdBy;
    private Long createdOn;
    private Boolean deleted;
    private Object description;
    private Object duration;
    private Object dynamicMeta;
    private String id;
    private List<String> languages;
    private String lastUpdatedBy;
    private Long lastUpdatedOn;
    private Object mTags;
    private Long minContentCount;
    private Object mixerMetaList;
    private Object mtags;
    private Object parentId;
    private Object publishedAt;
    private String realm;
    private RealmMeta realmMeta;
    private Long refreshFrequencyDay;
    private Long refreshFrequencyDayOfWeek;
    private List<String> regions;
    private Object sortStrategy;
    private String status;
    private Object subCategory;
    private Object subtitle;
    private Object tags;
    private String title;
    private String type;
    private Object vernacular;
    private Long version;
    private Object xPageLink;
    private Object xpageLink;
    private String zstatus;
}
