// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'device.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Device {
  String get id;
  String? get rev;
  int? get deletionDate;
  List<Identifier> get identifiers;
  int? get created;
  int? get modified;
  String? get author;
  String? get responsible;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  int? get endOfLife;
  String? get medicalLocationId;
  String? get externalId;
  String? get name;
  String? get type;
  String? get brand;
  String? get model;
  String? get serialNumber;
  String? get parentId;
  Uint8List? get picture;
  Set<DecryptedPropertyStub> get properties;
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
  Set<DecryptedPropertyStub>? get cryptoActorProperties;

  /// Create a copy of Device
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DeviceCopyWith<Device> get copyWith =>
      _$DeviceCopyWithImpl<Device>(this as Device, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Device &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            const DeepCollectionEquality()
                .equals(other.identifiers, identifiers) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            (identical(other.externalId, externalId) ||
                other.externalId == externalId) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.brand, brand) || other.brand == brand) &&
            (identical(other.model, model) || other.model == model) &&
            (identical(other.serialNumber, serialNumber) ||
                other.serialNumber == serialNumber) &&
            (identical(other.parentId, parentId) ||
                other.parentId == parentId) &&
            const DeepCollectionEquality().equals(other.picture, picture) &&
            const DeepCollectionEquality()
                .equals(other.properties, properties) &&
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
            const DeepCollectionEquality()
                .equals(other.cryptoActorProperties, cryptoActorProperties));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        deletionDate,
        const DeepCollectionEquality().hash(identifiers),
        created,
        modified,
        author,
        responsible,
        const DeepCollectionEquality().hash(tags),
        const DeepCollectionEquality().hash(codes),
        endOfLife,
        medicalLocationId,
        externalId,
        name,
        type,
        brand,
        model,
        serialNumber,
        parentId,
        const DeepCollectionEquality().hash(picture),
        const DeepCollectionEquality().hash(properties),
        const DeepCollectionEquality().hash(hcPartyKeys),
        const DeepCollectionEquality().hash(aesExchangeKeys),
        const DeepCollectionEquality().hash(transferKeys),
        const DeepCollectionEquality().hash(privateKeyShamirPartitions),
        publicKey,
        const DeepCollectionEquality().hash(publicKeysForOaepWithSha256),
        const DeepCollectionEquality().hash(cryptoActorProperties)
      ]);

  @override
  String toString() {
    return 'Device(id: $id, rev: $rev, deletionDate: $deletionDate, identifiers: $identifiers, created: $created, modified: $modified, author: $author, responsible: $responsible, tags: $tags, codes: $codes, endOfLife: $endOfLife, medicalLocationId: $medicalLocationId, externalId: $externalId, name: $name, type: $type, brand: $brand, model: $model, serialNumber: $serialNumber, parentId: $parentId, picture: $picture, properties: $properties, hcPartyKeys: $hcPartyKeys, aesExchangeKeys: $aesExchangeKeys, transferKeys: $transferKeys, privateKeyShamirPartitions: $privateKeyShamirPartitions, publicKey: $publicKey, publicKeysForOaepWithSha256: $publicKeysForOaepWithSha256, cryptoActorProperties: $cryptoActorProperties)';
  }
}

/// @nodoc
abstract mixin class $DeviceCopyWith<$Res> {
  factory $DeviceCopyWith(Device value, $Res Function(Device) _then) =
      _$DeviceCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      List<Identifier> identifiers,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      String? medicalLocationId,
      String? externalId,
      String? name,
      String? type,
      String? brand,
      String? model,
      String? serialNumber,
      String? parentId,
      Uint8List? picture,
      Set<DecryptedPropertyStub> properties,
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
      Set<DecryptedPropertyStub>? cryptoActorProperties});
}

/// @nodoc
class _$DeviceCopyWithImpl<$Res> implements $DeviceCopyWith<$Res> {
  _$DeviceCopyWithImpl(this._self, this._then);

  final Device _self;
  final $Res Function(Device) _then;

  /// Create a copy of Device
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? identifiers = null,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? medicalLocationId = freezed,
    Object? externalId = freezed,
    Object? name = freezed,
    Object? type = freezed,
    Object? brand = freezed,
    Object? model = freezed,
    Object? serialNumber = freezed,
    Object? parentId = freezed,
    Object? picture = freezed,
    Object? properties = null,
    Object? hcPartyKeys = null,
    Object? aesExchangeKeys = null,
    Object? transferKeys = null,
    Object? privateKeyShamirPartitions = null,
    Object? publicKey = freezed,
    Object? publicKeysForOaepWithSha256 = null,
    Object? cryptoActorProperties = freezed,
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
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      identifiers: null == identifiers
          ? _self.identifiers
          : identifiers // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      created: freezed == created
          ? _self.created
          : created // ignore: cast_nullable_to_non_nullable
              as int?,
      modified: freezed == modified
          ? _self.modified
          : modified // ignore: cast_nullable_to_non_nullable
              as int?,
      author: freezed == author
          ? _self.author
          : author // ignore: cast_nullable_to_non_nullable
              as String?,
      responsible: freezed == responsible
          ? _self.responsible
          : responsible // ignore: cast_nullable_to_non_nullable
              as String?,
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      codes: null == codes
          ? _self.codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
              as String?,
      externalId: freezed == externalId
          ? _self.externalId
          : externalId // ignore: cast_nullable_to_non_nullable
              as String?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as String?,
      brand: freezed == brand
          ? _self.brand
          : brand // ignore: cast_nullable_to_non_nullable
              as String?,
      model: freezed == model
          ? _self.model
          : model // ignore: cast_nullable_to_non_nullable
              as String?,
      serialNumber: freezed == serialNumber
          ? _self.serialNumber
          : serialNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      parentId: freezed == parentId
          ? _self.parentId
          : parentId // ignore: cast_nullable_to_non_nullable
              as String?,
      picture: freezed == picture
          ? _self.picture
          : picture // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      properties: null == properties
          ? _self.properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
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
      cryptoActorProperties: freezed == cryptoActorProperties
          ? _self.cryptoActorProperties
          : cryptoActorProperties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
    ));
  }
}

/// @nodoc

class _Device implements Device {
  const _Device(
      {required this.id,
      this.rev = null,
      this.deletionDate = null,
      final List<Identifier> identifiers = const [],
      this.created = null,
      this.modified = null,
      this.author = null,
      this.responsible = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      this.endOfLife = null,
      this.medicalLocationId = null,
      this.externalId = null,
      this.name = null,
      this.type = null,
      this.brand = null,
      this.model = null,
      this.serialNumber = null,
      this.parentId = null,
      this.picture = null,
      final Set<DecryptedPropertyStub> properties = const {},
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
      final Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256 = const {},
      final Set<DecryptedPropertyStub>? cryptoActorProperties = null})
      : _identifiers = identifiers,
        _tags = tags,
        _codes = codes,
        _properties = properties,
        _hcPartyKeys = hcPartyKeys,
        _aesExchangeKeys = aesExchangeKeys,
        _transferKeys = transferKeys,
        _privateKeyShamirPartitions = privateKeyShamirPartitions,
        _publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256,
        _cryptoActorProperties = cryptoActorProperties;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  @JsonKey()
  final int? deletionDate;
  final List<Identifier> _identifiers;
  @override
  @JsonKey()
  List<Identifier> get identifiers {
    if (_identifiers is EqualUnmodifiableListView) return _identifiers;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_identifiers);
  }

  @override
  @JsonKey()
  final int? created;
  @override
  @JsonKey()
  final int? modified;
  @override
  @JsonKey()
  final String? author;
  @override
  @JsonKey()
  final String? responsible;
  final Set<CodeStub> _tags;
  @override
  @JsonKey()
  Set<CodeStub> get tags {
    if (_tags is EqualUnmodifiableSetView) return _tags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_tags);
  }

  final Set<CodeStub> _codes;
  @override
  @JsonKey()
  Set<CodeStub> get codes {
    if (_codes is EqualUnmodifiableSetView) return _codes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_codes);
  }

  @override
  @JsonKey()
  final int? endOfLife;
  @override
  @JsonKey()
  final String? medicalLocationId;
  @override
  @JsonKey()
  final String? externalId;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? type;
  @override
  @JsonKey()
  final String? brand;
  @override
  @JsonKey()
  final String? model;
  @override
  @JsonKey()
  final String? serialNumber;
  @override
  @JsonKey()
  final String? parentId;
  @override
  @JsonKey()
  final Uint8List? picture;
  final Set<DecryptedPropertyStub> _properties;
  @override
  @JsonKey()
  Set<DecryptedPropertyStub> get properties {
    if (_properties is EqualUnmodifiableSetView) return _properties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_properties);
  }

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
  @JsonKey()
  Set<CardinalRsaPublicKey> get publicKeysForOaepWithSha256 {
    if (_publicKeysForOaepWithSha256 is EqualUnmodifiableSetView)
      return _publicKeysForOaepWithSha256;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_publicKeysForOaepWithSha256);
  }

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

  /// Create a copy of Device
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DeviceCopyWith<_Device> get copyWith =>
      __$DeviceCopyWithImpl<_Device>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Device &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            const DeepCollectionEquality()
                .equals(other._identifiers, _identifiers) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            (identical(other.externalId, externalId) ||
                other.externalId == externalId) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.brand, brand) || other.brand == brand) &&
            (identical(other.model, model) || other.model == model) &&
            (identical(other.serialNumber, serialNumber) ||
                other.serialNumber == serialNumber) &&
            (identical(other.parentId, parentId) ||
                other.parentId == parentId) &&
            const DeepCollectionEquality().equals(other.picture, picture) &&
            const DeepCollectionEquality()
                .equals(other._properties, _properties) &&
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
            const DeepCollectionEquality()
                .equals(other._cryptoActorProperties, _cryptoActorProperties));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        deletionDate,
        const DeepCollectionEquality().hash(_identifiers),
        created,
        modified,
        author,
        responsible,
        const DeepCollectionEquality().hash(_tags),
        const DeepCollectionEquality().hash(_codes),
        endOfLife,
        medicalLocationId,
        externalId,
        name,
        type,
        brand,
        model,
        serialNumber,
        parentId,
        const DeepCollectionEquality().hash(picture),
        const DeepCollectionEquality().hash(_properties),
        const DeepCollectionEquality().hash(_hcPartyKeys),
        const DeepCollectionEquality().hash(_aesExchangeKeys),
        const DeepCollectionEquality().hash(_transferKeys),
        const DeepCollectionEquality().hash(_privateKeyShamirPartitions),
        publicKey,
        const DeepCollectionEquality().hash(_publicKeysForOaepWithSha256),
        const DeepCollectionEquality().hash(_cryptoActorProperties)
      ]);

  @override
  String toString() {
    return 'Device(id: $id, rev: $rev, deletionDate: $deletionDate, identifiers: $identifiers, created: $created, modified: $modified, author: $author, responsible: $responsible, tags: $tags, codes: $codes, endOfLife: $endOfLife, medicalLocationId: $medicalLocationId, externalId: $externalId, name: $name, type: $type, brand: $brand, model: $model, serialNumber: $serialNumber, parentId: $parentId, picture: $picture, properties: $properties, hcPartyKeys: $hcPartyKeys, aesExchangeKeys: $aesExchangeKeys, transferKeys: $transferKeys, privateKeyShamirPartitions: $privateKeyShamirPartitions, publicKey: $publicKey, publicKeysForOaepWithSha256: $publicKeysForOaepWithSha256, cryptoActorProperties: $cryptoActorProperties)';
  }
}

/// @nodoc
abstract mixin class _$DeviceCopyWith<$Res> implements $DeviceCopyWith<$Res> {
  factory _$DeviceCopyWith(_Device value, $Res Function(_Device) _then) =
      __$DeviceCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      List<Identifier> identifiers,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      String? medicalLocationId,
      String? externalId,
      String? name,
      String? type,
      String? brand,
      String? model,
      String? serialNumber,
      String? parentId,
      Uint8List? picture,
      Set<DecryptedPropertyStub> properties,
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
      Set<DecryptedPropertyStub>? cryptoActorProperties});
}

/// @nodoc
class __$DeviceCopyWithImpl<$Res> implements _$DeviceCopyWith<$Res> {
  __$DeviceCopyWithImpl(this._self, this._then);

  final _Device _self;
  final $Res Function(_Device) _then;

  /// Create a copy of Device
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? identifiers = null,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? medicalLocationId = freezed,
    Object? externalId = freezed,
    Object? name = freezed,
    Object? type = freezed,
    Object? brand = freezed,
    Object? model = freezed,
    Object? serialNumber = freezed,
    Object? parentId = freezed,
    Object? picture = freezed,
    Object? properties = null,
    Object? hcPartyKeys = null,
    Object? aesExchangeKeys = null,
    Object? transferKeys = null,
    Object? privateKeyShamirPartitions = null,
    Object? publicKey = freezed,
    Object? publicKeysForOaepWithSha256 = null,
    Object? cryptoActorProperties = freezed,
  }) {
    return _then(_Device(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      identifiers: null == identifiers
          ? _self._identifiers
          : identifiers // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      created: freezed == created
          ? _self.created
          : created // ignore: cast_nullable_to_non_nullable
              as int?,
      modified: freezed == modified
          ? _self.modified
          : modified // ignore: cast_nullable_to_non_nullable
              as int?,
      author: freezed == author
          ? _self.author
          : author // ignore: cast_nullable_to_non_nullable
              as String?,
      responsible: freezed == responsible
          ? _self.responsible
          : responsible // ignore: cast_nullable_to_non_nullable
              as String?,
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      codes: null == codes
          ? _self._codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
              as String?,
      externalId: freezed == externalId
          ? _self.externalId
          : externalId // ignore: cast_nullable_to_non_nullable
              as String?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as String?,
      brand: freezed == brand
          ? _self.brand
          : brand // ignore: cast_nullable_to_non_nullable
              as String?,
      model: freezed == model
          ? _self.model
          : model // ignore: cast_nullable_to_non_nullable
              as String?,
      serialNumber: freezed == serialNumber
          ? _self.serialNumber
          : serialNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      parentId: freezed == parentId
          ? _self.parentId
          : parentId // ignore: cast_nullable_to_non_nullable
              as String?,
      picture: freezed == picture
          ? _self.picture
          : picture // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      properties: null == properties
          ? _self._properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
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
      cryptoActorProperties: freezed == cryptoActorProperties
          ? _self._cryptoActorProperties
          : cryptoActorProperties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>?,
    ));
  }
}

// dart format on
