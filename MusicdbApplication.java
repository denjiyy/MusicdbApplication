package bg.musicapp.musicdb;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "My Custom API",
				description = "This is the API for my own application",
				version = "1.0",
				contact = @Contact(name = "Your Name", email = "your-email@example.com", url = "http://your-contact-url.com"),
				license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0")
		)
)
@SpringBootApplication
public class MusicdbApplication {
	public static void main(String[] args) {
		SpringApplication.run(MusicdbApplication.class, args);
	}
}