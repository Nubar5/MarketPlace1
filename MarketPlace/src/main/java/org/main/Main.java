package org.main;

import org.entity.Category;
import org.entity.Product;
import org.entity.Sale;
import org.service.impl.ProductImpl;
import org.service.impl.SaleImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProductImpl productImpl = new ProductImpl();
        Product prod = new Product(1L, "aa11", "aa11", Category.Wearable, 1d, 111);
        Product prod1 = new Product(2l, "ab11", "ab11", Category.Eatable, 2d, 222);
        Product prod2 = new Product(3l, "bb11", "bb11", Category.Drinks, 3d, 333);
        Product prod3 = new Product(4l, "ba11", "ba11", Category.Eatable, 4d, 444);
        Product prod4 = new Product(5l, "bc11", "bc11", Category.Wearable, 5d, 555);
        ProductImpl.productList.add(prod);
        ProductImpl.productList.add(prod1);
        ProductImpl.productList.add(prod2);
        ProductImpl.productList.add(prod3);
        ProductImpl.productList.add(prod4);
        SaleImpl saleImpl = new SaleImpl();

        Operations operations = new Operations();

        boolean operation = true;
        while (operation) {
            System.out.println("1-product,2-sale,3-exit");
            int operationValue = scanner.nextInt();
            switch (operationValue) {
                case 1: {
                    System.out.println("1-add,2-update,3-delete,4-show,5-show by price,6- by category,7-by name");
                    int firstCase = scanner.nextInt();
                    if (firstCase == 1) {
                        productImpl.addProduct(operations.addProduct());
                    } else if (firstCase == 2) {
                        boolean updateChoice = true;
                        while (updateChoice) {
                            System.out.println("select update case 1-name, 2-category, 3-price, 4-amount");
                            int alter = scanner.nextInt();
                            if (alter == 1) {
                                System.out.println("enter id and update name");
                                productImpl.updateProductName(scanner.nextLong(), scanner.next());
                            } else if (alter == 2) {
                                System.out.println("enter id and update category(e w d)");
                                productImpl.updateProductCategory(scanner.nextLong(), scanner.next());
                            } else if (alter == 3) {
                                System.out.println("enter id and update price");
                                productImpl.updateProductPrice(scanner.nextLong(), scanner.nextDouble());
                            } else if (alter == 4) {
                                System.out.println("enter id and update amount");
                                productImpl.updateProductAmount(scanner.nextLong(), scanner.nextInt());
                            } else System.out.println("invalid choice");
                            System.out.println("continue update 0-no, 1-yes");
                            int c = scanner.nextInt();
                            if (c == 0) {
                                updateChoice = false;
                            } else if (c == 1) {
                                updateChoice = true;
                            } else System.out.println("invalid operation");

                        }
                    } else if (firstCase == 3) {
                        System.out.println("enter id");
                        Long deleteProduct = scanner.nextLong();
                        productImpl.deleteProduct(deleteProduct);
                    } else if (firstCase == 4) {
                        for (Product p : productImpl.showProducts()) {
                            System.out.println(p.toString());
                        }
                    } else if (firstCase == 5) {
                        System.out.println("enter min and max price");
                        for (Product p : productImpl.showProductsByPrice(scanner.nextDouble(), scanner.nextDouble())) {
                            System.out.println(p.toString());
                        }
                    } else if (firstCase == 6) {
                        System.out.println("enter category d e w");
                        productImpl.showProductsByCategory(scanner.next());

                    } else if (firstCase == 7) {
                        System.out.println("enter product name");
                        for (Product p : productImpl.showProductsByName(scanner.next())) {
                            System.out.println(p.toString());
                        }
                    } else {
                        System.out.println("invalid operation");
                    }
                    break;
                }


                case 2: {
                    System.out.println("0-show,1-add,2-return item ,3-delete,select by 4- duration ,5-price,6-date,7-id");
                    int secondCase = scanner.nextInt();
                    if (secondCase == 1) {
                        saleImpl.addSale(operations.addSale());
                    } else if (secondCase == 0) {
                        for (Sale s : saleImpl.showSale()
                        ) {
                            System.out.println(s.toString());
                        }
                    } else if (secondCase == 2) {
                        System.out.println("enter sale id and barcode of product to remove");
                        saleImpl.removeItem(scanner.nextLong(), scanner.next());
                    } else if (secondCase == 3) {
                        System.out.println("enter sale id to remove");
                        saleImpl.removeSale(scanner.nextLong());
                    } else if (secondCase == 4) {

                        for (Sale s :saleImpl.showSaleByDuration(operations.convertDatetoLocalDateTime(), operations.convertDatetoLocalDateTime())) {
                            System.out.println(s.toString());
                        }

                    } else if (secondCase == 5) {
                        System.out.println("enter min and max price ");
                        Double minPrice = scanner.nextDouble();
                        Double maxPrice = scanner.nextDouble();
                        for (Sale s : saleImpl.showSaleByPrice(minPrice, maxPrice)) {
                            System.out.println(s.toString());
                        }

                    } else if (secondCase == 6) {
                        System.out.println("enter date   (yyyy-MM-dd):");
                        String input = scanner.next();
                        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate date = LocalDate.parse(input, dateFormatter);
                      for (Sale s : saleImpl.showSaleByDate(date)) {
                            System.out.println(s.toString());
                        }

                    } else if (secondCase == 7) {
                        System.out.println("enter id for search sale");
                        Long id = scanner.nextLong();
                        System.out.println(saleImpl.showSaleById(id).toString());


                    } else {
                        System.out.println("invalid operation");
                    }
                }
                break;
                case 3: {
                    System.out.println("bye!!");
                    operation = false;
                    break;
                }
                default: {
                    System.out.println("invalid Operation value");
                }
            }
        }


    }
}