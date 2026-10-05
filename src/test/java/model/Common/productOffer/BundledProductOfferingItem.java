package model.Common.productOffer;

import java.util.List;
import lombok.Data;

@Data
public class BundledProductOfferingItem{
	private BundledProductOfferingOption bundledProductOfferingOption;
	private String name;
	private List<BundleProductOfferingRelationshipItem> bundleProductOfferingRelationship;
	private String description;
	private String id;
	private String href;
}