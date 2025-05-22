// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'topic.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DecryptedTopic {
  String get id;
  String? get rev;
  int? get created;
  int? get modified;
  String? get healthElementId;
  String? get contactId;
  String? get description;
  Set<CodeStub> get codes;
  Set<CodeStub> get tags;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  int? get endOfLife;
  int? get deletionDate;
  Map<String, TopicRole> get activeParticipants;
  SecurityMetadata? get securityMetadata;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  Set<String> get linkedHealthElements;
  Set<String> get linkedServices;

  /// Create a copy of DecryptedTopic
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedTopicCopyWith<DecryptedTopic> get copyWith =>
      _$DecryptedTopicCopyWithImpl<DecryptedTopic>(
          this as DecryptedTopic, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedTopic &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            (identical(other.description, description) ||
                other.description == description) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            const DeepCollectionEquality()
                .equals(other.activeParticipants, activeParticipants) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
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
            const DeepCollectionEquality()
                .equals(other.linkedHealthElements, linkedHealthElements) &&
            const DeepCollectionEquality()
                .equals(other.linkedServices, linkedServices));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        created,
        modified,
        healthElementId,
        contactId,
        description,
        const DeepCollectionEquality().hash(codes),
        const DeepCollectionEquality().hash(tags),
        author,
        responsible,
        medicalLocationId,
        endOfLife,
        deletionDate,
        const DeepCollectionEquality().hash(activeParticipants),
        securityMetadata,
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        const DeepCollectionEquality().hash(linkedHealthElements),
        const DeepCollectionEquality().hash(linkedServices)
      ]);

  @override
  String toString() {
    return 'DecryptedTopic(id: $id, rev: $rev, created: $created, modified: $modified, healthElementId: $healthElementId, contactId: $contactId, description: $description, codes: $codes, tags: $tags, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, endOfLife: $endOfLife, deletionDate: $deletionDate, activeParticipants: $activeParticipants, securityMetadata: $securityMetadata, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, linkedHealthElements: $linkedHealthElements, linkedServices: $linkedServices)';
  }
}

/// @nodoc
abstract mixin class $DecryptedTopicCopyWith<$Res> {
  factory $DecryptedTopicCopyWith(
          DecryptedTopic value, $Res Function(DecryptedTopic) _then) =
      _$DecryptedTopicCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? created,
      int? modified,
      String? healthElementId,
      String? contactId,
      String? description,
      Set<CodeStub> codes,
      Set<CodeStub> tags,
      String? author,
      String? responsible,
      String? medicalLocationId,
      int? endOfLife,
      int? deletionDate,
      Map<String, TopicRole> activeParticipants,
      SecurityMetadata? securityMetadata,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      Set<String> linkedHealthElements,
      Set<String> linkedServices});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$DecryptedTopicCopyWithImpl<$Res>
    implements $DecryptedTopicCopyWith<$Res> {
  _$DecryptedTopicCopyWithImpl(this._self, this._then);

  final DecryptedTopic _self;
  final $Res Function(DecryptedTopic) _then;

  /// Create a copy of DecryptedTopic
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? healthElementId = freezed,
    Object? contactId = freezed,
    Object? description = freezed,
    Object? codes = null,
    Object? tags = null,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? activeParticipants = null,
    Object? securityMetadata = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? linkedHealthElements = null,
    Object? linkedServices = null,
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
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      description: freezed == description
          ? _self.description
          : description // ignore: cast_nullable_to_non_nullable
              as String?,
      codes: null == codes
          ? _self.codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
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
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      activeParticipants: null == activeParticipants
          ? _self.activeParticipants
          : activeParticipants // ignore: cast_nullable_to_non_nullable
              as Map<String, TopicRole>,
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
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
      linkedHealthElements: null == linkedHealthElements
          ? _self.linkedHealthElements
          : linkedHealthElements // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      linkedServices: null == linkedServices
          ? _self.linkedServices
          : linkedServices // ignore: cast_nullable_to_non_nullable
              as Set<String>,
    ));
  }

  /// Create a copy of DecryptedTopic
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

class _DecryptedTopic implements DecryptedTopic {
  const _DecryptedTopic(
      {required this.id,
      this.rev = null,
      this.created = null,
      this.modified = null,
      this.healthElementId = null,
      this.contactId = null,
      this.description = null,
      final Set<CodeStub> codes = const {},
      final Set<CodeStub> tags = const {},
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      this.endOfLife = null,
      this.deletionDate = null,
      final Map<String, TopicRole> activeParticipants = const {},
      this.securityMetadata = null,
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      final Set<String> linkedHealthElements = const {},
      final Set<String> linkedServices = const {}})
      : _codes = codes,
        _tags = tags,
        _activeParticipants = activeParticipants,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys,
        _linkedHealthElements = linkedHealthElements,
        _linkedServices = linkedServices;

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
  final String? healthElementId;
  @override
  @JsonKey()
  final String? contactId;
  @override
  @JsonKey()
  final String? description;
  final Set<CodeStub> _codes;
  @override
  @JsonKey()
  Set<CodeStub> get codes {
    if (_codes is EqualUnmodifiableSetView) return _codes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_codes);
  }

  final Set<CodeStub> _tags;
  @override
  @JsonKey()
  Set<CodeStub> get tags {
    if (_tags is EqualUnmodifiableSetView) return _tags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_tags);
  }

  @override
  @JsonKey()
  final String? author;
  @override
  @JsonKey()
  final String? responsible;
  @override
  @JsonKey()
  final String? medicalLocationId;
  @override
  @JsonKey()
  final int? endOfLife;
  @override
  @JsonKey()
  final int? deletionDate;
  final Map<String, TopicRole> _activeParticipants;
  @override
  @JsonKey()
  Map<String, TopicRole> get activeParticipants {
    if (_activeParticipants is EqualUnmodifiableMapView)
      return _activeParticipants;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_activeParticipants);
  }

  @override
  @JsonKey()
  final SecurityMetadata? securityMetadata;
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
  final Set<String> _linkedHealthElements;
  @override
  @JsonKey()
  Set<String> get linkedHealthElements {
    if (_linkedHealthElements is EqualUnmodifiableSetView)
      return _linkedHealthElements;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_linkedHealthElements);
  }

  final Set<String> _linkedServices;
  @override
  @JsonKey()
  Set<String> get linkedServices {
    if (_linkedServices is EqualUnmodifiableSetView) return _linkedServices;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_linkedServices);
  }

  /// Create a copy of DecryptedTopic
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedTopicCopyWith<_DecryptedTopic> get copyWith =>
      __$DecryptedTopicCopyWithImpl<_DecryptedTopic>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedTopic &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            (identical(other.description, description) ||
                other.description == description) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            const DeepCollectionEquality()
                .equals(other._activeParticipants, _activeParticipants) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
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
            const DeepCollectionEquality()
                .equals(other._linkedHealthElements, _linkedHealthElements) &&
            const DeepCollectionEquality()
                .equals(other._linkedServices, _linkedServices));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        created,
        modified,
        healthElementId,
        contactId,
        description,
        const DeepCollectionEquality().hash(_codes),
        const DeepCollectionEquality().hash(_tags),
        author,
        responsible,
        medicalLocationId,
        endOfLife,
        deletionDate,
        const DeepCollectionEquality().hash(_activeParticipants),
        securityMetadata,
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        const DeepCollectionEquality().hash(_linkedHealthElements),
        const DeepCollectionEquality().hash(_linkedServices)
      ]);

  @override
  String toString() {
    return 'DecryptedTopic(id: $id, rev: $rev, created: $created, modified: $modified, healthElementId: $healthElementId, contactId: $contactId, description: $description, codes: $codes, tags: $tags, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, endOfLife: $endOfLife, deletionDate: $deletionDate, activeParticipants: $activeParticipants, securityMetadata: $securityMetadata, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, linkedHealthElements: $linkedHealthElements, linkedServices: $linkedServices)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedTopicCopyWith<$Res>
    implements $DecryptedTopicCopyWith<$Res> {
  factory _$DecryptedTopicCopyWith(
          _DecryptedTopic value, $Res Function(_DecryptedTopic) _then) =
      __$DecryptedTopicCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? created,
      int? modified,
      String? healthElementId,
      String? contactId,
      String? description,
      Set<CodeStub> codes,
      Set<CodeStub> tags,
      String? author,
      String? responsible,
      String? medicalLocationId,
      int? endOfLife,
      int? deletionDate,
      Map<String, TopicRole> activeParticipants,
      SecurityMetadata? securityMetadata,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      Set<String> linkedHealthElements,
      Set<String> linkedServices});

  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$DecryptedTopicCopyWithImpl<$Res>
    implements _$DecryptedTopicCopyWith<$Res> {
  __$DecryptedTopicCopyWithImpl(this._self, this._then);

  final _DecryptedTopic _self;
  final $Res Function(_DecryptedTopic) _then;

  /// Create a copy of DecryptedTopic
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? healthElementId = freezed,
    Object? contactId = freezed,
    Object? description = freezed,
    Object? codes = null,
    Object? tags = null,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? activeParticipants = null,
    Object? securityMetadata = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? linkedHealthElements = null,
    Object? linkedServices = null,
  }) {
    return _then(_DecryptedTopic(
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
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      description: freezed == description
          ? _self.description
          : description // ignore: cast_nullable_to_non_nullable
              as String?,
      codes: null == codes
          ? _self._codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
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
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      activeParticipants: null == activeParticipants
          ? _self._activeParticipants
          : activeParticipants // ignore: cast_nullable_to_non_nullable
              as Map<String, TopicRole>,
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
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
      linkedHealthElements: null == linkedHealthElements
          ? _self._linkedHealthElements
          : linkedHealthElements // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      linkedServices: null == linkedServices
          ? _self._linkedServices
          : linkedServices // ignore: cast_nullable_to_non_nullable
              as Set<String>,
    ));
  }

  /// Create a copy of DecryptedTopic
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
mixin _$EncryptedTopic {
  String get id;
  String? get rev;
  int? get created;
  int? get modified;
  String? get healthElementId;
  String? get contactId;
  String? get description;
  Set<CodeStub> get codes;
  Set<CodeStub> get tags;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  int? get endOfLife;
  int? get deletionDate;
  Map<String, TopicRole> get activeParticipants;
  SecurityMetadata? get securityMetadata;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  Set<String> get linkedHealthElements;
  Set<String> get linkedServices;

  /// Create a copy of EncryptedTopic
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedTopicCopyWith<EncryptedTopic> get copyWith =>
      _$EncryptedTopicCopyWithImpl<EncryptedTopic>(
          this as EncryptedTopic, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedTopic &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            (identical(other.description, description) ||
                other.description == description) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            const DeepCollectionEquality()
                .equals(other.activeParticipants, activeParticipants) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
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
            const DeepCollectionEquality()
                .equals(other.linkedHealthElements, linkedHealthElements) &&
            const DeepCollectionEquality()
                .equals(other.linkedServices, linkedServices));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        created,
        modified,
        healthElementId,
        contactId,
        description,
        const DeepCollectionEquality().hash(codes),
        const DeepCollectionEquality().hash(tags),
        author,
        responsible,
        medicalLocationId,
        endOfLife,
        deletionDate,
        const DeepCollectionEquality().hash(activeParticipants),
        securityMetadata,
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        const DeepCollectionEquality().hash(linkedHealthElements),
        const DeepCollectionEquality().hash(linkedServices)
      ]);

  @override
  String toString() {
    return 'EncryptedTopic(id: $id, rev: $rev, created: $created, modified: $modified, healthElementId: $healthElementId, contactId: $contactId, description: $description, codes: $codes, tags: $tags, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, endOfLife: $endOfLife, deletionDate: $deletionDate, activeParticipants: $activeParticipants, securityMetadata: $securityMetadata, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, linkedHealthElements: $linkedHealthElements, linkedServices: $linkedServices)';
  }
}

/// @nodoc
abstract mixin class $EncryptedTopicCopyWith<$Res> {
  factory $EncryptedTopicCopyWith(
          EncryptedTopic value, $Res Function(EncryptedTopic) _then) =
      _$EncryptedTopicCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? created,
      int? modified,
      String? healthElementId,
      String? contactId,
      String? description,
      Set<CodeStub> codes,
      Set<CodeStub> tags,
      String? author,
      String? responsible,
      String? medicalLocationId,
      int? endOfLife,
      int? deletionDate,
      Map<String, TopicRole> activeParticipants,
      SecurityMetadata? securityMetadata,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      Set<String> linkedHealthElements,
      Set<String> linkedServices});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$EncryptedTopicCopyWithImpl<$Res>
    implements $EncryptedTopicCopyWith<$Res> {
  _$EncryptedTopicCopyWithImpl(this._self, this._then);

  final EncryptedTopic _self;
  final $Res Function(EncryptedTopic) _then;

  /// Create a copy of EncryptedTopic
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? healthElementId = freezed,
    Object? contactId = freezed,
    Object? description = freezed,
    Object? codes = null,
    Object? tags = null,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? activeParticipants = null,
    Object? securityMetadata = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? linkedHealthElements = null,
    Object? linkedServices = null,
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
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      description: freezed == description
          ? _self.description
          : description // ignore: cast_nullable_to_non_nullable
              as String?,
      codes: null == codes
          ? _self.codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
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
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      activeParticipants: null == activeParticipants
          ? _self.activeParticipants
          : activeParticipants // ignore: cast_nullable_to_non_nullable
              as Map<String, TopicRole>,
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
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
      linkedHealthElements: null == linkedHealthElements
          ? _self.linkedHealthElements
          : linkedHealthElements // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      linkedServices: null == linkedServices
          ? _self.linkedServices
          : linkedServices // ignore: cast_nullable_to_non_nullable
              as Set<String>,
    ));
  }

  /// Create a copy of EncryptedTopic
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

class _EncryptedTopic implements EncryptedTopic {
  const _EncryptedTopic(
      {required this.id,
      this.rev = null,
      this.created = null,
      this.modified = null,
      this.healthElementId = null,
      this.contactId = null,
      this.description = null,
      final Set<CodeStub> codes = const {},
      final Set<CodeStub> tags = const {},
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      this.endOfLife = null,
      this.deletionDate = null,
      final Map<String, TopicRole> activeParticipants = const {},
      this.securityMetadata = null,
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      final Set<String> linkedHealthElements = const {},
      final Set<String> linkedServices = const {}})
      : _codes = codes,
        _tags = tags,
        _activeParticipants = activeParticipants,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys,
        _linkedHealthElements = linkedHealthElements,
        _linkedServices = linkedServices;

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
  final String? healthElementId;
  @override
  @JsonKey()
  final String? contactId;
  @override
  @JsonKey()
  final String? description;
  final Set<CodeStub> _codes;
  @override
  @JsonKey()
  Set<CodeStub> get codes {
    if (_codes is EqualUnmodifiableSetView) return _codes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_codes);
  }

  final Set<CodeStub> _tags;
  @override
  @JsonKey()
  Set<CodeStub> get tags {
    if (_tags is EqualUnmodifiableSetView) return _tags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_tags);
  }

  @override
  @JsonKey()
  final String? author;
  @override
  @JsonKey()
  final String? responsible;
  @override
  @JsonKey()
  final String? medicalLocationId;
  @override
  @JsonKey()
  final int? endOfLife;
  @override
  @JsonKey()
  final int? deletionDate;
  final Map<String, TopicRole> _activeParticipants;
  @override
  @JsonKey()
  Map<String, TopicRole> get activeParticipants {
    if (_activeParticipants is EqualUnmodifiableMapView)
      return _activeParticipants;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_activeParticipants);
  }

  @override
  @JsonKey()
  final SecurityMetadata? securityMetadata;
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
  final Set<String> _linkedHealthElements;
  @override
  @JsonKey()
  Set<String> get linkedHealthElements {
    if (_linkedHealthElements is EqualUnmodifiableSetView)
      return _linkedHealthElements;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_linkedHealthElements);
  }

  final Set<String> _linkedServices;
  @override
  @JsonKey()
  Set<String> get linkedServices {
    if (_linkedServices is EqualUnmodifiableSetView) return _linkedServices;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_linkedServices);
  }

  /// Create a copy of EncryptedTopic
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedTopicCopyWith<_EncryptedTopic> get copyWith =>
      __$EncryptedTopicCopyWithImpl<_EncryptedTopic>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedTopic &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            (identical(other.description, description) ||
                other.description == description) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            const DeepCollectionEquality()
                .equals(other._activeParticipants, _activeParticipants) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata) &&
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
            const DeepCollectionEquality()
                .equals(other._linkedHealthElements, _linkedHealthElements) &&
            const DeepCollectionEquality()
                .equals(other._linkedServices, _linkedServices));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        created,
        modified,
        healthElementId,
        contactId,
        description,
        const DeepCollectionEquality().hash(_codes),
        const DeepCollectionEquality().hash(_tags),
        author,
        responsible,
        medicalLocationId,
        endOfLife,
        deletionDate,
        const DeepCollectionEquality().hash(_activeParticipants),
        securityMetadata,
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        const DeepCollectionEquality().hash(_linkedHealthElements),
        const DeepCollectionEquality().hash(_linkedServices)
      ]);

  @override
  String toString() {
    return 'EncryptedTopic(id: $id, rev: $rev, created: $created, modified: $modified, healthElementId: $healthElementId, contactId: $contactId, description: $description, codes: $codes, tags: $tags, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, endOfLife: $endOfLife, deletionDate: $deletionDate, activeParticipants: $activeParticipants, securityMetadata: $securityMetadata, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, linkedHealthElements: $linkedHealthElements, linkedServices: $linkedServices)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedTopicCopyWith<$Res>
    implements $EncryptedTopicCopyWith<$Res> {
  factory _$EncryptedTopicCopyWith(
          _EncryptedTopic value, $Res Function(_EncryptedTopic) _then) =
      __$EncryptedTopicCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? created,
      int? modified,
      String? healthElementId,
      String? contactId,
      String? description,
      Set<CodeStub> codes,
      Set<CodeStub> tags,
      String? author,
      String? responsible,
      String? medicalLocationId,
      int? endOfLife,
      int? deletionDate,
      Map<String, TopicRole> activeParticipants,
      SecurityMetadata? securityMetadata,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      Set<String> linkedHealthElements,
      Set<String> linkedServices});

  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$EncryptedTopicCopyWithImpl<$Res>
    implements _$EncryptedTopicCopyWith<$Res> {
  __$EncryptedTopicCopyWithImpl(this._self, this._then);

  final _EncryptedTopic _self;
  final $Res Function(_EncryptedTopic) _then;

  /// Create a copy of EncryptedTopic
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? healthElementId = freezed,
    Object? contactId = freezed,
    Object? description = freezed,
    Object? codes = null,
    Object? tags = null,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? activeParticipants = null,
    Object? securityMetadata = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? linkedHealthElements = null,
    Object? linkedServices = null,
  }) {
    return _then(_EncryptedTopic(
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
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      description: freezed == description
          ? _self.description
          : description // ignore: cast_nullable_to_non_nullable
              as String?,
      codes: null == codes
          ? _self._codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
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
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      activeParticipants: null == activeParticipants
          ? _self._activeParticipants
          : activeParticipants // ignore: cast_nullable_to_non_nullable
              as Map<String, TopicRole>,
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
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
      linkedHealthElements: null == linkedHealthElements
          ? _self._linkedHealthElements
          : linkedHealthElements // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      linkedServices: null == linkedServices
          ? _self._linkedServices
          : linkedServices // ignore: cast_nullable_to_non_nullable
              as Set<String>,
    ));
  }

  /// Create a copy of EncryptedTopic
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
