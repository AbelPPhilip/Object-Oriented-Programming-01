/**
 * 
 * @author abelp
 *
 */
public class Television {
	private final String MANUFACTURER;
	private final int SCREEN_SIZE;
	
	private boolean powerOn;
	private int channel;
	private int volume;
	

	public Television(String brand, int size) {
		MANUFACTURER = brand;
		SCREEN_SIZE = size;
		powerOn = false;
		volume = 20;
		channel=2;
		// TODO Auto-generated constructor stub
		
	}

/**
 * Method to check if the power is on. 
 * @return true of the power is on, false other wise 
 */
	public boolean isPowerOn() {
		return powerOn;
	}

/**
 * void method to switch power 
 * 
 */
	public void power() {
		powerOn = !powerOn;
	}

/**
 * 
 * @return channel number 
 */
	public int getChannel() {
		return channel;
	}

/**
 * Method to set the channel for the TV
 * @param channel an int value for the channel
 */
	public void setChannel(int channel) {
		this.channel = channel;
	}

/**
 * Method to return the current volume
 * @return volume value of the TV
 */
	public int getVolume() {
		return volume;
	}

/**
 * Method to set the volume
 * @param volume an int value for volume 
 */
	public void setVolume(int volume) {
		this.volume = volume;
	}
/**
 * Method to increase Volume by one 
 */
	public void increaseVolume() {
		volume++;
	}
	
/**
 * Method to decrease volume by one
 */
	public void decreaseVolume() {
		volume--;
	}

/**
 * Method to get the screen size
 * @return the int value of the screen size in inches
 */
	public int getScreenSize() {
		return SCREEN_SIZE;
	}

/**
 * Method to retrieve the manufacturer information
 * @return string value of the manufacturer
 */
	public String getManufacturer() {
		return MANUFACTURER;
	}

}
