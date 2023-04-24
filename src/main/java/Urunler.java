public class Urunler {

    private String no;
    private String name;
    private double price;
    public Urunler(){

    }

    public Urunler(String no, String name, double price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }


     public String getNo() {
         return no;
     }


    public String getName() {
        return name;
    }


    public double getPrice() {
         return price;
    }



    @Override
    public String toString() {
        return
                "No= " + no +
                "  Name= " + name +
                "  Price= " + price;
    }
}
