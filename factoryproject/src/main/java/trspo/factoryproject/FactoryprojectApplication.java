package trspo.factoryproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"trspo.factoryproject"})
//@EnableJpaRespositories
public class FactoryprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactoryprojectApplication.class, args);
    }

}
