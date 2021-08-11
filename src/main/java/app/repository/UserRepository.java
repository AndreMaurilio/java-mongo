package app.repository;


import app.domain.model.Car;
import app.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    @Query(value = "{'cpf':?0}")
    Optional<User> findByCpf(String cpf);

}
