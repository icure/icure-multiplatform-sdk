// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'delegation.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Delegation {
  String? get owner;
  String? get delegatedTo;
  HexString? get key;
  List<String> get tags;

  /// Create a copy of Delegation
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DelegationCopyWith<Delegation> get copyWith =>
      _$DelegationCopyWithImpl<Delegation>(this as Delegation, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Delegation &&
            (identical(other.owner, owner) || other.owner == owner) &&
            (identical(other.delegatedTo, delegatedTo) ||
                other.delegatedTo == delegatedTo) &&
            (identical(other.key, key) || other.key == key) &&
            const DeepCollectionEquality().equals(other.tags, tags));
  }

  @override
  int get hashCode => Object.hash(runtimeType, owner, delegatedTo, key,
      const DeepCollectionEquality().hash(tags));

  @override
  String toString() {
    return 'Delegation(owner: $owner, delegatedTo: $delegatedTo, key: $key, tags: $tags)';
  }
}

/// @nodoc
abstract mixin class $DelegationCopyWith<$Res> {
  factory $DelegationCopyWith(
          Delegation value, $Res Function(Delegation) _then) =
      _$DelegationCopyWithImpl;
  @useResult
  $Res call(
      {String? owner, String? delegatedTo, HexString? key, List<String> tags});
}

/// @nodoc
class _$DelegationCopyWithImpl<$Res> implements $DelegationCopyWith<$Res> {
  _$DelegationCopyWithImpl(this._self, this._then);

  final Delegation _self;
  final $Res Function(Delegation) _then;

  /// Create a copy of Delegation
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? owner = freezed,
    Object? delegatedTo = freezed,
    Object? key = freezed,
    Object? tags = null,
  }) {
    return _then(_self.copyWith(
      owner: freezed == owner
          ? _self.owner
          : owner // ignore: cast_nullable_to_non_nullable
              as String?,
      delegatedTo: freezed == delegatedTo
          ? _self.delegatedTo
          : delegatedTo // ignore: cast_nullable_to_non_nullable
              as String?,
      key: freezed == key
          ? _self.key
          : key // ignore: cast_nullable_to_non_nullable
              as HexString?,
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as List<String>,
    ));
  }
}

/// @nodoc

class _Delegation implements Delegation {
  const _Delegation(
      {this.owner = null,
      this.delegatedTo = null,
      this.key = null,
      final List<String> tags = const []})
      : _tags = tags;

  @override
  @JsonKey()
  final String? owner;
  @override
  @JsonKey()
  final String? delegatedTo;
  @override
  @JsonKey()
  final HexString? key;
  final List<String> _tags;
  @override
  @JsonKey()
  List<String> get tags {
    if (_tags is EqualUnmodifiableListView) return _tags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_tags);
  }

  /// Create a copy of Delegation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DelegationCopyWith<_Delegation> get copyWith =>
      __$DelegationCopyWithImpl<_Delegation>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Delegation &&
            (identical(other.owner, owner) || other.owner == owner) &&
            (identical(other.delegatedTo, delegatedTo) ||
                other.delegatedTo == delegatedTo) &&
            (identical(other.key, key) || other.key == key) &&
            const DeepCollectionEquality().equals(other._tags, _tags));
  }

  @override
  int get hashCode => Object.hash(runtimeType, owner, delegatedTo, key,
      const DeepCollectionEquality().hash(_tags));

  @override
  String toString() {
    return 'Delegation(owner: $owner, delegatedTo: $delegatedTo, key: $key, tags: $tags)';
  }
}

/// @nodoc
abstract mixin class _$DelegationCopyWith<$Res>
    implements $DelegationCopyWith<$Res> {
  factory _$DelegationCopyWith(
          _Delegation value, $Res Function(_Delegation) _then) =
      __$DelegationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? owner, String? delegatedTo, HexString? key, List<String> tags});
}

/// @nodoc
class __$DelegationCopyWithImpl<$Res> implements _$DelegationCopyWith<$Res> {
  __$DelegationCopyWithImpl(this._self, this._then);

  final _Delegation _self;
  final $Res Function(_Delegation) _then;

  /// Create a copy of Delegation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? owner = freezed,
    Object? delegatedTo = freezed,
    Object? key = freezed,
    Object? tags = null,
  }) {
    return _then(_Delegation(
      owner: freezed == owner
          ? _self.owner
          : owner // ignore: cast_nullable_to_non_nullable
              as String?,
      delegatedTo: freezed == delegatedTo
          ? _self.delegatedTo
          : delegatedTo // ignore: cast_nullable_to_non_nullable
              as String?,
      key: freezed == key
          ? _self.key
          : key // ignore: cast_nullable_to_non_nullable
              as HexString?,
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as List<String>,
    ));
  }
}

// dart format on
