package entities;

import java.io.ObjectInputStream.GetField;

public class ImportedProduct extends Product {

	private Double customFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customFee) {
		super(name, price);
		this.customFee = customFee;
	}

	public Double getCustomFee() {
		return customFee;
	}

	public void setCustomFee(Double customFee) {
		this.customFee = customFee;
	}
	
	public double totalPrice() {
		return getPrice() + customFee;
	}

	@Override
	public String priceTag() {
		return getName() + " $ " + totalPrice() + " (Custom fee: $ " + getCustomFee()+ ")";
	}	
}
