
class FilterOptions<E> {
  Map<String, dynamic> _json;
  FilterOptions(this._json);

  static Map<String, dynamic> encode(FilterOptions value) {
    return Map.unmodifiable(value._json);
  }

  factory FilterOptions.fromJSON(Map<String, dynamic> data) {
    return FilterOptions(data);
  }
}

class SortableFilterOptions<E> extends FilterOptions<E> {
  SortableFilterOptions(Map<String, dynamic> json) : super(json);

  factory SortableFilterOptions.fromJSON(Map<String, dynamic> data) {
    return SortableFilterOptions(data);
  }
}

class BaseFilterOptions<E> extends FilterOptions<E> {
  BaseFilterOptions(Map<String, dynamic> json) : super(json);

  factory BaseFilterOptions.fromJSON(Map<String, dynamic> data) {
    return BaseFilterOptions(data);
  }
}

class BaseSortableFilterOptions<E> extends BaseFilterOptions<E> implements SortableFilterOptions<E> {
  BaseSortableFilterOptions(Map<String, dynamic> json) : super(json);

  factory BaseSortableFilterOptions.fromJSON(Map<String, dynamic> data) {
    return BaseSortableFilterOptions(data);
  }
}