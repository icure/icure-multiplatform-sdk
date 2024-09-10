package com.icure.cardinal.sdk.py.filters.MetaFilters

import com.icure.cardinal.sdk.filters.DispatchedMetaFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import kotlinx.serialization.Serializable

@Serializable
private data class ListOfFiltersParam(
	val filters: List<FilterOptions<Identifiable<String>>>
)

@OptIn(InternalIcureApi::class)
fun intersection(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListOfFiltersParam>(params)
	require(decodedParams.filters.size >= 2) { "Intersection requires at least two filters" }
	DispatchedMetaFilterOptions.intersection(
		decodedParams.filters[0],
		decodedParams.filters[1],
		*decodedParams.filters.drop(2).toTypedArray()
	)
}.toPyString(FilterOptions.serializer())

@OptIn(InternalIcureApi::class)
fun union(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListOfFiltersParam>(params)
	require(decodedParams.filters.size >= 2) { "Intersection requires at least two filters" }
	DispatchedMetaFilterOptions.union(
		decodedParams.filters[0],
		decodedParams.filters[1],
		*decodedParams.filters.drop(2).toTypedArray()
	)
}.toPyString(FilterOptions.serializer())

@Serializable
private data class DifferenceParams(
	val of: FilterOptions<Identifiable<String>>,
	val subtracting: FilterOptions<Identifiable<String>>,
)

@OptIn(InternalIcureApi::class)
fun difference(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DifferenceParams>(params)
	DispatchedMetaFilterOptions.difference(
		of = decodedParams.of,
		subtracting = decodedParams.subtracting
	)
}.toPyString(FilterOptions.serializer())