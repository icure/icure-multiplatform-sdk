// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/form.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/model/form_template.dart';
import 'dart:typed_data';


class FormBasicApi {
	final String _sdkId;
	final Object _dartSdk;
	FormBasicApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<String>> matchFormsBy(BaseFilterOptions<Form> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.matchFormsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchFormsBySorted(BaseSortableFilterOptions<Form> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.matchFormsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedForm>> filterFormsBy(BaseFilterOptions<Form> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.filterFormsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedForm>> filterFormsBySorted(BaseSortableFilterOptions<Form> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.filterFormsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteFormById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.deleteFormById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteFormsByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.deleteFormsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeFormById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.purgeFormById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteForm(Form form) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.deleteForm(
			_sdkId,
			form,
		);
	}

	Future<List<DocIdentifier>> deleteForms(List<Form> forms) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.deleteForms(
			_sdkId,
			forms,
		);
	}

	Future<void> purgeForm(Form form) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.purgeForm(
			_sdkId,
			form,
		);
	}

	Future<FormTemplate> getFormTemplate(String formTemplateId, { bool? raw }) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.getFormTemplate(
			_sdkId,
			formTemplateId,
			raw,
		);
	}

	Future<FormTemplate> createFormTemplate(FormTemplate formTemplate) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.createFormTemplate(
			_sdkId,
			formTemplate,
		);
	}

	Future<DocIdentifier> deleteFormTemplate(String formTemplateId) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.deleteFormTemplate(
			_sdkId,
			formTemplateId,
		);
	}

	Future<FormTemplate> updateFormTemplate(FormTemplate formTemplate) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.updateFormTemplate(
			_sdkId,
			formTemplate,
		);
	}

	Future<String> setTemplateAttachment(String formTemplateId, Uint8List payload) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.setTemplateAttachment(
			_sdkId,
			formTemplateId,
			payload,
		);
	}

	Future<EncryptedForm> createForm(EncryptedForm entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.createForm(
			_sdkId,
			entity,
		);
	}

	Future<List<EncryptedForm>> createForms(List<EncryptedForm> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.createForms(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedForm> modifyForm(EncryptedForm entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.modifyForm(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedForm> undeleteFormById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.undeleteFormById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedForm> undeleteForm(Form form) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.undeleteForm(
			_sdkId,
			form,
		);
	}

	Future<List<EncryptedForm>> modifyForms(List<EncryptedForm> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.modifyForms(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedForm?> getForm(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.getForm(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedForm>> getForms(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.getForms(
			_sdkId,
			entityIds,
		);
	}

	Future<EncryptedForm> getLatestFormByLogicalUuid(String logicalUuid) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.getLatestFormByLogicalUuid(
			_sdkId,
			logicalUuid,
		);
	}

	Future<EncryptedForm> getLatestFormByUniqueId(String uniqueId) async {
		return await CardinalSdkPlatformInterface.instance.apis.formBasic.getLatestFormByUniqueId(
			_sdkId,
			uniqueId,
		);
	}
}