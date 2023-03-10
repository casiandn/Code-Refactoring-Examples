/**
 *
 * This class represents an electrical appliance. It has properties such as its color, energy efficiency rating,
 *
 * base price, and weight. It also has methods to calculate the final price of the appliance based on these properties.
 */
package homeappliance;

public class HomeAppliance {

    /**
     * *
     * Define the constants that determine what the default values are. When you
     * want to refer to these values, you only have to write the name.
     */
    //DEFAULT CONSTANTS
    private final static String DEFAULT_COLOR = "white";
    private final static char DEFAULT_CONSUMPTION = 'F';
    private final static double DEFAULT_BASEPRICE = 100;
    private final static double DEFAULT_WEIGHT = 5;

    //Class attribute
    private static String colors[] = {"white", "black", "red", "blue", "gray"};

    //ATTRIBUTES
    private String color;
    private char consumption;
    private double basePrice;
    private double weight;

    //CONSTRUCTORS
    /**
     * Constructor that initializes the object attributes with the passed
     * parameters. If the color or consumption is not valid, the default values
     * are set.
     *
     * @param color the color of the electrical appliance
     * @param consumption the consumption of the electrical appliance
     * @param basePrice the base price of the electrical appliance
     * @param weight the weight of the electrical appliance
     */
    public HomeAppliance(String color, char consumption, double basePrice, double weight) {
        this.color = validateColor(color);
        this.consumption = validateConsumption(consumption);
        this.basePrice = basePrice;
        this.weight = weight;
    }

    /**
     * Constructor that initializes the object attributes with the default
     * values.
     */
    public HomeAppliance() {
        this(DEFAULT_COLOR, DEFAULT_CONSUMPTION, DEFAULT_BASEPRICE, DEFAULT_WEIGHT);
    }

    /**
     * Constructor that initializes the object attributes with the default
     * values, except for the base price and weight.
     *
     * @param basePrice the base price of the electrical appliance
     * @param weight the weight of the electrical appliance
     */
    public HomeAppliance(double basePrice, double weight) {
        this(DEFAULT_COLOR, DEFAULT_CONSUMPTION, basePrice, weight);
    }

    //PUBLIC METHODS
    /**
     * Method that returns the color of the electrical appliance.
     *
     * @return the color of the electrical appliance
     */
    public String getColor() {
        return color;
    }

    /**
     * Method that returns the consumption of the electrical appliance.
     *
     * @return the consumption of the electrical appliance
     */
    public char getConsumption() {
        return consumption;
    }

    /**
     * Method that returns the base price of the electrical appliance.
     *
     * @return the base price of the electrical appliance
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Returns the weight of the electrical appliance.
     *
     * @return the weight of the electrical appliance
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the default color for an HomeAppliance instance.
     *
     * @return the default color
     */
    public static String getDefaultColor() {
        return DEFAULT_COLOR;
    }

    /**
     * Returns the default consumption for an HomeAppliance instance.
     *
     * @return the default consumption
     */
    public static char getDefaultConsumption() {
        return DEFAULT_CONSUMPTION;
    }

    /**
     * Returns the default base price for an HomeAppliance instance.
     *
     * @return the default base price
     */
    public static double getDefaultBasePrice() {
        return DEFAULT_BASEPRICE;
    }

    /**
     * Returns the default weight for an HomeAppliance instance.
     *
     * @return the default weight
     */
    public static double getDefaultWeight() {
        return DEFAULT_WEIGHT;
    }

    /**
     * Calculates the final price of the appliance.
     *
     * @return the final price of the appliance
     */
    public double calculateFinalPrice() {
        double consumptionSurcharge = calculateConsumptionSurcharge(consumption);
        double weightSurcharge = calculateWeightSurcharge(weight);
        return basePrice + consumptionSurcharge + weightSurcharge;
    }

    /**
     *
     * Calculates the consumption surcharge of the appliance.
     *
     * @param consumption the consumption of the appliance
     * @return the consumption surcharge of the appliance
     */
    private double calculateConsumptionSurcharge(char consumption) {
        double surcharge = 0;
        switch (consumption) {
            case 'A' ->
                surcharge += 100;
            case 'B' ->
                surcharge += 80;
            case 'C' ->
                surcharge += 60;
            case 'D' ->
                surcharge += 50;
            case 'E' ->
                surcharge += 30;
            case 'F' ->
                surcharge += 10;
        }
        return surcharge;
    }

    /**
     *
     * Calculates the weight surcharge of the appliance.
     *
     * @param weight the weight of the appliance
     * @return the weight surcharge of the appliance
     */
    private double calculateWeightSurcharge(double weight) {
        double surcharge = 0;
        if (weight >= 0 && weight < 19) {
            surcharge += 10;
        } else if (weight >= 20 && weight < 49) {
            surcharge += 50;
        } else if (weight >= 50 && weight <= 79) {
            surcharge += 80;
        } else if (weight >= 80) {
            surcharge += 100;
        }
        return surcharge;
    }

    /**
     *
     * Checks if the color of the appliance is within the available colors, if
     * not it returns the default color.
     *
     * @param color the color of the appliance
     * @return the color of the appliance if available, otherwise the default
     * color
     */
    private String validateColor(String color) {
        for (int i = 0; i < colors.length; i++) {
            if (colors[i].equals(color)) {
                return color;
            }
        }
        return DEFAULT_COLOR;
    }

    /**
     *
     * Checks if the consumption of the appliance is within the available
     * consumptions, if not it returns the default consumption.
     *
     * @param consumption the consumption of the appliance
     * @return the consumption of the appliance if available, otherwise the
     * default consumption
     */
    private char validateConsumption(char consumption) {
        if (consumption >= 'A' && consumption <= 'F') {
            return consumption;
        }
        return DEFAULT_CONSUMPTION;
    }
}
