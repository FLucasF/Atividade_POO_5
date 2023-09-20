package back;

public interface MarketplaceInterface {
    boolean registerProduct(Product p);
    boolean removeProduct(Product p);
    Product searchProduct(int code) throws ProductNotFoundException;
    boolean modifyAmountProduct(Product p, int newAmount);

    //dados pecorridos
}
