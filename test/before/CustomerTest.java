package before;

import before.Customer;
import before.Movie;
import before.Rental;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class CustomerTest {
    
    public CustomerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetName() {
        Customer customer = new Customer("木下");
        assertThat(customer.getName(), is("木下"));
    }
    
    @Test
    public void testStatement01() {
        Rental rental1 = new Rental(new Movie("TwentyFour", 0), 7);        
        Rental rental2 = new Rental(new Movie("徳川家康", 1), 3);        
        Rental rental3 = new Rental(new Movie("アンパンマン", 2), 5);
        
        Customer customer = new Customer("日本　太郎");
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        assertThat(customer.statement(), is(
            "Rental Record for 日本　太郎\n" +
            "  TwentyFour  9.5\n" +
            "  徳川家康  9.0\n" +
            "  アンパンマン  4.5\n" +
            "Amount owed is 23.0\n" +
            "You earnd 4 frequent rental points"
        ));
    }
    
    @Test
    public void testStatement02() {
        Rental rental2 = new Rental(new Movie("新作レンタル", 1), 1);        
        
        Customer customer = new Customer("日本　太郎");
        customer.addRental(rental2);

        assertThat(customer.statement(), is(
            "Rental Record for 日本　太郎\n" +
            "  新作レンタル  3.0\n" +
            "Amount owed is 3.0\n" +
            "You earnd 1 frequent rental points"
        ));
    }
}
