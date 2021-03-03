package de.buddelbubi.implementedcode.network;


import cn.nukkit.entity.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ScoreboardDisplay {

    /**
     * The api is from the server software GoMint (DISCONTINUED)
     */

    private  Scoreboard scoreboard;
    private  String objectiveName;
    private String displayName;
    private SortOrder sortOrder;

    public ScoreboardDisplay(Scoreboard scoreboard, String ob, String di, SortOrder so) {
    	this.scoreboard = scoreboard;
    	this.objectiveName = ob;
    	this.displayName = di;
    	this.sortOrder = so;
    }
    
    public DisplayEntry addEntity( Entity entity, int score ) {
        long scoreId = this.scoreboard.addOrUpdateEntity( entity, this.objectiveName, score );
        return new DisplayEntry( this.scoreboard, scoreId );
    }

    public DisplayEntry addLine( String line, int score ) {
        long scoreId = this.scoreboard.addOrUpdateLine( line, this.objectiveName, score );
        return new DisplayEntry( this.scoreboard, scoreId );
    }

    public void removeEntry( DisplayEntry entry ) {
        this.scoreboard.removeScoreEntry( entry.getScoreId() );
    }

	public String getObjectiveName() {
		
		return this.objectiveName;
	}

	public String getDisplayName() {
		
		return this.displayName;
	}

	public SortOrder getSortOrder() {
		
		return sortOrder;
	}

}