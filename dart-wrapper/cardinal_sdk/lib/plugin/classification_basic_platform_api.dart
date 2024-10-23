// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/classification.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class ClassificationBasicPlatformApi {
	MethodChannel _methodChannel;
	ClassificationBasicPlatformApi(this._methodChannel);

	Future<List<String>> matchClassificationsBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationBasicApi.matchClassificationsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchClassificationsBy");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<List<String>> matchClassificationsBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationBasicApi.matchClassificationsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchClassificationsBySorted");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<PaginatedListIterator<EncryptedClassification>> filterClassificationsBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationBasicApi.filterClassificationsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterClassificationsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedClassification.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedClassification>> filterClassificationsBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationBasicApi.filterClassificationsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterClassificationsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedClassification.fromJSON(x0));
	}

	Future<DocIdentifier> deleteClassification(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationBasicApi.deleteClassification',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteClassification");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteClassifications(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationBasicApi.deleteClassifications',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteClassifications");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<EncryptedClassification> modifyClassification(String sdkId, EncryptedClassification entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationBasicApi.modifyClassification',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedClassification.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyClassification");
		final parsedResJson = jsonDecode(res);
		return EncryptedClassification.fromJSON(parsedResJson);
	}

	Future<EncryptedClassification> getClassification(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationBasicApi.getClassification',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getClassification");
		final parsedResJson = jsonDecode(res);
		return EncryptedClassification.fromJSON(parsedResJson);
	}

	Future<List<EncryptedClassification>> getClassifications(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ClassificationBasicApi.getClassifications',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getClassifications");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedClassification.fromJSON(x1) );
	}
}