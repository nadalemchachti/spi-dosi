package fr.univbrest.dosi.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;

@Component
public class EnseignantBusinessJPA implements EnseignantBusiness {

	EnseignantRepository repos;
	
	@Autowired
	public EnseignantBusinessJPA(EnseignantRepository repos) {
		this.repos = repos;
	}

	@Override
	public Enseignant creerEnseignant(Enseignant enseignant) {
		return repos.save(enseignant);
	}

	@Override
	public void supprimerEnseignant(Long id) {
		repos.delete(id);

	}

	@Override
	public Enseignant recupererEnseignantParId(Long id) {
		return repos.findEnseignantByNoEnseignant(id);
	}


	

	@Override
	public List<Enseignant> recupererEnseignantParNom(String nom) {
		return repos.findEnseignantByNom(nom) ;
	}
	
	

	@Override
	public List<Enseignant> recupererEnseignantParPays(String Pays) {
		return repos.findEnseignantByPays(Pays);
	}

	@Override
	public List<Enseignant> recupererTousLesEnseignant() {
		return (List<Enseignant>) repos.findAll();
	}

	@Override
	public Enseignant recupererEnseignantParNomPrenom(String nom, String prenom) {
		Enseignant E = new Enseignant();
		List<Enseignant> ListeE = repos.findEnseignantByNom(nom);
		for(Enseignant N : ListeE)
		{
			if(N.getPrenom().equals(prenom)) {
					return N;
				}
			}
		
		return null;		
	}

	
	

}
