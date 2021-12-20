/**
 * 
 * @author abelp
 *
 */
public class Alcohol extends Beverage {
	private boolean weekend;
	private final double WEEKEND_COST=0.6;
	private double alcoholPrice;
	

	public Alcohol(String nm, SIZE sz,boolean weekend ) {
		super (nm,TYPE.ALCOHOL,sz);
		this.weekend = weekend;
		alcoholPrice = calcPrice();
		
		
	}


	@Override
/**
 * @return alcohol price
 */
	public double calcPrice() {
			// TODO Auto-generated method stub
			alcoholPrice=BASE_PRICE;
			switch (this.getSize()){
			case SMALL:
				break;
			case LARGE:
				alcoholPrice+=(SIZE_PRICE*2);
				break;
			case MEDIUM:
				alcoholPrice+=(SIZE_PRICE);
				break;
			default:
				break;
			}
			if (weekend) {
				alcoholPrice+=WEEKEND_COST;
			}
			
			return alcoholPrice;
			
	}
		// TODO Auto-generated method stub
		
/**
 * @return The printed version of the Alcohol class. 	
 */

	public String toString() {
		return this.getBevName()+","+this.getSize()+" = "+this.alcoholPrice;
	}

}
