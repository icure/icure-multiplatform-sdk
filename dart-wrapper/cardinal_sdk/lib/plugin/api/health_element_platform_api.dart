// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/health_element.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/crypto/entities/health_element_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class HealthElementPlatformApi {
	MethodChannel _methodChannel;
	TryAndRecoverHealthElementPlatformApi tryAndRecover;
	EncryptedHealthElementPlatformApi encrypted;
	HealthElementPlatformApi(
		this._methodChannel
		) : tryAndRecover = TryAndRecoverHealthElementPlatformApi(_methodChannel),
		encrypted = EncryptedHealthElementPlatformApi(_methodChannel);

	Future<DecryptedHealthElement> createHealthElement(String sdkId, DecryptedHealthElement entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.createHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedHealthElement.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createHealthElement");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<List<DecryptedHealthElement>> createHealthElements(String sdkId, List<DecryptedHealthElement> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.createHealthElements',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => DecryptedHealthElement.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedHealthElement.fromJSON(x1) ).toList();
	}

	Future<DecryptedHealthElement> withEncryptionMetadata(String sdkId, DecryptedHealthElement? base, Patient patient, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedHealthElement.encode(base!)),
				"patient": jsonEncode(Patient.encode(patient)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<bool> hasWriteAccess(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<Set<String>> decryptPatientIdOf(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toSet();
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, HealthElement entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(HealthElement.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		);
	}

	Future<DecryptedHealthElement> decrypt(String sdkId, EncryptedHealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.decrypt',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(EncryptedHealthElement.encode(healthElement)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<HealthElement> tryDecrypt(String sdkId, EncryptedHealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(EncryptedHealthElement.encode(healthElement)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return HealthElement.fromJSON(parsedResJson);
	}

	Future<List<String>> matchHealthElementsBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.matchHealthElementsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchHealthElementsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchHealthElementsBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.matchHealthElementsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchHealthElementsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<DocIdentifier> deleteHealthElementById(String sdkId, String entityId, String? rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.deleteHealthElementById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElementById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteHealthElementsByIds(String sdkId, List<IdWithMandatoryRev> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.deleteHealthElementsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => IdWithMandatoryRev.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElementsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeHealthElementById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.purgeHealthElementById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<DocIdentifier> deleteHealthElement(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.deleteHealthElement',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElement");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteHealthElements(String sdkId, List<HealthElement> healthElements) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.deleteHealthElements',
			{
				"sdkId": sdkId,
				"healthElements": jsonEncode(healthElements.map((x0) => HealthElement.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeHealthElement(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.purgeHealthElement',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		);
	}

	Future<DecryptedHealthElement> shareWith(String sdkId, String delegateId, DecryptedHealthElement healthElement, HealthElementShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"healthElement": jsonEncode(DecryptedHealthElement.encode(healthElement)),
				"options": jsonEncode(options == null ? null : HealthElementShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<DecryptedHealthElement> shareWithMany(String sdkId, DecryptedHealthElement healthElement, Map<String, HealthElementShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.shareWithMany',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(DecryptedHealthElement.encode(healthElement)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, HealthElementShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedHealthElement>> filterHealthElementsBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.filterHealthElementsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterHealthElementsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedHealthElement.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedHealthElement>> filterHealthElementsBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.filterHealthElementsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterHealthElementsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedHealthElement.fromJSON(x0));
	}

	Future<DecryptedHealthElement> undeleteHealthElementById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.undeleteHealthElementById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthElementById");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<DecryptedHealthElement> undeleteHealthElement(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.undeleteHealthElement',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthElement");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<DecryptedHealthElement> modifyHealthElement(String sdkId, DecryptedHealthElement entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.modifyHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedHealthElement.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElement");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<List<DecryptedHealthElement>> modifyHealthElements(String sdkId, List<DecryptedHealthElement> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.modifyHealthElements',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => DecryptedHealthElement.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedHealthElement.fromJSON(x1) ).toList();
	}

	Future<DecryptedHealthElement> getHealthElement(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.getHealthElement',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getHealthElement");
		final parsedResJson = jsonDecode(res);
		return DecryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<List<DecryptedHealthElement>> getHealthElements(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.getHealthElements',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedHealthElement.fromJSON(x1) ).toList();
	}

	Future<EntitySubscription<EncryptedHealthElement>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, FilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0)).toList()),
				"filter": jsonEncode(FilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedHealthElement.fromJSON(x0));
	}
}

class TryAndRecoverHealthElementPlatformApi {
	MethodChannel _methodChannel;
	TryAndRecoverHealthElementPlatformApi(this._methodChannel);

	Future<HealthElement> shareWith(String sdkId, String delegateId, HealthElement healthElement, HealthElementShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
				"options": jsonEncode(options == null ? null : HealthElementShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return HealthElement.fromJSON(parsedResJson);
	}

	Future<HealthElement> shareWithMany(String sdkId, HealthElement healthElement, Map<String, HealthElementShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, HealthElementShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return HealthElement.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<HealthElement>> filterHealthElementsBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.filterHealthElementsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterHealthElementsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => HealthElement.fromJSON(x0));
	}

	Future<PaginatedListIterator<HealthElement>> filterHealthElementsBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.filterHealthElementsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterHealthElementsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => HealthElement.fromJSON(x0));
	}

	Future<HealthElement> undeleteHealthElementById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.undeleteHealthElementById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthElementById");
		final parsedResJson = jsonDecode(res);
		return HealthElement.fromJSON(parsedResJson);
	}

	Future<HealthElement> undeleteHealthElement(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.undeleteHealthElement',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthElement");
		final parsedResJson = jsonDecode(res);
		return HealthElement.fromJSON(parsedResJson);
	}

	Future<HealthElement> modifyHealthElement(String sdkId, HealthElement entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.modifyHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(HealthElement.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElement");
		final parsedResJson = jsonDecode(res);
		return HealthElement.fromJSON(parsedResJson);
	}

	Future<List<HealthElement>> modifyHealthElements(String sdkId, List<HealthElement> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.modifyHealthElements',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => HealthElement.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => HealthElement.fromJSON(x1) ).toList();
	}

	Future<HealthElement> getHealthElement(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.getHealthElement',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getHealthElement");
		final parsedResJson = jsonDecode(res);
		return HealthElement.fromJSON(parsedResJson);
	}

	Future<List<HealthElement>> getHealthElements(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.tryAndRecover.getHealthElements',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => HealthElement.fromJSON(x1) ).toList();
	}
}

class EncryptedHealthElementPlatformApi {
	MethodChannel _methodChannel;
	EncryptedHealthElementPlatformApi(this._methodChannel);

	Future<EncryptedHealthElement> shareWith(String sdkId, String delegateId, EncryptedHealthElement healthElement, HealthElementShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"healthElement": jsonEncode(EncryptedHealthElement.encode(healthElement)),
				"options": jsonEncode(options == null ? null : HealthElementShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<EncryptedHealthElement> shareWithMany(String sdkId, EncryptedHealthElement healthElement, Map<String, HealthElementShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(EncryptedHealthElement.encode(healthElement)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, HealthElementShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedHealthElement>> filterHealthElementsBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.filterHealthElementsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterHealthElementsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedHealthElement.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedHealthElement>> filterHealthElementsBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.filterHealthElementsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterHealthElementsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedHealthElement.fromJSON(x0));
	}

	Future<EncryptedHealthElement> undeleteHealthElementById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.undeleteHealthElementById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthElementById");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<EncryptedHealthElement> undeleteHealthElement(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.undeleteHealthElement',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthElement");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<EncryptedHealthElement> modifyHealthElement(String sdkId, EncryptedHealthElement entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.modifyHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedHealthElement.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElement");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<List<EncryptedHealthElement>> modifyHealthElements(String sdkId, List<EncryptedHealthElement> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.modifyHealthElements',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedHealthElement.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedHealthElement.fromJSON(x1) ).toList();
	}

	Future<EncryptedHealthElement> getHealthElement(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.getHealthElement',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getHealthElement");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<List<EncryptedHealthElement>> getHealthElements(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementApi.encrypted.getHealthElements',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedHealthElement.fromJSON(x1) ).toList();
	}
}