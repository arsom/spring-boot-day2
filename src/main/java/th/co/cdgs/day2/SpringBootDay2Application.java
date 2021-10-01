package th.co.cdgs.day2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDay2Application {

	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
	context = SpringApplication.run(SpringBootDay2Application.class, args);
		System.out.println(context.getBeanDefinitionCount());

	}

}
