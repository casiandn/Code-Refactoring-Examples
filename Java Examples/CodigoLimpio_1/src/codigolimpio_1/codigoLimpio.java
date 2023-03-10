package codigolimpio_1;

/**
 * This class provides methods for calculating the shipping tax and discount price.
 */
public class codigoLimpio {

    private static final double SHIPPING_TAX = 4.59;
    private static final double MAX_PRICE_TAXED = 100.0;
    private static final double DISCOUNT_RATE = 0.10;

    public static void main(String[] args) {
        double price = 129.99;
        double discountPrice = calculateDiscountOfShipping(price);
        double shippingPrice = calculateShippingTax(price);
    }

    /**
     * Calculates the tax of the shipping based on the price of the item.
     *
     * @param price the base price of the item.
     * @return the shipping tax calculated based on the price of the item.
     */
    private static double calculateShippingTax(double price) {
        double shippingTax = 0.0;
        if (price > MAX_PRICE_TAXED) {
            shippingTax = SHIPPING_TAX;
        }
        return shippingTax;
    }

    /**
     * Calculates the discount price based on the total price of the item and the shipping tax.
     *
     * @param totalPrice the total price of the item including the shipping tax.
     * @return the discount price calculated based on the total price of the item and the shipping tax.
     */
    private static double calculateDiscountOfShipping(double totalPrice) {
        double discount = totalPrice * DISCOUNT_RATE;
        double discountPrice = totalPrice - discount;
        return discountPrice;
    }
}
