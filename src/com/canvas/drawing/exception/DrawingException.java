/*
 * @author Anurup Borah
 * @package com.canvas.drawing.exception
 * 
 * DrawingException Class that is the Custom Exception class for the Application
 */
package com.canvas.drawing.exception;

import java.io.IOException;

import com.canvas.drawing.constant.DrawingConstant;

public class DrawingException extends BaseException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5097762946561830854L;

	private Exception exception;
	
	private String  customexceptionMsg;
	
	public DrawingException(Exception e,String customexceptionMsg){
		super(customexceptionMsg);
		this.exception = e;
		this.customexceptionMsg = customexceptionMsg;
		String errmsg = this.initateException();
		System.err.println(errmsg);
	}
	
	public String initateException(){
		String exceptionMsg= "";
		if(this.exception instanceof NumberFormatException){
			exceptionMsg = DrawingConstant.EXCEPTION_NUMBER_FORMAT;
		}else if (this.exception instanceof InterruptedException) {
			exceptionMsg = DrawingConstant.EXCEPTION_INTERRUPT;
		}else if (this.exception instanceof ArrayIndexOutOfBoundsException) {
			exceptionMsg =  DrawingConstant.EXCEPTION_ARRAY_OUTBOUND;
		}else if (this.exception instanceof IOException) {
			exceptionMsg = DrawingConstant.EXCEPTION_IO;
		}else if(this.exception instanceof StringIndexOutOfBoundsException){
			exceptionMsg = DrawingConstant.EXCEPTION_STRING_OUTBOUND;
		}else if(this.exception instanceof NullPointerException){
			exceptionMsg = DrawingConstant.EXCEPTION_NULL_POINTER;
		}else{
			exceptionMsg = this.exception.getMessage();
		}
		
		return (this.customexceptionMsg!="") ? this.customexceptionMsg  : exceptionMsg;
	}
	
}
