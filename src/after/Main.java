package after;

public class Main {
    public static void main(String... args) throws Exception{
        
        Customer customer = new Customer("日本　太郎");
        customer.addRental(new Rental(new Movie("TwentyFour", "RegulerType"), 7));
        customer.addRental(new Rental(new Movie("新作レンタル", "NewReleaseType"), 3));
        customer.addRental(new Rental(new Movie("アンパンマン", "ChildrenType"), 5));
        
        System.out.println(customer.getStatement());
        
    }
    
}
