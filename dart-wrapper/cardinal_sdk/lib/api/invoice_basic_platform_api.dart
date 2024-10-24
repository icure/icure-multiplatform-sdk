// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/icure_stub.dart';
import 'package:cardinal_sdk/model/data/labelled_occurence.dart';
import 'package:cardinal_sdk/model/invoice.dart';
import 'package:cardinal_sdk/model/embed/invoicing_code.dart';
import 'package:cardinal_sdk/model/embed/medium_type.dart';
import 'package:cardinal_sdk/model/embed/invoice_type.dart';


class InvoiceBasicPlatformApi {
	String _sdkId;
	InvoiceBasicPlatformApi(this._sdkId);

	Future<DocIdentifier> deleteInvoice(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.deleteInvoice(
			_sdkId,
			entityId,
		);
	}

	Future<List<IcureStub>> findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(String hcPartyId, List<String> secretPatientKeys) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(
			_sdkId,
			hcPartyId,
			secretPatientKeys,
		);
	}

	Future<List<LabelledOccurence>> getTarificationsCodesOccurrences(int minOccurrence) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.getTarificationsCodesOccurrences(
			_sdkId,
			minOccurrence,
		);
	}

	Future<EncryptedInvoice> modifyInvoice(EncryptedInvoice entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.modifyInvoice(
			_sdkId,
			entity,
		);
	}

	Future<List<EncryptedInvoice>> modifyInvoices(List<EncryptedInvoice> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.modifyInvoices(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedInvoice> getInvoice(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.getInvoice(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedInvoice>> getInvoices(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.getInvoices(
			_sdkId,
			entityIds,
		);
	}

	Future<List<EncryptedInvoice>> findInvoicesByHcPartyPatientForeignKeys(String hcPartyId, List<String> secretPatientKeys) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.findInvoicesByHcPartyPatientForeignKeys(
			_sdkId,
			hcPartyId,
			secretPatientKeys,
		);
	}

	Future<EncryptedInvoice> reassignInvoice(EncryptedInvoice invoice) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.reassignInvoice(
			_sdkId,
			invoice,
		);
	}

	Future<EncryptedInvoice> mergeTo(String invoiceId, List<String> ids) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.mergeTo(
			_sdkId,
			invoiceId,
			ids,
		);
	}

	Future<EncryptedInvoice> validate(String invoiceId, String scheme, String forcedValue) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.validate(
			_sdkId,
			invoiceId,
			scheme,
			forcedValue,
		);
	}

	Future<List<EncryptedInvoice>> appendCodes(String userId, String type, String sentMediumType, String secretFKeys, String? insuranceId, String? invoiceId, int? gracePeriod, List<EncryptedInvoicingCode> invoicingCodes) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.appendCodes(
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
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.removeCodes(
			_sdkId,
			userId,
			serviceId,
			secretFKeys,
			tarificationIds,
		);
	}

	Future<List<EncryptedInvoice>> listInvoicesByHCPartyAndPatientForeignKeys(String hcPartyId, List<String> secretPatientKeys) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.listInvoicesByHCPartyAndPatientForeignKeys(
			_sdkId,
			hcPartyId,
			secretPatientKeys,
		);
	}

	Future<List<EncryptedInvoice>> listInvoicesByHcPartyAndGroupId(String hcPartyId, String groupId) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.listInvoicesByHcPartyAndGroupId(
			_sdkId,
			hcPartyId,
			groupId,
		);
	}

	Future<List<EncryptedInvoice>> listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(String hcPartyId, MediumType sentMediumType, InvoiceType invoiceType, bool sent, int? from, int? to) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
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
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.listInvoicesByContactIds(
			_sdkId,
			contactIds,
		);
	}

	Future<List<EncryptedInvoice>> listInvoicesByRecipientsIds(List<String> recipientsIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.listInvoicesByRecipientsIds(
			_sdkId,
			recipientsIds,
		);
	}

	Future<List<EncryptedInvoice>> listToInsurances(List<String> userIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.listToInsurances(
			_sdkId,
			userIds,
		);
	}

	Future<List<EncryptedInvoice>> listToInsurancesUnsent(List<String> userIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.listToInsurancesUnsent(
			_sdkId,
			userIds,
		);
	}

	Future<List<EncryptedInvoice>> listToPatients(String hcPartyId) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.listToPatients(
			_sdkId,
			hcPartyId,
		);
	}

	Future<List<EncryptedInvoice>> listToPatientsUnsent(String? hcPartyId) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.listToPatientsUnsent(
			_sdkId,
			hcPartyId,
		);
	}

	Future<List<EncryptedInvoice>> listInvoicesByIds(List<String> ids) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.listInvoicesByIds(
			_sdkId,
			ids,
		);
	}

	Future<List<EncryptedInvoice>> listInvoicesByHcpartySendingModeStatusDate(String hcPartyId, String sendingMode, String status, int from, int to) async {
		return await CardinalSdkPlatformInterface.instance.apis.invoiceBasic.listInvoicesByHcpartySendingModeStatusDate(
			_sdkId,
			hcPartyId,
			sendingMode,
			status,
			from,
			to,
		);
	}
}