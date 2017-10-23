package after;

public class NewReleaseType implements MovieType{

    @Override
    public int getCharge(int daysRented) {
         return daysRented * 70;
    }
    
    @Override
    public int getRentalPoints(int daysRented){
        return daysRented > 1 ? 2 : 1;
    }
    
}
