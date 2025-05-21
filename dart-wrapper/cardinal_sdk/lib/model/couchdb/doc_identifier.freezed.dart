// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'doc_identifier.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DocIdentifier {
  String? get id;
  String? get rev;

  /// Create a copy of DocIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DocIdentifierCopyWith<DocIdentifier> get copyWith =>
      _$DocIdentifierCopyWithImpl<DocIdentifier>(
          this as DocIdentifier, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DocIdentifier &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, rev);

  @override
  String toString() {
    return 'DocIdentifier(id: $id, rev: $rev)';
  }
}

/// @nodoc
abstract mixin class $DocIdentifierCopyWith<$Res> {
  factory $DocIdentifierCopyWith(
          DocIdentifier value, $Res Function(DocIdentifier) _then) =
      _$DocIdentifierCopyWithImpl;
  @useResult
  $Res call({String? id, String? rev});
}

/// @nodoc
class _$DocIdentifierCopyWithImpl<$Res>
    implements $DocIdentifierCopyWith<$Res> {
  _$DocIdentifierCopyWithImpl(this._self, this._then);

  final DocIdentifier _self;
  final $Res Function(DocIdentifier) _then;

  /// Create a copy of DocIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = freezed,
    Object? rev = freezed,
  }) {
    return _then(_self.copyWith(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _DocIdentifier implements DocIdentifier {
  const _DocIdentifier({this.id = null, this.rev = null});

  @override
  @JsonKey()
  final String? id;
  @override
  @JsonKey()
  final String? rev;

  /// Create a copy of DocIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DocIdentifierCopyWith<_DocIdentifier> get copyWith =>
      __$DocIdentifierCopyWithImpl<_DocIdentifier>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DocIdentifier &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, rev);

  @override
  String toString() {
    return 'DocIdentifier(id: $id, rev: $rev)';
  }
}

/// @nodoc
abstract mixin class _$DocIdentifierCopyWith<$Res>
    implements $DocIdentifierCopyWith<$Res> {
  factory _$DocIdentifierCopyWith(
          _DocIdentifier value, $Res Function(_DocIdentifier) _then) =
      __$DocIdentifierCopyWithImpl;
  @override
  @useResult
  $Res call({String? id, String? rev});
}

/// @nodoc
class __$DocIdentifierCopyWithImpl<$Res>
    implements _$DocIdentifierCopyWith<$Res> {
  __$DocIdentifierCopyWithImpl(this._self, this._then);

  final _DocIdentifier _self;
  final $Res Function(_DocIdentifier) _then;

  /// Create a copy of DocIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = freezed,
    Object? rev = freezed,
  }) {
    return _then(_DocIdentifier(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
