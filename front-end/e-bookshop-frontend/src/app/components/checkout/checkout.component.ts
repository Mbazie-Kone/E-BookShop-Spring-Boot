import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { EbookshopFormServiceService } from '../../services/ebookshop-form-service.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrl: './checkout.component.css'
})
export class CheckoutComponent implements OnInit{


  checkoutFormGroup: FormGroup;

  totalPrice: number = 0;
  totalQuantity: number = 0;

  creditCardyears: number[] = [];
  creditCardmonths: number[] = [];

  constructor(private formBuilder: FormBuilder, private ebookshopFormService: EbookshopFormServiceService) {}

  ngOnInit(): void {
    this.checkoutFormGroup = this.formBuilder.group({
      customer: this.formBuilder.group({
        firstName: [''],
        lastName: [''],
        email: ['']
      }),
      shippingAddress: this.formBuilder.group({
        street: [''],
        city: [''],
        state: [''],
        country: [''],
        zipCode: ['']
      }),
      billingAddress: this.formBuilder.group({
        street: [''],
        city: [''],
        state: [''],
        country: [''],
        zipCode: ['']
      }),
      creditCard: this.formBuilder.group({
        cardType: [''],
        nameOnCard: [''],
        cardNumber: [''],
        securityCode: [''],
        expirationMonth: [''],
        expirationYear: ['']
      })
    });

    // populate credit card months
    const startMonth: number = new Date().getMonth() + 1;
    console.log("startMonth: "+ startMonth);
    this.ebookshopFormService.getCreditCardMonths(startMonth).subscribe(
      data => {
        console.log("Retrieved credit card months: "+ JSON.stringify);
      }
    )

    // populate credit card years
  }

  copyShippingAddressToBillingAddress(event:any):void {
    if(event.target.checked) {
      const billingAddress = (this.checkoutFormGroup.get('billingAddress') as FormGroup);
      const shippingAddress = (this.checkoutFormGroup.get('shippingAddress') as FormGroup);
      billingAddress.setValue(shippingAddress.value);
    }
    else {
      const billingAddress = (this.checkoutFormGroup.get('billingAddress') as FormGroup);
      billingAddress.reset();
    }
  }

  onSubmit() {
    console.log("Handling the submit button");
    console.log(this.checkoutFormGroup.get('customer')?.value);
    console.log("the email address is "+ this.checkoutFormGroup.get('customer')?.value.email);
  }
}
