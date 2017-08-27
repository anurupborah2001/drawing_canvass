/*
 * @author Anurup Borah
 * @package com.canvas.drawing.helper
 * 
 * Drawing Helper Class is  helper class for the application 
 */
package com.canvas.drawing.helper;

import java.util.List;

public class DrawingHelper {

	
	public char getFirstCharacter(String commandStr){
		return Character.toUpperCase(commandStr.charAt(0));
	}
	
	public static boolean isSet(List<?> list, int index) {
		return index >=0 && index < list.size() && list.get(index) != null;
	}

	
}
