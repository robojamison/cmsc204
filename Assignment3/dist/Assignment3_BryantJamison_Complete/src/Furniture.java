/**
 * The furniture data object
 *
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu) for CMSC 204 (R. Alexander) M/W 1PM-3PM
 */
public class Furniture
{
    private String name;
    protected String material;
    protected String color;

    /**
     * Creates a new furniture object
     */
    public Furniture()
    {
        name = null;
        color = null;
        material = null;
    }

    /**
     * Creates a new furniture object with properties
     *
     * @param name Furniture name
     * @param color Furniture color
     * @param material Furniture material
     */
    public Furniture(String name, String color, String material)
    {
        this.name = name;
        this.color = color;
        this.material = material;
    }

    /**
     * Returns the name of the furniture
     *
     * @return Furniture name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns a string representation of the piece of furniture
     *
     * @return String representation
     */
    public String toString()
    {
        return this.name;
    }
}
