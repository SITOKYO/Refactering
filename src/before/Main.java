/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package before;

public class Main {
    public static void main(String... args){
        
        Customer customer = new Customer("日本　太郎");
        customer.addRental(new Rental(new Movie("TwentyFour", Movie.REGULER), 7));
        customer.addRental(new Rental(new Movie("新作レンタル", Movie.NEW_RELRASE), 3));
        customer.addRental(new Rental(new Movie("アンパンマン", Movie.CHILDRENS), 5));
        
        System.out.println(customer.statement());
    }
    
}
