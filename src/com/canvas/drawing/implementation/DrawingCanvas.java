/*
 * @author Anurup Borah
 * @package com.canvas.drawing.implementation
 * 
 * Drawing Canvas Class is the class that handles the implementation of the Drawing Canvass App
 *
 */
package com.canvas.drawing.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.canvas.drawing.constant.DrawingConstant;
import com.canvas.drawing.exception.DrawingException;
import com.canvas.drawing.helper.DrawingHelper;
import com.canvas.drawing.helper.PropertyFileHelper;
import com.canvas.drawing.model.Canvas;
import com.canvas.drawing.model.Point;
import com.canvas.drawing.validator.DrawingValidator;

public class DrawingCanvas {
	 static Canvas canvas = null;
	 
	 private DrawingValidator validator = null;
	 
	 private DrawingHelper helper = null;
	 
	 private PropertyFileHelper propFile = null;
	
	 public static Map<String,String> propMsg = new HashMap<String,String>();
	 
		public DrawingCanvas() {
			// TODO Auto-generated constructor stub
			this.validator = new DrawingValidator();
			this.helper = new DrawingHelper();
			this.propFile = new PropertyFileHelper(DrawingConstant.APP_PROP_FILENAME);
		}
	
	public boolean validateCanvas(String regex,String commandLine){
		if (this.validator.mastchStringRegEx(regex, commandLine)) {
	        return true;
	    } 
		 return false;
	} 
	
	@SuppressWarnings("static-access")
	public void createCanvas(String commandStr) throws DrawingException{
		try {
			char firstChar = this.helper.getFirstCharacter(commandStr);
			String[] cmd = commandStr.split(" ");
			List<Point> listPoints= new ArrayList<>(2);
			if(firstChar=='Q'){
				return;
			}
			Point point2,point1 = null;
			point1 = new Point(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2]));
			listPoints.add(0, point1);
			boolean validateStr = false;
			this.propMsg = this.propFile.readFromProperties();
			String validateMsg = this.propMsg.get(DrawingConstant.PROP_KEY_INVALID_COMMAND);
			switch(firstChar) {
					case 'C' :
						if(this.validateCanvas(DrawingConstant.REGEX_CANVAS, commandStr)){
						    validateStr = true;
							this.canvas = new Canvas(listPoints,firstChar);
						}else{
							validateMsg = this.propMsg.get(DrawingConstant.PROP_KEY_INVALID_CANVAS);
						}
					break;
					case 'L' :
						if(this.validateCanvas(DrawingConstant.REGEX_LINE, commandStr)){
							validateStr = true;
							point2 = new Point(Integer.parseInt(cmd[3]),Integer.parseInt(cmd[4]));
							listPoints.add(1, point2);
							this.canvas.draw(firstChar,listPoints,'\u0000');
						}else{
							validateMsg = this.propMsg.get(DrawingConstant.PROP_KEY_INVALID_LINE);
						}
					break;
					case 'R' :
						if(this.validateCanvas(DrawingConstant.REGEX_RECTANGLE, commandStr)){
							validateStr = true;
							point2 = new Point(Integer.parseInt(cmd[3]),Integer.parseInt(cmd[4]));
							listPoints.add(1, point2);
							this.canvas.draw(firstChar,listPoints,'\u0000');
						}else{
							validateMsg = this.propMsg.get(DrawingConstant.PROP_KEY_INVALID_RECTANGLE);
						}
					break;
					case 'B' :
						if(this.validateCanvas(DrawingConstant.REGEX_BOX_FILL, commandStr)){
							validateStr = true;
							this.canvas.draw(firstChar,listPoints,cmd[3].charAt(0));
						}else{
							validateMsg = this.propMsg.get(DrawingConstant.PROP_KEY_INVALID_BOX_FILL);
						}
					break;
				}
				
				if(this.canvas!=null && validateStr){
					this.canvas.render();
				}else{
					System.err.println(validateMsg);
					return;
				}
		}catch (Exception e) {
			throw new DrawingException(e, "");
		}
	}
	
	public void draw(String commandStr) throws DrawingException{
		this.createCanvas(commandStr);
	}
	

}
