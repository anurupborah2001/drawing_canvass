/*
 * @author Anurup Borah
 * @package com.canvas.drawing.model
 * 
 * Canvas Model is the main model class for building the canvas and also the execution of the Canvas,Line,Rectangle and Box Fill
 *
 */
package com.canvas.drawing.model;

import java.util.List;

import com.canvas.drawing.constant.DrawingConstant;
import com.canvas.drawing.exception.DrawingException;
import com.canvas.drawing.helper.DrawingHelper;
import com.canvas.drawing.helper.PropertyFileHelper;
import com.canvas.drawing.implementation.DrawingCanvas;

public class Canvas {

	Shape shapeObj= null;
	
	private char[][] canvasArr;
	
	private Line line;
	
	private int width;
	
	private int height;
	
	private char shape;
	
	private List<Point> canvasPoints;
	
	private PropertyFileHelper propFile = null;
	
	public Canvas(List<Point> listPoints,char shape){
		this.canvasPoints = listPoints;
		this.width = listPoints.get(0).getX() + 2;
		this.height = listPoints.get(0).getY() + 2;
		this.canvasArr = new char[this.height][this.width];
		this.shape = shape;
		this.initateCanvas();
		this.propFile = new PropertyFileHelper(DrawingConstant.APP_PROP_FILENAME);
	}
	
	public void initateCanvas(){	
		this.draw(this.shape,this.canvasPoints,'\u0000');
	}
	
	public void render() {
		if(this.shapeObj != null){
			for(int i=0;i<this.height;i++) {
				for(int j=0;j<this.width;j++) {				 
					System.out.print(this.canvasArr[i][j]);
				}
				System.out.println();
			}
		}
	}
	

	public boolean validateLineBounds(int x1, int y1, int x2, int y2) {
		if(x1 <= this.width && x2 <= this.width && y1 <= this.height && y2 <= this.height){
			return true;
		}else{
			return false;
		}
	}
	
	
	public boolean validatePointBounds(int x, int y) {
		if(x >= 1 && x <= this.width && y >= 1 && y <= this.height){
			return true;
		}else{
			return false;
		}
	}
	
	
	public void draw(char str,List<Point> canvasPointsArr,char marker) {//, char... b
		char upperStr = Character.toUpperCase(str);
		String errMsg = "";
		int x1 = (DrawingHelper.isSet(canvasPointsArr, 0)) ? canvasPointsArr.get(0).getX() : 0;
		int y1 = (DrawingHelper.isSet(canvasPointsArr, 0)) ? canvasPointsArr.get(0).getY() : 0;
		int x2 = (DrawingHelper.isSet(canvasPointsArr, 1)) ? canvasPointsArr.get(1).getX() : 0;
		int y2 = (DrawingHelper.isSet(canvasPointsArr, 1)) ? canvasPointsArr.get(1).getY() : 0; 
		this.shapeObj = new Line(this.canvasArr);
		try {
			DrawingCanvas.propMsg = (DrawingCanvas.propMsg.isEmpty()) ? this.propFile.readFromProperties() :  DrawingCanvas.propMsg;
		} catch (DrawingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   switch(upperStr) {
			case 'C' :
				this.shapeObj.draw(0, 0, this.width-1, 0, DrawingConstant.HORIZONTAL_LINE_CHAR);
				this.shapeObj.draw(0, this.height-1, this.width-1, this.height-1, DrawingConstant.HORIZONTAL_LINE_CHAR);
				this.shapeObj.draw(0, 1, 0, this.height-2, DrawingConstant.VERTICAL_LINE_CHAR);
				this.shapeObj.draw(this.width-1, 1, this.width-1, this.height-2, DrawingConstant.VERTICAL_LINE_CHAR);
			break;
			case 'L' :
				if(this.shapeObj.validate(x1, y1, x2, y2)){
					if(this.validateLineBounds(x1, y1, x2, y2)){
						this.shapeObj.draw(x1,y1,x2,y2,DrawingConstant.HORIZONTAL_VERTICAL_CROSS_CHAR);
					}else{
						errMsg = DrawingCanvas.propMsg.get(DrawingConstant.PROP_KEY_INVALID_LINE_OUT_OF_BOUND);
					}
				}else{
						errMsg = DrawingCanvas.propMsg.get(DrawingConstant.PROP_KEY_INVALID_LINE_DRAWN);
				}
			break;
			case 'R' :
				this.shapeObj = new Rectangle(this.canvasArr);
				if(this.shapeObj.validate(x1, y1, x2, y2)){
					if(this.validateLineBounds(x1, y1, x2, y2)){
					   this.shapeObj.draw(x1,y1,x2,y2,DrawingConstant.HORIZONTAL_VERTICAL_CROSS_CHAR);
					}else{
						errMsg = DrawingCanvas.propMsg.get(DrawingConstant.PROP_KEY_INVALID_LINE_OUT_OF_BOUND);
					}
				}else{
						errMsg = DrawingCanvas.propMsg.get(DrawingConstant.PROP_KEY_INVALID_RECTANGLE_PARAM);
				}
			break;
			case 'B' :
				this.shapeObj = new Rectangle(this.canvasArr);
				if(this.validatePointBounds(x1,y1)){
					this.shapeObj.Fill(x1,y1,marker);
				}else{
					errMsg = DrawingCanvas.propMsg.get(DrawingConstant.PROP_KEY_INVALID_POINT_PARAM);
				}
			break;
		}
	   
	   if(errMsg!=""){
		    System.err.println(errMsg);
			return;
	   }
	   	this.canvasArr = this.shapeObj.getCanvasArray();
	}
	

	
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

}
