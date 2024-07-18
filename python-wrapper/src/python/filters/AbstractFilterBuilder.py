from abc import ABC, abstractmethod
from typing import Generic, TypeVar, List
from icure.model import UnionFilter, IntersectionFilter


F = TypeVar('F')
B = TypeVar('B')


class AbstractFilterBuilder(ABC, Generic[F, B]):
    _filters: List[F] = []
    _uses_sorting: bool = False

    def build(self, as_union: bool = False) -> F:
        """
        Build a filter that combines all requirements set in this builder. By default the returned filter will be an
        intersection of the requirements, meaning that only entities that satisfy all requirements will be returned.
        You can also build a union filter by setting the `as_union` parameter to True. Note however that you can't
        use sorting with union filter.
        :param as_union: True if the returned filter should be a union filter.
        :return: a filter that combines all requirements set in this builder.
        :raises ValueError: if as_union is true but the builder is sorted, or if no requirements where provided.
        """
        if len(self._filters) <= 0:
            raise ValueError("No filter provided")
        if as_union:
            if self._uses_sorting:
                raise ValueError("Union filters can't be sorted")
            return UnionFilter(filters=self._filters.copy())
        else:
            return IntersectionFilter(filters=self._filters.copy())

    def by_filter(self, filter: F) -> B:
        """
        Uses the provided filter. Useful only if you want to make a combination of union and intersection filters.
        :param filter: a filter
        :return: self
        """
        return self._add_filter(filter, False)

    def _add_filter(self, filter: F, sort: bool) -> B:
        if sort:
            if self._uses_sorting:
                raise ValueError("Data can only be sorted for one filter")
            else:
                self._uses_sorting = True
                self._filters.insert(0, filter)
        else:
            self._filters.append(filter)
        return self