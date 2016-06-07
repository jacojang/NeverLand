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
			LandUri lu = new LandUri();
			lu.setName("세종그랑시아");
			lu.setUri("http://land.naver.com/article/articleList.nhn?rletNo=9492&rletTypeCd=A01&tradeTypeCd=&hscpTypeCd=");
			landUriRepository.save(lu);

			LandUri lu2 = new LandUri();
			lu2.setName(" 동구햇살");
			lu2.setUri("http://land.naver.com/article/articleList.nhn?rletNo=10492&rletTypeCd=A01&tradeTypeCd=&hscpTypeCd=");
			landUriRepository.save(lu2);
		};
	}
}