/**
 * This class contains JUnit tests for GuiaElectrodomestico class
 */
package homeappliance.test;

import homeappliance.HomeAppliance;
import org.junit.Test;
import static org.junit.Assert.*;

public class HomeApplianceTest {

    // constructors
    /**
     * Test for the constructor with default values and input price and weight.
     */
    @Test
    public void testConstructorWithDefaultValuesAndPriceAndWeight() {
        double basePrice = 200.0;
        double weight = 20.0;

        HomeAppliance instance = new HomeAppliance(basePrice, weight);

        assertEquals(HomeAppliance.getDefaultColor(), instance.getColor());
        assertEquals(HomeAppliance.getDefaultConsumption(), instance.getConsumption());
        assertEquals(basePrice, instance.getBasePrice(), 0.0);
        assertEquals(weight, instance.getWeight(), 0.0);
    }

    /**
     * Test for the constructor with default values. The default values are
     * constants.
     */
    @Test
    public void testConstructorWithDefaultValues() {
        HomeAppliance instance = new HomeAppliance();

        assertEquals(HomeAppliance.getDefaultColor(), instance.getColor());
        assertEquals(HomeAppliance.getDefaultConsumption(), instance.getConsumption());
        assertEquals(HomeAppliance.getDefaultBasePrice(), instance.getBasePrice(), 0.0);
        assertEquals(HomeAppliance.getDefaultWeight(), instance.getWeight(), 0.0);
    }

    /**
     * Test for the constructor with user input.
     */
    @Test
    public void testConstructorWithUserInput() {
        String color = "red";
        char consumo = 'A';
        double basePrice = 100.0;
        double weight = 10.0;

        HomeAppliance instance = new HomeAppliance(color, consumo, basePrice, weight);

        assertEquals(color, instance.getColor());
        assertEquals(consumo, instance.getConsumption());
        assertEquals(basePrice, instance.getBasePrice(), 0.0);
        assertEquals(weight, instance.getWeight(), 0.0);
    }

    // getters
    /**
     * Test the getter method for the color field.
     */
    @Test
    public void testGetColor() {
        String color = "red";
        HomeAppliance instance = new HomeAppliance(color, HomeAppliance.getDefaultConsumption(), HomeAppliance.getDefaultBasePrice(), HomeAppliance.getDefaultWeight());

        assertEquals(color, instance.getColor());
    }

    /**
     * Test the getter method for the consumption field.
     */
    @Test
    public void testGetConsumption() {
        char consumo = 'F';
        HomeAppliance instance = new HomeAppliance(HomeAppliance.getDefaultColor(), consumo, HomeAppliance.getDefaultBasePrice(), HomeAppliance.getDefaultWeight());

        assertEquals(consumo, instance.getConsumption());
    }

    /**
     *
     * Test the getter method for the basePrice field
     */
    @Test
    public void testGetBasePrice() {
        double precioBase = 200.0;
        HomeAppliance instance = new HomeAppliance(HomeAppliance.getDefaultColor(), HomeAppliance.getDefaultConsumption(), precioBase, HomeAppliance.getDefaultWeight());

        assertEquals(precioBase, instance.getBasePrice(), 0.01);
    }

    /**
     *
     * Test the getter method for the weight field
     */
    @Test
    public void testGetWeight() {
        // Create an instance of HomeAppliance with a specific peso
        double peso = 50.0;
        HomeAppliance instance = new HomeAppliance(HomeAppliance.getDefaultColor(), HomeAppliance.getDefaultConsumption(), HomeAppliance.getDefaultBasePrice(), peso);

        // Test that the getWeight() method returns the expected value
        assertEquals(peso, instance.getWeight(), 0.01);
    }

    ////////////// public methods
    /**
     * Test for the ValidateColor method with a valid color Valid colors:
     * "white", "black", "red", "blue", "gray"
     */
    @Test
    public void testValidateColorWithValidColor() {
        String color = "blue";
        HomeAppliance instance = new HomeAppliance(color, HomeAppliance.getDefaultConsumption(), HomeAppliance.getDefaultBasePrice(), HomeAppliance.getDefaultWeight());
        assertEquals(color, instance.getColor());
    }

    /**
     * Test for the ValidateColor method with a valid color Valid colors:
     * "white", "black", "red", "blue", "gray" and checks if case-insensitive
     */
    @Test
    public void testValidateColorWithValidColorCaseInsensitive() {
        String color = "BLUE";
        HomeAppliance instance = new HomeAppliance(color, HomeAppliance.getDefaultConsumption(), HomeAppliance.getDefaultBasePrice(), HomeAppliance.getDefaultWeight());
        assertEquals(color.toLowerCase(), instance.getColor());
    }

    /**
     * Test case to verify that an instance of HomeAppliance with an invalid color.
     * color should be the default color
     */
    @Test
    public void testValidateColorWithInvalidColor() {
        String color = "pink";
        HomeAppliance instance = new HomeAppliance(color, HomeAppliance.getDefaultConsumption(), HomeAppliance.getDefaultBasePrice(), HomeAppliance.getDefaultWeight());
        assertEquals(HomeAppliance.getDefaultColor(), instance.getColor());
    }

    /**
     * Test case to verify that an instance of HomeAppliance with a valid consumption
     */
    @Test
    public void testValidateConsumptionWithValidConsumption() {
        char consumo = 'A';
        HomeAppliance instance = new HomeAppliance(HomeAppliance.getDefaultColor(), consumo, HomeAppliance.getDefaultBasePrice(), HomeAppliance.getDefaultWeight());
        assertEquals(consumo, instance.getConsumption());
    }
    
    /**
     * Test case to verify that an instance of HomeAppliance with a valid
     * consumption but with the letter in lower case. The result should be in capital letter.
     */
    @Test
    public void testValidateConsumptionWithValidConsumptionCaseInsensiive() {
        char consumo = 'a';
        HomeAppliance instance = new HomeAppliance(HomeAppliance.getDefaultColor(), consumo, HomeAppliance.getDefaultBasePrice(), HomeAppliance.getDefaultWeight());
        assertEquals(Character.toUpperCase(consumo), instance.getConsumption());
    }
    
    /**
     * Test case to verify that an instance of HomeAppliance with an invalid
     * consumption has the default consumption.
     */
    @Test
    public void testValidateConsumptionWithInvalidConsumption() {
        char consumo = 'G';
        HomeAppliance instance = new HomeAppliance(HomeAppliance.getDefaultColor(), consumo, HomeAppliance.getDefaultBasePrice(), HomeAppliance.getDefaultWeight());
        assertEquals(HomeAppliance.getDefaultConsumption(), instance.getConsumption());
    }

    /**
     * Test case to verify that the calculateFinalPrice method returns the
     * correct price for an instance of HomeAppliance with consumption A and
     * weight 10.
     */
    @Test
    public void testCalculateFinalPriceWithConsumptionAAndWeight10() {
        HomeAppliance instance = new HomeAppliance(HomeAppliance.getDefaultColor(), 'A', HomeAppliance.getDefaultBasePrice(), 10);
        double expResult = HomeAppliance.getDefaultBasePrice() + 100 + 10;
        double result = instance.calculateFinalPrice();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test method to validate the calculation of the price of an instance of
     * GuiaElectrodomestico with consumption F and weight 30. The expected
     * result is the sum of the base price plus 10 (for consumption F) plus 50
     * (for weight). The result is compared with the expected value with a delta
     * of 0.01.
     */
    @Test
    public void testFinalPriceWithConsumptionFAndWeight30() {
        HomeAppliance instance = new HomeAppliance(HomeAppliance.getDefaultColor(), 'F', HomeAppliance.getDefaultBasePrice(), 30);
        double expResult = HomeAppliance.getDefaultBasePrice() + 10 + 50;
        double result = instance.calculateFinalPrice();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test method to validate the calculation of the price of an instance of
     * GuiaElectrodomestico with consumption C and weight 60. The expected
     * result is the sum of the base price plus 60 (for the weight between 50
     * and 79) plus 80 (for the weight above 79). The result is compared with
     * the expected value with a delta of 0.01.
     */
    @Test
    public void testFinalPriceWithConsumptionCAndWeight60() {
        HomeAppliance instance = new HomeAppliance(HomeAppliance.getDefaultColor(), 'C', HomeAppliance.getDefaultBasePrice(), 60);
        double expResult = HomeAppliance.getDefaultBasePrice() + 60 + 80;
        double result = instance.calculateFinalPrice();
        assertEquals(expResult, result, 0.01);
    }

    /**
     *
     * Tests the calculateFinalPrice method of the Electrodomestico class with
     * color 'C' and weight of 81. It creates an instance of Electrodomestico
     * using the default color and base price, and sets the consumption to 'C'
     * and weight to 81. It then calculates the expected result by adding the
     * default base price, the price corresponding to consumption 'C', and the
     * price corresponding to a weight of 81. The method asserts that the result
     * returned by calculateFinalPrice is equal to the expected result with a
     * tolerance of 0.01.
     */
    @Test
    public void testFinalPriceWithConsumptionCAndWeight81() {
        HomeAppliance instance = new HomeAppliance(HomeAppliance.getDefaultColor(), 'C', HomeAppliance.getDefaultBasePrice(), 81);
        double expResult = HomeAppliance.getDefaultBasePrice() + 60 + 100;
        double result = instance.calculateFinalPrice();
        assertEquals(expResult, result, 0.01);
    }

}
