// auto-generated file
import {Invoice} from '../../Invoice.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class InvoiceByHcPartyCodeDateFilter implements AbstractFilter<Invoice> {

  desc: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  code: string;

  startInvoiceDate: number | undefined = undefined;

  endInvoiceDate: number | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.invoice.InvoiceByHcPartyCodeDateFilter' = 'com.icure.sdk.model.filter.invoice.InvoiceByHcPartyCodeDateFilter';

  constructor(partial: Partial<InvoiceByHcPartyCodeDateFilter> & Pick<InvoiceByHcPartyCodeDateFilter, "code">) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    this.code = partial.code;
    if ('startInvoiceDate' in partial) this.startInvoiceDate = partial.startInvoiceDate;
    if ('endInvoiceDate' in partial) this.endInvoiceDate = partial.endInvoiceDate;
  }

}
