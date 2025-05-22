// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'renewal.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Renewal {
  int? get decimal;
  Duration? get duration;

  /// Create a copy of Renewal
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $RenewalCopyWith<Renewal> get copyWith =>
      _$RenewalCopyWithImpl<Renewal>(this as Renewal, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Renewal &&
            (identical(other.decimal, decimal) || other.decimal == decimal) &&
            (identical(other.duration, duration) ||
                other.duration == duration));
  }

  @override
  int get hashCode => Object.hash(runtimeType, decimal, duration);

  @override
  String toString() {
    return 'Renewal(decimal: $decimal, duration: $duration)';
  }
}

/// @nodoc
abstract mixin class $RenewalCopyWith<$Res> {
  factory $RenewalCopyWith(Renewal value, $Res Function(Renewal) _then) =
      _$RenewalCopyWithImpl;
  @useResult
  $Res call({int? decimal, Duration? duration});

  $DurationCopyWith<$Res>? get duration;
}

/// @nodoc
class _$RenewalCopyWithImpl<$Res> implements $RenewalCopyWith<$Res> {
  _$RenewalCopyWithImpl(this._self, this._then);

  final Renewal _self;
  final $Res Function(Renewal) _then;

  /// Create a copy of Renewal
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? decimal = freezed,
    Object? duration = freezed,
  }) {
    return _then(_self.copyWith(
      decimal: freezed == decimal
          ? _self.decimal
          : decimal // ignore: cast_nullable_to_non_nullable
              as int?,
      duration: freezed == duration
          ? _self.duration
          : duration // ignore: cast_nullable_to_non_nullable
              as Duration?,
    ));
  }

  /// Create a copy of Renewal
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DurationCopyWith<$Res>? get duration {
    if (_self.duration == null) {
      return null;
    }

    return $DurationCopyWith<$Res>(_self.duration!, (value) {
      return _then(_self.copyWith(duration: value));
    });
  }
}

/// @nodoc

class _Renewal implements Renewal {
  const _Renewal({this.decimal = null, this.duration = null});

  @override
  @JsonKey()
  final int? decimal;
  @override
  @JsonKey()
  final Duration? duration;

  /// Create a copy of Renewal
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$RenewalCopyWith<_Renewal> get copyWith =>
      __$RenewalCopyWithImpl<_Renewal>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Renewal &&
            (identical(other.decimal, decimal) || other.decimal == decimal) &&
            (identical(other.duration, duration) ||
                other.duration == duration));
  }

  @override
  int get hashCode => Object.hash(runtimeType, decimal, duration);

  @override
  String toString() {
    return 'Renewal(decimal: $decimal, duration: $duration)';
  }
}

/// @nodoc
abstract mixin class _$RenewalCopyWith<$Res> implements $RenewalCopyWith<$Res> {
  factory _$RenewalCopyWith(_Renewal value, $Res Function(_Renewal) _then) =
      __$RenewalCopyWithImpl;
  @override
  @useResult
  $Res call({int? decimal, Duration? duration});

  @override
  $DurationCopyWith<$Res>? get duration;
}

/// @nodoc
class __$RenewalCopyWithImpl<$Res> implements _$RenewalCopyWith<$Res> {
  __$RenewalCopyWithImpl(this._self, this._then);

  final _Renewal _self;
  final $Res Function(_Renewal) _then;

  /// Create a copy of Renewal
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? decimal = freezed,
    Object? duration = freezed,
  }) {
    return _then(_Renewal(
      decimal: freezed == decimal
          ? _self.decimal
          : decimal // ignore: cast_nullable_to_non_nullable
              as int?,
      duration: freezed == duration
          ? _self.duration
          : duration // ignore: cast_nullable_to_non_nullable
              as Duration?,
    ));
  }

  /// Create a copy of Renewal
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DurationCopyWith<$Res>? get duration {
    if (_self.duration == null) {
      return null;
    }

    return $DurationCopyWith<$Res>(_self.duration!, (value) {
      return _then(_self.copyWith(duration: value));
    });
  }
}

// dart format on
