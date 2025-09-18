package est.day11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Day11Application {

	public static void main(String[] args) {
		SpringApplication.run(Day11Application.class, args);
	}

}

