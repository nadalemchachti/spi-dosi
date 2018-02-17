package fr.univbrest.dosi.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;
import static org.assertj.core.api.Assertions.assertThat;

public class FormationBusinessJPATest {

	FormationBusinessJPA business;
	@Test
	public void doitCreerUneFormation() {
		FormationRepository repos = new FormationRepositoryList();
		business = new FormationBusinessJPA(repos);
		Formation formation1 = new Formation("33", "M2", "O",  BigDecimal.valueOf(2.0), "DOSI");
		Formation resultat = business.CreerFormation(formation1);
		
		assertThat(resultat.getDebutAccreditation()).isCloseTo(new Date(), 500);
		assertThat(repos.count()).isEqualTo(1);
}
	
	class FormationRepositoryList implements FormationRepository{

		private List<Formation> data;
		public FormationRepositoryList() {
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
		public void delete(Formation arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Iterable<? extends Formation> arg0) {
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
		public Iterable<Formation> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Formation> findAll(Iterable<String> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Formation findOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Formation> S save(S entity) {
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Formation> Iterable<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Formation> findByNomFormation(String nomFormation) {
			List<Formation> listeFormation = new ArrayList<>();
			for(Formation f : data) {
				if(f.getNomFormation()== nomFormation ) {
					listeFormation.add(f);										
				}
			}
			return listeFormation;
		}
		
	}

}
