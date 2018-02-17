package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.business.EnseignantBusiness;

@RestController
@RequestMapping("/enseignants")
public class EnseignantController {
	private EnseignantBusiness business ;

	@Autowired
	public EnseignantController(EnseignantBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	  public Enseignant creerEnseignant(@RequestBody Enseignant EnseignantACreer) {
	    return business.creerEnseignant(EnseignantACreer);  
	  }
	  
	  @RequestMapping(method = RequestMethod.GET)
	  public List<Enseignant> recupererToutesLesEnseignants() {
	    return business.recupererTousLesEnseignant();  
	  }
	
	  @RequestMapping(method = RequestMethod.GET, value="/{id}")
	  public Enseignant recupererEnseignantParId(@PathVariable String id) {
	    return business.recupererEnseignantParId(Long.valueOf(id));  
	  }
	  
	  @RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	  public void supprimerEnseignant(@PathVariable String id) {
	      business.supprimerEnseignant(Long.valueOf(id));  
	  }
	
	  
	  @RequestMapping(method = RequestMethod.GET, value="/pays/{pays}")
	  public List<Enseignant> recupererEnseignantParPays(@PathVariable String pays) {
	    return business.recupererEnseignantParPays(pays);  
	  }
	  
	  @RequestMapping(method = RequestMethod.GET, value="/nom/{nom}")
	  public List<Enseignant> recupererEnseignantParNom(@PathVariable String nom) {
	    return business.recupererEnseignantParNom(nom);  
	  }
	  @RequestMapping(method = RequestMethod.GET, value="/nom/{nom}/prenom/{prenom}")
	  public Enseignant recupererEnseignantParNomPrenom(@PathVariable String nom,@PathVariable String prenom) {
	    return business.recupererEnseignantParNomPrenom(nom, prenom);  
	  }
}
