// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'range.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Range {
  double? get low;
  double? get high;

  /// Create a copy of Range
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $RangeCopyWith<Range> get copyWith =>
      _$RangeCopyWithImpl<Range>(this as Range, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Range &&
            (identical(other.low, low) || other.low == low) &&
            (identical(other.high, high) || other.high == high));
  }

  @override
  int get hashCode => Object.hash(runtimeType, low, high);

  @override
  String toString() {
    return 'Range(low: $low, high: $high)';
  }
}

/// @nodoc
abstract mixin class $RangeCopyWith<$Res> {
  factory $RangeCopyWith(Range value, $Res Function(Range) _then) =
      _$RangeCopyWithImpl;
  @useResult
  $Res call({double? low, double? high});
}

/// @nodoc
class _$RangeCopyWithImpl<$Res> implements $RangeCopyWith<$Res> {
  _$RangeCopyWithImpl(this._self, this._then);

  final Range _self;
  final $Res Function(Range) _then;

  /// Create a copy of Range
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? low = freezed,
    Object? high = freezed,
  }) {
    return _then(_self.copyWith(
      low: freezed == low
          ? _self.low
          : low // ignore: cast_nullable_to_non_nullable
              as double?,
      high: freezed == high
          ? _self.high
          : high // ignore: cast_nullable_to_non_nullable
              as double?,
    ));
  }
}

/// @nodoc

class _Range implements Range {
  const _Range({this.low = null, this.high = null});

  @override
  @JsonKey()
  final double? low;
  @override
  @JsonKey()
  final double? high;

  /// Create a copy of Range
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$RangeCopyWith<_Range> get copyWith =>
      __$RangeCopyWithImpl<_Range>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Range &&
            (identical(other.low, low) || other.low == low) &&
            (identical(other.high, high) || other.high == high));
  }

  @override
  int get hashCode => Object.hash(runtimeType, low, high);

  @override
  String toString() {
    return 'Range(low: $low, high: $high)';
  }
}

/// @nodoc
abstract mixin class _$RangeCopyWith<$Res> implements $RangeCopyWith<$Res> {
  factory _$RangeCopyWith(_Range value, $Res Function(_Range) _then) =
      __$RangeCopyWithImpl;
  @override
  @useResult
  $Res call({double? low, double? high});
}

/// @nodoc
class __$RangeCopyWithImpl<$Res> implements _$RangeCopyWith<$Res> {
  __$RangeCopyWithImpl(this._self, this._then);

  final _Range _self;
  final $Res Function(_Range) _then;

  /// Create a copy of Range
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? low = freezed,
    Object? high = freezed,
  }) {
    return _then(_Range(
      low: freezed == low
          ? _self.low
          : low // ignore: cast_nullable_to_non_nullable
              as double?,
      high: freezed == high
          ? _self.high
          : high // ignore: cast_nullable_to_non_nullable
              as double?,
    ));
  }
}

// dart format on
