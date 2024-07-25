from typing import List

from icure.filters.AbstractFilterBuilder import AbstractFilterBuilder
from icure.model import ComplementFilter, DeviceAbstractFilter, AllDevicesFilter, DeviceByIdsFilter, \
    DeviceByHcPartyFilter


class DeviceFilters:
    """
    Factory and builder for creating device filters.
    """

    @classmethod
    def complement_filter(cls, super_set: DeviceAbstractFilter, sub_set: DeviceAbstractFilter) -> DeviceAbstractFilter:
        """
        :param super_set: a filter
        :param sub_set: a filter
        :return: A filter that provides all entities that are in super_set but not in subset. The result will preserve
        the same ordering it had in the super_set.
        """
        return ComplementFilter(super_set=super_set, sub_set=sub_set)

    @classmethod
    def all_devices_filter(cls) -> DeviceAbstractFilter:
        """
        :return: A filter to get all devices
        """
        return AllDevicesFilter()

    class Builder(AbstractFilterBuilder[DeviceAbstractFilter, 'DeviceFilters.Builder']):
        def by_responsible(self, responsible_id: str) -> 'DeviceFilters.Builder':
            """
            All devices where the responsible is the provided
            :param responsible_id: the id of the responsible (must match exactly)
            :return: self
            """
            return self._add_filter(
                DeviceByHcPartyFilter(responsible_id=responsible_id),
                False
            )

        def by_ids(self, ids: List[str], sort: bool = False) -> 'DeviceFilters.Builder':
            """
            All devices with one of the provided ids
            :param ids: a list of ids
            :param sort: if True the data obtained through this filter will be returned in the same order as the input ids.
            :raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                DeviceByIdsFilter(ids=ids),
                sort
            )
