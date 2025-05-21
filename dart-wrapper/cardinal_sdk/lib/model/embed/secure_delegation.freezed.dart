// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'secure_delegation.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$SecureDelegation {
  String? get delegator;
  String? get delegate;
  Set<Base64String> get secretIds;
  Set<Base64String> get encryptionKeys;
  Set<Base64String> get owningEntityIds;
  Set<SecureDelegationKeyString> get parentDelegations;
  String? get exchangeDataId;
  AccessLevel get permissions;

  /// Create a copy of SecureDelegation
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $SecureDelegationCopyWith<SecureDelegation> get copyWith =>
      _$SecureDelegationCopyWithImpl<SecureDelegation>(
          this as SecureDelegation, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is SecureDelegation &&
            (identical(other.delegator, delegator) ||
                other.delegator == delegator) &&
            (identical(other.delegate, delegate) ||
                other.delegate == delegate) &&
            const DeepCollectionEquality().equals(other.secretIds, secretIds) &&
            const DeepCollectionEquality()
                .equals(other.encryptionKeys, encryptionKeys) &&
            const DeepCollectionEquality()
                .equals(other.owningEntityIds, owningEntityIds) &&
            const DeepCollectionEquality()
                .equals(other.parentDelegations, parentDelegations) &&
            (identical(other.exchangeDataId, exchangeDataId) ||
                other.exchangeDataId == exchangeDataId) &&
            (identical(other.permissions, permissions) ||
                other.permissions == permissions));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      delegator,
      delegate,
      const DeepCollectionEquality().hash(secretIds),
      const DeepCollectionEquality().hash(encryptionKeys),
      const DeepCollectionEquality().hash(owningEntityIds),
      const DeepCollectionEquality().hash(parentDelegations),
      exchangeDataId,
      permissions);

  @override
  String toString() {
    return 'SecureDelegation(delegator: $delegator, delegate: $delegate, secretIds: $secretIds, encryptionKeys: $encryptionKeys, owningEntityIds: $owningEntityIds, parentDelegations: $parentDelegations, exchangeDataId: $exchangeDataId, permissions: $permissions)';
  }
}

/// @nodoc
abstract mixin class $SecureDelegationCopyWith<$Res> {
  factory $SecureDelegationCopyWith(
          SecureDelegation value, $Res Function(SecureDelegation) _then) =
      _$SecureDelegationCopyWithImpl;
  @useResult
  $Res call(
      {String? delegator,
      String? delegate,
      Set<Base64String> secretIds,
      Set<Base64String> encryptionKeys,
      Set<Base64String> owningEntityIds,
      Set<SecureDelegationKeyString> parentDelegations,
      String? exchangeDataId,
      AccessLevel permissions});
}

/// @nodoc
class _$SecureDelegationCopyWithImpl<$Res>
    implements $SecureDelegationCopyWith<$Res> {
  _$SecureDelegationCopyWithImpl(this._self, this._then);

  final SecureDelegation _self;
  final $Res Function(SecureDelegation) _then;

  /// Create a copy of SecureDelegation
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? delegator = freezed,
    Object? delegate = freezed,
    Object? secretIds = null,
    Object? encryptionKeys = null,
    Object? owningEntityIds = null,
    Object? parentDelegations = null,
    Object? exchangeDataId = freezed,
    Object? permissions = null,
  }) {
    return _then(_self.copyWith(
      delegator: freezed == delegator
          ? _self.delegator
          : delegator // ignore: cast_nullable_to_non_nullable
              as String?,
      delegate: freezed == delegate
          ? _self.delegate
          : delegate // ignore: cast_nullable_to_non_nullable
              as String?,
      secretIds: null == secretIds
          ? _self.secretIds
          : secretIds // ignore: cast_nullable_to_non_nullable
              as Set<Base64String>,
      encryptionKeys: null == encryptionKeys
          ? _self.encryptionKeys
          : encryptionKeys // ignore: cast_nullable_to_non_nullable
              as Set<Base64String>,
      owningEntityIds: null == owningEntityIds
          ? _self.owningEntityIds
          : owningEntityIds // ignore: cast_nullable_to_non_nullable
              as Set<Base64String>,
      parentDelegations: null == parentDelegations
          ? _self.parentDelegations
          : parentDelegations // ignore: cast_nullable_to_non_nullable
              as Set<SecureDelegationKeyString>,
      exchangeDataId: freezed == exchangeDataId
          ? _self.exchangeDataId
          : exchangeDataId // ignore: cast_nullable_to_non_nullable
              as String?,
      permissions: null == permissions
          ? _self.permissions
          : permissions // ignore: cast_nullable_to_non_nullable
              as AccessLevel,
    ));
  }
}

/// @nodoc

class _SecureDelegation implements SecureDelegation {
  const _SecureDelegation(
      {this.delegator = null,
      this.delegate = null,
      final Set<Base64String> secretIds = const {},
      final Set<Base64String> encryptionKeys = const {},
      final Set<Base64String> owningEntityIds = const {},
      final Set<SecureDelegationKeyString> parentDelegations = const {},
      this.exchangeDataId = null,
      required this.permissions})
      : _secretIds = secretIds,
        _encryptionKeys = encryptionKeys,
        _owningEntityIds = owningEntityIds,
        _parentDelegations = parentDelegations;

  @override
  @JsonKey()
  final String? delegator;
  @override
  @JsonKey()
  final String? delegate;
  final Set<Base64String> _secretIds;
  @override
  @JsonKey()
  Set<Base64String> get secretIds {
    if (_secretIds is EqualUnmodifiableSetView) return _secretIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_secretIds);
  }

  final Set<Base64String> _encryptionKeys;
  @override
  @JsonKey()
  Set<Base64String> get encryptionKeys {
    if (_encryptionKeys is EqualUnmodifiableSetView) return _encryptionKeys;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_encryptionKeys);
  }

  final Set<Base64String> _owningEntityIds;
  @override
  @JsonKey()
  Set<Base64String> get owningEntityIds {
    if (_owningEntityIds is EqualUnmodifiableSetView) return _owningEntityIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_owningEntityIds);
  }

  final Set<SecureDelegationKeyString> _parentDelegations;
  @override
  @JsonKey()
  Set<SecureDelegationKeyString> get parentDelegations {
    if (_parentDelegations is EqualUnmodifiableSetView)
      return _parentDelegations;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_parentDelegations);
  }

  @override
  @JsonKey()
  final String? exchangeDataId;
  @override
  final AccessLevel permissions;

  /// Create a copy of SecureDelegation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$SecureDelegationCopyWith<_SecureDelegation> get copyWith =>
      __$SecureDelegationCopyWithImpl<_SecureDelegation>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _SecureDelegation &&
            (identical(other.delegator, delegator) ||
                other.delegator == delegator) &&
            (identical(other.delegate, delegate) ||
                other.delegate == delegate) &&
            const DeepCollectionEquality()
                .equals(other._secretIds, _secretIds) &&
            const DeepCollectionEquality()
                .equals(other._encryptionKeys, _encryptionKeys) &&
            const DeepCollectionEquality()
                .equals(other._owningEntityIds, _owningEntityIds) &&
            const DeepCollectionEquality()
                .equals(other._parentDelegations, _parentDelegations) &&
            (identical(other.exchangeDataId, exchangeDataId) ||
                other.exchangeDataId == exchangeDataId) &&
            (identical(other.permissions, permissions) ||
                other.permissions == permissions));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      delegator,
      delegate,
      const DeepCollectionEquality().hash(_secretIds),
      const DeepCollectionEquality().hash(_encryptionKeys),
      const DeepCollectionEquality().hash(_owningEntityIds),
      const DeepCollectionEquality().hash(_parentDelegations),
      exchangeDataId,
      permissions);

  @override
  String toString() {
    return 'SecureDelegation(delegator: $delegator, delegate: $delegate, secretIds: $secretIds, encryptionKeys: $encryptionKeys, owningEntityIds: $owningEntityIds, parentDelegations: $parentDelegations, exchangeDataId: $exchangeDataId, permissions: $permissions)';
  }
}

/// @nodoc
abstract mixin class _$SecureDelegationCopyWith<$Res>
    implements $SecureDelegationCopyWith<$Res> {
  factory _$SecureDelegationCopyWith(
          _SecureDelegation value, $Res Function(_SecureDelegation) _then) =
      __$SecureDelegationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? delegator,
      String? delegate,
      Set<Base64String> secretIds,
      Set<Base64String> encryptionKeys,
      Set<Base64String> owningEntityIds,
      Set<SecureDelegationKeyString> parentDelegations,
      String? exchangeDataId,
      AccessLevel permissions});
}

/// @nodoc
class __$SecureDelegationCopyWithImpl<$Res>
    implements _$SecureDelegationCopyWith<$Res> {
  __$SecureDelegationCopyWithImpl(this._self, this._then);

  final _SecureDelegation _self;
  final $Res Function(_SecureDelegation) _then;

  /// Create a copy of SecureDelegation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? delegator = freezed,
    Object? delegate = freezed,
    Object? secretIds = null,
    Object? encryptionKeys = null,
    Object? owningEntityIds = null,
    Object? parentDelegations = null,
    Object? exchangeDataId = freezed,
    Object? permissions = null,
  }) {
    return _then(_SecureDelegation(
      delegator: freezed == delegator
          ? _self.delegator
          : delegator // ignore: cast_nullable_to_non_nullable
              as String?,
      delegate: freezed == delegate
          ? _self.delegate
          : delegate // ignore: cast_nullable_to_non_nullable
              as String?,
      secretIds: null == secretIds
          ? _self._secretIds
          : secretIds // ignore: cast_nullable_to_non_nullable
              as Set<Base64String>,
      encryptionKeys: null == encryptionKeys
          ? _self._encryptionKeys
          : encryptionKeys // ignore: cast_nullable_to_non_nullable
              as Set<Base64String>,
      owningEntityIds: null == owningEntityIds
          ? _self._owningEntityIds
          : owningEntityIds // ignore: cast_nullable_to_non_nullable
              as Set<Base64String>,
      parentDelegations: null == parentDelegations
          ? _self._parentDelegations
          : parentDelegations // ignore: cast_nullable_to_non_nullable
              as Set<SecureDelegationKeyString>,
      exchangeDataId: freezed == exchangeDataId
          ? _self.exchangeDataId
          : exchangeDataId // ignore: cast_nullable_to_non_nullable
              as String?,
      permissions: null == permissions
          ? _self.permissions
          : permissions // ignore: cast_nullable_to_non_nullable
              as AccessLevel,
    ));
  }
}

// dart format on
