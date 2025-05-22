// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'financial_institution_information.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedFinancialInstitutionInformation {
  String? get name;
  String? get key;
  String? get bankAccount;
  String? get bic;
  String? get proxyBankAccount;
  String? get proxyBic;
  Set<String> get preferredFiiForPartners;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedFinancialInstitutionInformation
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedFinancialInstitutionInformationCopyWith<
          EncryptedFinancialInstitutionInformation>
      get copyWith => _$EncryptedFinancialInstitutionInformationCopyWithImpl<
              EncryptedFinancialInstitutionInformation>(
          this as EncryptedFinancialInstitutionInformation, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedFinancialInstitutionInformation &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.key, key) || other.key == key) &&
            (identical(other.bankAccount, bankAccount) ||
                other.bankAccount == bankAccount) &&
            (identical(other.bic, bic) || other.bic == bic) &&
            (identical(other.proxyBankAccount, proxyBankAccount) ||
                other.proxyBankAccount == proxyBankAccount) &&
            (identical(other.proxyBic, proxyBic) ||
                other.proxyBic == proxyBic) &&
            const DeepCollectionEquality().equals(
                other.preferredFiiForPartners, preferredFiiForPartners) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      name,
      key,
      bankAccount,
      bic,
      proxyBankAccount,
      proxyBic,
      const DeepCollectionEquality().hash(preferredFiiForPartners),
      encryptedSelf);

  @override
  String toString() {
    return 'EncryptedFinancialInstitutionInformation(name: $name, key: $key, bankAccount: $bankAccount, bic: $bic, proxyBankAccount: $proxyBankAccount, proxyBic: $proxyBic, preferredFiiForPartners: $preferredFiiForPartners, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedFinancialInstitutionInformationCopyWith<$Res> {
  factory $EncryptedFinancialInstitutionInformationCopyWith(
          EncryptedFinancialInstitutionInformation value,
          $Res Function(EncryptedFinancialInstitutionInformation) _then) =
      _$EncryptedFinancialInstitutionInformationCopyWithImpl;
  @useResult
  $Res call(
      {String? name,
      String? key,
      String? bankAccount,
      String? bic,
      String? proxyBankAccount,
      String? proxyBic,
      Set<String> preferredFiiForPartners,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$EncryptedFinancialInstitutionInformationCopyWithImpl<$Res>
    implements $EncryptedFinancialInstitutionInformationCopyWith<$Res> {
  _$EncryptedFinancialInstitutionInformationCopyWithImpl(
      this._self, this._then);

  final EncryptedFinancialInstitutionInformation _self;
  final $Res Function(EncryptedFinancialInstitutionInformation) _then;

  /// Create a copy of EncryptedFinancialInstitutionInformation
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? name = freezed,
    Object? key = freezed,
    Object? bankAccount = freezed,
    Object? bic = freezed,
    Object? proxyBankAccount = freezed,
    Object? proxyBic = freezed,
    Object? preferredFiiForPartners = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      key: freezed == key
          ? _self.key
          : key // ignore: cast_nullable_to_non_nullable
              as String?,
      bankAccount: freezed == bankAccount
          ? _self.bankAccount
          : bankAccount // ignore: cast_nullable_to_non_nullable
              as String?,
      bic: freezed == bic
          ? _self.bic
          : bic // ignore: cast_nullable_to_non_nullable
              as String?,
      proxyBankAccount: freezed == proxyBankAccount
          ? _self.proxyBankAccount
          : proxyBankAccount // ignore: cast_nullable_to_non_nullable
              as String?,
      proxyBic: freezed == proxyBic
          ? _self.proxyBic
          : proxyBic // ignore: cast_nullable_to_non_nullable
              as String?,
      preferredFiiForPartners: null == preferredFiiForPartners
          ? _self.preferredFiiForPartners
          : preferredFiiForPartners // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _EncryptedFinancialInstitutionInformation
    implements EncryptedFinancialInstitutionInformation {
  const _EncryptedFinancialInstitutionInformation(
      {this.name = null,
      this.key = null,
      this.bankAccount = null,
      this.bic = null,
      this.proxyBankAccount = null,
      this.proxyBic = null,
      final Set<String> preferredFiiForPartners = const {},
      this.encryptedSelf = null})
      : _preferredFiiForPartners = preferredFiiForPartners;

  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? key;
  @override
  @JsonKey()
  final String? bankAccount;
  @override
  @JsonKey()
  final String? bic;
  @override
  @JsonKey()
  final String? proxyBankAccount;
  @override
  @JsonKey()
  final String? proxyBic;
  final Set<String> _preferredFiiForPartners;
  @override
  @JsonKey()
  Set<String> get preferredFiiForPartners {
    if (_preferredFiiForPartners is EqualUnmodifiableSetView)
      return _preferredFiiForPartners;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_preferredFiiForPartners);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedFinancialInstitutionInformation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedFinancialInstitutionInformationCopyWith<
          _EncryptedFinancialInstitutionInformation>
      get copyWith => __$EncryptedFinancialInstitutionInformationCopyWithImpl<
          _EncryptedFinancialInstitutionInformation>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedFinancialInstitutionInformation &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.key, key) || other.key == key) &&
            (identical(other.bankAccount, bankAccount) ||
                other.bankAccount == bankAccount) &&
            (identical(other.bic, bic) || other.bic == bic) &&
            (identical(other.proxyBankAccount, proxyBankAccount) ||
                other.proxyBankAccount == proxyBankAccount) &&
            (identical(other.proxyBic, proxyBic) ||
                other.proxyBic == proxyBic) &&
            const DeepCollectionEquality().equals(
                other._preferredFiiForPartners, _preferredFiiForPartners) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      name,
      key,
      bankAccount,
      bic,
      proxyBankAccount,
      proxyBic,
      const DeepCollectionEquality().hash(_preferredFiiForPartners),
      encryptedSelf);

  @override
  String toString() {
    return 'EncryptedFinancialInstitutionInformation(name: $name, key: $key, bankAccount: $bankAccount, bic: $bic, proxyBankAccount: $proxyBankAccount, proxyBic: $proxyBic, preferredFiiForPartners: $preferredFiiForPartners, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedFinancialInstitutionInformationCopyWith<$Res>
    implements $EncryptedFinancialInstitutionInformationCopyWith<$Res> {
  factory _$EncryptedFinancialInstitutionInformationCopyWith(
          _EncryptedFinancialInstitutionInformation value,
          $Res Function(_EncryptedFinancialInstitutionInformation) _then) =
      __$EncryptedFinancialInstitutionInformationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? name,
      String? key,
      String? bankAccount,
      String? bic,
      String? proxyBankAccount,
      String? proxyBic,
      Set<String> preferredFiiForPartners,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$EncryptedFinancialInstitutionInformationCopyWithImpl<$Res>
    implements _$EncryptedFinancialInstitutionInformationCopyWith<$Res> {
  __$EncryptedFinancialInstitutionInformationCopyWithImpl(
      this._self, this._then);

  final _EncryptedFinancialInstitutionInformation _self;
  final $Res Function(_EncryptedFinancialInstitutionInformation) _then;

  /// Create a copy of EncryptedFinancialInstitutionInformation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? name = freezed,
    Object? key = freezed,
    Object? bankAccount = freezed,
    Object? bic = freezed,
    Object? proxyBankAccount = freezed,
    Object? proxyBic = freezed,
    Object? preferredFiiForPartners = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedFinancialInstitutionInformation(
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      key: freezed == key
          ? _self.key
          : key // ignore: cast_nullable_to_non_nullable
              as String?,
      bankAccount: freezed == bankAccount
          ? _self.bankAccount
          : bankAccount // ignore: cast_nullable_to_non_nullable
              as String?,
      bic: freezed == bic
          ? _self.bic
          : bic // ignore: cast_nullable_to_non_nullable
              as String?,
      proxyBankAccount: freezed == proxyBankAccount
          ? _self.proxyBankAccount
          : proxyBankAccount // ignore: cast_nullable_to_non_nullable
              as String?,
      proxyBic: freezed == proxyBic
          ? _self.proxyBic
          : proxyBic // ignore: cast_nullable_to_non_nullable
              as String?,
      preferredFiiForPartners: null == preferredFiiForPartners
          ? _self._preferredFiiForPartners
          : preferredFiiForPartners // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc
mixin _$DecryptedFinancialInstitutionInformation {
  String? get name;
  String? get key;
  String? get bankAccount;
  String? get bic;
  String? get proxyBankAccount;
  String? get proxyBic;
  Set<String> get preferredFiiForPartners;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedFinancialInstitutionInformation
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedFinancialInstitutionInformationCopyWith<
          DecryptedFinancialInstitutionInformation>
      get copyWith => _$DecryptedFinancialInstitutionInformationCopyWithImpl<
              DecryptedFinancialInstitutionInformation>(
          this as DecryptedFinancialInstitutionInformation, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedFinancialInstitutionInformation &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.key, key) || other.key == key) &&
            (identical(other.bankAccount, bankAccount) ||
                other.bankAccount == bankAccount) &&
            (identical(other.bic, bic) || other.bic == bic) &&
            (identical(other.proxyBankAccount, proxyBankAccount) ||
                other.proxyBankAccount == proxyBankAccount) &&
            (identical(other.proxyBic, proxyBic) ||
                other.proxyBic == proxyBic) &&
            const DeepCollectionEquality().equals(
                other.preferredFiiForPartners, preferredFiiForPartners) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      name,
      key,
      bankAccount,
      bic,
      proxyBankAccount,
      proxyBic,
      const DeepCollectionEquality().hash(preferredFiiForPartners),
      encryptedSelf);

  @override
  String toString() {
    return 'DecryptedFinancialInstitutionInformation(name: $name, key: $key, bankAccount: $bankAccount, bic: $bic, proxyBankAccount: $proxyBankAccount, proxyBic: $proxyBic, preferredFiiForPartners: $preferredFiiForPartners, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedFinancialInstitutionInformationCopyWith<$Res> {
  factory $DecryptedFinancialInstitutionInformationCopyWith(
          DecryptedFinancialInstitutionInformation value,
          $Res Function(DecryptedFinancialInstitutionInformation) _then) =
      _$DecryptedFinancialInstitutionInformationCopyWithImpl;
  @useResult
  $Res call(
      {String? name,
      String? key,
      String? bankAccount,
      String? bic,
      String? proxyBankAccount,
      String? proxyBic,
      Set<String> preferredFiiForPartners,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$DecryptedFinancialInstitutionInformationCopyWithImpl<$Res>
    implements $DecryptedFinancialInstitutionInformationCopyWith<$Res> {
  _$DecryptedFinancialInstitutionInformationCopyWithImpl(
      this._self, this._then);

  final DecryptedFinancialInstitutionInformation _self;
  final $Res Function(DecryptedFinancialInstitutionInformation) _then;

  /// Create a copy of DecryptedFinancialInstitutionInformation
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? name = freezed,
    Object? key = freezed,
    Object? bankAccount = freezed,
    Object? bic = freezed,
    Object? proxyBankAccount = freezed,
    Object? proxyBic = freezed,
    Object? preferredFiiForPartners = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      key: freezed == key
          ? _self.key
          : key // ignore: cast_nullable_to_non_nullable
              as String?,
      bankAccount: freezed == bankAccount
          ? _self.bankAccount
          : bankAccount // ignore: cast_nullable_to_non_nullable
              as String?,
      bic: freezed == bic
          ? _self.bic
          : bic // ignore: cast_nullable_to_non_nullable
              as String?,
      proxyBankAccount: freezed == proxyBankAccount
          ? _self.proxyBankAccount
          : proxyBankAccount // ignore: cast_nullable_to_non_nullable
              as String?,
      proxyBic: freezed == proxyBic
          ? _self.proxyBic
          : proxyBic // ignore: cast_nullable_to_non_nullable
              as String?,
      preferredFiiForPartners: null == preferredFiiForPartners
          ? _self.preferredFiiForPartners
          : preferredFiiForPartners // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _DecryptedFinancialInstitutionInformation
    implements DecryptedFinancialInstitutionInformation {
  const _DecryptedFinancialInstitutionInformation(
      {this.name = null,
      this.key = null,
      this.bankAccount = null,
      this.bic = null,
      this.proxyBankAccount = null,
      this.proxyBic = null,
      final Set<String> preferredFiiForPartners = const {},
      this.encryptedSelf = null})
      : _preferredFiiForPartners = preferredFiiForPartners;

  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? key;
  @override
  @JsonKey()
  final String? bankAccount;
  @override
  @JsonKey()
  final String? bic;
  @override
  @JsonKey()
  final String? proxyBankAccount;
  @override
  @JsonKey()
  final String? proxyBic;
  final Set<String> _preferredFiiForPartners;
  @override
  @JsonKey()
  Set<String> get preferredFiiForPartners {
    if (_preferredFiiForPartners is EqualUnmodifiableSetView)
      return _preferredFiiForPartners;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_preferredFiiForPartners);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedFinancialInstitutionInformation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedFinancialInstitutionInformationCopyWith<
          _DecryptedFinancialInstitutionInformation>
      get copyWith => __$DecryptedFinancialInstitutionInformationCopyWithImpl<
          _DecryptedFinancialInstitutionInformation>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedFinancialInstitutionInformation &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.key, key) || other.key == key) &&
            (identical(other.bankAccount, bankAccount) ||
                other.bankAccount == bankAccount) &&
            (identical(other.bic, bic) || other.bic == bic) &&
            (identical(other.proxyBankAccount, proxyBankAccount) ||
                other.proxyBankAccount == proxyBankAccount) &&
            (identical(other.proxyBic, proxyBic) ||
                other.proxyBic == proxyBic) &&
            const DeepCollectionEquality().equals(
                other._preferredFiiForPartners, _preferredFiiForPartners) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      name,
      key,
      bankAccount,
      bic,
      proxyBankAccount,
      proxyBic,
      const DeepCollectionEquality().hash(_preferredFiiForPartners),
      encryptedSelf);

  @override
  String toString() {
    return 'DecryptedFinancialInstitutionInformation(name: $name, key: $key, bankAccount: $bankAccount, bic: $bic, proxyBankAccount: $proxyBankAccount, proxyBic: $proxyBic, preferredFiiForPartners: $preferredFiiForPartners, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedFinancialInstitutionInformationCopyWith<$Res>
    implements $DecryptedFinancialInstitutionInformationCopyWith<$Res> {
  factory _$DecryptedFinancialInstitutionInformationCopyWith(
          _DecryptedFinancialInstitutionInformation value,
          $Res Function(_DecryptedFinancialInstitutionInformation) _then) =
      __$DecryptedFinancialInstitutionInformationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? name,
      String? key,
      String? bankAccount,
      String? bic,
      String? proxyBankAccount,
      String? proxyBic,
      Set<String> preferredFiiForPartners,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$DecryptedFinancialInstitutionInformationCopyWithImpl<$Res>
    implements _$DecryptedFinancialInstitutionInformationCopyWith<$Res> {
  __$DecryptedFinancialInstitutionInformationCopyWithImpl(
      this._self, this._then);

  final _DecryptedFinancialInstitutionInformation _self;
  final $Res Function(_DecryptedFinancialInstitutionInformation) _then;

  /// Create a copy of DecryptedFinancialInstitutionInformation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? name = freezed,
    Object? key = freezed,
    Object? bankAccount = freezed,
    Object? bic = freezed,
    Object? proxyBankAccount = freezed,
    Object? proxyBic = freezed,
    Object? preferredFiiForPartners = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedFinancialInstitutionInformation(
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      key: freezed == key
          ? _self.key
          : key // ignore: cast_nullable_to_non_nullable
              as String?,
      bankAccount: freezed == bankAccount
          ? _self.bankAccount
          : bankAccount // ignore: cast_nullable_to_non_nullable
              as String?,
      bic: freezed == bic
          ? _self.bic
          : bic // ignore: cast_nullable_to_non_nullable
              as String?,
      proxyBankAccount: freezed == proxyBankAccount
          ? _self.proxyBankAccount
          : proxyBankAccount // ignore: cast_nullable_to_non_nullable
              as String?,
      proxyBic: freezed == proxyBic
          ? _self.proxyBic
          : proxyBic // ignore: cast_nullable_to_non_nullable
              as String?,
      preferredFiiForPartners: null == preferredFiiForPartners
          ? _self._preferredFiiForPartners
          : preferredFiiForPartners // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

// dart format on
