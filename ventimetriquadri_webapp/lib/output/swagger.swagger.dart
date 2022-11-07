import 'swagger.models.swagger.dart';
import 'package:chopper/chopper.dart';

import 'client_mapping.dart';
import 'dart:async';
import 'package:chopper/chopper.dart' as chopper;
import 'swagger.enums.swagger.dart' as enums;
export 'swagger.enums.swagger.dart';
export 'swagger.models.swagger.dart';

part 'swagger.swagger.chopper.dart';

// **************************************************************************
// SwaggerChopperGenerator
// **************************************************************************

@ChopperApi()
abstract class Swagger extends ChopperService {
  static Swagger create({
    ChopperClient? client,
    Authenticator? authenticator,
    String? baseUrl,
    Iterable<dynamic>? interceptors,
  }) {
    if (client != null) {
      return _$Swagger(client);
    }

    final newClient = ChopperClient(
        services: [_$Swagger()],
        converter: $JsonSerializableConverter(),
        interceptors: interceptors ?? [],
        authenticator: authenticator,
        baseUrl: baseUrl ??
            'http://servicedbacorp741w.com:8444/ventimetriquadriservice');
    return _$Swagger(newClient);
  }

  ///delete
  ///@param branchId
  ///@param name
  ///@param email
  ///@param vatNumber
  ///@param address
  ///@param city
  ///@param cap
  ///@param phoneNumber
  Future<chopper.Response> apiV1AppBranchesDeleteDelete({
    int? branchId,
    String? name,
    String? email,
    String? vatNumber,
    String? address,
    String? city,
    String? cap,
    String? phoneNumber,
  }) {
    return _apiV1AppBranchesDeleteDelete(
        branchId: branchId,
        name: name,
        email: email,
        vatNumber: vatNumber,
        address: address,
        city: city,
        cap: cap,
        phoneNumber: phoneNumber);
  }

  ///delete
  ///@param branchId
  ///@param name
  ///@param email
  ///@param vatNumber
  ///@param address
  ///@param city
  ///@param cap
  ///@param phoneNumber
  @Delete(path: '/api/v1/app/branches/delete')
  Future<chopper.Response> _apiV1AppBranchesDeleteDelete({
    @Query('branchId') int? branchId,
    @Query('name') String? name,
    @Query('email') String? email,
    @Query('vatNumber') String? vatNumber,
    @Query('address') String? address,
    @Query('city') String? city,
    @Query('cap') String? cap,
    @Query('phoneNumber') String? phoneNumber,
  });

  ///retrieveAll
  Future<chopper.Response<List<Branch>>> apiV1AppBranchesFindallGet() {
    generatedMapping.putIfAbsent(Branch, () => Branch.fromJsonFactory);

    return _apiV1AppBranchesFindallGet();
  }

  ///retrieveAll
  @Get(path: '/api/v1/app/branches/findall')
  Future<chopper.Response<List<Branch>>> _apiV1AppBranchesFindallGet();

  ///retrieveByPhone
  ///@param phone phone
  Future<chopper.Response<Branch>> apiV1AppBranchesFindbyphoneGet(
      {required String? phone}) {
    generatedMapping.putIfAbsent(Branch, () => Branch.fromJsonFactory);

    return _apiV1AppBranchesFindbyphoneGet(phone: phone);
  }

  ///retrieveByPhone
  ///@param phone phone
  @Get(path: '/api/v1/app/branches/findbyphone')
  Future<chopper.Response<Branch>> _apiV1AppBranchesFindbyphoneGet(
      {@Query('phone') required String? phone});

  ///save
  ///@param branchId
  ///@param name
  ///@param email
  ///@param vatNumber
  ///@param address
  ///@param city
  ///@param cap
  ///@param phoneNumber
  Future<chopper.Response> apiV1AppBranchesSavePost({
    int? branchId,
    String? name,
    String? email,
    String? vatNumber,
    String? address,
    String? city,
    String? cap,
    String? phoneNumber,
  }) {
    return _apiV1AppBranchesSavePost(
        branchId: branchId,
        name: name,
        email: email,
        vatNumber: vatNumber,
        address: address,
        city: city,
        cap: cap,
        phoneNumber: phoneNumber);
  }

  ///save
  ///@param branchId
  ///@param name
  ///@param email
  ///@param vatNumber
  ///@param address
  ///@param city
  ///@param cap
  ///@param phoneNumber
  @Post(
    path: '/api/v1/app/branches/save',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1AppBranchesSavePost({
    @Query('branchId') int? branchId,
    @Query('name') String? name,
    @Query('email') String? email,
    @Query('vatNumber') String? vatNumber,
    @Query('address') String? address,
    @Query('city') String? city,
    @Query('cap') String? cap,
    @Query('phoneNumber') String? phoneNumber,
  });

  ///update
  ///@param branchId
  ///@param name
  ///@param email
  ///@param vatNumber
  ///@param address
  ///@param city
  ///@param cap
  ///@param phoneNumber
  Future<chopper.Response> apiV1AppBranchesUpdatePut({
    int? branchId,
    String? name,
    String? email,
    String? vatNumber,
    String? address,
    String? city,
    String? cap,
    String? phoneNumber,
  }) {
    return _apiV1AppBranchesUpdatePut(
        branchId: branchId,
        name: name,
        email: email,
        vatNumber: vatNumber,
        address: address,
        city: city,
        cap: cap,
        phoneNumber: phoneNumber);
  }

  ///update
  ///@param branchId
  ///@param name
  ///@param email
  ///@param vatNumber
  ///@param address
  ///@param city
  ///@param cap
  ///@param phoneNumber
  @Put(
    path: '/api/v1/app/branches/update',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1AppBranchesUpdatePut({
    @Query('branchId') int? branchId,
    @Query('name') String? name,
    @Query('email') String? email,
    @Query('vatNumber') String? vatNumber,
    @Query('address') String? address,
    @Query('city') String? city,
    @Query('cap') String? cap,
    @Query('phoneNumber') String? phoneNumber,
  });

  ///delete
  ///@param eventId
  ///@param name
  ///@param dateEvent
  ///@param dateCreation
  ///@param eventStatus
  ///@param location
  Future<chopper.Response> apiV1AppEventsDeleteDelete({
    int? eventId,
    String? name,
    String? dateEvent,
    String? dateCreation,
    String? eventStatus,
    String? location,
  }) {
    return _apiV1AppEventsDeleteDelete(
        eventId: eventId,
        name: name,
        dateEvent: dateEvent,
        dateCreation: dateCreation,
        eventStatus: eventStatus,
        location: location);
  }

  ///delete
  ///@param eventId
  ///@param name
  ///@param dateEvent
  ///@param dateCreation
  ///@param eventStatus
  ///@param location
  @Delete(path: '/api/v1/app/events/delete')
  Future<chopper.Response> _apiV1AppEventsDeleteDelete({
    @Query('eventId') int? eventId,
    @Query('name') String? name,
    @Query('dateEvent') String? dateEvent,
    @Query('dateCreation') String? dateCreation,
    @Query('eventStatus') String? eventStatus,
    @Query('location') String? location,
  });

  ///delete
  ///@param event.eventId
  ///@param event.name
  ///@param event.dateEvent
  ///@param event.dateCreation
  ///@param event.eventStatus
  ///@param event.location
  ///@param eventExpenceId
  ///@param description
  ///@param amount
  ///@param dateIntert
  Future<chopper.Response> apiV1AppEventsExpencesDeleteDelete({
    int? eventEventId,
    String? eventName,
    String? eventDateEvent,
    String? eventDateCreation,
    String? eventEventStatus,
    String? eventLocation,
    int? eventExpenceId,
    String? description,
    num? amount,
    String? dateIntert,
  }) {
    return _apiV1AppEventsExpencesDeleteDelete(
        eventEventId: eventEventId,
        eventName: eventName,
        eventDateEvent: eventDateEvent,
        eventDateCreation: eventDateCreation,
        eventEventStatus: eventEventStatus,
        eventLocation: eventLocation,
        eventExpenceId: eventExpenceId,
        description: description,
        amount: amount,
        dateIntert: dateIntert);
  }

  ///delete
  ///@param event.eventId
  ///@param event.name
  ///@param event.dateEvent
  ///@param event.dateCreation
  ///@param event.eventStatus
  ///@param event.location
  ///@param eventExpenceId
  ///@param description
  ///@param amount
  ///@param dateIntert
  @Delete(path: '/api/v1/app/events/expences/delete')
  Future<chopper.Response> _apiV1AppEventsExpencesDeleteDelete({
    @Query('event.eventId') int? eventEventId,
    @Query('event.name') String? eventName,
    @Query('event.dateEvent') String? eventDateEvent,
    @Query('event.dateCreation') String? eventDateCreation,
    @Query('event.eventStatus') String? eventEventStatus,
    @Query('event.location') String? eventLocation,
    @Query('eventExpenceId') int? eventExpenceId,
    @Query('description') String? description,
    @Query('amount') num? amount,
    @Query('dateIntert') String? dateIntert,
  });

  ///retrieveAll
  Future<chopper.Response<List<EventExpence>>>
      apiV1AppEventsExpencesFindallGet() {
    generatedMapping.putIfAbsent(
        EventExpence, () => EventExpence.fromJsonFactory);

    return _apiV1AppEventsExpencesFindallGet();
  }

  ///retrieveAll
  @Get(path: '/api/v1/app/events/expences/findall')
  Future<chopper.Response<List<EventExpence>>>
      _apiV1AppEventsExpencesFindallGet();

  ///save
  ///@param event.eventId
  ///@param event.name
  ///@param event.dateEvent
  ///@param event.dateCreation
  ///@param event.eventStatus
  ///@param event.location
  ///@param eventExpenceId
  ///@param description
  ///@param amount
  ///@param dateIntert
  Future<chopper.Response> apiV1AppEventsExpencesSavePost({
    int? eventEventId,
    String? eventName,
    String? eventDateEvent,
    String? eventDateCreation,
    String? eventEventStatus,
    String? eventLocation,
    int? eventExpenceId,
    String? description,
    num? amount,
    String? dateIntert,
  }) {
    return _apiV1AppEventsExpencesSavePost(
        eventEventId: eventEventId,
        eventName: eventName,
        eventDateEvent: eventDateEvent,
        eventDateCreation: eventDateCreation,
        eventEventStatus: eventEventStatus,
        eventLocation: eventLocation,
        eventExpenceId: eventExpenceId,
        description: description,
        amount: amount,
        dateIntert: dateIntert);
  }

  ///save
  ///@param event.eventId
  ///@param event.name
  ///@param event.dateEvent
  ///@param event.dateCreation
  ///@param event.eventStatus
  ///@param event.location
  ///@param eventExpenceId
  ///@param description
  ///@param amount
  ///@param dateIntert
  @Post(
    path: '/api/v1/app/events/expences/save',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1AppEventsExpencesSavePost({
    @Query('event.eventId') int? eventEventId,
    @Query('event.name') String? eventName,
    @Query('event.dateEvent') String? eventDateEvent,
    @Query('event.dateCreation') String? eventDateCreation,
    @Query('event.eventStatus') String? eventEventStatus,
    @Query('event.location') String? eventLocation,
    @Query('eventExpenceId') int? eventExpenceId,
    @Query('description') String? description,
    @Query('amount') num? amount,
    @Query('dateIntert') String? dateIntert,
  });

  ///update
  ///@param event.eventId
  ///@param event.name
  ///@param event.dateEvent
  ///@param event.dateCreation
  ///@param event.eventStatus
  ///@param event.location
  ///@param eventExpenceId
  ///@param description
  ///@param amount
  ///@param dateIntert
  Future<chopper.Response> apiV1AppEventsExpencesUpdatePut({
    int? eventEventId,
    String? eventName,
    String? eventDateEvent,
    String? eventDateCreation,
    String? eventEventStatus,
    String? eventLocation,
    int? eventExpenceId,
    String? description,
    num? amount,
    String? dateIntert,
  }) {
    return _apiV1AppEventsExpencesUpdatePut(
        eventEventId: eventEventId,
        eventName: eventName,
        eventDateEvent: eventDateEvent,
        eventDateCreation: eventDateCreation,
        eventEventStatus: eventEventStatus,
        eventLocation: eventLocation,
        eventExpenceId: eventExpenceId,
        description: description,
        amount: amount,
        dateIntert: dateIntert);
  }

  ///update
  ///@param event.eventId
  ///@param event.name
  ///@param event.dateEvent
  ///@param event.dateCreation
  ///@param event.eventStatus
  ///@param event.location
  ///@param eventExpenceId
  ///@param description
  ///@param amount
  ///@param dateIntert
  @Put(
    path: '/api/v1/app/events/expences/update',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1AppEventsExpencesUpdatePut({
    @Query('event.eventId') int? eventEventId,
    @Query('event.name') String? eventName,
    @Query('event.dateEvent') String? eventDateEvent,
    @Query('event.dateCreation') String? eventDateCreation,
    @Query('event.eventStatus') String? eventEventStatus,
    @Query('event.location') String? eventLocation,
    @Query('eventExpenceId') int? eventExpenceId,
    @Query('description') String? description,
    @Query('amount') num? amount,
    @Query('dateIntert') String? dateIntert,
  });

  ///retrieveAll
  Future<chopper.Response<List<Event>>> apiV1AppEventsFindallGet() {
    generatedMapping.putIfAbsent(Event, () => Event.fromJsonFactory);

    return _apiV1AppEventsFindallGet();
  }

  ///retrieveAll
  @Get(path: '/api/v1/app/events/findall')
  Future<chopper.Response<List<Event>>> _apiV1AppEventsFindallGet();

  ///save
  ///@param eventId
  ///@param name
  ///@param dateEvent
  ///@param dateCreation
  ///@param eventStatus
  ///@param location
  Future<chopper.Response> apiV1AppEventsSavePost({
    int? eventId,
    String? name,
    String? dateEvent,
    String? dateCreation,
    String? eventStatus,
    String? location,
  }) {
    return _apiV1AppEventsSavePost(
        eventId: eventId,
        name: name,
        dateEvent: dateEvent,
        dateCreation: dateCreation,
        eventStatus: eventStatus,
        location: location);
  }

  ///save
  ///@param eventId
  ///@param name
  ///@param dateEvent
  ///@param dateCreation
  ///@param eventStatus
  ///@param location
  @Post(
    path: '/api/v1/app/events/save',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1AppEventsSavePost({
    @Query('eventId') int? eventId,
    @Query('name') String? name,
    @Query('dateEvent') String? dateEvent,
    @Query('dateCreation') String? dateCreation,
    @Query('eventStatus') String? eventStatus,
    @Query('location') String? location,
  });

  ///update
  ///@param eventId
  ///@param name
  ///@param dateEvent
  ///@param dateCreation
  ///@param eventStatus
  ///@param location
  Future<chopper.Response> apiV1AppEventsUpdatePut({
    int? eventId,
    String? name,
    String? dateEvent,
    String? dateCreation,
    String? eventStatus,
    String? location,
  }) {
    return _apiV1AppEventsUpdatePut(
        eventId: eventId,
        name: name,
        dateEvent: dateEvent,
        dateCreation: dateCreation,
        eventStatus: eventStatus,
        location: location);
  }

  ///update
  ///@param eventId
  ///@param name
  ///@param dateEvent
  ///@param dateCreation
  ///@param eventStatus
  ///@param location
  @Put(
    path: '/api/v1/app/events/update',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1AppEventsUpdatePut({
    @Query('eventId') int? eventId,
    @Query('name') String? name,
    @Query('dateEvent') String? dateEvent,
    @Query('dateCreation') String? dateCreation,
    @Query('eventStatus') String? eventStatus,
    @Query('location') String? location,
  });

  ///delete
  ///@param supplier.supplierId
  ///@param supplier.name
  ///@param supplier.vatNumber
  ///@param supplier.address
  ///@param supplier.city
  ///@param supplier.cap
  ///@param supplier.phoneNumber
  ///@param supplier.email
  ///@param supplier.pec
  ///@param productId
  ///@param name
  ///@param unitMeasure
  ///@param vatApplied
  ///@param price
  ///@param description
  ///@param category
  Future<chopper.Response> apiV1AppProductsDeleteDelete({
    int? supplierSupplierId,
    String? supplierName,
    String? supplierVatNumber,
    String? supplierAddress,
    String? supplierCity,
    String? supplierCap,
    String? supplierPhoneNumber,
    String? supplierEmail,
    String? supplierPec,
    int? productId,
    String? name,
    String? unitMeasure,
    int? vatApplied,
    num? price,
    String? description,
    String? category,
  }) {
    return _apiV1AppProductsDeleteDelete(
        supplierSupplierId: supplierSupplierId,
        supplierName: supplierName,
        supplierVatNumber: supplierVatNumber,
        supplierAddress: supplierAddress,
        supplierCity: supplierCity,
        supplierCap: supplierCap,
        supplierPhoneNumber: supplierPhoneNumber,
        supplierEmail: supplierEmail,
        supplierPec: supplierPec,
        productId: productId,
        name: name,
        unitMeasure: unitMeasure,
        vatApplied: vatApplied,
        price: price,
        description: description,
        category: category);
  }

  ///delete
  ///@param supplier.supplierId
  ///@param supplier.name
  ///@param supplier.vatNumber
  ///@param supplier.address
  ///@param supplier.city
  ///@param supplier.cap
  ///@param supplier.phoneNumber
  ///@param supplier.email
  ///@param supplier.pec
  ///@param productId
  ///@param name
  ///@param unitMeasure
  ///@param vatApplied
  ///@param price
  ///@param description
  ///@param category
  @Delete(path: '/api/v1/app/products/delete')
  Future<chopper.Response> _apiV1AppProductsDeleteDelete({
    @Query('supplier.supplierId') int? supplierSupplierId,
    @Query('supplier.name') String? supplierName,
    @Query('supplier.vatNumber') String? supplierVatNumber,
    @Query('supplier.address') String? supplierAddress,
    @Query('supplier.city') String? supplierCity,
    @Query('supplier.cap') String? supplierCap,
    @Query('supplier.phoneNumber') String? supplierPhoneNumber,
    @Query('supplier.email') String? supplierEmail,
    @Query('supplier.pec') String? supplierPec,
    @Query('productId') int? productId,
    @Query('name') String? name,
    @Query('unitMeasure') String? unitMeasure,
    @Query('vatApplied') int? vatApplied,
    @Query('price') num? price,
    @Query('description') String? description,
    @Query('category') String? category,
  });

  ///retrieveAll
  Future<chopper.Response<List<Product>>> apiV1AppProductsFindallGet() {
    generatedMapping.putIfAbsent(Product, () => Product.fromJsonFactory);

    return _apiV1AppProductsFindallGet();
  }

  ///retrieveAll
  @Get(path: '/api/v1/app/products/findall')
  Future<chopper.Response<List<Product>>> _apiV1AppProductsFindallGet();

  ///save
  ///@param supplier.supplierId
  ///@param supplier.name
  ///@param supplier.vatNumber
  ///@param supplier.address
  ///@param supplier.city
  ///@param supplier.cap
  ///@param supplier.phoneNumber
  ///@param supplier.email
  ///@param supplier.pec
  ///@param productId
  ///@param name
  ///@param unitMeasure
  ///@param vatApplied
  ///@param price
  ///@param description
  ///@param category
  Future<chopper.Response> apiV1AppProductsSavePost({
    int? supplierSupplierId,
    String? supplierName,
    String? supplierVatNumber,
    String? supplierAddress,
    String? supplierCity,
    String? supplierCap,
    String? supplierPhoneNumber,
    String? supplierEmail,
    String? supplierPec,
    int? productId,
    String? name,
    String? unitMeasure,
    int? vatApplied,
    num? price,
    String? description,
    String? category,
  }) {
    return _apiV1AppProductsSavePost(
        supplierSupplierId: supplierSupplierId,
        supplierName: supplierName,
        supplierVatNumber: supplierVatNumber,
        supplierAddress: supplierAddress,
        supplierCity: supplierCity,
        supplierCap: supplierCap,
        supplierPhoneNumber: supplierPhoneNumber,
        supplierEmail: supplierEmail,
        supplierPec: supplierPec,
        productId: productId,
        name: name,
        unitMeasure: unitMeasure,
        vatApplied: vatApplied,
        price: price,
        description: description,
        category: category);
  }

  ///save
  ///@param supplier.supplierId
  ///@param supplier.name
  ///@param supplier.vatNumber
  ///@param supplier.address
  ///@param supplier.city
  ///@param supplier.cap
  ///@param supplier.phoneNumber
  ///@param supplier.email
  ///@param supplier.pec
  ///@param productId
  ///@param name
  ///@param unitMeasure
  ///@param vatApplied
  ///@param price
  ///@param description
  ///@param category
  @Post(
    path: '/api/v1/app/products/save',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1AppProductsSavePost({
    @Query('supplier.supplierId') int? supplierSupplierId,
    @Query('supplier.name') String? supplierName,
    @Query('supplier.vatNumber') String? supplierVatNumber,
    @Query('supplier.address') String? supplierAddress,
    @Query('supplier.city') String? supplierCity,
    @Query('supplier.cap') String? supplierCap,
    @Query('supplier.phoneNumber') String? supplierPhoneNumber,
    @Query('supplier.email') String? supplierEmail,
    @Query('supplier.pec') String? supplierPec,
    @Query('productId') int? productId,
    @Query('name') String? name,
    @Query('unitMeasure') String? unitMeasure,
    @Query('vatApplied') int? vatApplied,
    @Query('price') num? price,
    @Query('description') String? description,
    @Query('category') String? category,
  });

  ///update
  ///@param supplier.supplierId
  ///@param supplier.name
  ///@param supplier.vatNumber
  ///@param supplier.address
  ///@param supplier.city
  ///@param supplier.cap
  ///@param supplier.phoneNumber
  ///@param supplier.email
  ///@param supplier.pec
  ///@param productId
  ///@param name
  ///@param unitMeasure
  ///@param vatApplied
  ///@param price
  ///@param description
  ///@param category
  Future<chopper.Response> apiV1AppProductsUpdatePut({
    int? supplierSupplierId,
    String? supplierName,
    String? supplierVatNumber,
    String? supplierAddress,
    String? supplierCity,
    String? supplierCap,
    String? supplierPhoneNumber,
    String? supplierEmail,
    String? supplierPec,
    int? productId,
    String? name,
    String? unitMeasure,
    int? vatApplied,
    num? price,
    String? description,
    String? category,
  }) {
    return _apiV1AppProductsUpdatePut(
        supplierSupplierId: supplierSupplierId,
        supplierName: supplierName,
        supplierVatNumber: supplierVatNumber,
        supplierAddress: supplierAddress,
        supplierCity: supplierCity,
        supplierCap: supplierCap,
        supplierPhoneNumber: supplierPhoneNumber,
        supplierEmail: supplierEmail,
        supplierPec: supplierPec,
        productId: productId,
        name: name,
        unitMeasure: unitMeasure,
        vatApplied: vatApplied,
        price: price,
        description: description,
        category: category);
  }

  ///update
  ///@param supplier.supplierId
  ///@param supplier.name
  ///@param supplier.vatNumber
  ///@param supplier.address
  ///@param supplier.city
  ///@param supplier.cap
  ///@param supplier.phoneNumber
  ///@param supplier.email
  ///@param supplier.pec
  ///@param productId
  ///@param name
  ///@param unitMeasure
  ///@param vatApplied
  ///@param price
  ///@param description
  ///@param category
  @Put(
    path: '/api/v1/app/products/update',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1AppProductsUpdatePut({
    @Query('supplier.supplierId') int? supplierSupplierId,
    @Query('supplier.name') String? supplierName,
    @Query('supplier.vatNumber') String? supplierVatNumber,
    @Query('supplier.address') String? supplierAddress,
    @Query('supplier.city') String? supplierCity,
    @Query('supplier.cap') String? supplierCap,
    @Query('supplier.phoneNumber') String? supplierPhoneNumber,
    @Query('supplier.email') String? supplierEmail,
    @Query('supplier.pec') String? supplierPec,
    @Query('productId') int? productId,
    @Query('name') String? name,
    @Query('unitMeasure') String? unitMeasure,
    @Query('vatApplied') int? vatApplied,
    @Query('price') num? price,
    @Query('description') String? description,
    @Query('category') String? category,
  });

  ///delete
  ///@param storageId
  ///@param name
  ///@param creationDate
  ///@param address
  ///@param city
  ///@param cap
  Future<chopper.Response> apiV1AppStorageDeleteDelete({
    int? storageId,
    String? name,
    String? creationDate,
    String? address,
    String? city,
    int? cap,
  }) {
    return _apiV1AppStorageDeleteDelete(
        storageId: storageId,
        name: name,
        creationDate: creationDate,
        address: address,
        city: city,
        cap: cap);
  }

  ///delete
  ///@param storageId
  ///@param name
  ///@param creationDate
  ///@param address
  ///@param city
  ///@param cap
  @Delete(path: '/api/v1/app/storage/delete')
  Future<chopper.Response> _apiV1AppStorageDeleteDelete({
    @Query('storageId') int? storageId,
    @Query('name') String? name,
    @Query('creationDate') String? creationDate,
    @Query('address') String? address,
    @Query('city') String? city,
    @Query('cap') int? cap,
  });

  ///retrieveAll
  Future<chopper.Response<List<Storage>>> apiV1AppStorageFindallGet() {
    generatedMapping.putIfAbsent(Storage, () => Storage.fromJsonFactory);

    return _apiV1AppStorageFindallGet();
  }

  ///retrieveAll
  @Get(path: '/api/v1/app/storage/findall')
  Future<chopper.Response<List<Storage>>> _apiV1AppStorageFindallGet();

  ///save
  ///@param storageId
  ///@param name
  ///@param creationDate
  ///@param address
  ///@param city
  ///@param cap
  Future<chopper.Response> apiV1AppStorageSavePost({
    int? storageId,
    String? name,
    String? creationDate,
    String? address,
    String? city,
    int? cap,
  }) {
    return _apiV1AppStorageSavePost(
        storageId: storageId,
        name: name,
        creationDate: creationDate,
        address: address,
        city: city,
        cap: cap);
  }

  ///save
  ///@param storageId
  ///@param name
  ///@param creationDate
  ///@param address
  ///@param city
  ///@param cap
  @Post(
    path: '/api/v1/app/storage/save',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1AppStorageSavePost({
    @Query('storageId') int? storageId,
    @Query('name') String? name,
    @Query('creationDate') String? creationDate,
    @Query('address') String? address,
    @Query('city') String? city,
    @Query('cap') int? cap,
  });

  ///update
  ///@param storageId
  ///@param name
  ///@param creationDate
  ///@param address
  ///@param city
  ///@param cap
  Future<chopper.Response> apiV1AppStorageUpdatePut({
    int? storageId,
    String? name,
    String? creationDate,
    String? address,
    String? city,
    int? cap,
  }) {
    return _apiV1AppStorageUpdatePut(
        storageId: storageId,
        name: name,
        creationDate: creationDate,
        address: address,
        city: city,
        cap: cap);
  }

  ///update
  ///@param storageId
  ///@param name
  ///@param creationDate
  ///@param address
  ///@param city
  ///@param cap
  @Put(
    path: '/api/v1/app/storage/update',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1AppStorageUpdatePut({
    @Query('storageId') int? storageId,
    @Query('name') String? name,
    @Query('creationDate') String? creationDate,
    @Query('address') String? address,
    @Query('city') String? city,
    @Query('cap') int? cap,
  });

  ///delete
  ///@param supplierId
  ///@param name
  ///@param vatNumber
  ///@param address
  ///@param city
  ///@param cap
  ///@param phoneNumber
  ///@param email
  ///@param pec
  Future<chopper.Response> apiV1AppSuppliersDeleteDelete({
    int? supplierId,
    String? name,
    String? vatNumber,
    String? address,
    String? city,
    String? cap,
    String? phoneNumber,
    String? email,
    String? pec,
  }) {
    return _apiV1AppSuppliersDeleteDelete(
        supplierId: supplierId,
        name: name,
        vatNumber: vatNumber,
        address: address,
        city: city,
        cap: cap,
        phoneNumber: phoneNumber,
        email: email,
        pec: pec);
  }

  ///delete
  ///@param supplierId
  ///@param name
  ///@param vatNumber
  ///@param address
  ///@param city
  ///@param cap
  ///@param phoneNumber
  ///@param email
  ///@param pec
  @Delete(path: '/api/v1/app/suppliers/delete')
  Future<chopper.Response> _apiV1AppSuppliersDeleteDelete({
    @Query('supplierId') int? supplierId,
    @Query('name') String? name,
    @Query('vatNumber') String? vatNumber,
    @Query('address') String? address,
    @Query('city') String? city,
    @Query('cap') String? cap,
    @Query('phoneNumber') String? phoneNumber,
    @Query('email') String? email,
    @Query('pec') String? pec,
  });

  ///retrieveAll
  Future<chopper.Response<List<Supplier>>> apiV1AppSuppliersFindallGet() {
    generatedMapping.putIfAbsent(Supplier, () => Supplier.fromJsonFactory);

    return _apiV1AppSuppliersFindallGet();
  }

  ///retrieveAll
  @Get(path: '/api/v1/app/suppliers/findall')
  Future<chopper.Response<List<Supplier>>> _apiV1AppSuppliersFindallGet();

  ///retrieveByPhone
  ///@param phone phone
  Future<chopper.Response<Supplier>> apiV1AppSuppliersFindbyphoneGet(
      {required String? phone}) {
    generatedMapping.putIfAbsent(Supplier, () => Supplier.fromJsonFactory);

    return _apiV1AppSuppliersFindbyphoneGet(phone: phone);
  }

  ///retrieveByPhone
  ///@param phone phone
  @Get(path: '/api/v1/app/suppliers/findbyphone')
  Future<chopper.Response<Supplier>> _apiV1AppSuppliersFindbyphoneGet(
      {@Query('phone') required String? phone});

  ///save
  ///@param supplierId
  ///@param name
  ///@param vatNumber
  ///@param address
  ///@param city
  ///@param cap
  ///@param phoneNumber
  ///@param email
  ///@param pec
  Future<chopper.Response> apiV1AppSuppliersSavePost({
    int? supplierId,
    String? name,
    String? vatNumber,
    String? address,
    String? city,
    String? cap,
    String? phoneNumber,
    String? email,
    String? pec,
  }) {
    return _apiV1AppSuppliersSavePost(
        supplierId: supplierId,
        name: name,
        vatNumber: vatNumber,
        address: address,
        city: city,
        cap: cap,
        phoneNumber: phoneNumber,
        email: email,
        pec: pec);
  }

  ///save
  ///@param supplierId
  ///@param name
  ///@param vatNumber
  ///@param address
  ///@param city
  ///@param cap
  ///@param phoneNumber
  ///@param email
  ///@param pec
  @Post(
    path: '/api/v1/app/suppliers/save',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1AppSuppliersSavePost({
    @Query('supplierId') int? supplierId,
    @Query('name') String? name,
    @Query('vatNumber') String? vatNumber,
    @Query('address') String? address,
    @Query('city') String? city,
    @Query('cap') String? cap,
    @Query('phoneNumber') String? phoneNumber,
    @Query('email') String? email,
    @Query('pec') String? pec,
  });

  ///update
  ///@param supplierId
  ///@param name
  ///@param vatNumber
  ///@param address
  ///@param city
  ///@param cap
  ///@param phoneNumber
  ///@param email
  ///@param pec
  Future<chopper.Response> apiV1AppSuppliersUpdatePut({
    int? supplierId,
    String? name,
    String? vatNumber,
    String? address,
    String? city,
    String? cap,
    String? phoneNumber,
    String? email,
    String? pec,
  }) {
    return _apiV1AppSuppliersUpdatePut(
        supplierId: supplierId,
        name: name,
        vatNumber: vatNumber,
        address: address,
        city: city,
        cap: cap,
        phoneNumber: phoneNumber,
        email: email,
        pec: pec);
  }

  ///update
  ///@param supplierId
  ///@param name
  ///@param vatNumber
  ///@param address
  ///@param city
  ///@param cap
  ///@param phoneNumber
  ///@param email
  ///@param pec
  @Put(
    path: '/api/v1/app/suppliers/update',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1AppSuppliersUpdatePut({
    @Query('supplierId') int? supplierId,
    @Query('name') String? name,
    @Query('vatNumber') String? vatNumber,
    @Query('address') String? address,
    @Query('city') String? city,
    @Query('cap') String? cap,
    @Query('phoneNumber') String? phoneNumber,
    @Query('email') String? email,
    @Query('pec') String? pec,
  });

  ///delete
  ///@param userId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  Future<chopper.Response> apiV1AppUsersDeleteDelete({
    int? userId,
    String? name,
    String? lastname,
    String? email,
    String? phoneNumber,
  }) {
    return _apiV1AppUsersDeleteDelete(
        userId: userId,
        name: name,
        lastname: lastname,
        email: email,
        phoneNumber: phoneNumber);
  }

  ///delete
  ///@param userId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  @Delete(path: '/api/v1/app/users/delete')
  Future<chopper.Response> _apiV1AppUsersDeleteDelete({
    @Query('userId') int? userId,
    @Query('name') String? name,
    @Query('lastname') String? lastname,
    @Query('email') String? email,
    @Query('phoneNumber') String? phoneNumber,
  });

  ///retrieveAll
  Future<chopper.Response<List<UserEntity>>> apiV1AppUsersFindallGet() {
    generatedMapping.putIfAbsent(UserEntity, () => UserEntity.fromJsonFactory);

    return _apiV1AppUsersFindallGet();
  }

  ///retrieveAll
  @Get(path: '/api/v1/app/users/findall')
  Future<chopper.Response<List<UserEntity>>> _apiV1AppUsersFindallGet();

  ///save
  ///@param userId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  Future<chopper.Response> apiV1AppUsersSavePost({
    int? userId,
    String? name,
    String? lastname,
    String? email,
    String? phoneNumber,
  }) {
    return _apiV1AppUsersSavePost(
        userId: userId,
        name: name,
        lastname: lastname,
        email: email,
        phoneNumber: phoneNumber);
  }

  ///save
  ///@param userId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  @Post(
    path: '/api/v1/app/users/save',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1AppUsersSavePost({
    @Query('userId') int? userId,
    @Query('name') String? name,
    @Query('lastname') String? lastname,
    @Query('email') String? email,
    @Query('phoneNumber') String? phoneNumber,
  });

  ///update
  ///@param userId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  Future<chopper.Response> apiV1AppUsersUpdatePut({
    int? userId,
    String? name,
    String? lastname,
    String? email,
    String? phoneNumber,
  }) {
    return _apiV1AppUsersUpdatePut(
        userId: userId,
        name: name,
        lastname: lastname,
        email: email,
        phoneNumber: phoneNumber);
  }

  ///update
  ///@param userId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  @Put(
    path: '/api/v1/app/users/update',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1AppUsersUpdatePut({
    @Query('userId') int? userId,
    @Query('name') String? name,
    @Query('lastname') String? lastname,
    @Query('email') String? email,
    @Query('phoneNumber') String? phoneNumber,
  });

  ///delete
  ///@param customerId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  ///@param dob
  ///@param treatmentPersonalData
  ///@param branch20m2
  ///@param accessCounter
  Future<chopper.Response> apiV1WebsiteCustomersDeleteDelete({
    int? customerId,
    String? name,
    String? lastname,
    String? email,
    String? phoneNumber,
    String? dob,
    bool? treatmentPersonalData,
    String? branch20m2,
    int? accessCounter,
  }) {
    return _apiV1WebsiteCustomersDeleteDelete(
        customerId: customerId,
        name: name,
        lastname: lastname,
        email: email,
        phoneNumber: phoneNumber,
        dob: dob,
        treatmentPersonalData: treatmentPersonalData,
        branch20m2: branch20m2,
        accessCounter: accessCounter);
  }

  ///delete
  ///@param customerId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  ///@param dob
  ///@param treatmentPersonalData
  ///@param branch20m2
  ///@param accessCounter
  @Delete(path: '/api/v1/website/customers/delete')
  Future<chopper.Response> _apiV1WebsiteCustomersDeleteDelete({
    @Query('customerId') int? customerId,
    @Query('name') String? name,
    @Query('lastname') String? lastname,
    @Query('email') String? email,
    @Query('phoneNumber') String? phoneNumber,
    @Query('dob') String? dob,
    @Query('treatmentPersonalData') bool? treatmentPersonalData,
    @Query('branch20m2') String? branch20m2,
    @Query('accessCounter') int? accessCounter,
  });

  ///retrieveAll
  Future<chopper.Response<List<Customers>>> apiV1WebsiteCustomersFindallGet() {
    generatedMapping.putIfAbsent(Customers, () => Customers.fromJsonFactory);

    return _apiV1WebsiteCustomersFindallGet();
  }

  ///retrieveAll
  @Get(path: '/api/v1/website/customers/findall')
  Future<chopper.Response<List<Customers>>> _apiV1WebsiteCustomersFindallGet();

  ///retrieveByPhone
  ///@param phone phone
  Future<chopper.Response<Customers>> apiV1WebsiteCustomersFindbyphoneGet(
      {required String? phone}) {
    generatedMapping.putIfAbsent(Customers, () => Customers.fromJsonFactory);

    return _apiV1WebsiteCustomersFindbyphoneGet(phone: phone);
  }

  ///retrieveByPhone
  ///@param phone phone
  @Get(path: '/api/v1/website/customers/findbyphone')
  Future<chopper.Response<Customers>> _apiV1WebsiteCustomersFindbyphoneGet(
      {@Query('phone') required String? phone});

  ///save
  ///@param customerId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  ///@param dob
  ///@param treatmentPersonalData
  ///@param branch20m2
  ///@param accessCounter
  Future<chopper.Response> apiV1WebsiteCustomersSavePost({
    int? customerId,
    String? name,
    String? lastname,
    String? email,
    String? phoneNumber,
    String? dob,
    bool? treatmentPersonalData,
    String? branch20m2,
    int? accessCounter,
  }) {
    return _apiV1WebsiteCustomersSavePost(
        customerId: customerId,
        name: name,
        lastname: lastname,
        email: email,
        phoneNumber: phoneNumber,
        dob: dob,
        treatmentPersonalData: treatmentPersonalData,
        branch20m2: branch20m2,
        accessCounter: accessCounter);
  }

  ///save
  ///@param customerId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  ///@param dob
  ///@param treatmentPersonalData
  ///@param branch20m2
  ///@param accessCounter
  @Post(
    path: '/api/v1/website/customers/save',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1WebsiteCustomersSavePost({
    @Query('customerId') int? customerId,
    @Query('name') String? name,
    @Query('lastname') String? lastname,
    @Query('email') String? email,
    @Query('phoneNumber') String? phoneNumber,
    @Query('dob') String? dob,
    @Query('treatmentPersonalData') bool? treatmentPersonalData,
    @Query('branch20m2') String? branch20m2,
    @Query('accessCounter') int? accessCounter,
  });

  ///update
  ///@param customerId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  ///@param dob
  ///@param treatmentPersonalData
  ///@param branch20m2
  ///@param accessCounter
  Future<chopper.Response> apiV1WebsiteCustomersUpdatePut({
    int? customerId,
    String? name,
    String? lastname,
    String? email,
    String? phoneNumber,
    String? dob,
    bool? treatmentPersonalData,
    String? branch20m2,
    int? accessCounter,
  }) {
    return _apiV1WebsiteCustomersUpdatePut(
        customerId: customerId,
        name: name,
        lastname: lastname,
        email: email,
        phoneNumber: phoneNumber,
        dob: dob,
        treatmentPersonalData: treatmentPersonalData,
        branch20m2: branch20m2,
        accessCounter: accessCounter);
  }

  ///update
  ///@param customerId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  ///@param dob
  ///@param treatmentPersonalData
  ///@param branch20m2
  ///@param accessCounter
  @Put(
    path: '/api/v1/website/customers/update',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1WebsiteCustomersUpdatePut({
    @Query('customerId') int? customerId,
    @Query('name') String? name,
    @Query('lastname') String? lastname,
    @Query('email') String? email,
    @Query('phoneNumber') String? phoneNumber,
    @Query('dob') String? dob,
    @Query('treatmentPersonalData') bool? treatmentPersonalData,
    @Query('branch20m2') String? branch20m2,
    @Query('accessCounter') int? accessCounter,
  });
}

typedef $JsonFactory<T> = T Function(Map<String, dynamic> json);

class $CustomJsonDecoder {
  $CustomJsonDecoder(this.factories);

  final Map<Type, $JsonFactory> factories;

  dynamic decode<T>(dynamic entity) {
    if (entity is Iterable) {
      return _decodeList<T>(entity);
    }

    if (entity is T) {
      return entity;
    }

    if (isTypeOf<T, Map>()) {
      return entity;
    }

    if (isTypeOf<T, Iterable>()) {
      return entity;
    }

    if (entity is Map<String, dynamic>) {
      return _decodeMap<T>(entity);
    }

    return entity;
  }

  T _decodeMap<T>(Map<String, dynamic> values) {
    final jsonFactory = factories[T];
    if (jsonFactory == null || jsonFactory is! $JsonFactory<T>) {
      return throw "Could not find factory for type $T. Is '$T: $T.fromJsonFactory' included in the CustomJsonDecoder instance creation in bootstrapper.dart?";
    }

    return jsonFactory(values);
  }

  List<T> _decodeList<T>(Iterable values) =>
      values.where((v) => v != null).map<T>((v) => decode<T>(v) as T).toList();
}

class $JsonSerializableConverter extends chopper.JsonConverter {
  @override
  FutureOr<chopper.Response<ResultType>> convertResponse<ResultType, Item>(
      chopper.Response response) async {
    if (response.bodyString.isEmpty) {
      // In rare cases, when let's say 204 (no content) is returned -
      // we cannot decode the missing json with the result type specified
      return chopper.Response(response.base, null, error: response.error);
    }

    final jsonRes = await super.convertResponse(response);
    return jsonRes.copyWith<ResultType>(
        body: $jsonDecoder.decode<Item>(jsonRes.body) as ResultType);
  }
}

final $jsonDecoder = $CustomJsonDecoder(generatedMapping);
