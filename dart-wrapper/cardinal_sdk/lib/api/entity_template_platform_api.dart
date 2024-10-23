// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/entity_template.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class EntityTemplatePlatformApi {
	String _sdkId;
	EntityTemplatePlatformApi(this._sdkId);

	Future<EntityTemplate> getEntityTemplate(String documentTemplateId) async {
		return await CardinalSdkPlatformInterface.instance.entityTemplate.getEntityTemplate(
			_sdkId,
			documentTemplateId,
		);
	}

	Future<EntityTemplate> createEntityTemplate(EntityTemplate applicationSettings) async {
		return await CardinalSdkPlatformInterface.instance.entityTemplate.createEntityTemplate(
			_sdkId,
			applicationSettings,
		);
	}

	Future<EntityTemplate> modifyEntityTemplate(EntityTemplate documentTemplate) async {
		return await CardinalSdkPlatformInterface.instance.entityTemplate.modifyEntityTemplate(
			_sdkId,
			documentTemplate,
		);
	}

	Future<List<EntityTemplate>> listEntityTemplatesBy(String userId, String type, String? searchString, bool? includeEntities) async {
		return await CardinalSdkPlatformInterface.instance.entityTemplate.listEntityTemplatesBy(
			_sdkId,
			userId,
			type,
			searchString,
			includeEntities,
		);
	}

	Future<List<EntityTemplate>> listAllEntityTemplatesBy(String type, String? searchString, bool? includeEntities) async {
		return await CardinalSdkPlatformInterface.instance.entityTemplate.listAllEntityTemplatesBy(
			_sdkId,
			type,
			searchString,
			includeEntities,
		);
	}

	Future<List<EntityTemplate>> listEntityTemplatesByKeyword(String userId, String type, String keyword, bool? includeEntities) async {
		return await CardinalSdkPlatformInterface.instance.entityTemplate.listEntityTemplatesByKeyword(
			_sdkId,
			userId,
			type,
			keyword,
			includeEntities,
		);
	}

	Future<List<EntityTemplate>> findAllEntityTemplatesByKeyword(String type, String keyword, bool? includeEntities) async {
		return await CardinalSdkPlatformInterface.instance.entityTemplate.findAllEntityTemplatesByKeyword(
			_sdkId,
			type,
			keyword,
			includeEntities,
		);
	}

	Future<List<EntityTemplate>> getEntityTemplates(List<String> entityTemplateIds) async {
		return await CardinalSdkPlatformInterface.instance.entityTemplate.getEntityTemplates(
			_sdkId,
			entityTemplateIds,
		);
	}

	Future<List<EntityTemplate>> modifyEntityTemplates(List<EntityTemplate> entityTemplates) async {
		return await CardinalSdkPlatformInterface.instance.entityTemplate.modifyEntityTemplates(
			_sdkId,
			entityTemplates,
		);
	}

	Future<List<EntityTemplate>> createEntityTemplates(List<EntityTemplate> entityTemplates) async {
		return await CardinalSdkPlatformInterface.instance.entityTemplate.createEntityTemplates(
			_sdkId,
			entityTemplates,
		);
	}

	Future<List<DocIdentifier>> deleteEntityTemplates(List<IdWithMandatoryRev> entityTemplateIds) async {
		return await CardinalSdkPlatformInterface.instance.entityTemplate.deleteEntityTemplates(
			_sdkId,
			entityTemplateIds,
		);
	}
}