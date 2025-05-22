// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'sub_contact.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedSubContact {
  String? get id;
  int? get created;
  int? get modified;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  int? get endOfLife;
  String? get descr;
  String? get protocol;
  int? get status;
  String? get formId;
  String? get planOfActionId;
  String? get healthElementId;
  String? get classificationId;
  List<ServiceLink> get services;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedSubContact
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedSubContactCopyWith<EncryptedSubContact> get copyWith =>
      _$EncryptedSubContactCopyWithImpl<EncryptedSubContact>(
          this as EncryptedSubContact, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedSubContact &&
            (identical(other.id, id) || other.id == id) &&
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
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.protocol, protocol) ||
                other.protocol == protocol) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.formId, formId) || other.formId == formId) &&
            (identical(other.planOfActionId, planOfActionId) ||
                other.planOfActionId == planOfActionId) &&
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.classificationId, classificationId) ||
                other.classificationId == classificationId) &&
            const DeepCollectionEquality().equals(other.services, services) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      created,
      modified,
      author,
      responsible,
      medicalLocationId,
      const DeepCollectionEquality().hash(tags),
      const DeepCollectionEquality().hash(codes),
      endOfLife,
      descr,
      protocol,
      status,
      formId,
      planOfActionId,
      healthElementId,
      classificationId,
      const DeepCollectionEquality().hash(services),
      encryptedSelf);

  @override
  String toString() {
    return 'EncryptedSubContact(id: $id, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, descr: $descr, protocol: $protocol, status: $status, formId: $formId, planOfActionId: $planOfActionId, healthElementId: $healthElementId, classificationId: $classificationId, services: $services, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedSubContactCopyWith<$Res> {
  factory $EncryptedSubContactCopyWith(
          EncryptedSubContact value, $Res Function(EncryptedSubContact) _then) =
      _$EncryptedSubContactCopyWithImpl;
  @useResult
  $Res call(
      {String? id,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      String? descr,
      String? protocol,
      int? status,
      String? formId,
      String? planOfActionId,
      String? healthElementId,
      String? classificationId,
      List<ServiceLink> services,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$EncryptedSubContactCopyWithImpl<$Res>
    implements $EncryptedSubContactCopyWith<$Res> {
  _$EncryptedSubContactCopyWithImpl(this._self, this._then);

  final EncryptedSubContact _self;
  final $Res Function(EncryptedSubContact) _then;

  /// Create a copy of EncryptedSubContact
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? descr = freezed,
    Object? protocol = freezed,
    Object? status = freezed,
    Object? formId = freezed,
    Object? planOfActionId = freezed,
    Object? healthElementId = freezed,
    Object? classificationId = freezed,
    Object? services = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
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
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      protocol: freezed == protocol
          ? _self.protocol
          : protocol // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      formId: freezed == formId
          ? _self.formId
          : formId // ignore: cast_nullable_to_non_nullable
              as String?,
      planOfActionId: freezed == planOfActionId
          ? _self.planOfActionId
          : planOfActionId // ignore: cast_nullable_to_non_nullable
              as String?,
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      classificationId: freezed == classificationId
          ? _self.classificationId
          : classificationId // ignore: cast_nullable_to_non_nullable
              as String?,
      services: null == services
          ? _self.services
          : services // ignore: cast_nullable_to_non_nullable
              as List<ServiceLink>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _EncryptedSubContact implements EncryptedSubContact {
  const _EncryptedSubContact(
      {this.id = null,
      this.created = null,
      this.modified = null,
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      this.endOfLife = null,
      this.descr = null,
      this.protocol = null,
      this.status = null,
      this.formId = null,
      this.planOfActionId = null,
      this.healthElementId = null,
      this.classificationId = null,
      final List<ServiceLink> services = const [],
      this.encryptedSelf = null})
      : _tags = tags,
        _codes = codes,
        _services = services;

  @override
  @JsonKey()
  final String? id;
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
  final String? descr;
  @override
  @JsonKey()
  final String? protocol;
  @override
  @JsonKey()
  final int? status;
  @override
  @JsonKey()
  final String? formId;
  @override
  @JsonKey()
  final String? planOfActionId;
  @override
  @JsonKey()
  final String? healthElementId;
  @override
  @JsonKey()
  final String? classificationId;
  final List<ServiceLink> _services;
  @override
  @JsonKey()
  List<ServiceLink> get services {
    if (_services is EqualUnmodifiableListView) return _services;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_services);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedSubContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedSubContactCopyWith<_EncryptedSubContact> get copyWith =>
      __$EncryptedSubContactCopyWithImpl<_EncryptedSubContact>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedSubContact &&
            (identical(other.id, id) || other.id == id) &&
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
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.protocol, protocol) ||
                other.protocol == protocol) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.formId, formId) || other.formId == formId) &&
            (identical(other.planOfActionId, planOfActionId) ||
                other.planOfActionId == planOfActionId) &&
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.classificationId, classificationId) ||
                other.classificationId == classificationId) &&
            const DeepCollectionEquality().equals(other._services, _services) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      created,
      modified,
      author,
      responsible,
      medicalLocationId,
      const DeepCollectionEquality().hash(_tags),
      const DeepCollectionEquality().hash(_codes),
      endOfLife,
      descr,
      protocol,
      status,
      formId,
      planOfActionId,
      healthElementId,
      classificationId,
      const DeepCollectionEquality().hash(_services),
      encryptedSelf);

  @override
  String toString() {
    return 'EncryptedSubContact(id: $id, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, descr: $descr, protocol: $protocol, status: $status, formId: $formId, planOfActionId: $planOfActionId, healthElementId: $healthElementId, classificationId: $classificationId, services: $services, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedSubContactCopyWith<$Res>
    implements $EncryptedSubContactCopyWith<$Res> {
  factory _$EncryptedSubContactCopyWith(_EncryptedSubContact value,
          $Res Function(_EncryptedSubContact) _then) =
      __$EncryptedSubContactCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? id,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      String? descr,
      String? protocol,
      int? status,
      String? formId,
      String? planOfActionId,
      String? healthElementId,
      String? classificationId,
      List<ServiceLink> services,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$EncryptedSubContactCopyWithImpl<$Res>
    implements _$EncryptedSubContactCopyWith<$Res> {
  __$EncryptedSubContactCopyWithImpl(this._self, this._then);

  final _EncryptedSubContact _self;
  final $Res Function(_EncryptedSubContact) _then;

  /// Create a copy of EncryptedSubContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? descr = freezed,
    Object? protocol = freezed,
    Object? status = freezed,
    Object? formId = freezed,
    Object? planOfActionId = freezed,
    Object? healthElementId = freezed,
    Object? classificationId = freezed,
    Object? services = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedSubContact(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
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
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      protocol: freezed == protocol
          ? _self.protocol
          : protocol // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      formId: freezed == formId
          ? _self.formId
          : formId // ignore: cast_nullable_to_non_nullable
              as String?,
      planOfActionId: freezed == planOfActionId
          ? _self.planOfActionId
          : planOfActionId // ignore: cast_nullable_to_non_nullable
              as String?,
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      classificationId: freezed == classificationId
          ? _self.classificationId
          : classificationId // ignore: cast_nullable_to_non_nullable
              as String?,
      services: null == services
          ? _self._services
          : services // ignore: cast_nullable_to_non_nullable
              as List<ServiceLink>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc
mixin _$DecryptedSubContact {
  String? get id;
  int? get created;
  int? get modified;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  int? get endOfLife;
  String? get descr;
  String? get protocol;
  int? get status;
  String? get formId;
  String? get planOfActionId;
  String? get healthElementId;
  String? get classificationId;
  List<ServiceLink> get services;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedSubContact
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedSubContactCopyWith<DecryptedSubContact> get copyWith =>
      _$DecryptedSubContactCopyWithImpl<DecryptedSubContact>(
          this as DecryptedSubContact, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedSubContact &&
            (identical(other.id, id) || other.id == id) &&
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
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.protocol, protocol) ||
                other.protocol == protocol) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.formId, formId) || other.formId == formId) &&
            (identical(other.planOfActionId, planOfActionId) ||
                other.planOfActionId == planOfActionId) &&
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.classificationId, classificationId) ||
                other.classificationId == classificationId) &&
            const DeepCollectionEquality().equals(other.services, services) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      created,
      modified,
      author,
      responsible,
      medicalLocationId,
      const DeepCollectionEquality().hash(tags),
      const DeepCollectionEquality().hash(codes),
      endOfLife,
      descr,
      protocol,
      status,
      formId,
      planOfActionId,
      healthElementId,
      classificationId,
      const DeepCollectionEquality().hash(services),
      encryptedSelf);

  @override
  String toString() {
    return 'DecryptedSubContact(id: $id, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, descr: $descr, protocol: $protocol, status: $status, formId: $formId, planOfActionId: $planOfActionId, healthElementId: $healthElementId, classificationId: $classificationId, services: $services, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedSubContactCopyWith<$Res> {
  factory $DecryptedSubContactCopyWith(
          DecryptedSubContact value, $Res Function(DecryptedSubContact) _then) =
      _$DecryptedSubContactCopyWithImpl;
  @useResult
  $Res call(
      {String? id,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      String? descr,
      String? protocol,
      int? status,
      String? formId,
      String? planOfActionId,
      String? healthElementId,
      String? classificationId,
      List<ServiceLink> services,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$DecryptedSubContactCopyWithImpl<$Res>
    implements $DecryptedSubContactCopyWith<$Res> {
  _$DecryptedSubContactCopyWithImpl(this._self, this._then);

  final DecryptedSubContact _self;
  final $Res Function(DecryptedSubContact) _then;

  /// Create a copy of DecryptedSubContact
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? descr = freezed,
    Object? protocol = freezed,
    Object? status = freezed,
    Object? formId = freezed,
    Object? planOfActionId = freezed,
    Object? healthElementId = freezed,
    Object? classificationId = freezed,
    Object? services = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
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
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      protocol: freezed == protocol
          ? _self.protocol
          : protocol // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      formId: freezed == formId
          ? _self.formId
          : formId // ignore: cast_nullable_to_non_nullable
              as String?,
      planOfActionId: freezed == planOfActionId
          ? _self.planOfActionId
          : planOfActionId // ignore: cast_nullable_to_non_nullable
              as String?,
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      classificationId: freezed == classificationId
          ? _self.classificationId
          : classificationId // ignore: cast_nullable_to_non_nullable
              as String?,
      services: null == services
          ? _self.services
          : services // ignore: cast_nullable_to_non_nullable
              as List<ServiceLink>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _DecryptedSubContact implements DecryptedSubContact {
  const _DecryptedSubContact(
      {this.id = null,
      this.created = null,
      this.modified = null,
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      this.endOfLife = null,
      this.descr = null,
      this.protocol = null,
      this.status = null,
      this.formId = null,
      this.planOfActionId = null,
      this.healthElementId = null,
      this.classificationId = null,
      final List<ServiceLink> services = const [],
      this.encryptedSelf = null})
      : _tags = tags,
        _codes = codes,
        _services = services;

  @override
  @JsonKey()
  final String? id;
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
  final String? descr;
  @override
  @JsonKey()
  final String? protocol;
  @override
  @JsonKey()
  final int? status;
  @override
  @JsonKey()
  final String? formId;
  @override
  @JsonKey()
  final String? planOfActionId;
  @override
  @JsonKey()
  final String? healthElementId;
  @override
  @JsonKey()
  final String? classificationId;
  final List<ServiceLink> _services;
  @override
  @JsonKey()
  List<ServiceLink> get services {
    if (_services is EqualUnmodifiableListView) return _services;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_services);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedSubContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedSubContactCopyWith<_DecryptedSubContact> get copyWith =>
      __$DecryptedSubContactCopyWithImpl<_DecryptedSubContact>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedSubContact &&
            (identical(other.id, id) || other.id == id) &&
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
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.protocol, protocol) ||
                other.protocol == protocol) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.formId, formId) || other.formId == formId) &&
            (identical(other.planOfActionId, planOfActionId) ||
                other.planOfActionId == planOfActionId) &&
            (identical(other.healthElementId, healthElementId) ||
                other.healthElementId == healthElementId) &&
            (identical(other.classificationId, classificationId) ||
                other.classificationId == classificationId) &&
            const DeepCollectionEquality().equals(other._services, _services) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      created,
      modified,
      author,
      responsible,
      medicalLocationId,
      const DeepCollectionEquality().hash(_tags),
      const DeepCollectionEquality().hash(_codes),
      endOfLife,
      descr,
      protocol,
      status,
      formId,
      planOfActionId,
      healthElementId,
      classificationId,
      const DeepCollectionEquality().hash(_services),
      encryptedSelf);

  @override
  String toString() {
    return 'DecryptedSubContact(id: $id, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, descr: $descr, protocol: $protocol, status: $status, formId: $formId, planOfActionId: $planOfActionId, healthElementId: $healthElementId, classificationId: $classificationId, services: $services, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedSubContactCopyWith<$Res>
    implements $DecryptedSubContactCopyWith<$Res> {
  factory _$DecryptedSubContactCopyWith(_DecryptedSubContact value,
          $Res Function(_DecryptedSubContact) _then) =
      __$DecryptedSubContactCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? id,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      String? descr,
      String? protocol,
      int? status,
      String? formId,
      String? planOfActionId,
      String? healthElementId,
      String? classificationId,
      List<ServiceLink> services,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$DecryptedSubContactCopyWithImpl<$Res>
    implements _$DecryptedSubContactCopyWith<$Res> {
  __$DecryptedSubContactCopyWithImpl(this._self, this._then);

  final _DecryptedSubContact _self;
  final $Res Function(_DecryptedSubContact) _then;

  /// Create a copy of DecryptedSubContact
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? descr = freezed,
    Object? protocol = freezed,
    Object? status = freezed,
    Object? formId = freezed,
    Object? planOfActionId = freezed,
    Object? healthElementId = freezed,
    Object? classificationId = freezed,
    Object? services = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedSubContact(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
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
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      protocol: freezed == protocol
          ? _self.protocol
          : protocol // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      formId: freezed == formId
          ? _self.formId
          : formId // ignore: cast_nullable_to_non_nullable
              as String?,
      planOfActionId: freezed == planOfActionId
          ? _self.planOfActionId
          : planOfActionId // ignore: cast_nullable_to_non_nullable
              as String?,
      healthElementId: freezed == healthElementId
          ? _self.healthElementId
          : healthElementId // ignore: cast_nullable_to_non_nullable
              as String?,
      classificationId: freezed == classificationId
          ? _self.classificationId
          : classificationId // ignore: cast_nullable_to_non_nullable
              as String?,
      services: null == services
          ? _self._services
          : services // ignore: cast_nullable_to_non_nullable
              as List<ServiceLink>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

// dart format on
