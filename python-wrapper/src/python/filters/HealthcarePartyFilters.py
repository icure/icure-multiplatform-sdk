from typing import List, Optional

from icure.filters.AbstractFilterBuilder import AbstractFilterBuilder
from icure.model import HealthcarePartyAbstractFilter, ComplementFilter, AllHealthcarePartiesFilter, \
    HealthcarePartyByIdsFilter, HealthcarePartyByNameFilter, HealthcarePartyByIdentifiersFilter, \
    HealthcarePartyByTagCodeFilter, Identifier


class HealthcarePartyFilters:
    """
    Factory and builder for creating healthcare party filters.
    """

    @classmethod
    def complement_filter(cls, super_set: HealthcarePartyAbstractFilter, sub_set: HealthcarePartyAbstractFilter) -> HealthcarePartyAbstractFilter:
        """
        :param super_set: a filter
        :param sub_set: a filter
        :return: A filter that provides all entities that are in super_set but not in subset. The result will preserve
        the same ordering it had in the super_set.
        """
        return ComplementFilter(super_set=super_set, sub_set=sub_set)

    @classmethod
    def all_devices_filter(cls) -> HealthcarePartyAbstractFilter:
        """
        :return: A filter to get all devices
        """
        return AllHealthcarePartiesFilter()

    class Builder(AbstractFilterBuilder[HealthcarePartyAbstractFilter, 'HealthcarePartyFilters.Builder']):
        def by_identifiers(self, identifiers: List[Identifier], sort: bool = False) -> 'HealthcarePartyFilters.Builder':
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
                HealthcarePartyByIdentifiersFilter(
                    identifiers=identifiers
                ),
                sort
            )

        def by_code(
                self,
                code_type: str,
                code_code: Optional[str],
                sort: bool = False
        ) -> 'HealthcarePartyFilters.Builder':
            """
            Get all healthcare parties that have a certain code. If you specify only the code type you will get all
            entities that have at least a code of that type.
            :param code_type: a code type
            :param code_code: a code for the provided code type, or None if you want the filter to accept any entity
            with a code of the provided type.
            :param sort: if True the data obtained through this filter will be sorted by code_code. Has no effect if
            code_code parameter is not None.
            raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                HealthcarePartyByTagCodeFilter(
                    tag_type=None,
                    tag_code=None,
                    code_type=code_type,
                    code_code=code_code,
                ),
                sort
            )

        def by_tag(
                self,
                tag_type: str,
                tag_code: Optional[str],
                sort: bool = False
        ) -> 'HealthcarePartyFilters.Builder':
            """
            Get all healthcare parties that have a certain tag. If you specify only the tag type you will get all
            entities that have at least a tag of that type.
            :param tag_type: a tag type
            :param tag_code: a code for the provided tag type, or None if you want the filter to accept any entity
            with a tag of the provided type.
            :param sort: if True the data obtained through this filter will be sorted by tag_code. Has no effect if the
            tag_code parameter is not None.
            raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                HealthcarePartyByTagCodeFilter(
                    tag_type=tag_type,
                    tag_code=tag_code,
                    code_type=None,
                    code_code=None,
                ),
                sort
            )

        def by_ids(self, ids: List[str], sort: bool = False) -> 'HealthcarePartyFilters.Builder':
            """
            The filter will return all healthcare parties with one of the provided ids..
            :param ids: a list of ids.
            :param sort: if True the data obtained through this filter will be returned in the same order as the input ids.
            :raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                HealthcarePartyByIdsFilter(ids),
                sort
            )

        def by_name(self, search_string: str, sort: bool = False, descending: bool = False):
            """
            Get all healthcare parties where the normalized last_name+first_name or speciality contain the provided
            search string.
            :param search_string: a string to search for
            :param sort: if True the results will be sorted by lexicographically by the matching last_name+first_name or
            speciality substring. If a healthcare party has multiple matching substrings only the first will be
            considered.
            :param descending: set to True if sort is True and you want to invert the sorting order.
            :return: self
            """
            return self._add_filter(
                HealthcarePartyByNameFilter(name=search_string, descending=descending),
                sort
            )
