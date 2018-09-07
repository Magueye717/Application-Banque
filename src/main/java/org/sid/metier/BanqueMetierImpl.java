package org.sid.metier;

import org.sid.dao.CompteRepository;
import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier{
	@Autowired
	CompteRepository compteRepository ;

	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cp=compteRepository.findOne(codeCpte);
		if (cp==null) throw new Exception("Compte introuvable");
		return null;
	}

	@Override
	public void verser(String codeCpte, double montant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
