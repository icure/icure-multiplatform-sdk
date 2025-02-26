// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {IdentityDocumentReader} from './embed/IdentityDocumentReader.mjs';
import {InvoiceInterventionType} from './embed/InvoiceInterventionType.mjs';
import {InvoiceType} from './embed/InvoiceType.mjs';
import {DecryptedInvoicingCode, EncryptedInvoicingCode, InvoicingCode} from './embed/InvoicingCode.mjs';
import {MediumType} from './embed/MediumType.mjs';
import {Payment} from './embed/Payment.mjs';
import {PaymentType} from './embed/PaymentType.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface Invoice extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	invoiceDate: number | undefined;

	sentDate: number | undefined;

	printedDate: number | undefined;

	invoicingCodes: Array<InvoicingCode>;

	receipts: { [ key: string ]: string };

	recipientType: string | undefined;

	recipientId: string | undefined;

	invoiceReference: string | undefined;

	decisionReference: string | undefined;

	thirdPartyReference: string | undefined;

	thirdPartyPaymentJustification: string | undefined;

	thirdPartyPaymentReason: string | undefined;

	reason: string | undefined;

	invoiceType: InvoiceType | undefined;

	sentMediumType: MediumType | undefined;

	interventionType: InvoiceInterventionType | undefined;

	groupId: string | undefined;

	paymentType: PaymentType | undefined;

	paid: number | undefined;

	payments: Array<Payment> | undefined;

	gnotionNihii: string | undefined;

	gnotionSsin: string | undefined;

	gnotionLastName: string | undefined;

	gnotionFirstName: string | undefined;

	gnotionCdHcParty: string | undefined;

	invoicePeriod: number | undefined;

	careProviderType: string | undefined;

	internshipNihii: string | undefined;

	internshipSsin: string | undefined;

	internshipLastName: string | undefined;

	internshipFirstName: string | undefined;

	internshipCdHcParty: string | undefined;

	internshipCbe: string | undefined;

	supervisorNihii: string | undefined;

	supervisorSsin: string | undefined;

	supervisorLastName: string | undefined;

	supervisorFirstName: string | undefined;

	supervisorCdHcParty: string | undefined;

	supervisorCbe: string | undefined;

	error: string | undefined;

	encounterLocationName: string | undefined;

	encounterLocationNihii: string | undefined;

	encounterLocationNorm: number | undefined;

	longDelayJustification: number | undefined;

	correctiveInvoiceId: string | undefined;

	correctedInvoiceId: string | undefined;

	creditNote: boolean | undefined;

	creditNoteRelatedInvoiceId: string | undefined;

	idDocument: IdentityDocumentReader | undefined;

	admissionDate: number | undefined;

	locationNihii: string | undefined;

	locationService: number | undefined;

	cancelReason: string | undefined;

	cancelDate: number | undefined;

	options: { [ key: string ]: string };

	readonly isEncrypted: boolean;

}

export class DecryptedInvoice {

	id: string;

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	invoiceDate: number | undefined = undefined;

	sentDate: number | undefined = undefined;

	printedDate: number | undefined = undefined;

	invoicingCodes: Array<DecryptedInvoicingCode> = [];

	receipts: { [ key: string ]: string } = {};

	recipientType: string | undefined = undefined;

	recipientId: string | undefined = undefined;

	invoiceReference: string | undefined = undefined;

	decisionReference: string | undefined = undefined;

	thirdPartyReference: string | undefined = undefined;

	thirdPartyPaymentJustification: string | undefined = undefined;

	thirdPartyPaymentReason: string | undefined = undefined;

	reason: string | undefined = undefined;

	invoiceType: InvoiceType | undefined = undefined;

	sentMediumType: MediumType | undefined = undefined;

	interventionType: InvoiceInterventionType | undefined = undefined;

	groupId: string | undefined = undefined;

	paymentType: PaymentType | undefined = undefined;

	paid: number | undefined = undefined;

	payments: Array<Payment> | undefined = undefined;

	gnotionNihii: string | undefined = undefined;

	gnotionSsin: string | undefined = undefined;

	gnotionLastName: string | undefined = undefined;

	gnotionFirstName: string | undefined = undefined;

	gnotionCdHcParty: string | undefined = undefined;

	invoicePeriod: number | undefined = undefined;

	careProviderType: string | undefined = undefined;

	internshipNihii: string | undefined = undefined;

	internshipSsin: string | undefined = undefined;

	internshipLastName: string | undefined = undefined;

	internshipFirstName: string | undefined = undefined;

	internshipCdHcParty: string | undefined = undefined;

	internshipCbe: string | undefined = undefined;

	supervisorNihii: string | undefined = undefined;

	supervisorSsin: string | undefined = undefined;

	supervisorLastName: string | undefined = undefined;

	supervisorFirstName: string | undefined = undefined;

	supervisorCdHcParty: string | undefined = undefined;

	supervisorCbe: string | undefined = undefined;

	error: string | undefined = undefined;

	encounterLocationName: string | undefined = undefined;

	encounterLocationNihii: string | undefined = undefined;

	encounterLocationNorm: number | undefined = undefined;

	longDelayJustification: number | undefined = undefined;

	correctiveInvoiceId: string | undefined = undefined;

	correctedInvoiceId: string | undefined = undefined;

	creditNote: boolean | undefined = undefined;

	creditNoteRelatedInvoiceId: string | undefined = undefined;

	idDocument: IdentityDocumentReader | undefined = undefined;

	admissionDate: number | undefined = undefined;

	locationNihii: string | undefined = undefined;

	locationService: number | undefined = undefined;

	cancelReason: string | undefined = undefined;

	cancelDate: number | undefined = undefined;

	options: { [ key: string ]: string } = {};

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedInvoice>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('invoiceDate' in partial) this.invoiceDate = partial.invoiceDate;
		if ('sentDate' in partial) this.sentDate = partial.sentDate;
		if ('printedDate' in partial) this.printedDate = partial.printedDate;
		if ('invoicingCodes' in partial && partial.invoicingCodes !== undefined) this.invoicingCodes = partial.invoicingCodes;
		if ('receipts' in partial && partial.receipts !== undefined) this.receipts = partial.receipts;
		if ('recipientType' in partial) this.recipientType = partial.recipientType;
		if ('recipientId' in partial) this.recipientId = partial.recipientId;
		if ('invoiceReference' in partial) this.invoiceReference = partial.invoiceReference;
		if ('decisionReference' in partial) this.decisionReference = partial.decisionReference;
		if ('thirdPartyReference' in partial) this.thirdPartyReference = partial.thirdPartyReference;
		if ('thirdPartyPaymentJustification' in partial) this.thirdPartyPaymentJustification = partial.thirdPartyPaymentJustification;
		if ('thirdPartyPaymentReason' in partial) this.thirdPartyPaymentReason = partial.thirdPartyPaymentReason;
		if ('reason' in partial) this.reason = partial.reason;
		if ('invoiceType' in partial) this.invoiceType = partial.invoiceType;
		if ('sentMediumType' in partial) this.sentMediumType = partial.sentMediumType;
		if ('interventionType' in partial) this.interventionType = partial.interventionType;
		if ('groupId' in partial) this.groupId = partial.groupId;
		if ('paymentType' in partial) this.paymentType = partial.paymentType;
		if ('paid' in partial) this.paid = partial.paid;
		if ('payments' in partial) this.payments = partial.payments;
		if ('gnotionNihii' in partial) this.gnotionNihii = partial.gnotionNihii;
		if ('gnotionSsin' in partial) this.gnotionSsin = partial.gnotionSsin;
		if ('gnotionLastName' in partial) this.gnotionLastName = partial.gnotionLastName;
		if ('gnotionFirstName' in partial) this.gnotionFirstName = partial.gnotionFirstName;
		if ('gnotionCdHcParty' in partial) this.gnotionCdHcParty = partial.gnotionCdHcParty;
		if ('invoicePeriod' in partial) this.invoicePeriod = partial.invoicePeriod;
		if ('careProviderType' in partial) this.careProviderType = partial.careProviderType;
		if ('internshipNihii' in partial) this.internshipNihii = partial.internshipNihii;
		if ('internshipSsin' in partial) this.internshipSsin = partial.internshipSsin;
		if ('internshipLastName' in partial) this.internshipLastName = partial.internshipLastName;
		if ('internshipFirstName' in partial) this.internshipFirstName = partial.internshipFirstName;
		if ('internshipCdHcParty' in partial) this.internshipCdHcParty = partial.internshipCdHcParty;
		if ('internshipCbe' in partial) this.internshipCbe = partial.internshipCbe;
		if ('supervisorNihii' in partial) this.supervisorNihii = partial.supervisorNihii;
		if ('supervisorSsin' in partial) this.supervisorSsin = partial.supervisorSsin;
		if ('supervisorLastName' in partial) this.supervisorLastName = partial.supervisorLastName;
		if ('supervisorFirstName' in partial) this.supervisorFirstName = partial.supervisorFirstName;
		if ('supervisorCdHcParty' in partial) this.supervisorCdHcParty = partial.supervisorCdHcParty;
		if ('supervisorCbe' in partial) this.supervisorCbe = partial.supervisorCbe;
		if ('error' in partial) this.error = partial.error;
		if ('encounterLocationName' in partial) this.encounterLocationName = partial.encounterLocationName;
		if ('encounterLocationNihii' in partial) this.encounterLocationNihii = partial.encounterLocationNihii;
		if ('encounterLocationNorm' in partial) this.encounterLocationNorm = partial.encounterLocationNorm;
		if ('longDelayJustification' in partial) this.longDelayJustification = partial.longDelayJustification;
		if ('correctiveInvoiceId' in partial) this.correctiveInvoiceId = partial.correctiveInvoiceId;
		if ('correctedInvoiceId' in partial) this.correctedInvoiceId = partial.correctedInvoiceId;
		if ('creditNote' in partial) this.creditNote = partial.creditNote;
		if ('creditNoteRelatedInvoiceId' in partial) this.creditNoteRelatedInvoiceId = partial.creditNoteRelatedInvoiceId;
		if ('idDocument' in partial) this.idDocument = partial.idDocument;
		if ('admissionDate' in partial) this.admissionDate = partial.admissionDate;
		if ('locationNihii' in partial) this.locationNihii = partial.locationNihii;
		if ('locationService' in partial) this.locationService = partial.locationService;
		if ('cancelReason' in partial) this.cancelReason = partial.cancelReason;
		if ('cancelDate' in partial) this.cancelDate = partial.cancelDate;
		if ('options' in partial && partial.options !== undefined) this.options = partial.options;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
	}

}

export class EncryptedInvoice {

	id: string;

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	invoiceDate: number | undefined = undefined;

	sentDate: number | undefined = undefined;

	printedDate: number | undefined = undefined;

	invoicingCodes: Array<EncryptedInvoicingCode> = [];

	receipts: { [ key: string ]: string } = {};

	recipientType: string | undefined = undefined;

	recipientId: string | undefined = undefined;

	invoiceReference: string | undefined = undefined;

	decisionReference: string | undefined = undefined;

	thirdPartyReference: string | undefined = undefined;

	thirdPartyPaymentJustification: string | undefined = undefined;

	thirdPartyPaymentReason: string | undefined = undefined;

	reason: string | undefined = undefined;

	invoiceType: InvoiceType | undefined = undefined;

	sentMediumType: MediumType | undefined = undefined;

	interventionType: InvoiceInterventionType | undefined = undefined;

	groupId: string | undefined = undefined;

	paymentType: PaymentType | undefined = undefined;

	paid: number | undefined = undefined;

	payments: Array<Payment> | undefined = undefined;

	gnotionNihii: string | undefined = undefined;

	gnotionSsin: string | undefined = undefined;

	gnotionLastName: string | undefined = undefined;

	gnotionFirstName: string | undefined = undefined;

	gnotionCdHcParty: string | undefined = undefined;

	invoicePeriod: number | undefined = undefined;

	careProviderType: string | undefined = undefined;

	internshipNihii: string | undefined = undefined;

	internshipSsin: string | undefined = undefined;

	internshipLastName: string | undefined = undefined;

	internshipFirstName: string | undefined = undefined;

	internshipCdHcParty: string | undefined = undefined;

	internshipCbe: string | undefined = undefined;

	supervisorNihii: string | undefined = undefined;

	supervisorSsin: string | undefined = undefined;

	supervisorLastName: string | undefined = undefined;

	supervisorFirstName: string | undefined = undefined;

	supervisorCdHcParty: string | undefined = undefined;

	supervisorCbe: string | undefined = undefined;

	error: string | undefined = undefined;

	encounterLocationName: string | undefined = undefined;

	encounterLocationNihii: string | undefined = undefined;

	encounterLocationNorm: number | undefined = undefined;

	longDelayJustification: number | undefined = undefined;

	correctiveInvoiceId: string | undefined = undefined;

	correctedInvoiceId: string | undefined = undefined;

	creditNote: boolean | undefined = undefined;

	creditNoteRelatedInvoiceId: string | undefined = undefined;

	idDocument: IdentityDocumentReader | undefined = undefined;

	admissionDate: number | undefined = undefined;

	locationNihii: string | undefined = undefined;

	locationService: number | undefined = undefined;

	cancelReason: string | undefined = undefined;

	cancelDate: number | undefined = undefined;

	options: { [ key: string ]: string } = {};

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedInvoice>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('invoiceDate' in partial) this.invoiceDate = partial.invoiceDate;
		if ('sentDate' in partial) this.sentDate = partial.sentDate;
		if ('printedDate' in partial) this.printedDate = partial.printedDate;
		if ('invoicingCodes' in partial && partial.invoicingCodes !== undefined) this.invoicingCodes = partial.invoicingCodes;
		if ('receipts' in partial && partial.receipts !== undefined) this.receipts = partial.receipts;
		if ('recipientType' in partial) this.recipientType = partial.recipientType;
		if ('recipientId' in partial) this.recipientId = partial.recipientId;
		if ('invoiceReference' in partial) this.invoiceReference = partial.invoiceReference;
		if ('decisionReference' in partial) this.decisionReference = partial.decisionReference;
		if ('thirdPartyReference' in partial) this.thirdPartyReference = partial.thirdPartyReference;
		if ('thirdPartyPaymentJustification' in partial) this.thirdPartyPaymentJustification = partial.thirdPartyPaymentJustification;
		if ('thirdPartyPaymentReason' in partial) this.thirdPartyPaymentReason = partial.thirdPartyPaymentReason;
		if ('reason' in partial) this.reason = partial.reason;
		if ('invoiceType' in partial) this.invoiceType = partial.invoiceType;
		if ('sentMediumType' in partial) this.sentMediumType = partial.sentMediumType;
		if ('interventionType' in partial) this.interventionType = partial.interventionType;
		if ('groupId' in partial) this.groupId = partial.groupId;
		if ('paymentType' in partial) this.paymentType = partial.paymentType;
		if ('paid' in partial) this.paid = partial.paid;
		if ('payments' in partial) this.payments = partial.payments;
		if ('gnotionNihii' in partial) this.gnotionNihii = partial.gnotionNihii;
		if ('gnotionSsin' in partial) this.gnotionSsin = partial.gnotionSsin;
		if ('gnotionLastName' in partial) this.gnotionLastName = partial.gnotionLastName;
		if ('gnotionFirstName' in partial) this.gnotionFirstName = partial.gnotionFirstName;
		if ('gnotionCdHcParty' in partial) this.gnotionCdHcParty = partial.gnotionCdHcParty;
		if ('invoicePeriod' in partial) this.invoicePeriod = partial.invoicePeriod;
		if ('careProviderType' in partial) this.careProviderType = partial.careProviderType;
		if ('internshipNihii' in partial) this.internshipNihii = partial.internshipNihii;
		if ('internshipSsin' in partial) this.internshipSsin = partial.internshipSsin;
		if ('internshipLastName' in partial) this.internshipLastName = partial.internshipLastName;
		if ('internshipFirstName' in partial) this.internshipFirstName = partial.internshipFirstName;
		if ('internshipCdHcParty' in partial) this.internshipCdHcParty = partial.internshipCdHcParty;
		if ('internshipCbe' in partial) this.internshipCbe = partial.internshipCbe;
		if ('supervisorNihii' in partial) this.supervisorNihii = partial.supervisorNihii;
		if ('supervisorSsin' in partial) this.supervisorSsin = partial.supervisorSsin;
		if ('supervisorLastName' in partial) this.supervisorLastName = partial.supervisorLastName;
		if ('supervisorFirstName' in partial) this.supervisorFirstName = partial.supervisorFirstName;
		if ('supervisorCdHcParty' in partial) this.supervisorCdHcParty = partial.supervisorCdHcParty;
		if ('supervisorCbe' in partial) this.supervisorCbe = partial.supervisorCbe;
		if ('error' in partial) this.error = partial.error;
		if ('encounterLocationName' in partial) this.encounterLocationName = partial.encounterLocationName;
		if ('encounterLocationNihii' in partial) this.encounterLocationNihii = partial.encounterLocationNihii;
		if ('encounterLocationNorm' in partial) this.encounterLocationNorm = partial.encounterLocationNorm;
		if ('longDelayJustification' in partial) this.longDelayJustification = partial.longDelayJustification;
		if ('correctiveInvoiceId' in partial) this.correctiveInvoiceId = partial.correctiveInvoiceId;
		if ('correctedInvoiceId' in partial) this.correctedInvoiceId = partial.correctedInvoiceId;
		if ('creditNote' in partial) this.creditNote = partial.creditNote;
		if ('creditNoteRelatedInvoiceId' in partial) this.creditNoteRelatedInvoiceId = partial.creditNoteRelatedInvoiceId;
		if ('idDocument' in partial) this.idDocument = partial.idDocument;
		if ('admissionDate' in partial) this.admissionDate = partial.admissionDate;
		if ('locationNihii' in partial) this.locationNihii = partial.locationNihii;
		if ('locationService' in partial) this.locationService = partial.locationService;
		if ('cancelReason' in partial) this.cancelReason = partial.cancelReason;
		if ('cancelDate' in partial) this.cancelDate = partial.cancelDate;
		if ('options' in partial && partial.options !== undefined) this.options = partial.options;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
	}

}
