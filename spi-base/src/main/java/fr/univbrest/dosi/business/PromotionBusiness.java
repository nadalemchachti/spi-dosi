package fr.univbrest.dosi.business;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;

public interface PromotionBusiness {

	Promotion creerPromotion(Promotion promotion);
	void supprimerPromotion(PromotionPK id);
	Promotion recupererPromotionParId(PromotionPK id);
	List<Promotion> recupereToutesLesPromotions();
	List<Promotion> recupererPromotionParSigle(String sigle);
	List<Promotion> recuperePromotionParEnseignant(BigDecimal noEnseignant);
	
	
}
