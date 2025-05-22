// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'code.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Code {
  String get id;
  String? get rev;
  int? get deletionDate;
  String? get context;
  String? get type;
  String? get code;
  String? get version;
  Map<String, String>? get label;
  String? get author;
  Set<String> get regions;
  Set<Periodicity> get periodicity;
  int? get level;
  Set<String> get links;
  Map<String, List<String>> get qualifiedLinks;
  Set<CodeFlag> get flags;
  Map<String, Set<String>> get searchTerms;
  String? get data;
  Map<AppendixType, String> get appendices;
  bool get disabled;

  /// Create a copy of Code
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $CodeCopyWith<Code> get copyWith =>
      _$CodeCopyWithImpl<Code>(this as Code, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Code &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.context, context) || other.context == context) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.version, version) || other.version == version) &&
            const DeepCollectionEquality().equals(other.label, label) &&
            (identical(other.author, author) || other.author == author) &&
            const DeepCollectionEquality().equals(other.regions, regions) &&
            const DeepCollectionEquality()
                .equals(other.periodicity, periodicity) &&
            (identical(other.level, level) || other.level == level) &&
            const DeepCollectionEquality().equals(other.links, links) &&
            const DeepCollectionEquality()
                .equals(other.qualifiedLinks, qualifiedLinks) &&
            const DeepCollectionEquality().equals(other.flags, flags) &&
            const DeepCollectionEquality()
                .equals(other.searchTerms, searchTerms) &&
            (identical(other.data, data) || other.data == data) &&
            const DeepCollectionEquality()
                .equals(other.appendices, appendices) &&
            (identical(other.disabled, disabled) ||
                other.disabled == disabled));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        deletionDate,
        context,
        type,
        code,
        version,
        const DeepCollectionEquality().hash(label),
        author,
        const DeepCollectionEquality().hash(regions),
        const DeepCollectionEquality().hash(periodicity),
        level,
        const DeepCollectionEquality().hash(links),
        const DeepCollectionEquality().hash(qualifiedLinks),
        const DeepCollectionEquality().hash(flags),
        const DeepCollectionEquality().hash(searchTerms),
        data,
        const DeepCollectionEquality().hash(appendices),
        disabled
      ]);

  @override
  String toString() {
    return 'Code(id: $id, rev: $rev, deletionDate: $deletionDate, context: $context, type: $type, code: $code, version: $version, label: $label, author: $author, regions: $regions, periodicity: $periodicity, level: $level, links: $links, qualifiedLinks: $qualifiedLinks, flags: $flags, searchTerms: $searchTerms, data: $data, appendices: $appendices, disabled: $disabled)';
  }
}

/// @nodoc
abstract mixin class $CodeCopyWith<$Res> {
  factory $CodeCopyWith(Code value, $Res Function(Code) _then) =
      _$CodeCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? context,
      String? type,
      String? code,
      String? version,
      Map<String, String>? label,
      String? author,
      Set<String> regions,
      Set<Periodicity> periodicity,
      int? level,
      Set<String> links,
      Map<String, List<String>> qualifiedLinks,
      Set<CodeFlag> flags,
      Map<String, Set<String>> searchTerms,
      String? data,
      Map<AppendixType, String> appendices,
      bool disabled});
}

/// @nodoc
class _$CodeCopyWithImpl<$Res> implements $CodeCopyWith<$Res> {
  _$CodeCopyWithImpl(this._self, this._then);

  final Code _self;
  final $Res Function(Code) _then;

  /// Create a copy of Code
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? context = freezed,
    Object? type = freezed,
    Object? code = freezed,
    Object? version = freezed,
    Object? label = freezed,
    Object? author = freezed,
    Object? regions = null,
    Object? periodicity = null,
    Object? level = freezed,
    Object? links = null,
    Object? qualifiedLinks = null,
    Object? flags = null,
    Object? searchTerms = null,
    Object? data = freezed,
    Object? appendices = null,
    Object? disabled = null,
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
      context: freezed == context
          ? _self.context
          : context // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as String?,
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as String?,
      label: freezed == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      author: freezed == author
          ? _self.author
          : author // ignore: cast_nullable_to_non_nullable
              as String?,
      regions: null == regions
          ? _self.regions
          : regions // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      periodicity: null == periodicity
          ? _self.periodicity
          : periodicity // ignore: cast_nullable_to_non_nullable
              as Set<Periodicity>,
      level: freezed == level
          ? _self.level
          : level // ignore: cast_nullable_to_non_nullable
              as int?,
      links: null == links
          ? _self.links
          : links // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      qualifiedLinks: null == qualifiedLinks
          ? _self.qualifiedLinks
          : qualifiedLinks // ignore: cast_nullable_to_non_nullable
              as Map<String, List<String>>,
      flags: null == flags
          ? _self.flags
          : flags // ignore: cast_nullable_to_non_nullable
              as Set<CodeFlag>,
      searchTerms: null == searchTerms
          ? _self.searchTerms
          : searchTerms // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<String>>,
      data: freezed == data
          ? _self.data
          : data // ignore: cast_nullable_to_non_nullable
              as String?,
      appendices: null == appendices
          ? _self.appendices
          : appendices // ignore: cast_nullable_to_non_nullable
              as Map<AppendixType, String>,
      disabled: null == disabled
          ? _self.disabled
          : disabled // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

/// @nodoc

class _Code implements Code {
  const _Code(
      {required this.id,
      this.rev = null,
      this.deletionDate = null,
      this.context = null,
      this.type = null,
      this.code = null,
      this.version = null,
      final Map<String, String>? label = null,
      this.author = null,
      final Set<String> regions = const {},
      final Set<Periodicity> periodicity = const {},
      this.level = null,
      final Set<String> links = const {},
      final Map<String, List<String>> qualifiedLinks = const {},
      final Set<CodeFlag> flags = const {},
      final Map<String, Set<String>> searchTerms = const {},
      this.data = null,
      final Map<AppendixType, String> appendices = const {},
      this.disabled = false})
      : _label = label,
        _regions = regions,
        _periodicity = periodicity,
        _links = links,
        _qualifiedLinks = qualifiedLinks,
        _flags = flags,
        _searchTerms = searchTerms,
        _appendices = appendices;

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
  final String? context;
  @override
  @JsonKey()
  final String? type;
  @override
  @JsonKey()
  final String? code;
  @override
  @JsonKey()
  final String? version;
  final Map<String, String>? _label;
  @override
  @JsonKey()
  Map<String, String>? get label {
    final value = _label;
    if (value == null) return null;
    if (_label is EqualUnmodifiableMapView) return _label;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(value);
  }

  @override
  @JsonKey()
  final String? author;
  final Set<String> _regions;
  @override
  @JsonKey()
  Set<String> get regions {
    if (_regions is EqualUnmodifiableSetView) return _regions;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_regions);
  }

  final Set<Periodicity> _periodicity;
  @override
  @JsonKey()
  Set<Periodicity> get periodicity {
    if (_periodicity is EqualUnmodifiableSetView) return _periodicity;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_periodicity);
  }

  @override
  @JsonKey()
  final int? level;
  final Set<String> _links;
  @override
  @JsonKey()
  Set<String> get links {
    if (_links is EqualUnmodifiableSetView) return _links;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_links);
  }

  final Map<String, List<String>> _qualifiedLinks;
  @override
  @JsonKey()
  Map<String, List<String>> get qualifiedLinks {
    if (_qualifiedLinks is EqualUnmodifiableMapView) return _qualifiedLinks;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_qualifiedLinks);
  }

  final Set<CodeFlag> _flags;
  @override
  @JsonKey()
  Set<CodeFlag> get flags {
    if (_flags is EqualUnmodifiableSetView) return _flags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_flags);
  }

  final Map<String, Set<String>> _searchTerms;
  @override
  @JsonKey()
  Map<String, Set<String>> get searchTerms {
    if (_searchTerms is EqualUnmodifiableMapView) return _searchTerms;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_searchTerms);
  }

  @override
  @JsonKey()
  final String? data;
  final Map<AppendixType, String> _appendices;
  @override
  @JsonKey()
  Map<AppendixType, String> get appendices {
    if (_appendices is EqualUnmodifiableMapView) return _appendices;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_appendices);
  }

  @override
  @JsonKey()
  final bool disabled;

  /// Create a copy of Code
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$CodeCopyWith<_Code> get copyWith =>
      __$CodeCopyWithImpl<_Code>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Code &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.context, context) || other.context == context) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.version, version) || other.version == version) &&
            const DeepCollectionEquality().equals(other._label, _label) &&
            (identical(other.author, author) || other.author == author) &&
            const DeepCollectionEquality().equals(other._regions, _regions) &&
            const DeepCollectionEquality()
                .equals(other._periodicity, _periodicity) &&
            (identical(other.level, level) || other.level == level) &&
            const DeepCollectionEquality().equals(other._links, _links) &&
            const DeepCollectionEquality()
                .equals(other._qualifiedLinks, _qualifiedLinks) &&
            const DeepCollectionEquality().equals(other._flags, _flags) &&
            const DeepCollectionEquality()
                .equals(other._searchTerms, _searchTerms) &&
            (identical(other.data, data) || other.data == data) &&
            const DeepCollectionEquality()
                .equals(other._appendices, _appendices) &&
            (identical(other.disabled, disabled) ||
                other.disabled == disabled));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        deletionDate,
        context,
        type,
        code,
        version,
        const DeepCollectionEquality().hash(_label),
        author,
        const DeepCollectionEquality().hash(_regions),
        const DeepCollectionEquality().hash(_periodicity),
        level,
        const DeepCollectionEquality().hash(_links),
        const DeepCollectionEquality().hash(_qualifiedLinks),
        const DeepCollectionEquality().hash(_flags),
        const DeepCollectionEquality().hash(_searchTerms),
        data,
        const DeepCollectionEquality().hash(_appendices),
        disabled
      ]);

  @override
  String toString() {
    return 'Code(id: $id, rev: $rev, deletionDate: $deletionDate, context: $context, type: $type, code: $code, version: $version, label: $label, author: $author, regions: $regions, periodicity: $periodicity, level: $level, links: $links, qualifiedLinks: $qualifiedLinks, flags: $flags, searchTerms: $searchTerms, data: $data, appendices: $appendices, disabled: $disabled)';
  }
}

/// @nodoc
abstract mixin class _$CodeCopyWith<$Res> implements $CodeCopyWith<$Res> {
  factory _$CodeCopyWith(_Code value, $Res Function(_Code) _then) =
      __$CodeCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? context,
      String? type,
      String? code,
      String? version,
      Map<String, String>? label,
      String? author,
      Set<String> regions,
      Set<Periodicity> periodicity,
      int? level,
      Set<String> links,
      Map<String, List<String>> qualifiedLinks,
      Set<CodeFlag> flags,
      Map<String, Set<String>> searchTerms,
      String? data,
      Map<AppendixType, String> appendices,
      bool disabled});
}

/// @nodoc
class __$CodeCopyWithImpl<$Res> implements _$CodeCopyWith<$Res> {
  __$CodeCopyWithImpl(this._self, this._then);

  final _Code _self;
  final $Res Function(_Code) _then;

  /// Create a copy of Code
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? context = freezed,
    Object? type = freezed,
    Object? code = freezed,
    Object? version = freezed,
    Object? label = freezed,
    Object? author = freezed,
    Object? regions = null,
    Object? periodicity = null,
    Object? level = freezed,
    Object? links = null,
    Object? qualifiedLinks = null,
    Object? flags = null,
    Object? searchTerms = null,
    Object? data = freezed,
    Object? appendices = null,
    Object? disabled = null,
  }) {
    return _then(_Code(
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
      context: freezed == context
          ? _self.context
          : context // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as String?,
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as String?,
      label: freezed == label
          ? _self._label
          : label // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      author: freezed == author
          ? _self.author
          : author // ignore: cast_nullable_to_non_nullable
              as String?,
      regions: null == regions
          ? _self._regions
          : regions // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      periodicity: null == periodicity
          ? _self._periodicity
          : periodicity // ignore: cast_nullable_to_non_nullable
              as Set<Periodicity>,
      level: freezed == level
          ? _self.level
          : level // ignore: cast_nullable_to_non_nullable
              as int?,
      links: null == links
          ? _self._links
          : links // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      qualifiedLinks: null == qualifiedLinks
          ? _self._qualifiedLinks
          : qualifiedLinks // ignore: cast_nullable_to_non_nullable
              as Map<String, List<String>>,
      flags: null == flags
          ? _self._flags
          : flags // ignore: cast_nullable_to_non_nullable
              as Set<CodeFlag>,
      searchTerms: null == searchTerms
          ? _self._searchTerms
          : searchTerms // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<String>>,
      data: freezed == data
          ? _self.data
          : data // ignore: cast_nullable_to_non_nullable
              as String?,
      appendices: null == appendices
          ? _self._appendices
          : appendices // ignore: cast_nullable_to_non_nullable
              as Map<AppendixType, String>,
      disabled: null == disabled
          ? _self.disabled
          : disabled // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

// dart format on
