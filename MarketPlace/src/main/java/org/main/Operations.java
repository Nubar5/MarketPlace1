package org.main;

import org.entity.Category;
import org.entity.Item;
import org.entity.Product;
import org.entity.Sale;
import org.service.impl.ItemImpl;
import org.service.impl.ProductImpl;
import org.service.impl.SaleImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Operations {


    public Product addProduct(){
        Scanner scanner =new Scanner(System.in);
        Product product = new Product();
        System.out.println("name");

        product.setName(scanner.next());
        boolean b= true;
        while (b) {
            System.out.println("enter barcode 4 character");
            String barcode = scanner.next();
            if (barcode.matches("^.{4}$")) {
                product.setBarcode(barcode);
                b = false;
            } else System.out.println("invalid barcode");
        }
        System.out.println("enter  :d,e,w ");
        String s=scanner.next();
        if(s.equals("d"))
            product.setCategory(Category.Drinks);
        else if (s.equals("e")) {
            product.setCategory(Category.Eatable);
        }else if (s.equals("w")) {
            product.setCategory(Category.Wearable);
        }
        System.out.println("price, amount");
        product.setPrice(scanner.nextDouble());
        product.setAmount(scanner.nextInt());
        return product;
    }

    public List<Item> addSale(){
        Scanner scanner = new Scanner(System.in);
        ProductImpl productImpl = new ProductImpl();
        ItemImpl itemImpl = new ItemImpl();
        boolean item=true;
        List<Item> items=new ArrayList<>();

        while (item){
            Item item1 = new Item();
            System.out.println("add item  barcode (only 4 char)");
            String t=scanner.next();
            item1.setBarcode(t);

            try{
                Product p =productImpl.getProductByBarcode(item1.getBarcode());

                System.out.println(p.toString());
            }catch (NoSuchElementException noSuchElementException){
                System.out.println("no such product");
                noSuchElementException.getMessage();
            }
            System.out.println(" How many");
            int c1= scanner.nextInt();
            item1.setCount(c1);
            System.out.println("want add new item? 1-yes, 0-no");
            item1.setTotal(itemImpl.itemTotal(t,c1));
            items.add(item1);
            int c = scanner.nextInt();
            if (c==1){
                item=true;
            }
            else if(c==0){
                item=false;
            }
            else System.out.println("invalid operation");
        }

        return items;
    }
public void removeItem(){
        SaleImpl saleImpl = new SaleImpl();
        Scanner sc=new Scanner(System.in) ;
    System.out.println("enter sale id and barcode of product to remove");
    saleImpl.removeItem(sc.nextLong(),sc.next());
}
 public LocalDateTime convertDatetoLocalDateTime(){
        Scanner scanner = new Scanner(System.in);
     System.out.println("enter start date  (yyyy-MM-dd):");
     String input = scanner.next();
     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     LocalDate date = LocalDate.parse(input, dateFormatter);
     LocalTime time = LocalTime.of(0, 0); // Assuming the time as midnight (00:00)
     LocalDateTime dateTime1 = LocalDateTime.of(date, time);
        return dateTime1;
 }

}
