// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'crypto_actor_stub.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$CryptoActorStub {
  String get id;
  String get rev;
  Map<String, List<HexString>> get hcPartyKeys;
  Map<
          AesExchangeKeyEntryKeyString,
          Map<String,
              Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>
      get aesExchangeKeys;
  Map<AesExchangeKeyEncryptionKeypairIdentifier,
          Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>
      get transferKeys;
  Map<String, HexString> get privateKeyShamirPartitions;
  CardinalRsaPublicKey? get publicKey;
  Set<CardinalRsaPublicKey> get publicKeysForOaepWithSha256;
  String? get parentId;
  Set<DecryptedPropertyStub>? get cryptoActorProperties;

  /// Create a copy of CryptoActorStub
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $CryptoActorStubCopyWith<CryptoActorStub> get copyWith =>
      _$CryptoActorStubCopyWithImpl<CryptoActorStub>(
          this as CryptoActorStub, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is CryptoActorStub &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            const DeepCollectionEquality()
                .equals(other.hcPartyKeys, hcPartyKeys) &&
            const DeepCollectionEquality()
                .equals(other.aesExchangeKeys, aesExchangeKeys) &&
            const DeepCollectionEquality()
                .equals(other.transferKeys, transferKeys) &&
            const DeepCollectionEquality().equals(
                other.privateKeyShamirPartitions, privateKeyShamirPartitions) &&
            (identical(other.publicKey, publicKey) ||
                other.publicKey == publicKey) &&
            const DeepCollectionEquality().equals(
                other.publicKeysForOaepWithSha256,
                publicKeysForOaepWithSha256) &&
            (identical(other.parentId, parentId) ||
                other.parentId == parentId) &&
            const DeepCollectionEquality()
                .equals(other.cryptoActorProperties, cryptoActorProperties));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      const DeepCollectionEquality().hash(hcPartyKeys),
      const DeepCollectionEquality().hash(aesExchangeKeys),
      const DeepCollectionEquality().hash(transferKeys),
      const DeepCollectionEquality().hash(privateKeyShamirPartitions),
      publicKey,
      const DeepCollectionEquality().hash(publicKeysForOaepWithSha256),
      parentId,
      const DeepCollectionEquality().hash(cryptoActorProperties));

  @override
  String toString() {
    return 'CryptoActorStub(id: $id, rev: $rev, hcPartyKeys: $hcPartyKeys, aesExchangeKeys: $aesExchangeKeys, transferKeys: $transferKeys, privateKeyShamirPartitions: $privateKeyShamirPartitions, publicKey: $publicKey, publicKeysForOaepWithSha256: $publicKeysForOaepWithSha256, parentId: $parentId, cryptoActorProperties: $cryptoActorProperties)';
  }
}

/// @nodoc
abstract mixin class $CryptoActorStubCopyWith<$Res> {
  factory $CryptoActorStubCopyWith(
          CryptoActorStub value, $Res Function(CryptoActorStub) _then) =
      _$CryptoActorStubCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String rev,
      Map<String, List<HexString>> hcPartyKeys,
      Map<
              AesExchangeKeyEntryKeyString,
              Map<String,
                  Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>
          aesExchangeKeys,
      Map<AesExchangeKeyEncryptionKeypairIdentifier,
              Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>
          transferKeys,
      Map<String, HexString> privateKeyShamirPartitions,
      CardinalRsaPublicKey? publicKey,
      Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256,
      String? parentId,
      Set<DecryptedPropertyStub>? cryptoActorProperties});
}

/// @nodoc
class _$CryptoActorStubCopyWithImpl<$Res>
    implements $CryptoActorStubCopyWith<$Res> {
  _$CryptoActorStubCopyWithImpl(this._self, this._then);

  final CryptoActorStub _self;
  final $Res Function(CryptoActorStub) _then;

  /// Create a copy of CryptoActorStub
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = null,
    Object? hcPartyKeys = null,
    Object? aesExchangeKeys = null,
    Object? transferKeys = null,
    Object? privateKeyShamirPartitions = null,
    Object? publicKey = freezed,
    Object? publicKeysForOaepWithSha256 = null,
    Object? parentId = freezed,
    Object? cryptoActorProperties = freezed,
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
      hcPartyKeys: null == hcPartyKeys
          ? _self.hcPartyKeys
          : hcPartyKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, List<HexString>>,
      aesExchangeKeys: null == aesExchangeKeys
          ? _self.aesExchangeKeys
          : aesExchangeKeys // ignore: cast_nullable_to_non_nullable
              as Map<
                  AesExchangeKeyEntryKeyString,
                  Map<
                      String,
                      Map<AesExchangeKeyEncryptionKeypairIdentifier,
                          HexString>>>,
      transferKeys: null == transferKeys
          ? _self.transferKeys
          : transferKeys // ignore: cast_nullable_to_non_nullable
              as Map<AesExchangeKeyEncryptionKeypairIdentifier,
                  Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>,
      privateKeyShamirPartitions: null == privateKeyShamirPartitions
          ? _self.privateKeyShamirPartitions
          : privateKeyShamirPartitions // ignore: cast_nullable_to_non_nullable
              as Map<String, HexString>,
      publicKey: freezed == publicKey
          ? _self.publicKey
          : publicKey // ignore: cast_nullable_to_non_nullable
              as CardinalRsaPublicKey?,
      publicKeysForOaepWithSha256: null == publicKeysForOaepWithSha256
          ? _self.publicKeysForOaepWithSha256
          : publicKeysForOaepWithSha256 // ignore: cast_nullable_to_non_nullable
              as Set<CardinalRsaPublicKey>,
      parentId: freezed == parentId
          ? _self.parentId
          : parentId // ignore: cast_nullable_to_non_nullable
              as String?,
      cryptoActorProperties: freezed == cryptoActorProperties
          ? _self.cryptoActorProperties
          : cryptoActorProperties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
    ));
  }
}

/// @nodoc

class _CryptoActorStub implements CryptoActorStub {
  const _CryptoActorStub(
      {required this.id,
      required this.rev,
      final Map<String, List<HexString>> hcPartyKeys = const {},
      final Map<
              AesExchangeKeyEntryKeyString,
              Map<String,
                  Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>
          aesExchangeKeys = const {},
      final Map<AesExchangeKeyEncryptionKeypairIdentifier,
              Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>
          transferKeys = const {},
      final Map<String, HexString> privateKeyShamirPartitions = const {},
      this.publicKey = null,
      required final Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256,
      this.parentId = null,
      final Set<DecryptedPropertyStub>? cryptoActorProperties = null})
      : _hcPartyKeys = hcPartyKeys,
        _aesExchangeKeys = aesExchangeKeys,
        _transferKeys = transferKeys,
        _privateKeyShamirPartitions = privateKeyShamirPartitions,
        _publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256,
        _cryptoActorProperties = cryptoActorProperties;

  @override
  final String id;
  @override
  final String rev;
  final Map<String, List<HexString>> _hcPartyKeys;
  @override
  @JsonKey()
  Map<String, List<HexString>> get hcPartyKeys {
    if (_hcPartyKeys is EqualUnmodifiableMapView) return _hcPartyKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_hcPartyKeys);
  }

  final Map<
          AesExchangeKeyEntryKeyString,
          Map<String,
              Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>
      _aesExchangeKeys;
  @override
  @JsonKey()
  Map<
          AesExchangeKeyEntryKeyString,
          Map<String,
              Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>
      get aesExchangeKeys {
    if (_aesExchangeKeys is EqualUnmodifiableMapView) return _aesExchangeKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_aesExchangeKeys);
  }

  final Map<AesExchangeKeyEncryptionKeypairIdentifier,
      Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> _transferKeys;
  @override
  @JsonKey()
  Map<AesExchangeKeyEncryptionKeypairIdentifier,
          Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>
      get transferKeys {
    if (_transferKeys is EqualUnmodifiableMapView) return _transferKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_transferKeys);
  }

  final Map<String, HexString> _privateKeyShamirPartitions;
  @override
  @JsonKey()
  Map<String, HexString> get privateKeyShamirPartitions {
    if (_privateKeyShamirPartitions is EqualUnmodifiableMapView)
      return _privateKeyShamirPartitions;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_privateKeyShamirPartitions);
  }

  @override
  @JsonKey()
  final CardinalRsaPublicKey? publicKey;
  final Set<CardinalRsaPublicKey> _publicKeysForOaepWithSha256;
  @override
  Set<CardinalRsaPublicKey> get publicKeysForOaepWithSha256 {
    if (_publicKeysForOaepWithSha256 is EqualUnmodifiableSetView)
      return _publicKeysForOaepWithSha256;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_publicKeysForOaepWithSha256);
  }

  @override
  @JsonKey()
  final String? parentId;
  final Set<DecryptedPropertyStub>? _cryptoActorProperties;
  @override
  @JsonKey()
  Set<DecryptedPropertyStub>? get cryptoActorProperties {
    final value = _cryptoActorProperties;
    if (value == null) return null;
    if (_cryptoActorProperties is EqualUnmodifiableSetView)
      return _cryptoActorProperties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  /// Create a copy of CryptoActorStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$CryptoActorStubCopyWith<_CryptoActorStub> get copyWith =>
      __$CryptoActorStubCopyWithImpl<_CryptoActorStub>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _CryptoActorStub &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            const DeepCollectionEquality()
                .equals(other._hcPartyKeys, _hcPartyKeys) &&
            const DeepCollectionEquality()
                .equals(other._aesExchangeKeys, _aesExchangeKeys) &&
            const DeepCollectionEquality()
                .equals(other._transferKeys, _transferKeys) &&
            const DeepCollectionEquality().equals(
                other._privateKeyShamirPartitions,
                _privateKeyShamirPartitions) &&
            (identical(other.publicKey, publicKey) ||
                other.publicKey == publicKey) &&
            const DeepCollectionEquality().equals(
                other._publicKeysForOaepWithSha256,
                _publicKeysForOaepWithSha256) &&
            (identical(other.parentId, parentId) ||
                other.parentId == parentId) &&
            const DeepCollectionEquality()
                .equals(other._cryptoActorProperties, _cryptoActorProperties));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      const DeepCollectionEquality().hash(_hcPartyKeys),
      const DeepCollectionEquality().hash(_aesExchangeKeys),
      const DeepCollectionEquality().hash(_transferKeys),
      const DeepCollectionEquality().hash(_privateKeyShamirPartitions),
      publicKey,
      const DeepCollectionEquality().hash(_publicKeysForOaepWithSha256),
      parentId,
      const DeepCollectionEquality().hash(_cryptoActorProperties));

  @override
  String toString() {
    return 'CryptoActorStub(id: $id, rev: $rev, hcPartyKeys: $hcPartyKeys, aesExchangeKeys: $aesExchangeKeys, transferKeys: $transferKeys, privateKeyShamirPartitions: $privateKeyShamirPartitions, publicKey: $publicKey, publicKeysForOaepWithSha256: $publicKeysForOaepWithSha256, parentId: $parentId, cryptoActorProperties: $cryptoActorProperties)';
  }
}

/// @nodoc
abstract mixin class _$CryptoActorStubCopyWith<$Res>
    implements $CryptoActorStubCopyWith<$Res> {
  factory _$CryptoActorStubCopyWith(
          _CryptoActorStub value, $Res Function(_CryptoActorStub) _then) =
      __$CryptoActorStubCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String rev,
      Map<String, List<HexString>> hcPartyKeys,
      Map<
              AesExchangeKeyEntryKeyString,
              Map<String,
                  Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>
          aesExchangeKeys,
      Map<AesExchangeKeyEncryptionKeypairIdentifier,
              Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>
          transferKeys,
      Map<String, HexString> privateKeyShamirPartitions,
      CardinalRsaPublicKey? publicKey,
      Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256,
      String? parentId,
      Set<DecryptedPropertyStub>? cryptoActorProperties});
}

/// @nodoc
class __$CryptoActorStubCopyWithImpl<$Res>
    implements _$CryptoActorStubCopyWith<$Res> {
  __$CryptoActorStubCopyWithImpl(this._self, this._then);

  final _CryptoActorStub _self;
  final $Res Function(_CryptoActorStub) _then;

  /// Create a copy of CryptoActorStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = null,
    Object? hcPartyKeys = null,
    Object? aesExchangeKeys = null,
    Object? transferKeys = null,
    Object? privateKeyShamirPartitions = null,
    Object? publicKey = freezed,
    Object? publicKeysForOaepWithSha256 = null,
    Object? parentId = freezed,
    Object? cryptoActorProperties = freezed,
  }) {
    return _then(_CryptoActorStub(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: null == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String,
      hcPartyKeys: null == hcPartyKeys
          ? _self._hcPartyKeys
          : hcPartyKeys // ignore: cast_nullable_to_non_nullable
              as Map<String, List<HexString>>,
      aesExchangeKeys: null == aesExchangeKeys
          ? _self._aesExchangeKeys
          : aesExchangeKeys // ignore: cast_nullable_to_non_nullable
              as Map<
                  AesExchangeKeyEntryKeyString,
                  Map<
                      String,
                      Map<AesExchangeKeyEncryptionKeypairIdentifier,
                          HexString>>>,
      transferKeys: null == transferKeys
          ? _self._transferKeys
          : transferKeys // ignore: cast_nullable_to_non_nullable
              as Map<AesExchangeKeyEncryptionKeypairIdentifier,
                  Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>,
      privateKeyShamirPartitions: null == privateKeyShamirPartitions
          ? _self._privateKeyShamirPartitions
          : privateKeyShamirPartitions // ignore: cast_nullable_to_non_nullable
              as Map<String, HexString>,
      publicKey: freezed == publicKey
          ? _self.publicKey
          : publicKey // ignore: cast_nullable_to_non_nullable
              as CardinalRsaPublicKey?,
      publicKeysForOaepWithSha256: null == publicKeysForOaepWithSha256
          ? _self._publicKeysForOaepWithSha256
          : publicKeysForOaepWithSha256 // ignore: cast_nullable_to_non_nullable
              as Set<CardinalRsaPublicKey>,
      parentId: freezed == parentId
          ? _self.parentId
          : parentId // ignore: cast_nullable_to_non_nullable
              as String?,
      cryptoActorProperties: freezed == cryptoActorProperties
          ? _self._cryptoActorProperties
          : cryptoActorProperties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
    ));
  }
}

// dart format on
