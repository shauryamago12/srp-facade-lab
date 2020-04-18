package srpfacadelab;
import java.util.*;

public class RpgPlayerFacade {

    public static final int MAX_CARRYING_CAPACITY = 1000;
    private final IGameEngine gameEngine;
    private List<Item> inventory;
    private UseItem use;
    private ItemManager pick;
    private int carryingCapacity;

    public RpgPlayerFacade(IGameEngine gameEngine) {
        RpgPlayer player;
        this.gameEngine = gameEngine;
        inventory = new ArrayList<Item>();
        carryingCapacity = MAX_CARRYING_CAPACITY;
        use = new UseItem(gameEngine);
        pick = new ItemManager(gameEngine);
    }

    public void useItem(Item item, RpgPlayer player) {
        use.useItem(item, player);
    }

    public boolean pickUpItem(Item item, RpgPlayer player) {
        return pick.pickUpItem(item, player);
    }
}


