import json
from typing import overload, TypeVar, List, Union, Any, Tuple
from ctypes import cast, c_char_p
from cardinal_sdk.filters import FilterOptions
from cardinal_sdk.filters.FilterOptions import FilterOptions, SortableFilterOptions, BaseFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json

E = TypeVar('E')


@overload
def intersection(
        a: BaseSortableFilterOptions[E],
        b: BaseFilterOptions[E],
        *others: BaseFilterOptions[E]
) -> BaseSortableFilterOptions[E]:
    pass


@overload
def intersection(
        a: SortableFilterOptions[E],
        b: FilterOptions[E],
        *others: FilterOptions[E]
) -> SortableFilterOptions[E]:
    pass


@overload
def intersection(
        a: BaseFilterOptions[E],
        b: BaseFilterOptions[E],
        *others: BaseFilterOptions[E]
) -> BaseFilterOptions[E]:
    pass


@overload
def intersection(
        a: FilterOptions[E],
        b: FilterOptions[E],
        *others: FilterOptions[E]
) -> FilterOptions[E]:
    pass


def intersection(
        a: FilterOptions[E],
        b: FilterOptions[E],
        *others: FilterOptions[E]
) -> FilterOptions[E]:
    """
    Create filter options that match entities that satisfy all provided filters (at least 2 filters are required).

    If the first provided filter options `a` are sortable then the returned filter options are sortable using the same
    criteria as `a`.
    If all filters options provided are base filters options then the returned filter options are also base options.
    :param a:
    :param b:
    :param others:
    :return:
    """
    json_data = json.dumps({
        "filters": [x.__serialize__() for x in ([a, b] + list(others))]
    })
    call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MetaFilters.intersection(json_data.encode('utf-8'))
    result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
    symbols.DisposeString(call_result)
    if result_info.failure is not None:
        raise Exception(result_info.failure)
    else:
        filter_type = result_info.success["kotlinType"]
        if filter_type == "com.icure.cardinal.sdk.filters.SortableIntersectionFilterOptions":
            return SortableFilterOptions(result_info.success)
        elif filter_type == "com.icure.cardinal.sdk.filters.IntersectionFilterOptions":
            return FilterOptions(result_info.success)
        elif filter_type == "com.icure.cardinal.sdk.filters.BaseSortableIntersectionFilterOptions":
            return BaseSortableFilterOptions(result_info.success)
        elif filter_type == "com.icure.cardinal.sdk.filters.BaseIntersectionFilterOptions":
            return BaseFilterOptions(result_info.success)
        else:
            raise Exception(f"Internal error: unexpected type of filter options returned by intersection method: {filter_type}")


@overload
def union(
        a: BaseFilterOptions[E],
        b: BaseFilterOptions[E],
        *others: BaseFilterOptions[E]
) -> BaseFilterOptions[E]:
    pass


@overload
def union(
        a: FilterOptions[E],
        b: FilterOptions[E],
        *others: FilterOptions[E]
) -> FilterOptions[E]:
    pass


def union(
        a: FilterOptions[E],
        b: FilterOptions[E],
        *others: FilterOptions[E]
) -> FilterOptions[E]:
    """
    Create filter options that match entities that satisfy at least one of the provided filters (at least 2 filters are
     required).

     These options are never sortable.
     If all filters options provided are base filters options then the returned filter options are also base options.
    :param a:
    :param b:
    :param others:
    :return:
    """
    json_data = json.dumps({
        "filters": [x.__serialize__() for x in ([a, b] + list(others))]
    })
    # `union` is reserved in c, kotlin changes it to union_
    call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MetaFilters.union_(json_data.encode('utf-8'))
    result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
    symbols.DisposeString(call_result)
    if result_info.failure is not None:
        raise Exception(result_info.failure)
    else:
        filter_type = result_info.success["kotlinType"]
        if filter_type == "com.icure.cardinal.sdk.filters.UnionFilterOptions":
            return FilterOptions(result_info.success)
        elif filter_type == "com.icure.cardinal.sdk.filters.BaseUnionFilterOptions":
            return BaseFilterOptions(result_info.success)
        else:
            raise Exception(f"Internal error: unexpected type of filter options returned by union method: {filter_type}")


@overload
def difference(
        of: BaseSortableFilterOptions[E],
        subtracting: BaseFilterOptions[E]
) -> BaseSortableFilterOptions[E]:
    pass


@overload
def difference(
        of: SortableFilterOptions[E],
        subtracting: FilterOptions[E]
) -> SortableFilterOptions[E]:
    pass


@overload
def difference(
        of: BaseFilterOptions[E],
        subtracting: BaseFilterOptions[E]
) -> BaseFilterOptions[E]:
    pass


@overload
def difference(
        of: FilterOptions[E],
        subtracting: FilterOptions[E]
) -> FilterOptions[E]:
    pass


def difference(
        of: FilterOptions[E],
        subtracting: FilterOptions[E]
) -> FilterOptions[E]:
    """
    Create filter options that match entities that satisfy the `of` filter but do not satisfy the `subtracting` filter.
    If the first provided filter options `of` are sortable then the returned filter options are sortable using the same
    criteria as `of`.
    If all filters options provided are base filters options then the returned filter options are also base options.
    :param of:
    :param subtracting:
    :return:
    """
    json_data = json.dumps({
        "of": of.__serialize__(),
        "subtracting": subtracting.__serialize__()
    })
    call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.MetaFilters.difference(json_data.encode('utf-8'))
    result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
    symbols.DisposeString(call_result)
    if result_info.failure is not None:
        raise Exception(result_info.failure)
    else:
        filter_type = result_info.success["kotlinType"]
        if filter_type == "com.icure.cardinal.sdk.filters.SortableDifferenceFilterOptions":
            return SortableFilterOptions(result_info.success)
        elif filter_type == "com.icure.cardinal.sdk.filters.DifferenceFilterOptions":
            return FilterOptions(result_info.success)
        elif filter_type == "com.icure.cardinal.sdk.filters.BaseSortableDifferenceFilterOptions":
            return BaseSortableFilterOptions(result_info.success)
        elif filter_type == "com.icure.cardinal.sdk.filters.BaseDifferenceFilterOptions":
            return BaseFilterOptions(result_info.success)
        else:
            raise Exception(f"Internal error: unexpected type of filter options returned by difference method: {filter_type}")
