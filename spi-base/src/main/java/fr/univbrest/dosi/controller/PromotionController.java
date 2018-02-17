package fr.univbrest.dosi.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.business.PromotionBusiness;

@RestController
@RequestMapping("/Promotions")
public class PromotionController {
	private PromotionBusiness business ;

	@Autowired
	public PromotionController(PromotionBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Promotion creerPromotion(@RequestBody Promotion promotionACreer) {
		return business.creerPromotion(promotionACreer);	
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Promotion> recupererToutesLesPromotions() {
		return business.recupereToutesLesPromotions();	
	}
	
	@RequestMapping(method = RequestMethod.GET , value="sigle/{sigle}")
	public List<Promotion> recupererPromotionParSigle(@PathVariable String sigle) {
		return business.recupererPromotionParSigle(sigle);	
	}
	
	@RequestMapping(method = RequestMethod.GET , value="enseignant/{noenseignant}")
	public List<Promotion> recupererPromotionParNoEnseignant(@PathVariable String noenseignant) {
		return business.recuperePromotionParEnseignant(new BigDecimal(noenseignant));	
	}
	
	@RequestMapping(method = RequestMethod.GET , value="/{annee}/{code}")
	public Promotion recupererPromotionParId(@PathVariable String annee ,@PathVariable String code) {
		return business.recupererPromotionParId(new PromotionPK(annee,code));	
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/{annee}/{code}")
	public void supprimerPromotion(@PathVariable String annee ,@PathVariable String code) {
		business.supprimerPromotion(new PromotionPK(annee,code));
	}

}
