package tn.essat.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.dao.IMagasinDao;
import tn.essat.dao.IProduitDao;
import tn.essat.model.Magasin;

@RestController
public class AppRest {
	
@Autowired
IProduitDao daop;
@Autowired
IMagasinDao daom;


public void setDaop(IProduitDao daop) {
	this.daop = daop;
}
public void setDaom(IMagasinDao daom) {
	this.daom = daom;
}
@GetMapping("/magasins")	
public List<Magasin> get1(){
	return daom.findAll();
}
@PostMapping("/addMagasin")
public void get2(@RequestBody Magasin mag) {
daom.save(mag);
}



}

