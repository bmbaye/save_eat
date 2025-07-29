package src.saveeatback.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${spring.application.version}")
    private String version;

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("SaveEat API")
                        .version(version)
                        .description("API pour gerer une plateforme de vente de produits alimentaires frais")
                );
    }

    @Bean
    public GroupedOpenApi groupedOpenApi(){
        return GroupedOpenApi.builder()
                .group("gestion saveeat")
                .packagesToScan("src.saveeatback.web.controllers")
                .packagesToExclude("src.saveeatback.datas.entities")
                .build();
    }
}
