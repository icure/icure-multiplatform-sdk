// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'key_value_predicate.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$KeyValuePredicate {
  String? get key;
  Operator? get operator;
  AnyPrimitive? get value;

  /// Create a copy of KeyValuePredicate
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $KeyValuePredicateCopyWith<KeyValuePredicate> get copyWith =>
      _$KeyValuePredicateCopyWithImpl<KeyValuePredicate>(
          this as KeyValuePredicate, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is KeyValuePredicate &&
            (identical(other.key, key) || other.key == key) &&
            (identical(other.operator, operator) ||
                other.operator == operator) &&
            const DeepCollectionEquality().equals(other.value, value));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, key, operator, const DeepCollectionEquality().hash(value));

  @override
  String toString() {
    return 'KeyValuePredicate(key: $key, operator: $operator, value: $value)';
  }
}

/// @nodoc
abstract mixin class $KeyValuePredicateCopyWith<$Res> {
  factory $KeyValuePredicateCopyWith(
          KeyValuePredicate value, $Res Function(KeyValuePredicate) _then) =
      _$KeyValuePredicateCopyWithImpl;
  @useResult
  $Res call({String? key, Operator? operator, AnyPrimitive? value});
}

/// @nodoc
class _$KeyValuePredicateCopyWithImpl<$Res>
    implements $KeyValuePredicateCopyWith<$Res> {
  _$KeyValuePredicateCopyWithImpl(this._self, this._then);

  final KeyValuePredicate _self;
  final $Res Function(KeyValuePredicate) _then;

  /// Create a copy of KeyValuePredicate
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? key = freezed,
    Object? operator = freezed,
    Object? value = freezed,
  }) {
    return _then(_self.copyWith(
      key: freezed == key
          ? _self.key
          : key // ignore: cast_nullable_to_non_nullable
              as String?,
      operator: freezed == operator
          ? _self.operator
          : operator // ignore: cast_nullable_to_non_nullable
              as Operator?,
      value: freezed == value ? _self.value : value,
    ));
  }
}

/// @nodoc

class _KeyValuePredicate implements KeyValuePredicate {
  const _KeyValuePredicate(
      {this.key = null, this.operator = null, this.value = null});

  @override
  @JsonKey()
  final String? key;
  @override
  @JsonKey()
  final Operator? operator;
  @override
  @JsonKey()
  final AnyPrimitive? value;

  /// Create a copy of KeyValuePredicate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$KeyValuePredicateCopyWith<_KeyValuePredicate> get copyWith =>
      __$KeyValuePredicateCopyWithImpl<_KeyValuePredicate>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _KeyValuePredicate &&
            (identical(other.key, key) || other.key == key) &&
            (identical(other.operator, operator) ||
                other.operator == operator) &&
            const DeepCollectionEquality().equals(other.value, value));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, key, operator, const DeepCollectionEquality().hash(value));

  @override
  String toString() {
    return 'KeyValuePredicate(key: $key, operator: $operator, value: $value)';
  }
}

/// @nodoc
abstract mixin class _$KeyValuePredicateCopyWith<$Res>
    implements $KeyValuePredicateCopyWith<$Res> {
  factory _$KeyValuePredicateCopyWith(
          _KeyValuePredicate value, $Res Function(_KeyValuePredicate) _then) =
      __$KeyValuePredicateCopyWithImpl;
  @override
  @useResult
  $Res call({String? key, Operator? operator, AnyPrimitive? value});
}

/// @nodoc
class __$KeyValuePredicateCopyWithImpl<$Res>
    implements _$KeyValuePredicateCopyWith<$Res> {
  __$KeyValuePredicateCopyWithImpl(this._self, this._then);

  final _KeyValuePredicate _self;
  final $Res Function(_KeyValuePredicate) _then;

  /// Create a copy of KeyValuePredicate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? key = freezed,
    Object? operator = freezed,
    Object? value = freezed,
  }) {
    return _then(_KeyValuePredicate(
      key: freezed == key
          ? _self.key
          : key // ignore: cast_nullable_to_non_nullable
              as String?,
      operator: freezed == operator
          ? _self.operator
          : operator // ignore: cast_nullable_to_non_nullable
              as Operator?,
      value: freezed == value ? _self.value : value,
    ));
  }
}

// dart format on
