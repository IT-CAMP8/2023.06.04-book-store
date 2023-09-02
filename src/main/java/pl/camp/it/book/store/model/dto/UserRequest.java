package pl.camp.it.book.store.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import pl.camp.it.book.store.model.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserRequest {
    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private User.Role role;
}
