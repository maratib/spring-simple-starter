package com.example.simple;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleApplication {

	@Value("${server.port}")
	private int serverPort;

	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
	}

	@PostConstruct()
	public void started() throws IOException {
		System.out.println("Application started at port : " + serverPort);
	}

	@PreDestroy
	public void onExit() {
		System.out.println("Exiting app...");
	}

}
