// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'id_with_rev.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$IdWithRev {
  String get id;
  String? get rev;

  /// Create a copy of IdWithRev
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $IdWithRevCopyWith<IdWithRev> get copyWith =>
      _$IdWithRevCopyWithImpl<IdWithRev>(this as IdWithRev, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is IdWithRev &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, rev);

  @override
  String toString() {
    return 'IdWithRev(id: $id, rev: $rev)';
  }
}

/// @nodoc
abstract mixin class $IdWithRevCopyWith<$Res> {
  factory $IdWithRevCopyWith(IdWithRev value, $Res Function(IdWithRev) _then) =
      _$IdWithRevCopyWithImpl;
  @useResult
  $Res call({String id, String? rev});
}

/// @nodoc
class _$IdWithRevCopyWithImpl<$Res> implements $IdWithRevCopyWith<$Res> {
  _$IdWithRevCopyWithImpl(this._self, this._then);

  final IdWithRev _self;
  final $Res Function(IdWithRev) _then;

  /// Create a copy of IdWithRev
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _IdWithRev implements IdWithRev {
  const _IdWithRev({required this.id, this.rev = null});

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;

  /// Create a copy of IdWithRev
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$IdWithRevCopyWith<_IdWithRev> get copyWith =>
      __$IdWithRevCopyWithImpl<_IdWithRev>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _IdWithRev &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, rev);

  @override
  String toString() {
    return 'IdWithRev(id: $id, rev: $rev)';
  }
}

/// @nodoc
abstract mixin class _$IdWithRevCopyWith<$Res>
    implements $IdWithRevCopyWith<$Res> {
  factory _$IdWithRevCopyWith(
          _IdWithRev value, $Res Function(_IdWithRev) _then) =
      __$IdWithRevCopyWithImpl;
  @override
  @useResult
  $Res call({String id, String? rev});
}

/// @nodoc
class __$IdWithRevCopyWithImpl<$Res> implements _$IdWithRevCopyWith<$Res> {
  __$IdWithRevCopyWithImpl(this._self, this._then);

  final _IdWithRev _self;
  final $Res Function(_IdWithRev) _then;

  /// Create a copy of IdWithRev
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
  }) {
    return _then(_IdWithRev(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
