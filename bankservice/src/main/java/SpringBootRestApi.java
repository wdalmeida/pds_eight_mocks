import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"controller"})
public class SpringBootRestApi {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApi.class, args);
    }
}
