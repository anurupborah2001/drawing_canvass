/*
 * @author Anurup Borah
 * @package com.canvas.drawing.service
 * 
 * DrawingService is a service layer called by the Drawing Conroller
 *
 */
package com.canvas.drawing.service;

import com.canvas.drawing.exception.DrawingException;
import com.canvas.drawing.implementation.DrawingCanvas;

public class DrawingService implements BaseService{
    private DrawingCanvas canvas;

	public DrawingService() {
		// TODO Auto-generated constructor stub
		this.canvas = new DrawingCanvas();
	}
	

	@Override
	public void drawService(String commandStr) throws DrawingException {
		// TODO Auto-generated method stub
		this.canvas.draw(commandStr);
	}

}
