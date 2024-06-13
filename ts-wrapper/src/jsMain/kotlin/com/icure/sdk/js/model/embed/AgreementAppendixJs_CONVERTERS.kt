package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.model.embed.AgreementAppendix
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun agreementAppendix_toJs(obj: AgreementAppendix): AgreementAppendixJs {
	val docSeq = intToNumber(obj.docSeq)
	val verseSeq = intToNumber(obj.verseSeq)
	val documentId = obj.documentId
	val path = obj.path
	return AgreementAppendixJs(js("{" +
		"docSeq:docSeq," +
		"verseSeq:verseSeq," +
		"documentId:documentId," +
		"path:path" +
	"}"))
}

public fun agreementAppendix_fromJs(obj: AgreementAppendixJs): AgreementAppendix {
	val docSeq = numberToInt(obj.docSeq, "obj.docSeq")
	val verseSeq = numberToInt(obj.verseSeq, "obj.verseSeq")
	val documentId = obj.documentId
	val path = obj.path
	return AgreementAppendix(
		docSeq = docSeq,
		verseSeq = verseSeq,
		documentId = documentId,
		path = path,
	)
}
