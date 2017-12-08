package sulpovar.igor;

public class SlotMachineImpl implements SlotMachine {
	
	public final static int START_TO_PLAY = 5;
	public final static int GAMEOVER_LOW = START_TO_PLAY;
	public final static int GAMEOVER_HIH = 20;
	public final static double RETURN_LOW = 0.9;
	public final static double RETURN_HIGH = 1.6;
			
	@Override
	public Play play(Play prevPlayTurn, double thisInvestmentSize) {
		Play thisPlay = new Play();
		thisPlay.setInvestmentSize(thisInvestmentSize);
		thisPlay.setPlaySeqNum(prevPlayTurn.getPlaySeqNum() + 1);
		thisPlay.setGameOverSeqNum(prevPlayTurn.getGameOverSeqNum());
		
		if (prevPlayTurn.getStage() == PlayStage.START) {
			thisPlay.setReturnsSize(calcReturnsSize(thisInvestmentSize));
			if (thisPlay.getPlaySeqNum() < START_TO_PLAY) {
				thisPlay.setStage(PlayStage.START);
			} else {
				thisPlay.setStage(PlayStage.PLAY);
			}
		} else if (prevPlayTurn.getStage() == PlayStage.PLAY) {
			if (thisPlay.getPlaySeqNum() < prevPlayTurn.getGameOverSeqNum()) {
				thisPlay.setReturnsSize(calcReturnsSize(thisInvestmentSize));
				thisPlay.setStage(PlayStage.PLAY);
			} else {
				thisPlay.setReturnsSize(0);
				thisPlay.setStage(PlayStage.GAMEOVER);
			}
		} else if (prevPlayTurn.getStage() == PlayStage.GAMEOVER) {
			thisPlay.setReturnsSize(0);
			thisPlay.setStage(PlayStage.GAMEOVER);
		} else {
			throw new IllegalArgumentException("PlayStage of " + prevPlayTurn.getStage().name() + " is unknown. Please add to SlotMachineImpl class");
		}
		
		return thisPlay;
	}
	
	private double calcReturnsSize(double thisInvestmentSize) {
		double growthRange = RETURN_HIGH-RETURN_LOW;
		double growthModule = growthRange * Math.random();
		double growthRate = growthModule + RETURN_LOW;
		return (growthRate + RETURN_LOW) * thisInvestmentSize;
	}

}
