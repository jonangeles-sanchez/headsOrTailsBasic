package edu.mhu.cs.jonathan.coinGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CoinGameGUI {

	public static void main(String[] args) {
		new CoinGameGUI().go();
	}
	
	private ButtonGroup radioGuess;
	private JFrame frame;
	private CoinGame cg;
	JLabel result;
	JLabel totalWins;
	JLabel totalLosses;
	JLabel winPercentage;
	JLabel totalGuesses;
	JTextField resultField;
	JTextField totalWinsField;
	JTextField totalLossField;
	JTextField winPercentageField;
	JTextField totalGuessesField;
	
	
	public void go() {
		frame = new JFrame("Coin Guessing Game");
		cg = new CoinGame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JRadioButton radioHeads = new JRadioButton("Heads");
		radioHeads.setActionCommand("0");
		JRadioButton radioTails = new JRadioButton("Tails");
		radioTails.setActionCommand("1");
		
		radioGuess = new ButtonGroup();
		radioGuess.add(radioHeads);
		radioGuess.add(radioTails);
		
		JPanel questionPanel = new JPanel();
		
		questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
		questionPanel.add(new JLabel("Take a guess... Heads or Tails?"));
		questionPanel.add(radioHeads);
		questionPanel.add(radioTails);
		
		JButton btnGuessSubmit = new JButton("Submit");
		btnGuessSubmit.addActionListener(new submitButtonListener());
		
		questionPanel.add(btnGuessSubmit);
		
		frame.getContentPane().add(BorderLayout.CENTER, questionPanel);
		
		JPanel statsPanel = new JPanel();
		statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
		result = new JLabel("Result: ");
		resultField = new JTextField(10);
		resultField.setEditable(false);
		
		totalWins = new JLabel("Total Wins: ");
		totalWinsField = new JTextField(10);
		totalWinsField.setEditable(false);
		
		
		totalLosses = new JLabel("Total Losses: ");
		totalLossField = new JTextField(10);
		totalLossField.setEditable(false);
		
		
		totalGuesses = new JLabel("Total Guesses: ");
		totalGuessesField = new JTextField(10);
		totalGuessesField.setEditable(false);
		
		winPercentage = new JLabel("Win Percentage: ");
		winPercentageField = new JTextField(10);
		winPercentageField.setEditable(false);
		
		statsPanel.add(result);
		statsPanel.add(resultField);
		
		statsPanel.add(totalWins);
		statsPanel.add(totalWinsField);
		
		statsPanel.add(totalLosses);
		statsPanel.add(totalLossField);
		
		statsPanel.add(totalGuesses);
		statsPanel.add(totalGuessesField);
		
		statsPanel.add(winPercentage);
		statsPanel.add(winPercentageField);
		
		frame.getContentPane().add(BorderLayout.EAST, statsPanel);
		
		frame.setSize(375,300);
		frame.setVisible(true);
		
		
	}
	
	class submitButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//String msg = radioGuess.getSelection().getActionCommand();
			//JOptionPane.showMessageDialog(null, msg);
			//String msg = cg.checkGuess(cg.flipCoin(), Integer.parseInt(radioGuess.getSelection().getActionCommand())) ? "You should've put some money on it, because you got it right!" : "Good thing you didn't bet... because you LOST!";
			if(radioGuess.isSelected(null)) {
				JOptionPane.showMessageDialog(frame, "Please select an option");
				return;
			}
			//String result = cg.checkGuess(cg.flipCoin(), Integer.parseInt(radioGuess.getSelection().getActionCommand())) ? "You got it right!" : "Incorrect guess!";
			String result = "";
			if(cg.checkGuess(cg.flipCoin(), Integer.parseInt(radioGuess.getSelection().getActionCommand()))) {
				result = "You got it right!";
				resultField.setBackground(Color.green);
			} else {
				result = "Incorrect guess!";
				resultField.setBackground(Color.red);
			}
			resultField.setText(result);
			totalWinsField.setText(String.valueOf(cg.getTotalCorrect()));
			totalLossField.setText(String.valueOf(cg.getTotalIncorrect()));
			totalGuessesField.setText(String.valueOf(cg.getTotalGuesses()));
			winPercentageField.setText(String.format("%.2f", cg.calcWinPerc()));
		}
		
	}

}
