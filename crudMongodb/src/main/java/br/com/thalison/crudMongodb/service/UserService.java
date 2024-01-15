package br.com.thalison.crudMongodb.service;

import br.com.thalison.crudMongodb.domain.User;
import br.com.thalison.crudMongodb.repository.UserRepository;
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
}
