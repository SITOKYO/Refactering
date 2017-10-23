package after;

public class ChildrenType implements MovieType{

    @Override
    public int getCharge(int daysRented) {
        return  daysRented > 3 ? 150 + (daysRented - 3) * 15 : 150;
    }
    
    @Override
    public int getRentalPoints(int daysRented){
        return 1;
    }
}
