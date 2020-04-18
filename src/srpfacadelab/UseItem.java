package srpfacadelab;

import java.util.*;

public class UseItem {
    private final IGameEngine gameEngine;
    public UseItem(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }
    public void useItem(Item item, RpgPlayer player) {
        if (item.getName().equals("Stink Bomb")) {
            List<IEnemy> enemies = player.gameEngine.getEnemiesNear(player);

            for (IEnemy enemy : enemies) {
                enemy.takeDamage(100);
            }
        }
    }
}
