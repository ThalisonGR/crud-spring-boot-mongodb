package br.com.thalison.crudMongodb.service.exception;

import br.com.thalison.crudMongodb.domain.Post;
import br.com.thalison.crudMongodb.domain.User;
import br.com.thalison.crudMongodb.dto.UserDTO;
import br.com.thalison.crudMongodb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {


    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findById(String id){

        //https://stackoverflow.com/questions/52634362/inferred-type-s-for-type-parameter-s-is-not-within-its-bound-should-extend
        Post post = postRepository.findById(id).orElse(null);
        if (post == null){
           throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return post;
    }

}
