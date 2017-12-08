package sulpovar.igor;

public interface SlotMachine {

	//@formatter:off
	/**
	 * Main simulation method
	 * Takes an investment size X and returns next size to an investment.
	 * Rules:
	 * 	Play 1-5: Returns value is X + Y which is evenly distributed value between 0.9X and 1.6X
	 *  Play 6-20: Returns X+Y as above but a randomly chosen play returns 0 and all subsequent palys return 0 
	 */
	//@formatter:on
	public abstract Play play(Play prevPlayTurn, double thisInvestmentSize);

}
