// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/icure_stub.dart';
import 'package:cardinal_sdk/model/data/labelled_occurence.dart';
import 'package:cardinal_sdk/model/invoice.dart';
import 'package:cardinal_sdk/model/embed/invoicing_code.dart';
import 'package:cardinal_sdk/model/embed/medium_type.dart';
import 'package:cardinal_sdk/model/embed/invoice_type.dart';


class InvoiceBasicPlatformApi {
	MethodChannel _methodChannel;
	InvoiceBasicPlatformApi(this._methodChannel);

	Future<DocIdentifier> deleteInvoice(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.deleteInvoice',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteInvoice");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<IcureStub>> findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(String sdkId, String hcPartyId, List<String> secretPatientKeys) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.findInvoicesDelegationsStubsByHcPartyPatientForeignKeys',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
				"secretPatientKeys": jsonEncode(secretPatientKeys.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method findInvoicesDelegationsStubsByHcPartyPatientForeignKeys");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => IcureStub.fromJSON(x1) );
	}

	Future<List<LabelledOccurence>> getTarificationsCodesOccurrences(String sdkId, int minOccurrence) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.getTarificationsCodesOccurrences',
			{
				"sdkId": sdkId,
				"minOccurrence": jsonEncode(minOccurrence),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getTarificationsCodesOccurrences");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => LabelledOccurence.fromJSON(x1) );
	}

	Future<EncryptedInvoice> modifyInvoice(String sdkId, EncryptedInvoice entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.modifyInvoice',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedInvoice.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyInvoice");
		final parsedResJson = jsonDecode(res);
		return EncryptedInvoice.fromJSON(parsedResJson);
	}

	Future<List<EncryptedInvoice>> modifyInvoices(String sdkId, List<EncryptedInvoice> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.modifyInvoices',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedInvoice.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyInvoices");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}

	Future<EncryptedInvoice> getInvoice(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.getInvoice',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getInvoice");
		final parsedResJson = jsonDecode(res);
		return EncryptedInvoice.fromJSON(parsedResJson);
	}

	Future<List<EncryptedInvoice>> getInvoices(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.getInvoices',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getInvoices");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}

	Future<List<EncryptedInvoice>> findInvoicesByHcPartyPatientForeignKeys(String sdkId, String hcPartyId, List<String> secretPatientKeys) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.findInvoicesByHcPartyPatientForeignKeys',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
				"secretPatientKeys": jsonEncode(secretPatientKeys.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method findInvoicesByHcPartyPatientForeignKeys");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}

	Future<EncryptedInvoice> reassignInvoice(String sdkId, EncryptedInvoice invoice) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.reassignInvoice',
			{
				"sdkId": sdkId,
				"invoice": jsonEncode(EncryptedInvoice.encode(invoice)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method reassignInvoice");
		final parsedResJson = jsonDecode(res);
		return EncryptedInvoice.fromJSON(parsedResJson);
	}

	Future<EncryptedInvoice> mergeTo(String sdkId, String invoiceId, List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.mergeTo',
			{
				"sdkId": sdkId,
				"invoiceId": jsonEncode(invoiceId),
				"ids": jsonEncode(ids.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method mergeTo");
		final parsedResJson = jsonDecode(res);
		return EncryptedInvoice.fromJSON(parsedResJson);
	}

	Future<EncryptedInvoice> validate(String sdkId, String invoiceId, String scheme, String forcedValue) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.validate',
			{
				"sdkId": sdkId,
				"invoiceId": jsonEncode(invoiceId),
				"scheme": jsonEncode(scheme),
				"forcedValue": jsonEncode(forcedValue),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method validate");
		final parsedResJson = jsonDecode(res);
		return EncryptedInvoice.fromJSON(parsedResJson);
	}

	Future<List<EncryptedInvoice>> appendCodes(String sdkId, String userId, String type, String sentMediumType, String secretFKeys, String? insuranceId, String? invoiceId, int? gracePeriod, List<EncryptedInvoicingCode> invoicingCodes) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.appendCodes',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"type": jsonEncode(type),
				"sentMediumType": jsonEncode(sentMediumType),
				"secretFKeys": jsonEncode(secretFKeys),
				"insuranceId": jsonEncode(insuranceId),
				"invoiceId": jsonEncode(invoiceId),
				"gracePeriod": jsonEncode(gracePeriod),
				"invoicingCodes": jsonEncode(invoicingCodes.map((x0) => EncryptedInvoicingCode.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method appendCodes");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}

	Future<List<EncryptedInvoice>> removeCodes(String sdkId, String userId, String serviceId, String secretFKeys, List<String> tarificationIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.removeCodes',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"serviceId": jsonEncode(serviceId),
				"secretFKeys": jsonEncode(secretFKeys),
				"tarificationIds": jsonEncode(tarificationIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method removeCodes");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}

	Future<List<EncryptedInvoice>> listInvoicesByHCPartyAndPatientForeignKeys(String sdkId, String hcPartyId, List<String> secretPatientKeys) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.listInvoicesByHCPartyAndPatientForeignKeys',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
				"secretPatientKeys": jsonEncode(secretPatientKeys.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByHCPartyAndPatientForeignKeys");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}

	Future<List<EncryptedInvoice>> listInvoicesByHcPartyAndGroupId(String sdkId, String hcPartyId, String groupId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.listInvoicesByHcPartyAndGroupId',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
				"groupId": jsonEncode(groupId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByHcPartyAndGroupId");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}

	Future<List<EncryptedInvoice>> listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(String sdkId, String hcPartyId, MediumType sentMediumType, InvoiceType invoiceType, bool sent, int? from, int? to) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
				"sentMediumType": jsonEncode(MediumType.encode(sentMediumType)),
				"invoiceType": jsonEncode(InvoiceType.encode(invoiceType)),
				"sent": jsonEncode(sent),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}

	Future<List<EncryptedInvoice>> listInvoicesByContactIds(String sdkId, List<String> contactIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.listInvoicesByContactIds',
			{
				"sdkId": sdkId,
				"contactIds": jsonEncode(contactIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByContactIds");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}

	Future<List<EncryptedInvoice>> listInvoicesByRecipientsIds(String sdkId, List<String> recipientsIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.listInvoicesByRecipientsIds',
			{
				"sdkId": sdkId,
				"recipientsIds": jsonEncode(recipientsIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByRecipientsIds");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}

	Future<List<EncryptedInvoice>> listToInsurances(String sdkId, List<String> userIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.listToInsurances',
			{
				"sdkId": sdkId,
				"userIds": jsonEncode(userIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listToInsurances");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}

	Future<List<EncryptedInvoice>> listToInsurancesUnsent(String sdkId, List<String> userIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.listToInsurancesUnsent',
			{
				"sdkId": sdkId,
				"userIds": jsonEncode(userIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listToInsurancesUnsent");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}

	Future<List<EncryptedInvoice>> listToPatients(String sdkId, String hcPartyId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.listToPatients',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listToPatients");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}

	Future<List<EncryptedInvoice>> listToPatientsUnsent(String sdkId, String? hcPartyId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.listToPatientsUnsent',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listToPatientsUnsent");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}

	Future<List<EncryptedInvoice>> listInvoicesByIds(String sdkId, List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.listInvoicesByIds',
			{
				"sdkId": sdkId,
				"ids": jsonEncode(ids.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByIds");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}

	Future<List<EncryptedInvoice>> listInvoicesByHcpartySendingModeStatusDate(String sdkId, String hcPartyId, String sendingMode, String status, int from, int to) async {
		final res = await _methodChannel.invokeMethod<String>(
			'InvoiceBasicApi.listInvoicesByHcpartySendingModeStatusDate',
			{
				"sdkId": sdkId,
				"hcPartyId": jsonEncode(hcPartyId),
				"sendingMode": jsonEncode(sendingMode),
				"status": jsonEncode(status),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listInvoicesByHcpartySendingModeStatusDate");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedInvoice.fromJSON(x1) );
	}
}