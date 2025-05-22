// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'always_permission_item.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$AlwaysPermissionItem {
  PermissionType get type;

  /// Create a copy of AlwaysPermissionItem
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $AlwaysPermissionItemCopyWith<AlwaysPermissionItem> get copyWith =>
      _$AlwaysPermissionItemCopyWithImpl<AlwaysPermissionItem>(
          this as AlwaysPermissionItem, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is AlwaysPermissionItem &&
            (identical(other.type, type) || other.type == type));
  }

  @override
  int get hashCode => Object.hash(runtimeType, type);

  @override
  String toString() {
    return 'AlwaysPermissionItem(type: $type)';
  }
}

/// @nodoc
abstract mixin class $AlwaysPermissionItemCopyWith<$Res> {
  factory $AlwaysPermissionItemCopyWith(AlwaysPermissionItem value,
          $Res Function(AlwaysPermissionItem) _then) =
      _$AlwaysPermissionItemCopyWithImpl;
  @useResult
  $Res call({PermissionType type});
}

/// @nodoc
class _$AlwaysPermissionItemCopyWithImpl<$Res>
    implements $AlwaysPermissionItemCopyWith<$Res> {
  _$AlwaysPermissionItemCopyWithImpl(this._self, this._then);

  final AlwaysPermissionItem _self;
  final $Res Function(AlwaysPermissionItem) _then;

  /// Create a copy of AlwaysPermissionItem
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? type = null,
  }) {
    return _then(_self.copyWith(
      type: null == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as PermissionType,
    ));
  }
}

/// @nodoc

class _AlwaysPermissionItem extends AlwaysPermissionItem {
  const _AlwaysPermissionItem({required this.type}) : super._();

  @override
  final PermissionType type;

  /// Create a copy of AlwaysPermissionItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$AlwaysPermissionItemCopyWith<_AlwaysPermissionItem> get copyWith =>
      __$AlwaysPermissionItemCopyWithImpl<_AlwaysPermissionItem>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _AlwaysPermissionItem &&
            (identical(other.type, type) || other.type == type));
  }

  @override
  int get hashCode => Object.hash(runtimeType, type);

  @override
  String toString() {
    return 'AlwaysPermissionItem(type: $type)';
  }
}

/// @nodoc
abstract mixin class _$AlwaysPermissionItemCopyWith<$Res>
    implements $AlwaysPermissionItemCopyWith<$Res> {
  factory _$AlwaysPermissionItemCopyWith(_AlwaysPermissionItem value,
          $Res Function(_AlwaysPermissionItem) _then) =
      __$AlwaysPermissionItemCopyWithImpl;
  @override
  @useResult
  $Res call({PermissionType type});
}

/// @nodoc
class __$AlwaysPermissionItemCopyWithImpl<$Res>
    implements _$AlwaysPermissionItemCopyWith<$Res> {
  __$AlwaysPermissionItemCopyWithImpl(this._self, this._then);

  final _AlwaysPermissionItem _self;
  final $Res Function(_AlwaysPermissionItem) _then;

  /// Create a copy of AlwaysPermissionItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? type = null,
  }) {
    return _then(_AlwaysPermissionItem(
      type: null == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as PermissionType,
    ));
  }
}

// dart format on
