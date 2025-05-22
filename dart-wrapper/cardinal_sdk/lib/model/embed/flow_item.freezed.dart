// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'flow_item.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$FlowItem {
  String? get id;
  String? get title;
  String? get comment;
  int? get receptionDate;
  int? get processingDate;
  String? get processer;
  int? get cancellationDate;
  String? get canceller;
  String? get cancellationReason;
  String? get cancellationNote;
  String? get status;
  bool? get homeVisit;
  String? get municipality;
  String? get town;
  String? get zipCode;
  String? get street;
  String? get building;
  String? get buildingNumber;
  String? get doorbellName;
  String? get floor;
  String? get letterBox;
  String? get notesOps;
  String? get notesContact;
  String? get latitude;
  String? get longitude;
  String? get type;
  bool? get emergency;
  String? get phoneNumber;
  String? get patientId;
  String? get patientLastName;
  String? get patientFirstName;
  String? get description;
  String? get interventionCode;

  /// Create a copy of FlowItem
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $FlowItemCopyWith<FlowItem> get copyWith =>
      _$FlowItemCopyWithImpl<FlowItem>(this as FlowItem, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is FlowItem &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.title, title) || other.title == title) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.receptionDate, receptionDate) ||
                other.receptionDate == receptionDate) &&
            (identical(other.processingDate, processingDate) ||
                other.processingDate == processingDate) &&
            (identical(other.processer, processer) ||
                other.processer == processer) &&
            (identical(other.cancellationDate, cancellationDate) ||
                other.cancellationDate == cancellationDate) &&
            (identical(other.canceller, canceller) ||
                other.canceller == canceller) &&
            (identical(other.cancellationReason, cancellationReason) ||
                other.cancellationReason == cancellationReason) &&
            (identical(other.cancellationNote, cancellationNote) ||
                other.cancellationNote == cancellationNote) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.homeVisit, homeVisit) ||
                other.homeVisit == homeVisit) &&
            (identical(other.municipality, municipality) ||
                other.municipality == municipality) &&
            (identical(other.town, town) || other.town == town) &&
            (identical(other.zipCode, zipCode) || other.zipCode == zipCode) &&
            (identical(other.street, street) || other.street == street) &&
            (identical(other.building, building) ||
                other.building == building) &&
            (identical(other.buildingNumber, buildingNumber) ||
                other.buildingNumber == buildingNumber) &&
            (identical(other.doorbellName, doorbellName) ||
                other.doorbellName == doorbellName) &&
            (identical(other.floor, floor) || other.floor == floor) &&
            (identical(other.letterBox, letterBox) ||
                other.letterBox == letterBox) &&
            (identical(other.notesOps, notesOps) ||
                other.notesOps == notesOps) &&
            (identical(other.notesContact, notesContact) ||
                other.notesContact == notesContact) &&
            (identical(other.latitude, latitude) ||
                other.latitude == latitude) &&
            (identical(other.longitude, longitude) ||
                other.longitude == longitude) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.emergency, emergency) ||
                other.emergency == emergency) &&
            (identical(other.phoneNumber, phoneNumber) ||
                other.phoneNumber == phoneNumber) &&
            (identical(other.patientId, patientId) ||
                other.patientId == patientId) &&
            (identical(other.patientLastName, patientLastName) ||
                other.patientLastName == patientLastName) &&
            (identical(other.patientFirstName, patientFirstName) ||
                other.patientFirstName == patientFirstName) &&
            (identical(other.description, description) ||
                other.description == description) &&
            (identical(other.interventionCode, interventionCode) ||
                other.interventionCode == interventionCode));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        title,
        comment,
        receptionDate,
        processingDate,
        processer,
        cancellationDate,
        canceller,
        cancellationReason,
        cancellationNote,
        status,
        homeVisit,
        municipality,
        town,
        zipCode,
        street,
        building,
        buildingNumber,
        doorbellName,
        floor,
        letterBox,
        notesOps,
        notesContact,
        latitude,
        longitude,
        type,
        emergency,
        phoneNumber,
        patientId,
        patientLastName,
        patientFirstName,
        description,
        interventionCode
      ]);

  @override
  String toString() {
    return 'FlowItem(id: $id, title: $title, comment: $comment, receptionDate: $receptionDate, processingDate: $processingDate, processer: $processer, cancellationDate: $cancellationDate, canceller: $canceller, cancellationReason: $cancellationReason, cancellationNote: $cancellationNote, status: $status, homeVisit: $homeVisit, municipality: $municipality, town: $town, zipCode: $zipCode, street: $street, building: $building, buildingNumber: $buildingNumber, doorbellName: $doorbellName, floor: $floor, letterBox: $letterBox, notesOps: $notesOps, notesContact: $notesContact, latitude: $latitude, longitude: $longitude, type: $type, emergency: $emergency, phoneNumber: $phoneNumber, patientId: $patientId, patientLastName: $patientLastName, patientFirstName: $patientFirstName, description: $description, interventionCode: $interventionCode)';
  }
}

/// @nodoc
abstract mixin class $FlowItemCopyWith<$Res> {
  factory $FlowItemCopyWith(FlowItem value, $Res Function(FlowItem) _then) =
      _$FlowItemCopyWithImpl;
  @useResult
  $Res call(
      {String? id,
      String? title,
      String? comment,
      int? receptionDate,
      int? processingDate,
      String? processer,
      int? cancellationDate,
      String? canceller,
      String? cancellationReason,
      String? cancellationNote,
      String? status,
      bool? homeVisit,
      String? municipality,
      String? town,
      String? zipCode,
      String? street,
      String? building,
      String? buildingNumber,
      String? doorbellName,
      String? floor,
      String? letterBox,
      String? notesOps,
      String? notesContact,
      String? latitude,
      String? longitude,
      String? type,
      bool? emergency,
      String? phoneNumber,
      String? patientId,
      String? patientLastName,
      String? patientFirstName,
      String? description,
      String? interventionCode});
}

/// @nodoc
class _$FlowItemCopyWithImpl<$Res> implements $FlowItemCopyWith<$Res> {
  _$FlowItemCopyWithImpl(this._self, this._then);

  final FlowItem _self;
  final $Res Function(FlowItem) _then;

  /// Create a copy of FlowItem
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = freezed,
    Object? title = freezed,
    Object? comment = freezed,
    Object? receptionDate = freezed,
    Object? processingDate = freezed,
    Object? processer = freezed,
    Object? cancellationDate = freezed,
    Object? canceller = freezed,
    Object? cancellationReason = freezed,
    Object? cancellationNote = freezed,
    Object? status = freezed,
    Object? homeVisit = freezed,
    Object? municipality = freezed,
    Object? town = freezed,
    Object? zipCode = freezed,
    Object? street = freezed,
    Object? building = freezed,
    Object? buildingNumber = freezed,
    Object? doorbellName = freezed,
    Object? floor = freezed,
    Object? letterBox = freezed,
    Object? notesOps = freezed,
    Object? notesContact = freezed,
    Object? latitude = freezed,
    Object? longitude = freezed,
    Object? type = freezed,
    Object? emergency = freezed,
    Object? phoneNumber = freezed,
    Object? patientId = freezed,
    Object? patientLastName = freezed,
    Object? patientFirstName = freezed,
    Object? description = freezed,
    Object? interventionCode = freezed,
  }) {
    return _then(_self.copyWith(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      title: freezed == title
          ? _self.title
          : title // ignore: cast_nullable_to_non_nullable
              as String?,
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      receptionDate: freezed == receptionDate
          ? _self.receptionDate
          : receptionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      processingDate: freezed == processingDate
          ? _self.processingDate
          : processingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      processer: freezed == processer
          ? _self.processer
          : processer // ignore: cast_nullable_to_non_nullable
              as String?,
      cancellationDate: freezed == cancellationDate
          ? _self.cancellationDate
          : cancellationDate // ignore: cast_nullable_to_non_nullable
              as int?,
      canceller: freezed == canceller
          ? _self.canceller
          : canceller // ignore: cast_nullable_to_non_nullable
              as String?,
      cancellationReason: freezed == cancellationReason
          ? _self.cancellationReason
          : cancellationReason // ignore: cast_nullable_to_non_nullable
              as String?,
      cancellationNote: freezed == cancellationNote
          ? _self.cancellationNote
          : cancellationNote // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as String?,
      homeVisit: freezed == homeVisit
          ? _self.homeVisit
          : homeVisit // ignore: cast_nullable_to_non_nullable
              as bool?,
      municipality: freezed == municipality
          ? _self.municipality
          : municipality // ignore: cast_nullable_to_non_nullable
              as String?,
      town: freezed == town
          ? _self.town
          : town // ignore: cast_nullable_to_non_nullable
              as String?,
      zipCode: freezed == zipCode
          ? _self.zipCode
          : zipCode // ignore: cast_nullable_to_non_nullable
              as String?,
      street: freezed == street
          ? _self.street
          : street // ignore: cast_nullable_to_non_nullable
              as String?,
      building: freezed == building
          ? _self.building
          : building // ignore: cast_nullable_to_non_nullable
              as String?,
      buildingNumber: freezed == buildingNumber
          ? _self.buildingNumber
          : buildingNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      doorbellName: freezed == doorbellName
          ? _self.doorbellName
          : doorbellName // ignore: cast_nullable_to_non_nullable
              as String?,
      floor: freezed == floor
          ? _self.floor
          : floor // ignore: cast_nullable_to_non_nullable
              as String?,
      letterBox: freezed == letterBox
          ? _self.letterBox
          : letterBox // ignore: cast_nullable_to_non_nullable
              as String?,
      notesOps: freezed == notesOps
          ? _self.notesOps
          : notesOps // ignore: cast_nullable_to_non_nullable
              as String?,
      notesContact: freezed == notesContact
          ? _self.notesContact
          : notesContact // ignore: cast_nullable_to_non_nullable
              as String?,
      latitude: freezed == latitude
          ? _self.latitude
          : latitude // ignore: cast_nullable_to_non_nullable
              as String?,
      longitude: freezed == longitude
          ? _self.longitude
          : longitude // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as String?,
      emergency: freezed == emergency
          ? _self.emergency
          : emergency // ignore: cast_nullable_to_non_nullable
              as bool?,
      phoneNumber: freezed == phoneNumber
          ? _self.phoneNumber
          : phoneNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      patientId: freezed == patientId
          ? _self.patientId
          : patientId // ignore: cast_nullable_to_non_nullable
              as String?,
      patientLastName: freezed == patientLastName
          ? _self.patientLastName
          : patientLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      patientFirstName: freezed == patientFirstName
          ? _self.patientFirstName
          : patientFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      description: freezed == description
          ? _self.description
          : description // ignore: cast_nullable_to_non_nullable
              as String?,
      interventionCode: freezed == interventionCode
          ? _self.interventionCode
          : interventionCode // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _FlowItem implements FlowItem {
  const _FlowItem(
      {this.id = null,
      this.title = null,
      this.comment = null,
      this.receptionDate = null,
      this.processingDate = null,
      this.processer = null,
      this.cancellationDate = null,
      this.canceller = null,
      this.cancellationReason = null,
      this.cancellationNote = null,
      this.status = null,
      this.homeVisit = null,
      this.municipality = null,
      this.town = null,
      this.zipCode = null,
      this.street = null,
      this.building = null,
      this.buildingNumber = null,
      this.doorbellName = null,
      this.floor = null,
      this.letterBox = null,
      this.notesOps = null,
      this.notesContact = null,
      this.latitude = null,
      this.longitude = null,
      this.type = null,
      this.emergency = null,
      this.phoneNumber = null,
      this.patientId = null,
      this.patientLastName = null,
      this.patientFirstName = null,
      this.description = null,
      this.interventionCode = null});

  @override
  @JsonKey()
  final String? id;
  @override
  @JsonKey()
  final String? title;
  @override
  @JsonKey()
  final String? comment;
  @override
  @JsonKey()
  final int? receptionDate;
  @override
  @JsonKey()
  final int? processingDate;
  @override
  @JsonKey()
  final String? processer;
  @override
  @JsonKey()
  final int? cancellationDate;
  @override
  @JsonKey()
  final String? canceller;
  @override
  @JsonKey()
  final String? cancellationReason;
  @override
  @JsonKey()
  final String? cancellationNote;
  @override
  @JsonKey()
  final String? status;
  @override
  @JsonKey()
  final bool? homeVisit;
  @override
  @JsonKey()
  final String? municipality;
  @override
  @JsonKey()
  final String? town;
  @override
  @JsonKey()
  final String? zipCode;
  @override
  @JsonKey()
  final String? street;
  @override
  @JsonKey()
  final String? building;
  @override
  @JsonKey()
  final String? buildingNumber;
  @override
  @JsonKey()
  final String? doorbellName;
  @override
  @JsonKey()
  final String? floor;
  @override
  @JsonKey()
  final String? letterBox;
  @override
  @JsonKey()
  final String? notesOps;
  @override
  @JsonKey()
  final String? notesContact;
  @override
  @JsonKey()
  final String? latitude;
  @override
  @JsonKey()
  final String? longitude;
  @override
  @JsonKey()
  final String? type;
  @override
  @JsonKey()
  final bool? emergency;
  @override
  @JsonKey()
  final String? phoneNumber;
  @override
  @JsonKey()
  final String? patientId;
  @override
  @JsonKey()
  final String? patientLastName;
  @override
  @JsonKey()
  final String? patientFirstName;
  @override
  @JsonKey()
  final String? description;
  @override
  @JsonKey()
  final String? interventionCode;

  /// Create a copy of FlowItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$FlowItemCopyWith<_FlowItem> get copyWith =>
      __$FlowItemCopyWithImpl<_FlowItem>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _FlowItem &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.title, title) || other.title == title) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.receptionDate, receptionDate) ||
                other.receptionDate == receptionDate) &&
            (identical(other.processingDate, processingDate) ||
                other.processingDate == processingDate) &&
            (identical(other.processer, processer) ||
                other.processer == processer) &&
            (identical(other.cancellationDate, cancellationDate) ||
                other.cancellationDate == cancellationDate) &&
            (identical(other.canceller, canceller) ||
                other.canceller == canceller) &&
            (identical(other.cancellationReason, cancellationReason) ||
                other.cancellationReason == cancellationReason) &&
            (identical(other.cancellationNote, cancellationNote) ||
                other.cancellationNote == cancellationNote) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.homeVisit, homeVisit) ||
                other.homeVisit == homeVisit) &&
            (identical(other.municipality, municipality) ||
                other.municipality == municipality) &&
            (identical(other.town, town) || other.town == town) &&
            (identical(other.zipCode, zipCode) || other.zipCode == zipCode) &&
            (identical(other.street, street) || other.street == street) &&
            (identical(other.building, building) ||
                other.building == building) &&
            (identical(other.buildingNumber, buildingNumber) ||
                other.buildingNumber == buildingNumber) &&
            (identical(other.doorbellName, doorbellName) ||
                other.doorbellName == doorbellName) &&
            (identical(other.floor, floor) || other.floor == floor) &&
            (identical(other.letterBox, letterBox) ||
                other.letterBox == letterBox) &&
            (identical(other.notesOps, notesOps) ||
                other.notesOps == notesOps) &&
            (identical(other.notesContact, notesContact) ||
                other.notesContact == notesContact) &&
            (identical(other.latitude, latitude) ||
                other.latitude == latitude) &&
            (identical(other.longitude, longitude) ||
                other.longitude == longitude) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.emergency, emergency) ||
                other.emergency == emergency) &&
            (identical(other.phoneNumber, phoneNumber) ||
                other.phoneNumber == phoneNumber) &&
            (identical(other.patientId, patientId) ||
                other.patientId == patientId) &&
            (identical(other.patientLastName, patientLastName) ||
                other.patientLastName == patientLastName) &&
            (identical(other.patientFirstName, patientFirstName) ||
                other.patientFirstName == patientFirstName) &&
            (identical(other.description, description) ||
                other.description == description) &&
            (identical(other.interventionCode, interventionCode) ||
                other.interventionCode == interventionCode));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        title,
        comment,
        receptionDate,
        processingDate,
        processer,
        cancellationDate,
        canceller,
        cancellationReason,
        cancellationNote,
        status,
        homeVisit,
        municipality,
        town,
        zipCode,
        street,
        building,
        buildingNumber,
        doorbellName,
        floor,
        letterBox,
        notesOps,
        notesContact,
        latitude,
        longitude,
        type,
        emergency,
        phoneNumber,
        patientId,
        patientLastName,
        patientFirstName,
        description,
        interventionCode
      ]);

  @override
  String toString() {
    return 'FlowItem(id: $id, title: $title, comment: $comment, receptionDate: $receptionDate, processingDate: $processingDate, processer: $processer, cancellationDate: $cancellationDate, canceller: $canceller, cancellationReason: $cancellationReason, cancellationNote: $cancellationNote, status: $status, homeVisit: $homeVisit, municipality: $municipality, town: $town, zipCode: $zipCode, street: $street, building: $building, buildingNumber: $buildingNumber, doorbellName: $doorbellName, floor: $floor, letterBox: $letterBox, notesOps: $notesOps, notesContact: $notesContact, latitude: $latitude, longitude: $longitude, type: $type, emergency: $emergency, phoneNumber: $phoneNumber, patientId: $patientId, patientLastName: $patientLastName, patientFirstName: $patientFirstName, description: $description, interventionCode: $interventionCode)';
  }
}

/// @nodoc
abstract mixin class _$FlowItemCopyWith<$Res>
    implements $FlowItemCopyWith<$Res> {
  factory _$FlowItemCopyWith(_FlowItem value, $Res Function(_FlowItem) _then) =
      __$FlowItemCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? id,
      String? title,
      String? comment,
      int? receptionDate,
      int? processingDate,
      String? processer,
      int? cancellationDate,
      String? canceller,
      String? cancellationReason,
      String? cancellationNote,
      String? status,
      bool? homeVisit,
      String? municipality,
      String? town,
      String? zipCode,
      String? street,
      String? building,
      String? buildingNumber,
      String? doorbellName,
      String? floor,
      String? letterBox,
      String? notesOps,
      String? notesContact,
      String? latitude,
      String? longitude,
      String? type,
      bool? emergency,
      String? phoneNumber,
      String? patientId,
      String? patientLastName,
      String? patientFirstName,
      String? description,
      String? interventionCode});
}

/// @nodoc
class __$FlowItemCopyWithImpl<$Res> implements _$FlowItemCopyWith<$Res> {
  __$FlowItemCopyWithImpl(this._self, this._then);

  final _FlowItem _self;
  final $Res Function(_FlowItem) _then;

  /// Create a copy of FlowItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = freezed,
    Object? title = freezed,
    Object? comment = freezed,
    Object? receptionDate = freezed,
    Object? processingDate = freezed,
    Object? processer = freezed,
    Object? cancellationDate = freezed,
    Object? canceller = freezed,
    Object? cancellationReason = freezed,
    Object? cancellationNote = freezed,
    Object? status = freezed,
    Object? homeVisit = freezed,
    Object? municipality = freezed,
    Object? town = freezed,
    Object? zipCode = freezed,
    Object? street = freezed,
    Object? building = freezed,
    Object? buildingNumber = freezed,
    Object? doorbellName = freezed,
    Object? floor = freezed,
    Object? letterBox = freezed,
    Object? notesOps = freezed,
    Object? notesContact = freezed,
    Object? latitude = freezed,
    Object? longitude = freezed,
    Object? type = freezed,
    Object? emergency = freezed,
    Object? phoneNumber = freezed,
    Object? patientId = freezed,
    Object? patientLastName = freezed,
    Object? patientFirstName = freezed,
    Object? description = freezed,
    Object? interventionCode = freezed,
  }) {
    return _then(_FlowItem(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      title: freezed == title
          ? _self.title
          : title // ignore: cast_nullable_to_non_nullable
              as String?,
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      receptionDate: freezed == receptionDate
          ? _self.receptionDate
          : receptionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      processingDate: freezed == processingDate
          ? _self.processingDate
          : processingDate // ignore: cast_nullable_to_non_nullable
              as int?,
      processer: freezed == processer
          ? _self.processer
          : processer // ignore: cast_nullable_to_non_nullable
              as String?,
      cancellationDate: freezed == cancellationDate
          ? _self.cancellationDate
          : cancellationDate // ignore: cast_nullable_to_non_nullable
              as int?,
      canceller: freezed == canceller
          ? _self.canceller
          : canceller // ignore: cast_nullable_to_non_nullable
              as String?,
      cancellationReason: freezed == cancellationReason
          ? _self.cancellationReason
          : cancellationReason // ignore: cast_nullable_to_non_nullable
              as String?,
      cancellationNote: freezed == cancellationNote
          ? _self.cancellationNote
          : cancellationNote // ignore: cast_nullable_to_non_nullable
              as String?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as String?,
      homeVisit: freezed == homeVisit
          ? _self.homeVisit
          : homeVisit // ignore: cast_nullable_to_non_nullable
              as bool?,
      municipality: freezed == municipality
          ? _self.municipality
          : municipality // ignore: cast_nullable_to_non_nullable
              as String?,
      town: freezed == town
          ? _self.town
          : town // ignore: cast_nullable_to_non_nullable
              as String?,
      zipCode: freezed == zipCode
          ? _self.zipCode
          : zipCode // ignore: cast_nullable_to_non_nullable
              as String?,
      street: freezed == street
          ? _self.street
          : street // ignore: cast_nullable_to_non_nullable
              as String?,
      building: freezed == building
          ? _self.building
          : building // ignore: cast_nullable_to_non_nullable
              as String?,
      buildingNumber: freezed == buildingNumber
          ? _self.buildingNumber
          : buildingNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      doorbellName: freezed == doorbellName
          ? _self.doorbellName
          : doorbellName // ignore: cast_nullable_to_non_nullable
              as String?,
      floor: freezed == floor
          ? _self.floor
          : floor // ignore: cast_nullable_to_non_nullable
              as String?,
      letterBox: freezed == letterBox
          ? _self.letterBox
          : letterBox // ignore: cast_nullable_to_non_nullable
              as String?,
      notesOps: freezed == notesOps
          ? _self.notesOps
          : notesOps // ignore: cast_nullable_to_non_nullable
              as String?,
      notesContact: freezed == notesContact
          ? _self.notesContact
          : notesContact // ignore: cast_nullable_to_non_nullable
              as String?,
      latitude: freezed == latitude
          ? _self.latitude
          : latitude // ignore: cast_nullable_to_non_nullable
              as String?,
      longitude: freezed == longitude
          ? _self.longitude
          : longitude // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as String?,
      emergency: freezed == emergency
          ? _self.emergency
          : emergency // ignore: cast_nullable_to_non_nullable
              as bool?,
      phoneNumber: freezed == phoneNumber
          ? _self.phoneNumber
          : phoneNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      patientId: freezed == patientId
          ? _self.patientId
          : patientId // ignore: cast_nullable_to_non_nullable
              as String?,
      patientLastName: freezed == patientLastName
          ? _self.patientLastName
          : patientLastName // ignore: cast_nullable_to_non_nullable
              as String?,
      patientFirstName: freezed == patientFirstName
          ? _self.patientFirstName
          : patientFirstName // ignore: cast_nullable_to_non_nullable
              as String?,
      description: freezed == description
          ? _self.description
          : description // ignore: cast_nullable_to_non_nullable
              as String?,
      interventionCode: freezed == interventionCode
          ? _self.interventionCode
          : interventionCode // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
