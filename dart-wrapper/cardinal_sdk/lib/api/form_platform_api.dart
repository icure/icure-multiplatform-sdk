// auto-generated file
import 'package:cardinal_sdk/model/form.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/model/form_template.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/crypto/entities/form_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class FormPlatformApi {
	String _sdkId;
	TryAndRecoverFormPlatformApi tryAndRecover;
	EncryptedFormPlatformApi encrypted;
	FormPlatformApi(
		this._sdkId
		) : tryAndRecover = TryAndRecoverFormPlatformApi(_sdkId),
		encrypted = EncryptedFormPlatformApi(_sdkId);

	Future<DecryptedForm> createForm(DecryptedForm entity) async {
		return await CardinalSdkPlatformInterface.instance.form.createForm(
			_sdkId,
			entity,
		);
	}

	Future<List<DecryptedForm>> createForms(List<DecryptedForm> entities) async {
		return await CardinalSdkPlatformInterface.instance.form.createForms(
			_sdkId,
			entities,
		);
	}

	Future<DecryptedForm> withEncryptionMetadata(DecryptedForm? base, Patient patient, User? user, { Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent }) async {
		return await CardinalSdkPlatformInterface.instance.form.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(Form form) async {
		return await CardinalSdkPlatformInterface.instance.form.getEncryptionKeysOf(
			_sdkId,
			form,
		);
	}

	Future<bool> hasWriteAccess(Form form) async {
		return await CardinalSdkPlatformInterface.instance.form.hasWriteAccess(
			_sdkId,
			form,
		);
	}

	Future<Set<String>> decryptPatientIdOf(Form form) async {
		return await CardinalSdkPlatformInterface.instance.form.decryptPatientIdOf(
			_sdkId,
			form,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(Form entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.form.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedForm> decrypt(EncryptedForm form) async {
		return await CardinalSdkPlatformInterface.instance.form.decrypt(
			_sdkId,
			form,
		);
	}

	Future<Form> tryDecrypt(EncryptedForm form) async {
		return await CardinalSdkPlatformInterface.instance.form.tryDecrypt(
			_sdkId,
			form,
		);
	}

	Future<List<String>> matchFormsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.form.matchFormsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchFormsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.form.matchFormsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteFormById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.form.deleteFormById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteFormsByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.form.deleteFormsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeFormById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.form.purgeFormById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteForm(Form form) async {
		return await CardinalSdkPlatformInterface.instance.form.deleteForm(
			_sdkId,
			form,
		);
	}

	Future<List<DocIdentifier>> deleteForms(List<Form> forms) async {
		return await CardinalSdkPlatformInterface.instance.form.deleteForms(
			_sdkId,
			forms,
		);
	}

	Future<void> purgeForm(Form form) async {
		return await CardinalSdkPlatformInterface.instance.form.purgeForm(
			_sdkId,
			form,
		);
	}

	Future<FormTemplate> getFormTemplate(String formTemplateId, bool? raw) async {
		return await CardinalSdkPlatformInterface.instance.form.getFormTemplate(
			_sdkId,
			formTemplateId,
			raw,
		);
	}

	Future<FormTemplate> createFormTemplate(FormTemplate formTemplate) async {
		return await CardinalSdkPlatformInterface.instance.form.createFormTemplate(
			_sdkId,
			formTemplate,
		);
	}

	Future<DocIdentifier> deleteFormTemplate(String formTemplateId) async {
		return await CardinalSdkPlatformInterface.instance.form.deleteFormTemplate(
			_sdkId,
			formTemplateId,
		);
	}

	Future<FormTemplate> updateFormTemplate(FormTemplate formTemplate) async {
		return await CardinalSdkPlatformInterface.instance.form.updateFormTemplate(
			_sdkId,
			formTemplate,
		);
	}

	Future<String> setTemplateAttachment(String formTemplateId, Uint8List payload) async {
		return await CardinalSdkPlatformInterface.instance.form.setTemplateAttachment(
			_sdkId,
			formTemplateId,
			payload,
		);
	}

	Future<DecryptedForm> shareWith(String delegateId, DecryptedForm form, FormShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.form.shareWith(
			_sdkId,
			delegateId,
			form,
			options,
		);
	}

	Future<DecryptedForm> shareWithMany(DecryptedForm form, Map<String, FormShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.form.shareWithMany(
			_sdkId,
			form,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedForm>> filterFormsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.form.filterFormsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedForm>> filterFormsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.form.filterFormsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedForm> modifyForm(DecryptedForm entity) async {
		return await CardinalSdkPlatformInterface.instance.form.modifyForm(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedForm> undeleteFormById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.form.undeleteFormById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedForm> undeleteForm(Form form) async {
		return await CardinalSdkPlatformInterface.instance.form.undeleteForm(
			_sdkId,
			form,
		);
	}

	Future<List<DecryptedForm>> modifyForms(List<DecryptedForm> entities) async {
		return await CardinalSdkPlatformInterface.instance.form.modifyForms(
			_sdkId,
			entities,
		);
	}

	Future<DecryptedForm> getForm(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.form.getForm(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedForm>> getForms(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.form.getForms(
			_sdkId,
			entityIds,
		);
	}

	Future<DecryptedForm> getLatestFormByLogicalUuid(String logicalUuid) async {
		return await CardinalSdkPlatformInterface.instance.form.getLatestFormByLogicalUuid(
			_sdkId,
			logicalUuid,
		);
	}

	Future<DecryptedForm> getLatestFormByUniqueId(String uniqueId) async {
		return await CardinalSdkPlatformInterface.instance.form.getLatestFormByUniqueId(
			_sdkId,
			uniqueId,
		);
	}
}

class TryAndRecoverFormPlatformApi {
	String _sdkId;
	TryAndRecoverFormPlatformApi(this._sdkId);

	Future<Form> shareWith(String delegateId, Form form, FormShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.form.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			form,
			options,
		);
	}

	Future<Form> shareWithMany(Form form, Map<String, FormShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.form.tryAndRecover.shareWithMany(
			_sdkId,
			form,
			delegates,
		);
	}

	Future<PaginatedListIterator<Form>> filterFormsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.form.tryAndRecover.filterFormsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Form>> filterFormsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.form.tryAndRecover.filterFormsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Form> modifyForm(Form entity) async {
		return await CardinalSdkPlatformInterface.instance.form.tryAndRecover.modifyForm(
			_sdkId,
			entity,
		);
	}

	Future<Form> undeleteFormById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.form.tryAndRecover.undeleteFormById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<Form> undeleteForm(Form form) async {
		return await CardinalSdkPlatformInterface.instance.form.tryAndRecover.undeleteForm(
			_sdkId,
			form,
		);
	}

	Future<List<Form>> modifyForms(List<Form> entities) async {
		return await CardinalSdkPlatformInterface.instance.form.tryAndRecover.modifyForms(
			_sdkId,
			entities,
		);
	}

	Future<Form> getForm(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.form.tryAndRecover.getForm(
			_sdkId,
			entityId,
		);
	}

	Future<List<Form>> getForms(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.form.tryAndRecover.getForms(
			_sdkId,
			entityIds,
		);
	}

	Future<Form> getLatestFormByLogicalUuid(String logicalUuid) async {
		return await CardinalSdkPlatformInterface.instance.form.tryAndRecover.getLatestFormByLogicalUuid(
			_sdkId,
			logicalUuid,
		);
	}

	Future<Form> getLatestFormByUniqueId(String uniqueId) async {
		return await CardinalSdkPlatformInterface.instance.form.tryAndRecover.getLatestFormByUniqueId(
			_sdkId,
			uniqueId,
		);
	}
}

class EncryptedFormPlatformApi {
	String _sdkId;
	EncryptedFormPlatformApi(this._sdkId);

	Future<EncryptedForm> shareWith(String delegateId, EncryptedForm form, FormShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.form.encrypted.shareWith(
			_sdkId,
			delegateId,
			form,
			options,
		);
	}

	Future<EncryptedForm> shareWithMany(EncryptedForm form, Map<String, FormShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.form.encrypted.shareWithMany(
			_sdkId,
			form,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedForm>> filterFormsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.form.encrypted.filterFormsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedForm>> filterFormsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.form.encrypted.filterFormsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedForm> modifyForm(EncryptedForm entity) async {
		return await CardinalSdkPlatformInterface.instance.form.encrypted.modifyForm(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedForm> undeleteFormById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.form.encrypted.undeleteFormById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedForm> undeleteForm(Form form) async {
		return await CardinalSdkPlatformInterface.instance.form.encrypted.undeleteForm(
			_sdkId,
			form,
		);
	}

	Future<List<EncryptedForm>> modifyForms(List<EncryptedForm> entities) async {
		return await CardinalSdkPlatformInterface.instance.form.encrypted.modifyForms(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedForm> getForm(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.form.encrypted.getForm(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedForm>> getForms(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.form.encrypted.getForms(
			_sdkId,
			entityIds,
		);
	}

	Future<EncryptedForm> getLatestFormByLogicalUuid(String logicalUuid) async {
		return await CardinalSdkPlatformInterface.instance.form.encrypted.getLatestFormByLogicalUuid(
			_sdkId,
			logicalUuid,
		);
	}

	Future<EncryptedForm> getLatestFormByUniqueId(String uniqueId) async {
		return await CardinalSdkPlatformInterface.instance.form.encrypted.getLatestFormByUniqueId(
			_sdkId,
			uniqueId,
		);
	}
}