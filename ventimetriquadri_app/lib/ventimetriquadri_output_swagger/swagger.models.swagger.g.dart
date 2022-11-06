// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'swagger.models.swagger.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Storage _$StorageFromJson(Map<String, dynamic> json) => Storage(
      address: json['address'] as String?,
      cap: json['cap'] as int?,
      city: json['city'] as String?,
      creationDate: json['creationDate'] as String?,
      name: json['name'] as String?,
      storageId: json['storageId'] as num?,
    );

Map<String, dynamic> _$StorageToJson(Storage instance) => <String, dynamic>{
      'address': instance.address,
      'cap': instance.cap,
      'city': instance.city,
      'creationDate': instance.creationDate,
      'name': instance.name,
      'storageId': instance.storageId,
    };

Customers _$CustomersFromJson(Map<String, dynamic> json) => Customers(
      accessCounter: json['accessCounter'] as int?,
      branch20m2: customersBranch20m2FromJson(json['branch20m2']),
      customerId: json['customerId'] as num?,
      dob: json['dob'] as String?,
      email: json['email'] as String?,
      lastname: json['lastname'] as String?,
      name: json['name'] as String?,
      phoneNumber: json['phoneNumber'] as String?,
      treatmentPersonalData: json['treatmentPersonalData'] as bool?,
    );

Map<String, dynamic> _$CustomersToJson(Customers instance) => <String, dynamic>{
      'accessCounter': instance.accessCounter,
      'branch20m2': customersBranch20m2ToJson(instance.branch20m2),
      'customerId': instance.customerId,
      'dob': instance.dob,
      'email': instance.email,
      'lastname': instance.lastname,
      'name': instance.name,
      'phoneNumber': instance.phoneNumber,
      'treatmentPersonalData': instance.treatmentPersonalData,
    };

Branch _$BranchFromJson(Map<String, dynamic> json) => Branch(
      address: json['address'] as String?,
      branchId: json['branchId'] as num?,
      cap: json['cap'] as String?,
      city: json['city'] as String?,
      email: json['email'] as String?,
      name: json['name'] as String?,
      phoneNumber: json['phoneNumber'] as String?,
      vatNumber: json['vatNumber'] as String?,
    );

Map<String, dynamic> _$BranchToJson(Branch instance) => <String, dynamic>{
      'address': instance.address,
      'branchId': instance.branchId,
      'cap': instance.cap,
      'city': instance.city,
      'email': instance.email,
      'name': instance.name,
      'phoneNumber': instance.phoneNumber,
      'vatNumber': instance.vatNumber,
    };

Event _$EventFromJson(Map<String, dynamic> json) => Event(
      dateCreation: json['dateCreation'] as String?,
      dateEvent: json['dateEvent'] as String?,
      eventId: json['eventId'] as num?,
      eventStatus: eventEventStatusFromJson(json['eventStatus']),
      location: json['location'] as String?,
      name: json['name'] as String?,
    );

Map<String, dynamic> _$EventToJson(Event instance) => <String, dynamic>{
      'dateCreation': instance.dateCreation,
      'dateEvent': instance.dateEvent,
      'eventId': instance.eventId,
      'eventStatus': eventEventStatusToJson(instance.eventStatus),
      'location': instance.location,
      'name': instance.name,
    };

Product _$ProductFromJson(Map<String, dynamic> json) => Product(
      category: json['category'] as String?,
      description: json['description'] as String?,
      name: json['name'] as String?,
      price: (json['price'] as num?)?.toDouble(),
      productId: json['productId'] as num?,
      supplier: json['supplier'] == null
          ? null
          : Supplier.fromJson(json['supplier'] as Map<String, dynamic>),
      unitMeasure: productUnitMeasureFromJson(json['unitMeasure']),
      vatApplied: json['vatApplied'] as int?,
    );

Map<String, dynamic> _$ProductToJson(Product instance) => <String, dynamic>{
      'category': instance.category,
      'description': instance.description,
      'name': instance.name,
      'price': instance.price,
      'productId': instance.productId,
      'supplier': instance.supplier?.toJson(),
      'unitMeasure': productUnitMeasureToJson(instance.unitMeasure),
      'vatApplied': instance.vatApplied,
    };

Supplier _$SupplierFromJson(Map<String, dynamic> json) => Supplier(
      address: json['address'] as String?,
      cap: json['cap'] as String?,
      city: json['city'] as String?,
      email: json['email'] as String?,
      name: json['name'] as String?,
      pec: json['pec'] as String?,
      phoneNumber: json['phoneNumber'] as String?,
      supplierId: json['supplierId'] as num?,
      vatNumber: json['vatNumber'] as String?,
    );

Map<String, dynamic> _$SupplierToJson(Supplier instance) => <String, dynamic>{
      'address': instance.address,
      'cap': instance.cap,
      'city': instance.city,
      'email': instance.email,
      'name': instance.name,
      'pec': instance.pec,
      'phoneNumber': instance.phoneNumber,
      'supplierId': instance.supplierId,
      'vatNumber': instance.vatNumber,
    };

EventExpence _$EventExpenceFromJson(Map<String, dynamic> json) => EventExpence(
      amount: (json['amount'] as num?)?.toDouble(),
      dateIntert: json['dateIntert'] as String?,
      description: json['description'] as String?,
      event: json['event'] == null
          ? null
          : Event.fromJson(json['event'] as Map<String, dynamic>),
      eventExpenceId: json['eventExpenceId'] as num?,
    );

Map<String, dynamic> _$EventExpenceToJson(EventExpence instance) =>
    <String, dynamic>{
      'amount': instance.amount,
      'dateIntert': instance.dateIntert,
      'description': instance.description,
      'event': instance.event?.toJson(),
      'eventExpenceId': instance.eventExpenceId,
    };

UserEntity _$UserEntityFromJson(Map<String, dynamic> json) => UserEntity(
      email: json['email'] as String?,
      lastname: json['lastname'] as String?,
      name: json['name'] as String?,
      phoneNumber: json['phoneNumber'] as String?,
      userId: json['userId'] as num?,
    );

Map<String, dynamic> _$UserEntityToJson(UserEntity instance) =>
    <String, dynamic>{
      'email': instance.email,
      'lastname': instance.lastname,
      'name': instance.name,
      'phoneNumber': instance.phoneNumber,
      'userId': instance.userId,
    };
