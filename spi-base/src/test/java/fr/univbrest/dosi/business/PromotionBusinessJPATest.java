package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.business.CandidatBusinessJPATest.CandidatRepositoryList;
import fr.univbrest.dosi.repositories.CandidatRepository;
import fr.univbrest.dosi.repositories.PromotionRepository;

public class PromotionBusinessJPATest {

	PromotionBusinessJPA business ;
	
	@Test
	public void doitCreerPromotion() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		PromotionPK promotionPK = new PromotionPK("2013-2014","M2DOSI");
		Promotion promotion= new Promotion(promotionPK , new BigDecimal(10),"DOSI6");
		Promotion res = business.creerPromotion(promotion);
		assertThat(res.getSiglePromotion()).isEqualTo("DOSI6");
		assertThat(repos.count()).isEqualTo(1);
	}
	
	@Test
	public void doitSupprimerPromotion() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		PromotionPK promotionPK = new PromotionPK("2013-2014","M2DOSI");
		Promotion promotion= new Promotion(promotionPK , new BigDecimal(10),"DOSI6");
		business.repos.save(promotion);
		business.supprimerPromotion(promotionPK);
		assertThat(repos.count()).isEqualTo(0);
	}
	
	@Test
	public void doitRechercherPromotionParId() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		PromotionPK promotionPK = new PromotionPK("2013-2014","M2DOSI");
		Promotion promotion= new Promotion(promotionPK , new BigDecimal(10),"DOSI6");
		business.repos.save(promotion);
		Promotion res = business.recupererPromotionParId(promotionPK);
		assertThat(res.getSiglePromotion()).isEqualTo("DOSI6");
	}
	
	@Test
	public void doitRechercherPromotionParSigle() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		PromotionPK promotionPK = new PromotionPK("2013-2014","M2DOSI");
		Promotion promotion= new Promotion(promotionPK , new BigDecimal(10),"DOSI6");
		business.repos.save(promotion);
		List<Promotion> res = business.recupererPromotionParSigle("DOSI6");
		assertThat(res.get(0).getId()).isEqualTo(promotionPK);
	}
	
	@Test
	public void doitRechercherPromotionParEnseignant() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		PromotionPK promotionPK = new PromotionPK("2013-2014","M2DOSI");
		Promotion promotion= new Promotion(promotionPK , new BigDecimal(10),new BigDecimal(10),"DOSI6");
		business.repos.save(promotion);
		List<Promotion> res = business.recuperePromotionParEnseignant(new BigDecimal(10));
		assertThat(res.get(0).getId()).isEqualTo(promotionPK);
	}
	
	public void doitRetournerToutesLesPromotions() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		PromotionPK promotionPK1 = new PromotionPK("2013-2014","M2DOSI");
		Promotion promotion1= new Promotion(promotionPK1 , new BigDecimal(10),"DOSI6");
		business.repos.save(promotion1);
		PromotionPK promotionPK2 = new PromotionPK("2014-2015","M2DOSI");
		Promotion promotion2= new Promotion(promotionPK2 , new BigDecimal(10),"DOSI7");
		business.repos.save(promotion2);
		assertThat(repos.count()).isEqualTo(2);
		
	}
	public class PromotionRepositoryList implements PromotionRepository{

		List<Promotion> data;
		
		public PromotionRepositoryList() {
			data= new ArrayList();
		}

		@Override
		public <S extends Promotion> S save(S entity) {
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Promotion> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Promotion findOne(PromotionPK id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean exists(PromotionPK id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Promotion> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Promotion> findAll(Iterable<PromotionPK> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			return data.size();
		}

		@Override
		public void delete(PromotionPK id) {
			data.remove(business.recupererPromotionParId(id));
		}

		@Override
		public void delete(Promotion entity) {
			data.remove(entity);
			
		}

		@Override
		public void delete(Iterable<? extends Promotion> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		

		@Override
		public List<Promotion> findPromotionBySiglePromotion(String siglePromotion) {
			List<Promotion> P= new ArrayList<>();
			for(Promotion c:data) {
				if(c.getSiglePromotion()== siglePromotion) {
					P.add(c);
				}
			}
			return P;
		}

		@Override
		public List<Promotion> findPromotionByNoEnseignant(BigDecimal noEnseignant) {
			List<Promotion> P= new ArrayList<>();
			for(Promotion c:data) {
				if(c.getNoEnseignant().equals(noEnseignant)) {
					P.add(c);
				}
			}
			return P;
		}

		@Override
		public Promotion findById(PromotionPK id) {
			Promotion e = new Promotion();
			for(Promotion c:data) {
				if(c.getId()==id) {
					e=c;
				}
			}
			return e;
		}

		
		}
	
	
	
}
