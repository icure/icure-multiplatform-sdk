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
import com.icure.cardinal.sdk.model.filter.calendarItem.CalendarItemByDataOwnerUpdatedAfter
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
			"UnionFilter" -> UnionFilterSerializer(this as KSerializer<AbstractFilter<Identifiable<String>>>)
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
			UnionFilter::class ->
				UnionFilterSerializer(
					this as
						KSerializer<AbstractFilter<Identifiable<String>>>,
				)
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
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"AccessLogByUserIdUserTypeDateFilter" -> AccessLogByUserIdUserTypeDateFilter.serializer()
			"AccessLogByDataOwnerPatientDateFilter" -> AccessLogByDataOwnerPatientDateFilter.serializer()
			"AccessLogByDateFilter" -> AccessLogByDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<AccessLog>>): KSerializer<out AbstractFilter<AccessLog>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			AccessLogByUserIdUserTypeDateFilter::class -> AccessLogByUserIdUserTypeDateFilter.serializer()
			AccessLogByDataOwnerPatientDateFilter::class -> AccessLogByDataOwnerPatientDateFilter.serializer()
			AccessLogByDateFilter::class -> AccessLogByDateFilter.serializer()
			else -> null
		}
}

internal object AgendaAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Agenda>>("${'$'}type", "AbstractFilter<Agenda>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Agenda>>? =
		when (serialName) {
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"AgendaReadableByUserIdFilter" -> AgendaReadableByUserIdFilter.serializer()
			"AgendaByUserIdFilter" -> AgendaByUserIdFilter.serializer()
			"AllAgendasFilter" -> AllAgendasFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Agenda>>): KSerializer<out AbstractFilter<Agenda>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			AgendaReadableByUserIdFilter::class -> AgendaReadableByUserIdFilter.serializer()
			AgendaByUserIdFilter::class -> AgendaByUserIdFilter.serializer()
			AllAgendasFilter::class -> AllAgendasFilter.serializer()
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
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"CalendarItemByPeriodAndDataOwnerIdFilter" ->
				CalendarItemByPeriodAndDataOwnerIdFilter.serializer()
			"CalendarItemByPeriodAndAgendaIdFilter" -> CalendarItemByPeriodAndAgendaIdFilter.serializer()
			"CalendarItemByRecurrenceIdFilter" -> CalendarItemByRecurrenceIdFilter.serializer()
			"CalendarItemByDataOwnerUpdatedAfter" -> CalendarItemByDataOwnerUpdatedAfter.serializer()
			"CalendarItemByDataOwnerPatientStartTimeFilter" ->
				CalendarItemByDataOwnerPatientStartTimeFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<CalendarItem>>): KSerializer<out AbstractFilter<CalendarItem>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			CalendarItemByPeriodAndDataOwnerIdFilter::class ->
				CalendarItemByPeriodAndDataOwnerIdFilter.serializer()
			CalendarItemByPeriodAndAgendaIdFilter::class -> CalendarItemByPeriodAndAgendaIdFilter.serializer()
			CalendarItemByRecurrenceIdFilter::class -> CalendarItemByRecurrenceIdFilter.serializer()
			CalendarItemByDataOwnerUpdatedAfter::class -> CalendarItemByDataOwnerUpdatedAfter.serializer()
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
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"ClassificationByDataOwnerPatientCreatedDateFilter" ->
				ClassificationByDataOwnerPatientCreatedDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Classification>>): KSerializer<out AbstractFilter<Classification>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ClassificationByDataOwnerPatientCreatedDateFilter::class ->
				ClassificationByDataOwnerPatientCreatedDateFilter.serializer()
			else -> null
		}
}

internal object CodeAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Code>>("${'$'}type", "AbstractFilter<Code>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Code>>? =
		when (serialName) {
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"CodeByIdsFilter" -> CodeByIdsFilter.serializer()
			"CodeIdsByTypeCodeVersionIntervalFilter" -> CodeIdsByTypeCodeVersionIntervalFilter.serializer()
			"AllCodesFilter" -> AllCodesFilter.serializer()
			"CodeByQualifiedLinkFilter" -> CodeByQualifiedLinkFilter.serializer()
			"CodeByRegionTypesLanguageLabelVersionFilters" ->
				CodeByRegionTypesLanguageLabelVersionFilters.serializer()
			"CodeByRegionTypeCodeVersionFilters" -> CodeByRegionTypeCodeVersionFilters.serializer()
			"CodeByRegionTypeLabelLanguageFilter" -> CodeByRegionTypeLabelLanguageFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Code>>): KSerializer<out AbstractFilter<Code>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			CodeByIdsFilter::class -> CodeByIdsFilter.serializer()
			CodeIdsByTypeCodeVersionIntervalFilter::class ->
				CodeIdsByTypeCodeVersionIntervalFilter.serializer()
			AllCodesFilter::class -> AllCodesFilter.serializer()
			CodeByQualifiedLinkFilter::class -> CodeByQualifiedLinkFilter.serializer()
			CodeByRegionTypesLanguageLabelVersionFilters::class ->
				CodeByRegionTypesLanguageLabelVersionFilters.serializer()
			CodeByRegionTypeCodeVersionFilters::class -> CodeByRegionTypeCodeVersionFilters.serializer()
			CodeByRegionTypeLabelLanguageFilter::class -> CodeByRegionTypeLabelLanguageFilter.serializer()
			else -> null
		}
}

internal object ContactAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Contact>>("${'$'}type", "AbstractFilter<Contact>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Contact>>? =
		when (serialName) {
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"ContactByDataOwnerServiceTagFilter" -> ContactByDataOwnerServiceTagFilter.serializer()
			"ContactByDataOwnerOpeningDateFilter" -> ContactByDataOwnerOpeningDateFilter.serializer()
			"ContactByHcPartyFilter" -> ContactByHcPartyFilter.serializer()
			"ContactByExternalIdFilter" -> ContactByExternalIdFilter.serializer()
			"ContactByServiceIdsFilter" -> ContactByServiceIdsFilter.serializer()
			"ContactByHcPartyPatientTagCodeDateFilter" ->
				ContactByHcPartyPatientTagCodeDateFilter.serializer()
			"ContactByDataOwnerServiceCodeFilter" -> ContactByDataOwnerServiceCodeFilter.serializer()
			"ContactByDataOwnerFormIdsFilter" -> ContactByDataOwnerFormIdsFilter.serializer()
			"ContactByDataOwnerPatientOpeningDateFilter" ->
				ContactByDataOwnerPatientOpeningDateFilter.serializer()
			"ContactByHcPartyIdentifiersFilter" -> ContactByHcPartyIdentifiersFilter.serializer()
			"ContactByHcPartyTagCodeDateFilter" -> ContactByHcPartyTagCodeDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Contact>>): KSerializer<out AbstractFilter<Contact>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ContactByDataOwnerServiceTagFilter::class -> ContactByDataOwnerServiceTagFilter.serializer()
			ContactByDataOwnerOpeningDateFilter::class -> ContactByDataOwnerOpeningDateFilter.serializer()
			ContactByHcPartyFilter::class -> ContactByHcPartyFilter.serializer()
			ContactByExternalIdFilter::class -> ContactByExternalIdFilter.serializer()
			ContactByServiceIdsFilter::class -> ContactByServiceIdsFilter.serializer()
			ContactByHcPartyPatientTagCodeDateFilter::class ->
				ContactByHcPartyPatientTagCodeDateFilter.serializer()
			ContactByDataOwnerServiceCodeFilter::class -> ContactByDataOwnerServiceCodeFilter.serializer()
			ContactByDataOwnerFormIdsFilter::class -> ContactByDataOwnerFormIdsFilter.serializer()
			ContactByDataOwnerPatientOpeningDateFilter::class ->
				ContactByDataOwnerPatientOpeningDateFilter.serializer()
			ContactByHcPartyIdentifiersFilter::class -> ContactByHcPartyIdentifiersFilter.serializer()
			ContactByHcPartyTagCodeDateFilter::class -> ContactByHcPartyTagCodeDateFilter.serializer()
			else -> null
		}
}

internal object DeviceAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Device>>("${'$'}type", "AbstractFilter<Device>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Device>>? =
		when (serialName) {
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"DeviceByIdsFilter" -> DeviceByIdsFilter.serializer()
			"AllDevicesFilter" -> AllDevicesFilter.serializer()
			"DeviceByHcPartyFilter" -> DeviceByHcPartyFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Device>>): KSerializer<out AbstractFilter<Device>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			DeviceByIdsFilter::class -> DeviceByIdsFilter.serializer()
			AllDevicesFilter::class -> AllDevicesFilter.serializer()
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
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"DocumentByTypeDataOwnerPatientFilter" -> DocumentByTypeDataOwnerPatientFilter.serializer()
			"DocumentByDataOwnerPatientDateFilter" -> DocumentByDataOwnerPatientDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Document>>): KSerializer<out AbstractFilter<Document>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			DocumentByTypeDataOwnerPatientFilter::class -> DocumentByTypeDataOwnerPatientFilter.serializer()
			DocumentByDataOwnerPatientDateFilter::class -> DocumentByDataOwnerPatientDateFilter.serializer()
			else -> null
		}
}

internal object FormAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Form>>("${'$'}type", "AbstractFilter<Form>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Form>>? =
		when (serialName) {
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"FormByDataOwnerParentIdFilter" -> FormByDataOwnerParentIdFilter.serializer()
			"FormByUniqueUuidFilter" -> FormByUniqueUuidFilter.serializer()
			"FormByLogicalUuidFilter" -> FormByLogicalUuidFilter.serializer()
			"FormByDataOwnerPatientOpeningDateFilter" -> FormByDataOwnerPatientOpeningDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Form>>): KSerializer<out AbstractFilter<Form>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			FormByDataOwnerParentIdFilter::class -> FormByDataOwnerParentIdFilter.serializer()
			FormByUniqueUuidFilter::class -> FormByUniqueUuidFilter.serializer()
			FormByLogicalUuidFilter::class -> FormByLogicalUuidFilter.serializer()
			FormByDataOwnerPatientOpeningDateFilter::class ->
				FormByDataOwnerPatientOpeningDateFilter.serializer()
			else -> null
		}
}

internal object GroupAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Group>>("${'$'}type", "AbstractFilter<Group>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Group>>? =
		when (serialName) {
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"GroupWithContentFilter" -> GroupWithContentFilter.serializer()
			"AllGroupsFilter" -> AllGroupsFilter.serializer()
			"GroupBySuperGroupFilter" -> GroupBySuperGroupFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Group>>): KSerializer<out AbstractFilter<Group>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			GroupWithContentFilter::class -> GroupWithContentFilter.serializer()
			AllGroupsFilter::class -> AllGroupsFilter.serializer()
			GroupBySuperGroupFilter::class -> GroupBySuperGroupFilter.serializer()
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
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"HealthElementByHcPartyIdentifiersFilter" -> HealthElementByHcPartyIdentifiersFilter.serializer()
			"HealthElementByHcPartyStatusFilter" -> HealthElementByHcPartyStatusFilter.serializer()
			"HealthElementByHcPartyTagCodeFilter" -> HealthElementByHcPartyTagCodeFilter.serializer()
			"HealthElementByIdsFilter" -> HealthElementByIdsFilter.serializer()
			"HealthElementByHcPartyFilter" -> HealthElementByHcPartyFilter.serializer()
			"HealthElementByDataOwnerPatientOpeningDate" ->
				HealthElementByDataOwnerPatientOpeningDate.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<HealthElement>>): KSerializer<out AbstractFilter<HealthElement>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			HealthElementByHcPartyIdentifiersFilter::class ->
				HealthElementByHcPartyIdentifiersFilter.serializer()
			HealthElementByHcPartyStatusFilter::class -> HealthElementByHcPartyStatusFilter.serializer()
			HealthElementByHcPartyTagCodeFilter::class -> HealthElementByHcPartyTagCodeFilter.serializer()
			HealthElementByIdsFilter::class -> HealthElementByIdsFilter.serializer()
			HealthElementByHcPartyFilter::class -> HealthElementByHcPartyFilter.serializer()
			HealthElementByDataOwnerPatientOpeningDate::class ->
				HealthElementByDataOwnerPatientOpeningDate.serializer()
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
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"HealthcarePartyByIdentifiersFilter" -> HealthcarePartyByIdentifiersFilter.serializer()
			"HealthcarePartyByTypeSpecialtyPostCodeFilter" ->
				HealthcarePartyByTypeSpecialtyPostCodeFilter.serializer()
			"HealthcarePartyByParentIdFilter" -> HealthcarePartyByParentIdFilter.serializer()
			"AllHealthcarePartiesFilter" -> AllHealthcarePartiesFilter.serializer()
			"HealthcarePartyByIdsFilter" -> HealthcarePartyByIdsFilter.serializer()
			"HealthcarePartyByNameFilter" -> HealthcarePartyByNameFilter.serializer()
			"HealthcarePartyByTagCodeFilter" -> HealthcarePartyByTagCodeFilter.serializer()
			"HealthcarePartyByNationalIdentifierFilter" ->
				HealthcarePartyByNationalIdentifierFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(
		kclass: KClass<out AbstractFilter<HealthcareParty>>,
	): KSerializer<out AbstractFilter<HealthcareParty>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			HealthcarePartyByIdentifiersFilter::class -> HealthcarePartyByIdentifiersFilter.serializer()
			HealthcarePartyByTypeSpecialtyPostCodeFilter::class ->
				HealthcarePartyByTypeSpecialtyPostCodeFilter.serializer()
			HealthcarePartyByParentIdFilter::class -> HealthcarePartyByParentIdFilter.serializer()
			AllHealthcarePartiesFilter::class -> AllHealthcarePartiesFilter.serializer()
			HealthcarePartyByIdsFilter::class -> HealthcarePartyByIdsFilter.serializer()
			HealthcarePartyByNameFilter::class -> HealthcarePartyByNameFilter.serializer()
			HealthcarePartyByTagCodeFilter::class -> HealthcarePartyByTagCodeFilter.serializer()
			HealthcarePartyByNationalIdentifierFilter::class ->
				HealthcarePartyByNationalIdentifierFilter.serializer()
			else -> null
		}
}

internal object InvoiceAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Invoice>>("${'$'}type", "AbstractFilter<Invoice>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Invoice>>? =
		when (serialName) {
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"InvoiceByHcPartyCodeDateFilter" -> InvoiceByHcPartyCodeDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Invoice>>): KSerializer<out AbstractFilter<Invoice>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
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
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"MaintenanceTaskByHcPartyAndTypeFilter" -> MaintenanceTaskByHcPartyAndTypeFilter.serializer()
			"MaintenanceTaskByHcPartyAndIdentifiersFilter" ->
				MaintenanceTaskByHcPartyAndIdentifiersFilter.serializer()
			"MaintenanceTaskByIdsFilter" -> MaintenanceTaskByIdsFilter.serializer()
			"MaintenanceTaskAfterDateFilter" -> MaintenanceTaskAfterDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(
		kclass: KClass<out AbstractFilter<MaintenanceTask>>,
	): KSerializer<out AbstractFilter<MaintenanceTask>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			MaintenanceTaskByHcPartyAndTypeFilter::class -> MaintenanceTaskByHcPartyAndTypeFilter.serializer()
			MaintenanceTaskByHcPartyAndIdentifiersFilter::class ->
				MaintenanceTaskByHcPartyAndIdentifiersFilter.serializer()
			MaintenanceTaskByIdsFilter::class -> MaintenanceTaskByIdsFilter.serializer()
			MaintenanceTaskAfterDateFilter::class -> MaintenanceTaskAfterDateFilter.serializer()
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
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"MedicalLocationByPostCodeFilter" -> MedicalLocationByPostCodeFilter.serializer()
			"AllMedicalLocationsFilter" -> AllMedicalLocationsFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(
		kclass: KClass<out AbstractFilter<MedicalLocation>>,
	): KSerializer<out AbstractFilter<MedicalLocation>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			MedicalLocationByPostCodeFilter::class -> MedicalLocationByPostCodeFilter.serializer()
			AllMedicalLocationsFilter::class -> AllMedicalLocationsFilter.serializer()
			else -> null
		}
}

internal object MessageAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Message>>("${'$'}type", "AbstractFilter<Message>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Message>>? =
		when (serialName) {
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"MessageByHcPartyFilter" -> MessageByHcPartyFilter.serializer()
			"MessageByDataOwnerTransportGuidSentDateFilter" ->
				MessageByDataOwnerTransportGuidSentDateFilter.serializer()
			"MessageByInvoiceIdsFilter" -> MessageByInvoiceIdsFilter.serializer()
			"MessageByDataOwnerFromAddressFilter" -> MessageByDataOwnerFromAddressFilter.serializer()
			"MessageByParentIdsFilter" -> MessageByParentIdsFilter.serializer()
			"MessageByDataOwnerToAddressFilter" -> MessageByDataOwnerToAddressFilter.serializer()
			"MessageByHcPartyTransportGuidReceivedFilter" ->
				MessageByHcPartyTransportGuidReceivedFilter.serializer()
			"MessageByDataOwnerPatientSentDateFilter" -> MessageByDataOwnerPatientSentDateFilter.serializer()
			"LatestMessageByHcPartyTransportGuidFilter" ->
				LatestMessageByHcPartyTransportGuidFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Message>>): KSerializer<out AbstractFilter<Message>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			MessageByHcPartyFilter::class -> MessageByHcPartyFilter.serializer()
			MessageByDataOwnerTransportGuidSentDateFilter::class ->
				MessageByDataOwnerTransportGuidSentDateFilter.serializer()
			MessageByInvoiceIdsFilter::class -> MessageByInvoiceIdsFilter.serializer()
			MessageByDataOwnerFromAddressFilter::class -> MessageByDataOwnerFromAddressFilter.serializer()
			MessageByParentIdsFilter::class -> MessageByParentIdsFilter.serializer()
			MessageByDataOwnerToAddressFilter::class -> MessageByDataOwnerToAddressFilter.serializer()
			MessageByHcPartyTransportGuidReceivedFilter::class ->
				MessageByHcPartyTransportGuidReceivedFilter.serializer()
			MessageByDataOwnerPatientSentDateFilter::class ->
				MessageByDataOwnerPatientSentDateFilter.serializer()
			LatestMessageByHcPartyTransportGuidFilter::class ->
				LatestMessageByHcPartyTransportGuidFilter.serializer()
			else -> null
		}
}

internal object PatientAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Patient>>("${'$'}type", "AbstractFilter<Patient>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Patient>>? =
		when (serialName) {
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"PatientByHcPartyNameFilter" -> PatientByHcPartyNameFilter.serializer()
			"PatientByHcPartyDateOfBirthFilter" -> PatientByHcPartyDateOfBirthFilter.serializer()
			"PatientByHcPartyAndSsinsFilter" -> PatientByHcPartyAndSsinsFilter.serializer()
			"PatientByHcPartyDateOfBirthBetweenFilter" ->
				PatientByHcPartyDateOfBirthBetweenFilter.serializer()
			"PatientByHcPartyAndExternalIdFilter" -> PatientByHcPartyAndExternalIdFilter.serializer()
			"PatientByIdsFilter" -> PatientByIdsFilter.serializer()
			"PatientByHcPartyAndIdentifiersFilter" -> PatientByHcPartyAndIdentifiersFilter.serializer()
			"PatientByHcPartyAndAddressFilter" -> PatientByHcPartyAndAddressFilter.serializer()
			"PatientByHcPartyGenderEducationProfession" ->
				PatientByHcPartyGenderEducationProfession.serializer()
			"PatientByHcPartyAndTelecomFilter" -> PatientByHcPartyAndTelecomFilter.serializer()
			"PatientByHcPartyAndActiveFilter" -> PatientByHcPartyAndActiveFilter.serializer()
			"PatientByHcPartyAndSsinFilter" -> PatientByHcPartyAndSsinFilter.serializer()
			"PatientByDataOwnerModifiedAfterFilter" -> PatientByDataOwnerModifiedAfterFilter.serializer()
			"PatientByHcPartyFilter" -> PatientByHcPartyFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Patient>>): KSerializer<out AbstractFilter<Patient>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			PatientByHcPartyNameFilter::class -> PatientByHcPartyNameFilter.serializer()
			PatientByHcPartyDateOfBirthFilter::class -> PatientByHcPartyDateOfBirthFilter.serializer()
			PatientByHcPartyAndSsinsFilter::class -> PatientByHcPartyAndSsinsFilter.serializer()
			PatientByHcPartyDateOfBirthBetweenFilter::class ->
				PatientByHcPartyDateOfBirthBetweenFilter.serializer()
			PatientByHcPartyAndExternalIdFilter::class -> PatientByHcPartyAndExternalIdFilter.serializer()
			PatientByIdsFilter::class -> PatientByIdsFilter.serializer()
			PatientByHcPartyAndIdentifiersFilter::class -> PatientByHcPartyAndIdentifiersFilter.serializer()
			PatientByHcPartyAndAddressFilter::class -> PatientByHcPartyAndAddressFilter.serializer()
			PatientByHcPartyGenderEducationProfession::class ->
				PatientByHcPartyGenderEducationProfession.serializer()
			PatientByHcPartyAndTelecomFilter::class -> PatientByHcPartyAndTelecomFilter.serializer()
			PatientByHcPartyAndActiveFilter::class -> PatientByHcPartyAndActiveFilter.serializer()
			PatientByHcPartyAndSsinFilter::class -> PatientByHcPartyAndSsinFilter.serializer()
			PatientByDataOwnerModifiedAfterFilter::class -> PatientByDataOwnerModifiedAfterFilter.serializer()
			PatientByHcPartyFilter::class -> PatientByHcPartyFilter.serializer()
			else -> null
		}
}

internal object ServiceAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Service>>("${'$'}type", "AbstractFilter<Service>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Service>>? =
		when (serialName) {
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"ServiceByHcPartyHealthElementIdsFilter" -> ServiceByHcPartyHealthElementIdsFilter.serializer()
			"ServiceByAssociationIdFilter" -> ServiceByAssociationIdFilter.serializer()
			"ServiceByDataOwnerPatientDateFilter" -> ServiceByDataOwnerPatientDateFilter.serializer()
			"ServiceByHcPartyIdentifiersFilter" -> ServiceByHcPartyIdentifiersFilter.serializer()
			"ServiceByHcPartyTagCodeDateFilter" -> ServiceByHcPartyTagCodeDateFilter.serializer()
			"ServiceByHcPartyFilter" -> ServiceByHcPartyFilter.serializer()
			"ServiceByIdsFilter" -> ServiceByIdsFilter.serializer()
			"ServiceByQualifiedLinkFilter" -> ServiceByQualifiedLinkFilter.serializer()
			"ServiceBySecretForeignKeys" -> ServiceBySecretForeignKeys.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Service>>): KSerializer<out AbstractFilter<Service>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			ServiceByHcPartyHealthElementIdsFilter::class ->
				ServiceByHcPartyHealthElementIdsFilter.serializer()
			ServiceByAssociationIdFilter::class -> ServiceByAssociationIdFilter.serializer()
			ServiceByDataOwnerPatientDateFilter::class -> ServiceByDataOwnerPatientDateFilter.serializer()
			ServiceByHcPartyIdentifiersFilter::class -> ServiceByHcPartyIdentifiersFilter.serializer()
			ServiceByHcPartyTagCodeDateFilter::class -> ServiceByHcPartyTagCodeDateFilter.serializer()
			ServiceByHcPartyFilter::class -> ServiceByHcPartyFilter.serializer()
			ServiceByIdsFilter::class -> ServiceByIdsFilter.serializer()
			ServiceByQualifiedLinkFilter::class -> ServiceByQualifiedLinkFilter.serializer()
			ServiceBySecretForeignKeys::class -> ServiceBySecretForeignKeys.serializer()
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
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"TimeTableByPeriodAndAgendaIdFilter" -> TimeTableByPeriodAndAgendaIdFilter.serializer()
			"TimeTableByAgendaIdFilter" -> TimeTableByAgendaIdFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<TimeTable>>): KSerializer<out AbstractFilter<TimeTable>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			TimeTableByPeriodAndAgendaIdFilter::class -> TimeTableByPeriodAndAgendaIdFilter.serializer()
			TimeTableByAgendaIdFilter::class -> TimeTableByAgendaIdFilter.serializer()
			else -> null
		}
}

internal object TopicAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Topic>>("${'$'}type", "AbstractFilter<Topic>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Topic>>? =
		when (serialName) {
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"TopicByParticipantFilter" -> TopicByParticipantFilter.serializer()
			"TopicByHcPartyFilter" -> TopicByHcPartyFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Topic>>): KSerializer<out AbstractFilter<Topic>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			TopicByParticipantFilter::class -> TopicByParticipantFilter.serializer()
			TopicByHcPartyFilter::class -> TopicByHcPartyFilter.serializer()
			else -> null
		}
}

internal object UserAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<User>>("${'$'}type", "AbstractFilter<User>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<User>>? =
		when (serialName) {
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UserByNameEmailPhoneFilter" -> UserByNameEmailPhoneFilter.serializer()
			"UserByHealthcarePartyIdFilter" -> UserByHealthcarePartyIdFilter.serializer()
			"UserByIdsFilter" -> UserByIdsFilter.serializer()
			"AllUsersFilter" -> AllUsersFilter.serializer()
			"UsersByPatientIdFilter" -> UsersByPatientIdFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<User>>): KSerializer<out AbstractFilter<User>>? =
		when (kclass) {
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UserByNameEmailPhoneFilter::class -> UserByNameEmailPhoneFilter.serializer()
			UserByHealthcarePartyIdFilter::class -> UserByHealthcarePartyIdFilter.serializer()
			UserByIdsFilter::class -> UserByIdsFilter.serializer()
			AllUsersFilter::class -> AllUsersFilter.serializer()
			UsersByPatientIdFilter::class -> UsersByPatientIdFilter.serializer()
			else -> null
		}
}
