// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'message.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DecryptedMessage {
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
  String? get fromAddress;
  String? get fromHealthcarePartyId;
  String? get formId;
  int? get status;
  String? get recipientsType;
  Set<String> get recipients;
  Set<String> get toAddresses;
  int? get received;
  int? get sent;
  Map<String, String> get metas;
  Map<String, MessageReadStatus> get readStatus;
  List<MessageAttachment> get messageAttachments;
  String? get transportGuid;
  String? get remark;
  String? get conversationGuid;
  String? get subject;
  Set<String> get invoiceIds;
  String? get parentId;
  String? get externalRef;
  Set<String> get unassignedResults;
  Map<String, String> get assignedResults;
  Map<String, String> get senderReferences;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;

  /// Create a copy of DecryptedMessage
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedMessageCopyWith<DecryptedMessage> get copyWith =>
      _$DecryptedMessageCopyWithImpl<DecryptedMessage>(
          this as DecryptedMessage, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedMessage &&
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
            (identical(other.fromAddress, fromAddress) ||
                other.fromAddress == fromAddress) &&
            (identical(other.fromHealthcarePartyId, fromHealthcarePartyId) ||
                other.fromHealthcarePartyId == fromHealthcarePartyId) &&
            (identical(other.formId, formId) || other.formId == formId) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.recipientsType, recipientsType) ||
                other.recipientsType == recipientsType) &&
            const DeepCollectionEquality()
                .equals(other.recipients, recipients) &&
            const DeepCollectionEquality()
                .equals(other.toAddresses, toAddresses) &&
            (identical(other.received, received) ||
                other.received == received) &&
            (identical(other.sent, sent) || other.sent == sent) &&
            const DeepCollectionEquality().equals(other.metas, metas) &&
            const DeepCollectionEquality()
                .equals(other.readStatus, readStatus) &&
            const DeepCollectionEquality()
                .equals(other.messageAttachments, messageAttachments) &&
            (identical(other.transportGuid, transportGuid) ||
                other.transportGuid == transportGuid) &&
            (identical(other.remark, remark) || other.remark == remark) &&
            (identical(other.conversationGuid, conversationGuid) ||
                other.conversationGuid == conversationGuid) &&
            (identical(other.subject, subject) || other.subject == subject) &&
            const DeepCollectionEquality()
                .equals(other.invoiceIds, invoiceIds) &&
            (identical(other.parentId, parentId) ||
                other.parentId == parentId) &&
            (identical(other.externalRef, externalRef) ||
                other.externalRef == externalRef) &&
            const DeepCollectionEquality()
                .equals(other.unassignedResults, unassignedResults) &&
            const DeepCollectionEquality()
                .equals(other.assignedResults, assignedResults) &&
            const DeepCollectionEquality()
                .equals(other.senderReferences, senderReferences) &&
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
        fromAddress,
        fromHealthcarePartyId,
        formId,
        status,
        recipientsType,
        const DeepCollectionEquality().hash(recipients),
        const DeepCollectionEquality().hash(toAddresses),
        received,
        sent,
        const DeepCollectionEquality().hash(metas),
        const DeepCollectionEquality().hash(readStatus),
        const DeepCollectionEquality().hash(messageAttachments),
        transportGuid,
        remark,
        conversationGuid,
        subject,
        const DeepCollectionEquality().hash(invoiceIds),
        parentId,
        externalRef,
        const DeepCollectionEquality().hash(unassignedResults),
        const DeepCollectionEquality().hash(assignedResults),
        const DeepCollectionEquality().hash(senderReferences),
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'DecryptedMessage(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, fromAddress: $fromAddress, fromHealthcarePartyId: $fromHealthcarePartyId, formId: $formId, status: $status, recipientsType: $recipientsType, recipients: $recipients, toAddresses: $toAddresses, received: $received, sent: $sent, metas: $metas, readStatus: $readStatus, messageAttachments: $messageAttachments, transportGuid: $transportGuid, remark: $remark, conversationGuid: $conversationGuid, subject: $subject, invoiceIds: $invoiceIds, parentId: $parentId, externalRef: $externalRef, unassignedResults: $unassignedResults, assignedResults: $assignedResults, senderReferences: $senderReferences, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class $DecryptedMessageCopyWith<$Res> {
  factory $DecryptedMessageCopyWith(
          DecryptedMessage value, $Res Function(DecryptedMessage) _then) =
      _$DecryptedMessageCopyWithImpl;
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
      String? fromAddress,
      String? fromHealthcarePartyId,
      String? formId,
      int? status,
      String? recipientsType,
      Set<String> recipients,
      Set<String> toAddresses,
      int? received,
      int? sent,
      Map<String, String> metas,
      Map<String, MessageReadStatus> readStatus,
      List<MessageAttachment> messageAttachments,
      String? transportGuid,
      String? remark,
      String? conversationGuid,
      String? subject,
      Set<String> invoiceIds,
      String? parentId,
      String? externalRef,
      Set<String> unassignedResults,
      Map<String, String> assignedResults,
      Map<String, String> senderReferences,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$DecryptedMessageCopyWithImpl<$Res>
    implements $DecryptedMessageCopyWith<$Res> {
  _$DecryptedMessageCopyWithImpl(this._self, this._then);

  final DecryptedMessage _self;
  final $Res Function(DecryptedMessage) _then;

  /// Create a copy of DecryptedMessage
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
    Object? fromAddress = freezed,
    Object? fromHealthcarePartyId = freezed,
    Object? formId = freezed,
    Object? status = freezed,
    Object? recipientsType = freezed,
    Object? recipients = null,
    Object? toAddresses = null,
    Object? received = freezed,
    Object? sent = freezed,
    Object? metas = null,
    Object? readStatus = null,
    Object? messageAttachments = null,
    Object? transportGuid = freezed,
    Object? remark = freezed,
    Object? conversationGuid = freezed,
    Object? subject = freezed,
    Object? invoiceIds = null,
    Object? parentId = freezed,
    Object? externalRef = freezed,
    Object? unassignedResults = null,
    Object? assignedResults = null,
    Object? senderReferences = null,
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
      fromAddress: freezed == fromAddress
          ? _self.fromAddress
          : fromAddress // ignore: cast_nullable_to_non_nullable
              as String?,
      fromHealthcarePartyId: freezed == fromHealthcarePartyId
          ? _self.fromHealthcarePartyId
          : fromHealthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      formId: freezed == formId
          ? _self.formId
          : formId // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      recipientsType: freezed == recipientsType
          ? _self.recipientsType
          : recipientsType // ignore: cast_nullable_to_non_nullable
              as String?,
      recipients: null == recipients
          ? _self.recipients
          : recipients // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      toAddresses: null == toAddresses
          ? _self.toAddresses
          : toAddresses // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      received: freezed == received
          ? _self.received
          : received // ignore: cast_nullable_to_non_nullable
              as int?,
      sent: freezed == sent
          ? _self.sent
          : sent // ignore: cast_nullable_to_non_nullable
              as int?,
      metas: null == metas
          ? _self.metas
          : metas // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      readStatus: null == readStatus
          ? _self.readStatus
          : readStatus // ignore: cast_nullable_to_non_nullable
              as Map<String, MessageReadStatus>,
      messageAttachments: null == messageAttachments
          ? _self.messageAttachments
          : messageAttachments // ignore: cast_nullable_to_non_nullable
              as List<MessageAttachment>,
      transportGuid: freezed == transportGuid
          ? _self.transportGuid
          : transportGuid // ignore: cast_nullable_to_non_nullable
              as String?,
      remark: freezed == remark
          ? _self.remark
          : remark // ignore: cast_nullable_to_non_nullable
              as String?,
      conversationGuid: freezed == conversationGuid
          ? _self.conversationGuid
          : conversationGuid // ignore: cast_nullable_to_non_nullable
              as String?,
      subject: freezed == subject
          ? _self.subject
          : subject // ignore: cast_nullable_to_non_nullable
              as String?,
      invoiceIds: null == invoiceIds
          ? _self.invoiceIds
          : invoiceIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      parentId: freezed == parentId
          ? _self.parentId
          : parentId // ignore: cast_nullable_to_non_nullable
              as String?,
      externalRef: freezed == externalRef
          ? _self.externalRef
          : externalRef // ignore: cast_nullable_to_non_nullable
              as String?,
      unassignedResults: null == unassignedResults
          ? _self.unassignedResults
          : unassignedResults // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      assignedResults: null == assignedResults
          ? _self.assignedResults
          : assignedResults // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      senderReferences: null == senderReferences
          ? _self.senderReferences
          : senderReferences // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
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

  /// Create a copy of DecryptedMessage
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

class _DecryptedMessage implements DecryptedMessage {
  const _DecryptedMessage(
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
      this.fromAddress = null,
      this.fromHealthcarePartyId = null,
      this.formId = null,
      this.status = null,
      this.recipientsType = null,
      final Set<String> recipients = const {},
      final Set<String> toAddresses = const {},
      this.received = null,
      this.sent = null,
      final Map<String, String> metas = const {},
      final Map<String, MessageReadStatus> readStatus = const {},
      final List<MessageAttachment> messageAttachments = const [],
      this.transportGuid = null,
      this.remark = null,
      this.conversationGuid = null,
      this.subject = null,
      final Set<String> invoiceIds = const {},
      this.parentId = null,
      this.externalRef = null,
      final Set<String> unassignedResults = const {},
      final Map<String, String> assignedResults = const {},
      final Map<String, String> senderReferences = const {},
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null})
      : _tags = tags,
        _codes = codes,
        _recipients = recipients,
        _toAddresses = toAddresses,
        _metas = metas,
        _readStatus = readStatus,
        _messageAttachments = messageAttachments,
        _invoiceIds = invoiceIds,
        _unassignedResults = unassignedResults,
        _assignedResults = assignedResults,
        _senderReferences = senderReferences,
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
  final String? fromAddress;
  @override
  @JsonKey()
  final String? fromHealthcarePartyId;
  @override
  @JsonKey()
  final String? formId;
  @override
  @JsonKey()
  final int? status;
  @override
  @JsonKey()
  final String? recipientsType;
  final Set<String> _recipients;
  @override
  @JsonKey()
  Set<String> get recipients {
    if (_recipients is EqualUnmodifiableSetView) return _recipients;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_recipients);
  }

  final Set<String> _toAddresses;
  @override
  @JsonKey()
  Set<String> get toAddresses {
    if (_toAddresses is EqualUnmodifiableSetView) return _toAddresses;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_toAddresses);
  }

  @override
  @JsonKey()
  final int? received;
  @override
  @JsonKey()
  final int? sent;
  final Map<String, String> _metas;
  @override
  @JsonKey()
  Map<String, String> get metas {
    if (_metas is EqualUnmodifiableMapView) return _metas;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_metas);
  }

  final Map<String, MessageReadStatus> _readStatus;
  @override
  @JsonKey()
  Map<String, MessageReadStatus> get readStatus {
    if (_readStatus is EqualUnmodifiableMapView) return _readStatus;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_readStatus);
  }

  final List<MessageAttachment> _messageAttachments;
  @override
  @JsonKey()
  List<MessageAttachment> get messageAttachments {
    if (_messageAttachments is EqualUnmodifiableListView)
      return _messageAttachments;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_messageAttachments);
  }

  @override
  @JsonKey()
  final String? transportGuid;
  @override
  @JsonKey()
  final String? remark;
  @override
  @JsonKey()
  final String? conversationGuid;
  @override
  @JsonKey()
  final String? subject;
  final Set<String> _invoiceIds;
  @override
  @JsonKey()
  Set<String> get invoiceIds {
    if (_invoiceIds is EqualUnmodifiableSetView) return _invoiceIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_invoiceIds);
  }

  @override
  @JsonKey()
  final String? parentId;
  @override
  @JsonKey()
  final String? externalRef;
  final Set<String> _unassignedResults;
  @override
  @JsonKey()
  Set<String> get unassignedResults {
    if (_unassignedResults is EqualUnmodifiableSetView)
      return _unassignedResults;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_unassignedResults);
  }

  final Map<String, String> _assignedResults;
  @override
  @JsonKey()
  Map<String, String> get assignedResults {
    if (_assignedResults is EqualUnmodifiableMapView) return _assignedResults;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_assignedResults);
  }

  final Map<String, String> _senderReferences;
  @override
  @JsonKey()
  Map<String, String> get senderReferences {
    if (_senderReferences is EqualUnmodifiableMapView) return _senderReferences;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_senderReferences);
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

  /// Create a copy of DecryptedMessage
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedMessageCopyWith<_DecryptedMessage> get copyWith =>
      __$DecryptedMessageCopyWithImpl<_DecryptedMessage>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedMessage &&
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
            (identical(other.fromAddress, fromAddress) ||
                other.fromAddress == fromAddress) &&
            (identical(other.fromHealthcarePartyId, fromHealthcarePartyId) ||
                other.fromHealthcarePartyId == fromHealthcarePartyId) &&
            (identical(other.formId, formId) || other.formId == formId) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.recipientsType, recipientsType) ||
                other.recipientsType == recipientsType) &&
            const DeepCollectionEquality()
                .equals(other._recipients, _recipients) &&
            const DeepCollectionEquality()
                .equals(other._toAddresses, _toAddresses) &&
            (identical(other.received, received) ||
                other.received == received) &&
            (identical(other.sent, sent) || other.sent == sent) &&
            const DeepCollectionEquality().equals(other._metas, _metas) &&
            const DeepCollectionEquality()
                .equals(other._readStatus, _readStatus) &&
            const DeepCollectionEquality()
                .equals(other._messageAttachments, _messageAttachments) &&
            (identical(other.transportGuid, transportGuid) ||
                other.transportGuid == transportGuid) &&
            (identical(other.remark, remark) || other.remark == remark) &&
            (identical(other.conversationGuid, conversationGuid) ||
                other.conversationGuid == conversationGuid) &&
            (identical(other.subject, subject) || other.subject == subject) &&
            const DeepCollectionEquality()
                .equals(other._invoiceIds, _invoiceIds) &&
            (identical(other.parentId, parentId) ||
                other.parentId == parentId) &&
            (identical(other.externalRef, externalRef) ||
                other.externalRef == externalRef) &&
            const DeepCollectionEquality()
                .equals(other._unassignedResults, _unassignedResults) &&
            const DeepCollectionEquality()
                .equals(other._assignedResults, _assignedResults) &&
            const DeepCollectionEquality()
                .equals(other._senderReferences, _senderReferences) &&
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
        fromAddress,
        fromHealthcarePartyId,
        formId,
        status,
        recipientsType,
        const DeepCollectionEquality().hash(_recipients),
        const DeepCollectionEquality().hash(_toAddresses),
        received,
        sent,
        const DeepCollectionEquality().hash(_metas),
        const DeepCollectionEquality().hash(_readStatus),
        const DeepCollectionEquality().hash(_messageAttachments),
        transportGuid,
        remark,
        conversationGuid,
        subject,
        const DeepCollectionEquality().hash(_invoiceIds),
        parentId,
        externalRef,
        const DeepCollectionEquality().hash(_unassignedResults),
        const DeepCollectionEquality().hash(_assignedResults),
        const DeepCollectionEquality().hash(_senderReferences),
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'DecryptedMessage(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, fromAddress: $fromAddress, fromHealthcarePartyId: $fromHealthcarePartyId, formId: $formId, status: $status, recipientsType: $recipientsType, recipients: $recipients, toAddresses: $toAddresses, received: $received, sent: $sent, metas: $metas, readStatus: $readStatus, messageAttachments: $messageAttachments, transportGuid: $transportGuid, remark: $remark, conversationGuid: $conversationGuid, subject: $subject, invoiceIds: $invoiceIds, parentId: $parentId, externalRef: $externalRef, unassignedResults: $unassignedResults, assignedResults: $assignedResults, senderReferences: $senderReferences, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedMessageCopyWith<$Res>
    implements $DecryptedMessageCopyWith<$Res> {
  factory _$DecryptedMessageCopyWith(
          _DecryptedMessage value, $Res Function(_DecryptedMessage) _then) =
      __$DecryptedMessageCopyWithImpl;
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
      String? fromAddress,
      String? fromHealthcarePartyId,
      String? formId,
      int? status,
      String? recipientsType,
      Set<String> recipients,
      Set<String> toAddresses,
      int? received,
      int? sent,
      Map<String, String> metas,
      Map<String, MessageReadStatus> readStatus,
      List<MessageAttachment> messageAttachments,
      String? transportGuid,
      String? remark,
      String? conversationGuid,
      String? subject,
      Set<String> invoiceIds,
      String? parentId,
      String? externalRef,
      Set<String> unassignedResults,
      Map<String, String> assignedResults,
      Map<String, String> senderReferences,
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
class __$DecryptedMessageCopyWithImpl<$Res>
    implements _$DecryptedMessageCopyWith<$Res> {
  __$DecryptedMessageCopyWithImpl(this._self, this._then);

  final _DecryptedMessage _self;
  final $Res Function(_DecryptedMessage) _then;

  /// Create a copy of DecryptedMessage
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
    Object? fromAddress = freezed,
    Object? fromHealthcarePartyId = freezed,
    Object? formId = freezed,
    Object? status = freezed,
    Object? recipientsType = freezed,
    Object? recipients = null,
    Object? toAddresses = null,
    Object? received = freezed,
    Object? sent = freezed,
    Object? metas = null,
    Object? readStatus = null,
    Object? messageAttachments = null,
    Object? transportGuid = freezed,
    Object? remark = freezed,
    Object? conversationGuid = freezed,
    Object? subject = freezed,
    Object? invoiceIds = null,
    Object? parentId = freezed,
    Object? externalRef = freezed,
    Object? unassignedResults = null,
    Object? assignedResults = null,
    Object? senderReferences = null,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_DecryptedMessage(
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
      fromAddress: freezed == fromAddress
          ? _self.fromAddress
          : fromAddress // ignore: cast_nullable_to_non_nullable
              as String?,
      fromHealthcarePartyId: freezed == fromHealthcarePartyId
          ? _self.fromHealthcarePartyId
          : fromHealthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      formId: freezed == formId
          ? _self.formId
          : formId // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      recipientsType: freezed == recipientsType
          ? _self.recipientsType
          : recipientsType // ignore: cast_nullable_to_non_nullable
              as String?,
      recipients: null == recipients
          ? _self._recipients
          : recipients // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      toAddresses: null == toAddresses
          ? _self._toAddresses
          : toAddresses // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      received: freezed == received
          ? _self.received
          : received // ignore: cast_nullable_to_non_nullable
              as int?,
      sent: freezed == sent
          ? _self.sent
          : sent // ignore: cast_nullable_to_non_nullable
              as int?,
      metas: null == metas
          ? _self._metas
          : metas // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      readStatus: null == readStatus
          ? _self._readStatus
          : readStatus // ignore: cast_nullable_to_non_nullable
              as Map<String, MessageReadStatus>,
      messageAttachments: null == messageAttachments
          ? _self._messageAttachments
          : messageAttachments // ignore: cast_nullable_to_non_nullable
              as List<MessageAttachment>,
      transportGuid: freezed == transportGuid
          ? _self.transportGuid
          : transportGuid // ignore: cast_nullable_to_non_nullable
              as String?,
      remark: freezed == remark
          ? _self.remark
          : remark // ignore: cast_nullable_to_non_nullable
              as String?,
      conversationGuid: freezed == conversationGuid
          ? _self.conversationGuid
          : conversationGuid // ignore: cast_nullable_to_non_nullable
              as String?,
      subject: freezed == subject
          ? _self.subject
          : subject // ignore: cast_nullable_to_non_nullable
              as String?,
      invoiceIds: null == invoiceIds
          ? _self._invoiceIds
          : invoiceIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      parentId: freezed == parentId
          ? _self.parentId
          : parentId // ignore: cast_nullable_to_non_nullable
              as String?,
      externalRef: freezed == externalRef
          ? _self.externalRef
          : externalRef // ignore: cast_nullable_to_non_nullable
              as String?,
      unassignedResults: null == unassignedResults
          ? _self._unassignedResults
          : unassignedResults // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      assignedResults: null == assignedResults
          ? _self._assignedResults
          : assignedResults // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      senderReferences: null == senderReferences
          ? _self._senderReferences
          : senderReferences // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
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

  /// Create a copy of DecryptedMessage
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
mixin _$EncryptedMessage {
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
  String? get fromAddress;
  String? get fromHealthcarePartyId;
  String? get formId;
  int? get status;
  String? get recipientsType;
  Set<String> get recipients;
  Set<String> get toAddresses;
  int? get received;
  int? get sent;
  Map<String, String> get metas;
  Map<String, MessageReadStatus> get readStatus;
  List<MessageAttachment> get messageAttachments;
  String? get transportGuid;
  String? get remark;
  String? get conversationGuid;
  String? get subject;
  Set<String> get invoiceIds;
  String? get parentId;
  String? get externalRef;
  Set<String> get unassignedResults;
  Map<String, String> get assignedResults;
  Map<String, String> get senderReferences;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  Base64String? get encryptedSelf;
  SecurityMetadata? get securityMetadata;

  /// Create a copy of EncryptedMessage
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedMessageCopyWith<EncryptedMessage> get copyWith =>
      _$EncryptedMessageCopyWithImpl<EncryptedMessage>(
          this as EncryptedMessage, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedMessage &&
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
            (identical(other.fromAddress, fromAddress) ||
                other.fromAddress == fromAddress) &&
            (identical(other.fromHealthcarePartyId, fromHealthcarePartyId) ||
                other.fromHealthcarePartyId == fromHealthcarePartyId) &&
            (identical(other.formId, formId) || other.formId == formId) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.recipientsType, recipientsType) ||
                other.recipientsType == recipientsType) &&
            const DeepCollectionEquality()
                .equals(other.recipients, recipients) &&
            const DeepCollectionEquality()
                .equals(other.toAddresses, toAddresses) &&
            (identical(other.received, received) ||
                other.received == received) &&
            (identical(other.sent, sent) || other.sent == sent) &&
            const DeepCollectionEquality().equals(other.metas, metas) &&
            const DeepCollectionEquality()
                .equals(other.readStatus, readStatus) &&
            const DeepCollectionEquality()
                .equals(other.messageAttachments, messageAttachments) &&
            (identical(other.transportGuid, transportGuid) ||
                other.transportGuid == transportGuid) &&
            (identical(other.remark, remark) || other.remark == remark) &&
            (identical(other.conversationGuid, conversationGuid) ||
                other.conversationGuid == conversationGuid) &&
            (identical(other.subject, subject) || other.subject == subject) &&
            const DeepCollectionEquality()
                .equals(other.invoiceIds, invoiceIds) &&
            (identical(other.parentId, parentId) ||
                other.parentId == parentId) &&
            (identical(other.externalRef, externalRef) ||
                other.externalRef == externalRef) &&
            const DeepCollectionEquality()
                .equals(other.unassignedResults, unassignedResults) &&
            const DeepCollectionEquality()
                .equals(other.assignedResults, assignedResults) &&
            const DeepCollectionEquality()
                .equals(other.senderReferences, senderReferences) &&
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
        fromAddress,
        fromHealthcarePartyId,
        formId,
        status,
        recipientsType,
        const DeepCollectionEquality().hash(recipients),
        const DeepCollectionEquality().hash(toAddresses),
        received,
        sent,
        const DeepCollectionEquality().hash(metas),
        const DeepCollectionEquality().hash(readStatus),
        const DeepCollectionEquality().hash(messageAttachments),
        transportGuid,
        remark,
        conversationGuid,
        subject,
        const DeepCollectionEquality().hash(invoiceIds),
        parentId,
        externalRef,
        const DeepCollectionEquality().hash(unassignedResults),
        const DeepCollectionEquality().hash(assignedResults),
        const DeepCollectionEquality().hash(senderReferences),
        const DeepCollectionEquality().hash(secretForeignKeys),
        const DeepCollectionEquality().hash(cryptedForeignKeys),
        const DeepCollectionEquality().hash(delegations),
        const DeepCollectionEquality().hash(encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'EncryptedMessage(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, fromAddress: $fromAddress, fromHealthcarePartyId: $fromHealthcarePartyId, formId: $formId, status: $status, recipientsType: $recipientsType, recipients: $recipients, toAddresses: $toAddresses, received: $received, sent: $sent, metas: $metas, readStatus: $readStatus, messageAttachments: $messageAttachments, transportGuid: $transportGuid, remark: $remark, conversationGuid: $conversationGuid, subject: $subject, invoiceIds: $invoiceIds, parentId: $parentId, externalRef: $externalRef, unassignedResults: $unassignedResults, assignedResults: $assignedResults, senderReferences: $senderReferences, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class $EncryptedMessageCopyWith<$Res> {
  factory $EncryptedMessageCopyWith(
          EncryptedMessage value, $Res Function(EncryptedMessage) _then) =
      _$EncryptedMessageCopyWithImpl;
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
      String? fromAddress,
      String? fromHealthcarePartyId,
      String? formId,
      int? status,
      String? recipientsType,
      Set<String> recipients,
      Set<String> toAddresses,
      int? received,
      int? sent,
      Map<String, String> metas,
      Map<String, MessageReadStatus> readStatus,
      List<MessageAttachment> messageAttachments,
      String? transportGuid,
      String? remark,
      String? conversationGuid,
      String? subject,
      Set<String> invoiceIds,
      String? parentId,
      String? externalRef,
      Set<String> unassignedResults,
      Map<String, String> assignedResults,
      Map<String, String> senderReferences,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      Base64String? encryptedSelf,
      SecurityMetadata? securityMetadata});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$EncryptedMessageCopyWithImpl<$Res>
    implements $EncryptedMessageCopyWith<$Res> {
  _$EncryptedMessageCopyWithImpl(this._self, this._then);

  final EncryptedMessage _self;
  final $Res Function(EncryptedMessage) _then;

  /// Create a copy of EncryptedMessage
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
    Object? fromAddress = freezed,
    Object? fromHealthcarePartyId = freezed,
    Object? formId = freezed,
    Object? status = freezed,
    Object? recipientsType = freezed,
    Object? recipients = null,
    Object? toAddresses = null,
    Object? received = freezed,
    Object? sent = freezed,
    Object? metas = null,
    Object? readStatus = null,
    Object? messageAttachments = null,
    Object? transportGuid = freezed,
    Object? remark = freezed,
    Object? conversationGuid = freezed,
    Object? subject = freezed,
    Object? invoiceIds = null,
    Object? parentId = freezed,
    Object? externalRef = freezed,
    Object? unassignedResults = null,
    Object? assignedResults = null,
    Object? senderReferences = null,
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
      fromAddress: freezed == fromAddress
          ? _self.fromAddress
          : fromAddress // ignore: cast_nullable_to_non_nullable
              as String?,
      fromHealthcarePartyId: freezed == fromHealthcarePartyId
          ? _self.fromHealthcarePartyId
          : fromHealthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      formId: freezed == formId
          ? _self.formId
          : formId // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      recipientsType: freezed == recipientsType
          ? _self.recipientsType
          : recipientsType // ignore: cast_nullable_to_non_nullable
              as String?,
      recipients: null == recipients
          ? _self.recipients
          : recipients // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      toAddresses: null == toAddresses
          ? _self.toAddresses
          : toAddresses // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      received: freezed == received
          ? _self.received
          : received // ignore: cast_nullable_to_non_nullable
              as int?,
      sent: freezed == sent
          ? _self.sent
          : sent // ignore: cast_nullable_to_non_nullable
              as int?,
      metas: null == metas
          ? _self.metas
          : metas // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      readStatus: null == readStatus
          ? _self.readStatus
          : readStatus // ignore: cast_nullable_to_non_nullable
              as Map<String, MessageReadStatus>,
      messageAttachments: null == messageAttachments
          ? _self.messageAttachments
          : messageAttachments // ignore: cast_nullable_to_non_nullable
              as List<MessageAttachment>,
      transportGuid: freezed == transportGuid
          ? _self.transportGuid
          : transportGuid // ignore: cast_nullable_to_non_nullable
              as String?,
      remark: freezed == remark
          ? _self.remark
          : remark // ignore: cast_nullable_to_non_nullable
              as String?,
      conversationGuid: freezed == conversationGuid
          ? _self.conversationGuid
          : conversationGuid // ignore: cast_nullable_to_non_nullable
              as String?,
      subject: freezed == subject
          ? _self.subject
          : subject // ignore: cast_nullable_to_non_nullable
              as String?,
      invoiceIds: null == invoiceIds
          ? _self.invoiceIds
          : invoiceIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      parentId: freezed == parentId
          ? _self.parentId
          : parentId // ignore: cast_nullable_to_non_nullable
              as String?,
      externalRef: freezed == externalRef
          ? _self.externalRef
          : externalRef // ignore: cast_nullable_to_non_nullable
              as String?,
      unassignedResults: null == unassignedResults
          ? _self.unassignedResults
          : unassignedResults // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      assignedResults: null == assignedResults
          ? _self.assignedResults
          : assignedResults // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      senderReferences: null == senderReferences
          ? _self.senderReferences
          : senderReferences // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
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

  /// Create a copy of EncryptedMessage
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

class _EncryptedMessage implements EncryptedMessage {
  const _EncryptedMessage(
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
      this.fromAddress = null,
      this.fromHealthcarePartyId = null,
      this.formId = null,
      this.status = null,
      this.recipientsType = null,
      final Set<String> recipients = const {},
      final Set<String> toAddresses = const {},
      this.received = null,
      this.sent = null,
      final Map<String, String> metas = const {},
      final Map<String, MessageReadStatus> readStatus = const {},
      final List<MessageAttachment> messageAttachments = const [],
      this.transportGuid = null,
      this.remark = null,
      this.conversationGuid = null,
      this.subject = null,
      final Set<String> invoiceIds = const {},
      this.parentId = null,
      this.externalRef = null,
      final Set<String> unassignedResults = const {},
      final Map<String, String> assignedResults = const {},
      final Map<String, String> senderReferences = const {},
      final Set<String> secretForeignKeys = const {},
      final Map<String, Set<Delegation>> cryptedForeignKeys = const {},
      final Map<String, Set<Delegation>> delegations = const {},
      final Map<String, Set<Delegation>> encryptionKeys = const {},
      this.encryptedSelf = null,
      this.securityMetadata = null})
      : _tags = tags,
        _codes = codes,
        _recipients = recipients,
        _toAddresses = toAddresses,
        _metas = metas,
        _readStatus = readStatus,
        _messageAttachments = messageAttachments,
        _invoiceIds = invoiceIds,
        _unassignedResults = unassignedResults,
        _assignedResults = assignedResults,
        _senderReferences = senderReferences,
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
  final String? fromAddress;
  @override
  @JsonKey()
  final String? fromHealthcarePartyId;
  @override
  @JsonKey()
  final String? formId;
  @override
  @JsonKey()
  final int? status;
  @override
  @JsonKey()
  final String? recipientsType;
  final Set<String> _recipients;
  @override
  @JsonKey()
  Set<String> get recipients {
    if (_recipients is EqualUnmodifiableSetView) return _recipients;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_recipients);
  }

  final Set<String> _toAddresses;
  @override
  @JsonKey()
  Set<String> get toAddresses {
    if (_toAddresses is EqualUnmodifiableSetView) return _toAddresses;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_toAddresses);
  }

  @override
  @JsonKey()
  final int? received;
  @override
  @JsonKey()
  final int? sent;
  final Map<String, String> _metas;
  @override
  @JsonKey()
  Map<String, String> get metas {
    if (_metas is EqualUnmodifiableMapView) return _metas;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_metas);
  }

  final Map<String, MessageReadStatus> _readStatus;
  @override
  @JsonKey()
  Map<String, MessageReadStatus> get readStatus {
    if (_readStatus is EqualUnmodifiableMapView) return _readStatus;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_readStatus);
  }

  final List<MessageAttachment> _messageAttachments;
  @override
  @JsonKey()
  List<MessageAttachment> get messageAttachments {
    if (_messageAttachments is EqualUnmodifiableListView)
      return _messageAttachments;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_messageAttachments);
  }

  @override
  @JsonKey()
  final String? transportGuid;
  @override
  @JsonKey()
  final String? remark;
  @override
  @JsonKey()
  final String? conversationGuid;
  @override
  @JsonKey()
  final String? subject;
  final Set<String> _invoiceIds;
  @override
  @JsonKey()
  Set<String> get invoiceIds {
    if (_invoiceIds is EqualUnmodifiableSetView) return _invoiceIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_invoiceIds);
  }

  @override
  @JsonKey()
  final String? parentId;
  @override
  @JsonKey()
  final String? externalRef;
  final Set<String> _unassignedResults;
  @override
  @JsonKey()
  Set<String> get unassignedResults {
    if (_unassignedResults is EqualUnmodifiableSetView)
      return _unassignedResults;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_unassignedResults);
  }

  final Map<String, String> _assignedResults;
  @override
  @JsonKey()
  Map<String, String> get assignedResults {
    if (_assignedResults is EqualUnmodifiableMapView) return _assignedResults;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_assignedResults);
  }

  final Map<String, String> _senderReferences;
  @override
  @JsonKey()
  Map<String, String> get senderReferences {
    if (_senderReferences is EqualUnmodifiableMapView) return _senderReferences;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_senderReferences);
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

  /// Create a copy of EncryptedMessage
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedMessageCopyWith<_EncryptedMessage> get copyWith =>
      __$EncryptedMessageCopyWithImpl<_EncryptedMessage>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedMessage &&
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
            (identical(other.fromAddress, fromAddress) ||
                other.fromAddress == fromAddress) &&
            (identical(other.fromHealthcarePartyId, fromHealthcarePartyId) ||
                other.fromHealthcarePartyId == fromHealthcarePartyId) &&
            (identical(other.formId, formId) || other.formId == formId) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.recipientsType, recipientsType) ||
                other.recipientsType == recipientsType) &&
            const DeepCollectionEquality()
                .equals(other._recipients, _recipients) &&
            const DeepCollectionEquality()
                .equals(other._toAddresses, _toAddresses) &&
            (identical(other.received, received) ||
                other.received == received) &&
            (identical(other.sent, sent) || other.sent == sent) &&
            const DeepCollectionEquality().equals(other._metas, _metas) &&
            const DeepCollectionEquality()
                .equals(other._readStatus, _readStatus) &&
            const DeepCollectionEquality()
                .equals(other._messageAttachments, _messageAttachments) &&
            (identical(other.transportGuid, transportGuid) ||
                other.transportGuid == transportGuid) &&
            (identical(other.remark, remark) || other.remark == remark) &&
            (identical(other.conversationGuid, conversationGuid) ||
                other.conversationGuid == conversationGuid) &&
            (identical(other.subject, subject) || other.subject == subject) &&
            const DeepCollectionEquality()
                .equals(other._invoiceIds, _invoiceIds) &&
            (identical(other.parentId, parentId) ||
                other.parentId == parentId) &&
            (identical(other.externalRef, externalRef) ||
                other.externalRef == externalRef) &&
            const DeepCollectionEquality()
                .equals(other._unassignedResults, _unassignedResults) &&
            const DeepCollectionEquality()
                .equals(other._assignedResults, _assignedResults) &&
            const DeepCollectionEquality()
                .equals(other._senderReferences, _senderReferences) &&
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
        fromAddress,
        fromHealthcarePartyId,
        formId,
        status,
        recipientsType,
        const DeepCollectionEquality().hash(_recipients),
        const DeepCollectionEquality().hash(_toAddresses),
        received,
        sent,
        const DeepCollectionEquality().hash(_metas),
        const DeepCollectionEquality().hash(_readStatus),
        const DeepCollectionEquality().hash(_messageAttachments),
        transportGuid,
        remark,
        conversationGuid,
        subject,
        const DeepCollectionEquality().hash(_invoiceIds),
        parentId,
        externalRef,
        const DeepCollectionEquality().hash(_unassignedResults),
        const DeepCollectionEquality().hash(_assignedResults),
        const DeepCollectionEquality().hash(_senderReferences),
        const DeepCollectionEquality().hash(_secretForeignKeys),
        const DeepCollectionEquality().hash(_cryptedForeignKeys),
        const DeepCollectionEquality().hash(_delegations),
        const DeepCollectionEquality().hash(_encryptionKeys),
        encryptedSelf,
        securityMetadata
      ]);

  @override
  String toString() {
    return 'EncryptedMessage(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, fromAddress: $fromAddress, fromHealthcarePartyId: $fromHealthcarePartyId, formId: $formId, status: $status, recipientsType: $recipientsType, recipients: $recipients, toAddresses: $toAddresses, received: $received, sent: $sent, metas: $metas, readStatus: $readStatus, messageAttachments: $messageAttachments, transportGuid: $transportGuid, remark: $remark, conversationGuid: $conversationGuid, subject: $subject, invoiceIds: $invoiceIds, parentId: $parentId, externalRef: $externalRef, unassignedResults: $unassignedResults, assignedResults: $assignedResults, senderReferences: $senderReferences, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, encryptedSelf: $encryptedSelf, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedMessageCopyWith<$Res>
    implements $EncryptedMessageCopyWith<$Res> {
  factory _$EncryptedMessageCopyWith(
          _EncryptedMessage value, $Res Function(_EncryptedMessage) _then) =
      __$EncryptedMessageCopyWithImpl;
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
      String? fromAddress,
      String? fromHealthcarePartyId,
      String? formId,
      int? status,
      String? recipientsType,
      Set<String> recipients,
      Set<String> toAddresses,
      int? received,
      int? sent,
      Map<String, String> metas,
      Map<String, MessageReadStatus> readStatus,
      List<MessageAttachment> messageAttachments,
      String? transportGuid,
      String? remark,
      String? conversationGuid,
      String? subject,
      Set<String> invoiceIds,
      String? parentId,
      String? externalRef,
      Set<String> unassignedResults,
      Map<String, String> assignedResults,
      Map<String, String> senderReferences,
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
class __$EncryptedMessageCopyWithImpl<$Res>
    implements _$EncryptedMessageCopyWith<$Res> {
  __$EncryptedMessageCopyWithImpl(this._self, this._then);

  final _EncryptedMessage _self;
  final $Res Function(_EncryptedMessage) _then;

  /// Create a copy of EncryptedMessage
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
    Object? fromAddress = freezed,
    Object? fromHealthcarePartyId = freezed,
    Object? formId = freezed,
    Object? status = freezed,
    Object? recipientsType = freezed,
    Object? recipients = null,
    Object? toAddresses = null,
    Object? received = freezed,
    Object? sent = freezed,
    Object? metas = null,
    Object? readStatus = null,
    Object? messageAttachments = null,
    Object? transportGuid = freezed,
    Object? remark = freezed,
    Object? conversationGuid = freezed,
    Object? subject = freezed,
    Object? invoiceIds = null,
    Object? parentId = freezed,
    Object? externalRef = freezed,
    Object? unassignedResults = null,
    Object? assignedResults = null,
    Object? senderReferences = null,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? encryptedSelf = freezed,
    Object? securityMetadata = freezed,
  }) {
    return _then(_EncryptedMessage(
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
      fromAddress: freezed == fromAddress
          ? _self.fromAddress
          : fromAddress // ignore: cast_nullable_to_non_nullable
              as String?,
      fromHealthcarePartyId: freezed == fromHealthcarePartyId
          ? _self.fromHealthcarePartyId
          : fromHealthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      formId: freezed == formId
          ? _self.formId
          : formId // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as int?,
      recipientsType: freezed == recipientsType
          ? _self.recipientsType
          : recipientsType // ignore: cast_nullable_to_non_nullable
              as String?,
      recipients: null == recipients
          ? _self._recipients
          : recipients // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      toAddresses: null == toAddresses
          ? _self._toAddresses
          : toAddresses // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      received: freezed == received
          ? _self.received
          : received // ignore: cast_nullable_to_non_nullable
              as int?,
      sent: freezed == sent
          ? _self.sent
          : sent // ignore: cast_nullable_to_non_nullable
              as int?,
      metas: null == metas
          ? _self._metas
          : metas // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      readStatus: null == readStatus
          ? _self._readStatus
          : readStatus // ignore: cast_nullable_to_non_nullable
              as Map<String, MessageReadStatus>,
      messageAttachments: null == messageAttachments
          ? _self._messageAttachments
          : messageAttachments // ignore: cast_nullable_to_non_nullable
              as List<MessageAttachment>,
      transportGuid: freezed == transportGuid
          ? _self.transportGuid
          : transportGuid // ignore: cast_nullable_to_non_nullable
              as String?,
      remark: freezed == remark
          ? _self.remark
          : remark // ignore: cast_nullable_to_non_nullable
              as String?,
      conversationGuid: freezed == conversationGuid
          ? _self.conversationGuid
          : conversationGuid // ignore: cast_nullable_to_non_nullable
              as String?,
      subject: freezed == subject
          ? _self.subject
          : subject // ignore: cast_nullable_to_non_nullable
              as String?,
      invoiceIds: null == invoiceIds
          ? _self._invoiceIds
          : invoiceIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      parentId: freezed == parentId
          ? _self.parentId
          : parentId // ignore: cast_nullable_to_non_nullable
              as String?,
      externalRef: freezed == externalRef
          ? _self.externalRef
          : externalRef // ignore: cast_nullable_to_non_nullable
              as String?,
      unassignedResults: null == unassignedResults
          ? _self._unassignedResults
          : unassignedResults // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      assignedResults: null == assignedResults
          ? _self._assignedResults
          : assignedResults // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      senderReferences: null == senderReferences
          ? _self._senderReferences
          : senderReferences // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
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

  /// Create a copy of EncryptedMessage
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
