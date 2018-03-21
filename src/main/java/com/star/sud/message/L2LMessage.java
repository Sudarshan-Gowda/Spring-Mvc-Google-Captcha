package com.star.sud.message;

public class L2LMessage {

	protected L2LMessageCode code;

	protected String additionalCode;

	protected String message;

	protected L2LMessageType type;

	public L2LMessageCode getCode() {
		return code;
	}

	public void setCode(L2LMessageCode code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public L2LMessageType getType() {
		return type;
	}

	public void setType(L2LMessageType type) {
		this.type = type;
	}

	public String getAdditionalCode() {
		return additionalCode;
	}

	public void setAdditionalCode(String additionalCode) {
		this.additionalCode = additionalCode;
	}

	public L2LMessage(L2LMessageCode code, String message, L2LMessageType type) {
		this.code = code;
		this.message = message;
		this.type = type;
	}

	public L2LMessage(String code, String message, L2LMessageType type) {
		this.additionalCode = code;
		this.message = message;
		this.type = type;
	}

	public L2LMessage() {

	}
}
