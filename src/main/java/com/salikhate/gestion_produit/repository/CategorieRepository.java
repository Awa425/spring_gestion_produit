package com.salikhate.gestion_produit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salikhate.gestion_produit.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    
}
