package fr.univbrest.dosi.business;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repositories.PromotionRepository;

@Component
public class PromotionBusinessJPA implements PromotionBusiness {

	PromotionRepository repos;
	
	@Autowired
	public PromotionBusinessJPA(PromotionRepository repos) {
		this.repos = repos;
	}

	@Override
	public Promotion creerPromotion(Promotion promotion) {
		
		return repos.save(promotion);
	}

	@Override
	public void supprimerPromotion(PromotionPK id) {
		repos.delete(recupererPromotionParId(id));
	}

	@Override
	public Promotion recupererPromotionParId(PromotionPK id) {
		return repos.findById(id);
	}
	

	@Override
	public List<Promotion> recupereToutesLesPromotions() {
		return (List<Promotion>) repos.findAll();
	}

	@Override
	public List<Promotion> recupererPromotionParSigle(String sigle) {
		return  repos.findPromotionBySiglePromotion(sigle);
	}

	@Override
	public List<Promotion> recuperePromotionParEnseignant(BigDecimal noEnseignant) {
		return repos.findPromotionByNoEnseignant(noEnseignant);
	}

}
