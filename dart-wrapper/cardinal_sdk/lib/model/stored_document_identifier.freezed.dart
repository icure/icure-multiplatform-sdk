// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'stored_document_identifier.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$StoredDocumentIdentifier {
  String get id;
  String get rev;

  /// Create a copy of StoredDocumentIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $StoredDocumentIdentifierCopyWith<StoredDocumentIdentifier> get copyWith =>
      _$StoredDocumentIdentifierCopyWithImpl<StoredDocumentIdentifier>(
          this as StoredDocumentIdentifier, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is StoredDocumentIdentifier &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, rev);

  @override
  String toString() {
    return 'StoredDocumentIdentifier(id: $id, rev: $rev)';
  }
}

/// @nodoc
abstract mixin class $StoredDocumentIdentifierCopyWith<$Res> {
  factory $StoredDocumentIdentifierCopyWith(StoredDocumentIdentifier value,
          $Res Function(StoredDocumentIdentifier) _then) =
      _$StoredDocumentIdentifierCopyWithImpl;
  @useResult
  $Res call({String id, String rev});
}

/// @nodoc
class _$StoredDocumentIdentifierCopyWithImpl<$Res>
    implements $StoredDocumentIdentifierCopyWith<$Res> {
  _$StoredDocumentIdentifierCopyWithImpl(this._self, this._then);

  final StoredDocumentIdentifier _self;
  final $Res Function(StoredDocumentIdentifier) _then;

  /// Create a copy of StoredDocumentIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = null,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: null == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _StoredDocumentIdentifier implements StoredDocumentIdentifier {
  const _StoredDocumentIdentifier({required this.id, required this.rev});

  @override
  final String id;
  @override
  final String rev;

  /// Create a copy of StoredDocumentIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$StoredDocumentIdentifierCopyWith<_StoredDocumentIdentifier> get copyWith =>
      __$StoredDocumentIdentifierCopyWithImpl<_StoredDocumentIdentifier>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _StoredDocumentIdentifier &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, rev);

  @override
  String toString() {
    return 'StoredDocumentIdentifier(id: $id, rev: $rev)';
  }
}

/// @nodoc
abstract mixin class _$StoredDocumentIdentifierCopyWith<$Res>
    implements $StoredDocumentIdentifierCopyWith<$Res> {
  factory _$StoredDocumentIdentifierCopyWith(_StoredDocumentIdentifier value,
          $Res Function(_StoredDocumentIdentifier) _then) =
      __$StoredDocumentIdentifierCopyWithImpl;
  @override
  @useResult
  $Res call({String id, String rev});
}

/// @nodoc
class __$StoredDocumentIdentifierCopyWithImpl<$Res>
    implements _$StoredDocumentIdentifierCopyWith<$Res> {
  __$StoredDocumentIdentifierCopyWithImpl(this._self, this._then);

  final _StoredDocumentIdentifier _self;
  final $Res Function(_StoredDocumentIdentifier) _then;

  /// Create a copy of StoredDocumentIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = null,
  }) {
    return _then(_StoredDocumentIdentifier(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: null == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

// dart format on
