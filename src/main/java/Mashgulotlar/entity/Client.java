package Mashgulotlar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {
    private Integer id;
    private String name;
    private boolean active;
    private String phone;
}
