package model.Common.productOffer;

import lombok.Data;

import java.util.List;

@Data
public class Data1 {
	private ProductSpecification productSpecification;
	private String lifecycleStatus;
	private List<ProductOfferingPriceItem> productOfferingPrice;
	private boolean sellable;
	private String version;
	private List<ProductOfferingRelationshipItem> productOfferingRelationship;
	private List<BundledProductOfferingItem> bundledProductOffering;
	private List<AttachmentItem> attachment;
	private String lastUpdate;
	private String name;
	private List<ConstraintItem> constraint;
	private String id;
	private ProductOfferingOption productOfferingOption;
	private List<CategoryItem> category;
	private boolean bundle;
}