// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'replication_info.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ReplicationInfo {
  bool get active;
  bool get running;
  int? get pendingFrom;
  int? get pendingTo;

  /// Create a copy of ReplicationInfo
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ReplicationInfoCopyWith<ReplicationInfo> get copyWith =>
      _$ReplicationInfoCopyWithImpl<ReplicationInfo>(
          this as ReplicationInfo, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ReplicationInfo &&
            (identical(other.active, active) || other.active == active) &&
            (identical(other.running, running) || other.running == running) &&
            (identical(other.pendingFrom, pendingFrom) ||
                other.pendingFrom == pendingFrom) &&
            (identical(other.pendingTo, pendingTo) ||
                other.pendingTo == pendingTo));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, active, running, pendingFrom, pendingTo);

  @override
  String toString() {
    return 'ReplicationInfo(active: $active, running: $running, pendingFrom: $pendingFrom, pendingTo: $pendingTo)';
  }
}

/// @nodoc
abstract mixin class $ReplicationInfoCopyWith<$Res> {
  factory $ReplicationInfoCopyWith(
          ReplicationInfo value, $Res Function(ReplicationInfo) _then) =
      _$ReplicationInfoCopyWithImpl;
  @useResult
  $Res call({bool active, bool running, int? pendingFrom, int? pendingTo});
}

/// @nodoc
class _$ReplicationInfoCopyWithImpl<$Res>
    implements $ReplicationInfoCopyWith<$Res> {
  _$ReplicationInfoCopyWithImpl(this._self, this._then);

  final ReplicationInfo _self;
  final $Res Function(ReplicationInfo) _then;

  /// Create a copy of ReplicationInfo
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? active = null,
    Object? running = null,
    Object? pendingFrom = freezed,
    Object? pendingTo = freezed,
  }) {
    return _then(_self.copyWith(
      active: null == active
          ? _self.active
          : active // ignore: cast_nullable_to_non_nullable
              as bool,
      running: null == running
          ? _self.running
          : running // ignore: cast_nullable_to_non_nullable
              as bool,
      pendingFrom: freezed == pendingFrom
          ? _self.pendingFrom
          : pendingFrom // ignore: cast_nullable_to_non_nullable
              as int?,
      pendingTo: freezed == pendingTo
          ? _self.pendingTo
          : pendingTo // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }
}

/// @nodoc

class _ReplicationInfo implements ReplicationInfo {
  const _ReplicationInfo(
      {this.active = false,
      this.running = false,
      this.pendingFrom = null,
      this.pendingTo = null});

  @override
  @JsonKey()
  final bool active;
  @override
  @JsonKey()
  final bool running;
  @override
  @JsonKey()
  final int? pendingFrom;
  @override
  @JsonKey()
  final int? pendingTo;

  /// Create a copy of ReplicationInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ReplicationInfoCopyWith<_ReplicationInfo> get copyWith =>
      __$ReplicationInfoCopyWithImpl<_ReplicationInfo>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ReplicationInfo &&
            (identical(other.active, active) || other.active == active) &&
            (identical(other.running, running) || other.running == running) &&
            (identical(other.pendingFrom, pendingFrom) ||
                other.pendingFrom == pendingFrom) &&
            (identical(other.pendingTo, pendingTo) ||
                other.pendingTo == pendingTo));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, active, running, pendingFrom, pendingTo);

  @override
  String toString() {
    return 'ReplicationInfo(active: $active, running: $running, pendingFrom: $pendingFrom, pendingTo: $pendingTo)';
  }
}

/// @nodoc
abstract mixin class _$ReplicationInfoCopyWith<$Res>
    implements $ReplicationInfoCopyWith<$Res> {
  factory _$ReplicationInfoCopyWith(
          _ReplicationInfo value, $Res Function(_ReplicationInfo) _then) =
      __$ReplicationInfoCopyWithImpl;
  @override
  @useResult
  $Res call({bool active, bool running, int? pendingFrom, int? pendingTo});
}

/// @nodoc
class __$ReplicationInfoCopyWithImpl<$Res>
    implements _$ReplicationInfoCopyWith<$Res> {
  __$ReplicationInfoCopyWithImpl(this._self, this._then);

  final _ReplicationInfo _self;
  final $Res Function(_ReplicationInfo) _then;

  /// Create a copy of ReplicationInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? active = null,
    Object? running = null,
    Object? pendingFrom = freezed,
    Object? pendingTo = freezed,
  }) {
    return _then(_ReplicationInfo(
      active: null == active
          ? _self.active
          : active // ignore: cast_nullable_to_non_nullable
              as bool,
      running: null == running
          ? _self.running
          : running // ignore: cast_nullable_to_non_nullable
              as bool,
      pendingFrom: freezed == pendingFrom
          ? _self.pendingFrom
          : pendingFrom // ignore: cast_nullable_to_non_nullable
              as int?,
      pendingTo: freezed == pendingTo
          ? _self.pendingTo
          : pendingTo // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }
}

// dart format on
