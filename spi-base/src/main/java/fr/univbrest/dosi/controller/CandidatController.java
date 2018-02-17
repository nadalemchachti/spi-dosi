package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.business.CandidatBusiness;

@RestController
@RequestMapping("/candidats")
public class CandidatController {
	
	CandidatBusiness business;

	@Autowired
	public CandidatController(CandidatBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.GET)  
	List<Candidat> recupererTousLesCandidats(){
		return business.recupererTousLesCandidats();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Candidat ajouterCandidat(@RequestBody Candidat candidatAAjouter) {
		return business.creerCandidat(candidatAAjouter);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/id/{idCandidatASupprimer}")
	public void supprimerCandidat(@PathVariable String idCandidatASupprimer) {
		business.supprimerCandidat(idCandidatASupprimer);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/nom/{nomCandidat}")
	public List<Candidat> recupererCandidatParNom(@PathVariable String nomCandidat) {
		return business.rechercherCandidatParNom(nomCandidat);
	}	
	
	@RequestMapping(method = RequestMethod.GET, value="/universite/{univCandidat}")
	public List<Candidat> recupererCandidatParUniv(@PathVariable String univCandidat) {
		return business.rechercherCandidatParUniversite(univCandidat);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Candidat recupererCandidatParId(@PathVariable String id) {
		return business.rechercherCandidatParId(id);
	}
	
	
	
	

}
