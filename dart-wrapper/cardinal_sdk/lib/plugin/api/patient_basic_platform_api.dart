// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/crypto/entities/entity_access_information.dart';
import 'package:cardinal_sdk/model/id_with_rev.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class PatientBasicPlatformApi {
	MethodChannel _methodChannel;
	PatientBasicPlatformApi(this._methodChannel);

	Future<List<String>> matchPatientsBy(String sdkId, BaseFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.matchPatientsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchPatientsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchPatientsBySorted(String sdkId, BaseSortableFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.matchPatientsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchPatientsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<EncryptedPatient>> filterPatientsBy(String sdkId, BaseFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.filterPatientsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedPatient.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedPatient>> filterPatientsBySorted(String sdkId, BaseSortableFilterOptions<Patient> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.filterPatientsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterPatientsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedPatient.fromJSON(x0));
	}

	Future<DocIdentifier> deletePatientById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.deletePatientById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deletePatientById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deletePatientsByIds(String sdkId, List<IdWithMandatoryRev> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.deletePatientsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => IdWithMandatoryRev.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deletePatientsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgePatientById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.purgePatientById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<DocIdentifier> deletePatient(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.deletePatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deletePatient");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deletePatients(String sdkId, List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.deletePatients',
			{
				"sdkId": sdkId,
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deletePatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgePatient(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.purgePatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
	}

	Future<EntityAccessInformation> getDataOwnersWithAccessTo(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.getDataOwnersWithAccessTo',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getDataOwnersWithAccessTo");
		final parsedResJson = jsonDecode(res);
		return EntityAccessInformation.fromJSON(parsedResJson);
	}

	Future<Patient> undeletePatient(String sdkId, Patient patient) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.undeletePatient',
			{
				"sdkId": sdkId,
				"patient": jsonEncode(Patient.encode(patient)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeletePatient");
		final parsedResJson = jsonDecode(res);
		return Patient.fromJSON(parsedResJson);
	}

	Future<EncryptedPatient> modifyPatient(String sdkId, EncryptedPatient entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.modifyPatient',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedPatient.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatient");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<EncryptedPatient> undeletePatientById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.undeletePatientById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeletePatientById");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<List<EncryptedPatient>> undeletePatients(String sdkId, List<IdWithMandatoryRev> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.undeletePatients',
			{
				"sdkId": sdkId,
				"ids": jsonEncode(ids.map((x0) => IdWithMandatoryRev.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeletePatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedPatient.fromJSON(x1) ).toList();
	}

	Future<EncryptedPatient> getPatient(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.getPatient',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatient");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<EncryptedPatient> getPatientResolvingMerges(String sdkId, String patientId, int? maxMergeDepth) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.getPatientResolvingMerges',
			{
				"sdkId": sdkId,
				"patientId": jsonEncode(patientId),
				"maxMergeDepth": jsonEncode(maxMergeDepth),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatientResolvingMerges");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<List<EncryptedPatient>> getPatients(String sdkId, List<String> patientIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.getPatients',
			{
				"sdkId": sdkId,
				"patientIds": jsonEncode(patientIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedPatient.fromJSON(x1) ).toList();
	}

	Future<List<IdWithRev>> modifyPatients(String sdkId, List<EncryptedPatient> patientDtos) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.modifyPatients',
			{
				"sdkId": sdkId,
				"patientDtos": jsonEncode(patientDtos.map((x0) => EncryptedPatient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPatients");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => IdWithRev.fromJSON(x1) ).toList();
	}

	Future<EncryptedPatient> mergePatients(String sdkId, Patient from, EncryptedPatient mergedInto) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.mergePatients',
			{
				"sdkId": sdkId,
				"from": jsonEncode(Patient.encode(from)),
				"mergedInto": jsonEncode(EncryptedPatient.encode(mergedInto)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method mergePatients");
		final parsedResJson = jsonDecode(res);
		return EncryptedPatient.fromJSON(parsedResJson);
	}

	Future<EntitySubscription<EncryptedPatient>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, BaseFilterOptions<Patient> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientBasicApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0)).toList()),
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedPatient.fromJSON(x0));
	}
}