package pl.camp.it.book.store.session;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.camp.it.book.store.model.Cart;
import pl.camp.it.book.store.model.User;

@NoArgsConstructor
@Getter
@Setter
@Component
@SessionScope
public class SessionData {
    private User user = null;
    private Cart cart = new Cart();
    private String info = null;

    public boolean isLogged() {
        return this.user != null;
    }

    public boolean isAdmin() {
        if(this.user == null) {
            return false;
        }
        return this.user.getRole() == User.Role.ADMIN;
    }

    public String getInfo() {
        if(this.info == null) {
            return "";
        } else {
            String temp = this.info;
            this.info = null;
            return temp;
        }
    }
}
