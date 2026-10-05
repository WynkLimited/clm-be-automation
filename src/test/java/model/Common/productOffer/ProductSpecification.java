package model.Common.productOffer;

import java.util.List;
import lombok.Data;

@Data
public class ProductSpecification{
	private List<ProductSpecCharacteristicItem> productSpecCharacteristic;
	private String brand;
}