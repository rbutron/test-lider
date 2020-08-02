export class ProductModel {

    private _identification: number;
	private _priceElement: number;
	private _discountElement: number;
	private _descriptionElement: string;
	private _imageElement: string;
    private _brandElement: string;
    
    get identification(): number {
        return this._identification;
    }
	get priceElement(): number {
        return this._priceElement;
    }
	get discountElement(): number {
        return this._discountElement;
    }
	get descriptionElement(): string {
        return this._descriptionElement;
    }
	get imageElement(): string {
        return this._imageElement;
    }
	get brandElement(): string {
        return this._brandElement;
    }

}