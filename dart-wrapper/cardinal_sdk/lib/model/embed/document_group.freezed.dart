// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'document_group.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DocumentGroup {
  String? get guid;
  String? get name;

  /// Create a copy of DocumentGroup
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DocumentGroupCopyWith<DocumentGroup> get copyWith =>
      _$DocumentGroupCopyWithImpl<DocumentGroup>(
          this as DocumentGroup, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DocumentGroup &&
            (identical(other.guid, guid) || other.guid == guid) &&
            (identical(other.name, name) || other.name == name));
  }

  @override
  int get hashCode => Object.hash(runtimeType, guid, name);

  @override
  String toString() {
    return 'DocumentGroup(guid: $guid, name: $name)';
  }
}

/// @nodoc
abstract mixin class $DocumentGroupCopyWith<$Res> {
  factory $DocumentGroupCopyWith(
          DocumentGroup value, $Res Function(DocumentGroup) _then) =
      _$DocumentGroupCopyWithImpl;
  @useResult
  $Res call({String? guid, String? name});
}

/// @nodoc
class _$DocumentGroupCopyWithImpl<$Res>
    implements $DocumentGroupCopyWith<$Res> {
  _$DocumentGroupCopyWithImpl(this._self, this._then);

  final DocumentGroup _self;
  final $Res Function(DocumentGroup) _then;

  /// Create a copy of DocumentGroup
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? guid = freezed,
    Object? name = freezed,
  }) {
    return _then(_self.copyWith(
      guid: freezed == guid
          ? _self.guid
          : guid // ignore: cast_nullable_to_non_nullable
              as String?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _DocumentGroup implements DocumentGroup {
  const _DocumentGroup({this.guid = null, this.name = null});

  @override
  @JsonKey()
  final String? guid;
  @override
  @JsonKey()
  final String? name;

  /// Create a copy of DocumentGroup
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DocumentGroupCopyWith<_DocumentGroup> get copyWith =>
      __$DocumentGroupCopyWithImpl<_DocumentGroup>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DocumentGroup &&
            (identical(other.guid, guid) || other.guid == guid) &&
            (identical(other.name, name) || other.name == name));
  }

  @override
  int get hashCode => Object.hash(runtimeType, guid, name);

  @override
  String toString() {
    return 'DocumentGroup(guid: $guid, name: $name)';
  }
}

/// @nodoc
abstract mixin class _$DocumentGroupCopyWith<$Res>
    implements $DocumentGroupCopyWith<$Res> {
  factory _$DocumentGroupCopyWith(
          _DocumentGroup value, $Res Function(_DocumentGroup) _then) =
      __$DocumentGroupCopyWithImpl;
  @override
  @useResult
  $Res call({String? guid, String? name});
}

/// @nodoc
class __$DocumentGroupCopyWithImpl<$Res>
    implements _$DocumentGroupCopyWith<$Res> {
  __$DocumentGroupCopyWithImpl(this._self, this._then);

  final _DocumentGroup _self;
  final $Res Function(_DocumentGroup) _then;

  /// Create a copy of DocumentGroup
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? guid = freezed,
    Object? name = freezed,
  }) {
    return _then(_DocumentGroup(
      guid: freezed == guid
          ? _self.guid
          : guid // ignore: cast_nullable_to_non_nullable
              as String?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
