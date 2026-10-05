
package model.Common.arsenalCollection;

import java.util.List;

import lombok.Data;

@Data
public class ArsenalCollection {
    private Artworks artworks;
    private Long cacheTime;
    private String category;
    private String collectionId;
    private Object contentTypes;
    private List<Content> contents;
    private Object cps;
    private Object description;
    private DynamicMeta dynamicMeta;
    private Object extra;
    private String id;
    private List<String> languages;
    private Object mTags;
    private String realm;
    private List<String> regions;
    private String sortStrategy;
    private String status;
    private Object subtitle;
    private String title;
    private String type;
    private Object xAppKey;
    private Object xFilters;
    private Object xPageLink;
}
