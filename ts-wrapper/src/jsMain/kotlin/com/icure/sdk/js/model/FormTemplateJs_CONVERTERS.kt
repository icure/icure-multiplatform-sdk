package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.setToArray
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
	val rev = obj.rev
	val deletionDate = longToNumber(obj.deletionDate)
	val templateLayout = obj.templateLayout?.let { nonNull1 ->
		formTemplateLayout_toJs(nonNull1)
	}
	val rawTemplateLayout = obj.rawTemplateLayout
	val name = obj.name
	val guid = obj.guid
	val group = obj.group?.let { nonNull1 ->
		documentGroup_toJs(nonNull1)
	}
	val descr = obj.descr
	val disabled = obj.disabled
	val specialty = obj.specialty?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val author = obj.author
	val formInstancePreferredLocation = obj.formInstancePreferredLocation
	val keyboardShortcut = obj.keyboardShortcut
	val shortReport = obj.shortReport
	val mediumReport = obj.mediumReport
	val longReport = obj.longReport
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
	val layoutAttachmentId = obj.layoutAttachmentId
	val templateLayoutAttachmentId = obj.templateLayoutAttachmentId
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
	val rev = obj.rev
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val templateLayout = obj.templateLayout?.let { nonNull1 ->
		formTemplateLayout_fromJs(nonNull1)
	}
	val rawTemplateLayout = obj.rawTemplateLayout
	val name = obj.name
	val guid = obj.guid
	val group = obj.group?.let { nonNull1 ->
		documentGroup_fromJs(nonNull1)
	}
	val descr = obj.descr
	val disabled = obj.disabled
	val specialty = obj.specialty?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val author = obj.author
	val formInstancePreferredLocation = obj.formInstancePreferredLocation
	val keyboardShortcut = obj.keyboardShortcut
	val shortReport = obj.shortReport
	val mediumReport = obj.mediumReport
	val longReport = obj.longReport
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
	val layoutAttachmentId = obj.layoutAttachmentId
	val templateLayoutAttachmentId = obj.templateLayoutAttachmentId
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
