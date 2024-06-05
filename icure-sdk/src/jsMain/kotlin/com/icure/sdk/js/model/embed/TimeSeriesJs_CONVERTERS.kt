package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.model.embed.TimeSeries
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.collections.List

public fun timeSeries_toJs(obj: TimeSeries): TimeSeriesJs {
	val fields = listToArray(
		obj.fields,
		{ x1: String ->
			x1
		},
	)
	val samples = listToArray(
		obj.samples,
		{ x1: List<Double> ->
			listToArray(
				x1,
				{ x2: Double ->
					x2
				},
			)
		},
	)
	val min = listToArray(
		obj.min,
		{ x1: Double ->
			x1
		},
	)
	val max = listToArray(
		obj.max,
		{ x1: Double ->
			x1
		},
	)
	val mean = listToArray(
		obj.mean,
		{ x1: Double ->
			x1
		},
	)
	val median = listToArray(
		obj.median,
		{ x1: Double ->
			x1
		},
	)
	val variance = listToArray(
		obj.variance,
		{ x1: Double ->
			x1
		},
	)
	return TimeSeriesJs(js("{" +
		"fields:fields," +
		"samples:samples," +
		"min:min," +
		"max:max," +
		"mean:mean," +
		"median:median," +
		"variance:variance" +
	"}"))
}

public fun timeSeries_fromJs(obj: TimeSeriesJs): TimeSeries {
	val fields = arrayToList(
		obj.fields,
		"obj.fields",
		{ x1: String ->
			x1
		},
	)
	val samples = arrayToList(
		obj.samples,
		"obj.samples",
		{ x1: Array<Double> ->
			arrayToList(
				x1,
				"x1",
				{ x2: Double ->
					x2
				},
			)
		},
	)
	val min = arrayToList(
		obj.min,
		"obj.min",
		{ x1: Double ->
			x1
		},
	)
	val max = arrayToList(
		obj.max,
		"obj.max",
		{ x1: Double ->
			x1
		},
	)
	val mean = arrayToList(
		obj.mean,
		"obj.mean",
		{ x1: Double ->
			x1
		},
	)
	val median = arrayToList(
		obj.median,
		"obj.median",
		{ x1: Double ->
			x1
		},
	)
	val variance = arrayToList(
		obj.variance,
		"obj.variance",
		{ x1: Double ->
			x1
		},
	)
	return TimeSeries(
		fields = fields,
		samples = samples,
		min = min,
		max = max,
		mean = mean,
		median = median,
		variance = variance,
	)
}
