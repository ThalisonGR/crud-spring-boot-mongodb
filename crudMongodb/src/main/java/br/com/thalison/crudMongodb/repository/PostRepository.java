package br.com.thalison.crudMongodb.repository;

import br.com.thalison.crudMongodb.domain.Post;
import br.com.thalison.crudMongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
