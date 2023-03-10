package homeappliance;

/**
 *
 * @author GSW1A46732958
 */
public class homeappliance {

    private final static String COLOR = "white";
    private final static char CONSUMPTION = 'F';
    private final static double BASE_PRICE = 100;
    private final static double WEIGHT = 5;

    private String color;
    private char consumption;
    private double basePrice;
    private double weight;

    private static String colors[] = {"white", "black", "red", "blue", "gray"};

    public homeappliance(String color, char consumption, double basePrice, double weight) {
        checkColor(color);
        checkConsumption(consumption);
        this.basePrice = basePrice;
        this.weight = weight;
    }

    // Default
    public homeappliance() {
        this(COLOR, CONSUMPTION, BASE_PRICE, WEIGHT);
    }

    
    // With price and weight
    public homeappliance(double basePrice, double weight) {
        this(COLOR, CONSUMPTION, basePrice, weight);
    }

    private void checkColor(String color) {

        String colors[] = {"white", "black", "red", "blue", "gray"};
        boolean found = false;

        for (int i = 0; i < colors.length && !found; i++) {
            if (colors[i].equals(color)) {
                found = true;
            }
        }
        if (found) {
            this.color = color;
        } else {
            this.color = COLOR;
        }
    }

    private void checkConsumption(char consumption) {
        if (consumption >= 'A' && consumption <= 'F') {
            this.consumption = consumption;
        } else {
            this.consumption = CONSUMPTION;
        }
    }

    public String getColor() {
        return color;
    }

    public char getConsumption() {
        return consumption;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getWeight() {
        return weight;
    }

    public double finalPrice() {
        double additionalCost = 0;
        switch (consumption) {
        case 'A':
        additionalCost += 100;
        break;
        case 'B':
        additionalCost += 80;
        break;
        case 'C':
        additionalCost += 60;
        break;
        case 'D':
        additionalCost += 50;
        break;
        case 'E':
        additionalCost += 30;
        break;
        case 'F':
        additionalCost += 10;
        break;
        }

        if (weight >= 0 && weight < 19) {
        additionalCost += 10;
        } else if (weight >= 20 && weight < 49) {
        additionalCost += 50;
        } else if (weight >= 50 && weight <= 79) {
        additionalCost += 80;
        } else if (weight >= 80) {
        additionalCost += 100;
        }

        return basePrice + additionalCost;
    }
    
}
