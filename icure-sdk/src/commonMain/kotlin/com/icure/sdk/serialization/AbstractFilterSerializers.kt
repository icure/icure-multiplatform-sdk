// This file is auto-generated
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
import com.icure.sdk.model.Group
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
import com.icure.sdk.model.filter.agenda.AllAgendasFilter
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
import com.icure.sdk.model.filter.group.AllGroupsFilter
import com.icure.sdk.model.filter.group.GroupBySuperGroupFilter
import com.icure.sdk.model.filter.group.GroupWithContentFilter
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
import kotlinx.serialization.KSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.reflect.KClass

internal object AnyAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<*>>("${'$'}type", "AbstractFilter<Identifiable>") {
	@Suppress("UNCHECKED_CAST")
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<*>>? =
		when (serialName) {
			"IntersectionFilter" ->
				IntersectionFilterSerializer(
					this as
						KSerializer<AbstractFilter<Identifiable<String>>>,
				)
			"UnionFilter" -> UnionFilterSerializer(this as KSerializer<AbstractFilter<Identifiable<String>>>)
			"ComplementFilter" ->
				ComplementFilterSerializer(
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
			ComplementFilter::class ->
				ComplementFilterSerializer(
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
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"AccessLogByDateFilter" -> AccessLogByDateFilter.serializer()
			"AccessLogByUserIdUserTypeDateFilter" -> AccessLogByUserIdUserTypeDateFilter.serializer()
			"AccessLogByDataOwnerPatientDateFilter" -> AccessLogByDataOwnerPatientDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<AccessLog>>): KSerializer<out AbstractFilter<AccessLog>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
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
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"AgendaReadableByUserIdFilter" -> AgendaReadableByUserIdFilter.serializer()
			"AgendaByUserIdFilter" -> AgendaByUserIdFilter.serializer()
			"AllAgendasFilter" -> AllAgendasFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Agenda>>): KSerializer<out AbstractFilter<Agenda>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
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
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"CalendarItemByPeriodAndAgendaIdFilter" -> CalendarItemByPeriodAndAgendaIdFilter.serializer()
			"CalendarItemByRecurrenceIdFilter" -> CalendarItemByRecurrenceIdFilter.serializer()
			"CalendarItemByDataOwnerPatientStartTimeFilter" ->
				CalendarItemByDataOwnerPatientStartTimeFilter.serializer()
			"CalendarItemByPeriodAndDataOwnerIdFilter" ->
				CalendarItemByPeriodAndDataOwnerIdFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<CalendarItem>>): KSerializer<out AbstractFilter<CalendarItem>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			CalendarItemByPeriodAndAgendaIdFilter::class -> CalendarItemByPeriodAndAgendaIdFilter.serializer()
			CalendarItemByRecurrenceIdFilter::class -> CalendarItemByRecurrenceIdFilter.serializer()
			CalendarItemByDataOwnerPatientStartTimeFilter::class ->
				CalendarItemByDataOwnerPatientStartTimeFilter.serializer()
			CalendarItemByPeriodAndDataOwnerIdFilter::class ->
				CalendarItemByPeriodAndDataOwnerIdFilter.serializer()
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
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"ClassificationByDataOwnerPatientCreatedDateFilter" ->
				ClassificationByDataOwnerPatientCreatedDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Classification>>): KSerializer<out AbstractFilter<Classification>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			ClassificationByDataOwnerPatientCreatedDateFilter::class ->
				ClassificationByDataOwnerPatientCreatedDateFilter.serializer()
			else -> null
		}
}

internal object CodeAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Code>>("${'$'}type", "AbstractFilter<Code>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Code>>? =
		when (serialName) {
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"AllCodesFilter" -> AllCodesFilter.serializer()
			"CodeByRegionTypesLanguageLabelVersionFilters" ->
				CodeByRegionTypesLanguageLabelVersionFilters.serializer()
			"CodeByRegionTypeLabelLanguageFilter" -> CodeByRegionTypeLabelLanguageFilter.serializer()
			"CodeIdsByTypeCodeVersionIntervalFilter" -> CodeIdsByTypeCodeVersionIntervalFilter.serializer()
			"CodeByRegionTypeCodeVersionFilters" -> CodeByRegionTypeCodeVersionFilters.serializer()
			"CodeByQualifiedLinkFilter" -> CodeByQualifiedLinkFilter.serializer()
			"CodeByIdsFilter" -> CodeByIdsFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Code>>): KSerializer<out AbstractFilter<Code>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			AllCodesFilter::class -> AllCodesFilter.serializer()
			CodeByRegionTypesLanguageLabelVersionFilters::class ->
				CodeByRegionTypesLanguageLabelVersionFilters.serializer()
			CodeByRegionTypeLabelLanguageFilter::class -> CodeByRegionTypeLabelLanguageFilter.serializer()
			CodeIdsByTypeCodeVersionIntervalFilter::class ->
				CodeIdsByTypeCodeVersionIntervalFilter.serializer()
			CodeByRegionTypeCodeVersionFilters::class -> CodeByRegionTypeCodeVersionFilters.serializer()
			CodeByQualifiedLinkFilter::class -> CodeByQualifiedLinkFilter.serializer()
			CodeByIdsFilter::class -> CodeByIdsFilter.serializer()
			else -> null
		}
}

internal object ContactAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Contact>>("${'$'}type", "AbstractFilter<Contact>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Contact>>? =
		when (serialName) {
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"ContactByDataOwnerFormIdsFilter" -> ContactByDataOwnerFormIdsFilter.serializer()
			"ContactByExternalIdFilter" -> ContactByExternalIdFilter.serializer()
			"ContactByDataOwnerPatientOpeningDateFilter" ->
				ContactByDataOwnerPatientOpeningDateFilter.serializer()
			"ContactByHcPartyFilter" -> ContactByHcPartyFilter.serializer()
			"ContactByServiceIdsFilter" -> ContactByServiceIdsFilter.serializer()
			"ContactByHcPartyPatientTagCodeDateFilter" ->
				ContactByHcPartyPatientTagCodeDateFilter.serializer()
			"ContactByHcPartyTagCodeDateFilter" -> ContactByHcPartyTagCodeDateFilter.serializer()
			"ContactByHcPartyIdentifiersFilter" -> ContactByHcPartyIdentifiersFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Contact>>): KSerializer<out AbstractFilter<Contact>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			ContactByDataOwnerFormIdsFilter::class -> ContactByDataOwnerFormIdsFilter.serializer()
			ContactByExternalIdFilter::class -> ContactByExternalIdFilter.serializer()
			ContactByDataOwnerPatientOpeningDateFilter::class ->
				ContactByDataOwnerPatientOpeningDateFilter.serializer()
			ContactByHcPartyFilter::class -> ContactByHcPartyFilter.serializer()
			ContactByServiceIdsFilter::class -> ContactByServiceIdsFilter.serializer()
			ContactByHcPartyPatientTagCodeDateFilter::class ->
				ContactByHcPartyPatientTagCodeDateFilter.serializer()
			ContactByHcPartyTagCodeDateFilter::class -> ContactByHcPartyTagCodeDateFilter.serializer()
			ContactByHcPartyIdentifiersFilter::class -> ContactByHcPartyIdentifiersFilter.serializer()
			else -> null
		}
}

internal object DeviceAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Device>>("${'$'}type", "AbstractFilter<Device>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Device>>? =
		when (serialName) {
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"DeviceByHcPartyFilter" -> DeviceByHcPartyFilter.serializer()
			"DeviceByIdsFilter" -> DeviceByIdsFilter.serializer()
			"AllDevicesFilter" -> AllDevicesFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Device>>): KSerializer<out AbstractFilter<Device>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			DeviceByHcPartyFilter::class -> DeviceByHcPartyFilter.serializer()
			DeviceByIdsFilter::class -> DeviceByIdsFilter.serializer()
			AllDevicesFilter::class -> AllDevicesFilter.serializer()
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
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"DocumentByTypeDataOwnerPatientFilter" -> DocumentByTypeDataOwnerPatientFilter.serializer()
			"DocumentByDataOwnerPatientDateFilter" -> DocumentByDataOwnerPatientDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Document>>): KSerializer<out AbstractFilter<Document>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			DocumentByTypeDataOwnerPatientFilter::class -> DocumentByTypeDataOwnerPatientFilter.serializer()
			DocumentByDataOwnerPatientDateFilter::class -> DocumentByDataOwnerPatientDateFilter.serializer()
			else -> null
		}
}

internal object FormAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Form>>("${'$'}type", "AbstractFilter<Form>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Form>>? =
		when (serialName) {
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"FormByDataOwnerParentIdFilter" -> FormByDataOwnerParentIdFilter.serializer()
			"FormByDataOwnerPatientOpeningDateFilter" -> FormByDataOwnerPatientOpeningDateFilter.serializer()
			"FormByUniqueUuidFilter" -> FormByUniqueUuidFilter.serializer()
			"FormByLogicalUuidFilter" -> FormByLogicalUuidFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Form>>): KSerializer<out AbstractFilter<Form>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			FormByDataOwnerParentIdFilter::class -> FormByDataOwnerParentIdFilter.serializer()
			FormByDataOwnerPatientOpeningDateFilter::class ->
				FormByDataOwnerPatientOpeningDateFilter.serializer()
			FormByUniqueUuidFilter::class -> FormByUniqueUuidFilter.serializer()
			FormByLogicalUuidFilter::class -> FormByLogicalUuidFilter.serializer()
			else -> null
		}
}

internal object GroupAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Group>>("${'$'}type", "AbstractFilter<Group>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Group>>? =
		when (serialName) {
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"AllGroupsFilter" -> AllGroupsFilter.serializer()
			"GroupBySuperGroupFilter" -> GroupBySuperGroupFilter.serializer()
			"GroupWithContentFilter" -> GroupWithContentFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Group>>): KSerializer<out AbstractFilter<Group>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
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
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"HealthElementByDataOwnerPatientOpeningDate" ->
				HealthElementByDataOwnerPatientOpeningDate.serializer()
			"HealthElementByHcPartyIdentifiersFilter" -> HealthElementByHcPartyIdentifiersFilter.serializer()
			"HealthElementByHcPartyTagCodeFilter" -> HealthElementByHcPartyTagCodeFilter.serializer()
			"HealthElementByHcPartyStatusFilter" -> HealthElementByHcPartyStatusFilter.serializer()
			"HealthElementByHcPartyFilter" -> HealthElementByHcPartyFilter.serializer()
			"HealthElementByIdsFilter" -> HealthElementByIdsFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<HealthElement>>): KSerializer<out AbstractFilter<HealthElement>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			HealthElementByDataOwnerPatientOpeningDate::class ->
				HealthElementByDataOwnerPatientOpeningDate.serializer()
			HealthElementByHcPartyIdentifiersFilter::class ->
				HealthElementByHcPartyIdentifiersFilter.serializer()
			HealthElementByHcPartyTagCodeFilter::class -> HealthElementByHcPartyTagCodeFilter.serializer()
			HealthElementByHcPartyStatusFilter::class -> HealthElementByHcPartyStatusFilter.serializer()
			HealthElementByHcPartyFilter::class -> HealthElementByHcPartyFilter.serializer()
			HealthElementByIdsFilter::class -> HealthElementByIdsFilter.serializer()
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
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"HealthcarePartyByTagCodeFilter" -> HealthcarePartyByTagCodeFilter.serializer()
			"HealthcarePartyByIdentifiersFilter" -> HealthcarePartyByIdentifiersFilter.serializer()
			"HealthcarePartyByNationalIdentifierFilter" ->
				HealthcarePartyByNationalIdentifierFilter.serializer()
			"HealthcarePartyByParentIdFilter" -> HealthcarePartyByParentIdFilter.serializer()
			"HealthcarePartyByIdsFilter" -> HealthcarePartyByIdsFilter.serializer()
			"HealthcarePartyByTypeSpecialtyPostCodeFilter" ->
				HealthcarePartyByTypeSpecialtyPostCodeFilter.serializer()
			"HealthcarePartyByNameFilter" -> HealthcarePartyByNameFilter.serializer()
			"AllHealthcarePartiesFilter" -> AllHealthcarePartiesFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(
		kclass: KClass<out AbstractFilter<HealthcareParty>>,
	): KSerializer<out AbstractFilter<HealthcareParty>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			HealthcarePartyByTagCodeFilter::class -> HealthcarePartyByTagCodeFilter.serializer()
			HealthcarePartyByIdentifiersFilter::class -> HealthcarePartyByIdentifiersFilter.serializer()
			HealthcarePartyByNationalIdentifierFilter::class ->
				HealthcarePartyByNationalIdentifierFilter.serializer()
			HealthcarePartyByParentIdFilter::class -> HealthcarePartyByParentIdFilter.serializer()
			HealthcarePartyByIdsFilter::class -> HealthcarePartyByIdsFilter.serializer()
			HealthcarePartyByTypeSpecialtyPostCodeFilter::class ->
				HealthcarePartyByTypeSpecialtyPostCodeFilter.serializer()
			HealthcarePartyByNameFilter::class -> HealthcarePartyByNameFilter.serializer()
			AllHealthcarePartiesFilter::class -> AllHealthcarePartiesFilter.serializer()
			else -> null
		}
}

internal object InvoiceAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Invoice>>("${'$'}type", "AbstractFilter<Invoice>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Invoice>>? =
		when (serialName) {
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"InvoiceByHcPartyCodeDateFilter" -> InvoiceByHcPartyCodeDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Invoice>>): KSerializer<out AbstractFilter<Invoice>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
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
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"MaintenanceTaskAfterDateFilter" -> MaintenanceTaskAfterDateFilter.serializer()
			"MaintenanceTaskByHcPartyAndTypeFilter" -> MaintenanceTaskByHcPartyAndTypeFilter.serializer()
			"MaintenanceTaskByHcPartyAndIdentifiersFilter" ->
				MaintenanceTaskByHcPartyAndIdentifiersFilter.serializer()
			"MaintenanceTaskByIdsFilter" -> MaintenanceTaskByIdsFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(
		kclass: KClass<out AbstractFilter<MaintenanceTask>>,
	): KSerializer<out AbstractFilter<MaintenanceTask>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			MaintenanceTaskAfterDateFilter::class -> MaintenanceTaskAfterDateFilter.serializer()
			MaintenanceTaskByHcPartyAndTypeFilter::class -> MaintenanceTaskByHcPartyAndTypeFilter.serializer()
			MaintenanceTaskByHcPartyAndIdentifiersFilter::class ->
				MaintenanceTaskByHcPartyAndIdentifiersFilter.serializer()
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
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"MedicalLocationByPostCodeFilter" -> MedicalLocationByPostCodeFilter.serializer()
			"AllMedicalLocationsFilter" -> AllMedicalLocationsFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(
		kclass: KClass<out AbstractFilter<MedicalLocation>>,
	): KSerializer<out AbstractFilter<MedicalLocation>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			MedicalLocationByPostCodeFilter::class -> MedicalLocationByPostCodeFilter.serializer()
			AllMedicalLocationsFilter::class -> AllMedicalLocationsFilter.serializer()
			else -> null
		}
}

internal object MessageAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Message>>("${'$'}type", "AbstractFilter<Message>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Message>>? =
		when (serialName) {
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"MessageByDataOwnerToAddressFilter" -> MessageByDataOwnerToAddressFilter.serializer()
			"MessageByDataOwnerFromAddressFilter" -> MessageByDataOwnerFromAddressFilter.serializer()
			"MessageByHcPartyTransportGuidReceivedFilter" ->
				MessageByHcPartyTransportGuidReceivedFilter.serializer()
			"MessageByDataOwnerPatientSentDateFilter" -> MessageByDataOwnerPatientSentDateFilter.serializer()
			"MessageByParentIdsFilter" -> MessageByParentIdsFilter.serializer()
			"MessageByHcPartyFilter" -> MessageByHcPartyFilter.serializer()
			"LatestMessageByHcPartyTransportGuidFilter" ->
				LatestMessageByHcPartyTransportGuidFilter.serializer()
			"MessageByInvoiceIdsFilter" -> MessageByInvoiceIdsFilter.serializer()
			"MessageByDataOwnerTransportGuidSentDateFilter" ->
				MessageByDataOwnerTransportGuidSentDateFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Message>>): KSerializer<out AbstractFilter<Message>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			MessageByDataOwnerToAddressFilter::class -> MessageByDataOwnerToAddressFilter.serializer()
			MessageByDataOwnerFromAddressFilter::class -> MessageByDataOwnerFromAddressFilter.serializer()
			MessageByHcPartyTransportGuidReceivedFilter::class ->
				MessageByHcPartyTransportGuidReceivedFilter.serializer()
			MessageByDataOwnerPatientSentDateFilter::class ->
				MessageByDataOwnerPatientSentDateFilter.serializer()
			MessageByParentIdsFilter::class -> MessageByParentIdsFilter.serializer()
			MessageByHcPartyFilter::class -> MessageByHcPartyFilter.serializer()
			LatestMessageByHcPartyTransportGuidFilter::class ->
				LatestMessageByHcPartyTransportGuidFilter.serializer()
			MessageByInvoiceIdsFilter::class -> MessageByInvoiceIdsFilter.serializer()
			MessageByDataOwnerTransportGuidSentDateFilter::class ->
				MessageByDataOwnerTransportGuidSentDateFilter.serializer()
			else -> null
		}
}

internal object PatientAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Patient>>("${'$'}type", "AbstractFilter<Patient>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Patient>>? =
		when (serialName) {
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"PatientByHcPartyAndExternalIdFilter" -> PatientByHcPartyAndExternalIdFilter.serializer()
			"PatientByHcPartyFilter" -> PatientByHcPartyFilter.serializer()
			"PatientByHcPartyDateOfBirthBetweenFilter" ->
				PatientByHcPartyDateOfBirthBetweenFilter.serializer()
			"PatientByHcPartyAndActiveFilter" -> PatientByHcPartyAndActiveFilter.serializer()
			"PatientByHcPartyAndSsinsFilter" -> PatientByHcPartyAndSsinsFilter.serializer()
			"PatientByHcPartyAndSsinFilter" -> PatientByHcPartyAndSsinFilter.serializer()
			"PatientByHcPartyAndTelecomFilter" -> PatientByHcPartyAndTelecomFilter.serializer()
			"PatientByHcPartyDateOfBirthFilter" -> PatientByHcPartyDateOfBirthFilter.serializer()
			"PatientByHcPartyAndAddressFilter" -> PatientByHcPartyAndAddressFilter.serializer()
			"PatientByHcPartyGenderEducationProfession" ->
				PatientByHcPartyGenderEducationProfession.serializer()
			"PatientByIdsFilter" -> PatientByIdsFilter.serializer()
			"PatientByHcPartyNameFilter" -> PatientByHcPartyNameFilter.serializer()
			"PatientByHcPartyAndIdentifiersFilter" -> PatientByHcPartyAndIdentifiersFilter.serializer()
			"PatientByDataOwnerModifiedAfterFilter" -> PatientByDataOwnerModifiedAfterFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Patient>>): KSerializer<out AbstractFilter<Patient>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			PatientByHcPartyAndExternalIdFilter::class -> PatientByHcPartyAndExternalIdFilter.serializer()
			PatientByHcPartyFilter::class -> PatientByHcPartyFilter.serializer()
			PatientByHcPartyDateOfBirthBetweenFilter::class ->
				PatientByHcPartyDateOfBirthBetweenFilter.serializer()
			PatientByHcPartyAndActiveFilter::class -> PatientByHcPartyAndActiveFilter.serializer()
			PatientByHcPartyAndSsinsFilter::class -> PatientByHcPartyAndSsinsFilter.serializer()
			PatientByHcPartyAndSsinFilter::class -> PatientByHcPartyAndSsinFilter.serializer()
			PatientByHcPartyAndTelecomFilter::class -> PatientByHcPartyAndTelecomFilter.serializer()
			PatientByHcPartyDateOfBirthFilter::class -> PatientByHcPartyDateOfBirthFilter.serializer()
			PatientByHcPartyAndAddressFilter::class -> PatientByHcPartyAndAddressFilter.serializer()
			PatientByHcPartyGenderEducationProfession::class ->
				PatientByHcPartyGenderEducationProfession.serializer()
			PatientByIdsFilter::class -> PatientByIdsFilter.serializer()
			PatientByHcPartyNameFilter::class -> PatientByHcPartyNameFilter.serializer()
			PatientByHcPartyAndIdentifiersFilter::class -> PatientByHcPartyAndIdentifiersFilter.serializer()
			PatientByDataOwnerModifiedAfterFilter::class -> PatientByDataOwnerModifiedAfterFilter.serializer()
			else -> null
		}
}

internal object ServiceAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Service>>("${'$'}type", "AbstractFilter<Service>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Service>>? =
		when (serialName) {
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"ServiceByAssociationIdFilter" -> ServiceByAssociationIdFilter.serializer()
			"ServiceByHcPartyTagCodeDateFilter" -> ServiceByHcPartyTagCodeDateFilter.serializer()
			"ServiceByHcPartyIdentifiersFilter" -> ServiceByHcPartyIdentifiersFilter.serializer()
			"ServiceByIdsFilter" -> ServiceByIdsFilter.serializer()
			"ServiceByHcPartyFilter" -> ServiceByHcPartyFilter.serializer()
			"ServiceByHcPartyHealthElementIdsFilter" -> ServiceByHcPartyHealthElementIdsFilter.serializer()
			"ServiceBySecretForeignKeys" -> ServiceBySecretForeignKeys.serializer()
			"ServiceByQualifiedLinkFilter" -> ServiceByQualifiedLinkFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Service>>): KSerializer<out AbstractFilter<Service>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			ServiceByAssociationIdFilter::class -> ServiceByAssociationIdFilter.serializer()
			ServiceByHcPartyTagCodeDateFilter::class -> ServiceByHcPartyTagCodeDateFilter.serializer()
			ServiceByHcPartyIdentifiersFilter::class -> ServiceByHcPartyIdentifiersFilter.serializer()
			ServiceByIdsFilter::class -> ServiceByIdsFilter.serializer()
			ServiceByHcPartyFilter::class -> ServiceByHcPartyFilter.serializer()
			ServiceByHcPartyHealthElementIdsFilter::class ->
				ServiceByHcPartyHealthElementIdsFilter.serializer()
			ServiceBySecretForeignKeys::class -> ServiceBySecretForeignKeys.serializer()
			ServiceByQualifiedLinkFilter::class -> ServiceByQualifiedLinkFilter.serializer()
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
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"TimeTableByPeriodAndAgendaIdFilter" -> TimeTableByPeriodAndAgendaIdFilter.serializer()
			"TimeTableByAgendaIdFilter" -> TimeTableByAgendaIdFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<TimeTable>>): KSerializer<out AbstractFilter<TimeTable>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			TimeTableByPeriodAndAgendaIdFilter::class -> TimeTableByPeriodAndAgendaIdFilter.serializer()
			TimeTableByAgendaIdFilter::class -> TimeTableByAgendaIdFilter.serializer()
			else -> null
		}
}

internal object TopicAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<Topic>>("${'$'}type", "AbstractFilter<Topic>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<Topic>>? =
		when (serialName) {
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"TopicByHcPartyFilter" -> TopicByHcPartyFilter.serializer()
			"TopicByParticipantFilter" -> TopicByParticipantFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<Topic>>): KSerializer<out AbstractFilter<Topic>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			TopicByHcPartyFilter::class -> TopicByHcPartyFilter.serializer()
			TopicByParticipantFilter::class -> TopicByParticipantFilter.serializer()
			else -> null
		}
}

internal object UserAbstractFilterSerializer :
	CustomJsonPolymorphicSerializer<AbstractFilter<User>>("${'$'}type", "AbstractFilter<User>") {
	override fun getSerializerBySerialName(serialName: String): KSerializer<out AbstractFilter<User>>? =
		when (serialName) {
			"IntersectionFilter" -> IntersectionFilterSerializer(this)
			"UnionFilter" -> UnionFilterSerializer(this)
			"ComplementFilter" -> ComplementFilterSerializer(this)
			"AllUsersFilter" -> AllUsersFilter.serializer()
			"UserByHealthcarePartyIdFilter" -> UserByHealthcarePartyIdFilter.serializer()
			"UsersByPatientIdFilter" -> UsersByPatientIdFilter.serializer()
			"UserByNameEmailPhoneFilter" -> UserByNameEmailPhoneFilter.serializer()
			"UserByIdsFilter" -> UserByIdsFilter.serializer()
			else -> null
		}

	override fun getSerializerByClass(kclass: KClass<out AbstractFilter<User>>): KSerializer<out AbstractFilter<User>>? =
		when (kclass) {
			IntersectionFilter::class -> IntersectionFilterSerializer(this)
			UnionFilter::class -> UnionFilterSerializer(this)
			ComplementFilter::class -> ComplementFilterSerializer(this)
			AllUsersFilter::class -> AllUsersFilter.serializer()
			UserByHealthcarePartyIdFilter::class -> UserByHealthcarePartyIdFilter.serializer()
			UsersByPatientIdFilter::class -> UsersByPatientIdFilter.serializer()
			UserByNameEmailPhoneFilter::class -> UserByNameEmailPhoneFilter.serializer()
			UserByIdsFilter::class -> UserByIdsFilter.serializer()
			else -> null
		}
}
