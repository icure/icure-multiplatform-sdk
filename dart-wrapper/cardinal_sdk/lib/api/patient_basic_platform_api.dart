// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/crypto/entities/entity_access_information.dart';
import 'package:cardinal_sdk/model/id_with_rev.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class PatientBasicPlatformApi {
	String _sdkId;
	PatientBasicPlatformApi(this._sdkId);

	Future<List<String>> matchPatientsBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.matchPatientsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchPatientsBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.matchPatientsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedPatient>> filterPatientsBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.filterPatientsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedPatient>> filterPatientsBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.filterPatientsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deletePatientById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.deletePatientById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deletePatientsByIds(List<IdWithMandatoryRev> entityIds) async {
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

	Future<DocIdentifier> deletePatient(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.deletePatient(
			_sdkId,
			patient,
		);
	}

	Future<List<DocIdentifier>> deletePatients(List<Patient> patients) async {
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

	Future<List<EncryptedPatient>> undeletePatients(List<IdWithMandatoryRev> ids) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.undeletePatients(
			_sdkId,
			ids,
		);
	}

	Future<EncryptedPatient> getPatient(String entityId) async {
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

	Future<List<IdWithRev>> modifyPatients(List<EncryptedPatient> patientDtos) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.modifyPatients(
			_sdkId,
			patientDtos,
		);
	}

	Future<EncryptedPatient> mergePatients(Patient from, EncryptedPatient mergedInto) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.mergePatients(
			_sdkId,
			from,
			mergedInto,
		);
	}

	Future<EntitySubscription<EncryptedPatient>> subscribeToEvents(Set<SubscriptionEventType> events, BaseFilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		return await CardinalSdkPlatformInterface.instance.apis.patientBasic.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}