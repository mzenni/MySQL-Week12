import java.util.Random;

public class TestDemo {
	public int addPositive (int a, int b) {
		int sum = a + b;
		if((a > 0) && (b > 0)) {
			return sum;
		}
		else {
			throw new IllegalArgumentException("\nBoth parameters must be positive!");
		}
	}
	
	// obtains random integer and returns that integer squared
	public int randomNumberSquared() { 
		int rndInt = getRandomInt(); 
		int result = rndInt * rndInt; 
		return result; 
	}

	// 
	int getRandomInt() {
		Random random = new Random(); 
		
		// gets random integer between 1 to 10 
		return random.nextInt(10) + 1 ; 
	}

}


