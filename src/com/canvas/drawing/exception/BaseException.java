/*
 * @author Anurup Borah
 * @package com.canvas.drawing.exception
 * 
 * abstract BaseException Class that extends Exception class
 */
package com.canvas.drawing.exception;

abstract class BaseException extends Exception {
	
	public BaseException(String message){
		super(message);
	}
	
	abstract String initateException();	
	
}
