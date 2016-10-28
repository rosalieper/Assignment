//this class will handle the point 6 on the main menu 

public class MamiAmara{

	private Keypad keypad;
	private Screen screen;
	private ProductDispenser product;

	public MamiAmara(int code){
		Screen screen = new Screen();
		Keypad keypad = new Keypad();

		if (code == 1111) {
			amaraMenu();
		}
	}
	public void amaraMenu(){
		screen.displayMessageLine("1. See cash in machine\n2. See quantity of product in machine\n3. Change machine code");
	}
	public void amaraRun(){
		int menu = keypad.getInput();
		switch(menu){
			case 1: screen.diplayMessageLine("The cash in machine is %d ", amountInMachine);
				break;
			case 2: screen.displayMessageLine("%d fried_eggs\n%d Bananas\n%d beverages\n%d Plantain_chips\n%d Cookies", cnt1, cnt2, cnt3, cnt4, cnt5);
				break;
			case 3:
				break;
		}
	}
}