package org.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.service.impl.ItemImpl;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    private Long id;
    private static Long lastId=0l;
    private String barcode;
    private int count;
    private Double total;

    {
        lastId++;
        id=lastId;
    }
    public void setTotal(){
        ItemImpl item = new ItemImpl();
        total=item.itemTotal(this.barcode,this.count);
    }


}
