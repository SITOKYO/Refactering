package before;

import before.Movie;
import before.Rental;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RentalTest {
    
    public RentalTest() {
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
    public void testGetMovie() {
        Movie movie = new Movie("TwentyFour", 100);
        Rental rental = new Rental(movie, 7);
        assertThat(rental.getMovie().getTitle(), is("TwentyFour"));
        assertThat(rental.getMovie().getPriceCode(), is(100));
    }

    @Test
    public void testGetDaysRented() {
        Movie movie = new Movie("TwentyFour", 100);
        Rental rental = new Rental(movie, 7);
        assertThat(rental.getDaysRented(), is(7));
    }
    
}
