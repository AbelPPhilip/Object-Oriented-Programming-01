/**
 * Management Company is a data element class, 
 * which is used to create Management Company object. 
 * @author abelp
 * @version 11
 *Date: 10/25/2021
 *Description: Main Class to combine the 2 supporting classes, Property and Plot
 * 
 *
 */


public class ManagementCompany {

	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private double mgmFeePer;
	private String name, taxID;
	private Property[]properties; 
	private Plot plot;
	
	/**
	 * Default Constructor
	 */
	public ManagementCompany() {
		plot = new Plot(0,0,10,10);
		properties = new Property[5];
	}
	
   /**Overriden Constructor 
    * 
    * @param name accepts name of the company 
    * @param taxID accepts taxID of the company 
    * @param mgmFee accepts the mgmFee of the company 
    */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name; 
		this.taxID = taxID; 
		mgmFeePer = mgmFee;
		plot = new Plot (0,0,10,10);
		properties = new Property[MAX_PROPERTY];
	}
	
	/** Overriden Constructor method to create Management Company Object
	 * @param name accepts name of the Company 
	 * @param taxID accepts the taxID of Company 
	 * @param mgmFee accepts the management fee
	 * @param x accepts the x value 
	 * @param y accepts the y value 
	 * @param width accepts the width of the plot
	 * @param depth accepts the depth of the plot 
	 * 
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name; 
		this.taxID = taxID; 
		mgmFeePer = mgmFee;
		plot = new Plot (x, y, width, depth);	
		properties = new Property[MAX_PROPERTY];
	}
	/**Copy Constructor
	 * @param otherCompany accepts another ManagementCompany object which then is copied to new object.
	 */
	
	public ManagementCompany(ManagementCompany otherCompany){
		properties = new Property[otherCompany.getMAX_PROPERTY()];
		
		
		
	}
	
	/**
	 * addProperty Method to accept another property object 
	 * @param property accepts Property object to add to array
	 * @return integer of index or another integer if conditions met.
	 */
	public int addProperty(Property property) {
		int i = 0;
		if (property==null) 
	    	return -2;
		else {
			if(!(this.plot.encompasses(property.getPlot()))) {
				return -4;
			}
		}
		
		int counter = 0;
		for (i =0;i<MAX_PROPERTY;i++) {
	    	if (!(properties[i]==null)) {
	    		counter++;
	    		if(counter>=5) {
	    			return -1;
	    		}
	    		
	    	    if (properties[i].getPlot().overlaps(property.getPlot()))
	    	    	return -4;
	    	}
	    	else {
	    	properties[i] = property;
	    	return i;
	    	}
	    }
		return i;
		
	}
	
	/**
	 * Overloaded addProperty method
	 * @param name accepts name of the property 
	 * @param city accepts city of the property 
	 * @param rent accepts the rent of the property 
	 * @param owner accepts the owner of the property
	 * @return integer of index or another integer if conditions met.
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		Property property = new Property(name,city,rent,owner);
		int i = 0;
		if (property==null) 
	    	return -2;
		else {
			if(!(this.plot.encompasses(property.getPlot()))) {
				return -4;
			}
		}
		
		int counter = 0;
		for (i =0;i<MAX_PROPERTY;i++) {
	    	if (!(properties[i]==null)) {
	    		counter++;
	    		if(counter>=5) {
	    			return -1;
	    		}
	    		
	    	    if (properties[i].getPlot().overlaps(property.getPlot()))
	    	    	return -4;
	    	}
	    	else {
	    	properties[i] = property;
	    	return i;
	    	}
	    }
		return i;
		
	}
	
	/**Overloaded addProperty method
	 * @param name accepts name of the property 
	 * @param city accepts city of the property 
	 * @param rent accepts the rent of the property 
	 * @param owner accepts the owner of the property
	 * @param x accepts the x value of the plot  
	 * @param y accepts the y value of the plot
	 * @param width accepts the width of the plot
	 * @param depth accepts the depth of the plot 
	 * @return integer of index or another integer if conditions met.
	 */
	public int addProperty (String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property property = new Property(name,city,rent,owner,x,y,width,depth);
		int i = 0;
		if (property==null) 
	    	return -2;
		else {
			if(!(this.plot.encompasses(property.getPlot()))) {
				return -4;
			}
		}
		
		int counter = 0;
		for (i =0;i<MAX_PROPERTY;i++) {
	    	if (!(properties[i]==null)) {
	    		counter++;
	    		if(counter>=5) {
	    			return -1;
	    		}
	    		
	    	    if (properties[i].getPlot().overlaps(property.getPlot()))
	    	    	return -4;
	    	}
	    	else {
	    	properties[i] = property;
	    	return i;
	    	}
	    }
		return i;
	}
	
	/**
	 * displayPropertyAtIndex Method that displays the property at the index of the array 
	 * @param i accepts the index to which the property must be displayed
	 * @return the information of the property at the index
	 */
	public String displayPropertyAtIndex(int i) {
		return properties[i].toString();
	}
	
	/**
	 * @return the value of MAX_PROPERTY 
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	/**
	 * @return maximum rent of the property
	 */
	public double maxRentProp() {
		return properties[maxRentPropertyIndex()].getRentAmount();
	}
	
	
	/**
	 * @return index of the property with maximum rent
	 */
	public int maxRentPropertyIndex() {
		double max = properties[0].getRentAmount();
		for (int i = 1 ;i <properties.length;i++) {
			if ((properties[i]!=null)&&(properties[i].getRentAmount()>max)) {
				max = properties[i].getRentAmount();
				return i;
			}
		}
		return 0;
		
	}
	
	/**
	 * @return the name of the Management Company
	 */
	public String getName() {
		return name; 
	}
	
	/**
	 * @return the Plot object
	 */
	public Plot getPlot() {
		return plot;
	}
	
	/** 
	 * Overriden toString method to display the contents of the object 
	 */
	public String toString() {
		String string = "List of the properties for " + name +", taxID"+taxID;
		for (int i = 0; i<properties.length;i++) {
			if (properties[i]!=null) {
			   string+=(properties[i].toString()+"\n");
			}
		}
		string+=("total Management Fee: "+mgmFeePer);
		return string;
		
	}
	
	/**
	 * @return the total rent of the properties in the company
	 */
	public double totalRent() {
		double total = 0;
		for (int i = 0 ;i <properties.length;i++) {
			if (properties[i]!=null) {
				total+=properties[i].getRentAmount();
			}
		}
		return total;
	}
	

}
