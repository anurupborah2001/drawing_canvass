/*
 * @author Anurup Borah
 * @package com.canvas.drawing.service
 * 
 * Base Service Class acts as parent class
 *
 */
package com.canvas.drawing.service;

import com.canvas.drawing.exception.DrawingException;

interface BaseService{
	
	public void drawService(String commandStr) throws DrawingException;
}
