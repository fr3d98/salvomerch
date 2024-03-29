package it.salvomerch.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ordine_prodotto", schema = "salvomerch")
public class OrdineProdotto {
    private Integer id;
   // private Integer ordine;
   // private Integer prodotto;
    private Ordine ordine;
    private Prodotto prodotto;
    private Integer quantita;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quantita", nullable = false)
    public Integer getQuantita() { return  quantita;}
    public void setQuantita(int q){
        this.quantita=q;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdineProdotto that = (OrdineProdotto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(ordine, that.ordine) &&
                Objects.equals(prodotto, that.prodotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ordine, prodotto);
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ordine", referencedColumnName = "id")
    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordineByOrdine) {
        this.ordine = ordineByOrdine;
    }

    @ManyToOne
    @JoinColumn(name = "prodotto", referencedColumnName = "id")
    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodottoByProdotto) {
        this.prodotto = prodottoByProdotto;
    }
}
