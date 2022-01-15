package Mashgulotlar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
private Integer id;
private String name;
private boolean active;
private Integer category_id;
private Integer measurement_id;
private Integer attachment_id;
}
