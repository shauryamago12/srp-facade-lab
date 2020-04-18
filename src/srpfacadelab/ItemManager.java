package srpfacadelab;

public class ItemManager {

    private final IGameEngine gameEngine;
    public ItemManager(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }
    public boolean pickUpItem(Item item, RpgPlayer player) {
        int weight = player.calculateInventoryWeight();
        if (weight + item.getWeight() > player.getCarryingCapacity())
            return false;
        if (item.isUnique() && player.checkIfItemExistsInInventory(item))
            return false;
        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            player.setHealth(player.getHealth() + item.getHeal());

            if (player.getHealth() > player.getMaxHealth())
                player.setHealth(player.getMaxHealth());

            if (item.getHeal() > 500) {
                player.gameEngine.playSpecialEffect("green_swirly");
            }
            return true;
        }
        if (item.isRare()) {
            if (item.isUnique())
                player.gameEngine.playSpecialEffect("blue_swirly");
            else
                player.gameEngine.playSpecialEffect("cool_swirly_particles");
        }
        player.inventory.add(item);

        player.calculateStats();

        return true;
    }
}
