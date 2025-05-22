// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'agreement_appendix.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$AgreementAppendix {
  int? get docSeq;
  int? get verseSeq;
  String? get documentId;
  String? get path;

  /// Create a copy of AgreementAppendix
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $AgreementAppendixCopyWith<AgreementAppendix> get copyWith =>
      _$AgreementAppendixCopyWithImpl<AgreementAppendix>(
          this as AgreementAppendix, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is AgreementAppendix &&
            (identical(other.docSeq, docSeq) || other.docSeq == docSeq) &&
            (identical(other.verseSeq, verseSeq) ||
                other.verseSeq == verseSeq) &&
            (identical(other.documentId, documentId) ||
                other.documentId == documentId) &&
            (identical(other.path, path) || other.path == path));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, docSeq, verseSeq, documentId, path);

  @override
  String toString() {
    return 'AgreementAppendix(docSeq: $docSeq, verseSeq: $verseSeq, documentId: $documentId, path: $path)';
  }
}

/// @nodoc
abstract mixin class $AgreementAppendixCopyWith<$Res> {
  factory $AgreementAppendixCopyWith(
          AgreementAppendix value, $Res Function(AgreementAppendix) _then) =
      _$AgreementAppendixCopyWithImpl;
  @useResult
  $Res call({int? docSeq, int? verseSeq, String? documentId, String? path});
}

/// @nodoc
class _$AgreementAppendixCopyWithImpl<$Res>
    implements $AgreementAppendixCopyWith<$Res> {
  _$AgreementAppendixCopyWithImpl(this._self, this._then);

  final AgreementAppendix _self;
  final $Res Function(AgreementAppendix) _then;

  /// Create a copy of AgreementAppendix
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? docSeq = freezed,
    Object? verseSeq = freezed,
    Object? documentId = freezed,
    Object? path = freezed,
  }) {
    return _then(_self.copyWith(
      docSeq: freezed == docSeq
          ? _self.docSeq
          : docSeq // ignore: cast_nullable_to_non_nullable
              as int?,
      verseSeq: freezed == verseSeq
          ? _self.verseSeq
          : verseSeq // ignore: cast_nullable_to_non_nullable
              as int?,
      documentId: freezed == documentId
          ? _self.documentId
          : documentId // ignore: cast_nullable_to_non_nullable
              as String?,
      path: freezed == path
          ? _self.path
          : path // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _AgreementAppendix implements AgreementAppendix {
  const _AgreementAppendix(
      {this.docSeq = null,
      this.verseSeq = null,
      this.documentId = null,
      this.path = null});

  @override
  @JsonKey()
  final int? docSeq;
  @override
  @JsonKey()
  final int? verseSeq;
  @override
  @JsonKey()
  final String? documentId;
  @override
  @JsonKey()
  final String? path;

  /// Create a copy of AgreementAppendix
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$AgreementAppendixCopyWith<_AgreementAppendix> get copyWith =>
      __$AgreementAppendixCopyWithImpl<_AgreementAppendix>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _AgreementAppendix &&
            (identical(other.docSeq, docSeq) || other.docSeq == docSeq) &&
            (identical(other.verseSeq, verseSeq) ||
                other.verseSeq == verseSeq) &&
            (identical(other.documentId, documentId) ||
                other.documentId == documentId) &&
            (identical(other.path, path) || other.path == path));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, docSeq, verseSeq, documentId, path);

  @override
  String toString() {
    return 'AgreementAppendix(docSeq: $docSeq, verseSeq: $verseSeq, documentId: $documentId, path: $path)';
  }
}

/// @nodoc
abstract mixin class _$AgreementAppendixCopyWith<$Res>
    implements $AgreementAppendixCopyWith<$Res> {
  factory _$AgreementAppendixCopyWith(
          _AgreementAppendix value, $Res Function(_AgreementAppendix) _then) =
      __$AgreementAppendixCopyWithImpl;
  @override
  @useResult
  $Res call({int? docSeq, int? verseSeq, String? documentId, String? path});
}

/// @nodoc
class __$AgreementAppendixCopyWithImpl<$Res>
    implements _$AgreementAppendixCopyWith<$Res> {
  __$AgreementAppendixCopyWithImpl(this._self, this._then);

  final _AgreementAppendix _self;
  final $Res Function(_AgreementAppendix) _then;

  /// Create a copy of AgreementAppendix
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? docSeq = freezed,
    Object? verseSeq = freezed,
    Object? documentId = freezed,
    Object? path = freezed,
  }) {
    return _then(_AgreementAppendix(
      docSeq: freezed == docSeq
          ? _self.docSeq
          : docSeq // ignore: cast_nullable_to_non_nullable
              as int?,
      verseSeq: freezed == verseSeq
          ? _self.verseSeq
          : verseSeq // ignore: cast_nullable_to_non_nullable
              as int?,
      documentId: freezed == documentId
          ? _self.documentId
          : documentId // ignore: cast_nullable_to_non_nullable
              as String?,
      path: freezed == path
          ? _self.path
          : path // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
