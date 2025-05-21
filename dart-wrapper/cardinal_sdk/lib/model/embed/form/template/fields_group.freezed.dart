// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'fields_group.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$FieldsGroup {
  String get group;
  List<StructureElement>? get fields;

  /// Create a copy of FieldsGroup
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $FieldsGroupCopyWith<FieldsGroup> get copyWith =>
      _$FieldsGroupCopyWithImpl<FieldsGroup>(this as FieldsGroup, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is FieldsGroup &&
            (identical(other.group, group) || other.group == group) &&
            const DeepCollectionEquality().equals(other.fields, fields));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, group, const DeepCollectionEquality().hash(fields));

  @override
  String toString() {
    return 'FieldsGroup(group: $group, fields: $fields)';
  }
}

/// @nodoc
abstract mixin class $FieldsGroupCopyWith<$Res> {
  factory $FieldsGroupCopyWith(
          FieldsGroup value, $Res Function(FieldsGroup) _then) =
      _$FieldsGroupCopyWithImpl;
  @useResult
  $Res call({String group, List<StructureElement>? fields});
}

/// @nodoc
class _$FieldsGroupCopyWithImpl<$Res> implements $FieldsGroupCopyWith<$Res> {
  _$FieldsGroupCopyWithImpl(this._self, this._then);

  final FieldsGroup _self;
  final $Res Function(FieldsGroup) _then;

  /// Create a copy of FieldsGroup
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? group = null,
    Object? fields = freezed,
  }) {
    return _then(_self.copyWith(
      group: null == group
          ? _self.group
          : group // ignore: cast_nullable_to_non_nullable
              as String,
      fields: freezed == fields
          ? _self.fields
          : fields // ignore: cast_nullable_to_non_nullable
              as List<StructureElement>?,
    ));
  }
}

/// @nodoc

class _FieldsGroup implements FieldsGroup {
  const _FieldsGroup(
      {required this.group, final List<StructureElement>? fields = null})
      : _fields = fields;

  @override
  final String group;
  final List<StructureElement>? _fields;
  @override
  @JsonKey()
  List<StructureElement>? get fields {
    final value = _fields;
    if (value == null) return null;
    if (_fields is EqualUnmodifiableListView) return _fields;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  /// Create a copy of FieldsGroup
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$FieldsGroupCopyWith<_FieldsGroup> get copyWith =>
      __$FieldsGroupCopyWithImpl<_FieldsGroup>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _FieldsGroup &&
            (identical(other.group, group) || other.group == group) &&
            const DeepCollectionEquality().equals(other._fields, _fields));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, group, const DeepCollectionEquality().hash(_fields));

  @override
  String toString() {
    return 'FieldsGroup(group: $group, fields: $fields)';
  }
}

/// @nodoc
abstract mixin class _$FieldsGroupCopyWith<$Res>
    implements $FieldsGroupCopyWith<$Res> {
  factory _$FieldsGroupCopyWith(
          _FieldsGroup value, $Res Function(_FieldsGroup) _then) =
      __$FieldsGroupCopyWithImpl;
  @override
  @useResult
  $Res call({String group, List<StructureElement>? fields});
}

/// @nodoc
class __$FieldsGroupCopyWithImpl<$Res> implements _$FieldsGroupCopyWith<$Res> {
  __$FieldsGroupCopyWithImpl(this._self, this._then);

  final _FieldsGroup _self;
  final $Res Function(_FieldsGroup) _then;

  /// Create a copy of FieldsGroup
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? group = null,
    Object? fields = freezed,
  }) {
    return _then(_FieldsGroup(
      group: null == group
          ? _self.group
          : group // ignore: cast_nullable_to_non_nullable
              as String,
      fields: freezed == fields
          ? _self._fields
          : fields // ignore: cast_nullable_to_non_nullable
              as List<StructureElement>?,
    ));
  }
}

// dart format on
