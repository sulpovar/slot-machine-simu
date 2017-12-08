package sulpovar.igor;

public class Play {
	private double investmentSize;
	private double returnsSize;
	private int playSeqNum;
	private PlayStage stage;
	private int gameOverSeqNum;
	
	public Play() {
		
	}
	public Play(double investmentSize, int playSeqNum, int gameOverSeqNum) {
		this.playSeqNum = playSeqNum;
		this.investmentSize = investmentSize;
		this.gameOverSeqNum = gameOverSeqNum;
	}
	public double getInvestmentSize() {
		return investmentSize;
	}
	public void setInvestmentSize(double investmentSize) {
		this.investmentSize = investmentSize;
	}
	public double getReturnsSize() {
		return returnsSize;
	}
	public void setReturnsSize(double returnsSize) {
		this.returnsSize = returnsSize;
	}
	public int getPlaySeqNum() {
		return playSeqNum;
	}
	public void setPlaySeqNum(int playSeqNum) {
		this.playSeqNum = playSeqNum;
	}
	public PlayStage getStage() {
		return stage;
	}
	public void setStage(PlayStage stage) {
		this.stage = stage;
	}
	public int getGameOverSeqNum() {
		return gameOverSeqNum;
	}
	public void setGameOverSeqNum(int gameOverSeqNum) {
		this.gameOverSeqNum = gameOverSeqNum;
	}

}
