package com.salikhate.gestion_produit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.salikhate.gestion_produit.entities.Categorie;
import com.salikhate.gestion_produit.entities.Produit;

@RepositoryRestResource(path = "rest")
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findByNomProduit(String nomProduit);

    List<Produit> findByNomProduitContains(String nom);

    List<Produit> findByCategorieIdCat(Long id);

    @Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
    List<Produit> findByNomPrix(String nom, Double prix);

    @Query("select p from Produit p where p.categorie = ?1")
    List<Produit> findByCategorie(Categorie categorie);

}
