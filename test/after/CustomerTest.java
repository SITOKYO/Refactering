package after;

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
    public void testStatement01() throws Exception {
        Rental rental1 = new Rental(new Movie("TwentyFour", "RegulerType"), 7);        
        Rental rental2 = new Rental(new Movie("徳川家康", "NewReleaseType"), 3);        
        Rental rental3 = new Rental(new Movie("アンパンマン", "ChildrenType"), 5);
        
        Customer customer = new Customer("日本　太郎");
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        assertThat(customer.getStatement(), is(
            "Rental Record for 日本　太郎\n" +
            "  TwentyFour  175\n" +
            "  徳川家康  210\n" +
            "  アンパンマン  180\n" +
            "Amount owed is 565\n" +
            "You earnd 4 frequent rental points"
        ));
    }
    
    @Test
    public void testStatement02() throws Exception {
        Rental rental2 = new Rental(new Movie("新作レンタル", "NewReleaseType"), 1);        
        
        Customer customer = new Customer("日本　太郎");
        customer.addRental(rental2);

        assertThat(customer.getStatement(), is(
            "Rental Record for 日本　太郎\n" +
            "  新作レンタル  70\n" +
            "Amount owed is 70\n" +
            "You earnd 1 frequent rental points"
        ));
    }
}
