
public class Coffee extends Beverage{
	
	private boolean extraShot;
	private boolean extraSyrup;
	private double coffeePrice;
	
	
	final double EXTRASHOT_PRICE = 0.5;
	final double EXTRASYRUP_PRICE = 0.5;
	

	public Coffee(String nm,SIZE sz,boolean extraShot, boolean extraSyrup) {
		super(nm,TYPE.COFFEE,sz);
		
		this.extraShot = extraShot;
		this.extraSyrup =extraSyrup;
		coffeePrice=calcPrice();
		// TODO Auto-generated constructor stub
		
	}


	@Override
	public double calcPrice() {
		// TODO Auto-generated method stub
		coffeePrice=0;
		coffeePrice+=BASE_PRICE;
		switch (this.getSize()){
		case SMALL:
			break;
		case LARGE:
			coffeePrice+=(SIZE_PRICE*2);
			break;
		case MEDIUM:
			coffeePrice+=(SIZE_PRICE);
			break;
		default:
			break;
		}
        if (this.getExtraShot()) {
        	coffeePrice+=EXTRASHOT_PRICE;
        }
        if(this.getExtraSyrup()) {
        	coffeePrice+=EXTRASYRUP_PRICE;
        }
		return coffeePrice;
	}
	
	boolean equals(Coffee obj) {
		if (this.extraShot==obj.getExtraShot()&&this.extraSyrup==obj.getExtraSyrup()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return (this.getBevName()+","+this.getSize()+" = "+this.calcPrice()) ;
	}
	


	public boolean getExtraShot() {
		return extraShot;
	}


	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}


	public boolean getExtraSyrup() {
		return extraSyrup;
	}


	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}
	
	public SIZE getCoffeeSize() {
		return this.getSize();
	}


	public void setCoffeeSize(SIZE coffeeSize) {
		super.setSize(coffeeSize);;
	}



}
