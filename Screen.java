/*The screen class*/

public class Screen{
	public Screen(){}
	//display message on screen
	public void displayMessage(String message){
		System.out.print(message);
	}
	//display message with new line
	public void displayMessageLine(String message){
		System.out.println(message);
	}
	//display price amount
	public void displayPrice(double price){
		System.out.printf("%.2f", price);
	}
}