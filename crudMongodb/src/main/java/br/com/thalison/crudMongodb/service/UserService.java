package br.com.thalison.crudMongodb.service;

import br.com.thalison.crudMongodb.domain.User;
import br.com.thalison.crudMongodb.dto.UserDTO;
import br.com.thalison.crudMongodb.repository.UserRepository;
import br.com.thalison.crudMongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){

        //https://stackoverflow.com/questions/52634362/inferred-type-s-for-type-parameter-s-is-not-within-its-bound-should-extend
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
           throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

    public User insert (User user){
        return  userRepository.insert(user);
    }

    public  void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }
    public User fromDTO(UserDTO objectdto){
        return new User(objectdto.getId(), objectdto.getName(), objectdto.getEmail());
    }
}
