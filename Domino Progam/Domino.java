import java.util.*;
import java.awt.*;
import java.math.*;

/**
 * 
 * @author Darries Snelling
 *
 */

public class Domino {

	/**
	 * CONSTANT Used as the initial point for the domino to make calculation
	 * based on top left of domino
	 */
	final private int LEFT_DOMINO_TOP = 100;

	/**
	 * x, y for the location of the rectangle and all the other objects
	 */

	private int xDominoPosition, yDominoPosition;

	/**
	 * used to store users value from the prompt
	 */

	private int usersValue;

	/**
	 * declaration of the random instance variable for data manipulation
	 */

	private int randomComputer;

	/**
	 * random object instantiated for data manipulation
	 */
	Random random = new Random();

	/**
	 * Scanner object used to prompt user for data
	 */
	Scanner keyboard = new Scanner(System.in);

	/**
	 * Constructor for the Domino class that initialized some data members.
	 */

	public Domino() {
		System.out.println("Hola");
		numberValidation(); // invokes number validation between 1 and 5
		randomComputer = (int) random.nextInt(5) + 1; // adds one to random
														// number to incease
														// limit to five
		System.out.println("Please enter the location of the domino: ");
		xDominoPosition = keyboard.nextInt(); // x-position for the blank and
												// all other objects in class
		yDominoPosition = keyboard.nextInt();// x-position for the blank and all
												// other objects in class

	}

	/**
	 * receives results from number validation and draws the die based on users
	 * value and computer random generation.
	 */

	public void paint(Graphics pen) {

		drawBlank(pen); // invoked method to draw blank on the screen so that I
						// don't have to continue to draw it

		/**
		 * if statement used to draw die based user value to the left side of
		 * the die using the prompt.
		 */

		if (usersValue == 1) {
			drawOne(pen, true);
		} else if (usersValue == 2) {
			drawTwo(pen, true);
		} else if (usersValue == 3) {
			drawThree(pen, true);
		} else if (usersValue == 4) {
			drawFour(pen, true);
		} else if (usersValue == 5) {
			drawFive(pen, true);
		}

		/**
		 * if statement used to draw die based on random number generation to
		 * the right side of the die.
		 */

		if (randomComputer == 1) {
			drawOne(pen, false);
		} else if (randomComputer == 2) {
			drawTwo(pen, false);
		} else if (randomComputer == 3) {
			drawThree(pen, false);
		} else if (randomComputer == 4) {
			drawFour(pen, false);
		} else {
			drawFive(pen, false);
		}

	}

	/**
	 * Draws a die with one dot in the left or right side of the die depending
	 * on the argument isLeft.
	 * 
	 */

	private void drawOne(Graphics pen, boolean isLeft) {
		if (isLeft) {
			drawDot(pen, LEFT_DOMINO_TOP / 2, LEFT_DOMINO_TOP / 2);
		} else {
			drawDot(pen, LEFT_DOMINO_TOP * 2 - LEFT_DOMINO_TOP / 2, LEFT_DOMINO_TOP / 2);
		}

		/**
		 * Draws a die with two dots in the left or right side depending on the
		 * argument isLeft.
		 * 
		 * 
		 */

	}

	private void drawTwo(Graphics pen, boolean isLeft) {
		if (isLeft) {
			drawDot(pen, LEFT_DOMINO_TOP / 10, LEFT_DOMINO_TOP / 10);
			drawDot(pen, LEFT_DOMINO_TOP - LEFT_DOMINO_TOP / 10,
					LEFT_DOMINO_TOP / 2 + LEFT_DOMINO_TOP / 4 + LEFT_DOMINO_TOP / 10);
		} else {
			drawDot(pen, LEFT_DOMINO_TOP * 2 - LEFT_DOMINO_TOP / 6,
					LEFT_DOMINO_TOP / 2 + LEFT_DOMINO_TOP / 4 + LEFT_DOMINO_TOP / 20);
			drawDot(pen, LEFT_DOMINO_TOP + LEFT_DOMINO_TOP / 5,
					LEFT_DOMINO_TOP / 2 - LEFT_DOMINO_TOP / 2 + LEFT_DOMINO_TOP / 10);
		}

	}

	/**
	 * Draws a die with three dots in the left or right side depending on the
	 * argument isLeft and one on the opposite side.
	 * 
	 * 
	 */

	private void drawThree(Graphics pen, boolean isLeft) {
		if (isLeft) {
			drawTwo(pen, true);
			drawOne(pen, true);

		} else {
			drawTwo(pen, false);
			drawOne(pen, false);
		}
	}

	/**
	 * Draws a die with four dots in the left or right side depending on the
	 * argument isLeft and two on the opposite side.
	 * 
	 * 
	 */

	private void drawFour(Graphics pen, boolean isLeft) {
		if (isLeft) {
			drawTwo(pen, true);
			drawDot(pen, LEFT_DOMINO_TOP - LEFT_DOMINO_TOP / 10, LEFT_DOMINO_TOP / 10);
			drawDot(pen, LEFT_DOMINO_TOP / 10, LEFT_DOMINO_TOP - LEFT_DOMINO_TOP / 5);
		} else {
			drawTwo(pen, false);
			drawDot(pen, LEFT_DOMINO_TOP + LEFT_DOMINO_TOP / 5, LEFT_DOMINO_TOP / 2 + LEFT_DOMINO_TOP / 4);
			drawDot(pen, LEFT_DOMINO_TOP * 2 - LEFT_DOMINO_TOP / 5,
					LEFT_DOMINO_TOP / 2 - LEFT_DOMINO_TOP / 2 + LEFT_DOMINO_TOP / 10);
		}

	}

	/**
	 * Draws a die with five dots in the left or right side depending on the
	 * argument isLeft and three on the opposite side.
	 * 
	 * 
	 */

	private void drawFive(Graphics pen, boolean isLeft) {
		if (isLeft) {
			drawFour(pen, true);
			drawOne(pen, true);
		} else {
			drawFour(pen, false);
			drawOne(pen, false);

		}

	}

	/**
	 * 
	 * Draw blank die using the x-position and y-position.
	 */

	private void drawBlank(Graphics pen) {

		/**
		 * draws rectangle for the background of the domino.
		 * 
		 */

		pen.setColor(Color.gray);
		pen.fillRect(xDominoPosition, yDominoPosition, LEFT_DOMINO_TOP * 2 + LEFT_DOMINO_TOP / 20,
				LEFT_DOMINO_TOP + LEFT_DOMINO_TOP / 20);

		/**
		 * fills front of rectangle white.
		 */

		pen.setColor(Color.white);
		pen.fillRect(xDominoPosition + LEFT_DOMINO_TOP / 20, yDominoPosition + LEFT_DOMINO_TOP / 20,
				LEFT_DOMINO_TOP * 2, LEFT_DOMINO_TOP + 2);

		/**
		 * draws outline of rectangle for the domino.
		 */

		pen.setColor(Color.black);
		pen.drawRect(xDominoPosition + LEFT_DOMINO_TOP / 20, yDominoPosition + LEFT_DOMINO_TOP / 20,
				LEFT_DOMINO_TOP * 2, LEFT_DOMINO_TOP);

		/**
		 * draws lines for the background of the domino
		 */
		pen.drawLine(xDominoPosition + LEFT_DOMINO_TOP + LEFT_DOMINO_TOP / 10, yDominoPosition + LEFT_DOMINO_TOP,
				xDominoPosition + LEFT_DOMINO_TOP + LEFT_DOMINO_TOP / 10, yDominoPosition);

	}

	/**
	 * Draws a red dot on the die in a centralized location based on center x
	 * and center y.
	 */

	private void drawDot(Graphics pane, int centerX, int centerY) {

		pane.setColor(Color.RED);
		pane.fillOval(xDominoPosition + centerX, yDominoPosition + centerY, LEFT_DOMINO_TOP / 6, LEFT_DOMINO_TOP / 6);

	}

	/**
	 * Validates the number from 1 to 5, and uses recursion to request valid
	 * info if not valid.
	 */

	public int numberValidation() {
		System.out.println("Please enter a value between 1 and 5 for the domino: ");
		usersValue = keyboard.nextInt();
		if (usersValue > 0 && usersValue <= 5) {
			return usersValue;
		} else {
			return numberValidation();
		}
	}

}
