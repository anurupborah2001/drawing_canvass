/*
 * @author Anurup Borah
 * @package com.canvas.drawing.controller
 * 
 * MainController Class that works as Proxy Controller
 */
package com.canvas.drawing.controller;

public class MainController<BaseService> {
	private BaseController basecontroller;
	private BaseService baseService;
	public MainController(BaseController basecontroller,BaseService baseService){
		this.basecontroller = basecontroller;
		this.baseService = baseService;
	} 
	
	public void scaneAndDrawCanvas(){
		this.basecontroller.scanAndDrawCanvas();
	}
		
}
