/*
 * @author Anurup Borah
 * @package com.canvas.drawing.validator
 * 
 * Base Validator is the parent class for the validator of the Application
 *
 */
package com.canvas.drawing.validator;

abstract class BaseValidator {
	public abstract boolean mastchStringRegEx(String pattern, String content);
}
