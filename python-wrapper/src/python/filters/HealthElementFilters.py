from typing import List, Optional, Union

from icure import IcureSdk
from icure.filters.AbstractFilterBuilder import AbstractFilterBuilder
from icure.model import HealthElementAbstractFilter, HealthElementByHcPartyFilter, \
    HealthElementByHcPartyIdentifiersFilter, HealthElementByIdsFilter, HealthElementByHcPartyTagCodeFilter, \
    HealthElementByHcPartySecretForeignKeysFilter, ComplementFilter, Identifier, Patient


class HealthElementFilters:
    """
    Factory and builder for creating health elements filters.
    """

    @classmethod
    def complement_filter(cls, super_set: HealthElementAbstractFilter, sub_set: HealthElementAbstractFilter) -> HealthElementAbstractFilter:
        """
        :param super_set: a filter
        :param sub_set: a filter
        :return: A filter that provides all entities that are in super_set but not in subset. The result will preserve
        the same ordering it had in the super_set.
        """
        return ComplementFilter(super_set=super_set, sub_set=sub_set)

    @classmethod
    def all_health_elements_for_self_filter(
            cls,
            sdk: IcureSdk
    ) -> HealthElementAbstractFilter:
        """
        :param sdk: the sdk, used to get the id of the current data owner
        :return: A filter to get all health elements accessible to the current data owner
        """
        return HealthElementByHcPartyFilter(sdk.data_owner.get_current_data_owner_id_blocking())

    @classmethod
    def all_health_elements_for_data_owner_filter(
            cls,
            data_owner_id: str
    ) -> HealthElementAbstractFilter:
        """
        :param data_owner_id: a data owner id. Note that you may need some special permissions to use the filter if the
        data owner id is not the current data owner.
        :return: A filter to get all health elements accessible to the specified data owner
        """
        return HealthElementByHcPartyFilter(data_owner_id)

    class Builder(AbstractFilterBuilder[HealthElementAbstractFilter, 'HealthElementFilters.Builder']):
        """
        Allows to build complex filters for health elements
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

        def by_identifiers(self, identifiers: List[Identifier], sort: bool = False) -> 'HealthElementFilters.Builder':
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
                HealthElementByHcPartyIdentifiersFilter(
                    identifiers=identifiers,
                    hc_party_id=self.__data_owner_id
                ),
                sort
            )

        def by_code(
                self,
                code_type: str,
                code_code: Optional[str],
                sort: bool = False
        ) -> 'HealthElementFilters.Builder':
            """
            Get all health elements that have a certain code. If you specify only the code type you will get all entities
            that have at least a code of that type.
            :param code_type: a code type
            :param code_code: a code for the provided code type, or None if you want the filter to accept any entity
            with a code of the provided type.
            :param sort: if True the data obtained through this filter will be sorted by code_code. Has no effect if the
            code_code parameter is not None.
            raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                HealthElementByHcPartyTagCodeFilter(
                    tag_type=None,
                    tag_code=None,
                    code_type=code_type,
                    code_code=code_code,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )

        def by_tag(
                self,
                tag_type: str,
                tag_code: Optional[str],
                sort: bool = False
        ) -> 'HealthElementFilters.Builder':
            """
            Get all health elements that have a certain tag. If you specify only the tag type you will get all entities
            that have at least a tag of that type.
            :param tag_type: a tag type
            :param tag_code: a code for the provided tag type, or None if you want the filter to accept any entity
            with a tag of the provided type.
            :param sort: if True the data obtained through this filter will be sorted by tag_code. Has no effect if the
            tag_code parameter is not None.
            raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                HealthElementByHcPartyTagCodeFilter(
                    tag_type=tag_type,
                    tag_code=tag_code,
                    code_type=None,
                    code_code=None,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )

        def by_ids(self, ids: List[str], sort: bool = False) -> 'HealthElementFilters.Builder':
            """
            The filter will return all health elements with one of the provided ids.
            :param ids: a list of ids.
            :param sort: if True the data obtained through this filter will be returned in the same order as the input ids.
            :raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                HealthElementByIdsFilter(ids),
                sort
            )

        def by_patients(
                self,
                patients_or_secret_ids: List[Union[Patient, str]],
                sort: bool = False
        ) -> 'HealthElementFilters.Builder':
            """
            Get all health elements linked to a patient within the provided group.
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
                HealthElementByHcPartySecretForeignKeysFilter(
                    patient_secret_foreign_keys=secret_ids,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )
