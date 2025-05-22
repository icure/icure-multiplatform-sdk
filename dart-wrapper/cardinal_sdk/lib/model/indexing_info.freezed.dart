// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'indexing_info.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$IndexingInfo {
  Map<String, int>? get statuses;

  /// Create a copy of IndexingInfo
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $IndexingInfoCopyWith<IndexingInfo> get copyWith =>
      _$IndexingInfoCopyWithImpl<IndexingInfo>(
          this as IndexingInfo, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is IndexingInfo &&
            const DeepCollectionEquality().equals(other.statuses, statuses));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, const DeepCollectionEquality().hash(statuses));

  @override
  String toString() {
    return 'IndexingInfo(statuses: $statuses)';
  }
}

/// @nodoc
abstract mixin class $IndexingInfoCopyWith<$Res> {
  factory $IndexingInfoCopyWith(
          IndexingInfo value, $Res Function(IndexingInfo) _then) =
      _$IndexingInfoCopyWithImpl;
  @useResult
  $Res call({Map<String, int>? statuses});
}

/// @nodoc
class _$IndexingInfoCopyWithImpl<$Res> implements $IndexingInfoCopyWith<$Res> {
  _$IndexingInfoCopyWithImpl(this._self, this._then);

  final IndexingInfo _self;
  final $Res Function(IndexingInfo) _then;

  /// Create a copy of IndexingInfo
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? statuses = freezed,
  }) {
    return _then(_self.copyWith(
      statuses: freezed == statuses
          ? _self.statuses
          : statuses // ignore: cast_nullable_to_non_nullable
              as Map<String, int>?,
    ));
  }
}

/// @nodoc

class _IndexingInfo implements IndexingInfo {
  const _IndexingInfo({final Map<String, int>? statuses = null})
      : _statuses = statuses;

  final Map<String, int>? _statuses;
  @override
  @JsonKey()
  Map<String, int>? get statuses {
    final value = _statuses;
    if (value == null) return null;
    if (_statuses is EqualUnmodifiableMapView) return _statuses;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(value);
  }

  /// Create a copy of IndexingInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$IndexingInfoCopyWith<_IndexingInfo> get copyWith =>
      __$IndexingInfoCopyWithImpl<_IndexingInfo>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _IndexingInfo &&
            const DeepCollectionEquality().equals(other._statuses, _statuses));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, const DeepCollectionEquality().hash(_statuses));

  @override
  String toString() {
    return 'IndexingInfo(statuses: $statuses)';
  }
}

/// @nodoc
abstract mixin class _$IndexingInfoCopyWith<$Res>
    implements $IndexingInfoCopyWith<$Res> {
  factory _$IndexingInfoCopyWith(
          _IndexingInfo value, $Res Function(_IndexingInfo) _then) =
      __$IndexingInfoCopyWithImpl;
  @override
  @useResult
  $Res call({Map<String, int>? statuses});
}

/// @nodoc
class __$IndexingInfoCopyWithImpl<$Res>
    implements _$IndexingInfoCopyWith<$Res> {
  __$IndexingInfoCopyWithImpl(this._self, this._then);

  final _IndexingInfo _self;
  final $Res Function(_IndexingInfo) _then;

  /// Create a copy of IndexingInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? statuses = freezed,
  }) {
    return _then(_IndexingInfo(
      statuses: freezed == statuses
          ? _self._statuses
          : statuses // ignore: cast_nullable_to_non_nullable
              as Map<String, int>?,
    ));
  }
}

// dart format on
