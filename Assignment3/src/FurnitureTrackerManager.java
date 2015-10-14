import javax.swing.*;
import java.io.*;

/**
 * Application data class
 *
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu) for CMSC 204 (R. Alexander) M/W 1PM-3PM
 */
public class FurnitureTrackerManager
{
    private boolean initialized;
    private Factory factory;
    private Factory location;
    private Truck truck;
    private Store store1;
    private Store store2;
    private Store store3;
    private Store store4;

    public FurnitureTrackerManager()
    {
        factory = new Factory("Factory");
        location = factory;
        truck = new Truck(location);
        store1 = new Store("Wal-Mart");
        store2 = new Store("Sam's Club");
        store3 = new Store("BJ's");
        store4 = new Store("Big Lots");
    }

    /**
     * Creates a new furniture tracker
     *
     * @param file Furniture data file
     */
    public void newFurnitureTracker(File file)
    {
        // Create truck
        truck = new Truck();

        // Read furniture file
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            String[] contents;

            while ((line = br.readLine()) != null) {
                // Parse line contents into array
                contents = line.split(",");

                try {
                    // Create furniture object
                    Furniture f = new Furniture(contents[0], contents[1], contents[2]);

                    // Add furniture to factory
                    factory.addFurniture(f);
                } catch(ArrayIndexOutOfBoundsException e) {
                    System.err.println("Error: Exception occurred while parsing file");
                    e.printStackTrace();
                    GUI.displayError("An error occurred while parsing the file", true);
                }
            }
        } catch (IOException e) {
            System.err.println("Error: Exception occurred while reading file");
            e.printStackTrace();
            GUI.displayError("An error occurred while reading the file", true);
        }
    }

    /**
     * Returns an array of the furniture in a factory
     *
     * @param factory Factory to get furniture of
     * @return Furniture in factory
     */
    public Furniture[] getFurnitures(Factory factory)
    {
        return factory.getFurnitures();
    }

    /**
     * ???
     *
     * @throws WrongLocationException ???
     * @throws TruckLoadException ???
     * @return ???
     */
    public Furniture[] loadTruck() throws WrongLocationException, TruckLoadException
    {
        if (truck.getLocation().equals(factory)) {
            if (truck.toArray().length < 10) {
                // ???
            } else {
                throw new TruckLoadException("Unable to load new furniture onto full truck");
//                GUI.displayError("The truck cannot be loaded because it is full", false);
            }
        } else {
            throw new WrongLocationException("Unable to load truck at non-factory location");
//            GUI.displayError("The truck can only be loaded at the factory", false);
        }

        return null;
    }

    /**
     * Unloads the manager's truck into one of the manager's stores
     *
     * @param store The store to unload the truck into
     * @throws WrongLocationException ???
     * @throws TruckLoadException ???
     * @return ???
     */
    public Furniture[] unloadTruck(Store store) throws WrongLocationException, TruckLoadException
    {
        return new Furniture[0];
    }

    /**
     * Adds a piece of furniture to the manager's factory
     *
     * @param furniture Piece of furniture to add
     */
    public void addFurnitureToFactory(Furniture furniture)
    {
        factory.addFurniture(furniture);
    }

    /**
     * Moves the manager's truck to the next location
     *
     * @throws FurnitureTrackerNotInitializedException If furniture tracker is not initialized
     */
    public void dispatchTruck() throws FurnitureTrackerNotInitializedException
    {
        if (initialized) {

        } else {
            throw new FurnitureTrackerNotInitializedException("Action attempted before tracker initialized");
        }
    }

    /**
     * Returns the manager's truck's current location
     *
     * @return Truck location
     */
    public Factory getTruckLocation()
    {
        return location;
    }

    /**
     * Returns the manager's truck object
     *
     * @return Truck object
     */
    public Truck getTruck()
    {
        return truck;
    }

    /**
     * Returns the manager's factory object
     *
     * @return Factory object
     */
    public Factory getFactory()
    {
        return factory;
    }

    /**
     * Returns the first of the manager's store objects
     *
     * @return 1st store object
     */
    public Store getStore1()
    {
        return store1;
    }

    /**
     * Returns the second of the manager's store objects
     *
     * @return 2nd store object
     */
    public Store getStore2()
    {
        return store2;
    }

    /**
     * Returns the third of the manager's store objects
     *
     * @return 3rd store object
     */
    public Store getStore3()
    {
        return store3;
    }

    /**
     * Returns the fourth of the manager's store objects
     *
     * @return 4th store object
     */
    public Store getStore4()
    {
        return store4;
    }

    public boolean isInitialized()
    {
        return initialized;
    }
}