// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'substanceproduct.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Substanceproduct {
  List<CodeStub> get intendedcds;
  List<CodeStub> get deliveredcds;
  String? get intendedname;
  String? get deliveredname;
  String? get productId;

  /// Create a copy of Substanceproduct
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $SubstanceproductCopyWith<Substanceproduct> get copyWith =>
      _$SubstanceproductCopyWithImpl<Substanceproduct>(
          this as Substanceproduct, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Substanceproduct &&
            const DeepCollectionEquality()
                .equals(other.intendedcds, intendedcds) &&
            const DeepCollectionEquality()
                .equals(other.deliveredcds, deliveredcds) &&
            (identical(other.intendedname, intendedname) ||
                other.intendedname == intendedname) &&
            (identical(other.deliveredname, deliveredname) ||
                other.deliveredname == deliveredname) &&
            (identical(other.productId, productId) ||
                other.productId == productId));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(intendedcds),
      const DeepCollectionEquality().hash(deliveredcds),
      intendedname,
      deliveredname,
      productId);

  @override
  String toString() {
    return 'Substanceproduct(intendedcds: $intendedcds, deliveredcds: $deliveredcds, intendedname: $intendedname, deliveredname: $deliveredname, productId: $productId)';
  }
}

/// @nodoc
abstract mixin class $SubstanceproductCopyWith<$Res> {
  factory $SubstanceproductCopyWith(
          Substanceproduct value, $Res Function(Substanceproduct) _then) =
      _$SubstanceproductCopyWithImpl;
  @useResult
  $Res call(
      {List<CodeStub> intendedcds,
      List<CodeStub> deliveredcds,
      String? intendedname,
      String? deliveredname,
      String? productId});
}

/// @nodoc
class _$SubstanceproductCopyWithImpl<$Res>
    implements $SubstanceproductCopyWith<$Res> {
  _$SubstanceproductCopyWithImpl(this._self, this._then);

  final Substanceproduct _self;
  final $Res Function(Substanceproduct) _then;

  /// Create a copy of Substanceproduct
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? intendedcds = null,
    Object? deliveredcds = null,
    Object? intendedname = freezed,
    Object? deliveredname = freezed,
    Object? productId = freezed,
  }) {
    return _then(_self.copyWith(
      intendedcds: null == intendedcds
          ? _self.intendedcds
          : intendedcds // ignore: cast_nullable_to_non_nullable
              as List<CodeStub>,
      deliveredcds: null == deliveredcds
          ? _self.deliveredcds
          : deliveredcds // ignore: cast_nullable_to_non_nullable
              as List<CodeStub>,
      intendedname: freezed == intendedname
          ? _self.intendedname
          : intendedname // ignore: cast_nullable_to_non_nullable
              as String?,
      deliveredname: freezed == deliveredname
          ? _self.deliveredname
          : deliveredname // ignore: cast_nullable_to_non_nullable
              as String?,
      productId: freezed == productId
          ? _self.productId
          : productId // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _Substanceproduct implements Substanceproduct {
  const _Substanceproduct(
      {final List<CodeStub> intendedcds = const [],
      final List<CodeStub> deliveredcds = const [],
      this.intendedname = null,
      this.deliveredname = null,
      this.productId = null})
      : _intendedcds = intendedcds,
        _deliveredcds = deliveredcds;

  final List<CodeStub> _intendedcds;
  @override
  @JsonKey()
  List<CodeStub> get intendedcds {
    if (_intendedcds is EqualUnmodifiableListView) return _intendedcds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_intendedcds);
  }

  final List<CodeStub> _deliveredcds;
  @override
  @JsonKey()
  List<CodeStub> get deliveredcds {
    if (_deliveredcds is EqualUnmodifiableListView) return _deliveredcds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_deliveredcds);
  }

  @override
  @JsonKey()
  final String? intendedname;
  @override
  @JsonKey()
  final String? deliveredname;
  @override
  @JsonKey()
  final String? productId;

  /// Create a copy of Substanceproduct
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$SubstanceproductCopyWith<_Substanceproduct> get copyWith =>
      __$SubstanceproductCopyWithImpl<_Substanceproduct>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Substanceproduct &&
            const DeepCollectionEquality()
                .equals(other._intendedcds, _intendedcds) &&
            const DeepCollectionEquality()
                .equals(other._deliveredcds, _deliveredcds) &&
            (identical(other.intendedname, intendedname) ||
                other.intendedname == intendedname) &&
            (identical(other.deliveredname, deliveredname) ||
                other.deliveredname == deliveredname) &&
            (identical(other.productId, productId) ||
                other.productId == productId));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(_intendedcds),
      const DeepCollectionEquality().hash(_deliveredcds),
      intendedname,
      deliveredname,
      productId);

  @override
  String toString() {
    return 'Substanceproduct(intendedcds: $intendedcds, deliveredcds: $deliveredcds, intendedname: $intendedname, deliveredname: $deliveredname, productId: $productId)';
  }
}

/// @nodoc
abstract mixin class _$SubstanceproductCopyWith<$Res>
    implements $SubstanceproductCopyWith<$Res> {
  factory _$SubstanceproductCopyWith(
          _Substanceproduct value, $Res Function(_Substanceproduct) _then) =
      __$SubstanceproductCopyWithImpl;
  @override
  @useResult
  $Res call(
      {List<CodeStub> intendedcds,
      List<CodeStub> deliveredcds,
      String? intendedname,
      String? deliveredname,
      String? productId});
}

/// @nodoc
class __$SubstanceproductCopyWithImpl<$Res>
    implements _$SubstanceproductCopyWith<$Res> {
  __$SubstanceproductCopyWithImpl(this._self, this._then);

  final _Substanceproduct _self;
  final $Res Function(_Substanceproduct) _then;

  /// Create a copy of Substanceproduct
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? intendedcds = null,
    Object? deliveredcds = null,
    Object? intendedname = freezed,
    Object? deliveredname = freezed,
    Object? productId = freezed,
  }) {
    return _then(_Substanceproduct(
      intendedcds: null == intendedcds
          ? _self._intendedcds
          : intendedcds // ignore: cast_nullable_to_non_nullable
              as List<CodeStub>,
      deliveredcds: null == deliveredcds
          ? _self._deliveredcds
          : deliveredcds // ignore: cast_nullable_to_non_nullable
              as List<CodeStub>,
      intendedname: freezed == intendedname
          ? _self.intendedname
          : intendedname // ignore: cast_nullable_to_non_nullable
              as String?,
      deliveredname: freezed == deliveredname
          ? _self.deliveredname
          : deliveredname // ignore: cast_nullable_to_non_nullable
              as String?,
      productId: freezed == productId
          ? _self.productId
          : productId // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
