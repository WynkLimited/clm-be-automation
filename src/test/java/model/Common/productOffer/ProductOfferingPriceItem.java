package model.Common.productOffer;

import lombok.Data;

import java.util.List;

@Data
public class ProductOfferingPriceItem{
	private Price price;
	private String name;
	private String priceType;
	private List<TaxItem> tax;
}