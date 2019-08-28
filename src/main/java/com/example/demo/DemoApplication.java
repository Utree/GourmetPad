package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.repository.CategoryV1Repository;
import com.example.demo.repository.PriceRangeV1Repository;
import com.example.demo.repository.ShopV2Repository;
import com.example.demo.domain.CategoryV1;
import com.example.demo.domain.PriceRangeV1;
import com.example.demo.domain.ShopV2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// データを削除
	@Bean
	public CommandLineRunner deleteAllData(ShopV2Repository shopV2Repository, CategoryV1Repository categoryV1Repository, PriceRangeV1Repository priceRangeV1Repository) {
		return (args) -> {
			shopV2Repository.deleteAll();
			categoryV1Repository.deleteAll();
			priceRangeV1Repository.deleteAll();
		};
	}

	// カテゴリを初期化
	@Bean
	public CommandLineRunner addInitialDataToCategoryV1(CategoryV1Repository repository) {
		return (args) -> {
			log.info("this method called");
			// データを注入
			repository.save(new CategoryV1("中華"));
			repository.save(new CategoryV1("フレンチ"));
			repository.save(new CategoryV1("イタリアン"));
			repository.save(new CategoryV1("和食"));
			repository.save(new CategoryV1("ファミレス"));
			repository.save(new CategoryV1("カフェ"));
			
			// 確認
			log.info("findAll CategoryV1");
			log.info("-------------------");
			for (CategoryV1 categoryV1: repository.findAll()) {
				log.info(categoryV1.toString());
			}
			log.info("-------------------");
		};
	}

	// 価格帯を初期化
	@Bean
	public CommandLineRunner addInitialDataToPriceRangeV1(PriceRangeV1Repository repository) {
		return (args) -> {
			// データを注入
			repository.save(new PriceRangeV1("-499", 0));
			repository.save(new PriceRangeV1("500-999", 1));
			repository.save(new PriceRangeV1("1000-4999", 2));
			repository.save(new PriceRangeV1("5000-9999", 3));
			repository.save(new PriceRangeV1("10000-29999", 4));
			repository.save(new PriceRangeV1("30000-", 5));
			
			// 確認
			log.info("findAll priceRangeV1");
			log.info("-------------------");
			for (PriceRangeV1 priceRangeV1: repository.findAll()) {
				log.info(priceRangeV1.toString());
			}
			log.info("-------------------");
		};
	}

	// ShopV2を初期化
	@Bean
	public CommandLineRunner addInitialDataToShopV2(ShopV2Repository shopV2Repository, CategoryV1Repository categoryV1Repository, PriceRangeV1Repository priceRangeV1Repository) {
		return (args) -> {
			// データを注入
			shopV2Repository.save(
				new ShopV2(
					"シナジーフレンチ",
					priceRangeV1Repository.findByName("5000-9999").get(0),
					"大阪",
					categoryV1Repository.findByName("フレンチ").get(0)
				)
			);
			shopV2Repository.save(
				new ShopV2(
					"シナジーイタリアン",
					priceRangeV1Repository.findByName("-499").get(0),
					"兵庫",
					categoryV1Repository.findByName("イタリアン").get(0)
				)
			);
			shopV2Repository.save(
				new ShopV2(
					"シナジー中華",
					priceRangeV1Repository.findByName("1000-4999").get(0),
					"奈良",
					categoryV1Repository.findByName("中華").get(0)
				)
			);
			shopV2Repository.save(
				new ShopV2(
					"シナジー和食",
					priceRangeV1Repository.findByName("10000-29999").get(0),
					"和歌山",
					categoryV1Repository.findByName("和食").get(0)
				)
			);
			shopV2Repository.save(
				new ShopV2(
					"シナジーファミレス",
					priceRangeV1Repository.findByName("500-999").get(0),
					"大阪",
					categoryV1Repository.findByName("ファミレス").get(0)
				)
			);

			// 確認
			log.info("findAll priceRangeV1");
			log.info("-------------------");
			for (ShopV2 shopV2: shopV2Repository.findAll()) {
				log.info(shopV2.toString());
			}
			log.info("-------------------");
		};
	}
}
