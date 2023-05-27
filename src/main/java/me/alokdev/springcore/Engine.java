package me.alokdev.springcore;

public class Engine {
	private String type;

	@Override
	public String toString() {
		return "Engine [type=" + type + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
