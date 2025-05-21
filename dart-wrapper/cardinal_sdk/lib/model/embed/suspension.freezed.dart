// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'suspension.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Suspension {
  int? get beginMoment;
  int? get endMoment;
  String? get suspensionReason;
  String? get lifecycle;

  /// Create a copy of Suspension
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $SuspensionCopyWith<Suspension> get copyWith =>
      _$SuspensionCopyWithImpl<Suspension>(this as Suspension, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Suspension &&
            (identical(other.beginMoment, beginMoment) ||
                other.beginMoment == beginMoment) &&
            (identical(other.endMoment, endMoment) ||
                other.endMoment == endMoment) &&
            (identical(other.suspensionReason, suspensionReason) ||
                other.suspensionReason == suspensionReason) &&
            (identical(other.lifecycle, lifecycle) ||
                other.lifecycle == lifecycle));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, beginMoment, endMoment, suspensionReason, lifecycle);

  @override
  String toString() {
    return 'Suspension(beginMoment: $beginMoment, endMoment: $endMoment, suspensionReason: $suspensionReason, lifecycle: $lifecycle)';
  }
}

/// @nodoc
abstract mixin class $SuspensionCopyWith<$Res> {
  factory $SuspensionCopyWith(
          Suspension value, $Res Function(Suspension) _then) =
      _$SuspensionCopyWithImpl;
  @useResult
  $Res call(
      {int? beginMoment,
      int? endMoment,
      String? suspensionReason,
      String? lifecycle});
}

/// @nodoc
class _$SuspensionCopyWithImpl<$Res> implements $SuspensionCopyWith<$Res> {
  _$SuspensionCopyWithImpl(this._self, this._then);

  final Suspension _self;
  final $Res Function(Suspension) _then;

  /// Create a copy of Suspension
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? beginMoment = freezed,
    Object? endMoment = freezed,
    Object? suspensionReason = freezed,
    Object? lifecycle = freezed,
  }) {
    return _then(_self.copyWith(
      beginMoment: freezed == beginMoment
          ? _self.beginMoment
          : beginMoment // ignore: cast_nullable_to_non_nullable
              as int?,
      endMoment: freezed == endMoment
          ? _self.endMoment
          : endMoment // ignore: cast_nullable_to_non_nullable
              as int?,
      suspensionReason: freezed == suspensionReason
          ? _self.suspensionReason
          : suspensionReason // ignore: cast_nullable_to_non_nullable
              as String?,
      lifecycle: freezed == lifecycle
          ? _self.lifecycle
          : lifecycle // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _Suspension implements Suspension {
  const _Suspension(
      {this.beginMoment = null,
      this.endMoment = null,
      this.suspensionReason = null,
      this.lifecycle = null});

  @override
  @JsonKey()
  final int? beginMoment;
  @override
  @JsonKey()
  final int? endMoment;
  @override
  @JsonKey()
  final String? suspensionReason;
  @override
  @JsonKey()
  final String? lifecycle;

  /// Create a copy of Suspension
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$SuspensionCopyWith<_Suspension> get copyWith =>
      __$SuspensionCopyWithImpl<_Suspension>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Suspension &&
            (identical(other.beginMoment, beginMoment) ||
                other.beginMoment == beginMoment) &&
            (identical(other.endMoment, endMoment) ||
                other.endMoment == endMoment) &&
            (identical(other.suspensionReason, suspensionReason) ||
                other.suspensionReason == suspensionReason) &&
            (identical(other.lifecycle, lifecycle) ||
                other.lifecycle == lifecycle));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, beginMoment, endMoment, suspensionReason, lifecycle);

  @override
  String toString() {
    return 'Suspension(beginMoment: $beginMoment, endMoment: $endMoment, suspensionReason: $suspensionReason, lifecycle: $lifecycle)';
  }
}

/// @nodoc
abstract mixin class _$SuspensionCopyWith<$Res>
    implements $SuspensionCopyWith<$Res> {
  factory _$SuspensionCopyWith(
          _Suspension value, $Res Function(_Suspension) _then) =
      __$SuspensionCopyWithImpl;
  @override
  @useResult
  $Res call(
      {int? beginMoment,
      int? endMoment,
      String? suspensionReason,
      String? lifecycle});
}

/// @nodoc
class __$SuspensionCopyWithImpl<$Res> implements _$SuspensionCopyWith<$Res> {
  __$SuspensionCopyWithImpl(this._self, this._then);

  final _Suspension _self;
  final $Res Function(_Suspension) _then;

  /// Create a copy of Suspension
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? beginMoment = freezed,
    Object? endMoment = freezed,
    Object? suspensionReason = freezed,
    Object? lifecycle = freezed,
  }) {
    return _then(_Suspension(
      beginMoment: freezed == beginMoment
          ? _self.beginMoment
          : beginMoment // ignore: cast_nullable_to_non_nullable
              as int?,
      endMoment: freezed == endMoment
          ? _self.endMoment
          : endMoment // ignore: cast_nullable_to_non_nullable
              as int?,
      suspensionReason: freezed == suspensionReason
          ? _self.suspensionReason
          : suspensionReason // ignore: cast_nullable_to_non_nullable
              as String?,
      lifecycle: freezed == lifecycle
          ? _self.lifecycle
          : lifecycle // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
