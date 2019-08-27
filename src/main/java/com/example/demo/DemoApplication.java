package com.example.demo;

import com.example.demo.repository.ShopRepository;
import com.example.demo.domain.Shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ShopRepository repository) {
		return (args) -> {
			// save a couple of shops
			repository.deleteAll();
			repository.save(new Shop("シナジーフレンチ", "100-500", "京都"));
			repository.save(new Shop("シナジーイタリアン", "-100", "兵庫"));
			repository.save(new Shop("シナジー中華", "1000-5000", "奈良"));
			repository.save(new Shop("シナジー和食", "10000-", "和歌山"));
			repository.save(new Shop("シナジーファミレス", "2000-5000", "大阪"));
			
		};
	}

}
