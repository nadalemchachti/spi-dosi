package fr.univbrest.dosi.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.CandidatRepository;
import static org.assertj.core.api.Assertions.assertThat;

public class CandidatBusinessJPATest {

	CandidatBusinessJPA business;
	
	
	@Test
	public void doitCreerUnCandidat() {
		CandidatRepository repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		Candidat candidat1 = new Candidat("1", "Morchid", "BenMsik");
		business.repos.save(candidat1);
		Candidat resultat = business.creerCandidat(candidat1);
		assertThat(resultat.getNom()).isEqualTo("Morchid");
		assertThat(resultat.getAdresse()).isEqualTo("Adresse");
		assertThat(resultat.getEmail()).isEqualTo("Email");
	}	
	
	@Test
	public void doitSupprimerUnCandidat() {
		CandidatRepository repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		Candidat candidat1 = new Candidat("1", "Morchid", "BenMsik");
		business.repos.save(candidat1);
		business.supprimerCandidat("1");
		assertThat(business.repos.count()).isEqualTo(0);
	}
	
	@Test
	public void doitRechercherUnCandidatParNom() {
		CandidatRepository repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		Candidat candidat1 = new Candidat("1", "Morchid", "BenMsik");
		business.repos.save(candidat1);
		List<Candidat> resultat =  business.rechercherCandidatParNom("Morchid");
		assertThat(resultat.get(0).getUniversiteOrigine()).isEqualTo("BenMsik");	
	}
	
	@Test
	public void doitRechercherUnCandidatParUniv() {
		CandidatRepository repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		Candidat candidat1 = new Candidat("1", "Morchid", "BenMsik");
		business.repos.save(candidat1);
		List<Candidat> resultat =  business.rechercherCandidatParUniversite("BenMsik");
		assertThat(resultat.get(0).getNom()).isEqualTo("Morchid");
	}
	
	public class CandidatRepositoryList implements CandidatRepository{

		private List<Candidat> data;
		
		public CandidatRepositoryList() {
			data = Lists.newArrayList();
		}

		@Override
		public long count() {
			return data.size();
		}

		@Override
		public void delete(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Candidat C) {	
					data.remove(C);										
			
		}

		@Override
		public void delete(Iterable<? extends Candidat> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean exists(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Candidat> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Candidat> findAll(Iterable<String> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Candidat findOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Candidat> S save(S entity) {
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Candidat> Iterable<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Candidat> findCandidatByNom(String nom) {
			List<Candidat> listeCandidat = new ArrayList<>();
			for(Candidat c : data) {
				if(c.getNom()==nom) {
					listeCandidat.add(c);										
				}
			}
			return listeCandidat;
		}

		@Override
		public List<Candidat> findCandidatByUniversiteOrigine(String universiteOrigine) {
			List<Candidat> listeCandidat = new ArrayList<>();
			for(Candidat c : data) {
				if(c.getUniversiteOrigine()==universiteOrigine ) {
					listeCandidat.add(c);										
				}
			}
			return listeCandidat;
		}

		@Override
		public Candidat findCandidatByNoCandidat(String id) {
			for(Candidat c : data) {
				if(c.getNoCandidat()==id ) {
					return c;										
				}
			}
			return null;
		}}

}
