from typing import List, Optional

from icure import IcureSdk
from icure.filters.AbstractFilterBuilder import AbstractFilterBuilder
from icure.model import MaintenanceTaskAbstractFilter, MaintenanceTaskByIdsFilter, MaintenanceTaskAfterDateFilter, \
    MaintenanceTaskByHcPartyAndTypeFilter, MaintenanceTaskByHcPartyAndIdentifiersFilter, ComplementFilter, Identifier


class MaintenanceTaskFilters:
    """
    Factory and builder for creating maintenance tasks filters.
    """

    @classmethod
    def complement_filter(cls, super_set: MaintenanceTaskAbstractFilter, sub_set: MaintenanceTaskAbstractFilter) -> MaintenanceTaskAbstractFilter:
        """
        :param super_set: a filter
        :param sub_set: a filter
        :return: A filter that provides all entities that are in super_set but not in subset. The result will preserve
        the same ordering it had in the super_set.
        """
        return ComplementFilter(super_set=super_set, sub_set=sub_set)

    class Builder(AbstractFilterBuilder[MaintenanceTaskAbstractFilter, 'MaintenanceTaskFilters.Builder']):
        """
        Allows to build complex filters for maintenance tasks
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

        def by_ids(self, ids: List[str], sort: bool = False) -> 'MaintenanceTaskFilters.Builder':
            """
            The filter will return all maintenance tasks with one of the provided ids.
            :param ids: a list of ids.
            :param sort: if True the data obtained through this filter will be returned in the same order as the input ids.
            :raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                MaintenanceTaskByIdsFilter(ids),
                sort
            )

        def by_identifiers(self, identifiers: List[Identifier], sort: bool = False) -> 'MaintenanceTaskFilters.Builder':
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
                MaintenanceTaskByHcPartyAndIdentifiersFilter(
                    identifiers=identifiers,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )

        def by_type(
            self,
            type: str,
        ) -> 'MaintenanceTaskFilters.Builder':
            """
            Get all maintenance tasks of a specific type.
            :param type: a maintenance task type.
            :return: self
            """
            return self._add_filter(
                MaintenanceTaskByHcPartyAndTypeFilter(
                    type=type,
                    healthcare_party_id=self.__data_owner_id
                ),
                False
            )

        def after_date(
            self,
            date: int
        ) -> 'MaintenanceTaskFilters.Builder':
            """
            Get all maintenance tasks with a creation date after the provided date.
            :param date: a date
            :return: self
            """
            return self._add_filter(
                MaintenanceTaskAfterDateFilter(
                    date=date,
                    healthcare_party_id=self.__data_owner_id
                ),
                False
            )
