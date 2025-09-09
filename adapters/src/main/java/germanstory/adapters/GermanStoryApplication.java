package germanstory.adapters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("germanstory.infrastructure.repository")
@EntityScan("germanstory.infrastructure.entity")
public class GermanStoryApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(GermanStoryApplication.class, args);
    }
}