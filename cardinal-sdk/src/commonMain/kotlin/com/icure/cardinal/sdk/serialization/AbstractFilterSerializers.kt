// This file is auto-generated
package com.icure.cardinal.sdk.serialization

import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.MedicalLocation
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.ComplementFilter
import com.icure.cardinal.sdk.model.filter.IntersectionFilter
import com.icure.cardinal.sdk.model.filter.UnionFilter
import com.icure.cardinal.sdk.model.filter.accesslog.AccessLogByDataOwnerPatientDateFilter
import com.icure.cardinal.sdk.model.filter.accesslog.AccessLogByDateFilter
import com.icure.cardinal.sdk.model.filter.accesslog.AccessLogByUserIdUserTypeDateFilter
import com.icure.cardinal.sdk.model.filter.agenda.AgendaByUserIdFilter
import com.icure.cardinal.sdk.model.filter.agenda.AgendaReadableByUserIdFilter
import com.icure.cardinal.sdk.model.filter.agenda.AllAgendasFilter
import com.icure.cardinal.sdk.model.filter.calendarItem.CalendarItemByDataOwnerPatientStartTimeFilter
import com.icure.cardinal.sdk.model.filter.calendarItem.CalendarItemByPeriodAndAgendaIdFilter
import com.icure.cardinal.sdk.model.filter.calendarItem.CalendarItemByPeriodAndDataOwnerIdFilter
import com.icure.cardinal.sdk.model.filter.calendarItem.CalendarItemByRecurrenceIdFilter
import com.icure.cardinal.sdk.model.filter.classification.ClassificationByDataOwnerPatientCreatedDateFilter
import com.icure.cardinal.sdk.model.filter.code.AllCodesFilter
import com.icure.cardinal.sdk.model.filter.code.CodeByIdsFilter
import com.icure.cardinal.sdk.model.filter.code.CodeByQualifiedLinkFilter
import com.icure.cardinal.sdk.model.filter.code.CodeByRegionTypeCodeVersionFilters
import com.icure.cardinal.sdk.model.filter.code.CodeByRegionTypeLabelLanguageFilter
import com.icure.cardinal.sdk.model.filter.code.CodeByRegionTypesLanguageLabelVersionFilters
import com.icure.cardinal.sdk.model.filter.code.CodeIdsByTypeCodeVersionIntervalFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByDataOwnerFormIdsFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByDataOwnerOpeningDateFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByDataOwnerPatientOpeningDateFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByDataOwnerServiceCodeFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByDataOwnerServiceTagFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByExternalIdFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByHcPartyFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByHcPartyIdentifiersFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByHcPartyPatientTagCodeDateFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByHcPartyTagCodeDateFilter
import com.icure.cardinal.sdk.model.filter.contact.ContactByServiceIdsFilter
import com.icure.cardinal.sdk.model.filter.device.AllDevicesFilter
import com.icure.cardinal.sdk.model.filter.device.DeviceByHcPartyFilter
import com.icure.cardinal.sdk.model.filter.device.DeviceByIdsFilter
import com.icure.cardinal.sdk.model.filter.document.DocumentByDataOwnerPatientDateFilter
import com.icure.cardinal.sdk.model.filter.document.DocumentByTypeDataOwnerPatientFilter
import com.icure.cardinal.sdk.model.filter.form.FormByDataOwnerParentIdFilter
import com.icure.cardinal.sdk.model.filter.form.FormByDataOwnerPatientOpeningDateFilter
import com.icure.cardinal.sdk.model.filter.form.FormByLogicalUuidFilter
import com.icure.cardinal.sdk.model.filter.form.FormByUniqueUuidFilter
import com.icure.cardinal.sdk.model.filter.group.AllGroupsFilter
import com.icure.cardinal.sdk.model.filter.group.GroupBySuperGroupFilter
import com.icure.cardinal.sdk.model.filter.group.GroupWithContentFilter
import com.icure.cardinal.sdk.model.filter.hcparty.AllHealthcarePartiesFilter
import com.icure.cardinal.sdk.model.filter.hcparty.HealthcarePartyByIdentifiersFilter
import com.icure.cardinal.sdk.model.filter.hcparty.HealthcarePartyByIdsFilter
import com.icure.cardinal.sdk.model.filter.hcparty.HealthcarePartyByNameFilter
import com.icure.cardinal.sdk.model.filter.hcparty.HealthcarePartyByNationalIdentifierFilter
import com.icure.cardinal.sdk.model.filter.hcparty.HealthcarePartyByParentIdFilter
import com.icure.cardinal.sdk.model.filter.hcparty.HealthcarePartyByTagCodeFilter
import com.icure.cardinal.sdk.model.filter.hcparty.HealthcarePartyByTypeSpecialtyPostCodeFilter
import com.icure.cardinal.sdk.model.filter.healthelement.HealthElementByDataOwnerPatientOpeningDate
import com.icure.cardinal.sdk.model.filter.healthelement.HealthElementByHcPartyFilter
import com.icure.cardinal.sdk.model.filter.healthelement.HealthElementByHcPartyIdentifiersFilter
import com.icure.cardinal.sdk.model.filter.healthelement.HealthElementByHcPartyStatusFilter
import com.icure.cardinal.sdk.model.filter.healthelement.HealthElementByHcPartyTagCodeFilter
import com.icure.cardinal.sdk.model.filter.healthelement.HealthElementByIdsFilter
import com.icure.cardinal.sdk.model.filter.invoice.InvoiceByHcPartyCodeDateFilter
import com.icure.cardinal.sdk.model.filter.maintenancetask.MaintenanceTaskAfterDateFilter
import com.icure.cardinal.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilter
import com.icure.cardinal.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilter
import com.icure.cardinal.sdk.model.filter.maintenancetask.MaintenanceTaskByIdsFilter
import com.icure.cardinal.sdk.model.filter.medicallocation.AllMedicalLocationsFilter
import com.icure.cardinal.sdk.model.filter.medicallocation.MedicalLocationByPostCodeFilter
import com.icure.cardinal.sdk.model.filter.message.LatestMessageByHcPartyTransportGuidFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByDataOwnerFromAddressFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByDataOwnerPatientSentDateFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByDataOwnerToAddressFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByDataOwnerTransportGuidSentDateFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByHcPartyFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByHcPartyTransportGuidReceivedFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByInvoiceIdsFilter
import com.icure.cardinal.sdk.model.filter.message.MessageByParentIdsFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByDataOwnerModifiedAfterFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyAndActiveFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyAndAddressFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyAndExternalIdFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyAndIdentifiersFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyAndSsinFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyAndSsinsFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyAndTelecomFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyDateOfBirthBetweenFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyDateOfBirthFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyGenderEducationProfession
import com.icure.cardinal.sdk.model.filter.patient.PatientByHcPartyNameFilter
import com.icure.cardinal.sdk.model.filter.patient.PatientByIdsFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByAssociationIdFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByDataOwnerPatientDateFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByHcPartyFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByHcPartyHealthElementIdsFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByHcPartyIdentifiersFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByHcPartyTagCodeDateFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByIdsFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceByQualifiedLinkFilter
import com.icure.cardinal.sdk.model.filter.service.ServiceBySecretForeignKeys
import com.icure.cardinal.sdk.model.filter.timetable.TimeTableByAgendaIdFilter
import com.icure.cardinal.sdk.model.filter.timetable.TimeTableByPeriodAndAgendaIdFilter
import com.icure.cardinal.sdk.model.filter.topic.TopicByHcPartyFilter
import com.icure.cardinal.sdk.model.filter.topic.TopicByParticipantFilter
import com.icure.cardinal.sdk.model.filter.user.AllUsersFilter
import com.icure.cardinal.sdk.model.filter.user.UserByHealthcarePartyIdFilter
import com.icure.cardinal.sdk.model.filter.user.UserByIdsFilter
import com.icure.cardinal.sdk.model.filter.user.UserByNameEmailPhoneFilter
import com.icure.cardinal.sdk.model.filter.user.UsersByPatientIdFilter
import com.icure.cardinal.sdk.utils.CustomJsonPolymorphicSerializer
import kotlinx.serialization.KSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.reflect.KClass

internal object AnyAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<*>>("${'$'}type", "AbstractFilter<Identifiable>") {
	@Suppress("UNCHECKED_CAST")
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<*>>? =
		when (serialName) {
			"ComplementFilter" ->
				ComplementFilterSerializer(
					this as
						KSerializer<AbstractFilter<Identifiable<String>>>,
				)
			"IntersectionFilter" ->
				IntersectionFilterSerializer(
					this as
						KSerializer<AbstractFilter<Identifiable<String>>>,
				)
			"UnionFilter" -> UnionFilterSerializer(this as KSerializer<AbstractFilter<Identifiable<String>>>)
			else ->
				AgendaAbstractFilterSerializer.getSerializerBySerialName(serialName)
					?: CalendarItemAbstractFilterSerializer.getSerializerBySerialName(serialName)
					?: ClassificationAbstractFilterSerializer.getSerializerBySerialName(serialName)
					?: CodeAbstractFilterSerializer.getSerializerBySerialName(serialName)
					?: ContactAbstractFilterSerializer.getSerializerBySerialName(serialName)
					?: DeviceAbstractFilterSerializer.getSerializerBySerialName(serialName)
					?: DocumentAbstractFilterSerializer.getSerializerBySerialName(serialName)
					?: FormAbstractFilterSerializer.getSerializerBySerialName(serialName)
					?: GroupAbstractFilterSerializer.getSerializerBySerialName(serialName)
					?: HealthElementAbstractFilterSerializer.getSerializerBySerialName(serialName)
					?: HealthcarePartyAbstractFilterSerializer.getSerializerBySerialName(serialName)
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
	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<*>>): KSerializer<out AbstractFilter<*>>? =
		when (kclass) {
			ComplementFilter::class ->
				ComplementFilterSerializer(
					this as
						KSerializer<AbstractFilter<Identifiable<String>>>,
				)
			IntersectionFilter::class ->
				IntersectionFilterSerializer(
					this as
						KSerializer<AbstractFilter<Identifiable<String>>>,
				)
			UnionFilter::class ->
				UnionFilterSerializer(
					this as
						KSerializer<AbstractFilter<Identifiable<String>>>,
				)
			else ->
				AgendaAbstractFilterSerializer.getSerializerByClass(
					kclass as
						KClass<out AbstractFilter<Agenda>>,
				)
					?: CalendarItemAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<CalendarItem>>,
					)
					?: ClassificationAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<Classification>>,
					)
					?: CodeAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Code>>)
					?: ContactAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<Contact>>,
					)
					?: DeviceAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<Device>>,
					)
					?: DocumentAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<Document>>,
					)
					?: FormAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<Form>>)
					?: GroupAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<Group>>,
					)
					?: HealthElementAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<HealthElement>>,
					)
					?: HealthcarePartyAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<HealthcareParty>>,
					)
					?: InvoiceAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<Invoice>>,
					)
					?: MaintenanceTaskAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<MaintenanceTask>>,
					)
					?: MedicalLocationAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<MedicalLocation>>,
					)
					?: MessageAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<Message>>,
					)
					?: PatientAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<Patient>>,
					)
					?: ServiceAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<Service>>,
					)
					?: TimeTableAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<TimeTable>>,
					)
					?: TopicAbstractFilterSerializer.getSerializerByClass(
						kclass as
							KClass<out AbstractFilter<Topic>>,
					)
					?: UserAbstractFilterSerializer.getSerializerByClass(kclass as KClass<out AbstractFilter<User>>)
		}
}

internal object AccessLogAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<AccessLog>>(
		"${'$'}type",
		"AbstractFilter<AccessLog>",
	) {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<AccessLog>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"AccessLogByDateFilter" -> AccessLogByDateFilter.serializer()
			"AccessLogByUserIdUserTypeDateFilter" -> AccessLogByUserIdUserTypeDateFilter.serializer()
			"AccessLogByDataOwnerPatientDateFilter" -> AccessLogByDataOwnerPatientDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<AccessLog>>): KSerializer<out AbstractFilter<AccessLog>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			AccessLogByDateFilter::class -> AccessLogByDateFilter.serializer()
			AccessLogByUserIdUserTypeDateFilter::class -> AccessLogByUserIdUserTypeDateFilter.serializer()
			AccessLogByDataOwnerPatientDateFilter::class -> AccessLogByDataOwnerPatientDateFilter.serializer()
			else -> null
		}
}

internal object AgendaAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Agenda>>("${'$'}type", "AbstractFilter<Agenda>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Agenda>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"AllAgendasFilter" -> AllAgendasFilter.serializer()
			"AgendaByUserIdFilter" -> AgendaByUserIdFilter.serializer()
			"AgendaReadableByUserIdFilter" -> AgendaReadableByUserIdFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Agenda>>): KSerializer<out AbstractFilter<Agenda>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			AllAgendasFilter::class -> AllAgendasFilter.serializer()
			AgendaByUserIdFilter::class -> AgendaByUserIdFilter.serializer()
			AgendaReadableByUserIdFilter::class -> AgendaReadableByUserIdFilter.serializer()
			else -> null
		}
}

internal object CalendarItemAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<CalendarItem>>(
		"${'$'}type",
		"AbstractFilter<CalendarItem>",
	) {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<CalendarItem>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"CalendarItemByRecurrenceIdFilter" -> CalendarItemByRecurrenceIdFilter.serializer()
			"CalendarItemByPeriodAndDataOwnerIdFilter" ->
				CalendarItemByPeriodAndDataOwnerIdFilter.serializer()
			"CalendarItemByPeriodAndAgendaIdFilter" -> CalendarItemByPeriodAndAgendaIdFilter.serializer()
			"CalendarItemByDataOwnerPatientStartTimeFilter" ->
				CalendarItemByDataOwnerPatientStartTimeFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<CalendarItem>>): KSerializer<out AbstractFilter<CalendarItem>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			CalendarItemByRecurrenceIdFilter::class -> CalendarItemByRecurrenceIdFilter.serializer()
			CalendarItemByPeriodAndDataOwnerIdFilter::class ->
				CalendarItemByPeriodAndDataOwnerIdFilter.serializer()
			CalendarItemByPeriodAndAgendaIdFilter::class -> CalendarItemByPeriodAndAgendaIdFilter.serializer()
			CalendarItemByDataOwnerPatientStartTimeFilter::class ->
				CalendarItemByDataOwnerPatientStartTimeFilter.serializer()
			else -> null
		}
}

internal object ClassificationAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Classification>>(
		"${'$'}type",
		"AbstractFilter<Classification>",
	) {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Classification>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ClassificationByDataOwnerPatientCreatedDateFilter" ->
				ClassificationByDataOwnerPatientCreatedDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Classification>>): KSerializer<out AbstractFilter<Classification>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ClassificationByDataOwnerPatientCreatedDateFilter::class ->
				ClassificationByDataOwnerPatientCreatedDateFilter.serializer()
			else -> null
		}
}

internal object CodeAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Code>>("${'$'}type", "AbstractFilter<Code>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Code>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"CodeByQualifiedLinkFilter" -> CodeByQualifiedLinkFilter.serializer()
			"AllCodesFilter" -> AllCodesFilter.serializer()
			"CodeByIdsFilter" -> CodeByIdsFilter.serializer()
			"CodeByRegionTypeLabelLanguageFilter" -> CodeByRegionTypeLabelLanguageFilter.serializer()
			"CodeByRegionTypeCodeVersionFilters" -> CodeByRegionTypeCodeVersionFilters.serializer()
			"CodeByRegionTypesLanguageLabelVersionFilters" ->
				CodeByRegionTypesLanguageLabelVersionFilters.serializer()
			"CodeIdsByTypeCodeVersionIntervalFilter" -> CodeIdsByTypeCodeVersionIntervalFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Code>>): KSerializer<out AbstractFilter<Code>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			CodeByQualifiedLinkFilter::class -> CodeByQualifiedLinkFilter.serializer()
			AllCodesFilter::class -> AllCodesFilter.serializer()
			CodeByIdsFilter::class -> CodeByIdsFilter.serializer()
			CodeByRegionTypeLabelLanguageFilter::class -> CodeByRegionTypeLabelLanguageFilter.serializer()
			CodeByRegionTypeCodeVersionFilters::class -> CodeByRegionTypeCodeVersionFilters.serializer()
			CodeByRegionTypesLanguageLabelVersionFilters::class ->
				CodeByRegionTypesLanguageLabelVersionFilters.serializer()
			CodeIdsByTypeCodeVersionIntervalFilter::class ->
				CodeIdsByTypeCodeVersionIntervalFilter.serializer()
			else -> null
		}
}

internal object ContactAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Contact>>("${'$'}type", "AbstractFilter<Contact>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Contact>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ContactByDataOwnerFormIdsFilter" -> ContactByDataOwnerFormIdsFilter.serializer()
			"ContactByHcPartyFilter" -> ContactByHcPartyFilter.serializer()
			"ContactByExternalIdFilter" -> ContactByExternalIdFilter.serializer()
			"ContactByServiceIdsFilter" -> ContactByServiceIdsFilter.serializer()
			"ContactByHcPartyTagCodeDateFilter" -> ContactByHcPartyTagCodeDateFilter.serializer()
			"ContactByDataOwnerServiceCodeFilter" -> ContactByDataOwnerServiceCodeFilter.serializer()
			"ContactByDataOwnerPatientOpeningDateFilter" ->
				ContactByDataOwnerPatientOpeningDateFilter.serializer()
			"ContactByHcPartyIdentifiersFilter" -> ContactByHcPartyIdentifiersFilter.serializer()
			"ContactByDataOwnerOpeningDateFilter" -> ContactByDataOwnerOpeningDateFilter.serializer()
			"ContactByDataOwnerServiceTagFilter" -> ContactByDataOwnerServiceTagFilter.serializer()
			"ContactByHcPartyPatientTagCodeDateFilter" ->
				ContactByHcPartyPatientTagCodeDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Contact>>): KSerializer<out AbstractFilter<Contact>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ContactByDataOwnerFormIdsFilter::class -> ContactByDataOwnerFormIdsFilter.serializer()
			ContactByHcPartyFilter::class -> ContactByHcPartyFilter.serializer()
			ContactByExternalIdFilter::class -> ContactByExternalIdFilter.serializer()
			ContactByServiceIdsFilter::class -> ContactByServiceIdsFilter.serializer()
			ContactByHcPartyTagCodeDateFilter::class -> ContactByHcPartyTagCodeDateFilter.serializer()
			ContactByDataOwnerServiceCodeFilter::class -> ContactByDataOwnerServiceCodeFilter.serializer()
			ContactByDataOwnerPatientOpeningDateFilter::class ->
				ContactByDataOwnerPatientOpeningDateFilter.serializer()
			ContactByHcPartyIdentifiersFilter::class -> ContactByHcPartyIdentifiersFilter.serializer()
			ContactByDataOwnerOpeningDateFilter::class -> ContactByDataOwnerOpeningDateFilter.serializer()
			ContactByDataOwnerServiceTagFilter::class -> ContactByDataOwnerServiceTagFilter.serializer()
			ContactByHcPartyPatientTagCodeDateFilter::class ->
				ContactByHcPartyPatientTagCodeDateFilter.serializer()
			else -> null
		}
}

internal object DeviceAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Device>>("${'$'}type", "AbstractFilter<Device>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Device>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"AllDevicesFilter" -> AllDevicesFilter.serializer()
			"DeviceByIdsFilter" -> DeviceByIdsFilter.serializer()
			"DeviceByHcPartyFilter" -> DeviceByHcPartyFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Device>>): KSerializer<out AbstractFilter<Device>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			AllDevicesFilter::class -> AllDevicesFilter.serializer()
			DeviceByIdsFilter::class -> DeviceByIdsFilter.serializer()
			DeviceByHcPartyFilter::class -> DeviceByHcPartyFilter.serializer()
			else -> null
		}
}

internal object DocumentAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Document>>(
		"${'$'}type",
		"AbstractFilter<Document>",
	) {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Document>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"DocumentByTypeDataOwnerPatientFilter" -> DocumentByTypeDataOwnerPatientFilter.serializer()
			"DocumentByDataOwnerPatientDateFilter" -> DocumentByDataOwnerPatientDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Document>>): KSerializer<out AbstractFilter<Document>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			DocumentByTypeDataOwnerPatientFilter::class -> DocumentByTypeDataOwnerPatientFilter.serializer()
			DocumentByDataOwnerPatientDateFilter::class -> DocumentByDataOwnerPatientDateFilter.serializer()
			else -> null
		}
}

internal object FormAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Form>>("${'$'}type", "AbstractFilter<Form>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Form>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"FormByDataOwnerPatientOpeningDateFilter" -> FormByDataOwnerPatientOpeningDateFilter.serializer()
			"FormByLogicalUuidFilter" -> FormByLogicalUuidFilter.serializer()
			"FormByDataOwnerParentIdFilter" -> FormByDataOwnerParentIdFilter.serializer()
			"FormByUniqueUuidFilter" -> FormByUniqueUuidFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Form>>): KSerializer<out AbstractFilter<Form>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			FormByDataOwnerPatientOpeningDateFilter::class ->
				FormByDataOwnerPatientOpeningDateFilter.serializer()
			FormByLogicalUuidFilter::class -> FormByLogicalUuidFilter.serializer()
			FormByDataOwnerParentIdFilter::class -> FormByDataOwnerParentIdFilter.serializer()
			FormByUniqueUuidFilter::class -> FormByUniqueUuidFilter.serializer()
			else -> null
		}
}

internal object GroupAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Group>>("${'$'}type", "AbstractFilter<Group>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Group>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"AllGroupsFilter" -> AllGroupsFilter.serializer()
			"GroupBySuperGroupFilter" -> GroupBySuperGroupFilter.serializer()
			"GroupWithContentFilter" -> GroupWithContentFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Group>>): KSerializer<out AbstractFilter<Group>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			AllGroupsFilter::class -> AllGroupsFilter.serializer()
			GroupBySuperGroupFilter::class -> GroupBySuperGroupFilter.serializer()
			GroupWithContentFilter::class -> GroupWithContentFilter.serializer()
			else -> null
		}
}

internal object HealthElementAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<HealthElement>>(
		"${'$'}type",
		"AbstractFilter<HealthElement>",
	) {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<HealthElement>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"HealthElementByIdsFilter" -> HealthElementByIdsFilter.serializer()
			"HealthElementByHcPartyTagCodeFilter" -> HealthElementByHcPartyTagCodeFilter.serializer()
			"HealthElementByDataOwnerPatientOpeningDate" ->
				HealthElementByDataOwnerPatientOpeningDate.serializer()
			"HealthElementByHcPartyStatusFilter" -> HealthElementByHcPartyStatusFilter.serializer()
			"HealthElementByHcPartyFilter" -> HealthElementByHcPartyFilter.serializer()
			"HealthElementByHcPartyIdentifiersFilter" -> HealthElementByHcPartyIdentifiersFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<HealthElement>>): KSerializer<out AbstractFilter<HealthElement>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			HealthElementByIdsFilter::class -> HealthElementByIdsFilter.serializer()
			HealthElementByHcPartyTagCodeFilter::class -> HealthElementByHcPartyTagCodeFilter.serializer()
			HealthElementByDataOwnerPatientOpeningDate::class ->
				HealthElementByDataOwnerPatientOpeningDate.serializer()
			HealthElementByHcPartyStatusFilter::class -> HealthElementByHcPartyStatusFilter.serializer()
			HealthElementByHcPartyFilter::class -> HealthElementByHcPartyFilter.serializer()
			HealthElementByHcPartyIdentifiersFilter::class ->
				HealthElementByHcPartyIdentifiersFilter.serializer()
			else -> null
		}
}

internal object HealthcarePartyAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<HealthcareParty>>(
		"${'$'}type",
		"AbstractFilter<HealthcareParty>",
	) {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<HealthcareParty>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"HealthcarePartyByIdentifiersFilter" -> HealthcarePartyByIdentifiersFilter.serializer()
			"HealthcarePartyByIdsFilter" -> HealthcarePartyByIdsFilter.serializer()
			"AllHealthcarePartiesFilter" -> AllHealthcarePartiesFilter.serializer()
			"HealthcarePartyByTagCodeFilter" -> HealthcarePartyByTagCodeFilter.serializer()
			"HealthcarePartyByNameFilter" -> HealthcarePartyByNameFilter.serializer()
			"HealthcarePartyByNationalIdentifierFilter" ->
				HealthcarePartyByNationalIdentifierFilter.serializer()
			"HealthcarePartyByTypeSpecialtyPostCodeFilter" ->
				HealthcarePartyByTypeSpecialtyPostCodeFilter.serializer()
			"HealthcarePartyByParentIdFilter" -> HealthcarePartyByParentIdFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(
		kclass: KClass<out AbstractFilter<HealthcareParty>>,
	): KSerializer<out AbstractFilter<HealthcareParty>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			HealthcarePartyByIdentifiersFilter::class -> HealthcarePartyByIdentifiersFilter.serializer()
			HealthcarePartyByIdsFilter::class -> HealthcarePartyByIdsFilter.serializer()
			AllHealthcarePartiesFilter::class -> AllHealthcarePartiesFilter.serializer()
			HealthcarePartyByTagCodeFilter::class -> HealthcarePartyByTagCodeFilter.serializer()
			HealthcarePartyByNameFilter::class -> HealthcarePartyByNameFilter.serializer()
			HealthcarePartyByNationalIdentifierFilter::class ->
				HealthcarePartyByNationalIdentifierFilter.serializer()
			HealthcarePartyByTypeSpecialtyPostCodeFilter::class ->
				HealthcarePartyByTypeSpecialtyPostCodeFilter.serializer()
			HealthcarePartyByParentIdFilter::class -> HealthcarePartyByParentIdFilter.serializer()
			else -> null
		}
}

internal object InvoiceAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Invoice>>("${'$'}type", "AbstractFilter<Invoice>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Invoice>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"InvoiceByHcPartyCodeDateFilter" -> InvoiceByHcPartyCodeDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Invoice>>): KSerializer<out AbstractFilter<Invoice>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			InvoiceByHcPartyCodeDateFilter::class -> InvoiceByHcPartyCodeDateFilter.serializer()
			else -> null
		}
}

internal object MaintenanceTaskAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<MaintenanceTask>>(
		"${'$'}type",
		"AbstractFilter<MaintenanceTask>",
	) {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<MaintenanceTask>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"MaintenanceTaskByHcPartyAndTypeFilter" -> MaintenanceTaskByHcPartyAndTypeFilter.serializer()
			"MaintenanceTaskByHcPartyAndIdentifiersFilter" ->
				MaintenanceTaskByHcPartyAndIdentifiersFilter.serializer()
			"MaintenanceTaskAfterDateFilter" -> MaintenanceTaskAfterDateFilter.serializer()
			"MaintenanceTaskByIdsFilter" -> MaintenanceTaskByIdsFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(
		kclass: KClass<out AbstractFilter<MaintenanceTask>>,
	): KSerializer<out AbstractFilter<MaintenanceTask>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			MaintenanceTaskByHcPartyAndTypeFilter::class -> MaintenanceTaskByHcPartyAndTypeFilter.serializer()
			MaintenanceTaskByHcPartyAndIdentifiersFilter::class ->
				MaintenanceTaskByHcPartyAndIdentifiersFilter.serializer()
			MaintenanceTaskAfterDateFilter::class -> MaintenanceTaskAfterDateFilter.serializer()
			MaintenanceTaskByIdsFilter::class -> MaintenanceTaskByIdsFilter.serializer()
			else -> null
		}
}

internal object MedicalLocationAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<MedicalLocation>>(
		"${'$'}type",
		"AbstractFilter<MedicalLocation>",
	) {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<MedicalLocation>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"MedicalLocationByPostCodeFilter" -> MedicalLocationByPostCodeFilter.serializer()
			"AllMedicalLocationsFilter" -> AllMedicalLocationsFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(
		kclass: KClass<out AbstractFilter<MedicalLocation>>,
	): KSerializer<out AbstractFilter<MedicalLocation>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			MedicalLocationByPostCodeFilter::class -> MedicalLocationByPostCodeFilter.serializer()
			AllMedicalLocationsFilter::class -> AllMedicalLocationsFilter.serializer()
			else -> null
		}
}

internal object MessageAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Message>>("${'$'}type", "AbstractFilter<Message>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Message>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"MessageByDataOwnerToAddressFilter" -> MessageByDataOwnerToAddressFilter.serializer()
			"MessageByDataOwnerTransportGuidSentDateFilter" ->
				MessageByDataOwnerTransportGuidSentDateFilter.serializer()
			"LatestMessageByHcPartyTransportGuidFilter" ->
				LatestMessageByHcPartyTransportGuidFilter.serializer()
			"MessageByInvoiceIdsFilter" -> MessageByInvoiceIdsFilter.serializer()
			"MessageByDataOwnerPatientSentDateFilter" -> MessageByDataOwnerPatientSentDateFilter.serializer()
			"MessageByParentIdsFilter" -> MessageByParentIdsFilter.serializer()
			"MessageByDataOwnerFromAddressFilter" -> MessageByDataOwnerFromAddressFilter.serializer()
			"MessageByHcPartyFilter" -> MessageByHcPartyFilter.serializer()
			"MessageByHcPartyTransportGuidReceivedFilter" ->
				MessageByHcPartyTransportGuidReceivedFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Message>>): KSerializer<out AbstractFilter<Message>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			MessageByDataOwnerToAddressFilter::class -> MessageByDataOwnerToAddressFilter.serializer()
			MessageByDataOwnerTransportGuidSentDateFilter::class ->
				MessageByDataOwnerTransportGuidSentDateFilter.serializer()
			LatestMessageByHcPartyTransportGuidFilter::class ->
				LatestMessageByHcPartyTransportGuidFilter.serializer()
			MessageByInvoiceIdsFilter::class -> MessageByInvoiceIdsFilter.serializer()
			MessageByDataOwnerPatientSentDateFilter::class ->
				MessageByDataOwnerPatientSentDateFilter.serializer()
			MessageByParentIdsFilter::class -> MessageByParentIdsFilter.serializer()
			MessageByDataOwnerFromAddressFilter::class -> MessageByDataOwnerFromAddressFilter.serializer()
			MessageByHcPartyFilter::class -> MessageByHcPartyFilter.serializer()
			MessageByHcPartyTransportGuidReceivedFilter::class ->
				MessageByHcPartyTransportGuidReceivedFilter.serializer()
			else -> null
		}
}

internal object PatientAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Patient>>("${'$'}type", "AbstractFilter<Patient>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Patient>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"PatientByHcPartyGenderEducationProfession" ->
				PatientByHcPartyGenderEducationProfession.serializer()
			"PatientByDataOwnerModifiedAfterFilter" -> PatientByDataOwnerModifiedAfterFilter.serializer()
			"PatientByHcPartyAndSsinsFilter" -> PatientByHcPartyAndSsinsFilter.serializer()
			"PatientByHcPartyAndExternalIdFilter" -> PatientByHcPartyAndExternalIdFilter.serializer()
			"PatientByHcPartyAndSsinFilter" -> PatientByHcPartyAndSsinFilter.serializer()
			"PatientByHcPartyFilter" -> PatientByHcPartyFilter.serializer()
			"PatientByHcPartyDateOfBirthBetweenFilter" ->
				PatientByHcPartyDateOfBirthBetweenFilter.serializer()
			"PatientByHcPartyAndAddressFilter" -> PatientByHcPartyAndAddressFilter.serializer()
			"PatientByHcPartyAndActiveFilter" -> PatientByHcPartyAndActiveFilter.serializer()
			"PatientByHcPartyAndIdentifiersFilter" -> PatientByHcPartyAndIdentifiersFilter.serializer()
			"PatientByIdsFilter" -> PatientByIdsFilter.serializer()
			"PatientByHcPartyAndTelecomFilter" -> PatientByHcPartyAndTelecomFilter.serializer()
			"PatientByHcPartyNameFilter" -> PatientByHcPartyNameFilter.serializer()
			"PatientByHcPartyDateOfBirthFilter" -> PatientByHcPartyDateOfBirthFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Patient>>): KSerializer<out AbstractFilter<Patient>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			PatientByHcPartyGenderEducationProfession::class ->
				PatientByHcPartyGenderEducationProfession.serializer()
			PatientByDataOwnerModifiedAfterFilter::class -> PatientByDataOwnerModifiedAfterFilter.serializer()
			PatientByHcPartyAndSsinsFilter::class -> PatientByHcPartyAndSsinsFilter.serializer()
			PatientByHcPartyAndExternalIdFilter::class -> PatientByHcPartyAndExternalIdFilter.serializer()
			PatientByHcPartyAndSsinFilter::class -> PatientByHcPartyAndSsinFilter.serializer()
			PatientByHcPartyFilter::class -> PatientByHcPartyFilter.serializer()
			PatientByHcPartyDateOfBirthBetweenFilter::class ->
				PatientByHcPartyDateOfBirthBetweenFilter.serializer()
			PatientByHcPartyAndAddressFilter::class -> PatientByHcPartyAndAddressFilter.serializer()
			PatientByHcPartyAndActiveFilter::class -> PatientByHcPartyAndActiveFilter.serializer()
			PatientByHcPartyAndIdentifiersFilter::class -> PatientByHcPartyAndIdentifiersFilter.serializer()
			PatientByIdsFilter::class -> PatientByIdsFilter.serializer()
			PatientByHcPartyAndTelecomFilter::class -> PatientByHcPartyAndTelecomFilter.serializer()
			PatientByHcPartyNameFilter::class -> PatientByHcPartyNameFilter.serializer()
			PatientByHcPartyDateOfBirthFilter::class -> PatientByHcPartyDateOfBirthFilter.serializer()
			else -> null
		}
}

internal object ServiceAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Service>>("${'$'}type", "AbstractFilter<Service>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Service>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ServiceByAssociationIdFilter" -> ServiceByAssociationIdFilter.serializer()
			"ServiceByHcPartyHealthElementIdsFilter" -> ServiceByHcPartyHealthElementIdsFilter.serializer()
			"ServiceByHcPartyFilter" -> ServiceByHcPartyFilter.serializer()
			"ServiceByIdsFilter" -> ServiceByIdsFilter.serializer()
			"ServiceByHcPartyTagCodeDateFilter" -> ServiceByHcPartyTagCodeDateFilter.serializer()
			"ServiceBySecretForeignKeys" -> ServiceBySecretForeignKeys.serializer()
			"ServiceByDataOwnerPatientDateFilter" -> ServiceByDataOwnerPatientDateFilter.serializer()
			"ServiceByQualifiedLinkFilter" -> ServiceByQualifiedLinkFilter.serializer()
			"ServiceByHcPartyIdentifiersFilter" -> ServiceByHcPartyIdentifiersFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Service>>): KSerializer<out AbstractFilter<Service>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ServiceByAssociationIdFilter::class -> ServiceByAssociationIdFilter.serializer()
			ServiceByHcPartyHealthElementIdsFilter::class ->
				ServiceByHcPartyHealthElementIdsFilter.serializer()
			ServiceByHcPartyFilter::class -> ServiceByHcPartyFilter.serializer()
			ServiceByIdsFilter::class -> ServiceByIdsFilter.serializer()
			ServiceByHcPartyTagCodeDateFilter::class -> ServiceByHcPartyTagCodeDateFilter.serializer()
			ServiceBySecretForeignKeys::class -> ServiceBySecretForeignKeys.serializer()
			ServiceByDataOwnerPatientDateFilter::class -> ServiceByDataOwnerPatientDateFilter.serializer()
			ServiceByQualifiedLinkFilter::class -> ServiceByQualifiedLinkFilter.serializer()
			ServiceByHcPartyIdentifiersFilter::class -> ServiceByHcPartyIdentifiersFilter.serializer()
			else -> null
		}
}

internal object TimeTableAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<TimeTable>>(
		"${'$'}type",
		"AbstractFilter<TimeTable>",
	) {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<TimeTable>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"TimeTableByPeriodAndAgendaIdFilter" -> TimeTableByPeriodAndAgendaIdFilter.serializer()
			"TimeTableByAgendaIdFilter" -> TimeTableByAgendaIdFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<TimeTable>>): KSerializer<out AbstractFilter<TimeTable>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			TimeTableByPeriodAndAgendaIdFilter::class -> TimeTableByPeriodAndAgendaIdFilter.serializer()
			TimeTableByAgendaIdFilter::class -> TimeTableByAgendaIdFilter.serializer()
			else -> null
		}
}

internal object TopicAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Topic>>("${'$'}type", "AbstractFilter<Topic>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Topic>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"TopicByHcPartyFilter" -> TopicByHcPartyFilter.serializer()
			"TopicByParticipantFilter" -> TopicByParticipantFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Topic>>): KSerializer<out AbstractFilter<Topic>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			TopicByHcPartyFilter::class -> TopicByHcPartyFilter.serializer()
			TopicByParticipantFilter::class -> TopicByParticipantFilter.serializer()
			else -> null
		}
}

internal object UserAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<User>>("${'$'}type", "AbstractFilter<User>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<User>>? =
		when (serialName) {
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"UserByHealthcarePartyIdFilter" -> UserByHealthcarePartyIdFilter.serializer()
			"UserByNameEmailPhoneFilter" -> UserByNameEmailPhoneFilter.serializer()
			"AllUsersFilter" -> AllUsersFilter.serializer()
			"UsersByPatientIdFilter" -> UsersByPatientIdFilter.serializer()
			"UserByIdsFilter" -> UserByIdsFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<User>>): KSerializer<out AbstractFilter<User>>? =
		when (kclass) {
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			UserByHealthcarePartyIdFilter::class -> UserByHealthcarePartyIdFilter.serializer()
			UserByNameEmailPhoneFilter::class -> UserByNameEmailPhoneFilter.serializer()
			AllUsersFilter::class -> AllUsersFilter.serializer()
			UsersByPatientIdFilter::class -> UsersByPatientIdFilter.serializer()
			UserByIdsFilter::class -> UserByIdsFilter.serializer()
			else -> null
		}
}
