package website.bfmatching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class BfMatchingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BfMatchingApplication.class, args);
	}

	@Component
	public class CustomBCryptPasswordEncoder extends BCryptPasswordEncoder {
	}

}
