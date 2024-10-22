
class FilterOptions<E> {
  Map<String, dynamic> json;
  FilterOptions(this.json);
}

class SortableFilterOptions<E> extends FilterOptions<E> {
  SortableFilterOptions(Map<String, dynamic> json) : super(json);
}

class BaseFilterOptions<E> extends FilterOptions<E> {
  BaseFilterOptions(Map<String, dynamic> json) : super(json);
}

class BaseSortableFilterOptions<E> extends BaseFilterOptions<E> implements SortableFilterOptions<E> {
  BaseSortableFilterOptions(Map<String, dynamic> json) : super(json);
}