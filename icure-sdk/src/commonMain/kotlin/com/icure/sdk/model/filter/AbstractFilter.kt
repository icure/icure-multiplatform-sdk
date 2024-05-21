package com.icure.sdk.model.filter

import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.code.CodeByRegionTypeLabelLanguageFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskAfterDateFilter
import com.icure.sdk.utils.CustomJsonPolymorphicSerializer
import kotlinx.serialization.KSerializer
import kotlin.reflect.KClass

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
interface AbstractFilter<O : Identifiable<String>> : Filter<O> {
	public val desc: String?
	// region AbstractFilter-AbstractFilter

	// endregion
}

internal object AnyAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<*>>("\$type", "AbstractFilter<Identifiable>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<*>>? = when (serialName) {
		"UnionFilter" -> UnionFilter.serializer(this)
		"IntersectionFilter" -> IntersectionFilter.serializer(this)
		"MaintenanceTaskAfterDateFilter" -> MaintenanceTaskAfterDateFilter.serializer()
		"CodeByRegionTypeLabelLanguageFilter" -> CodeByRegionTypeLabelLanguageFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<*>>): KSerializer<out AbstractFilter<*>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilter.serializer(this)
			IntersectionFilter::class -> IntersectionFilter.serializer(this)
			MaintenanceTaskAfterDateFilter::class -> MaintenanceTaskAfterDateFilter.serializer()
			CodeByRegionTypeLabelLanguageFilter::class -> CodeByRegionTypeLabelLanguageFilter.serializer()
			else -> null
		}
	}
}

internal object MaintenanceTaskAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<MaintenanceTask>>("\$type", "AbstractFilter<MaintenanceTask>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<MaintenanceTask>>? = when (serialName) {
		"UnionFilter" -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<MaintenanceTask>>
		"IntersectionFilter" -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<MaintenanceTask>>
		"MaintenanceTaskAfterDateFilter" -> MaintenanceTaskAfterDateFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<MaintenanceTask>>): KSerializer<out AbstractFilter<MaintenanceTask>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<MaintenanceTask>>
			IntersectionFilter::class -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<MaintenanceTask>>
			MaintenanceTaskAfterDateFilter::class -> MaintenanceTaskAfterDateFilter.serializer()
			else -> null
		}
	}
}
