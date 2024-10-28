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
	@ActualInt32() abstract int? invoicePeriod;
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
	@ActualInt32() abstract int? encounterLocationNorm;
	@ActualInt32() abstract int? longDelayJustification;
	abstract String? correctiveInvoiceId;
	abstract String? correctedInvoiceId;
	abstract bool? creditNote;
	abstract String? creditNoteRelatedInvoiceId;
	abstract IdentityDocumentReader? idDocument;
	abstract int? admissionDate;
	abstract String? locationNihii;
	@ActualInt32() abstract int? locationService;
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
	@override String? rev = null;
	@override int? created = null;
	@override int? modified = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife = null;
	@override int? deletionDate = null;
	@override int? invoiceDate = null;
	@override int? sentDate = null;
	@override int? printedDate = null;
	@override List<DecryptedInvoicingCode> invoicingCodes = [];
	@override Map<String, String> receipts = {};
	@override String? recipientType = null;
	@override String? recipientId = null;
	@override String? invoiceReference = null;
	@override String? thirdPartyReference = null;
	@override String? thirdPartyPaymentJustification = null;
	@override String? thirdPartyPaymentReason = null;
	@override String? reason = null;
	@override InvoiceType? invoiceType = null;
	@override MediumType? sentMediumType = null;
	@override InvoiceInterventionType? interventionType = null;
	@override String? groupId = null;
	@override PaymentType? paymentType = null;
	@override double? paid = null;
	@override List<Payment>? payments = null;
	@override String? gnotionNihii = null;
	@override String? gnotionSsin = null;
	@override String? gnotionLastName = null;
	@override String? gnotionFirstName = null;
	@override String? gnotionCdHcParty = null;
	int? _invoicePeriod = null;
	@ActualInt32() @override int? get invoicePeriod => _invoicePeriod;
	@ActualInt32() @override set invoicePeriod(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('invoicePeriod value cannot exceed 2147483647');
		}
		_invoicePeriod = value;
	}
	@override String? careProviderType = null;
	@override String? internshipNihii = null;
	@override String? internshipSsin = null;
	@override String? internshipLastName = null;
	@override String? internshipFirstName = null;
	@override String? internshipCdHcParty = null;
	@override String? internshipCbe = null;
	@override String? supervisorNihii = null;
	@override String? supervisorSsin = null;
	@override String? supervisorLastName = null;
	@override String? supervisorFirstName = null;
	@override String? supervisorCdHcParty = null;
	@override String? supervisorCbe = null;
	@override String? error = null;
	@override String? encounterLocationName = null;
	@override String? encounterLocationNihii = null;
	int? _encounterLocationNorm = null;
	@ActualInt32() @override int? get encounterLocationNorm => _encounterLocationNorm;
	@ActualInt32() @override set encounterLocationNorm(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('encounterLocationNorm value cannot exceed 2147483647');
		}
		_encounterLocationNorm = value;
	}
	int? _longDelayJustification = null;
	@ActualInt32() @override int? get longDelayJustification => _longDelayJustification;
	@ActualInt32() @override set longDelayJustification(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('longDelayJustification value cannot exceed 2147483647');
		}
		_longDelayJustification = value;
	}
	@override String? correctiveInvoiceId = null;
	@override String? correctedInvoiceId = null;
	@override bool? creditNote = null;
	@override String? creditNoteRelatedInvoiceId = null;
	@override IdentityDocumentReader? idDocument = null;
	@override int? admissionDate = null;
	@override String? locationNihii = null;
	int? _locationService = null;
	@ActualInt32() @override int? get locationService => _locationService;
	@ActualInt32() @override set locationService(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('locationService value cannot exceed 2147483647');
		}
		_locationService = value;
	}
	@override String? cancelReason = null;
	@override int? cancelDate = null;
	@override Map<String, String> options = {};
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	DecryptedInvoice(
		this.id,
		{
			int? invoicePeriod,
			int? encounterLocationNorm,
			int? longDelayJustification,
			int? locationService,
			String? rev,
			int? created,
			int? modified,
			String? author,
			String? responsible,
			String? medicalLocationId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			int? endOfLife,
			int? deletionDate,
			int? invoiceDate,
			int? sentDate,
			int? printedDate,
			List<DecryptedInvoicingCode>? invoicingCodes,
			Map<String, String>? receipts,
			String? recipientType,
			String? recipientId,
			String? invoiceReference,
			String? thirdPartyReference,
			String? thirdPartyPaymentJustification,
			String? thirdPartyPaymentReason,
			String? reason,
			InvoiceType? invoiceType,
			MediumType? sentMediumType,
			InvoiceInterventionType? interventionType,
			String? groupId,
			PaymentType? paymentType,
			double? paid,
			List<Payment>? payments,
			String? gnotionNihii,
			String? gnotionSsin,
			String? gnotionLastName,
			String? gnotionFirstName,
			String? gnotionCdHcParty,
			String? careProviderType,
			String? internshipNihii,
			String? internshipSsin,
			String? internshipLastName,
			String? internshipFirstName,
			String? internshipCdHcParty,
			String? internshipCbe,
			String? supervisorNihii,
			String? supervisorSsin,
			String? supervisorLastName,
			String? supervisorFirstName,
			String? supervisorCdHcParty,
			String? supervisorCbe,
			String? error,
			String? encounterLocationName,
			String? encounterLocationNihii,
			String? correctiveInvoiceId,
			String? correctedInvoiceId,
			bool? creditNote,
			String? creditNoteRelatedInvoiceId,
			IdentityDocumentReader? idDocument,
			int? admissionDate,
			String? locationNihii,
			String? cancelReason,
			int? cancelDate,
			Map<String, String>? options,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata
		}) : rev = rev ?? null,
		created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		invoiceDate = invoiceDate ?? null,
		sentDate = sentDate ?? null,
		printedDate = printedDate ?? null,
		invoicingCodes = invoicingCodes ?? [],
		receipts = receipts ?? {},
		recipientType = recipientType ?? null,
		recipientId = recipientId ?? null,
		invoiceReference = invoiceReference ?? null,
		thirdPartyReference = thirdPartyReference ?? null,
		thirdPartyPaymentJustification = thirdPartyPaymentJustification ?? null,
		thirdPartyPaymentReason = thirdPartyPaymentReason ?? null,
		reason = reason ?? null,
		invoiceType = invoiceType ?? null,
		sentMediumType = sentMediumType ?? null,
		interventionType = interventionType ?? null,
		groupId = groupId ?? null,
		paymentType = paymentType ?? null,
		paid = paid ?? null,
		payments = payments ?? null,
		gnotionNihii = gnotionNihii ?? null,
		gnotionSsin = gnotionSsin ?? null,
		gnotionLastName = gnotionLastName ?? null,
		gnotionFirstName = gnotionFirstName ?? null,
		gnotionCdHcParty = gnotionCdHcParty ?? null,
		careProviderType = careProviderType ?? null,
		internshipNihii = internshipNihii ?? null,
		internshipSsin = internshipSsin ?? null,
		internshipLastName = internshipLastName ?? null,
		internshipFirstName = internshipFirstName ?? null,
		internshipCdHcParty = internshipCdHcParty ?? null,
		internshipCbe = internshipCbe ?? null,
		supervisorNihii = supervisorNihii ?? null,
		supervisorSsin = supervisorSsin ?? null,
		supervisorLastName = supervisorLastName ?? null,
		supervisorFirstName = supervisorFirstName ?? null,
		supervisorCdHcParty = supervisorCdHcParty ?? null,
		supervisorCbe = supervisorCbe ?? null,
		error = error ?? null,
		encounterLocationName = encounterLocationName ?? null,
		encounterLocationNihii = encounterLocationNihii ?? null,
		correctiveInvoiceId = correctiveInvoiceId ?? null,
		correctedInvoiceId = correctedInvoiceId ?? null,
		creditNote = creditNote ?? null,
		creditNoteRelatedInvoiceId = creditNoteRelatedInvoiceId ?? null,
		idDocument = idDocument ?? null,
		admissionDate = admissionDate ?? null,
		locationNihii = locationNihii ?? null,
		cancelReason = cancelReason ?? null,
		cancelDate = cancelDate ?? null,
		options = options ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null,
		_invoicePeriod = invoicePeriod ?? null,
		_encounterLocationNorm = encounterLocationNorm ?? null,
		_longDelayJustification = longDelayJustification ?? null,
		_locationService = locationService ?? null;

	factory DecryptedInvoice.fromJSON(Map<String, dynamic> data) {
		return DecryptedInvoice(
			(data["id"] as String),
			invoicePeriod: (data["invoicePeriod"] as int?),
			encounterLocationNorm: (data["encounterLocationNorm"] as int?),
			longDelayJustification: (data["longDelayJustification"] as int?),
			locationService: (data["locationService"] as int?),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			invoiceDate: (data["invoiceDate"] as int?),
			sentDate: (data["sentDate"] as int?),
			printedDate: (data["printedDate"] as int?),
			invoicingCodes: (data["invoicingCodes"] as List<dynamic>).map((x0) => DecryptedInvoicingCode.fromJSON(x0) ).toList(),
			receipts: (data["receipts"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			recipientType: (data["recipientType"] as String?),
			recipientId: (data["recipientId"] as String?),
			invoiceReference: (data["invoiceReference"] as String?),
			thirdPartyReference: (data["thirdPartyReference"] as String?),
			thirdPartyPaymentJustification: (data["thirdPartyPaymentJustification"] as String?),
			thirdPartyPaymentReason: (data["thirdPartyPaymentReason"] as String?),
			reason: (data["reason"] as String?),
			invoiceType: data["invoiceType"] == null ? null : InvoiceType.fromJSON(data["invoiceType"]),
			sentMediumType: data["sentMediumType"] == null ? null : MediumType.fromJSON(data["sentMediumType"]),
			interventionType: data["interventionType"] == null ? null : InvoiceInterventionType.fromJSON(data["interventionType"]),
			groupId: (data["groupId"] as String?),
			paymentType: data["paymentType"] == null ? null : PaymentType.fromJSON(data["paymentType"]),
			paid: (data["paid"] as num?)?.toDouble(),
			payments: (data["payments"] as List<dynamic>?)?.map((x0) => Payment.fromJSON(x0) ).toList(),
			gnotionNihii: (data["gnotionNihii"] as String?),
			gnotionSsin: (data["gnotionSsin"] as String?),
			gnotionLastName: (data["gnotionLastName"] as String?),
			gnotionFirstName: (data["gnotionFirstName"] as String?),
			gnotionCdHcParty: (data["gnotionCdHcParty"] as String?),
			careProviderType: (data["careProviderType"] as String?),
			internshipNihii: (data["internshipNihii"] as String?),
			internshipSsin: (data["internshipSsin"] as String?),
			internshipLastName: (data["internshipLastName"] as String?),
			internshipFirstName: (data["internshipFirstName"] as String?),
			internshipCdHcParty: (data["internshipCdHcParty"] as String?),
			internshipCbe: (data["internshipCbe"] as String?),
			supervisorNihii: (data["supervisorNihii"] as String?),
			supervisorSsin: (data["supervisorSsin"] as String?),
			supervisorLastName: (data["supervisorLastName"] as String?),
			supervisorFirstName: (data["supervisorFirstName"] as String?),
			supervisorCdHcParty: (data["supervisorCdHcParty"] as String?),
			supervisorCbe: (data["supervisorCbe"] as String?),
			error: (data["error"] as String?),
			encounterLocationName: (data["encounterLocationName"] as String?),
			encounterLocationNihii: (data["encounterLocationNihii"] as String?),
			correctiveInvoiceId: (data["correctiveInvoiceId"] as String?),
			correctedInvoiceId: (data["correctedInvoiceId"] as String?),
			creditNote: (data["creditNote"] as bool?),
			creditNoteRelatedInvoiceId: (data["creditNoteRelatedInvoiceId"] as String?),
			idDocument: data["idDocument"] == null ? null : IdentityDocumentReader.fromJSON(data["idDocument"]),
			admissionDate: (data["admissionDate"] as int?),
			locationNihii: (data["locationNihii"] as String?),
			cancelReason: (data["cancelReason"] as String?),
			cancelDate: (data["cancelDate"] as int?),
			options: (data["options"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
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
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"invoiceDate" : value.invoiceDate,
			"sentDate" : value.sentDate,
			"printedDate" : value.printedDate,
			"invoicingCodes" : value.invoicingCodes.map((x0) => DecryptedInvoicingCode.encode(x0)).toList(),
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
			"payments" : value.payments?.map((x0) => Payment.encode(x0)).toList(),
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
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}

class EncryptedInvoice implements Invoice {
	@override String id;
	@override String? rev = null;
	@override int? created = null;
	@override int? modified = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife = null;
	@override int? deletionDate = null;
	@override int? invoiceDate = null;
	@override int? sentDate = null;
	@override int? printedDate = null;
	@override List<EncryptedInvoicingCode> invoicingCodes = [];
	@override Map<String, String> receipts = {};
	@override String? recipientType = null;
	@override String? recipientId = null;
	@override String? invoiceReference = null;
	@override String? thirdPartyReference = null;
	@override String? thirdPartyPaymentJustification = null;
	@override String? thirdPartyPaymentReason = null;
	@override String? reason = null;
	@override InvoiceType? invoiceType = null;
	@override MediumType? sentMediumType = null;
	@override InvoiceInterventionType? interventionType = null;
	@override String? groupId = null;
	@override PaymentType? paymentType = null;
	@override double? paid = null;
	@override List<Payment>? payments = null;
	@override String? gnotionNihii = null;
	@override String? gnotionSsin = null;
	@override String? gnotionLastName = null;
	@override String? gnotionFirstName = null;
	@override String? gnotionCdHcParty = null;
	int? _invoicePeriod = null;
	@ActualInt32() @override int? get invoicePeriod => _invoicePeriod;
	@ActualInt32() @override set invoicePeriod(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('invoicePeriod value cannot exceed 2147483647');
		}
		_invoicePeriod = value;
	}
	@override String? careProviderType = null;
	@override String? internshipNihii = null;
	@override String? internshipSsin = null;
	@override String? internshipLastName = null;
	@override String? internshipFirstName = null;
	@override String? internshipCdHcParty = null;
	@override String? internshipCbe = null;
	@override String? supervisorNihii = null;
	@override String? supervisorSsin = null;
	@override String? supervisorLastName = null;
	@override String? supervisorFirstName = null;
	@override String? supervisorCdHcParty = null;
	@override String? supervisorCbe = null;
	@override String? error = null;
	@override String? encounterLocationName = null;
	@override String? encounterLocationNihii = null;
	int? _encounterLocationNorm = null;
	@ActualInt32() @override int? get encounterLocationNorm => _encounterLocationNorm;
	@ActualInt32() @override set encounterLocationNorm(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('encounterLocationNorm value cannot exceed 2147483647');
		}
		_encounterLocationNorm = value;
	}
	int? _longDelayJustification = null;
	@ActualInt32() @override int? get longDelayJustification => _longDelayJustification;
	@ActualInt32() @override set longDelayJustification(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('longDelayJustification value cannot exceed 2147483647');
		}
		_longDelayJustification = value;
	}
	@override String? correctiveInvoiceId = null;
	@override String? correctedInvoiceId = null;
	@override bool? creditNote = null;
	@override String? creditNoteRelatedInvoiceId = null;
	@override IdentityDocumentReader? idDocument = null;
	@override int? admissionDate = null;
	@override String? locationNihii = null;
	int? _locationService = null;
	@ActualInt32() @override int? get locationService => _locationService;
	@ActualInt32() @override set locationService(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('locationService value cannot exceed 2147483647');
		}
		_locationService = value;
	}
	@override String? cancelReason = null;
	@override int? cancelDate = null;
	@override Map<String, String> options = {};
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	EncryptedInvoice(
		this.id,
		{
			int? invoicePeriod,
			int? encounterLocationNorm,
			int? longDelayJustification,
			int? locationService,
			String? rev,
			int? created,
			int? modified,
			String? author,
			String? responsible,
			String? medicalLocationId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			int? endOfLife,
			int? deletionDate,
			int? invoiceDate,
			int? sentDate,
			int? printedDate,
			List<EncryptedInvoicingCode>? invoicingCodes,
			Map<String, String>? receipts,
			String? recipientType,
			String? recipientId,
			String? invoiceReference,
			String? thirdPartyReference,
			String? thirdPartyPaymentJustification,
			String? thirdPartyPaymentReason,
			String? reason,
			InvoiceType? invoiceType,
			MediumType? sentMediumType,
			InvoiceInterventionType? interventionType,
			String? groupId,
			PaymentType? paymentType,
			double? paid,
			List<Payment>? payments,
			String? gnotionNihii,
			String? gnotionSsin,
			String? gnotionLastName,
			String? gnotionFirstName,
			String? gnotionCdHcParty,
			String? careProviderType,
			String? internshipNihii,
			String? internshipSsin,
			String? internshipLastName,
			String? internshipFirstName,
			String? internshipCdHcParty,
			String? internshipCbe,
			String? supervisorNihii,
			String? supervisorSsin,
			String? supervisorLastName,
			String? supervisorFirstName,
			String? supervisorCdHcParty,
			String? supervisorCbe,
			String? error,
			String? encounterLocationName,
			String? encounterLocationNihii,
			String? correctiveInvoiceId,
			String? correctedInvoiceId,
			bool? creditNote,
			String? creditNoteRelatedInvoiceId,
			IdentityDocumentReader? idDocument,
			int? admissionDate,
			String? locationNihii,
			String? cancelReason,
			int? cancelDate,
			Map<String, String>? options,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata
		}) : rev = rev ?? null,
		created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		invoiceDate = invoiceDate ?? null,
		sentDate = sentDate ?? null,
		printedDate = printedDate ?? null,
		invoicingCodes = invoicingCodes ?? [],
		receipts = receipts ?? {},
		recipientType = recipientType ?? null,
		recipientId = recipientId ?? null,
		invoiceReference = invoiceReference ?? null,
		thirdPartyReference = thirdPartyReference ?? null,
		thirdPartyPaymentJustification = thirdPartyPaymentJustification ?? null,
		thirdPartyPaymentReason = thirdPartyPaymentReason ?? null,
		reason = reason ?? null,
		invoiceType = invoiceType ?? null,
		sentMediumType = sentMediumType ?? null,
		interventionType = interventionType ?? null,
		groupId = groupId ?? null,
		paymentType = paymentType ?? null,
		paid = paid ?? null,
		payments = payments ?? null,
		gnotionNihii = gnotionNihii ?? null,
		gnotionSsin = gnotionSsin ?? null,
		gnotionLastName = gnotionLastName ?? null,
		gnotionFirstName = gnotionFirstName ?? null,
		gnotionCdHcParty = gnotionCdHcParty ?? null,
		careProviderType = careProviderType ?? null,
		internshipNihii = internshipNihii ?? null,
		internshipSsin = internshipSsin ?? null,
		internshipLastName = internshipLastName ?? null,
		internshipFirstName = internshipFirstName ?? null,
		internshipCdHcParty = internshipCdHcParty ?? null,
		internshipCbe = internshipCbe ?? null,
		supervisorNihii = supervisorNihii ?? null,
		supervisorSsin = supervisorSsin ?? null,
		supervisorLastName = supervisorLastName ?? null,
		supervisorFirstName = supervisorFirstName ?? null,
		supervisorCdHcParty = supervisorCdHcParty ?? null,
		supervisorCbe = supervisorCbe ?? null,
		error = error ?? null,
		encounterLocationName = encounterLocationName ?? null,
		encounterLocationNihii = encounterLocationNihii ?? null,
		correctiveInvoiceId = correctiveInvoiceId ?? null,
		correctedInvoiceId = correctedInvoiceId ?? null,
		creditNote = creditNote ?? null,
		creditNoteRelatedInvoiceId = creditNoteRelatedInvoiceId ?? null,
		idDocument = idDocument ?? null,
		admissionDate = admissionDate ?? null,
		locationNihii = locationNihii ?? null,
		cancelReason = cancelReason ?? null,
		cancelDate = cancelDate ?? null,
		options = options ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null,
		_invoicePeriod = invoicePeriod ?? null,
		_encounterLocationNorm = encounterLocationNorm ?? null,
		_longDelayJustification = longDelayJustification ?? null,
		_locationService = locationService ?? null;

	factory EncryptedInvoice.fromJSON(Map<String, dynamic> data) {
		return EncryptedInvoice(
			(data["id"] as String),
			invoicePeriod: (data["invoicePeriod"] as int?),
			encounterLocationNorm: (data["encounterLocationNorm"] as int?),
			longDelayJustification: (data["longDelayJustification"] as int?),
			locationService: (data["locationService"] as int?),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			invoiceDate: (data["invoiceDate"] as int?),
			sentDate: (data["sentDate"] as int?),
			printedDate: (data["printedDate"] as int?),
			invoicingCodes: (data["invoicingCodes"] as List<dynamic>).map((x0) => EncryptedInvoicingCode.fromJSON(x0) ).toList(),
			receipts: (data["receipts"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			recipientType: (data["recipientType"] as String?),
			recipientId: (data["recipientId"] as String?),
			invoiceReference: (data["invoiceReference"] as String?),
			thirdPartyReference: (data["thirdPartyReference"] as String?),
			thirdPartyPaymentJustification: (data["thirdPartyPaymentJustification"] as String?),
			thirdPartyPaymentReason: (data["thirdPartyPaymentReason"] as String?),
			reason: (data["reason"] as String?),
			invoiceType: data["invoiceType"] == null ? null : InvoiceType.fromJSON(data["invoiceType"]),
			sentMediumType: data["sentMediumType"] == null ? null : MediumType.fromJSON(data["sentMediumType"]),
			interventionType: data["interventionType"] == null ? null : InvoiceInterventionType.fromJSON(data["interventionType"]),
			groupId: (data["groupId"] as String?),
			paymentType: data["paymentType"] == null ? null : PaymentType.fromJSON(data["paymentType"]),
			paid: (data["paid"] as num?)?.toDouble(),
			payments: (data["payments"] as List<dynamic>?)?.map((x0) => Payment.fromJSON(x0) ).toList(),
			gnotionNihii: (data["gnotionNihii"] as String?),
			gnotionSsin: (data["gnotionSsin"] as String?),
			gnotionLastName: (data["gnotionLastName"] as String?),
			gnotionFirstName: (data["gnotionFirstName"] as String?),
			gnotionCdHcParty: (data["gnotionCdHcParty"] as String?),
			careProviderType: (data["careProviderType"] as String?),
			internshipNihii: (data["internshipNihii"] as String?),
			internshipSsin: (data["internshipSsin"] as String?),
			internshipLastName: (data["internshipLastName"] as String?),
			internshipFirstName: (data["internshipFirstName"] as String?),
			internshipCdHcParty: (data["internshipCdHcParty"] as String?),
			internshipCbe: (data["internshipCbe"] as String?),
			supervisorNihii: (data["supervisorNihii"] as String?),
			supervisorSsin: (data["supervisorSsin"] as String?),
			supervisorLastName: (data["supervisorLastName"] as String?),
			supervisorFirstName: (data["supervisorFirstName"] as String?),
			supervisorCdHcParty: (data["supervisorCdHcParty"] as String?),
			supervisorCbe: (data["supervisorCbe"] as String?),
			error: (data["error"] as String?),
			encounterLocationName: (data["encounterLocationName"] as String?),
			encounterLocationNihii: (data["encounterLocationNihii"] as String?),
			correctiveInvoiceId: (data["correctiveInvoiceId"] as String?),
			correctedInvoiceId: (data["correctedInvoiceId"] as String?),
			creditNote: (data["creditNote"] as bool?),
			creditNoteRelatedInvoiceId: (data["creditNoteRelatedInvoiceId"] as String?),
			idDocument: data["idDocument"] == null ? null : IdentityDocumentReader.fromJSON(data["idDocument"]),
			admissionDate: (data["admissionDate"] as int?),
			locationNihii: (data["locationNihii"] as String?),
			cancelReason: (data["cancelReason"] as String?),
			cancelDate: (data["cancelDate"] as int?),
			options: (data["options"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
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
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"invoiceDate" : value.invoiceDate,
			"sentDate" : value.sentDate,
			"printedDate" : value.printedDate,
			"invoicingCodes" : value.invoicingCodes.map((x0) => EncryptedInvoicingCode.encode(x0)).toList(),
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
			"payments" : value.payments?.map((x0) => Payment.encode(x0)).toList(),
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
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}