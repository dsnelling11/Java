import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.*;

/**
 * This is the domino panel that contains the constructor for my domino program
 * 
 * @author Darries Snelling
 *
 */
public class Game extends Frame {

	/**
	 * This is a instantiation of the domino datatype used to paint
	 * user domino and computer domino
	 */

	private Domino myDomino = new Domino();// domino object
	private Domino computerDomino = new Domino();// domino object
	
	/**
	 * boolean identifiers used to assist in pause of the 
	 * computer domino 
	 */
	private boolean ready = false;
	
	
	/**
	 * boolean identifiers used to assist in pause of the 
	 * computer domino 
	 */
	
	private boolean match = false;
	
	
	/**
	 * Constuctor used to intialize screen window specifics: size, location, and
	 * background.
	 */

	public Game() {
		Scanner keyboard = new Scanner(System.in);
		
		/**
		 * local variable for x and y position
		 */
		int xDominoPosition, yDominoPosition;
		int userLeftDomino;		
		
		/**
		 * do while loop to handle domino face for user
		 */
		
		System.out.println("Hola");
		do{
		System.out.println("Please enter face of the domino 1 through 5: ");
		userLeftDomino = keyboard.nextInt();
		}while(userLeftDomino < 1 || userLeftDomino >5);
		
		
		System.out.println("Enter the location of the domino in the form x y"
				+ " example(100 200): ");
		xDominoPosition = keyboard.nextInt(); // x-position for the blank and
		// all other objects in class
		yDominoPosition = keyboard.nextInt();// y-position for the blank and all
		// other objects in class
		
		
		int randLeftDomino = (int)(Math.random()*5)+ 1; //computer domino
		int randRightPlayerDomino = (int)(Math.random()*5)+ 1;//user domino
		int randRightDomino = (int)(Math.random()*5)+ 1;//computer domino
		int randXYLocation =  (int)(Math.random()*200)+ 1; //computer x y coordinates
		
		setSize(600, 500);
		setLocation(100, 100);
		setTitle("Domino");
		setBackground(Color.white);
		
		/**
		 * user domino setup
		 */
		
		myDomino.setup(xDominoPosition, yDominoPosition, userLeftDomino
				,  randRightPlayerDomino);
		
		setVisible(true); //set visibility to display user domino
		
		
		/**
		 * used to pause program for two seconds
		 */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int xAdjust = 100; //to adjust the x-coordinate 
		
		
		/**
		 * comparing the two dominos and readjusting
		 * the computer domino
		 */
		
		if(userLeftDomino == randLeftDomino && match){
		computerDomino.setup(xDominoPosition - xAdjust, yDominoPosition, 
				randRightDomino, randLeftDomino);
		}else if (userLeftDomino == randRightDomino ){
			computerDomino.setup(xDominoPosition  - xAdjust, yDominoPosition, 
					randLeftDomino, randRightDomino);
			match = true;
		}else if(randRightPlayerDomino == randLeftDomino){
			computerDomino.setup(xDominoPosition  + xAdjust, yDominoPosition,
					randLeftDomino, randRightDomino);
			match = true;
		}else if(randRightPlayerDomino == randRightDomino  ){
			computerDomino.setup(xDominoPosition  + xAdjust, yDominoPosition, 
					randRightDomino, randLeftDomino);
			match = true;
		}else{
			computerDomino.setup(randXYLocation, randXYLocation, 
					 randLeftDomino, randRightDomino);
		}
		
		/**
		 * decision display
		 */
		
		if(match == true){
			System.out.println("** Its a Match!!");
		}else{
			System.out.println("** Not a Match!!");

		}
		
		ready = true;
		repaint(); // update the domino drawing
	}
	
	

	/**
	 * paint method used to draw the domino object
	 */

	public void paint(Graphics pen) {

		myDomino.paint(pen);
		if(ready){
		computerDomino.paint(pen);
		}

	}

}
