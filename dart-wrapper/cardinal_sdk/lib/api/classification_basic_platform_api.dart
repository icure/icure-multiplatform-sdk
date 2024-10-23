// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/classification.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class ClassificationBasicPlatformApi {
	String _sdkId;
	ClassificationBasicPlatformApi(this._sdkId);

	Future<List<String>> matchClassificationsBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.classificationBasic.matchClassificationsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchClassificationsBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.classificationBasic.matchClassificationsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedClassification>> filterClassificationsBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.classificationBasic.filterClassificationsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedClassification>> filterClassificationsBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.classificationBasic.filterClassificationsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteClassification(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.classificationBasic.deleteClassification(
			_sdkId,
			entityId,
		);
	}

	Future<List<DocIdentifier>> deleteClassifications(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.classificationBasic.deleteClassifications(
			_sdkId,
			entityIds,
		);
	}

	Future<EncryptedClassification> modifyClassification(EncryptedClassification entity) async {
		return await CardinalSdkPlatformInterface.instance.classificationBasic.modifyClassification(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedClassification> getClassification(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.classificationBasic.getClassification(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedClassification>> getClassifications(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.classificationBasic.getClassifications(
			_sdkId,
			entityIds,
		);
	}
}