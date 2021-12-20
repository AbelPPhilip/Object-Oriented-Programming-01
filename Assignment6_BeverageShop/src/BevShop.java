import java.util.ArrayList;

public class BevShop implements BevShopInterfce {
	private static int numOfAlcoholDrinks;
	private Order currentOrder;
	private final int MIN_AGE_ALCOHOL = 21;
	private final int MAX_ALCOHOL_DRINKS=3;
	private ArrayList <Order> list;
	final int MIN_TIME= 8;				//earliest time for the order
	final int MAX_TIME= 23;				//latest  time for the order
	final int MAX_FRUIT = 5;
	int orderNumber;
	
    
	public BevShop() {
		// TODO Auto-generated constructor stub
		list = new ArrayList<Order>();
		orderNumber = 0;
	}

	@Override
	public boolean validTime(int time) {
		// TODO Auto-generated method stub
		if (time>=MIN_TIME && time<=MAX_TIME) {
			return true;
		}
		return false;
	}

	@Override
	public boolean eligibleForMore() {
		// TODO Auto-generated method stub
	    int count = currentOrder.getBeverageList().size();
	    if (count<3) {
	    	return true;
	    }
		return false;
	}

	@Override
	public boolean validAge(int age) {
		// TODO Auto-generated method stub
		if (age>21) {
			return true; 
		}
		return false;
	}

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		// TODO Auto-generated method stub
		if (validTime(time)) {
			currentOrder = new Order (time,day,new Customer(customerName,customerAge));
			list.add(currentOrder);
		    numOfAlcoholDrinks = 0;
		    currentOrder.setOrderNo(orderNumber++);
		}
		
		
		
	}

	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		// TODO Auto-generated method stub
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
		
	}

	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		// TODO Auto-generated method stub
		if (currentOrder.getCustomer().getAge()>this.getMIN_AGE_ALCOHOL() && numOfAlcoholDrinks<MAX_ALCOHOL_DRINKS) {
			currentOrder.addNewBeverage(bevName, size);
			numOfAlcoholDrinks++;
		}
		
		
	}

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		// TODO Auto-generated method stub
		if(!isMaxFruit(numOfFruits)) {
			currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtien);
		}
		
	}

	@Override
	public int findOrder(int orderNo) {
		// TODO Auto-generated method stub
		if (list!=null) {
		for(int i = 0; i< list.size();i++) {
			if (list.get(i).getOrderNo()==orderNo) {
				return i;
			}
		}
		}
		return 0;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		// TODO Auto-generated method stub
		for (int i = 0;i<list.size();i++) {
			if(list.get(i).getOrderNo()==orderNo) {
				return list.get(i).calcOrderTotal();
			}
		}
		return 0;
		
		
	}

	@Override
	public double totalMonthlySale() {
		// TODO Auto-generated method stub
		if(list==null || list.size()<=0) {
			return 0;
		}
		double total = 0;
		for(int i = 0;i<list.size();i++) {
			total+=list.get(i).calcOrderTotal();
		}
		return total;
	}

	@Override
	public void sortOrders() {
		// TODO Auto-generated method stub 
		
		
		
	}

	@Override
	public Order getOrderAtIndex(int index) {
		// TODO Auto-generated method stub
		if (list == null || list.size()<index) {
			return null;
		}
		return list.get(index);
	}

	public int getNumOfAlcoholDrink() {
		return numOfAlcoholDrinks;
	}

	
	public int getMIN_AGE_ALCOHOL() {
		return MIN_AGE_ALCOHOL;
	}
	
	public Order getCurrentOrder() {
		return currentOrder;
	}
	
	public int getMinAgeForAlcohol() {
		return MIN_AGE_ALCOHOL;
	}
	public boolean isMaxFruit(int fruits) {
		if (fruits>MAX_FRUIT) {
			return true;
		}
		return false;
		
	}
	
	

	public int getMaxOrderForAlcohol() {
		return 3;
	}

	public int totalNumOfMonthlyOrders() {
		// TODO Auto-generated met
		if(list==null || list.size()<0) {
			return 0;
		}
		int total = 0; 
		for(int i=0; i<list.size();i++) {
			total++;
		}
		return total;
	}

	public int getMAX_ALCOHOL_DRINKS() {
		return MAX_ALCOHOL_DRINKS;
	}
	
	public String toString() {
		String lines ="Beverage Shop Stats";
		for (int i= 0; i<list.size();i++) {
			lines+="\n"+list.get(i).toString();
		}
		lines += "\nTotal Monthly Sales = $"+this.totalMonthlySale();
		return lines;
		
	}
  
}
