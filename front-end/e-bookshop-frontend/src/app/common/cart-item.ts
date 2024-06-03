import { Product } from "./product";

export class CartItem {
    id: number;
    name: string;
    imageUrl: string;
    unitPrince: number;

    quantity: number;

    constructor(product: Product) {
        this.id = product.id;
        this.name = product.name;
        this.imageUrl = product.imageUrl;
        this.unitPrince = product.unitPrice;

        this.quantity = 1;
    }
}
