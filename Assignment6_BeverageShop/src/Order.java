import java.util.ArrayList;
import java.util.Random;
public class Order implements OrderInterface,Comparable<Order> {
	private int orderNum;
	private int orderTime;
	private DAY day; 
	private Customer customer;
	private ArrayList<Beverage> beverages;
	

	public Order(int time, DAY day, Customer customerOther) {
		// TODO Auto-generated constructor stub
		orderTime = time;
		this.day = day;
		customer = new Customer(customerOther.getName(),customerOther.getAge());
		beverages = new ArrayList<Beverage>();
		
	}

	
	public int RandomNum() {
		Random rand = new Random();
		int num =1000+ rand.nextInt(8000);
		return num;
	}
	
	public ArrayList<Beverage> getBeverageList() {
		return beverages;
	}

	@Override
	public boolean isWeekend() {
		// TODO Auto-generated method stub
		if (this.getOrderDay()==DAY.SATURDAY || this.getOrderDay()==DAY.SUNDAY) {
			return true;
		}
		return false;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		// TODO Auto-generated method stub
		if (beverages.size()<itemNo) {
			return null;
		}
		return beverages.get(itemNo);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		// TODO Auto-generated method stub
		Coffee beverage = new Coffee(bevName,size,extraShot,extraSyrup);
		beverages.add(beverage);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		// TODO Auto-generated method stub
		Alcohol beverage = new Alcohol(bevName,size,isWeekend());
		beverages.add(beverage);
		
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		
		// TODO Auto-generated method stub
		Smoothie beverage = new Smoothie(bevName, size, numOfFruits,addProtien);
		beverages.add(beverage);
	}

	@Override
	public double calcOrderTotal() {
		// TODO Auto-generated method stub
		if (beverages.size()<0) {
			return 0;
		}
		double total = 0;
		for (int i = 0; i<beverages.size();i++) {
			total+=beverages.get(i).calcPrice();
		}
		return total;
	}

	@Override
	public int findNumOfBeveType(TYPE type) {
		if (beverages.size()<0) {
			return 0;
		}
		int total = 0;
		for (int i = 0; i<beverages.size();i++) {
			if (beverages.get(i).getType()==type) {
				total++;
			}
		}
		return total;
		
	}
	
	public int getTotalItems() {
		if (beverages.size()<0) {
			return 0;
		}
		int total=0;
		for (int i = 0;i<beverages.size();i++) {
			total++;
		}
		return total;
	}
	
	public String toString() {
		String line =  this.getCustomer().getName()+", Age:"+this.getCustomer().getAge()+"\nOrder Info\n"+"OrderNo.: "+getOrderNo()+"\nOrder Time: "+getOrderTime()+"/nList of Purchase:";
		for (int i = 0; i<beverages.size();i++) {
			line+= "\n"+i+getBeverage(i).getBevName()+", Size ="+getBeverage(i).getSize()+ "Price: "+getBeverage(i).calcPrice();
		}
		line+="Order Total ="+this.calcOrderTotal();
		return line;
	}

	public DAY getOrderDay() {
		return day;
	}

	public void setDay(DAY day) {
		this.day = day;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	

	

	

	public int getOrderNo() {
		return orderNum;
	}

	public void setOrderNo(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	@Override
	public int compareTo(Order o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
