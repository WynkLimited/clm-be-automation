package model.Common.productOffer;

import lombok.Data;

@Data
public class ConstraintItem{
	private String valueType;
	private String name;
	private String type;
	private Value value;
}