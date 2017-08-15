/**
 * A class for an Item used in OnlineShopper
 *@author Alberto Fernandez Saucedo
 */
public class Item
{
    private String name;
    private double price;

    public Item()
    {
        this("", 0);
    }
    public Item(String name, int price)
    {
        this.name = name;
        this.price = (double) price / 100;
    }

    public String getProductName()
    {
        return name;
    }

    public void setProductName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = (double)price / 100;
    }

}
