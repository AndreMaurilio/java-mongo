package app.repository;

import app.domain.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CarRepository extends MongoRepository<Car,String> {

    @Query(value = "{ 'placa' : ?0}")
    Optional<Car> findByPlaca(String placa);
}
