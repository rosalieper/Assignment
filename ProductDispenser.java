/*definig the ProductDispenser class*/

public class ProductDispenser{
	public final static int INITIAL_COUNT = 100;
	public int amountInMachine;//number of hundred francs coins
	//cnt holds the number of available items for each product
	public int cnt1;
	public int cnt2;
	public int cnt3;
	public int cnt4;
	public int cnt5;

	public ProductDispenser(){
		amountInMachine = INITIAL_COUNT;
		cnt1 = 10;
		cnt2 = 10;
		cnt3 = 10;
		cnt4 = 10;
		cnt5 = 10;
	}

	public void dispenseProduct(double price, double amountSentIn, int amountProduct, int product){
		if (isSufficientProductAvailable(amountProduct, product)) {
			switch(product){
			case 1: cnt1-=amountProduct; break;//update the amount of product left
			case 2: cnt2-=amountProduct; break;
			case 3: cnt3-=amountProduct; break;
			case 4: cnt4-=amountProduct; break;
			case 5: cnt5-=amountProduct; break;
			}
			dispenseChange(price, amountProduct, amountSentIn);	
		}
		
	}

	public void dispenseChange(double price, int amountProduct, double amountSentIn){
		double totalPrice = price *amountProduct;//compute exact customer price
		double dispenseChange = amountSentIn - totalPrice;//compute the change
		if (isSufficientCashAvailable(price, amountProduct, amountSentIn)) {
			amountInMachine -= dispenseChange/100;
			amountInMachine += amountSentIn;// reset count to hold the remaining amount after giving the change	
		}
	}

	public boolean isSufficientCashAvailable(double price, int amountProduct, double amountSentIn){
		double totalPrice = price *amountProduct;//compute exact customer price
		double dispenseChange = amountSentIn - totalPrice;//compute the change

		if (amountInMachine >= dispenseChange)
			return true;//enough cash available
		else
			return false;//unsuficient cash cant give change
	}

	public boolean isSufficientProductAvailable(int amountProduct, int product){
		switch(product){
			case 1: if(cnt1>amountProduct)return true; else return false; break;
			case 2: if(cnt2>amountProduct)return true; else return false; break;
			case 3: if(cnt3>amountProduct)return true; else return false;break;
			case 4: if(cnt4>amountProduct)return true; else return false; break;
			case 5: if(cnt5>amountProduct)return true; else return false; break;
		}
		return false;
	}
}