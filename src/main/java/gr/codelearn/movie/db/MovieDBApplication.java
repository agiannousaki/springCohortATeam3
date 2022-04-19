package gr.codelearn.movie.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class MovieDBApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieDBApplication.class, args);
	}
}
