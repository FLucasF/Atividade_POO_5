package back;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MarketPlace implements MarketplaceInterface{
    Map<Integer, Product> products;
    GravadorDeProdutos gravador = new GravadorDeProdutos();

    public MarketPlace() {
        try {
            this.products = gravador.leProdutos();

        } catch (IOException e) {
            System.err.println(e.getMessage());
            this.products = new HashMap<>();
        }
    }

    public void sairDoSistema() {
        try {
            this.gravador.gravaProdutos(this.products);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

//    public MarketPlace() {
//        this.products = new HashMap<>();
//    }
    @Override
    public boolean registerProduct(Product p) {
        if(this.products.containsKey(p.getCode())) {
            return false;
        }
        this.products.put(p.getCode(), p);
        return true;
    }

    @Override
    public boolean removeProduct(Product p) {
        if(this.products.containsKey(p.getCode())) {
            this.products.remove(p.getCode());
            return true;
        }
        return false;
    }

    @Override
    public Product searchProduct(int code) throws ProductNotFoundException {
        Product p = this.products.get(code);
        if(p == null) {
            throw new ProductNotFoundException("Non-existent product");
        }
        return p;
    }

    @Override
    public boolean modifyAmountProduct(Product p, int newAmount) {
        if(this.products.containsKey(p.getCode())) {
            p.setAmount(newAmount);
            return true;
        }
        return false;
    }
}
