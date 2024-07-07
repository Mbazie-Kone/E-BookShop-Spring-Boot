import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { EbookshopFormServiceService } from '../../services/ebookshop-form-service.service';
import { Country } from '../../common/country';
import { State } from '../../common/state';

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
  creditCardMonths: number[] = [];

  countries: Country[] = [];

  shippingAddressStates: State[] = [];
  billingAddressStates: State[] = [];

  constructor(private formBuilder: FormBuilder, private ebookshopFormService: EbookshopFormServiceService) {}

  ngOnInit(): void {
    this.checkoutFormGroup = this.formBuilder.group({
      customer: this.formBuilder.group({
        firstName: new FormControl('', [Validators.required, Validators.minLength(2)]),
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
    this.ebookshopFormService.getCreditCardMonths(startMonth).subscribe (
      data => {
        console.log("Retrieved credit card months: "+ JSON.stringify(data));
        this.creditCardMonths = data;
      }
    )

    // populate credit card years
    this.ebookshopFormService.getCreditCardYears().subscribe (
      data => {
        console.log("retrived credit card years: " + JSON.stringify(data));
        this.creditCardyears = data;
      }
    );

    // populate countries
    this.ebookshopFormService.getCountries().subscribe(
      data => {
        console.log("Retrieved countries: " + JSON.stringify(data));
        this.countries = data;
      }
    );
  }

  copyShippingAddressToBillingAddress(event:any):void {
    if(event.target.checked) {
      const billingAddress = (this.checkoutFormGroup.get('billingAddress') as FormGroup);
      const shippingAddress = (this.checkoutFormGroup.get('shippingAddress') as FormGroup);
      billingAddress.setValue(shippingAddress.value);
      // bug fix for states
      this.billingAddressStates = this.shippingAddressStates;
    }
    else {
      const billingAddress = (this.checkoutFormGroup.get('billingAddress') as FormGroup);
      billingAddress.reset();
      // bug fix for states
      this.billingAddressStates = [];
    }
  }

  onSubmit() {
    console.log("Handling the submit button");
    console.log(this.checkoutFormGroup.get('customer')?.value);
    console.log("the email address is "+ this.checkoutFormGroup.get('customer')?.value.email);
    console.log("the shipping address country is "+ this.checkoutFormGroup.get('shippingAddress')?.value.country.name);
    console.log("the shipping address state is "+ this.checkoutFormGroup.get('shippingAddress')?.value.state.name);
  }

  handleMonthsAndYears() {
    const creditCardFormGroup = this.checkoutFormGroup.get('creditCard');
    const currentYear: number = new Date().getFullYear();
    const selectedYear: number = Number(creditCardFormGroup?.value.expirationYear);
    // if the current year equals the selected year, then start with the current month
    let startMonth: number;
    if(currentYear === selectedYear) {
      startMonth = new Date().getMonth() + 1;
    }
    else {
      startMonth = 1;
    }
    this.ebookshopFormService.getCreditCardMonths(startMonth).subscribe(
      data => {
        console.log("Retrieved credit card months: " + JSON.stringify(data));
        this.creditCardMonths = data;
      }
    );
  }

  getStates(formGroupName: string) {
    const formGroup = this.checkoutFormGroup.get(formGroupName);
    const countryCode = formGroup?.value.country.code;
    const countryName = formGroup?.value.country.name;
    console.log(`${formGroupName} country code: ${countryCode}`);
    console.log(`${formGroupName} country name: ${countryName}`);
    this.ebookshopFormService.getStates(countryCode).subscribe(
      data => {
        if( formGroupName === 'shippingAddress') {
          this.shippingAddressStates = data;
        }
        else {
          this.billingAddressStates = data;
        }
        // select first item by default
        formGroup?.get('state')?.setValue(data[0]);
      }
    );
  }
}
