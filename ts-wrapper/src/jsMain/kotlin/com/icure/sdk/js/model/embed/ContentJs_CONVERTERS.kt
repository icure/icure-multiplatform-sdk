package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.instantToNumber
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInstant
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.embed.Content
import com.icure.sdk.model.embed.DecryptedContent
import com.icure.sdk.model.embed.DecryptedService
import com.icure.sdk.model.embed.EncryptedContent
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.Measure
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun content_toJs(obj: DecryptedContent): DecryptedContentJs {
	val stringValue = obj.stringValue ?: undefined
	val numberValue = obj.numberValue ?: undefined
	val booleanValue = obj.booleanValue ?: undefined
	val instantValue = instantToNumber(obj.instantValue) ?: undefined
	val fuzzyDateValue = longToNumber(obj.fuzzyDateValue) ?: undefined
	val binaryValue = obj.binaryValue ?: undefined
	val documentId = obj.documentId ?: undefined
	val measureValue = obj.measureValue?.let { nonNull1 ->
		measure_toJs(nonNull1)
	} ?: undefined
	val medicationValue = obj.medicationValue?.let { nonNull1 ->
		medication_toJs(nonNull1)
	} ?: undefined
	val timeSeries = obj.timeSeries?.let { nonNull1 ->
		timeSeries_toJs(nonNull1)
	} ?: undefined
	val compoundValue = listToArray(
		obj.compoundValue,
		{ x1: DecryptedService ->
			service_toJs(x1)
		},
	) ?: undefined
	val ratio = listToArray(
		obj.ratio,
		{ x1: Measure ->
			measure_toJs(x1)
		},
	) ?: undefined
	val range = listToArray(
		obj.range,
		{ x1: Measure ->
			measure_toJs(x1)
		},
	) ?: undefined
	return DecryptedContentJs(js("{" +
		"stringValue:stringValue," +
		"numberValue:numberValue," +
		"booleanValue:booleanValue," +
		"instantValue:instantValue," +
		"fuzzyDateValue:fuzzyDateValue," +
		"binaryValue:binaryValue," +
		"documentId:documentId," +
		"measureValue:measureValue," +
		"medicationValue:medicationValue," +
		"timeSeries:timeSeries," +
		"compoundValue:compoundValue," +
		"ratio:ratio," +
		"range:range" +
	"}"))
}

public fun content_fromJs(obj: DecryptedContentJs): DecryptedContent {
	val stringValue = obj.stringValue
	val numberValue = obj.numberValue
	val booleanValue = obj.booleanValue
	val instantValue = numberToInstant(obj.instantValue, "obj.instantValue")
	val fuzzyDateValue = numberToLong(obj.fuzzyDateValue, "obj.fuzzyDateValue")
	val binaryValue = obj.binaryValue
	val documentId = obj.documentId
	val measureValue = obj.measureValue?.let { nonNull1 ->
		measure_fromJs(nonNull1)
	}
	val medicationValue = obj.medicationValue?.let { nonNull1 ->
		medication_fromJs(nonNull1)
	}
	val timeSeries = obj.timeSeries?.let { nonNull1 ->
		timeSeries_fromJs(nonNull1)
	}
	val compoundValue = arrayToList(
		obj.compoundValue,
		"obj.compoundValue",
		{ x1: DecryptedServiceJs ->
			service_fromJs(x1)
		},
	)
	val ratio = arrayToList(
		obj.ratio,
		"obj.ratio",
		{ x1: MeasureJs ->
			measure_fromJs(x1)
		},
	)
	val range = arrayToList(
		obj.range,
		"obj.range",
		{ x1: MeasureJs ->
			measure_fromJs(x1)
		},
	)
	return DecryptedContent(
		stringValue = stringValue,
		numberValue = numberValue,
		booleanValue = booleanValue,
		instantValue = instantValue,
		fuzzyDateValue = fuzzyDateValue,
		binaryValue = binaryValue,
		documentId = documentId,
		measureValue = measureValue,
		medicationValue = medicationValue,
		timeSeries = timeSeries,
		compoundValue = compoundValue,
		ratio = ratio,
		range = range,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun content_toJs(obj: EncryptedContent): EncryptedContentJs {
	val stringValue = obj.stringValue ?: undefined
	val numberValue = obj.numberValue ?: undefined
	val booleanValue = obj.booleanValue ?: undefined
	val instantValue = instantToNumber(obj.instantValue) ?: undefined
	val fuzzyDateValue = longToNumber(obj.fuzzyDateValue) ?: undefined
	val binaryValue = obj.binaryValue ?: undefined
	val documentId = obj.documentId ?: undefined
	val measureValue = obj.measureValue?.let { nonNull1 ->
		measure_toJs(nonNull1)
	} ?: undefined
	val medicationValue = obj.medicationValue?.let { nonNull1 ->
		medication_toJs(nonNull1)
	} ?: undefined
	val timeSeries = obj.timeSeries?.let { nonNull1 ->
		timeSeries_toJs(nonNull1)
	} ?: undefined
	val compoundValue = listToArray(
		obj.compoundValue,
		{ x1: EncryptedService ->
			service_toJs(x1)
		},
	) ?: undefined
	val ratio = listToArray(
		obj.ratio,
		{ x1: Measure ->
			measure_toJs(x1)
		},
	) ?: undefined
	val range = listToArray(
		obj.range,
		{ x1: Measure ->
			measure_toJs(x1)
		},
	) ?: undefined
	return EncryptedContentJs(js("{" +
		"stringValue:stringValue," +
		"numberValue:numberValue," +
		"booleanValue:booleanValue," +
		"instantValue:instantValue," +
		"fuzzyDateValue:fuzzyDateValue," +
		"binaryValue:binaryValue," +
		"documentId:documentId," +
		"measureValue:measureValue," +
		"medicationValue:medicationValue," +
		"timeSeries:timeSeries," +
		"compoundValue:compoundValue," +
		"ratio:ratio," +
		"range:range" +
	"}"))
}

public fun content_fromJs(obj: EncryptedContentJs): EncryptedContent {
	val stringValue = obj.stringValue
	val numberValue = obj.numberValue
	val booleanValue = obj.booleanValue
	val instantValue = numberToInstant(obj.instantValue, "obj.instantValue")
	val fuzzyDateValue = numberToLong(obj.fuzzyDateValue, "obj.fuzzyDateValue")
	val binaryValue = obj.binaryValue
	val documentId = obj.documentId
	val measureValue = obj.measureValue?.let { nonNull1 ->
		measure_fromJs(nonNull1)
	}
	val medicationValue = obj.medicationValue?.let { nonNull1 ->
		medication_fromJs(nonNull1)
	}
	val timeSeries = obj.timeSeries?.let { nonNull1 ->
		timeSeries_fromJs(nonNull1)
	}
	val compoundValue = arrayToList(
		obj.compoundValue,
		"obj.compoundValue",
		{ x1: EncryptedServiceJs ->
			service_fromJs(x1)
		},
	)
	val ratio = arrayToList(
		obj.ratio,
		"obj.ratio",
		{ x1: MeasureJs ->
			measure_fromJs(x1)
		},
	)
	val range = arrayToList(
		obj.range,
		"obj.range",
		{ x1: MeasureJs ->
			measure_fromJs(x1)
		},
	)
	return EncryptedContent(
		stringValue = stringValue,
		numberValue = numberValue,
		booleanValue = booleanValue,
		instantValue = instantValue,
		fuzzyDateValue = fuzzyDateValue,
		binaryValue = binaryValue,
		documentId = documentId,
		measureValue = measureValue,
		medicationValue = medicationValue,
		timeSeries = timeSeries,
		compoundValue = compoundValue,
		ratio = ratio,
		range = range,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun content_toJs(obj: Content): ContentJs = when (obj) {
	is EncryptedContent -> content_toJs(obj)
	is DecryptedContent -> content_toJs(obj)
}

public fun content_fromJs(obj: ContentJs): Content = if (obj.isEncrypted) {
	content_fromJs(obj as EncryptedContentJs)
} else {
	content_fromJs(obj as DecryptedContentJs)
}
