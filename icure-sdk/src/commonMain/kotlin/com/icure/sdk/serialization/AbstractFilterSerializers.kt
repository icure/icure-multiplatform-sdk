package com.icure.sdk.serialization

import com.icure.sdk.model.AccessLog
import com.icure.sdk.model.Agenda
import com.icure.sdk.model.CalendarItem
import com.icure.sdk.model.Classification
import com.icure.sdk.model.Code
import com.icure.sdk.model.Contact
import com.icure.sdk.model.Device
import com.icure.sdk.model.Document
import com.icure.sdk.model.Form
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.Invoice
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.MedicalLocation
import com.icure.sdk.model.Message
import com.icure.sdk.model.Patient
import com.icure.sdk.model.TimeTable
import com.icure.sdk.model.Topic
import com.icure.sdk.model.User
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.ComplementFilter
import com.icure.sdk.model.filter.IntersectionFilter
import com.icure.sdk.model.filter.UnionFilter
import com.icure.sdk.model.filter.accesslog.AccessLogByDataOwnerPatientDateFilter
import com.icure.sdk.model.filter.accesslog.AccessLogByDateFilter
import com.icure.sdk.model.filter.accesslog.AccessLogByUserIdUserTypeDateFilter
import com.icure.sdk.model.filter.agenda.AgendaByUserIdFilter
import com.icure.sdk.model.filter.agenda.AgendaReadableByUserIdFilter
import com.icure.sdk.model.filter.calendarItem.CalendarItemByDataOwnerPatientStartTimeFilter
import com.icure.sdk.model.filter.calendarItem.CalendarItemByPeriodAndAgendaIdFilter
import com.icure.sdk.model.filter.calendarItem.CalendarItemByPeriodAndDataOwnerIdFilter
import com.icure.sdk.model.filter.calendarItem.CalendarItemByRecurrenceIdFilter
import com.icure.sdk.model.filter.classification.ClassificationByDataOwnerPatientCreatedDateFilter
import com.icure.sdk.model.filter.code.AllCodesFilter
import com.icure.sdk.model.filter.code.CodeByIdsFilter
import com.icure.sdk.model.filter.code.CodeByQualifiedLinkFilter
import com.icure.sdk.model.filter.code.CodeByRegionTypeCodeVersionFilters
import com.icure.sdk.model.filter.code.CodeByRegionTypeLabelLanguageFilter
import com.icure.sdk.model.filter.code.CodeByRegionTypesLanguageLabelVersionFilters
import com.icure.sdk.model.filter.code.CodeIdsByTypeCodeVersionIntervalFilter
import com.icure.sdk.model.filter.contact.ContactByDataOwnerFormIdsFilter
import com.icure.sdk.model.filter.contact.ContactByDataOwnerPatientOpeningDateFilter
import com.icure.sdk.model.filter.contact.ContactByExternalIdFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyIdentifiersFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyPatientTagCodeDateFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyTagCodeDateFilter
import com.icure.sdk.model.filter.contact.ContactByServiceIdsFilter
import com.icure.sdk.model.filter.device.AllDevicesFilter
import com.icure.sdk.model.filter.device.DeviceByHcPartyFilter
import com.icure.sdk.model.filter.device.DeviceByIdsFilter
import com.icure.sdk.model.filter.document.DocumentByDataOwnerPatientDateFilter
import com.icure.sdk.model.filter.document.DocumentByTypeDataOwnerPatientFilter
import com.icure.sdk.model.filter.form.FormByDataOwnerParentIdFilter
import com.icure.sdk.model.filter.form.FormByDataOwnerPatientOpeningDateFilter
import com.icure.sdk.model.filter.form.FormByLogicalUuidFilter
import com.icure.sdk.model.filter.form.FormByUniqueUuidFilter
import com.icure.sdk.model.filter.hcparty.AllHealthcarePartiesFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdentifiersFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdsFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByNameFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByNationalIdentifierFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByParentIdFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByTagCodeFilter
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByTypeSpecialtyPostCodeFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByDataOwnerPatientOpeningDate
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyIdentifiersFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartySecretForeignKeysFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyStatusFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyTagCodeFilter
import com.icure.sdk.model.filter.healthelement.HealthElementByIdsFilter
import com.icure.sdk.model.filter.invoice.InvoiceByHcPartyCodeDateFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskAfterDateFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilter
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByIdsFilter
import com.icure.sdk.model.filter.medicallocation.AllMedicalLocationsFilter
import com.icure.sdk.model.filter.medicallocation.MedicalLocationByPostCodeFilter
import com.icure.sdk.model.filter.message.LatestMessageByHcPartyTransportGuidFilter
import com.icure.sdk.model.filter.message.MessageByDataOwnerFromAddressFilter
import com.icure.sdk.model.filter.message.MessageByDataOwnerPatientSentDateFilter
import com.icure.sdk.model.filter.message.MessageByDataOwnerToAddressFilter
import com.icure.sdk.model.filter.message.MessageByDataOwnerTransportGuidSentDateFilter
import com.icure.sdk.model.filter.message.MessageByHcPartyFilter
import com.icure.sdk.model.filter.message.MessageByHcPartyTransportGuidFilter
import com.icure.sdk.model.filter.message.MessageByHcPartyTransportGuidReceivedFilter
import com.icure.sdk.model.filter.message.MessageByInvoiceIdsFilter
import com.icure.sdk.model.filter.message.MessageByParentIdsFilter
import com.icure.sdk.model.filter.patient.PatientByDataOwnerModifiedAfterFilter
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
import com.icure.sdk.model.filter.patient.PatientByHcPartyNameFilter
import com.icure.sdk.model.filter.patient.PatientByIdsFilter
import com.icure.sdk.model.filter.service.ServiceByAssociationIdFilter
import com.icure.sdk.model.filter.service.ServiceByHcPartyFilter
import com.icure.sdk.model.filter.service.ServiceByHcPartyHealthElementIdsFilter
import com.icure.sdk.model.filter.service.ServiceByHcPartyIdentifiersFilter
import com.icure.sdk.model.filter.service.ServiceByHcPartyTagCodeDateFilter
import com.icure.sdk.model.filter.service.ServiceByIdsFilter
import com.icure.sdk.model.filter.service.ServiceByQualifiedLinkFilter
import com.icure.sdk.model.filter.service.ServiceBySecretForeignKeys
import com.icure.sdk.model.filter.timetable.TimeTableByAgendaIdFilter
import com.icure.sdk.model.filter.timetable.TimeTableByPeriodAndAgendaIdFilter
import com.icure.sdk.model.filter.topic.TopicByHcPartyFilter
import com.icure.sdk.model.filter.topic.TopicByParticipantFilter
import com.icure.sdk.model.filter.user.AllUsersFilter
import com.icure.sdk.model.filter.user.UserByHealthcarePartyIdFilter
import com.icure.sdk.model.filter.user.UserByIdsFilter
import com.icure.sdk.model.filter.user.UserByNameEmailPhoneFilter
import com.icure.sdk.model.filter.user.UsersByPatientIdFilter
import com.icure.sdk.utils.CustomJsonPolymorphicSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure
import kotlin.reflect.KClass

internal object AnyAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<*>>("\$type", "AbstractFilter<Identifiable>") {
	@Suppress("UNCHECKED_CAST")
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<*>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this as KSerializer<AbstractFilter<Identifiable<String>>>)
		"IntersectionFilter" -> IntersectionFilterSerializer(this as KSerializer<AbstractFilter<Identifiable<String>>>)
		"ComplementFilter" -> ComplementFilterSerializer(this as KSerializer<AbstractFilter<Identifiable<String>>>)
		else -> AccessLogAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: AgendaAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: CalendarItemAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: ClassificationAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: CodeAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: ContactAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: DeviceAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: DocumentAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: FormAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: HealthcarePartyAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: HealthElementAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: InvoiceAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: MaintenanceTaskAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: MedicalLocationAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: MessageAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: PatientAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: ServiceAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: TimeTableAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: TopicAbstractFilterSerializer.getSerializerBySerialName(serialName)
			?: UserAbstractFilterSerializer.getSerializerBySerialName(serialName)
	}

	@Suppress("UNCHECKED_CAST")
	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<*>>): KSerializer<out AbstractFilter<*>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this as KSerializer<AbstractFilter<Identifiable<String>>>)
			IntersectionFilter::class -> IntersectionFilterSerializer(this as KSerializer<AbstractFilter<Identifiable<String>>>)
			ComplementFilter::class -> ComplementFilterSerializer(this as KSerializer<AbstractFilter<Identifiable<String>>>)
			else ->  AccessLogAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<AccessLog>>)
				?: AgendaAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Agenda>>)
				?: CalendarItemAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<CalendarItem>>)
				?: ClassificationAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Classification>>)
				?: CodeAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Code>>)
				?: ContactAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Contact>>)
				?: DeviceAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Device>>)
				?: DocumentAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Document>>)
				?: FormAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Form>>)
				?: HealthcarePartyAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<HealthcareParty>>)
				?: HealthElementAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<HealthElement>>)
				?: InvoiceAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Invoice>>)
				?: MaintenanceTaskAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<MaintenanceTask>>)
				?: MedicalLocationAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<MedicalLocation>>)
				?: MessageAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Message>>)
				?: PatientAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Patient>>)
				?: ServiceAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Service>>)
				?: TimeTableAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<TimeTable>>)
				?: TopicAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Topic>>)
				?: UserAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<User>>)
		}
	}
}

internal object AccessLogAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<AccessLog>>("\$type", "AbstractFilter<AccessLog>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<AccessLog>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"AccessLogByDataOwnerPatientDateFilter" -> AccessLogByDataOwnerPatientDateFilter.serializer()
		"AccessLogByDateFilter" -> AccessLogByDateFilter.serializer()
		"AccessLogByUserIdUserTypeDateFilter" -> AccessLogByUserIdUserTypeDateFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<AccessLog>>): KSerializer<out AbstractFilter<AccessLog>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			AccessLogByDataOwnerPatientDateFilter::class -> AccessLogByDataOwnerPatientDateFilter.serializer()
			AccessLogByDateFilter::class -> AccessLogByDateFilter.serializer()
			AccessLogByUserIdUserTypeDateFilter::class -> AccessLogByUserIdUserTypeDateFilter.serializer()
			else -> null
		}
	}
}

internal object AgendaAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Agenda>>("\$type", "AbstractFilter<Agenda>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Agenda>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"AgendaByUserIdFilter" -> AgendaByUserIdFilter.serializer()
		"AgendaReadableByUserIdFilter" -> AgendaReadableByUserIdFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Agenda>>): KSerializer<out AbstractFilter<Agenda>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			AgendaByUserIdFilter::class -> AgendaByUserIdFilter.serializer()
			AgendaReadableByUserIdFilter::class -> AgendaReadableByUserIdFilter.serializer()
			else -> null
		}
	}
}

internal object CalendarItemAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<CalendarItem>>("\$type", "AbstractFilter<CalendarItem>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<CalendarItem>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"CalendarItemByDataOwnerPatientStartTimeFilter" -> CalendarItemByDataOwnerPatientStartTimeFilter.serializer()
		"CalendarItemByPeriodAndAgendaIdFilter" -> CalendarItemByPeriodAndAgendaIdFilter.serializer()
		"CalendarItemByPeriodAndDataOwnerIdFilter" -> CalendarItemByPeriodAndDataOwnerIdFilter.serializer()
		"CalendarItemByRecurrenceIdFilter" -> CalendarItemByRecurrenceIdFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<CalendarItem>>): KSerializer<out AbstractFilter<CalendarItem>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			CalendarItemByDataOwnerPatientStartTimeFilter::class -> CalendarItemByDataOwnerPatientStartTimeFilter.serializer()
			CalendarItemByPeriodAndAgendaIdFilter::class -> CalendarItemByPeriodAndAgendaIdFilter.serializer()
			CalendarItemByPeriodAndDataOwnerIdFilter::class -> CalendarItemByPeriodAndDataOwnerIdFilter.serializer()
			CalendarItemByRecurrenceIdFilter::class -> CalendarItemByRecurrenceIdFilter.serializer()
			else -> null
		}
	}
}

internal object ClassificationAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Classification>>("\$type", "AbstractFilter<Classification>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Classification>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"ClassificationByUserIdFilter" -> ClassificationByDataOwnerPatientCreatedDateFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Classification>>): KSerializer<out AbstractFilter<Classification>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			ClassificationByDataOwnerPatientCreatedDateFilter::class -> ClassificationByDataOwnerPatientCreatedDateFilter.serializer()
			else -> null
		}
	}
}

internal object CodeAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Code>>("\$type", "AbstractFilter<Code>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Code>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"AllCodesFilter" -> AllCodesFilter.serializer()
		"CodeByIdsFilter" -> CodeByIdsFilter.serializer()
		"CodeByQualifiedLinkFilter" -> CodeByQualifiedLinkFilter.serializer()
		"CodeByRegionTypeCodeVersionFilters" -> CodeByRegionTypeCodeVersionFilters.serializer()
		"CodeByRegionTypeLabelLanguageFilter" -> CodeByRegionTypeLabelLanguageFilter.serializer()
		"CodeByRegionTypesLanguageLabelVersionFilters" -> CodeByRegionTypesLanguageLabelVersionFilters.serializer()
		"CodeIdsByTypeCodeVersionIntervalFilter" -> CodeIdsByTypeCodeVersionIntervalFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Code>>): KSerializer<out AbstractFilter<Code>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			AllCodesFilter::class -> AllCodesFilter.serializer()
			CodeByIdsFilter::class -> CodeByIdsFilter.serializer()
			CodeByQualifiedLinkFilter::class -> CodeByQualifiedLinkFilter.serializer()
			CodeByRegionTypeCodeVersionFilters::class -> CodeByRegionTypeCodeVersionFilters.serializer()
			CodeByRegionTypeLabelLanguageFilter::class -> CodeByRegionTypeLabelLanguageFilter.serializer()
			CodeByRegionTypesLanguageLabelVersionFilters::class -> CodeByRegionTypesLanguageLabelVersionFilters.serializer()
			CodeIdsByTypeCodeVersionIntervalFilter::class -> CodeIdsByTypeCodeVersionIntervalFilter.serializer()
			else -> null
		}
	}
}

internal object ContactAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Contact>>("\$type", "AbstractFilter<Contact>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Contact>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"ContactByDataOwnerFormIdsFilter" -> ContactByDataOwnerFormIdsFilter.serializer()
		"ContactByDataOwnerPatientOpeningDateFilter" -> ContactByDataOwnerPatientOpeningDateFilter.serializer()
		"ContactByExternalIdFilter" -> ContactByExternalIdFilter.serializer()
		"ContactByHcPartyFilter" -> ContactByHcPartyFilter.serializer()
		"ContactByHcPartyIdentifiersFilter" -> ContactByHcPartyIdentifiersFilter.serializer()
		"ContactByHcPartyPatientTagCodeDateFilter" -> ContactByHcPartyPatientTagCodeDateFilter.serializer()
		"ContactByHcPartyTagCodeDateFilter" -> ContactByHcPartyTagCodeDateFilter.serializer()
		"ContactByServiceIdsFilter" -> ContactByServiceIdsFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Contact>>): KSerializer<out AbstractFilter<Contact>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			ContactByDataOwnerFormIdsFilter::class -> ContactByDataOwnerFormIdsFilter.serializer()
			ContactByDataOwnerPatientOpeningDateFilter::class -> ContactByDataOwnerPatientOpeningDateFilter.serializer()
			ContactByExternalIdFilter::class -> ContactByExternalIdFilter.serializer()
			ContactByHcPartyFilter::class -> ContactByHcPartyFilter.serializer()
			ContactByHcPartyIdentifiersFilter::class -> ContactByHcPartyIdentifiersFilter.serializer()
			ContactByHcPartyPatientTagCodeDateFilter::class -> ContactByHcPartyPatientTagCodeDateFilter.serializer()
			ContactByHcPartyTagCodeDateFilter::class -> ContactByHcPartyTagCodeDateFilter.serializer()
			ContactByServiceIdsFilter::class -> ContactByServiceIdsFilter.serializer()
			else -> null
		}
	}
}

internal object DeviceAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Device>>("\$type", "AbstractFilter<Device>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Device>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"AllDevicesFilter" -> AllDevicesFilter.serializer()
		"DeviceByHcPartyFilter" -> DeviceByHcPartyFilter.serializer()
		"DeviceByIdsFilter" -> DeviceByIdsFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Device>>): KSerializer<out AbstractFilter<Device>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			AllDevicesFilter::class -> AllDevicesFilter.serializer()
			DeviceByHcPartyFilter::class -> DeviceByHcPartyFilter.serializer()
			DeviceByIdsFilter::class -> DeviceByIdsFilter.serializer()
			else -> null
		}
	}
}

internal object DocumentAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Document>>("\$type", "AbstractFilter<Document>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Document>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"DocumentByDataOwnerPatientDateFilter" -> DocumentByDataOwnerPatientDateFilter.serializer()
		"DocumentByTypeDataOwnerPatientFilter" -> DocumentByTypeDataOwnerPatientFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Document>>): KSerializer<out AbstractFilter<Document>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			DocumentByDataOwnerPatientDateFilter::class -> DocumentByDataOwnerPatientDateFilter.serializer()
			DocumentByTypeDataOwnerPatientFilter::class -> DocumentByTypeDataOwnerPatientFilter.serializer()
			else -> null
		}
	}
}

internal object FormAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Form>>("\$type", "AbstractFilter<Form>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Form>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"FormByDataOwnerParentIdFilter" -> FormByDataOwnerParentIdFilter.serializer()
		"FormByDataOwnerPatientOpeningDateFilter" -> FormByDataOwnerPatientOpeningDateFilter.serializer()
		"FormByLogicalUuidFilter" -> FormByLogicalUuidFilter.serializer()
		"FormByUniqueUuidFilter" -> FormByUniqueUuidFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Form>>): KSerializer<out AbstractFilter<Form>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			FormByDataOwnerParentIdFilter::class -> FormByDataOwnerParentIdFilter.serializer()
			FormByDataOwnerPatientOpeningDateFilter::class -> FormByDataOwnerPatientOpeningDateFilter.serializer()
			FormByLogicalUuidFilter::class -> FormByLogicalUuidFilter.serializer()
			FormByUniqueUuidFilter::class -> FormByUniqueUuidFilter.serializer()
			else -> null
		}
	}
}

internal object HealthcarePartyAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<HealthcareParty>>("\$type", "AbstractFilter<HealthcareParty>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<HealthcareParty>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"AllHealthcarePartiesFilter" -> AllHealthcarePartiesFilter.serializer()
		"HealthcarePartyByIdentifiersFilter" -> HealthcarePartyByIdentifiersFilter.serializer()
		"HealthcarePartyByIdsFilter" -> HealthcarePartyByIdsFilter.serializer()
		"HealthcarePartyByNameFilter" -> HealthcarePartyByNameFilter.serializer()
		"HealthcarePartyByNationalIdentifierFilter" -> HealthcarePartyByNationalIdentifierFilter.serializer()
		"HealthcarePartyByParentIdFilter" -> HealthcarePartyByParentIdFilter.serializer()
		"HealthcarePartyByTagCodeFilter" -> HealthcarePartyByTagCodeFilter.serializer()
		"HealthcarePartyByTypeSpecialtyPostCodeFilter" -> HealthcarePartyByTypeSpecialtyPostCodeFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<HealthcareParty>>): KSerializer<out AbstractFilter<HealthcareParty>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			AllHealthcarePartiesFilter::class -> AllHealthcarePartiesFilter.serializer()
			HealthcarePartyByIdentifiersFilter::class -> HealthcarePartyByIdentifiersFilter.serializer()
			HealthcarePartyByIdsFilter::class -> HealthcarePartyByIdsFilter.serializer()
			HealthcarePartyByNameFilter::class -> HealthcarePartyByNameFilter.serializer()
			HealthcarePartyByNationalIdentifierFilter::class -> HealthcarePartyByNationalIdentifierFilter.serializer()
			HealthcarePartyByParentIdFilter::class -> HealthcarePartyByParentIdFilter.serializer()
			HealthcarePartyByTagCodeFilter::class -> HealthcarePartyByTagCodeFilter.serializer()
			HealthcarePartyByTypeSpecialtyPostCodeFilter::class -> HealthcarePartyByTypeSpecialtyPostCodeFilter.serializer()
			else -> null
		}
	}
}

internal object HealthElementAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<HealthElement>>("\$type", "AbstractFilter<HealthElement>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<HealthElement>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"HealthElementByDataOwnerPatientOpeningDate" -> HealthElementByDataOwnerPatientOpeningDate.serializer()
		"HealthElementByHcPartyFilter" -> HealthElementByHcPartyFilter.serializer()
		"HealthElementByHcPartyIdentifiersFilter" -> HealthElementByHcPartyIdentifiersFilter.serializer()
		"HealthElementByHcPartySecretForeignKeysFilter" -> HealthElementByHcPartySecretForeignKeysFilter.serializer()
		"HealthElementByHcPartyStatusFilter" -> HealthElementByHcPartyStatusFilter.serializer()
		"HealthElementByHcPartyTagCodeFilter" -> HealthElementByHcPartyTagCodeFilter.serializer()
		"HealthElementByIdsFilter" -> HealthElementByIdsFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<HealthElement>>): KSerializer<out AbstractFilter<HealthElement>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			HealthElementByDataOwnerPatientOpeningDate::class -> HealthElementByDataOwnerPatientOpeningDate.serializer()
			HealthElementByHcPartyFilter::class -> HealthElementByHcPartyFilter.serializer()
			HealthElementByHcPartyIdentifiersFilter::class -> HealthElementByHcPartyIdentifiersFilter.serializer()
			HealthElementByHcPartySecretForeignKeysFilter::class -> HealthElementByHcPartySecretForeignKeysFilter.serializer()
			HealthElementByHcPartyStatusFilter::class -> HealthElementByHcPartyStatusFilter.serializer()
			HealthElementByHcPartyTagCodeFilter::class -> HealthElementByHcPartyTagCodeFilter.serializer()
			HealthElementByIdsFilter::class -> HealthElementByIdsFilter.serializer()
			else -> null
		}
	}
}

internal object InvoiceAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Invoice>>("\$type", "AbstractFilter<Invoice>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Invoice>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"InvoiceByHcPartyCodeDateFilter" -> InvoiceByHcPartyCodeDateFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Invoice>>): KSerializer<out AbstractFilter<Invoice>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			InvoiceByHcPartyCodeDateFilter::class -> InvoiceByHcPartyCodeDateFilter.serializer()
			else -> null
		}
	}
}

internal object MaintenanceTaskAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<MaintenanceTask>>("\$type", "AbstractFilter<MaintenanceTask>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<MaintenanceTask>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"MaintenanceTaskAfterDateFilter" -> MaintenanceTaskAfterDateFilter.serializer()
		"MaintenanceTaskByHcPartyAndIdentifiersFilter" -> MaintenanceTaskByHcPartyAndIdentifiersFilter.serializer()
		"MaintenanceTaskByHcPartyAndTypeFilter" -> MaintenanceTaskByHcPartyAndTypeFilter.serializer()
		"MaintenanceTaskByIdsFilter" -> MaintenanceTaskByIdsFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<MaintenanceTask>>): KSerializer<out AbstractFilter<MaintenanceTask>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			MaintenanceTaskAfterDateFilter::class -> MaintenanceTaskAfterDateFilter.serializer()
			MaintenanceTaskByHcPartyAndIdentifiersFilter::class -> MaintenanceTaskByHcPartyAndIdentifiersFilter.serializer()
			MaintenanceTaskByHcPartyAndTypeFilter::class -> MaintenanceTaskByHcPartyAndTypeFilter.serializer()
			MaintenanceTaskByIdsFilter::class -> MaintenanceTaskByIdsFilter.serializer()
			else -> null
		}
	}
}

internal object MedicalLocationAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<MedicalLocation>>("\$type", "AbstractFilter<MedicalLocation>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<MedicalLocation>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"AllMedicalLocationsFilter" -> AllMedicalLocationsFilter.serializer()
		"MedicalLocationByPostCodeFilter" -> MedicalLocationByPostCodeFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<MedicalLocation>>): KSerializer<out AbstractFilter<MedicalLocation>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			MedicalLocationByPostCodeFilter::class -> MedicalLocationByPostCodeFilter.serializer()
			else -> null
		}
	}
}

internal object MessageAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Message>>("\$type", "AbstractFilter<Message>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Message>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"LatestMessageByHcPartyTransportGuidFilter" -> LatestMessageByHcPartyTransportGuidFilter.serializer()
		"MessageByDataOwnerFromAddressFilter" -> MessageByDataOwnerFromAddressFilter.serializer()
		"MessageByDataOwnerPatientSentDateFilter" -> MessageByDataOwnerPatientSentDateFilter.serializer()
		"MessageByDataOwnerToAddressFilter" -> MessageByDataOwnerToAddressFilter.serializer()
		"MessageByDataOwnerTransportGuidSentDateFilter" -> MessageByDataOwnerTransportGuidSentDateFilter.serializer()
		"MessageByHcPartyFilter" -> MessageByHcPartyFilter.serializer()
		"MessageByHcPartyTransportGuidFilter" -> MessageByHcPartyTransportGuidFilter.serializer()
		"MessageByHcPartyTransportGuidReceivedFilter" -> MessageByHcPartyTransportGuidReceivedFilter.serializer()
		"MessageByInvoiceIdsFilter" -> MessageByInvoiceIdsFilter.serializer()
		"MessageByParentIdsFilter" -> MessageByParentIdsFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Message>>): KSerializer<out AbstractFilter<Message>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			LatestMessageByHcPartyTransportGuidFilter::class -> LatestMessageByHcPartyTransportGuidFilter.serializer()
			MessageByDataOwnerFromAddressFilter::class -> MessageByDataOwnerFromAddressFilter.serializer()
			MessageByDataOwnerPatientSentDateFilter::class -> MessageByDataOwnerPatientSentDateFilter.serializer()
			MessageByDataOwnerToAddressFilter::class -> MessageByDataOwnerToAddressFilter.serializer()
			MessageByDataOwnerTransportGuidSentDateFilter::class -> MessageByDataOwnerTransportGuidSentDateFilter.serializer()
			MessageByHcPartyFilter::class -> MessageByHcPartyFilter.serializer()
			MessageByHcPartyTransportGuidFilter::class -> MessageByHcPartyTransportGuidFilter.serializer()
			MessageByHcPartyTransportGuidReceivedFilter::class -> MessageByHcPartyTransportGuidReceivedFilter.serializer()
			MessageByInvoiceIdsFilter::class -> MessageByInvoiceIdsFilter.serializer()
			MessageByParentIdsFilter::class -> MessageByParentIdsFilter.serializer()
			else -> null
		}
	}
}

internal object PatientAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Patient>>("\$type", "AbstractFilter<Patient>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Patient>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"PatientByDataOwnerModifiedAfterFilter" -> PatientByDataOwnerModifiedAfterFilter.serializer()
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
		"PatientByHcPartyNameFilter" -> PatientByHcPartyNameFilter.serializer()
		"PatientByIdsFilter" -> PatientByIdsFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Patient>>): KSerializer<out AbstractFilter<Patient>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			PatientByDataOwnerModifiedAfterFilter::class -> PatientByDataOwnerModifiedAfterFilter.serializer()
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
			PatientByHcPartyNameFilter::class -> PatientByHcPartyNameFilter.serializer()
			PatientByIdsFilter::class -> PatientByIdsFilter.serializer()
			else -> null
		}
	}
}

internal object ServiceAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Service>>("\$type", "AbstractFilter<Service>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Service>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"ServiceByAssociationIdFilter" -> ServiceByAssociationIdFilter.serializer()
		"ServiceByHcPartyFilter" -> ServiceByHcPartyFilter.serializer()
		"ServiceByHcPartyHealthElementIdsFilter" -> ServiceByHcPartyHealthElementIdsFilter.serializer()
		"ServiceByHcPartyIdentifiersFilter" -> ServiceByHcPartyIdentifiersFilter.serializer()
		"ServiceByHcPartyTagCodeDateFilter" -> ServiceByHcPartyTagCodeDateFilter.serializer()
		"ServiceByIdsFilter" -> ServiceByIdsFilter.serializer()
		"ServiceByQualifiedLinkFilter" -> ServiceByQualifiedLinkFilter.serializer()
		"ServiceBySecretForeignKeys" -> ServiceBySecretForeignKeys.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Service>>): KSerializer<out AbstractFilter<Service>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			ServiceByAssociationIdFilter::class -> ServiceByAssociationIdFilter.serializer()
			ServiceByHcPartyFilter::class -> ServiceByHcPartyFilter.serializer()
			ServiceByHcPartyHealthElementIdsFilter::class -> ServiceByHcPartyHealthElementIdsFilter.serializer()
			ServiceByHcPartyIdentifiersFilter::class -> ServiceByHcPartyIdentifiersFilter.serializer()
			ServiceByHcPartyTagCodeDateFilter::class -> ServiceByHcPartyTagCodeDateFilter.serializer()
			ServiceByIdsFilter::class -> ServiceByIdsFilter.serializer()
			ServiceByQualifiedLinkFilter::class -> ServiceByQualifiedLinkFilter.serializer()
			ServiceBySecretForeignKeys::class -> ServiceBySecretForeignKeys.serializer()
			else -> null
		}
	}
}

internal object TimeTableAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<TimeTable>>("\$type", "AbstractFilter<TimeTable>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<TimeTable>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"TimeTableByAgendaIdFilter" -> TimeTableByAgendaIdFilter.serializer()
		"TimeTableByPeriodAndAgendaIdFilter" -> TimeTableByPeriodAndAgendaIdFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<TimeTable>>): KSerializer<out AbstractFilter<TimeTable>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			TimeTableByAgendaIdFilter::class -> TimeTableByAgendaIdFilter.serializer()
			TimeTableByPeriodAndAgendaIdFilter::class -> TimeTableByPeriodAndAgendaIdFilter.serializer()
			else -> null
		}
	}
}

internal object TopicAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<Topic>>("\$type", "AbstractFilter<Topic>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Topic>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"TopicByHcPartyFilter" -> TopicByHcPartyFilter.serializer()
		"TopicByParticipantFilter" -> TopicByParticipantFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Topic>>): KSerializer<out AbstractFilter<Topic>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			TopicByHcPartyFilter::class -> TopicByHcPartyFilter.serializer()
			TopicByParticipantFilter::class -> TopicByParticipantFilter.serializer()
			else -> null
		}
	}
}

internal object UserAbstractFilterSerializer : CustomJsonPolymorphicSerializer<AbstractFilter<User>>("\$type", "AbstractFilter<User>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<User>>? = when (serialName) {
		"UnionFilter" -> UnionFilterSerializer(this)
		"IntersectionFilter" -> IntersectionFilterSerializer(this)
		"ComplementFilter" -> ComplementFilterSerializer(this)
		"AllUsersFilter" -> AllUsersFilter.serializer()
		"UserByHealthcarePartyIdFilter" -> UserByHealthcarePartyIdFilter.serializer()
		"UserByIdsFilter" -> UserByIdsFilter.serializer()
		"UserByNameEmailPhoneFilter" -> UserByNameEmailPhoneFilter.serializer()
		"UsersByPatientIdFilter" -> UsersByPatientIdFilter.serializer()
		else -> null
	}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<User>>): KSerializer<out AbstractFilter<User>>? {
		return when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			AllUsersFilter::class -> AllUsersFilter.serializer()
			UserByHealthcarePartyIdFilter::class -> UserByHealthcarePartyIdFilter.serializer()
			UserByIdsFilter::class -> UserByIdsFilter.serializer()
			UserByNameEmailPhoneFilter::class -> UserByNameEmailPhoneFilter.serializer()
			UsersByPatientIdFilter::class -> UsersByPatientIdFilter.serializer()
			else -> null
		}
	}
}
