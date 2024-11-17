package facts;


public class Order {
    private double total;
    private int discount;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "total=" + total +
                ", discount=" + discount +
                '}';
    }
}
