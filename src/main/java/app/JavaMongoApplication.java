package app;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan
@SpringBootApplication
@EnableMongock
public class JavaMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaMongoApplication.class, args);

    }
}
