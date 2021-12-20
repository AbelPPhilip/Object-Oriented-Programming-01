/**Property Class
 * 
 * @author abelp
 * @version 11
 * Description: Property Class is a data manager class to manage the plots and arrange them into subsets for the Management company to use. 
 *
 */

public class Property {
	/**
	 * Private fields 
	 */
	private String city, owner, propertyName;
	private double rentAmount;
	private Plot plot;
	/*
	 * Default Constructor 
	 */
	public Property(){
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0; 
		plot = new Plot (0,0,1,1);
	}
	
	/**
	 * Overriden constructor 
	 * @param p Property object 
	 */
	public Property(Property p) {
		this.city = p.getCity();
		this.owner = p.getOwner();
		this.propertyName = p.getPropertyName();
		plot = new Plot();
		plot = p.getPlot();
	}
	
	/**
	 * Overriden
	 * @param propertyName accepts Property name 
	 * @param city accepts city 
	 * @param rentAmount accepts ren amount 
	 * @param owner accepts the name of the owner 
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName; 
		this.city = city; 
		this.rentAmount = rentAmount; 
		this.owner = owner;
		plot = new Plot(0,0,1,1);
	}
	
	/**
	 * Overriden Constructor 
	 * @param propertyName accepts property name 
	 * @param city accepts city name 
	 * @param rentAmount accepts the amount of rent 
	 * @param owner accepts the name of the owner
	 * @param x accepts the x value 
	 * @param y accepts the y value 
	 * @param width accepts the width value
	 * @param depth accepts the value of depth 
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName; 
		this.city = city; 
		this.rentAmount = rentAmount; 
		this.owner = owner;
		plot = new Plot(x,y,width,depth);
	}
	
	/**
	 *
	 * @return city 
	 */
	public String getCity() {
		return city; 
	}
	
	/**
	 * 
	 * @return name of owner 
	 */
	public String getOwner () {
		return owner; 
	}
	
	/**
	 * 
	 * @return name of property 
	 */
	public String getPropertyName() {
		return propertyName; 
	}
	
	/**
	 * 
	 * @return Plot Object 
	 */
	public Plot getPlot() {
		return plot;
	}
	
	/**
	 * Set method 
	 * @param x accepts the x to replace
	 * @param y accepts the y to replace
	 * @param width accepts the width to replace
	 * @param depth accepts the depth to replace 
	 */
	public void setPlot(int x, int y, int width, int depth) {
		plot.setX(x);
	    plot.setY(y);
	    plot.setWidth(width);
	    plot.setDepth(depth);
	}
	
	/**
	 * Set method 
	 * @param city name of city 
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Set method 
	 * @param owner set the owner according to the owner entered 
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * Set method
	 * @param propertyName reset the property name
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	/**
	 * Get method 
	 * @return rent amount 
	 */
	public double getRentAmount () {
		return rentAmount; 
	}
	/**
	 * Set method 
	 * @param rentAmount rent amount 
	 */
	public void setRentAmount (double rentAmount) {
		this.rentAmount = rentAmount; 
	}
	/**
	 * @return the components of the object
	 */
	public String toString() {
		return "Property Name: " +propertyName + "\nLocated in "+city+"\nBelonging to: "+owner+"\nRent Amount: "+rentAmount;
	} 
}
