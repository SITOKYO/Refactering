package before;

import before.Movie;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MovieTest {
    
    public MovieTest() {
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
    public void testGetTitle() {
        Movie movie = new Movie("TwentyFour", 100);
        assertThat(movie.getTitle(), is("TwentyFour"));
    }

    @Test
    public void testGetPriceCode() {
        Movie movie = new Movie("TwentyFour", 100);
        assertThat(movie.getPriceCode(), is(100));
    }

    @Test
    public void testSetPriceCode() {
        Movie movie = new Movie("TwentyFour", 100);
        movie.setPriceCode(200);
        assertThat(movie.getPriceCode(), is(200));
    }
    
}
