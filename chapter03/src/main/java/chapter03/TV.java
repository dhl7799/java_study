package chapter03;

public class TV {
	private int channel; //1~255
	private int volume;
	private boolean power;
	
	public TV(int ch, int vol, boolean p) {
		this.channel = ch;
		this.volume = vol;
		this.power = p;
	}
	
	public void power(boolean on) {
		this.power = on;
	}
	
	public void channel(int channel) {
		this.channel = channel;
	}
	public void channel(boolean up) {
		if(up) {
			this.channel++;
			if(channel>255)
				channel=0;
		}
		else {
			this.channel--;
			if(channel<0)
				channel=255;
		}
	}
	public void volume(int voluem) {
		this.volume = voluem;
	}
	public void volume(boolean up) {
		if(up) {
			this.volume++;
			if(volume>255)
				volume=0;
		}
		else {
			this.volume--;
			if(volume<0)
				volume=255;
		}
	}
	public void status() {
		System.out.println("TV[power=" + (power ? "on" : "off") +", "+
						   "Channel=" + channel + ", " +
						   "Volume=" +volume + "]"
							
				);
	}
}
