package back;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private Integer code;
    private String name;
    private int amount;
    private double price;


    public Product(Integer codeProvided, String nameProvided, int amountProvided, double priceProvided) {
        this.code = codeProvided;
        this.name = nameProvided;
        this.amount = amountProvided;
        this.price = priceProvided;
    }

    public Product() {
        this(0, "", 0, 0.0);
    }

    //Methods
    @Override
    public String toString() {
        return "Code product: " +this.code+ ", Name product: " +this.name+
                ", Amount: " +this.amount+ " and Price: " +this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return code == product.code && Double.compare(price, product.price) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, price);
    }

    //getters and setters
    public int getCode() {
        return this.code;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }
}
