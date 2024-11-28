package com.icure.cardinal.sdk.dart.filters

import com.icure.cardinal.sdk.dart.utils.DartResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.filters.difference as sdkDifference
import com.icure.cardinal.sdk.filters.intersection as sdkIntersection
import com.icure.cardinal.sdk.filters.union as sdkUnion

@OptIn(InternalIcureApi::class)
object MetaFilters {
	fun intersection(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		leftString: String,
		rightString: String
	) {
		val left = Serialization.fullLanguageInteropJson.decodeFromString(FilterOptions.serializer<Identifiable<String>>(), leftString)
		val right = Serialization.fullLanguageInteropJson.decodeFromString(FilterOptions.serializer<Identifiable<String>>(), rightString)
		DartResult.resolve(
			dartResultCallback,
			FilterOptions.serializer<Identifiable<String>>()
		) {
			sdkIntersection(left, right)
		}
	}

	fun sortableIntersection(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		leftString: String,
		rightString: String
	) {
		val left = Serialization.fullLanguageInteropJson.decodeFromString(SortableFilterOptions.serializer<Identifiable<String>>(), leftString)
		val right = Serialization.fullLanguageInteropJson.decodeFromString(FilterOptions.serializer<Identifiable<String>>(), rightString)
		DartResult.resolve(
			dartResultCallback,
			SortableFilterOptions.serializer<Identifiable<String>>()
		) {
			sdkIntersection(left, right)
		}
	}

	fun baseIntersection(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		leftString: String,
		rightString: String
	) {
		val left = Serialization.fullLanguageInteropJson.decodeFromString(BaseFilterOptions.serializer<Identifiable<String>>(), leftString)
		val right = Serialization.fullLanguageInteropJson.decodeFromString(BaseFilterOptions.serializer<Identifiable<String>>(), rightString)
		DartResult.resolve(
			dartResultCallback,
			BaseFilterOptions.serializer<Identifiable<String>>()
		) {
			sdkIntersection(left, right)
		}
	}

	fun baseSortableIntersection(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		leftString: String,
		rightString: String
	) {
		val left = Serialization.fullLanguageInteropJson.decodeFromString(BaseSortableFilterOptions.serializer<Identifiable<String>>(), leftString)
		val right = Serialization.fullLanguageInteropJson.decodeFromString(BaseFilterOptions.serializer<Identifiable<String>>(), rightString)
		DartResult.resolve(
			dartResultCallback,
			BaseSortableFilterOptions.serializer<Identifiable<String>>()
		) {
			sdkIntersection(left, right)
		}
	}

	fun difference(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		leftString: String,
		rightString: String
	) {
		val left = Serialization.fullLanguageInteropJson.decodeFromString(FilterOptions.serializer<Identifiable<String>>(), leftString)
		val right = Serialization.fullLanguageInteropJson.decodeFromString(FilterOptions.serializer<Identifiable<String>>(), rightString)
		DartResult.resolve(
			dartResultCallback,
			FilterOptions.serializer<Identifiable<String>>()
		) {
			sdkDifference(left, right)
		}
	}

	fun sortableDifference(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		leftString: String,
		rightString: String
	) {
		val left = Serialization.fullLanguageInteropJson.decodeFromString(SortableFilterOptions.serializer<Identifiable<String>>(), leftString)
		val right = Serialization.fullLanguageInteropJson.decodeFromString(FilterOptions.serializer<Identifiable<String>>(), rightString)
		DartResult.resolve(
			dartResultCallback,
			SortableFilterOptions.serializer<Identifiable<String>>()
		) {
			sdkDifference(left, right)
		}
	}

	fun baseDifference(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		leftString: String,
		rightString: String
	) {
		val left = Serialization.fullLanguageInteropJson.decodeFromString(BaseFilterOptions.serializer<Identifiable<String>>(), leftString)
		val right = Serialization.fullLanguageInteropJson.decodeFromString(BaseFilterOptions.serializer<Identifiable<String>>(), rightString)
		DartResult.resolve(
			dartResultCallback,
			BaseFilterOptions.serializer<Identifiable<String>>()
		) {
			sdkDifference(left, right)
		}
	}

	fun baseSortableDifference(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		leftString: String,
		rightString: String
	) {
		val left = Serialization.fullLanguageInteropJson.decodeFromString(BaseSortableFilterOptions.serializer<Identifiable<String>>(), leftString)
		val right = Serialization.fullLanguageInteropJson.decodeFromString(BaseFilterOptions.serializer<Identifiable<String>>(), rightString)
		DartResult.resolve(
			dartResultCallback,
			BaseSortableFilterOptions.serializer<Identifiable<String>>()
		) {
			sdkDifference(left, right)
		}
	}

	fun union(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		leftString: String,
		rightString: String
	) {
		val left = Serialization.fullLanguageInteropJson.decodeFromString(FilterOptions.serializer<Identifiable<String>>(), leftString)
		val right = Serialization.fullLanguageInteropJson.decodeFromString(FilterOptions.serializer<Identifiable<String>>(), rightString)
		DartResult.resolve(
			dartResultCallback,
			FilterOptions.serializer<Identifiable<String>>()
		) {
			sdkUnion(left, right)
		}
	}

	fun baseUnion(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		leftString: String,
		rightString: String
	) {
		val left = Serialization.fullLanguageInteropJson.decodeFromString(BaseFilterOptions.serializer<Identifiable<String>>(), leftString)
		val right = Serialization.fullLanguageInteropJson.decodeFromString(BaseFilterOptions.serializer<Identifiable<String>>(), rightString)
		DartResult.resolve(
			dartResultCallback,
			BaseFilterOptions.serializer<Identifiable<String>>()
		) {
			sdkUnion(left, right)
		}
	}
}