// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/invoicing_code.dart';
import 'package:cardinal_sdk/model/embed/invoice_type.dart';
import 'package:cardinal_sdk/model/embed/medium_type.dart';
import 'package:cardinal_sdk/model/embed/invoice_intervention_type.dart';
import 'package:cardinal_sdk/model/embed/payment_type.dart';
import 'package:cardinal_sdk/model/embed/payment.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/identity_document_reader.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/invoice.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class Invoice implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
	@override abstract String id;
	@override abstract String? rev;
	@override abstract int? created;
	@override abstract int? modified;
	@override abstract String? author;
	@override abstract String? responsible;
	@override abstract String? medicalLocationId;
	@override abstract Set<CodeStub> tags;
	@override abstract Set<CodeStub> codes;
	@override abstract int? endOfLife;
	@override abstract int? deletionDate;
	abstract int? invoiceDate;
	abstract int? sentDate;
	abstract int? printedDate;
	List<InvoicingCode> get invoicingCodes;
	abstract Map<String, String> receipts;
	abstract String? recipientType;
	abstract String? recipientId;
	abstract String? invoiceReference;
	abstract String? thirdPartyReference;
	abstract String? thirdPartyPaymentJustification;
	abstract String? thirdPartyPaymentReason;
	abstract String? reason;
	abstract InvoiceType? invoiceType;
	abstract MediumType? sentMediumType;
	abstract InvoiceInterventionType? interventionType;
	abstract String? groupId;
	abstract PaymentType? paymentType;
	abstract double? paid;
	abstract List<Payment>? payments;
	abstract String? gnotionNihii;
	abstract String? gnotionSsin;
	abstract String? gnotionLastName;
	abstract String? gnotionFirstName;
	abstract String? gnotionCdHcParty;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? invoicePeriod;
	abstract String? careProviderType;
	abstract String? internshipNihii;
	abstract String? internshipSsin;
	abstract String? internshipLastName;
	abstract String? internshipFirstName;
	abstract String? internshipCdHcParty;
	abstract String? internshipCbe;
	abstract String? supervisorNihii;
	abstract String? supervisorSsin;
	abstract String? supervisorLastName;
	abstract String? supervisorFirstName;
	abstract String? supervisorCdHcParty;
	abstract String? supervisorCbe;
	abstract String? error;
	abstract String? encounterLocationName;
	abstract String? encounterLocationNihii;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? encounterLocationNorm;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? longDelayJustification;
	abstract String? correctiveInvoiceId;
	abstract String? correctedInvoiceId;
	abstract bool? creditNote;
	abstract String? creditNoteRelatedInvoiceId;
	abstract IdentityDocumentReader? idDocument;
	abstract int? admissionDate;
	abstract String? locationNihii;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? locationService;
	abstract String? cancelReason;
	abstract int? cancelDate;
	abstract Map<String, String> options;
	@override abstract Set<String> secretForeignKeys;
	@override abstract Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract Map<String, Set<Delegation>> delegations;
	@override abstract Map<String, Set<Delegation>> encryptionKeys;
	@override abstract Base64String? encryptedSelf;
	@override abstract SecurityMetadata? securityMetadata;

	static Map<String, dynamic> encode(Invoice value) {
		switch (value) {
			case DecryptedInvoice entity:
				Map<String, dynamic> entityJson = DecryptedInvoice.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedInvoice";
				return entityJson;
			case EncryptedInvoice entity:
				Map<String, dynamic> entityJson = EncryptedInvoice.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedInvoice";
				return entityJson;
		}
	}

	static Invoice fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.DecryptedInvoice":
				return DecryptedInvoice.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedInvoice":
				return EncryptedInvoice.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class DecryptedInvoice implements Invoice {
	@override String id;
	@override String? rev;
	@override int? created;
	@override int? modified;
	@override String? author;
	@override String? responsible;
	@override String? medicalLocationId;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife;
	@override int? deletionDate;
	@override int? invoiceDate;
	@override int? sentDate;
	@override int? printedDate;
	@override List<DecryptedInvoicingCode> invoicingCodes = [];
	@override Map<String, String> receipts = {};
	@override String? recipientType;
	@override String? recipientId;
	@override String? invoiceReference;
	@override String? thirdPartyReference;
	@override String? thirdPartyPaymentJustification;
	@override String? thirdPartyPaymentReason;
	@override String? reason;
	@override InvoiceType? invoiceType;
	@override MediumType? sentMediumType;
	@override InvoiceInterventionType? interventionType;
	@override String? groupId;
	@override PaymentType? paymentType;
	@override double? paid;
	@override List<Payment>? payments;
	@override String? gnotionNihii;
	@override String? gnotionSsin;
	@override String? gnotionLastName;
	@override String? gnotionFirstName;
	@override String? gnotionCdHcParty;
	int? _invoicePeriod;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get invoicePeriod => _invoicePeriod;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set invoicePeriod(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('invoicePeriod value cannot exceed 2147483647');
		}
		_invoicePeriod = value;
	}
	@override String? careProviderType;
	@override String? internshipNihii;
	@override String? internshipSsin;
	@override String? internshipLastName;
	@override String? internshipFirstName;
	@override String? internshipCdHcParty;
	@override String? internshipCbe;
	@override String? supervisorNihii;
	@override String? supervisorSsin;
	@override String? supervisorLastName;
	@override String? supervisorFirstName;
	@override String? supervisorCdHcParty;
	@override String? supervisorCbe;
	@override String? error;
	@override String? encounterLocationName;
	@override String? encounterLocationNihii;
	int? _encounterLocationNorm;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get encounterLocationNorm => _encounterLocationNorm;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set encounterLocationNorm(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('encounterLocationNorm value cannot exceed 2147483647');
		}
		_encounterLocationNorm = value;
	}
	int? _longDelayJustification;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get longDelayJustification => _longDelayJustification;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set longDelayJustification(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('longDelayJustification value cannot exceed 2147483647');
		}
		_longDelayJustification = value;
	}
	@override String? correctiveInvoiceId;
	@override String? correctedInvoiceId;
	@override bool? creditNote;
	@override String? creditNoteRelatedInvoiceId;
	@override IdentityDocumentReader? idDocument;
	@override int? admissionDate;
	@override String? locationNihii;
	int? _locationService;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get locationService => _locationService;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set locationService(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('locationService value cannot exceed 2147483647');
		}
		_locationService = value;
	}
	@override String? cancelReason;
	@override int? cancelDate;
	@override Map<String, String> options = {};
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	DecryptedInvoice(
		this.id,
		{
			int? invoicePeriod,
			int? encounterLocationNorm,
			int? longDelayJustification,
			int? locationService,
			this.rev,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.medicalLocationId,
			this.endOfLife,
			this.deletionDate,
			this.invoiceDate,
			this.sentDate,
			this.printedDate,
			this.recipientType,
			this.recipientId,
			this.invoiceReference,
			this.thirdPartyReference,
			this.thirdPartyPaymentJustification,
			this.thirdPartyPaymentReason,
			this.reason,
			this.invoiceType,
			this.sentMediumType,
			this.interventionType,
			this.groupId,
			this.paymentType,
			this.paid,
			this.payments,
			this.gnotionNihii,
			this.gnotionSsin,
			this.gnotionLastName,
			this.gnotionFirstName,
			this.gnotionCdHcParty,
			this.careProviderType,
			this.internshipNihii,
			this.internshipSsin,
			this.internshipLastName,
			this.internshipFirstName,
			this.internshipCdHcParty,
			this.internshipCbe,
			this.supervisorNihii,
			this.supervisorSsin,
			this.supervisorLastName,
			this.supervisorFirstName,
			this.supervisorCdHcParty,
			this.supervisorCbe,
			this.error,
			this.encounterLocationName,
			this.encounterLocationNihii,
			this.correctiveInvoiceId,
			this.correctedInvoiceId,
			this.creditNote,
			this.creditNoteRelatedInvoiceId,
			this.idDocument,
			this.admissionDate,
			this.locationNihii,
			this.cancelReason,
			this.cancelDate,
			this.encryptedSelf,
			this.securityMetadata,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			List<DecryptedInvoicingCode>? invoicingCodes,
			Map<String, String>? receipts,
			Map<String, String>? options,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys
		}) : tags = tags ?? {},
		codes = codes ?? {},
		invoicingCodes = invoicingCodes ?? [],
		receipts = receipts ?? {},
		options = options ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		_invoicePeriod = invoicePeriod,
		_encounterLocationNorm = encounterLocationNorm,
		_longDelayJustification = longDelayJustification,
		_locationService = locationService;

	factory DecryptedInvoice.fromJSON(Map<String, dynamic> data) {
		return DecryptedInvoice(
			data["id"],
			invoicePeriod: data["invoicePeriod"],
			encounterLocationNorm: data["encounterLocationNorm"],
			longDelayJustification: data["longDelayJustification"],
			locationService: data["locationService"],
			rev: data["rev"],
			created: data["created"],
			modified: data["modified"],
			author: data["author"],
			responsible: data["responsible"],
			medicalLocationId: data["medicalLocationId"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ),
			endOfLife: data["endOfLife"],
			deletionDate: data["deletionDate"],
			invoiceDate: data["invoiceDate"],
			sentDate: data["sentDate"],
			printedDate: data["printedDate"],
			invoicingCodes: data["invoicingCodes"].map((x0) => DecryptedInvoicingCode.fromJSON(x0) ),
			receipts: data["receipts"].map((k0, v0) => MapEntry(k0, v0)),
			recipientType: data["recipientType"],
			recipientId: data["recipientId"],
			invoiceReference: data["invoiceReference"],
			thirdPartyReference: data["thirdPartyReference"],
			thirdPartyPaymentJustification: data["thirdPartyPaymentJustification"],
			thirdPartyPaymentReason: data["thirdPartyPaymentReason"],
			reason: data["reason"],
			invoiceType: data["invoiceType"] == null ? null : InvoiceType.fromJSON(data["invoiceType"]),
			sentMediumType: data["sentMediumType"] == null ? null : MediumType.fromJSON(data["sentMediumType"]),
			interventionType: data["interventionType"] == null ? null : InvoiceInterventionType.fromJSON(data["interventionType"]),
			groupId: data["groupId"],
			paymentType: data["paymentType"] == null ? null : PaymentType.fromJSON(data["paymentType"]),
			paid: data["paid"],
			payments: data["payments"]?.map((x0) => Payment.fromJSON(x0) ),
			gnotionNihii: data["gnotionNihii"],
			gnotionSsin: data["gnotionSsin"],
			gnotionLastName: data["gnotionLastName"],
			gnotionFirstName: data["gnotionFirstName"],
			gnotionCdHcParty: data["gnotionCdHcParty"],
			careProviderType: data["careProviderType"],
			internshipNihii: data["internshipNihii"],
			internshipSsin: data["internshipSsin"],
			internshipLastName: data["internshipLastName"],
			internshipFirstName: data["internshipFirstName"],
			internshipCdHcParty: data["internshipCdHcParty"],
			internshipCbe: data["internshipCbe"],
			supervisorNihii: data["supervisorNihii"],
			supervisorSsin: data["supervisorSsin"],
			supervisorLastName: data["supervisorLastName"],
			supervisorFirstName: data["supervisorFirstName"],
			supervisorCdHcParty: data["supervisorCdHcParty"],
			supervisorCbe: data["supervisorCbe"],
			error: data["error"],
			encounterLocationName: data["encounterLocationName"],
			encounterLocationNihii: data["encounterLocationNihii"],
			correctiveInvoiceId: data["correctiveInvoiceId"],
			correctedInvoiceId: data["correctedInvoiceId"],
			creditNote: data["creditNote"],
			creditNoteRelatedInvoiceId: data["creditNoteRelatedInvoiceId"],
			idDocument: data["idDocument"] == null ? null : IdentityDocumentReader.fromJSON(data["idDocument"]),
			admissionDate: data["admissionDate"],
			locationNihii: data["locationNihii"],
			cancelReason: data["cancelReason"],
			cancelDate: data["cancelDate"],
			options: data["options"].map((k0, v0) => MapEntry(k0, v0)),
			secretForeignKeys: data["secretForeignKeys"].map((x0) => x0 ),
			cryptedForeignKeys: data["cryptedForeignKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ))),
			delegations: data["delegations"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ))),
			encryptionKeys: data["encryptionKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ))),
			encryptedSelf: data["encryptedSelf"],
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

	static Map<String, dynamic> encode(DecryptedInvoice value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"invoiceDate" : value.invoiceDate,
			"sentDate" : value.sentDate,
			"printedDate" : value.printedDate,
			"invoicingCodes" : value.invoicingCodes.map((x0) => DecryptedInvoicingCode.encode(x0)),
			"receipts" : value.receipts.map((k0, v0) => MapEntry(k0, v0)),
			"recipientType" : value.recipientType,
			"recipientId" : value.recipientId,
			"invoiceReference" : value.invoiceReference,
			"thirdPartyReference" : value.thirdPartyReference,
			"thirdPartyPaymentJustification" : value.thirdPartyPaymentJustification,
			"thirdPartyPaymentReason" : value.thirdPartyPaymentReason,
			"reason" : value.reason,
			"invoiceType" : value.invoiceType == null ? null : InvoiceType.encode(value.invoiceType!),
			"sentMediumType" : value.sentMediumType == null ? null : MediumType.encode(value.sentMediumType!),
			"interventionType" : value.interventionType == null ? null : InvoiceInterventionType.encode(value.interventionType!),
			"groupId" : value.groupId,
			"paymentType" : value.paymentType == null ? null : PaymentType.encode(value.paymentType!),
			"paid" : value.paid,
			"payments" : value.payments?.map((x0) => Payment.encode(x0)),
			"gnotionNihii" : value.gnotionNihii,
			"gnotionSsin" : value.gnotionSsin,
			"gnotionLastName" : value.gnotionLastName,
			"gnotionFirstName" : value.gnotionFirstName,
			"gnotionCdHcParty" : value.gnotionCdHcParty,
			"invoicePeriod" : value.invoicePeriod,
			"careProviderType" : value.careProviderType,
			"internshipNihii" : value.internshipNihii,
			"internshipSsin" : value.internshipSsin,
			"internshipLastName" : value.internshipLastName,
			"internshipFirstName" : value.internshipFirstName,
			"internshipCdHcParty" : value.internshipCdHcParty,
			"internshipCbe" : value.internshipCbe,
			"supervisorNihii" : value.supervisorNihii,
			"supervisorSsin" : value.supervisorSsin,
			"supervisorLastName" : value.supervisorLastName,
			"supervisorFirstName" : value.supervisorFirstName,
			"supervisorCdHcParty" : value.supervisorCdHcParty,
			"supervisorCbe" : value.supervisorCbe,
			"error" : value.error,
			"encounterLocationName" : value.encounterLocationName,
			"encounterLocationNihii" : value.encounterLocationNihii,
			"encounterLocationNorm" : value.encounterLocationNorm,
			"longDelayJustification" : value.longDelayJustification,
			"correctiveInvoiceId" : value.correctiveInvoiceId,
			"correctedInvoiceId" : value.correctedInvoiceId,
			"creditNote" : value.creditNote,
			"creditNoteRelatedInvoiceId" : value.creditNoteRelatedInvoiceId,
			"idDocument" : value.idDocument == null ? null : IdentityDocumentReader.encode(value.idDocument!),
			"admissionDate" : value.admissionDate,
			"locationNihii" : value.locationNihii,
			"locationService" : value.locationService,
			"cancelReason" : value.cancelReason,
			"cancelDate" : value.cancelDate,
			"options" : value.options.map((k0, v0) => MapEntry(k0, v0)),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}

class EncryptedInvoice implements Invoice {
	@override String id;
	@override String? rev;
	@override int? created;
	@override int? modified;
	@override String? author;
	@override String? responsible;
	@override String? medicalLocationId;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife;
	@override int? deletionDate;
	@override int? invoiceDate;
	@override int? sentDate;
	@override int? printedDate;
	@override List<EncryptedInvoicingCode> invoicingCodes = [];
	@override Map<String, String> receipts = {};
	@override String? recipientType;
	@override String? recipientId;
	@override String? invoiceReference;
	@override String? thirdPartyReference;
	@override String? thirdPartyPaymentJustification;
	@override String? thirdPartyPaymentReason;
	@override String? reason;
	@override InvoiceType? invoiceType;
	@override MediumType? sentMediumType;
	@override InvoiceInterventionType? interventionType;
	@override String? groupId;
	@override PaymentType? paymentType;
	@override double? paid;
	@override List<Payment>? payments;
	@override String? gnotionNihii;
	@override String? gnotionSsin;
	@override String? gnotionLastName;
	@override String? gnotionFirstName;
	@override String? gnotionCdHcParty;
	int? _invoicePeriod;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get invoicePeriod => _invoicePeriod;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set invoicePeriod(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('invoicePeriod value cannot exceed 2147483647');
		}
		_invoicePeriod = value;
	}
	@override String? careProviderType;
	@override String? internshipNihii;
	@override String? internshipSsin;
	@override String? internshipLastName;
	@override String? internshipFirstName;
	@override String? internshipCdHcParty;
	@override String? internshipCbe;
	@override String? supervisorNihii;
	@override String? supervisorSsin;
	@override String? supervisorLastName;
	@override String? supervisorFirstName;
	@override String? supervisorCdHcParty;
	@override String? supervisorCbe;
	@override String? error;
	@override String? encounterLocationName;
	@override String? encounterLocationNihii;
	int? _encounterLocationNorm;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get encounterLocationNorm => _encounterLocationNorm;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set encounterLocationNorm(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('encounterLocationNorm value cannot exceed 2147483647');
		}
		_encounterLocationNorm = value;
	}
	int? _longDelayJustification;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get longDelayJustification => _longDelayJustification;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set longDelayJustification(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('longDelayJustification value cannot exceed 2147483647');
		}
		_longDelayJustification = value;
	}
	@override String? correctiveInvoiceId;
	@override String? correctedInvoiceId;
	@override bool? creditNote;
	@override String? creditNoteRelatedInvoiceId;
	@override IdentityDocumentReader? idDocument;
	@override int? admissionDate;
	@override String? locationNihii;
	int? _locationService;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get locationService => _locationService;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set locationService(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('locationService value cannot exceed 2147483647');
		}
		_locationService = value;
	}
	@override String? cancelReason;
	@override int? cancelDate;
	@override Map<String, String> options = {};
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	EncryptedInvoice(
		this.id,
		{
			int? invoicePeriod,
			int? encounterLocationNorm,
			int? longDelayJustification,
			int? locationService,
			this.rev,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.medicalLocationId,
			this.endOfLife,
			this.deletionDate,
			this.invoiceDate,
			this.sentDate,
			this.printedDate,
			this.recipientType,
			this.recipientId,
			this.invoiceReference,
			this.thirdPartyReference,
			this.thirdPartyPaymentJustification,
			this.thirdPartyPaymentReason,
			this.reason,
			this.invoiceType,
			this.sentMediumType,
			this.interventionType,
			this.groupId,
			this.paymentType,
			this.paid,
			this.payments,
			this.gnotionNihii,
			this.gnotionSsin,
			this.gnotionLastName,
			this.gnotionFirstName,
			this.gnotionCdHcParty,
			this.careProviderType,
			this.internshipNihii,
			this.internshipSsin,
			this.internshipLastName,
			this.internshipFirstName,
			this.internshipCdHcParty,
			this.internshipCbe,
			this.supervisorNihii,
			this.supervisorSsin,
			this.supervisorLastName,
			this.supervisorFirstName,
			this.supervisorCdHcParty,
			this.supervisorCbe,
			this.error,
			this.encounterLocationName,
			this.encounterLocationNihii,
			this.correctiveInvoiceId,
			this.correctedInvoiceId,
			this.creditNote,
			this.creditNoteRelatedInvoiceId,
			this.idDocument,
			this.admissionDate,
			this.locationNihii,
			this.cancelReason,
			this.cancelDate,
			this.encryptedSelf,
			this.securityMetadata,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			List<EncryptedInvoicingCode>? invoicingCodes,
			Map<String, String>? receipts,
			Map<String, String>? options,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys
		}) : tags = tags ?? {},
		codes = codes ?? {},
		invoicingCodes = invoicingCodes ?? [],
		receipts = receipts ?? {},
		options = options ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		_invoicePeriod = invoicePeriod,
		_encounterLocationNorm = encounterLocationNorm,
		_longDelayJustification = longDelayJustification,
		_locationService = locationService;

	factory EncryptedInvoice.fromJSON(Map<String, dynamic> data) {
		return EncryptedInvoice(
			data["id"],
			invoicePeriod: data["invoicePeriod"],
			encounterLocationNorm: data["encounterLocationNorm"],
			longDelayJustification: data["longDelayJustification"],
			locationService: data["locationService"],
			rev: data["rev"],
			created: data["created"],
			modified: data["modified"],
			author: data["author"],
			responsible: data["responsible"],
			medicalLocationId: data["medicalLocationId"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ),
			endOfLife: data["endOfLife"],
			deletionDate: data["deletionDate"],
			invoiceDate: data["invoiceDate"],
			sentDate: data["sentDate"],
			printedDate: data["printedDate"],
			invoicingCodes: data["invoicingCodes"].map((x0) => EncryptedInvoicingCode.fromJSON(x0) ),
			receipts: data["receipts"].map((k0, v0) => MapEntry(k0, v0)),
			recipientType: data["recipientType"],
			recipientId: data["recipientId"],
			invoiceReference: data["invoiceReference"],
			thirdPartyReference: data["thirdPartyReference"],
			thirdPartyPaymentJustification: data["thirdPartyPaymentJustification"],
			thirdPartyPaymentReason: data["thirdPartyPaymentReason"],
			reason: data["reason"],
			invoiceType: data["invoiceType"] == null ? null : InvoiceType.fromJSON(data["invoiceType"]),
			sentMediumType: data["sentMediumType"] == null ? null : MediumType.fromJSON(data["sentMediumType"]),
			interventionType: data["interventionType"] == null ? null : InvoiceInterventionType.fromJSON(data["interventionType"]),
			groupId: data["groupId"],
			paymentType: data["paymentType"] == null ? null : PaymentType.fromJSON(data["paymentType"]),
			paid: data["paid"],
			payments: data["payments"]?.map((x0) => Payment.fromJSON(x0) ),
			gnotionNihii: data["gnotionNihii"],
			gnotionSsin: data["gnotionSsin"],
			gnotionLastName: data["gnotionLastName"],
			gnotionFirstName: data["gnotionFirstName"],
			gnotionCdHcParty: data["gnotionCdHcParty"],
			careProviderType: data["careProviderType"],
			internshipNihii: data["internshipNihii"],
			internshipSsin: data["internshipSsin"],
			internshipLastName: data["internshipLastName"],
			internshipFirstName: data["internshipFirstName"],
			internshipCdHcParty: data["internshipCdHcParty"],
			internshipCbe: data["internshipCbe"],
			supervisorNihii: data["supervisorNihii"],
			supervisorSsin: data["supervisorSsin"],
			supervisorLastName: data["supervisorLastName"],
			supervisorFirstName: data["supervisorFirstName"],
			supervisorCdHcParty: data["supervisorCdHcParty"],
			supervisorCbe: data["supervisorCbe"],
			error: data["error"],
			encounterLocationName: data["encounterLocationName"],
			encounterLocationNihii: data["encounterLocationNihii"],
			correctiveInvoiceId: data["correctiveInvoiceId"],
			correctedInvoiceId: data["correctedInvoiceId"],
			creditNote: data["creditNote"],
			creditNoteRelatedInvoiceId: data["creditNoteRelatedInvoiceId"],
			idDocument: data["idDocument"] == null ? null : IdentityDocumentReader.fromJSON(data["idDocument"]),
			admissionDate: data["admissionDate"],
			locationNihii: data["locationNihii"],
			cancelReason: data["cancelReason"],
			cancelDate: data["cancelDate"],
			options: data["options"].map((k0, v0) => MapEntry(k0, v0)),
			secretForeignKeys: data["secretForeignKeys"].map((x0) => x0 ),
			cryptedForeignKeys: data["cryptedForeignKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ))),
			delegations: data["delegations"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ))),
			encryptionKeys: data["encryptionKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ))),
			encryptedSelf: data["encryptedSelf"],
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

	static Map<String, dynamic> encode(EncryptedInvoice value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"invoiceDate" : value.invoiceDate,
			"sentDate" : value.sentDate,
			"printedDate" : value.printedDate,
			"invoicingCodes" : value.invoicingCodes.map((x0) => EncryptedInvoicingCode.encode(x0)),
			"receipts" : value.receipts.map((k0, v0) => MapEntry(k0, v0)),
			"recipientType" : value.recipientType,
			"recipientId" : value.recipientId,
			"invoiceReference" : value.invoiceReference,
			"thirdPartyReference" : value.thirdPartyReference,
			"thirdPartyPaymentJustification" : value.thirdPartyPaymentJustification,
			"thirdPartyPaymentReason" : value.thirdPartyPaymentReason,
			"reason" : value.reason,
			"invoiceType" : value.invoiceType == null ? null : InvoiceType.encode(value.invoiceType!),
			"sentMediumType" : value.sentMediumType == null ? null : MediumType.encode(value.sentMediumType!),
			"interventionType" : value.interventionType == null ? null : InvoiceInterventionType.encode(value.interventionType!),
			"groupId" : value.groupId,
			"paymentType" : value.paymentType == null ? null : PaymentType.encode(value.paymentType!),
			"paid" : value.paid,
			"payments" : value.payments?.map((x0) => Payment.encode(x0)),
			"gnotionNihii" : value.gnotionNihii,
			"gnotionSsin" : value.gnotionSsin,
			"gnotionLastName" : value.gnotionLastName,
			"gnotionFirstName" : value.gnotionFirstName,
			"gnotionCdHcParty" : value.gnotionCdHcParty,
			"invoicePeriod" : value.invoicePeriod,
			"careProviderType" : value.careProviderType,
			"internshipNihii" : value.internshipNihii,
			"internshipSsin" : value.internshipSsin,
			"internshipLastName" : value.internshipLastName,
			"internshipFirstName" : value.internshipFirstName,
			"internshipCdHcParty" : value.internshipCdHcParty,
			"internshipCbe" : value.internshipCbe,
			"supervisorNihii" : value.supervisorNihii,
			"supervisorSsin" : value.supervisorSsin,
			"supervisorLastName" : value.supervisorLastName,
			"supervisorFirstName" : value.supervisorFirstName,
			"supervisorCdHcParty" : value.supervisorCdHcParty,
			"supervisorCbe" : value.supervisorCbe,
			"error" : value.error,
			"encounterLocationName" : value.encounterLocationName,
			"encounterLocationNihii" : value.encounterLocationNihii,
			"encounterLocationNorm" : value.encounterLocationNorm,
			"longDelayJustification" : value.longDelayJustification,
			"correctiveInvoiceId" : value.correctiveInvoiceId,
			"correctedInvoiceId" : value.correctedInvoiceId,
			"creditNote" : value.creditNote,
			"creditNoteRelatedInvoiceId" : value.creditNoteRelatedInvoiceId,
			"idDocument" : value.idDocument == null ? null : IdentityDocumentReader.encode(value.idDocument!),
			"admissionDate" : value.admissionDate,
			"locationNihii" : value.locationNihii,
			"locationService" : value.locationService,
			"cancelReason" : value.cancelReason,
			"cancelDate" : value.cancelDate,
			"options" : value.options.map((k0, v0) => MapEntry(k0, v0)),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}