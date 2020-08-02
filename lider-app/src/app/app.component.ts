import { Component } from '@angular/core';

import { QuotationService } from './services/quotation.service';
import { ProductModel } from './models/product.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'lider-app';
  card: ProductModel[];
  search: string = "";
  page = 1;
  pageSize = 10;

  constructor (
    private service: QuotationService
  ) {

  }

  findProducts (data: string) {
    this.search = data;
    this.service.getProducts(data).subscribe(s => this.card = s);
  }

}
