// auto-generated file
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
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
	String _sdkId;
	TryAndRecoverPatientPlatformApi tryAndRecover;
	EncryptedPatientPlatformApi encrypted;
	PatientPlatformApi(
		this._sdkId
		) : tryAndRecover = TryAndRecoverPatientPlatformApi(_sdkId),
		encrypted = EncryptedPatientPlatformApi(_sdkId);

	Future<Set<String>> getSecretIdsOf(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.getSecretIdsOf(
			_sdkId,
			patient,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.getEncryptionKeysOf(
			_sdkId,
			patient,
		);
	}

	Future<DecryptedPatient> createPatient(DecryptedPatient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.createPatient(
			_sdkId,
			patient,
		);
	}

	Future<DecryptedPatient> withEncryptionMetadata(DecryptedPatient? base, User? user, { Map<String, AccessLevel> delegates = const {} }) async {
		return await CardinalSdkPlatformInterface.instance.patient.withEncryptionMetadata(
			_sdkId,
			base,
			user,
			delegates,
		);
	}

	Future<bool> hasWriteAccess(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.hasWriteAccess(
			_sdkId,
			patient,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(Patient entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.patient.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedPatient> decrypt(EncryptedPatient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.decrypt(
			_sdkId,
			patient,
		);
	}

	Future<Patient> tryDecrypt(EncryptedPatient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.tryDecrypt(
			_sdkId,
			patient,
		);
	}

	Future<List<IdWithRev>> createPatients(List<DecryptedPatient> patientDtos) async {
		return await CardinalSdkPlatformInterface.instance.patient.createPatients(
			_sdkId,
			patientDtos,
		);
	}

	Future<ShareAllPatientDataOptionsResult> shareAllDataOfPatient(String patientId, Map<String, Set<ShareAllPatientDataOptionsTag>> delegatesWithShareType) async {
		return await CardinalSdkPlatformInterface.instance.patient.shareAllDataOfPatient(
			_sdkId,
			patientId,
			delegatesWithShareType,
		);
	}

	Future<Set<String>> getConfidentialSecretIdsOf(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.getConfidentialSecretIdsOf(
			_sdkId,
			patient,
		);
	}

	Future<bool> forceInitializeExchangeDataToNewlyInvitedPatient(String patientId) async {
		return await CardinalSdkPlatformInterface.instance.patient.forceInitializeExchangeDataToNewlyInvitedPatient(
			_sdkId,
			patientId,
		);
	}

	Future<List<String>> matchPatientsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.patient.matchPatientsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchPatientsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.patient.matchPatientsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedPatient> ensureEncryptionMetadataForSelfIsInitialized({ Map<String, AccessLevel> sharingWith = const {} }) async {
		return await CardinalSdkPlatformInterface.instance.patient.ensureEncryptionMetadataForSelfIsInitialized(
			_sdkId,
			sharingWith,
		);
	}

	Future<DocIdentifier> deletePatientById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.patient.deletePatientById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deletePatientsByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.patient.deletePatientsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgePatientById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.patient.purgePatientById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deletePatient(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.deletePatient(
			_sdkId,
			patient,
		);
	}

	Future<List<DocIdentifier>> deletePatients(List<Patient> patients) async {
		return await CardinalSdkPlatformInterface.instance.patient.deletePatients(
			_sdkId,
			patients,
		);
	}

	Future<void> purgePatient(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.purgePatient(
			_sdkId,
			patient,
		);
	}

	Future<EntityAccessInformation> getDataOwnersWithAccessTo(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.getDataOwnersWithAccessTo(
			_sdkId,
			patient,
		);
	}

	Future<DecryptedPatient> shareWith(String delegateId, DecryptedPatient patient, PatientShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.patient.shareWith(
			_sdkId,
			delegateId,
			patient,
			options,
		);
	}

	Future<DecryptedPatient> shareWithMany(DecryptedPatient patient, Map<String, PatientShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.patient.shareWithMany(
			_sdkId,
			patient,
			delegates,
		);
	}

	Future<DecryptedPatient> initializeConfidentialSecretId(DecryptedPatient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.initializeConfidentialSecretId(
			_sdkId,
			patient,
		);
	}

	Future<PaginatedListIterator<DecryptedPatient>> filterPatientsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.patient.filterPatientsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedPatient>> filterPatientsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.patient.filterPatientsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Patient> undeletePatient(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.undeletePatient(
			_sdkId,
			patient,
		);
	}

	Future<DecryptedPatient> modifyPatient(DecryptedPatient entity) async {
		return await CardinalSdkPlatformInterface.instance.patient.modifyPatient(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedPatient> undeletePatientById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.patient.undeletePatientById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<List<DecryptedPatient>> undeletePatients(List<IdWithMandatoryRev> ids) async {
		return await CardinalSdkPlatformInterface.instance.patient.undeletePatients(
			_sdkId,
			ids,
		);
	}

	Future<DecryptedPatient> getPatient(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.patient.getPatient(
			_sdkId,
			entityId,
		);
	}

	Future<DecryptedPatient> getPatientResolvingMerges(String patientId, int? maxMergeDepth) async {
		return await CardinalSdkPlatformInterface.instance.patient.getPatientResolvingMerges(
			_sdkId,
			patientId,
			maxMergeDepth,
		);
	}

	Future<List<DecryptedPatient>> getPatients(List<String> patientIds) async {
		return await CardinalSdkPlatformInterface.instance.patient.getPatients(
			_sdkId,
			patientIds,
		);
	}

	Future<List<IdWithRev>> modifyPatients(List<EncryptedPatient> patientDtos) async {
		return await CardinalSdkPlatformInterface.instance.patient.modifyPatients(
			_sdkId,
			patientDtos,
		);
	}

	Future<DecryptedPatient> mergePatients(Patient from, DecryptedPatient mergedInto) async {
		return await CardinalSdkPlatformInterface.instance.patient.mergePatients(
			_sdkId,
			from,
			mergedInto,
		);
	}

	Future<EntitySubscription<EncryptedPatient>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		return await CardinalSdkPlatformInterface.instance.patient.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class TryAndRecoverPatientPlatformApi {
	String _sdkId;
	TryAndRecoverPatientPlatformApi(this._sdkId);

	Future<Patient> shareWith(String delegateId, Patient patient, PatientShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.patient.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			patient,
			options,
		);
	}

	Future<Patient> shareWithMany(Patient patient, Map<String, PatientShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.patient.tryAndRecover.shareWithMany(
			_sdkId,
			patient,
			delegates,
		);
	}

	Future<Patient> initializeConfidentialSecretId(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.tryAndRecover.initializeConfidentialSecretId(
			_sdkId,
			patient,
		);
	}

	Future<PaginatedListIterator<Patient>> filterPatientsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.patient.tryAndRecover.filterPatientsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Patient>> filterPatientsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.patient.tryAndRecover.filterPatientsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Patient> undeletePatient(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.tryAndRecover.undeletePatient(
			_sdkId,
			patient,
		);
	}

	Future<Patient> modifyPatient(Patient entity) async {
		return await CardinalSdkPlatformInterface.instance.patient.tryAndRecover.modifyPatient(
			_sdkId,
			entity,
		);
	}

	Future<Patient> undeletePatientById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.patient.tryAndRecover.undeletePatientById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<List<Patient>> undeletePatients(List<IdWithMandatoryRev> ids) async {
		return await CardinalSdkPlatformInterface.instance.patient.tryAndRecover.undeletePatients(
			_sdkId,
			ids,
		);
	}

	Future<Patient> getPatient(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.patient.tryAndRecover.getPatient(
			_sdkId,
			entityId,
		);
	}

	Future<Patient> getPatientResolvingMerges(String patientId, int? maxMergeDepth) async {
		return await CardinalSdkPlatformInterface.instance.patient.tryAndRecover.getPatientResolvingMerges(
			_sdkId,
			patientId,
			maxMergeDepth,
		);
	}

	Future<List<Patient>> getPatients(List<String> patientIds) async {
		return await CardinalSdkPlatformInterface.instance.patient.tryAndRecover.getPatients(
			_sdkId,
			patientIds,
		);
	}

	Future<List<IdWithRev>> modifyPatients(List<EncryptedPatient> patientDtos) async {
		return await CardinalSdkPlatformInterface.instance.patient.tryAndRecover.modifyPatients(
			_sdkId,
			patientDtos,
		);
	}

	Future<Patient> mergePatients(Patient from, Patient mergedInto) async {
		return await CardinalSdkPlatformInterface.instance.patient.tryAndRecover.mergePatients(
			_sdkId,
			from,
			mergedInto,
		);
	}
}

class EncryptedPatientPlatformApi {
	String _sdkId;
	EncryptedPatientPlatformApi(this._sdkId);

	Future<EncryptedPatient> shareWith(String delegateId, EncryptedPatient patient, PatientShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.patient.encrypted.shareWith(
			_sdkId,
			delegateId,
			patient,
			options,
		);
	}

	Future<EncryptedPatient> shareWithMany(EncryptedPatient patient, Map<String, PatientShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.patient.encrypted.shareWithMany(
			_sdkId,
			patient,
			delegates,
		);
	}

	Future<EncryptedPatient> initializeConfidentialSecretId(EncryptedPatient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.encrypted.initializeConfidentialSecretId(
			_sdkId,
			patient,
		);
	}

	Future<PaginatedListIterator<EncryptedPatient>> filterPatientsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.patient.encrypted.filterPatientsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedPatient>> filterPatientsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.patient.encrypted.filterPatientsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Patient> undeletePatient(Patient patient) async {
		return await CardinalSdkPlatformInterface.instance.patient.encrypted.undeletePatient(
			_sdkId,
			patient,
		);
	}

	Future<EncryptedPatient> modifyPatient(EncryptedPatient entity) async {
		return await CardinalSdkPlatformInterface.instance.patient.encrypted.modifyPatient(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedPatient> undeletePatientById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.patient.encrypted.undeletePatientById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<List<EncryptedPatient>> undeletePatients(List<IdWithMandatoryRev> ids) async {
		return await CardinalSdkPlatformInterface.instance.patient.encrypted.undeletePatients(
			_sdkId,
			ids,
		);
	}

	Future<EncryptedPatient> getPatient(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.patient.encrypted.getPatient(
			_sdkId,
			entityId,
		);
	}

	Future<EncryptedPatient> getPatientResolvingMerges(String patientId, int? maxMergeDepth) async {
		return await CardinalSdkPlatformInterface.instance.patient.encrypted.getPatientResolvingMerges(
			_sdkId,
			patientId,
			maxMergeDepth,
		);
	}

	Future<List<EncryptedPatient>> getPatients(List<String> patientIds) async {
		return await CardinalSdkPlatformInterface.instance.patient.encrypted.getPatients(
			_sdkId,
			patientIds,
		);
	}

	Future<List<IdWithRev>> modifyPatients(List<EncryptedPatient> patientDtos) async {
		return await CardinalSdkPlatformInterface.instance.patient.encrypted.modifyPatients(
			_sdkId,
			patientDtos,
		);
	}

	Future<EncryptedPatient> mergePatients(Patient from, EncryptedPatient mergedInto) async {
		return await CardinalSdkPlatformInterface.instance.patient.encrypted.mergePatients(
			_sdkId,
			from,
			mergedInto,
		);
	}
}