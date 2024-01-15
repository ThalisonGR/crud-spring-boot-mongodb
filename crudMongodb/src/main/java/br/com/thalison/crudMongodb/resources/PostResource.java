package br.com.thalison.crudMongodb.resources;

import br.com.thalison.crudMongodb.domain.Post;
import br.com.thalison.crudMongodb.domain.User;
import br.com.thalison.crudMongodb.dto.UserDTO;
import br.com.thalison.crudMongodb.service.exception.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/posts") //geralmente o nome do metodo sempre no pluras "users"
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Post>> findAll() {
        List<Post> listPost = postService.findAll();
        return ResponseEntity.ok().body(listPost);
    }

    //https://stackoverflow.com/questions/4801794/use-of-javas-collections-singletonlist
    //Motivo de utilização do Collections.singletonList
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Post>> findById(@PathVariable String id) {
        Post postObj = postService.findById(id);
        return ResponseEntity.ok().body(Collections.singletonList(postObj));
    }
}
