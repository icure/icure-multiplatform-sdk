package com.icure.sdk.crypto

import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.AnyAbstractFilterSerializer
import com.icure.sdk.model.filter.IntersectionFilter
import com.icure.sdk.model.filter.MaintenanceTaskAbstractFilterSerializer
import com.icure.sdk.model.filter.UnionFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.filter.code.CodeByRegionTypeLabelLanguageFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskAfterDateFilter
import com.icure.sdk.utils.Serialization
import io.kotest.core.spec.style.StringSpec
import kotlinx.serialization.Contextual
import kotlinx.serialization.encodeToString

class Tmp : StringSpec({
	"Serialization" {
		val chain = FilterChain(
			filter = MaintenanceTaskAfterDateFilter(
				date = 123L
			)
		)
		val chain2 = FilterChain(
			filter = CodeByRegionTypeLabelLanguageFilter(
				type = "Banana",
				language = "English"
			)
		)
		val complexFilter: AbstractFilter<MaintenanceTask> = UnionFilter(
			filters = listOf(
				MaintenanceTaskAfterDateFilter(
					date = 123L
				),
				IntersectionFilter(
					filters = listOf(
						MaintenanceTaskAfterDateFilter(
							date = 456L
						),
						MaintenanceTaskAfterDateFilter(
							date = 789L
						),
					)
				)
			)
		)
		println(Serialization.json.encodeToString(MaintenanceTaskAbstractFilterSerializer, complexFilter))
		println(Serialization.json.encodeToString(AnyAbstractFilterSerializer, complexFilter as AbstractFilter<out Identifiable<String>>))
		println(Serialization.json.encodeToString(FilterChain(filter = complexFilter)))
		println(Serialization.json.encodeToString(FilterChain(filter = complexFilter as AbstractFilter<out Identifiable<String>>)))
		println(Serialization.json.encodeToString<@Contextual AbstractFilter<MaintenanceTask>>(complexFilter))
//		val sChain = Serialization.json.encodeToString(chain)
//		println(sChain)
//		val sChainF = Serialization.json.encodeToString<@Contextual AbstractFilter<out Identifiable<String>>>(chain.filter)
//		println(sChainF)
//		val sChain2 = Serialization.json.encodeToString(chain2)
//		println(sChain2)
//		val sChain2F = Serialization.json.encodeToString(AbstractFilter.Serializer, chain2.filter)
//		println(sChain2F)
//		println("Deserialise")
//		println(Serialization.json.decodeFromString<FilterChain<MaintenanceTask>>(sChain))
//		println(Serialization.json.decodeFromString<AbstractFilter<MaintenanceTask>>(AbstractFilter.Serializer as KSerializer<AbstractFilter<MaintenanceTask>>, sChainF))
//		println(Serialization.json.decodeFromString<FilterChain<Code>>(sChain2))
//		println(Serialization.json.decodeFromString<AbstractFilter<Code>>(AbstractFilter.Serializer as KSerializer<AbstractFilter<Code>>, sChain2F))
	}
})
