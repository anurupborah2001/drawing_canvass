package com.canvas.drawing.model;

public interface Shape {
	
	public void render();
	
	public void draw(int x1,int y1,int x2,int y2,String ch);
	
	public char[][] getCanvasArray();
	
	public void Fill(int x, int y, char ch);
	
	public boolean validate(int x1, int y1, int x2, int y2);
}
