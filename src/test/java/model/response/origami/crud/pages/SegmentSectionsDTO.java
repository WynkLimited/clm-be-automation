package model.response.origami.crud.pages;

import lombok.Data;


@Data
public class SegmentSectionsDTO {
	private int weight;
	private String segmentId;
	private String sectionId;
	private boolean tagRank;
}