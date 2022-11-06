// ignore_for_file: type=lint

import 'package:json_annotation/json_annotation.dart';
import 'package:collection/collection.dart';
import 'dart:convert';

part 'swagger.models.swagger.g.dart';

@JsonSerializable(explicitToJson: true)
class User20m2 {
  User20m2({
    this.dob,
    this.email,
    this.lastname,
    this.name,
    this.phoneNumber,
    this.treatmentPersonalData,
    this.userId,
  });

  factory User20m2.fromJson(Map<String, dynamic> json) =>
      _$User20m2FromJson(json);

  @JsonKey(name: 'dob')
  final String? dob;
  @JsonKey(name: 'email')
  final String? email;
  @JsonKey(name: 'lastname')
  final String? lastname;
  @JsonKey(name: 'name')
  final String? name;
  @JsonKey(name: 'phoneNumber')
  final String? phoneNumber;
  @JsonKey(name: 'treatmentPersonalData')
  final bool? treatmentPersonalData;
  @JsonKey(name: 'userId')
  final num? userId;
  static const fromJsonFactory = _$User20m2FromJson;
  static const toJsonFactory = _$User20m2ToJson;
  Map<String, dynamic> toJson() => _$User20m2ToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is User20m2 &&
            (identical(other.dob, dob) ||
                const DeepCollectionEquality().equals(other.dob, dob)) &&
            (identical(other.email, email) ||
                const DeepCollectionEquality().equals(other.email, email)) &&
            (identical(other.lastname, lastname) ||
                const DeepCollectionEquality()
                    .equals(other.lastname, lastname)) &&
            (identical(other.name, name) ||
                const DeepCollectionEquality().equals(other.name, name)) &&
            (identical(other.phoneNumber, phoneNumber) ||
                const DeepCollectionEquality()
                    .equals(other.phoneNumber, phoneNumber)) &&
            (identical(other.treatmentPersonalData, treatmentPersonalData) ||
                const DeepCollectionEquality().equals(
                    other.treatmentPersonalData, treatmentPersonalData)) &&
            (identical(other.userId, userId) ||
                const DeepCollectionEquality().equals(other.userId, userId)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(dob) ^
      const DeepCollectionEquality().hash(email) ^
      const DeepCollectionEquality().hash(lastname) ^
      const DeepCollectionEquality().hash(name) ^
      const DeepCollectionEquality().hash(phoneNumber) ^
      const DeepCollectionEquality().hash(treatmentPersonalData) ^
      const DeepCollectionEquality().hash(userId) ^
      runtimeType.hashCode;
}

extension $User20m2Extension on User20m2 {
  User20m2 copyWith(
      {String? dob,
      String? email,
      String? lastname,
      String? name,
      String? phoneNumber,
      bool? treatmentPersonalData,
      num? userId}) {
    return User20m2(
        dob: dob ?? this.dob,
        email: email ?? this.email,
        lastname: lastname ?? this.lastname,
        name: name ?? this.name,
        phoneNumber: phoneNumber ?? this.phoneNumber,
        treatmentPersonalData:
            treatmentPersonalData ?? this.treatmentPersonalData,
        userId: userId ?? this.userId);
  }

  User20m2 copyWithWrapped(
      {Wrapped<String?>? dob,
      Wrapped<String?>? email,
      Wrapped<String?>? lastname,
      Wrapped<String?>? name,
      Wrapped<String?>? phoneNumber,
      Wrapped<bool?>? treatmentPersonalData,
      Wrapped<num?>? userId}) {
    return User20m2(
        dob: (dob != null ? dob.value : this.dob),
        email: (email != null ? email.value : this.email),
        lastname: (lastname != null ? lastname.value : this.lastname),
        name: (name != null ? name.value : this.name),
        phoneNumber:
            (phoneNumber != null ? phoneNumber.value : this.phoneNumber),
        treatmentPersonalData: (treatmentPersonalData != null
            ? treatmentPersonalData.value
            : this.treatmentPersonalData),
        userId: (userId != null ? userId.value : this.userId));
  }
}

// ignore: unused_element
String? _dateToJson(DateTime? date) {
  if (date == null) {
    return null;
  }

  final year = date.year.toString();
  final month = date.month < 10 ? '0${date.month}' : date.month.toString();
  final day = date.day < 10 ? '0${date.day}' : date.day.toString();

  return '$year-$month-$day';
}

class Wrapped<T> {
  final T value;
  const Wrapped.value(this.value);
}
