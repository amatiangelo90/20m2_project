// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'swagger.models.swagger.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

User20m2 _$User20m2FromJson(Map<String, dynamic> json) => User20m2(
      dob: json['dob'] as String?,
      email: json['email'] as String?,
      lastname: json['lastname'] as String?,
      name: json['name'] as String?,
      phoneNumber: json['phoneNumber'] as String?,
      treatmentPersonalData: json['treatmentPersonalData'] as bool?,
      userId: json['userId'] as num?,
    );

Map<String, dynamic> _$User20m2ToJson(User20m2 instance) => <String, dynamic>{
      'dob': instance.dob,
      'email': instance.email,
      'lastname': instance.lastname,
      'name': instance.name,
      'phoneNumber': instance.phoneNumber,
      'treatmentPersonalData': instance.treatmentPersonalData,
      'userId': instance.userId,
    };
