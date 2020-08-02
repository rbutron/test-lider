import { Component, OnInit, Input } from '@angular/core';
import { ProductModel } from '../models/product.model';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {

  _card: ProductModel;
  
  @Input()
  set dataCard(card: ProductModel) {
    this._card = card;
  }

  @Input()
  obj: any;

  constructor() { }

  ngOnInit(): void {
  }

}
