package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Candidat;

@Component
public interface CandidatBusiness {
	
	Candidat creerCandidat(Candidat candidatACreer);
	void supprimerCandidat(String idCandidatACreer);
	List<Candidat> rechercherCandidatParNom(String nomCandidat);
	List<Candidat> rechercherCandidatParUniversite(String universiteCandidat);
	List<Candidat> recupererTousLesCandidats();
	Candidat rechercherCandidatParId(String id);

}
