// auto-generated file
import {PaymentType} from './PaymentType.mjs';


export class Payment {

	paymentDate: number = 0;

	paymentType: PaymentType | undefined = undefined;

	paid: number | undefined = undefined;

	constructor(partial: Partial<Payment>) {
		if ('paymentDate' in partial && partial.paymentDate !== undefined) this.paymentDate = partial.paymentDate;
		if ('paymentType' in partial) this.paymentType = partial.paymentType;
		if ('paid' in partial) this.paid = partial.paid;
	}

}
