package it.salvomerch.controllers;

import it.salvomerch.entities.Prodotto;
import it.salvomerch.servicies.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:4200")

public class ProdottiController {

    @Autowired
    private ProdottoService prodottoService;

    @GetMapping
    public List<Prodotto> allProducts(){
        return prodottoService.showAllProducts();
    }

    @PostMapping("/add")
    public void addProdotto(@RequestBody Prodotto prodotto){
        prodottoService.addProduct(prodotto);
    }

    @GetMapping("/{id}")
    public Prodotto getProdotto(@PathVariable("id") int id){
        return prodottoService.getProdotto(id);
    }
}
