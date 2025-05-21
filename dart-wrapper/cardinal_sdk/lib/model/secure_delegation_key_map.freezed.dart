// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'secure_delegation_key_map.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedSecureDelegationKeyMap {
  String get id;
  String? get rev;
  String get delegationKey;
  String? get delegator;
  String? get delegate;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;
  int? get deletionDate;

  /// Create a copy of EncryptedSecureDelegationKeyMap
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedSecureDelegationKeyMapCopyWith<EncryptedSecureDelegationKeyMap>
      get copyWith => _$EncryptedSecureDelegationKeyMapCopyWithImpl<
              EncryptedSecureDelegationKeyMap>(
          this as EncryptedSecureDelegationKeyMap, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedSecureDelegationKeyMap &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.delegationKey, delegationKey) ||
                other.delegationKey == delegationKey) &&
            (identical(other.delegator, delegator) ||
                other.delegator == delegator) &&
            (identical(other.delegate, delegate) ||
                other.delegate == delegate) &&
            const DeepCollectionEquality()
                .equals(other.secretForeignKeys, secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.cryptedForeignKeys, cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.delegations, delegations) &&
            const DeepCollectionEquality()
                .equals(other.encryptionKeys, encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      delegationKey,
      delegator,
      delegate,
      const DeepCollectionEquality().hash(secretForeignKeys),
      const DeepCollectionEquality().hash(cryptedForeignKeys),
      const DeepCollectionEquality().hash(delegations),
      const DeepCollectionEquality().hash(encryptionKeys),
      encryptedSelf,
      securityMetadata,
      deletionDate);

  @override
  String toString() {
    return 'EncryptedSecureDelegationKeyMap(id: $id, rev: $rev, delegationKey: $delegationKey, delegator: $delegator, delegate: $delegate, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata, deletionDate: $deletionDate)';
  }
}

/// @nodoc
abstract mixin class $EncryptedSecureDelegationKeyMapCopyWith<$Res> {
  factory $EncryptedSecureDelegationKeyMapCopyWith(
          EncryptedSecureDelegationKeyMap value,
          $Res Function(EncryptedSecureDelegationKeyMap) _then) =
      _$EncryptedSecureDelegationKeyMapCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      String delegationKey,
      String? delegator,
      String? delegate,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata,
      int? deletionDate});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$EncryptedSecureDelegationKeyMapCopyWithImpl<$Res>
    implements $EncryptedSecureDelegationKeyMapCopyWith<$Res> {
  _$EncryptedSecureDelegationKeyMapCopyWithImpl(this._self, this._then);

  final EncryptedSecureDelegationKeyMap _self;
  final $Res Function(EncryptedSecureDelegationKeyMap) _then;

  /// Create a copy of EncryptedSecureDelegationKeyMap
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? delegationKey = null,
    Object? delegator = freezed,
    Object? delegate = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
    Object? deletionDate = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      delegationKey: null == delegationKey
          ? _self.delegationKey
          : delegationKey // ignore: cast_nullable_to_non_nullable
              as String,
      delegator: freezed == delegator
          ? _self.delegator
          : delegator // ignore: cast_nullable_to_non_nullable
              as String?,
      delegate: freezed == delegate
          ? _self.delegate
          : delegate // ignore: cast_nullable_to_non_nullable
              as String?,
      secretForeignKeys: null == secretForeignKeys
          ? _self.secretForeignKeys
          : secretForeignKeys // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      cryptedForeignKeys: null == cryptedForeignKeys
          ? _self.cryptedForeignKeys
          : cryptedForeignKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      delegations: null == delegations
          ? _self.delegations
          : delegations // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptionKeys: null == encryptionKeys
          ? _self.encryptionKeys
          : encryptionKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }

  /// Create a copy of EncryptedSecureDelegationKeyMap
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $SecurityMetadataCopyWith<$Res>? get securityMetadata {
    if (_self.securityMetadata == null) {
      return null;
    }

    return $SecurityMetadataCopyWith<$Res>(_self.securityMetadata!, (value) {
      return _then(_self.copyWith(securityMetadata: value));
    });
  }
}

/// @nodoc

class _EncryptedSecureDelegationKeyMap
    implements EncryptedSecureDelegationKeyMap {
  const _EncryptedSecureDelegationKeyMap(
      {required this.id,
      this.rev = null,
      required this.delegationKey,
      this.delegator = null,
      this.delegate = null,
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null,
      this.deletionDate = null})
      : _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  final String delegationKey;
  @override
  @JsonKey()
  final String? delegator;
  @override
  @JsonKey()
  final String? delegate;
  final Set<String> _secretForeignKeys;
  @override
  @JsonKey()
  Set<String> get secretForeignKeys {
    if (_secretForeignKeys is EqualUnmodifiableSetView)
      return _secretForeignKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_secretForeignKeys);
  }

  final Map<String, Set<Delegation>> _cryptedForeignKeys;
  @override
  @JsonKey()
  Map<String, Set<Delegation>> get cryptedForeignKeys {
    if (_cryptedForeignKeys is EqualUnmodifiableMapView)
      return _cryptedForeignKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_cryptedForeignKeys);
  }

  final Map<String, Set<Delegation>> _delegations;
  @override
  @JsonKey()
  Map<String, Set<Delegation>> get delegations {
    if (_delegations is EqualUnmodifiableMapView) return _delegations;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_delegations);
  }

  final Map<String, Set<Delegation>> _encryptionKeys;
  @override
  @JsonKey()
  Map<String, Set<Delegation>> get encryptionKeys {
    if (_encryptionKeys is EqualUnmodifiableMapView) return _encryptionKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_encryptionKeys);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;
  @override
  @JsonKey()
  final SecurityMetadata? securityMetadata;
  @override
  @JsonKey()
  final int? deletionDate;

  /// Create a copy of EncryptedSecureDelegationKeyMap
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedSecureDelegationKeyMapCopyWith<_EncryptedSecureDelegationKeyMap>
      get copyWith => __$EncryptedSecureDelegationKeyMapCopyWithImpl<
          _EncryptedSecureDelegationKeyMap>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedSecureDelegationKeyMap &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.delegationKey, delegationKey) ||
                other.delegationKey == delegationKey) &&
            (identical(other.delegator, delegator) ||
                other.delegator == delegator) &&
            (identical(other.delegate, delegate) ||
                other.delegate == delegate) &&
            const DeepCollectionEquality()
                .equals(other._secretForeignKeys, _secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._cryptedForeignKeys, _cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._delegations, _delegations) &&
            const DeepCollectionEquality()
                .equals(other._encryptionKeys, _encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      delegationKey,
      delegator,
      delegate,
      const DeepCollectionEquality().hash(_secretForeignKeys),
      const DeepCollectionEquality().hash(_cryptedForeignKeys),
      const DeepCollectionEquality().hash(_delegations),
      const DeepCollectionEquality().hash(_encryptionKeys),
      encryptedSelf,
      securityMetadata,
      deletionDate);

  @override
  String toString() {
    return 'EncryptedSecureDelegationKeyMap(id: $id, rev: $rev, delegationKey: $delegationKey, delegator: $delegator, delegate: $delegate, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata, deletionDate: $deletionDate)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedSecureDelegationKeyMapCopyWith<$Res>
    implements $EncryptedSecureDelegationKeyMapCopyWith<$Res> {
  factory _$EncryptedSecureDelegationKeyMapCopyWith(
          _EncryptedSecureDelegationKeyMap value,
          $Res Function(_EncryptedSecureDelegationKeyMap) _then) =
      __$EncryptedSecureDelegationKeyMapCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      String delegationKey,
      String? delegator,
      String? delegate,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata,
      int? deletionDate});

  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$EncryptedSecureDelegationKeyMapCopyWithImpl<$Res>
    implements _$EncryptedSecureDelegationKeyMapCopyWith<$Res> {
  __$EncryptedSecureDelegationKeyMapCopyWithImpl(this._self, this._then);

  final _EncryptedSecureDelegationKeyMap _self;
  final $Res Function(_EncryptedSecureDelegationKeyMap) _then;

  /// Create a copy of EncryptedSecureDelegationKeyMap
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? delegationKey = null,
    Object? delegator = freezed,
    Object? delegate = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
    Object? deletionDate = freezed,
  }) {
    return _then(_EncryptedSecureDelegationKeyMap(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      delegationKey: null == delegationKey
          ? _self.delegationKey
          : delegationKey // ignore: cast_nullable_to_non_nullable
              as String,
      delegator: freezed == delegator
          ? _self.delegator
          : delegator // ignore: cast_nullable_to_non_nullable
              as String?,
      delegate: freezed == delegate
          ? _self.delegate
          : delegate // ignore: cast_nullable_to_non_nullable
              as String?,
      secretForeignKeys: null == secretForeignKeys
          ? _self._secretForeignKeys
          : secretForeignKeys // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      cryptedForeignKeys: null == cryptedForeignKeys
          ? _self._cryptedForeignKeys
          : cryptedForeignKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      delegations: null == delegations
          ? _self._delegations
          : delegations // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptionKeys: null == encryptionKeys
          ? _self._encryptionKeys
          : encryptionKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }

  /// Create a copy of EncryptedSecureDelegationKeyMap
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $SecurityMetadataCopyWith<$Res>? get securityMetadata {
    if (_self.securityMetadata == null) {
      return null;
    }

    return $SecurityMetadataCopyWith<$Res>(_self.securityMetadata!, (value) {
      return _then(_self.copyWith(securityMetadata: value));
    });
  }
}

/// @nodoc
mixin _$DecryptedSecureDelegationKeyMap {
  String get id;
  String? get rev;
  String get delegationKey;
  String? get delegator;
  String? get delegate;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;
  int? get deletionDate;

  /// Create a copy of DecryptedSecureDelegationKeyMap
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedSecureDelegationKeyMapCopyWith<DecryptedSecureDelegationKeyMap>
      get copyWith => _$DecryptedSecureDelegationKeyMapCopyWithImpl<
              DecryptedSecureDelegationKeyMap>(
          this as DecryptedSecureDelegationKeyMap, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedSecureDelegationKeyMap &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.delegationKey, delegationKey) ||
                other.delegationKey == delegationKey) &&
            (identical(other.delegator, delegator) ||
                other.delegator == delegator) &&
            (identical(other.delegate, delegate) ||
                other.delegate == delegate) &&
            const DeepCollectionEquality()
                .equals(other.secretForeignKeys, secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.cryptedForeignKeys, cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.delegations, delegations) &&
            const DeepCollectionEquality()
                .equals(other.encryptionKeys, encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      delegationKey,
      delegator,
      delegate,
      const DeepCollectionEquality().hash(secretForeignKeys),
      const DeepCollectionEquality().hash(cryptedForeignKeys),
      const DeepCollectionEquality().hash(delegations),
      const DeepCollectionEquality().hash(encryptionKeys),
      encryptedSelf,
      securityMetadata,
      deletionDate);

  @override
  String toString() {
    return 'DecryptedSecureDelegationKeyMap(id: $id, rev: $rev, delegationKey: $delegationKey, delegator: $delegator, delegate: $delegate, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata, deletionDate: $deletionDate)';
  }
}

/// @nodoc
abstract mixin class $DecryptedSecureDelegationKeyMapCopyWith<$Res> {
  factory $DecryptedSecureDelegationKeyMapCopyWith(
          DecryptedSecureDelegationKeyMap value,
          $Res Function(DecryptedSecureDelegationKeyMap) _then) =
      _$DecryptedSecureDelegationKeyMapCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      String delegationKey,
      String? delegator,
      String? delegate,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata,
      int? deletionDate});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$DecryptedSecureDelegationKeyMapCopyWithImpl<$Res>
    implements $DecryptedSecureDelegationKeyMapCopyWith<$Res> {
  _$DecryptedSecureDelegationKeyMapCopyWithImpl(this._self, this._then);

  final DecryptedSecureDelegationKeyMap _self;
  final $Res Function(DecryptedSecureDelegationKeyMap) _then;

  /// Create a copy of DecryptedSecureDelegationKeyMap
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? delegationKey = null,
    Object? delegator = freezed,
    Object? delegate = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
    Object? deletionDate = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      delegationKey: null == delegationKey
          ? _self.delegationKey
          : delegationKey // ignore: cast_nullable_to_non_nullable
              as String,
      delegator: freezed == delegator
          ? _self.delegator
          : delegator // ignore: cast_nullable_to_non_nullable
              as String?,
      delegate: freezed == delegate
          ? _self.delegate
          : delegate // ignore: cast_nullable_to_non_nullable
              as String?,
      secretForeignKeys: null == secretForeignKeys
          ? _self.secretForeignKeys
          : secretForeignKeys // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      cryptedForeignKeys: null == cryptedForeignKeys
          ? _self.cryptedForeignKeys
          : cryptedForeignKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      delegations: null == delegations
          ? _self.delegations
          : delegations // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptionKeys: null == encryptionKeys
          ? _self.encryptionKeys
          : encryptionKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }

  /// Create a copy of DecryptedSecureDelegationKeyMap
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $SecurityMetadataCopyWith<$Res>? get securityMetadata {
    if (_self.securityMetadata == null) {
      return null;
    }

    return $SecurityMetadataCopyWith<$Res>(_self.securityMetadata!, (value) {
      return _then(_self.copyWith(securityMetadata: value));
    });
  }
}

/// @nodoc

class _DecryptedSecureDelegationKeyMap
    implements DecryptedSecureDelegationKeyMap {
  const _DecryptedSecureDelegationKeyMap(
      {required this.id,
      this.rev = null,
      required this.delegationKey,
      this.delegator = null,
      this.delegate = null,
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null,
      this.deletionDate = null})
      : _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  final String delegationKey;
  @override
  @JsonKey()
  final String? delegator;
  @override
  @JsonKey()
  final String? delegate;
  final Set<String> _secretForeignKeys;
  @override
  @JsonKey()
  Set<String> get secretForeignKeys {
    if (_secretForeignKeys is EqualUnmodifiableSetView)
      return _secretForeignKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_secretForeignKeys);
  }

  final Map<String, Set<Delegation>> _cryptedForeignKeys;
  @override
  @JsonKey()
  Map<String, Set<Delegation>> get cryptedForeignKeys {
    if (_cryptedForeignKeys is EqualUnmodifiableMapView)
      return _cryptedForeignKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_cryptedForeignKeys);
  }

  final Map<String, Set<Delegation>> _delegations;
  @override
  @JsonKey()
  Map<String, Set<Delegation>> get delegations {
    if (_delegations is EqualUnmodifiableMapView) return _delegations;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_delegations);
  }

  final Map<String, Set<Delegation>> _encryptionKeys;
  @override
  @JsonKey()
  Map<String, Set<Delegation>> get encryptionKeys {
    if (_encryptionKeys is EqualUnmodifiableMapView) return _encryptionKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_encryptionKeys);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;
  @override
  @JsonKey()
  final SecurityMetadata? securityMetadata;
  @override
  @JsonKey()
  final int? deletionDate;

  /// Create a copy of DecryptedSecureDelegationKeyMap
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedSecureDelegationKeyMapCopyWith<_DecryptedSecureDelegationKeyMap>
      get copyWith => __$DecryptedSecureDelegationKeyMapCopyWithImpl<
          _DecryptedSecureDelegationKeyMap>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedSecureDelegationKeyMap &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.delegationKey, delegationKey) ||
                other.delegationKey == delegationKey) &&
            (identical(other.delegator, delegator) ||
                other.delegator == delegator) &&
            (identical(other.delegate, delegate) ||
                other.delegate == delegate) &&
            const DeepCollectionEquality()
                .equals(other._secretForeignKeys, _secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._cryptedForeignKeys, _cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._delegations, _delegations) &&
            const DeepCollectionEquality()
                .equals(other._encryptionKeys, _encryptionKeys) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      delegationKey,
      delegator,
      delegate,
      const DeepCollectionEquality().hash(_secretForeignKeys),
      const DeepCollectionEquality().hash(_cryptedForeignKeys),
      const DeepCollectionEquality().hash(_delegations),
      const DeepCollectionEquality().hash(_encryptionKeys),
      encryptedSelf,
      securityMetadata,
      deletionDate);

  @override
  String toString() {
    return 'DecryptedSecureDelegationKeyMap(id: $id, rev: $rev, delegationKey: $delegationKey, delegator: $delegator, delegate: $delegate, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata, deletionDate: $deletionDate)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedSecureDelegationKeyMapCopyWith<$Res>
    implements $DecryptedSecureDelegationKeyMapCopyWith<$Res> {
  factory _$DecryptedSecureDelegationKeyMapCopyWith(
          _DecryptedSecureDelegationKeyMap value,
          $Res Function(_DecryptedSecureDelegationKeyMap) _then) =
      __$DecryptedSecureDelegationKeyMapCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      String delegationKey,
      String? delegator,
      String? delegate,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata,
      int? deletionDate});

  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$DecryptedSecureDelegationKeyMapCopyWithImpl<$Res>
    implements _$DecryptedSecureDelegationKeyMapCopyWith<$Res> {
  __$DecryptedSecureDelegationKeyMapCopyWithImpl(this._self, this._then);

  final _DecryptedSecureDelegationKeyMap _self;
  final $Res Function(_DecryptedSecureDelegationKeyMap) _then;

  /// Create a copy of DecryptedSecureDelegationKeyMap
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? delegationKey = null,
    Object? delegator = freezed,
    Object? delegate = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
    Object? deletionDate = freezed,
  }) {
    return _then(_DecryptedSecureDelegationKeyMap(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      delegationKey: null == delegationKey
          ? _self.delegationKey
          : delegationKey // ignore: cast_nullable_to_non_nullable
              as String,
      delegator: freezed == delegator
          ? _self.delegator
          : delegator // ignore: cast_nullable_to_non_nullable
              as String?,
      delegate: freezed == delegate
          ? _self.delegate
          : delegate // ignore: cast_nullable_to_non_nullable
              as String?,
      secretForeignKeys: null == secretForeignKeys
          ? _self._secretForeignKeys
          : secretForeignKeys // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      cryptedForeignKeys: null == cryptedForeignKeys
          ? _self._cryptedForeignKeys
          : cryptedForeignKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      delegations: null == delegations
          ? _self._delegations
          : delegations // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptionKeys: null == encryptionKeys
          ? _self._encryptionKeys
          : encryptionKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<Delegation>>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }

  /// Create a copy of DecryptedSecureDelegationKeyMap
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $SecurityMetadataCopyWith<$Res>? get securityMetadata {
    if (_self.securityMetadata == null) {
      return null;
    }

    return $SecurityMetadataCopyWith<$Res>(_self.securityMetadata!, (value) {
      return _then(_self.copyWith(securityMetadata: value));
    });
  }
}

// dart format on
