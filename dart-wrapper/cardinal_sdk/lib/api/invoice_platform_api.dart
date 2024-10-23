// auto-generated file
import 'package:cardinal_sdk/model/invoice.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/icure_stub.dart';
import 'package:cardinal_sdk/model/data/labelled_occurence.dart';
import 'package:cardinal_sdk/crypto/entities/invoice_share_options.dart';
import 'package:cardinal_sdk/model/embed/invoicing_code.dart';
import 'package:cardinal_sdk/model/embed/medium_type.dart';
import 'package:cardinal_sdk/model/embed/invoice_type.dart';


class InvoicePlatformApi {
	String _sdkId;
	TryAndRecoverInvoicePlatformApi tryAndRecover;
	EncryptedInvoicePlatformApi encrypted;
	InvoicePlatformApi(
		this._sdkId
		) : tryAndRecover = TryAndRecoverInvoicePlatformApi(_sdkId),
		encrypted = EncryptedInvoicePlatformApi(_sdkId);

	Future<DecryptedInvoice> createInvoice(DecryptedInvoice entity, String? prefix) async {
		return await CardinalSdkPlatformInterface.instance.invoice.createInvoice(
			_sdkId,
			entity,
			prefix,
		);
	}

	Future<List<DecryptedInvoice>> createInvoices(List<DecryptedInvoice> entities) async {
		return await CardinalSdkPlatformInterface.instance.invoice.createInvoices(
			_sdkId,
			entities,
		);
	}

	Future<DecryptedInvoice> withEncryptionMetadata(DecryptedInvoice? base, Patient? patient, User? user, { Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent }) async {
		return await CardinalSdkPlatformInterface.instance.invoice.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(Invoice invoice) async {
		return await CardinalSdkPlatformInterface.instance.invoice.getEncryptionKeysOf(
			_sdkId,
			invoice,
		);
	}

	Future<bool> hasWriteAccess(Invoice invoice) async {
		return await CardinalSdkPlatformInterface.instance.invoice.hasWriteAccess(
			_sdkId,
			invoice,
		);
	}

	Future<Set<String>> decryptPatientIdOf(Invoice invoice) async {
		return await CardinalSdkPlatformInterface.instance.invoice.decryptPatientIdOf(
			_sdkId,
			invoice,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(Invoice entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.invoice.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedInvoice> decrypt(EncryptedInvoice invoice) async {
		return await CardinalSdkPlatformInterface.instance.invoice.decrypt(
			_sdkId,
			invoice,
		);
	}

	Future<Invoice> tryDecrypt(EncryptedInvoice invoice) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryDecrypt(
			_sdkId,
			invoice,
		);
	}

	Future<DocIdentifier> deleteInvoice(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.invoice.deleteInvoice(
			_sdkId,
			entityId,
		);
	}

	Future<List<IcureStub>> findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(String hcPartyId, List<String> secretPatientKeys) async {
		return await CardinalSdkPlatformInterface.instance.invoice.findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(
			_sdkId,
			hcPartyId,
			secretPatientKeys,
		);
	}

	Future<List<LabelledOccurence>> getTarificationsCodesOccurrences(int minOccurrence) async {
		return await CardinalSdkPlatformInterface.instance.invoice.getTarificationsCodesOccurrences(
			_sdkId,
			minOccurrence,
		);
	}

	Future<DecryptedInvoice> shareWith(String delegateId, DecryptedInvoice invoice, InvoiceShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.invoice.shareWith(
			_sdkId,
			delegateId,
			invoice,
			options,
		);
	}

	Future<DecryptedInvoice> shareWithMany(DecryptedInvoice invoice, Map<String, InvoiceShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.invoice.shareWithMany(
			_sdkId,
			invoice,
			delegates,
		);
	}

	Future<DecryptedInvoice> modifyInvoice(DecryptedInvoice entity) async {
		return await CardinalSdkPlatformInterface.instance.invoice.modifyInvoice(
			_sdkId,
			entity,
		);
	}

	Future<List<DecryptedInvoice>> modifyInvoices(List<DecryptedInvoice> entities) async {
		return await CardinalSdkPlatformInterface.instance.invoice.modifyInvoices(
			_sdkId,
			entities,
		);
	}

	Future<DecryptedInvoice> getInvoice(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.invoice.getInvoice(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedInvoice>> getInvoices(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.getInvoices(
			_sdkId,
			entityIds,
		);
	}

	Future<List<DecryptedInvoice>> findInvoicesByHcPartyPatientForeignKeys(String hcPartyId, List<String> secretPatientKeys) async {
		return await CardinalSdkPlatformInterface.instance.invoice.findInvoicesByHcPartyPatientForeignKeys(
			_sdkId,
			hcPartyId,
			secretPatientKeys,
		);
	}

	Future<DecryptedInvoice> reassignInvoice(DecryptedInvoice invoice) async {
		return await CardinalSdkPlatformInterface.instance.invoice.reassignInvoice(
			_sdkId,
			invoice,
		);
	}

	Future<DecryptedInvoice> mergeTo(String invoiceId, List<String> ids) async {
		return await CardinalSdkPlatformInterface.instance.invoice.mergeTo(
			_sdkId,
			invoiceId,
			ids,
		);
	}

	Future<DecryptedInvoice> validate(String invoiceId, String scheme, String forcedValue) async {
		return await CardinalSdkPlatformInterface.instance.invoice.validate(
			_sdkId,
			invoiceId,
			scheme,
			forcedValue,
		);
	}

	Future<List<DecryptedInvoice>> appendCodes(String userId, String type, String sentMediumType, String secretFKeys, String? insuranceId, String? invoiceId, int? gracePeriod, List<EncryptedInvoicingCode> invoicingCodes) async {
		return await CardinalSdkPlatformInterface.instance.invoice.appendCodes(
			_sdkId,
			userId,
			type,
			sentMediumType,
			secretFKeys,
			insuranceId,
			invoiceId,
			gracePeriod,
			invoicingCodes,
		);
	}

	Future<List<DecryptedInvoice>> removeCodes(String userId, String serviceId, String secretFKeys, List<String> tarificationIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.removeCodes(
			_sdkId,
			userId,
			serviceId,
			secretFKeys,
			tarificationIds,
		);
	}

	Future<List<DecryptedInvoice>> listInvoicesByHCPartyAndPatientForeignKeys(String hcPartyId, List<String> secretPatientKeys) async {
		return await CardinalSdkPlatformInterface.instance.invoice.listInvoicesByHCPartyAndPatientForeignKeys(
			_sdkId,
			hcPartyId,
			secretPatientKeys,
		);
	}

	Future<List<DecryptedInvoice>> listInvoicesByHcPartyAndGroupId(String hcPartyId, String groupId) async {
		return await CardinalSdkPlatformInterface.instance.invoice.listInvoicesByHcPartyAndGroupId(
			_sdkId,
			hcPartyId,
			groupId,
		);
	}

	Future<List<DecryptedInvoice>> listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(String hcPartyId, MediumType sentMediumType, InvoiceType invoiceType, bool sent, int? from, int? to) async {
		return await CardinalSdkPlatformInterface.instance.invoice.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
			_sdkId,
			hcPartyId,
			sentMediumType,
			invoiceType,
			sent,
			from,
			to,
		);
	}

	Future<List<DecryptedInvoice>> listInvoicesByContactIds(List<String> contactIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.listInvoicesByContactIds(
			_sdkId,
			contactIds,
		);
	}

	Future<List<DecryptedInvoice>> listInvoicesByRecipientsIds(List<String> recipientsIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.listInvoicesByRecipientsIds(
			_sdkId,
			recipientsIds,
		);
	}

	Future<List<DecryptedInvoice>> listToInsurances(List<String> userIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.listToInsurances(
			_sdkId,
			userIds,
		);
	}

	Future<List<DecryptedInvoice>> listToInsurancesUnsent(List<String> userIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.listToInsurancesUnsent(
			_sdkId,
			userIds,
		);
	}

	Future<List<DecryptedInvoice>> listToPatients(String hcPartyId) async {
		return await CardinalSdkPlatformInterface.instance.invoice.listToPatients(
			_sdkId,
			hcPartyId,
		);
	}

	Future<List<DecryptedInvoice>> listToPatientsUnsent(String? hcPartyId) async {
		return await CardinalSdkPlatformInterface.instance.invoice.listToPatientsUnsent(
			_sdkId,
			hcPartyId,
		);
	}

	Future<List<DecryptedInvoice>> listInvoicesByIds(List<String> ids) async {
		return await CardinalSdkPlatformInterface.instance.invoice.listInvoicesByIds(
			_sdkId,
			ids,
		);
	}

	Future<List<DecryptedInvoice>> listInvoicesByHcpartySendingModeStatusDate(String hcPartyId, String sendingMode, String status, int from, int to) async {
		return await CardinalSdkPlatformInterface.instance.invoice.listInvoicesByHcpartySendingModeStatusDate(
			_sdkId,
			hcPartyId,
			sendingMode,
			status,
			from,
			to,
		);
	}
}

class TryAndRecoverInvoicePlatformApi {
	String _sdkId;
	TryAndRecoverInvoicePlatformApi(this._sdkId);

	Future<Invoice> shareWith(String delegateId, Invoice invoice, InvoiceShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			invoice,
			options,
		);
	}

	Future<Invoice> shareWithMany(Invoice invoice, Map<String, InvoiceShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.shareWithMany(
			_sdkId,
			invoice,
			delegates,
		);
	}

	Future<Invoice> modifyInvoice(Invoice entity) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.modifyInvoice(
			_sdkId,
			entity,
		);
	}

	Future<List<Invoice>> modifyInvoices(List<Invoice> entities) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.modifyInvoices(
			_sdkId,
			entities,
		);
	}

	Future<Invoice> getInvoice(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.getInvoice(
			_sdkId,
			entityId,
		);
	}

	Future<List<Invoice>> getInvoices(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.getInvoices(
			_sdkId,
			entityIds,
		);
	}

	Future<List<Invoice>> findInvoicesByHcPartyPatientForeignKeys(String hcPartyId, List<String> secretPatientKeys) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.findInvoicesByHcPartyPatientForeignKeys(
			_sdkId,
			hcPartyId,
			secretPatientKeys,
		);
	}

	Future<Invoice> reassignInvoice(Invoice invoice) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.reassignInvoice(
			_sdkId,
			invoice,
		);
	}

	Future<Invoice> mergeTo(String invoiceId, List<String> ids) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.mergeTo(
			_sdkId,
			invoiceId,
			ids,
		);
	}

	Future<Invoice> validate(String invoiceId, String scheme, String forcedValue) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.validate(
			_sdkId,
			invoiceId,
			scheme,
			forcedValue,
		);
	}

	Future<List<Invoice>> appendCodes(String userId, String type, String sentMediumType, String secretFKeys, String? insuranceId, String? invoiceId, int? gracePeriod, List<EncryptedInvoicingCode> invoicingCodes) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.appendCodes(
			_sdkId,
			userId,
			type,
			sentMediumType,
			secretFKeys,
			insuranceId,
			invoiceId,
			gracePeriod,
			invoicingCodes,
		);
	}

	Future<List<Invoice>> removeCodes(String userId, String serviceId, String secretFKeys, List<String> tarificationIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.removeCodes(
			_sdkId,
			userId,
			serviceId,
			secretFKeys,
			tarificationIds,
		);
	}

	Future<List<Invoice>> listInvoicesByHCPartyAndPatientForeignKeys(String hcPartyId, List<String> secretPatientKeys) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.listInvoicesByHCPartyAndPatientForeignKeys(
			_sdkId,
			hcPartyId,
			secretPatientKeys,
		);
	}

	Future<List<Invoice>> listInvoicesByHcPartyAndGroupId(String hcPartyId, String groupId) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.listInvoicesByHcPartyAndGroupId(
			_sdkId,
			hcPartyId,
			groupId,
		);
	}

	Future<List<Invoice>> listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(String hcPartyId, MediumType sentMediumType, InvoiceType invoiceType, bool sent, int? from, int? to) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
			_sdkId,
			hcPartyId,
			sentMediumType,
			invoiceType,
			sent,
			from,
			to,
		);
	}

	Future<List<Invoice>> listInvoicesByContactIds(List<String> contactIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.listInvoicesByContactIds(
			_sdkId,
			contactIds,
		);
	}

	Future<List<Invoice>> listInvoicesByRecipientsIds(List<String> recipientsIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.listInvoicesByRecipientsIds(
			_sdkId,
			recipientsIds,
		);
	}

	Future<List<Invoice>> listToInsurances(List<String> userIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.listToInsurances(
			_sdkId,
			userIds,
		);
	}

	Future<List<Invoice>> listToInsurancesUnsent(List<String> userIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.listToInsurancesUnsent(
			_sdkId,
			userIds,
		);
	}

	Future<List<Invoice>> listToPatients(String hcPartyId) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.listToPatients(
			_sdkId,
			hcPartyId,
		);
	}

	Future<List<Invoice>> listToPatientsUnsent(String? hcPartyId) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.listToPatientsUnsent(
			_sdkId,
			hcPartyId,
		);
	}

	Future<List<Invoice>> listInvoicesByIds(List<String> ids) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.listInvoicesByIds(
			_sdkId,
			ids,
		);
	}

	Future<List<Invoice>> listInvoicesByHcpartySendingModeStatusDate(String hcPartyId, String sendingMode, String status, int from, int to) async {
		return await CardinalSdkPlatformInterface.instance.invoice.tryAndRecover.listInvoicesByHcpartySendingModeStatusDate(
			_sdkId,
			hcPartyId,
			sendingMode,
			status,
			from,
			to,
		);
	}
}

class EncryptedInvoicePlatformApi {
	String _sdkId;
	EncryptedInvoicePlatformApi(this._sdkId);

	Future<EncryptedInvoice> shareWith(String delegateId, EncryptedInvoice invoice, InvoiceShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.shareWith(
			_sdkId,
			delegateId,
			invoice,
			options,
		);
	}

	Future<EncryptedInvoice> shareWithMany(EncryptedInvoice invoice, Map<String, InvoiceShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.shareWithMany(
			_sdkId,
			invoice,
			delegates,
		);
	}

	Future<EncryptedInvoice> modifyInvoice(EncryptedInvoice entity) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.modifyInvoice(
			_sdkId,
			entity,
		);
	}

	Future<List<EncryptedInvoice>> modifyInvoices(List<EncryptedInvoice> entities) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.modifyInvoices(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedInvoice> getInvoice(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.getInvoice(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedInvoice>> getInvoices(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.getInvoices(
			_sdkId,
			entityIds,
		);
	}

	Future<List<EncryptedInvoice>> findInvoicesByHcPartyPatientForeignKeys(String hcPartyId, List<String> secretPatientKeys) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.findInvoicesByHcPartyPatientForeignKeys(
			_sdkId,
			hcPartyId,
			secretPatientKeys,
		);
	}

	Future<EncryptedInvoice> reassignInvoice(EncryptedInvoice invoice) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.reassignInvoice(
			_sdkId,
			invoice,
		);
	}

	Future<EncryptedInvoice> mergeTo(String invoiceId, List<String> ids) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.mergeTo(
			_sdkId,
			invoiceId,
			ids,
		);
	}

	Future<EncryptedInvoice> validate(String invoiceId, String scheme, String forcedValue) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.validate(
			_sdkId,
			invoiceId,
			scheme,
			forcedValue,
		);
	}

	Future<List<EncryptedInvoice>> appendCodes(String userId, String type, String sentMediumType, String secretFKeys, String? insuranceId, String? invoiceId, int? gracePeriod, List<EncryptedInvoicingCode> invoicingCodes) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.appendCodes(
			_sdkId,
			userId,
			type,
			sentMediumType,
			secretFKeys,
			insuranceId,
			invoiceId,
			gracePeriod,
			invoicingCodes,
		);
	}

	Future<List<EncryptedInvoice>> removeCodes(String userId, String serviceId, String secretFKeys, List<String> tarificationIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.removeCodes(
			_sdkId,
			userId,
			serviceId,
			secretFKeys,
			tarificationIds,
		);
	}

	Future<List<EncryptedInvoice>> listInvoicesByHCPartyAndPatientForeignKeys(String hcPartyId, List<String> secretPatientKeys) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.listInvoicesByHCPartyAndPatientForeignKeys(
			_sdkId,
			hcPartyId,
			secretPatientKeys,
		);
	}

	Future<List<EncryptedInvoice>> listInvoicesByHcPartyAndGroupId(String hcPartyId, String groupId) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.listInvoicesByHcPartyAndGroupId(
			_sdkId,
			hcPartyId,
			groupId,
		);
	}

	Future<List<EncryptedInvoice>> listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(String hcPartyId, MediumType sentMediumType, InvoiceType invoiceType, bool sent, int? from, int? to) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
			_sdkId,
			hcPartyId,
			sentMediumType,
			invoiceType,
			sent,
			from,
			to,
		);
	}

	Future<List<EncryptedInvoice>> listInvoicesByContactIds(List<String> contactIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.listInvoicesByContactIds(
			_sdkId,
			contactIds,
		);
	}

	Future<List<EncryptedInvoice>> listInvoicesByRecipientsIds(List<String> recipientsIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.listInvoicesByRecipientsIds(
			_sdkId,
			recipientsIds,
		);
	}

	Future<List<EncryptedInvoice>> listToInsurances(List<String> userIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.listToInsurances(
			_sdkId,
			userIds,
		);
	}

	Future<List<EncryptedInvoice>> listToInsurancesUnsent(List<String> userIds) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.listToInsurancesUnsent(
			_sdkId,
			userIds,
		);
	}

	Future<List<EncryptedInvoice>> listToPatients(String hcPartyId) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.listToPatients(
			_sdkId,
			hcPartyId,
		);
	}

	Future<List<EncryptedInvoice>> listToPatientsUnsent(String? hcPartyId) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.listToPatientsUnsent(
			_sdkId,
			hcPartyId,
		);
	}

	Future<List<EncryptedInvoice>> listInvoicesByIds(List<String> ids) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.listInvoicesByIds(
			_sdkId,
			ids,
		);
	}

	Future<List<EncryptedInvoice>> listInvoicesByHcpartySendingModeStatusDate(String hcPartyId, String sendingMode, String status, int from, int to) async {
		return await CardinalSdkPlatformInterface.instance.invoice.encrypted.listInvoicesByHcpartySendingModeStatusDate(
			_sdkId,
			hcPartyId,
			sendingMode,
			status,
			from,
			to,
		);
	}
}