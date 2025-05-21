// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'document.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedDocument {
  String get id;
  String? get rev;
  int? get created;
  int? get modified;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  int? get endOfLife;
  int? get deletionDate;
  DocumentLocation? get documentLocation;
  DocumentType? get documentType;
  DocumentStatus? get documentStatus;
  String? get externalUri;
  String? get name;
  String? get version;
  String? get storedICureDocumentId;
  String? get externalUuid;
  int? get size;
  String? get hash;
  String? get openingContactId;
  String? get attachmentId;
  String? get objectStoreReference;
  String? get mainUti;
  Set<String> get otherUtis;
  Map<String, DataAttachment> get secondaryAttachments;
  List<DeletedAttachment> get deletedAttachments;
  Uint8List? get encryptedAttachment;
  Uint8List? get decryptedAttachment;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;

  /// Create a copy of EncryptedDocument
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedDocumentCopyWith<EncryptedDocument> get copyWith =>
      _$EncryptedDocumentCopyWithImpl<EncryptedDocument>(
          this as EncryptedDocument, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedDocument &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.documentLocation, documentLocation) ||
                other.documentLocation == documentLocation) &&
            (identical(other.documentType, documentType) ||
                other.documentType == documentType) &&
            (identical(other.documentStatus, documentStatus) ||
                other.documentStatus == documentStatus) &&
            (identical(other.externalUri, externalUri) ||
                other.externalUri == externalUri) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.version, version) || other.version == version) &&
            (identical(other.storedICureDocumentId, storedICureDocumentId) ||
                other.storedICureDocumentId == storedICureDocumentId) &&
            (identical(other.externalUuid, externalUuid) ||
                other.externalUuid == externalUuid) &&
            (identical(other.size, size) || other.size == size) &&
            (identical(other.hash, hash) || other.hash == hash) &&
            (identical(other.openingContactId, openingContactId) ||
                other.openingContactId == openingContactId) &&
            (identical(other.attachmentId, attachmentId) ||
                other.attachmentId == attachmentId) &&
            (identical(other.objectStoreReference, objectStoreReference) ||
                other.objectStoreReference == objectStoreReference) &&
            (identical(other.mainUti, mainUti) || other.mainUti == mainUti) &&
            const DeepCollectionEquality().equals(other.otherUtis, otherUtis) &&
            const DeepCollectionEquality()
                .equals(other.secondaryAttachments, secondaryAttachments) &&
            const DeepCollectionEquality()
                .equals(other.deletedAttachments, deletedAttachments) &&
            const DeepCollectionEquality()
                .equals(other.encryptedAttachment, encryptedAttachment) &&
            const DeepCollectionEquality()
                .equals(other.decryptedAttachment, decryptedAttachment) &&
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
                other.securityMetadata == securityMetadata));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        created,
        modified,
        author,
        responsible,
        medicalLocationId,
        const DeepCollectionEquality().hash(tags),
        const DeepCollectionEquality().hash(codes),
        endOfLife,
        deletionDate,
        documentLocation,
        documentType,
        documentStatus,
        externalUri,
        name,
        version,
        storedICureDocumentId,
        externalUuid,
        size,
        hash,
        openingContactId,
        attachmentId,
        objectStoreReference,
        mainUti,
        const DeepCollectionEquality().hash(otherUtis),
        const DeepCollectionEquality().hash(secondaryAttachments),
        const DeepCollectionEquality().hash(deletedAttachments),
        const DeepCollectionEquality().hash(encryptedAttachment),
        const DeepCollectionEquality().hash(decryptedAttachment),
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'EncryptedDocument(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, documentLocation: $documentLocation, documentType: $documentType, documentStatus: $documentStatus, externalUri: $externalUri, name: $name, version: $version, storedICureDocumentId: $storedICureDocumentId, externalUuid: $externalUuid, size: $size, hash: $hash, openingContactId: $openingContactId, attachmentId: $attachmentId, objectStoreReference: $objectStoreReference, mainUti: $mainUti, otherUtis: $otherUtis, secondaryAttachments: $secondaryAttachments, deletedAttachments: $deletedAttachments, encryptedAttachment: $encryptedAttachment, decryptedAttachment: $decryptedAttachment, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class $EncryptedDocumentCopyWith<$Res> {
  factory $EncryptedDocumentCopyWith(
          EncryptedDocument value, $Res Function(EncryptedDocument) _then) =
      _$EncryptedDocumentCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      DocumentLocation? documentLocation,
      DocumentType? documentType,
      DocumentStatus? documentStatus,
      String? externalUri,
      String? name,
      String? version,
      String? storedICureDocumentId,
      String? externalUuid,
      int? size,
      String? hash,
      String? openingContactId,
      String? attachmentId,
      String? objectStoreReference,
      String? mainUti,
      Set<String> otherUtis,
      Map<String, DataAttachment> secondaryAttachments,
      List<DeletedAttachment> deletedAttachments,
      Uint8List? encryptedAttachment,
      Uint8List? decryptedAttachment,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$EncryptedDocumentCopyWithImpl<$Res>
    implements $EncryptedDocumentCopyWith<$Res> {
  _$EncryptedDocumentCopyWithImpl(this._self, this._then);

  final EncryptedDocument _self;
  final $Res Function(EncryptedDocument) _then;

  /// Create a copy of EncryptedDocument
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? documentLocation = freezed,
    Object? documentType = freezed,
    Object? documentStatus = freezed,
    Object? externalUri = freezed,
    Object? name = freezed,
    Object? version = freezed,
    Object? storedICureDocumentId = freezed,
    Object? externalUuid = freezed,
    Object? size = freezed,
    Object? hash = freezed,
    Object? openingContactId = freezed,
    Object? attachmentId = freezed,
    Object? objectStoreReference = freezed,
    Object? mainUti = freezed,
    Object? otherUtis = null,
    Object? secondaryAttachments = null,
    Object? deletedAttachments = null,
    Object? encryptedAttachment = freezed,
    Object? decryptedAttachment = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
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
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
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
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      documentLocation: freezed == documentLocation
          ? _self.documentLocation
          : documentLocation // ignore: cast_nullable_to_non_nullable
              as DocumentLocation?,
      documentType: freezed == documentType
          ? _self.documentType
          : documentType // ignore: cast_nullable_to_non_nullable
              as DocumentType?,
      documentStatus: freezed == documentStatus
          ? _self.documentStatus
          : documentStatus // ignore: cast_nullable_to_non_nullable
              as DocumentStatus?,
      externalUri: freezed == externalUri
          ? _self.externalUri
          : externalUri // ignore: cast_nullable_to_non_nullable
              as String?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as String?,
      storedICureDocumentId: freezed == storedICureDocumentId
          ? _self.storedICureDocumentId
          : storedICureDocumentId // ignore: cast_nullable_to_non_nullable
              as String?,
      externalUuid: freezed == externalUuid
          ? _self.externalUuid
          : externalUuid // ignore: cast_nullable_to_non_nullable
              as String?,
      size: freezed == size
          ? _self.size
          : size // ignore: cast_nullable_to_non_nullable
              as int?,
      hash: freezed == hash
          ? _self.hash
          : hash // ignore: cast_nullable_to_non_nullable
              as String?,
      openingContactId: freezed == openingContactId
          ? _self.openingContactId
          : openingContactId // ignore: cast_nullable_to_non_nullable
              as String?,
      attachmentId: freezed == attachmentId
          ? _self.attachmentId
          : attachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
      objectStoreReference: freezed == objectStoreReference
          ? _self.objectStoreReference
          : objectStoreReference // ignore: cast_nullable_to_non_nullable
              as String?,
      mainUti: freezed == mainUti
          ? _self.mainUti
          : mainUti // ignore: cast_nullable_to_non_nullable
              as String?,
      otherUtis: null == otherUtis
          ? _self.otherUtis
          : otherUtis // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      secondaryAttachments: null == secondaryAttachments
          ? _self.secondaryAttachments
          : secondaryAttachments // ignore: cast_nullable_to_non_nullable
              as Map<String, DataAttachment>,
      deletedAttachments: null == deletedAttachments
          ? _self.deletedAttachments
          : deletedAttachments // ignore: cast_nullable_to_non_nullable
              as List<DeletedAttachment>,
      encryptedAttachment: freezed == encryptedAttachment
          ? _self.encryptedAttachment
          : encryptedAttachment // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      decryptedAttachment: freezed == decryptedAttachment
          ? _self.decryptedAttachment
          : decryptedAttachment // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
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
    ));
  }

  /// Create a copy of EncryptedDocument
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

class _EncryptedDocument implements EncryptedDocument {
  const _EncryptedDocument(
      {required this.id,
      this.rev = null,
      this.created = null,
      this.modified = null,
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      this.endOfLife = null,
      this.deletionDate = null,
      this.documentLocation = null,
      this.documentType = null,
      this.documentStatus = null,
      this.externalUri = null,
      this.name = null,
      this.version = null,
      this.storedICureDocumentId = null,
      this.externalUuid = null,
      this.size = null,
      this.hash = null,
      this.openingContactId = null,
      this.attachmentId = null,
      this.objectStoreReference = null,
      this.mainUti = null,
      final Set<String> otherUtis = const {},
      final Map<String, DataAttachment> secondaryAttachments = const {},
      final List<DeletedAttachment> deletedAttachments = const [],
      this.encryptedAttachment = null,
      this.decryptedAttachment = null,
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null})
      : _tags = tags,
        _codes = codes,
        _otherUtis = otherUtis,
        _secondaryAttachments = secondaryAttachments,
        _deletedAttachments = deletedAttachments,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
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
  @override
  @JsonKey()
  final String? medicalLocationId;
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
  final int? deletionDate;
  @override
  @JsonKey()
  final DocumentLocation? documentLocation;
  @override
  @JsonKey()
  final DocumentType? documentType;
  @override
  @JsonKey()
  final DocumentStatus? documentStatus;
  @override
  @JsonKey()
  final String? externalUri;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? version;
  @override
  @JsonKey()
  final String? storedICureDocumentId;
  @override
  @JsonKey()
  final String? externalUuid;
  @override
  @JsonKey()
  final int? size;
  @override
  @JsonKey()
  final String? hash;
  @override
  @JsonKey()
  final String? openingContactId;
  @override
  @JsonKey()
  final String? attachmentId;
  @override
  @JsonKey()
  final String? objectStoreReference;
  @override
  @JsonKey()
  final String? mainUti;
  final Set<String> _otherUtis;
  @override
  @JsonKey()
  Set<String> get otherUtis {
    if (_otherUtis is EqualUnmodifiableSetView) return _otherUtis;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_otherUtis);
  }

  final Map<String, DataAttachment> _secondaryAttachments;
  @override
  @JsonKey()
  Map<String, DataAttachment> get secondaryAttachments {
    if (_secondaryAttachments is EqualUnmodifiableMapView)
      return _secondaryAttachments;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_secondaryAttachments);
  }

  final List<DeletedAttachment> _deletedAttachments;
  @override
  @JsonKey()
  List<DeletedAttachment> get deletedAttachments {
    if (_deletedAttachments is EqualUnmodifiableListView)
      return _deletedAttachments;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_deletedAttachments);
  }

  @override
  @JsonKey()
  final Uint8List? encryptedAttachment;
  @override
  @JsonKey()
  final Uint8List? decryptedAttachment;
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

  /// Create a copy of EncryptedDocument
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedDocumentCopyWith<_EncryptedDocument> get copyWith =>
      __$EncryptedDocumentCopyWithImpl<_EncryptedDocument>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedDocument &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.documentLocation, documentLocation) ||
                other.documentLocation == documentLocation) &&
            (identical(other.documentType, documentType) ||
                other.documentType == documentType) &&
            (identical(other.documentStatus, documentStatus) ||
                other.documentStatus == documentStatus) &&
            (identical(other.externalUri, externalUri) ||
                other.externalUri == externalUri) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.version, version) || other.version == version) &&
            (identical(other.storedICureDocumentId, storedICureDocumentId) ||
                other.storedICureDocumentId == storedICureDocumentId) &&
            (identical(other.externalUuid, externalUuid) ||
                other.externalUuid == externalUuid) &&
            (identical(other.size, size) || other.size == size) &&
            (identical(other.hash, hash) || other.hash == hash) &&
            (identical(other.openingContactId, openingContactId) ||
                other.openingContactId == openingContactId) &&
            (identical(other.attachmentId, attachmentId) ||
                other.attachmentId == attachmentId) &&
            (identical(other.objectStoreReference, objectStoreReference) ||
                other.objectStoreReference == objectStoreReference) &&
            (identical(other.mainUti, mainUti) || other.mainUti == mainUti) &&
            const DeepCollectionEquality()
                .equals(other._otherUtis, _otherUtis) &&
            const DeepCollectionEquality()
                .equals(other._secondaryAttachments, _secondaryAttachments) &&
            const DeepCollectionEquality()
                .equals(other._deletedAttachments, _deletedAttachments) &&
            const DeepCollectionEquality()
                .equals(other.encryptedAttachment, encryptedAttachment) &&
            const DeepCollectionEquality()
                .equals(other.decryptedAttachment, decryptedAttachment) &&
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
                other.securityMetadata == securityMetadata));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        created,
        modified,
        author,
        responsible,
        medicalLocationId,
        const DeepCollectionEquality().hash(_tags),
        const DeepCollectionEquality().hash(_codes),
        endOfLife,
        deletionDate,
        documentLocation,
        documentType,
        documentStatus,
        externalUri,
        name,
        version,
        storedICureDocumentId,
        externalUuid,
        size,
        hash,
        openingContactId,
        attachmentId,
        objectStoreReference,
        mainUti,
        const DeepCollectionEquality().hash(_otherUtis),
        const DeepCollectionEquality().hash(_secondaryAttachments),
        const DeepCollectionEquality().hash(_deletedAttachments),
        const DeepCollectionEquality().hash(encryptedAttachment),
        const DeepCollectionEquality().hash(decryptedAttachment),
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'EncryptedDocument(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, documentLocation: $documentLocation, documentType: $documentType, documentStatus: $documentStatus, externalUri: $externalUri, name: $name, version: $version, storedICureDocumentId: $storedICureDocumentId, externalUuid: $externalUuid, size: $size, hash: $hash, openingContactId: $openingContactId, attachmentId: $attachmentId, objectStoreReference: $objectStoreReference, mainUti: $mainUti, otherUtis: $otherUtis, secondaryAttachments: $secondaryAttachments, deletedAttachments: $deletedAttachments, encryptedAttachment: $encryptedAttachment, decryptedAttachment: $decryptedAttachment, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedDocumentCopyWith<$Res>
    implements $EncryptedDocumentCopyWith<$Res> {
  factory _$EncryptedDocumentCopyWith(
          _EncryptedDocument value, $Res Function(_EncryptedDocument) _then) =
      __$EncryptedDocumentCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      DocumentLocation? documentLocation,
      DocumentType? documentType,
      DocumentStatus? documentStatus,
      String? externalUri,
      String? name,
      String? version,
      String? storedICureDocumentId,
      String? externalUuid,
      int? size,
      String? hash,
      String? openingContactId,
      String? attachmentId,
      String? objectStoreReference,
      String? mainUti,
      Set<String> otherUtis,
      Map<String, DataAttachment> secondaryAttachments,
      List<DeletedAttachment> deletedAttachments,
      Uint8List? encryptedAttachment,
      Uint8List? decryptedAttachment,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$EncryptedDocumentCopyWithImpl<$Res>
    implements _$EncryptedDocumentCopyWith<$Res> {
  __$EncryptedDocumentCopyWithImpl(this._self, this._then);

  final _EncryptedDocument _self;
  final $Res Function(_EncryptedDocument) _then;

  /// Create a copy of EncryptedDocument
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? documentLocation = freezed,
    Object? documentType = freezed,
    Object? documentStatus = freezed,
    Object? externalUri = freezed,
    Object? name = freezed,
    Object? version = freezed,
    Object? storedICureDocumentId = freezed,
    Object? externalUuid = freezed,
    Object? size = freezed,
    Object? hash = freezed,
    Object? openingContactId = freezed,
    Object? attachmentId = freezed,
    Object? objectStoreReference = freezed,
    Object? mainUti = freezed,
    Object? otherUtis = null,
    Object? secondaryAttachments = null,
    Object? deletedAttachments = null,
    Object? encryptedAttachment = freezed,
    Object? decryptedAttachment = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_EncryptedDocument(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
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
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
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
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      documentLocation: freezed == documentLocation
          ? _self.documentLocation
          : documentLocation // ignore: cast_nullable_to_non_nullable
              as DocumentLocation?,
      documentType: freezed == documentType
          ? _self.documentType
          : documentType // ignore: cast_nullable_to_non_nullable
              as DocumentType?,
      documentStatus: freezed == documentStatus
          ? _self.documentStatus
          : documentStatus // ignore: cast_nullable_to_non_nullable
              as DocumentStatus?,
      externalUri: freezed == externalUri
          ? _self.externalUri
          : externalUri // ignore: cast_nullable_to_non_nullable
              as String?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as String?,
      storedICureDocumentId: freezed == storedICureDocumentId
          ? _self.storedICureDocumentId
          : storedICureDocumentId // ignore: cast_nullable_to_non_nullable
              as String?,
      externalUuid: freezed == externalUuid
          ? _self.externalUuid
          : externalUuid // ignore: cast_nullable_to_non_nullable
              as String?,
      size: freezed == size
          ? _self.size
          : size // ignore: cast_nullable_to_non_nullable
              as int?,
      hash: freezed == hash
          ? _self.hash
          : hash // ignore: cast_nullable_to_non_nullable
              as String?,
      openingContactId: freezed == openingContactId
          ? _self.openingContactId
          : openingContactId // ignore: cast_nullable_to_non_nullable
              as String?,
      attachmentId: freezed == attachmentId
          ? _self.attachmentId
          : attachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
      objectStoreReference: freezed == objectStoreReference
          ? _self.objectStoreReference
          : objectStoreReference // ignore: cast_nullable_to_non_nullable
              as String?,
      mainUti: freezed == mainUti
          ? _self.mainUti
          : mainUti // ignore: cast_nullable_to_non_nullable
              as String?,
      otherUtis: null == otherUtis
          ? _self._otherUtis
          : otherUtis // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      secondaryAttachments: null == secondaryAttachments
          ? _self._secondaryAttachments
          : secondaryAttachments // ignore: cast_nullable_to_non_nullable
              as Map<String, DataAttachment>,
      deletedAttachments: null == deletedAttachments
          ? _self._deletedAttachments
          : deletedAttachments // ignore: cast_nullable_to_non_nullable
              as List<DeletedAttachment>,
      encryptedAttachment: freezed == encryptedAttachment
          ? _self.encryptedAttachment
          : encryptedAttachment // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      decryptedAttachment: freezed == decryptedAttachment
          ? _self.decryptedAttachment
          : decryptedAttachment // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
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
    ));
  }

  /// Create a copy of EncryptedDocument
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
mixin _$DecryptedDocument {
  String get id;
  String? get rev;
  int? get created;
  int? get modified;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  int? get endOfLife;
  int? get deletionDate;
  DocumentLocation? get documentLocation;
  DocumentType? get documentType;
  DocumentStatus? get documentStatus;
  String? get externalUri;
  String? get name;
  String? get version;
  String? get storedICureDocumentId;
  String? get externalUuid;
  int? get size;
  String? get hash;
  String? get openingContactId;
  String? get attachmentId;
  String? get objectStoreReference;
  String? get mainUti;
  Set<String> get otherUtis;
  Map<String, DataAttachment> get secondaryAttachments;
  List<DeletedAttachment> get deletedAttachments;
  Uint8List? get encryptedAttachment;
  Uint8List? get decryptedAttachment;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;

  /// Create a copy of DecryptedDocument
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedDocumentCopyWith<DecryptedDocument> get copyWith =>
      _$DecryptedDocumentCopyWithImpl<DecryptedDocument>(
          this as DecryptedDocument, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedDocument &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.documentLocation, documentLocation) ||
                other.documentLocation == documentLocation) &&
            (identical(other.documentType, documentType) ||
                other.documentType == documentType) &&
            (identical(other.documentStatus, documentStatus) ||
                other.documentStatus == documentStatus) &&
            (identical(other.externalUri, externalUri) ||
                other.externalUri == externalUri) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.version, version) || other.version == version) &&
            (identical(other.storedICureDocumentId, storedICureDocumentId) ||
                other.storedICureDocumentId == storedICureDocumentId) &&
            (identical(other.externalUuid, externalUuid) ||
                other.externalUuid == externalUuid) &&
            (identical(other.size, size) || other.size == size) &&
            (identical(other.hash, hash) || other.hash == hash) &&
            (identical(other.openingContactId, openingContactId) ||
                other.openingContactId == openingContactId) &&
            (identical(other.attachmentId, attachmentId) ||
                other.attachmentId == attachmentId) &&
            (identical(other.objectStoreReference, objectStoreReference) ||
                other.objectStoreReference == objectStoreReference) &&
            (identical(other.mainUti, mainUti) || other.mainUti == mainUti) &&
            const DeepCollectionEquality().equals(other.otherUtis, otherUtis) &&
            const DeepCollectionEquality()
                .equals(other.secondaryAttachments, secondaryAttachments) &&
            const DeepCollectionEquality()
                .equals(other.deletedAttachments, deletedAttachments) &&
            const DeepCollectionEquality()
                .equals(other.encryptedAttachment, encryptedAttachment) &&
            const DeepCollectionEquality()
                .equals(other.decryptedAttachment, decryptedAttachment) &&
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
                other.securityMetadata == securityMetadata));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        created,
        modified,
        author,
        responsible,
        medicalLocationId,
        const DeepCollectionEquality().hash(tags),
        const DeepCollectionEquality().hash(codes),
        endOfLife,
        deletionDate,
        documentLocation,
        documentType,
        documentStatus,
        externalUri,
        name,
        version,
        storedICureDocumentId,
        externalUuid,
        size,
        hash,
        openingContactId,
        attachmentId,
        objectStoreReference,
        mainUti,
        const DeepCollectionEquality().hash(otherUtis),
        const DeepCollectionEquality().hash(secondaryAttachments),
        const DeepCollectionEquality().hash(deletedAttachments),
        const DeepCollectionEquality().hash(encryptedAttachment),
        const DeepCollectionEquality().hash(decryptedAttachment),
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'DecryptedDocument(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, documentLocation: $documentLocation, documentType: $documentType, documentStatus: $documentStatus, externalUri: $externalUri, name: $name, version: $version, storedICureDocumentId: $storedICureDocumentId, externalUuid: $externalUuid, size: $size, hash: $hash, openingContactId: $openingContactId, attachmentId: $attachmentId, objectStoreReference: $objectStoreReference, mainUti: $mainUti, otherUtis: $otherUtis, secondaryAttachments: $secondaryAttachments, deletedAttachments: $deletedAttachments, encryptedAttachment: $encryptedAttachment, decryptedAttachment: $decryptedAttachment, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class $DecryptedDocumentCopyWith<$Res> {
  factory $DecryptedDocumentCopyWith(
          DecryptedDocument value, $Res Function(DecryptedDocument) _then) =
      _$DecryptedDocumentCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      DocumentLocation? documentLocation,
      DocumentType? documentType,
      DocumentStatus? documentStatus,
      String? externalUri,
      String? name,
      String? version,
      String? storedICureDocumentId,
      String? externalUuid,
      int? size,
      String? hash,
      String? openingContactId,
      String? attachmentId,
      String? objectStoreReference,
      String? mainUti,
      Set<String> otherUtis,
      Map<String, DataAttachment> secondaryAttachments,
      List<DeletedAttachment> deletedAttachments,
      Uint8List? encryptedAttachment,
      Uint8List? decryptedAttachment,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$DecryptedDocumentCopyWithImpl<$Res>
    implements $DecryptedDocumentCopyWith<$Res> {
  _$DecryptedDocumentCopyWithImpl(this._self, this._then);

  final DecryptedDocument _self;
  final $Res Function(DecryptedDocument) _then;

  /// Create a copy of DecryptedDocument
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? documentLocation = freezed,
    Object? documentType = freezed,
    Object? documentStatus = freezed,
    Object? externalUri = freezed,
    Object? name = freezed,
    Object? version = freezed,
    Object? storedICureDocumentId = freezed,
    Object? externalUuid = freezed,
    Object? size = freezed,
    Object? hash = freezed,
    Object? openingContactId = freezed,
    Object? attachmentId = freezed,
    Object? objectStoreReference = freezed,
    Object? mainUti = freezed,
    Object? otherUtis = null,
    Object? secondaryAttachments = null,
    Object? deletedAttachments = null,
    Object? encryptedAttachment = freezed,
    Object? decryptedAttachment = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
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
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
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
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      documentLocation: freezed == documentLocation
          ? _self.documentLocation
          : documentLocation // ignore: cast_nullable_to_non_nullable
              as DocumentLocation?,
      documentType: freezed == documentType
          ? _self.documentType
          : documentType // ignore: cast_nullable_to_non_nullable
              as DocumentType?,
      documentStatus: freezed == documentStatus
          ? _self.documentStatus
          : documentStatus // ignore: cast_nullable_to_non_nullable
              as DocumentStatus?,
      externalUri: freezed == externalUri
          ? _self.externalUri
          : externalUri // ignore: cast_nullable_to_non_nullable
              as String?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as String?,
      storedICureDocumentId: freezed == storedICureDocumentId
          ? _self.storedICureDocumentId
          : storedICureDocumentId // ignore: cast_nullable_to_non_nullable
              as String?,
      externalUuid: freezed == externalUuid
          ? _self.externalUuid
          : externalUuid // ignore: cast_nullable_to_non_nullable
              as String?,
      size: freezed == size
          ? _self.size
          : size // ignore: cast_nullable_to_non_nullable
              as int?,
      hash: freezed == hash
          ? _self.hash
          : hash // ignore: cast_nullable_to_non_nullable
              as String?,
      openingContactId: freezed == openingContactId
          ? _self.openingContactId
          : openingContactId // ignore: cast_nullable_to_non_nullable
              as String?,
      attachmentId: freezed == attachmentId
          ? _self.attachmentId
          : attachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
      objectStoreReference: freezed == objectStoreReference
          ? _self.objectStoreReference
          : objectStoreReference // ignore: cast_nullable_to_non_nullable
              as String?,
      mainUti: freezed == mainUti
          ? _self.mainUti
          : mainUti // ignore: cast_nullable_to_non_nullable
              as String?,
      otherUtis: null == otherUtis
          ? _self.otherUtis
          : otherUtis // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      secondaryAttachments: null == secondaryAttachments
          ? _self.secondaryAttachments
          : secondaryAttachments // ignore: cast_nullable_to_non_nullable
              as Map<String, DataAttachment>,
      deletedAttachments: null == deletedAttachments
          ? _self.deletedAttachments
          : deletedAttachments // ignore: cast_nullable_to_non_nullable
              as List<DeletedAttachment>,
      encryptedAttachment: freezed == encryptedAttachment
          ? _self.encryptedAttachment
          : encryptedAttachment // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      decryptedAttachment: freezed == decryptedAttachment
          ? _self.decryptedAttachment
          : decryptedAttachment // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
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
    ));
  }

  /// Create a copy of DecryptedDocument
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

class _DecryptedDocument implements DecryptedDocument {
  const _DecryptedDocument(
      {required this.id,
      this.rev = null,
      this.created = null,
      this.modified = null,
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      this.endOfLife = null,
      this.deletionDate = null,
      this.documentLocation = null,
      this.documentType = null,
      this.documentStatus = null,
      this.externalUri = null,
      this.name = null,
      this.version = null,
      this.storedICureDocumentId = null,
      this.externalUuid = null,
      this.size = null,
      this.hash = null,
      this.openingContactId = null,
      this.attachmentId = null,
      this.objectStoreReference = null,
      this.mainUti = null,
      final Set<String> otherUtis = const {},
      final Map<String, DataAttachment> secondaryAttachments = const {},
      final List<DeletedAttachment> deletedAttachments = const [],
      this.encryptedAttachment = null,
      this.decryptedAttachment = null,
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null})
      : _tags = tags,
        _codes = codes,
        _otherUtis = otherUtis,
        _secondaryAttachments = secondaryAttachments,
        _deletedAttachments = deletedAttachments,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
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
  @override
  @JsonKey()
  final String? medicalLocationId;
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
  final int? deletionDate;
  @override
  @JsonKey()
  final DocumentLocation? documentLocation;
  @override
  @JsonKey()
  final DocumentType? documentType;
  @override
  @JsonKey()
  final DocumentStatus? documentStatus;
  @override
  @JsonKey()
  final String? externalUri;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? version;
  @override
  @JsonKey()
  final String? storedICureDocumentId;
  @override
  @JsonKey()
  final String? externalUuid;
  @override
  @JsonKey()
  final int? size;
  @override
  @JsonKey()
  final String? hash;
  @override
  @JsonKey()
  final String? openingContactId;
  @override
  @JsonKey()
  final String? attachmentId;
  @override
  @JsonKey()
  final String? objectStoreReference;
  @override
  @JsonKey()
  final String? mainUti;
  final Set<String> _otherUtis;
  @override
  @JsonKey()
  Set<String> get otherUtis {
    if (_otherUtis is EqualUnmodifiableSetView) return _otherUtis;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_otherUtis);
  }

  final Map<String, DataAttachment> _secondaryAttachments;
  @override
  @JsonKey()
  Map<String, DataAttachment> get secondaryAttachments {
    if (_secondaryAttachments is EqualUnmodifiableMapView)
      return _secondaryAttachments;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_secondaryAttachments);
  }

  final List<DeletedAttachment> _deletedAttachments;
  @override
  @JsonKey()
  List<DeletedAttachment> get deletedAttachments {
    if (_deletedAttachments is EqualUnmodifiableListView)
      return _deletedAttachments;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_deletedAttachments);
  }

  @override
  @JsonKey()
  final Uint8List? encryptedAttachment;
  @override
  @JsonKey()
  final Uint8List? decryptedAttachment;
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

  /// Create a copy of DecryptedDocument
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedDocumentCopyWith<_DecryptedDocument> get copyWith =>
      __$DecryptedDocumentCopyWithImpl<_DecryptedDocument>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedDocument &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.documentLocation, documentLocation) ||
                other.documentLocation == documentLocation) &&
            (identical(other.documentType, documentType) ||
                other.documentType == documentType) &&
            (identical(other.documentStatus, documentStatus) ||
                other.documentStatus == documentStatus) &&
            (identical(other.externalUri, externalUri) ||
                other.externalUri == externalUri) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.version, version) || other.version == version) &&
            (identical(other.storedICureDocumentId, storedICureDocumentId) ||
                other.storedICureDocumentId == storedICureDocumentId) &&
            (identical(other.externalUuid, externalUuid) ||
                other.externalUuid == externalUuid) &&
            (identical(other.size, size) || other.size == size) &&
            (identical(other.hash, hash) || other.hash == hash) &&
            (identical(other.openingContactId, openingContactId) ||
                other.openingContactId == openingContactId) &&
            (identical(other.attachmentId, attachmentId) ||
                other.attachmentId == attachmentId) &&
            (identical(other.objectStoreReference, objectStoreReference) ||
                other.objectStoreReference == objectStoreReference) &&
            (identical(other.mainUti, mainUti) || other.mainUti == mainUti) &&
            const DeepCollectionEquality()
                .equals(other._otherUtis, _otherUtis) &&
            const DeepCollectionEquality()
                .equals(other._secondaryAttachments, _secondaryAttachments) &&
            const DeepCollectionEquality()
                .equals(other._deletedAttachments, _deletedAttachments) &&
            const DeepCollectionEquality()
                .equals(other.encryptedAttachment, encryptedAttachment) &&
            const DeepCollectionEquality()
                .equals(other.decryptedAttachment, decryptedAttachment) &&
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
                other.securityMetadata == securityMetadata));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        created,
        modified,
        author,
        responsible,
        medicalLocationId,
        const DeepCollectionEquality().hash(_tags),
        const DeepCollectionEquality().hash(_codes),
        endOfLife,
        deletionDate,
        documentLocation,
        documentType,
        documentStatus,
        externalUri,
        name,
        version,
        storedICureDocumentId,
        externalUuid,
        size,
        hash,
        openingContactId,
        attachmentId,
        objectStoreReference,
        mainUti,
        const DeepCollectionEquality().hash(_otherUtis),
        const DeepCollectionEquality().hash(_secondaryAttachments),
        const DeepCollectionEquality().hash(_deletedAttachments),
        const DeepCollectionEquality().hash(encryptedAttachment),
        const DeepCollectionEquality().hash(decryptedAttachment),
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'DecryptedDocument(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, documentLocation: $documentLocation, documentType: $documentType, documentStatus: $documentStatus, externalUri: $externalUri, name: $name, version: $version, storedICureDocumentId: $storedICureDocumentId, externalUuid: $externalUuid, size: $size, hash: $hash, openingContactId: $openingContactId, attachmentId: $attachmentId, objectStoreReference: $objectStoreReference, mainUti: $mainUti, otherUtis: $otherUtis, secondaryAttachments: $secondaryAttachments, deletedAttachments: $deletedAttachments, encryptedAttachment: $encryptedAttachment, decryptedAttachment: $decryptedAttachment, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedDocumentCopyWith<$Res>
    implements $DecryptedDocumentCopyWith<$Res> {
  factory _$DecryptedDocumentCopyWith(
          _DecryptedDocument value, $Res Function(_DecryptedDocument) _then) =
      __$DecryptedDocumentCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      DocumentLocation? documentLocation,
      DocumentType? documentType,
      DocumentStatus? documentStatus,
      String? externalUri,
      String? name,
      String? version,
      String? storedICureDocumentId,
      String? externalUuid,
      int? size,
      String? hash,
      String? openingContactId,
      String? attachmentId,
      String? objectStoreReference,
      String? mainUti,
      Set<String> otherUtis,
      Map<String, DataAttachment> secondaryAttachments,
      List<DeletedAttachment> deletedAttachments,
      Uint8List? encryptedAttachment,
      Uint8List? decryptedAttachment,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$DecryptedDocumentCopyWithImpl<$Res>
    implements _$DecryptedDocumentCopyWith<$Res> {
  __$DecryptedDocumentCopyWithImpl(this._self, this._then);

  final _DecryptedDocument _self;
  final $Res Function(_DecryptedDocument) _then;

  /// Create a copy of DecryptedDocument
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? documentLocation = freezed,
    Object? documentType = freezed,
    Object? documentStatus = freezed,
    Object? externalUri = freezed,
    Object? name = freezed,
    Object? version = freezed,
    Object? storedICureDocumentId = freezed,
    Object? externalUuid = freezed,
    Object? size = freezed,
    Object? hash = freezed,
    Object? openingContactId = freezed,
    Object? attachmentId = freezed,
    Object? objectStoreReference = freezed,
    Object? mainUti = freezed,
    Object? otherUtis = null,
    Object? secondaryAttachments = null,
    Object? deletedAttachments = null,
    Object? encryptedAttachment = freezed,
    Object? decryptedAttachment = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_DecryptedDocument(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
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
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
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
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      documentLocation: freezed == documentLocation
          ? _self.documentLocation
          : documentLocation // ignore: cast_nullable_to_non_nullable
              as DocumentLocation?,
      documentType: freezed == documentType
          ? _self.documentType
          : documentType // ignore: cast_nullable_to_non_nullable
              as DocumentType?,
      documentStatus: freezed == documentStatus
          ? _self.documentStatus
          : documentStatus // ignore: cast_nullable_to_non_nullable
              as DocumentStatus?,
      externalUri: freezed == externalUri
          ? _self.externalUri
          : externalUri // ignore: cast_nullable_to_non_nullable
              as String?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as String?,
      storedICureDocumentId: freezed == storedICureDocumentId
          ? _self.storedICureDocumentId
          : storedICureDocumentId // ignore: cast_nullable_to_non_nullable
              as String?,
      externalUuid: freezed == externalUuid
          ? _self.externalUuid
          : externalUuid // ignore: cast_nullable_to_non_nullable
              as String?,
      size: freezed == size
          ? _self.size
          : size // ignore: cast_nullable_to_non_nullable
              as int?,
      hash: freezed == hash
          ? _self.hash
          : hash // ignore: cast_nullable_to_non_nullable
              as String?,
      openingContactId: freezed == openingContactId
          ? _self.openingContactId
          : openingContactId // ignore: cast_nullable_to_non_nullable
              as String?,
      attachmentId: freezed == attachmentId
          ? _self.attachmentId
          : attachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
      objectStoreReference: freezed == objectStoreReference
          ? _self.objectStoreReference
          : objectStoreReference // ignore: cast_nullable_to_non_nullable
              as String?,
      mainUti: freezed == mainUti
          ? _self.mainUti
          : mainUti // ignore: cast_nullable_to_non_nullable
              as String?,
      otherUtis: null == otherUtis
          ? _self._otherUtis
          : otherUtis // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      secondaryAttachments: null == secondaryAttachments
          ? _self._secondaryAttachments
          : secondaryAttachments // ignore: cast_nullable_to_non_nullable
              as Map<String, DataAttachment>,
      deletedAttachments: null == deletedAttachments
          ? _self._deletedAttachments
          : deletedAttachments // ignore: cast_nullable_to_non_nullable
              as List<DeletedAttachment>,
      encryptedAttachment: freezed == encryptedAttachment
          ? _self.encryptedAttachment
          : encryptedAttachment // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      decryptedAttachment: freezed == decryptedAttachment
          ? _self.decryptedAttachment
          : decryptedAttachment // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
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
    ));
  }

  /// Create a copy of DecryptedDocument
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
