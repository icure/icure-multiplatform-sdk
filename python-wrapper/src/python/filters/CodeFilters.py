from typing import List, Optional

from icure.filters.AbstractFilterBuilder import AbstractFilterBuilder
from icure.model import ComplementFilter, CodeAbstractFilter, AllCodesFilter, CodeByIdsFilter, \
    CodeByRegionTypeLabelLanguageFilter, CodeIdsByTypeCodeVersionIntervalFilter


class CodeFilters:
    """
    Factory and builder for creating code filters.
    """

    @classmethod
    def complement_filter(cls, super_set: CodeAbstractFilter, sub_set: CodeAbstractFilter) -> CodeAbstractFilter:
        """
        :param super_set: a filter
        :param sub_set: a filter
        :return: A filter that provides all entities that are in super_set but not in subset. The result will preserve
        the same ordering it had in the super_set.
        """
        return ComplementFilter(super_set=super_set, sub_set=sub_set)

    @classmethod
    def all_codes_filter(cls):
        """
        :return: A filter to get all codes.
        """
        return AllCodesFilter()

    class Builder(AbstractFilterBuilder[CodeAbstractFilter, 'CodeFilters.Builder']):
        """
        Allows to build complex filters for codes.
        """

        def __init__(self):
            """
            Initializes the filter builder.
            """

        def by_ids(self, ids: List[str], sort: bool = False) -> 'CodeFilters.Builder':
            """
            The filter will return all the codes with one of the provided ids.
            :param ids: a list of ids.
            :param sort: if True the data obtained through this filter will be returned in the same order as the input ids.
            :raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                CodeByIdsFilter(ids),
                sort
            )

        def by_language_type_label_region(self, language: str, type: str, label: Optional[str], region: Optional[str], sort: bool = True) -> 'CodeFilters.Builder':
            """
            The filter will return all the codes of a type that matches a certain label in a specific language.
            :param language: the language in ISO standard of the label. Only the codes that have this language as key
                in the `labels` dict will be included in the result.
            :param type: the type of the code. Only the codes with this `type` will be included in the result.
            :param label: a search string. If not None, then only the codes that in the `labels` dict, for the specified
                language, have a value that starts with the specified search string will be included in the result. If
                None, the resulting codes will not be filtered based on the labels.
            :param region: If not None, only the codes that have this region in the `regions` list will be included in
                the result. If None, the resulting codes will not be filtered based on the region.
            :param sort: if True the data obtained through this filter will be returned in the same order as the input ids.
            :return: self
            """
            return self._add_filter(
                CodeByRegionTypeLabelLanguageFilter(
                    type=type,
                    language=language,
                    desc=None,
                    label=label,
                    region=region
                ),
                sort
            )

        def by_type_code_version_interval(self, start_type: Optional[str], start_code: Optional[str], start_version: Optional[str], end_type: Optional[str], end_code: Optional[str], end_version: Optional[str]) -> 'CodeFilters.Builder':
            """
            The filter will return all the codes between (start_type, start_code, start_version) and (end_type,
            end_code, end_version), inclusive, ordered lexicographically by `type`, `code`, `version`. If no element of
            the starting triplet is specified, then all the filters since the beginning will be returned. If no element
            of the ending triplet is specified, then all the filters until the end will be returned.
            In each triplet, if `code` is not None, then `type` must be not None and if `version` is not None then
            `code` must be not None.
            Example: `by_type_code_version("TYPE_A", "CODE_C", "1", "TYPE_C", "CODE_A", "2")` will return all the codes
            between ("TYPE_A", "CODE_C", "1") and ("TYPE_C", "CODE_A", "2").
            ("TYPE_B", "CODE_C", "3") WILL be returned, because "TYPE_A" > "TYPE_B" > "TYPE_C".
            ("TYPE_A", "CODE_A", "2") WILL NOT be returned because "TYPE_A" == "TYPE_A" byt "CODE_A" < "CODE_C"
            :param start_type: the start `type`. (optional, but required if start_code is not None).
            :param start_code: the start `code` (optional, but required if start_version is not None).
            :param start_version: the start `version` (optional)
            :param end_type: the end `type`. (optional, but required if end_code is not None).
            :param end_code: the end `code` (optional, but required if end_version is not None).
            :param end_version: the end `version`. (optional)
            :raises ValueError: if code is not None and type is None or if version is not None and code is None.
            :return: self
            """
            if start_code is not None and start_type is None:
                raise ValueError("Cannot specify a start_code without a start_type")
            if start_version is not None and start_code is None:
                raise ValueError("Cannot specify a start_version without a start_code")
            if end_code is not None and end_type is None:
                raise ValueError("Cannot specify a end_code without a end_type")
            if end_version is not None and end_code is None:
                raise ValueError("Cannot specify a end_version without a end_code")
            return self._add_filter(
                CodeIdsByTypeCodeVersionIntervalFilter(
                    start_type=start_type,
                    start_code=start_code,
                    start_version=start_version,
                    end_type=end_type,
                    end_code=end_code,
                    end_version=end_version
                ),
                False
            )
