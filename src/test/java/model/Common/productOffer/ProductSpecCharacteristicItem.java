package model.Common.productOffer;

import java.util.List;
import lombok.Data;

@Data
public class ProductSpecCharacteristicItem{
	private String name;
	private List<ProductSpecCharacteristicValueItem> productSpecCharacteristicValue;
}