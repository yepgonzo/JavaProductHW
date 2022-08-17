package ru.netology.productmanager;

import javax.naming.NameNotFoundException;

public class Repository {
    private Product[] products = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
          tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void remove(int id) {
        if (findById(id) == null) {
            throw new IdNotFound("Запрашиваемый Id не найден: " + id);
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
          if (product.getId() != id)  {
              tmp[copyToIndex] = product;
              copyToIndex++;
          }
        }
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }
}
