// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'or_predicate.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$OrPredicate {
  List<Predicate> get predicates;

  /// Create a copy of OrPredicate
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $OrPredicateCopyWith<OrPredicate> get copyWith =>
      _$OrPredicateCopyWithImpl<OrPredicate>(this as OrPredicate, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is OrPredicate &&
            const DeepCollectionEquality()
                .equals(other.predicates, predicates));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, const DeepCollectionEquality().hash(predicates));

  @override
  String toString() {
    return 'OrPredicate(predicates: $predicates)';
  }
}

/// @nodoc
abstract mixin class $OrPredicateCopyWith<$Res> {
  factory $OrPredicateCopyWith(
          OrPredicate value, $Res Function(OrPredicate) _then) =
      _$OrPredicateCopyWithImpl;
  @useResult
  $Res call({List<Predicate> predicates});
}

/// @nodoc
class _$OrPredicateCopyWithImpl<$Res> implements $OrPredicateCopyWith<$Res> {
  _$OrPredicateCopyWithImpl(this._self, this._then);

  final OrPredicate _self;
  final $Res Function(OrPredicate) _then;

  /// Create a copy of OrPredicate
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? predicates = null,
  }) {
    return _then(_self.copyWith(
      predicates: null == predicates
          ? _self.predicates
          : predicates // ignore: cast_nullable_to_non_nullable
              as List<Predicate>,
    ));
  }
}

/// @nodoc

class _OrPredicate implements OrPredicate {
  const _OrPredicate({final List<Predicate> predicates = const []})
      : _predicates = predicates;

  final List<Predicate> _predicates;
  @override
  @JsonKey()
  List<Predicate> get predicates {
    if (_predicates is EqualUnmodifiableListView) return _predicates;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_predicates);
  }

  /// Create a copy of OrPredicate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$OrPredicateCopyWith<_OrPredicate> get copyWith =>
      __$OrPredicateCopyWithImpl<_OrPredicate>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _OrPredicate &&
            const DeepCollectionEquality()
                .equals(other._predicates, _predicates));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, const DeepCollectionEquality().hash(_predicates));

  @override
  String toString() {
    return 'OrPredicate(predicates: $predicates)';
  }
}

/// @nodoc
abstract mixin class _$OrPredicateCopyWith<$Res>
    implements $OrPredicateCopyWith<$Res> {
  factory _$OrPredicateCopyWith(
          _OrPredicate value, $Res Function(_OrPredicate) _then) =
      __$OrPredicateCopyWithImpl;
  @override
  @useResult
  $Res call({List<Predicate> predicates});
}

/// @nodoc
class __$OrPredicateCopyWithImpl<$Res> implements _$OrPredicateCopyWith<$Res> {
  __$OrPredicateCopyWithImpl(this._self, this._then);

  final _OrPredicate _self;
  final $Res Function(_OrPredicate) _then;

  /// Create a copy of OrPredicate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? predicates = null,
  }) {
    return _then(_OrPredicate(
      predicates: null == predicates
          ? _self._predicates
          : predicates // ignore: cast_nullable_to_non_nullable
              as List<Predicate>,
    ));
  }
}

// dart format on
