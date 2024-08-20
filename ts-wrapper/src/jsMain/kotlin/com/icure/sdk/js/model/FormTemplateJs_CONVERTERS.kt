// auto-generated file
package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.js.model.embed.documentGroup_fromJs
import com.icure.sdk.js.model.embed.documentGroup_toJs
import com.icure.sdk.js.model.embed.form.template.formTemplateLayout_fromJs
import com.icure.sdk.js.model.embed.form.template.formTemplateLayout_toJs
import com.icure.sdk.model.FormTemplate
import com.icure.sdk.model.base.CodeStub
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun formTemplate_toJs(obj: FormTemplate): FormTemplateJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val templateLayout = nullToUndefined(
		obj.templateLayout?.let { nonNull1 ->
			formTemplateLayout_toJs(nonNull1)
		}
	)
	val rawTemplateLayout = nullToUndefined(
		obj.rawTemplateLayout
	)
	val name = nullToUndefined(
		obj.name
	)
	val guid = nullToUndefined(
		obj.guid
	)
	val group = nullToUndefined(
		obj.group?.let { nonNull1 ->
			documentGroup_toJs(nonNull1)
		}
	)
	val descr = nullToUndefined(
		obj.descr
	)
	val disabled = nullToUndefined(
		obj.disabled
	)
	val specialty = nullToUndefined(
		obj.specialty?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	val author = nullToUndefined(
		obj.author
	)
	val formInstancePreferredLocation = nullToUndefined(
		obj.formInstancePreferredLocation
	)
	val keyboardShortcut = nullToUndefined(
		obj.keyboardShortcut
	)
	val shortReport = nullToUndefined(
		obj.shortReport
	)
	val mediumReport = nullToUndefined(
		obj.mediumReport
	)
	val longReport = nullToUndefined(
		obj.longReport
	)
	val reports = setToArray(
		obj.reports,
		{ x1: String ->
			x1
		},
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val layoutAttachmentId = nullToUndefined(
		obj.layoutAttachmentId
	)
	val templateLayoutAttachmentId = nullToUndefined(
		obj.templateLayoutAttachmentId
	)
	return FormTemplateJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"templateLayout:templateLayout," +
		"rawTemplateLayout:rawTemplateLayout," +
		"name:name," +
		"guid:guid," +
		"group:group," +
		"descr:descr," +
		"disabled:disabled," +
		"specialty:specialty," +
		"author:author," +
		"formInstancePreferredLocation:formInstancePreferredLocation," +
		"keyboardShortcut:keyboardShortcut," +
		"shortReport:shortReport," +
		"mediumReport:mediumReport," +
		"longReport:longReport," +
		"reports:reports," +
		"tags:tags," +
		"layoutAttachmentId:layoutAttachmentId," +
		"templateLayoutAttachmentId:templateLayoutAttachmentId" +
	"}"))
}

public fun formTemplate_fromJs(obj: FormTemplateJs): FormTemplate {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val templateLayout = obj.templateLayout?.let { nonNull1 ->
		formTemplateLayout_fromJs(nonNull1)
	}
	val rawTemplateLayout = undefinedToNull(obj.rawTemplateLayout)
	val name = undefinedToNull(obj.name)
	val guid = undefinedToNull(obj.guid)
	val group = obj.group?.let { nonNull1 ->
		documentGroup_fromJs(nonNull1)
	}
	val descr = undefinedToNull(obj.descr)
	val disabled = undefinedToNull(obj.disabled)
	val specialty = obj.specialty?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val author = undefinedToNull(obj.author)
	val formInstancePreferredLocation = undefinedToNull(obj.formInstancePreferredLocation)
	val keyboardShortcut = undefinedToNull(obj.keyboardShortcut)
	val shortReport = undefinedToNull(obj.shortReport)
	val mediumReport = undefinedToNull(obj.mediumReport)
	val longReport = undefinedToNull(obj.longReport)
	val reports = arrayToSet(
		obj.reports,
		"obj.reports",
		{ x1: String ->
			x1
		},
	)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val layoutAttachmentId = undefinedToNull(obj.layoutAttachmentId)
	val templateLayoutAttachmentId = undefinedToNull(obj.templateLayoutAttachmentId)
	return FormTemplate(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		templateLayout = templateLayout,
		rawTemplateLayout = rawTemplateLayout,
		name = name,
		guid = guid,
		group = group,
		descr = descr,
		disabled = disabled,
		specialty = specialty,
		author = author,
		formInstancePreferredLocation = formInstancePreferredLocation,
		keyboardShortcut = keyboardShortcut,
		shortReport = shortReport,
		mediumReport = mediumReport,
		longReport = longReport,
		reports = reports,
		tags = tags,
		layoutAttachmentId = layoutAttachmentId,
		templateLayoutAttachmentId = templateLayoutAttachmentId,
	)
}
