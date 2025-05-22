// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'document_template.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DocumentTemplate {
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
  Uint8List? get attachment;
  DocumentType? get documentType;
  String? get mainUti;
  String? get name;
  Set<String> get otherUtis;
  String? get attachmentId;
  ReportVersion? get version;
  String? get owner;
  String? get guid;
  DocumentGroup? get group;
  String? get descr;
  String? get disabled;
  CodeStub? get specialty;

  /// Create a copy of DocumentTemplate
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DocumentTemplateCopyWith<DocumentTemplate> get copyWith =>
      _$DocumentTemplateCopyWithImpl<DocumentTemplate>(
          this as DocumentTemplate, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DocumentTemplate &&
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
            const DeepCollectionEquality()
                .equals(other.attachment, attachment) &&
            (identical(other.documentType, documentType) ||
                other.documentType == documentType) &&
            (identical(other.mainUti, mainUti) || other.mainUti == mainUti) &&
            (identical(other.name, name) || other.name == name) &&
            const DeepCollectionEquality().equals(other.otherUtis, otherUtis) &&
            (identical(other.attachmentId, attachmentId) ||
                other.attachmentId == attachmentId) &&
            (identical(other.version, version) || other.version == version) &&
            (identical(other.owner, owner) || other.owner == owner) &&
            (identical(other.guid, guid) || other.guid == guid) &&
            (identical(other.group, group) || other.group == group) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.disabled, disabled) ||
                other.disabled == disabled) &&
            (identical(other.specialty, specialty) ||
                other.specialty == specialty));
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
        const DeepCollectionEquality().hash(attachment),
        documentType,
        mainUti,
        name,
        const DeepCollectionEquality().hash(otherUtis),
        attachmentId,
        version,
        owner,
        guid,
        group,
        descr,
        disabled,
        specialty
      ]);

  @override
  String toString() {
    return 'DocumentTemplate(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, attachment: $attachment, documentType: $documentType, mainUti: $mainUti, name: $name, otherUtis: $otherUtis, attachmentId: $attachmentId, version: $version, owner: $owner, guid: $guid, group: $group, descr: $descr, disabled: $disabled, specialty: $specialty)';
  }
}

/// @nodoc
abstract mixin class $DocumentTemplateCopyWith<$Res> {
  factory $DocumentTemplateCopyWith(
          DocumentTemplate value, $Res Function(DocumentTemplate) _then) =
      _$DocumentTemplateCopyWithImpl;
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
      Uint8List? attachment,
      DocumentType? documentType,
      String? mainUti,
      String? name,
      Set<String> otherUtis,
      String? attachmentId,
      ReportVersion? version,
      String? owner,
      String? guid,
      DocumentGroup? group,
      String? descr,
      String? disabled,
      CodeStub? specialty});

  $DocumentGroupCopyWith<$Res>? get group;
  $CodeStubCopyWith<$Res>? get specialty;
}

/// @nodoc
class _$DocumentTemplateCopyWithImpl<$Res>
    implements $DocumentTemplateCopyWith<$Res> {
  _$DocumentTemplateCopyWithImpl(this._self, this._then);

  final DocumentTemplate _self;
  final $Res Function(DocumentTemplate) _then;

  /// Create a copy of DocumentTemplate
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
    Object? attachment = freezed,
    Object? documentType = freezed,
    Object? mainUti = freezed,
    Object? name = freezed,
    Object? otherUtis = null,
    Object? attachmentId = freezed,
    Object? version = freezed,
    Object? owner = freezed,
    Object? guid = freezed,
    Object? group = freezed,
    Object? descr = freezed,
    Object? disabled = freezed,
    Object? specialty = freezed,
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
      attachment: freezed == attachment
          ? _self.attachment
          : attachment // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      documentType: freezed == documentType
          ? _self.documentType
          : documentType // ignore: cast_nullable_to_non_nullable
              as DocumentType?,
      mainUti: freezed == mainUti
          ? _self.mainUti
          : mainUti // ignore: cast_nullable_to_non_nullable
              as String?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      otherUtis: null == otherUtis
          ? _self.otherUtis
          : otherUtis // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      attachmentId: freezed == attachmentId
          ? _self.attachmentId
          : attachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as ReportVersion?,
      owner: freezed == owner
          ? _self.owner
          : owner // ignore: cast_nullable_to_non_nullable
              as String?,
      guid: freezed == guid
          ? _self.guid
          : guid // ignore: cast_nullable_to_non_nullable
              as String?,
      group: freezed == group
          ? _self.group
          : group // ignore: cast_nullable_to_non_nullable
              as DocumentGroup?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      disabled: freezed == disabled
          ? _self.disabled
          : disabled // ignore: cast_nullable_to_non_nullable
              as String?,
      specialty: freezed == specialty
          ? _self.specialty
          : specialty // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
    ));
  }

  /// Create a copy of DocumentTemplate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DocumentGroupCopyWith<$Res>? get group {
    if (_self.group == null) {
      return null;
    }

    return $DocumentGroupCopyWith<$Res>(_self.group!, (value) {
      return _then(_self.copyWith(group: value));
    });
  }

  /// Create a copy of DocumentTemplate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get specialty {
    if (_self.specialty == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.specialty!, (value) {
      return _then(_self.copyWith(specialty: value));
    });
  }
}

/// @nodoc

class _DocumentTemplate implements DocumentTemplate {
  const _DocumentTemplate(
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
      this.attachment = null,
      this.documentType = null,
      this.mainUti = null,
      this.name = null,
      final Set<String> otherUtis = const {},
      this.attachmentId = null,
      this.version = null,
      this.owner = null,
      this.guid = null,
      this.group = null,
      this.descr = null,
      this.disabled = null,
      this.specialty = null})
      : _tags = tags,
        _codes = codes,
        _otherUtis = otherUtis;

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
  final Uint8List? attachment;
  @override
  @JsonKey()
  final DocumentType? documentType;
  @override
  @JsonKey()
  final String? mainUti;
  @override
  @JsonKey()
  final String? name;
  final Set<String> _otherUtis;
  @override
  @JsonKey()
  Set<String> get otherUtis {
    if (_otherUtis is EqualUnmodifiableSetView) return _otherUtis;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_otherUtis);
  }

  @override
  @JsonKey()
  final String? attachmentId;
  @override
  @JsonKey()
  final ReportVersion? version;
  @override
  @JsonKey()
  final String? owner;
  @override
  @JsonKey()
  final String? guid;
  @override
  @JsonKey()
  final DocumentGroup? group;
  @override
  @JsonKey()
  final String? descr;
  @override
  @JsonKey()
  final String? disabled;
  @override
  @JsonKey()
  final CodeStub? specialty;

  /// Create a copy of DocumentTemplate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DocumentTemplateCopyWith<_DocumentTemplate> get copyWith =>
      __$DocumentTemplateCopyWithImpl<_DocumentTemplate>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DocumentTemplate &&
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
            const DeepCollectionEquality()
                .equals(other.attachment, attachment) &&
            (identical(other.documentType, documentType) ||
                other.documentType == documentType) &&
            (identical(other.mainUti, mainUti) || other.mainUti == mainUti) &&
            (identical(other.name, name) || other.name == name) &&
            const DeepCollectionEquality()
                .equals(other._otherUtis, _otherUtis) &&
            (identical(other.attachmentId, attachmentId) ||
                other.attachmentId == attachmentId) &&
            (identical(other.version, version) || other.version == version) &&
            (identical(other.owner, owner) || other.owner == owner) &&
            (identical(other.guid, guid) || other.guid == guid) &&
            (identical(other.group, group) || other.group == group) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.disabled, disabled) ||
                other.disabled == disabled) &&
            (identical(other.specialty, specialty) ||
                other.specialty == specialty));
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
        const DeepCollectionEquality().hash(attachment),
        documentType,
        mainUti,
        name,
        const DeepCollectionEquality().hash(_otherUtis),
        attachmentId,
        version,
        owner,
        guid,
        group,
        descr,
        disabled,
        specialty
      ]);

  @override
  String toString() {
    return 'DocumentTemplate(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, attachment: $attachment, documentType: $documentType, mainUti: $mainUti, name: $name, otherUtis: $otherUtis, attachmentId: $attachmentId, version: $version, owner: $owner, guid: $guid, group: $group, descr: $descr, disabled: $disabled, specialty: $specialty)';
  }
}

/// @nodoc
abstract mixin class _$DocumentTemplateCopyWith<$Res>
    implements $DocumentTemplateCopyWith<$Res> {
  factory _$DocumentTemplateCopyWith(
          _DocumentTemplate value, $Res Function(_DocumentTemplate) _then) =
      __$DocumentTemplateCopyWithImpl;
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
      Uint8List? attachment,
      DocumentType? documentType,
      String? mainUti,
      String? name,
      Set<String> otherUtis,
      String? attachmentId,
      ReportVersion? version,
      String? owner,
      String? guid,
      DocumentGroup? group,
      String? descr,
      String? disabled,
      CodeStub? specialty});

  @override
  $DocumentGroupCopyWith<$Res>? get group;
  @override
  $CodeStubCopyWith<$Res>? get specialty;
}

/// @nodoc
class __$DocumentTemplateCopyWithImpl<$Res>
    implements _$DocumentTemplateCopyWith<$Res> {
  __$DocumentTemplateCopyWithImpl(this._self, this._then);

  final _DocumentTemplate _self;
  final $Res Function(_DocumentTemplate) _then;

  /// Create a copy of DocumentTemplate
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
    Object? attachment = freezed,
    Object? documentType = freezed,
    Object? mainUti = freezed,
    Object? name = freezed,
    Object? otherUtis = null,
    Object? attachmentId = freezed,
    Object? version = freezed,
    Object? owner = freezed,
    Object? guid = freezed,
    Object? group = freezed,
    Object? descr = freezed,
    Object? disabled = freezed,
    Object? specialty = freezed,
  }) {
    return _then(_DocumentTemplate(
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
      attachment: freezed == attachment
          ? _self.attachment
          : attachment // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      documentType: freezed == documentType
          ? _self.documentType
          : documentType // ignore: cast_nullable_to_non_nullable
              as DocumentType?,
      mainUti: freezed == mainUti
          ? _self.mainUti
          : mainUti // ignore: cast_nullable_to_non_nullable
              as String?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      otherUtis: null == otherUtis
          ? _self._otherUtis
          : otherUtis // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      attachmentId: freezed == attachmentId
          ? _self.attachmentId
          : attachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as ReportVersion?,
      owner: freezed == owner
          ? _self.owner
          : owner // ignore: cast_nullable_to_non_nullable
              as String?,
      guid: freezed == guid
          ? _self.guid
          : guid // ignore: cast_nullable_to_non_nullable
              as String?,
      group: freezed == group
          ? _self.group
          : group // ignore: cast_nullable_to_non_nullable
              as DocumentGroup?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      disabled: freezed == disabled
          ? _self.disabled
          : disabled // ignore: cast_nullable_to_non_nullable
              as String?,
      specialty: freezed == specialty
          ? _self.specialty
          : specialty // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
    ));
  }

  /// Create a copy of DocumentTemplate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DocumentGroupCopyWith<$Res>? get group {
    if (_self.group == null) {
      return null;
    }

    return $DocumentGroupCopyWith<$Res>(_self.group!, (value) {
      return _then(_self.copyWith(group: value));
    });
  }

  /// Create a copy of DocumentTemplate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get specialty {
    if (_self.specialty == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.specialty!, (value) {
      return _then(_self.copyWith(specialty: value));
    });
  }
}

// dart format on
