package model;

public class Result {
	private String out;
	private String err;
	private int returnCode;
	public Result() {
		super();
	}
	public String getOut() {
		return out;
	}
	public void setOut(String out) {
		this.out = out;
	}
	public String getErr() {
		return err;
	}
	public void setErr(String err) {
		this.err = err;
	}
	public int getRc() {
		return returnCode;
	}
	public void setRc(int rc) {
		this.returnCode = rc;
	}

}
