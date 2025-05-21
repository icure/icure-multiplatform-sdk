// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'content.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedContent {
  String? get stringValue;
  double? get numberValue;
  bool? get booleanValue;
  DateTime? get instantValue;
  int? get fuzzyDateValue;
  Uint8List? get binaryValue;
  String? get documentId;
  Measure? get measureValue;
  Medication? get medicationValue;
  TimeSeries? get timeSeries;
  List<EncryptedService>? get compoundValue;
  List<Measure>? get ratio;
  List<Measure>? get range;

  /// Create a copy of EncryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedContentCopyWith<EncryptedContent> get copyWith =>
      _$EncryptedContentCopyWithImpl<EncryptedContent>(
          this as EncryptedContent, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedContent &&
            (identical(other.stringValue, stringValue) ||
                other.stringValue == stringValue) &&
            (identical(other.numberValue, numberValue) ||
                other.numberValue == numberValue) &&
            (identical(other.booleanValue, booleanValue) ||
                other.booleanValue == booleanValue) &&
            (identical(other.instantValue, instantValue) ||
                other.instantValue == instantValue) &&
            (identical(other.fuzzyDateValue, fuzzyDateValue) ||
                other.fuzzyDateValue == fuzzyDateValue) &&
            const DeepCollectionEquality()
                .equals(other.binaryValue, binaryValue) &&
            (identical(other.documentId, documentId) ||
                other.documentId == documentId) &&
            (identical(other.measureValue, measureValue) ||
                other.measureValue == measureValue) &&
            (identical(other.medicationValue, medicationValue) ||
                other.medicationValue == medicationValue) &&
            (identical(other.timeSeries, timeSeries) ||
                other.timeSeries == timeSeries) &&
            const DeepCollectionEquality()
                .equals(other.compoundValue, compoundValue) &&
            const DeepCollectionEquality().equals(other.ratio, ratio) &&
            const DeepCollectionEquality().equals(other.range, range));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      stringValue,
      numberValue,
      booleanValue,
      instantValue,
      fuzzyDateValue,
      const DeepCollectionEquality().hash(binaryValue),
      documentId,
      measureValue,
      medicationValue,
      timeSeries,
      const DeepCollectionEquality().hash(compoundValue),
      const DeepCollectionEquality().hash(ratio),
      const DeepCollectionEquality().hash(range));

  @override
  String toString() {
    return 'EncryptedContent(stringValue: $stringValue, numberValue: $numberValue, booleanValue: $booleanValue, instantValue: $instantValue, fuzzyDateValue: $fuzzyDateValue, binaryValue: $binaryValue, documentId: $documentId, measureValue: $measureValue, medicationValue: $medicationValue, timeSeries: $timeSeries, compoundValue: $compoundValue, ratio: $ratio, range: $range)';
  }
}

/// @nodoc
abstract mixin class $EncryptedContentCopyWith<$Res> {
  factory $EncryptedContentCopyWith(
          EncryptedContent value, $Res Function(EncryptedContent) _then) =
      _$EncryptedContentCopyWithImpl;
  @useResult
  $Res call(
      {String? stringValue,
      double? numberValue,
      bool? booleanValue,
      DateTime? instantValue,
      int? fuzzyDateValue,
      Uint8List? binaryValue,
      String? documentId,
      Measure? measureValue,
      Medication? medicationValue,
      TimeSeries? timeSeries,
      List<EncryptedService>? compoundValue,
      List<Measure>? ratio,
      List<Measure>? range});

  $MeasureCopyWith<$Res>? get measureValue;
  $MedicationCopyWith<$Res>? get medicationValue;
  $TimeSeriesCopyWith<$Res>? get timeSeries;
}

/// @nodoc
class _$EncryptedContentCopyWithImpl<$Res>
    implements $EncryptedContentCopyWith<$Res> {
  _$EncryptedContentCopyWithImpl(this._self, this._then);

  final EncryptedContent _self;
  final $Res Function(EncryptedContent) _then;

  /// Create a copy of EncryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? stringValue = freezed,
    Object? numberValue = freezed,
    Object? booleanValue = freezed,
    Object? instantValue = freezed,
    Object? fuzzyDateValue = freezed,
    Object? binaryValue = freezed,
    Object? documentId = freezed,
    Object? measureValue = freezed,
    Object? medicationValue = freezed,
    Object? timeSeries = freezed,
    Object? compoundValue = freezed,
    Object? ratio = freezed,
    Object? range = freezed,
  }) {
    return _then(_self.copyWith(
      stringValue: freezed == stringValue
          ? _self.stringValue
          : stringValue // ignore: cast_nullable_to_non_nullable
              as String?,
      numberValue: freezed == numberValue
          ? _self.numberValue
          : numberValue // ignore: cast_nullable_to_non_nullable
              as double?,
      booleanValue: freezed == booleanValue
          ? _self.booleanValue
          : booleanValue // ignore: cast_nullable_to_non_nullable
              as bool?,
      instantValue: freezed == instantValue
          ? _self.instantValue
          : instantValue // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      fuzzyDateValue: freezed == fuzzyDateValue
          ? _self.fuzzyDateValue
          : fuzzyDateValue // ignore: cast_nullable_to_non_nullable
              as int?,
      binaryValue: freezed == binaryValue
          ? _self.binaryValue
          : binaryValue // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      documentId: freezed == documentId
          ? _self.documentId
          : documentId // ignore: cast_nullable_to_non_nullable
              as String?,
      measureValue: freezed == measureValue
          ? _self.measureValue
          : measureValue // ignore: cast_nullable_to_non_nullable
              as Measure?,
      medicationValue: freezed == medicationValue
          ? _self.medicationValue
          : medicationValue // ignore: cast_nullable_to_non_nullable
              as Medication?,
      timeSeries: freezed == timeSeries
          ? _self.timeSeries
          : timeSeries // ignore: cast_nullable_to_non_nullable
              as TimeSeries?,
      compoundValue: freezed == compoundValue
          ? _self.compoundValue
          : compoundValue // ignore: cast_nullable_to_non_nullable
              as List<EncryptedService>?,
      ratio: freezed == ratio
          ? _self.ratio
          : ratio // ignore: cast_nullable_to_non_nullable
              as List<Measure>?,
      range: freezed == range
          ? _self.range
          : range // ignore: cast_nullable_to_non_nullable
              as List<Measure>?,
    ));
  }

  /// Create a copy of EncryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $MeasureCopyWith<$Res>? get measureValue {
    if (_self.measureValue == null) {
      return null;
    }

    return $MeasureCopyWith<$Res>(_self.measureValue!, (value) {
      return _then(_self.copyWith(measureValue: value));
    });
  }

  /// Create a copy of EncryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $MedicationCopyWith<$Res>? get medicationValue {
    if (_self.medicationValue == null) {
      return null;
    }

    return $MedicationCopyWith<$Res>(_self.medicationValue!, (value) {
      return _then(_self.copyWith(medicationValue: value));
    });
  }

  /// Create a copy of EncryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $TimeSeriesCopyWith<$Res>? get timeSeries {
    if (_self.timeSeries == null) {
      return null;
    }

    return $TimeSeriesCopyWith<$Res>(_self.timeSeries!, (value) {
      return _then(_self.copyWith(timeSeries: value));
    });
  }
}

/// @nodoc

class _EncryptedContent implements EncryptedContent {
  const _EncryptedContent(
      {this.stringValue = null,
      this.numberValue = null,
      this.booleanValue = null,
      this.instantValue = null,
      this.fuzzyDateValue = null,
      this.binaryValue = null,
      this.documentId = null,
      this.measureValue = null,
      this.medicationValue = null,
      this.timeSeries = null,
      final List<EncryptedService>? compoundValue = null,
      final List<Measure>? ratio = null,
      final List<Measure>? range = null})
      : _compoundValue = compoundValue,
        _ratio = ratio,
        _range = range;

  @override
  @JsonKey()
  final String? stringValue;
  @override
  @JsonKey()
  final double? numberValue;
  @override
  @JsonKey()
  final bool? booleanValue;
  @override
  @JsonKey()
  final DateTime? instantValue;
  @override
  @JsonKey()
  final int? fuzzyDateValue;
  @override
  @JsonKey()
  final Uint8List? binaryValue;
  @override
  @JsonKey()
  final String? documentId;
  @override
  @JsonKey()
  final Measure? measureValue;
  @override
  @JsonKey()
  final Medication? medicationValue;
  @override
  @JsonKey()
  final TimeSeries? timeSeries;
  final List<EncryptedService>? _compoundValue;
  @override
  @JsonKey()
  List<EncryptedService>? get compoundValue {
    final value = _compoundValue;
    if (value == null) return null;
    if (_compoundValue is EqualUnmodifiableListView) return _compoundValue;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  final List<Measure>? _ratio;
  @override
  @JsonKey()
  List<Measure>? get ratio {
    final value = _ratio;
    if (value == null) return null;
    if (_ratio is EqualUnmodifiableListView) return _ratio;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  final List<Measure>? _range;
  @override
  @JsonKey()
  List<Measure>? get range {
    final value = _range;
    if (value == null) return null;
    if (_range is EqualUnmodifiableListView) return _range;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  /// Create a copy of EncryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedContentCopyWith<_EncryptedContent> get copyWith =>
      __$EncryptedContentCopyWithImpl<_EncryptedContent>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedContent &&
            (identical(other.stringValue, stringValue) ||
                other.stringValue == stringValue) &&
            (identical(other.numberValue, numberValue) ||
                other.numberValue == numberValue) &&
            (identical(other.booleanValue, booleanValue) ||
                other.booleanValue == booleanValue) &&
            (identical(other.instantValue, instantValue) ||
                other.instantValue == instantValue) &&
            (identical(other.fuzzyDateValue, fuzzyDateValue) ||
                other.fuzzyDateValue == fuzzyDateValue) &&
            const DeepCollectionEquality()
                .equals(other.binaryValue, binaryValue) &&
            (identical(other.documentId, documentId) ||
                other.documentId == documentId) &&
            (identical(other.measureValue, measureValue) ||
                other.measureValue == measureValue) &&
            (identical(other.medicationValue, medicationValue) ||
                other.medicationValue == medicationValue) &&
            (identical(other.timeSeries, timeSeries) ||
                other.timeSeries == timeSeries) &&
            const DeepCollectionEquality()
                .equals(other._compoundValue, _compoundValue) &&
            const DeepCollectionEquality().equals(other._ratio, _ratio) &&
            const DeepCollectionEquality().equals(other._range, _range));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      stringValue,
      numberValue,
      booleanValue,
      instantValue,
      fuzzyDateValue,
      const DeepCollectionEquality().hash(binaryValue),
      documentId,
      measureValue,
      medicationValue,
      timeSeries,
      const DeepCollectionEquality().hash(_compoundValue),
      const DeepCollectionEquality().hash(_ratio),
      const DeepCollectionEquality().hash(_range));

  @override
  String toString() {
    return 'EncryptedContent(stringValue: $stringValue, numberValue: $numberValue, booleanValue: $booleanValue, instantValue: $instantValue, fuzzyDateValue: $fuzzyDateValue, binaryValue: $binaryValue, documentId: $documentId, measureValue: $measureValue, medicationValue: $medicationValue, timeSeries: $timeSeries, compoundValue: $compoundValue, ratio: $ratio, range: $range)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedContentCopyWith<$Res>
    implements $EncryptedContentCopyWith<$Res> {
  factory _$EncryptedContentCopyWith(
          _EncryptedContent value, $Res Function(_EncryptedContent) _then) =
      __$EncryptedContentCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? stringValue,
      double? numberValue,
      bool? booleanValue,
      DateTime? instantValue,
      int? fuzzyDateValue,
      Uint8List? binaryValue,
      String? documentId,
      Measure? measureValue,
      Medication? medicationValue,
      TimeSeries? timeSeries,
      List<EncryptedService>? compoundValue,
      List<Measure>? ratio,
      List<Measure>? range});

  @override
  $MeasureCopyWith<$Res>? get measureValue;
  @override
  $MedicationCopyWith<$Res>? get medicationValue;
  @override
  $TimeSeriesCopyWith<$Res>? get timeSeries;
}

/// @nodoc
class __$EncryptedContentCopyWithImpl<$Res>
    implements _$EncryptedContentCopyWith<$Res> {
  __$EncryptedContentCopyWithImpl(this._self, this._then);

  final _EncryptedContent _self;
  final $Res Function(_EncryptedContent) _then;

  /// Create a copy of EncryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? stringValue = freezed,
    Object? numberValue = freezed,
    Object? booleanValue = freezed,
    Object? instantValue = freezed,
    Object? fuzzyDateValue = freezed,
    Object? binaryValue = freezed,
    Object? documentId = freezed,
    Object? measureValue = freezed,
    Object? medicationValue = freezed,
    Object? timeSeries = freezed,
    Object? compoundValue = freezed,
    Object? ratio = freezed,
    Object? range = freezed,
  }) {
    return _then(_EncryptedContent(
      stringValue: freezed == stringValue
          ? _self.stringValue
          : stringValue // ignore: cast_nullable_to_non_nullable
              as String?,
      numberValue: freezed == numberValue
          ? _self.numberValue
          : numberValue // ignore: cast_nullable_to_non_nullable
              as double?,
      booleanValue: freezed == booleanValue
          ? _self.booleanValue
          : booleanValue // ignore: cast_nullable_to_non_nullable
              as bool?,
      instantValue: freezed == instantValue
          ? _self.instantValue
          : instantValue // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      fuzzyDateValue: freezed == fuzzyDateValue
          ? _self.fuzzyDateValue
          : fuzzyDateValue // ignore: cast_nullable_to_non_nullable
              as int?,
      binaryValue: freezed == binaryValue
          ? _self.binaryValue
          : binaryValue // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      documentId: freezed == documentId
          ? _self.documentId
          : documentId // ignore: cast_nullable_to_non_nullable
              as String?,
      measureValue: freezed == measureValue
          ? _self.measureValue
          : measureValue // ignore: cast_nullable_to_non_nullable
              as Measure?,
      medicationValue: freezed == medicationValue
          ? _self.medicationValue
          : medicationValue // ignore: cast_nullable_to_non_nullable
              as Medication?,
      timeSeries: freezed == timeSeries
          ? _self.timeSeries
          : timeSeries // ignore: cast_nullable_to_non_nullable
              as TimeSeries?,
      compoundValue: freezed == compoundValue
          ? _self._compoundValue
          : compoundValue // ignore: cast_nullable_to_non_nullable
              as List<EncryptedService>?,
      ratio: freezed == ratio
          ? _self._ratio
          : ratio // ignore: cast_nullable_to_non_nullable
              as List<Measure>?,
      range: freezed == range
          ? _self._range
          : range // ignore: cast_nullable_to_non_nullable
              as List<Measure>?,
    ));
  }

  /// Create a copy of EncryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $MeasureCopyWith<$Res>? get measureValue {
    if (_self.measureValue == null) {
      return null;
    }

    return $MeasureCopyWith<$Res>(_self.measureValue!, (value) {
      return _then(_self.copyWith(measureValue: value));
    });
  }

  /// Create a copy of EncryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $MedicationCopyWith<$Res>? get medicationValue {
    if (_self.medicationValue == null) {
      return null;
    }

    return $MedicationCopyWith<$Res>(_self.medicationValue!, (value) {
      return _then(_self.copyWith(medicationValue: value));
    });
  }

  /// Create a copy of EncryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $TimeSeriesCopyWith<$Res>? get timeSeries {
    if (_self.timeSeries == null) {
      return null;
    }

    return $TimeSeriesCopyWith<$Res>(_self.timeSeries!, (value) {
      return _then(_self.copyWith(timeSeries: value));
    });
  }
}

/// @nodoc
mixin _$DecryptedContent {
  String? get stringValue;
  double? get numberValue;
  bool? get booleanValue;
  DateTime? get instantValue;
  int? get fuzzyDateValue;
  Uint8List? get binaryValue;
  String? get documentId;
  Measure? get measureValue;
  Medication? get medicationValue;
  TimeSeries? get timeSeries;
  List<DecryptedService>? get compoundValue;
  List<Measure>? get ratio;
  List<Measure>? get range;

  /// Create a copy of DecryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedContentCopyWith<DecryptedContent> get copyWith =>
      _$DecryptedContentCopyWithImpl<DecryptedContent>(
          this as DecryptedContent, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedContent &&
            (identical(other.stringValue, stringValue) ||
                other.stringValue == stringValue) &&
            (identical(other.numberValue, numberValue) ||
                other.numberValue == numberValue) &&
            (identical(other.booleanValue, booleanValue) ||
                other.booleanValue == booleanValue) &&
            (identical(other.instantValue, instantValue) ||
                other.instantValue == instantValue) &&
            (identical(other.fuzzyDateValue, fuzzyDateValue) ||
                other.fuzzyDateValue == fuzzyDateValue) &&
            const DeepCollectionEquality()
                .equals(other.binaryValue, binaryValue) &&
            (identical(other.documentId, documentId) ||
                other.documentId == documentId) &&
            (identical(other.measureValue, measureValue) ||
                other.measureValue == measureValue) &&
            (identical(other.medicationValue, medicationValue) ||
                other.medicationValue == medicationValue) &&
            (identical(other.timeSeries, timeSeries) ||
                other.timeSeries == timeSeries) &&
            const DeepCollectionEquality()
                .equals(other.compoundValue, compoundValue) &&
            const DeepCollectionEquality().equals(other.ratio, ratio) &&
            const DeepCollectionEquality().equals(other.range, range));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      stringValue,
      numberValue,
      booleanValue,
      instantValue,
      fuzzyDateValue,
      const DeepCollectionEquality().hash(binaryValue),
      documentId,
      measureValue,
      medicationValue,
      timeSeries,
      const DeepCollectionEquality().hash(compoundValue),
      const DeepCollectionEquality().hash(ratio),
      const DeepCollectionEquality().hash(range));

  @override
  String toString() {
    return 'DecryptedContent(stringValue: $stringValue, numberValue: $numberValue, booleanValue: $booleanValue, instantValue: $instantValue, fuzzyDateValue: $fuzzyDateValue, binaryValue: $binaryValue, documentId: $documentId, measureValue: $measureValue, medicationValue: $medicationValue, timeSeries: $timeSeries, compoundValue: $compoundValue, ratio: $ratio, range: $range)';
  }
}

/// @nodoc
abstract mixin class $DecryptedContentCopyWith<$Res> {
  factory $DecryptedContentCopyWith(
          DecryptedContent value, $Res Function(DecryptedContent) _then) =
      _$DecryptedContentCopyWithImpl;
  @useResult
  $Res call(
      {String? stringValue,
      double? numberValue,
      bool? booleanValue,
      DateTime? instantValue,
      int? fuzzyDateValue,
      Uint8List? binaryValue,
      String? documentId,
      Measure? measureValue,
      Medication? medicationValue,
      TimeSeries? timeSeries,
      List<DecryptedService>? compoundValue,
      List<Measure>? ratio,
      List<Measure>? range});

  $MeasureCopyWith<$Res>? get measureValue;
  $MedicationCopyWith<$Res>? get medicationValue;
  $TimeSeriesCopyWith<$Res>? get timeSeries;
}

/// @nodoc
class _$DecryptedContentCopyWithImpl<$Res>
    implements $DecryptedContentCopyWith<$Res> {
  _$DecryptedContentCopyWithImpl(this._self, this._then);

  final DecryptedContent _self;
  final $Res Function(DecryptedContent) _then;

  /// Create a copy of DecryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? stringValue = freezed,
    Object? numberValue = freezed,
    Object? booleanValue = freezed,
    Object? instantValue = freezed,
    Object? fuzzyDateValue = freezed,
    Object? binaryValue = freezed,
    Object? documentId = freezed,
    Object? measureValue = freezed,
    Object? medicationValue = freezed,
    Object? timeSeries = freezed,
    Object? compoundValue = freezed,
    Object? ratio = freezed,
    Object? range = freezed,
  }) {
    return _then(_self.copyWith(
      stringValue: freezed == stringValue
          ? _self.stringValue
          : stringValue // ignore: cast_nullable_to_non_nullable
              as String?,
      numberValue: freezed == numberValue
          ? _self.numberValue
          : numberValue // ignore: cast_nullable_to_non_nullable
              as double?,
      booleanValue: freezed == booleanValue
          ? _self.booleanValue
          : booleanValue // ignore: cast_nullable_to_non_nullable
              as bool?,
      instantValue: freezed == instantValue
          ? _self.instantValue
          : instantValue // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      fuzzyDateValue: freezed == fuzzyDateValue
          ? _self.fuzzyDateValue
          : fuzzyDateValue // ignore: cast_nullable_to_non_nullable
              as int?,
      binaryValue: freezed == binaryValue
          ? _self.binaryValue
          : binaryValue // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      documentId: freezed == documentId
          ? _self.documentId
          : documentId // ignore: cast_nullable_to_non_nullable
              as String?,
      measureValue: freezed == measureValue
          ? _self.measureValue
          : measureValue // ignore: cast_nullable_to_non_nullable
              as Measure?,
      medicationValue: freezed == medicationValue
          ? _self.medicationValue
          : medicationValue // ignore: cast_nullable_to_non_nullable
              as Medication?,
      timeSeries: freezed == timeSeries
          ? _self.timeSeries
          : timeSeries // ignore: cast_nullable_to_non_nullable
              as TimeSeries?,
      compoundValue: freezed == compoundValue
          ? _self.compoundValue
          : compoundValue // ignore: cast_nullable_to_non_nullable
              as List<DecryptedService>?,
      ratio: freezed == ratio
          ? _self.ratio
          : ratio // ignore: cast_nullable_to_non_nullable
              as List<Measure>?,
      range: freezed == range
          ? _self.range
          : range // ignore: cast_nullable_to_non_nullable
              as List<Measure>?,
    ));
  }

  /// Create a copy of DecryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $MeasureCopyWith<$Res>? get measureValue {
    if (_self.measureValue == null) {
      return null;
    }

    return $MeasureCopyWith<$Res>(_self.measureValue!, (value) {
      return _then(_self.copyWith(measureValue: value));
    });
  }

  /// Create a copy of DecryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $MedicationCopyWith<$Res>? get medicationValue {
    if (_self.medicationValue == null) {
      return null;
    }

    return $MedicationCopyWith<$Res>(_self.medicationValue!, (value) {
      return _then(_self.copyWith(medicationValue: value));
    });
  }

  /// Create a copy of DecryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $TimeSeriesCopyWith<$Res>? get timeSeries {
    if (_self.timeSeries == null) {
      return null;
    }

    return $TimeSeriesCopyWith<$Res>(_self.timeSeries!, (value) {
      return _then(_self.copyWith(timeSeries: value));
    });
  }
}

/// @nodoc

class _DecryptedContent implements DecryptedContent {
  const _DecryptedContent(
      {this.stringValue = null,
      this.numberValue = null,
      this.booleanValue = null,
      this.instantValue = null,
      this.fuzzyDateValue = null,
      this.binaryValue = null,
      this.documentId = null,
      this.measureValue = null,
      this.medicationValue = null,
      this.timeSeries = null,
      final List<DecryptedService>? compoundValue = null,
      final List<Measure>? ratio = null,
      final List<Measure>? range = null})
      : _compoundValue = compoundValue,
        _ratio = ratio,
        _range = range;

  @override
  @JsonKey()
  final String? stringValue;
  @override
  @JsonKey()
  final double? numberValue;
  @override
  @JsonKey()
  final bool? booleanValue;
  @override
  @JsonKey()
  final DateTime? instantValue;
  @override
  @JsonKey()
  final int? fuzzyDateValue;
  @override
  @JsonKey()
  final Uint8List? binaryValue;
  @override
  @JsonKey()
  final String? documentId;
  @override
  @JsonKey()
  final Measure? measureValue;
  @override
  @JsonKey()
  final Medication? medicationValue;
  @override
  @JsonKey()
  final TimeSeries? timeSeries;
  final List<DecryptedService>? _compoundValue;
  @override
  @JsonKey()
  List<DecryptedService>? get compoundValue {
    final value = _compoundValue;
    if (value == null) return null;
    if (_compoundValue is EqualUnmodifiableListView) return _compoundValue;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  final List<Measure>? _ratio;
  @override
  @JsonKey()
  List<Measure>? get ratio {
    final value = _ratio;
    if (value == null) return null;
    if (_ratio is EqualUnmodifiableListView) return _ratio;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  final List<Measure>? _range;
  @override
  @JsonKey()
  List<Measure>? get range {
    final value = _range;
    if (value == null) return null;
    if (_range is EqualUnmodifiableListView) return _range;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  /// Create a copy of DecryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedContentCopyWith<_DecryptedContent> get copyWith =>
      __$DecryptedContentCopyWithImpl<_DecryptedContent>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedContent &&
            (identical(other.stringValue, stringValue) ||
                other.stringValue == stringValue) &&
            (identical(other.numberValue, numberValue) ||
                other.numberValue == numberValue) &&
            (identical(other.booleanValue, booleanValue) ||
                other.booleanValue == booleanValue) &&
            (identical(other.instantValue, instantValue) ||
                other.instantValue == instantValue) &&
            (identical(other.fuzzyDateValue, fuzzyDateValue) ||
                other.fuzzyDateValue == fuzzyDateValue) &&
            const DeepCollectionEquality()
                .equals(other.binaryValue, binaryValue) &&
            (identical(other.documentId, documentId) ||
                other.documentId == documentId) &&
            (identical(other.measureValue, measureValue) ||
                other.measureValue == measureValue) &&
            (identical(other.medicationValue, medicationValue) ||
                other.medicationValue == medicationValue) &&
            (identical(other.timeSeries, timeSeries) ||
                other.timeSeries == timeSeries) &&
            const DeepCollectionEquality()
                .equals(other._compoundValue, _compoundValue) &&
            const DeepCollectionEquality().equals(other._ratio, _ratio) &&
            const DeepCollectionEquality().equals(other._range, _range));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      stringValue,
      numberValue,
      booleanValue,
      instantValue,
      fuzzyDateValue,
      const DeepCollectionEquality().hash(binaryValue),
      documentId,
      measureValue,
      medicationValue,
      timeSeries,
      const DeepCollectionEquality().hash(_compoundValue),
      const DeepCollectionEquality().hash(_ratio),
      const DeepCollectionEquality().hash(_range));

  @override
  String toString() {
    return 'DecryptedContent(stringValue: $stringValue, numberValue: $numberValue, booleanValue: $booleanValue, instantValue: $instantValue, fuzzyDateValue: $fuzzyDateValue, binaryValue: $binaryValue, documentId: $documentId, measureValue: $measureValue, medicationValue: $medicationValue, timeSeries: $timeSeries, compoundValue: $compoundValue, ratio: $ratio, range: $range)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedContentCopyWith<$Res>
    implements $DecryptedContentCopyWith<$Res> {
  factory _$DecryptedContentCopyWith(
          _DecryptedContent value, $Res Function(_DecryptedContent) _then) =
      __$DecryptedContentCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? stringValue,
      double? numberValue,
      bool? booleanValue,
      DateTime? instantValue,
      int? fuzzyDateValue,
      Uint8List? binaryValue,
      String? documentId,
      Measure? measureValue,
      Medication? medicationValue,
      TimeSeries? timeSeries,
      List<DecryptedService>? compoundValue,
      List<Measure>? ratio,
      List<Measure>? range});

  @override
  $MeasureCopyWith<$Res>? get measureValue;
  @override
  $MedicationCopyWith<$Res>? get medicationValue;
  @override
  $TimeSeriesCopyWith<$Res>? get timeSeries;
}

/// @nodoc
class __$DecryptedContentCopyWithImpl<$Res>
    implements _$DecryptedContentCopyWith<$Res> {
  __$DecryptedContentCopyWithImpl(this._self, this._then);

  final _DecryptedContent _self;
  final $Res Function(_DecryptedContent) _then;

  /// Create a copy of DecryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? stringValue = freezed,
    Object? numberValue = freezed,
    Object? booleanValue = freezed,
    Object? instantValue = freezed,
    Object? fuzzyDateValue = freezed,
    Object? binaryValue = freezed,
    Object? documentId = freezed,
    Object? measureValue = freezed,
    Object? medicationValue = freezed,
    Object? timeSeries = freezed,
    Object? compoundValue = freezed,
    Object? ratio = freezed,
    Object? range = freezed,
  }) {
    return _then(_DecryptedContent(
      stringValue: freezed == stringValue
          ? _self.stringValue
          : stringValue // ignore: cast_nullable_to_non_nullable
              as String?,
      numberValue: freezed == numberValue
          ? _self.numberValue
          : numberValue // ignore: cast_nullable_to_non_nullable
              as double?,
      booleanValue: freezed == booleanValue
          ? _self.booleanValue
          : booleanValue // ignore: cast_nullable_to_non_nullable
              as bool?,
      instantValue: freezed == instantValue
          ? _self.instantValue
          : instantValue // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      fuzzyDateValue: freezed == fuzzyDateValue
          ? _self.fuzzyDateValue
          : fuzzyDateValue // ignore: cast_nullable_to_non_nullable
              as int?,
      binaryValue: freezed == binaryValue
          ? _self.binaryValue
          : binaryValue // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      documentId: freezed == documentId
          ? _self.documentId
          : documentId // ignore: cast_nullable_to_non_nullable
              as String?,
      measureValue: freezed == measureValue
          ? _self.measureValue
          : measureValue // ignore: cast_nullable_to_non_nullable
              as Measure?,
      medicationValue: freezed == medicationValue
          ? _self.medicationValue
          : medicationValue // ignore: cast_nullable_to_non_nullable
              as Medication?,
      timeSeries: freezed == timeSeries
          ? _self.timeSeries
          : timeSeries // ignore: cast_nullable_to_non_nullable
              as TimeSeries?,
      compoundValue: freezed == compoundValue
          ? _self._compoundValue
          : compoundValue // ignore: cast_nullable_to_non_nullable
              as List<DecryptedService>?,
      ratio: freezed == ratio
          ? _self._ratio
          : ratio // ignore: cast_nullable_to_non_nullable
              as List<Measure>?,
      range: freezed == range
          ? _self._range
          : range // ignore: cast_nullable_to_non_nullable
              as List<Measure>?,
    ));
  }

  /// Create a copy of DecryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $MeasureCopyWith<$Res>? get measureValue {
    if (_self.measureValue == null) {
      return null;
    }

    return $MeasureCopyWith<$Res>(_self.measureValue!, (value) {
      return _then(_self.copyWith(measureValue: value));
    });
  }

  /// Create a copy of DecryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $MedicationCopyWith<$Res>? get medicationValue {
    if (_self.medicationValue == null) {
      return null;
    }

    return $MedicationCopyWith<$Res>(_self.medicationValue!, (value) {
      return _then(_self.copyWith(medicationValue: value));
    });
  }

  /// Create a copy of DecryptedContent
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $TimeSeriesCopyWith<$Res>? get timeSeries {
    if (_self.timeSeries == null) {
      return null;
    }

    return $TimeSeriesCopyWith<$Res>(_self.timeSeries!, (value) {
      return _then(_self.copyWith(timeSeries: value));
    });
  }
}

// dart format on
