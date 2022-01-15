package Mashgulotlar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
private Integer id;
private String email;
private String password;
private String full_name;
private String phone;
private boolean active;
}
