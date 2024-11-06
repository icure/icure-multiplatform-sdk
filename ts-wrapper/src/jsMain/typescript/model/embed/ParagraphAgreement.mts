// auto-generated file
import {AgreementAppendix} from './AgreementAppendix.mjs';


export class ParagraphAgreement {

	timestamp: number | undefined = undefined;

	paragraph: string | undefined = undefined;

	accepted: boolean | undefined = undefined;

	inTreatment: boolean | undefined = undefined;

	canceled: boolean | undefined = undefined;

	careProviderReference: string | undefined = undefined;

	decisionReference: string | undefined = undefined;

	start: number | undefined = undefined;

	end: number | undefined = undefined;

	cancelationDate: number | undefined = undefined;

	quantityValue: number | undefined = undefined;

	quantityUnit: string | undefined = undefined;

	ioRequestReference: string | undefined = undefined;

	responseType: string | undefined = undefined;

	refusalJustification: { [ key: string ]: string } | undefined = undefined;

	verses: Array<number> | undefined = undefined;

	coverageType: string | undefined = undefined;

	unitNumber: number | undefined = undefined;

	strength: number | undefined = undefined;

	strengthUnit: string | undefined = undefined;

	agreementAppendices: Array<AgreementAppendix> | undefined = undefined;

	documentId: string | undefined = undefined;

	constructor(partial: Partial<ParagraphAgreement>) {
		if ('timestamp' in partial) this.timestamp = partial.timestamp;
		if ('paragraph' in partial) this.paragraph = partial.paragraph;
		if ('accepted' in partial) this.accepted = partial.accepted;
		if ('inTreatment' in partial) this.inTreatment = partial.inTreatment;
		if ('canceled' in partial) this.canceled = partial.canceled;
		if ('careProviderReference' in partial) this.careProviderReference = partial.careProviderReference;
		if ('decisionReference' in partial) this.decisionReference = partial.decisionReference;
		if ('start' in partial) this.start = partial.start;
		if ('end' in partial) this.end = partial.end;
		if ('cancelationDate' in partial) this.cancelationDate = partial.cancelationDate;
		if ('quantityValue' in partial) this.quantityValue = partial.quantityValue;
		if ('quantityUnit' in partial) this.quantityUnit = partial.quantityUnit;
		if ('ioRequestReference' in partial) this.ioRequestReference = partial.ioRequestReference;
		if ('responseType' in partial) this.responseType = partial.responseType;
		if ('refusalJustification' in partial) this.refusalJustification = partial.refusalJustification;
		if ('verses' in partial) this.verses = partial.verses;
		if ('coverageType' in partial) this.coverageType = partial.coverageType;
		if ('unitNumber' in partial) this.unitNumber = partial.unitNumber;
		if ('strength' in partial) this.strength = partial.strength;
		if ('strengthUnit' in partial) this.strengthUnit = partial.strengthUnit;
		if ('agreementAppendices' in partial) this.agreementAppendices = partial.agreementAppendices;
		if ('documentId' in partial) this.documentId = partial.documentId;
	}

}
