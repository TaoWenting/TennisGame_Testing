/* 
Wii Tennis 
A game is won by the first player to have won at least four points in total and at least two points more than the opponent. 
The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as "love", "fifteen", "thirty", and "forty" respectively. 
If at least three points have been scored by each player, and the scores are equal, the score is "deuce". 
If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is "advantage" for the player in the lead. 
*/

public class TennisGame {
   
    private static final int LOVE = 0;
    private static final int FIFTEEN = 1;
    private static final int THIRTY = 2;
    private static final int FORTY = 3;
    private static final int OVER_FORTY = 4;
	
	
	private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
   
    public TennisGame(String player1Name, String player2Name) {
        // TO BE IMPLEMENTED
        System.out.println("I am constructor");
        this.player1Name = player1Name;
        this.player2Name = player2Name;
       
    }

    public TennisGame() {
        // TO BE IMPLEMENTED
        System.out.println("I am constructor");
        m_score1 = 0;
        m_score2 = 0;
       
    }
	
	public String getScore() {
		System.out.println("I am method for displaying score");
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

        if (tie()) {
            return scoreForTie();
        } else if (possibleWin()) {
            return scoreForPossibleWin();
        }
        return scoreForNoTieAndNoWin();
    }	

    private static String nameFor(int score) {
    	
        if (score==FIFTEEN) {
            return Point.fifteen.name(); 
        }
        
        return Point.love.name();
    }

    private static enum Point {
        love(LOVE), fifteen(FIFTEEN), thirty(THIRTY), forty(FORTY), overforty(OVER_FORTY);
        private final int score;

        private Point(int score) {
            this.score = score;
        }
        
        public Point fromScore(int score) {
            return null;
        }
        
        
    }
   

    public void wonPoint(String playerName) throws TennisGameException{
        if (playerName == "player1") {
        	if(Math.abs(m_score1-m_score2)<4){
        		m_score1 += 1;
        		}
        	else{
        		throw new TennisGameException();
        	}
        } else {
        	if(Math.abs(m_score1-m_score2)<4){
        		m_score2 += 1;
        		}
        	else{
        		throw new TennisGameException();
        	}         
        }
    }

    public void player1Scored() throws TennisGameException{
    	if(Math.abs(m_score1-m_score2)<4){
    		m_score1 += 1;
    		}
    	else{
    		throw new TennisGameException();
    	}
        
    }
    
    public void player2Scored() throws TennisGameException{
    	if(Math.abs(m_score1-m_score2)<4){
    		m_score2 += 1;
    		}
    	else{
    		throw new TennisGameException();
    	}
        
    }

    private String scoreForNoTieAndNoWin() {
        String score = "";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = m_score1;
            } else {
                score += " - ";
                tempScore = m_score2;
            }
            switch (tempScore) {
                case LOVE:
                    score += nameFor(tempScore);
                    break;
                case FIFTEEN:
                    score += "15";
                    break;
                case THIRTY:
                    score += "30";
                    break;
                case FORTY:
                    score += "40";
                    break;
            }
        }
        return score;
    }

    private String scoreForPossibleWin() {
        String score;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) {
            score = "player1 has advantage";
        } else if (minusResult == -1) {
            score = "player2 has advantage";
        } else if (minusResult >= 2) {
            score = "player1 wins";
        } else {
            score = "player2 wins";
        }
        return score;
    }

    private String scoreForTie() {
        switch (m_score1) {
            case LOVE:
                return "love - love";
            case FIFTEEN:
                return "15 - 15";
            case THIRTY:
                return "30 - 30";
            case FORTY:
                return "deuce";
            default:
                return "deuce";
        }
    }

    private boolean tie() {
        return m_score1 == m_score2;
    }

    private boolean possibleWin() {
        return m_score1 >= OVER_FORTY || m_score2 >= OVER_FORTY;
    }
}