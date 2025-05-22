// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'valorisation.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedValorisation {
  int? get startOfValidity;
  int? get endOfValidity;
  String? get predicate;
  List<int>? get reference;
  double? get totalAmount;
  double? get reimbursement;
  double? get patientIntervention;
  double? get doctorSupplement;
  double? get vat;
  Map<String, String>? get label;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedValorisation
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedValorisationCopyWith<EncryptedValorisation> get copyWith =>
      _$EncryptedValorisationCopyWithImpl<EncryptedValorisation>(
          this as EncryptedValorisation, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedValorisation &&
            (identical(other.startOfValidity, startOfValidity) ||
                other.startOfValidity == startOfValidity) &&
            (identical(other.endOfValidity, endOfValidity) ||
                other.endOfValidity == endOfValidity) &&
            (identical(other.predicate, predicate) ||
                other.predicate == predicate) &&
            const DeepCollectionEquality().equals(other.reference, reference) &&
            (identical(other.totalAmount, totalAmount) ||
                other.totalAmount == totalAmount) &&
            (identical(other.reimbursement, reimbursement) ||
                other.reimbursement == reimbursement) &&
            (identical(other.patientIntervention, patientIntervention) ||
                other.patientIntervention == patientIntervention) &&
            (identical(other.doctorSupplement, doctorSupplement) ||
                other.doctorSupplement == doctorSupplement) &&
            (identical(other.vat, vat) || other.vat == vat) &&
            const DeepCollectionEquality().equals(other.label, label) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      startOfValidity,
      endOfValidity,
      predicate,
      const DeepCollectionEquality().hash(reference),
      totalAmount,
      reimbursement,
      patientIntervention,
      doctorSupplement,
      vat,
      const DeepCollectionEquality().hash(label),
      encryptedSelf);

  @override
  String toString() {
    return 'EncryptedValorisation(startOfValidity: $startOfValidity, endOfValidity: $endOfValidity, predicate: $predicate, reference: $reference, totalAmount: $totalAmount, reimbursement: $reimbursement, patientIntervention: $patientIntervention, doctorSupplement: $doctorSupplement, vat: $vat, label: $label, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedValorisationCopyWith<$Res> {
  factory $EncryptedValorisationCopyWith(EncryptedValorisation value,
          $Res Function(EncryptedValorisation) _then) =
      _$EncryptedValorisationCopyWithImpl;
  @useResult
  $Res call(
      {int? startOfValidity,
      int? endOfValidity,
      String? predicate,
      List<int>? reference,
      double? totalAmount,
      double? reimbursement,
      double? patientIntervention,
      double? doctorSupplement,
      double? vat,
      Map<String, String>? label,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$EncryptedValorisationCopyWithImpl<$Res>
    implements $EncryptedValorisationCopyWith<$Res> {
  _$EncryptedValorisationCopyWithImpl(this._self, this._then);

  final EncryptedValorisation _self;
  final $Res Function(EncryptedValorisation) _then;

  /// Create a copy of EncryptedValorisation
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? startOfValidity = freezed,
    Object? endOfValidity = freezed,
    Object? predicate = freezed,
    Object? reference = freezed,
    Object? totalAmount = freezed,
    Object? reimbursement = freezed,
    Object? patientIntervention = freezed,
    Object? doctorSupplement = freezed,
    Object? vat = freezed,
    Object? label = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      startOfValidity: freezed == startOfValidity
          ? _self.startOfValidity
          : startOfValidity // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfValidity: freezed == endOfValidity
          ? _self.endOfValidity
          : endOfValidity // ignore: cast_nullable_to_non_nullable
              as int?,
      predicate: freezed == predicate
          ? _self.predicate
          : predicate // ignore: cast_nullable_to_non_nullable
              as String?,
      reference: freezed == reference
          ? _self.reference
          : reference // ignore: cast_nullable_to_non_nullable
              as List<int>?,
      totalAmount: freezed == totalAmount
          ? _self.totalAmount
          : totalAmount // ignore: cast_nullable_to_non_nullable
              as double?,
      reimbursement: freezed == reimbursement
          ? _self.reimbursement
          : reimbursement // ignore: cast_nullable_to_non_nullable
              as double?,
      patientIntervention: freezed == patientIntervention
          ? _self.patientIntervention
          : patientIntervention // ignore: cast_nullable_to_non_nullable
              as double?,
      doctorSupplement: freezed == doctorSupplement
          ? _self.doctorSupplement
          : doctorSupplement // ignore: cast_nullable_to_non_nullable
              as double?,
      vat: freezed == vat
          ? _self.vat
          : vat // ignore: cast_nullable_to_non_nullable
              as double?,
      label: freezed == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _EncryptedValorisation implements EncryptedValorisation {
  const _EncryptedValorisation(
      {this.startOfValidity = null,
      this.endOfValidity = null,
      this.predicate = null,
      final List<int>? reference = null,
      this.totalAmount = null,
      this.reimbursement = null,
      this.patientIntervention = null,
      this.doctorSupplement = null,
      this.vat = null,
      final Map<String, String>? label = const {},
      this.encryptedSelf = null})
      : _reference = reference,
        _label = label;

  @override
  @JsonKey()
  final int? startOfValidity;
  @override
  @JsonKey()
  final int? endOfValidity;
  @override
  @JsonKey()
  final String? predicate;
  final List<int>? _reference;
  @override
  @JsonKey()
  List<int>? get reference {
    final value = _reference;
    if (value == null) return null;
    if (_reference is EqualUnmodifiableListView) return _reference;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  @override
  @JsonKey()
  final double? totalAmount;
  @override
  @JsonKey()
  final double? reimbursement;
  @override
  @JsonKey()
  final double? patientIntervention;
  @override
  @JsonKey()
  final double? doctorSupplement;
  @override
  @JsonKey()
  final double? vat;
  final Map<String, String>? _label;
  @override
  @JsonKey()
  Map<String, String>? get label {
    final value = _label;
    if (value == null) return null;
    if (_label is EqualUnmodifiableMapView) return _label;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(value);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedValorisation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedValorisationCopyWith<_EncryptedValorisation> get copyWith =>
      __$EncryptedValorisationCopyWithImpl<_EncryptedValorisation>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedValorisation &&
            (identical(other.startOfValidity, startOfValidity) ||
                other.startOfValidity == startOfValidity) &&
            (identical(other.endOfValidity, endOfValidity) ||
                other.endOfValidity == endOfValidity) &&
            (identical(other.predicate, predicate) ||
                other.predicate == predicate) &&
            const DeepCollectionEquality()
                .equals(other._reference, _reference) &&
            (identical(other.totalAmount, totalAmount) ||
                other.totalAmount == totalAmount) &&
            (identical(other.reimbursement, reimbursement) ||
                other.reimbursement == reimbursement) &&
            (identical(other.patientIntervention, patientIntervention) ||
                other.patientIntervention == patientIntervention) &&
            (identical(other.doctorSupplement, doctorSupplement) ||
                other.doctorSupplement == doctorSupplement) &&
            (identical(other.vat, vat) || other.vat == vat) &&
            const DeepCollectionEquality().equals(other._label, _label) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      startOfValidity,
      endOfValidity,
      predicate,
      const DeepCollectionEquality().hash(_reference),
      totalAmount,
      reimbursement,
      patientIntervention,
      doctorSupplement,
      vat,
      const DeepCollectionEquality().hash(_label),
      encryptedSelf);

  @override
  String toString() {
    return 'EncryptedValorisation(startOfValidity: $startOfValidity, endOfValidity: $endOfValidity, predicate: $predicate, reference: $reference, totalAmount: $totalAmount, reimbursement: $reimbursement, patientIntervention: $patientIntervention, doctorSupplement: $doctorSupplement, vat: $vat, label: $label, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedValorisationCopyWith<$Res>
    implements $EncryptedValorisationCopyWith<$Res> {
  factory _$EncryptedValorisationCopyWith(_EncryptedValorisation value,
          $Res Function(_EncryptedValorisation) _then) =
      __$EncryptedValorisationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {int? startOfValidity,
      int? endOfValidity,
      String? predicate,
      List<int>? reference,
      double? totalAmount,
      double? reimbursement,
      double? patientIntervention,
      double? doctorSupplement,
      double? vat,
      Map<String, String>? label,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$EncryptedValorisationCopyWithImpl<$Res>
    implements _$EncryptedValorisationCopyWith<$Res> {
  __$EncryptedValorisationCopyWithImpl(this._self, this._then);

  final _EncryptedValorisation _self;
  final $Res Function(_EncryptedValorisation) _then;

  /// Create a copy of EncryptedValorisation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? startOfValidity = freezed,
    Object? endOfValidity = freezed,
    Object? predicate = freezed,
    Object? reference = freezed,
    Object? totalAmount = freezed,
    Object? reimbursement = freezed,
    Object? patientIntervention = freezed,
    Object? doctorSupplement = freezed,
    Object? vat = freezed,
    Object? label = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedValorisation(
      startOfValidity: freezed == startOfValidity
          ? _self.startOfValidity
          : startOfValidity // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfValidity: freezed == endOfValidity
          ? _self.endOfValidity
          : endOfValidity // ignore: cast_nullable_to_non_nullable
              as int?,
      predicate: freezed == predicate
          ? _self.predicate
          : predicate // ignore: cast_nullable_to_non_nullable
              as String?,
      reference: freezed == reference
          ? _self._reference
          : reference // ignore: cast_nullable_to_non_nullable
              as List<int>?,
      totalAmount: freezed == totalAmount
          ? _self.totalAmount
          : totalAmount // ignore: cast_nullable_to_non_nullable
              as double?,
      reimbursement: freezed == reimbursement
          ? _self.reimbursement
          : reimbursement // ignore: cast_nullable_to_non_nullable
              as double?,
      patientIntervention: freezed == patientIntervention
          ? _self.patientIntervention
          : patientIntervention // ignore: cast_nullable_to_non_nullable
              as double?,
      doctorSupplement: freezed == doctorSupplement
          ? _self.doctorSupplement
          : doctorSupplement // ignore: cast_nullable_to_non_nullable
              as double?,
      vat: freezed == vat
          ? _self.vat
          : vat // ignore: cast_nullable_to_non_nullable
              as double?,
      label: freezed == label
          ? _self._label
          : label // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc
mixin _$DecryptedValorisation {
  int? get startOfValidity;
  int? get endOfValidity;
  String? get predicate;
  List<int>? get reference;
  double? get totalAmount;
  double? get reimbursement;
  double? get patientIntervention;
  double? get doctorSupplement;
  double? get vat;
  Map<String, String>? get label;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedValorisation
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedValorisationCopyWith<DecryptedValorisation> get copyWith =>
      _$DecryptedValorisationCopyWithImpl<DecryptedValorisation>(
          this as DecryptedValorisation, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedValorisation &&
            (identical(other.startOfValidity, startOfValidity) ||
                other.startOfValidity == startOfValidity) &&
            (identical(other.endOfValidity, endOfValidity) ||
                other.endOfValidity == endOfValidity) &&
            (identical(other.predicate, predicate) ||
                other.predicate == predicate) &&
            const DeepCollectionEquality().equals(other.reference, reference) &&
            (identical(other.totalAmount, totalAmount) ||
                other.totalAmount == totalAmount) &&
            (identical(other.reimbursement, reimbursement) ||
                other.reimbursement == reimbursement) &&
            (identical(other.patientIntervention, patientIntervention) ||
                other.patientIntervention == patientIntervention) &&
            (identical(other.doctorSupplement, doctorSupplement) ||
                other.doctorSupplement == doctorSupplement) &&
            (identical(other.vat, vat) || other.vat == vat) &&
            const DeepCollectionEquality().equals(other.label, label) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      startOfValidity,
      endOfValidity,
      predicate,
      const DeepCollectionEquality().hash(reference),
      totalAmount,
      reimbursement,
      patientIntervention,
      doctorSupplement,
      vat,
      const DeepCollectionEquality().hash(label),
      encryptedSelf);

  @override
  String toString() {
    return 'DecryptedValorisation(startOfValidity: $startOfValidity, endOfValidity: $endOfValidity, predicate: $predicate, reference: $reference, totalAmount: $totalAmount, reimbursement: $reimbursement, patientIntervention: $patientIntervention, doctorSupplement: $doctorSupplement, vat: $vat, label: $label, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedValorisationCopyWith<$Res> {
  factory $DecryptedValorisationCopyWith(DecryptedValorisation value,
          $Res Function(DecryptedValorisation) _then) =
      _$DecryptedValorisationCopyWithImpl;
  @useResult
  $Res call(
      {int? startOfValidity,
      int? endOfValidity,
      String? predicate,
      List<int>? reference,
      double? totalAmount,
      double? reimbursement,
      double? patientIntervention,
      double? doctorSupplement,
      double? vat,
      Map<String, String>? label,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$DecryptedValorisationCopyWithImpl<$Res>
    implements $DecryptedValorisationCopyWith<$Res> {
  _$DecryptedValorisationCopyWithImpl(this._self, this._then);

  final DecryptedValorisation _self;
  final $Res Function(DecryptedValorisation) _then;

  /// Create a copy of DecryptedValorisation
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? startOfValidity = freezed,
    Object? endOfValidity = freezed,
    Object? predicate = freezed,
    Object? reference = freezed,
    Object? totalAmount = freezed,
    Object? reimbursement = freezed,
    Object? patientIntervention = freezed,
    Object? doctorSupplement = freezed,
    Object? vat = freezed,
    Object? label = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      startOfValidity: freezed == startOfValidity
          ? _self.startOfValidity
          : startOfValidity // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfValidity: freezed == endOfValidity
          ? _self.endOfValidity
          : endOfValidity // ignore: cast_nullable_to_non_nullable
              as int?,
      predicate: freezed == predicate
          ? _self.predicate
          : predicate // ignore: cast_nullable_to_non_nullable
              as String?,
      reference: freezed == reference
          ? _self.reference
          : reference // ignore: cast_nullable_to_non_nullable
              as List<int>?,
      totalAmount: freezed == totalAmount
          ? _self.totalAmount
          : totalAmount // ignore: cast_nullable_to_non_nullable
              as double?,
      reimbursement: freezed == reimbursement
          ? _self.reimbursement
          : reimbursement // ignore: cast_nullable_to_non_nullable
              as double?,
      patientIntervention: freezed == patientIntervention
          ? _self.patientIntervention
          : patientIntervention // ignore: cast_nullable_to_non_nullable
              as double?,
      doctorSupplement: freezed == doctorSupplement
          ? _self.doctorSupplement
          : doctorSupplement // ignore: cast_nullable_to_non_nullable
              as double?,
      vat: freezed == vat
          ? _self.vat
          : vat // ignore: cast_nullable_to_non_nullable
              as double?,
      label: freezed == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _DecryptedValorisation implements DecryptedValorisation {
  const _DecryptedValorisation(
      {this.startOfValidity = null,
      this.endOfValidity = null,
      this.predicate = null,
      final List<int>? reference = null,
      this.totalAmount = null,
      this.reimbursement = null,
      this.patientIntervention = null,
      this.doctorSupplement = null,
      this.vat = null,
      final Map<String, String>? label = const {},
      this.encryptedSelf = null})
      : _reference = reference,
        _label = label;

  @override
  @JsonKey()
  final int? startOfValidity;
  @override
  @JsonKey()
  final int? endOfValidity;
  @override
  @JsonKey()
  final String? predicate;
  final List<int>? _reference;
  @override
  @JsonKey()
  List<int>? get reference {
    final value = _reference;
    if (value == null) return null;
    if (_reference is EqualUnmodifiableListView) return _reference;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  @override
  @JsonKey()
  final double? totalAmount;
  @override
  @JsonKey()
  final double? reimbursement;
  @override
  @JsonKey()
  final double? patientIntervention;
  @override
  @JsonKey()
  final double? doctorSupplement;
  @override
  @JsonKey()
  final double? vat;
  final Map<String, String>? _label;
  @override
  @JsonKey()
  Map<String, String>? get label {
    final value = _label;
    if (value == null) return null;
    if (_label is EqualUnmodifiableMapView) return _label;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(value);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedValorisation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedValorisationCopyWith<_DecryptedValorisation> get copyWith =>
      __$DecryptedValorisationCopyWithImpl<_DecryptedValorisation>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedValorisation &&
            (identical(other.startOfValidity, startOfValidity) ||
                other.startOfValidity == startOfValidity) &&
            (identical(other.endOfValidity, endOfValidity) ||
                other.endOfValidity == endOfValidity) &&
            (identical(other.predicate, predicate) ||
                other.predicate == predicate) &&
            const DeepCollectionEquality()
                .equals(other._reference, _reference) &&
            (identical(other.totalAmount, totalAmount) ||
                other.totalAmount == totalAmount) &&
            (identical(other.reimbursement, reimbursement) ||
                other.reimbursement == reimbursement) &&
            (identical(other.patientIntervention, patientIntervention) ||
                other.patientIntervention == patientIntervention) &&
            (identical(other.doctorSupplement, doctorSupplement) ||
                other.doctorSupplement == doctorSupplement) &&
            (identical(other.vat, vat) || other.vat == vat) &&
            const DeepCollectionEquality().equals(other._label, _label) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      startOfValidity,
      endOfValidity,
      predicate,
      const DeepCollectionEquality().hash(_reference),
      totalAmount,
      reimbursement,
      patientIntervention,
      doctorSupplement,
      vat,
      const DeepCollectionEquality().hash(_label),
      encryptedSelf);

  @override
  String toString() {
    return 'DecryptedValorisation(startOfValidity: $startOfValidity, endOfValidity: $endOfValidity, predicate: $predicate, reference: $reference, totalAmount: $totalAmount, reimbursement: $reimbursement, patientIntervention: $patientIntervention, doctorSupplement: $doctorSupplement, vat: $vat, label: $label, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedValorisationCopyWith<$Res>
    implements $DecryptedValorisationCopyWith<$Res> {
  factory _$DecryptedValorisationCopyWith(_DecryptedValorisation value,
          $Res Function(_DecryptedValorisation) _then) =
      __$DecryptedValorisationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {int? startOfValidity,
      int? endOfValidity,
      String? predicate,
      List<int>? reference,
      double? totalAmount,
      double? reimbursement,
      double? patientIntervention,
      double? doctorSupplement,
      double? vat,
      Map<String, String>? label,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$DecryptedValorisationCopyWithImpl<$Res>
    implements _$DecryptedValorisationCopyWith<$Res> {
  __$DecryptedValorisationCopyWithImpl(this._self, this._then);

  final _DecryptedValorisation _self;
  final $Res Function(_DecryptedValorisation) _then;

  /// Create a copy of DecryptedValorisation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? startOfValidity = freezed,
    Object? endOfValidity = freezed,
    Object? predicate = freezed,
    Object? reference = freezed,
    Object? totalAmount = freezed,
    Object? reimbursement = freezed,
    Object? patientIntervention = freezed,
    Object? doctorSupplement = freezed,
    Object? vat = freezed,
    Object? label = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedValorisation(
      startOfValidity: freezed == startOfValidity
          ? _self.startOfValidity
          : startOfValidity // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfValidity: freezed == endOfValidity
          ? _self.endOfValidity
          : endOfValidity // ignore: cast_nullable_to_non_nullable
              as int?,
      predicate: freezed == predicate
          ? _self.predicate
          : predicate // ignore: cast_nullable_to_non_nullable
              as String?,
      reference: freezed == reference
          ? _self._reference
          : reference // ignore: cast_nullable_to_non_nullable
              as List<int>?,
      totalAmount: freezed == totalAmount
          ? _self.totalAmount
          : totalAmount // ignore: cast_nullable_to_non_nullable
              as double?,
      reimbursement: freezed == reimbursement
          ? _self.reimbursement
          : reimbursement // ignore: cast_nullable_to_non_nullable
              as double?,
      patientIntervention: freezed == patientIntervention
          ? _self.patientIntervention
          : patientIntervention // ignore: cast_nullable_to_non_nullable
              as double?,
      doctorSupplement: freezed == doctorSupplement
          ? _self.doctorSupplement
          : doctorSupplement // ignore: cast_nullable_to_non_nullable
              as double?,
      vat: freezed == vat
          ? _self.vat
          : vat // ignore: cast_nullable_to_non_nullable
              as double?,
      label: freezed == label
          ? _self._label
          : label // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

// dart format on
