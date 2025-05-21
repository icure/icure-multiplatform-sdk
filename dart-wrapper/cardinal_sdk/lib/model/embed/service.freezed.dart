// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'service.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DecryptedService {
  String get id;
  String? get transactionId;
  List<Identifier> get identifier;
  String? get contactId;
  Set<String>? get subContactIds;
  Set<String>? get plansOfActionIds;
  Set<String>? get healthElementsIds;
  Set<String>? get formIds;
  Set<String>? get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  String? get label;
  int? get index;
  Map<String, DecryptedContent> get content;
  String? get encryptedContent;
  Map<String, String> get textIndexes;
  int? get valueDate;
  int? get openingDate;
  int? get closingDate;
  String? get formId;
  int? get created;
  int? get modified;
  int? get endOfLife;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  String? get comment;
  int? get status;
  Set<String> get invoicingCodes;
  List<Annotation> get notes;
  Map<LinkQualification, Map<String, String>> get qualifiedLinks;
  Set<CodeStub> get codes;
  Set<CodeStub> get tags;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;

  /// Create a copy of DecryptedService
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedServiceCopyWith<DecryptedService> get copyWith =>
      _$DecryptedServiceCopyWithImpl<DecryptedService>(
          this as DecryptedService, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedService &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.transactionId, transactionId) ||
                other.transactionId == transactionId) &&
            const DeepCollectionEquality()
                .equals(other.identifier, identifier) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            const DeepCollectionEquality()
                .equals(other.subContactIds, subContactIds) &&
            const DeepCollectionEquality()
                .equals(other.plansOfActionIds, plansOfActionIds) &&
            const DeepCollectionEquality()
                .equals(other.healthElementsIds, healthElementsIds) &&
            const DeepCollectionEquality().equals(other.formIds, formIds) &&
            const DeepCollectionEquality()
                .equals(other.secretForeignKeys, secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.cryptedForeignKeys, cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.delegations, delegations) &&
            const DeepCollectionEquality()
                .equals(other.encryptionKeys, encryptionKeys) &&
            (identical(other.label, label) || other.label == label) &&
            (identical(other.index, index) || other.index == index) &&
            const DeepCollectionEquality().equals(other.content, content) &&
            (identical(other.encryptedContent, encryptedContent) ||
                other.encryptedContent == encryptedContent) &&
            const DeepCollectionEquality()
                .equals(other.textIndexes, textIndexes) &&
            (identical(other.valueDate, valueDate) ||
                other.valueDate == valueDate) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.formId, formId) || other.formId == formId) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.status, status) || other.status == status) &&
            const DeepCollectionEquality()
                .equals(other.invoicingCodes, invoicingCodes) &&
            const DeepCollectionEquality().equals(other.notes, notes) &&
            const DeepCollectionEquality()
                .equals(other.qualifiedLinks, qualifiedLinks) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        transactionId,
        const DeepCollectionEquality().hash(identifier),
        contactId,
        const DeepCollectionEquality().hash(subContactIds),
        const DeepCollectionEquality().hash(plansOfActionIds),
        const DeepCollectionEquality().hash(healthElementsIds),
        const DeepCollectionEquality().hash(formIds),
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        label,
        index,
        const DeepCollectionEquality().hash(content),
        encryptedContent,
        const DeepCollectionEquality().hash(textIndexes),
        valueDate,
        openingDate,
        closingDate,
        formId,
        created,
        modified,
        endOfLife,
        author,
        responsible,
        medicalLocationId,
        comment,
        status,
        const DeepCollectionEquality().hash(invoicingCodes),
        const DeepCollectionEquality().hash(notes),
        const DeepCollectionEquality().hash(qualifiedLinks),
        const DeepCollectionEquality().hash(codes),
        const DeepCollectionEquality().hash(tags),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'DecryptedService(id: $id, transactionId: $transactionId, identifier: $identifier, contactId: $contactId, subContactIds: $subContactIds, plansOfActionIds: $plansOfActionIds, healthElementsIds: $healthElementsIds, formIds: $formIds, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, label: $label, index: $index, content: $content, encryptedContent: $encryptedContent, textIndexes: $textIndexes, valueDate: $valueDate, openingDate: $openingDate, closingDate: $closingDate, formId: $formId, created: $created, modified: $modified, endOfLife: $endOfLife, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, comment: $comment, status: $status, invoicingCodes: $invoicingCodes, notes: $notes, qualifiedLinks: $qualifiedLinks, codes: $codes, tags: $tags, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class $DecryptedServiceCopyWith<$Res> {
  factory $DecryptedServiceCopyWith(
          DecryptedService value, $Res Function(DecryptedService) _then) =
      _$DecryptedServiceCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? transactionId,
      List<Identifier> identifier,
      String? contactId,
      Set<String>? subContactIds,
      Set<String>? plansOfActionIds,
      Set<String>? healthElementsIds,
      Set<String>? formIds,
      Set<String>? secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      String? label,
      int? index,
      Map<String, DecryptedContent> content,
      String? encryptedContent,
      Map<String, String> textIndexes,
      int? valueDate,
      int? openingDate,
      int? closingDate,
      String? formId,
      int? created,
      int? modified,
      int? endOfLife,
      String? author,
      String? responsible,
      String? medicalLocationId,
      String? comment,
      int? status,
      Set<String> invoicingCodes,
      List<Annotation> notes,
      Map<LinkQualification, Map<String, String>> qualifiedLinks,
      Set<CodeStub> codes,
      Set<CodeStub> tags,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$DecryptedServiceCopyWithImpl<$Res>
    implements $DecryptedServiceCopyWith<$Res> {
  _$DecryptedServiceCopyWithImpl(this._self, this._then);

  final DecryptedService _self;
  final $Res Function(DecryptedService) _then;

  /// Create a copy of DecryptedService
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? transactionId = freezed,
    Object? identifier = null,
    Object? contactId = freezed,
    Object? subContactIds = freezed,
    Object? plansOfActionIds = freezed,
    Object? healthElementsIds = freezed,
    Object? formIds = freezed,
    Object? secretForeignKeys = freezed,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? label = freezed,
    Object? index = freezed,
    Object? content = null,
    Object? encryptedContent = freezed,
    Object? textIndexes = null,
    Object? valueDate = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? formId = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? endOfLife = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? comment = freezed,
    Object? status = freezed,
    Object? invoicingCodes = null,
    Object? notes = null,
    Object? qualifiedLinks = null,
    Object? codes = null,
    Object? tags = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      transactionId: freezed == transactionId
          ? _self.transactionId
          : transactionId // ignore: cast_nullable_to_non_nullable
              as String?,
      identifier: null == identifier
          ? _self.identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      subContactIds: freezed == subContactIds
          ? _self.subContactIds
          : subContactIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      plansOfActionIds: freezed == plansOfActionIds
          ? _self.plansOfActionIds
          : plansOfActionIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      healthElementsIds: freezed == healthElementsIds
          ? _self.healthElementsIds
          : healthElementsIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      formIds: freezed == formIds
          ? _self.formIds
          : formIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      secretForeignKeys: freezed == secretForeignKeys
          ? _self.secretForeignKeys
          : secretForeignKeys // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
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
      label: freezed == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as String?,
      index: freezed == index
          ? _self.index
          : index // ignore: cast_nullable_to_non_nullable
              as int?,
      content: null == content
          ? _self.content
          : content // ignore: cast_nullable_to_non_nullable
              as Map<String, DecryptedContent>,
      encryptedContent: freezed == encryptedContent
          ? _self.encryptedContent
          : encryptedContent // ignore: cast_nullable_to_non_nullable
              as String?,
      textIndexes: null == textIndexes
          ? _self.textIndexes
          : textIndexes // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
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
      formId: freezed == formId
          ? _self.formId
          : formId // ignore: cast_nullable_to_non_nullable
              as String?,
      created: freezed == created
          ? _self.created
          : created // ignore: cast_nullable_to_non_nullable
              as int?,
      modified: freezed == modified
          ? _self.modified
          : modified // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
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
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      invoicingCodes: null == invoicingCodes
          ? _self.invoicingCodes
          : invoicingCodes // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      notes: null == notes
          ? _self.notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      qualifiedLinks: null == qualifiedLinks
          ? _self.qualifiedLinks
          : qualifiedLinks // ignore: cast_nullable_to_non_nullable
              as Map<LinkQualification, Map<String, String>>,
      codes: null == codes
          ? _self.codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
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

  /// Create a copy of DecryptedService
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

class _DecryptedService implements DecryptedService {
  const _DecryptedService(
      {required this.id,
      this.transactionId = null,
      final List<Identifier> identifier = const [],
      this.contactId = null,
      final Set<String>? subContactIds = null,
      final Set<String>? plansOfActionIds = null,
      final Set<String>? healthElementsIds = null,
      final Set<String>? formIds = null,
      final Set<String>? secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.label = null,
      this.index = null,
      final Map<String, DecryptedContent> content = const {},
      this.encryptedContent = null,
      final Map<String, String> textIndexes = const {},
      this.valueDate = null,
      this.openingDate = null,
      this.closingDate = null,
      this.formId = null,
      this.created = null,
      this.modified = null,
      this.endOfLife = null,
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      this.comment = null,
      this.status = null,
      final Set<String> invoicingCodes = const {},
      final List<Annotation> notes = const [],
      final Map<LinkQualification, Map<String, String>> qualifiedLinks =
          const {},
      final Set<CodeStub> codes = const {},
      final Set<CodeStub> tags = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null})
      : _identifier = identifier,
        _subContactIds = subContactIds,
        _plansOfActionIds = plansOfActionIds,
        _healthElementsIds = healthElementsIds,
        _formIds = formIds,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys,
        _content = content,
        _textIndexes = textIndexes,
        _invoicingCodes = invoicingCodes,
        _notes = notes,
        _qualifiedLinks = qualifiedLinks,
        _codes = codes,
        _tags = tags;

  @override
  final String id;
  @override
  @JsonKey()
  final String? transactionId;
  final List<Identifier> _identifier;
  @override
  @JsonKey()
  List<Identifier> get identifier {
    if (_identifier is EqualUnmodifiableListView) return _identifier;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_identifier);
  }

  @override
  @JsonKey()
  final String? contactId;
  final Set<String>? _subContactIds;
  @override
  @JsonKey()
  Set<String>? get subContactIds {
    final value = _subContactIds;
    if (value == null) return null;
    if (_subContactIds is EqualUnmodifiableSetView) return _subContactIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  final Set<String>? _plansOfActionIds;
  @override
  @JsonKey()
  Set<String>? get plansOfActionIds {
    final value = _plansOfActionIds;
    if (value == null) return null;
    if (_plansOfActionIds is EqualUnmodifiableSetView) return _plansOfActionIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  final Set<String>? _healthElementsIds;
  @override
  @JsonKey()
  Set<String>? get healthElementsIds {
    final value = _healthElementsIds;
    if (value == null) return null;
    if (_healthElementsIds is EqualUnmodifiableSetView)
      return _healthElementsIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  final Set<String>? _formIds;
  @override
  @JsonKey()
  Set<String>? get formIds {
    final value = _formIds;
    if (value == null) return null;
    if (_formIds is EqualUnmodifiableSetView) return _formIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  final Set<String>? _secretForeignKeys;
  @override
  @JsonKey()
  Set<String>? get secretForeignKeys {
    final value = _secretForeignKeys;
    if (value == null) return null;
    if (_secretForeignKeys is EqualUnmodifiableSetView)
      return _secretForeignKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
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
  final String? label;
  @override
  @JsonKey()
  final int? index;
  final Map<String, DecryptedContent> _content;
  @override
  @JsonKey()
  Map<String, DecryptedContent> get content {
    if (_content is EqualUnmodifiableMapView) return _content;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_content);
  }

  @override
  @JsonKey()
  final String? encryptedContent;
  final Map<String, String> _textIndexes;
  @override
  @JsonKey()
  Map<String, String> get textIndexes {
    if (_textIndexes is EqualUnmodifiableMapView) return _textIndexes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_textIndexes);
  }

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
  final String? formId;
  @override
  @JsonKey()
  final int? created;
  @override
  @JsonKey()
  final int? modified;
  @override
  @JsonKey()
  final int? endOfLife;
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
  final String? comment;
  @override
  @JsonKey()
  final int? status;
  final Set<String> _invoicingCodes;
  @override
  @JsonKey()
  Set<String> get invoicingCodes {
    if (_invoicingCodes is EqualUnmodifiableSetView) return _invoicingCodes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_invoicingCodes);
  }

  final List<Annotation> _notes;
  @override
  @JsonKey()
  List<Annotation> get notes {
    if (_notes is EqualUnmodifiableListView) return _notes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_notes);
  }

  final Map<LinkQualification, Map<String, String>> _qualifiedLinks;
  @override
  @JsonKey()
  Map<LinkQualification, Map<String, String>> get qualifiedLinks {
    if (_qualifiedLinks is EqualUnmodifiableMapView) return _qualifiedLinks;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_qualifiedLinks);
  }

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
  final Base64String? encryptedSelf;
  @override
  @JsonKey()
  final SecurityMetadata? securityMetadata;

  /// Create a copy of DecryptedService
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedServiceCopyWith<_DecryptedService> get copyWith =>
      __$DecryptedServiceCopyWithImpl<_DecryptedService>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedService &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.transactionId, transactionId) ||
                other.transactionId == transactionId) &&
            const DeepCollectionEquality()
                .equals(other._identifier, _identifier) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            const DeepCollectionEquality()
                .equals(other._subContactIds, _subContactIds) &&
            const DeepCollectionEquality()
                .equals(other._plansOfActionIds, _plansOfActionIds) &&
            const DeepCollectionEquality()
                .equals(other._healthElementsIds, _healthElementsIds) &&
            const DeepCollectionEquality().equals(other._formIds, _formIds) &&
            const DeepCollectionEquality()
                .equals(other._secretForeignKeys, _secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._cryptedForeignKeys, _cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._delegations, _delegations) &&
            const DeepCollectionEquality()
                .equals(other._encryptionKeys, _encryptionKeys) &&
            (identical(other.label, label) || other.label == label) &&
            (identical(other.index, index) || other.index == index) &&
            const DeepCollectionEquality().equals(other._content, _content) &&
            (identical(other.encryptedContent, encryptedContent) ||
                other.encryptedContent == encryptedContent) &&
            const DeepCollectionEquality()
                .equals(other._textIndexes, _textIndexes) &&
            (identical(other.valueDate, valueDate) ||
                other.valueDate == valueDate) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.formId, formId) || other.formId == formId) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.status, status) || other.status == status) &&
            const DeepCollectionEquality()
                .equals(other._invoicingCodes, _invoicingCodes) &&
            const DeepCollectionEquality().equals(other._notes, _notes) &&
            const DeepCollectionEquality()
                .equals(other._qualifiedLinks, _qualifiedLinks) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        transactionId,
        const DeepCollectionEquality().hash(_identifier),
        contactId,
        const DeepCollectionEquality().hash(_subContactIds),
        const DeepCollectionEquality().hash(_plansOfActionIds),
        const DeepCollectionEquality().hash(_healthElementsIds),
        const DeepCollectionEquality().hash(_formIds),
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        label,
        index,
        const DeepCollectionEquality().hash(_content),
        encryptedContent,
        const DeepCollectionEquality().hash(_textIndexes),
        valueDate,
        openingDate,
        closingDate,
        formId,
        created,
        modified,
        endOfLife,
        author,
        responsible,
        medicalLocationId,
        comment,
        status,
        const DeepCollectionEquality().hash(_invoicingCodes),
        const DeepCollectionEquality().hash(_notes),
        const DeepCollectionEquality().hash(_qualifiedLinks),
        const DeepCollectionEquality().hash(_codes),
        const DeepCollectionEquality().hash(_tags),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'DecryptedService(id: $id, transactionId: $transactionId, identifier: $identifier, contactId: $contactId, subContactIds: $subContactIds, plansOfActionIds: $plansOfActionIds, healthElementsIds: $healthElementsIds, formIds: $formIds, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, label: $label, index: $index, content: $content, encryptedContent: $encryptedContent, textIndexes: $textIndexes, valueDate: $valueDate, openingDate: $openingDate, closingDate: $closingDate, formId: $formId, created: $created, modified: $modified, endOfLife: $endOfLife, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, comment: $comment, status: $status, invoicingCodes: $invoicingCodes, notes: $notes, qualifiedLinks: $qualifiedLinks, codes: $codes, tags: $tags, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedServiceCopyWith<$Res>
    implements $DecryptedServiceCopyWith<$Res> {
  factory _$DecryptedServiceCopyWith(
          _DecryptedService value, $Res Function(_DecryptedService) _then) =
      __$DecryptedServiceCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? transactionId,
      List<Identifier> identifier,
      String? contactId,
      Set<String>? subContactIds,
      Set<String>? plansOfActionIds,
      Set<String>? healthElementsIds,
      Set<String>? formIds,
      Set<String>? secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      String? label,
      int? index,
      Map<String, DecryptedContent> content,
      String? encryptedContent,
      Map<String, String> textIndexes,
      int? valueDate,
      int? openingDate,
      int? closingDate,
      String? formId,
      int? created,
      int? modified,
      int? endOfLife,
      String? author,
      String? responsible,
      String? medicalLocationId,
      String? comment,
      int? status,
      Set<String> invoicingCodes,
      List<Annotation> notes,
      Map<LinkQualification, Map<String, String>> qualifiedLinks,
      Set<CodeStub> codes,
      Set<CodeStub> tags,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$DecryptedServiceCopyWithImpl<$Res>
    implements _$DecryptedServiceCopyWith<$Res> {
  __$DecryptedServiceCopyWithImpl(this._self, this._then);

  final _DecryptedService _self;
  final $Res Function(_DecryptedService) _then;

  /// Create a copy of DecryptedService
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? transactionId = freezed,
    Object? identifier = null,
    Object? contactId = freezed,
    Object? subContactIds = freezed,
    Object? plansOfActionIds = freezed,
    Object? healthElementsIds = freezed,
    Object? formIds = freezed,
    Object? secretForeignKeys = freezed,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? label = freezed,
    Object? index = freezed,
    Object? content = null,
    Object? encryptedContent = freezed,
    Object? textIndexes = null,
    Object? valueDate = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? formId = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? endOfLife = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? comment = freezed,
    Object? status = freezed,
    Object? invoicingCodes = null,
    Object? notes = null,
    Object? qualifiedLinks = null,
    Object? codes = null,
    Object? tags = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_DecryptedService(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      transactionId: freezed == transactionId
          ? _self.transactionId
          : transactionId // ignore: cast_nullable_to_non_nullable
              as String?,
      identifier: null == identifier
          ? _self._identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      subContactIds: freezed == subContactIds
          ? _self._subContactIds
          : subContactIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      plansOfActionIds: freezed == plansOfActionIds
          ? _self._plansOfActionIds
          : plansOfActionIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      healthElementsIds: freezed == healthElementsIds
          ? _self._healthElementsIds
          : healthElementsIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      formIds: freezed == formIds
          ? _self._formIds
          : formIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      secretForeignKeys: freezed == secretForeignKeys
          ? _self._secretForeignKeys
          : secretForeignKeys // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
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
      label: freezed == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as String?,
      index: freezed == index
          ? _self.index
          : index // ignore: cast_nullable_to_non_nullable
              as int?,
      content: null == content
          ? _self._content
          : content // ignore: cast_nullable_to_non_nullable
              as Map<String, DecryptedContent>,
      encryptedContent: freezed == encryptedContent
          ? _self.encryptedContent
          : encryptedContent // ignore: cast_nullable_to_non_nullable
              as String?,
      textIndexes: null == textIndexes
          ? _self._textIndexes
          : textIndexes // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
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
      formId: freezed == formId
          ? _self.formId
          : formId // ignore: cast_nullable_to_non_nullable
              as String?,
      created: freezed == created
          ? _self.created
          : created // ignore: cast_nullable_to_non_nullable
              as int?,
      modified: freezed == modified
          ? _self.modified
          : modified // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
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
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      invoicingCodes: null == invoicingCodes
          ? _self._invoicingCodes
          : invoicingCodes // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      notes: null == notes
          ? _self._notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      qualifiedLinks: null == qualifiedLinks
          ? _self._qualifiedLinks
          : qualifiedLinks // ignore: cast_nullable_to_non_nullable
              as Map<LinkQualification, Map<String, String>>,
      codes: null == codes
          ? _self._codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
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

  /// Create a copy of DecryptedService
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
mixin _$EncryptedService {
  String get id;
  String? get transactionId;
  List<Identifier> get identifier;
  String? get contactId;
  Set<String>? get subContactIds;
  Set<String>? get plansOfActionIds;
  Set<String>? get healthElementsIds;
  Set<String>? get formIds;
  Set<String>? get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  String? get label;
  int? get index;
  Map<String, EncryptedContent> get content;
  String? get encryptedContent;
  Map<String, String> get textIndexes;
  int? get valueDate;
  int? get openingDate;
  int? get closingDate;
  String? get formId;
  int? get created;
  int? get modified;
  int? get endOfLife;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  String? get comment;
  int? get status;
  Set<String> get invoicingCodes;
  List<Annotation> get notes;
  Map<LinkQualification, Map<String, String>> get qualifiedLinks;
  Set<CodeStub> get codes;
  Set<CodeStub> get tags;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;

  /// Create a copy of EncryptedService
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedServiceCopyWith<EncryptedService> get copyWith =>
      _$EncryptedServiceCopyWithImpl<EncryptedService>(
          this as EncryptedService, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedService &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.transactionId, transactionId) ||
                other.transactionId == transactionId) &&
            const DeepCollectionEquality()
                .equals(other.identifier, identifier) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            const DeepCollectionEquality()
                .equals(other.subContactIds, subContactIds) &&
            const DeepCollectionEquality()
                .equals(other.plansOfActionIds, plansOfActionIds) &&
            const DeepCollectionEquality()
                .equals(other.healthElementsIds, healthElementsIds) &&
            const DeepCollectionEquality().equals(other.formIds, formIds) &&
            const DeepCollectionEquality()
                .equals(other.secretForeignKeys, secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.cryptedForeignKeys, cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.delegations, delegations) &&
            const DeepCollectionEquality()
                .equals(other.encryptionKeys, encryptionKeys) &&
            (identical(other.label, label) || other.label == label) &&
            (identical(other.index, index) || other.index == index) &&
            const DeepCollectionEquality().equals(other.content, content) &&
            (identical(other.encryptedContent, encryptedContent) ||
                other.encryptedContent == encryptedContent) &&
            const DeepCollectionEquality()
                .equals(other.textIndexes, textIndexes) &&
            (identical(other.valueDate, valueDate) ||
                other.valueDate == valueDate) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.formId, formId) || other.formId == formId) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.status, status) || other.status == status) &&
            const DeepCollectionEquality()
                .equals(other.invoicingCodes, invoicingCodes) &&
            const DeepCollectionEquality().equals(other.notes, notes) &&
            const DeepCollectionEquality()
                .equals(other.qualifiedLinks, qualifiedLinks) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        transactionId,
        const DeepCollectionEquality().hash(identifier),
        contactId,
        const DeepCollectionEquality().hash(subContactIds),
        const DeepCollectionEquality().hash(plansOfActionIds),
        const DeepCollectionEquality().hash(healthElementsIds),
        const DeepCollectionEquality().hash(formIds),
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        label,
        index,
        const DeepCollectionEquality().hash(content),
        encryptedContent,
        const DeepCollectionEquality().hash(textIndexes),
        valueDate,
        openingDate,
        closingDate,
        formId,
        created,
        modified,
        endOfLife,
        author,
        responsible,
        medicalLocationId,
        comment,
        status,
        const DeepCollectionEquality().hash(invoicingCodes),
        const DeepCollectionEquality().hash(notes),
        const DeepCollectionEquality().hash(qualifiedLinks),
        const DeepCollectionEquality().hash(codes),
        const DeepCollectionEquality().hash(tags),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'EncryptedService(id: $id, transactionId: $transactionId, identifier: $identifier, contactId: $contactId, subContactIds: $subContactIds, plansOfActionIds: $plansOfActionIds, healthElementsIds: $healthElementsIds, formIds: $formIds, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, label: $label, index: $index, content: $content, encryptedContent: $encryptedContent, textIndexes: $textIndexes, valueDate: $valueDate, openingDate: $openingDate, closingDate: $closingDate, formId: $formId, created: $created, modified: $modified, endOfLife: $endOfLife, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, comment: $comment, status: $status, invoicingCodes: $invoicingCodes, notes: $notes, qualifiedLinks: $qualifiedLinks, codes: $codes, tags: $tags, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class $EncryptedServiceCopyWith<$Res> {
  factory $EncryptedServiceCopyWith(
          EncryptedService value, $Res Function(EncryptedService) _then) =
      _$EncryptedServiceCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? transactionId,
      List<Identifier> identifier,
      String? contactId,
      Set<String>? subContactIds,
      Set<String>? plansOfActionIds,
      Set<String>? healthElementsIds,
      Set<String>? formIds,
      Set<String>? secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      String? label,
      int? index,
      Map<String, EncryptedContent> content,
      String? encryptedContent,
      Map<String, String> textIndexes,
      int? valueDate,
      int? openingDate,
      int? closingDate,
      String? formId,
      int? created,
      int? modified,
      int? endOfLife,
      String? author,
      String? responsible,
      String? medicalLocationId,
      String? comment,
      int? status,
      Set<String> invoicingCodes,
      List<Annotation> notes,
      Map<LinkQualification, Map<String, String>> qualifiedLinks,
      Set<CodeStub> codes,
      Set<CodeStub> tags,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$EncryptedServiceCopyWithImpl<$Res>
    implements $EncryptedServiceCopyWith<$Res> {
  _$EncryptedServiceCopyWithImpl(this._self, this._then);

  final EncryptedService _self;
  final $Res Function(EncryptedService) _then;

  /// Create a copy of EncryptedService
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? transactionId = freezed,
    Object? identifier = null,
    Object? contactId = freezed,
    Object? subContactIds = freezed,
    Object? plansOfActionIds = freezed,
    Object? healthElementsIds = freezed,
    Object? formIds = freezed,
    Object? secretForeignKeys = freezed,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? label = freezed,
    Object? index = freezed,
    Object? content = null,
    Object? encryptedContent = freezed,
    Object? textIndexes = null,
    Object? valueDate = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? formId = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? endOfLife = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? comment = freezed,
    Object? status = freezed,
    Object? invoicingCodes = null,
    Object? notes = null,
    Object? qualifiedLinks = null,
    Object? codes = null,
    Object? tags = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      transactionId: freezed == transactionId
          ? _self.transactionId
          : transactionId // ignore: cast_nullable_to_non_nullable
              as String?,
      identifier: null == identifier
          ? _self.identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      subContactIds: freezed == subContactIds
          ? _self.subContactIds
          : subContactIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      plansOfActionIds: freezed == plansOfActionIds
          ? _self.plansOfActionIds
          : plansOfActionIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      healthElementsIds: freezed == healthElementsIds
          ? _self.healthElementsIds
          : healthElementsIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      formIds: freezed == formIds
          ? _self.formIds
          : formIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      secretForeignKeys: freezed == secretForeignKeys
          ? _self.secretForeignKeys
          : secretForeignKeys // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
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
      label: freezed == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as String?,
      index: freezed == index
          ? _self.index
          : index // ignore: cast_nullable_to_non_nullable
              as int?,
      content: null == content
          ? _self.content
          : content // ignore: cast_nullable_to_non_nullable
              as Map<String, EncryptedContent>,
      encryptedContent: freezed == encryptedContent
          ? _self.encryptedContent
          : encryptedContent // ignore: cast_nullable_to_non_nullable
              as String?,
      textIndexes: null == textIndexes
          ? _self.textIndexes
          : textIndexes // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
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
      formId: freezed == formId
          ? _self.formId
          : formId // ignore: cast_nullable_to_non_nullable
              as String?,
      created: freezed == created
          ? _self.created
          : created // ignore: cast_nullable_to_non_nullable
              as int?,
      modified: freezed == modified
          ? _self.modified
          : modified // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
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
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      invoicingCodes: null == invoicingCodes
          ? _self.invoicingCodes
          : invoicingCodes // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      notes: null == notes
          ? _self.notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      qualifiedLinks: null == qualifiedLinks
          ? _self.qualifiedLinks
          : qualifiedLinks // ignore: cast_nullable_to_non_nullable
              as Map<LinkQualification, Map<String, String>>,
      codes: null == codes
          ? _self.codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
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

  /// Create a copy of EncryptedService
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

class _EncryptedService implements EncryptedService {
  const _EncryptedService(
      {required this.id,
      this.transactionId = null,
      final List<Identifier> identifier = const [],
      this.contactId = null,
      final Set<String>? subContactIds = null,
      final Set<String>? plansOfActionIds = null,
      final Set<String>? healthElementsIds = null,
      final Set<String>? formIds = null,
      final Set<String>? secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.label = null,
      this.index = null,
      final Map<String, EncryptedContent> content = const {},
      this.encryptedContent = null,
      final Map<String, String> textIndexes = const {},
      this.valueDate = null,
      this.openingDate = null,
      this.closingDate = null,
      this.formId = null,
      this.created = null,
      this.modified = null,
      this.endOfLife = null,
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      this.comment = null,
      this.status = null,
      final Set<String> invoicingCodes = const {},
      final List<Annotation> notes = const [],
      final Map<LinkQualification, Map<String, String>> qualifiedLinks =
          const {},
      final Set<CodeStub> codes = const {},
      final Set<CodeStub> tags = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null})
      : _identifier = identifier,
        _subContactIds = subContactIds,
        _plansOfActionIds = plansOfActionIds,
        _healthElementsIds = healthElementsIds,
        _formIds = formIds,
        _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys,
        _content = content,
        _textIndexes = textIndexes,
        _invoicingCodes = invoicingCodes,
        _notes = notes,
        _qualifiedLinks = qualifiedLinks,
        _codes = codes,
        _tags = tags;

  @override
  final String id;
  @override
  @JsonKey()
  final String? transactionId;
  final List<Identifier> _identifier;
  @override
  @JsonKey()
  List<Identifier> get identifier {
    if (_identifier is EqualUnmodifiableListView) return _identifier;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_identifier);
  }

  @override
  @JsonKey()
  final String? contactId;
  final Set<String>? _subContactIds;
  @override
  @JsonKey()
  Set<String>? get subContactIds {
    final value = _subContactIds;
    if (value == null) return null;
    if (_subContactIds is EqualUnmodifiableSetView) return _subContactIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  final Set<String>? _plansOfActionIds;
  @override
  @JsonKey()
  Set<String>? get plansOfActionIds {
    final value = _plansOfActionIds;
    if (value == null) return null;
    if (_plansOfActionIds is EqualUnmodifiableSetView) return _plansOfActionIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  final Set<String>? _healthElementsIds;
  @override
  @JsonKey()
  Set<String>? get healthElementsIds {
    final value = _healthElementsIds;
    if (value == null) return null;
    if (_healthElementsIds is EqualUnmodifiableSetView)
      return _healthElementsIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  final Set<String>? _formIds;
  @override
  @JsonKey()
  Set<String>? get formIds {
    final value = _formIds;
    if (value == null) return null;
    if (_formIds is EqualUnmodifiableSetView) return _formIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  final Set<String>? _secretForeignKeys;
  @override
  @JsonKey()
  Set<String>? get secretForeignKeys {
    final value = _secretForeignKeys;
    if (value == null) return null;
    if (_secretForeignKeys is EqualUnmodifiableSetView)
      return _secretForeignKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
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
  final String? label;
  @override
  @JsonKey()
  final int? index;
  final Map<String, EncryptedContent> _content;
  @override
  @JsonKey()
  Map<String, EncryptedContent> get content {
    if (_content is EqualUnmodifiableMapView) return _content;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_content);
  }

  @override
  @JsonKey()
  final String? encryptedContent;
  final Map<String, String> _textIndexes;
  @override
  @JsonKey()
  Map<String, String> get textIndexes {
    if (_textIndexes is EqualUnmodifiableMapView) return _textIndexes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_textIndexes);
  }

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
  final String? formId;
  @override
  @JsonKey()
  final int? created;
  @override
  @JsonKey()
  final int? modified;
  @override
  @JsonKey()
  final int? endOfLife;
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
  final String? comment;
  @override
  @JsonKey()
  final int? status;
  final Set<String> _invoicingCodes;
  @override
  @JsonKey()
  Set<String> get invoicingCodes {
    if (_invoicingCodes is EqualUnmodifiableSetView) return _invoicingCodes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_invoicingCodes);
  }

  final List<Annotation> _notes;
  @override
  @JsonKey()
  List<Annotation> get notes {
    if (_notes is EqualUnmodifiableListView) return _notes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_notes);
  }

  final Map<LinkQualification, Map<String, String>> _qualifiedLinks;
  @override
  @JsonKey()
  Map<LinkQualification, Map<String, String>> get qualifiedLinks {
    if (_qualifiedLinks is EqualUnmodifiableMapView) return _qualifiedLinks;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_qualifiedLinks);
  }

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
  final Base64String? encryptedSelf;
  @override
  @JsonKey()
  final SecurityMetadata? securityMetadata;

  /// Create a copy of EncryptedService
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedServiceCopyWith<_EncryptedService> get copyWith =>
      __$EncryptedServiceCopyWithImpl<_EncryptedService>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedService &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.transactionId, transactionId) ||
                other.transactionId == transactionId) &&
            const DeepCollectionEquality()
                .equals(other._identifier, _identifier) &&
            (identical(other.contactId, contactId) ||
                other.contactId == contactId) &&
            const DeepCollectionEquality()
                .equals(other._subContactIds, _subContactIds) &&
            const DeepCollectionEquality()
                .equals(other._plansOfActionIds, _plansOfActionIds) &&
            const DeepCollectionEquality()
                .equals(other._healthElementsIds, _healthElementsIds) &&
            const DeepCollectionEquality().equals(other._formIds, _formIds) &&
            const DeepCollectionEquality()
                .equals(other._secretForeignKeys, _secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._cryptedForeignKeys, _cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._delegations, _delegations) &&
            const DeepCollectionEquality()
                .equals(other._encryptionKeys, _encryptionKeys) &&
            (identical(other.label, label) || other.label == label) &&
            (identical(other.index, index) || other.index == index) &&
            const DeepCollectionEquality().equals(other._content, _content) &&
            (identical(other.encryptedContent, encryptedContent) ||
                other.encryptedContent == encryptedContent) &&
            const DeepCollectionEquality()
                .equals(other._textIndexes, _textIndexes) &&
            (identical(other.valueDate, valueDate) ||
                other.valueDate == valueDate) &&
            (identical(other.openingDate, openingDate) ||
                other.openingDate == openingDate) &&
            (identical(other.closingDate, closingDate) ||
                other.closingDate == closingDate) &&
            (identical(other.formId, formId) || other.formId == formId) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.status, status) || other.status == status) &&
            const DeepCollectionEquality()
                .equals(other._invoicingCodes, _invoicingCodes) &&
            const DeepCollectionEquality().equals(other._notes, _notes) &&
            const DeepCollectionEquality()
                .equals(other._qualifiedLinks, _qualifiedLinks) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        transactionId,
        const DeepCollectionEquality().hash(_identifier),
        contactId,
        const DeepCollectionEquality().hash(_subContactIds),
        const DeepCollectionEquality().hash(_plansOfActionIds),
        const DeepCollectionEquality().hash(_healthElementsIds),
        const DeepCollectionEquality().hash(_formIds),
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        label,
        index,
        const DeepCollectionEquality().hash(_content),
        encryptedContent,
        const DeepCollectionEquality().hash(_textIndexes),
        valueDate,
        openingDate,
        closingDate,
        formId,
        created,
        modified,
        endOfLife,
        author,
        responsible,
        medicalLocationId,
        comment,
        status,
        const DeepCollectionEquality().hash(_invoicingCodes),
        const DeepCollectionEquality().hash(_notes),
        const DeepCollectionEquality().hash(_qualifiedLinks),
        const DeepCollectionEquality().hash(_codes),
        const DeepCollectionEquality().hash(_tags),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'EncryptedService(id: $id, transactionId: $transactionId, identifier: $identifier, contactId: $contactId, subContactIds: $subContactIds, plansOfActionIds: $plansOfActionIds, healthElementsIds: $healthElementsIds, formIds: $formIds, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, label: $label, index: $index, content: $content, encryptedContent: $encryptedContent, textIndexes: $textIndexes, valueDate: $valueDate, openingDate: $openingDate, closingDate: $closingDate, formId: $formId, created: $created, modified: $modified, endOfLife: $endOfLife, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, comment: $comment, status: $status, invoicingCodes: $invoicingCodes, notes: $notes, qualifiedLinks: $qualifiedLinks, codes: $codes, tags: $tags, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedServiceCopyWith<$Res>
    implements $EncryptedServiceCopyWith<$Res> {
  factory _$EncryptedServiceCopyWith(
          _EncryptedService value, $Res Function(_EncryptedService) _then) =
      __$EncryptedServiceCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? transactionId,
      List<Identifier> identifier,
      String? contactId,
      Set<String>? subContactIds,
      Set<String>? plansOfActionIds,
      Set<String>? healthElementsIds,
      Set<String>? formIds,
      Set<String>? secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      String? label,
      int? index,
      Map<String, EncryptedContent> content,
      String? encryptedContent,
      Map<String, String> textIndexes,
      int? valueDate,
      int? openingDate,
      int? closingDate,
      String? formId,
      int? created,
      int? modified,
      int? endOfLife,
      String? author,
      String? responsible,
      String? medicalLocationId,
      String? comment,
      int? status,
      Set<String> invoicingCodes,
      List<Annotation> notes,
      Map<LinkQualification, Map<String, String>> qualifiedLinks,
      Set<CodeStub> codes,
      Set<CodeStub> tags,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$EncryptedServiceCopyWithImpl<$Res>
    implements _$EncryptedServiceCopyWith<$Res> {
  __$EncryptedServiceCopyWithImpl(this._self, this._then);

  final _EncryptedService _self;
  final $Res Function(_EncryptedService) _then;

  /// Create a copy of EncryptedService
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? transactionId = freezed,
    Object? identifier = null,
    Object? contactId = freezed,
    Object? subContactIds = freezed,
    Object? plansOfActionIds = freezed,
    Object? healthElementsIds = freezed,
    Object? formIds = freezed,
    Object? secretForeignKeys = freezed,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? label = freezed,
    Object? index = freezed,
    Object? content = null,
    Object? encryptedContent = freezed,
    Object? textIndexes = null,
    Object? valueDate = freezed,
    Object? openingDate = freezed,
    Object? closingDate = freezed,
    Object? formId = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? endOfLife = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? comment = freezed,
    Object? status = freezed,
    Object? invoicingCodes = null,
    Object? notes = null,
    Object? qualifiedLinks = null,
    Object? codes = null,
    Object? tags = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_EncryptedService(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      transactionId: freezed == transactionId
          ? _self.transactionId
          : transactionId // ignore: cast_nullable_to_non_nullable
              as String?,
      identifier: null == identifier
          ? _self._identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      contactId: freezed == contactId
          ? _self.contactId
          : contactId // ignore: cast_nullable_to_non_nullable
              as String?,
      subContactIds: freezed == subContactIds
          ? _self._subContactIds
          : subContactIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      plansOfActionIds: freezed == plansOfActionIds
          ? _self._plansOfActionIds
          : plansOfActionIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      healthElementsIds: freezed == healthElementsIds
          ? _self._healthElementsIds
          : healthElementsIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      formIds: freezed == formIds
          ? _self._formIds
          : formIds // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      secretForeignKeys: freezed == secretForeignKeys
          ? _self._secretForeignKeys
          : secretForeignKeys // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
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
      label: freezed == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as String?,
      index: freezed == index
          ? _self.index
          : index // ignore: cast_nullable_to_non_nullable
              as int?,
      content: null == content
          ? _self._content
          : content // ignore: cast_nullable_to_non_nullable
              as Map<String, EncryptedContent>,
      encryptedContent: freezed == encryptedContent
          ? _self.encryptedContent
          : encryptedContent // ignore: cast_nullable_to_non_nullable
              as String?,
      textIndexes: null == textIndexes
          ? _self._textIndexes
          : textIndexes // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
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
      formId: freezed == formId
          ? _self.formId
          : formId // ignore: cast_nullable_to_non_nullable
              as String?,
      created: freezed == created
          ? _self.created
          : created // ignore: cast_nullable_to_non_nullable
              as int?,
      modified: freezed == modified
          ? _self.modified
          : modified // ignore: cast_nullable_to_non_nullable
              as int?,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
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
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      invoicingCodes: null == invoicingCodes
          ? _self._invoicingCodes
          : invoicingCodes // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      notes: null == notes
          ? _self._notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      qualifiedLinks: null == qualifiedLinks
          ? _self._qualifiedLinks
          : qualifiedLinks // ignore: cast_nullable_to_non_nullable
              as Map<LinkQualification, Map<String, String>>,
      codes: null == codes
          ? _self._codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
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

  /// Create a copy of EncryptedService
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
