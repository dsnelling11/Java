import java.awt.*;

/**
 * This is the domino panel that contains the constructor for my domino program
 * 
 * @author Darries Snelling
 *
 */
public class DominoPanel extends Frame {

	/**
	 * This is a instantiation of the domino datatype used to paint
	 */

	private Domino myDomino = new Domino();// domino object

	/**
	 * Constuctor used to intialize screen window specifics: size, location, and
	 * background.
	 */

	public DominoPanel() {
		setSize(600, 500);
		setLocation(100, 100);
		setTitle("Domino");
		setBackground(Color.white);

		setVisible(true);
		repaint(); // update the domino drawing
	}

	/**
	 * paint method used to draw the domino object
	 */

	public void paint(Graphics pen) {

		myDomino.paint(pen);
	}

}
