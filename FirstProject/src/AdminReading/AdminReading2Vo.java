package AdminReading;

public class AdminReading2Vo {

	private String gain1;
	private String gain2;
	private String gain3;
	private String giving1;
	private String giving2;
	private String giving3;
	
	public AdminReading2Vo () {
		
	}
	
	public AdminReading2Vo(String gain1, String gain2, String gain3,
			String giving1 ,String giving2 , String giving3) {
		this.gain1 = gain1;
		this.gain2 = gain2;
		this.gain3= gain3;
		this.giving1 = giving1;
		this.giving2 = giving2;
		this.giving3 = giving3;
		
}
	public String getgain1() {
		return gain1;
	}

	public String getgain2() {
		return gain2;
	}

	public String getgain3() {
		return gain3;
	}
	
	public String getgiving1() {
		return giving1;
	}

	public String getgiving2() {
		return giving2;
	}

	public String getgiving3() {
		return giving3;
	}

}
