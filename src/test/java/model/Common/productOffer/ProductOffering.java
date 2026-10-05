package model.Common.productOffer;

import lombok.Data;

@Data
public class ProductOffering{
	private String msg;
	private String traceId;
	private Data1 data;
	private boolean success;
}