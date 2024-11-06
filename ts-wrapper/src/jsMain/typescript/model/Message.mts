// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {MessageAttachment} from './embed/MessageAttachment.mjs';
import {MessageReadStatus} from './embed/MessageReadStatus.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface Message extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	fromAddress: string | undefined;

	fromHealthcarePartyId: string | undefined;

	formId: string | undefined;

	status: number | undefined;

	recipientsType: string | undefined;

	recipients: Array<string>;

	toAddresses: Array<string>;

	received: number | undefined;

	sent: number | undefined;

	metas: { [ key: string ]: string };

	readStatus: { [ key: string ]: MessageReadStatus };

	messageAttachments: Array<MessageAttachment>;

	transportGuid: string | undefined;

	remark: string | undefined;

	conversationGuid: string | undefined;

	subject: string | undefined;

	invoiceIds: Array<string>;

	parentId: string | undefined;

	externalRef: string | undefined;

	unassignedResults: Array<string>;

	assignedResults: { [ key: string ]: string };

	senderReferences: { [ key: string ]: string };

	readonly isEncrypted: boolean;

}

export class DecryptedMessage {

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

	fromAddress: string | undefined = undefined;

	fromHealthcarePartyId: string | undefined = undefined;

	formId: string | undefined = undefined;

	status: number | undefined = undefined;

	recipientsType: string | undefined = undefined;

	recipients: Array<string> = [];

	toAddresses: Array<string> = [];

	received: number | undefined = undefined;

	sent: number | undefined = undefined;

	metas: { [ key: string ]: string } = {};

	readStatus: { [ key: string ]: MessageReadStatus } = {};

	messageAttachments: Array<MessageAttachment> = [];

	transportGuid: string | undefined = undefined;

	remark: string | undefined = undefined;

	conversationGuid: string | undefined = undefined;

	subject: string | undefined = undefined;

	invoiceIds: Array<string> = [];

	parentId: string | undefined = undefined;

	externalRef: string | undefined = undefined;

	unassignedResults: Array<string> = [];

	assignedResults: { [ key: string ]: string } = {};

	senderReferences: { [ key: string ]: string } = {};

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedMessage>) {
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
		if ('fromAddress' in partial) this.fromAddress = partial.fromAddress;
		if ('fromHealthcarePartyId' in partial) this.fromHealthcarePartyId = partial.fromHealthcarePartyId;
		if ('formId' in partial) this.formId = partial.formId;
		if ('status' in partial) this.status = partial.status;
		if ('recipientsType' in partial) this.recipientsType = partial.recipientsType;
		if ('recipients' in partial && partial.recipients !== undefined) this.recipients = partial.recipients;
		if ('toAddresses' in partial && partial.toAddresses !== undefined) this.toAddresses = partial.toAddresses;
		if ('received' in partial) this.received = partial.received;
		if ('sent' in partial) this.sent = partial.sent;
		if ('metas' in partial && partial.metas !== undefined) this.metas = partial.metas;
		if ('readStatus' in partial && partial.readStatus !== undefined) this.readStatus = partial.readStatus;
		if ('messageAttachments' in partial && partial.messageAttachments !== undefined) this.messageAttachments = partial.messageAttachments;
		if ('transportGuid' in partial) this.transportGuid = partial.transportGuid;
		if ('remark' in partial) this.remark = partial.remark;
		if ('conversationGuid' in partial) this.conversationGuid = partial.conversationGuid;
		if ('subject' in partial) this.subject = partial.subject;
		if ('invoiceIds' in partial && partial.invoiceIds !== undefined) this.invoiceIds = partial.invoiceIds;
		if ('parentId' in partial) this.parentId = partial.parentId;
		if ('externalRef' in partial) this.externalRef = partial.externalRef;
		if ('unassignedResults' in partial && partial.unassignedResults !== undefined) this.unassignedResults = partial.unassignedResults;
		if ('assignedResults' in partial && partial.assignedResults !== undefined) this.assignedResults = partial.assignedResults;
		if ('senderReferences' in partial && partial.senderReferences !== undefined) this.senderReferences = partial.senderReferences;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
	}

}

export class EncryptedMessage {

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

	fromAddress: string | undefined = undefined;

	fromHealthcarePartyId: string | undefined = undefined;

	formId: string | undefined = undefined;

	status: number | undefined = undefined;

	recipientsType: string | undefined = undefined;

	recipients: Array<string> = [];

	toAddresses: Array<string> = [];

	received: number | undefined = undefined;

	sent: number | undefined = undefined;

	metas: { [ key: string ]: string } = {};

	readStatus: { [ key: string ]: MessageReadStatus } = {};

	messageAttachments: Array<MessageAttachment> = [];

	transportGuid: string | undefined = undefined;

	remark: string | undefined = undefined;

	conversationGuid: string | undefined = undefined;

	subject: string | undefined = undefined;

	invoiceIds: Array<string> = [];

	parentId: string | undefined = undefined;

	externalRef: string | undefined = undefined;

	unassignedResults: Array<string> = [];

	assignedResults: { [ key: string ]: string } = {};

	senderReferences: { [ key: string ]: string } = {};

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedMessage>) {
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
		if ('fromAddress' in partial) this.fromAddress = partial.fromAddress;
		if ('fromHealthcarePartyId' in partial) this.fromHealthcarePartyId = partial.fromHealthcarePartyId;
		if ('formId' in partial) this.formId = partial.formId;
		if ('status' in partial) this.status = partial.status;
		if ('recipientsType' in partial) this.recipientsType = partial.recipientsType;
		if ('recipients' in partial && partial.recipients !== undefined) this.recipients = partial.recipients;
		if ('toAddresses' in partial && partial.toAddresses !== undefined) this.toAddresses = partial.toAddresses;
		if ('received' in partial) this.received = partial.received;
		if ('sent' in partial) this.sent = partial.sent;
		if ('metas' in partial && partial.metas !== undefined) this.metas = partial.metas;
		if ('readStatus' in partial && partial.readStatus !== undefined) this.readStatus = partial.readStatus;
		if ('messageAttachments' in partial && partial.messageAttachments !== undefined) this.messageAttachments = partial.messageAttachments;
		if ('transportGuid' in partial) this.transportGuid = partial.transportGuid;
		if ('remark' in partial) this.remark = partial.remark;
		if ('conversationGuid' in partial) this.conversationGuid = partial.conversationGuid;
		if ('subject' in partial) this.subject = partial.subject;
		if ('invoiceIds' in partial && partial.invoiceIds !== undefined) this.invoiceIds = partial.invoiceIds;
		if ('parentId' in partial) this.parentId = partial.parentId;
		if ('externalRef' in partial) this.externalRef = partial.externalRef;
		if ('unassignedResults' in partial && partial.unassignedResults !== undefined) this.unassignedResults = partial.unassignedResults;
		if ('assignedResults' in partial && partial.assignedResults !== undefined) this.assignedResults = partial.assignedResults;
		if ('senderReferences' in partial && partial.senderReferences !== undefined) this.senderReferences = partial.senderReferences;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
	}

}
