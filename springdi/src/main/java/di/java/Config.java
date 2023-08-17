package di.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"di.java"})
@Configuration
public class Config {
	
	/*
	@Qualifier("car")
	@Bean
	public Car car() {
		return new Car();
	}
	
	@Qualifier("h")
	@Bean	
	public HankookTire hankookTire() {
		return new HankookTire();
	}
	
	@Qualifier("k")
	@Bean	
	public KumhoTire kumhoTire() {
		return new KumhoTire();
	}
	*/
}
