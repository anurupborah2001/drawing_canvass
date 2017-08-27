/*
 * @author Anurup Borah
 * @package com.canvas.drawing.constant
 * 
 * Constant Class holding the constants of the application
 */
package com.canvas.drawing.constant;

public class DrawingConstant {
	public static final String VERTICAL_LINE_CHAR = "|";
	public static final String HORIZONTAL_LINE_CHAR = "-";
	public static final String HORIZONTAL_VERTICAL_CROSS_CHAR = "x";
	
	//Regular Expressions
	public static final String REGEX_CANVAS ="^[C]{1} [0-9]{1,2} [0-9]{1,2}$";
	public static final String REGEX_LINE = "^[L]{1} [0-9]{1,2} [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}$";
	public static final String REGEX_RECTANGLE ="^[R]{1} [0-9]{1,2} [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}$";
	public static final String REGEX_BOX_FILL ="^[B]{1} [0-9]{1,2} [0-9]{1,2} [a-z]{1}$";
	
	//Property Exception Message
	public static final String PROP_CANNOT_OPEN = "Property File Cannot be opened";
	public static final String PROP_CANNOT_CLOSE = "Property File Cannot be closed";
	public static final String PROP_NOT_FOUND = "Sorry, unable to find ";
	
	
	public static final String APP_PROP_FILENAME = "application.properties";
	
	//Property File Key Name
	public static final String PROP_KEY_INVALID_COMMAND = "invalid_command";
	public static final String PROP_KEY_INVALID_CANVAS = "invalid_canvas";
	public static final String PROP_KEY_INVALID_LINE = "invalid_line";
	public static final String PROP_KEY_INVALID_RECTANGLE = "inavlid_rectangle";
	public static final String PROP_KEY_INVALID_BOX_FILL = "invalid_box_fill";
	public static final String PROP_KEY_INVALID_LINE_DRAWN = "invalid_line_drawn";
	public static final String PROP_KEY_INVALID_LINE_OUT_OF_BOUND = "invalid_line_out_of_bound";
	public static final String PROP_KEY_INVALID_RECTANGLE_PARAM = "invalid_rectangle";
	public static final String PROP_KEY_INVALID_POINT_PARAM = "invalid_point";
	
	//Exception Messages
	public static final String EXCEPTION_NUMBER_FORMAT = "Invalid Number Format\n";
	public static final String EXCEPTION_INTERRUPT = "Interruption in program process\n";
	public static final String EXCEPTION_ARRAY_OUTBOUND = "Invalid command supplied\n";
	public static final String EXCEPTION_IO = "Input Output Error\n";
	public static final String EXCEPTION_STRING_OUTBOUND = "Invalid String Entered\n";
	public static final String EXCEPTION_NULL_POINTER= "Invalid String Entered.Draw a Canvas first\n";
	
}
