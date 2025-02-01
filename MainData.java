public class MainData {

    private int id;
    private String title;
    private double price;

    public MainData() {
    }

    public MainData(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            System.out.println("Price 0 unavailable");
            return;
        }
        this.price = price;

    }

    @Override
    public String toString() {
        return "id=" + id + ", title=" + title + ", price=" + price + "";
    }

}