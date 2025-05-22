// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'not_predicate.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$NotPredicate {
  Predicate get predicate;

  /// Create a copy of NotPredicate
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $NotPredicateCopyWith<NotPredicate> get copyWith =>
      _$NotPredicateCopyWithImpl<NotPredicate>(
          this as NotPredicate, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is NotPredicate &&
            (identical(other.predicate, predicate) ||
                other.predicate == predicate));
  }

  @override
  int get hashCode => Object.hash(runtimeType, predicate);

  @override
  String toString() {
    return 'NotPredicate(predicate: $predicate)';
  }
}

/// @nodoc
abstract mixin class $NotPredicateCopyWith<$Res> {
  factory $NotPredicateCopyWith(
          NotPredicate value, $Res Function(NotPredicate) _then) =
      _$NotPredicateCopyWithImpl;
  @useResult
  $Res call({Predicate predicate});
}

/// @nodoc
class _$NotPredicateCopyWithImpl<$Res> implements $NotPredicateCopyWith<$Res> {
  _$NotPredicateCopyWithImpl(this._self, this._then);

  final NotPredicate _self;
  final $Res Function(NotPredicate) _then;

  /// Create a copy of NotPredicate
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? predicate = null,
  }) {
    return _then(_self.copyWith(
      predicate: null == predicate
          ? _self.predicate
          : predicate // ignore: cast_nullable_to_non_nullable
              as Predicate,
    ));
  }
}

/// @nodoc

class _NotPredicate implements NotPredicate {
  const _NotPredicate({required this.predicate});

  @override
  final Predicate predicate;

  /// Create a copy of NotPredicate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$NotPredicateCopyWith<_NotPredicate> get copyWith =>
      __$NotPredicateCopyWithImpl<_NotPredicate>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _NotPredicate &&
            (identical(other.predicate, predicate) ||
                other.predicate == predicate));
  }

  @override
  int get hashCode => Object.hash(runtimeType, predicate);

  @override
  String toString() {
    return 'NotPredicate(predicate: $predicate)';
  }
}

/// @nodoc
abstract mixin class _$NotPredicateCopyWith<$Res>
    implements $NotPredicateCopyWith<$Res> {
  factory _$NotPredicateCopyWith(
          _NotPredicate value, $Res Function(_NotPredicate) _then) =
      __$NotPredicateCopyWithImpl;
  @override
  @useResult
  $Res call({Predicate predicate});
}

/// @nodoc
class __$NotPredicateCopyWithImpl<$Res>
    implements _$NotPredicateCopyWith<$Res> {
  __$NotPredicateCopyWithImpl(this._self, this._then);

  final _NotPredicate _self;
  final $Res Function(_NotPredicate) _then;

  /// Create a copy of NotPredicate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? predicate = null,
  }) {
    return _then(_NotPredicate(
      predicate: null == predicate
          ? _self.predicate
          : predicate // ignore: cast_nullable_to_non_nullable
              as Predicate,
    ));
  }
}

// dart format on
