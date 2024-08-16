import {
  FilterOptions,
  SortableFilterOptions,
  BaseSortableFilterOptions,
  BaseFilterOptions,
  InternalFilterOptions
} from "../icure-sdk-ts.mjs"
import {Identifiable} from "../model/base/Identifiable.mjs";

/**
 * Create filter options that match entities that satisfy all provided filters (at least 2 filters are required).
 *
 * If the first provided filter options {@link a} is sortable then these filter options are sortable using the same criteria as {@link a}.
 * If all filters options provided are base filters options then the returned filter options are also base options.
 *
 * @param a
 * @param b
 * @param others
 */
function intersection<T extends Identifiable<string>>(a: BaseSortableFilterOptions<T>, b: BaseFilterOptions<T>, ...others: BaseFilterOptions<T>[]): BaseSortableFilterOptions<T>
function intersection<T extends Identifiable<string>>(a: BaseFilterOptions<T>, b: BaseFilterOptions<T>, ...others: BaseFilterOptions<T>[]): BaseFilterOptions<T>
function intersection<T extends Identifiable<string>>(a: SortableFilterOptions<T>, b: FilterOptions<T>, ...others: FilterOptions<T>[]): SortableFilterOptions<T>
function intersection<T extends Identifiable<string>>(a: FilterOptions<T>, b: FilterOptions<T>, ...others: FilterOptions<T>[]): FilterOptions<T>
function intersection<T extends Identifiable<string>>(a: FilterOptions<T>, b: FilterOptions<T>, ...others: FilterOptions<T>[]): FilterOptions<T> {
  return InternalFilterOptions.getInstance().intersection(a, b, others)
}

/**
 * Create filter options that match entities that satisfy at least one of the provided filters (at least 2 filters are required).
 *
 * These options are never sortable.
 * If all filters options provided are base filters options then the returned filter options are also base options.
 *
 * @param a
 * @param b
 * @param others
 */
function union<T extends Identifiable<string>>(a: BaseFilterOptions<T>, b: BaseFilterOptions<T>, ...others: BaseFilterOptions<T>[]): BaseFilterOptions<T>
function union<T extends Identifiable<string>>(a: FilterOptions<T>, b: FilterOptions<T>, ...others: FilterOptions<T>[]): FilterOptions<T>
function union<T extends Identifiable<string>>(a: FilterOptions<T>, b: FilterOptions<T>, ...others: FilterOptions<T>[]): FilterOptions<T> {
  return InternalFilterOptions.getInstance().union(a, b, others)
}

/**
 * Create filter options that match entities that satisfy the {@link of} filter but do not satisfy the {@link subtracting} filter.
 *
 * If the first provided filter options {@link of} is sortable then these filter options are sortable using the same criteria as {@link of}.
 * If all filters options provided are base filters options then the returned filter options are also base options.
 *
 * @param of
 * @param subtracting
 */
function difference<T extends Identifiable<string>>(of: BaseSortableFilterOptions<T>, subtracting: BaseFilterOptions<T>): BaseSortableFilterOptions<T>
function difference<T extends Identifiable<string>>(of: BaseFilterOptions<T>, subtracting: BaseFilterOptions<T>): BaseFilterOptions<T>
function difference<T extends Identifiable<string>>(of: SortableFilterOptions<T>, subtracting: FilterOptions<T>): SortableFilterOptions<T>
function difference<T extends Identifiable<string>>(of: FilterOptions<T>, subtracting: FilterOptions<T>): FilterOptions<T>
function difference<T extends Identifiable<string>>(of: FilterOptions<T>, subtracting: FilterOptions<T>): FilterOptions<T> {
  return InternalFilterOptions.getInstance().difference(of, subtracting)
}