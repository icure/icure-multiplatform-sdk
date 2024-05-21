package com.icure.sdk.model.filter

import com.icure.sdk.model.Code
import com.icure.sdk.model.Contact
import com.icure.sdk.model.Device
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.Invoice
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.Message
import com.icure.sdk.model.Patient
import com.icure.sdk.model.Topic
import com.icure.sdk.model.User
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.filter.code.AllCodesFilter
import com.icure.sdk.model.filter.code.CodeByIdsFilter
import com.icure.sdk.model.filter.code.CodeByRegionTypeLabelLanguageFilter
import com.icure.sdk.model.filter.code.CodeIdsByTypeCodeVersionIntervalFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyIdentifiersFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyPatientTagCodeDateFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyTagCodeDateFilter
import com.icure.sdk.model.filter.device.DeviceByHcPartyFilter
import com.icure.sdk.model.filter.device.DeviceByIdsFilter
import com.icure.sdk.model.filter.hcparty.AllHealthcarePartiesFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdentifiersFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdsFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByNameFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByTagCodeFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyIdentifiersFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartySecretForeignKeysFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyTagCodeFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByIdsFilter
import com.icure.sdk.model.filter.invoice.InvoiceByHcPartyCodeDateFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskAfterDateFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByIdsFilter
import com.icure.sdk.model.filter.message.LatestMessageByHcPartyTransportGuidFilter
import com.icure.sdk.model.filter.message.MessageByHcPartyFilter
import com.icure.sdk.model.filter.message.MessageByHcPartyTransportGuidFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndActiveFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndAddressFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndExternalIdFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndIdentifiersFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndSsinFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndSsinsFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyAndTelecomFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyDateOfBirthBetweenFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyDateOfBirthFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyGenderEducationProfession
import com.icure.sdk.model.filter.patient.PatientByHcPartyNameContainsFuzzyFilter
import com.icure.sdk.model.filter.patient.PatientByHcPartyNameFilter
import com.icure.sdk.model.filter.patient.PatientByIdsFilter
import com.icure.sdk.model.filter.service.ServiceByContactsAndSubcontactsFilter
import com.icure.sdk.model.filter.service.ServiceByHcPartyFilter
import com.icure.sdk.model.filter.service.ServiceByHcPartyHealthElementIdsFilter
import com.icure.sdk.model.filter.service.ServiceByHcPartyIdentifiersFilter
import com.icure.sdk.model.filter.service.ServiceByHcPartyTagCodeDateFilter
import com.icure.sdk.model.filter.service.ServiceByIdsFilter
import com.icure.sdk.model.filter.service.ServiceBySecretForeignKeys
import com.icure.sdk.model.filter.topic.TopicByHcPartyFilter
import com.icure.sdk.model.filter.topic.TopicByParticipantFilter
import com.icure.sdk.model.filter.user.UserByIdsFilter
import com.icure.sdk.model.filter.user.UserByNameEmailPhoneFilter
import com.icure.sdk.model.filter.user.UsersByPatientIdFilter
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
		"ComplementFilter" -> ComplementFilter.serializer(this)
		else -> CodeAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: ContactAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: DeviceAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: HealthcarePartyAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: HealthElementAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: InvoiceAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: MaintenanceTaskAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: MessageAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: PatientAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: ServiceAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: TopicAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: UserAbstractFilterSerializer.getSerializerBySerialName(serialName)
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<*>>): KSerializer<out AbstractFilter<*>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilter.serializer(this)
			IntersectionFilter::class -> IntersectionFilter.serializer(this)
			ComplementFilter::class -> ComplementFilter.serializer(this)
			else -> CodeAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Code>>)
				?: ContactAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Contact>>)
				?: DeviceAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Device>>)
				?: HealthcarePartyAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<HealthcareParty>>)
				?: HealthElementAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<HealthElement>>)
				?: InvoiceAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Invoice>>)
				?: MaintenanceTaskAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<MaintenanceTask>>)
				?: MessageAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Message>>)
				?: PatientAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Patient>>)
				?: ServiceAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Service>>)
				?: TopicAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Topic>>)
				?: UserAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<User>>)
		}
	}
}

internal object CodeAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Code>>("\$type", "AbstractFilter<Code>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Code>>? = when (serialName) {
		"UnionFilter" -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Code>>
		"IntersectionFilter" -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Code>>
		"ComplementFilter" -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Code>>
		"AllCodesFilter" -> AllCodesFilter.serializer()
		"CodeByIdsFilter" -> CodeByIdsFilter.serializer()
		"CodeByRegionTypeLabelLanguageFilter" -> CodeByRegionTypeLabelLanguageFilter.serializer()
		"CodeIdsByTypeCodeVersionIntervalFilter" -> CodeIdsByTypeCodeVersionIntervalFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Code>>): KSerializer<out AbstractFilter<Code>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Code>>
			IntersectionFilter::class -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Code>>
			ComplementFilter::class -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Code>>
			AllCodesFilter::class -> AllCodesFilter.serializer()
			CodeByIdsFilter::class -> CodeByIdsFilter.serializer()
			CodeByRegionTypeLabelLanguageFilter::class -> CodeByRegionTypeLabelLanguageFilter.serializer()
			CodeIdsByTypeCodeVersionIntervalFilter::class -> CodeIdsByTypeCodeVersionIntervalFilter.serializer()
			else -> null
		}
	}
}

internal object ContactAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Contact>>("\$type", "AbstractFilter<Contact>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Contact>>? = when (serialName) {
		"UnionFilter" -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Contact>>
		"IntersectionFilter" -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Contact>>
		"ComplementFilter" -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Contact>>
		"ContactByHcPartyFilter" -> ContactByHcPartyFilter.serializer()
		"ContactByHcPartyIdentifiersFilter" -> ContactByHcPartyIdentifiersFilter.serializer()
		"ContactByHcPartyPatientTagCodeDateFilter" -> ContactByHcPartyPatientTagCodeDateFilter.serializer()
		"ContactByHcPartyTagCodeDateFilter" -> ContactByHcPartyTagCodeDateFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Contact>>): KSerializer<out AbstractFilter<Contact>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Contact>>
			IntersectionFilter::class -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Contact>>
			ComplementFilter::class -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Contact>>
			ContactByHcPartyFilter::class -> ContactByHcPartyFilter.serializer()
			ContactByHcPartyIdentifiersFilter::class -> ContactByHcPartyIdentifiersFilter.serializer()
			ContactByHcPartyPatientTagCodeDateFilter::class -> ContactByHcPartyPatientTagCodeDateFilter.serializer()
			ContactByHcPartyTagCodeDateFilter::class -> ContactByHcPartyTagCodeDateFilter.serializer()
			else -> null
		}
	}
}

internal object DeviceAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Device>>("\$type", "AbstractFilter<Device>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Device>>? = when (serialName) {
		"UnionFilter" -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Device>>
		"IntersectionFilter" -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Device>>
		"ComplementFilter" -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Device>>
		"DeviceByHcPartyFilter" -> DeviceByHcPartyFilter.serializer()
		"DeviceByIdsFilter" -> DeviceByIdsFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Device>>): KSerializer<out AbstractFilter<Device>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Device>>
			IntersectionFilter::class -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Device>>
			ComplementFilter::class -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Device>>
			DeviceByHcPartyFilter::class -> DeviceByHcPartyFilter.serializer()
			DeviceByIdsFilter::class -> DeviceByIdsFilter.serializer()
			else -> null
		}
	}
}

internal object HealthcarePartyAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<HealthcareParty>>("\$type", "AbstractFilter<HealthcareParty>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<HealthcareParty>>? = when (serialName) {
		"UnionFilter" -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<HealthcareParty>>
		"IntersectionFilter" -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<HealthcareParty>>
		"ComplementFilter" -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<HealthcareParty>>
		"AllHealthcarePartiesFilter" -> AllHealthcarePartiesFilter.serializer()
		"HealthcarePartyByIdentifiersFilter" -> HealthcarePartyByIdentifiersFilter.serializer()
		"HealthcarePartyByIdsFilter" -> HealthcarePartyByIdsFilter.serializer()
		"HealthcarePartyByNameFilter" -> HealthcarePartyByNameFilter.serializer()
		"HealthcarePartyByTagCodeFilter" -> HealthcarePartyByTagCodeFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<HealthcareParty>>): KSerializer<out AbstractFilter<HealthcareParty>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<HealthcareParty>>
			IntersectionFilter::class -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<HealthcareParty>>
			ComplementFilter::class -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<HealthcareParty>>
			AllHealthcarePartiesFilter::class -> AllHealthcarePartiesFilter.serializer()
			HealthcarePartyByIdentifiersFilter::class -> HealthcarePartyByIdentifiersFilter.serializer()
			HealthcarePartyByIdsFilter::class -> HealthcarePartyByIdsFilter.serializer()
			HealthcarePartyByNameFilter::class -> HealthcarePartyByNameFilter.serializer()
			HealthcarePartyByTagCodeFilter::class -> HealthcarePartyByTagCodeFilter.serializer()
			else -> null
		}
	}
}

internal object HealthElementAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<HealthElement>>("\$type", "AbstractFilter<HealthElement>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<HealthElement>>? = when (serialName) {
		"UnionFilter" -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<HealthElement>>
		"IntersectionFilter" -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<HealthElement>>
		"ComplementFilter" -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<HealthElement>>
		"HealthElementByHcPartyFilter" -> HealthElementByHcPartyFilter.serializer()
		"HealthElementByHcPartyIdentifiersFilter" -> HealthElementByHcPartyIdentifiersFilter.serializer()
		"HealthElementByIdsFilter" -> HealthElementByIdsFilter.serializer()
		"HealthElementByHcPartySecretForeignKeysFilter" -> HealthElementByHcPartySecretForeignKeysFilter.serializer()
		"HealthElementByHcPartyTagCodeFilter" -> HealthElementByHcPartyTagCodeFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<HealthElement>>): KSerializer<out AbstractFilter<HealthElement>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<HealthElement>>
			IntersectionFilter::class -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<HealthElement>>
			ComplementFilter::class -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<HealthElement>>
			HealthElementByHcPartyFilter::class -> HealthElementByHcPartyFilter.serializer()
			HealthElementByHcPartyIdentifiersFilter::class -> HealthElementByHcPartyIdentifiersFilter.serializer()
			HealthElementByIdsFilter::class -> HealthElementByIdsFilter.serializer()
			HealthElementByHcPartySecretForeignKeysFilter::class -> HealthElementByHcPartySecretForeignKeysFilter.serializer()
			HealthElementByHcPartyTagCodeFilter::class -> HealthElementByHcPartyTagCodeFilter.serializer()
			else -> null
		}
	}
}

internal object InvoiceAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Invoice>>("\$type", "AbstractFilter<Invoice>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Invoice>>? = when (serialName) {
		"UnionFilter" -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Invoice>>
		"IntersectionFilter" -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Invoice>>
		"ComplementFilter" -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Invoice>>
		"InvoiceByHcPartyCodeDateFilter" -> InvoiceByHcPartyCodeDateFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Invoice>>): KSerializer<out AbstractFilter<Invoice>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Invoice>>
			IntersectionFilter::class -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Invoice>>
			ComplementFilter::class -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Invoice>>
			InvoiceByHcPartyCodeDateFilter::class -> InvoiceByHcPartyCodeDateFilter.serializer()
			else -> null
		}
	}
}

internal object MaintenanceTaskAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<MaintenanceTask>>("\$type", "AbstractFilter<MaintenanceTask>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<MaintenanceTask>>? = when (serialName) {
		"UnionFilter" -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<MaintenanceTask>>
		"IntersectionFilter" -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<MaintenanceTask>>
		"ComplementFilter" -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<MaintenanceTask>>
		"MaintenanceTaskAfterDateFilter" -> MaintenanceTaskAfterDateFilter.serializer()
		"MaintenanceTaskByHcPartyAndIdentifiersFilter" -> MaintenanceTaskByHcPartyAndIdentifiersFilter.serializer()
		"MaintenanceTaskByHcPartyAndTypeFilter" -> MaintenanceTaskByHcPartyAndTypeFilter.serializer()
		"MaintenanceTaskByIdsFilter" -> MaintenanceTaskByIdsFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<MaintenanceTask>>): KSerializer<out AbstractFilter<MaintenanceTask>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<MaintenanceTask>>
			IntersectionFilter::class -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<MaintenanceTask>>
			ComplementFilter::class -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<MaintenanceTask>>
			MaintenanceTaskAfterDateFilter::class -> MaintenanceTaskAfterDateFilter.serializer()
			MaintenanceTaskByHcPartyAndIdentifiersFilter::class -> MaintenanceTaskByHcPartyAndIdentifiersFilter.serializer()
			MaintenanceTaskByHcPartyAndTypeFilter::class -> MaintenanceTaskByHcPartyAndTypeFilter.serializer()
			MaintenanceTaskByIdsFilter::class -> MaintenanceTaskByIdsFilter.serializer()
			else -> null
		}
	}
}

internal object MessageAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Message>>("\$type", "AbstractFilter<Message>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Message>>? = when (serialName) {
		"UnionFilter" -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Message>>
		"IntersectionFilter" -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Message>>
		"ComplementFilter" -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Message>>
		"LatestMessageByHcPartyTransportGuidFilter" -> LatestMessageByHcPartyTransportGuidFilter.serializer()
		"MessageByHcPartyFilter" -> MessageByHcPartyFilter.serializer()
		"MessageByHcPartyTransportGuidFilter" -> MessageByHcPartyTransportGuidFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Message>>): KSerializer<out AbstractFilter<Message>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Message>>
			IntersectionFilter::class -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Message>>
			ComplementFilter::class -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Message>>
			LatestMessageByHcPartyTransportGuidFilter::class -> LatestMessageByHcPartyTransportGuidFilter.serializer()
			MessageByHcPartyFilter::class -> MessageByHcPartyFilter.serializer()
			MessageByHcPartyTransportGuidFilter::class -> MessageByHcPartyTransportGuidFilter.serializer()
			else -> null
		}
	}
}

internal object PatientAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Patient>>("\$type", "AbstractFilter<Patient>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Patient>>? = when (serialName) {
		"UnionFilter" -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Patient>>
		"IntersectionFilter" -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Patient>>
		"ComplementFilter" -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Patient>>
		"PatientByHcPartyAndActiveFilter" -> PatientByHcPartyAndActiveFilter.serializer()
		"PatientByHcPartyAndAddressFilter" -> PatientByHcPartyAndAddressFilter.serializer()
		"PatientByHcPartyAndExternalIdFilter" -> PatientByHcPartyAndExternalIdFilter.serializer()
		"PatientByHcPartyAndIdentifiersFilter" -> PatientByHcPartyAndIdentifiersFilter.serializer()
		"PatientByHcPartyAndSsinFilter" -> PatientByHcPartyAndSsinFilter.serializer()
		"PatientByHcPartyAndSsinsFilter" -> PatientByHcPartyAndSsinsFilter.serializer()
		"PatientByHcPartyAndTelecomFilter" -> PatientByHcPartyAndTelecomFilter.serializer()
		"PatientByHcPartyDateOfBirthBetweenFilter" -> PatientByHcPartyDateOfBirthBetweenFilter.serializer()
		"PatientByHcPartyDateOfBirthFilter" -> PatientByHcPartyDateOfBirthFilter.serializer()
		"PatientByHcPartyFilter" -> PatientByHcPartyFilter.serializer()
		"PatientByHcPartyGenderEducationProfession" -> PatientByHcPartyGenderEducationProfession.serializer()
		"PatientByHcPartyNameContainsFuzzyFilter" -> PatientByHcPartyNameContainsFuzzyFilter.serializer()
		"PatientByHcPartyNameFilter" -> PatientByHcPartyNameFilter.serializer()
		"PatientByIdsFilter" -> PatientByIdsFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Patient>>): KSerializer<out AbstractFilter<Patient>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Patient>>
			IntersectionFilter::class -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Patient>>
			ComplementFilter::class -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Patient>>
			PatientByHcPartyAndActiveFilter::class -> PatientByHcPartyAndActiveFilter.serializer()
			PatientByHcPartyAndAddressFilter::class -> PatientByHcPartyAndAddressFilter.serializer()
			PatientByHcPartyAndExternalIdFilter::class -> PatientByHcPartyAndExternalIdFilter.serializer()
			PatientByHcPartyAndIdentifiersFilter::class -> PatientByHcPartyAndIdentifiersFilter.serializer()
			PatientByHcPartyAndSsinFilter::class -> PatientByHcPartyAndSsinFilter.serializer()
			PatientByHcPartyAndSsinsFilter::class -> PatientByHcPartyAndSsinsFilter.serializer()
			PatientByHcPartyAndTelecomFilter::class -> PatientByHcPartyAndTelecomFilter.serializer()
			PatientByHcPartyDateOfBirthBetweenFilter::class -> PatientByHcPartyDateOfBirthBetweenFilter.serializer()
			PatientByHcPartyDateOfBirthFilter::class -> PatientByHcPartyDateOfBirthFilter.serializer()
			PatientByHcPartyFilter::class -> PatientByHcPartyFilter.serializer()
			PatientByHcPartyGenderEducationProfession::class -> PatientByHcPartyGenderEducationProfession.serializer()
			PatientByHcPartyNameContainsFuzzyFilter::class -> PatientByHcPartyNameContainsFuzzyFilter.serializer()
			PatientByHcPartyNameFilter::class -> PatientByHcPartyNameFilter.serializer()
			PatientByIdsFilter::class -> PatientByIdsFilter.serializer()
			else -> null
		}
	}
}

internal object ServiceAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Service>>("\$type", "AbstractFilter<Service>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Service>>? = when (serialName) {
		"UnionFilter" -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Service>>
		"IntersectionFilter" -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Service>>
		"ComplementFilter" -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Service>>
		"ServiceByContactsAndSubcontactsFilter" -> ServiceByContactsAndSubcontactsFilter.serializer()
		"ServiceByHcPartyFilter" -> ServiceByHcPartyFilter.serializer()
		"ServiceByHcPartyHealthElementIdsFilter" -> ServiceByHcPartyHealthElementIdsFilter.serializer()
		"ServiceByHcPartyIdentifiersFilter" -> ServiceByHcPartyIdentifiersFilter.serializer()
		"ServiceByHcPartyTagCodeDateFilter" -> ServiceByHcPartyTagCodeDateFilter.serializer()
		"ServiceByIdsFilter" -> ServiceByIdsFilter.serializer()
		"ServiceBySecretForeignKeys" -> ServiceBySecretForeignKeys.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Service>>): KSerializer<out AbstractFilter<Service>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Service>>
			IntersectionFilter::class -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Service>>
			ComplementFilter::class -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Service>>
			ServiceByContactsAndSubcontactsFilter::class -> ServiceByContactsAndSubcontactsFilter.serializer()
			ServiceByHcPartyFilter::class -> ServiceByHcPartyFilter.serializer()
			ServiceByHcPartyHealthElementIdsFilter::class -> ServiceByHcPartyHealthElementIdsFilter.serializer()
			ServiceByHcPartyIdentifiersFilter::class -> ServiceByHcPartyIdentifiersFilter.serializer()
			ServiceByHcPartyTagCodeDateFilter::class -> ServiceByHcPartyTagCodeDateFilter.serializer()
			ServiceByIdsFilter::class -> ServiceByIdsFilter.serializer()
			ServiceBySecretForeignKeys::class -> ServiceBySecretForeignKeys.serializer()
			else -> null
		}
	}
}

internal object TopicAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Topic>>("\$type", "AbstractFilter<Topic>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Topic>>? = when (serialName) {
		"UnionFilter" -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Topic>>
		"IntersectionFilter" -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Topic>>
		"ComplementFilter" -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Topic>>
		"TopicByHcPartyFilter" -> TopicByHcPartyFilter.serializer()
		"TopicByParticipantFilter" -> TopicByParticipantFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Topic>>): KSerializer<out AbstractFilter<Topic>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<Topic>>
			IntersectionFilter::class -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<Topic>>
			ComplementFilter::class -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<Topic>>
			TopicByHcPartyFilter::class -> TopicByHcPartyFilter.serializer()
			TopicByParticipantFilter::class -> TopicByParticipantFilter.serializer()
			else -> null
		}
	}
}

internal object UserAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<User>>("\$type", "AbstractFilter<User>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<User>>? = when (serialName) {
		"UnionFilter" -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<User>>
		"IntersectionFilter" -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<User>>
		"ComplementFilter" -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<User>>
		"UserByIdsFilter" -> UserByIdsFilter.serializer()
		"UserByNameEmailPhoneFilter" -> UserByNameEmailPhoneFilter.serializer()
		"UsersByPatientIdFilter" -> UsersByPatientIdFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<User>>): KSerializer<out AbstractFilter<User>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilter.serializer(this) as KSerializer<out AbstractFilter<User>>
			IntersectionFilter::class -> IntersectionFilter.serializer(this) as KSerializer<out AbstractFilter<User>>
			ComplementFilter::class -> ComplementFilter.serializer(this) as KSerializer<out AbstractFilter<User>>
			UserByIdsFilter::class -> UserByIdsFilter.serializer()
			UserByNameEmailPhoneFilter::class -> UserByNameEmailPhoneFilter.serializer()
			UsersByPatientIdFilter::class -> UsersByPatientIdFilter.serializer()
			else -> null
		}
	}
}
