import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ProdottoService} from "../../prodotto.service";
import {Router} from "@angular/router";
import {Prodotto} from "../../prodotto";

@Component({
  selector: 'app-add-up-prodotto',
  templateUrl: './add-up-prodotto.component.html',
  styleUrls: ['./add-up-prodotto.component.css']
})
export class AddUpProdottoComponent implements OnInit {

  @Input()
  prodotto : Prodotto;

  @Output()
  prodottoAddedEvent = new EventEmitter();

  constructor(private prodottoService : ProdottoService, private router : Router) { }

  ngOnInit(): void {
  }

  addProdotto() : void {
    this.prodottoService.addProdotto(this.prodotto).subscribe(
      (prodotto) => {
        this.prodottoAddedEvent.emit();
        this.router.navigate([]);
      }
    );
  }

  updateProdotto() : void {
    this.prodottoService.updateProdotto(this.prodotto).subscribe(
      (prodotto) =>{
        this.prodottoAddedEvent.emit()
        this.router.navigate([])}
    );
  }

}
