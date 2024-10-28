// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/form.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/model/form_template.dart';
import 'dart:typed_data';


class FormBasicPlatformApi {
	MethodChannel _methodChannel;
	FormBasicPlatformApi(this._methodChannel);

	Future<List<String>> matchFormsBy(String sdkId, BaseFilterOptions<Form> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.matchFormsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchFormsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchFormsBySorted(String sdkId, BaseSortableFilterOptions<Form> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.matchFormsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchFormsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<EncryptedForm>> filterFormsBy(String sdkId, BaseFilterOptions<Form> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.filterFormsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterFormsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedForm.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedForm>> filterFormsBySorted(String sdkId, BaseSortableFilterOptions<Form> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.filterFormsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterFormsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedForm.fromJSON(x0));
	}

	Future<DocIdentifier> deleteFormById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.deleteFormById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteFormById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteFormsByIds(String sdkId, List<IdWithMandatoryRev> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.deleteFormsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => IdWithMandatoryRev.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteFormsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeFormById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.purgeFormById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<DocIdentifier> deleteForm(String sdkId, Form form) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.deleteForm',
			{
				"sdkId": sdkId,
				"form": jsonEncode(Form.encode(form)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteForm");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteForms(String sdkId, List<Form> forms) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.deleteForms',
			{
				"sdkId": sdkId,
				"forms": jsonEncode(forms.map((x0) => Form.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteForms");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeForm(String sdkId, Form form) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.purgeForm',
			{
				"sdkId": sdkId,
				"form": jsonEncode(Form.encode(form)),
			}
		);
	}

	Future<FormTemplate> getFormTemplate(String sdkId, String formTemplateId, bool? raw) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.getFormTemplate',
			{
				"sdkId": sdkId,
				"formTemplateId": jsonEncode(formTemplateId),
				"raw": jsonEncode(raw),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getFormTemplate");
		final parsedResJson = jsonDecode(res);
		return FormTemplate.fromJSON(parsedResJson);
	}

	Future<FormTemplate> createFormTemplate(String sdkId, FormTemplate formTemplate) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.createFormTemplate',
			{
				"sdkId": sdkId,
				"formTemplate": jsonEncode(FormTemplate.encode(formTemplate)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createFormTemplate");
		final parsedResJson = jsonDecode(res);
		return FormTemplate.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deleteFormTemplate(String sdkId, String formTemplateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.deleteFormTemplate',
			{
				"sdkId": sdkId,
				"formTemplateId": jsonEncode(formTemplateId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteFormTemplate");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<FormTemplate> updateFormTemplate(String sdkId, FormTemplate formTemplate) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.updateFormTemplate',
			{
				"sdkId": sdkId,
				"formTemplate": jsonEncode(FormTemplate.encode(formTemplate)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method updateFormTemplate");
		final parsedResJson = jsonDecode(res);
		return FormTemplate.fromJSON(parsedResJson);
	}

	Future<String> setTemplateAttachment(String sdkId, String formTemplateId, Uint8List payload) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.setTemplateAttachment',
			{
				"sdkId": sdkId,
				"formTemplateId": jsonEncode(formTemplateId),
				"payload": jsonEncode(base64Encode(payload as List<int>)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method setTemplateAttachment");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as String);
	}

	Future<EncryptedForm> modifyForm(String sdkId, EncryptedForm entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.modifyForm',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedForm.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyForm");
		final parsedResJson = jsonDecode(res);
		return EncryptedForm.fromJSON(parsedResJson);
	}

	Future<EncryptedForm> undeleteFormById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.undeleteFormById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteFormById");
		final parsedResJson = jsonDecode(res);
		return EncryptedForm.fromJSON(parsedResJson);
	}

	Future<EncryptedForm> undeleteForm(String sdkId, Form form) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.undeleteForm',
			{
				"sdkId": sdkId,
				"form": jsonEncode(Form.encode(form)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteForm");
		final parsedResJson = jsonDecode(res);
		return EncryptedForm.fromJSON(parsedResJson);
	}

	Future<List<EncryptedForm>> modifyForms(String sdkId, List<EncryptedForm> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.modifyForms',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedForm.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyForms");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedForm.fromJSON(x1) ).toList();
	}

	Future<EncryptedForm> getForm(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.getForm',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getForm");
		final parsedResJson = jsonDecode(res);
		return EncryptedForm.fromJSON(parsedResJson);
	}

	Future<List<EncryptedForm>> getForms(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.getForms',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getForms");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedForm.fromJSON(x1) ).toList();
	}

	Future<EncryptedForm> getLatestFormByLogicalUuid(String sdkId, String logicalUuid) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.getLatestFormByLogicalUuid',
			{
				"sdkId": sdkId,
				"logicalUuid": jsonEncode(logicalUuid),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getLatestFormByLogicalUuid");
		final parsedResJson = jsonDecode(res);
		return EncryptedForm.fromJSON(parsedResJson);
	}

	Future<EncryptedForm> getLatestFormByUniqueId(String sdkId, String uniqueId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormBasicApi.getLatestFormByUniqueId',
			{
				"sdkId": sdkId,
				"uniqueId": jsonEncode(uniqueId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getLatestFormByUniqueId");
		final parsedResJson = jsonDecode(res);
		return EncryptedForm.fromJSON(parsedResJson);
	}
}