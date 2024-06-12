package com.icure.sdk.js.model.filter

import com.icure.sdk.js.model.base.IdentifiableJs
import com.icure.sdk.js.model.filter.code.AllCodesFilterJs
import com.icure.sdk.js.model.filter.code.CodeByIdsFilterJs
import com.icure.sdk.js.model.filter.code.CodeByRegionTypeLabelLanguageFilterJs
import com.icure.sdk.js.model.filter.code.CodeIdsByTypeCodeVersionIntervalFilterJs
import com.icure.sdk.js.model.filter.code.allCodesFilter_fromJs
import com.icure.sdk.js.model.filter.code.allCodesFilter_toJs
import com.icure.sdk.js.model.filter.code.codeByIdsFilter_fromJs
import com.icure.sdk.js.model.filter.code.codeByIdsFilter_toJs
import com.icure.sdk.js.model.filter.code.codeByRegionTypeLabelLanguageFilter_fromJs
import com.icure.sdk.js.model.filter.code.codeByRegionTypeLabelLanguageFilter_toJs
import com.icure.sdk.js.model.filter.code.codeIdsByTypeCodeVersionIntervalFilter_fromJs
import com.icure.sdk.js.model.filter.code.codeIdsByTypeCodeVersionIntervalFilter_toJs
import com.icure.sdk.js.model.filter.contact.ContactByHcPartyFilterJs
import com.icure.sdk.js.model.filter.contact.ContactByHcPartyIdentifiersFilterJs
import com.icure.sdk.js.model.filter.contact.ContactByHcPartyPatientTagCodeDateFilterJs
import com.icure.sdk.js.model.filter.contact.ContactByHcPartyTagCodeDateFilterJs
import com.icure.sdk.js.model.filter.contact.ContactByServiceIdsFilterJs
import com.icure.sdk.js.model.filter.contact.contactByHcPartyFilter_fromJs
import com.icure.sdk.js.model.filter.contact.contactByHcPartyFilter_toJs
import com.icure.sdk.js.model.filter.contact.contactByHcPartyIdentifiersFilter_fromJs
import com.icure.sdk.js.model.filter.contact.contactByHcPartyIdentifiersFilter_toJs
import com.icure.sdk.js.model.filter.contact.contactByHcPartyPatientTagCodeDateFilter_fromJs
import com.icure.sdk.js.model.filter.contact.contactByHcPartyPatientTagCodeDateFilter_toJs
import com.icure.sdk.js.model.filter.contact.contactByHcPartyTagCodeDateFilter_fromJs
import com.icure.sdk.js.model.filter.contact.contactByHcPartyTagCodeDateFilter_toJs
import com.icure.sdk.js.model.filter.contact.contactByServiceIdsFilter_fromJs
import com.icure.sdk.js.model.filter.contact.contactByServiceIdsFilter_toJs
import com.icure.sdk.js.model.filter.device.AllDevicesFilterJs
import com.icure.sdk.js.model.filter.device.DeviceByHcPartyFilterJs
import com.icure.sdk.js.model.filter.device.DeviceByIdsFilterJs
import com.icure.sdk.js.model.filter.device.allDevicesFilter_fromJs
import com.icure.sdk.js.model.filter.device.allDevicesFilter_toJs
import com.icure.sdk.js.model.filter.device.deviceByHcPartyFilter_fromJs
import com.icure.sdk.js.model.filter.device.deviceByHcPartyFilter_toJs
import com.icure.sdk.js.model.filter.device.deviceByIdsFilter_fromJs
import com.icure.sdk.js.model.filter.device.deviceByIdsFilter_toJs
import com.icure.sdk.js.model.filter.hcparty.AllHealthcarePartiesFilterJs
import com.icure.sdk.js.model.filter.hcparty.HealthcarePartyByIdentifiersFilterJs
import com.icure.sdk.js.model.filter.hcparty.HealthcarePartyByIdsFilterJs
import com.icure.sdk.js.model.filter.hcparty.HealthcarePartyByNameFilterJs
import com.icure.sdk.js.model.filter.hcparty.HealthcarePartyByTagCodeFilterJs
import com.icure.sdk.js.model.filter.hcparty.allHealthcarePartiesFilter_fromJs
import com.icure.sdk.js.model.filter.hcparty.allHealthcarePartiesFilter_toJs
import com.icure.sdk.js.model.filter.hcparty.healthcarePartyByIdentifiersFilter_fromJs
import com.icure.sdk.js.model.filter.hcparty.healthcarePartyByIdentifiersFilter_toJs
import com.icure.sdk.js.model.filter.hcparty.healthcarePartyByIdsFilter_fromJs
import com.icure.sdk.js.model.filter.hcparty.healthcarePartyByIdsFilter_toJs
import com.icure.sdk.js.model.filter.hcparty.healthcarePartyByNameFilter_fromJs
import com.icure.sdk.js.model.filter.hcparty.healthcarePartyByNameFilter_toJs
import com.icure.sdk.js.model.filter.hcparty.healthcarePartyByTagCodeFilter_fromJs
import com.icure.sdk.js.model.filter.hcparty.healthcarePartyByTagCodeFilter_toJs
import com.icure.sdk.js.model.filter.healthelement.HealthElementByHcPartyFilterJs
import com.icure.sdk.js.model.filter.healthelement.HealthElementByHcPartyIdentifiersFilterJs
import com.icure.sdk.js.model.filter.healthelement.HealthElementByHcPartySecretForeignKeysFilterJs
import com.icure.sdk.js.model.filter.healthelement.HealthElementByHcPartyTagCodeFilterJs
import com.icure.sdk.js.model.filter.healthelement.HealthElementByIdsFilterJs
import com.icure.sdk.js.model.filter.healthelement.healthElementByHcPartyFilter_fromJs
import com.icure.sdk.js.model.filter.healthelement.healthElementByHcPartyFilter_toJs
import com.icure.sdk.js.model.filter.healthelement.healthElementByHcPartyIdentifiersFilter_fromJs
import com.icure.sdk.js.model.filter.healthelement.healthElementByHcPartyIdentifiersFilter_toJs
import com.icure.sdk.js.model.filter.healthelement.healthElementByHcPartySecretForeignKeysFilter_fromJs
import com.icure.sdk.js.model.filter.healthelement.healthElementByHcPartySecretForeignKeysFilter_toJs
import com.icure.sdk.js.model.filter.healthelement.healthElementByHcPartyTagCodeFilter_fromJs
import com.icure.sdk.js.model.filter.healthelement.healthElementByHcPartyTagCodeFilter_toJs
import com.icure.sdk.js.model.filter.healthelement.healthElementByIdsFilter_fromJs
import com.icure.sdk.js.model.filter.healthelement.healthElementByIdsFilter_toJs
import com.icure.sdk.js.model.filter.invoice.InvoiceByHcPartyCodeDateFilterJs
import com.icure.sdk.js.model.filter.invoice.invoiceByHcPartyCodeDateFilter_fromJs
import com.icure.sdk.js.model.filter.invoice.invoiceByHcPartyCodeDateFilter_toJs
import com.icure.sdk.js.model.filter.maintenancetask.MaintenanceTaskAfterDateFilterJs
import com.icure.sdk.js.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilterJs
import com.icure.sdk.js.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilterJs
import com.icure.sdk.js.model.filter.maintenancetask.MaintenanceTaskByIdsFilterJs
import com.icure.sdk.js.model.filter.maintenancetask.maintenanceTaskAfterDateFilter_fromJs
import com.icure.sdk.js.model.filter.maintenancetask.maintenanceTaskAfterDateFilter_toJs
import com.icure.sdk.js.model.filter.maintenancetask.maintenanceTaskByHcPartyAndIdentifiersFilter_fromJs
import com.icure.sdk.js.model.filter.maintenancetask.maintenanceTaskByHcPartyAndIdentifiersFilter_toJs
import com.icure.sdk.js.model.filter.maintenancetask.maintenanceTaskByHcPartyAndTypeFilter_fromJs
import com.icure.sdk.js.model.filter.maintenancetask.maintenanceTaskByHcPartyAndTypeFilter_toJs
import com.icure.sdk.js.model.filter.maintenancetask.maintenanceTaskByIdsFilter_fromJs
import com.icure.sdk.js.model.filter.maintenancetask.maintenanceTaskByIdsFilter_toJs
import com.icure.sdk.js.model.filter.message.LatestMessageByHcPartyTransportGuidFilterJs
import com.icure.sdk.js.model.filter.message.MessageByHcPartyFilterJs
import com.icure.sdk.js.model.filter.message.MessageByHcPartyTransportGuidFilterJs
import com.icure.sdk.js.model.filter.message.latestMessageByHcPartyTransportGuidFilter_fromJs
import com.icure.sdk.js.model.filter.message.latestMessageByHcPartyTransportGuidFilter_toJs
import com.icure.sdk.js.model.filter.message.messageByHcPartyFilter_fromJs
import com.icure.sdk.js.model.filter.message.messageByHcPartyFilter_toJs
import com.icure.sdk.js.model.filter.message.messageByHcPartyTransportGuidFilter_fromJs
import com.icure.sdk.js.model.filter.message.messageByHcPartyTransportGuidFilter_toJs
import com.icure.sdk.js.model.filter.patient.PatientByHcPartyAndActiveFilterJs
import com.icure.sdk.js.model.filter.patient.PatientByHcPartyAndAddressFilterJs
import com.icure.sdk.js.model.filter.patient.PatientByHcPartyAndExternalIdFilterJs
import com.icure.sdk.js.model.filter.patient.PatientByHcPartyAndIdentifiersFilterJs
import com.icure.sdk.js.model.filter.patient.PatientByHcPartyAndSsinFilterJs
import com.icure.sdk.js.model.filter.patient.PatientByHcPartyAndSsinsFilterJs
import com.icure.sdk.js.model.filter.patient.PatientByHcPartyAndTelecomFilterJs
import com.icure.sdk.js.model.filter.patient.PatientByHcPartyDateOfBirthBetweenFilterJs
import com.icure.sdk.js.model.filter.patient.PatientByHcPartyDateOfBirthFilterJs
import com.icure.sdk.js.model.filter.patient.PatientByHcPartyFilterJs
import com.icure.sdk.js.model.filter.patient.PatientByHcPartyGenderEducationProfessionJs
import com.icure.sdk.js.model.filter.patient.PatientByHcPartyNameContainsFuzzyFilterJs
import com.icure.sdk.js.model.filter.patient.PatientByHcPartyNameFilterJs
import com.icure.sdk.js.model.filter.patient.PatientByIdsFilterJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyAndActiveFilter_fromJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyAndActiveFilter_toJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyAndAddressFilter_fromJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyAndAddressFilter_toJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyAndExternalIdFilter_fromJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyAndExternalIdFilter_toJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyAndIdentifiersFilter_fromJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyAndIdentifiersFilter_toJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyAndSsinFilter_fromJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyAndSsinFilter_toJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyAndSsinsFilter_fromJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyAndSsinsFilter_toJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyAndTelecomFilter_fromJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyAndTelecomFilter_toJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyDateOfBirthBetweenFilter_fromJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyDateOfBirthBetweenFilter_toJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyDateOfBirthFilter_fromJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyDateOfBirthFilter_toJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyFilter_fromJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyFilter_toJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyGenderEducationProfession_fromJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyGenderEducationProfession_toJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyNameContainsFuzzyFilter_fromJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyNameContainsFuzzyFilter_toJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyNameFilter_fromJs
import com.icure.sdk.js.model.filter.patient.patientByHcPartyNameFilter_toJs
import com.icure.sdk.js.model.filter.patient.patientByIdsFilter_fromJs
import com.icure.sdk.js.model.filter.patient.patientByIdsFilter_toJs
import com.icure.sdk.js.model.filter.service.ServiceByContactsAndSubcontactsFilterJs
import com.icure.sdk.js.model.filter.service.ServiceByHcPartyFilterJs
import com.icure.sdk.js.model.filter.service.ServiceByHcPartyHealthElementIdsFilterJs
import com.icure.sdk.js.model.filter.service.ServiceByHcPartyIdentifiersFilterJs
import com.icure.sdk.js.model.filter.service.ServiceByHcPartyTagCodeDateFilterJs
import com.icure.sdk.js.model.filter.service.ServiceByIdsFilterJs
import com.icure.sdk.js.model.filter.service.ServiceBySecretForeignKeysJs
import com.icure.sdk.js.model.filter.service.serviceByContactsAndSubcontactsFilter_fromJs
import com.icure.sdk.js.model.filter.service.serviceByContactsAndSubcontactsFilter_toJs
import com.icure.sdk.js.model.filter.service.serviceByHcPartyFilter_fromJs
import com.icure.sdk.js.model.filter.service.serviceByHcPartyFilter_toJs
import com.icure.sdk.js.model.filter.service.serviceByHcPartyHealthElementIdsFilter_fromJs
import com.icure.sdk.js.model.filter.service.serviceByHcPartyHealthElementIdsFilter_toJs
import com.icure.sdk.js.model.filter.service.serviceByHcPartyIdentifiersFilter_fromJs
import com.icure.sdk.js.model.filter.service.serviceByHcPartyIdentifiersFilter_toJs
import com.icure.sdk.js.model.filter.service.serviceByHcPartyTagCodeDateFilter_fromJs
import com.icure.sdk.js.model.filter.service.serviceByHcPartyTagCodeDateFilter_toJs
import com.icure.sdk.js.model.filter.service.serviceByIdsFilter_fromJs
import com.icure.sdk.js.model.filter.service.serviceByIdsFilter_toJs
import com.icure.sdk.js.model.filter.service.serviceBySecretForeignKeys_fromJs
import com.icure.sdk.js.model.filter.service.serviceBySecretForeignKeys_toJs
import com.icure.sdk.js.model.filter.topic.TopicByHcPartyFilterJs
import com.icure.sdk.js.model.filter.topic.TopicByParticipantFilterJs
import com.icure.sdk.js.model.filter.topic.topicByHcPartyFilter_fromJs
import com.icure.sdk.js.model.filter.topic.topicByHcPartyFilter_toJs
import com.icure.sdk.js.model.filter.topic.topicByParticipantFilter_fromJs
import com.icure.sdk.js.model.filter.topic.topicByParticipantFilter_toJs
import com.icure.sdk.js.model.filter.user.AllUsersFilterJs
import com.icure.sdk.js.model.filter.user.UserByIdsFilterJs
import com.icure.sdk.js.model.filter.user.UserByNameEmailPhoneFilterJs
import com.icure.sdk.js.model.filter.user.UsersByPatientIdFilterJs
import com.icure.sdk.js.model.filter.user.allUsersFilter_fromJs
import com.icure.sdk.js.model.filter.user.allUsersFilter_toJs
import com.icure.sdk.js.model.filter.user.userByIdsFilter_fromJs
import com.icure.sdk.js.model.filter.user.userByIdsFilter_toJs
import com.icure.sdk.js.model.filter.user.userByNameEmailPhoneFilter_fromJs
import com.icure.sdk.js.model.filter.user.userByNameEmailPhoneFilter_toJs
import com.icure.sdk.js.model.filter.user.usersByPatientIdFilter_fromJs
import com.icure.sdk.js.model.filter.user.usersByPatientIdFilter_toJs
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.ComplementFilter
import com.icure.sdk.model.filter.IdsFilter
import com.icure.sdk.model.filter.IntersectionFilter
import com.icure.sdk.model.filter.UnionFilter
import com.icure.sdk.model.filter.code.AllCodesFilter
import com.icure.sdk.model.filter.code.CodeByIdsFilter
import com.icure.sdk.model.filter.code.CodeByRegionTypeLabelLanguageFilter
import com.icure.sdk.model.filter.code.CodeIdsByTypeCodeVersionIntervalFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyIdentifiersFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyPatientTagCodeDateFilter
import com.icure.sdk.model.filter.contact.ContactByHcPartyTagCodeDateFilter
import com.icure.sdk.model.filter.contact.ContactByServiceIdsFilter
import com.icure.sdk.model.filter.device.AllDevicesFilter
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
import com.icure.sdk.model.filter.user.AllUsersFilter
import com.icure.sdk.model.filter.user.UserByIdsFilter
import com.icure.sdk.model.filter.user.UserByNameEmailPhoneFilter
import com.icure.sdk.model.filter.user.UsersByPatientIdFilter
import kotlin.String

public fun <O : Identifiable<String>, O_JS : IdentifiableJs<String>>
		abstractFilter_toJs(obj: AbstractFilter<O>, convertO: (O) -> O_JS): AbstractFilterJs<O_JS> = when
		(obj) {
	is ContactByHcPartyPatientTagCodeDateFilter ->
			contactByHcPartyPatientTagCodeDateFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is ContactByHcPartyTagCodeDateFilter ->
			contactByHcPartyTagCodeDateFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is ContactByHcPartyFilter -> contactByHcPartyFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is ContactByServiceIdsFilter -> contactByServiceIdsFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is ContactByHcPartyIdentifiersFilter ->
			contactByHcPartyIdentifiersFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is HealthcarePartyByIdsFilter -> healthcarePartyByIdsFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is HealthcarePartyByTagCodeFilter ->
			healthcarePartyByTagCodeFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is AllHealthcarePartiesFilter -> allHealthcarePartiesFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is HealthcarePartyByIdentifiersFilter ->
			healthcarePartyByIdentifiersFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is HealthcarePartyByNameFilter -> healthcarePartyByNameFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is HealthElementByHcPartySecretForeignKeysFilter ->
			healthElementByHcPartySecretForeignKeysFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is HealthElementByHcPartyTagCodeFilter ->
			healthElementByHcPartyTagCodeFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is HealthElementByIdsFilter -> healthElementByIdsFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is HealthElementByHcPartyIdentifiersFilter ->
			healthElementByHcPartyIdentifiersFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is HealthElementByHcPartyFilter -> healthElementByHcPartyFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is CodeIdsByTypeCodeVersionIntervalFilter ->
			codeIdsByTypeCodeVersionIntervalFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is AllCodesFilter -> allCodesFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is CodeByIdsFilter -> codeByIdsFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is CodeByRegionTypeLabelLanguageFilter ->
			codeByRegionTypeLabelLanguageFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is MessageByHcPartyTransportGuidFilter ->
			messageByHcPartyTransportGuidFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is MessageByHcPartyFilter -> messageByHcPartyFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is LatestMessageByHcPartyTransportGuidFilter ->
			latestMessageByHcPartyTransportGuidFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is UserByIdsFilter -> userByIdsFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is AllUsersFilter -> allUsersFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is UserByNameEmailPhoneFilter -> userByNameEmailPhoneFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is UsersByPatientIdFilter -> usersByPatientIdFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is TopicByParticipantFilter -> topicByParticipantFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is TopicByHcPartyFilter -> topicByHcPartyFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is UnionFilter<O> -> unionFilter_toJs(
		obj,
		{ x1: O ->
			convertO(x1)
		},
	) as AbstractFilterJs<O_JS>
	is PatientByHcPartyGenderEducationProfession ->
			patientByHcPartyGenderEducationProfession_toJs(obj) as AbstractFilterJs<O_JS>
	is PatientByHcPartyDateOfBirthFilter ->
			patientByHcPartyDateOfBirthFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is PatientByHcPartyAndExternalIdFilter ->
			patientByHcPartyAndExternalIdFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is PatientByHcPartyAndSsinsFilter ->
			patientByHcPartyAndSsinsFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is PatientByHcPartyAndActiveFilter ->
			patientByHcPartyAndActiveFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is PatientByHcPartyAndAddressFilter ->
			patientByHcPartyAndAddressFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is PatientByHcPartyNameFilter -> patientByHcPartyNameFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is PatientByHcPartyAndSsinFilter ->
			patientByHcPartyAndSsinFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is PatientByHcPartyNameContainsFuzzyFilter ->
			patientByHcPartyNameContainsFuzzyFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is PatientByIdsFilter -> patientByIdsFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is PatientByHcPartyAndIdentifiersFilter ->
			patientByHcPartyAndIdentifiersFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is PatientByHcPartyDateOfBirthBetweenFilter ->
			patientByHcPartyDateOfBirthBetweenFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is PatientByHcPartyAndTelecomFilter ->
			patientByHcPartyAndTelecomFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is PatientByHcPartyFilter -> patientByHcPartyFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is DeviceByIdsFilter -> deviceByIdsFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is DeviceByHcPartyFilter -> deviceByHcPartyFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is AllDevicesFilter -> allDevicesFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is ComplementFilter<O> -> complementFilter_toJs(
		obj,
		{ x1: O ->
			convertO(x1)
		},
	) as AbstractFilterJs<O_JS>
	is IntersectionFilter<O> -> intersectionFilter_toJs(
		obj,
		{ x1: O ->
			convertO(x1)
		},
	) as AbstractFilterJs<O_JS>
	is IdsFilter<O> -> idsFilter_toJs(
		obj,
		{ x1: O ->
			convertO(x1)
		},
	) as AbstractFilterJs<O_JS>
	is ServiceBySecretForeignKeys -> serviceBySecretForeignKeys_toJs(obj) as AbstractFilterJs<O_JS>
	is ServiceByContactsAndSubcontactsFilter ->
			serviceByContactsAndSubcontactsFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is ServiceByHcPartyTagCodeDateFilter ->
			serviceByHcPartyTagCodeDateFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is ServiceByHcPartyHealthElementIdsFilter ->
			serviceByHcPartyHealthElementIdsFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is ServiceByHcPartyIdentifiersFilter ->
			serviceByHcPartyIdentifiersFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is ServiceByHcPartyFilter -> serviceByHcPartyFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is ServiceByIdsFilter -> serviceByIdsFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is MaintenanceTaskByHcPartyAndTypeFilter ->
			maintenanceTaskByHcPartyAndTypeFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is MaintenanceTaskByHcPartyAndIdentifiersFilter ->
			maintenanceTaskByHcPartyAndIdentifiersFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is MaintenanceTaskByIdsFilter -> maintenanceTaskByIdsFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is MaintenanceTaskAfterDateFilter ->
			maintenanceTaskAfterDateFilter_toJs(obj) as AbstractFilterJs<O_JS>
	is InvoiceByHcPartyCodeDateFilter ->
			invoiceByHcPartyCodeDateFilter_toJs(obj) as AbstractFilterJs<O_JS>
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.sdk.model.filter.AbstractFilter: $obj""")
}

public fun <O : IdentifiableJs<String>, O_KT : Identifiable<String>>
		abstractFilter_fromJs(obj: AbstractFilterJs<O>, convertO: (O) -> O_KT): AbstractFilter<O_KT> =
		when {
	obj is ContactByHcPartyPatientTagCodeDateFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.contact.ContactByHcPartyPatientTagCodeDateFilter" ->contactByHcPartyPatientTagCodeDateFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.contact.ContactByHcPartyPatientTagCodeDateFilterJs) as
			AbstractFilter<O_KT>
	obj is ContactByHcPartyTagCodeDateFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.contact.ContactByHcPartyTagCodeDateFilter" ->contactByHcPartyTagCodeDateFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.contact.ContactByHcPartyTagCodeDateFilterJs) as
			AbstractFilter<O_KT>
	obj is ContactByHcPartyFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.contact.ContactByHcPartyFilter" ->contactByHcPartyFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.contact.ContactByHcPartyFilterJs) as AbstractFilter<O_KT>
	obj is ContactByServiceIdsFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.contact.ContactByServiceIdsFilter" ->contactByServiceIdsFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.contact.ContactByServiceIdsFilterJs) as AbstractFilter<O_KT>
	obj is ContactByHcPartyIdentifiersFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.contact.ContactByHcPartyIdentifiersFilter" ->contactByHcPartyIdentifiersFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.contact.ContactByHcPartyIdentifiersFilterJs) as
			AbstractFilter<O_KT>
	obj is HealthcarePartyByIdsFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdsFilter" ->healthcarePartyByIdsFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.hcparty.HealthcarePartyByIdsFilterJs) as AbstractFilter<O_KT>
	obj is HealthcarePartyByTagCodeFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.hcparty.HealthcarePartyByTagCodeFilter" ->healthcarePartyByTagCodeFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.hcparty.HealthcarePartyByTagCodeFilterJs) as
			AbstractFilter<O_KT>
	obj is AllHealthcarePartiesFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.hcparty.AllHealthcarePartiesFilter" ->allHealthcarePartiesFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.hcparty.AllHealthcarePartiesFilterJs) as AbstractFilter<O_KT>
	obj is HealthcarePartyByIdentifiersFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdentifiersFilter" ->healthcarePartyByIdentifiersFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.hcparty.HealthcarePartyByIdentifiersFilterJs) as
			AbstractFilter<O_KT>
	obj is HealthcarePartyByNameFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.hcparty.HealthcarePartyByNameFilter" ->healthcarePartyByNameFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.hcparty.HealthcarePartyByNameFilterJs) as AbstractFilter<O_KT>
	obj is HealthElementByHcPartySecretForeignKeysFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.healthelement.HealthElementByHcPartySecretForeignKeysFilter" ->healthElementByHcPartySecretForeignKeysFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.healthelement.HealthElementByHcPartySecretForeignKeysFilterJs)
			as AbstractFilter<O_KT>
	obj is HealthElementByHcPartyTagCodeFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyTagCodeFilter" ->healthElementByHcPartyTagCodeFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.healthelement.HealthElementByHcPartyTagCodeFilterJs) as
			AbstractFilter<O_KT>
	obj is HealthElementByIdsFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.healthelement.HealthElementByIdsFilter" ->healthElementByIdsFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.healthelement.HealthElementByIdsFilterJs) as
			AbstractFilter<O_KT>
	obj is HealthElementByHcPartyIdentifiersFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyIdentifiersFilter" ->healthElementByHcPartyIdentifiersFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.healthelement.HealthElementByHcPartyIdentifiersFilterJs) as
			AbstractFilter<O_KT>
	obj is HealthElementByHcPartyFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyFilter" ->healthElementByHcPartyFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.healthelement.HealthElementByHcPartyFilterJs) as
			AbstractFilter<O_KT>
	obj is CodeIdsByTypeCodeVersionIntervalFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.code.CodeIdsByTypeCodeVersionIntervalFilter" ->codeIdsByTypeCodeVersionIntervalFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.code.CodeIdsByTypeCodeVersionIntervalFilterJs) as
			AbstractFilter<O_KT>
	obj is AllCodesFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.code.AllCodesFilter" ->allCodesFilter_fromJs(obj as
			com.icure.sdk.js.model.filter.code.AllCodesFilterJs) as AbstractFilter<O_KT>
	obj is CodeByIdsFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.code.CodeByIdsFilter" ->codeByIdsFilter_fromJs(obj as
			com.icure.sdk.js.model.filter.code.CodeByIdsFilterJs) as AbstractFilter<O_KT>
	obj is CodeByRegionTypeLabelLanguageFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.code.CodeByRegionTypeLabelLanguageFilter" ->codeByRegionTypeLabelLanguageFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.code.CodeByRegionTypeLabelLanguageFilterJs) as
			AbstractFilter<O_KT>
	obj is MessageByHcPartyTransportGuidFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.message.MessageByHcPartyTransportGuidFilter" ->messageByHcPartyTransportGuidFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.message.MessageByHcPartyTransportGuidFilterJs) as
			AbstractFilter<O_KT>
	obj is MessageByHcPartyFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.message.MessageByHcPartyFilter" ->messageByHcPartyFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.message.MessageByHcPartyFilterJs) as AbstractFilter<O_KT>
	obj is LatestMessageByHcPartyTransportGuidFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.message.LatestMessageByHcPartyTransportGuidFilter" ->latestMessageByHcPartyTransportGuidFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.message.LatestMessageByHcPartyTransportGuidFilterJs) as
			AbstractFilter<O_KT>
	obj is UserByIdsFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.user.UserByIdsFilter" ->userByIdsFilter_fromJs(obj as
			com.icure.sdk.js.model.filter.user.UserByIdsFilterJs) as AbstractFilter<O_KT>
	obj is AllUsersFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.user.AllUsersFilter" ->allUsersFilter_fromJs(obj as
			com.icure.sdk.js.model.filter.user.AllUsersFilterJs) as AbstractFilter<O_KT>
	obj is UserByNameEmailPhoneFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.user.UserByNameEmailPhoneFilter" ->userByNameEmailPhoneFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.user.UserByNameEmailPhoneFilterJs) as AbstractFilter<O_KT>
	obj is UsersByPatientIdFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.user.UsersByPatientIdFilter" ->usersByPatientIdFilter_fromJs(obj as
			com.icure.sdk.js.model.filter.user.UsersByPatientIdFilterJs) as AbstractFilter<O_KT>
	obj is TopicByParticipantFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.topic.TopicByParticipantFilter" ->topicByParticipantFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.topic.TopicByParticipantFilterJs) as AbstractFilter<O_KT>
	obj is TopicByHcPartyFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.topic.TopicByHcPartyFilter" ->topicByHcPartyFilter_fromJs(obj as
			com.icure.sdk.js.model.filter.topic.TopicByHcPartyFilterJs) as AbstractFilter<O_KT>
	obj is UnionFilterJs<O> || obj.ktClass ==
			"com.icure.sdk.model.filter.UnionFilter" ->unionFilter_fromJs(
		obj as com.icure.sdk.js.model.filter.UnionFilterJs<O>,
		{ x1: O ->
			convertO(x1)
		},
	) as AbstractFilter<O_KT>
	obj is PatientByHcPartyGenderEducationProfessionJs || obj.ktClass ==
			"com.icure.sdk.model.filter.patient.PatientByHcPartyGenderEducationProfession" ->patientByHcPartyGenderEducationProfession_fromJs(obj
			as com.icure.sdk.js.model.filter.patient.PatientByHcPartyGenderEducationProfessionJs) as
			AbstractFilter<O_KT>
	obj is PatientByHcPartyDateOfBirthFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.patient.PatientByHcPartyDateOfBirthFilter" ->patientByHcPartyDateOfBirthFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.patient.PatientByHcPartyDateOfBirthFilterJs) as
			AbstractFilter<O_KT>
	obj is PatientByHcPartyAndExternalIdFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.patient.PatientByHcPartyAndExternalIdFilter" ->patientByHcPartyAndExternalIdFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.patient.PatientByHcPartyAndExternalIdFilterJs) as
			AbstractFilter<O_KT>
	obj is PatientByHcPartyAndSsinsFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.patient.PatientByHcPartyAndSsinsFilter" ->patientByHcPartyAndSsinsFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.patient.PatientByHcPartyAndSsinsFilterJs) as
			AbstractFilter<O_KT>
	obj is PatientByHcPartyAndActiveFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.patient.PatientByHcPartyAndActiveFilter" ->patientByHcPartyAndActiveFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.patient.PatientByHcPartyAndActiveFilterJs) as
			AbstractFilter<O_KT>
	obj is PatientByHcPartyAndAddressFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.patient.PatientByHcPartyAndAddressFilter" ->patientByHcPartyAndAddressFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.patient.PatientByHcPartyAndAddressFilterJs) as
			AbstractFilter<O_KT>
	obj is PatientByHcPartyNameFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.patient.PatientByHcPartyNameFilter" ->patientByHcPartyNameFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.patient.PatientByHcPartyNameFilterJs) as AbstractFilter<O_KT>
	obj is PatientByHcPartyAndSsinFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.patient.PatientByHcPartyAndSsinFilter" ->patientByHcPartyAndSsinFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.patient.PatientByHcPartyAndSsinFilterJs) as AbstractFilter<O_KT>
	obj is PatientByHcPartyNameContainsFuzzyFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.patient.PatientByHcPartyNameContainsFuzzyFilter" ->patientByHcPartyNameContainsFuzzyFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.patient.PatientByHcPartyNameContainsFuzzyFilterJs) as
			AbstractFilter<O_KT>
	obj is PatientByIdsFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.patient.PatientByIdsFilter" ->patientByIdsFilter_fromJs(obj as
			com.icure.sdk.js.model.filter.patient.PatientByIdsFilterJs) as AbstractFilter<O_KT>
	obj is PatientByHcPartyAndIdentifiersFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.patient.PatientByHcPartyAndIdentifiersFilter" ->patientByHcPartyAndIdentifiersFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.patient.PatientByHcPartyAndIdentifiersFilterJs) as
			AbstractFilter<O_KT>
	obj is PatientByHcPartyDateOfBirthBetweenFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.patient.PatientByHcPartyDateOfBirthBetweenFilter" ->patientByHcPartyDateOfBirthBetweenFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.patient.PatientByHcPartyDateOfBirthBetweenFilterJs) as
			AbstractFilter<O_KT>
	obj is PatientByHcPartyAndTelecomFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.patient.PatientByHcPartyAndTelecomFilter" ->patientByHcPartyAndTelecomFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.patient.PatientByHcPartyAndTelecomFilterJs) as
			AbstractFilter<O_KT>
	obj is PatientByHcPartyFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.patient.PatientByHcPartyFilter" ->patientByHcPartyFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.patient.PatientByHcPartyFilterJs) as AbstractFilter<O_KT>
	obj is DeviceByIdsFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.device.DeviceByIdsFilter" ->deviceByIdsFilter_fromJs(obj as
			com.icure.sdk.js.model.filter.device.DeviceByIdsFilterJs) as AbstractFilter<O_KT>
	obj is DeviceByHcPartyFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.device.DeviceByHcPartyFilter" ->deviceByHcPartyFilter_fromJs(obj as
			com.icure.sdk.js.model.filter.device.DeviceByHcPartyFilterJs) as AbstractFilter<O_KT>
	obj is AllDevicesFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.device.AllDevicesFilter" ->allDevicesFilter_fromJs(obj as
			com.icure.sdk.js.model.filter.device.AllDevicesFilterJs) as AbstractFilter<O_KT>
	obj is ComplementFilterJs<O> || obj.ktClass ==
			"com.icure.sdk.model.filter.ComplementFilter" ->complementFilter_fromJs(
		obj as com.icure.sdk.js.model.filter.ComplementFilterJs<O>,
		{ x1: O ->
			convertO(x1)
		},
	) as AbstractFilter<O_KT>
	obj is IntersectionFilterJs<O> || obj.ktClass ==
			"com.icure.sdk.model.filter.IntersectionFilter" ->intersectionFilter_fromJs(
		obj as com.icure.sdk.js.model.filter.IntersectionFilterJs<O>,
		{ x1: O ->
			convertO(x1)
		},
	) as AbstractFilter<O_KT>
	obj is IdsFilterJs<O> || obj.ktClass == "com.icure.sdk.model.filter.IdsFilter" ->idsFilter_fromJs(
		obj as com.icure.sdk.js.model.filter.IdsFilterJs<O>,
		{ x1: O ->
			convertO(x1)
		},
	) as AbstractFilter<O_KT>
	obj is ServiceBySecretForeignKeysJs || obj.ktClass ==
			"com.icure.sdk.model.filter.service.ServiceBySecretForeignKeys" ->serviceBySecretForeignKeys_fromJs(obj
			as com.icure.sdk.js.model.filter.service.ServiceBySecretForeignKeysJs) as AbstractFilter<O_KT>
	obj is ServiceByContactsAndSubcontactsFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.service.ServiceByContactsAndSubcontactsFilter" ->serviceByContactsAndSubcontactsFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.service.ServiceByContactsAndSubcontactsFilterJs) as
			AbstractFilter<O_KT>
	obj is ServiceByHcPartyTagCodeDateFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.service.ServiceByHcPartyTagCodeDateFilter" ->serviceByHcPartyTagCodeDateFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.service.ServiceByHcPartyTagCodeDateFilterJs) as
			AbstractFilter<O_KT>
	obj is ServiceByHcPartyHealthElementIdsFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.service.ServiceByHcPartyHealthElementIdsFilter" ->serviceByHcPartyHealthElementIdsFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.service.ServiceByHcPartyHealthElementIdsFilterJs) as
			AbstractFilter<O_KT>
	obj is ServiceByHcPartyIdentifiersFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.service.ServiceByHcPartyIdentifiersFilter" ->serviceByHcPartyIdentifiersFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.service.ServiceByHcPartyIdentifiersFilterJs) as
			AbstractFilter<O_KT>
	obj is ServiceByHcPartyFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.service.ServiceByHcPartyFilter" ->serviceByHcPartyFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.service.ServiceByHcPartyFilterJs) as AbstractFilter<O_KT>
	obj is ServiceByIdsFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.service.ServiceByIdsFilter" ->serviceByIdsFilter_fromJs(obj as
			com.icure.sdk.js.model.filter.service.ServiceByIdsFilterJs) as AbstractFilter<O_KT>
	obj is MaintenanceTaskByHcPartyAndTypeFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilter" ->maintenanceTaskByHcPartyAndTypeFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilterJs) as
			AbstractFilter<O_KT>
	obj is MaintenanceTaskByHcPartyAndIdentifiersFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilter" ->maintenanceTaskByHcPartyAndIdentifiersFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilterJs)
			as AbstractFilter<O_KT>
	obj is MaintenanceTaskByIdsFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByIdsFilter" ->maintenanceTaskByIdsFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.maintenancetask.MaintenanceTaskByIdsFilterJs) as
			AbstractFilter<O_KT>
	obj is MaintenanceTaskAfterDateFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskAfterDateFilter" ->maintenanceTaskAfterDateFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.maintenancetask.MaintenanceTaskAfterDateFilterJs) as
			AbstractFilter<O_KT>
	obj is InvoiceByHcPartyCodeDateFilterJs || obj.ktClass ==
			"com.icure.sdk.model.filter.invoice.InvoiceByHcPartyCodeDateFilter" ->invoiceByHcPartyCodeDateFilter_fromJs(obj
			as com.icure.sdk.js.model.filter.invoice.InvoiceByHcPartyCodeDateFilterJs) as
			AbstractFilter<O_KT>
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.sdk.model.filter.AbstractFilter: $obj""")
}
