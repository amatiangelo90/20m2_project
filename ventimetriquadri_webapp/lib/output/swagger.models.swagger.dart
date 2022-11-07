// ignore_for_file: type=lint

import 'package:json_annotation/json_annotation.dart';
import 'package:collection/collection.dart';
import 'dart:convert';
import 'swagger.enums.swagger.dart' as enums;

part 'swagger.models.swagger.g.dart';

@JsonSerializable(explicitToJson: true)
class Storage {
  Storage({
    this.address,
    this.cap,
    this.city,
    this.creationDate,
    this.name,
    this.storageId,
  });

  factory Storage.fromJson(Map<String, dynamic> json) =>
      _$StorageFromJson(json);

  @JsonKey(name: 'address')
  final String? address;
  @JsonKey(name: 'cap')
  final int? cap;
  @JsonKey(name: 'city')
  final String? city;
  @JsonKey(name: 'creationDate')
  final String? creationDate;
  @JsonKey(name: 'name')
  final String? name;
  @JsonKey(name: 'storageId')
  final num? storageId;
  static const fromJsonFactory = _$StorageFromJson;
  static const toJsonFactory = _$StorageToJson;
  Map<String, dynamic> toJson() => _$StorageToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is Storage &&
            (identical(other.address, address) ||
                const DeepCollectionEquality()
                    .equals(other.address, address)) &&
            (identical(other.cap, cap) ||
                const DeepCollectionEquality().equals(other.cap, cap)) &&
            (identical(other.city, city) ||
                const DeepCollectionEquality().equals(other.city, city)) &&
            (identical(other.creationDate, creationDate) ||
                const DeepCollectionEquality()
                    .equals(other.creationDate, creationDate)) &&
            (identical(other.name, name) ||
                const DeepCollectionEquality().equals(other.name, name)) &&
            (identical(other.storageId, storageId) ||
                const DeepCollectionEquality()
                    .equals(other.storageId, storageId)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(address) ^
      const DeepCollectionEquality().hash(cap) ^
      const DeepCollectionEquality().hash(city) ^
      const DeepCollectionEquality().hash(creationDate) ^
      const DeepCollectionEquality().hash(name) ^
      const DeepCollectionEquality().hash(storageId) ^
      runtimeType.hashCode;
}

extension $StorageExtension on Storage {
  Storage copyWith(
      {String? address,
      int? cap,
      String? city,
      String? creationDate,
      String? name,
      num? storageId}) {
    return Storage(
        address: address ?? this.address,
        cap: cap ?? this.cap,
        city: city ?? this.city,
        creationDate: creationDate ?? this.creationDate,
        name: name ?? this.name,
        storageId: storageId ?? this.storageId);
  }

  Storage copyWithWrapped(
      {Wrapped<String?>? address,
      Wrapped<int?>? cap,
      Wrapped<String?>? city,
      Wrapped<String?>? creationDate,
      Wrapped<String?>? name,
      Wrapped<num?>? storageId}) {
    return Storage(
        address: (address != null ? address.value : this.address),
        cap: (cap != null ? cap.value : this.cap),
        city: (city != null ? city.value : this.city),
        creationDate:
            (creationDate != null ? creationDate.value : this.creationDate),
        name: (name != null ? name.value : this.name),
        storageId: (storageId != null ? storageId.value : this.storageId));
  }
}

@JsonSerializable(explicitToJson: true)
class Customers {
  Customers({
    this.accessCounter,
    this.branch20m2,
    this.customerId,
    this.dob,
    this.email,
    this.lastname,
    this.name,
    this.phoneNumber,
    this.treatmentPersonalData,
  });

  factory Customers.fromJson(Map<String, dynamic> json) =>
      _$CustomersFromJson(json);

  @JsonKey(name: 'accessCounter')
  final int? accessCounter;
  @JsonKey(
    name: 'branch20m2',
    toJson: customersBranch20m2ToJson,
    fromJson: customersBranch20m2FromJson,
  )
  final enums.CustomersBranch20m2? branch20m2;
  @JsonKey(name: 'customerId')
  final num? customerId;
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
  static const fromJsonFactory = _$CustomersFromJson;
  static const toJsonFactory = _$CustomersToJson;
  Map<String, dynamic> toJson() => _$CustomersToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is Customers &&
            (identical(other.accessCounter, accessCounter) ||
                const DeepCollectionEquality()
                    .equals(other.accessCounter, accessCounter)) &&
            (identical(other.branch20m2, branch20m2) ||
                const DeepCollectionEquality()
                    .equals(other.branch20m2, branch20m2)) &&
            (identical(other.customerId, customerId) ||
                const DeepCollectionEquality()
                    .equals(other.customerId, customerId)) &&
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
                    other.treatmentPersonalData, treatmentPersonalData)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(accessCounter) ^
      const DeepCollectionEquality().hash(branch20m2) ^
      const DeepCollectionEquality().hash(customerId) ^
      const DeepCollectionEquality().hash(dob) ^
      const DeepCollectionEquality().hash(email) ^
      const DeepCollectionEquality().hash(lastname) ^
      const DeepCollectionEquality().hash(name) ^
      const DeepCollectionEquality().hash(phoneNumber) ^
      const DeepCollectionEquality().hash(treatmentPersonalData) ^
      runtimeType.hashCode;
}

extension $CustomersExtension on Customers {
  Customers copyWith(
      {int? accessCounter,
      enums.CustomersBranch20m2? branch20m2,
      num? customerId,
      String? dob,
      String? email,
      String? lastname,
      String? name,
      String? phoneNumber,
      bool? treatmentPersonalData}) {
    return Customers(
        accessCounter: accessCounter ?? this.accessCounter,
        branch20m2: branch20m2 ?? this.branch20m2,
        customerId: customerId ?? this.customerId,
        dob: dob ?? this.dob,
        email: email ?? this.email,
        lastname: lastname ?? this.lastname,
        name: name ?? this.name,
        phoneNumber: phoneNumber ?? this.phoneNumber,
        treatmentPersonalData:
            treatmentPersonalData ?? this.treatmentPersonalData);
  }

  Customers copyWithWrapped(
      {Wrapped<int?>? accessCounter,
      Wrapped<enums.CustomersBranch20m2?>? branch20m2,
      Wrapped<num?>? customerId,
      Wrapped<String?>? dob,
      Wrapped<String?>? email,
      Wrapped<String?>? lastname,
      Wrapped<String?>? name,
      Wrapped<String?>? phoneNumber,
      Wrapped<bool?>? treatmentPersonalData}) {
    return Customers(
        accessCounter:
            (accessCounter != null ? accessCounter.value : this.accessCounter),
        branch20m2: (branch20m2 != null ? branch20m2.value : this.branch20m2),
        customerId: (customerId != null ? customerId.value : this.customerId),
        dob: (dob != null ? dob.value : this.dob),
        email: (email != null ? email.value : this.email),
        lastname: (lastname != null ? lastname.value : this.lastname),
        name: (name != null ? name.value : this.name),
        phoneNumber:
            (phoneNumber != null ? phoneNumber.value : this.phoneNumber),
        treatmentPersonalData: (treatmentPersonalData != null
            ? treatmentPersonalData.value
            : this.treatmentPersonalData));
  }
}

@JsonSerializable(explicitToJson: true)
class Branch {
  Branch({
    this.address,
    this.branchId,
    this.cap,
    this.city,
    this.email,
    this.name,
    this.phoneNumber,
    this.vatNumber,
  });

  factory Branch.fromJson(Map<String, dynamic> json) => _$BranchFromJson(json);

  @JsonKey(name: 'address')
  final String? address;
  @JsonKey(name: 'branchId')
  final num? branchId;
  @JsonKey(name: 'cap')
  final String? cap;
  @JsonKey(name: 'city')
  final String? city;
  @JsonKey(name: 'email')
  final String? email;
  @JsonKey(name: 'name')
  final String? name;
  @JsonKey(name: 'phoneNumber')
  final String? phoneNumber;
  @JsonKey(name: 'vatNumber')
  final String? vatNumber;
  static const fromJsonFactory = _$BranchFromJson;
  static const toJsonFactory = _$BranchToJson;
  Map<String, dynamic> toJson() => _$BranchToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is Branch &&
            (identical(other.address, address) ||
                const DeepCollectionEquality()
                    .equals(other.address, address)) &&
            (identical(other.branchId, branchId) ||
                const DeepCollectionEquality()
                    .equals(other.branchId, branchId)) &&
            (identical(other.cap, cap) ||
                const DeepCollectionEquality().equals(other.cap, cap)) &&
            (identical(other.city, city) ||
                const DeepCollectionEquality().equals(other.city, city)) &&
            (identical(other.email, email) ||
                const DeepCollectionEquality().equals(other.email, email)) &&
            (identical(other.name, name) ||
                const DeepCollectionEquality().equals(other.name, name)) &&
            (identical(other.phoneNumber, phoneNumber) ||
                const DeepCollectionEquality()
                    .equals(other.phoneNumber, phoneNumber)) &&
            (identical(other.vatNumber, vatNumber) ||
                const DeepCollectionEquality()
                    .equals(other.vatNumber, vatNumber)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(address) ^
      const DeepCollectionEquality().hash(branchId) ^
      const DeepCollectionEquality().hash(cap) ^
      const DeepCollectionEquality().hash(city) ^
      const DeepCollectionEquality().hash(email) ^
      const DeepCollectionEquality().hash(name) ^
      const DeepCollectionEquality().hash(phoneNumber) ^
      const DeepCollectionEquality().hash(vatNumber) ^
      runtimeType.hashCode;
}

extension $BranchExtension on Branch {
  Branch copyWith(
      {String? address,
      num? branchId,
      String? cap,
      String? city,
      String? email,
      String? name,
      String? phoneNumber,
      String? vatNumber}) {
    return Branch(
        address: address ?? this.address,
        branchId: branchId ?? this.branchId,
        cap: cap ?? this.cap,
        city: city ?? this.city,
        email: email ?? this.email,
        name: name ?? this.name,
        phoneNumber: phoneNumber ?? this.phoneNumber,
        vatNumber: vatNumber ?? this.vatNumber);
  }

  Branch copyWithWrapped(
      {Wrapped<String?>? address,
      Wrapped<num?>? branchId,
      Wrapped<String?>? cap,
      Wrapped<String?>? city,
      Wrapped<String?>? email,
      Wrapped<String?>? name,
      Wrapped<String?>? phoneNumber,
      Wrapped<String?>? vatNumber}) {
    return Branch(
        address: (address != null ? address.value : this.address),
        branchId: (branchId != null ? branchId.value : this.branchId),
        cap: (cap != null ? cap.value : this.cap),
        city: (city != null ? city.value : this.city),
        email: (email != null ? email.value : this.email),
        name: (name != null ? name.value : this.name),
        phoneNumber:
            (phoneNumber != null ? phoneNumber.value : this.phoneNumber),
        vatNumber: (vatNumber != null ? vatNumber.value : this.vatNumber));
  }
}

@JsonSerializable(explicitToJson: true)
class Event {
  Event({
    this.dateCreation,
    this.dateEvent,
    this.eventId,
    this.eventStatus,
    this.location,
    this.name,
  });

  factory Event.fromJson(Map<String, dynamic> json) => _$EventFromJson(json);

  @JsonKey(name: 'dateCreation')
  final String? dateCreation;
  @JsonKey(name: 'dateEvent')
  final String? dateEvent;
  @JsonKey(name: 'eventId')
  final num? eventId;
  @JsonKey(
    name: 'eventStatus',
    toJson: eventEventStatusToJson,
    fromJson: eventEventStatusFromJson,
  )
  final enums.EventEventStatus? eventStatus;
  @JsonKey(name: 'location')
  final String? location;
  @JsonKey(name: 'name')
  final String? name;
  static const fromJsonFactory = _$EventFromJson;
  static const toJsonFactory = _$EventToJson;
  Map<String, dynamic> toJson() => _$EventToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is Event &&
            (identical(other.dateCreation, dateCreation) ||
                const DeepCollectionEquality()
                    .equals(other.dateCreation, dateCreation)) &&
            (identical(other.dateEvent, dateEvent) ||
                const DeepCollectionEquality()
                    .equals(other.dateEvent, dateEvent)) &&
            (identical(other.eventId, eventId) ||
                const DeepCollectionEquality()
                    .equals(other.eventId, eventId)) &&
            (identical(other.eventStatus, eventStatus) ||
                const DeepCollectionEquality()
                    .equals(other.eventStatus, eventStatus)) &&
            (identical(other.location, location) ||
                const DeepCollectionEquality()
                    .equals(other.location, location)) &&
            (identical(other.name, name) ||
                const DeepCollectionEquality().equals(other.name, name)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(dateCreation) ^
      const DeepCollectionEquality().hash(dateEvent) ^
      const DeepCollectionEquality().hash(eventId) ^
      const DeepCollectionEquality().hash(eventStatus) ^
      const DeepCollectionEquality().hash(location) ^
      const DeepCollectionEquality().hash(name) ^
      runtimeType.hashCode;
}

extension $EventExtension on Event {
  Event copyWith(
      {String? dateCreation,
      String? dateEvent,
      num? eventId,
      enums.EventEventStatus? eventStatus,
      String? location,
      String? name}) {
    return Event(
        dateCreation: dateCreation ?? this.dateCreation,
        dateEvent: dateEvent ?? this.dateEvent,
        eventId: eventId ?? this.eventId,
        eventStatus: eventStatus ?? this.eventStatus,
        location: location ?? this.location,
        name: name ?? this.name);
  }

  Event copyWithWrapped(
      {Wrapped<String?>? dateCreation,
      Wrapped<String?>? dateEvent,
      Wrapped<num?>? eventId,
      Wrapped<enums.EventEventStatus?>? eventStatus,
      Wrapped<String?>? location,
      Wrapped<String?>? name}) {
    return Event(
        dateCreation:
            (dateCreation != null ? dateCreation.value : this.dateCreation),
        dateEvent: (dateEvent != null ? dateEvent.value : this.dateEvent),
        eventId: (eventId != null ? eventId.value : this.eventId),
        eventStatus:
            (eventStatus != null ? eventStatus.value : this.eventStatus),
        location: (location != null ? location.value : this.location),
        name: (name != null ? name.value : this.name));
  }
}

@JsonSerializable(explicitToJson: true)
class Product {
  Product({
    this.category,
    this.description,
    this.name,
    this.price,
    this.productId,
    this.supplier,
    this.unitMeasure,
    this.vatApplied,
  });

  factory Product.fromJson(Map<String, dynamic> json) =>
      _$ProductFromJson(json);

  @JsonKey(name: 'category')
  final String? category;
  @JsonKey(name: 'description')
  final String? description;
  @JsonKey(name: 'name')
  final String? name;
  @JsonKey(name: 'price')
  final double? price;
  @JsonKey(name: 'productId')
  final num? productId;
  @JsonKey(name: 'supplier')
  final Supplier? supplier;
  @JsonKey(
    name: 'unitMeasure',
    toJson: productUnitMeasureToJson,
    fromJson: productUnitMeasureFromJson,
  )
  final enums.ProductUnitMeasure? unitMeasure;
  @JsonKey(name: 'vatApplied')
  final int? vatApplied;
  static const fromJsonFactory = _$ProductFromJson;
  static const toJsonFactory = _$ProductToJson;
  Map<String, dynamic> toJson() => _$ProductToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is Product &&
            (identical(other.category, category) ||
                const DeepCollectionEquality()
                    .equals(other.category, category)) &&
            (identical(other.description, description) ||
                const DeepCollectionEquality()
                    .equals(other.description, description)) &&
            (identical(other.name, name) ||
                const DeepCollectionEquality().equals(other.name, name)) &&
            (identical(other.price, price) ||
                const DeepCollectionEquality().equals(other.price, price)) &&
            (identical(other.productId, productId) ||
                const DeepCollectionEquality()
                    .equals(other.productId, productId)) &&
            (identical(other.supplier, supplier) ||
                const DeepCollectionEquality()
                    .equals(other.supplier, supplier)) &&
            (identical(other.unitMeasure, unitMeasure) ||
                const DeepCollectionEquality()
                    .equals(other.unitMeasure, unitMeasure)) &&
            (identical(other.vatApplied, vatApplied) ||
                const DeepCollectionEquality()
                    .equals(other.vatApplied, vatApplied)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(category) ^
      const DeepCollectionEquality().hash(description) ^
      const DeepCollectionEquality().hash(name) ^
      const DeepCollectionEquality().hash(price) ^
      const DeepCollectionEquality().hash(productId) ^
      const DeepCollectionEquality().hash(supplier) ^
      const DeepCollectionEquality().hash(unitMeasure) ^
      const DeepCollectionEquality().hash(vatApplied) ^
      runtimeType.hashCode;
}

extension $ProductExtension on Product {
  Product copyWith(
      {String? category,
      String? description,
      String? name,
      double? price,
      num? productId,
      Supplier? supplier,
      enums.ProductUnitMeasure? unitMeasure,
      int? vatApplied}) {
    return Product(
        category: category ?? this.category,
        description: description ?? this.description,
        name: name ?? this.name,
        price: price ?? this.price,
        productId: productId ?? this.productId,
        supplier: supplier ?? this.supplier,
        unitMeasure: unitMeasure ?? this.unitMeasure,
        vatApplied: vatApplied ?? this.vatApplied);
  }

  Product copyWithWrapped(
      {Wrapped<String?>? category,
      Wrapped<String?>? description,
      Wrapped<String?>? name,
      Wrapped<double?>? price,
      Wrapped<num?>? productId,
      Wrapped<Supplier?>? supplier,
      Wrapped<enums.ProductUnitMeasure?>? unitMeasure,
      Wrapped<int?>? vatApplied}) {
    return Product(
        category: (category != null ? category.value : this.category),
        description:
            (description != null ? description.value : this.description),
        name: (name != null ? name.value : this.name),
        price: (price != null ? price.value : this.price),
        productId: (productId != null ? productId.value : this.productId),
        supplier: (supplier != null ? supplier.value : this.supplier),
        unitMeasure:
            (unitMeasure != null ? unitMeasure.value : this.unitMeasure),
        vatApplied: (vatApplied != null ? vatApplied.value : this.vatApplied));
  }
}

@JsonSerializable(explicitToJson: true)
class Supplier {
  Supplier({
    this.address,
    this.cap,
    this.city,
    this.email,
    this.name,
    this.pec,
    this.phoneNumber,
    this.supplierId,
    this.vatNumber,
  });

  factory Supplier.fromJson(Map<String, dynamic> json) =>
      _$SupplierFromJson(json);

  @JsonKey(name: 'address')
  final String? address;
  @JsonKey(name: 'cap')
  final String? cap;
  @JsonKey(name: 'city')
  final String? city;
  @JsonKey(name: 'email')
  final String? email;
  @JsonKey(name: 'name')
  final String? name;
  @JsonKey(name: 'pec')
  final String? pec;
  @JsonKey(name: 'phoneNumber')
  final String? phoneNumber;
  @JsonKey(name: 'supplierId')
  final num? supplierId;
  @JsonKey(name: 'vatNumber')
  final String? vatNumber;
  static const fromJsonFactory = _$SupplierFromJson;
  static const toJsonFactory = _$SupplierToJson;
  Map<String, dynamic> toJson() => _$SupplierToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is Supplier &&
            (identical(other.address, address) ||
                const DeepCollectionEquality()
                    .equals(other.address, address)) &&
            (identical(other.cap, cap) ||
                const DeepCollectionEquality().equals(other.cap, cap)) &&
            (identical(other.city, city) ||
                const DeepCollectionEquality().equals(other.city, city)) &&
            (identical(other.email, email) ||
                const DeepCollectionEquality().equals(other.email, email)) &&
            (identical(other.name, name) ||
                const DeepCollectionEquality().equals(other.name, name)) &&
            (identical(other.pec, pec) ||
                const DeepCollectionEquality().equals(other.pec, pec)) &&
            (identical(other.phoneNumber, phoneNumber) ||
                const DeepCollectionEquality()
                    .equals(other.phoneNumber, phoneNumber)) &&
            (identical(other.supplierId, supplierId) ||
                const DeepCollectionEquality()
                    .equals(other.supplierId, supplierId)) &&
            (identical(other.vatNumber, vatNumber) ||
                const DeepCollectionEquality()
                    .equals(other.vatNumber, vatNumber)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(address) ^
      const DeepCollectionEquality().hash(cap) ^
      const DeepCollectionEquality().hash(city) ^
      const DeepCollectionEquality().hash(email) ^
      const DeepCollectionEquality().hash(name) ^
      const DeepCollectionEquality().hash(pec) ^
      const DeepCollectionEquality().hash(phoneNumber) ^
      const DeepCollectionEquality().hash(supplierId) ^
      const DeepCollectionEquality().hash(vatNumber) ^
      runtimeType.hashCode;
}

extension $SupplierExtension on Supplier {
  Supplier copyWith(
      {String? address,
      String? cap,
      String? city,
      String? email,
      String? name,
      String? pec,
      String? phoneNumber,
      num? supplierId,
      String? vatNumber}) {
    return Supplier(
        address: address ?? this.address,
        cap: cap ?? this.cap,
        city: city ?? this.city,
        email: email ?? this.email,
        name: name ?? this.name,
        pec: pec ?? this.pec,
        phoneNumber: phoneNumber ?? this.phoneNumber,
        supplierId: supplierId ?? this.supplierId,
        vatNumber: vatNumber ?? this.vatNumber);
  }

  Supplier copyWithWrapped(
      {Wrapped<String?>? address,
      Wrapped<String?>? cap,
      Wrapped<String?>? city,
      Wrapped<String?>? email,
      Wrapped<String?>? name,
      Wrapped<String?>? pec,
      Wrapped<String?>? phoneNumber,
      Wrapped<num?>? supplierId,
      Wrapped<String?>? vatNumber}) {
    return Supplier(
        address: (address != null ? address.value : this.address),
        cap: (cap != null ? cap.value : this.cap),
        city: (city != null ? city.value : this.city),
        email: (email != null ? email.value : this.email),
        name: (name != null ? name.value : this.name),
        pec: (pec != null ? pec.value : this.pec),
        phoneNumber:
            (phoneNumber != null ? phoneNumber.value : this.phoneNumber),
        supplierId: (supplierId != null ? supplierId.value : this.supplierId),
        vatNumber: (vatNumber != null ? vatNumber.value : this.vatNumber));
  }
}

@JsonSerializable(explicitToJson: true)
class EventExpence {
  EventExpence({
    this.amount,
    this.dateIntert,
    this.description,
    this.event,
    this.eventExpenceId,
  });

  factory EventExpence.fromJson(Map<String, dynamic> json) =>
      _$EventExpenceFromJson(json);

  @JsonKey(name: 'amount')
  final double? amount;
  @JsonKey(name: 'dateIntert')
  final String? dateIntert;
  @JsonKey(name: 'description')
  final String? description;
  @JsonKey(name: 'event')
  final Event? event;
  @JsonKey(name: 'eventExpenceId')
  final num? eventExpenceId;
  static const fromJsonFactory = _$EventExpenceFromJson;
  static const toJsonFactory = _$EventExpenceToJson;
  Map<String, dynamic> toJson() => _$EventExpenceToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is EventExpence &&
            (identical(other.amount, amount) ||
                const DeepCollectionEquality().equals(other.amount, amount)) &&
            (identical(other.dateIntert, dateIntert) ||
                const DeepCollectionEquality()
                    .equals(other.dateIntert, dateIntert)) &&
            (identical(other.description, description) ||
                const DeepCollectionEquality()
                    .equals(other.description, description)) &&
            (identical(other.event, event) ||
                const DeepCollectionEquality().equals(other.event, event)) &&
            (identical(other.eventExpenceId, eventExpenceId) ||
                const DeepCollectionEquality()
                    .equals(other.eventExpenceId, eventExpenceId)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(amount) ^
      const DeepCollectionEquality().hash(dateIntert) ^
      const DeepCollectionEquality().hash(description) ^
      const DeepCollectionEquality().hash(event) ^
      const DeepCollectionEquality().hash(eventExpenceId) ^
      runtimeType.hashCode;
}

extension $EventExpenceExtension on EventExpence {
  EventExpence copyWith(
      {double? amount,
      String? dateIntert,
      String? description,
      Event? event,
      num? eventExpenceId}) {
    return EventExpence(
        amount: amount ?? this.amount,
        dateIntert: dateIntert ?? this.dateIntert,
        description: description ?? this.description,
        event: event ?? this.event,
        eventExpenceId: eventExpenceId ?? this.eventExpenceId);
  }

  EventExpence copyWithWrapped(
      {Wrapped<double?>? amount,
      Wrapped<String?>? dateIntert,
      Wrapped<String?>? description,
      Wrapped<Event?>? event,
      Wrapped<num?>? eventExpenceId}) {
    return EventExpence(
        amount: (amount != null ? amount.value : this.amount),
        dateIntert: (dateIntert != null ? dateIntert.value : this.dateIntert),
        description:
            (description != null ? description.value : this.description),
        event: (event != null ? event.value : this.event),
        eventExpenceId: (eventExpenceId != null
            ? eventExpenceId.value
            : this.eventExpenceId));
  }
}

@JsonSerializable(explicitToJson: true)
class UserEntity {
  UserEntity({
    this.email,
    this.lastname,
    this.name,
    this.phoneNumber,
    this.userId,
  });

  factory UserEntity.fromJson(Map<String, dynamic> json) =>
      _$UserEntityFromJson(json);

  @JsonKey(name: 'email')
  final String? email;
  @JsonKey(name: 'lastname')
  final String? lastname;
  @JsonKey(name: 'name')
  final String? name;
  @JsonKey(name: 'phoneNumber')
  final String? phoneNumber;
  @JsonKey(name: 'userId')
  final num? userId;
  static const fromJsonFactory = _$UserEntityFromJson;
  static const toJsonFactory = _$UserEntityToJson;
  Map<String, dynamic> toJson() => _$UserEntityToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is UserEntity &&
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
            (identical(other.userId, userId) ||
                const DeepCollectionEquality().equals(other.userId, userId)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(email) ^
      const DeepCollectionEquality().hash(lastname) ^
      const DeepCollectionEquality().hash(name) ^
      const DeepCollectionEquality().hash(phoneNumber) ^
      const DeepCollectionEquality().hash(userId) ^
      runtimeType.hashCode;
}

extension $UserEntityExtension on UserEntity {
  UserEntity copyWith(
      {String? email,
      String? lastname,
      String? name,
      String? phoneNumber,
      num? userId}) {
    return UserEntity(
        email: email ?? this.email,
        lastname: lastname ?? this.lastname,
        name: name ?? this.name,
        phoneNumber: phoneNumber ?? this.phoneNumber,
        userId: userId ?? this.userId);
  }

  UserEntity copyWithWrapped(
      {Wrapped<String?>? email,
      Wrapped<String?>? lastname,
      Wrapped<String?>? name,
      Wrapped<String?>? phoneNumber,
      Wrapped<num?>? userId}) {
    return UserEntity(
        email: (email != null ? email.value : this.email),
        lastname: (lastname != null ? lastname.value : this.lastname),
        name: (name != null ? name.value : this.name),
        phoneNumber:
            (phoneNumber != null ? phoneNumber.value : this.phoneNumber),
        userId: (userId != null ? userId.value : this.userId));
  }
}

String? customersBranch20m2ToJson(
    enums.CustomersBranch20m2? customersBranch20m2) {
  return enums.$CustomersBranch20m2Map[customersBranch20m2];
}

enums.CustomersBranch20m2 customersBranch20m2FromJson(
  Object? customersBranch20m2, [
  enums.CustomersBranch20m2? defaultValue,
]) {
  if (customersBranch20m2 is String) {
    return enums.$CustomersBranch20m2Map.entries
        .firstWhere(
            (element) =>
                element.value.toLowerCase() ==
                customersBranch20m2.toLowerCase(),
            orElse: () => const MapEntry(
                enums.CustomersBranch20m2.swaggerGeneratedUnknown, ''))
        .key;
  }

  final parsedResult = defaultValue == null
      ? null
      : enums.$CustomersBranch20m2Map.entries
          .firstWhereOrNull((element) => element.value == defaultValue)
          ?.key;

  return parsedResult ??
      defaultValue ??
      enums.CustomersBranch20m2.swaggerGeneratedUnknown;
}

List<String> customersBranch20m2ListToJson(
    List<enums.CustomersBranch20m2>? customersBranch20m2) {
  if (customersBranch20m2 == null) {
    return [];
  }

  return customersBranch20m2
      .map((e) => enums.$CustomersBranch20m2Map[e]!)
      .toList();
}

List<enums.CustomersBranch20m2> customersBranch20m2ListFromJson(
  List? customersBranch20m2, [
  List<enums.CustomersBranch20m2>? defaultValue,
]) {
  if (customersBranch20m2 == null) {
    return defaultValue ?? [];
  }

  return customersBranch20m2
      .map((e) => customersBranch20m2FromJson(e.toString()))
      .toList();
}

List<enums.CustomersBranch20m2>? customersBranch20m2NullableListFromJson(
  List? customersBranch20m2, [
  List<enums.CustomersBranch20m2>? defaultValue,
]) {
  if (customersBranch20m2 == null) {
    return defaultValue;
  }

  return customersBranch20m2
      .map((e) => customersBranch20m2FromJson(e.toString()))
      .toList();
}

String? eventEventStatusToJson(enums.EventEventStatus? eventEventStatus) {
  return enums.$EventEventStatusMap[eventEventStatus];
}

enums.EventEventStatus eventEventStatusFromJson(
  Object? eventEventStatus, [
  enums.EventEventStatus? defaultValue,
]) {
  if (eventEventStatus is String) {
    return enums.$EventEventStatusMap.entries
        .firstWhere(
            (element) =>
                element.value.toLowerCase() == eventEventStatus.toLowerCase(),
            orElse: () => const MapEntry(
                enums.EventEventStatus.swaggerGeneratedUnknown, ''))
        .key;
  }

  final parsedResult = defaultValue == null
      ? null
      : enums.$EventEventStatusMap.entries
          .firstWhereOrNull((element) => element.value == defaultValue)
          ?.key;

  return parsedResult ??
      defaultValue ??
      enums.EventEventStatus.swaggerGeneratedUnknown;
}

List<String> eventEventStatusListToJson(
    List<enums.EventEventStatus>? eventEventStatus) {
  if (eventEventStatus == null) {
    return [];
  }

  return eventEventStatus.map((e) => enums.$EventEventStatusMap[e]!).toList();
}

List<enums.EventEventStatus> eventEventStatusListFromJson(
  List? eventEventStatus, [
  List<enums.EventEventStatus>? defaultValue,
]) {
  if (eventEventStatus == null) {
    return defaultValue ?? [];
  }

  return eventEventStatus
      .map((e) => eventEventStatusFromJson(e.toString()))
      .toList();
}

List<enums.EventEventStatus>? eventEventStatusNullableListFromJson(
  List? eventEventStatus, [
  List<enums.EventEventStatus>? defaultValue,
]) {
  if (eventEventStatus == null) {
    return defaultValue;
  }

  return eventEventStatus
      .map((e) => eventEventStatusFromJson(e.toString()))
      .toList();
}

String? productUnitMeasureToJson(enums.ProductUnitMeasure? productUnitMeasure) {
  return enums.$ProductUnitMeasureMap[productUnitMeasure];
}

enums.ProductUnitMeasure productUnitMeasureFromJson(
  Object? productUnitMeasure, [
  enums.ProductUnitMeasure? defaultValue,
]) {
  if (productUnitMeasure is String) {
    return enums.$ProductUnitMeasureMap.entries
        .firstWhere(
            (element) =>
                element.value.toLowerCase() == productUnitMeasure.toLowerCase(),
            orElse: () => const MapEntry(
                enums.ProductUnitMeasure.swaggerGeneratedUnknown, ''))
        .key;
  }

  final parsedResult = defaultValue == null
      ? null
      : enums.$ProductUnitMeasureMap.entries
          .firstWhereOrNull((element) => element.value == defaultValue)
          ?.key;

  return parsedResult ??
      defaultValue ??
      enums.ProductUnitMeasure.swaggerGeneratedUnknown;
}

List<String> productUnitMeasureListToJson(
    List<enums.ProductUnitMeasure>? productUnitMeasure) {
  if (productUnitMeasure == null) {
    return [];
  }

  return productUnitMeasure
      .map((e) => enums.$ProductUnitMeasureMap[e]!)
      .toList();
}

List<enums.ProductUnitMeasure> productUnitMeasureListFromJson(
  List? productUnitMeasure, [
  List<enums.ProductUnitMeasure>? defaultValue,
]) {
  if (productUnitMeasure == null) {
    return defaultValue ?? [];
  }

  return productUnitMeasure
      .map((e) => productUnitMeasureFromJson(e.toString()))
      .toList();
}

List<enums.ProductUnitMeasure>? productUnitMeasureNullableListFromJson(
  List? productUnitMeasure, [
  List<enums.ProductUnitMeasure>? defaultValue,
]) {
  if (productUnitMeasure == null) {
    return defaultValue;
  }

  return productUnitMeasure
      .map((e) => productUnitMeasureFromJson(e.toString()))
      .toList();
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
