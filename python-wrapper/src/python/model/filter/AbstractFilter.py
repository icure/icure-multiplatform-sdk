import json
from typing import Union, Dict
from model.filter.contact.ContactByHcPartyPatientTagCodeDateFilter import ContactByHcPartyPatientTagCodeDateFilter
from model.filter.contact.ContactByHcPartyTagCodeDateFilter import ContactByHcPartyTagCodeDateFilter
from model.filter.contact.ContactByHcPartyFilter import ContactByHcPartyFilter
from model.filter.contact.ContactByServiceIdsFilter import ContactByServiceIdsFilter
from model.filter.contact.ContactByHcPartyIdentifiersFilter import ContactByHcPartyIdentifiersFilter
from model.filter.hcparty.HealthcarePartyByIdsFilter import HealthcarePartyByIdsFilter
from model.filter.hcparty.HealthcarePartyByTagCodeFilter import HealthcarePartyByTagCodeFilter
from model.filter.hcparty.AllHealthcarePartiesFilter import AllHealthcarePartiesFilter
from model.filter.hcparty.HealthcarePartyByIdentifiersFilter import HealthcarePartyByIdentifiersFilter
from model.filter.hcparty.HealthcarePartyByNameFilter import HealthcarePartyByNameFilter
from model.filter.healthelement.HealthElementByHcPartySecretForeignKeysFilter import HealthElementByHcPartySecretForeignKeysFilter
from model.filter.healthelement.HealthElementByHcPartyTagCodeFilter import HealthElementByHcPartyTagCodeFilter
from model.filter.healthelement.HealthElementByIdsFilter import HealthElementByIdsFilter
from model.filter.healthelement.HealthElementByHcPartyIdentifiersFilter import HealthElementByHcPartyIdentifiersFilter
from model.filter.healthelement.HealthElementByHcPartyFilter import HealthElementByHcPartyFilter
from model.filter.code.CodeIdsByTypeCodeVersionIntervalFilter import CodeIdsByTypeCodeVersionIntervalFilter
from model.filter.code.AllCodesFilter import AllCodesFilter
from model.filter.code.CodeByIdsFilter import CodeByIdsFilter
from model.filter.code.CodeByRegionTypeLabelLanguageFilter import CodeByRegionTypeLabelLanguageFilter
from model.filter.message.MessageByHcPartyTransportGuidFilter import MessageByHcPartyTransportGuidFilter
from model.filter.message.MessageByHcPartyFilter import MessageByHcPartyFilter
from model.filter.message.LatestMessageByHcPartyTransportGuidFilter import LatestMessageByHcPartyTransportGuidFilter
from model.filter.user.UserByIdsFilter import UserByIdsFilter
from model.filter.user.AllUsersFilter import AllUsersFilter
from model.filter.user.UserByNameEmailPhoneFilter import UserByNameEmailPhoneFilter
from model.filter.user.UsersByPatientIdFilter import UsersByPatientIdFilter
from model.filter.topic.TopicByParticipantFilter import TopicByParticipantFilter
from model.filter.topic.TopicByHcPartyFilter import TopicByHcPartyFilter
from model.filter.UnionFilter import UnionFilter
from model.filter.patient.PatientByHcPartyGenderEducationProfession import PatientByHcPartyGenderEducationProfession
from model.filter.patient.PatientByHcPartyDateOfBirthFilter import PatientByHcPartyDateOfBirthFilter
from model.filter.patient.PatientByHcPartyAndExternalIdFilter import PatientByHcPartyAndExternalIdFilter
from model.filter.patient.PatientByHcPartyAndSsinsFilter import PatientByHcPartyAndSsinsFilter
from model.filter.patient.PatientByHcPartyAndActiveFilter import PatientByHcPartyAndActiveFilter
from model.filter.patient.PatientByHcPartyAndAddressFilter import PatientByHcPartyAndAddressFilter
from model.filter.patient.PatientByHcPartyNameFilter import PatientByHcPartyNameFilter
from model.filter.patient.PatientByHcPartyAndSsinFilter import PatientByHcPartyAndSsinFilter
from model.filter.patient.PatientByHcPartyNameContainsFuzzyFilter import PatientByHcPartyNameContainsFuzzyFilter
from model.filter.patient.PatientByIdsFilter import PatientByIdsFilter
from model.filter.patient.PatientByHcPartyAndIdentifiersFilter import PatientByHcPartyAndIdentifiersFilter
from model.filter.patient.PatientByHcPartyDateOfBirthBetweenFilter import PatientByHcPartyDateOfBirthBetweenFilter
from model.filter.patient.PatientByHcPartyAndTelecomFilter import PatientByHcPartyAndTelecomFilter
from model.filter.patient.PatientByHcPartyFilter import PatientByHcPartyFilter
from model.filter.device.DeviceByIdsFilter import DeviceByIdsFilter
from model.filter.device.DeviceByHcPartyFilter import DeviceByHcPartyFilter
from model.filter.device.AllDevicesFilter import AllDevicesFilter
from model.filter.ComplementFilter import ComplementFilter
from model.filter.IntersectionFilter import IntersectionFilter
from model.filter.IdsFilter import IdsFilter
from model.filter.service.ServiceBySecretForeignKeys import ServiceBySecretForeignKeys
from model.filter.service.ServiceByContactsAndSubcontactsFilter import ServiceByContactsAndSubcontactsFilter
from model.filter.service.ServiceByHcPartyTagCodeDateFilter import ServiceByHcPartyTagCodeDateFilter
from model.filter.service.ServiceByHcPartyHealthElementIdsFilter import ServiceByHcPartyHealthElementIdsFilter
from model.filter.service.ServiceByHcPartyIdentifiersFilter import ServiceByHcPartyIdentifiersFilter
from model.filter.service.ServiceByHcPartyFilter import ServiceByHcPartyFilter
from model.filter.service.ServiceByIdsFilter import ServiceByIdsFilter
from model.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilter import MaintenanceTaskByHcPartyAndTypeFilter
from model.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilter import MaintenanceTaskByHcPartyAndIdentifiersFilter
from model.filter.maintenancetask.MaintenanceTaskByIdsFilter import MaintenanceTaskByIdsFilter
from model.filter.maintenancetask.MaintenanceTaskAfterDateFilter import MaintenanceTaskAfterDateFilter
from model.filter.invoice.InvoiceByHcPartyCodeDateFilter import InvoiceByHcPartyCodeDateFilter

AbstractFilter = Union['ContactByHcPartyPatientTagCodeDateFilter', 'ContactByHcPartyTagCodeDateFilter', 'ContactByHcPartyFilter', 'ContactByServiceIdsFilter', 'ContactByHcPartyIdentifiersFilter', 'HealthcarePartyByIdsFilter', 'HealthcarePartyByTagCodeFilter', 'AllHealthcarePartiesFilter', 'HealthcarePartyByIdentifiersFilter', 'HealthcarePartyByNameFilter', 'HealthElementByHcPartySecretForeignKeysFilter', 'HealthElementByHcPartyTagCodeFilter', 'HealthElementByIdsFilter', 'HealthElementByHcPartyIdentifiersFilter', 'HealthElementByHcPartyFilter', 'CodeIdsByTypeCodeVersionIntervalFilter', 'AllCodesFilter', 'CodeByIdsFilter', 'CodeByRegionTypeLabelLanguageFilter', 'MessageByHcPartyTransportGuidFilter', 'MessageByHcPartyFilter', 'LatestMessageByHcPartyTransportGuidFilter', 'UserByIdsFilter', 'AllUsersFilter', 'UserByNameEmailPhoneFilter', 'UsersByPatientIdFilter', 'TopicByParticipantFilter', 'TopicByHcPartyFilter', 'UnionFilter', 'PatientByHcPartyGenderEducationProfession', 'PatientByHcPartyDateOfBirthFilter', 'PatientByHcPartyAndExternalIdFilter', 'PatientByHcPartyAndSsinsFilter', 'PatientByHcPartyAndActiveFilter', 'PatientByHcPartyAndAddressFilter', 'PatientByHcPartyNameFilter', 'PatientByHcPartyAndSsinFilter', 'PatientByHcPartyNameContainsFuzzyFilter', 'PatientByIdsFilter', 'PatientByHcPartyAndIdentifiersFilter', 'PatientByHcPartyDateOfBirthBetweenFilter', 'PatientByHcPartyAndTelecomFilter', 'PatientByHcPartyFilter', 'DeviceByIdsFilter', 'DeviceByHcPartyFilter', 'AllDevicesFilter', 'ComplementFilter', 'IntersectionFilter', 'IdsFilter', 'ServiceBySecretForeignKeys', 'ServiceByContactsAndSubcontactsFilter', 'ServiceByHcPartyTagCodeDateFilter', 'ServiceByHcPartyHealthElementIdsFilter', 'ServiceByHcPartyIdentifiersFilter', 'ServiceByHcPartyFilter', 'ServiceByIdsFilter', 'MaintenanceTaskByHcPartyAndTypeFilter', 'MaintenanceTaskByHcPartyAndIdentifiersFilter', 'MaintenanceTaskByIdsFilter', 'MaintenanceTaskAfterDateFilter', 'InvoiceByHcPartyCodeDateFilter']

def serialize_abstract_filter(abstract_filter: AbstractFilter) -> object:
	if instanceof(abstract_filter, ContactByHcPartyPatientTagCodeDateFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ContactByHcPartyPatientTagCodeDateFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, ContactByHcPartyTagCodeDateFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ContactByHcPartyTagCodeDateFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, ContactByHcPartyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ContactByHcPartyFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, ContactByServiceIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ContactByServiceIdsFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, ContactByHcPartyIdentifiersFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ContactByHcPartyIdentifiersFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, HealthcarePartyByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthcarePartyByIdsFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, HealthcarePartyByTagCodeFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthcarePartyByTagCodeFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, AllHealthcarePartiesFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "AllHealthcarePartiesFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, HealthcarePartyByIdentifiersFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthcarePartyByIdentifiersFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, HealthcarePartyByNameFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthcarePartyByNameFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, HealthElementByHcPartySecretForeignKeysFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthElementByHcPartySecretForeignKeysFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, HealthElementByHcPartyTagCodeFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthElementByHcPartyTagCodeFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, HealthElementByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthElementByIdsFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, HealthElementByHcPartyIdentifiersFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthElementByHcPartyIdentifiersFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, HealthElementByHcPartyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "HealthElementByHcPartyFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, CodeIdsByTypeCodeVersionIntervalFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "CodeIdsByTypeCodeVersionIntervalFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, AllCodesFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "AllCodesFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, CodeByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "CodeByIdsFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, CodeByRegionTypeLabelLanguageFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "CodeByRegionTypeLabelLanguageFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, MessageByHcPartyTransportGuidFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "MessageByHcPartyTransportGuidFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, MessageByHcPartyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "MessageByHcPartyFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, LatestMessageByHcPartyTransportGuidFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "LatestMessageByHcPartyTransportGuidFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, UserByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "UserByIdsFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, AllUsersFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "AllUsersFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, UserByNameEmailPhoneFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "UserByNameEmailPhoneFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, UsersByPatientIdFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "UsersByPatientIdFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, TopicByParticipantFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "TopicByParticipantFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, TopicByHcPartyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "TopicByHcPartyFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, UnionFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "UnionFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, PatientByHcPartyGenderEducationProfession):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyGenderEducationProfession"})
		return serialized_entity
	elif instanceof(abstract_filter, PatientByHcPartyDateOfBirthFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyDateOfBirthFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, PatientByHcPartyAndExternalIdFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyAndExternalIdFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, PatientByHcPartyAndSsinsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyAndSsinsFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, PatientByHcPartyAndActiveFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyAndActiveFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, PatientByHcPartyAndAddressFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyAndAddressFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, PatientByHcPartyNameFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyNameFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, PatientByHcPartyAndSsinFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyAndSsinFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, PatientByHcPartyNameContainsFuzzyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyNameContainsFuzzyFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, PatientByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByIdsFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, PatientByHcPartyAndIdentifiersFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyAndIdentifiersFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, PatientByHcPartyDateOfBirthBetweenFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyDateOfBirthBetweenFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, PatientByHcPartyAndTelecomFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyAndTelecomFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, PatientByHcPartyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "PatientByHcPartyFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, DeviceByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "DeviceByIdsFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, DeviceByHcPartyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "DeviceByHcPartyFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, AllDevicesFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "AllDevicesFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, ComplementFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ComplementFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, IntersectionFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "IntersectionFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, IdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "IdsFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, ServiceBySecretForeignKeys):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ServiceBySecretForeignKeys"})
		return serialized_entity
	elif instanceof(abstract_filter, ServiceByContactsAndSubcontactsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ServiceByContactsAndSubcontactsFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, ServiceByHcPartyTagCodeDateFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ServiceByHcPartyTagCodeDateFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, ServiceByHcPartyHealthElementIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ServiceByHcPartyHealthElementIdsFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, ServiceByHcPartyIdentifiersFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ServiceByHcPartyIdentifiersFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, ServiceByHcPartyFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ServiceByHcPartyFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, ServiceByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "ServiceByIdsFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, MaintenanceTaskByHcPartyAndTypeFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "MaintenanceTaskByHcPartyAndTypeFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, MaintenanceTaskByHcPartyAndIdentifiersFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "MaintenanceTaskByHcPartyAndIdentifiersFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, MaintenanceTaskByIdsFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "MaintenanceTaskByIdsFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, MaintenanceTaskAfterDateFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "MaintenanceTaskAfterDateFilter"})
		return serialized_entity
	elif instanceof(abstract_filter, InvoiceByHcPartyCodeDateFilter):
		serialized_entity = abstract_filter.__serialize__()
		serialized_entity.update({"$type": "InvoiceByHcPartyCodeDateFilter"})
		return serialized_entity
	else:
		raise Exception(f"{type(abstract_filter)} is not a known subclass of AbstractFilter")

def deserialize_abstract_filter(data: Union[str, Dict[str, object]]) -> 'AbstractFilter':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("$type")
	if qualifier is None:
		raise Exception("Missing qualifier: $type")
	if qualifier == "ContactByHcPartyPatientTagCodeDateFilter":
		ContactByHcPartyPatientTagCodeDateFilter._deserialize(deserialized_dict)
	elif qualifier == "ContactByHcPartyTagCodeDateFilter":
		ContactByHcPartyTagCodeDateFilter._deserialize(deserialized_dict)
	elif qualifier == "ContactByHcPartyFilter":
		ContactByHcPartyFilter._deserialize(deserialized_dict)
	elif qualifier == "ContactByServiceIdsFilter":
		ContactByServiceIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "ContactByHcPartyIdentifiersFilter":
		ContactByHcPartyIdentifiersFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthcarePartyByIdsFilter":
		HealthcarePartyByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthcarePartyByTagCodeFilter":
		HealthcarePartyByTagCodeFilter._deserialize(deserialized_dict)
	elif qualifier == "AllHealthcarePartiesFilter":
		AllHealthcarePartiesFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthcarePartyByIdentifiersFilter":
		HealthcarePartyByIdentifiersFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthcarePartyByNameFilter":
		HealthcarePartyByNameFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthElementByHcPartySecretForeignKeysFilter":
		HealthElementByHcPartySecretForeignKeysFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthElementByHcPartyTagCodeFilter":
		HealthElementByHcPartyTagCodeFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthElementByIdsFilter":
		HealthElementByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthElementByHcPartyIdentifiersFilter":
		HealthElementByHcPartyIdentifiersFilter._deserialize(deserialized_dict)
	elif qualifier == "HealthElementByHcPartyFilter":
		HealthElementByHcPartyFilter._deserialize(deserialized_dict)
	elif qualifier == "CodeIdsByTypeCodeVersionIntervalFilter":
		CodeIdsByTypeCodeVersionIntervalFilter._deserialize(deserialized_dict)
	elif qualifier == "AllCodesFilter":
		AllCodesFilter._deserialize(deserialized_dict)
	elif qualifier == "CodeByIdsFilter":
		CodeByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "CodeByRegionTypeLabelLanguageFilter":
		CodeByRegionTypeLabelLanguageFilter._deserialize(deserialized_dict)
	elif qualifier == "MessageByHcPartyTransportGuidFilter":
		MessageByHcPartyTransportGuidFilter._deserialize(deserialized_dict)
	elif qualifier == "MessageByHcPartyFilter":
		MessageByHcPartyFilter._deserialize(deserialized_dict)
	elif qualifier == "LatestMessageByHcPartyTransportGuidFilter":
		LatestMessageByHcPartyTransportGuidFilter._deserialize(deserialized_dict)
	elif qualifier == "UserByIdsFilter":
		UserByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "AllUsersFilter":
		AllUsersFilter._deserialize(deserialized_dict)
	elif qualifier == "UserByNameEmailPhoneFilter":
		UserByNameEmailPhoneFilter._deserialize(deserialized_dict)
	elif qualifier == "UsersByPatientIdFilter":
		UsersByPatientIdFilter._deserialize(deserialized_dict)
	elif qualifier == "TopicByParticipantFilter":
		TopicByParticipantFilter._deserialize(deserialized_dict)
	elif qualifier == "TopicByHcPartyFilter":
		TopicByHcPartyFilter._deserialize(deserialized_dict)
	elif qualifier == "UnionFilter":
		UnionFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyGenderEducationProfession":
		PatientByHcPartyGenderEducationProfession._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyDateOfBirthFilter":
		PatientByHcPartyDateOfBirthFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyAndExternalIdFilter":
		PatientByHcPartyAndExternalIdFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyAndSsinsFilter":
		PatientByHcPartyAndSsinsFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyAndActiveFilter":
		PatientByHcPartyAndActiveFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyAndAddressFilter":
		PatientByHcPartyAndAddressFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyNameFilter":
		PatientByHcPartyNameFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyAndSsinFilter":
		PatientByHcPartyAndSsinFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyNameContainsFuzzyFilter":
		PatientByHcPartyNameContainsFuzzyFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByIdsFilter":
		PatientByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyAndIdentifiersFilter":
		PatientByHcPartyAndIdentifiersFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyDateOfBirthBetweenFilter":
		PatientByHcPartyDateOfBirthBetweenFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyAndTelecomFilter":
		PatientByHcPartyAndTelecomFilter._deserialize(deserialized_dict)
	elif qualifier == "PatientByHcPartyFilter":
		PatientByHcPartyFilter._deserialize(deserialized_dict)
	elif qualifier == "DeviceByIdsFilter":
		DeviceByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "DeviceByHcPartyFilter":
		DeviceByHcPartyFilter._deserialize(deserialized_dict)
	elif qualifier == "AllDevicesFilter":
		AllDevicesFilter._deserialize(deserialized_dict)
	elif qualifier == "ComplementFilter":
		ComplementFilter._deserialize(deserialized_dict)
	elif qualifier == "IntersectionFilter":
		IntersectionFilter._deserialize(deserialized_dict)
	elif qualifier == "IdsFilter":
		IdsFilter._deserialize(deserialized_dict)
	elif qualifier == "ServiceBySecretForeignKeys":
		ServiceBySecretForeignKeys._deserialize(deserialized_dict)
	elif qualifier == "ServiceByContactsAndSubcontactsFilter":
		ServiceByContactsAndSubcontactsFilter._deserialize(deserialized_dict)
	elif qualifier == "ServiceByHcPartyTagCodeDateFilter":
		ServiceByHcPartyTagCodeDateFilter._deserialize(deserialized_dict)
	elif qualifier == "ServiceByHcPartyHealthElementIdsFilter":
		ServiceByHcPartyHealthElementIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "ServiceByHcPartyIdentifiersFilter":
		ServiceByHcPartyIdentifiersFilter._deserialize(deserialized_dict)
	elif qualifier == "ServiceByHcPartyFilter":
		ServiceByHcPartyFilter._deserialize(deserialized_dict)
	elif qualifier == "ServiceByIdsFilter":
		ServiceByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "MaintenanceTaskByHcPartyAndTypeFilter":
		MaintenanceTaskByHcPartyAndTypeFilter._deserialize(deserialized_dict)
	elif qualifier == "MaintenanceTaskByHcPartyAndIdentifiersFilter":
		MaintenanceTaskByHcPartyAndIdentifiersFilter._deserialize(deserialized_dict)
	elif qualifier == "MaintenanceTaskByIdsFilter":
		MaintenanceTaskByIdsFilter._deserialize(deserialized_dict)
	elif qualifier == "MaintenanceTaskAfterDateFilter":
		MaintenanceTaskAfterDateFilter._deserialize(deserialized_dict)
	elif qualifier == "InvoiceByHcPartyCodeDateFilter":
		InvoiceByHcPartyCodeDateFilter._deserialize(deserialized_dict)
	else:
		raise Exception(f"{qualifier} is not a known subclass of AbstractFilter")

__all__ = ['AbstractFilter','serialize_abstract_filter','deserialize_abstract_filter']