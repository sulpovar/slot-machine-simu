package sulpovar.igor;

public class SlotMachineSimuMain {

	public static void main(String[] args) {
		
		SlotMachine machine = new SlotMachineImpl();
		
		Play beginPlay = new Play();
		beginPlay.setStage(PlayStage.START);
		beginPlay.setPlaySeqNum(0);
		beginPlay.setInvestmentSize(1);
		beginPlay.setReturnsSize(1);
		beginPlay.setGameOverSeqNum(calcGameOverSeqNum(SlotMachineImpl.GAMEOVER_LOW,SlotMachineImpl.GAMEOVER_HIH));
		
		Play thisPlayTurn = beginPlay;
		double totalProfit = 0.0;
		for (int i = 0; i < SlotMachineImpl.GAMEOVER_HIH; i++) {
			double totalMoney = thisPlayTurn.getReturnsSize();
			double nextInvestment = calculateNextInvestment(totalMoney);
			totalProfit += totalMoney - nextInvestment;
			thisPlayTurn = machine.play(thisPlayTurn, nextInvestment);
		}

		System.out.println("Resulting return is " + totalProfit);
	}

	private static double calculateNextInvestment(double totalMoney) {
		double nextInvestment = totalMoney * 0.1;
		return nextInvestment;
	}
	
	private static int calcGameOverSeqNum(int gameOverFrom, int gameOverTo) {
		return (int) Math.round(Math.random() * (gameOverTo - gameOverFrom)) + gameOverFrom;
	}

}
