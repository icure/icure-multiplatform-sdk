// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'paragraph_agreement.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ParagraphAgreement {
  int? get timestamp;
  String? get paragraph;
  bool? get accepted;
  bool? get inTreatment;
  bool? get canceled;
  String? get careProviderReference;
  String? get decisionReference;
  int? get start;
  int? get end;
  int? get cancelationDate;
  double? get quantityValue;
  String? get quantityUnit;
  String? get ioRequestReference;
  String? get responseType;
  Map<String, String>? get refusalJustification;
  Set<int>? get verses;
  String? get coverageType;
  double? get unitNumber;
  double? get strength;
  String? get strengthUnit;
  List<AgreementAppendix>? get agreementAppendices;
  String? get documentId;

  /// Create a copy of ParagraphAgreement
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ParagraphAgreementCopyWith<ParagraphAgreement> get copyWith =>
      _$ParagraphAgreementCopyWithImpl<ParagraphAgreement>(
          this as ParagraphAgreement, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ParagraphAgreement &&
            (identical(other.timestamp, timestamp) ||
                other.timestamp == timestamp) &&
            (identical(other.paragraph, paragraph) ||
                other.paragraph == paragraph) &&
            (identical(other.accepted, accepted) ||
                other.accepted == accepted) &&
            (identical(other.inTreatment, inTreatment) ||
                other.inTreatment == inTreatment) &&
            (identical(other.canceled, canceled) ||
                other.canceled == canceled) &&
            (identical(other.careProviderReference, careProviderReference) ||
                other.careProviderReference == careProviderReference) &&
            (identical(other.decisionReference, decisionReference) ||
                other.decisionReference == decisionReference) &&
            (identical(other.start, start) || other.start == start) &&
            (identical(other.end, end) || other.end == end) &&
            (identical(other.cancelationDate, cancelationDate) ||
                other.cancelationDate == cancelationDate) &&
            (identical(other.quantityValue, quantityValue) ||
                other.quantityValue == quantityValue) &&
            (identical(other.quantityUnit, quantityUnit) ||
                other.quantityUnit == quantityUnit) &&
            (identical(other.ioRequestReference, ioRequestReference) ||
                other.ioRequestReference == ioRequestReference) &&
            (identical(other.responseType, responseType) ||
                other.responseType == responseType) &&
            const DeepCollectionEquality()
                .equals(other.refusalJustification, refusalJustification) &&
            const DeepCollectionEquality().equals(other.verses, verses) &&
            (identical(other.coverageType, coverageType) ||
                other.coverageType == coverageType) &&
            (identical(other.unitNumber, unitNumber) ||
                other.unitNumber == unitNumber) &&
            (identical(other.strength, strength) ||
                other.strength == strength) &&
            (identical(other.strengthUnit, strengthUnit) ||
                other.strengthUnit == strengthUnit) &&
            const DeepCollectionEquality()
                .equals(other.agreementAppendices, agreementAppendices) &&
            (identical(other.documentId, documentId) ||
                other.documentId == documentId));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        timestamp,
        paragraph,
        accepted,
        inTreatment,
        canceled,
        careProviderReference,
        decisionReference,
        start,
        end,
        cancelationDate,
        quantityValue,
        quantityUnit,
        ioRequestReference,
        responseType,
        const DeepCollectionEquality().hash(refusalJustification),
        const DeepCollectionEquality().hash(verses),
        coverageType,
        unitNumber,
        strength,
        strengthUnit,
        const DeepCollectionEquality().hash(agreementAppendices),
        documentId
      ]);

  @override
  String toString() {
    return 'ParagraphAgreement(timestamp: $timestamp, paragraph: $paragraph, accepted: $accepted, inTreatment: $inTreatment, canceled: $canceled, careProviderReference: $careProviderReference, decisionReference: $decisionReference, start: $start, end: $end, cancelationDate: $cancelationDate, quantityValue: $quantityValue, quantityUnit: $quantityUnit, ioRequestReference: $ioRequestReference, responseType: $responseType, refusalJustification: $refusalJustification, verses: $verses, coverageType: $coverageType, unitNumber: $unitNumber, strength: $strength, strengthUnit: $strengthUnit, agreementAppendices: $agreementAppendices, documentId: $documentId)';
  }
}

/// @nodoc
abstract mixin class $ParagraphAgreementCopyWith<$Res> {
  factory $ParagraphAgreementCopyWith(
          ParagraphAgreement value, $Res Function(ParagraphAgreement) _then) =
      _$ParagraphAgreementCopyWithImpl;
  @useResult
  $Res call(
      {int? timestamp,
      String? paragraph,
      bool? accepted,
      bool? inTreatment,
      bool? canceled,
      String? careProviderReference,
      String? decisionReference,
      int? start,
      int? end,
      int? cancelationDate,
      double? quantityValue,
      String? quantityUnit,
      String? ioRequestReference,
      String? responseType,
      Map<String, String>? refusalJustification,
      Set<int>? verses,
      String? coverageType,
      double? unitNumber,
      double? strength,
      String? strengthUnit,
      List<AgreementAppendix>? agreementAppendices,
      String? documentId});
}

/// @nodoc
class _$ParagraphAgreementCopyWithImpl<$Res>
    implements $ParagraphAgreementCopyWith<$Res> {
  _$ParagraphAgreementCopyWithImpl(this._self, this._then);

  final ParagraphAgreement _self;
  final $Res Function(ParagraphAgreement) _then;

  /// Create a copy of ParagraphAgreement
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? timestamp = freezed,
    Object? paragraph = freezed,
    Object? accepted = freezed,
    Object? inTreatment = freezed,
    Object? canceled = freezed,
    Object? careProviderReference = freezed,
    Object? decisionReference = freezed,
    Object? start = freezed,
    Object? end = freezed,
    Object? cancelationDate = freezed,
    Object? quantityValue = freezed,
    Object? quantityUnit = freezed,
    Object? ioRequestReference = freezed,
    Object? responseType = freezed,
    Object? refusalJustification = freezed,
    Object? verses = freezed,
    Object? coverageType = freezed,
    Object? unitNumber = freezed,
    Object? strength = freezed,
    Object? strengthUnit = freezed,
    Object? agreementAppendices = freezed,
    Object? documentId = freezed,
  }) {
    return _then(_self.copyWith(
      timestamp: freezed == timestamp
          ? _self.timestamp
          : timestamp // ignore: cast_nullable_to_non_nullable
              as int?,
      paragraph: freezed == paragraph
          ? _self.paragraph
          : paragraph // ignore: cast_nullable_to_non_nullable
              as String?,
      accepted: freezed == accepted
          ? _self.accepted
          : accepted // ignore: cast_nullable_to_non_nullable
              as bool?,
      inTreatment: freezed == inTreatment
          ? _self.inTreatment
          : inTreatment // ignore: cast_nullable_to_non_nullable
              as bool?,
      canceled: freezed == canceled
          ? _self.canceled
          : canceled // ignore: cast_nullable_to_non_nullable
              as bool?,
      careProviderReference: freezed == careProviderReference
          ? _self.careProviderReference
          : careProviderReference // ignore: cast_nullable_to_non_nullable
              as String?,
      decisionReference: freezed == decisionReference
          ? _self.decisionReference
          : decisionReference // ignore: cast_nullable_to_non_nullable
              as String?,
      start: freezed == start
          ? _self.start
          : start // ignore: cast_nullable_to_non_nullable
              as int?,
      end: freezed == end
          ? _self.end
          : end // ignore: cast_nullable_to_non_nullable
              as int?,
      cancelationDate: freezed == cancelationDate
          ? _self.cancelationDate
          : cancelationDate // ignore: cast_nullable_to_non_nullable
              as int?,
      quantityValue: freezed == quantityValue
          ? _self.quantityValue
          : quantityValue // ignore: cast_nullable_to_non_nullable
              as double?,
      quantityUnit: freezed == quantityUnit
          ? _self.quantityUnit
          : quantityUnit // ignore: cast_nullable_to_non_nullable
              as String?,
      ioRequestReference: freezed == ioRequestReference
          ? _self.ioRequestReference
          : ioRequestReference // ignore: cast_nullable_to_non_nullable
              as String?,
      responseType: freezed == responseType
          ? _self.responseType
          : responseType // ignore: cast_nullable_to_non_nullable
              as String?,
      refusalJustification: freezed == refusalJustification
          ? _self.refusalJustification
          : refusalJustification // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      verses: freezed == verses
          ? _self.verses
          : verses // ignore: cast_nullable_to_non_nullable
              as Set<int>?,
      coverageType: freezed == coverageType
          ? _self.coverageType
          : coverageType // ignore: cast_nullable_to_non_nullable
              as String?,
      unitNumber: freezed == unitNumber
          ? _self.unitNumber
          : unitNumber // ignore: cast_nullable_to_non_nullable
              as double?,
      strength: freezed == strength
          ? _self.strength
          : strength // ignore: cast_nullable_to_non_nullable
              as double?,
      strengthUnit: freezed == strengthUnit
          ? _self.strengthUnit
          : strengthUnit // ignore: cast_nullable_to_non_nullable
              as String?,
      agreementAppendices: freezed == agreementAppendices
          ? _self.agreementAppendices
          : agreementAppendices // ignore: cast_nullable_to_non_nullable
              as List<AgreementAppendix>?,
      documentId: freezed == documentId
          ? _self.documentId
          : documentId // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _ParagraphAgreement implements ParagraphAgreement {
  const _ParagraphAgreement(
      {this.timestamp = null,
      this.paragraph = null,
      this.accepted = null,
      this.inTreatment = null,
      this.canceled = null,
      this.careProviderReference = null,
      this.decisionReference = null,
      this.start = null,
      this.end = null,
      this.cancelationDate = null,
      this.quantityValue = null,
      this.quantityUnit = null,
      this.ioRequestReference = null,
      this.responseType = null,
      final Map<String, String>? refusalJustification = null,
      final Set<int>? verses = null,
      this.coverageType = null,
      this.unitNumber = null,
      this.strength = null,
      this.strengthUnit = null,
      final List<AgreementAppendix>? agreementAppendices = null,
      this.documentId = null})
      : _refusalJustification = refusalJustification,
        _verses = verses,
        _agreementAppendices = agreementAppendices;

  @override
  @JsonKey()
  final int? timestamp;
  @override
  @JsonKey()
  final String? paragraph;
  @override
  @JsonKey()
  final bool? accepted;
  @override
  @JsonKey()
  final bool? inTreatment;
  @override
  @JsonKey()
  final bool? canceled;
  @override
  @JsonKey()
  final String? careProviderReference;
  @override
  @JsonKey()
  final String? decisionReference;
  @override
  @JsonKey()
  final int? start;
  @override
  @JsonKey()
  final int? end;
  @override
  @JsonKey()
  final int? cancelationDate;
  @override
  @JsonKey()
  final double? quantityValue;
  @override
  @JsonKey()
  final String? quantityUnit;
  @override
  @JsonKey()
  final String? ioRequestReference;
  @override
  @JsonKey()
  final String? responseType;
  final Map<String, String>? _refusalJustification;
  @override
  @JsonKey()
  Map<String, String>? get refusalJustification {
    final value = _refusalJustification;
    if (value == null) return null;
    if (_refusalJustification is EqualUnmodifiableMapView)
      return _refusalJustification;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(value);
  }

  final Set<int>? _verses;
  @override
  @JsonKey()
  Set<int>? get verses {
    final value = _verses;
    if (value == null) return null;
    if (_verses is EqualUnmodifiableSetView) return _verses;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  @override
  @JsonKey()
  final String? coverageType;
  @override
  @JsonKey()
  final double? unitNumber;
  @override
  @JsonKey()
  final double? strength;
  @override
  @JsonKey()
  final String? strengthUnit;
  final List<AgreementAppendix>? _agreementAppendices;
  @override
  @JsonKey()
  List<AgreementAppendix>? get agreementAppendices {
    final value = _agreementAppendices;
    if (value == null) return null;
    if (_agreementAppendices is EqualUnmodifiableListView)
      return _agreementAppendices;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  @override
  @JsonKey()
  final String? documentId;

  /// Create a copy of ParagraphAgreement
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ParagraphAgreementCopyWith<_ParagraphAgreement> get copyWith =>
      __$ParagraphAgreementCopyWithImpl<_ParagraphAgreement>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ParagraphAgreement &&
            (identical(other.timestamp, timestamp) ||
                other.timestamp == timestamp) &&
            (identical(other.paragraph, paragraph) ||
                other.paragraph == paragraph) &&
            (identical(other.accepted, accepted) ||
                other.accepted == accepted) &&
            (identical(other.inTreatment, inTreatment) ||
                other.inTreatment == inTreatment) &&
            (identical(other.canceled, canceled) ||
                other.canceled == canceled) &&
            (identical(other.careProviderReference, careProviderReference) ||
                other.careProviderReference == careProviderReference) &&
            (identical(other.decisionReference, decisionReference) ||
                other.decisionReference == decisionReference) &&
            (identical(other.start, start) || other.start == start) &&
            (identical(other.end, end) || other.end == end) &&
            (identical(other.cancelationDate, cancelationDate) ||
                other.cancelationDate == cancelationDate) &&
            (identical(other.quantityValue, quantityValue) ||
                other.quantityValue == quantityValue) &&
            (identical(other.quantityUnit, quantityUnit) ||
                other.quantityUnit == quantityUnit) &&
            (identical(other.ioRequestReference, ioRequestReference) ||
                other.ioRequestReference == ioRequestReference) &&
            (identical(other.responseType, responseType) ||
                other.responseType == responseType) &&
            const DeepCollectionEquality()
                .equals(other._refusalJustification, _refusalJustification) &&
            const DeepCollectionEquality().equals(other._verses, _verses) &&
            (identical(other.coverageType, coverageType) ||
                other.coverageType == coverageType) &&
            (identical(other.unitNumber, unitNumber) ||
                other.unitNumber == unitNumber) &&
            (identical(other.strength, strength) ||
                other.strength == strength) &&
            (identical(other.strengthUnit, strengthUnit) ||
                other.strengthUnit == strengthUnit) &&
            const DeepCollectionEquality()
                .equals(other._agreementAppendices, _agreementAppendices) &&
            (identical(other.documentId, documentId) ||
                other.documentId == documentId));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        timestamp,
        paragraph,
        accepted,
        inTreatment,
        canceled,
        careProviderReference,
        decisionReference,
        start,
        end,
        cancelationDate,
        quantityValue,
        quantityUnit,
        ioRequestReference,
        responseType,
        const DeepCollectionEquality().hash(_refusalJustification),
        const DeepCollectionEquality().hash(_verses),
        coverageType,
        unitNumber,
        strength,
        strengthUnit,
        const DeepCollectionEquality().hash(_agreementAppendices),
        documentId
      ]);

  @override
  String toString() {
    return 'ParagraphAgreement(timestamp: $timestamp, paragraph: $paragraph, accepted: $accepted, inTreatment: $inTreatment, canceled: $canceled, careProviderReference: $careProviderReference, decisionReference: $decisionReference, start: $start, end: $end, cancelationDate: $cancelationDate, quantityValue: $quantityValue, quantityUnit: $quantityUnit, ioRequestReference: $ioRequestReference, responseType: $responseType, refusalJustification: $refusalJustification, verses: $verses, coverageType: $coverageType, unitNumber: $unitNumber, strength: $strength, strengthUnit: $strengthUnit, agreementAppendices: $agreementAppendices, documentId: $documentId)';
  }
}

/// @nodoc
abstract mixin class _$ParagraphAgreementCopyWith<$Res>
    implements $ParagraphAgreementCopyWith<$Res> {
  factory _$ParagraphAgreementCopyWith(
          _ParagraphAgreement value, $Res Function(_ParagraphAgreement) _then) =
      __$ParagraphAgreementCopyWithImpl;
  @override
  @useResult
  $Res call(
      {int? timestamp,
      String? paragraph,
      bool? accepted,
      bool? inTreatment,
      bool? canceled,
      String? careProviderReference,
      String? decisionReference,
      int? start,
      int? end,
      int? cancelationDate,
      double? quantityValue,
      String? quantityUnit,
      String? ioRequestReference,
      String? responseType,
      Map<String, String>? refusalJustification,
      Set<int>? verses,
      String? coverageType,
      double? unitNumber,
      double? strength,
      String? strengthUnit,
      List<AgreementAppendix>? agreementAppendices,
      String? documentId});
}

/// @nodoc
class __$ParagraphAgreementCopyWithImpl<$Res>
    implements _$ParagraphAgreementCopyWith<$Res> {
  __$ParagraphAgreementCopyWithImpl(this._self, this._then);

  final _ParagraphAgreement _self;
  final $Res Function(_ParagraphAgreement) _then;

  /// Create a copy of ParagraphAgreement
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? timestamp = freezed,
    Object? paragraph = freezed,
    Object? accepted = freezed,
    Object? inTreatment = freezed,
    Object? canceled = freezed,
    Object? careProviderReference = freezed,
    Object? decisionReference = freezed,
    Object? start = freezed,
    Object? end = freezed,
    Object? cancelationDate = freezed,
    Object? quantityValue = freezed,
    Object? quantityUnit = freezed,
    Object? ioRequestReference = freezed,
    Object? responseType = freezed,
    Object? refusalJustification = freezed,
    Object? verses = freezed,
    Object? coverageType = freezed,
    Object? unitNumber = freezed,
    Object? strength = freezed,
    Object? strengthUnit = freezed,
    Object? agreementAppendices = freezed,
    Object? documentId = freezed,
  }) {
    return _then(_ParagraphAgreement(
      timestamp: freezed == timestamp
          ? _self.timestamp
          : timestamp // ignore: cast_nullable_to_non_nullable
              as int?,
      paragraph: freezed == paragraph
          ? _self.paragraph
          : paragraph // ignore: cast_nullable_to_non_nullable
              as String?,
      accepted: freezed == accepted
          ? _self.accepted
          : accepted // ignore: cast_nullable_to_non_nullable
              as bool?,
      inTreatment: freezed == inTreatment
          ? _self.inTreatment
          : inTreatment // ignore: cast_nullable_to_non_nullable
              as bool?,
      canceled: freezed == canceled
          ? _self.canceled
          : canceled // ignore: cast_nullable_to_non_nullable
              as bool?,
      careProviderReference: freezed == careProviderReference
          ? _self.careProviderReference
          : careProviderReference // ignore: cast_nullable_to_non_nullable
              as String?,
      decisionReference: freezed == decisionReference
          ? _self.decisionReference
          : decisionReference // ignore: cast_nullable_to_non_nullable
              as String?,
      start: freezed == start
          ? _self.start
          : start // ignore: cast_nullable_to_non_nullable
              as int?,
      end: freezed == end
          ? _self.end
          : end // ignore: cast_nullable_to_non_nullable
              as int?,
      cancelationDate: freezed == cancelationDate
          ? _self.cancelationDate
          : cancelationDate // ignore: cast_nullable_to_non_nullable
              as int?,
      quantityValue: freezed == quantityValue
          ? _self.quantityValue
          : quantityValue // ignore: cast_nullable_to_non_nullable
              as double?,
      quantityUnit: freezed == quantityUnit
          ? _self.quantityUnit
          : quantityUnit // ignore: cast_nullable_to_non_nullable
              as String?,
      ioRequestReference: freezed == ioRequestReference
          ? _self.ioRequestReference
          : ioRequestReference // ignore: cast_nullable_to_non_nullable
              as String?,
      responseType: freezed == responseType
          ? _self.responseType
          : responseType // ignore: cast_nullable_to_non_nullable
              as String?,
      refusalJustification: freezed == refusalJustification
          ? _self._refusalJustification
          : refusalJustification // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      verses: freezed == verses
          ? _self._verses
          : verses // ignore: cast_nullable_to_non_nullable
              as Set<int>?,
      coverageType: freezed == coverageType
          ? _self.coverageType
          : coverageType // ignore: cast_nullable_to_non_nullable
              as String?,
      unitNumber: freezed == unitNumber
          ? _self.unitNumber
          : unitNumber // ignore: cast_nullable_to_non_nullable
              as double?,
      strength: freezed == strength
          ? _self.strength
          : strength // ignore: cast_nullable_to_non_nullable
              as double?,
      strengthUnit: freezed == strengthUnit
          ? _self.strengthUnit
          : strengthUnit // ignore: cast_nullable_to_non_nullable
              as String?,
      agreementAppendices: freezed == agreementAppendices
          ? _self._agreementAppendices
          : agreementAppendices // ignore: cast_nullable_to_non_nullable
              as List<AgreementAppendix>?,
      documentId: freezed == documentId
          ? _self.documentId
          : documentId // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
