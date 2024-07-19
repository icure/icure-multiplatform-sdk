from typing import List, Optional, Union

from icure import IcureSdk
from icure.filters.AbstractFilterBuilder import AbstractFilterBuilder
from icure.model import ServiceAbstractFilter, ServiceByHcPartyFilter, ServiceByHcPartyIdentifiersFilter, \
    ServiceByHcPartyTagCodeDateFilter, ComplementFilter, Identifier, Patient, ServiceBySecretForeignKeys, \
    ServiceByIdsFilter, ServiceByHcPartyHealthElementIdsFilter


class ServiceFilters:
    """
    Factory and builder for creating service filters.
    """

    @classmethod
    def complement_filter(cls, super_set: ServiceAbstractFilter, sub_set: ServiceAbstractFilter) -> ServiceAbstractFilter:
        """
        :param super_set: a filter
        :param sub_set: a filter
        :return: A filter that provides all entities that are in super_set but not in subset. The result will preserve
        the same ordering it had in the super_set.
        """
        return ComplementFilter(super_set=super_set, sub_set=sub_set)

    @classmethod
    def all_services_for_self_filter(
            cls,
            sdk: IcureSdk
    ) -> ServiceAbstractFilter:
        """
        :param sdk: the sdk, used to get the id of the current data owner
        :return: A filter to get all services accessible to the current data owner
        """
        return ServiceByHcPartyFilter(sdk.data_owner.get_current_data_owner_id_blocking())

    @classmethod
    def all_services_for_data_owner_filter(
            cls,
            data_owner_id: str
    ) -> ServiceAbstractFilter:
        """
        :param data_owner_id: a data owner id. Note that you may need some special permissions to use the filter if the
        data owner id is not the current data owner.
        :return: A filter to get all services accessible to the specified data owner
        """
        return ServiceByHcPartyFilter(data_owner_id)

    class Builder(AbstractFilterBuilder[ServiceAbstractFilter, 'ServiceFilters.Builder']):
        """
        Allows to build complex filters for services
        """

        def __init__(self, sdk: IcureSdk, data_owner_id: Optional[str] = None):
            """
            Initializes the filter builder
            :param sdk: the sdk, used to get some contextual information when needed.
            :param data_owner_id: id of a data owner to use in the filter. For most filters only data that is accessible to
            that data owner will be returned. If None will use the id of the data owner logged into the sdk.
            """
            self.__sdk = sdk
            self.__data_owner_id = data_owner_id if data_owner_id is not None else sdk.data_owner.get_current_data_owner_id_blocking()

        def by_identifiers(self, identifiers: List[Identifier], sort: bool = False) -> 'ServiceFilters.Builder':
            """
            The filter will return all the entities that have at least one of the specified identifiers. The system and
            value of an identifier must match exactly for an entity to be returned by this filter (other properties
            of the identifier are ignored).
            :param identifiers: a list of identifiers
            :param sort: if True the data obtained through this filter will be returned in the same order as the input
            identifiers. In case an entity has multiple identifiers only the first matching identifier will be
            considered.
            :raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                ServiceByHcPartyIdentifiersFilter(
                    identifiers=identifiers,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )

        def by_code(
            self,
            code_type: str,
            code_code: Optional[str],
            start_value_date: Optional[int],
            end_value_date: Optional[int],
            sort: bool = False
        ) -> 'ServiceFilters.Builder':
            """
            Get all services that have a certain code. If you specify only the code type you will get all entities that
            have at least a code of that type. You can also limit the result to only services that are within a
            certain value date (or opening date if missing) timeframe, but in that case you must specify the code_code.
            :param code_type: a code type
            :param code_code: a code for the provided code type, or None if you want the filter to accept any entity
            with a code of the provided type.
            :param start_value_date: if provided the filters accepts only services with a value date (or opening date if
            the value date is missing) that is after this value (inclusive).
            :param end_value_date:  if provided the filters accepts only services with a value date (or opening date if
            the value date is missing) that is before this value (inclusive).
            :param sort: if True the data obtained through this filter will be sorted by code_code, and then
            opening_date
            raises ValueError: if sort is True and another filter was previously set as the sort key, or if you provide
            a range for the opening date but no code_code.
            :return: self
            """
            if (start_value_date is not None or end_value_date is not None) and code_code is None:
                raise ValueError("To filter on opening date you need to provide either tag code or code code")
            return self._add_filter(
                ServiceByHcPartyTagCodeDateFilter(
                    tag_type=None,
                    tag_code=None,
                    code_type=code_type,
                    code_code=code_code,
                    start_value_date=start_value_date,
                    end_value_date=end_value_date,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )

        def by_tag(
            self,
            tag_type: str,
            tag_code: Optional[str],
            start_value_date: Optional[int],
            end_value_date: Optional[int],
            sort: bool = False
        ) -> 'ServiceFilters.Builder':
            """
            Get all services that have a certain tag. If you specify only the tag type you will get all entities that
            have at least a tag of that type. You can also limit the result to only services that are within a
            certain value date (or opening date if missing) timeframe, but in that case you must specify the tag_code.
            :param tag_type: a tag type
            :param tag_code: a code for the provided tag type, or None if you want the filter to accept any entity
            with a tag of the provided type.
            :param start_value_date: if provided the filters accepts only services with a value date (or opening date if
            the value date is missing) that is after this value (inclusive).
            :param end_value_date:  if provided the filters accepts only services with a value date (or opening date if
            the value date is missing) that is before this value (inclusive).
            :param sort: if True the data obtained through this filter will be sorted by tag_code, and then
            opening_date
            raises ValueError: if sort is True and another filter was previously set as the sort key, or if you provide
            a range for the opening date but no tag_code.
            :return: self
            """
            if (start_value_date is not None or end_value_date is not None) and tag_code is None:
                raise ValueError("To filter on opening date you need to provide either tag code or code code")
            return self._add_filter(
                ServiceByHcPartyTagCodeDateFilter(
                    tag_type=tag_type,
                    tag_code=tag_code,
                    code_type=None,
                    code_code=None,
                    start_value_date=start_value_date,
                    end_value_date=end_value_date,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )

        def by_patients(
            self,
            patients_or_secret_ids: List[Union[Patient, str]],
            sort: bool = False
        ) -> 'ServiceFilters.Builder':
            """
            Get all services linked to a patient within the provided group.
            :param patients_or_secret_ids: a list of patients or they secret ids. If you pass patients their secret ids
            will be extracted automatically by this method.
            :param sort: if true the data will be sorted by the patients, more specifically by the secret id of the
            patient used to link the data to it.
            :return: self
            """
            secret_ids = []
            for x in patients_or_secret_ids:
                if isinstance(x, str):
                    secret_ids.append(x)
                else:
                    secret_ids.extend(self.__sdk.patient.get_secret_ids_of_blocking(x))
            return self._add_filter(
                ServiceBySecretForeignKeys(
                    patient_secret_foreign_keys=secret_ids,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )

        def by_ids(self, ids: List[str], sort: bool = False) -> 'ServiceFilters.Builder':
            """
            The filter will return all services with one of the provided ids. This filter ignores the data_owner_id of the
            builder.
            :param ids: a list of ids.
            :param sort: if True the data obtained through this filter will be returned in the same order as the input ids.
            :raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                ServiceByIdsFilter(ids=ids),
                sort
            )

        def by_health_element_id_from_subcontact(
                self,
                health_element_ids: List[str],
                sort: bool = False
        ):
            """
            The filter will return services from subcontacts that are linked to one of the provided health element ids.
            :param health_element_ids: some health element ids
            :param sort: if True the data obtained through this filter will be returned in the same order as the input
             ids.
            :raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                ServiceByHcPartyHealthElementIdsFilter(
                    health_element_ids=health_element_ids,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )
