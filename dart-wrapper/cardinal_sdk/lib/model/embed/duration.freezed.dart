// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'duration.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Duration {
  double? get value;
  CodeStub? get unit;

  /// Create a copy of Duration
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DurationCopyWith<Duration> get copyWith =>
      _$DurationCopyWithImpl<Duration>(this as Duration, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Duration &&
            (identical(other.value, value) || other.value == value) &&
            (identical(other.unit, unit) || other.unit == unit));
  }

  @override
  int get hashCode => Object.hash(runtimeType, value, unit);

  @override
  String toString() {
    return 'Duration(value: $value, unit: $unit)';
  }
}

/// @nodoc
abstract mixin class $DurationCopyWith<$Res> {
  factory $DurationCopyWith(Duration value, $Res Function(Duration) _then) =
      _$DurationCopyWithImpl;
  @useResult
  $Res call({double? value, CodeStub? unit});

  $CodeStubCopyWith<$Res>? get unit;
}

/// @nodoc
class _$DurationCopyWithImpl<$Res> implements $DurationCopyWith<$Res> {
  _$DurationCopyWithImpl(this._self, this._then);

  final Duration _self;
  final $Res Function(Duration) _then;

  /// Create a copy of Duration
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? value = freezed,
    Object? unit = freezed,
  }) {
    return _then(_self.copyWith(
      value: freezed == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as double?,
      unit: freezed == unit
          ? _self.unit
          : unit // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
    ));
  }

  /// Create a copy of Duration
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get unit {
    if (_self.unit == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.unit!, (value) {
      return _then(_self.copyWith(unit: value));
    });
  }
}

/// @nodoc

class _Duration implements Duration {
  const _Duration({this.value = null, this.unit = null});

  @override
  @JsonKey()
  final double? value;
  @override
  @JsonKey()
  final CodeStub? unit;

  /// Create a copy of Duration
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DurationCopyWith<_Duration> get copyWith =>
      __$DurationCopyWithImpl<_Duration>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Duration &&
            (identical(other.value, value) || other.value == value) &&
            (identical(other.unit, unit) || other.unit == unit));
  }

  @override
  int get hashCode => Object.hash(runtimeType, value, unit);

  @override
  String toString() {
    return 'Duration(value: $value, unit: $unit)';
  }
}

/// @nodoc
abstract mixin class _$DurationCopyWith<$Res>
    implements $DurationCopyWith<$Res> {
  factory _$DurationCopyWith(_Duration value, $Res Function(_Duration) _then) =
      __$DurationCopyWithImpl;
  @override
  @useResult
  $Res call({double? value, CodeStub? unit});

  @override
  $CodeStubCopyWith<$Res>? get unit;
}

/// @nodoc
class __$DurationCopyWithImpl<$Res> implements _$DurationCopyWith<$Res> {
  __$DurationCopyWithImpl(this._self, this._then);

  final _Duration _self;
  final $Res Function(_Duration) _then;

  /// Create a copy of Duration
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? value = freezed,
    Object? unit = freezed,
  }) {
    return _then(_Duration(
      value: freezed == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as double?,
      unit: freezed == unit
          ? _self.unit
          : unit // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
    ));
  }

  /// Create a copy of Duration
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get unit {
    if (_self.unit == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.unit!, (value) {
      return _then(_self.copyWith(unit: value));
    });
  }
}

// dart format on
