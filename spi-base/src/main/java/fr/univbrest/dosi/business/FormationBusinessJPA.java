package fr.univbrest.dosi.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;

@Component
public class FormationBusinessJPA implements FormationBusiness {
	
	private FormationRepository repos;
	
	@Autowired
	public FormationBusinessJPA(FormationRepository repos) {
		this.repos = repos;
	}
	
	@Override
	public Formation CreerFormation(Formation FormationACreer) {
		FormationACreer.setDebutAccreditation(new Date());
				
		return repos.save(FormationACreer);
		
	}

	@Override
	public List<Formation> recupererToutesLesFormations() {
			return (List<Formation>) repos.findAll();
	}

	@Override
	public List<Formation> rechercherFormationParNom(String nom) {
				return  repos.findByNomFormation(nom);
	}

}
