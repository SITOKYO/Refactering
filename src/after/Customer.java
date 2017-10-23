package after;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList();
    
    Customer(String customerName){
        this.name = customerName;
    }
    
    /**
     * レンタルするビデオを追加する
     * <br>　レンタル１件ごとに、当メソッドを実行する
     * @param rental レンタルビデオ1件
     */
    public void addRental(Rental rental){
        rentals.add(rental);
    }
    
    /**
     * レンタルの報告書を作成する
     * 　<br>　addRentalメソッドで追加した分のレンタルの報告書を作成する
     * 　<br>　　ヘッダ：レンタルした顧客の名称
     * 　<br>　　明細：レンタルビデオのタイトルと料金（レンタルした分）
     * 　<br>　　フッタ：料金の合計と獲得ポイント数
     * @return  ビデオレンタルの報告書　String
     */
    public String getStatement(){
        return getStatementHeader() + getStatementDetail() + getStatementFooter();        
    }
    
    private String getStatementHeader(){
        return "Rental Record for " + name + "\n";
    }
    
    private String getStatementDetail(){
        return rentals.stream()
                .map(x -> "  " + x.getMovie().getTitle() + "  " 
                        + String.valueOf(x.getCharge()) + "\n")
                .reduce("", String::concat);
    }
    
    private String getStatementFooter(){
        String result = "";
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earnd " + String.valueOf(getTotalRentalPoints()) +
            " frequent rental points";
        return result;
    }
    
    private int getTotalCharge(){
        return rentals.stream()
                .map(x -> x.getCharge())
                .reduce(0, Integer::sum);
    }
    
    private int getTotalRentalPoints(){
        return rentals.stream()
                .map(x -> x.getRentalPoints())
                .reduce(0, Integer::sum);
    }
    
    @Override
    public String toString(){
        return
        "name:" + name + "\n" +
        "rentals:" + rentals + "\n";
    }
}
