// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/contact.dart';
import 'package:cardinal_sdk/model/embed/service.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/model/data/labelled_occurence.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';


class ContactBasicPlatformApi {
	MethodChannel _methodChannel;
	ContactBasicPlatformApi(this._methodChannel);

	Future<List<String>> matchContactsBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.matchContactsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchContactsBy");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<List<String>> matchServicesBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.matchServicesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchServicesBy");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<List<String>> matchContactsBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.matchContactsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchContactsBySorted");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<List<String>> matchServicesBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.matchServicesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchServicesBySorted");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<PaginatedListIterator<EncryptedContact>> filterContactsBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.filterContactsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterContactsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedContact.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedService>> filterServicesBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.filterServicesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterServicesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedService.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedContact>> filterContactsBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.filterContactsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterContactsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedContact.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedService>> filterServicesBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.filterServicesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterServicesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedService.fromJSON(x0));
	}

	Future<EntitySubscription<EncryptedService>> subscribeToServiceCreateOrUpdateEvents(String sdkId, BaseFilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.subscribeToServiceCreateOrUpdateEvents',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method subscribeToServiceCreateOrUpdateEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedService.fromJSON(x0));
	}

	Future<DocIdentifier> deleteContactById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.deleteContactById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteContactById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteContactsByIds(String sdkId, List<IdWithMandatoryRev> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.deleteContactsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => IdWithMandatoryRev.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteContactsByIds");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<void> purgeContactById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.purgeContactById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<DocIdentifier> deleteContact(String sdkId, Contact contact) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.deleteContact',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(Contact.encode(contact)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteContact");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteContacts(String sdkId, List<Contact> contacts) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.deleteContacts',
			{
				"sdkId": sdkId,
				"contacts": jsonEncode(contacts.map((x0) => Contact.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteContacts");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<void> purgeContact(String sdkId, Contact contact) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.purgeContact',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(Contact.encode(contact)),
			}
		);
	}

	Future<List<LabelledOccurence>> getServiceCodesOccurrences(String sdkId, String codeType, int minOccurrences) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.getServiceCodesOccurrences',
			{
				"sdkId": sdkId,
				"codeType": jsonEncode(codeType),
				"minOccurrences": jsonEncode(minOccurrences),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getServiceCodesOccurrences");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => LabelledOccurence.fromJSON(x1) );
	}

	Future<EncryptedContact> undeleteContactById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.undeleteContactById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteContactById");
		final parsedResJson = jsonDecode(res);
		return EncryptedContact.fromJSON(parsedResJson);
	}

	Future<EncryptedContact> undeleteContact(String sdkId, Contact contact) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.undeleteContact',
			{
				"sdkId": sdkId,
				"contact": jsonEncode(Contact.encode(contact)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteContact");
		final parsedResJson = jsonDecode(res);
		return EncryptedContact.fromJSON(parsedResJson);
	}

	Future<EncryptedContact> modifyContact(String sdkId, EncryptedContact entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.modifyContact',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedContact.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyContact");
		final parsedResJson = jsonDecode(res);
		return EncryptedContact.fromJSON(parsedResJson);
	}

	Future<List<EncryptedContact>> modifyContacts(String sdkId, List<EncryptedContact> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.modifyContacts',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedContact.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyContacts");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedContact.fromJSON(x1) );
	}

	Future<EncryptedContact> getContact(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.getContact',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getContact");
		final parsedResJson = jsonDecode(res);
		return EncryptedContact.fromJSON(parsedResJson);
	}

	Future<List<EncryptedContact>> getContacts(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.getContacts',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getContacts");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedContact.fromJSON(x1) );
	}

	Future<EncryptedService> getService(String sdkId, String serviceId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.getService',
			{
				"sdkId": sdkId,
				"serviceId": jsonEncode(serviceId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getService");
		final parsedResJson = jsonDecode(res);
		return EncryptedService.fromJSON(parsedResJson);
	}

	Future<List<EncryptedService>> getServices(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.getServices',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getServices");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedService.fromJSON(x1) );
	}

	Future<EntitySubscription<EncryptedContact>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, BaseFilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactBasicApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0))),
				"filter": jsonEncode(filter.json),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedContact.fromJSON(x0));
	}
}