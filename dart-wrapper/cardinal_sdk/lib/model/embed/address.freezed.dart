// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'address.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedAddress {
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  List<Identifier> get identifier;
  AddressType? get addressType;
  String? get descr;
  String? get street;
  String? get houseNumber;
  String? get postboxNumber;
  String? get postalCode;
  String? get city;
  String? get state;
  String? get country;
  String? get note;
  List<Annotation> get notes;
  List<EncryptedTelecom> get telecoms;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedAddress
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedAddressCopyWith<EncryptedAddress> get copyWith =>
      _$EncryptedAddressCopyWithImpl<EncryptedAddress>(
          this as EncryptedAddress, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedAddress &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            const DeepCollectionEquality()
                .equals(other.identifier, identifier) &&
            (identical(other.addressType, addressType) ||
                other.addressType == addressType) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.street, street) || other.street == street) &&
            (identical(other.houseNumber, houseNumber) ||
                other.houseNumber == houseNumber) &&
            (identical(other.postboxNumber, postboxNumber) ||
                other.postboxNumber == postboxNumber) &&
            (identical(other.postalCode, postalCode) ||
                other.postalCode == postalCode) &&
            (identical(other.city, city) || other.city == city) &&
            (identical(other.state, state) || other.state == state) &&
            (identical(other.country, country) || other.country == country) &&
            (identical(other.note, note) || other.note == note) &&
            const DeepCollectionEquality().equals(other.notes, notes) &&
            const DeepCollectionEquality().equals(other.telecoms, telecoms) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(tags),
      const DeepCollectionEquality().hash(codes),
      const DeepCollectionEquality().hash(identifier),
      addressType,
      descr,
      street,
      houseNumber,
      postboxNumber,
      postalCode,
      city,
      state,
      country,
      note,
      const DeepCollectionEquality().hash(notes),
      const DeepCollectionEquality().hash(telecoms),
      encryptedSelf);

  @override
  String toString() {
    return 'EncryptedAddress(tags: $tags, codes: $codes, identifier: $identifier, addressType: $addressType, descr: $descr, street: $street, houseNumber: $houseNumber, postboxNumber: $postboxNumber, postalCode: $postalCode, city: $city, state: $state, country: $country, note: $note, notes: $notes, telecoms: $telecoms, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedAddressCopyWith<$Res> {
  factory $EncryptedAddressCopyWith(
          EncryptedAddress value, $Res Function(EncryptedAddress) _then) =
      _$EncryptedAddressCopyWithImpl;
  @useResult
  $Res call(
      {Set<CodeStub> tags,
      Set<CodeStub> codes,
      List<Identifier> identifier,
      AddressType? addressType,
      String? descr,
      String? street,
      String? houseNumber,
      String? postboxNumber,
      String? postalCode,
      String? city,
      String? state,
      String? country,
      String? note,
      List<Annotation> notes,
      List<EncryptedTelecom> telecoms,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$EncryptedAddressCopyWithImpl<$Res>
    implements $EncryptedAddressCopyWith<$Res> {
  _$EncryptedAddressCopyWithImpl(this._self, this._then);

  final EncryptedAddress _self;
  final $Res Function(EncryptedAddress) _then;

  /// Create a copy of EncryptedAddress
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? tags = null,
    Object? codes = null,
    Object? identifier = null,
    Object? addressType = freezed,
    Object? descr = freezed,
    Object? street = freezed,
    Object? houseNumber = freezed,
    Object? postboxNumber = freezed,
    Object? postalCode = freezed,
    Object? city = freezed,
    Object? state = freezed,
    Object? country = freezed,
    Object? note = freezed,
    Object? notes = null,
    Object? telecoms = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      codes: null == codes
          ? _self.codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      identifier: null == identifier
          ? _self.identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      addressType: freezed == addressType
          ? _self.addressType
          : addressType // ignore: cast_nullable_to_non_nullable
              as AddressType?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      street: freezed == street
          ? _self.street
          : street // ignore: cast_nullable_to_non_nullable
              as String?,
      houseNumber: freezed == houseNumber
          ? _self.houseNumber
          : houseNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      postboxNumber: freezed == postboxNumber
          ? _self.postboxNumber
          : postboxNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      postalCode: freezed == postalCode
          ? _self.postalCode
          : postalCode // ignore: cast_nullable_to_non_nullable
              as String?,
      city: freezed == city
          ? _self.city
          : city // ignore: cast_nullable_to_non_nullable
              as String?,
      state: freezed == state
          ? _self.state
          : state // ignore: cast_nullable_to_non_nullable
              as String?,
      country: freezed == country
          ? _self.country
          : country // ignore: cast_nullable_to_non_nullable
              as String?,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      notes: null == notes
          ? _self.notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      telecoms: null == telecoms
          ? _self.telecoms
          : telecoms // ignore: cast_nullable_to_non_nullable
              as List<EncryptedTelecom>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _EncryptedAddress implements EncryptedAddress {
  const _EncryptedAddress(
      {final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      final List<Identifier> identifier = const [],
      this.addressType = null,
      this.descr = null,
      this.street = null,
      this.houseNumber = null,
      this.postboxNumber = null,
      this.postalCode = null,
      this.city = null,
      this.state = null,
      this.country = null,
      this.note = null,
      final List<Annotation> notes = const [],
      final List<EncryptedTelecom> telecoms = const [],
      this.encryptedSelf = null})
      : _tags = tags,
        _codes = codes,
        _identifier = identifier,
        _notes = notes,
        _telecoms = telecoms;

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
  final AddressType? addressType;
  @override
  @JsonKey()
  final String? descr;
  @override
  @JsonKey()
  final String? street;
  @override
  @JsonKey()
  final String? houseNumber;
  @override
  @JsonKey()
  final String? postboxNumber;
  @override
  @JsonKey()
  final String? postalCode;
  @override
  @JsonKey()
  final String? city;
  @override
  @JsonKey()
  final String? state;
  @override
  @JsonKey()
  final String? country;
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

  final List<EncryptedTelecom> _telecoms;
  @override
  @JsonKey()
  List<EncryptedTelecom> get telecoms {
    if (_telecoms is EqualUnmodifiableListView) return _telecoms;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_telecoms);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedAddress
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedAddressCopyWith<_EncryptedAddress> get copyWith =>
      __$EncryptedAddressCopyWithImpl<_EncryptedAddress>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedAddress &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            const DeepCollectionEquality()
                .equals(other._identifier, _identifier) &&
            (identical(other.addressType, addressType) ||
                other.addressType == addressType) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.street, street) || other.street == street) &&
            (identical(other.houseNumber, houseNumber) ||
                other.houseNumber == houseNumber) &&
            (identical(other.postboxNumber, postboxNumber) ||
                other.postboxNumber == postboxNumber) &&
            (identical(other.postalCode, postalCode) ||
                other.postalCode == postalCode) &&
            (identical(other.city, city) || other.city == city) &&
            (identical(other.state, state) || other.state == state) &&
            (identical(other.country, country) || other.country == country) &&
            (identical(other.note, note) || other.note == note) &&
            const DeepCollectionEquality().equals(other._notes, _notes) &&
            const DeepCollectionEquality().equals(other._telecoms, _telecoms) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(_tags),
      const DeepCollectionEquality().hash(_codes),
      const DeepCollectionEquality().hash(_identifier),
      addressType,
      descr,
      street,
      houseNumber,
      postboxNumber,
      postalCode,
      city,
      state,
      country,
      note,
      const DeepCollectionEquality().hash(_notes),
      const DeepCollectionEquality().hash(_telecoms),
      encryptedSelf);

  @override
  String toString() {
    return 'EncryptedAddress(tags: $tags, codes: $codes, identifier: $identifier, addressType: $addressType, descr: $descr, street: $street, houseNumber: $houseNumber, postboxNumber: $postboxNumber, postalCode: $postalCode, city: $city, state: $state, country: $country, note: $note, notes: $notes, telecoms: $telecoms, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedAddressCopyWith<$Res>
    implements $EncryptedAddressCopyWith<$Res> {
  factory _$EncryptedAddressCopyWith(
          _EncryptedAddress value, $Res Function(_EncryptedAddress) _then) =
      __$EncryptedAddressCopyWithImpl;
  @override
  @useResult
  $Res call(
      {Set<CodeStub> tags,
      Set<CodeStub> codes,
      List<Identifier> identifier,
      AddressType? addressType,
      String? descr,
      String? street,
      String? houseNumber,
      String? postboxNumber,
      String? postalCode,
      String? city,
      String? state,
      String? country,
      String? note,
      List<Annotation> notes,
      List<EncryptedTelecom> telecoms,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$EncryptedAddressCopyWithImpl<$Res>
    implements _$EncryptedAddressCopyWith<$Res> {
  __$EncryptedAddressCopyWithImpl(this._self, this._then);

  final _EncryptedAddress _self;
  final $Res Function(_EncryptedAddress) _then;

  /// Create a copy of EncryptedAddress
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? tags = null,
    Object? codes = null,
    Object? identifier = null,
    Object? addressType = freezed,
    Object? descr = freezed,
    Object? street = freezed,
    Object? houseNumber = freezed,
    Object? postboxNumber = freezed,
    Object? postalCode = freezed,
    Object? city = freezed,
    Object? state = freezed,
    Object? country = freezed,
    Object? note = freezed,
    Object? notes = null,
    Object? telecoms = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedAddress(
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      codes: null == codes
          ? _self._codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      identifier: null == identifier
          ? _self._identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      addressType: freezed == addressType
          ? _self.addressType
          : addressType // ignore: cast_nullable_to_non_nullable
              as AddressType?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      street: freezed == street
          ? _self.street
          : street // ignore: cast_nullable_to_non_nullable
              as String?,
      houseNumber: freezed == houseNumber
          ? _self.houseNumber
          : houseNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      postboxNumber: freezed == postboxNumber
          ? _self.postboxNumber
          : postboxNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      postalCode: freezed == postalCode
          ? _self.postalCode
          : postalCode // ignore: cast_nullable_to_non_nullable
              as String?,
      city: freezed == city
          ? _self.city
          : city // ignore: cast_nullable_to_non_nullable
              as String?,
      state: freezed == state
          ? _self.state
          : state // ignore: cast_nullable_to_non_nullable
              as String?,
      country: freezed == country
          ? _self.country
          : country // ignore: cast_nullable_to_non_nullable
              as String?,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      notes: null == notes
          ? _self._notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      telecoms: null == telecoms
          ? _self._telecoms
          : telecoms // ignore: cast_nullable_to_non_nullable
              as List<EncryptedTelecom>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc
mixin _$DecryptedAddress {
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  List<Identifier> get identifier;
  AddressType? get addressType;
  String? get descr;
  String? get street;
  String? get houseNumber;
  String? get postboxNumber;
  String? get postalCode;
  String? get city;
  String? get state;
  String? get country;
  String? get note;
  List<Annotation> get notes;
  List<DecryptedTelecom> get telecoms;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedAddress
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedAddressCopyWith<DecryptedAddress> get copyWith =>
      _$DecryptedAddressCopyWithImpl<DecryptedAddress>(
          this as DecryptedAddress, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedAddress &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            const DeepCollectionEquality()
                .equals(other.identifier, identifier) &&
            (identical(other.addressType, addressType) ||
                other.addressType == addressType) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.street, street) || other.street == street) &&
            (identical(other.houseNumber, houseNumber) ||
                other.houseNumber == houseNumber) &&
            (identical(other.postboxNumber, postboxNumber) ||
                other.postboxNumber == postboxNumber) &&
            (identical(other.postalCode, postalCode) ||
                other.postalCode == postalCode) &&
            (identical(other.city, city) || other.city == city) &&
            (identical(other.state, state) || other.state == state) &&
            (identical(other.country, country) || other.country == country) &&
            (identical(other.note, note) || other.note == note) &&
            const DeepCollectionEquality().equals(other.notes, notes) &&
            const DeepCollectionEquality().equals(other.telecoms, telecoms) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(tags),
      const DeepCollectionEquality().hash(codes),
      const DeepCollectionEquality().hash(identifier),
      addressType,
      descr,
      street,
      houseNumber,
      postboxNumber,
      postalCode,
      city,
      state,
      country,
      note,
      const DeepCollectionEquality().hash(notes),
      const DeepCollectionEquality().hash(telecoms),
      encryptedSelf);

  @override
  String toString() {
    return 'DecryptedAddress(tags: $tags, codes: $codes, identifier: $identifier, addressType: $addressType, descr: $descr, street: $street, houseNumber: $houseNumber, postboxNumber: $postboxNumber, postalCode: $postalCode, city: $city, state: $state, country: $country, note: $note, notes: $notes, telecoms: $telecoms, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedAddressCopyWith<$Res> {
  factory $DecryptedAddressCopyWith(
          DecryptedAddress value, $Res Function(DecryptedAddress) _then) =
      _$DecryptedAddressCopyWithImpl;
  @useResult
  $Res call(
      {Set<CodeStub> tags,
      Set<CodeStub> codes,
      List<Identifier> identifier,
      AddressType? addressType,
      String? descr,
      String? street,
      String? houseNumber,
      String? postboxNumber,
      String? postalCode,
      String? city,
      String? state,
      String? country,
      String? note,
      List<Annotation> notes,
      List<DecryptedTelecom> telecoms,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$DecryptedAddressCopyWithImpl<$Res>
    implements $DecryptedAddressCopyWith<$Res> {
  _$DecryptedAddressCopyWithImpl(this._self, this._then);

  final DecryptedAddress _self;
  final $Res Function(DecryptedAddress) _then;

  /// Create a copy of DecryptedAddress
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? tags = null,
    Object? codes = null,
    Object? identifier = null,
    Object? addressType = freezed,
    Object? descr = freezed,
    Object? street = freezed,
    Object? houseNumber = freezed,
    Object? postboxNumber = freezed,
    Object? postalCode = freezed,
    Object? city = freezed,
    Object? state = freezed,
    Object? country = freezed,
    Object? note = freezed,
    Object? notes = null,
    Object? telecoms = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      codes: null == codes
          ? _self.codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      identifier: null == identifier
          ? _self.identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      addressType: freezed == addressType
          ? _self.addressType
          : addressType // ignore: cast_nullable_to_non_nullable
              as AddressType?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      street: freezed == street
          ? _self.street
          : street // ignore: cast_nullable_to_non_nullable
              as String?,
      houseNumber: freezed == houseNumber
          ? _self.houseNumber
          : houseNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      postboxNumber: freezed == postboxNumber
          ? _self.postboxNumber
          : postboxNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      postalCode: freezed == postalCode
          ? _self.postalCode
          : postalCode // ignore: cast_nullable_to_non_nullable
              as String?,
      city: freezed == city
          ? _self.city
          : city // ignore: cast_nullable_to_non_nullable
              as String?,
      state: freezed == state
          ? _self.state
          : state // ignore: cast_nullable_to_non_nullable
              as String?,
      country: freezed == country
          ? _self.country
          : country // ignore: cast_nullable_to_non_nullable
              as String?,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      notes: null == notes
          ? _self.notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      telecoms: null == telecoms
          ? _self.telecoms
          : telecoms // ignore: cast_nullable_to_non_nullable
              as List<DecryptedTelecom>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _DecryptedAddress implements DecryptedAddress {
  const _DecryptedAddress(
      {final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      final List<Identifier> identifier = const [],
      this.addressType = null,
      this.descr = null,
      this.street = null,
      this.houseNumber = null,
      this.postboxNumber = null,
      this.postalCode = null,
      this.city = null,
      this.state = null,
      this.country = null,
      this.note = null,
      final List<Annotation> notes = const [],
      final List<DecryptedTelecom> telecoms = const [],
      this.encryptedSelf = null})
      : _tags = tags,
        _codes = codes,
        _identifier = identifier,
        _notes = notes,
        _telecoms = telecoms;

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
  final AddressType? addressType;
  @override
  @JsonKey()
  final String? descr;
  @override
  @JsonKey()
  final String? street;
  @override
  @JsonKey()
  final String? houseNumber;
  @override
  @JsonKey()
  final String? postboxNumber;
  @override
  @JsonKey()
  final String? postalCode;
  @override
  @JsonKey()
  final String? city;
  @override
  @JsonKey()
  final String? state;
  @override
  @JsonKey()
  final String? country;
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

  final List<DecryptedTelecom> _telecoms;
  @override
  @JsonKey()
  List<DecryptedTelecom> get telecoms {
    if (_telecoms is EqualUnmodifiableListView) return _telecoms;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_telecoms);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedAddress
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedAddressCopyWith<_DecryptedAddress> get copyWith =>
      __$DecryptedAddressCopyWithImpl<_DecryptedAddress>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedAddress &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            const DeepCollectionEquality()
                .equals(other._identifier, _identifier) &&
            (identical(other.addressType, addressType) ||
                other.addressType == addressType) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.street, street) || other.street == street) &&
            (identical(other.houseNumber, houseNumber) ||
                other.houseNumber == houseNumber) &&
            (identical(other.postboxNumber, postboxNumber) ||
                other.postboxNumber == postboxNumber) &&
            (identical(other.postalCode, postalCode) ||
                other.postalCode == postalCode) &&
            (identical(other.city, city) || other.city == city) &&
            (identical(other.state, state) || other.state == state) &&
            (identical(other.country, country) || other.country == country) &&
            (identical(other.note, note) || other.note == note) &&
            const DeepCollectionEquality().equals(other._notes, _notes) &&
            const DeepCollectionEquality().equals(other._telecoms, _telecoms) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(_tags),
      const DeepCollectionEquality().hash(_codes),
      const DeepCollectionEquality().hash(_identifier),
      addressType,
      descr,
      street,
      houseNumber,
      postboxNumber,
      postalCode,
      city,
      state,
      country,
      note,
      const DeepCollectionEquality().hash(_notes),
      const DeepCollectionEquality().hash(_telecoms),
      encryptedSelf);

  @override
  String toString() {
    return 'DecryptedAddress(tags: $tags, codes: $codes, identifier: $identifier, addressType: $addressType, descr: $descr, street: $street, houseNumber: $houseNumber, postboxNumber: $postboxNumber, postalCode: $postalCode, city: $city, state: $state, country: $country, note: $note, notes: $notes, telecoms: $telecoms, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedAddressCopyWith<$Res>
    implements $DecryptedAddressCopyWith<$Res> {
  factory _$DecryptedAddressCopyWith(
          _DecryptedAddress value, $Res Function(_DecryptedAddress) _then) =
      __$DecryptedAddressCopyWithImpl;
  @override
  @useResult
  $Res call(
      {Set<CodeStub> tags,
      Set<CodeStub> codes,
      List<Identifier> identifier,
      AddressType? addressType,
      String? descr,
      String? street,
      String? houseNumber,
      String? postboxNumber,
      String? postalCode,
      String? city,
      String? state,
      String? country,
      String? note,
      List<Annotation> notes,
      List<DecryptedTelecom> telecoms,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$DecryptedAddressCopyWithImpl<$Res>
    implements _$DecryptedAddressCopyWith<$Res> {
  __$DecryptedAddressCopyWithImpl(this._self, this._then);

  final _DecryptedAddress _self;
  final $Res Function(_DecryptedAddress) _then;

  /// Create a copy of DecryptedAddress
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? tags = null,
    Object? codes = null,
    Object? identifier = null,
    Object? addressType = freezed,
    Object? descr = freezed,
    Object? street = freezed,
    Object? houseNumber = freezed,
    Object? postboxNumber = freezed,
    Object? postalCode = freezed,
    Object? city = freezed,
    Object? state = freezed,
    Object? country = freezed,
    Object? note = freezed,
    Object? notes = null,
    Object? telecoms = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedAddress(
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      codes: null == codes
          ? _self._codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      identifier: null == identifier
          ? _self._identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      addressType: freezed == addressType
          ? _self.addressType
          : addressType // ignore: cast_nullable_to_non_nullable
              as AddressType?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      street: freezed == street
          ? _self.street
          : street // ignore: cast_nullable_to_non_nullable
              as String?,
      houseNumber: freezed == houseNumber
          ? _self.houseNumber
          : houseNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      postboxNumber: freezed == postboxNumber
          ? _self.postboxNumber
          : postboxNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      postalCode: freezed == postalCode
          ? _self.postalCode
          : postalCode // ignore: cast_nullable_to_non_nullable
              as String?,
      city: freezed == city
          ? _self.city
          : city // ignore: cast_nullable_to_non_nullable
              as String?,
      state: freezed == state
          ? _self.state
          : state // ignore: cast_nullable_to_non_nullable
              as String?,
      country: freezed == country
          ? _self.country
          : country // ignore: cast_nullable_to_non_nullable
              as String?,
      note: freezed == note
          ? _self.note
          : note // ignore: cast_nullable_to_non_nullable
              as String?,
      notes: null == notes
          ? _self._notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      telecoms: null == telecoms
          ? _self._telecoms
          : telecoms // ignore: cast_nullable_to_non_nullable
              as List<DecryptedTelecom>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

// dart format on
