/*
 * @author Anurup Borah
 * @package com.canvas.drawing.controller
 * 
 * DrawingController Class that functions as Controller in MVC Application
 */
package com.canvas.drawing.controller;

import java.util.Scanner;

import com.canvas.drawing.exception.DrawingException;
import com.canvas.drawing.helper.ScannerHelper;
import com.canvas.drawing.service.DrawingService;

public class DrawingController extends BaseController{

	DrawingService drawService;
	
	public DrawingController(){
		super();
		drawService = new DrawingService();
	}
	
	public void scanAndDrawCanvas(){
		Scanner scan = new Scanner(System.in);
		String commandString = new String();
		while(!commandString.equalsIgnoreCase("Q")) {
			System.out.print("enter command:");
			commandString = scan.nextLine();
			try {
				this.drawService.drawService(commandString);
			} catch (DrawingException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());  
			}
		}
		System.out.println("Program Done");
		scan.close();
	}

}
