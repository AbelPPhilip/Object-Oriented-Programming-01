
public abstract class Beverage {
	
	private String name;
	private TYPE type;
	private SIZE size;
	protected static double price; 
	final double BASE_PRICE = 2.0;
	final double SIZE_PRICE = 1.0;
	

	public Beverage(String name, TYPE type, SIZE size) {
		this.name = name;
		this.type = type; 
		this.size = size;
		// TODO Auto-generated constructor stub
	}
	public Beverage(String name, SIZE sz) {
		this.name = name;
		this.size = sz;
		
	}
	
	abstract double calcPrice();
	
	public String toString() {
		return name + " " + size+ " = "+price;
	}
	
	public boolean equals(Beverage obj) {
		if ((this.getBevName()).equals(obj.getBevName()) && this.getType().equals(obj.getType()) && this.getSize().equals(obj.getSize())) {
				return true; 
		}
		else return false; 
	}
	
	public String getBevName() {
		return name; 
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public TYPE getType() {
		return type;
	}
	
	public void setType(TYPE type) {
		this.type = type; 
	}
	
	public SIZE getSize() {
		return size;
	}
	
	public void setSize(SIZE size) {
		this.size = size; 
	}
	public double getBasePrice() {
		return BASE_PRICE;
	}
	

}
