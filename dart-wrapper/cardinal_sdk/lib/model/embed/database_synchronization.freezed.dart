// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'database_synchronization.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DatabaseSynchronization {
  String? get source;
  String? get target;
  String? get filter;
  DatabaseSynchronizationTarget? get localTarget;

  /// Create a copy of DatabaseSynchronization
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DatabaseSynchronizationCopyWith<DatabaseSynchronization> get copyWith =>
      _$DatabaseSynchronizationCopyWithImpl<DatabaseSynchronization>(
          this as DatabaseSynchronization, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DatabaseSynchronization &&
            (identical(other.source, source) || other.source == source) &&
            (identical(other.target, target) || other.target == target) &&
            (identical(other.filter, filter) || other.filter == filter) &&
            (identical(other.localTarget, localTarget) ||
                other.localTarget == localTarget));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, source, target, filter, localTarget);

  @override
  String toString() {
    return 'DatabaseSynchronization(source: $source, target: $target, filter: $filter, localTarget: $localTarget)';
  }
}

/// @nodoc
abstract mixin class $DatabaseSynchronizationCopyWith<$Res> {
  factory $DatabaseSynchronizationCopyWith(DatabaseSynchronization value,
          $Res Function(DatabaseSynchronization) _then) =
      _$DatabaseSynchronizationCopyWithImpl;
  @useResult
  $Res call(
      {String? source,
      String? target,
      String? filter,
      DatabaseSynchronizationTarget? localTarget});
}

/// @nodoc
class _$DatabaseSynchronizationCopyWithImpl<$Res>
    implements $DatabaseSynchronizationCopyWith<$Res> {
  _$DatabaseSynchronizationCopyWithImpl(this._self, this._then);

  final DatabaseSynchronization _self;
  final $Res Function(DatabaseSynchronization) _then;

  /// Create a copy of DatabaseSynchronization
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? source = freezed,
    Object? target = freezed,
    Object? filter = freezed,
    Object? localTarget = freezed,
  }) {
    return _then(_self.copyWith(
      source: freezed == source
          ? _self.source
          : source // ignore: cast_nullable_to_non_nullable
              as String?,
      target: freezed == target
          ? _self.target
          : target // ignore: cast_nullable_to_non_nullable
              as String?,
      filter: freezed == filter
          ? _self.filter
          : filter // ignore: cast_nullable_to_non_nullable
              as String?,
      localTarget: freezed == localTarget
          ? _self.localTarget
          : localTarget // ignore: cast_nullable_to_non_nullable
              as DatabaseSynchronizationTarget?,
    ));
  }
}

/// @nodoc

class _DatabaseSynchronization implements DatabaseSynchronization {
  const _DatabaseSynchronization(
      {this.source = null,
      this.target = null,
      this.filter = null,
      this.localTarget = null});

  @override
  @JsonKey()
  final String? source;
  @override
  @JsonKey()
  final String? target;
  @override
  @JsonKey()
  final String? filter;
  @override
  @JsonKey()
  final DatabaseSynchronizationTarget? localTarget;

  /// Create a copy of DatabaseSynchronization
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DatabaseSynchronizationCopyWith<_DatabaseSynchronization> get copyWith =>
      __$DatabaseSynchronizationCopyWithImpl<_DatabaseSynchronization>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DatabaseSynchronization &&
            (identical(other.source, source) || other.source == source) &&
            (identical(other.target, target) || other.target == target) &&
            (identical(other.filter, filter) || other.filter == filter) &&
            (identical(other.localTarget, localTarget) ||
                other.localTarget == localTarget));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, source, target, filter, localTarget);

  @override
  String toString() {
    return 'DatabaseSynchronization(source: $source, target: $target, filter: $filter, localTarget: $localTarget)';
  }
}

/// @nodoc
abstract mixin class _$DatabaseSynchronizationCopyWith<$Res>
    implements $DatabaseSynchronizationCopyWith<$Res> {
  factory _$DatabaseSynchronizationCopyWith(_DatabaseSynchronization value,
          $Res Function(_DatabaseSynchronization) _then) =
      __$DatabaseSynchronizationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? source,
      String? target,
      String? filter,
      DatabaseSynchronizationTarget? localTarget});
}

/// @nodoc
class __$DatabaseSynchronizationCopyWithImpl<$Res>
    implements _$DatabaseSynchronizationCopyWith<$Res> {
  __$DatabaseSynchronizationCopyWithImpl(this._self, this._then);

  final _DatabaseSynchronization _self;
  final $Res Function(_DatabaseSynchronization) _then;

  /// Create a copy of DatabaseSynchronization
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? source = freezed,
    Object? target = freezed,
    Object? filter = freezed,
    Object? localTarget = freezed,
  }) {
    return _then(_DatabaseSynchronization(
      source: freezed == source
          ? _self.source
          : source // ignore: cast_nullable_to_non_nullable
              as String?,
      target: freezed == target
          ? _self.target
          : target // ignore: cast_nullable_to_non_nullable
              as String?,
      filter: freezed == filter
          ? _self.filter
          : filter // ignore: cast_nullable_to_non_nullable
              as String?,
      localTarget: freezed == localTarget
          ? _self.localTarget
          : localTarget // ignore: cast_nullable_to_non_nullable
              as DatabaseSynchronizationTarget?,
    ));
  }
}

// dart format on
