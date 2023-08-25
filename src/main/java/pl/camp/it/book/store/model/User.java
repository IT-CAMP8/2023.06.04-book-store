package pl.camp.it.book.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "tuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String login;
    @JsonIgnore
    private String password;
    private String name;
    private String surname;
    @JsonIgnore
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(int id) {
        this.id = id;
    }

    public static User copyOf(User user) {
        User result = new User();
        result.id = user.id;
        result.role = user.role;
        result.name = user.name;
        result.password = user.password;
        result.email = user.email;
        result.surname = user.surname;
        result.login = user.login;
        return result;
    }

    public enum Role {
        ADMIN,
        USER
    }
}
