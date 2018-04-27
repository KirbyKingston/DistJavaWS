package DJStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author Mitch
 */
//@ComponentScan("DistJavaWS")
@SpringBootApplication
public class DistJavaWS {
    
    public static void main(String[] args) {
        SpringApplication.run(DistJavaWS.class, args);
    }

}