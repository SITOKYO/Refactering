package before;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
    private String name;
    private List rentals = new ArrayList();
    
    public Customer(String name){
        this.name = name;
    }
    
    public void addRental(Rental rental){
        rentals.add(rental);
    }
    
    public String getName() {
        return name;
    }
    
    public String statement(){
        int totalAmount = 0;
        int frequentRentalPoints = 0;
        Iterator iterator = rentals.iterator();
        String result = "Rental Record for " + getName() + "\n";
        while(iterator.hasNext()){
            int thisAmount = 0;
            Rental each = (Rental)iterator.next();
            
            // 一行ごとに金額を計算
            switch (each.getMovie().getPriceCode()){
                case Movie.REGULER:
                    thisAmount += 100;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 15;
                    break;
                case Movie.NEW_RELRASE:
                    thisAmount += each.getDaysRented() * 70;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 150;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 15;
                    break;
            }
            
            // レンタルポイントを加算
            frequentRentalPoints ++;
            
            // 新作を２日以上借りた場合はボーナスポイント
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELRASE) &&
                each.getDaysRented() > 1) frequentRentalPoints ++;
            
            // この貸し出しに関する数値の表示
            result += "  " + each.getMovie().getTitle() + "  " +
                String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        
        // フッター部分の追加
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earnd " + String.valueOf(frequentRentalPoints) +
            " frequent rental points";
        return result;
        
    }
    
    
}
