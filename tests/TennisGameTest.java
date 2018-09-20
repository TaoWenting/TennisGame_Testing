import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TennisGameTest {
	

	// Here is the format of the scores: "player1Score - player2Score"
		// "love - love"
		// "15 - 15"
		// "30 - 30"
		// "deuce"
		// "15 - love", "love - 15"
		// "30 - love", "love - 30"
		// "40 - love", "love - 40"
		// "30 - 15", "15 - 30"
		// "40 - 15", "15 - 40"
		// "player1 has advantage"
		// "player2 has advantage"
		// "player1 wins"
		// "player2 wins"

	@Before
	public void setUp() throws Exception {
	}

	// "love - love"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}

	// "15 - 15"
	@Test
	public void testTennisGame_fiftytofifty() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score incorrect", "15 - 15", score);
	}
	
	//"15 - love"
	@Test
	public void testTennisGame_fiftytolove() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		
		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score incorrect", "15 - love", score);
	}
	
	//"deuce"
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);
	}
	
	
	//"love - 15"
	@Test
	public void testTennisGame_loveto15() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "love - 15", score);
	}
	
	//"30 - love"
	@Test
	public void testTennisGame_30tolove() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "30 - love", score);
	}
	
	//"love - 30"
	@Test
	public void testTennisGame_loveto30() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "love - 30", score);
	}
	
	//"40 - love"
	@Test
	public void testTennisGame_40tolove() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "40 - love", score);
	}
	
	//"love - 40"
	@Test
	public void testTennisGame_loveto40() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "love - 40", score);
	}
	
	//"30 - 15"
	@Test
	public void testTennisGame_30to15() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "30 - 15", score);
	}
	
	//"15 - 30"
	@Test
	public void testTennisGame_15to30() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "15 - 30", score);
	}
	
	//"40 - 15"
	@Test
	public void testTennisGame_40to15() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "40 - 15", score);
	}
	
	//"15 - 40"
	@Test
	public void testTennisGame_15to40() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "15 - 40", score);
	}

	//"player1 has advantage"
	@Test
	public void testTennisGame_player1hasadvantage() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "player1 has advantage", score);
	}
	
	//"player2 has advantage"
	@Test
	public void testTennisGame_player2hasadvantage() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "player2 has advantage", score);
	}
	
	//"player1 wins"
	@Test
	public void testTennisGame_player1wins() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "player1 wins", score);
	}
	
	//"player2 wins"
	@Test
	public void testTennisGame_player2wins() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "player2 wins", score);
	}
	
	
	
	//TennisGameException
	@Test  (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();
		
	}
	
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();
		
	}
		
}
