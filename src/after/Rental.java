package after;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Rental {

    private final Movie movie;
    private final int daysRented;
    
    public Rental(Movie movie, int daysRented){
        this.movie = movie;
        this.daysRented = daysRented;
    }
    
    public Movie getMovie() {
        return movie;
    }
    
    public int getCharge() {
        int charge = 0;
        try {
            charge = movie.getMovieTypeInstance().getCharge(daysRented);
        } catch (Exception ex) {
            Logger.getLogger(Rental.class.getName()).log(Level.SEVERE, null, ex);
        }
        return charge;
    }
    
    public int getRentalPoints(){
        int rentalPoints = 0;
        try {
            rentalPoints = movie.getMovieTypeInstance().getRentalPoints(daysRented);
        } catch (Exception ex) {
            Logger.getLogger(Rental.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rentalPoints;
    }
    
    @Override
    public String toString(){
        return
        "movie:" + movie + "\n" +
        "daysRented:" + daysRented + "\n";
    }
      
}
