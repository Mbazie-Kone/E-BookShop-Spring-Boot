import { FormControl, ValidationErrors } from "@angular/forms";

export class EbookShopValidators {

    // whitespace validator
    static notOnlyWhitespace(control: FormControl) : ValidationErrors {
        // check if string only contains whitespace
        if(control.value != null) {

        }
        return null;
    }
}
