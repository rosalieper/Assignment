/*A new automatic teller machine has been designed by Faculty of
Engineering and Technology for Mami Amara and a program is needed
to make the machine function properly. The machine sells fried eggs,
bananas, beverages, plantain chips and cookies.*/

/*Assumptions: 1- This Atm programme assumes only one currency in use, (FCFA)
/*			   2- This Atm programme assumes the user input an amount in the machine and type exactly that amount (without errors)
*/
import java.util.Scanner;

public class ATM{

	private Keypad keypad;
	private Pay pay;
	private ProductDispenser product;
	private Screen screen;
	private MamiAmara mamiAmara;

	private static final int EGGS = 0;
	private static final int BANANAS = 1;
	private static final int BEVERAGES = 2;
	private static final int CHIPS = 3;
	private static final int COOKIES = 4;
	
	public ATM (){
		Screen screen = new Screen();
		Keypad keypad = new Keypad();
		Pay pay = new Pay();
		ProductDispenser product = new ProductDispenser();
	}
	public void run () {
		
		while(true){

			int request, numProduct;
			double price[] = {200, 100, 300, 200, 500};
			String menu[] = {"fried_eggs", "bananas", "beverages", "plantain_chips", "cookies" };

			screen.displayMessageLine("Welcome");
			screen.displayMessageLine("Select the number representing your choice\n");
			screen.displayMessageLine("1-> Fried eggs\t200F\n2-> Bananas\t100F\n3-> Beverages\t300F\n4-> Plantain chips\t200F\n5-> Cookies\t500F\n6-> MamiAmara queries...");
			screen.displayMessage("Enter your choice:  ");	

			request = keypad.getInput();
			while(request <= 5 && request >= 1){
				//display the price and take amount
				System.out.printf("The price of %s is %d",menu[request-1] ,price[request-1]); 
				System.out.printf("What amount of %s do you need? available amount is %d.\n Type 0 to return. ", menu[request-1]);
				numProduct = keypad.getInput();
				if (product.isSufficientProductAvailable(numProduct, request) && numProduct > 0) {
					screen.displayMessageLine("Product availabe waiting for your cash...");
					int cashIn = keypad.getInput();
					product.dispenseProduct(price[request-1], cashIn, numProduct, request-1);

					System.out.printf("Thanks for choosing us and please enjoy your %s",menu[request-1] );
					
				}
				else if(!product.isSufficientProductAvailable(numProduct, request) && numProduct > 0)//if requestnum >item return to main menu
					screen.displayMessageLine("The amount requested is not availabe. ");
				else if (numProduct == 6) {
					screen.displayMessageLine("Welcome Mami Amara");
					screen.displayMessageLine("please Enter your machine code : ");
					int code = keypad.getInput();
					MamiAmara mamiAmara =  new MamiAmara(code);
					mamiAmara.amaraMenu();
				}
			}
		}
	}
}