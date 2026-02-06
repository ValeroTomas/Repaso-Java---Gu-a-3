package com.repaso.mensajeria;

import com.repaso.mensajeria.Service.Components.Notificador;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepasoJavaGuia3Application implements CommandLineRunner {

	private final Notificador notificador;

	@Autowired
	public RepasoJavaGuia3Application(Notificador notificador) {
		this.notificador = notificador;
	}

	public static void main(String[] args) {
		SpringApplication.run(RepasoJavaGuia3Application.class, args);
	}

	@Override
	public void run(String @NonNull ... args) throws Exception {
		notificador.notificar("Hola mundo");
	}
}
