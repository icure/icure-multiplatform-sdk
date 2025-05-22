// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'entity_with_encryption_metadata_stub.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EntityWithEncryptionMetadataStub {
  String get id;
  String? get rev;
  Set<String> get secretForeignKeys;
  Map<String, Set<Delegation>> get cryptedForeignKeys;
  Map<String, Set<Delegation>> get delegations;
  Map<String, Set<Delegation>> get encryptionKeys;
  SecurityMetadata? get securityMetadata;

  /// Create a copy of EntityWithEncryptionMetadataStub
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EntityWithEncryptionMetadataStubCopyWith<EntityWithEncryptionMetadataStub>
      get copyWith => _$EntityWithEncryptionMetadataStubCopyWithImpl<
              EntityWithEncryptionMetadataStub>(
          this as EntityWithEncryptionMetadataStub, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EntityWithEncryptionMetadataStub &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            const DeepCollectionEquality()
                .equals(other.secretForeignKeys, secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.cryptedForeignKeys, cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other.delegations, delegations) &&
            const DeepCollectionEquality()
                .equals(other.encryptionKeys, encryptionKeys) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      const DeepCollectionEquality().hash(secretForeignKeys),
      const DeepCollectionEquality().hash(cryptedForeignKeys),
      const DeepCollectionEquality().hash(delegations),
      const DeepCollectionEquality().hash(encryptionKeys),
      securityMetadata);

  @override
  String toString() {
    return 'EntityWithEncryptionMetadataStub(id: $id, rev: $rev, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class $EntityWithEncryptionMetadataStubCopyWith<$Res> {
  factory $EntityWithEncryptionMetadataStubCopyWith(
          EntityWithEncryptionMetadataStub value,
          $Res Function(EntityWithEncryptionMetadataStub) _then) =
      _$EntityWithEncryptionMetadataStubCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      SecurityMetadata? securityMetadata});

  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class _$EntityWithEncryptionMetadataStubCopyWithImpl<$Res>
    implements $EntityWithEncryptionMetadataStubCopyWith<$Res> {
  _$EntityWithEncryptionMetadataStubCopyWithImpl(this._self, this._then);

  final EntityWithEncryptionMetadataStub _self;
  final $Res Function(EntityWithEncryptionMetadataStub) _then;

  /// Create a copy of EntityWithEncryptionMetadataStub
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
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
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
    ));
  }

  /// Create a copy of EntityWithEncryptionMetadataStub
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

class _EntityWithEncryptionMetadataStub
    implements EntityWithEncryptionMetadataStub {
  const _EntityWithEncryptionMetadataStub(
      {required this.id,
      required this.rev,
      required final Set<String> secretForeignKeys,
      required final Map<String, Set<Delegation>> cryptedForeignKeys,
      required final Map<String, Set<Delegation>> delegations,
      required final Map<String, Set<Delegation>> encryptionKeys,
      required this.securityMetadata})
      : _secretForeignKeys = secretForeignKeys,
        _cryptedForeignKeys = cryptedForeignKeys,
        _delegations = delegations,
        _encryptionKeys = encryptionKeys;

  @override
  final String id;
  @override
  final String? rev;
  final Set<String> _secretForeignKeys;
  @override
  Set<String> get secretForeignKeys {
    if (_secretForeignKeys is EqualUnmodifiableSetView)
      return _secretForeignKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_secretForeignKeys);
  }

  final Map<String, Set<Delegation>> _cryptedForeignKeys;
  @override
  Map<String, Set<Delegation>> get cryptedForeignKeys {
    if (_cryptedForeignKeys is EqualUnmodifiableMapView)
      return _cryptedForeignKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_cryptedForeignKeys);
  }

  final Map<String, Set<Delegation>> _delegations;
  @override
  Map<String, Set<Delegation>> get delegations {
    if (_delegations is EqualUnmodifiableMapView) return _delegations;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_delegations);
  }

  final Map<String, Set<Delegation>> _encryptionKeys;
  @override
  Map<String, Set<Delegation>> get encryptionKeys {
    if (_encryptionKeys is EqualUnmodifiableMapView) return _encryptionKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_encryptionKeys);
  }

  @override
  final SecurityMetadata? securityMetadata;

  /// Create a copy of EntityWithEncryptionMetadataStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EntityWithEncryptionMetadataStubCopyWith<_EntityWithEncryptionMetadataStub>
      get copyWith => __$EntityWithEncryptionMetadataStubCopyWithImpl<
          _EntityWithEncryptionMetadataStub>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EntityWithEncryptionMetadataStub &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            const DeepCollectionEquality()
                .equals(other._secretForeignKeys, _secretForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._cryptedForeignKeys, _cryptedForeignKeys) &&
            const DeepCollectionEquality()
                .equals(other._delegations, _delegations) &&
            const DeepCollectionEquality()
                .equals(other._encryptionKeys, _encryptionKeys) &&
            (identical(other.securityMetadata, securityMetadata) ||
                other.securityMetadata == securityMetadata));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      const DeepCollectionEquality().hash(_secretForeignKeys),
      const DeepCollectionEquality().hash(_cryptedForeignKeys),
      const DeepCollectionEquality().hash(_delegations),
      const DeepCollectionEquality().hash(_encryptionKeys),
      securityMetadata);

  @override
  String toString() {
    return 'EntityWithEncryptionMetadataStub(id: $id, rev: $rev, secretForeignKeys: $secretForeignKeys, cryptedForeignKeys: $cryptedForeignKeys, delegations: $delegations, encryptionKeys: $encryptionKeys, securityMetadata: $securityMetadata)';
  }
}

/// @nodoc
abstract mixin class _$EntityWithEncryptionMetadataStubCopyWith<$Res>
    implements $EntityWithEncryptionMetadataStubCopyWith<$Res> {
  factory _$EntityWithEncryptionMetadataStubCopyWith(
          _EntityWithEncryptionMetadataStub value,
          $Res Function(_EntityWithEncryptionMetadataStub) _then) =
      __$EntityWithEncryptionMetadataStubCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      Set<String> secretForeignKeys,
      Map<String, Set<Delegation>> cryptedForeignKeys,
      Map<String, Set<Delegation>> delegations,
      Map<String, Set<Delegation>> encryptionKeys,
      SecurityMetadata? securityMetadata});

  @override
  $SecurityMetadataCopyWith<$Res>? get securityMetadata;
}

/// @nodoc
class __$EntityWithEncryptionMetadataStubCopyWithImpl<$Res>
    implements _$EntityWithEncryptionMetadataStubCopyWith<$Res> {
  __$EntityWithEncryptionMetadataStubCopyWithImpl(this._self, this._then);

  final _EntityWithEncryptionMetadataStub _self;
  final $Res Function(_EntityWithEncryptionMetadataStub) _then;

  /// Create a copy of EntityWithEncryptionMetadataStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? secretForeignKeys = null,
    Object? cryptedForeignKeys = null,
    Object? delegations = null,
    Object? encryptionKeys = null,
    Object? securityMetadata = freezed,
  }) {
    return _then(_EntityWithEncryptionMetadataStub(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
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
      securityMetadata: freezed == securityMetadata
          ? _self.securityMetadata
          : securityMetadata // ignore: cast_nullable_to_non_nullable
              as SecurityMetadata?,
    ));
  }

  /// Create a copy of EntityWithEncryptionMetadataStub
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
