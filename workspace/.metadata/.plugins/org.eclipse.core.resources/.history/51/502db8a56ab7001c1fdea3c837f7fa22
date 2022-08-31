package cop2805;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Geovanie Ruiz
 *
 */
public class SimpleCalc extends JPanel implements ActionListener {
	private String[] operations = { "Add", "Subtract", "Multiply", "Divide" };
	private JTextField firstNumber = new JTextField();
	private JTextField secondNumber = new JTextField();
	private JComboBox<String> operationList = new JComboBox<String>(operations);
	private JButton calculate = new JButton("Calculate");
	private JLabel result = new JLabel("Result is:");

	/**
	 * Default constructor
	 * Build the GUI using a GridLayout to organize components
	 */
	public SimpleCalc() {
		super(new GridLayout(5, 2));
        
        add(new JLabel("First Number:"));
        add(firstNumber);

        add(new JLabel("Second Number:"));
        add(secondNumber);

        // Use empty label to take up a Grid cell
        add(new JLabel());
        add(operationList);

        add(new JLabel());
        // Add an event listener to the button to trigger code when it's clicked
        calculate.addActionListener(this);
        add(calculate);
        
        add(result);
	}

	/**
	 * Calculate a result based on the chosen operation
	 * 
	 * @param operation the name of the operator to use
	 * @param firstOperand the left value
	 * @param secondOperand the right value
	 * @return the resultant value of the operation chosen
	 */
	private Double Calculate(String operation, Double firstOperand, Double secondOperand) {
		Double result = 0.0;
		switch(operation) {
			case "Add":
				result = firstOperand + secondOperand;
				break;
			case "Subtract":
				result = firstOperand - secondOperand;
				break;
			case "Multiply":
				result = firstOperand * secondOperand;
				break;
			case "Divide":
				result = firstOperand / secondOperand;
				break;
		}
		return result;
	}

	/**
	 * Update the text in the result label
	 * 
	 * @param value the value to display as the result
	 */
	private void UpdateResult(Double value) {
		result.setText(String.format("Result is: %s", value.toString()));
	}

	/**
	 * Event triggered when button is clicked; collects data from components
	 * to update result label
	 * 
	 * @param e contains information about the triggered ActionEvent
	 */
    public void actionPerformed(ActionEvent e) {
    	Double firstNumberValue = Double.parseDouble(firstNumber.getText());
    	Double secondNumberValue = Double.parseDouble(secondNumber.getText());
    	String operation = (String) operationList.getSelectedItem();
        UpdateResult(Calculate(operation, firstNumberValue, secondNumberValue));
    }
    
	/**
	 * Create GUI container and drop an instance of the calculator
	 */
	private static void constructGUI() {
        // Create a new Frame to contain the calculator
		JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // Create a content pane and add it to the frame
        JComponent newContentPane = new SimpleCalc();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        // Get frame size and determine the frame's screen position to put it in the center
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = 300;
        int frameHeight = 150;
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        int midHorizPosition = (screenWidth / 2) - (frameWidth / 2);
        int midVertPosition = (screenHeight / 2) - (frameHeight / 2);

        // Set frame size, screen position, and show the calculator interface
        frame.setBounds(midHorizPosition, midVertPosition, frameWidth, frameHeight);
        frame.setVisible(true);
    }
    
	/**
	 * Launch the Calculator GUI
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
                constructGUI();
            }
        });
    }
}