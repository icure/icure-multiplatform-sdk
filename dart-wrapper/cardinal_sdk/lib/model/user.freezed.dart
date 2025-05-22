// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'user.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$User {
  String get id;
  String? get rev;
  int? get deletionDate;
  int? get created;
  List<Identifier> get identifier;
  String? get name;
  Set<DecryptedPropertyStub> get properties;
  Set<Permission> get permissions;
  Set<String> get roles;
  UsersType? get type;
  UsersStatus? get status;
  String? get login;
  String? get passwordHash;
  String? get groupId;
  String? get healthcarePartyId;
  String? get patientId;
  String? get deviceId;
  Map<DelegationTag, Set<String>> get autoDelegations;
  DateTime? get createdDate;
  DateTime? get termsOfUseDate;
  String? get email;
  String? get mobilePhone;
  Map<String, String> get applicationTokens;
  Map<String, AuthenticationToken> get authenticationTokens;
  UserSystemMetadata? get systemMetadata;

  /// Create a copy of User
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $UserCopyWith<User> get copyWith =>
      _$UserCopyWithImpl<User>(this as User, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is User &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.created, created) || other.created == created) &&
            const DeepCollectionEquality()
                .equals(other.identifier, identifier) &&
            (identical(other.name, name) || other.name == name) &&
            const DeepCollectionEquality()
                .equals(other.properties, properties) &&
            const DeepCollectionEquality()
                .equals(other.permissions, permissions) &&
            const DeepCollectionEquality().equals(other.roles, roles) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.login, login) || other.login == login) &&
            (identical(other.passwordHash, passwordHash) ||
                other.passwordHash == passwordHash) &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.patientId, patientId) ||
                other.patientId == patientId) &&
            (identical(other.deviceId, deviceId) ||
                other.deviceId == deviceId) &&
            const DeepCollectionEquality()
                .equals(other.autoDelegations, autoDelegations) &&
            (identical(other.createdDate, createdDate) ||
                other.createdDate == createdDate) &&
            (identical(other.termsOfUseDate, termsOfUseDate) ||
                other.termsOfUseDate == termsOfUseDate) &&
            (identical(other.email, email) || other.email == email) &&
            (identical(other.mobilePhone, mobilePhone) ||
                other.mobilePhone == mobilePhone) &&
            const DeepCollectionEquality()
                .equals(other.applicationTokens, applicationTokens) &&
            const DeepCollectionEquality()
                .equals(other.authenticationTokens, authenticationTokens) &&
            (identical(other.systemMetadata, systemMetadata) ||
                other.systemMetadata == systemMetadata));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        deletionDate,
        created,
        const DeepCollectionEquality().hash(identifier),
        name,
        const DeepCollectionEquality().hash(properties),
        const DeepCollectionEquality().hash(permissions),
        const DeepCollectionEquality().hash(roles),
        type,
        status,
        login,
        passwordHash,
        groupId,
        healthcarePartyId,
        patientId,
        deviceId,
        const DeepCollectionEquality().hash(autoDelegations),
        createdDate,
        termsOfUseDate,
        email,
        mobilePhone,
        const DeepCollectionEquality().hash(applicationTokens),
        const DeepCollectionEquality().hash(authenticationTokens),
        systemMetadata
      ]);

  @override
  String toString() {
    return 'User(id: $id, rev: $rev, deletionDate: $deletionDate, created: $created, identifier: $identifier, name: $name, properties: $properties, permissions: $permissions, roles: $roles, type: $type, status: $status, login: $login, passwordHash: $passwordHash, groupId: $groupId, healthcarePartyId: $healthcarePartyId, patientId: $patientId, deviceId: $deviceId, autoDelegations: $autoDelegations, createdDate: $createdDate, termsOfUseDate: $termsOfUseDate, email: $email, mobilePhone: $mobilePhone, applicationTokens: $applicationTokens, authenticationTokens: $authenticationTokens, systemMetadata: $systemMetadata)';
  }
}

/// @nodoc
abstract mixin class $UserCopyWith<$Res> {
  factory $UserCopyWith(User value, $Res Function(User) _then) =
      _$UserCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      int? created,
      List<Identifier> identifier,
      String? name,
      Set<DecryptedPropertyStub> properties,
      Set<Permission> permissions,
      Set<String> roles,
      UsersType? type,
      UsersStatus? status,
      String? login,
      String? passwordHash,
      String? groupId,
      String? healthcarePartyId,
      String? patientId,
      String? deviceId,
      Map<DelegationTag, Set<String>> autoDelegations,
      DateTime? createdDate,
      DateTime? termsOfUseDate,
      String? email,
      String? mobilePhone,
      Map<String, String> applicationTokens,
      Map<String, AuthenticationToken> authenticationTokens,
      UserSystemMetadata? systemMetadata});

  $UserSystemMetadataCopyWith<$Res>? get systemMetadata;
}

/// @nodoc
class _$UserCopyWithImpl<$Res> implements $UserCopyWith<$Res> {
  _$UserCopyWithImpl(this._self, this._then);

  final User _self;
  final $Res Function(User) _then;

  /// Create a copy of User
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? created = freezed,
    Object? identifier = null,
    Object? name = freezed,
    Object? properties = null,
    Object? permissions = null,
    Object? roles = null,
    Object? type = freezed,
    Object? status = freezed,
    Object? login = freezed,
    Object? passwordHash = freezed,
    Object? groupId = freezed,
    Object? healthcarePartyId = freezed,
    Object? patientId = freezed,
    Object? deviceId = freezed,
    Object? autoDelegations = null,
    Object? createdDate = freezed,
    Object? termsOfUseDate = freezed,
    Object? email = freezed,
    Object? mobilePhone = freezed,
    Object? applicationTokens = null,
    Object? authenticationTokens = null,
    Object? systemMetadata = freezed,
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
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      created: freezed == created
          ? _self.created
          : created // ignore: cast_nullable_to_non_nullable
              as int?,
      identifier: null == identifier
          ? _self.identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      properties: null == properties
          ? _self.properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
      permissions: null == permissions
          ? _self.permissions
          : permissions // ignore: cast_nullable_to_non_nullable
              as Set<Permission>,
      roles: null == roles
          ? _self.roles
          : roles // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as UsersType?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as UsersStatus?,
      login: freezed == login
          ? _self.login
          : login // ignore: cast_nullable_to_non_nullable
              as String?,
      passwordHash: freezed == passwordHash
          ? _self.passwordHash
          : passwordHash // ignore: cast_nullable_to_non_nullable
              as String?,
      groupId: freezed == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      patientId: freezed == patientId
          ? _self.patientId
          : patientId // ignore: cast_nullable_to_non_nullable
              as String?,
      deviceId: freezed == deviceId
          ? _self.deviceId
          : deviceId // ignore: cast_nullable_to_non_nullable
              as String?,
      autoDelegations: null == autoDelegations
          ? _self.autoDelegations
          : autoDelegations // ignore: cast_nullable_to_non_nullable
              as Map<DelegationTag, Set<String>>,
      createdDate: freezed == createdDate
          ? _self.createdDate
          : createdDate // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      termsOfUseDate: freezed == termsOfUseDate
          ? _self.termsOfUseDate
          : termsOfUseDate // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      email: freezed == email
          ? _self.email
          : email // ignore: cast_nullable_to_non_nullable
              as String?,
      mobilePhone: freezed == mobilePhone
          ? _self.mobilePhone
          : mobilePhone // ignore: cast_nullable_to_non_nullable
              as String?,
      applicationTokens: null == applicationTokens
          ? _self.applicationTokens
          : applicationTokens // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      authenticationTokens: null == authenticationTokens
          ? _self.authenticationTokens
          : authenticationTokens // ignore: cast_nullable_to_non_nullable
              as Map<String, AuthenticationToken>,
      systemMetadata: freezed == systemMetadata
          ? _self.systemMetadata
          : systemMetadata // ignore: cast_nullable_to_non_nullable
              as UserSystemMetadata?,
    ));
  }

  /// Create a copy of User
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $UserSystemMetadataCopyWith<$Res>? get systemMetadata {
    if (_self.systemMetadata == null) {
      return null;
    }

    return $UserSystemMetadataCopyWith<$Res>(_self.systemMetadata!, (value) {
      return _then(_self.copyWith(systemMetadata: value));
    });
  }
}

/// @nodoc

class _User implements User {
  const _User(
      {required this.id,
      this.rev = null,
      this.deletionDate = null,
      this.created = null,
      final List<Identifier> identifier = const [],
      this.name = null,
      final Set<DecryptedPropertyStub> properties = const {},
      final Set<Permission> permissions = const {},
      final Set<String> roles = const {},
      this.type = null,
      this.status = null,
      this.login = null,
      this.passwordHash = null,
      this.groupId = null,
      this.healthcarePartyId = null,
      this.patientId = null,
      this.deviceId = null,
      final Map<DelegationTag, Set<String>> autoDelegations = const {},
      this.createdDate = null,
      this.termsOfUseDate = null,
      this.email = null,
      this.mobilePhone = null,
      final Map<String, String> applicationTokens = const {},
      final Map<String, AuthenticationToken> authenticationTokens = const {},
      this.systemMetadata = null})
      : _identifier = identifier,
        _properties = properties,
        _permissions = permissions,
        _roles = roles,
        _autoDelegations = autoDelegations,
        _applicationTokens = applicationTokens,
        _authenticationTokens = authenticationTokens;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  @JsonKey()
  final int? deletionDate;
  @override
  @JsonKey()
  final int? created;
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
  final String? name;
  final Set<DecryptedPropertyStub> _properties;
  @override
  @JsonKey()
  Set<DecryptedPropertyStub> get properties {
    if (_properties is EqualUnmodifiableSetView) return _properties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_properties);
  }

  final Set<Permission> _permissions;
  @override
  @JsonKey()
  Set<Permission> get permissions {
    if (_permissions is EqualUnmodifiableSetView) return _permissions;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_permissions);
  }

  final Set<String> _roles;
  @override
  @JsonKey()
  Set<String> get roles {
    if (_roles is EqualUnmodifiableSetView) return _roles;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_roles);
  }

  @override
  @JsonKey()
  final UsersType? type;
  @override
  @JsonKey()
  final UsersStatus? status;
  @override
  @JsonKey()
  final String? login;
  @override
  @JsonKey()
  final String? passwordHash;
  @override
  @JsonKey()
  final String? groupId;
  @override
  @JsonKey()
  final String? healthcarePartyId;
  @override
  @JsonKey()
  final String? patientId;
  @override
  @JsonKey()
  final String? deviceId;
  final Map<DelegationTag, Set<String>> _autoDelegations;
  @override
  @JsonKey()
  Map<DelegationTag, Set<String>> get autoDelegations {
    if (_autoDelegations is EqualUnmodifiableMapView) return _autoDelegations;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_autoDelegations);
  }

  @override
  @JsonKey()
  final DateTime? createdDate;
  @override
  @JsonKey()
  final DateTime? termsOfUseDate;
  @override
  @JsonKey()
  final String? email;
  @override
  @JsonKey()
  final String? mobilePhone;
  final Map<String, String> _applicationTokens;
  @override
  @JsonKey()
  Map<String, String> get applicationTokens {
    if (_applicationTokens is EqualUnmodifiableMapView)
      return _applicationTokens;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_applicationTokens);
  }

  final Map<String, AuthenticationToken> _authenticationTokens;
  @override
  @JsonKey()
  Map<String, AuthenticationToken> get authenticationTokens {
    if (_authenticationTokens is EqualUnmodifiableMapView)
      return _authenticationTokens;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_authenticationTokens);
  }

  @override
  @JsonKey()
  final UserSystemMetadata? systemMetadata;

  /// Create a copy of User
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$UserCopyWith<_User> get copyWith =>
      __$UserCopyWithImpl<_User>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _User &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.created, created) || other.created == created) &&
            const DeepCollectionEquality()
                .equals(other._identifier, _identifier) &&
            (identical(other.name, name) || other.name == name) &&
            const DeepCollectionEquality()
                .equals(other._properties, _properties) &&
            const DeepCollectionEquality()
                .equals(other._permissions, _permissions) &&
            const DeepCollectionEquality().equals(other._roles, _roles) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.login, login) || other.login == login) &&
            (identical(other.passwordHash, passwordHash) ||
                other.passwordHash == passwordHash) &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.patientId, patientId) ||
                other.patientId == patientId) &&
            (identical(other.deviceId, deviceId) ||
                other.deviceId == deviceId) &&
            const DeepCollectionEquality()
                .equals(other._autoDelegations, _autoDelegations) &&
            (identical(other.createdDate, createdDate) ||
                other.createdDate == createdDate) &&
            (identical(other.termsOfUseDate, termsOfUseDate) ||
                other.termsOfUseDate == termsOfUseDate) &&
            (identical(other.email, email) || other.email == email) &&
            (identical(other.mobilePhone, mobilePhone) ||
                other.mobilePhone == mobilePhone) &&
            const DeepCollectionEquality()
                .equals(other._applicationTokens, _applicationTokens) &&
            const DeepCollectionEquality()
                .equals(other._authenticationTokens, _authenticationTokens) &&
            (identical(other.systemMetadata, systemMetadata) ||
                other.systemMetadata == systemMetadata));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        deletionDate,
        created,
        const DeepCollectionEquality().hash(_identifier),
        name,
        const DeepCollectionEquality().hash(_properties),
        const DeepCollectionEquality().hash(_permissions),
        const DeepCollectionEquality().hash(_roles),
        type,
        status,
        login,
        passwordHash,
        groupId,
        healthcarePartyId,
        patientId,
        deviceId,
        const DeepCollectionEquality().hash(_autoDelegations),
        createdDate,
        termsOfUseDate,
        email,
        mobilePhone,
        const DeepCollectionEquality().hash(_applicationTokens),
        const DeepCollectionEquality().hash(_authenticationTokens),
        systemMetadata
      ]);

  @override
  String toString() {
    return 'User(id: $id, rev: $rev, deletionDate: $deletionDate, created: $created, identifier: $identifier, name: $name, properties: $properties, permissions: $permissions, roles: $roles, type: $type, status: $status, login: $login, passwordHash: $passwordHash, groupId: $groupId, healthcarePartyId: $healthcarePartyId, patientId: $patientId, deviceId: $deviceId, autoDelegations: $autoDelegations, createdDate: $createdDate, termsOfUseDate: $termsOfUseDate, email: $email, mobilePhone: $mobilePhone, applicationTokens: $applicationTokens, authenticationTokens: $authenticationTokens, systemMetadata: $systemMetadata)';
  }
}

/// @nodoc
abstract mixin class _$UserCopyWith<$Res> implements $UserCopyWith<$Res> {
  factory _$UserCopyWith(_User value, $Res Function(_User) _then) =
      __$UserCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      int? created,
      List<Identifier> identifier,
      String? name,
      Set<DecryptedPropertyStub> properties,
      Set<Permission> permissions,
      Set<String> roles,
      UsersType? type,
      UsersStatus? status,
      String? login,
      String? passwordHash,
      String? groupId,
      String? healthcarePartyId,
      String? patientId,
      String? deviceId,
      Map<DelegationTag, Set<String>> autoDelegations,
      DateTime? createdDate,
      DateTime? termsOfUseDate,
      String? email,
      String? mobilePhone,
      Map<String, String> applicationTokens,
      Map<String, AuthenticationToken> authenticationTokens,
      UserSystemMetadata? systemMetadata});

  @override
  $UserSystemMetadataCopyWith<$Res>? get systemMetadata;
}

/// @nodoc
class __$UserCopyWithImpl<$Res> implements _$UserCopyWith<$Res> {
  __$UserCopyWithImpl(this._self, this._then);

  final _User _self;
  final $Res Function(_User) _then;

  /// Create a copy of User
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? created = freezed,
    Object? identifier = null,
    Object? name = freezed,
    Object? properties = null,
    Object? permissions = null,
    Object? roles = null,
    Object? type = freezed,
    Object? status = freezed,
    Object? login = freezed,
    Object? passwordHash = freezed,
    Object? groupId = freezed,
    Object? healthcarePartyId = freezed,
    Object? patientId = freezed,
    Object? deviceId = freezed,
    Object? autoDelegations = null,
    Object? createdDate = freezed,
    Object? termsOfUseDate = freezed,
    Object? email = freezed,
    Object? mobilePhone = freezed,
    Object? applicationTokens = null,
    Object? authenticationTokens = null,
    Object? systemMetadata = freezed,
  }) {
    return _then(_User(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      created: freezed == created
          ? _self.created
          : created // ignore: cast_nullable_to_non_nullable
              as int?,
      identifier: null == identifier
          ? _self._identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as List<Identifier>,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      properties: null == properties
          ? _self._properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
      permissions: null == permissions
          ? _self._permissions
          : permissions // ignore: cast_nullable_to_non_nullable
              as Set<Permission>,
      roles: null == roles
          ? _self._roles
          : roles // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as UsersType?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as UsersStatus?,
      login: freezed == login
          ? _self.login
          : login // ignore: cast_nullable_to_non_nullable
              as String?,
      passwordHash: freezed == passwordHash
          ? _self.passwordHash
          : passwordHash // ignore: cast_nullable_to_non_nullable
              as String?,
      groupId: freezed == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      patientId: freezed == patientId
          ? _self.patientId
          : patientId // ignore: cast_nullable_to_non_nullable
              as String?,
      deviceId: freezed == deviceId
          ? _self.deviceId
          : deviceId // ignore: cast_nullable_to_non_nullable
              as String?,
      autoDelegations: null == autoDelegations
          ? _self._autoDelegations
          : autoDelegations // ignore: cast_nullable_to_non_nullable
              as Map<DelegationTag, Set<String>>,
      createdDate: freezed == createdDate
          ? _self.createdDate
          : createdDate // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      termsOfUseDate: freezed == termsOfUseDate
          ? _self.termsOfUseDate
          : termsOfUseDate // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      email: freezed == email
          ? _self.email
          : email // ignore: cast_nullable_to_non_nullable
              as String?,
      mobilePhone: freezed == mobilePhone
          ? _self.mobilePhone
          : mobilePhone // ignore: cast_nullable_to_non_nullable
              as String?,
      applicationTokens: null == applicationTokens
          ? _self._applicationTokens
          : applicationTokens // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      authenticationTokens: null == authenticationTokens
          ? _self._authenticationTokens
          : authenticationTokens // ignore: cast_nullable_to_non_nullable
              as Map<String, AuthenticationToken>,
      systemMetadata: freezed == systemMetadata
          ? _self.systemMetadata
          : systemMetadata // ignore: cast_nullable_to_non_nullable
              as UserSystemMetadata?,
    ));
  }

  /// Create a copy of User
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $UserSystemMetadataCopyWith<$Res>? get systemMetadata {
    if (_self.systemMetadata == null) {
      return null;
    }

    return $UserSystemMetadataCopyWith<$Res>(_self.systemMetadata!, (value) {
      return _then(_self.copyWith(systemMetadata: value));
    });
  }
}

/// @nodoc
mixin _$UserSystemMetadata {
  Set<String> get roles;
  bool get isAdmin;
  bool get inheritsRoles;
  List<LoginIdentifier> get loginIdentifiers;

  /// Create a copy of UserSystemMetadata
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $UserSystemMetadataCopyWith<UserSystemMetadata> get copyWith =>
      _$UserSystemMetadataCopyWithImpl<UserSystemMetadata>(
          this as UserSystemMetadata, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is UserSystemMetadata &&
            const DeepCollectionEquality().equals(other.roles, roles) &&
            (identical(other.isAdmin, isAdmin) || other.isAdmin == isAdmin) &&
            (identical(other.inheritsRoles, inheritsRoles) ||
                other.inheritsRoles == inheritsRoles) &&
            const DeepCollectionEquality()
                .equals(other.loginIdentifiers, loginIdentifiers));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(roles),
      isAdmin,
      inheritsRoles,
      const DeepCollectionEquality().hash(loginIdentifiers));

  @override
  String toString() {
    return 'UserSystemMetadata(roles: $roles, isAdmin: $isAdmin, inheritsRoles: $inheritsRoles, loginIdentifiers: $loginIdentifiers)';
  }
}

/// @nodoc
abstract mixin class $UserSystemMetadataCopyWith<$Res> {
  factory $UserSystemMetadataCopyWith(
          UserSystemMetadata value, $Res Function(UserSystemMetadata) _then) =
      _$UserSystemMetadataCopyWithImpl;
  @useResult
  $Res call(
      {Set<String> roles,
      bool isAdmin,
      bool inheritsRoles,
      List<LoginIdentifier> loginIdentifiers});
}

/// @nodoc
class _$UserSystemMetadataCopyWithImpl<$Res>
    implements $UserSystemMetadataCopyWith<$Res> {
  _$UserSystemMetadataCopyWithImpl(this._self, this._then);

  final UserSystemMetadata _self;
  final $Res Function(UserSystemMetadata) _then;

  /// Create a copy of UserSystemMetadata
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? roles = null,
    Object? isAdmin = null,
    Object? inheritsRoles = null,
    Object? loginIdentifiers = null,
  }) {
    return _then(_self.copyWith(
      roles: null == roles
          ? _self.roles
          : roles // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      isAdmin: null == isAdmin
          ? _self.isAdmin
          : isAdmin // ignore: cast_nullable_to_non_nullable
              as bool,
      inheritsRoles: null == inheritsRoles
          ? _self.inheritsRoles
          : inheritsRoles // ignore: cast_nullable_to_non_nullable
              as bool,
      loginIdentifiers: null == loginIdentifiers
          ? _self.loginIdentifiers
          : loginIdentifiers // ignore: cast_nullable_to_non_nullable
              as List<LoginIdentifier>,
    ));
  }
}

/// @nodoc

class _UserSystemMetadata implements UserSystemMetadata {
  const _UserSystemMetadata(
      {required final Set<String> roles,
      required this.isAdmin,
      required this.inheritsRoles,
      final List<LoginIdentifier> loginIdentifiers = const []})
      : _roles = roles,
        _loginIdentifiers = loginIdentifiers;

  final Set<String> _roles;
  @override
  Set<String> get roles {
    if (_roles is EqualUnmodifiableSetView) return _roles;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_roles);
  }

  @override
  final bool isAdmin;
  @override
  final bool inheritsRoles;
  final List<LoginIdentifier> _loginIdentifiers;
  @override
  @JsonKey()
  List<LoginIdentifier> get loginIdentifiers {
    if (_loginIdentifiers is EqualUnmodifiableListView)
      return _loginIdentifiers;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_loginIdentifiers);
  }

  /// Create a copy of UserSystemMetadata
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$UserSystemMetadataCopyWith<_UserSystemMetadata> get copyWith =>
      __$UserSystemMetadataCopyWithImpl<_UserSystemMetadata>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _UserSystemMetadata &&
            const DeepCollectionEquality().equals(other._roles, _roles) &&
            (identical(other.isAdmin, isAdmin) || other.isAdmin == isAdmin) &&
            (identical(other.inheritsRoles, inheritsRoles) ||
                other.inheritsRoles == inheritsRoles) &&
            const DeepCollectionEquality()
                .equals(other._loginIdentifiers, _loginIdentifiers));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(_roles),
      isAdmin,
      inheritsRoles,
      const DeepCollectionEquality().hash(_loginIdentifiers));

  @override
  String toString() {
    return 'UserSystemMetadata(roles: $roles, isAdmin: $isAdmin, inheritsRoles: $inheritsRoles, loginIdentifiers: $loginIdentifiers)';
  }
}

/// @nodoc
abstract mixin class _$UserSystemMetadataCopyWith<$Res>
    implements $UserSystemMetadataCopyWith<$Res> {
  factory _$UserSystemMetadataCopyWith(
          _UserSystemMetadata value, $Res Function(_UserSystemMetadata) _then) =
      __$UserSystemMetadataCopyWithImpl;
  @override
  @useResult
  $Res call(
      {Set<String> roles,
      bool isAdmin,
      bool inheritsRoles,
      List<LoginIdentifier> loginIdentifiers});
}

/// @nodoc
class __$UserSystemMetadataCopyWithImpl<$Res>
    implements _$UserSystemMetadataCopyWith<$Res> {
  __$UserSystemMetadataCopyWithImpl(this._self, this._then);

  final _UserSystemMetadata _self;
  final $Res Function(_UserSystemMetadata) _then;

  /// Create a copy of UserSystemMetadata
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? roles = null,
    Object? isAdmin = null,
    Object? inheritsRoles = null,
    Object? loginIdentifiers = null,
  }) {
    return _then(_UserSystemMetadata(
      roles: null == roles
          ? _self._roles
          : roles // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      isAdmin: null == isAdmin
          ? _self.isAdmin
          : isAdmin // ignore: cast_nullable_to_non_nullable
              as bool,
      inheritsRoles: null == inheritsRoles
          ? _self.inheritsRoles
          : inheritsRoles // ignore: cast_nullable_to_non_nullable
              as bool,
      loginIdentifiers: null == loginIdentifiers
          ? _self._loginIdentifiers
          : loginIdentifiers // ignore: cast_nullable_to_non_nullable
              as List<LoginIdentifier>,
    ));
  }
}

// dart format on
