package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@ComponentScan
@EnableAutoConfiguration
public class Application {

      static List<Bulb> bulbsList = new ArrayList<>();
      static {
          bulbsList.add(new Bulb("1", "on"));
          bulbsList.add(new Bulb("2", "on"));
          bulbsList.add(new Bulb("3", "on"));
      }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}