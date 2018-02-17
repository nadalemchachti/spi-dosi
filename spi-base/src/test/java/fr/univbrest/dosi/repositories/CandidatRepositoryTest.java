package fr.univbrest.dosi.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Formation;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class CandidatRepositoryTest {
	
	@Autowired
	CandidatRepository candidatRepo;
	
	@Before
	public void setup() {
		Candidat candidat1 = new Candidat("1", "Morchid", "BenMsik");
		Candidat candidat2 = new Candidat("2", "Lemchachti", "Ensat");
		Candidat candidat3 = new Candidat("3", "Elgharss", "Fst");
	
		candidatRepo.save(candidat1);
		candidatRepo.save(candidat2);
		candidatRepo.save(candidat3);
	}
	
	@Test
	public void doitRechercherParNom() {
		List<Candidat> resultat = candidatRepo.findCandidatByNom("Morchid");
		
		assertThat(resultat.get(0).getNom()).isEqualTo("Morchid");
	}
	
	@Test
	public void doitRechercherParUnivOrigine() {
		List<Candidat> resultat = candidatRepo.findCandidatByUniversiteOrigine("Ensat");
		
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getUniversiteOrigine()).isEqualTo("Ensat");
		
	}
	
	
	

}
