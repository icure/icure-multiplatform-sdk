// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/form.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/model/form_template.dart';
import 'dart:typed_data';


class FormBasicPlatformApi {
	String _sdkId;
	FormBasicPlatformApi(this._sdkId);

	Future<List<String>> matchFormsBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.matchFormsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchFormsBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.matchFormsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedForm>> filterFormsBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.filterFormsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedForm>> filterFormsBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.filterFormsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteFormById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.deleteFormById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteFormsByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.deleteFormsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeFormById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.purgeFormById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteForm(Form form) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.deleteForm(
			_sdkId,
			form,
		);
	}

	Future<List<DocIdentifier>> deleteForms(List<Form> forms) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.deleteForms(
			_sdkId,
			forms,
		);
	}

	Future<void> purgeForm(Form form) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.purgeForm(
			_sdkId,
			form,
		);
	}

	Future<FormTemplate> getFormTemplate(String formTemplateId, bool? raw) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.getFormTemplate(
			_sdkId,
			formTemplateId,
			raw,
		);
	}

	Future<FormTemplate> createFormTemplate(FormTemplate formTemplate) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.createFormTemplate(
			_sdkId,
			formTemplate,
		);
	}

	Future<DocIdentifier> deleteFormTemplate(String formTemplateId) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.deleteFormTemplate(
			_sdkId,
			formTemplateId,
		);
	}

	Future<FormTemplate> updateFormTemplate(FormTemplate formTemplate) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.updateFormTemplate(
			_sdkId,
			formTemplate,
		);
	}

	Future<String> setTemplateAttachment(String formTemplateId, Uint8List payload) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.setTemplateAttachment(
			_sdkId,
			formTemplateId,
			payload,
		);
	}

	Future<EncryptedForm> modifyForm(EncryptedForm entity) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.modifyForm(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedForm> undeleteFormById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.undeleteFormById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedForm> undeleteForm(Form form) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.undeleteForm(
			_sdkId,
			form,
		);
	}

	Future<List<EncryptedForm>> modifyForms(List<EncryptedForm> entities) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.modifyForms(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedForm> getForm(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.getForm(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedForm>> getForms(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.getForms(
			_sdkId,
			entityIds,
		);
	}

	Future<EncryptedForm> getLatestFormByLogicalUuid(String logicalUuid) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.getLatestFormByLogicalUuid(
			_sdkId,
			logicalUuid,
		);
	}

	Future<EncryptedForm> getLatestFormByUniqueId(String uniqueId) async {
		return await CardinalSdkPlatformInterface.instance.formBasic.getLatestFormByUniqueId(
			_sdkId,
			uniqueId,
		);
	}
}