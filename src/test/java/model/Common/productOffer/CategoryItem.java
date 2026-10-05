package model.Common.productOffer;

import java.util.List;
import lombok.Data;

@Data
public class CategoryItem{
	private List<SubCategoryItem> subCategory;
	private String name;
}