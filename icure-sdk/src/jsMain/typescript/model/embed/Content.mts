// auto-generated file
import {Measure} from './Measure.mjs';
import {Medication} from './Medication.mjs';
import {DecryptedService, EncryptedService, Service} from './Service.mjs';
import {TimeSeries} from './TimeSeries.mjs';


export interface Content {

  stringValue: string | undefined;

  numberValue: number | undefined;

  booleanValue: boolean | undefined;

  instantValue: number | undefined;

  fuzzyDateValue: number | undefined;

  binaryValue: Int8Array | undefined;

  documentId: string | undefined;

  measureValue: Measure | undefined;

  medicationValue: Medication | undefined;

  timeSeries: TimeSeries | undefined;

  compoundValue: Array<Service> | undefined;

  ratio: Array<Measure> | undefined;

  range: Array<Measure> | undefined;

  readonly isEncrypted: boolean;

}

export class DecryptedContent {

  stringValue: string | undefined = undefined;

  numberValue: number | undefined = undefined;

  booleanValue: boolean | undefined = undefined;

  instantValue: number | undefined = undefined;

  fuzzyDateValue: number | undefined = undefined;

  binaryValue: Int8Array | undefined = undefined;

  documentId: string | undefined = undefined;

  measureValue: Measure | undefined = undefined;

  medicationValue: Medication | undefined = undefined;

  timeSeries: TimeSeries | undefined = undefined;

  compoundValue: Array<DecryptedService> | undefined = undefined;

  ratio: Array<Measure> | undefined = undefined;

  range: Array<Measure> | undefined = undefined;

  readonly isEncrypted: false = false;

  readonly $ktClass: 'com.icure.sdk.model.embed.DecryptedContent' = 'com.icure.sdk.model.embed.DecryptedContent';

  constructor(partial: Partial<DecryptedContent>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
    if ('stringValue' in partial) this.stringValue = partial.stringValue;
    if ('numberValue' in partial) this.numberValue = partial.numberValue;
    if ('booleanValue' in partial) this.booleanValue = partial.booleanValue;
    if ('instantValue' in partial) this.instantValue = partial.instantValue;
    if ('fuzzyDateValue' in partial) this.fuzzyDateValue = partial.fuzzyDateValue;
    if ('binaryValue' in partial) this.binaryValue = partial.binaryValue;
    if ('documentId' in partial) this.documentId = partial.documentId;
    if ('measureValue' in partial) this.measureValue = partial.measureValue;
    if ('medicationValue' in partial) this.medicationValue = partial.medicationValue;
    if ('timeSeries' in partial) this.timeSeries = partial.timeSeries;
    if ('compoundValue' in partial) this.compoundValue = partial.compoundValue;
    if ('ratio' in partial) this.ratio = partial.ratio;
    if ('range' in partial) this.range = partial.range;
  }

}

export class EncryptedContent {

  stringValue: string | undefined = undefined;

  numberValue: number | undefined = undefined;

  booleanValue: boolean | undefined = undefined;

  instantValue: number | undefined = undefined;

  fuzzyDateValue: number | undefined = undefined;

  binaryValue: Int8Array | undefined = undefined;

  documentId: string | undefined = undefined;

  measureValue: Measure | undefined = undefined;

  medicationValue: Medication | undefined = undefined;

  timeSeries: TimeSeries | undefined = undefined;

  compoundValue: Array<EncryptedService> | undefined = undefined;

  ratio: Array<Measure> | undefined = undefined;

  range: Array<Measure> | undefined = undefined;

  readonly isEncrypted: true = true;

  readonly $ktClass: 'com.icure.sdk.model.embed.EncryptedContent' = 'com.icure.sdk.model.embed.EncryptedContent';

  constructor(partial: Partial<EncryptedContent>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
    if ('stringValue' in partial) this.stringValue = partial.stringValue;
    if ('numberValue' in partial) this.numberValue = partial.numberValue;
    if ('booleanValue' in partial) this.booleanValue = partial.booleanValue;
    if ('instantValue' in partial) this.instantValue = partial.instantValue;
    if ('fuzzyDateValue' in partial) this.fuzzyDateValue = partial.fuzzyDateValue;
    if ('binaryValue' in partial) this.binaryValue = partial.binaryValue;
    if ('documentId' in partial) this.documentId = partial.documentId;
    if ('measureValue' in partial) this.measureValue = partial.measureValue;
    if ('medicationValue' in partial) this.medicationValue = partial.medicationValue;
    if ('timeSeries' in partial) this.timeSeries = partial.timeSeries;
    if ('compoundValue' in partial) this.compoundValue = partial.compoundValue;
    if ('ratio' in partial) this.ratio = partial.ratio;
    if ('range' in partial) this.range = partial.range;
  }

}
