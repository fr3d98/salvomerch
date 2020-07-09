package it.salvomerch.controllers;

import it.salvomerch.entities.Categoria;
import it.salvomerch.entities.Prodotto;
import it.salvomerch.entities.ProdottoInCarrello;
import it.salvomerch.servicies.CarrelloService;
import it.salvomerch.servicies.CategoriaService;
import it.salvomerch.servicies.ClienteService;
import it.salvomerch.servicies.ProdottoService;
import it.salvomerch.support.Carrello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/shop")
@PreAuthorize("hasAuthority('clients')")
@CrossOrigin("http://localhost:4300")
public class ShopController {
    @Autowired
    private ProdottoService prodottoService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private CarrelloService carrelloService;

    @GetMapping
    public List<Prodotto> getProdotti(){
        return prodottoService.showAllProducts();
    }

    @GetMapping("/categorie")
    private List<Categoria> getCategorie(){
        return categoriaService.showAllCategories();
    }

    @GetMapping("/cart")
    private Carrello getCarrello(@AuthenticationPrincipal OidcUser user){
        return clienteService.getCarrello(user);
    }

    @PostMapping("/updatecart")
    private ResponseEntity setCarrello(@AuthenticationPrincipal OidcUser user, @RequestBody Carrello carrello){
        List<ProdottoInCarrello> newCarrello = carrelloService.updateCarrello(user,carrello.getProdotti());
        if( newCarrello!=null)
            return new ResponseEntity(newCarrello, HttpStatus.OK);
        return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);

    }
}
