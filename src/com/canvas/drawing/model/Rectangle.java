/*
 * @author Anurup Borah
 * @package com.canvas.drawing.model
 * 
 * Rectangle Model class 
 *
 */
package com.canvas.drawing.model;

import java.util.List;

public class Rectangle implements Shape{
	
	private List<Point> rectPoints;
	
	private char marker = '\0';
	
	private Line line = null;
	
	private int width;
	
	private int height;
	
	
	public Rectangle(char[][] canvasArray){
		this.line = new Line(canvasArray);
	}
	
	public Rectangle(List<Point> rectPoints,char marker){
		this.rectPoints = rectPoints;
		this.setMarker(marker);
	}

	public List<Point> getRectPoints() {
		return rectPoints;
	}

	public void setRectPoints(List<Point> rectPoints) {
		this.rectPoints = rectPoints;
	}
	
	
	


	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void draw(int x1, int y1, int x2, int y2, String ch) {
		// TODO Auto-generated method stub
		this.line.draw(x1,y1, x2, y1, ch);
		this.line.draw(x1,y1, x1, y2, ch);
		this.line.draw(x2,y1, x2, y2, ch);
		this.line.draw(x1,y2, x2, y2, ch);
	}
	
	public char[][] getCanvasArray() {
		return this.line.getCanvasArray();
	}
	
	
	public void Fill(int x, int y, char ch) {
		char[][] canvasArr = this.line.getCanvasArray();
		if((int)canvasArr[y][x] != 0) {
			return;
		}
		
		if(x > 0 || x < this.height || y > 0 || y  < this.width) {
			if((int)canvasArr[y][x] == 0)
				canvasArr[y][x] = ch;
			this.Fill(x+1,y, ch);
			this.Fill(x-1,y, ch);
			this.Fill(x,y-1, ch);
			this.Fill(x,y+1, ch);			
		}
		this.line.setCanvasArray(canvasArr);
	}

	@Override
	public boolean validate(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		if(x1 < x2 && y1 < y2){
			return true;
		}else{
			return false;
		}
	}

	public char getMarker() {
		return marker;
	}

	public void setMarker(char marker) {
		this.marker = marker;
	}
}
