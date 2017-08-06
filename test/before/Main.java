/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package before;

import before.Customer;
import before.Movie;
import before.Rental;

/**
 *
 * @author kinopp
 */
public class Main {
    public static void main(String... args){
        //Rental rental1 = new Rental(new Movie("TwentyFour", 0), 7);        
        Rental rental2 = new Rental(new Movie("新作レンタル", 1), 1);        
        //Rental rental3 = new Rental(new Movie("アンパンマン", 2), 5);
        
        Customer customer = new Customer("木下　英樹");
        //customer.addRental(rental1);
        customer.addRental(rental2);
        //customer.addRental(rental3);
        
        System.out.println(customer.statement());
    }
    
}
