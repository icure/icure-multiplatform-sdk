// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'letter_value.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$LetterValue {
  String? get letter;
  String? get index;
  double? get coefficient;
  double? get value;

  /// Create a copy of LetterValue
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $LetterValueCopyWith<LetterValue> get copyWith =>
      _$LetterValueCopyWithImpl<LetterValue>(this as LetterValue, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is LetterValue &&
            (identical(other.letter, letter) || other.letter == letter) &&
            (identical(other.index, index) || other.index == index) &&
            (identical(other.coefficient, coefficient) ||
                other.coefficient == coefficient) &&
            (identical(other.value, value) || other.value == value));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, letter, index, coefficient, value);

  @override
  String toString() {
    return 'LetterValue(letter: $letter, index: $index, coefficient: $coefficient, value: $value)';
  }
}

/// @nodoc
abstract mixin class $LetterValueCopyWith<$Res> {
  factory $LetterValueCopyWith(
          LetterValue value, $Res Function(LetterValue) _then) =
      _$LetterValueCopyWithImpl;
  @useResult
  $Res call(
      {String? letter, String? index, double? coefficient, double? value});
}

/// @nodoc
class _$LetterValueCopyWithImpl<$Res> implements $LetterValueCopyWith<$Res> {
  _$LetterValueCopyWithImpl(this._self, this._then);

  final LetterValue _self;
  final $Res Function(LetterValue) _then;

  /// Create a copy of LetterValue
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? letter = freezed,
    Object? index = freezed,
    Object? coefficient = freezed,
    Object? value = freezed,
  }) {
    return _then(_self.copyWith(
      letter: freezed == letter
          ? _self.letter
          : letter // ignore: cast_nullable_to_non_nullable
              as String?,
      index: freezed == index
          ? _self.index
          : index // ignore: cast_nullable_to_non_nullable
              as String?,
      coefficient: freezed == coefficient
          ? _self.coefficient
          : coefficient // ignore: cast_nullable_to_non_nullable
              as double?,
      value: freezed == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as double?,
    ));
  }
}

/// @nodoc

class _LetterValue implements LetterValue {
  const _LetterValue(
      {this.letter = null,
      this.index = null,
      this.coefficient = null,
      this.value = null});

  @override
  @JsonKey()
  final String? letter;
  @override
  @JsonKey()
  final String? index;
  @override
  @JsonKey()
  final double? coefficient;
  @override
  @JsonKey()
  final double? value;

  /// Create a copy of LetterValue
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$LetterValueCopyWith<_LetterValue> get copyWith =>
      __$LetterValueCopyWithImpl<_LetterValue>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _LetterValue &&
            (identical(other.letter, letter) || other.letter == letter) &&
            (identical(other.index, index) || other.index == index) &&
            (identical(other.coefficient, coefficient) ||
                other.coefficient == coefficient) &&
            (identical(other.value, value) || other.value == value));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, letter, index, coefficient, value);

  @override
  String toString() {
    return 'LetterValue(letter: $letter, index: $index, coefficient: $coefficient, value: $value)';
  }
}

/// @nodoc
abstract mixin class _$LetterValueCopyWith<$Res>
    implements $LetterValueCopyWith<$Res> {
  factory _$LetterValueCopyWith(
          _LetterValue value, $Res Function(_LetterValue) _then) =
      __$LetterValueCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? letter, String? index, double? coefficient, double? value});
}

/// @nodoc
class __$LetterValueCopyWithImpl<$Res> implements _$LetterValueCopyWith<$Res> {
  __$LetterValueCopyWithImpl(this._self, this._then);

  final _LetterValue _self;
  final $Res Function(_LetterValue) _then;

  /// Create a copy of LetterValue
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? letter = freezed,
    Object? index = freezed,
    Object? coefficient = freezed,
    Object? value = freezed,
  }) {
    return _then(_LetterValue(
      letter: freezed == letter
          ? _self.letter
          : letter // ignore: cast_nullable_to_non_nullable
              as String?,
      index: freezed == index
          ? _self.index
          : index // ignore: cast_nullable_to_non_nullable
              as String?,
      coefficient: freezed == coefficient
          ? _self.coefficient
          : coefficient // ignore: cast_nullable_to_non_nullable
              as double?,
      value: freezed == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as double?,
    ));
  }
}

// dart format on
