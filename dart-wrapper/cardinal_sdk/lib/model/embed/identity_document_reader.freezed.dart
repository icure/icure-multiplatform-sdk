// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'identity_document_reader.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$IdentityDocumentReader {
  String? get justificatifDocumentNumber;
  String? get supportSerialNumber;
  int? get timeReadingEIdDocument;
  int get eidDocumentSupportType;
  int get reasonManualEncoding;
  int get reasonUsingVignette;

  /// Create a copy of IdentityDocumentReader
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $IdentityDocumentReaderCopyWith<IdentityDocumentReader> get copyWith =>
      _$IdentityDocumentReaderCopyWithImpl<IdentityDocumentReader>(
          this as IdentityDocumentReader, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is IdentityDocumentReader &&
            (identical(other.justificatifDocumentNumber,
                    justificatifDocumentNumber) ||
                other.justificatifDocumentNumber ==
                    justificatifDocumentNumber) &&
            (identical(other.supportSerialNumber, supportSerialNumber) ||
                other.supportSerialNumber == supportSerialNumber) &&
            (identical(other.timeReadingEIdDocument, timeReadingEIdDocument) ||
                other.timeReadingEIdDocument == timeReadingEIdDocument) &&
            (identical(other.eidDocumentSupportType, eidDocumentSupportType) ||
                other.eidDocumentSupportType == eidDocumentSupportType) &&
            (identical(other.reasonManualEncoding, reasonManualEncoding) ||
                other.reasonManualEncoding == reasonManualEncoding) &&
            (identical(other.reasonUsingVignette, reasonUsingVignette) ||
                other.reasonUsingVignette == reasonUsingVignette));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      justificatifDocumentNumber,
      supportSerialNumber,
      timeReadingEIdDocument,
      eidDocumentSupportType,
      reasonManualEncoding,
      reasonUsingVignette);

  @override
  String toString() {
    return 'IdentityDocumentReader(justificatifDocumentNumber: $justificatifDocumentNumber, supportSerialNumber: $supportSerialNumber, timeReadingEIdDocument: $timeReadingEIdDocument, eidDocumentSupportType: $eidDocumentSupportType, reasonManualEncoding: $reasonManualEncoding, reasonUsingVignette: $reasonUsingVignette)';
  }
}

/// @nodoc
abstract mixin class $IdentityDocumentReaderCopyWith<$Res> {
  factory $IdentityDocumentReaderCopyWith(IdentityDocumentReader value,
          $Res Function(IdentityDocumentReader) _then) =
      _$IdentityDocumentReaderCopyWithImpl;
  @useResult
  $Res call(
      {String? justificatifDocumentNumber,
      String? supportSerialNumber,
      int? timeReadingEIdDocument,
      int eidDocumentSupportType,
      int reasonManualEncoding,
      int reasonUsingVignette});
}

/// @nodoc
class _$IdentityDocumentReaderCopyWithImpl<$Res>
    implements $IdentityDocumentReaderCopyWith<$Res> {
  _$IdentityDocumentReaderCopyWithImpl(this._self, this._then);

  final IdentityDocumentReader _self;
  final $Res Function(IdentityDocumentReader) _then;

  /// Create a copy of IdentityDocumentReader
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? justificatifDocumentNumber = freezed,
    Object? supportSerialNumber = freezed,
    Object? timeReadingEIdDocument = freezed,
    Object? eidDocumentSupportType = null,
    Object? reasonManualEncoding = null,
    Object? reasonUsingVignette = null,
  }) {
    return _then(_self.copyWith(
      justificatifDocumentNumber: freezed == justificatifDocumentNumber
          ? _self.justificatifDocumentNumber
          : justificatifDocumentNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      supportSerialNumber: freezed == supportSerialNumber
          ? _self.supportSerialNumber
          : supportSerialNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      timeReadingEIdDocument: freezed == timeReadingEIdDocument
          ? _self.timeReadingEIdDocument
          : timeReadingEIdDocument // ignore: cast_nullable_to_non_nullable
              as int?,
      eidDocumentSupportType: null == eidDocumentSupportType
          ? _self.eidDocumentSupportType
          : eidDocumentSupportType // ignore: cast_nullable_to_non_nullable
              as int,
      reasonManualEncoding: null == reasonManualEncoding
          ? _self.reasonManualEncoding
          : reasonManualEncoding // ignore: cast_nullable_to_non_nullable
              as int,
      reasonUsingVignette: null == reasonUsingVignette
          ? _self.reasonUsingVignette
          : reasonUsingVignette // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

/// @nodoc

class _IdentityDocumentReader implements IdentityDocumentReader {
  const _IdentityDocumentReader(
      {this.justificatifDocumentNumber = null,
      this.supportSerialNumber = null,
      this.timeReadingEIdDocument = null,
      this.eidDocumentSupportType = 0,
      this.reasonManualEncoding = 0,
      this.reasonUsingVignette = 0});

  @override
  @JsonKey()
  final String? justificatifDocumentNumber;
  @override
  @JsonKey()
  final String? supportSerialNumber;
  @override
  @JsonKey()
  final int? timeReadingEIdDocument;
  @override
  @JsonKey()
  final int eidDocumentSupportType;
  @override
  @JsonKey()
  final int reasonManualEncoding;
  @override
  @JsonKey()
  final int reasonUsingVignette;

  /// Create a copy of IdentityDocumentReader
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$IdentityDocumentReaderCopyWith<_IdentityDocumentReader> get copyWith =>
      __$IdentityDocumentReaderCopyWithImpl<_IdentityDocumentReader>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _IdentityDocumentReader &&
            (identical(other.justificatifDocumentNumber,
                    justificatifDocumentNumber) ||
                other.justificatifDocumentNumber ==
                    justificatifDocumentNumber) &&
            (identical(other.supportSerialNumber, supportSerialNumber) ||
                other.supportSerialNumber == supportSerialNumber) &&
            (identical(other.timeReadingEIdDocument, timeReadingEIdDocument) ||
                other.timeReadingEIdDocument == timeReadingEIdDocument) &&
            (identical(other.eidDocumentSupportType, eidDocumentSupportType) ||
                other.eidDocumentSupportType == eidDocumentSupportType) &&
            (identical(other.reasonManualEncoding, reasonManualEncoding) ||
                other.reasonManualEncoding == reasonManualEncoding) &&
            (identical(other.reasonUsingVignette, reasonUsingVignette) ||
                other.reasonUsingVignette == reasonUsingVignette));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      justificatifDocumentNumber,
      supportSerialNumber,
      timeReadingEIdDocument,
      eidDocumentSupportType,
      reasonManualEncoding,
      reasonUsingVignette);

  @override
  String toString() {
    return 'IdentityDocumentReader(justificatifDocumentNumber: $justificatifDocumentNumber, supportSerialNumber: $supportSerialNumber, timeReadingEIdDocument: $timeReadingEIdDocument, eidDocumentSupportType: $eidDocumentSupportType, reasonManualEncoding: $reasonManualEncoding, reasonUsingVignette: $reasonUsingVignette)';
  }
}

/// @nodoc
abstract mixin class _$IdentityDocumentReaderCopyWith<$Res>
    implements $IdentityDocumentReaderCopyWith<$Res> {
  factory _$IdentityDocumentReaderCopyWith(_IdentityDocumentReader value,
          $Res Function(_IdentityDocumentReader) _then) =
      __$IdentityDocumentReaderCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? justificatifDocumentNumber,
      String? supportSerialNumber,
      int? timeReadingEIdDocument,
      int eidDocumentSupportType,
      int reasonManualEncoding,
      int reasonUsingVignette});
}

/// @nodoc
class __$IdentityDocumentReaderCopyWithImpl<$Res>
    implements _$IdentityDocumentReaderCopyWith<$Res> {
  __$IdentityDocumentReaderCopyWithImpl(this._self, this._then);

  final _IdentityDocumentReader _self;
  final $Res Function(_IdentityDocumentReader) _then;

  /// Create a copy of IdentityDocumentReader
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? justificatifDocumentNumber = freezed,
    Object? supportSerialNumber = freezed,
    Object? timeReadingEIdDocument = freezed,
    Object? eidDocumentSupportType = null,
    Object? reasonManualEncoding = null,
    Object? reasonUsingVignette = null,
  }) {
    return _then(_IdentityDocumentReader(
      justificatifDocumentNumber: freezed == justificatifDocumentNumber
          ? _self.justificatifDocumentNumber
          : justificatifDocumentNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      supportSerialNumber: freezed == supportSerialNumber
          ? _self.supportSerialNumber
          : supportSerialNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      timeReadingEIdDocument: freezed == timeReadingEIdDocument
          ? _self.timeReadingEIdDocument
          : timeReadingEIdDocument // ignore: cast_nullable_to_non_nullable
              as int?,
      eidDocumentSupportType: null == eidDocumentSupportType
          ? _self.eidDocumentSupportType
          : eidDocumentSupportType // ignore: cast_nullable_to_non_nullable
              as int,
      reasonManualEncoding: null == reasonManualEncoding
          ? _self.reasonManualEncoding
          : reasonManualEncoding // ignore: cast_nullable_to_non_nullable
              as int,
      reasonUsingVignette: null == reasonUsingVignette
          ? _self.reasonUsingVignette
          : reasonUsingVignette // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

// dart format on
