from typing import Generic, TypeVar


E = TypeVar('E')


class FilterOptions(Generic[E]):
    def __init__(self, json: object):
        self._json = json

    def __serialize__(self) -> object:
        return self._json


class SortableFilterOptions(FilterOptions[E]):
    def __init__(self, json: object):
        super().__init__(json)


class BaseFilterOptions(FilterOptions[E]):
    def __init__(self, json: object):
        super().__init__(json)


class BaseSortableFilterOptions(BaseFilterOptions[E], SortableFilterOptions[E]):
    def __init__(self, json: object):
        super().__init__(json)
