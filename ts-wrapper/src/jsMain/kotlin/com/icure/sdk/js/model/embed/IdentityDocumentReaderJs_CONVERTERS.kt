package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.embed.IdentityDocumentReader
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun identityDocumentReader_toJs(obj: IdentityDocumentReader): IdentityDocumentReaderJs {
	val justificatifDocumentNumber = nullToUndefined(
		obj.justificatifDocumentNumber
	)
	val supportSerialNumber = nullToUndefined(
		obj.supportSerialNumber
	)
	val timeReadingEIdDocument = nullToUndefined(
		longToNumber(obj.timeReadingEIdDocument)
	)
	val eidDocumentSupportType = intToNumber(obj.eidDocumentSupportType)
	val reasonManualEncoding = intToNumber(obj.reasonManualEncoding)
	val reasonUsingVignette = intToNumber(obj.reasonUsingVignette)
	return IdentityDocumentReaderJs(js("{" +
		"justificatifDocumentNumber:justificatifDocumentNumber," +
		"supportSerialNumber:supportSerialNumber," +
		"timeReadingEIdDocument:timeReadingEIdDocument," +
		"eidDocumentSupportType:eidDocumentSupportType," +
		"reasonManualEncoding:reasonManualEncoding," +
		"reasonUsingVignette:reasonUsingVignette" +
	"}"))
}

public fun identityDocumentReader_fromJs(obj: IdentityDocumentReaderJs): IdentityDocumentReader {
	val justificatifDocumentNumber = undefinedToNull(obj.justificatifDocumentNumber)
	val supportSerialNumber = undefinedToNull(obj.supportSerialNumber)
	val timeReadingEIdDocument = numberToLong(obj.timeReadingEIdDocument, "obj.timeReadingEIdDocument")
	val eidDocumentSupportType = numberToInt(obj.eidDocumentSupportType, "obj.eidDocumentSupportType")
	val reasonManualEncoding = numberToInt(obj.reasonManualEncoding, "obj.reasonManualEncoding")
	val reasonUsingVignette = numberToInt(obj.reasonUsingVignette, "obj.reasonUsingVignette")
	return IdentityDocumentReader(
		justificatifDocumentNumber = justificatifDocumentNumber,
		supportSerialNumber = supportSerialNumber,
		timeReadingEIdDocument = timeReadingEIdDocument,
		eidDocumentSupportType = eidDocumentSupportType,
		reasonManualEncoding = reasonManualEncoding,
		reasonUsingVignette = reasonUsingVignette,
	)
}
