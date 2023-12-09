package com.rebel.Ecom.Butter_sb_API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ButterSbApiApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(ButterSbApiApplication.class, args);
		System.out.println("Test your API endpoints :) ");
	}

	@Override
	public void run(String... args) throws Exception
	{
		//encoding password for now

		System.out.println(this.encoder.encode("123456"));

	}
}
