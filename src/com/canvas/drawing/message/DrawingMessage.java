/*
 * @author Anurup Borah
 * @package com.canvas.drawing.message
 * 
 * Drawing Message is the message Class that registers the messages
 *
 */
package com.canvas.drawing.message;

public class DrawingMessage implements IMessage{
	
		private String message;
		
		public DrawingMessage(String message){
			super();
			this.message = message;
		}
	
	  public String printMessage(){
		return this.message;
	  }
}
