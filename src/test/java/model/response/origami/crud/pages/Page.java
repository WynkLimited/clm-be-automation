package model.response.origami.crud.pages;

import java.util.List;

import lombok.Data;



@Data
public class Page {
	private String id;
	private String key;
	private String title;
	private String pageType;
	private List<SegmentSectionsDTO> segmentSections;
	private Object sectionIds;
	private List<SegmentPages> segmentPages;
	private String realm;
	private long createdOn;
	private String createdBy;
	private long lastUpdatedOn;
	private String lastUpdatedBy;
	private List<String> adapterKeys;
	private boolean isVisibleOnZion;
}