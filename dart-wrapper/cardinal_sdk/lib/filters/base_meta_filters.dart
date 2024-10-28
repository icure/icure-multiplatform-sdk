import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';

extension BaseMetaFilter<E> on Future<BaseFilterOptions<E>> {
  Future<BaseFilterOptions<E>> operator &(Future<BaseFilterOptions<E>> other) async {
    final left = await this;
    final right = await other;
    return await CardinalSdkPlatformInterface.instance.filters.metaFilters.baseIntersection(left, right);
  }

  Future<BaseFilterOptions<E>> operator |(Future<BaseFilterOptions<E>> other) async {
    final left = await this;
    final right = await other;
    return await CardinalSdkPlatformInterface.instance.filters.metaFilters.baseUnion(left, right);
  }

  Future<BaseFilterOptions<E>> operator -(Future<BaseFilterOptions<E>> other) async {
    final left = await this;
    final right = await other;
    return await CardinalSdkPlatformInterface.instance.filters.metaFilters.baseDifference(left, right);
  }
}

extension BaseSortableMetaFilter<E> on Future<BaseSortableFilterOptions<E>> {
  Future<BaseSortableFilterOptions<E>> operator &(Future<BaseFilterOptions<E>> other) async {
    final left = await this;
    final right = await other;
    return await CardinalSdkPlatformInterface.instance.filters.metaFilters.baseSortableIntersection(left, right);
  }

  Future<BaseSortableFilterOptions<E>> operator -(Future<BaseFilterOptions<E>> other) async {
    final left = await this;
    final right = await other;
    return await CardinalSdkPlatformInterface.instance.filters.metaFilters.baseSortableDifference(left, right);
  }
}
