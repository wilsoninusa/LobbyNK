package de.buddelbubi.implementedcode.network;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DisplayEntry {

    private final Scoreboard scoreboard = new Scoreboard();
    private final long scoreId = 0;
    
 

    public void setScore( int score ) {
        this.scoreboard.updateScore( this.scoreId, score );
    }

    public int getScore() {
        return this.scoreboard.getScore( this.scoreId );
    }

	public long getScoreId() {
	
		return this.scoreId;
	}

	public DisplayEntry(Scoreboard scoreboard2, long scoreId2) {
		// TODO Auto-generated constructor stub
	}

}