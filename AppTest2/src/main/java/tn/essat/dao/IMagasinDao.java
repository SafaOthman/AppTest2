package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.Magasin;

@Repository
public interface IMagasinDao  extends JpaRepository<Magasin, Integer>{

}
