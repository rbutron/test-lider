import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { ProductModel } from '../models/product.model';

@Injectable({
    providedIn: 'root'
})
export class QuotationService {

    private url: string = environment.baseUrl;
    constructor(
        private _http: HttpClient
    ) { }

    getProducts(data: string): Observable<ProductModel[]> {
        return this._http.get<ProductModel[]>(`${this.url}/v1/trigger/products`, {
            params: new HttpParams().set('query', data)
        });
    }

}