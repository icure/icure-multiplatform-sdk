// auto-generated file
import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/classification.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class ClassificationBasicApi {
	final String _sdkId;
	final CardinalSdk _dartSdk;
	ClassificationBasicApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<String>> matchClassificationsBy(BaseFilterOptions<Classification> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.classificationBasic.matchClassificationsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchClassificationsBySorted(BaseSortableFilterOptions<Classification> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.classificationBasic.matchClassificationsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedClassification>> filterClassificationsBy(BaseFilterOptions<Classification> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.classificationBasic.filterClassificationsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedClassification>> filterClassificationsBySorted(BaseSortableFilterOptions<Classification> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.classificationBasic.filterClassificationsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteClassification(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.classificationBasic.deleteClassification(
			_sdkId,
			entityId,
		);
	}

	Future<List<DocIdentifier>> deleteClassifications(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.classificationBasic.deleteClassifications(
			_sdkId,
			entityIds,
		);
	}

	Future<EncryptedClassification> modifyClassification(EncryptedClassification entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.classificationBasic.modifyClassification(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedClassification> getClassification(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.classificationBasic.getClassification(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedClassification>> getClassifications(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.classificationBasic.getClassifications(
			_sdkId,
			entityIds,
		);
	}
}