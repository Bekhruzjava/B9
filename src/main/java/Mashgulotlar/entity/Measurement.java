package Mashgulotlar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Measurement {
    private Integer id;
    private String name;
    private boolean active;
}
