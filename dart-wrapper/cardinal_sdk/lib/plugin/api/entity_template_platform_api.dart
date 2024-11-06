// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/entity_template.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class EntityTemplatePlatformApi {
	MethodChannel _methodChannel;
	EntityTemplatePlatformApi(this._methodChannel);

	Future<EntityTemplate> getEntityTemplate(String sdkId, String documentTemplateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'EntityTemplateApi.getEntityTemplate',
			{
				"sdkId": sdkId,
				"documentTemplateId": jsonEncode(documentTemplateId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getEntityTemplate");
		final parsedResJson = jsonDecode(res);
		return EntityTemplate.fromJSON(parsedResJson);
	}

	Future<EntityTemplate> createEntityTemplate(String sdkId, EntityTemplate applicationSettings) async {
		final res = await _methodChannel.invokeMethod<String>(
			'EntityTemplateApi.createEntityTemplate',
			{
				"sdkId": sdkId,
				"applicationSettings": jsonEncode(EntityTemplate.encode(applicationSettings)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createEntityTemplate");
		final parsedResJson = jsonDecode(res);
		return EntityTemplate.fromJSON(parsedResJson);
	}

	Future<EntityTemplate> modifyEntityTemplate(String sdkId, EntityTemplate documentTemplate) async {
		final res = await _methodChannel.invokeMethod<String>(
			'EntityTemplateApi.modifyEntityTemplate',
			{
				"sdkId": sdkId,
				"documentTemplate": jsonEncode(EntityTemplate.encode(documentTemplate)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyEntityTemplate");
		final parsedResJson = jsonDecode(res);
		return EntityTemplate.fromJSON(parsedResJson);
	}

	Future<List<EntityTemplate>> listEntityTemplatesBy(String sdkId, String userId, String type, String? searchString, bool? includeEntities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'EntityTemplateApi.listEntityTemplatesBy',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"type": jsonEncode(type),
				"searchString": jsonEncode(searchString),
				"includeEntities": jsonEncode(includeEntities),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listEntityTemplatesBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EntityTemplate.fromJSON(x1) ).toList();
	}

	Future<List<EntityTemplate>> listAllEntityTemplatesBy(String sdkId, String type, String? searchString, bool? includeEntities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'EntityTemplateApi.listAllEntityTemplatesBy',
			{
				"sdkId": sdkId,
				"type": jsonEncode(type),
				"searchString": jsonEncode(searchString),
				"includeEntities": jsonEncode(includeEntities),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listAllEntityTemplatesBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EntityTemplate.fromJSON(x1) ).toList();
	}

	Future<List<EntityTemplate>> listEntityTemplatesByKeyword(String sdkId, String userId, String type, String keyword, bool? includeEntities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'EntityTemplateApi.listEntityTemplatesByKeyword',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"type": jsonEncode(type),
				"keyword": jsonEncode(keyword),
				"includeEntities": jsonEncode(includeEntities),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listEntityTemplatesByKeyword");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EntityTemplate.fromJSON(x1) ).toList();
	}

	Future<List<EntityTemplate>> findAllEntityTemplatesByKeyword(String sdkId, String type, String keyword, bool? includeEntities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'EntityTemplateApi.findAllEntityTemplatesByKeyword',
			{
				"sdkId": sdkId,
				"type": jsonEncode(type),
				"keyword": jsonEncode(keyword),
				"includeEntities": jsonEncode(includeEntities),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method findAllEntityTemplatesByKeyword");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EntityTemplate.fromJSON(x1) ).toList();
	}

	Future<List<EntityTemplate>> getEntityTemplates(String sdkId, List<String> entityTemplateIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'EntityTemplateApi.getEntityTemplates',
			{
				"sdkId": sdkId,
				"entityTemplateIds": jsonEncode(entityTemplateIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getEntityTemplates");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EntityTemplate.fromJSON(x1) ).toList();
	}

	Future<List<EntityTemplate>> modifyEntityTemplates(String sdkId, List<EntityTemplate> entityTemplates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'EntityTemplateApi.modifyEntityTemplates',
			{
				"sdkId": sdkId,
				"entityTemplates": jsonEncode(entityTemplates.map((x0) => EntityTemplate.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyEntityTemplates");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EntityTemplate.fromJSON(x1) ).toList();
	}

	Future<List<EntityTemplate>> createEntityTemplates(String sdkId, List<EntityTemplate> entityTemplates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'EntityTemplateApi.createEntityTemplates',
			{
				"sdkId": sdkId,
				"entityTemplates": jsonEncode(entityTemplates.map((x0) => EntityTemplate.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createEntityTemplates");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EntityTemplate.fromJSON(x1) ).toList();
	}

	Future<List<DocIdentifier>> deleteEntityTemplates(String sdkId, List<IdWithMandatoryRev> entityTemplateIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'EntityTemplateApi.deleteEntityTemplates',
			{
				"sdkId": sdkId,
				"entityTemplateIds": jsonEncode(entityTemplateIds.map((x0) => IdWithMandatoryRev.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteEntityTemplates");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}
}