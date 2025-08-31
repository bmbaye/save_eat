package src.saveeatback.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", System.getProperty("cloudinary.cloud_name", "dgbz1s1wj"));
        config.put("api_key", System.getProperty("cloudinary.api_key", "733591967821886"));
        config.put("api_secret", System.getProperty("cloudinary.api_secret", "kL0VIFMtw2T6XFd4_PPSBrPdm-4"));
        return new Cloudinary(config);
    }
}
