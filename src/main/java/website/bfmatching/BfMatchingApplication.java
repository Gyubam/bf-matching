package website.bfmatching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BfMatchingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BfMatchingApplication.class, args);
	}

	@Component
	public class CustomBCryptPasswordEncoder extends BCryptPasswordEncoder {
	}

}
