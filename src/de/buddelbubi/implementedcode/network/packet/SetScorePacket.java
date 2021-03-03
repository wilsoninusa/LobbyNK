package de.buddelbubi.implementedcode.network.packet;

import cn.nukkit.network.protocol.DataPacket;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class SetScorePacket extends DataPacket {

    public static final byte NETWORK_ID = 0x6c;

    private byte type;
    private List<ScoreEntry> entries;

    @Override
    public byte pid() {
        return NETWORK_ID;
        
    }

    @Override
    public void decode() {
        //Ignore
    }

    @Override
    public void encode() {
        this.reset();
        this.putByte( this.type );
        this.putUnsignedVarInt( this.entries.size() );

        for ( ScoreEntry entry : this.entries ) {
            this.putVarLong( entry.scoreId );
            this.putString( entry.objective );
            this.putLInt( entry.score );

            this.putByte( entry.entityType );

            if(entry.getEntityType() == 1 && entry.getEntityType() == 2){
                this.putUnsignedVarLong( entry.entityId );

            } else if(entry.getEntityType() == 3){
                this.putString( entry.fakeEntity );
            }
        }
    }

    @Getter
    @ToString
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class ScoreEntry {
        private  long scoreId;
        private  String objective;
        private  int score;

        // Add entity type
        private byte entityType;
        private String fakeEntity;
        private long entityId;
		public ScoreEntry(long scoreId2, String string, int i) {
			scoreId = scoreId2;
			objective = string;
			score = i;
		}
		public ScoreEntry(long longKey, String objective2, int score2, byte type, String fakeName, long entityId2) {
			scoreId = longKey;
			objective = objective2;
			score = score2;
			entityType = type;
			fakeEntity = fakeName;
			entityId = entityId2;
		}
		public int getEntityType() {
			
			return entityType;
		}
    }

	public void setType(byte b) {
		this.type = b;
		
	}

	public void setEntries(ArrayList<ScoreEntry> arrayList) {
		this.entries = arrayList;
		
	}

	public void setEntries(List<ScoreEntry> entries2) {
		this.entries = entries2;
		
	}
}