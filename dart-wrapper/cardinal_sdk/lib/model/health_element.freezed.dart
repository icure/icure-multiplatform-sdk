// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'health_element.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedHealthElement {
  String get id;
  List<Identifier> get identifiers;
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
  String? get healthElementId;
  int? get valueDate;
  int? get openingDate;
  int? get closingDate;
  String? get descr;
  String? get note;
  List<Annotation> get notes;
  bool get relevant;
  String? get idOpeningContact;
  String? get idClosingContact;
  String? get idService;
  int get status;
  Laterality? get laterality;
  List<EncryptedPlanOfAction> get plansOfAction;
  List<EncryptedEpisode> get episodes;
  List<EncryptedCareTeamMember> get careTeam;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;

  /// Create a copy of EncryptedHealthElement
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedHealthElementCopyWith<EncryptedHealthElement> get copyWith =>
      _$EncryptedHealthElementCopyWithImpl<EncryptedHealthElement>(
          this as EncryptedHealthElement, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedHealthElement &&
            (identical(other.id, id) || other.id == id) &&
            const DeepCollectionEquality()
                .equals(other.identifiers, identifiers) &&
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
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.valueDate, valueDate) ||
                other.valueDate == valueDate) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.note, note) || other.note == note) &&
            const DeepCollectionEquality().equals(other.notes, notes) &&
            (identical(other.relevant, relevant) ||
                other.relevant == relevant) &&
            (identical(other.idOpeningContact, idOpeningContact) ||
                other.idOpeningContact == idOpeningContact) &&
            (identical(other.idClosingContact, idClosingContact) ||
                other.idClosingContact == idClosingContact) &&
            (identical(other.idService, idService) ||
                other.idService == idService) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.laterality, laterality) ||
                other.laterality == laterality) &&
            const DeepCollectionEquality()
                .equals(other.plansOfAction, plansOfAction) &&
            const DeepCollectionEquality().equals(other.episodes, episodes) &&
            const DeepCollectionEquality().equals(other.careTeam, careTeam) &&
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
        const DeepCollectionEquality().hash(identifiers),
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
        healthElementId,
        valueDate,
        openingDate,
        closingDate,
        descr,
        note,
        const DeepCollectionEquality().hash(notes),
        relevant,
        idOpeningContact,
        idClosingContact,
        idService,
        status,
        laterality,
        const DeepCollectionEquality().hash(plansOfAction),
        const DeepCollectionEquality().hash(episodes),
        const DeepCollectionEquality().hash(careTeam),
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'EncryptedHealthElement(id: $id, identifiers: $identifiers, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, healthElementId: $healthElementId, valueDate: $valueDate, openingDate: $openingDate, closingDate: $closingDate, descr: $descr, note: $note, notes: $notes, relevant: $relevant, idOpeningContact: $idOpeningContact, idClosingContact: $idClosingContact, idService: $idService, status: $status, laterality: $laterality, plansOfAction: $plansOfAction, episodes: $episodes, careTeam: $careTeam, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class $EncryptedHealthElementCopyWith<$Res> {
  factory $EncryptedHealthElementCopyWith(EncryptedHealthElement value,
          $Res Function(EncryptedHealthElement) _then) =
      _$EncryptedHealthElementCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      List<Identifier> identifiers,
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
      String? healthElementId,
      int? valueDate,
      int? openingDate,
      int? closingDate,
      String? descr,
      String? note,
      List<Annotation> notes,
      bool relevant,
      String? idOpeningContact,
      String? idClosingContact,
      String? idService,
      int status,
      Laterality? laterality,
      List<EncryptedPlanOfAction> plansOfAction,
      List<EncryptedEpisode> episodes,
      List<EncryptedCareTeamMember> careTeam,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$EncryptedHealthElementCopyWithImpl<$Res>
    implements $EncryptedHealthElementCopyWith<$Res> {
  _$EncryptedHealthElementCopyWithImpl(this._self, this._then);

  final EncryptedHealthElement _self;
  final $Res Function(EncryptedHealthElement) _then;

  /// Create a copy of EncryptedHealthElement
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? identifiers = null,
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
    Object? healthElementId = freezed,
    Object? valueDate = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? descr = freezed,
    Object? note = freezed,
    Object? notes = null,
    Object? relevant = null,
    Object? idOpeningContact = freezed,
    Object? idClosingContact = freezed,
    Object? idService = freezed,
    Object? status = null,
    Object? laterality = freezed,
    Object? plansOfAction = null,
    Object? episodes = null,
    Object? careTeam = null,
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
      identifiers: null == identifiers
          ? _self.identifiers
          : identifiers // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
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
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      valueDate: freezed == valueDate
          ? _self.valueDate
          : valueDate // ignore: cast_nullable_to_non_nullable
              as int?,
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      closingDate: freezed == closingDate
          ? _self.closingDate
          : closingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      notes: null == notes
          ? _self.notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      relevant: null == relevant
          ? _self.relevant
          : relevant // ignore: cast_nullable_to_non_nullable
              as bool,
      idOpeningContact: freezed == idOpeningContact
          ? _self.idOpeningContact
          : idOpeningContact // ignore: cast_nullable_to_non_nullable
              as String?,
      idClosingContact: freezed == idClosingContact
          ? _self.idClosingContact
          : idClosingContact // ignore: cast_nullable_to_non_nullable
              as String?,
      idService: freezed == idService
          ? _self.idService
          : idService // ignore: cast_nullable_to_non_nullable
              as String?,
      status: null == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int,
      laterality: freezed == laterality
          ? _self.laterality
          : laterality // ignore: cast_nullable_to_non_nullable
              as Laterality?,
      plansOfAction: null == plansOfAction
          ? _self.plansOfAction
          : plansOfAction // ignore: cast_nullable_to_non_nullable
              as List<EncryptedPlanOfAction>,
      episodes: null == episodes
          ? _self.episodes
          : episodes // ignore: cast_nullable_to_non_nullable
              as List<EncryptedEpisode>,
      careTeam: null == careTeam
          ? _self.careTeam
          : careTeam // ignore: cast_nullable_to_non_nullable
              as List<EncryptedCareTeamMember>,
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

  /// Create a copy of EncryptedHealthElement
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

class _EncryptedHealthElement implements EncryptedHealthElement {
  const _EncryptedHealthElement(
      {required this.id,
      final List<Identifier> identifiers = const [],
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
      this.healthElementId = null,
      this.valueDate = null,
      this.openingDate = null,
      this.closingDate = null,
      this.descr = null,
      this.note = null,
      final List<Annotation> notes = const [],
      this.relevant = true,
      this.idOpeningContact = null,
      this.idClosingContact = null,
      this.idService = null,
      this.status = 0,
      this.laterality = null,
      final List<EncryptedPlanOfAction> plansOfAction = const [],
      final List<EncryptedEpisode> episodes = const [],
      final List<EncryptedCareTeamMember> careTeam = const [],
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null})
      : _identifiers = identifiers,
        _tags = tags,
        _codes = codes,
        _notes = notes,
        _plansOfAction = plansOfAction,
        _episodes = episodes,
        _careTeam = careTeam,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys;

  @override
  final String id;
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
  final String? healthElementId;
  @override
  @JsonKey()
  final int? valueDate;
  @override
  @JsonKey()
  final int? openingDate;
  @override
  @JsonKey()
  final int? closingDate;
  @override
  @JsonKey()
  final String? descr;
  @override
  @JsonKey()
  final String? note;
  final List<Annotation> _notes;
  @override
  @JsonKey()
  List<Annotation> get notes {
    if (_notes is EqualUnmodifiableListView) return _notes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_notes);
  }

  @override
  @JsonKey()
  final bool relevant;
  @override
  @JsonKey()
  final String? idOpeningContact;
  @override
  @JsonKey()
  final String? idClosingContact;
  @override
  @JsonKey()
  final String? idService;
  @override
  @JsonKey()
  final int status;
  @override
  @JsonKey()
  final Laterality? laterality;
  final List<EncryptedPlanOfAction> _plansOfAction;
  @override
  @JsonKey()
  List<EncryptedPlanOfAction> get plansOfAction {
    if (_plansOfAction is EqualUnmodifiableListView) return _plansOfAction;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_plansOfAction);
  }

  final List<EncryptedEpisode> _episodes;
  @override
  @JsonKey()
  List<EncryptedEpisode> get episodes {
    if (_episodes is EqualUnmodifiableListView) return _episodes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_episodes);
  }

  final List<EncryptedCareTeamMember> _careTeam;
  @override
  @JsonKey()
  List<EncryptedCareTeamMember> get careTeam {
    if (_careTeam is EqualUnmodifiableListView) return _careTeam;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_careTeam);
  }

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

  /// Create a copy of EncryptedHealthElement
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedHealthElementCopyWith<_EncryptedHealthElement> get copyWith =>
      __$EncryptedHealthElementCopyWithImpl<_EncryptedHealthElement>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedHealthElement &&
            (identical(other.id, id) || other.id == id) &&
            const DeepCollectionEquality()
                .equals(other._identifiers, _identifiers) &&
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
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.valueDate, valueDate) ||
                other.valueDate == valueDate) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.note, note) || other.note == note) &&
            const DeepCollectionEquality().equals(other._notes, _notes) &&
            (identical(other.relevant, relevant) ||
                other.relevant == relevant) &&
            (identical(other.idOpeningContact, idOpeningContact) ||
                other.idOpeningContact == idOpeningContact) &&
            (identical(other.idClosingContact, idClosingContact) ||
                other.idClosingContact == idClosingContact) &&
            (identical(other.idService, idService) ||
                other.idService == idService) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.laterality, laterality) ||
                other.laterality == laterality) &&
            const DeepCollectionEquality()
                .equals(other._plansOfAction, _plansOfAction) &&
            const DeepCollectionEquality().equals(other._episodes, _episodes) &&
            const DeepCollectionEquality().equals(other._careTeam, _careTeam) &&
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
        const DeepCollectionEquality().hash(_identifiers),
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
        healthElementId,
        valueDate,
        openingDate,
        closingDate,
        descr,
        note,
        const DeepCollectionEquality().hash(_notes),
        relevant,
        idOpeningContact,
        idClosingContact,
        idService,
        status,
        laterality,
        const DeepCollectionEquality().hash(_plansOfAction),
        const DeepCollectionEquality().hash(_episodes),
        const DeepCollectionEquality().hash(_careTeam),
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'EncryptedHealthElement(id: $id, identifiers: $identifiers, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, healthElementId: $healthElementId, valueDate: $valueDate, openingDate: $openingDate, closingDate: $closingDate, descr: $descr, note: $note, notes: $notes, relevant: $relevant, idOpeningContact: $idOpeningContact, idClosingContact: $idClosingContact, idService: $idService, status: $status, laterality: $laterality, plansOfAction: $plansOfAction, episodes: $episodes, careTeam: $careTeam, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedHealthElementCopyWith<$Res>
    implements $EncryptedHealthElementCopyWith<$Res> {
  factory _$EncryptedHealthElementCopyWith(_EncryptedHealthElement value,
          $Res Function(_EncryptedHealthElement) _then) =
      __$EncryptedHealthElementCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      List<Identifier> identifiers,
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
      String? healthElementId,
      int? valueDate,
      int? openingDate,
      int? closingDate,
      String? descr,
      String? note,
      List<Annotation> notes,
      bool relevant,
      String? idOpeningContact,
      String? idClosingContact,
      String? idService,
      int status,
      Laterality? laterality,
      List<EncryptedPlanOfAction> plansOfAction,
      List<EncryptedEpisode> episodes,
      List<EncryptedCareTeamMember> careTeam,
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
class __$EncryptedHealthElementCopyWithImpl<$Res>
    implements _$EncryptedHealthElementCopyWith<$Res> {
  __$EncryptedHealthElementCopyWithImpl(this._self, this._then);

  final _EncryptedHealthElement _self;
  final $Res Function(_EncryptedHealthElement) _then;

  /// Create a copy of EncryptedHealthElement
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? identifiers = null,
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
    Object? healthElementId = freezed,
    Object? valueDate = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? descr = freezed,
    Object? note = freezed,
    Object? notes = null,
    Object? relevant = null,
    Object? idOpeningContact = freezed,
    Object? idClosingContact = freezed,
    Object? idService = freezed,
    Object? status = null,
    Object? laterality = freezed,
    Object? plansOfAction = null,
    Object? episodes = null,
    Object? careTeam = null,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_EncryptedHealthElement(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      identifiers: null == identifiers
          ? _self._identifiers
          : identifiers // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
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
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      valueDate: freezed == valueDate
          ? _self.valueDate
          : valueDate // ignore: cast_nullable_to_non_nullable
              as int?,
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      closingDate: freezed == closingDate
          ? _self.closingDate
          : closingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      notes: null == notes
          ? _self._notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      relevant: null == relevant
          ? _self.relevant
          : relevant // ignore: cast_nullable_to_non_nullable
              as bool,
      idOpeningContact: freezed == idOpeningContact
          ? _self.idOpeningContact
          : idOpeningContact // ignore: cast_nullable_to_non_nullable
              as String?,
      idClosingContact: freezed == idClosingContact
          ? _self.idClosingContact
          : idClosingContact // ignore: cast_nullable_to_non_nullable
              as String?,
      idService: freezed == idService
          ? _self.idService
          : idService // ignore: cast_nullable_to_non_nullable
              as String?,
      status: null == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int,
      laterality: freezed == laterality
          ? _self.laterality
          : laterality // ignore: cast_nullable_to_non_nullable
              as Laterality?,
      plansOfAction: null == plansOfAction
          ? _self._plansOfAction
          : plansOfAction // ignore: cast_nullable_to_non_nullable
              as List<EncryptedPlanOfAction>,
      episodes: null == episodes
          ? _self._episodes
          : episodes // ignore: cast_nullable_to_non_nullable
              as List<EncryptedEpisode>,
      careTeam: null == careTeam
          ? _self._careTeam
          : careTeam // ignore: cast_nullable_to_non_nullable
              as List<EncryptedCareTeamMember>,
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

  /// Create a copy of EncryptedHealthElement
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
mixin _$DecryptedHealthElement {
  String get id;
  List<Identifier> get identifiers;
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
  String? get healthElementId;
  int? get valueDate;
  int? get openingDate;
  int? get closingDate;
  String? get descr;
  String? get note;
  List<Annotation> get notes;
  bool get relevant;
  String? get idOpeningContact;
  String? get idClosingContact;
  String? get idService;
  int get status;
  Laterality? get laterality;
  List<DecryptedPlanOfAction> get plansOfAction;
  List<DecryptedEpisode> get episodes;
  List<DecryptedCareTeamMember> get careTeam;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;

  /// Create a copy of DecryptedHealthElement
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedHealthElementCopyWith<DecryptedHealthElement> get copyWith =>
      _$DecryptedHealthElementCopyWithImpl<DecryptedHealthElement>(
          this as DecryptedHealthElement, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedHealthElement &&
            (identical(other.id, id) || other.id == id) &&
            const DeepCollectionEquality()
                .equals(other.identifiers, identifiers) &&
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
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.valueDate, valueDate) ||
                other.valueDate == valueDate) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.note, note) || other.note == note) &&
            const DeepCollectionEquality().equals(other.notes, notes) &&
            (identical(other.relevant, relevant) ||
                other.relevant == relevant) &&
            (identical(other.idOpeningContact, idOpeningContact) ||
                other.idOpeningContact == idOpeningContact) &&
            (identical(other.idClosingContact, idClosingContact) ||
                other.idClosingContact == idClosingContact) &&
            (identical(other.idService, idService) ||
                other.idService == idService) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.laterality, laterality) ||
                other.laterality == laterality) &&
            const DeepCollectionEquality()
                .equals(other.plansOfAction, plansOfAction) &&
            const DeepCollectionEquality().equals(other.episodes, episodes) &&
            const DeepCollectionEquality().equals(other.careTeam, careTeam) &&
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
        const DeepCollectionEquality().hash(identifiers),
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
        healthElementId,
        valueDate,
        openingDate,
        closingDate,
        descr,
        note,
        const DeepCollectionEquality().hash(notes),
        relevant,
        idOpeningContact,
        idClosingContact,
        idService,
        status,
        laterality,
        const DeepCollectionEquality().hash(plansOfAction),
        const DeepCollectionEquality().hash(episodes),
        const DeepCollectionEquality().hash(careTeam),
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'DecryptedHealthElement(id: $id, identifiers: $identifiers, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, healthElementId: $healthElementId, valueDate: $valueDate, openingDate: $openingDate, closingDate: $closingDate, descr: $descr, note: $note, notes: $notes, relevant: $relevant, idOpeningContact: $idOpeningContact, idClosingContact: $idClosingContact, idService: $idService, status: $status, laterality: $laterality, plansOfAction: $plansOfAction, episodes: $episodes, careTeam: $careTeam, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class $DecryptedHealthElementCopyWith<$Res> {
  factory $DecryptedHealthElementCopyWith(DecryptedHealthElement value,
          $Res Function(DecryptedHealthElement) _then) =
      _$DecryptedHealthElementCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      List<Identifier> identifiers,
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
      String? healthElementId,
      int? valueDate,
      int? openingDate,
      int? closingDate,
      String? descr,
      String? note,
      List<Annotation> notes,
      bool relevant,
      String? idOpeningContact,
      String? idClosingContact,
      String? idService,
      int status,
      Laterality? laterality,
      List<DecryptedPlanOfAction> plansOfAction,
      List<DecryptedEpisode> episodes,
      List<DecryptedCareTeamMember> careTeam,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$DecryptedHealthElementCopyWithImpl<$Res>
    implements $DecryptedHealthElementCopyWith<$Res> {
  _$DecryptedHealthElementCopyWithImpl(this._self, this._then);

  final DecryptedHealthElement _self;
  final $Res Function(DecryptedHealthElement) _then;

  /// Create a copy of DecryptedHealthElement
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? identifiers = null,
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
    Object? healthElementId = freezed,
    Object? valueDate = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? descr = freezed,
    Object? note = freezed,
    Object? notes = null,
    Object? relevant = null,
    Object? idOpeningContact = freezed,
    Object? idClosingContact = freezed,
    Object? idService = freezed,
    Object? status = null,
    Object? laterality = freezed,
    Object? plansOfAction = null,
    Object? episodes = null,
    Object? careTeam = null,
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
      identifiers: null == identifiers
          ? _self.identifiers
          : identifiers // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
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
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      valueDate: freezed == valueDate
          ? _self.valueDate
          : valueDate // ignore: cast_nullable_to_non_nullable
              as int?,
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      closingDate: freezed == closingDate
          ? _self.closingDate
          : closingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      notes: null == notes
          ? _self.notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      relevant: null == relevant
          ? _self.relevant
          : relevant // ignore: cast_nullable_to_non_nullable
              as bool,
      idOpeningContact: freezed == idOpeningContact
          ? _self.idOpeningContact
          : idOpeningContact // ignore: cast_nullable_to_non_nullable
              as String?,
      idClosingContact: freezed == idClosingContact
          ? _self.idClosingContact
          : idClosingContact // ignore: cast_nullable_to_non_nullable
              as String?,
      idService: freezed == idService
          ? _self.idService
          : idService // ignore: cast_nullable_to_non_nullable
              as String?,
      status: null == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int,
      laterality: freezed == laterality
          ? _self.laterality
          : laterality // ignore: cast_nullable_to_non_nullable
              as Laterality?,
      plansOfAction: null == plansOfAction
          ? _self.plansOfAction
          : plansOfAction // ignore: cast_nullable_to_non_nullable
              as List<DecryptedPlanOfAction>,
      episodes: null == episodes
          ? _self.episodes
          : episodes // ignore: cast_nullable_to_non_nullable
              as List<DecryptedEpisode>,
      careTeam: null == careTeam
          ? _self.careTeam
          : careTeam // ignore: cast_nullable_to_non_nullable
              as List<DecryptedCareTeamMember>,
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

  /// Create a copy of DecryptedHealthElement
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

class _DecryptedHealthElement implements DecryptedHealthElement {
  const _DecryptedHealthElement(
      {required this.id,
      final List<Identifier> identifiers = const [],
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
      this.healthElementId = null,
      this.valueDate = null,
      this.openingDate = null,
      this.closingDate = null,
      this.descr = null,
      this.note = null,
      final List<Annotation> notes = const [],
      this.relevant = true,
      this.idOpeningContact = null,
      this.idClosingContact = null,
      this.idService = null,
      this.status = 0,
      this.laterality = null,
      final List<DecryptedPlanOfAction> plansOfAction = const [],
      final List<DecryptedEpisode> episodes = const [],
      final List<DecryptedCareTeamMember> careTeam = const [],
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null})
      : _identifiers = identifiers,
        _tags = tags,
        _codes = codes,
        _notes = notes,
        _plansOfAction = plansOfAction,
        _episodes = episodes,
        _careTeam = careTeam,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys;

  @override
  final String id;
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
  final String? healthElementId;
  @override
  @JsonKey()
  final int? valueDate;
  @override
  @JsonKey()
  final int? openingDate;
  @override
  @JsonKey()
  final int? closingDate;
  @override
  @JsonKey()
  final String? descr;
  @override
  @JsonKey()
  final String? note;
  final List<Annotation> _notes;
  @override
  @JsonKey()
  List<Annotation> get notes {
    if (_notes is EqualUnmodifiableListView) return _notes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_notes);
  }

  @override
  @JsonKey()
  final bool relevant;
  @override
  @JsonKey()
  final String? idOpeningContact;
  @override
  @JsonKey()
  final String? idClosingContact;
  @override
  @JsonKey()
  final String? idService;
  @override
  @JsonKey()
  final int status;
  @override
  @JsonKey()
  final Laterality? laterality;
  final List<DecryptedPlanOfAction> _plansOfAction;
  @override
  @JsonKey()
  List<DecryptedPlanOfAction> get plansOfAction {
    if (_plansOfAction is EqualUnmodifiableListView) return _plansOfAction;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_plansOfAction);
  }

  final List<DecryptedEpisode> _episodes;
  @override
  @JsonKey()
  List<DecryptedEpisode> get episodes {
    if (_episodes is EqualUnmodifiableListView) return _episodes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_episodes);
  }

  final List<DecryptedCareTeamMember> _careTeam;
  @override
  @JsonKey()
  List<DecryptedCareTeamMember> get careTeam {
    if (_careTeam is EqualUnmodifiableListView) return _careTeam;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_careTeam);
  }

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

  /// Create a copy of DecryptedHealthElement
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedHealthElementCopyWith<_DecryptedHealthElement> get copyWith =>
      __$DecryptedHealthElementCopyWithImpl<_DecryptedHealthElement>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedHealthElement &&
            (identical(other.id, id) || other.id == id) &&
            const DeepCollectionEquality()
                .equals(other._identifiers, _identifiers) &&
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
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.valueDate, valueDate) ||
                other.valueDate == valueDate) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.note, note) || other.note == note) &&
            const DeepCollectionEquality().equals(other._notes, _notes) &&
            (identical(other.relevant, relevant) ||
                other.relevant == relevant) &&
            (identical(other.idOpeningContact, idOpeningContact) ||
                other.idOpeningContact == idOpeningContact) &&
            (identical(other.idClosingContact, idClosingContact) ||
                other.idClosingContact == idClosingContact) &&
            (identical(other.idService, idService) ||
                other.idService == idService) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.laterality, laterality) ||
                other.laterality == laterality) &&
            const DeepCollectionEquality()
                .equals(other._plansOfAction, _plansOfAction) &&
            const DeepCollectionEquality().equals(other._episodes, _episodes) &&
            const DeepCollectionEquality().equals(other._careTeam, _careTeam) &&
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
        const DeepCollectionEquality().hash(_identifiers),
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
        healthElementId,
        valueDate,
        openingDate,
        closingDate,
        descr,
        note,
        const DeepCollectionEquality().hash(_notes),
        relevant,
        idOpeningContact,
        idClosingContact,
        idService,
        status,
        laterality,
        const DeepCollectionEquality().hash(_plansOfAction),
        const DeepCollectionEquality().hash(_episodes),
        const DeepCollectionEquality().hash(_careTeam),
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'DecryptedHealthElement(id: $id, identifiers: $identifiers, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, healthElementId: $healthElementId, valueDate: $valueDate, openingDate: $openingDate, closingDate: $closingDate, descr: $descr, note: $note, notes: $notes, relevant: $relevant, idOpeningContact: $idOpeningContact, idClosingContact: $idClosingContact, idService: $idService, status: $status, laterality: $laterality, plansOfAction: $plansOfAction, episodes: $episodes, careTeam: $careTeam, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedHealthElementCopyWith<$Res>
    implements $DecryptedHealthElementCopyWith<$Res> {
  factory _$DecryptedHealthElementCopyWith(_DecryptedHealthElement value,
          $Res Function(_DecryptedHealthElement) _then) =
      __$DecryptedHealthElementCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      List<Identifier> identifiers,
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
      String? healthElementId,
      int? valueDate,
      int? openingDate,
      int? closingDate,
      String? descr,
      String? note,
      List<Annotation> notes,
      bool relevant,
      String? idOpeningContact,
      String? idClosingContact,
      String? idService,
      int status,
      Laterality? laterality,
      List<DecryptedPlanOfAction> plansOfAction,
      List<DecryptedEpisode> episodes,
      List<DecryptedCareTeamMember> careTeam,
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
class __$DecryptedHealthElementCopyWithImpl<$Res>
    implements _$DecryptedHealthElementCopyWith<$Res> {
  __$DecryptedHealthElementCopyWithImpl(this._self, this._then);

  final _DecryptedHealthElement _self;
  final $Res Function(_DecryptedHealthElement) _then;

  /// Create a copy of DecryptedHealthElement
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? identifiers = null,
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
    Object? healthElementId = freezed,
    Object? valueDate = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? descr = freezed,
    Object? note = freezed,
    Object? notes = null,
    Object? relevant = null,
    Object? idOpeningContact = freezed,
    Object? idClosingContact = freezed,
    Object? idService = freezed,
    Object? status = null,
    Object? laterality = freezed,
    Object? plansOfAction = null,
    Object? episodes = null,
    Object? careTeam = null,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_DecryptedHealthElement(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      identifiers: null == identifiers
          ? _self._identifiers
          : identifiers // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
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
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      valueDate: freezed == valueDate
          ? _self.valueDate
          : valueDate // ignore: cast_nullable_to_non_nullable
              as int?,
      openingDate: freezed == openingDate
          ? _self.openingDate
          : openingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      closingDate: freezed == closingDate
          ? _self.closingDate
          : closingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      notes: null == notes
          ? _self._notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      relevant: null == relevant
          ? _self.relevant
          : relevant // ignore: cast_nullable_to_non_nullable
              as bool,
      idOpeningContact: freezed == idOpeningContact
          ? _self.idOpeningContact
          : idOpeningContact // ignore: cast_nullable_to_non_nullable
              as String?,
      idClosingContact: freezed == idClosingContact
          ? _self.idClosingContact
          : idClosingContact // ignore: cast_nullable_to_non_nullable
              as String?,
      idService: freezed == idService
          ? _self.idService
          : idService // ignore: cast_nullable_to_non_nullable
              as String?,
      status: null == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int,
      laterality: freezed == laterality
          ? _self.laterality
          : laterality // ignore: cast_nullable_to_non_nullable
              as Laterality?,
      plansOfAction: null == plansOfAction
          ? _self._plansOfAction
          : plansOfAction // ignore: cast_nullable_to_non_nullable
              as List<DecryptedPlanOfAction>,
      episodes: null == episodes
          ? _self._episodes
          : episodes // ignore: cast_nullable_to_non_nullable
              as List<DecryptedEpisode>,
      careTeam: null == careTeam
          ? _self._careTeam
          : careTeam // ignore: cast_nullable_to_non_nullable
              as List<DecryptedCareTeamMember>,
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

  /// Create a copy of DecryptedHealthElement
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
