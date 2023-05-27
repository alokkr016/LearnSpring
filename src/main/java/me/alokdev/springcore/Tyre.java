package me.alokdev.springcore;

public class Tyre {
	public Tyre(String brand, int price) {
		super();
		this.brand = brand;
		this.price = price;
	}

	private String brand;
	private int price;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Tyre [brand=" + brand + ", price=" + price + "]";
	}
	
}
