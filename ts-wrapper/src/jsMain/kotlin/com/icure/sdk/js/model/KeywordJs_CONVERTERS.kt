package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.js.model.embed.KeywordSubwordJs
import com.icure.sdk.js.model.embed.keywordSubword_fromJs
import com.icure.sdk.js.model.embed.keywordSubword_toJs
import com.icure.sdk.model.Keyword
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.KeywordSubword
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun keyword_toJs(obj: Keyword): KeywordJs {
	val id = obj.id
	val rev = obj.rev ?: undefined
	val created = longToNumber(obj.created) ?: undefined
	val modified = longToNumber(obj.modified) ?: undefined
	val author = obj.author ?: undefined
	val responsible = obj.responsible ?: undefined
	val medicalLocationId = obj.medicalLocationId ?: undefined
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
	val endOfLife = longToNumber(obj.endOfLife) ?: undefined
	val deletionDate = longToNumber(obj.deletionDate) ?: undefined
	val value = obj.value ?: undefined
	val subWords = setToArray(
		obj.subWords,
		{ x1: KeywordSubword ->
			keywordSubword_toJs(x1)
		},
	)
	val userId = obj.userId ?: undefined
	return KeywordJs(js("{" +
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
		"value:value," +
		"subWords:subWords," +
		"userId:userId" +
	"}"))
}

public fun keyword_fromJs(obj: KeywordJs): Keyword {
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
	val value = obj.value
	val subWords = arrayToSet(
		obj.subWords,
		"obj.subWords",
		{ x1: KeywordSubwordJs ->
			keywordSubword_fromJs(x1)
		},
	)
	val userId = obj.userId
	return Keyword(
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
		value = value,
		subWords = subWords,
		userId = userId,
	)
}
