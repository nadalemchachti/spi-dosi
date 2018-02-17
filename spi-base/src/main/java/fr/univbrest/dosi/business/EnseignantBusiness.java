package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Enseignant;

public interface EnseignantBusiness {
	
	Enseignant creerEnseignant(Enseignant enseignant);
	void supprimerEnseignant(Long id);
	Enseignant recupererEnseignantParId(Long id);
	List<Enseignant> recupererEnseignantParPays(String Pays);
	List<Enseignant> recupererTousLesEnseignant();
	List<Enseignant> recupererEnseignantParNom(String nom);
	Enseignant recupererEnseignantParNomPrenom(String nom , String prenom);


}
