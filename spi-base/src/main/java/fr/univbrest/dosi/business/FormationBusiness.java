package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Formation;

public interface FormationBusiness {
	
	Formation CreerFormation(Formation FormationACreer);

	List<Formation> recupererToutesLesFormations();

	List<Formation> rechercherFormationParNom(String nom);
}
