/*
 * @author Anurup Borah
 * @package com.canvas.drawing.implementation
 * 
 * CanvasMain is the main class and the main class for execution
 *
 */
package com.canvas.drawing.main;

import com.canvas.drawing.controller.DrawingController;
import com.canvas.drawing.controller.MainController;
import com.canvas.drawing.service.DrawingService;

public class CanvasMain {
	@SuppressWarnings("rawtypes")
	static MainController mainController = null;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args){
		mainController = new MainController(new DrawingController(),new DrawingService());
		mainController.scaneAndDrawCanvas();
	}

}
