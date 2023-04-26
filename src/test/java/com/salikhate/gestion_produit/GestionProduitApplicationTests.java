package com.salikhate.gestion_produit;

import org.junit.jupiter.api.Test;
// import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salikhate.gestion_produit.entities.Categorie;
import com.salikhate.gestion_produit.entities.Produit;
import com.salikhate.gestion_produit.repository.CategorieRepository;
import com.salikhate.gestion_produit.repository.ProduitRepository;

@SpringBootTest
class GestionProduitApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;

	@Autowired
	private CategorieRepository categorieRepository;

	@Test
	void contextLoads() {
	}

	// @Test
	// public void testCreateProduit() {
	// 	Produit prod = new Produit("PC Dell", 2200.500, new Date());
	// 	produitRepository.save(prod);
	// }

	@Test
	public void testFindProduit() {
		Produit p = produitRepository.findById(2L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit() {
		Produit p = produitRepository.findById(2L).get();
		p.setPrixProduit(1000.0);
		produitRepository.save(p);
	}

	@Test
	public void testDeleteProduit() {
		produitRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousProduits() {
		List<Produit> prods = produitRepository.findAll();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomProduit() {
		List<Produit> prods = produitRepository.findByNomProduit("iphone X");
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomProduitContains() {
		List<Produit> prods = produitRepository.findByNomProduitContains("iphone X");
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByNomPrix() {
		List<Produit> prods = produitRepository.findByNomPrix("iphone X", 1000.00);
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByCategorie() {
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		List<Produit> produits = produitRepository.findByCategorie(cat);
		for (Produit p : produits) {
			System.out.println("produit : " + p);
		}
	}

	@Test
	public void findByCategorieIdCat() {
		List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	// @Test
	// public void testfindByOrderByNomProduitAsc() {
	// List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
	// for (Produit p : prods) {
	// System.out.println(p);
	// }
	// }

	// Test Entity Category
	@Test
	public void testCreateCategorie() {
		Categorie cat = new Categorie(2L, "categorie 2", "description ", null);
		categorieRepository.save(cat);
	}
}
