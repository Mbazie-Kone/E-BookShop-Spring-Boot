import { Address } from "./address";
import { Customer } from "./customer";

export class Purchase {
    customer: Customer;
    shippingAddress: Address;
    billingAddress: Address;
}
