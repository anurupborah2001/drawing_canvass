/*
 * @author Anurup Borah
 * @package com.canvas.drawing.model
 * 
 * Line Model class 
 *
 */
package com.canvas.drawing.model;

import java.util.List;

import com.canvas.drawing.model.Shape;

public class Line implements Shape{
	char[][] canvasArray;
	 
	
	private List<Point> linePoints;
	
	
	public Line(char[][] canvasArray){
		this.canvasArray = canvasArray;
	}
		
	public List<Point> getLinePoints() {
		return linePoints;
	}

	public void setLinePoints(List<Point> linePoints) {
		this.linePoints = linePoints;
	}

	@Override
	public void render() {
		
		
	}

	@Override
	public void draw(int x1,int y1,int x2,int y2,String ch) {
		for(int i=y1; i<=y2; i++) {
			for(int j=x1; j<=x2; j++) {
				this.canvasArray[i][j] = ch.charAt(0);	
			}
		}	
	}
	
	
	public char[][] getCanvasArray() {
		return canvasArray;
	}

	public void setCanvasArray(char[][] canvasArray) {
		this.canvasArray = canvasArray;
	}

	@Override
	public void Fill(int x, int y, char ch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validate(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		if(x1 == x2 || y1 == y2) {
			return true;
		}else{
			return false;
		}
	}
	
}
