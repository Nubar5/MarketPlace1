package org.service.inter;

import org.entity.Category;
import org.entity.Product;

import java.util.List;

public interface ProductInter {

     Product addProduct(Product product);
     void deleteProduct(Long id);
     void updateProductName(Long id,String name);
     void updateProductPrice(Long id,Double price);
     void updateProductAmount(Long id,int amount);
     void updateProductCategory(Long id, String category);
     List<Product> showProducts();
     List<Product> showProductsByName(String name);
     void showProductsByCategory(String category);
     List<Product> showProductsByPrice(Double minPrice,Double maxPrice);

     Product getProductByBarcode(String barcode);

}
