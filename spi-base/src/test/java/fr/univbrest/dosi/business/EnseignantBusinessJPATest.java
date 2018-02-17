package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;
public class EnseignantBusinessJPATest {
	
	EnseignantBusinessJPA business;
	
	@Test
	public void doitCreerEnseignant() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		business = new EnseignantBusinessJPA(repos);
		Enseignant enseignant = new Enseignant(10, "emailPerso", "mobile", "pays", "telephone");
		Enseignant res = business.creerEnseignant(enseignant);
		assertThat(res.getEmailPerso()).isEqualTo("emailPerso");
		assertThat(repos.count()).isEqualTo(1);
	}
	
	@Test
	public void doitSupprimerEnseignant() {
	    EnseignantRepository repos = new EnseignantRepositoryList();
	    business = new EnseignantBusinessJPA(repos);

		Enseignant enseignant = new Enseignant(10, "emailPerso", "mobile", "pays", "telephone");
	    business.repos.save(enseignant);
	    business.supprimerEnseignant(10L);
	    assertThat(repos.count()).isEqualTo(0);
	  }
	
	@Test
	public void doitRecupererTousLesEnseignants() {
		EnseignantRepository repos = new EnseignantRepositoryList();
	    business = new EnseignantBusinessJPA(repos);
		Enseignant enseignant1 = new Enseignant(10, "emailPerso", "mobile", "pays", "telephone");
	    business.repos.save(enseignant1);
		Enseignant enseignant2 = new Enseignant(11, "emailPerso", "mobile", "pays", "telephone");
	    business.repos.save(enseignant2);
	    assertThat(repos.count()).isEqualTo(2);
	}
	
	@Test
	public void doitRecupererEnseignantParId() {
		EnseignantRepository repos = new EnseignantRepositoryList();
	    business = new EnseignantBusinessJPA(repos);
		Enseignant enseignant1 = new Enseignant(10, "emailPerso", "mobile", "pays", "telephone");
	    business.repos.save(enseignant1);
	    Enseignant res = business.recupererEnseignantParId(10L);
	    assertThat(res.getEmailPerso()).isEqualTo("emailPerso");
	}
	
	@Test
	public void doitRecupererEnseignantParPays() {
		EnseignantRepository repos = new EnseignantRepositoryList();
	    business = new EnseignantBusinessJPA(repos);
		Enseignant enseignant1 = new Enseignant(10, "emailPerso", "mobile", "pays", "telephone");
	    business.repos.save(enseignant1);
	    List<Enseignant> res = business.recupererEnseignantParPays("pays");
	    assertThat(res.get(0).getEmailPerso()).isEqualTo("emailPerso");
	}
	
	@Test
	public void doitRecupererEnseignantParNom() {
		EnseignantRepository repos = new EnseignantRepositoryList();
	    business = new EnseignantBusinessJPA(repos);
		Enseignant enseignant1 = new Enseignant(10, "xx", "pays");
	    business.repos.save(enseignant1);
	    List<Enseignant> res = business.recupererEnseignantParNom("xx");
	    assertThat(res.get(0).getPays()).isEqualTo("pays");
	}
	
	
	public class EnseignantRepositoryList implements EnseignantRepository{

		List<Enseignant> data;
		
		public EnseignantRepositoryList() {
		
			this.data = new ArrayList<>();
		}

		@Override
		public <S extends Enseignant> S save(S entity) {
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Enseignant> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Enseignant findOne(Long id) {
			
			return null ;
		}

		@Override
		public boolean exists(Long id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Enseignant> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Enseignant> findAll(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			return data.size();
		}

		@Override
		public void delete(Long id) {
			data.remove(business.recupererEnseignantParId(id));
			}

		@Override
		public void delete(Enseignant entity) {
			data.remove(entity);
			
		}

		@Override
		public void delete(Iterable<? extends Enseignant> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Enseignant findEnseignantByNoEnseignant(Long noEnseignant) {
			Enseignant P= new Enseignant();
		      for(Enseignant c:data) {
		        if(c.getNoEnseignant()==noEnseignant) {
		          P=c;
		        }
		      }
		      return P;
			
		}

		

		@Override
		public List<Enseignant> findEnseignantByPays(String pays) {
			List<Enseignant> P= new ArrayList<>();
		      for(Enseignant c:data) {
		        if(c.getPays()==pays) {
		          P.add(c);
		        }
		      }
		      return P;
			
		}

		@Override
		public List<Enseignant> findEnseignantByNom(String nom) {
			List<Enseignant> P= new ArrayList<>();
		      for(Enseignant c:data) {
		        if(c.getNom()==nom) {
		          P.add(c);
		        }
		      }
		      return P;
		}
		
	}

}
