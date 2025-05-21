// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/entity_access_information.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';
import 'package:cardinal_sdk/model/group_scoped.dart';


class PatientBasicApi {
	final String _sdkId;
	final Object _dartSdk;
	final PatientBasicInGroupApi inGroup;
	PatientBasicApi(
		this._sdkId,
		this._dartSdk
		) : inGroup = PatientBasicInGroupApi(_sdkId, _dartSdk);

	Future<List<String>> matchPatientsBy(BaseFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.matchPatientsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchPatientsBySorted(BaseSortableFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.matchPatientsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedPatient>> filterPatientsBy(BaseFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.filterPatientsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedPatient>> filterPatientsBySorted(BaseSortableFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.filterPatientsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<StoredDocumentIdentifier> deletePatientById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.deletePatientById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<StoredDocumentIdentifier>> deletePatientsByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.deletePatientsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgePatientById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.purgePatientById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<StoredDocumentIdentifier> deletePatient(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.deletePatient(
			_sdkId,
			patient,
		);
	}

	Future<List<StoredDocumentIdentifier>> deletePatients(List<Patient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.deletePatients(
			_sdkId,
			patients,
		);
	}

	Future<void> purgePatient(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.purgePatient(
			_sdkId,
			patient,
		);
	}

	Future<EntityAccessInformation> getDataOwnersWithAccessTo(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.getDataOwnersWithAccessTo(
			_sdkId,
			patient,
		);
	}

	Future<EncryptedPatient> createPatient(EncryptedPatient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.createPatient(
			_sdkId,
			patient,
		);
	}

	Future<List<StoredDocumentIdentifier>> createPatientsMinimal(List<EncryptedPatient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.createPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<EncryptedPatient>> createPatients(List<EncryptedPatient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.createPatients(
			_sdkId,
			patients,
		);
	}

	Future<Patient> undeletePatient(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.undeletePatient(
			_sdkId,
			patient,
		);
	}

	Future<EncryptedPatient> modifyPatient(EncryptedPatient entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.modifyPatient(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedPatient> undeletePatientById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.undeletePatientById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<List<EncryptedPatient>> undeletePatients(List<StoredDocumentIdentifier> ids) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.undeletePatients(
			_sdkId,
			ids,
		);
	}

	Future<EncryptedPatient?> getPatient(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.getPatient(
			_sdkId,
			entityId,
		);
	}

	Future<EncryptedPatient> getPatientResolvingMerges(String patientId, int? maxMergeDepth) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.getPatientResolvingMerges(
			_sdkId,
			patientId,
			maxMergeDepth,
		);
	}

	Future<List<EncryptedPatient>> getPatients(List<String> patientIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.getPatients(
			_sdkId,
			patientIds,
		);
	}

	Future<List<StoredDocumentIdentifier>> modifyPatientsMinimal(List<EncryptedPatient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.modifyPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<EncryptedPatient>> modifyPatients(List<EncryptedPatient> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.modifyPatients(
			_sdkId,
			patients,
		);
	}

	Future<EncryptedPatient> mergePatients(Patient from, EncryptedPatient mergedInto) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.mergePatients(
			_sdkId,
			from,
			mergedInto,
		);
	}

	Future<EntitySubscription<EncryptedPatient>> subscribeToEvents(Set<SubscriptionEventType> events, BaseFilterOptions<Patient> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class PatientBasicInGroupApi {
	final String _sdkId;
	final Object _dartSdk;
	PatientBasicInGroupApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<String>> matchPatientsBy(String groupId, BaseFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.inGroup.matchPatientsBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<List<String>> matchPatientsBySorted(String groupId, BaseSortableFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.inGroup.matchPatientsBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedPatient>>> filterPatientsBy(String groupId, BaseFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.inGroup.filterPatientsBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<PaginatedListIterator<GroupScoped<EncryptedPatient>>> filterPatientsBySorted(String groupId, BaseSortableFilterOptions<Patient> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.inGroup.filterPatientsBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<EntityAccessInformation> getDataOwnersWithAccessTo(GroupScoped<Patient> patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.inGroup.getDataOwnersWithAccessTo(
			_sdkId,
			patient,
		);
	}

	Future<GroupScoped<EncryptedPatient>> createPatient(GroupScoped<EncryptedPatient> patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.inGroup.createPatient(
			_sdkId,
			patient,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> createPatientsMinimal(List<GroupScoped<EncryptedPatient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.inGroup.createPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<GroupScoped<EncryptedPatient>>> createPatients(List<GroupScoped<EncryptedPatient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.inGroup.createPatients(
			_sdkId,
			patients,
		);
	}

	Future<GroupScoped<EncryptedPatient>?> getPatient(String groupId, String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.inGroup.getPatient(
			_sdkId,
			groupId,
			entityId,
		);
	}

	Future<GroupScoped<EncryptedPatient>> getPatientResolvingMerges(String groupId, String patientId, int? maxMergeDepth) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.inGroup.getPatientResolvingMerges(
			_sdkId,
			groupId,
			patientId,
			maxMergeDepth,
		);
	}

	Future<List<GroupScoped<EncryptedPatient>>> getPatients(String groupId, List<String> patientIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.inGroup.getPatients(
			_sdkId,
			groupId,
			patientIds,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> modifyPatientsMinimal(List<GroupScoped<EncryptedPatient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.inGroup.modifyPatientsMinimal(
			_sdkId,
			patients,
		);
	}

	Future<List<GroupScoped<EncryptedPatient>>> modifyPatients(List<GroupScoped<EncryptedPatient>> patients) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.inGroup.modifyPatients(
			_sdkId,
			patients,
		);
	}
}