/*
 * @author Anurup Borah
 * @package com.canvas.drawing.validator
 * 
 * DrawingValidator is a validator class
 *
 */
package com.canvas.drawing.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrawingValidator extends BaseValidator{

	public DrawingValidator(){};
	
	public boolean mastchStringRegEx(String pattern, String content) {
		Pattern p = Pattern.compile(pattern);
	    Matcher m = p.matcher(content); 
	    return m.matches();
	}
	
}
