// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'medical_house_contract.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DecryptedMedicalHouseContract {
  String? get contractId;
  int? get validFrom;
  int? get validTo;
  String? get mmNihii;
  String? get hcpId;
  ContractChangeType? get changeType;
  String? get parentContractId;
  String? get changedBy;
  int? get startOfContract;
  int? get startOfCoverage;
  int? get endOfContract;
  int? get endOfCoverage;
  bool get kine;
  bool get gp;
  bool get ptd;
  bool get nurse;
  bool get noKine;
  bool get noGp;
  bool get noNurse;
  int? get unsubscriptionReasonId;
  int? get ptdStart;
  int? get ptdEnd;
  int? get ptdLastInvoiced;
  int? get startOfSuspension;
  int? get endOfSuspension;
  SuspensionReason? get suspensionReason;
  String? get suspensionSource;
  bool get forcedSuspension;
  MhcSignatureType? get signatureType;
  int? get status;
  Map<String, String> get options;
  Map<String, String> get receipts;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedMedicalHouseContract
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedMedicalHouseContractCopyWith<DecryptedMedicalHouseContract>
      get copyWith => _$DecryptedMedicalHouseContractCopyWithImpl<
              DecryptedMedicalHouseContract>(
          this as DecryptedMedicalHouseContract, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedMedicalHouseContract &&
            (identical(other.contractId, contractId) ||
                other.contractId == contractId) &&
            (identical(other.validFrom, validFrom) ||
                other.validFrom == validFrom) &&
            (identical(other.validTo, validTo) || other.validTo == validTo) &&
            (identical(other.mmNihii, mmNihii) || other.mmNihii == mmNihii) &&
            (identical(other.hcpId, hcpId) || other.hcpId == hcpId) &&
            (identical(other.changeType, changeType) ||
                other.changeType == changeType) &&
            (identical(other.parentContractId, parentContractId) ||
                other.parentContractId == parentContractId) &&
            (identical(other.changedBy, changedBy) ||
                other.changedBy == changedBy) &&
            (identical(other.startOfContract, startOfContract) ||
                other.startOfContract == startOfContract) &&
            (identical(other.startOfCoverage, startOfCoverage) ||
                other.startOfCoverage == startOfCoverage) &&
            (identical(other.endOfContract, endOfContract) ||
                other.endOfContract == endOfContract) &&
            (identical(other.endOfCoverage, endOfCoverage) ||
                other.endOfCoverage == endOfCoverage) &&
            (identical(other.kine, kine) || other.kine == kine) &&
            (identical(other.gp, gp) || other.gp == gp) &&
            (identical(other.ptd, ptd) || other.ptd == ptd) &&
            (identical(other.nurse, nurse) || other.nurse == nurse) &&
            (identical(other.noKine, noKine) || other.noKine == noKine) &&
            (identical(other.noGp, noGp) || other.noGp == noGp) &&
            (identical(other.noNurse, noNurse) || other.noNurse == noNurse) &&
            (identical(other.unsubscriptionReasonId, unsubscriptionReasonId) ||
                other.unsubscriptionReasonId == unsubscriptionReasonId) &&
            (identical(other.ptdStart, ptdStart) ||
                other.ptdStart == ptdStart) &&
            (identical(other.ptdEnd, ptdEnd) || other.ptdEnd == ptdEnd) &&
            (identical(other.ptdLastInvoiced, ptdLastInvoiced) ||
                other.ptdLastInvoiced == ptdLastInvoiced) &&
            (identical(other.startOfSuspension, startOfSuspension) ||
                other.startOfSuspension == startOfSuspension) &&
            (identical(other.endOfSuspension, endOfSuspension) ||
                other.endOfSuspension == endOfSuspension) &&
            (identical(other.suspensionReason, suspensionReason) ||
                other.suspensionReason == suspensionReason) &&
            (identical(other.suspensionSource, suspensionSource) ||
                other.suspensionSource == suspensionSource) &&
            (identical(other.forcedSuspension, forcedSuspension) ||
                other.forcedSuspension == forcedSuspension) &&
            (identical(other.signatureType, signatureType) ||
                other.signatureType == signatureType) &&
            (identical(other.status, status) || other.status == status) &&
            const DeepCollectionEquality().equals(other.options, options) &&
            const DeepCollectionEquality().equals(other.receipts, receipts) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        contractId,
        validFrom,
        validTo,
        mmNihii,
        hcpId,
        changeType,
        parentContractId,
        changedBy,
        startOfContract,
        startOfCoverage,
        endOfContract,
        endOfCoverage,
        kine,
        gp,
        ptd,
        nurse,
        noKine,
        noGp,
        noNurse,
        unsubscriptionReasonId,
        ptdStart,
        ptdEnd,
        ptdLastInvoiced,
        startOfSuspension,
        endOfSuspension,
        suspensionReason,
        suspensionSource,
        forcedSuspension,
        signatureType,
        status,
        const DeepCollectionEquality().hash(options),
        const DeepCollectionEquality().hash(receipts),
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'DecryptedMedicalHouseContract(contractId: $contractId, validFrom: $validFrom, validTo: $validTo, mmNihii: $mmNihii, hcpId: $hcpId, changeType: $changeType, parentContractId: $parentContractId, changedBy: $changedBy, startOfContract: $startOfContract, startOfCoverage: $startOfCoverage, endOfContract: $endOfContract, endOfCoverage: $endOfCoverage, kine: $kine, gp: $gp, ptd: $ptd, nurse: $nurse, noKine: $noKine, noGp: $noGp, noNurse: $noNurse, unsubscriptionReasonId: $unsubscriptionReasonId, ptdStart: $ptdStart, ptdEnd: $ptdEnd, ptdLastInvoiced: $ptdLastInvoiced, startOfSuspension: $startOfSuspension, endOfSuspension: $endOfSuspension, suspensionReason: $suspensionReason, suspensionSource: $suspensionSource, forcedSuspension: $forcedSuspension, signatureType: $signatureType, status: $status, options: $options, receipts: $receipts, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedMedicalHouseContractCopyWith<$Res> {
  factory $DecryptedMedicalHouseContractCopyWith(
          DecryptedMedicalHouseContract value,
          $Res Function(DecryptedMedicalHouseContract) _then) =
      _$DecryptedMedicalHouseContractCopyWithImpl;
  @useResult
  $Res call(
      {String? contractId,
      int? validFrom,
      int? validTo,
      String? mmNihii,
      String? hcpId,
      ContractChangeType? changeType,
      String? parentContractId,
      String? changedBy,
      int? startOfContract,
      int? startOfCoverage,
      int? endOfContract,
      int? endOfCoverage,
      bool kine,
      bool gp,
      bool ptd,
      bool nurse,
      bool noKine,
      bool noGp,
      bool noNurse,
      int? unsubscriptionReasonId,
      int? ptdStart,
      int? ptdEnd,
      int? ptdLastInvoiced,
      int? startOfSuspension,
      int? endOfSuspension,
      SuspensionReason? suspensionReason,
      String? suspensionSource,
      bool forcedSuspension,
      MhcSignatureType? signatureType,
      int? status,
      Map<String, String> options,
      Map<String, String> receipts,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$DecryptedMedicalHouseContractCopyWithImpl<$Res>
    implements $DecryptedMedicalHouseContractCopyWith<$Res> {
  _$DecryptedMedicalHouseContractCopyWithImpl(this._self, this._then);

  final DecryptedMedicalHouseContract _self;
  final $Res Function(DecryptedMedicalHouseContract) _then;

  /// Create a copy of DecryptedMedicalHouseContract
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? contractId = freezed,
    Object? validFrom = freezed,
    Object? validTo = freezed,
    Object? mmNihii = freezed,
    Object? hcpId = freezed,
    Object? changeType = freezed,
    Object? parentContractId = freezed,
    Object? changedBy = freezed,
    Object? startOfContract = freezed,
    Object? startOfCoverage = freezed,
    Object? endOfContract = freezed,
    Object? endOfCoverage = freezed,
    Object? kine = null,
    Object? gp = null,
    Object? ptd = null,
    Object? nurse = null,
    Object? noKine = null,
    Object? noGp = null,
    Object? noNurse = null,
    Object? unsubscriptionReasonId = freezed,
    Object? ptdStart = freezed,
    Object? ptdEnd = freezed,
    Object? ptdLastInvoiced = freezed,
    Object? startOfSuspension = freezed,
    Object? endOfSuspension = freezed,
    Object? suspensionReason = freezed,
    Object? suspensionSource = freezed,
    Object? forcedSuspension = null,
    Object? signatureType = freezed,
    Object? status = freezed,
    Object? options = null,
    Object? receipts = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      contractId: freezed == contractId
          ? _self.contractId
          : contractId // ignore: cast_nullable_to_non_nullable
              as String?,
      validFrom: freezed == validFrom
          ? _self.validFrom
          : validFrom // ignore: cast_nullable_to_non_nullable
              as int?,
      validTo: freezed == validTo
          ? _self.validTo
          : validTo // ignore: cast_nullable_to_non_nullable
              as int?,
      mmNihii: freezed == mmNihii
          ? _self.mmNihii
          : mmNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      hcpId: freezed == hcpId
          ? _self.hcpId
          : hcpId // ignore: cast_nullable_to_non_nullable
              as String?,
      changeType: freezed == changeType
          ? _self.changeType
          : changeType // ignore: cast_nullable_to_non_nullable
              as ContractChangeType?,
      parentContractId: freezed == parentContractId
          ? _self.parentContractId
          : parentContractId // ignore: cast_nullable_to_non_nullable
              as String?,
      changedBy: freezed == changedBy
          ? _self.changedBy
          : changedBy // ignore: cast_nullable_to_non_nullable
              as String?,
      startOfContract: freezed == startOfContract
          ? _self.startOfContract
          : startOfContract // ignore: cast_nullable_to_non_nullable
              as int?,
      startOfCoverage: freezed == startOfCoverage
          ? _self.startOfCoverage
          : startOfCoverage // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfContract: freezed == endOfContract
          ? _self.endOfContract
          : endOfContract // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfCoverage: freezed == endOfCoverage
          ? _self.endOfCoverage
          : endOfCoverage // ignore: cast_nullable_to_non_nullable
              as int?,
      kine: null == kine
          ? _self.kine
          : kine // ignore: cast_nullable_to_non_nullable
              as bool,
      gp: null == gp
          ? _self.gp
          : gp // ignore: cast_nullable_to_non_nullable
              as bool,
      ptd: null == ptd
          ? _self.ptd
          : ptd // ignore: cast_nullable_to_non_nullable
              as bool,
      nurse: null == nurse
          ? _self.nurse
          : nurse // ignore: cast_nullable_to_non_nullable
              as bool,
      noKine: null == noKine
          ? _self.noKine
          : noKine // ignore: cast_nullable_to_non_nullable
              as bool,
      noGp: null == noGp
          ? _self.noGp
          : noGp // ignore: cast_nullable_to_non_nullable
              as bool,
      noNurse: null == noNurse
          ? _self.noNurse
          : noNurse // ignore: cast_nullable_to_non_nullable
              as bool,
      unsubscriptionReasonId: freezed == unsubscriptionReasonId
          ? _self.unsubscriptionReasonId
          : unsubscriptionReasonId // ignore: cast_nullable_to_non_nullable
              as int?,
      ptdStart: freezed == ptdStart
          ? _self.ptdStart
          : ptdStart // ignore: cast_nullable_to_non_nullable
              as int?,
      ptdEnd: freezed == ptdEnd
          ? _self.ptdEnd
          : ptdEnd // ignore: cast_nullable_to_non_nullable
              as int?,
      ptdLastInvoiced: freezed == ptdLastInvoiced
          ? _self.ptdLastInvoiced
          : ptdLastInvoiced // ignore: cast_nullable_to_non_nullable
              as int?,
      startOfSuspension: freezed == startOfSuspension
          ? _self.startOfSuspension
          : startOfSuspension // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfSuspension: freezed == endOfSuspension
          ? _self.endOfSuspension
          : endOfSuspension // ignore: cast_nullable_to_non_nullable
              as int?,
      suspensionReason: freezed == suspensionReason
          ? _self.suspensionReason
          : suspensionReason // ignore: cast_nullable_to_non_nullable
              as SuspensionReason?,
      suspensionSource: freezed == suspensionSource
          ? _self.suspensionSource
          : suspensionSource // ignore: cast_nullable_to_non_nullable
              as String?,
      forcedSuspension: null == forcedSuspension
          ? _self.forcedSuspension
          : forcedSuspension // ignore: cast_nullable_to_non_nullable
              as bool,
      signatureType: freezed == signatureType
          ? _self.signatureType
          : signatureType // ignore: cast_nullable_to_non_nullable
              as MhcSignatureType?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      options: null == options
          ? _self.options
          : options // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      receipts: null == receipts
          ? _self.receipts
          : receipts // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _DecryptedMedicalHouseContract implements DecryptedMedicalHouseContract {
  const _DecryptedMedicalHouseContract(
      {this.contractId = null,
      this.validFrom = null,
      this.validTo = null,
      this.mmNihii = null,
      this.hcpId = null,
      this.changeType = null,
      this.parentContractId = null,
      this.changedBy = null,
      this.startOfContract = null,
      this.startOfCoverage = null,
      this.endOfContract = null,
      this.endOfCoverage = null,
      this.kine = false,
      this.gp = false,
      this.ptd = false,
      this.nurse = false,
      this.noKine = false,
      this.noGp = false,
      this.noNurse = false,
      this.unsubscriptionReasonId = null,
      this.ptdStart = null,
      this.ptdEnd = null,
      this.ptdLastInvoiced = null,
      this.startOfSuspension = null,
      this.endOfSuspension = null,
      this.suspensionReason = null,
      this.suspensionSource = null,
      this.forcedSuspension = false,
      this.signatureType = null,
      this.status = null,
      final Map<String, String> options = const {},
      final Map<String, String> receipts = const {},
      this.encryptedSelf = null})
      : _options = options,
        _receipts = receipts;

  @override
  @JsonKey()
  final String? contractId;
  @override
  @JsonKey()
  final int? validFrom;
  @override
  @JsonKey()
  final int? validTo;
  @override
  @JsonKey()
  final String? mmNihii;
  @override
  @JsonKey()
  final String? hcpId;
  @override
  @JsonKey()
  final ContractChangeType? changeType;
  @override
  @JsonKey()
  final String? parentContractId;
  @override
  @JsonKey()
  final String? changedBy;
  @override
  @JsonKey()
  final int? startOfContract;
  @override
  @JsonKey()
  final int? startOfCoverage;
  @override
  @JsonKey()
  final int? endOfContract;
  @override
  @JsonKey()
  final int? endOfCoverage;
  @override
  @JsonKey()
  final bool kine;
  @override
  @JsonKey()
  final bool gp;
  @override
  @JsonKey()
  final bool ptd;
  @override
  @JsonKey()
  final bool nurse;
  @override
  @JsonKey()
  final bool noKine;
  @override
  @JsonKey()
  final bool noGp;
  @override
  @JsonKey()
  final bool noNurse;
  @override
  @JsonKey()
  final int? unsubscriptionReasonId;
  @override
  @JsonKey()
  final int? ptdStart;
  @override
  @JsonKey()
  final int? ptdEnd;
  @override
  @JsonKey()
  final int? ptdLastInvoiced;
  @override
  @JsonKey()
  final int? startOfSuspension;
  @override
  @JsonKey()
  final int? endOfSuspension;
  @override
  @JsonKey()
  final SuspensionReason? suspensionReason;
  @override
  @JsonKey()
  final String? suspensionSource;
  @override
  @JsonKey()
  final bool forcedSuspension;
  @override
  @JsonKey()
  final MhcSignatureType? signatureType;
  @override
  @JsonKey()
  final int? status;
  final Map<String, String> _options;
  @override
  @JsonKey()
  Map<String, String> get options {
    if (_options is EqualUnmodifiableMapView) return _options;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_options);
  }

  final Map<String, String> _receipts;
  @override
  @JsonKey()
  Map<String, String> get receipts {
    if (_receipts is EqualUnmodifiableMapView) return _receipts;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_receipts);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedMedicalHouseContract
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedMedicalHouseContractCopyWith<_DecryptedMedicalHouseContract>
      get copyWith => __$DecryptedMedicalHouseContractCopyWithImpl<
          _DecryptedMedicalHouseContract>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedMedicalHouseContract &&
            (identical(other.contractId, contractId) ||
                other.contractId == contractId) &&
            (identical(other.validFrom, validFrom) ||
                other.validFrom == validFrom) &&
            (identical(other.validTo, validTo) || other.validTo == validTo) &&
            (identical(other.mmNihii, mmNihii) || other.mmNihii == mmNihii) &&
            (identical(other.hcpId, hcpId) || other.hcpId == hcpId) &&
            (identical(other.changeType, changeType) ||
                other.changeType == changeType) &&
            (identical(other.parentContractId, parentContractId) ||
                other.parentContractId == parentContractId) &&
            (identical(other.changedBy, changedBy) ||
                other.changedBy == changedBy) &&
            (identical(other.startOfContract, startOfContract) ||
                other.startOfContract == startOfContract) &&
            (identical(other.startOfCoverage, startOfCoverage) ||
                other.startOfCoverage == startOfCoverage) &&
            (identical(other.endOfContract, endOfContract) ||
                other.endOfContract == endOfContract) &&
            (identical(other.endOfCoverage, endOfCoverage) ||
                other.endOfCoverage == endOfCoverage) &&
            (identical(other.kine, kine) || other.kine == kine) &&
            (identical(other.gp, gp) || other.gp == gp) &&
            (identical(other.ptd, ptd) || other.ptd == ptd) &&
            (identical(other.nurse, nurse) || other.nurse == nurse) &&
            (identical(other.noKine, noKine) || other.noKine == noKine) &&
            (identical(other.noGp, noGp) || other.noGp == noGp) &&
            (identical(other.noNurse, noNurse) || other.noNurse == noNurse) &&
            (identical(other.unsubscriptionReasonId, unsubscriptionReasonId) ||
                other.unsubscriptionReasonId == unsubscriptionReasonId) &&
            (identical(other.ptdStart, ptdStart) ||
                other.ptdStart == ptdStart) &&
            (identical(other.ptdEnd, ptdEnd) || other.ptdEnd == ptdEnd) &&
            (identical(other.ptdLastInvoiced, ptdLastInvoiced) ||
                other.ptdLastInvoiced == ptdLastInvoiced) &&
            (identical(other.startOfSuspension, startOfSuspension) ||
                other.startOfSuspension == startOfSuspension) &&
            (identical(other.endOfSuspension, endOfSuspension) ||
                other.endOfSuspension == endOfSuspension) &&
            (identical(other.suspensionReason, suspensionReason) ||
                other.suspensionReason == suspensionReason) &&
            (identical(other.suspensionSource, suspensionSource) ||
                other.suspensionSource == suspensionSource) &&
            (identical(other.forcedSuspension, forcedSuspension) ||
                other.forcedSuspension == forcedSuspension) &&
            (identical(other.signatureType, signatureType) ||
                other.signatureType == signatureType) &&
            (identical(other.status, status) || other.status == status) &&
            const DeepCollectionEquality().equals(other._options, _options) &&
            const DeepCollectionEquality().equals(other._receipts, _receipts) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        contractId,
        validFrom,
        validTo,
        mmNihii,
        hcpId,
        changeType,
        parentContractId,
        changedBy,
        startOfContract,
        startOfCoverage,
        endOfContract,
        endOfCoverage,
        kine,
        gp,
        ptd,
        nurse,
        noKine,
        noGp,
        noNurse,
        unsubscriptionReasonId,
        ptdStart,
        ptdEnd,
        ptdLastInvoiced,
        startOfSuspension,
        endOfSuspension,
        suspensionReason,
        suspensionSource,
        forcedSuspension,
        signatureType,
        status,
        const DeepCollectionEquality().hash(_options),
        const DeepCollectionEquality().hash(_receipts),
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'DecryptedMedicalHouseContract(contractId: $contractId, validFrom: $validFrom, validTo: $validTo, mmNihii: $mmNihii, hcpId: $hcpId, changeType: $changeType, parentContractId: $parentContractId, changedBy: $changedBy, startOfContract: $startOfContract, startOfCoverage: $startOfCoverage, endOfContract: $endOfContract, endOfCoverage: $endOfCoverage, kine: $kine, gp: $gp, ptd: $ptd, nurse: $nurse, noKine: $noKine, noGp: $noGp, noNurse: $noNurse, unsubscriptionReasonId: $unsubscriptionReasonId, ptdStart: $ptdStart, ptdEnd: $ptdEnd, ptdLastInvoiced: $ptdLastInvoiced, startOfSuspension: $startOfSuspension, endOfSuspension: $endOfSuspension, suspensionReason: $suspensionReason, suspensionSource: $suspensionSource, forcedSuspension: $forcedSuspension, signatureType: $signatureType, status: $status, options: $options, receipts: $receipts, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedMedicalHouseContractCopyWith<$Res>
    implements $DecryptedMedicalHouseContractCopyWith<$Res> {
  factory _$DecryptedMedicalHouseContractCopyWith(
          _DecryptedMedicalHouseContract value,
          $Res Function(_DecryptedMedicalHouseContract) _then) =
      __$DecryptedMedicalHouseContractCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? contractId,
      int? validFrom,
      int? validTo,
      String? mmNihii,
      String? hcpId,
      ContractChangeType? changeType,
      String? parentContractId,
      String? changedBy,
      int? startOfContract,
      int? startOfCoverage,
      int? endOfContract,
      int? endOfCoverage,
      bool kine,
      bool gp,
      bool ptd,
      bool nurse,
      bool noKine,
      bool noGp,
      bool noNurse,
      int? unsubscriptionReasonId,
      int? ptdStart,
      int? ptdEnd,
      int? ptdLastInvoiced,
      int? startOfSuspension,
      int? endOfSuspension,
      SuspensionReason? suspensionReason,
      String? suspensionSource,
      bool forcedSuspension,
      MhcSignatureType? signatureType,
      int? status,
      Map<String, String> options,
      Map<String, String> receipts,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$DecryptedMedicalHouseContractCopyWithImpl<$Res>
    implements _$DecryptedMedicalHouseContractCopyWith<$Res> {
  __$DecryptedMedicalHouseContractCopyWithImpl(this._self, this._then);

  final _DecryptedMedicalHouseContract _self;
  final $Res Function(_DecryptedMedicalHouseContract) _then;

  /// Create a copy of DecryptedMedicalHouseContract
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? contractId = freezed,
    Object? validFrom = freezed,
    Object? validTo = freezed,
    Object? mmNihii = freezed,
    Object? hcpId = freezed,
    Object? changeType = freezed,
    Object? parentContractId = freezed,
    Object? changedBy = freezed,
    Object? startOfContract = freezed,
    Object? startOfCoverage = freezed,
    Object? endOfContract = freezed,
    Object? endOfCoverage = freezed,
    Object? kine = null,
    Object? gp = null,
    Object? ptd = null,
    Object? nurse = null,
    Object? noKine = null,
    Object? noGp = null,
    Object? noNurse = null,
    Object? unsubscriptionReasonId = freezed,
    Object? ptdStart = freezed,
    Object? ptdEnd = freezed,
    Object? ptdLastInvoiced = freezed,
    Object? startOfSuspension = freezed,
    Object? endOfSuspension = freezed,
    Object? suspensionReason = freezed,
    Object? suspensionSource = freezed,
    Object? forcedSuspension = null,
    Object? signatureType = freezed,
    Object? status = freezed,
    Object? options = null,
    Object? receipts = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedMedicalHouseContract(
      contractId: freezed == contractId
          ? _self.contractId
          : contractId // ignore: cast_nullable_to_non_nullable
              as String?,
      validFrom: freezed == validFrom
          ? _self.validFrom
          : validFrom // ignore: cast_nullable_to_non_nullable
              as int?,
      validTo: freezed == validTo
          ? _self.validTo
          : validTo // ignore: cast_nullable_to_non_nullable
              as int?,
      mmNihii: freezed == mmNihii
          ? _self.mmNihii
          : mmNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      hcpId: freezed == hcpId
          ? _self.hcpId
          : hcpId // ignore: cast_nullable_to_non_nullable
              as String?,
      changeType: freezed == changeType
          ? _self.changeType
          : changeType // ignore: cast_nullable_to_non_nullable
              as ContractChangeType?,
      parentContractId: freezed == parentContractId
          ? _self.parentContractId
          : parentContractId // ignore: cast_nullable_to_non_nullable
              as String?,
      changedBy: freezed == changedBy
          ? _self.changedBy
          : changedBy // ignore: cast_nullable_to_non_nullable
              as String?,
      startOfContract: freezed == startOfContract
          ? _self.startOfContract
          : startOfContract // ignore: cast_nullable_to_non_nullable
              as int?,
      startOfCoverage: freezed == startOfCoverage
          ? _self.startOfCoverage
          : startOfCoverage // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfContract: freezed == endOfContract
          ? _self.endOfContract
          : endOfContract // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfCoverage: freezed == endOfCoverage
          ? _self.endOfCoverage
          : endOfCoverage // ignore: cast_nullable_to_non_nullable
              as int?,
      kine: null == kine
          ? _self.kine
          : kine // ignore: cast_nullable_to_non_nullable
              as bool,
      gp: null == gp
          ? _self.gp
          : gp // ignore: cast_nullable_to_non_nullable
              as bool,
      ptd: null == ptd
          ? _self.ptd
          : ptd // ignore: cast_nullable_to_non_nullable
              as bool,
      nurse: null == nurse
          ? _self.nurse
          : nurse // ignore: cast_nullable_to_non_nullable
              as bool,
      noKine: null == noKine
          ? _self.noKine
          : noKine // ignore: cast_nullable_to_non_nullable
              as bool,
      noGp: null == noGp
          ? _self.noGp
          : noGp // ignore: cast_nullable_to_non_nullable
              as bool,
      noNurse: null == noNurse
          ? _self.noNurse
          : noNurse // ignore: cast_nullable_to_non_nullable
              as bool,
      unsubscriptionReasonId: freezed == unsubscriptionReasonId
          ? _self.unsubscriptionReasonId
          : unsubscriptionReasonId // ignore: cast_nullable_to_non_nullable
              as int?,
      ptdStart: freezed == ptdStart
          ? _self.ptdStart
          : ptdStart // ignore: cast_nullable_to_non_nullable
              as int?,
      ptdEnd: freezed == ptdEnd
          ? _self.ptdEnd
          : ptdEnd // ignore: cast_nullable_to_non_nullable
              as int?,
      ptdLastInvoiced: freezed == ptdLastInvoiced
          ? _self.ptdLastInvoiced
          : ptdLastInvoiced // ignore: cast_nullable_to_non_nullable
              as int?,
      startOfSuspension: freezed == startOfSuspension
          ? _self.startOfSuspension
          : startOfSuspension // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfSuspension: freezed == endOfSuspension
          ? _self.endOfSuspension
          : endOfSuspension // ignore: cast_nullable_to_non_nullable
              as int?,
      suspensionReason: freezed == suspensionReason
          ? _self.suspensionReason
          : suspensionReason // ignore: cast_nullable_to_non_nullable
              as SuspensionReason?,
      suspensionSource: freezed == suspensionSource
          ? _self.suspensionSource
          : suspensionSource // ignore: cast_nullable_to_non_nullable
              as String?,
      forcedSuspension: null == forcedSuspension
          ? _self.forcedSuspension
          : forcedSuspension // ignore: cast_nullable_to_non_nullable
              as bool,
      signatureType: freezed == signatureType
          ? _self.signatureType
          : signatureType // ignore: cast_nullable_to_non_nullable
              as MhcSignatureType?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      options: null == options
          ? _self._options
          : options // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      receipts: null == receipts
          ? _self._receipts
          : receipts // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc
mixin _$EncryptedMedicalHouseContract {
  String? get contractId;
  int? get validFrom;
  int? get validTo;
  String? get mmNihii;
  String? get hcpId;
  ContractChangeType? get changeType;
  String? get parentContractId;
  String? get changedBy;
  int? get startOfContract;
  int? get startOfCoverage;
  int? get endOfContract;
  int? get endOfCoverage;
  bool get kine;
  bool get gp;
  bool get ptd;
  bool get nurse;
  bool get noKine;
  bool get noGp;
  bool get noNurse;
  int? get unsubscriptionReasonId;
  int? get ptdStart;
  int? get ptdEnd;
  int? get ptdLastInvoiced;
  int? get startOfSuspension;
  int? get endOfSuspension;
  SuspensionReason? get suspensionReason;
  String? get suspensionSource;
  bool get forcedSuspension;
  MhcSignatureType? get signatureType;
  int? get status;
  Map<String, String> get options;
  Map<String, String> get receipts;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedMedicalHouseContract
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedMedicalHouseContractCopyWith<EncryptedMedicalHouseContract>
      get copyWith => _$EncryptedMedicalHouseContractCopyWithImpl<
              EncryptedMedicalHouseContract>(
          this as EncryptedMedicalHouseContract, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedMedicalHouseContract &&
            (identical(other.contractId, contractId) ||
                other.contractId == contractId) &&
            (identical(other.validFrom, validFrom) ||
                other.validFrom == validFrom) &&
            (identical(other.validTo, validTo) || other.validTo == validTo) &&
            (identical(other.mmNihii, mmNihii) || other.mmNihii == mmNihii) &&
            (identical(other.hcpId, hcpId) || other.hcpId == hcpId) &&
            (identical(other.changeType, changeType) ||
                other.changeType == changeType) &&
            (identical(other.parentContractId, parentContractId) ||
                other.parentContractId == parentContractId) &&
            (identical(other.changedBy, changedBy) ||
                other.changedBy == changedBy) &&
            (identical(other.startOfContract, startOfContract) ||
                other.startOfContract == startOfContract) &&
            (identical(other.startOfCoverage, startOfCoverage) ||
                other.startOfCoverage == startOfCoverage) &&
            (identical(other.endOfContract, endOfContract) ||
                other.endOfContract == endOfContract) &&
            (identical(other.endOfCoverage, endOfCoverage) ||
                other.endOfCoverage == endOfCoverage) &&
            (identical(other.kine, kine) || other.kine == kine) &&
            (identical(other.gp, gp) || other.gp == gp) &&
            (identical(other.ptd, ptd) || other.ptd == ptd) &&
            (identical(other.nurse, nurse) || other.nurse == nurse) &&
            (identical(other.noKine, noKine) || other.noKine == noKine) &&
            (identical(other.noGp, noGp) || other.noGp == noGp) &&
            (identical(other.noNurse, noNurse) || other.noNurse == noNurse) &&
            (identical(other.unsubscriptionReasonId, unsubscriptionReasonId) ||
                other.unsubscriptionReasonId == unsubscriptionReasonId) &&
            (identical(other.ptdStart, ptdStart) ||
                other.ptdStart == ptdStart) &&
            (identical(other.ptdEnd, ptdEnd) || other.ptdEnd == ptdEnd) &&
            (identical(other.ptdLastInvoiced, ptdLastInvoiced) ||
                other.ptdLastInvoiced == ptdLastInvoiced) &&
            (identical(other.startOfSuspension, startOfSuspension) ||
                other.startOfSuspension == startOfSuspension) &&
            (identical(other.endOfSuspension, endOfSuspension) ||
                other.endOfSuspension == endOfSuspension) &&
            (identical(other.suspensionReason, suspensionReason) ||
                other.suspensionReason == suspensionReason) &&
            (identical(other.suspensionSource, suspensionSource) ||
                other.suspensionSource == suspensionSource) &&
            (identical(other.forcedSuspension, forcedSuspension) ||
                other.forcedSuspension == forcedSuspension) &&
            (identical(other.signatureType, signatureType) ||
                other.signatureType == signatureType) &&
            (identical(other.status, status) || other.status == status) &&
            const DeepCollectionEquality().equals(other.options, options) &&
            const DeepCollectionEquality().equals(other.receipts, receipts) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        contractId,
        validFrom,
        validTo,
        mmNihii,
        hcpId,
        changeType,
        parentContractId,
        changedBy,
        startOfContract,
        startOfCoverage,
        endOfContract,
        endOfCoverage,
        kine,
        gp,
        ptd,
        nurse,
        noKine,
        noGp,
        noNurse,
        unsubscriptionReasonId,
        ptdStart,
        ptdEnd,
        ptdLastInvoiced,
        startOfSuspension,
        endOfSuspension,
        suspensionReason,
        suspensionSource,
        forcedSuspension,
        signatureType,
        status,
        const DeepCollectionEquality().hash(options),
        const DeepCollectionEquality().hash(receipts),
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'EncryptedMedicalHouseContract(contractId: $contractId, validFrom: $validFrom, validTo: $validTo, mmNihii: $mmNihii, hcpId: $hcpId, changeType: $changeType, parentContractId: $parentContractId, changedBy: $changedBy, startOfContract: $startOfContract, startOfCoverage: $startOfCoverage, endOfContract: $endOfContract, endOfCoverage: $endOfCoverage, kine: $kine, gp: $gp, ptd: $ptd, nurse: $nurse, noKine: $noKine, noGp: $noGp, noNurse: $noNurse, unsubscriptionReasonId: $unsubscriptionReasonId, ptdStart: $ptdStart, ptdEnd: $ptdEnd, ptdLastInvoiced: $ptdLastInvoiced, startOfSuspension: $startOfSuspension, endOfSuspension: $endOfSuspension, suspensionReason: $suspensionReason, suspensionSource: $suspensionSource, forcedSuspension: $forcedSuspension, signatureType: $signatureType, status: $status, options: $options, receipts: $receipts, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedMedicalHouseContractCopyWith<$Res> {
  factory $EncryptedMedicalHouseContractCopyWith(
          EncryptedMedicalHouseContract value,
          $Res Function(EncryptedMedicalHouseContract) _then) =
      _$EncryptedMedicalHouseContractCopyWithImpl;
  @useResult
  $Res call(
      {String? contractId,
      int? validFrom,
      int? validTo,
      String? mmNihii,
      String? hcpId,
      ContractChangeType? changeType,
      String? parentContractId,
      String? changedBy,
      int? startOfContract,
      int? startOfCoverage,
      int? endOfContract,
      int? endOfCoverage,
      bool kine,
      bool gp,
      bool ptd,
      bool nurse,
      bool noKine,
      bool noGp,
      bool noNurse,
      int? unsubscriptionReasonId,
      int? ptdStart,
      int? ptdEnd,
      int? ptdLastInvoiced,
      int? startOfSuspension,
      int? endOfSuspension,
      SuspensionReason? suspensionReason,
      String? suspensionSource,
      bool forcedSuspension,
      MhcSignatureType? signatureType,
      int? status,
      Map<String, String> options,
      Map<String, String> receipts,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$EncryptedMedicalHouseContractCopyWithImpl<$Res>
    implements $EncryptedMedicalHouseContractCopyWith<$Res> {
  _$EncryptedMedicalHouseContractCopyWithImpl(this._self, this._then);

  final EncryptedMedicalHouseContract _self;
  final $Res Function(EncryptedMedicalHouseContract) _then;

  /// Create a copy of EncryptedMedicalHouseContract
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? contractId = freezed,
    Object? validFrom = freezed,
    Object? validTo = freezed,
    Object? mmNihii = freezed,
    Object? hcpId = freezed,
    Object? changeType = freezed,
    Object? parentContractId = freezed,
    Object? changedBy = freezed,
    Object? startOfContract = freezed,
    Object? startOfCoverage = freezed,
    Object? endOfContract = freezed,
    Object? endOfCoverage = freezed,
    Object? kine = null,
    Object? gp = null,
    Object? ptd = null,
    Object? nurse = null,
    Object? noKine = null,
    Object? noGp = null,
    Object? noNurse = null,
    Object? unsubscriptionReasonId = freezed,
    Object? ptdStart = freezed,
    Object? ptdEnd = freezed,
    Object? ptdLastInvoiced = freezed,
    Object? startOfSuspension = freezed,
    Object? endOfSuspension = freezed,
    Object? suspensionReason = freezed,
    Object? suspensionSource = freezed,
    Object? forcedSuspension = null,
    Object? signatureType = freezed,
    Object? status = freezed,
    Object? options = null,
    Object? receipts = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      contractId: freezed == contractId
          ? _self.contractId
          : contractId // ignore: cast_nullable_to_non_nullable
              as String?,
      validFrom: freezed == validFrom
          ? _self.validFrom
          : validFrom // ignore: cast_nullable_to_non_nullable
              as int?,
      validTo: freezed == validTo
          ? _self.validTo
          : validTo // ignore: cast_nullable_to_non_nullable
              as int?,
      mmNihii: freezed == mmNihii
          ? _self.mmNihii
          : mmNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      hcpId: freezed == hcpId
          ? _self.hcpId
          : hcpId // ignore: cast_nullable_to_non_nullable
              as String?,
      changeType: freezed == changeType
          ? _self.changeType
          : changeType // ignore: cast_nullable_to_non_nullable
              as ContractChangeType?,
      parentContractId: freezed == parentContractId
          ? _self.parentContractId
          : parentContractId // ignore: cast_nullable_to_non_nullable
              as String?,
      changedBy: freezed == changedBy
          ? _self.changedBy
          : changedBy // ignore: cast_nullable_to_non_nullable
              as String?,
      startOfContract: freezed == startOfContract
          ? _self.startOfContract
          : startOfContract // ignore: cast_nullable_to_non_nullable
              as int?,
      startOfCoverage: freezed == startOfCoverage
          ? _self.startOfCoverage
          : startOfCoverage // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfContract: freezed == endOfContract
          ? _self.endOfContract
          : endOfContract // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfCoverage: freezed == endOfCoverage
          ? _self.endOfCoverage
          : endOfCoverage // ignore: cast_nullable_to_non_nullable
              as int?,
      kine: null == kine
          ? _self.kine
          : kine // ignore: cast_nullable_to_non_nullable
              as bool,
      gp: null == gp
          ? _self.gp
          : gp // ignore: cast_nullable_to_non_nullable
              as bool,
      ptd: null == ptd
          ? _self.ptd
          : ptd // ignore: cast_nullable_to_non_nullable
              as bool,
      nurse: null == nurse
          ? _self.nurse
          : nurse // ignore: cast_nullable_to_non_nullable
              as bool,
      noKine: null == noKine
          ? _self.noKine
          : noKine // ignore: cast_nullable_to_non_nullable
              as bool,
      noGp: null == noGp
          ? _self.noGp
          : noGp // ignore: cast_nullable_to_non_nullable
              as bool,
      noNurse: null == noNurse
          ? _self.noNurse
          : noNurse // ignore: cast_nullable_to_non_nullable
              as bool,
      unsubscriptionReasonId: freezed == unsubscriptionReasonId
          ? _self.unsubscriptionReasonId
          : unsubscriptionReasonId // ignore: cast_nullable_to_non_nullable
              as int?,
      ptdStart: freezed == ptdStart
          ? _self.ptdStart
          : ptdStart // ignore: cast_nullable_to_non_nullable
              as int?,
      ptdEnd: freezed == ptdEnd
          ? _self.ptdEnd
          : ptdEnd // ignore: cast_nullable_to_non_nullable
              as int?,
      ptdLastInvoiced: freezed == ptdLastInvoiced
          ? _self.ptdLastInvoiced
          : ptdLastInvoiced // ignore: cast_nullable_to_non_nullable
              as int?,
      startOfSuspension: freezed == startOfSuspension
          ? _self.startOfSuspension
          : startOfSuspension // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfSuspension: freezed == endOfSuspension
          ? _self.endOfSuspension
          : endOfSuspension // ignore: cast_nullable_to_non_nullable
              as int?,
      suspensionReason: freezed == suspensionReason
          ? _self.suspensionReason
          : suspensionReason // ignore: cast_nullable_to_non_nullable
              as SuspensionReason?,
      suspensionSource: freezed == suspensionSource
          ? _self.suspensionSource
          : suspensionSource // ignore: cast_nullable_to_non_nullable
              as String?,
      forcedSuspension: null == forcedSuspension
          ? _self.forcedSuspension
          : forcedSuspension // ignore: cast_nullable_to_non_nullable
              as bool,
      signatureType: freezed == signatureType
          ? _self.signatureType
          : signatureType // ignore: cast_nullable_to_non_nullable
              as MhcSignatureType?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      options: null == options
          ? _self.options
          : options // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      receipts: null == receipts
          ? _self.receipts
          : receipts // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _EncryptedMedicalHouseContract implements EncryptedMedicalHouseContract {
  const _EncryptedMedicalHouseContract(
      {this.contractId = null,
      this.validFrom = null,
      this.validTo = null,
      this.mmNihii = null,
      this.hcpId = null,
      this.changeType = null,
      this.parentContractId = null,
      this.changedBy = null,
      this.startOfContract = null,
      this.startOfCoverage = null,
      this.endOfContract = null,
      this.endOfCoverage = null,
      this.kine = false,
      this.gp = false,
      this.ptd = false,
      this.nurse = false,
      this.noKine = false,
      this.noGp = false,
      this.noNurse = false,
      this.unsubscriptionReasonId = null,
      this.ptdStart = null,
      this.ptdEnd = null,
      this.ptdLastInvoiced = null,
      this.startOfSuspension = null,
      this.endOfSuspension = null,
      this.suspensionReason = null,
      this.suspensionSource = null,
      this.forcedSuspension = false,
      this.signatureType = null,
      this.status = null,
      final Map<String, String> options = const {},
      final Map<String, String> receipts = const {},
      this.encryptedSelf = null})
      : _options = options,
        _receipts = receipts;

  @override
  @JsonKey()
  final String? contractId;
  @override
  @JsonKey()
  final int? validFrom;
  @override
  @JsonKey()
  final int? validTo;
  @override
  @JsonKey()
  final String? mmNihii;
  @override
  @JsonKey()
  final String? hcpId;
  @override
  @JsonKey()
  final ContractChangeType? changeType;
  @override
  @JsonKey()
  final String? parentContractId;
  @override
  @JsonKey()
  final String? changedBy;
  @override
  @JsonKey()
  final int? startOfContract;
  @override
  @JsonKey()
  final int? startOfCoverage;
  @override
  @JsonKey()
  final int? endOfContract;
  @override
  @JsonKey()
  final int? endOfCoverage;
  @override
  @JsonKey()
  final bool kine;
  @override
  @JsonKey()
  final bool gp;
  @override
  @JsonKey()
  final bool ptd;
  @override
  @JsonKey()
  final bool nurse;
  @override
  @JsonKey()
  final bool noKine;
  @override
  @JsonKey()
  final bool noGp;
  @override
  @JsonKey()
  final bool noNurse;
  @override
  @JsonKey()
  final int? unsubscriptionReasonId;
  @override
  @JsonKey()
  final int? ptdStart;
  @override
  @JsonKey()
  final int? ptdEnd;
  @override
  @JsonKey()
  final int? ptdLastInvoiced;
  @override
  @JsonKey()
  final int? startOfSuspension;
  @override
  @JsonKey()
  final int? endOfSuspension;
  @override
  @JsonKey()
  final SuspensionReason? suspensionReason;
  @override
  @JsonKey()
  final String? suspensionSource;
  @override
  @JsonKey()
  final bool forcedSuspension;
  @override
  @JsonKey()
  final MhcSignatureType? signatureType;
  @override
  @JsonKey()
  final int? status;
  final Map<String, String> _options;
  @override
  @JsonKey()
  Map<String, String> get options {
    if (_options is EqualUnmodifiableMapView) return _options;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_options);
  }

  final Map<String, String> _receipts;
  @override
  @JsonKey()
  Map<String, String> get receipts {
    if (_receipts is EqualUnmodifiableMapView) return _receipts;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_receipts);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedMedicalHouseContract
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedMedicalHouseContractCopyWith<_EncryptedMedicalHouseContract>
      get copyWith => __$EncryptedMedicalHouseContractCopyWithImpl<
          _EncryptedMedicalHouseContract>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedMedicalHouseContract &&
            (identical(other.contractId, contractId) ||
                other.contractId == contractId) &&
            (identical(other.validFrom, validFrom) ||
                other.validFrom == validFrom) &&
            (identical(other.validTo, validTo) || other.validTo == validTo) &&
            (identical(other.mmNihii, mmNihii) || other.mmNihii == mmNihii) &&
            (identical(other.hcpId, hcpId) || other.hcpId == hcpId) &&
            (identical(other.changeType, changeType) ||
                other.changeType == changeType) &&
            (identical(other.parentContractId, parentContractId) ||
                other.parentContractId == parentContractId) &&
            (identical(other.changedBy, changedBy) ||
                other.changedBy == changedBy) &&
            (identical(other.startOfContract, startOfContract) ||
                other.startOfContract == startOfContract) &&
            (identical(other.startOfCoverage, startOfCoverage) ||
                other.startOfCoverage == startOfCoverage) &&
            (identical(other.endOfContract, endOfContract) ||
                other.endOfContract == endOfContract) &&
            (identical(other.endOfCoverage, endOfCoverage) ||
                other.endOfCoverage == endOfCoverage) &&
            (identical(other.kine, kine) || other.kine == kine) &&
            (identical(other.gp, gp) || other.gp == gp) &&
            (identical(other.ptd, ptd) || other.ptd == ptd) &&
            (identical(other.nurse, nurse) || other.nurse == nurse) &&
            (identical(other.noKine, noKine) || other.noKine == noKine) &&
            (identical(other.noGp, noGp) || other.noGp == noGp) &&
            (identical(other.noNurse, noNurse) || other.noNurse == noNurse) &&
            (identical(other.unsubscriptionReasonId, unsubscriptionReasonId) ||
                other.unsubscriptionReasonId == unsubscriptionReasonId) &&
            (identical(other.ptdStart, ptdStart) ||
                other.ptdStart == ptdStart) &&
            (identical(other.ptdEnd, ptdEnd) || other.ptdEnd == ptdEnd) &&
            (identical(other.ptdLastInvoiced, ptdLastInvoiced) ||
                other.ptdLastInvoiced == ptdLastInvoiced) &&
            (identical(other.startOfSuspension, startOfSuspension) ||
                other.startOfSuspension == startOfSuspension) &&
            (identical(other.endOfSuspension, endOfSuspension) ||
                other.endOfSuspension == endOfSuspension) &&
            (identical(other.suspensionReason, suspensionReason) ||
                other.suspensionReason == suspensionReason) &&
            (identical(other.suspensionSource, suspensionSource) ||
                other.suspensionSource == suspensionSource) &&
            (identical(other.forcedSuspension, forcedSuspension) ||
                other.forcedSuspension == forcedSuspension) &&
            (identical(other.signatureType, signatureType) ||
                other.signatureType == signatureType) &&
            (identical(other.status, status) || other.status == status) &&
            const DeepCollectionEquality().equals(other._options, _options) &&
            const DeepCollectionEquality().equals(other._receipts, _receipts) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        contractId,
        validFrom,
        validTo,
        mmNihii,
        hcpId,
        changeType,
        parentContractId,
        changedBy,
        startOfContract,
        startOfCoverage,
        endOfContract,
        endOfCoverage,
        kine,
        gp,
        ptd,
        nurse,
        noKine,
        noGp,
        noNurse,
        unsubscriptionReasonId,
        ptdStart,
        ptdEnd,
        ptdLastInvoiced,
        startOfSuspension,
        endOfSuspension,
        suspensionReason,
        suspensionSource,
        forcedSuspension,
        signatureType,
        status,
        const DeepCollectionEquality().hash(_options),
        const DeepCollectionEquality().hash(_receipts),
        encryptedSelf
      ]);

  @override
  String toString() {
    return 'EncryptedMedicalHouseContract(contractId: $contractId, validFrom: $validFrom, validTo: $validTo, mmNihii: $mmNihii, hcpId: $hcpId, changeType: $changeType, parentContractId: $parentContractId, changedBy: $changedBy, startOfContract: $startOfContract, startOfCoverage: $startOfCoverage, endOfContract: $endOfContract, endOfCoverage: $endOfCoverage, kine: $kine, gp: $gp, ptd: $ptd, nurse: $nurse, noKine: $noKine, noGp: $noGp, noNurse: $noNurse, unsubscriptionReasonId: $unsubscriptionReasonId, ptdStart: $ptdStart, ptdEnd: $ptdEnd, ptdLastInvoiced: $ptdLastInvoiced, startOfSuspension: $startOfSuspension, endOfSuspension: $endOfSuspension, suspensionReason: $suspensionReason, suspensionSource: $suspensionSource, forcedSuspension: $forcedSuspension, signatureType: $signatureType, status: $status, options: $options, receipts: $receipts, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedMedicalHouseContractCopyWith<$Res>
    implements $EncryptedMedicalHouseContractCopyWith<$Res> {
  factory _$EncryptedMedicalHouseContractCopyWith(
          _EncryptedMedicalHouseContract value,
          $Res Function(_EncryptedMedicalHouseContract) _then) =
      __$EncryptedMedicalHouseContractCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? contractId,
      int? validFrom,
      int? validTo,
      String? mmNihii,
      String? hcpId,
      ContractChangeType? changeType,
      String? parentContractId,
      String? changedBy,
      int? startOfContract,
      int? startOfCoverage,
      int? endOfContract,
      int? endOfCoverage,
      bool kine,
      bool gp,
      bool ptd,
      bool nurse,
      bool noKine,
      bool noGp,
      bool noNurse,
      int? unsubscriptionReasonId,
      int? ptdStart,
      int? ptdEnd,
      int? ptdLastInvoiced,
      int? startOfSuspension,
      int? endOfSuspension,
      SuspensionReason? suspensionReason,
      String? suspensionSource,
      bool forcedSuspension,
      MhcSignatureType? signatureType,
      int? status,
      Map<String, String> options,
      Map<String, String> receipts,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$EncryptedMedicalHouseContractCopyWithImpl<$Res>
    implements _$EncryptedMedicalHouseContractCopyWith<$Res> {
  __$EncryptedMedicalHouseContractCopyWithImpl(this._self, this._then);

  final _EncryptedMedicalHouseContract _self;
  final $Res Function(_EncryptedMedicalHouseContract) _then;

  /// Create a copy of EncryptedMedicalHouseContract
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? contractId = freezed,
    Object? validFrom = freezed,
    Object? validTo = freezed,
    Object? mmNihii = freezed,
    Object? hcpId = freezed,
    Object? changeType = freezed,
    Object? parentContractId = freezed,
    Object? changedBy = freezed,
    Object? startOfContract = freezed,
    Object? startOfCoverage = freezed,
    Object? endOfContract = freezed,
    Object? endOfCoverage = freezed,
    Object? kine = null,
    Object? gp = null,
    Object? ptd = null,
    Object? nurse = null,
    Object? noKine = null,
    Object? noGp = null,
    Object? noNurse = null,
    Object? unsubscriptionReasonId = freezed,
    Object? ptdStart = freezed,
    Object? ptdEnd = freezed,
    Object? ptdLastInvoiced = freezed,
    Object? startOfSuspension = freezed,
    Object? endOfSuspension = freezed,
    Object? suspensionReason = freezed,
    Object? suspensionSource = freezed,
    Object? forcedSuspension = null,
    Object? signatureType = freezed,
    Object? status = freezed,
    Object? options = null,
    Object? receipts = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedMedicalHouseContract(
      contractId: freezed == contractId
          ? _self.contractId
          : contractId // ignore: cast_nullable_to_non_nullable
              as String?,
      validFrom: freezed == validFrom
          ? _self.validFrom
          : validFrom // ignore: cast_nullable_to_non_nullable
              as int?,
      validTo: freezed == validTo
          ? _self.validTo
          : validTo // ignore: cast_nullable_to_non_nullable
              as int?,
      mmNihii: freezed == mmNihii
          ? _self.mmNihii
          : mmNihii // ignore: cast_nullable_to_non_nullable
              as String?,
      hcpId: freezed == hcpId
          ? _self.hcpId
          : hcpId // ignore: cast_nullable_to_non_nullable
              as String?,
      changeType: freezed == changeType
          ? _self.changeType
          : changeType // ignore: cast_nullable_to_non_nullable
              as ContractChangeType?,
      parentContractId: freezed == parentContractId
          ? _self.parentContractId
          : parentContractId // ignore: cast_nullable_to_non_nullable
              as String?,
      changedBy: freezed == changedBy
          ? _self.changedBy
          : changedBy // ignore: cast_nullable_to_non_nullable
              as String?,
      startOfContract: freezed == startOfContract
          ? _self.startOfContract
          : startOfContract // ignore: cast_nullable_to_non_nullable
              as int?,
      startOfCoverage: freezed == startOfCoverage
          ? _self.startOfCoverage
          : startOfCoverage // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfContract: freezed == endOfContract
          ? _self.endOfContract
          : endOfContract // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfCoverage: freezed == endOfCoverage
          ? _self.endOfCoverage
          : endOfCoverage // ignore: cast_nullable_to_non_nullable
              as int?,
      kine: null == kine
          ? _self.kine
          : kine // ignore: cast_nullable_to_non_nullable
              as bool,
      gp: null == gp
          ? _self.gp
          : gp // ignore: cast_nullable_to_non_nullable
              as bool,
      ptd: null == ptd
          ? _self.ptd
          : ptd // ignore: cast_nullable_to_non_nullable
              as bool,
      nurse: null == nurse
          ? _self.nurse
          : nurse // ignore: cast_nullable_to_non_nullable
              as bool,
      noKine: null == noKine
          ? _self.noKine
          : noKine // ignore: cast_nullable_to_non_nullable
              as bool,
      noGp: null == noGp
          ? _self.noGp
          : noGp // ignore: cast_nullable_to_non_nullable
              as bool,
      noNurse: null == noNurse
          ? _self.noNurse
          : noNurse // ignore: cast_nullable_to_non_nullable
              as bool,
      unsubscriptionReasonId: freezed == unsubscriptionReasonId
          ? _self.unsubscriptionReasonId
          : unsubscriptionReasonId // ignore: cast_nullable_to_non_nullable
              as int?,
      ptdStart: freezed == ptdStart
          ? _self.ptdStart
          : ptdStart // ignore: cast_nullable_to_non_nullable
              as int?,
      ptdEnd: freezed == ptdEnd
          ? _self.ptdEnd
          : ptdEnd // ignore: cast_nullable_to_non_nullable
              as int?,
      ptdLastInvoiced: freezed == ptdLastInvoiced
          ? _self.ptdLastInvoiced
          : ptdLastInvoiced // ignore: cast_nullable_to_non_nullable
              as int?,
      startOfSuspension: freezed == startOfSuspension
          ? _self.startOfSuspension
          : startOfSuspension // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfSuspension: freezed == endOfSuspension
          ? _self.endOfSuspension
          : endOfSuspension // ignore: cast_nullable_to_non_nullable
              as int?,
      suspensionReason: freezed == suspensionReason
          ? _self.suspensionReason
          : suspensionReason // ignore: cast_nullable_to_non_nullable
              as SuspensionReason?,
      suspensionSource: freezed == suspensionSource
          ? _self.suspensionSource
          : suspensionSource // ignore: cast_nullable_to_non_nullable
              as String?,
      forcedSuspension: null == forcedSuspension
          ? _self.forcedSuspension
          : forcedSuspension // ignore: cast_nullable_to_non_nullable
              as bool,
      signatureType: freezed == signatureType
          ? _self.signatureType
          : signatureType // ignore: cast_nullable_to_non_nullable
              as MhcSignatureType?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      options: null == options
          ? _self._options
          : options // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      receipts: null == receipts
          ? _self._receipts
          : receipts // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

// dart format on
