package com.theh.realchatapi.Exceptions;

public enum ErrorCodes {

	GENERAL_ENTITY_NOT_FOUND(001),
	UNKNOW_ERROR(111),
	BAD_CREDENTIAL(011),
	USER_NOT_EXIST(400),
	USER_EXIST(400),
	EMAIL_INCORRECT(500),
	NOT_VALID(100),
	NOTIFICATION_NOT_VALID(200),
	FILE_NOT_FOUND(300)
	;
	private int code;
	ErrorCodes(int code){
		this.code=code;
	}
	public int getCode() {
		return code;
	}
}
