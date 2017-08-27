/*
 * @author Anurup Borah
 * @package com.canvas.drawing.helper
 * 
 *ScannerHelper Class is helper class in order to scan the console inputs 
 *
 */
package com.canvas.drawing.helper;

import java.util.Scanner;

	public class ScannerHelper {
		
		private Scanner scan;
		
		public ScannerHelper(){}
		
		public Scanner openScanner(){
			this.scan = new Scanner(System.in);
			return this.scan;
	    }
		
		public String goNextLine(){
			if(this.scan instanceof Scanner){
				if(this.scan.hasNext()){
					return this.scan.nextLine();
				}
			}
			return null;
		}
		
		public void closeScan(){
			if(this.scan instanceof Scanner){
				this.scan.close();
			}
		}
}
