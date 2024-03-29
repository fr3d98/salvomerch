package it.salvomerch.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "prodotto_in_carrello", schema = "salvomerch")
public class ProdottoInCarrello {
    private Integer id;
    private Integer quantita;
    private Cliente cliente;
    private Prodotto prodotto;
    private double subTot;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Basic
    @Column(name = "quantita", nullable = true, precision = 0)
    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer totale) {
        this.quantita = totale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdottoInCarrello prodottoInCarrello = (ProdottoInCarrello) o;
        System.out.println(this.cliente+" "
                + prodottoInCarrello.getCliente().getEmail()+
                "\n"+this.getProdotto().getNome()+" "
                +prodottoInCarrello.getProdotto().getNome());
        return this.cliente.equals(prodottoInCarrello.getCliente()) && this.getProdotto().equals(prodottoInCarrello.getProdotto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, prodotto, quantita);
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable=false)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente clienteByCliente) {
        this.cliente = clienteByCliente;
    }

    @ManyToOne
    @JoinColumn(name = "prodotto", referencedColumnName = "id", nullable=false)
    public Prodotto getProdotto() {
        return prodotto;
    }


    public void setProdotto(Prodotto prodottiByProdotti) {
        this.prodotto = prodottiByProdotti;
    }
}
