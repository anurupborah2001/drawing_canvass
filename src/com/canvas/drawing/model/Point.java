/*
 * @author Anurup Borah
 * @package com.canvas.drawing.model
 * 
 * Point Model class 
 *
 */
package com.canvas.drawing.model;

public class Point implements Shape{
	private int x;
	
	private int y;
	
	public Point(){
		
	}
	
	public Point(int x, int y){
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", getX()=" + getX() + ", getY()=" + getY() + "]";
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void draw(int x1, int y1, int x2, int y2, String ch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char[][] getCanvasArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Fill(int x, int y, char ch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validate(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		return false;
	}

}
