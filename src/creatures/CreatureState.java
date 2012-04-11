package creatures;

import players.Player;

public interface CreatureState {
	
	// Creature killed?
	void killedCreature(Creature creature, Player tueur);
    
    // Creature damaged?
    void damagedCreature(Creature creature);
    
    // Creature arrived? 
    void reachedCreature(Creature creature);

}
