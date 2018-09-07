package org.sid;

import java.util.Date;

import org.sid.dao.ClientRepository;
import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Client;
import org.sid.entities.Compte;
import org.sid.entities.CompteCourant;
import org.sid.entities.Retrait;
import org.sid.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VotreBanqueApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	OperationRepository operationRepository;
	public static void main(String[] args) {
		SpringApplication.run(VotreBanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client c1=clientRepository.save(new Client( "Magueye", "magueye717@gmail.com"));
		Client c2=clientRepository.save(new Client( "Ngouda", "Ngouda@gmail.com"));
		
		Compte cp1=compteRepository.save(
				new CompteCourant("c1", new Date(), 90000, c1, 6000));
		Compte cp2=compteRepository.save(
				new CompteCourant("c2", new Date(), 50000, c1, 5.5));
		
		operationRepository.save(new Versement(new Date(), 30000, cp1));
		operationRepository.save(new Versement(new Date(), 60000, cp1));
		operationRepository.save(new Versement(new Date(), 11000, cp1));
		operationRepository.save(new Retrait(new Date(), 30000, cp1));
		
		operationRepository.save(new Versement(new Date(), 85000, cp2));
		operationRepository.save(new Versement(new Date(), 65000, cp2));
		operationRepository.save(new Versement(new Date(), 26000, cp2));
		operationRepository.save(new Retrait(new Date(), 40000, cp2));
	}
}
