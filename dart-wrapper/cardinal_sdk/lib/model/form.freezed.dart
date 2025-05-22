// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'form.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedForm {
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
  int? get openingDate;
  String? get status;
  int? get version;
  String? get logicalUuid;
  String? get descr;
  String? get uniqueId;
  String? get formTemplateId;
  String? get contactId;
  String? get healthElementId;
  String? get planOfActionId;
  String? get parent;
  String? get anchorId;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;

  /// Create a copy of EncryptedForm
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedFormCopyWith<EncryptedForm> get copyWith =>
      _$EncryptedFormCopyWithImpl<EncryptedForm>(
          this as EncryptedForm, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedForm &&
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
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.version, version) || other.version == version) &&
            (identical(other.logicalUuid, logicalUuid) ||
                other.logicalUuid == logicalUuid) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.uniqueId, uniqueId) ||
                other.uniqueId == uniqueId) &&
            (identical(other.formTemplateId, formTemplateId) ||
                other.formTemplateId == formTemplateId) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.planOfActionId, planOfActionId) ||
                other.planOfActionId == planOfActionId) &&
            (identical(other.parent, parent) || other.parent == parent) &&
            (identical(other.anchorId, anchorId) ||
                other.anchorId == anchorId) &&
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
        openingDate,
        status,
        version,
        logicalUuid,
        descr,
        uniqueId,
        formTemplateId,
        contactId,
        healthElementId,
        planOfActionId,
        parent,
        anchorId,
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'EncryptedForm(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, openingDate: $openingDate, status: $status, version: $version, logicalUuid: $logicalUuid, descr: $descr, uniqueId: $uniqueId, formTemplateId: $formTemplateId, contactId: $contactId, healthElementId: $healthElementId, planOfActionId: $planOfActionId, parent: $parent, anchorId: $anchorId, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class $EncryptedFormCopyWith<$Res> {
  factory $EncryptedFormCopyWith(
          EncryptedForm value, $Res Function(EncryptedForm) _then) =
      _$EncryptedFormCopyWithImpl;
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
      int? openingDate,
      String? status,
      int? version,
      String? logicalUuid,
      String? descr,
      String? uniqueId,
      String? formTemplateId,
      String? contactId,
      String? healthElementId,
      String? planOfActionId,
      String? parent,
      String? anchorId,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$EncryptedFormCopyWithImpl<$Res>
    implements $EncryptedFormCopyWith<$Res> {
  _$EncryptedFormCopyWithImpl(this._self, this._then);

  final EncryptedForm _self;
  final $Res Function(EncryptedForm) _then;

  /// Create a copy of EncryptedForm
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
    Object? openingDate = freezed,
    Object? status = freezed,
    Object? version = freezed,
    Object? logicalUuid = freezed,
    Object? descr = freezed,
    Object? uniqueId = freezed,
    Object? formTemplateId = freezed,
    Object? contactId = freezed,
    Object? healthElementId = freezed,
    Object? planOfActionId = freezed,
    Object? parent = freezed,
    Object? anchorId = freezed,
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
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as int?,
      logicalUuid: freezed == logicalUuid
          ? _self.logicalUuid
          : logicalUuid // ignore: cast_nullable_to_non_nullable
              as String?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      uniqueId: freezed == uniqueId
          ? _self.uniqueId
          : uniqueId // ignore: cast_nullable_to_non_nullable
              as String?,
      formTemplateId: freezed == formTemplateId
          ? _self.formTemplateId
          : formTemplateId // ignore: cast_nullable_to_non_nullable
              as String?,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      planOfActionId: freezed == planOfActionId
          ? _self.planOfActionId
          : planOfActionId // ignore: cast_nullable_to_non_nullable
              as String?,
      parent: freezed == parent
          ? _self.parent
          : parent // ignore: cast_nullable_to_non_nullable
              as String?,
      anchorId: freezed == anchorId
          ? _self.anchorId
          : anchorId // ignore: cast_nullable_to_non_nullable
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
    ));
  }

  /// Create a copy of EncryptedForm
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

class _EncryptedForm implements EncryptedForm {
  const _EncryptedForm(
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
      this.openingDate = null,
      this.status = null,
      this.version = null,
      this.logicalUuid = null,
      this.descr = null,
      this.uniqueId = null,
      this.formTemplateId = null,
      this.contactId = null,
      this.healthElementId = null,
      this.planOfActionId = null,
      this.parent = null,
      this.anchorId = null,
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null})
      : _tags = tags,
        _codes = codes,
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
  final int? openingDate;
  @override
  @JsonKey()
  final String? status;
  @override
  @JsonKey()
  final int? version;
  @override
  @JsonKey()
  final String? logicalUuid;
  @override
  @JsonKey()
  final String? descr;
  @override
  @JsonKey()
  final String? uniqueId;
  @override
  @JsonKey()
  final String? formTemplateId;
  @override
  @JsonKey()
  final String? contactId;
  @override
  @JsonKey()
  final String? healthElementId;
  @override
  @JsonKey()
  final String? planOfActionId;
  @override
  @JsonKey()
  final String? parent;
  @override
  @JsonKey()
  final String? anchorId;
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

  /// Create a copy of EncryptedForm
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedFormCopyWith<_EncryptedForm> get copyWith =>
      __$EncryptedFormCopyWithImpl<_EncryptedForm>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedForm &&
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
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.version, version) || other.version == version) &&
            (identical(other.logicalUuid, logicalUuid) ||
                other.logicalUuid == logicalUuid) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.uniqueId, uniqueId) ||
                other.uniqueId == uniqueId) &&
            (identical(other.formTemplateId, formTemplateId) ||
                other.formTemplateId == formTemplateId) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.planOfActionId, planOfActionId) ||
                other.planOfActionId == planOfActionId) &&
            (identical(other.parent, parent) || other.parent == parent) &&
            (identical(other.anchorId, anchorId) ||
                other.anchorId == anchorId) &&
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
        openingDate,
        status,
        version,
        logicalUuid,
        descr,
        uniqueId,
        formTemplateId,
        contactId,
        healthElementId,
        planOfActionId,
        parent,
        anchorId,
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'EncryptedForm(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, openingDate: $openingDate, status: $status, version: $version, logicalUuid: $logicalUuid, descr: $descr, uniqueId: $uniqueId, formTemplateId: $formTemplateId, contactId: $contactId, healthElementId: $healthElementId, planOfActionId: $planOfActionId, parent: $parent, anchorId: $anchorId, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedFormCopyWith<$Res>
    implements $EncryptedFormCopyWith<$Res> {
  factory _$EncryptedFormCopyWith(
          _EncryptedForm value, $Res Function(_EncryptedForm) _then) =
      __$EncryptedFormCopyWithImpl;
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
      int? openingDate,
      String? status,
      int? version,
      String? logicalUuid,
      String? descr,
      String? uniqueId,
      String? formTemplateId,
      String? contactId,
      String? healthElementId,
      String? planOfActionId,
      String? parent,
      String? anchorId,
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
class __$EncryptedFormCopyWithImpl<$Res>
    implements _$EncryptedFormCopyWith<$Res> {
  __$EncryptedFormCopyWithImpl(this._self, this._then);

  final _EncryptedForm _self;
  final $Res Function(_EncryptedForm) _then;

  /// Create a copy of EncryptedForm
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
    Object? openingDate = freezed,
    Object? status = freezed,
    Object? version = freezed,
    Object? logicalUuid = freezed,
    Object? descr = freezed,
    Object? uniqueId = freezed,
    Object? formTemplateId = freezed,
    Object? contactId = freezed,
    Object? healthElementId = freezed,
    Object? planOfActionId = freezed,
    Object? parent = freezed,
    Object? anchorId = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_EncryptedForm(
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
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as int?,
      logicalUuid: freezed == logicalUuid
          ? _self.logicalUuid
          : logicalUuid // ignore: cast_nullable_to_non_nullable
              as String?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      uniqueId: freezed == uniqueId
          ? _self.uniqueId
          : uniqueId // ignore: cast_nullable_to_non_nullable
              as String?,
      formTemplateId: freezed == formTemplateId
          ? _self.formTemplateId
          : formTemplateId // ignore: cast_nullable_to_non_nullable
              as String?,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      planOfActionId: freezed == planOfActionId
          ? _self.planOfActionId
          : planOfActionId // ignore: cast_nullable_to_non_nullable
              as String?,
      parent: freezed == parent
          ? _self.parent
          : parent // ignore: cast_nullable_to_non_nullable
              as String?,
      anchorId: freezed == anchorId
          ? _self.anchorId
          : anchorId // ignore: cast_nullable_to_non_nullable
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
    ));
  }

  /// Create a copy of EncryptedForm
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
mixin _$DecryptedForm {
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
  int? get openingDate;
  String? get status;
  int? get version;
  String? get logicalUuid;
  String? get descr;
  String? get uniqueId;
  String? get formTemplateId;
  String? get contactId;
  String? get healthElementId;
  String? get planOfActionId;
  String? get parent;
  String? get anchorId;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;

  /// Create a copy of DecryptedForm
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedFormCopyWith<DecryptedForm> get copyWith =>
      _$DecryptedFormCopyWithImpl<DecryptedForm>(
          this as DecryptedForm, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedForm &&
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
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.version, version) || other.version == version) &&
            (identical(other.logicalUuid, logicalUuid) ||
                other.logicalUuid == logicalUuid) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.uniqueId, uniqueId) ||
                other.uniqueId == uniqueId) &&
            (identical(other.formTemplateId, formTemplateId) ||
                other.formTemplateId == formTemplateId) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.planOfActionId, planOfActionId) ||
                other.planOfActionId == planOfActionId) &&
            (identical(other.parent, parent) || other.parent == parent) &&
            (identical(other.anchorId, anchorId) ||
                other.anchorId == anchorId) &&
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
        openingDate,
        status,
        version,
        logicalUuid,
        descr,
        uniqueId,
        formTemplateId,
        contactId,
        healthElementId,
        planOfActionId,
        parent,
        anchorId,
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'DecryptedForm(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, openingDate: $openingDate, status: $status, version: $version, logicalUuid: $logicalUuid, descr: $descr, uniqueId: $uniqueId, formTemplateId: $formTemplateId, contactId: $contactId, healthElementId: $healthElementId, planOfActionId: $planOfActionId, parent: $parent, anchorId: $anchorId, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class $DecryptedFormCopyWith<$Res> {
  factory $DecryptedFormCopyWith(
          DecryptedForm value, $Res Function(DecryptedForm) _then) =
      _$DecryptedFormCopyWithImpl;
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
      int? openingDate,
      String? status,
      int? version,
      String? logicalUuid,
      String? descr,
      String? uniqueId,
      String? formTemplateId,
      String? contactId,
      String? healthElementId,
      String? planOfActionId,
      String? parent,
      String? anchorId,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$DecryptedFormCopyWithImpl<$Res>
    implements $DecryptedFormCopyWith<$Res> {
  _$DecryptedFormCopyWithImpl(this._self, this._then);

  final DecryptedForm _self;
  final $Res Function(DecryptedForm) _then;

  /// Create a copy of DecryptedForm
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
    Object? openingDate = freezed,
    Object? status = freezed,
    Object? version = freezed,
    Object? logicalUuid = freezed,
    Object? descr = freezed,
    Object? uniqueId = freezed,
    Object? formTemplateId = freezed,
    Object? contactId = freezed,
    Object? healthElementId = freezed,
    Object? planOfActionId = freezed,
    Object? parent = freezed,
    Object? anchorId = freezed,
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
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as int?,
      logicalUuid: freezed == logicalUuid
          ? _self.logicalUuid
          : logicalUuid // ignore: cast_nullable_to_non_nullable
              as String?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      uniqueId: freezed == uniqueId
          ? _self.uniqueId
          : uniqueId // ignore: cast_nullable_to_non_nullable
              as String?,
      formTemplateId: freezed == formTemplateId
          ? _self.formTemplateId
          : formTemplateId // ignore: cast_nullable_to_non_nullable
              as String?,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      planOfActionId: freezed == planOfActionId
          ? _self.planOfActionId
          : planOfActionId // ignore: cast_nullable_to_non_nullable
              as String?,
      parent: freezed == parent
          ? _self.parent
          : parent // ignore: cast_nullable_to_non_nullable
              as String?,
      anchorId: freezed == anchorId
          ? _self.anchorId
          : anchorId // ignore: cast_nullable_to_non_nullable
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
    ));
  }

  /// Create a copy of DecryptedForm
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

class _DecryptedForm implements DecryptedForm {
  const _DecryptedForm(
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
      this.openingDate = null,
      this.status = null,
      this.version = null,
      this.logicalUuid = null,
      this.descr = null,
      this.uniqueId = null,
      this.formTemplateId = null,
      this.contactId = null,
      this.healthElementId = null,
      this.planOfActionId = null,
      this.parent = null,
      this.anchorId = null,
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null})
      : _tags = tags,
        _codes = codes,
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
  final int? openingDate;
  @override
  @JsonKey()
  final String? status;
  @override
  @JsonKey()
  final int? version;
  @override
  @JsonKey()
  final String? logicalUuid;
  @override
  @JsonKey()
  final String? descr;
  @override
  @JsonKey()
  final String? uniqueId;
  @override
  @JsonKey()
  final String? formTemplateId;
  @override
  @JsonKey()
  final String? contactId;
  @override
  @JsonKey()
  final String? healthElementId;
  @override
  @JsonKey()
  final String? planOfActionId;
  @override
  @JsonKey()
  final String? parent;
  @override
  @JsonKey()
  final String? anchorId;
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

  /// Create a copy of DecryptedForm
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedFormCopyWith<_DecryptedForm> get copyWith =>
      __$DecryptedFormCopyWithImpl<_DecryptedForm>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedForm &&
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
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.version, version) || other.version == version) &&
            (identical(other.logicalUuid, logicalUuid) ||
                other.logicalUuid == logicalUuid) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.uniqueId, uniqueId) ||
                other.uniqueId == uniqueId) &&
            (identical(other.formTemplateId, formTemplateId) ||
                other.formTemplateId == formTemplateId) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.planOfActionId, planOfActionId) ||
                other.planOfActionId == planOfActionId) &&
            (identical(other.parent, parent) || other.parent == parent) &&
            (identical(other.anchorId, anchorId) ||
                other.anchorId == anchorId) &&
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
        openingDate,
        status,
        version,
        logicalUuid,
        descr,
        uniqueId,
        formTemplateId,
        contactId,
        healthElementId,
        planOfActionId,
        parent,
        anchorId,
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'DecryptedForm(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, openingDate: $openingDate, status: $status, version: $version, logicalUuid: $logicalUuid, descr: $descr, uniqueId: $uniqueId, formTemplateId: $formTemplateId, contactId: $contactId, healthElementId: $healthElementId, planOfActionId: $planOfActionId, parent: $parent, anchorId: $anchorId, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedFormCopyWith<$Res>
    implements $DecryptedFormCopyWith<$Res> {
  factory _$DecryptedFormCopyWith(
          _DecryptedForm value, $Res Function(_DecryptedForm) _then) =
      __$DecryptedFormCopyWithImpl;
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
      int? openingDate,
      String? status,
      int? version,
      String? logicalUuid,
      String? descr,
      String? uniqueId,
      String? formTemplateId,
      String? contactId,
      String? healthElementId,
      String? planOfActionId,
      String? parent,
      String? anchorId,
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
class __$DecryptedFormCopyWithImpl<$Res>
    implements _$DecryptedFormCopyWith<$Res> {
  __$DecryptedFormCopyWithImpl(this._self, this._then);

  final _DecryptedForm _self;
  final $Res Function(_DecryptedForm) _then;

  /// Create a copy of DecryptedForm
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
    Object? openingDate = freezed,
    Object? status = freezed,
    Object? version = freezed,
    Object? logicalUuid = freezed,
    Object? descr = freezed,
    Object? uniqueId = freezed,
    Object? formTemplateId = freezed,
    Object? contactId = freezed,
    Object? healthElementId = freezed,
    Object? planOfActionId = freezed,
    Object? parent = freezed,
    Object? anchorId = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_DecryptedForm(
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
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as int?,
      logicalUuid: freezed == logicalUuid
          ? _self.logicalUuid
          : logicalUuid // ignore: cast_nullable_to_non_nullable
              as String?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      uniqueId: freezed == uniqueId
          ? _self.uniqueId
          : uniqueId // ignore: cast_nullable_to_non_nullable
              as String?,
      formTemplateId: freezed == formTemplateId
          ? _self.formTemplateId
          : formTemplateId // ignore: cast_nullable_to_non_nullable
              as String?,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      planOfActionId: freezed == planOfActionId
          ? _self.planOfActionId
          : planOfActionId // ignore: cast_nullable_to_non_nullable
              as String?,
      parent: freezed == parent
          ? _self.parent
          : parent // ignore: cast_nullable_to_non_nullable
              as String?,
      anchorId: freezed == anchorId
          ? _self.anchorId
          : anchorId // ignore: cast_nullable_to_non_nullable
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
    ));
  }

  /// Create a copy of DecryptedForm
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
