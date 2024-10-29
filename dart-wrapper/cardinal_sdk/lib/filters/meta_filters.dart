import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';

extension MetaFilter<E> on Future<FilterOptions<E>> {
  Future<FilterOptions<E>> operator &(Future<FilterOptions<E>> other) async {
    final left = await this;
    final right = await other;
    return await CardinalSdkPlatformInterface.instance.filters.metaFilters.intersection(left, right);
  }

  Future<FilterOptions<E>> operator |(Future<FilterOptions<E>> other) async {
    final left = await this;
    final right = await other;
    return await CardinalSdkPlatformInterface.instance.filters.metaFilters.union(left, right);
  }

  Future<FilterOptions<E>> operator -(Future<FilterOptions<E>> other) async {
    final left = await this;
    final right = await other;
    return await CardinalSdkPlatformInterface.instance.filters.metaFilters.difference(left, right);
  }
}

extension SortableMetaFilter<E> on Future<SortableFilterOptions<E>> {
  Future<SortableFilterOptions<E>> operator &(Future<FilterOptions<E>> other) async {
    final left = await this;
    final right = await other;
    return await CardinalSdkPlatformInterface.instance.filters.metaFilters.sortableIntersection(left, right);
  }

  Future<SortableFilterOptions<E>> operator -(Future<FilterOptions<E>> other) async {
    final left = await this;
    final right = await other;
    return await CardinalSdkPlatformInterface.instance.filters.metaFilters.sortableDifference(left, right);
  }
}
