import java.util.Scanner;

public class MontyHallGame
{
	public static void main(String[] args)
	{
		// game description
		description();
	
		// game
		game();
	
	}
	
	public static void description()
	{
		System.out.println("Welcome to Monty Hall Game!");
		System.out.println("There is a car hidden in one of the three doors.");
		System.out.print("Pick a door now and you will have a chance to switch");
		System.out.println("later.");
	}
	
	public static void game()
	{
		// creating an instance of a Scanner object
		Scanner keyboard = new Scanner(System.in);
		
		// the door the car is in
		int car = (int) (Math.random() * 3 + 1);
		
		//testing
		//System.out.println("car = " + car);
		
		System.out.print("Please pick a door (1, 2 or 3): ");
		int userPick = keyboard.nextInt();
		//get rid of the new line from the buffer
		keyboard.nextLine();
		
		// testing
		System.out.println("userPick = " + userPick);
		
		int reveal = doorToReveal(car, userPick);
		
		// testing
		//System.out.println("door to reveal = " + reveal);
		
		System.out.println("Door #" + reveal + " is empty!");
		System.out.println("Do you want to stay or switch (yes or no): ");
		String answer = keyboard.nextLine();
		
		if (answer.equals( "yes" ) )
		{
		
			userPick = doorToReveal( reveal , userPick );
			
		}
		
		
		
		// testing
		System.out.println(answer);
		
		if (userPick == car )
		{
		
			System.out.println( "You win!" );
		
		}
		
		else
		{		
		
			System.out.println( "You lose!" );
			
		}
	}
	
	/**
	 * This method returns the door number that is
	 * neither the car is in or the user's pick.
	 * This method generates a random door number 
	 * until it finds a door that is not equal to c nor u.
	 * @param c the door number the car is in
	 * @param u the door number that the user picked
	 * @return int 
	 */
	public static int doorToReveal(int c, int u)
	{
		int r = (int) (Math.random() * 3 + 1);
		while( r == c || r == u)
		{
			r = (int) (Math.random() * 3 + 1);
		}
		return r;
	
	}
	
	/**
	 * This method returns the door number that is
	 * neither the car is in or the user's pick.
	 * @param c the door number the car is in
	 * @param u the door number that the user picked
	 * @return int 
	 */
	public static int doorToReveal1(int c, int u)
	{
		for(int i = 1; i < 4; i++)
		{
			if (i != c && i != u)
				return i;
		
		}	
		return -1;
	}
}