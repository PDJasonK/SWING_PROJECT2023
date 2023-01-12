package ToeicContents;

public class ReadingMain2Vo {

	private String gain1;
	private String gain2;
	private String gain3;
	private String send1;
	private String send2;
	private String send3;
	
	ReadingMain2Vo(){

}

	public ReadingMain2Vo(String gain1, String gain2, String gain3, String send1, String send2, String send3) {
		this.gain1 = gain1;
		this.gain3 = gain3;
		this.gain3 = gain3;
		this.send1 = send1;
		this.send2 = send2;
		this.send3 = send3;

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

	public String getsend1() {
		return send1;
	}

	public String getsend2() {
		return send2;
	}

	public String getsend3() {
		return send3;
	}

}