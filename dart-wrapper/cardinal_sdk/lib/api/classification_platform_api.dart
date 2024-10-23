// auto-generated file
import 'package:cardinal_sdk/model/classification.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/classification_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class ClassificationPlatformApi {
	String _sdkId;
	TryAndRecoverClassificationPlatformApi tryAndRecover;
	EncryptedClassificationPlatformApi encrypted;
	ClassificationPlatformApi(
		this._sdkId
		) : tryAndRecover = TryAndRecoverClassificationPlatformApi(_sdkId),
		encrypted = EncryptedClassificationPlatformApi(_sdkId);

	Future<DecryptedClassification> createClassification(DecryptedClassification entity) async {
		return await CardinalSdkPlatformInterface.instance.classification.createClassification(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedClassification> withEncryptionMetadata(DecryptedClassification? base, Patient patient, User? user, { Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent }) async {
		return await CardinalSdkPlatformInterface.instance.classification.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(Classification classification) async {
		return await CardinalSdkPlatformInterface.instance.classification.getEncryptionKeysOf(
			_sdkId,
			classification,
		);
	}

	Future<bool> hasWriteAccess(Classification classification) async {
		return await CardinalSdkPlatformInterface.instance.classification.hasWriteAccess(
			_sdkId,
			classification,
		);
	}

	Future<Set<String>> decryptPatientIdOf(Classification classification) async {
		return await CardinalSdkPlatformInterface.instance.classification.decryptPatientIdOf(
			_sdkId,
			classification,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(Classification entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.classification.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedClassification> decrypt(EncryptedClassification classification) async {
		return await CardinalSdkPlatformInterface.instance.classification.decrypt(
			_sdkId,
			classification,
		);
	}

	Future<Classification> tryDecrypt(EncryptedClassification classification) async {
		return await CardinalSdkPlatformInterface.instance.classification.tryDecrypt(
			_sdkId,
			classification,
		);
	}

	Future<List<String>> matchClassificationsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.classification.matchClassificationsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchClassificationsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.classification.matchClassificationsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteClassification(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.classification.deleteClassification(
			_sdkId,
			entityId,
		);
	}

	Future<List<DocIdentifier>> deleteClassifications(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.classification.deleteClassifications(
			_sdkId,
			entityIds,
		);
	}

	Future<DecryptedClassification> shareWith(String delegateId, DecryptedClassification classification, ClassificationShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.classification.shareWith(
			_sdkId,
			delegateId,
			classification,
			options,
		);
	}

	Future<DecryptedClassification> shareWithMany(DecryptedClassification classification, Map<String, ClassificationShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.classification.shareWithMany(
			_sdkId,
			classification,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedClassification>> filterClassificationsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.classification.filterClassificationsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedClassification>> filterClassificationsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.classification.filterClassificationsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedClassification> modifyClassification(DecryptedClassification entity) async {
		return await CardinalSdkPlatformInterface.instance.classification.modifyClassification(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedClassification> getClassification(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.classification.getClassification(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedClassification>> getClassifications(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.classification.getClassifications(
			_sdkId,
			entityIds,
		);
	}
}

class TryAndRecoverClassificationPlatformApi {
	String _sdkId;
	TryAndRecoverClassificationPlatformApi(this._sdkId);

	Future<Classification> shareWith(String delegateId, Classification classification, ClassificationShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.classification.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			classification,
			options,
		);
	}

	Future<Classification> shareWithMany(Classification classification, Map<String, ClassificationShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.classification.tryAndRecover.shareWithMany(
			_sdkId,
			classification,
			delegates,
		);
	}

	Future<PaginatedListIterator<Classification>> filterClassificationsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.classification.tryAndRecover.filterClassificationsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Classification>> filterClassificationsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.classification.tryAndRecover.filterClassificationsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Classification> modifyClassification(Classification entity) async {
		return await CardinalSdkPlatformInterface.instance.classification.tryAndRecover.modifyClassification(
			_sdkId,
			entity,
		);
	}

	Future<Classification> getClassification(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.classification.tryAndRecover.getClassification(
			_sdkId,
			entityId,
		);
	}

	Future<List<Classification>> getClassifications(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.classification.tryAndRecover.getClassifications(
			_sdkId,
			entityIds,
		);
	}
}

class EncryptedClassificationPlatformApi {
	String _sdkId;
	EncryptedClassificationPlatformApi(this._sdkId);

	Future<EncryptedClassification> shareWith(String delegateId, EncryptedClassification classification, ClassificationShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.classification.encrypted.shareWith(
			_sdkId,
			delegateId,
			classification,
			options,
		);
	}

	Future<EncryptedClassification> shareWithMany(EncryptedClassification classification, Map<String, ClassificationShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.classification.encrypted.shareWithMany(
			_sdkId,
			classification,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedClassification>> filterClassificationsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.classification.encrypted.filterClassificationsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedClassification>> filterClassificationsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.classification.encrypted.filterClassificationsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedClassification> modifyClassification(EncryptedClassification entity) async {
		return await CardinalSdkPlatformInterface.instance.classification.encrypted.modifyClassification(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedClassification> getClassification(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.classification.encrypted.getClassification(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedClassification>> getClassifications(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.classification.encrypted.getClassifications(
			_sdkId,
			entityIds,
		);
	}
}