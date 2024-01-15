package br.com.thalison.crudMongodb.resources;

import br.com.thalison.crudMongodb.domain.User;
import br.com.thalison.crudMongodb.dto.UserDTO;
import br.com.thalison.crudMongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users") //geralmente o nome do metodo sempre no pluras "users"
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> listaUsers = userService.findAll();

        List<UserDTO> listaDTO = listaUsers.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);
    }
    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User userobj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(userobj));
    }

    @PostMapping()
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
        User userobj = userService.fromDTO(userDTO);
        userobj = userService.insert(userobj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id").buildAndExpand(userobj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }



}
