package org.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sale {
    private Long id;
    private static Long lastId=0l;
    private Double total;
    private List<Item> items;
    private LocalDateTime date;
    {
        lastId++;
        id=lastId;
    }

}
