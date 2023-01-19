package edu.mhu.cs.jonathan.coinGame;

public class CoinGame {

	private int userGuess;
	private int totalGuesses;
	private int totalCorrect;
	private int totalIncorrect;
	private double winLossRatio;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int flipCoin() {
		return (int) Math.round(Math.random());
	}
	
	public Boolean checkGuess(int result, int userGuess) {
		totalGuesses++;
		if(result == userGuess) {
			totalCorrect++;
			return true;
		}
		totalIncorrect++;
		return false;
	}
	
	public double calcWinPerc() {
		winLossRatio = (double) getTotalCorrect()/(double) getTotalGuesses();
		return winLossRatio;
	}

	public int getUserGuess() {
		return userGuess;
	}

	public void setUserGuess(int userGuess) {
		this.userGuess = userGuess;
	}

	public int getTotalGuesses() {
		return totalGuesses;
	}

	public void setTotalGuesses(int totalGuesses) {
		this.totalGuesses = totalGuesses;
	}

	public int getTotalCorrect() {
		return totalCorrect;
	}

	public void setTotalCorrect(int totalCorrect) {
		this.totalCorrect = totalCorrect;
	}

	public int getTotalIncorrect() {
		return totalIncorrect;
	}

	public void setTotalIncorrect(int totalIncorrect) {
		this.totalIncorrect = totalIncorrect;
	}

	public double getWinLossRatio() {
		return winLossRatio;
	}

	public void setWinLossRatio(double winLossRatio) {
		this.winLossRatio = winLossRatio;
	}
	
	

}
