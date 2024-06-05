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
import com.icure.sdk.model.DocumentTemplate
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.ReportVersion
import com.icure.sdk.model.embed.DocumentType
import kotlin.String

public fun documentTemplate_toJs(obj: DocumentTemplate): DocumentTemplateJs {
	val id = obj.id
	val rev = obj.rev
	val created = longToNumber(obj.created)
	val modified = longToNumber(obj.modified)
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val endOfLife = longToNumber(obj.endOfLife)
	val deletionDate = longToNumber(obj.deletionDate)
	val attachment = obj.attachment
	val documentType = obj.documentType?.let { nonNull1 ->
		obj.documentType?.name
	}
	val mainUti = obj.mainUti
	val name = obj.name
	val otherUtis = setToArray(
		obj.otherUtis,
		{ x1: String ->
			x1
		},
	)
	val attachmentId = obj.attachmentId
	val version = obj.version?.let { nonNull1 ->
		obj.version?.name
	}
	val owner = obj.owner
	val guid = obj.guid
	val group = obj.group?.let { nonNull1 ->
		documentGroup_toJs(nonNull1)
	}
	val descr = obj.descr
	val disabled = obj.disabled
	val specialty = obj.specialty?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	return DocumentTemplateJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"attachment:attachment," +
		"documentType:documentType," +
		"mainUti:mainUti," +
		"name:name," +
		"otherUtis:otherUtis," +
		"attachmentId:attachmentId," +
		"version:version," +
		"owner:owner," +
		"guid:guid," +
		"group:group," +
		"descr:descr," +
		"disabled:disabled," +
		"specialty:specialty" +
	"}"))
}

public fun documentTemplate_fromJs(obj: DocumentTemplateJs): DocumentTemplate {
	val id = obj.id
	val rev = obj.rev
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = obj.author
	val responsible = obj.responsible
	val medicalLocationId = obj.medicalLocationId
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val attachment = obj.attachment
	val documentType = obj.documentType?.let { nonNull1 ->
		DocumentType.valueOf(nonNull1)
	}
	val mainUti = obj.mainUti
	val name = obj.name
	val otherUtis = arrayToSet(
		obj.otherUtis,
		"obj.otherUtis",
		{ x1: String ->
			x1
		},
	)
	val attachmentId = obj.attachmentId
	val version = obj.version?.let { nonNull1 ->
		ReportVersion.valueOf(nonNull1)
	}
	val owner = obj.owner
	val guid = obj.guid
	val group = obj.group?.let { nonNull1 ->
		documentGroup_fromJs(nonNull1)
	}
	val descr = obj.descr
	val disabled = obj.disabled
	val specialty = obj.specialty?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	return DocumentTemplate(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		attachment = attachment,
		documentType = documentType,
		mainUti = mainUti,
		name = name,
		otherUtis = otherUtis,
		attachmentId = attachmentId,
		version = version,
		owner = owner,
		guid = guid,
		group = group,
		descr = descr,
		disabled = disabled,
		specialty = specialty,
	)
}
