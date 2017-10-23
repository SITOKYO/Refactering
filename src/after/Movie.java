package after;

public class Movie { 
    private final String title;
    private final String movieTypeClassName;
    
    public Movie(String movieTitle, String movieTypeClassName) throws Exception {
        this.title = movieTitle;
        this.movieTypeClassName = movieTypeClassName;
    }
    
    public String getTitle() {
        return title;
    }

    public MovieType getMovieTypeInstance() throws Exception{
        try {
            final String fullyQualifiedClassName = 
                    MovieType.class.getPackage().getName() + "." + movieTypeClassName;
            return (MovieType)Class.forName(fullyQualifiedClassName).newInstance();
        } catch (ClassNotFoundException ex) {
            // 注意：生成対象のクラスは当クラスと同パッケージに存在する必要があります。
            System.err.println("クラスの指定が正しくありません");
            throw ex;
        }
    }
    
    @Override
    public String toString(){
        return
        "title:" + title + "\n" +
        "movieTypeClassName:" + movieTypeClassName + "\n";
    }

}
