package xin.qust.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import xin.qust.platform.framework.WMRepositoryFactory;

import java.util.TimeZone;

@EnableJpaRepositories(repositoryFactoryBeanClass = WMRepositoryFactory.class, basePackages ="xin.qust.platform")
@SpringBootApplication
public class PlatFormApp {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(PlatFormApp.class);
    }
}
