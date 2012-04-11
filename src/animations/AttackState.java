package animations;

import towers.Tower;
import creatures.Creature;

public interface AttackState
{
	public void endAttack(Tower attacker, Creature target);
}
