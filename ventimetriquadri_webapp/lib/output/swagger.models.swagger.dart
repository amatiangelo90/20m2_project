// ignore_for_file: type=lint

import 'package:json_annotation/json_annotation.dart';
import 'package:collection/collection.dart';
import 'dart:convert';
import 'swagger.enums.swagger.dart' as enums;

part 'swagger.models.swagger.g.dart';

@JsonSerializable(explicitToJson: true)
class ROrderProduct {
  ROrderProduct({
    this.amount,
    this.orderProductId,
    this.price,
    this.productId,
    this.productName,
    this.unitMeasure,
  });

  factory ROrderProduct.fromJson(Map<String, dynamic> json) =>
      _$ROrderProductFromJson(json);

  @JsonKey(name: 'amount')
  final double? amount;
  @JsonKey(name: 'orderProductId')
  final num? orderProductId;
  @JsonKey(name: 'price')
  final double? price;
  @JsonKey(name: 'productId')
  final num? productId;
  @JsonKey(name: 'productName')
  final String? productName;
  @JsonKey(
    name: 'unitMeasure',
    toJson: rOrderProductUnitMeasureToJson,
    fromJson: rOrderProductUnitMeasureFromJson,
  )
  final enums.ROrderProductUnitMeasure? unitMeasure;
  static const fromJsonFactory = _$ROrderProductFromJson;
  static const toJsonFactory = _$ROrderProductToJson;
  Map<String, dynamic> toJson() => _$ROrderProductToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is ROrderProduct &&
            (identical(other.amount, amount) ||
                const DeepCollectionEquality().equals(other.amount, amount)) &&
            (identical(other.orderProductId, orderProductId) ||
                const DeepCollectionEquality()
                    .equals(other.orderProductId, orderProductId)) &&
            (identical(other.price, price) ||
                const DeepCollectionEquality().equals(other.price, price)) &&
            (identical(other.productId, productId) ||
                const DeepCollectionEquality()
                    .equals(other.productId, productId)) &&
            (identical(other.productName, productName) ||
                const DeepCollectionEquality()
                    .equals(other.productName, productName)) &&
            (identical(other.unitMeasure, unitMeasure) ||
                const DeepCollectionEquality()
                    .equals(other.unitMeasure, unitMeasure)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(amount) ^
      const DeepCollectionEquality().hash(orderProductId) ^
      const DeepCollectionEquality().hash(price) ^
      const DeepCollectionEquality().hash(productId) ^
      const DeepCollectionEquality().hash(productName) ^
      const DeepCollectionEquality().hash(unitMeasure) ^
      runtimeType.hashCode;
}

extension $ROrderProductExtension on ROrderProduct {
  ROrderProduct copyWith(
      {double? amount,
      num? orderProductId,
      double? price,
      num? productId,
      String? productName,
      enums.ROrderProductUnitMeasure? unitMeasure}) {
    return ROrderProduct(
        amount: amount ?? this.amount,
        orderProductId: orderProductId ?? this.orderProductId,
        price: price ?? this.price,
        productId: productId ?? this.productId,
        productName: productName ?? this.productName,
        unitMeasure: unitMeasure ?? this.unitMeasure);
  }

  ROrderProduct copyWithWrapped(
      {Wrapped<double?>? amount,
      Wrapped<num?>? orderProductId,
      Wrapped<double?>? price,
      Wrapped<num?>? productId,
      Wrapped<String?>? productName,
      Wrapped<enums.ROrderProductUnitMeasure?>? unitMeasure}) {
    return ROrderProduct(
        amount: (amount != null ? amount.value : this.amount),
        orderProductId: (orderProductId != null
            ? orderProductId.value
            : this.orderProductId),
        price: (price != null ? price.value : this.price),
        productId: (productId != null ? productId.value : this.productId),
        productName:
            (productName != null ? productName.value : this.productName),
        unitMeasure:
            (unitMeasure != null ? unitMeasure.value : this.unitMeasure));
  }
}

@JsonSerializable(explicitToJson: true)
class RWorkstationProduct {
  RWorkstationProduct({
    this.amountHundred,
    this.consumed,
    this.productId,
    this.productName,
    this.stockFromStorage,
    this.storageId,
    this.unitMeasure,
    this.workstationProductId,
  });

  factory RWorkstationProduct.fromJson(Map<String, dynamic> json) =>
      _$RWorkstationProductFromJson(json);

  @JsonKey(name: 'amountHundred')
  final double? amountHundred;
  @JsonKey(name: 'consumed')
  final double? consumed;
  @JsonKey(name: 'productId')
  final num? productId;
  @JsonKey(name: 'productName')
  final String? productName;
  @JsonKey(name: 'stockFromStorage')
  final double? stockFromStorage;
  @JsonKey(name: 'storageId')
  final num? storageId;
  @JsonKey(
    name: 'unitMeasure',
    toJson: rWorkstationProductUnitMeasureToJson,
    fromJson: rWorkstationProductUnitMeasureFromJson,
  )
  final enums.RWorkstationProductUnitMeasure? unitMeasure;
  @JsonKey(name: 'workstationProductId')
  final num? workstationProductId;
  static const fromJsonFactory = _$RWorkstationProductFromJson;
  static const toJsonFactory = _$RWorkstationProductToJson;
  Map<String, dynamic> toJson() => _$RWorkstationProductToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is RWorkstationProduct &&
            (identical(other.amountHundred, amountHundred) ||
                const DeepCollectionEquality()
                    .equals(other.amountHundred, amountHundred)) &&
            (identical(other.consumed, consumed) ||
                const DeepCollectionEquality()
                    .equals(other.consumed, consumed)) &&
            (identical(other.productId, productId) ||
                const DeepCollectionEquality()
                    .equals(other.productId, productId)) &&
            (identical(other.productName, productName) ||
                const DeepCollectionEquality()
                    .equals(other.productName, productName)) &&
            (identical(other.stockFromStorage, stockFromStorage) ||
                const DeepCollectionEquality()
                    .equals(other.stockFromStorage, stockFromStorage)) &&
            (identical(other.storageId, storageId) ||
                const DeepCollectionEquality()
                    .equals(other.storageId, storageId)) &&
            (identical(other.unitMeasure, unitMeasure) ||
                const DeepCollectionEquality()
                    .equals(other.unitMeasure, unitMeasure)) &&
            (identical(other.workstationProductId, workstationProductId) ||
                const DeepCollectionEquality()
                    .equals(other.workstationProductId, workstationProductId)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(amountHundred) ^
      const DeepCollectionEquality().hash(consumed) ^
      const DeepCollectionEquality().hash(productId) ^
      const DeepCollectionEquality().hash(productName) ^
      const DeepCollectionEquality().hash(stockFromStorage) ^
      const DeepCollectionEquality().hash(storageId) ^
      const DeepCollectionEquality().hash(unitMeasure) ^
      const DeepCollectionEquality().hash(workstationProductId) ^
      runtimeType.hashCode;
}

extension $RWorkstationProductExtension on RWorkstationProduct {
  RWorkstationProduct copyWith(
      {double? amountHundred,
      double? consumed,
      num? productId,
      String? productName,
      double? stockFromStorage,
      num? storageId,
      enums.RWorkstationProductUnitMeasure? unitMeasure,
      num? workstationProductId}) {
    return RWorkstationProduct(
        amountHundred: amountHundred ?? this.amountHundred,
        consumed: consumed ?? this.consumed,
        productId: productId ?? this.productId,
        productName: productName ?? this.productName,
        stockFromStorage: stockFromStorage ?? this.stockFromStorage,
        storageId: storageId ?? this.storageId,
        unitMeasure: unitMeasure ?? this.unitMeasure,
        workstationProductId:
            workstationProductId ?? this.workstationProductId);
  }

  RWorkstationProduct copyWithWrapped(
      {Wrapped<double?>? amountHundred,
      Wrapped<double?>? consumed,
      Wrapped<num?>? productId,
      Wrapped<String?>? productName,
      Wrapped<double?>? stockFromStorage,
      Wrapped<num?>? storageId,
      Wrapped<enums.RWorkstationProductUnitMeasure?>? unitMeasure,
      Wrapped<num?>? workstationProductId}) {
    return RWorkstationProduct(
        amountHundred:
            (amountHundred != null ? amountHundred.value : this.amountHundred),
        consumed: (consumed != null ? consumed.value : this.consumed),
        productId: (productId != null ? productId.value : this.productId),
        productName:
            (productName != null ? productName.value : this.productName),
        stockFromStorage: (stockFromStorage != null
            ? stockFromStorage.value
            : this.stockFromStorage),
        storageId: (storageId != null ? storageId.value : this.storageId),
        unitMeasure:
            (unitMeasure != null ? unitMeasure.value : this.unitMeasure),
        workstationProductId: (workstationProductId != null
            ? workstationProductId.value
            : this.workstationProductId));
  }
}

@JsonSerializable(explicitToJson: true)
class CustomerAccess {
  CustomerAccess({
    this.accessDate,
    this.branchLocation,
  });

  factory CustomerAccess.fromJson(Map<String, dynamic> json) =>
      _$CustomerAccessFromJson(json);

  @JsonKey(name: 'accessDate')
  final String? accessDate;
  @JsonKey(
    name: 'branchLocation',
    toJson: customerAccessBranchLocationToJson,
    fromJson: customerAccessBranchLocationFromJson,
  )
  final enums.CustomerAccessBranchLocation? branchLocation;
  static const fromJsonFactory = _$CustomerAccessFromJson;
  static const toJsonFactory = _$CustomerAccessToJson;
  Map<String, dynamic> toJson() => _$CustomerAccessToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is CustomerAccess &&
            (identical(other.accessDate, accessDate) ||
                const DeepCollectionEquality()
                    .equals(other.accessDate, accessDate)) &&
            (identical(other.branchLocation, branchLocation) ||
                const DeepCollectionEquality()
                    .equals(other.branchLocation, branchLocation)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(accessDate) ^
      const DeepCollectionEquality().hash(branchLocation) ^
      runtimeType.hashCode;
}

extension $CustomerAccessExtension on CustomerAccess {
  CustomerAccess copyWith(
      {String? accessDate,
      enums.CustomerAccessBranchLocation? branchLocation}) {
    return CustomerAccess(
        accessDate: accessDate ?? this.accessDate,
        branchLocation: branchLocation ?? this.branchLocation);
  }

  CustomerAccess copyWithWrapped(
      {Wrapped<String?>? accessDate,
      Wrapped<enums.CustomerAccessBranchLocation?>? branchLocation}) {
    return CustomerAccess(
        accessDate: (accessDate != null ? accessDate.value : this.accessDate),
        branchLocation: (branchLocation != null
            ? branchLocation.value
            : this.branchLocation));
  }
}

@JsonSerializable(explicitToJson: true)
class RStorageProduct {
  RStorageProduct({
    this.amountHundred,
    this.available,
    this.productId,
    this.productName,
    this.stock,
    this.storageProductId,
    this.unitMeasure,
  });

  factory RStorageProduct.fromJson(Map<String, dynamic> json) =>
      _$RStorageProductFromJson(json);

  @JsonKey(name: 'amountHundred')
  final double? amountHundred;
  @JsonKey(name: 'available')
  final bool? available;
  @JsonKey(name: 'productId')
  final num? productId;
  @JsonKey(name: 'productName')
  final String? productName;
  @JsonKey(name: 'stock')
  final double? stock;
  @JsonKey(name: 'storageProductId')
  final num? storageProductId;
  @JsonKey(
    name: 'unitMeasure',
    toJson: rStorageProductUnitMeasureToJson,
    fromJson: rStorageProductUnitMeasureFromJson,
  )
  final enums.RStorageProductUnitMeasure? unitMeasure;
  static const fromJsonFactory = _$RStorageProductFromJson;
  static const toJsonFactory = _$RStorageProductToJson;
  Map<String, dynamic> toJson() => _$RStorageProductToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is RStorageProduct &&
            (identical(other.amountHundred, amountHundred) ||
                const DeepCollectionEquality()
                    .equals(other.amountHundred, amountHundred)) &&
            (identical(other.available, available) ||
                const DeepCollectionEquality()
                    .equals(other.available, available)) &&
            (identical(other.productId, productId) ||
                const DeepCollectionEquality()
                    .equals(other.productId, productId)) &&
            (identical(other.productName, productName) ||
                const DeepCollectionEquality()
                    .equals(other.productName, productName)) &&
            (identical(other.stock, stock) ||
                const DeepCollectionEquality().equals(other.stock, stock)) &&
            (identical(other.storageProductId, storageProductId) ||
                const DeepCollectionEquality()
                    .equals(other.storageProductId, storageProductId)) &&
            (identical(other.unitMeasure, unitMeasure) ||
                const DeepCollectionEquality()
                    .equals(other.unitMeasure, unitMeasure)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(amountHundred) ^
      const DeepCollectionEquality().hash(available) ^
      const DeepCollectionEquality().hash(productId) ^
      const DeepCollectionEquality().hash(productName) ^
      const DeepCollectionEquality().hash(stock) ^
      const DeepCollectionEquality().hash(storageProductId) ^
      const DeepCollectionEquality().hash(unitMeasure) ^
      runtimeType.hashCode;
}

extension $RStorageProductExtension on RStorageProduct {
  RStorageProduct copyWith(
      {double? amountHundred,
      bool? available,
      num? productId,
      String? productName,
      double? stock,
      num? storageProductId,
      enums.RStorageProductUnitMeasure? unitMeasure}) {
    return RStorageProduct(
        amountHundred: amountHundred ?? this.amountHundred,
        available: available ?? this.available,
        productId: productId ?? this.productId,
        productName: productName ?? this.productName,
        stock: stock ?? this.stock,
        storageProductId: storageProductId ?? this.storageProductId,
        unitMeasure: unitMeasure ?? this.unitMeasure);
  }

  RStorageProduct copyWithWrapped(
      {Wrapped<double?>? amountHundred,
      Wrapped<bool?>? available,
      Wrapped<num?>? productId,
      Wrapped<String?>? productName,
      Wrapped<double?>? stock,
      Wrapped<num?>? storageProductId,
      Wrapped<enums.RStorageProductUnitMeasure?>? unitMeasure}) {
    return RStorageProduct(
        amountHundred:
            (amountHundred != null ? amountHundred.value : this.amountHundred),
        available: (available != null ? available.value : this.available),
        productId: (productId != null ? productId.value : this.productId),
        productName:
            (productName != null ? productName.value : this.productName),
        stock: (stock != null ? stock.value : this.stock),
        storageProductId: (storageProductId != null
            ? storageProductId.value
            : this.storageProductId),
        unitMeasure:
            (unitMeasure != null ? unitMeasure.value : this.unitMeasure));
  }
}

@JsonSerializable(explicitToJson: true)
class Customer {
  Customer({
    this.accessesList,
    this.customerId,
    this.dob,
    this.email,
    this.lastname,
    this.name,
    this.phone,
    this.treatmentPersonalData,
  });

  factory Customer.fromJson(Map<String, dynamic> json) =>
      _$CustomerFromJson(json);

  @JsonKey(name: 'accessesList', defaultValue: <CustomerAccess>[])
  final List<CustomerAccess>? accessesList;
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
  @JsonKey(name: 'phone')
  final String? phone;
  @JsonKey(name: 'treatmentPersonalData')
  final bool? treatmentPersonalData;
  static const fromJsonFactory = _$CustomerFromJson;
  static const toJsonFactory = _$CustomerToJson;
  Map<String, dynamic> toJson() => _$CustomerToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is Customer &&
            (identical(other.accessesList, accessesList) ||
                const DeepCollectionEquality()
                    .equals(other.accessesList, accessesList)) &&
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
            (identical(other.phone, phone) ||
                const DeepCollectionEquality().equals(other.phone, phone)) &&
            (identical(other.treatmentPersonalData, treatmentPersonalData) ||
                const DeepCollectionEquality().equals(
                    other.treatmentPersonalData, treatmentPersonalData)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(accessesList) ^
      const DeepCollectionEquality().hash(customerId) ^
      const DeepCollectionEquality().hash(dob) ^
      const DeepCollectionEquality().hash(email) ^
      const DeepCollectionEquality().hash(lastname) ^
      const DeepCollectionEquality().hash(name) ^
      const DeepCollectionEquality().hash(phone) ^
      const DeepCollectionEquality().hash(treatmentPersonalData) ^
      runtimeType.hashCode;
}

extension $CustomerExtension on Customer {
  Customer copyWith(
      {List<CustomerAccess>? accessesList,
      num? customerId,
      String? dob,
      String? email,
      String? lastname,
      String? name,
      String? phone,
      bool? treatmentPersonalData}) {
    return Customer(
        accessesList: accessesList ?? this.accessesList,
        customerId: customerId ?? this.customerId,
        dob: dob ?? this.dob,
        email: email ?? this.email,
        lastname: lastname ?? this.lastname,
        name: name ?? this.name,
        phone: phone ?? this.phone,
        treatmentPersonalData:
            treatmentPersonalData ?? this.treatmentPersonalData);
  }

  Customer copyWithWrapped(
      {Wrapped<List<CustomerAccess>?>? accessesList,
      Wrapped<num?>? customerId,
      Wrapped<String?>? dob,
      Wrapped<String?>? email,
      Wrapped<String?>? lastname,
      Wrapped<String?>? name,
      Wrapped<String?>? phone,
      Wrapped<bool?>? treatmentPersonalData}) {
    return Customer(
        accessesList:
            (accessesList != null ? accessesList.value : this.accessesList),
        customerId: (customerId != null ? customerId.value : this.customerId),
        dob: (dob != null ? dob.value : this.dob),
        email: (email != null ? email.value : this.email),
        lastname: (lastname != null ? lastname.value : this.lastname),
        name: (name != null ? name.value : this.name),
        phone: (phone != null ? phone.value : this.phone),
        treatmentPersonalData: (treatmentPersonalData != null
            ? treatmentPersonalData.value
            : this.treatmentPersonalData));
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
      enums.ProductUnitMeasure? unitMeasure,
      int? vatApplied}) {
    return Product(
        category: category ?? this.category,
        description: description ?? this.description,
        name: name ?? this.name,
        price: price ?? this.price,
        productId: productId ?? this.productId,
        unitMeasure: unitMeasure ?? this.unitMeasure,
        vatApplied: vatApplied ?? this.vatApplied);
  }

  Product copyWithWrapped(
      {Wrapped<String?>? category,
      Wrapped<String?>? description,
      Wrapped<String?>? name,
      Wrapped<double?>? price,
      Wrapped<num?>? productId,
      Wrapped<enums.ProductUnitMeasure?>? unitMeasure,
      Wrapped<int?>? vatApplied}) {
    return Product(
        category: (category != null ? category.value : this.category),
        description:
            (description != null ? description.value : this.description),
        name: (name != null ? name.value : this.name),
        price: (price != null ? price.value : this.price),
        productId: (productId != null ? productId.value : this.productId),
        unitMeasure:
            (unitMeasure != null ? unitMeasure.value : this.unitMeasure),
        vatApplied: (vatApplied != null ? vatApplied.value : this.vatApplied));
  }
}

@JsonSerializable(explicitToJson: true)
class UserEntity {
  UserEntity({
    this.branchList,
    this.email,
    this.lastname,
    this.name,
    this.phone,
    this.userId,
  });

  factory UserEntity.fromJson(Map<String, dynamic> json) =>
      _$UserEntityFromJson(json);

  @JsonKey(name: 'branchList', defaultValue: <Branch>[])
  final List<Branch>? branchList;
  @JsonKey(name: 'email')
  final String? email;
  @JsonKey(name: 'lastname')
  final String? lastname;
  @JsonKey(name: 'name')
  final String? name;
  @JsonKey(name: 'phone')
  final String? phone;
  @JsonKey(name: 'userId')
  final num? userId;
  static const fromJsonFactory = _$UserEntityFromJson;
  static const toJsonFactory = _$UserEntityToJson;
  Map<String, dynamic> toJson() => _$UserEntityToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is UserEntity &&
            (identical(other.branchList, branchList) ||
                const DeepCollectionEquality()
                    .equals(other.branchList, branchList)) &&
            (identical(other.email, email) ||
                const DeepCollectionEquality().equals(other.email, email)) &&
            (identical(other.lastname, lastname) ||
                const DeepCollectionEquality()
                    .equals(other.lastname, lastname)) &&
            (identical(other.name, name) ||
                const DeepCollectionEquality().equals(other.name, name)) &&
            (identical(other.phone, phone) ||
                const DeepCollectionEquality().equals(other.phone, phone)) &&
            (identical(other.userId, userId) ||
                const DeepCollectionEquality().equals(other.userId, userId)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(branchList) ^
      const DeepCollectionEquality().hash(email) ^
      const DeepCollectionEquality().hash(lastname) ^
      const DeepCollectionEquality().hash(name) ^
      const DeepCollectionEquality().hash(phone) ^
      const DeepCollectionEquality().hash(userId) ^
      runtimeType.hashCode;
}

extension $UserEntityExtension on UserEntity {
  UserEntity copyWith(
      {List<Branch>? branchList,
      String? email,
      String? lastname,
      String? name,
      String? phone,
      num? userId}) {
    return UserEntity(
        branchList: branchList ?? this.branchList,
        email: email ?? this.email,
        lastname: lastname ?? this.lastname,
        name: name ?? this.name,
        phone: phone ?? this.phone,
        userId: userId ?? this.userId);
  }

  UserEntity copyWithWrapped(
      {Wrapped<List<Branch>?>? branchList,
      Wrapped<String?>? email,
      Wrapped<String?>? lastname,
      Wrapped<String?>? name,
      Wrapped<String?>? phone,
      Wrapped<num?>? userId}) {
    return UserEntity(
        branchList: (branchList != null ? branchList.value : this.branchList),
        email: (email != null ? email.value : this.email),
        lastname: (lastname != null ? lastname.value : this.lastname),
        name: (name != null ? name.value : this.name),
        phone: (phone != null ? phone.value : this.phone),
        userId: (userId != null ? userId.value : this.userId));
  }
}

@JsonSerializable(explicitToJson: true)
class ExpenceEvent {
  ExpenceEvent({
    this.amount,
    this.dateIntert,
    this.description,
    this.expenceId,
  });

  factory ExpenceEvent.fromJson(Map<String, dynamic> json) =>
      _$ExpenceEventFromJson(json);

  @JsonKey(name: 'amount')
  final double? amount;
  @JsonKey(name: 'dateIntert')
  final String? dateIntert;
  @JsonKey(name: 'description')
  final String? description;
  @JsonKey(name: 'expenceId')
  final num? expenceId;
  static const fromJsonFactory = _$ExpenceEventFromJson;
  static const toJsonFactory = _$ExpenceEventToJson;
  Map<String, dynamic> toJson() => _$ExpenceEventToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is ExpenceEvent &&
            (identical(other.amount, amount) ||
                const DeepCollectionEquality().equals(other.amount, amount)) &&
            (identical(other.dateIntert, dateIntert) ||
                const DeepCollectionEquality()
                    .equals(other.dateIntert, dateIntert)) &&
            (identical(other.description, description) ||
                const DeepCollectionEquality()
                    .equals(other.description, description)) &&
            (identical(other.expenceId, expenceId) ||
                const DeepCollectionEquality()
                    .equals(other.expenceId, expenceId)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(amount) ^
      const DeepCollectionEquality().hash(dateIntert) ^
      const DeepCollectionEquality().hash(description) ^
      const DeepCollectionEquality().hash(expenceId) ^
      runtimeType.hashCode;
}

extension $ExpenceEventExtension on ExpenceEvent {
  ExpenceEvent copyWith(
      {double? amount,
      String? dateIntert,
      String? description,
      num? expenceId}) {
    return ExpenceEvent(
        amount: amount ?? this.amount,
        dateIntert: dateIntert ?? this.dateIntert,
        description: description ?? this.description,
        expenceId: expenceId ?? this.expenceId);
  }

  ExpenceEvent copyWithWrapped(
      {Wrapped<double?>? amount,
      Wrapped<String?>? dateIntert,
      Wrapped<String?>? description,
      Wrapped<num?>? expenceId}) {
    return ExpenceEvent(
        amount: (amount != null ? amount.value : this.amount),
        dateIntert: (dateIntert != null ? dateIntert.value : this.dateIntert),
        description:
            (description != null ? description.value : this.description),
        expenceId: (expenceId != null ? expenceId.value : this.expenceId));
  }
}

@JsonSerializable(explicitToJson: true)
class Workstation {
  Workstation({
    this.extra,
    this.name,
    this.products,
    this.responsable,
    this.workstationId,
    this.workstationStatus,
    this.workstationType,
  });

  factory Workstation.fromJson(Map<String, dynamic> json) =>
      _$WorkstationFromJson(json);

  @JsonKey(name: 'extra')
  final String? extra;
  @JsonKey(name: 'name')
  final String? name;
  @JsonKey(name: 'products', defaultValue: <RWorkstationProduct>[])
  final List<RWorkstationProduct>? products;
  @JsonKey(name: 'responsable')
  final String? responsable;
  @JsonKey(name: 'workstationId')
  final num? workstationId;
  @JsonKey(
    name: 'workstationStatus',
    toJson: workstationWorkstationStatusToJson,
    fromJson: workstationWorkstationStatusFromJson,
  )
  final enums.WorkstationWorkstationStatus? workstationStatus;
  @JsonKey(
    name: 'workstationType',
    toJson: workstationWorkstationTypeToJson,
    fromJson: workstationWorkstationTypeFromJson,
  )
  final enums.WorkstationWorkstationType? workstationType;
  static const fromJsonFactory = _$WorkstationFromJson;
  static const toJsonFactory = _$WorkstationToJson;
  Map<String, dynamic> toJson() => _$WorkstationToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is Workstation &&
            (identical(other.extra, extra) ||
                const DeepCollectionEquality().equals(other.extra, extra)) &&
            (identical(other.name, name) ||
                const DeepCollectionEquality().equals(other.name, name)) &&
            (identical(other.products, products) ||
                const DeepCollectionEquality()
                    .equals(other.products, products)) &&
            (identical(other.responsable, responsable) ||
                const DeepCollectionEquality()
                    .equals(other.responsable, responsable)) &&
            (identical(other.workstationId, workstationId) ||
                const DeepCollectionEquality()
                    .equals(other.workstationId, workstationId)) &&
            (identical(other.workstationStatus, workstationStatus) ||
                const DeepCollectionEquality()
                    .equals(other.workstationStatus, workstationStatus)) &&
            (identical(other.workstationType, workstationType) ||
                const DeepCollectionEquality()
                    .equals(other.workstationType, workstationType)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(extra) ^
      const DeepCollectionEquality().hash(name) ^
      const DeepCollectionEquality().hash(products) ^
      const DeepCollectionEquality().hash(responsable) ^
      const DeepCollectionEquality().hash(workstationId) ^
      const DeepCollectionEquality().hash(workstationStatus) ^
      const DeepCollectionEquality().hash(workstationType) ^
      runtimeType.hashCode;
}

extension $WorkstationExtension on Workstation {
  Workstation copyWith(
      {String? extra,
      String? name,
      List<RWorkstationProduct>? products,
      String? responsable,
      num? workstationId,
      enums.WorkstationWorkstationStatus? workstationStatus,
      enums.WorkstationWorkstationType? workstationType}) {
    return Workstation(
        extra: extra ?? this.extra,
        name: name ?? this.name,
        products: products ?? this.products,
        responsable: responsable ?? this.responsable,
        workstationId: workstationId ?? this.workstationId,
        workstationStatus: workstationStatus ?? this.workstationStatus,
        workstationType: workstationType ?? this.workstationType);
  }

  Workstation copyWithWrapped(
      {Wrapped<String?>? extra,
      Wrapped<String?>? name,
      Wrapped<List<RWorkstationProduct>?>? products,
      Wrapped<String?>? responsable,
      Wrapped<num?>? workstationId,
      Wrapped<enums.WorkstationWorkstationStatus?>? workstationStatus,
      Wrapped<enums.WorkstationWorkstationType?>? workstationType}) {
    return Workstation(
        extra: (extra != null ? extra.value : this.extra),
        name: (name != null ? name.value : this.name),
        products: (products != null ? products.value : this.products),
        responsable:
            (responsable != null ? responsable.value : this.responsable),
        workstationId:
            (workstationId != null ? workstationId.value : this.workstationId),
        workstationStatus: (workstationStatus != null
            ? workstationStatus.value
            : this.workstationStatus),
        workstationType: (workstationType != null
            ? workstationType.value
            : this.workstationType));
  }
}

@JsonSerializable(explicitToJson: true)
class OrderEntity {
  OrderEntity({
    this.branchId,
    this.closedBy,
    this.code,
    this.creationDate,
    this.deliveryDate,
    this.details,
    this.errorStatus,
    this.orderId,
    this.orderStatus,
    this.paid,
    this.products,
    this.senderUser,
    this.storageId,
    this.supplierId,
    this.total,
  });

  factory OrderEntity.fromJson(Map<String, dynamic> json) =>
      _$OrderEntityFromJson(json);

  @JsonKey(name: 'branchId')
  final num? branchId;
  @JsonKey(name: 'closedBy')
  final String? closedBy;
  @JsonKey(name: 'code')
  final String? code;
  @JsonKey(name: 'creationDate')
  final String? creationDate;
  @JsonKey(name: 'deliveryDate')
  final String? deliveryDate;
  @JsonKey(name: 'details')
  final String? details;
  @JsonKey(name: 'errorStatus')
  final String? errorStatus;
  @JsonKey(name: 'orderId')
  final num? orderId;
  @JsonKey(
    name: 'orderStatus',
    toJson: orderEntityOrderStatusToJson,
    fromJson: orderEntityOrderStatusFromJson,
  )
  final enums.OrderEntityOrderStatus? orderStatus;
  @JsonKey(name: 'paid')
  final bool? paid;
  @JsonKey(name: 'products', defaultValue: <ROrderProduct>[])
  final List<ROrderProduct>? products;
  @JsonKey(name: 'senderUser')
  final String? senderUser;
  @JsonKey(name: 'storageId')
  final num? storageId;
  @JsonKey(name: 'supplierId')
  final num? supplierId;
  @JsonKey(name: 'total')
  final double? total;
  static const fromJsonFactory = _$OrderEntityFromJson;
  static const toJsonFactory = _$OrderEntityToJson;
  Map<String, dynamic> toJson() => _$OrderEntityToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is OrderEntity &&
            (identical(other.branchId, branchId) ||
                const DeepCollectionEquality()
                    .equals(other.branchId, branchId)) &&
            (identical(other.closedBy, closedBy) ||
                const DeepCollectionEquality()
                    .equals(other.closedBy, closedBy)) &&
            (identical(other.code, code) ||
                const DeepCollectionEquality().equals(other.code, code)) &&
            (identical(other.creationDate, creationDate) ||
                const DeepCollectionEquality()
                    .equals(other.creationDate, creationDate)) &&
            (identical(other.deliveryDate, deliveryDate) ||
                const DeepCollectionEquality()
                    .equals(other.deliveryDate, deliveryDate)) &&
            (identical(other.details, details) ||
                const DeepCollectionEquality()
                    .equals(other.details, details)) &&
            (identical(other.errorStatus, errorStatus) ||
                const DeepCollectionEquality()
                    .equals(other.errorStatus, errorStatus)) &&
            (identical(other.orderId, orderId) ||
                const DeepCollectionEquality()
                    .equals(other.orderId, orderId)) &&
            (identical(other.orderStatus, orderStatus) ||
                const DeepCollectionEquality()
                    .equals(other.orderStatus, orderStatus)) &&
            (identical(other.paid, paid) ||
                const DeepCollectionEquality().equals(other.paid, paid)) &&
            (identical(other.products, products) ||
                const DeepCollectionEquality()
                    .equals(other.products, products)) &&
            (identical(other.senderUser, senderUser) ||
                const DeepCollectionEquality()
                    .equals(other.senderUser, senderUser)) &&
            (identical(other.storageId, storageId) ||
                const DeepCollectionEquality()
                    .equals(other.storageId, storageId)) &&
            (identical(other.supplierId, supplierId) ||
                const DeepCollectionEquality()
                    .equals(other.supplierId, supplierId)) &&
            (identical(other.total, total) ||
                const DeepCollectionEquality().equals(other.total, total)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(branchId) ^
      const DeepCollectionEquality().hash(closedBy) ^
      const DeepCollectionEquality().hash(code) ^
      const DeepCollectionEquality().hash(creationDate) ^
      const DeepCollectionEquality().hash(deliveryDate) ^
      const DeepCollectionEquality().hash(details) ^
      const DeepCollectionEquality().hash(errorStatus) ^
      const DeepCollectionEquality().hash(orderId) ^
      const DeepCollectionEquality().hash(orderStatus) ^
      const DeepCollectionEquality().hash(paid) ^
      const DeepCollectionEquality().hash(products) ^
      const DeepCollectionEquality().hash(senderUser) ^
      const DeepCollectionEquality().hash(storageId) ^
      const DeepCollectionEquality().hash(supplierId) ^
      const DeepCollectionEquality().hash(total) ^
      runtimeType.hashCode;
}

extension $OrderEntityExtension on OrderEntity {
  OrderEntity copyWith(
      {num? branchId,
      String? closedBy,
      String? code,
      String? creationDate,
      String? deliveryDate,
      String? details,
      String? errorStatus,
      num? orderId,
      enums.OrderEntityOrderStatus? orderStatus,
      bool? paid,
      List<ROrderProduct>? products,
      String? senderUser,
      num? storageId,
      num? supplierId,
      double? total}) {
    return OrderEntity(
        branchId: branchId ?? this.branchId,
        closedBy: closedBy ?? this.closedBy,
        code: code ?? this.code,
        creationDate: creationDate ?? this.creationDate,
        deliveryDate: deliveryDate ?? this.deliveryDate,
        details: details ?? this.details,
        errorStatus: errorStatus ?? this.errorStatus,
        orderId: orderId ?? this.orderId,
        orderStatus: orderStatus ?? this.orderStatus,
        paid: paid ?? this.paid,
        products: products ?? this.products,
        senderUser: senderUser ?? this.senderUser,
        storageId: storageId ?? this.storageId,
        supplierId: supplierId ?? this.supplierId,
        total: total ?? this.total);
  }

  OrderEntity copyWithWrapped(
      {Wrapped<num?>? branchId,
      Wrapped<String?>? closedBy,
      Wrapped<String?>? code,
      Wrapped<String?>? creationDate,
      Wrapped<String?>? deliveryDate,
      Wrapped<String?>? details,
      Wrapped<String?>? errorStatus,
      Wrapped<num?>? orderId,
      Wrapped<enums.OrderEntityOrderStatus?>? orderStatus,
      Wrapped<bool?>? paid,
      Wrapped<List<ROrderProduct>?>? products,
      Wrapped<String?>? senderUser,
      Wrapped<num?>? storageId,
      Wrapped<num?>? supplierId,
      Wrapped<double?>? total}) {
    return OrderEntity(
        branchId: (branchId != null ? branchId.value : this.branchId),
        closedBy: (closedBy != null ? closedBy.value : this.closedBy),
        code: (code != null ? code.value : this.code),
        creationDate:
            (creationDate != null ? creationDate.value : this.creationDate),
        deliveryDate:
            (deliveryDate != null ? deliveryDate.value : this.deliveryDate),
        details: (details != null ? details.value : this.details),
        errorStatus:
            (errorStatus != null ? errorStatus.value : this.errorStatus),
        orderId: (orderId != null ? orderId.value : this.orderId),
        orderStatus:
            (orderStatus != null ? orderStatus.value : this.orderStatus),
        paid: (paid != null ? paid.value : this.paid),
        products: (products != null ? products.value : this.products),
        senderUser: (senderUser != null ? senderUser.value : this.senderUser),
        storageId: (storageId != null ? storageId.value : this.storageId),
        supplierId: (supplierId != null ? supplierId.value : this.supplierId),
        total: (total != null ? total.value : this.total));
  }
}

@JsonSerializable(explicitToJson: true)
class Storage {
  Storage({
    this.address,
    this.branchId,
    this.cap,
    this.city,
    this.creationDate,
    this.name,
    this.products,
    this.storageId,
  });

  factory Storage.fromJson(Map<String, dynamic> json) =>
      _$StorageFromJson(json);

  @JsonKey(name: 'address')
  final String? address;
  @JsonKey(name: 'branchId')
  final num? branchId;
  @JsonKey(name: 'cap')
  final String? cap;
  @JsonKey(name: 'city')
  final String? city;
  @JsonKey(name: 'creationDate')
  final String? creationDate;
  @JsonKey(name: 'name')
  final String? name;
  @JsonKey(name: 'products', defaultValue: <RStorageProduct>[])
  final List<RStorageProduct>? products;
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
            (identical(other.branchId, branchId) ||
                const DeepCollectionEquality()
                    .equals(other.branchId, branchId)) &&
            (identical(other.cap, cap) ||
                const DeepCollectionEquality().equals(other.cap, cap)) &&
            (identical(other.city, city) ||
                const DeepCollectionEquality().equals(other.city, city)) &&
            (identical(other.creationDate, creationDate) ||
                const DeepCollectionEquality()
                    .equals(other.creationDate, creationDate)) &&
            (identical(other.name, name) ||
                const DeepCollectionEquality().equals(other.name, name)) &&
            (identical(other.products, products) ||
                const DeepCollectionEquality()
                    .equals(other.products, products)) &&
            (identical(other.storageId, storageId) ||
                const DeepCollectionEquality()
                    .equals(other.storageId, storageId)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(address) ^
      const DeepCollectionEquality().hash(branchId) ^
      const DeepCollectionEquality().hash(cap) ^
      const DeepCollectionEquality().hash(city) ^
      const DeepCollectionEquality().hash(creationDate) ^
      const DeepCollectionEquality().hash(name) ^
      const DeepCollectionEquality().hash(products) ^
      const DeepCollectionEquality().hash(storageId) ^
      runtimeType.hashCode;
}

extension $StorageExtension on Storage {
  Storage copyWith(
      {String? address,
      num? branchId,
      String? cap,
      String? city,
      String? creationDate,
      String? name,
      List<RStorageProduct>? products,
      num? storageId}) {
    return Storage(
        address: address ?? this.address,
        branchId: branchId ?? this.branchId,
        cap: cap ?? this.cap,
        city: city ?? this.city,
        creationDate: creationDate ?? this.creationDate,
        name: name ?? this.name,
        products: products ?? this.products,
        storageId: storageId ?? this.storageId);
  }

  Storage copyWithWrapped(
      {Wrapped<String?>? address,
      Wrapped<num?>? branchId,
      Wrapped<String?>? cap,
      Wrapped<String?>? city,
      Wrapped<String?>? creationDate,
      Wrapped<String?>? name,
      Wrapped<List<RStorageProduct>?>? products,
      Wrapped<num?>? storageId}) {
    return Storage(
        address: (address != null ? address.value : this.address),
        branchId: (branchId != null ? branchId.value : this.branchId),
        cap: (cap != null ? cap.value : this.cap),
        city: (city != null ? city.value : this.city),
        creationDate:
            (creationDate != null ? creationDate.value : this.creationDate),
        name: (name != null ? name.value : this.name),
        products: (products != null ? products.value : this.products),
        storageId: (storageId != null ? storageId.value : this.storageId));
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
    this.events,
    this.name,
    this.orders,
    this.phoneNumber,
    this.storages,
    this.suppliers,
    this.token,
    this.userId,
    this.userPriviledge,
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
  @JsonKey(name: 'events', defaultValue: <Event>[])
  final List<Event>? events;
  @JsonKey(name: 'name')
  final String? name;
  @JsonKey(name: 'orders', defaultValue: <OrderEntity>[])
  final List<OrderEntity>? orders;
  @JsonKey(name: 'phoneNumber')
  final String? phoneNumber;
  @JsonKey(name: 'storages', defaultValue: <Storage>[])
  final List<Storage>? storages;
  @JsonKey(name: 'suppliers', defaultValue: <Supplier>[])
  final List<Supplier>? suppliers;
  @JsonKey(name: 'token')
  final String? token;
  @JsonKey(name: 'userId')
  final num? userId;
  @JsonKey(
    name: 'userPriviledge',
    toJson: branchUserPriviledgeToJson,
    fromJson: branchUserPriviledgeFromJson,
  )
  final enums.BranchUserPriviledge? userPriviledge;
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
            (identical(other.events, events) ||
                const DeepCollectionEquality().equals(other.events, events)) &&
            (identical(other.name, name) ||
                const DeepCollectionEquality().equals(other.name, name)) &&
            (identical(other.orders, orders) ||
                const DeepCollectionEquality().equals(other.orders, orders)) &&
            (identical(other.phoneNumber, phoneNumber) ||
                const DeepCollectionEquality()
                    .equals(other.phoneNumber, phoneNumber)) &&
            (identical(other.storages, storages) ||
                const DeepCollectionEquality()
                    .equals(other.storages, storages)) &&
            (identical(other.suppliers, suppliers) ||
                const DeepCollectionEquality()
                    .equals(other.suppliers, suppliers)) &&
            (identical(other.token, token) ||
                const DeepCollectionEquality().equals(other.token, token)) &&
            (identical(other.userId, userId) ||
                const DeepCollectionEquality().equals(other.userId, userId)) &&
            (identical(other.userPriviledge, userPriviledge) ||
                const DeepCollectionEquality()
                    .equals(other.userPriviledge, userPriviledge)) &&
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
      const DeepCollectionEquality().hash(events) ^
      const DeepCollectionEquality().hash(name) ^
      const DeepCollectionEquality().hash(orders) ^
      const DeepCollectionEquality().hash(phoneNumber) ^
      const DeepCollectionEquality().hash(storages) ^
      const DeepCollectionEquality().hash(suppliers) ^
      const DeepCollectionEquality().hash(token) ^
      const DeepCollectionEquality().hash(userId) ^
      const DeepCollectionEquality().hash(userPriviledge) ^
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
      List<Event>? events,
      String? name,
      List<OrderEntity>? orders,
      String? phoneNumber,
      List<Storage>? storages,
      List<Supplier>? suppliers,
      String? token,
      num? userId,
      enums.BranchUserPriviledge? userPriviledge,
      String? vatNumber}) {
    return Branch(
        address: address ?? this.address,
        branchId: branchId ?? this.branchId,
        cap: cap ?? this.cap,
        city: city ?? this.city,
        email: email ?? this.email,
        events: events ?? this.events,
        name: name ?? this.name,
        orders: orders ?? this.orders,
        phoneNumber: phoneNumber ?? this.phoneNumber,
        storages: storages ?? this.storages,
        suppliers: suppliers ?? this.suppliers,
        token: token ?? this.token,
        userId: userId ?? this.userId,
        userPriviledge: userPriviledge ?? this.userPriviledge,
        vatNumber: vatNumber ?? this.vatNumber);
  }

  Branch copyWithWrapped(
      {Wrapped<String?>? address,
      Wrapped<num?>? branchId,
      Wrapped<String?>? cap,
      Wrapped<String?>? city,
      Wrapped<String?>? email,
      Wrapped<List<Event>?>? events,
      Wrapped<String?>? name,
      Wrapped<List<OrderEntity>?>? orders,
      Wrapped<String?>? phoneNumber,
      Wrapped<List<Storage>?>? storages,
      Wrapped<List<Supplier>?>? suppliers,
      Wrapped<String?>? token,
      Wrapped<num?>? userId,
      Wrapped<enums.BranchUserPriviledge?>? userPriviledge,
      Wrapped<String?>? vatNumber}) {
    return Branch(
        address: (address != null ? address.value : this.address),
        branchId: (branchId != null ? branchId.value : this.branchId),
        cap: (cap != null ? cap.value : this.cap),
        city: (city != null ? city.value : this.city),
        email: (email != null ? email.value : this.email),
        events: (events != null ? events.value : this.events),
        name: (name != null ? name.value : this.name),
        orders: (orders != null ? orders.value : this.orders),
        phoneNumber:
            (phoneNumber != null ? phoneNumber.value : this.phoneNumber),
        storages: (storages != null ? storages.value : this.storages),
        suppliers: (suppliers != null ? suppliers.value : this.suppliers),
        token: (token != null ? token.value : this.token),
        userId: (userId != null ? userId.value : this.userId),
        userPriviledge: (userPriviledge != null
            ? userPriviledge.value
            : this.userPriviledge),
        vatNumber: (vatNumber != null ? vatNumber.value : this.vatNumber));
  }
}

@JsonSerializable(explicitToJson: true)
class Event {
  Event({
    this.branchId,
    this.dateCreation,
    this.dateEvent,
    this.eventId,
    this.eventStatus,
    this.expenceEvents,
    this.location,
    this.name,
    this.storageId,
    this.workstations,
  });

  factory Event.fromJson(Map<String, dynamic> json) => _$EventFromJson(json);

  @JsonKey(name: 'branchId')
  final num? branchId;
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
  @JsonKey(name: 'expenceEvents', defaultValue: <ExpenceEvent>[])
  final List<ExpenceEvent>? expenceEvents;
  @JsonKey(name: 'location')
  final String? location;
  @JsonKey(name: 'name')
  final String? name;
  @JsonKey(name: 'storageId')
  final num? storageId;
  @JsonKey(name: 'workstations', defaultValue: <Workstation>[])
  final List<Workstation>? workstations;
  static const fromJsonFactory = _$EventFromJson;
  static const toJsonFactory = _$EventToJson;
  Map<String, dynamic> toJson() => _$EventToJson(this);

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other is Event &&
            (identical(other.branchId, branchId) ||
                const DeepCollectionEquality()
                    .equals(other.branchId, branchId)) &&
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
            (identical(other.expenceEvents, expenceEvents) ||
                const DeepCollectionEquality()
                    .equals(other.expenceEvents, expenceEvents)) &&
            (identical(other.location, location) ||
                const DeepCollectionEquality()
                    .equals(other.location, location)) &&
            (identical(other.name, name) ||
                const DeepCollectionEquality().equals(other.name, name)) &&
            (identical(other.storageId, storageId) ||
                const DeepCollectionEquality()
                    .equals(other.storageId, storageId)) &&
            (identical(other.workstations, workstations) ||
                const DeepCollectionEquality()
                    .equals(other.workstations, workstations)));
  }

  @override
  String toString() => jsonEncode(this);

  @override
  int get hashCode =>
      const DeepCollectionEquality().hash(branchId) ^
      const DeepCollectionEquality().hash(dateCreation) ^
      const DeepCollectionEquality().hash(dateEvent) ^
      const DeepCollectionEquality().hash(eventId) ^
      const DeepCollectionEquality().hash(eventStatus) ^
      const DeepCollectionEquality().hash(expenceEvents) ^
      const DeepCollectionEquality().hash(location) ^
      const DeepCollectionEquality().hash(name) ^
      const DeepCollectionEquality().hash(storageId) ^
      const DeepCollectionEquality().hash(workstations) ^
      runtimeType.hashCode;
}

extension $EventExtension on Event {
  Event copyWith(
      {num? branchId,
      String? dateCreation,
      String? dateEvent,
      num? eventId,
      enums.EventEventStatus? eventStatus,
      List<ExpenceEvent>? expenceEvents,
      String? location,
      String? name,
      num? storageId,
      List<Workstation>? workstations}) {
    return Event(
        branchId: branchId ?? this.branchId,
        dateCreation: dateCreation ?? this.dateCreation,
        dateEvent: dateEvent ?? this.dateEvent,
        eventId: eventId ?? this.eventId,
        eventStatus: eventStatus ?? this.eventStatus,
        expenceEvents: expenceEvents ?? this.expenceEvents,
        location: location ?? this.location,
        name: name ?? this.name,
        storageId: storageId ?? this.storageId,
        workstations: workstations ?? this.workstations);
  }

  Event copyWithWrapped(
      {Wrapped<num?>? branchId,
      Wrapped<String?>? dateCreation,
      Wrapped<String?>? dateEvent,
      Wrapped<num?>? eventId,
      Wrapped<enums.EventEventStatus?>? eventStatus,
      Wrapped<List<ExpenceEvent>?>? expenceEvents,
      Wrapped<String?>? location,
      Wrapped<String?>? name,
      Wrapped<num?>? storageId,
      Wrapped<List<Workstation>?>? workstations}) {
    return Event(
        branchId: (branchId != null ? branchId.value : this.branchId),
        dateCreation:
            (dateCreation != null ? dateCreation.value : this.dateCreation),
        dateEvent: (dateEvent != null ? dateEvent.value : this.dateEvent),
        eventId: (eventId != null ? eventId.value : this.eventId),
        eventStatus:
            (eventStatus != null ? eventStatus.value : this.eventStatus),
        expenceEvents:
            (expenceEvents != null ? expenceEvents.value : this.expenceEvents),
        location: (location != null ? location.value : this.location),
        name: (name != null ? name.value : this.name),
        storageId: (storageId != null ? storageId.value : this.storageId),
        workstations:
            (workstations != null ? workstations.value : this.workstations));
  }
}

@JsonSerializable(explicitToJson: true)
class Supplier {
  Supplier({
    this.address,
    this.branchId,
    this.cap,
    this.city,
    this.email,
    this.name,
    this.pec,
    this.phoneNumber,
    this.productList,
    this.supplierId,
    this.vatNumber,
  });

  factory Supplier.fromJson(Map<String, dynamic> json) =>
      _$SupplierFromJson(json);

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
  @JsonKey(name: 'pec')
  final String? pec;
  @JsonKey(name: 'phoneNumber')
  final String? phoneNumber;
  @JsonKey(name: 'productList', defaultValue: <Product>[])
  final List<Product>? productList;
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
            (identical(other.pec, pec) ||
                const DeepCollectionEquality().equals(other.pec, pec)) &&
            (identical(other.phoneNumber, phoneNumber) ||
                const DeepCollectionEquality()
                    .equals(other.phoneNumber, phoneNumber)) &&
            (identical(other.productList, productList) ||
                const DeepCollectionEquality()
                    .equals(other.productList, productList)) &&
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
      const DeepCollectionEquality().hash(branchId) ^
      const DeepCollectionEquality().hash(cap) ^
      const DeepCollectionEquality().hash(city) ^
      const DeepCollectionEquality().hash(email) ^
      const DeepCollectionEquality().hash(name) ^
      const DeepCollectionEquality().hash(pec) ^
      const DeepCollectionEquality().hash(phoneNumber) ^
      const DeepCollectionEquality().hash(productList) ^
      const DeepCollectionEquality().hash(supplierId) ^
      const DeepCollectionEquality().hash(vatNumber) ^
      runtimeType.hashCode;
}

extension $SupplierExtension on Supplier {
  Supplier copyWith(
      {String? address,
      num? branchId,
      String? cap,
      String? city,
      String? email,
      String? name,
      String? pec,
      String? phoneNumber,
      List<Product>? productList,
      num? supplierId,
      String? vatNumber}) {
    return Supplier(
        address: address ?? this.address,
        branchId: branchId ?? this.branchId,
        cap: cap ?? this.cap,
        city: city ?? this.city,
        email: email ?? this.email,
        name: name ?? this.name,
        pec: pec ?? this.pec,
        phoneNumber: phoneNumber ?? this.phoneNumber,
        productList: productList ?? this.productList,
        supplierId: supplierId ?? this.supplierId,
        vatNumber: vatNumber ?? this.vatNumber);
  }

  Supplier copyWithWrapped(
      {Wrapped<String?>? address,
      Wrapped<num?>? branchId,
      Wrapped<String?>? cap,
      Wrapped<String?>? city,
      Wrapped<String?>? email,
      Wrapped<String?>? name,
      Wrapped<String?>? pec,
      Wrapped<String?>? phoneNumber,
      Wrapped<List<Product>?>? productList,
      Wrapped<num?>? supplierId,
      Wrapped<String?>? vatNumber}) {
    return Supplier(
        address: (address != null ? address.value : this.address),
        branchId: (branchId != null ? branchId.value : this.branchId),
        cap: (cap != null ? cap.value : this.cap),
        city: (city != null ? city.value : this.city),
        email: (email != null ? email.value : this.email),
        name: (name != null ? name.value : this.name),
        pec: (pec != null ? pec.value : this.pec),
        phoneNumber:
            (phoneNumber != null ? phoneNumber.value : this.phoneNumber),
        productList:
            (productList != null ? productList.value : this.productList),
        supplierId: (supplierId != null ? supplierId.value : this.supplierId),
        vatNumber: (vatNumber != null ? vatNumber.value : this.vatNumber));
  }
}

String? rOrderProductUnitMeasureToJson(
    enums.ROrderProductUnitMeasure? rOrderProductUnitMeasure) {
  return enums.$ROrderProductUnitMeasureMap[rOrderProductUnitMeasure];
}

enums.ROrderProductUnitMeasure rOrderProductUnitMeasureFromJson(
  Object? rOrderProductUnitMeasure, [
  enums.ROrderProductUnitMeasure? defaultValue,
]) {
  if (rOrderProductUnitMeasure is String) {
    return enums.$ROrderProductUnitMeasureMap.entries
        .firstWhere(
            (element) =>
                element.value.toLowerCase() ==
                rOrderProductUnitMeasure.toLowerCase(),
            orElse: () => const MapEntry(
                enums.ROrderProductUnitMeasure.swaggerGeneratedUnknown, ''))
        .key;
  }

  final parsedResult = defaultValue == null
      ? null
      : enums.$ROrderProductUnitMeasureMap.entries
          .firstWhereOrNull((element) => element.value == defaultValue)
          ?.key;

  return parsedResult ??
      defaultValue ??
      enums.ROrderProductUnitMeasure.swaggerGeneratedUnknown;
}

List<String> rOrderProductUnitMeasureListToJson(
    List<enums.ROrderProductUnitMeasure>? rOrderProductUnitMeasure) {
  if (rOrderProductUnitMeasure == null) {
    return [];
  }

  return rOrderProductUnitMeasure
      .map((e) => enums.$ROrderProductUnitMeasureMap[e]!)
      .toList();
}

List<enums.ROrderProductUnitMeasure> rOrderProductUnitMeasureListFromJson(
  List? rOrderProductUnitMeasure, [
  List<enums.ROrderProductUnitMeasure>? defaultValue,
]) {
  if (rOrderProductUnitMeasure == null) {
    return defaultValue ?? [];
  }

  return rOrderProductUnitMeasure
      .map((e) => rOrderProductUnitMeasureFromJson(e.toString()))
      .toList();
}

List<enums.ROrderProductUnitMeasure>?
    rOrderProductUnitMeasureNullableListFromJson(
  List? rOrderProductUnitMeasure, [
  List<enums.ROrderProductUnitMeasure>? defaultValue,
]) {
  if (rOrderProductUnitMeasure == null) {
    return defaultValue;
  }

  return rOrderProductUnitMeasure
      .map((e) => rOrderProductUnitMeasureFromJson(e.toString()))
      .toList();
}

String? rWorkstationProductUnitMeasureToJson(
    enums.RWorkstationProductUnitMeasure? rWorkstationProductUnitMeasure) {
  return enums
      .$RWorkstationProductUnitMeasureMap[rWorkstationProductUnitMeasure];
}

enums.RWorkstationProductUnitMeasure rWorkstationProductUnitMeasureFromJson(
  Object? rWorkstationProductUnitMeasure, [
  enums.RWorkstationProductUnitMeasure? defaultValue,
]) {
  if (rWorkstationProductUnitMeasure is String) {
    return enums.$RWorkstationProductUnitMeasureMap.entries
        .firstWhere(
            (element) =>
                element.value.toLowerCase() ==
                rWorkstationProductUnitMeasure.toLowerCase(),
            orElse: () => const MapEntry(
                enums.RWorkstationProductUnitMeasure.swaggerGeneratedUnknown,
                ''))
        .key;
  }

  final parsedResult = defaultValue == null
      ? null
      : enums.$RWorkstationProductUnitMeasureMap.entries
          .firstWhereOrNull((element) => element.value == defaultValue)
          ?.key;

  return parsedResult ??
      defaultValue ??
      enums.RWorkstationProductUnitMeasure.swaggerGeneratedUnknown;
}

List<String> rWorkstationProductUnitMeasureListToJson(
    List<enums.RWorkstationProductUnitMeasure>?
        rWorkstationProductUnitMeasure) {
  if (rWorkstationProductUnitMeasure == null) {
    return [];
  }

  return rWorkstationProductUnitMeasure
      .map((e) => enums.$RWorkstationProductUnitMeasureMap[e]!)
      .toList();
}

List<enums.RWorkstationProductUnitMeasure>
    rWorkstationProductUnitMeasureListFromJson(
  List? rWorkstationProductUnitMeasure, [
  List<enums.RWorkstationProductUnitMeasure>? defaultValue,
]) {
  if (rWorkstationProductUnitMeasure == null) {
    return defaultValue ?? [];
  }

  return rWorkstationProductUnitMeasure
      .map((e) => rWorkstationProductUnitMeasureFromJson(e.toString()))
      .toList();
}

List<enums.RWorkstationProductUnitMeasure>?
    rWorkstationProductUnitMeasureNullableListFromJson(
  List? rWorkstationProductUnitMeasure, [
  List<enums.RWorkstationProductUnitMeasure>? defaultValue,
]) {
  if (rWorkstationProductUnitMeasure == null) {
    return defaultValue;
  }

  return rWorkstationProductUnitMeasure
      .map((e) => rWorkstationProductUnitMeasureFromJson(e.toString()))
      .toList();
}

String? customerAccessBranchLocationToJson(
    enums.CustomerAccessBranchLocation? customerAccessBranchLocation) {
  return enums.$CustomerAccessBranchLocationMap[customerAccessBranchLocation];
}

enums.CustomerAccessBranchLocation customerAccessBranchLocationFromJson(
  Object? customerAccessBranchLocation, [
  enums.CustomerAccessBranchLocation? defaultValue,
]) {
  if (customerAccessBranchLocation is String) {
    return enums.$CustomerAccessBranchLocationMap.entries
        .firstWhere(
            (element) =>
                element.value.toLowerCase() ==
                customerAccessBranchLocation.toLowerCase(),
            orElse: () => const MapEntry(
                enums.CustomerAccessBranchLocation.swaggerGeneratedUnknown, ''))
        .key;
  }

  final parsedResult = defaultValue == null
      ? null
      : enums.$CustomerAccessBranchLocationMap.entries
          .firstWhereOrNull((element) => element.value == defaultValue)
          ?.key;

  return parsedResult ??
      defaultValue ??
      enums.CustomerAccessBranchLocation.swaggerGeneratedUnknown;
}

List<String> customerAccessBranchLocationListToJson(
    List<enums.CustomerAccessBranchLocation>? customerAccessBranchLocation) {
  if (customerAccessBranchLocation == null) {
    return [];
  }

  return customerAccessBranchLocation
      .map((e) => enums.$CustomerAccessBranchLocationMap[e]!)
      .toList();
}

List<enums.CustomerAccessBranchLocation>
    customerAccessBranchLocationListFromJson(
  List? customerAccessBranchLocation, [
  List<enums.CustomerAccessBranchLocation>? defaultValue,
]) {
  if (customerAccessBranchLocation == null) {
    return defaultValue ?? [];
  }

  return customerAccessBranchLocation
      .map((e) => customerAccessBranchLocationFromJson(e.toString()))
      .toList();
}

List<enums.CustomerAccessBranchLocation>?
    customerAccessBranchLocationNullableListFromJson(
  List? customerAccessBranchLocation, [
  List<enums.CustomerAccessBranchLocation>? defaultValue,
]) {
  if (customerAccessBranchLocation == null) {
    return defaultValue;
  }

  return customerAccessBranchLocation
      .map((e) => customerAccessBranchLocationFromJson(e.toString()))
      .toList();
}

String? rStorageProductUnitMeasureToJson(
    enums.RStorageProductUnitMeasure? rStorageProductUnitMeasure) {
  return enums.$RStorageProductUnitMeasureMap[rStorageProductUnitMeasure];
}

enums.RStorageProductUnitMeasure rStorageProductUnitMeasureFromJson(
  Object? rStorageProductUnitMeasure, [
  enums.RStorageProductUnitMeasure? defaultValue,
]) {
  if (rStorageProductUnitMeasure is String) {
    return enums.$RStorageProductUnitMeasureMap.entries
        .firstWhere(
            (element) =>
                element.value.toLowerCase() ==
                rStorageProductUnitMeasure.toLowerCase(),
            orElse: () => const MapEntry(
                enums.RStorageProductUnitMeasure.swaggerGeneratedUnknown, ''))
        .key;
  }

  final parsedResult = defaultValue == null
      ? null
      : enums.$RStorageProductUnitMeasureMap.entries
          .firstWhereOrNull((element) => element.value == defaultValue)
          ?.key;

  return parsedResult ??
      defaultValue ??
      enums.RStorageProductUnitMeasure.swaggerGeneratedUnknown;
}

List<String> rStorageProductUnitMeasureListToJson(
    List<enums.RStorageProductUnitMeasure>? rStorageProductUnitMeasure) {
  if (rStorageProductUnitMeasure == null) {
    return [];
  }

  return rStorageProductUnitMeasure
      .map((e) => enums.$RStorageProductUnitMeasureMap[e]!)
      .toList();
}

List<enums.RStorageProductUnitMeasure> rStorageProductUnitMeasureListFromJson(
  List? rStorageProductUnitMeasure, [
  List<enums.RStorageProductUnitMeasure>? defaultValue,
]) {
  if (rStorageProductUnitMeasure == null) {
    return defaultValue ?? [];
  }

  return rStorageProductUnitMeasure
      .map((e) => rStorageProductUnitMeasureFromJson(e.toString()))
      .toList();
}

List<enums.RStorageProductUnitMeasure>?
    rStorageProductUnitMeasureNullableListFromJson(
  List? rStorageProductUnitMeasure, [
  List<enums.RStorageProductUnitMeasure>? defaultValue,
]) {
  if (rStorageProductUnitMeasure == null) {
    return defaultValue;
  }

  return rStorageProductUnitMeasure
      .map((e) => rStorageProductUnitMeasureFromJson(e.toString()))
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

String? workstationWorkstationStatusToJson(
    enums.WorkstationWorkstationStatus? workstationWorkstationStatus) {
  return enums.$WorkstationWorkstationStatusMap[workstationWorkstationStatus];
}

enums.WorkstationWorkstationStatus workstationWorkstationStatusFromJson(
  Object? workstationWorkstationStatus, [
  enums.WorkstationWorkstationStatus? defaultValue,
]) {
  if (workstationWorkstationStatus is String) {
    return enums.$WorkstationWorkstationStatusMap.entries
        .firstWhere(
            (element) =>
                element.value.toLowerCase() ==
                workstationWorkstationStatus.toLowerCase(),
            orElse: () => const MapEntry(
                enums.WorkstationWorkstationStatus.swaggerGeneratedUnknown, ''))
        .key;
  }

  final parsedResult = defaultValue == null
      ? null
      : enums.$WorkstationWorkstationStatusMap.entries
          .firstWhereOrNull((element) => element.value == defaultValue)
          ?.key;

  return parsedResult ??
      defaultValue ??
      enums.WorkstationWorkstationStatus.swaggerGeneratedUnknown;
}

List<String> workstationWorkstationStatusListToJson(
    List<enums.WorkstationWorkstationStatus>? workstationWorkstationStatus) {
  if (workstationWorkstationStatus == null) {
    return [];
  }

  return workstationWorkstationStatus
      .map((e) => enums.$WorkstationWorkstationStatusMap[e]!)
      .toList();
}

List<enums.WorkstationWorkstationStatus>
    workstationWorkstationStatusListFromJson(
  List? workstationWorkstationStatus, [
  List<enums.WorkstationWorkstationStatus>? defaultValue,
]) {
  if (workstationWorkstationStatus == null) {
    return defaultValue ?? [];
  }

  return workstationWorkstationStatus
      .map((e) => workstationWorkstationStatusFromJson(e.toString()))
      .toList();
}

List<enums.WorkstationWorkstationStatus>?
    workstationWorkstationStatusNullableListFromJson(
  List? workstationWorkstationStatus, [
  List<enums.WorkstationWorkstationStatus>? defaultValue,
]) {
  if (workstationWorkstationStatus == null) {
    return defaultValue;
  }

  return workstationWorkstationStatus
      .map((e) => workstationWorkstationStatusFromJson(e.toString()))
      .toList();
}

String? workstationWorkstationTypeToJson(
    enums.WorkstationWorkstationType? workstationWorkstationType) {
  return enums.$WorkstationWorkstationTypeMap[workstationWorkstationType];
}

enums.WorkstationWorkstationType workstationWorkstationTypeFromJson(
  Object? workstationWorkstationType, [
  enums.WorkstationWorkstationType? defaultValue,
]) {
  if (workstationWorkstationType is String) {
    return enums.$WorkstationWorkstationTypeMap.entries
        .firstWhere(
            (element) =>
                element.value.toLowerCase() ==
                workstationWorkstationType.toLowerCase(),
            orElse: () => const MapEntry(
                enums.WorkstationWorkstationType.swaggerGeneratedUnknown, ''))
        .key;
  }

  final parsedResult = defaultValue == null
      ? null
      : enums.$WorkstationWorkstationTypeMap.entries
          .firstWhereOrNull((element) => element.value == defaultValue)
          ?.key;

  return parsedResult ??
      defaultValue ??
      enums.WorkstationWorkstationType.swaggerGeneratedUnknown;
}

List<String> workstationWorkstationTypeListToJson(
    List<enums.WorkstationWorkstationType>? workstationWorkstationType) {
  if (workstationWorkstationType == null) {
    return [];
  }

  return workstationWorkstationType
      .map((e) => enums.$WorkstationWorkstationTypeMap[e]!)
      .toList();
}

List<enums.WorkstationWorkstationType> workstationWorkstationTypeListFromJson(
  List? workstationWorkstationType, [
  List<enums.WorkstationWorkstationType>? defaultValue,
]) {
  if (workstationWorkstationType == null) {
    return defaultValue ?? [];
  }

  return workstationWorkstationType
      .map((e) => workstationWorkstationTypeFromJson(e.toString()))
      .toList();
}

List<enums.WorkstationWorkstationType>?
    workstationWorkstationTypeNullableListFromJson(
  List? workstationWorkstationType, [
  List<enums.WorkstationWorkstationType>? defaultValue,
]) {
  if (workstationWorkstationType == null) {
    return defaultValue;
  }

  return workstationWorkstationType
      .map((e) => workstationWorkstationTypeFromJson(e.toString()))
      .toList();
}

String? orderEntityOrderStatusToJson(
    enums.OrderEntityOrderStatus? orderEntityOrderStatus) {
  return enums.$OrderEntityOrderStatusMap[orderEntityOrderStatus];
}

enums.OrderEntityOrderStatus orderEntityOrderStatusFromJson(
  Object? orderEntityOrderStatus, [
  enums.OrderEntityOrderStatus? defaultValue,
]) {
  if (orderEntityOrderStatus is String) {
    return enums.$OrderEntityOrderStatusMap.entries
        .firstWhere(
            (element) =>
                element.value.toLowerCase() ==
                orderEntityOrderStatus.toLowerCase(),
            orElse: () => const MapEntry(
                enums.OrderEntityOrderStatus.swaggerGeneratedUnknown, ''))
        .key;
  }

  final parsedResult = defaultValue == null
      ? null
      : enums.$OrderEntityOrderStatusMap.entries
          .firstWhereOrNull((element) => element.value == defaultValue)
          ?.key;

  return parsedResult ??
      defaultValue ??
      enums.OrderEntityOrderStatus.swaggerGeneratedUnknown;
}

List<String> orderEntityOrderStatusListToJson(
    List<enums.OrderEntityOrderStatus>? orderEntityOrderStatus) {
  if (orderEntityOrderStatus == null) {
    return [];
  }

  return orderEntityOrderStatus
      .map((e) => enums.$OrderEntityOrderStatusMap[e]!)
      .toList();
}

List<enums.OrderEntityOrderStatus> orderEntityOrderStatusListFromJson(
  List? orderEntityOrderStatus, [
  List<enums.OrderEntityOrderStatus>? defaultValue,
]) {
  if (orderEntityOrderStatus == null) {
    return defaultValue ?? [];
  }

  return orderEntityOrderStatus
      .map((e) => orderEntityOrderStatusFromJson(e.toString()))
      .toList();
}

List<enums.OrderEntityOrderStatus>? orderEntityOrderStatusNullableListFromJson(
  List? orderEntityOrderStatus, [
  List<enums.OrderEntityOrderStatus>? defaultValue,
]) {
  if (orderEntityOrderStatus == null) {
    return defaultValue;
  }

  return orderEntityOrderStatus
      .map((e) => orderEntityOrderStatusFromJson(e.toString()))
      .toList();
}

String? branchUserPriviledgeToJson(
    enums.BranchUserPriviledge? branchUserPriviledge) {
  return enums.$BranchUserPriviledgeMap[branchUserPriviledge];
}

enums.BranchUserPriviledge branchUserPriviledgeFromJson(
  Object? branchUserPriviledge, [
  enums.BranchUserPriviledge? defaultValue,
]) {
  if (branchUserPriviledge is String) {
    return enums.$BranchUserPriviledgeMap.entries
        .firstWhere(
            (element) =>
                element.value.toLowerCase() ==
                branchUserPriviledge.toLowerCase(),
            orElse: () => const MapEntry(
                enums.BranchUserPriviledge.swaggerGeneratedUnknown, ''))
        .key;
  }

  final parsedResult = defaultValue == null
      ? null
      : enums.$BranchUserPriviledgeMap.entries
          .firstWhereOrNull((element) => element.value == defaultValue)
          ?.key;

  return parsedResult ??
      defaultValue ??
      enums.BranchUserPriviledge.swaggerGeneratedUnknown;
}

List<String> branchUserPriviledgeListToJson(
    List<enums.BranchUserPriviledge>? branchUserPriviledge) {
  if (branchUserPriviledge == null) {
    return [];
  }

  return branchUserPriviledge
      .map((e) => enums.$BranchUserPriviledgeMap[e]!)
      .toList();
}

List<enums.BranchUserPriviledge> branchUserPriviledgeListFromJson(
  List? branchUserPriviledge, [
  List<enums.BranchUserPriviledge>? defaultValue,
]) {
  if (branchUserPriviledge == null) {
    return defaultValue ?? [];
  }

  return branchUserPriviledge
      .map((e) => branchUserPriviledgeFromJson(e.toString()))
      .toList();
}

List<enums.BranchUserPriviledge>? branchUserPriviledgeNullableListFromJson(
  List? branchUserPriviledge, [
  List<enums.BranchUserPriviledge>? defaultValue,
]) {
  if (branchUserPriviledge == null) {
    return defaultValue;
  }

  return branchUserPriviledge
      .map((e) => branchUserPriviledgeFromJson(e.toString()))
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
