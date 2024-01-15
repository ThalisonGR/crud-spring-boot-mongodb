package br.com.thalison.crudMongodb.config;

import br.com.thalison.crudMongodb.domain.Post;
import br.com.thalison.crudMongodb.domain.User;
import br.com.thalison.crudMongodb.dto.AuthorDTO;
import br.com.thalison.crudMongodb.repository.PostRepository;
import br.com.thalison.crudMongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;




    @Override
    public void run(String... args) throws Exception {

        postRepository.deleteAll();
        userRepository.deleteAll();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");


        userRepository.saveAll(Arrays.asList(maria , alex , bob));

        Post post = new Post(null,simpleDateFormat.parse("21/03/2023"),"Pariu viagem", "Vou viajar", new AuthorDTO(maria)  );
        Post post2 = new Post(null,simpleDateFormat.parse("25/03/2023"),"Viagem", "Muito bom" , new AuthorDTO(alex));

        postRepository.saveAll(Arrays.asList(post , post2));

        maria.getListPosts().addAll(Arrays.asList(post,post2));
        userRepository.save(maria);
    }
}
