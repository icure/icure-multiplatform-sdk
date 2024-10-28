import 'dart:convert';

import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:flutter/services.dart';

class PlatformMetaFilters {
  MethodChannel _methodChannel;
  PlatformMetaFilters(this._methodChannel);

  Future<FilterOptions<E>> intersection<E>(FilterOptions<E> left, FilterOptions<E> right) async {
    final res = await _methodChannel.invokeMethod<String>('MetaFilters.intersection', {
      "left": jsonEncode(FilterOptions.encode(left)),
      "right": jsonEncode(FilterOptions.encode(right)),
    });
    if (res == null) throw AssertionError("received null result from platform method intersection");
    final parsedResJson = jsonDecode(res);
    return FilterOptions.fromJSON(parsedResJson);
  }

  Future<SortableFilterOptions<E>> sortableIntersection<E>(SortableFilterOptions<E> left, FilterOptions<E> right) async {
    final res = await _methodChannel.invokeMethod<String>('MetaFilters.sortableIntersection', {
      "left": jsonEncode(FilterOptions.encode(left)),
      "right": jsonEncode(FilterOptions.encode(right)),
    });
    if (res == null) throw AssertionError("received null result from platform method sortableIntersection");
    final parsedResJson = jsonDecode(res);
    return SortableFilterOptions.fromJSON(parsedResJson);
  }

  Future<BaseFilterOptions<E>> baseIntersection<E>(BaseFilterOptions<E> left, BaseFilterOptions<E> right) async {
    final res = await _methodChannel.invokeMethod<String>('MetaFilters.baseIntersection', {
      "left": jsonEncode(FilterOptions.encode(left)),
      "right": jsonEncode(FilterOptions.encode(right)),
    });
    if (res == null) throw AssertionError("received null result from platform method baseIntersection");
    final parsedResJson = jsonDecode(res);
    return BaseFilterOptions.fromJSON(parsedResJson);
  }

  Future<BaseSortableFilterOptions<E>> baseSortableIntersection<E>(
      BaseSortableFilterOptions<E> left, BaseFilterOptions<E> right) async {
    final res = await _methodChannel.invokeMethod<String>('MetaFilters.baseSortableIntersection', {
      "left": jsonEncode(FilterOptions.encode(left)),
      "right": jsonEncode(FilterOptions.encode(right)),
    });
    if (res == null) throw AssertionError("received null result from platform method baseSortableIntersection");
    final parsedResJson = jsonDecode(res);
    return BaseSortableFilterOptions.fromJSON(parsedResJson);
  }

  Future<FilterOptions<E>> difference<E>(FilterOptions<E> left, FilterOptions<E> right) async {
    final res = await _methodChannel.invokeMethod<String>('MetaFilters.difference', {
      "left": jsonEncode(FilterOptions.encode(left)),
      "right": jsonEncode(FilterOptions.encode(right)),
    });
    if (res == null) throw AssertionError("received null result from platform method difference");
    final parsedResJson = jsonDecode(res);
    return FilterOptions.fromJSON(parsedResJson);
  }

  Future<SortableFilterOptions<E>> sortableDifference<E>(SortableFilterOptions<E> left, FilterOptions<E> right) async {
    final res = await _methodChannel.invokeMethod<String>('MetaFilters.sortableDifference', {
      "left": jsonEncode(FilterOptions.encode(left)),
      "right": jsonEncode(FilterOptions.encode(right)),
    });
    if (res == null) throw AssertionError("received null result from platform method sortableDifference");
    final parsedResJson = jsonDecode(res);
    return SortableFilterOptions.fromJSON(parsedResJson);
  }

  Future<BaseFilterOptions<E>> baseDifference<E>(BaseFilterOptions<E> left, BaseFilterOptions<E> right) async {
    final res = await _methodChannel.invokeMethod<String>('MetaFilters.baseDifference', {
      "left": jsonEncode(FilterOptions.encode(left)),
      "right": jsonEncode(FilterOptions.encode(right)),
    });
    if (res == null) throw AssertionError("received null result from platform method baseDifference");
    final parsedResJson = jsonDecode(res);
    return BaseFilterOptions.fromJSON(parsedResJson);
  }

  Future<BaseSortableFilterOptions<E>> baseSortableDifference<E>(
      BaseSortableFilterOptions<E> left, BaseFilterOptions<E> right) async {
    final res = await _methodChannel.invokeMethod<String>('MetaFilters.baseSortableDifference', {
      "left": jsonEncode(FilterOptions.encode(left)),
      "right": jsonEncode(FilterOptions.encode(right)),
    });
    if (res == null) throw AssertionError("received null result from platform method baseSortableDifference");
    final parsedResJson = jsonDecode(res);
    return BaseSortableFilterOptions.fromJSON(parsedResJson);
  }

  Future<FilterOptions<E>> union<E>(FilterOptions<E> left, FilterOptions<E> right) async {
    final res = await _methodChannel.invokeMethod<String>('MetaFilters.union', {
      "left": jsonEncode(FilterOptions.encode(left)),
      "right": jsonEncode(FilterOptions.encode(right)),
    });
    if (res == null) throw AssertionError("received null result from platform method union");
    final parsedResJson = jsonDecode(res);
    return FilterOptions.fromJSON(parsedResJson);
  }

  Future<BaseFilterOptions<E>> baseUnion<E>(BaseFilterOptions<E> left, BaseFilterOptions<E> right) async {
    final res = await _methodChannel.invokeMethod<String>('MetaFilters.baseUnion', {
      "left": jsonEncode(FilterOptions.encode(left)),
      "right": jsonEncode(FilterOptions.encode(right)),
    });
    if (res == null) throw AssertionError("received null result from platform method baseUnion");
    final parsedResJson = jsonDecode(res);
    return BaseFilterOptions.fromJSON(parsedResJson);
  }
}
