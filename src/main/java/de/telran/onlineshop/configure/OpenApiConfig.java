package de.telran.onlineshop.configure;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Online shop project Api",
                description = "API системы online магазина",
                version = "1.0.0",
                contact = @Contact(
                        name = "Konstantinisch",
                        email = "konst@konstantin.dev",
                        url = "https://web.de"
                )
        )
)

public class OpenApiConfig {

}
