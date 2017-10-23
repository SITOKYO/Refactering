package after;

public class RegulerType implements MovieType{

    @Override
    public int getCharge(int daysRented) {
        return daysRented > 2 ? 100 + (daysRented - 2) * 15 : 100;
    }
    
    @Override
    public int getRentalPoints(int daysRented){
        return 1;
    }
}
