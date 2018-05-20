package com.devlabs.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringbootDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringbootDemoApplication.class);

	@Autowired
	private CustomerRepository repository;

	@Autowired PostDetailsRepository postDetailsRepository;

	@Autowired PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
		SpringbootDemoApplication app = new SpringbootDemoApplication();
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Deepak", "Bhagat"));

			//fetch all customer
			log.info("Customer find with findAll");
			log.info("___________________________");

			for(Customer customer : repository.findAll()){
				log.info(customer.toString());
			}
			log.info(" ");

			//fetch by Id
			repository.findById(1L)
					.ifPresent(customer -> {
						log.info("Customer found by Id");
						log.info(customer.toString());
						log.info(" ");
					});
			//fetch by last name
            repository.findByLastName("Bhagat")
                    .forEach(customer -> {
                        log.info("Customer by last Name");
                        log.info(customer.toString());
                        log.info(" ");
                    });

            log.info("=================================Post======================================");

            PostDetails postDetails = new PostDetails();
            postDetails.setCratedOn(new Date());
            postDetails.setCreatedBy("Deepak");

            Post post = new Post("Title1", postDetails);
            post.setPostDetails(postDetails);
            postRepository.save(post);

            postRepository.findAll().forEach(post1 -> {
                log.info("-----------------");
                log.info(post1.toString());
                log.info(post1.getPostDetails().getCreatedBy());
            });

            postDetailsRepository.findAll().forEach(postDetails1 -> {
                log.info("-----------Post detial");
                log.info(postDetails1.toString());
                log.info(postDetails1.getPost().getTitle());
            });

		};

	}


}
