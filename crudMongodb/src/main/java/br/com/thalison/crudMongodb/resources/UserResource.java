package br.com.thalison.crudMongodb.resources;

import br.com.thalison.crudMongodb.domain.User;
import br.com.thalison.crudMongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users") //geralmente o nome do metodo sempre no pluras "users"
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

}
