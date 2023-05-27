package me.alokdev.springcore;

public class Price {
	private int cost;

	@Override
	public String toString() {
		return "Price [cost=" + cost + "]";
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
