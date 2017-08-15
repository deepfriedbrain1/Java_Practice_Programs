/**
 * A class that maintains a shopping cart for an online store.
 * @author Alberto Fernandez Saucedo
 */
public class OnlineShopper
{
    public static void main(String[] args)
    {
        Item[] items = {new Item("Bird feeder", 2050),
                        new Item("Squirrel guard", 1547),
                        new Item("Bird bath", 4499),
                        new Item("Sunflower seeds", 1295)};

        BagInterface<Item> shoppingCart = new Bag<>();
        double totalCost = 0;

        for(int i = 0; i < items.length; i++)
        {
            Item nextItem = items[i];
            shoppingCart.add(nextItem);
            totalCost = totalCost + nextItem.getPrice();
        }

        while(!shoppingCart.isEmpty())
        {
            System.out.println(shoppingCart.remove());
            System.out.println("Total cost: " + "\t$" + totalCost);
        }
    }
}
