/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codigolimpio_1;

/**
 *
 * @author GSW1A22439390
 */
public class codigoSucio {
    public static void main(String[] args) {
        double price = 129.99;

        double discountPrice = calculateDiscount(price);
        double shippingPrice = calculateShipping(price);
    }
       
    private static double calculateShipping(double price) {
    	return price < 100 ? 4.99 : 0; // hard coded
        
    }

    private static double calculateDiscount(double price) {
        return price * 0.1;
    }
}