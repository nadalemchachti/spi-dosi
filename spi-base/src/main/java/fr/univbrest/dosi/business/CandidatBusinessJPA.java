package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repositories.CandidatRepository;
@Service
public class CandidatBusinessJPA implements CandidatBusiness {

	CandidatRepository repos;
	
	@Autowired
	public CandidatBusinessJPA(CandidatRepository repos) {
		super();
		this.repos = repos;
	}

	@Override
	public Candidat creerCandidat(Candidat candidatACreer) {
		//candidatACreer.setAdresse("Adresse");
	  //candidatACreer.setNoCandidat("11");
		return repos.save(candidatACreer);
	}

	@Override
	public void supprimerCandidat(String idcandidatASupprimer) {
		repos.delete(repos.findOne(idcandidatASupprimer));
	}

	@Override
	public List<Candidat> rechercherCandidatParNom(String nomCandidat) {
		
		return repos.findCandidatByNom(nomCandidat);
	}

	@Override
	public List<Candidat> rechercherCandidatParUniversite(String universiteOrigine) {
		
		return repos.findCandidatByUniversiteOrigine(universiteOrigine);
	}

	@Override
	public List<Candidat> recupererTousLesCandidats() {
		return (List<Candidat>) repos.findAll();
	}

	@Override
	public Candidat rechercherCandidatParId(String id) {

		return repos.findCandidatByNoCandidat(id);
	}

}
