
/**
 * 
 * Plot is a data element class, 
 * which is used to create Management Company object. 
 * @author abelp
 * @version 11
 *Date: 10/25/2021
 *Description: Main Class to combine the 2 supporting classes, Property and Plot
 * 
 *
 */
 
public class Plot {
	private int x, y, width, depth;
	
	/**
	 * Default Constructor
	 */
	Plot(){
		x=0;
		y=0;
		width = 0;
		depth = 0; 
	}
	
	
	/**
	 * Overriden constructor
	 * @param p Plot Object 
	 */
	Plot (Plot p){
		this.x = p.getX();
		this.y = p.getY();
		this.width = p.getWidth();
		this.depth = p.getDepth();
	}
	
	/**
	 * 
	 * @param x accepts x value of ploy 
	 * @param y accepts y value of plot
	 * @param width accepts the width value 
	 * @param depth accepts the depth value 
	 */
	Plot (int x, int y,int width, int depth){
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * 
	 * @param p Plot object 
	 * @return wether the values overlap
	 */
	public boolean overlaps (Plot p) {
		int bottomLeftX1 = x; 
		int bottomLeftY1 = y;
		int topRightX1  = x +width;
		int topRightY1 = y+depth; 
		int bottomLeftX2 = p.getX();
		int bottomLeftY2 = p.getY();
		int topRightX2 = p.getX()+p.getWidth();
		int topRightY2 = p.getY()+p.getDepth();
		if ((bottomLeftX1 <topRightX2) &&(topRightX1 > bottomLeftX2)&&(bottomLeftY1 < topRightY2)&&(topRightY1 > bottomLeftY2)) {
						return true;
		}
		
		/*
		if (bottomLeftX1 <topRightX2) {
			if (topRightX1 > bottomLeftX2) {
				if (bottomLeftY1 < topRightY2) {
					if (topRightY1 > bottomLeftY2) {
						return true;
					}
				}
			}
		}
		*/
		return false; 
		
	}
	
	/**
	 * Boolean encompass method 
	 * @param p Plot object 
	 * @return true or false of the plot encompasses
	 */
	public boolean encompasses(Plot p ) {
		if ((p.getX()>=x)&&(p.getY()>=y) && ((p.getX()+p.getWidth())<=(x+width)) && ((p.getY()+p.getDepth()) <=(y+depth))){
			return true;
		}
		else return false;
	}
	
	/**
	 * Get Method
	 * @return x value 
	 */
	public int getX() {
		return x; 
	}
	
	
	/**
	 * Set Method 
	 * @return y value 
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Set method 
	 * @param y accepts y value to replace
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Set method 
	 * @param x accepts x value to replace 
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Set method 
	 * @param width accepts width to replace 
	 */
	public void setWidth(int width) {
		this.width = width; 
	}
	
	/**
	 * Get method 
	 * @return the width of the plot 
	 */
	public int getWidth () {
		return width; 
	}
	
	/**
	 * Get method 
	 * @return depth of the plot
	 */
	public int getDepth() {
		return depth; 
	}
	
	/**
	 * Set method 
	 * @param depth replace the depth value 
	 */
	public void setDepth(int depth) {
		this.depth = depth; 
	}
	/**
	 * Overriden String Method 
	 * @return contents of the object
	 */
	public String toString() {
		return ("Upper left:" + " ("+x+","+y+"); Width: "+width+" Depth: "+depth);
	}

}
