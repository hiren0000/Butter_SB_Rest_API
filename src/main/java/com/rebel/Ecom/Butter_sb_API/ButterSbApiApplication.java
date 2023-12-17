package com.rebel.Ecom.Butter_sb_API;

import com.rebel.Ecom.Butter_sb_API.Models.User;
import com.rebel.Ecom.Butter_sb_API.Models.UserRole;
import com.rebel.Ecom.Butter_sb_API.Repo.UserRepo;
import com.rebel.Ecom.Butter_sb_API.playload.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ButterSbApiApplication implements CommandLineRunner {

	@Autowired
	private UserRepo userRepo;

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


		//Admin added into db

		/*User user = new User();
		user.setFirstName("ADMIN");
		user.setEmail("Hiru.devmurari@gmail.com");
		user.setPassword("123456789");

		UserRole role = new UserRole();
		role.setRId(Constants.ADMIN_USER);
		role.setRName("ADMIN");


		List<UserRole> roles = new ArrayList<>();
		roles.add(role);

		user.setRoles(roles);

		this.userRepo.save(user);*/


	}
}
