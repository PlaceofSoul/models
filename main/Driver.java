package main;

import model.Models;

public class Driver {

	/**
	 * {@link Models}
	 * @param args
	 */
	public static void main(String[] args){
		Models superModels = new Models();
		Models superModels1 = new Models("Susan", "Chelse", 33, 80);
		Models superModels2 = new Models("Dani", "Silva", 44, 90, true, false);
		superModels.printDetails();
		System.out.println();
		superModels1.printDetails();
		System.out.println();
		superModels2.displayModelDetails(true);
		
	}
}
