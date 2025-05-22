// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'and_predicate.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$AndPredicate {
  List<Predicate> get predicates;

  /// Create a copy of AndPredicate
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $AndPredicateCopyWith<AndPredicate> get copyWith =>
      _$AndPredicateCopyWithImpl<AndPredicate>(
          this as AndPredicate, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is AndPredicate &&
            const DeepCollectionEquality()
                .equals(other.predicates, predicates));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, const DeepCollectionEquality().hash(predicates));

  @override
  String toString() {
    return 'AndPredicate(predicates: $predicates)';
  }
}

/// @nodoc
abstract mixin class $AndPredicateCopyWith<$Res> {
  factory $AndPredicateCopyWith(
          AndPredicate value, $Res Function(AndPredicate) _then) =
      _$AndPredicateCopyWithImpl;
  @useResult
  $Res call({List<Predicate> predicates});
}

/// @nodoc
class _$AndPredicateCopyWithImpl<$Res> implements $AndPredicateCopyWith<$Res> {
  _$AndPredicateCopyWithImpl(this._self, this._then);

  final AndPredicate _self;
  final $Res Function(AndPredicate) _then;

  /// Create a copy of AndPredicate
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

class _AndPredicate implements AndPredicate {
  const _AndPredicate({final List<Predicate> predicates = const []})
      : _predicates = predicates;

  final List<Predicate> _predicates;
  @override
  @JsonKey()
  List<Predicate> get predicates {
    if (_predicates is EqualUnmodifiableListView) return _predicates;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_predicates);
  }

  /// Create a copy of AndPredicate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$AndPredicateCopyWith<_AndPredicate> get copyWith =>
      __$AndPredicateCopyWithImpl<_AndPredicate>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _AndPredicate &&
            const DeepCollectionEquality()
                .equals(other._predicates, _predicates));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, const DeepCollectionEquality().hash(_predicates));

  @override
  String toString() {
    return 'AndPredicate(predicates: $predicates)';
  }
}

/// @nodoc
abstract mixin class _$AndPredicateCopyWith<$Res>
    implements $AndPredicateCopyWith<$Res> {
  factory _$AndPredicateCopyWith(
          _AndPredicate value, $Res Function(_AndPredicate) _then) =
      __$AndPredicateCopyWithImpl;
  @override
  @useResult
  $Res call({List<Predicate> predicates});
}

/// @nodoc
class __$AndPredicateCopyWithImpl<$Res>
    implements _$AndPredicateCopyWith<$Res> {
  __$AndPredicateCopyWithImpl(this._self, this._then);

  final _AndPredicate _self;
  final $Res Function(_AndPredicate) _then;

  /// Create a copy of AndPredicate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? predicates = null,
  }) {
    return _then(_AndPredicate(
      predicates: null == predicates
          ? _self._predicates
          : predicates // ignore: cast_nullable_to_non_nullable
              as List<Predicate>,
    ));
  }
}

// dart format on
