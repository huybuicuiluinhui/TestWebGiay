package asmhuybtph26874.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "roles")
    private int role;
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name = "pass")
    private String pass;
//    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
//    private List<Order> orderList;


}
