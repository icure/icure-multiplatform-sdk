// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'group_scoped.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$GroupScoped<E> {
  E get entity;
  String get groupId;

  /// Create a copy of GroupScoped
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $GroupScopedCopyWith<E, GroupScoped<E>> get copyWith =>
      _$GroupScopedCopyWithImpl<E, GroupScoped<E>>(
          this as GroupScoped<E>, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is GroupScoped<E> &&
            const DeepCollectionEquality().equals(other.entity, entity) &&
            (identical(other.groupId, groupId) || other.groupId == groupId));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, const DeepCollectionEquality().hash(entity), groupId);

  @override
  String toString() {
    return 'GroupScoped<$E>(entity: $entity, groupId: $groupId)';
  }
}

/// @nodoc
abstract mixin class $GroupScopedCopyWith<E, $Res> {
  factory $GroupScopedCopyWith(
          GroupScoped<E> value, $Res Function(GroupScoped<E>) _then) =
      _$GroupScopedCopyWithImpl;
  @useResult
  $Res call({E entity, String groupId});
}

/// @nodoc
class _$GroupScopedCopyWithImpl<E, $Res>
    implements $GroupScopedCopyWith<E, $Res> {
  _$GroupScopedCopyWithImpl(this._self, this._then);

  final GroupScoped<E> _self;
  final $Res Function(GroupScoped<E>) _then;

  /// Create a copy of GroupScoped
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? entity = freezed,
    Object? groupId = null,
  }) {
    return _then(_self.copyWith(
      entity: freezed == entity
          ? _self.entity
          : entity // ignore: cast_nullable_to_non_nullable
              as E,
      groupId: null == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _GroupScoped<E> implements GroupScoped<E> {
  const _GroupScoped({required this.entity, required this.groupId});

  @override
  final E entity;
  @override
  final String groupId;

  /// Create a copy of GroupScoped
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$GroupScopedCopyWith<E, _GroupScoped<E>> get copyWith =>
      __$GroupScopedCopyWithImpl<E, _GroupScoped<E>>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _GroupScoped<E> &&
            const DeepCollectionEquality().equals(other.entity, entity) &&
            (identical(other.groupId, groupId) || other.groupId == groupId));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, const DeepCollectionEquality().hash(entity), groupId);

  @override
  String toString() {
    return 'GroupScoped<$E>(entity: $entity, groupId: $groupId)';
  }
}

/// @nodoc
abstract mixin class _$GroupScopedCopyWith<E, $Res>
    implements $GroupScopedCopyWith<E, $Res> {
  factory _$GroupScopedCopyWith(
          _GroupScoped<E> value, $Res Function(_GroupScoped<E>) _then) =
      __$GroupScopedCopyWithImpl;
  @override
  @useResult
  $Res call({E entity, String groupId});
}

/// @nodoc
class __$GroupScopedCopyWithImpl<E, $Res>
    implements _$GroupScopedCopyWith<E, $Res> {
  __$GroupScopedCopyWithImpl(this._self, this._then);

  final _GroupScoped<E> _self;
  final $Res Function(_GroupScoped<E>) _then;

  /// Create a copy of GroupScoped
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? entity = freezed,
    Object? groupId = null,
  }) {
    return _then(_GroupScoped<E>(
      entity: freezed == entity
          ? _self.entity
          : entity // ignore: cast_nullable_to_non_nullable
              as E,
      groupId: null == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

// dart format on
