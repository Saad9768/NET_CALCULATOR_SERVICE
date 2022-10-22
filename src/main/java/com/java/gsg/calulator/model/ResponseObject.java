package com.java.gsg.calulator.model;

public class ResponseObject {

	private String status;
	private Double result;
	private String error;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ResponseObject [status=" + status + ", result=" + result + ", error=" + error + "]";
	}

}
