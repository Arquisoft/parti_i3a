package es.uniovi.asw;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import es.uniovi.asw.util.Helper;

@SpringBootApplication
@ComponentScan("es.uniovi.asw")
@Component
public class Application {

    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    	try {
			Helper.checkData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}