package de.buddelbubi.implementedcode.network.packet;
import cn.nukkit.network.protocol.DataPacket;
import lombok.Data;

@Data
public class SetObjectivePacket extends DataPacket {

    public static final byte NETWORK_ID = 0x6b;

    public String displaySlot;
    public String objectiveName;
    public String displayName;
    public String criteriaName;
    public int sortOrder;

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
        this.putString( this.displaySlot );
        this.putString( this.objectiveName );
        this.putString( this.displayName );
        this.putString( this.criteriaName );
        this.putVarInt( this.sortOrder );
    }

	public void setCriteriaName(String string) {
		this.putString( this.criteriaName );
	}

	public void setDisplayName(String string) {
		this.displayName = string;
		
	}

	public void setObjectiveName(String objectiveName) {
		this.objectiveName = objectiveName;
		
	}

	public void setDisplaySlot(String slot) {
		this.displaySlot = slot;
		
	}

	public void setSortOrder(int ordinal) {
	sortOrder = ordinal;
		
	}

	
}
