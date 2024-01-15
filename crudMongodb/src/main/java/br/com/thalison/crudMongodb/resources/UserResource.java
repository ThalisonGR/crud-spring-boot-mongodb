package br.com.thalison.crudMongodb.resources;

import br.com.thalison.crudMongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users") //geralmente o nome do metodo sempre no pluras "users"
public class UserResource {


    @GetMapping(value = "/findAll")
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria", "Maria@gmail.com");
        User alex = new User("2", "alex", "Malex@gmail.com");

        List<User> lista = new ArrayList<>();

        lista.addAll(Arrays.asList(maria, alex));

        return ResponseEntity.ok(lista);

    }

}
