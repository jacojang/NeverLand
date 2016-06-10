package com.jacojang.neverland;

import com.jacojang.neverland.domain.LandUri;
import com.jacojang.neverland.repository.LandUriRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NeverLandApplication {
	public static void main(String[] args) {
		SpringApplication.run(NeverLandApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(LandUriRepository landUriRepository) {
		return args -> {
			LandUri lu4 = new LandUri();
			lu4.setName("임광그대가");
			lu4.setUri("http://land.naver.com/article/articleList.nhn?rletNo=1251&rletTypeCd=A01&tradeTypeCd=&hscpTypeCd=");
			landUriRepository.save(lu4);

			LandUri lu = new LandUri();
			lu.setName("세종그랑시아");
			lu.setUri("http://land.naver.com/article/articleList.nhn?rletNo=9492&rletTypeCd=A01&tradeTypeCd=&hscpTypeCd=");
			landUriRepository.save(lu);

			LandUri lu2 = new LandUri();
			lu2.setName("동구햇살");
			lu2.setUri("http://land.naver.com/article/articleList.nhn?rletNo=10492&rletTypeCd=A01&tradeTypeCd=&hscpTypeCd=");
			landUriRepository.save(lu2);

			LandUri lu3 = new LandUri();
			lu3.setName("삼형그레이스");
			lu3.setUri("http://land.naver.com/article/articleList.nhn?rletNo=8419&rletTypeCd=A01&tradeTypeCd=&hscpTypeCd=");
			landUriRepository.save(lu3);
		};
	}
}