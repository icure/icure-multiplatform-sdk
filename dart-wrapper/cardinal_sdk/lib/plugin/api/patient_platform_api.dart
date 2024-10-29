// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/model/id_with_rev.dart';
import 'package:cardinal_sdk/crypto/entities/share_all_patient_data_options.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/crypto/entities/entity_access_information.dart';
import 'package:cardinal_sdk/crypto/entities/patient_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class PatientPlatformApi {
	MethodChannel _methodChannel;
	TryAndRecoverPatientPlatformApi tryAndRecover;
	EncryptedPatientPlatformApi encrypted;
	PatientPlatformApi(
		this._methodChannel
		) : tryAndRecover = TryAndRecoverPatientPlatformApi(_methodChannel),
		encrypted = EncryptedPatientPlatformApi(_methodChannel);

	Future<Set<String>> getSecretIdsOf(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.getSecretIdsOf',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getSecretIdsOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toSet();
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as HexString) ).toSet();
	}

	Future<DecryptedPatient> createPatient(String sdkId, DecryptedPatient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.createPatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(DecryptedPatient.encode(patient)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createPatient");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<DecryptedPatient> withEncryptionMetadata(String sdkId, DecryptedPatient? base, User? user, Map<String, AccessLevel> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedPatient.encode(base!)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<bool> hasWriteAccess(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, Patient entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Patient.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0).toList()),
			}
		);
	}

	Future<DecryptedPatient> decrypt(String sdkId, EncryptedPatient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.decrypt',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(EncryptedPatient.encode(patient)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<Patient> tryDecrypt(String sdkId, EncryptedPatient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(EncryptedPatient.encode(patient)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<List<IdWithRev>> createPatients(String sdkId, List<DecryptedPatient> patientDtos) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.createPatients',
			{
				"sdkId": sdkId,
				"patientDtos": jsonEncode(patientDtos.map((x0) => DecryptedPatient.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => IdWithRev.fromJSON(x1) ).toList();
	}

	Future<ShareAllPatientDataOptionsResult> shareAllDataOfPatient(String sdkId, String patientId, Map<String, Set<ShareAllPatientDataOptionsTag>> delegatesWithShareType) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.shareAllDataOfPatient',
			{
				"sdkId": sdkId,
				"patientId": jsonEncode(patientId),
				"delegatesWithShareType": jsonEncode(delegatesWithShareType.map((k0, v0) => MapEntry(k0, v0.map((x1) => ShareAllPatientDataOptionsTag.encode(x1)).toList()))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareAllDataOfPatient");
		final parsedResJson = jsonDecode(res);
		return ShareAllPatientDataOptionsResult.fromJSON(parsedResJson);
	}

	Future<Set<String>> getConfidentialSecretIdsOf(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.getConfidentialSecretIdsOf',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getConfidentialSecretIdsOf");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toSet();
	}

	Future<bool> forceInitializeExchangeDataToNewlyInvitedPatient(String sdkId, String patientId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.forceInitializeExchangeDataToNewlyInvitedPatient',
			{
				"sdkId": sdkId,
				"patientId": jsonEncode(patientId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method forceInitializeExchangeDataToNewlyInvitedPatient");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as bool);
	}

	Future<List<String>> matchPatientsBy(String sdkId, FilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.matchPatientsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchPatientsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchPatientsBySorted(String sdkId, SortableFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.matchPatientsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchPatientsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<EncryptedPatient> ensureEncryptionMetadataForSelfIsInitialized(String sdkId, Map<String, AccessLevel> sharingWith) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.ensureEncryptionMetadataForSelfIsInitialized',
			{
				"sdkId": sdkId,
				"sharingWith": jsonEncode(sharingWith.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method ensureEncryptionMetadataForSelfIsInitialized");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deletePatientById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.deletePatientById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deletePatientById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deletePatientsByIds(String sdkId, List<IdWithMandatoryRev> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.deletePatientsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => IdWithMandatoryRev.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deletePatientsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgePatientById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.purgePatientById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<DocIdentifier> deletePatient(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.deletePatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deletePatient");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deletePatients(String sdkId, List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.deletePatients',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deletePatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgePatient(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.purgePatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		);
	}

	Future<EntityAccessInformation> getDataOwnersWithAccessTo(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.getDataOwnersWithAccessTo',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getDataOwnersWithAccessTo");
		final parsedResJson = jsonDecode(res);
		return EntityAccessInformation.fromJSON(parsedResJson);
	}

	Future<DecryptedPatient> shareWith(String sdkId, String delegateId, DecryptedPatient patient, PatientShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"patient": jsonEncode(DecryptedPatient.encode(patient)),
				"options": jsonEncode(options == null ? null : PatientShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<DecryptedPatient> shareWithMany(String sdkId, DecryptedPatient patient, Map<String, PatientShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.shareWithMany',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(DecryptedPatient.encode(patient)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, PatientShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<DecryptedPatient> initializeConfidentialSecretId(String sdkId, DecryptedPatient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.initializeConfidentialSecretId',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(DecryptedPatient.encode(patient)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method initializeConfidentialSecretId");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedPatient>> filterPatientsBy(String sdkId, FilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.filterPatientsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedPatient.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedPatient>> filterPatientsBySorted(String sdkId, SortableFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.filterPatientsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedPatient.fromJSON(x0));
	}

	Future<Patient> undeletePatient(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.undeletePatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeletePatient");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<DecryptedPatient> modifyPatient(String sdkId, DecryptedPatient entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.modifyPatient',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedPatient.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyPatient");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<DecryptedPatient> undeletePatientById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.undeletePatientById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeletePatientById");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<List<DecryptedPatient>> undeletePatients(String sdkId, List<IdWithMandatoryRev> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.undeletePatients',
			{
				"sdkId": sdkId,
				"ids": jsonEncode(ids.map((x0) => IdWithMandatoryRev.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeletePatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedPatient.fromJSON(x1) ).toList();
	}

	Future<DecryptedPatient> getPatient(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.getPatient',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getPatient");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<DecryptedPatient> getPatientResolvingMerges(String sdkId, String patientId, int? maxMergeDepth) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.getPatientResolvingMerges',
			{
				"sdkId": sdkId,
				"patientId": jsonEncode(patientId),
				"maxMergeDepth": jsonEncode(maxMergeDepth),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getPatientResolvingMerges");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<List<DecryptedPatient>> getPatients(String sdkId, List<String> patientIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.getPatients',
			{
				"sdkId": sdkId,
				"patientIds": jsonEncode(patientIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DecryptedPatient.fromJSON(x1) ).toList();
	}

	Future<List<IdWithRev>> modifyPatients(String sdkId, List<EncryptedPatient> patientDtos) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.modifyPatients',
			{
				"sdkId": sdkId,
				"patientDtos": jsonEncode(patientDtos.map((x0) => EncryptedPatient.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => IdWithRev.fromJSON(x1) ).toList();
	}

	Future<DecryptedPatient> mergePatients(String sdkId, Patient from, DecryptedPatient mergedInto) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.mergePatients',
			{
				"sdkId": sdkId,
				"from": jsonEncode(Patient.encode(from)),
				"mergedInto": jsonEncode(DecryptedPatient.encode(mergedInto)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method mergePatients");
		final parsedResJson = jsonDecode(res);
		return DecryptedPatient.fromJSON(parsedResJson);
	}

	Future<EntitySubscription<EncryptedPatient>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, FilterOptions<Patient> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0)).toList()),
				"filter": jsonEncode(FilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedPatient.fromJSON(x0));
	}
}

class TryAndRecoverPatientPlatformApi {
	MethodChannel _methodChannel;
	TryAndRecoverPatientPlatformApi(this._methodChannel);

	Future<Patient> shareWith(String sdkId, String delegateId, Patient patient, PatientShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"patient": jsonEncode(Patient.encode(patient)),
				"options": jsonEncode(options == null ? null : PatientShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<Patient> shareWithMany(String sdkId, Patient patient, Map<String, PatientShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, PatientShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<Patient> initializeConfidentialSecretId(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.initializeConfidentialSecretId',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method initializeConfidentialSecretId");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<Patient>> filterPatientsBy(String sdkId, FilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.filterPatientsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Patient.fromJSON(x0));
	}

	Future<PaginatedListIterator<Patient>> filterPatientsBySorted(String sdkId, SortableFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.filterPatientsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Patient.fromJSON(x0));
	}

	Future<Patient> undeletePatient(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.undeletePatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeletePatient");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<Patient> modifyPatient(String sdkId, Patient entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.modifyPatient',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Patient.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyPatient");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<Patient> undeletePatientById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.undeletePatientById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeletePatientById");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<List<Patient>> undeletePatients(String sdkId, List<IdWithMandatoryRev> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.undeletePatients',
			{
				"sdkId": sdkId,
				"ids": jsonEncode(ids.map((x0) => IdWithMandatoryRev.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeletePatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Patient.fromJSON(x1) ).toList();
	}

	Future<Patient> getPatient(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.getPatient',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getPatient");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<Patient> getPatientResolvingMerges(String sdkId, String patientId, int? maxMergeDepth) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.getPatientResolvingMerges',
			{
				"sdkId": sdkId,
				"patientId": jsonEncode(patientId),
				"maxMergeDepth": jsonEncode(maxMergeDepth),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getPatientResolvingMerges");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<List<Patient>> getPatients(String sdkId, List<String> patientIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.getPatients',
			{
				"sdkId": sdkId,
				"patientIds": jsonEncode(patientIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Patient.fromJSON(x1) ).toList();
	}

	Future<List<IdWithRev>> modifyPatients(String sdkId, List<EncryptedPatient> patientDtos) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.modifyPatients',
			{
				"sdkId": sdkId,
				"patientDtos": jsonEncode(patientDtos.map((x0) => EncryptedPatient.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => IdWithRev.fromJSON(x1) ).toList();
	}

	Future<Patient> mergePatients(String sdkId, Patient from, Patient mergedInto) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.tryAndRecover.mergePatients',
			{
				"sdkId": sdkId,
				"from": jsonEncode(Patient.encode(from)),
				"mergedInto": jsonEncode(Patient.encode(mergedInto)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method mergePatients");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}
}

class EncryptedPatientPlatformApi {
	MethodChannel _methodChannel;
	EncryptedPatientPlatformApi(this._methodChannel);

	Future<EncryptedPatient> shareWith(String sdkId, String delegateId, EncryptedPatient patient, PatientShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"patient": jsonEncode(EncryptedPatient.encode(patient)),
				"options": jsonEncode(options == null ? null : PatientShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<EncryptedPatient> shareWithMany(String sdkId, EncryptedPatient patient, Map<String, PatientShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(EncryptedPatient.encode(patient)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, PatientShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<EncryptedPatient> initializeConfidentialSecretId(String sdkId, EncryptedPatient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.initializeConfidentialSecretId',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(EncryptedPatient.encode(patient)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method initializeConfidentialSecretId");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedPatient>> filterPatientsBy(String sdkId, FilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.filterPatientsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedPatient.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedPatient>> filterPatientsBySorted(String sdkId, SortableFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.filterPatientsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedPatient.fromJSON(x0));
	}

	Future<Patient> undeletePatient(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.undeletePatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeletePatient");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<EncryptedPatient> modifyPatient(String sdkId, EncryptedPatient entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.modifyPatient',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedPatient.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyPatient");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<EncryptedPatient> undeletePatientById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.undeletePatientById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeletePatientById");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<List<EncryptedPatient>> undeletePatients(String sdkId, List<IdWithMandatoryRev> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.undeletePatients',
			{
				"sdkId": sdkId,
				"ids": jsonEncode(ids.map((x0) => IdWithMandatoryRev.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeletePatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedPatient.fromJSON(x1) ).toList();
	}

	Future<EncryptedPatient> getPatient(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.getPatient',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getPatient");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<EncryptedPatient> getPatientResolvingMerges(String sdkId, String patientId, int? maxMergeDepth) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.getPatientResolvingMerges',
			{
				"sdkId": sdkId,
				"patientId": jsonEncode(patientId),
				"maxMergeDepth": jsonEncode(maxMergeDepth),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getPatientResolvingMerges");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<List<EncryptedPatient>> getPatients(String sdkId, List<String> patientIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.getPatients',
			{
				"sdkId": sdkId,
				"patientIds": jsonEncode(patientIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedPatient.fromJSON(x1) ).toList();
	}

	Future<List<IdWithRev>> modifyPatients(String sdkId, List<EncryptedPatient> patientDtos) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.modifyPatients',
			{
				"sdkId": sdkId,
				"patientDtos": jsonEncode(patientDtos.map((x0) => EncryptedPatient.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => IdWithRev.fromJSON(x1) ).toList();
	}

	Future<EncryptedPatient> mergePatients(String sdkId, Patient from, EncryptedPatient mergedInto) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientApi.encrypted.mergePatients',
			{
				"sdkId": sdkId,
				"from": jsonEncode(Patient.encode(from)),
				"mergedInto": jsonEncode(EncryptedPatient.encode(mergedInto)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method mergePatients");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}
}