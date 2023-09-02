package pl.camp.it.book.store.controllers.rest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.book.store.exceptions.LoginAlreadyExistException;
import pl.camp.it.book.store.model.User;
import pl.camp.it.book.store.model.dto.UserRequest;
import pl.camp.it.book.store.services.IUserService;

import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserRestController {

    @Autowired
    IUserService userService;

    @RequestMapping(path = "/{loginOrId}", method = RequestMethod.GET)
    public ResponseEntity<User> getByLogin(@PathVariable String loginOrId) {
        Optional<User> userBox;
        try {
            int id = Integer.parseInt(loginOrId);
            userBox = this.userService.getById(id);
        } catch (NumberFormatException e) {
            userBox = this.userService.getByLogin(loginOrId);
        }
        return userBox.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody UserRequest user) {
        User userModel = new User(0, user.getLogin(),
                DigestUtils.md5Hex(user.getPassword()), user.getName(), user.getSurname(),
                user.getEmail(), user.getRole());
        try {
            this.userService.persistUser(userModel);
        } catch (LoginAlreadyExistException e) {
            return ResponseEntity.status(CONFLICT).build();
        }
        return ResponseEntity.status(CREATED).body(userModel);
    }
}
