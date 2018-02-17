package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.FormationBusiness;

@RestController
@RequestMapping("/formations")
public class FormationController {
	private FormationBusiness business ;
	
	@Autowired 
	public FormationController(FormationBusiness business) {
		this.business = business; 
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Formation creerFormation(@RequestBody Formation formationACreer) {
		return business.CreerFormation(formationACreer);	
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Formation> recupererToutesLesFormations(){
		return business.recupererToutesLesFormations();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/nom/{nom}")
	public List<Formation> recupereLaFormationAvecLeNom(@PathVariable String nom) {
		return business.rechercherFormationParNom(nom);
	}
	
}
