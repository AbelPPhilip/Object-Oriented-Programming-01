
public class Smoothie extends Beverage {
	private int fruitNum;
	private boolean proteinPowder;
	private double smoothiePrice;
	private final double PROTEIN_PRICE = 1.5;
	private final double ADDFRUIT_PRICE = 0.5;
	
	
	

	public Smoothie(String nm,SIZE sz, int fruitNum, boolean proteinPowder) {
		super(nm,TYPE.SMOOTHIE,sz);
		this.proteinPowder = proteinPowder;
		this.fruitNum = fruitNum;
		smoothiePrice=calcPrice();
		
		
		// TODO Auto-generated constructor stub
	}
	
	public double calcPrice() {
		// TODO Auto-generated method stub
		smoothiePrice=0;
		smoothiePrice+=(BASE_PRICE+(((double)fruitNum)*ADDFRUIT_PRICE));
		switch (this.getSize()){
		case SMALL:
			break;
		case LARGE:
			smoothiePrice+=(SIZE_PRICE*2);
			break;
		case MEDIUM:
			smoothiePrice+=(SIZE_PRICE);
			break;
		default:
			break;
		}
		if (proteinPowder) {
			smoothiePrice+=PROTEIN_PRICE;
		}
		
		return smoothiePrice;
	}

	public double getPROTEIN_PRICE() {
		return PROTEIN_PRICE;
	}
	
	public String toString() {
		return this.getBevName()+","+this.getSize()+", Number of Fruits = "+getNumOfFruits()+"\nPrice = "+smoothiePrice;
	}
	public double getSmoothiePrice() {
		return smoothiePrice;
	}
	public double getNumOfFruits() {
		return fruitNum;
	}

	public boolean getAddProtien() {
		// TODO Auto-generated method stub
		return proteinPowder;
		
	}
	
	

}
