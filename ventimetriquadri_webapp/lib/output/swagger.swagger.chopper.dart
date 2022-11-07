//Generated code

part of 'swagger.swagger.dart';

// **************************************************************************
// ChopperGenerator
// **************************************************************************

// ignore_for_file: always_put_control_body_on_new_line, always_specify_types, prefer_const_declarations, unnecessary_brace_in_string_interps
class _$Swagger extends Swagger {
  _$Swagger([ChopperClient? client]) {
    if (client == null) return;
    this.client = client;
  }

  @override
  final definitionType = Swagger;

  @override
  Future<Response<dynamic>> _apiV1AppBranchesDeleteDelete({
    int? branchId,
    String? name,
    String? email,
    String? vatNumber,
    String? address,
    String? city,
    String? cap,
    String? phoneNumber,
  }) {
    final String $url = '/api/v1/app/branches/delete';
    final Map<String, dynamic> $params = <String, dynamic>{
      'branchId': branchId,
      'name': name,
      'email': email,
      'vatNumber': vatNumber,
      'address': address,
      'city': city,
      'cap': cap,
      'phoneNumber': phoneNumber,
    };
    final Request $request = Request(
      'DELETE',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<List<Branch>>> _apiV1AppBranchesFindallGet() {
    final String $url = '/api/v1/app/branches/findall';
    final Request $request = Request(
      'GET',
      $url,
      client.baseUrl,
    );
    return client.send<List<Branch>, Branch>($request);
  }

  @override
  Future<Response<Branch>> _apiV1AppBranchesFindbyphoneGet(
      {required String? phone}) {
    final String $url = '/api/v1/app/branches/findbyphone';
    final Map<String, dynamic> $params = <String, dynamic>{'phone': phone};
    final Request $request = Request(
      'GET',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<Branch, Branch>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppBranchesSavePost({
    int? branchId,
    String? name,
    String? email,
    String? vatNumber,
    String? address,
    String? city,
    String? cap,
    String? phoneNumber,
  }) {
    final String $url = '/api/v1/app/branches/save';
    final Map<String, dynamic> $params = <String, dynamic>{
      'branchId': branchId,
      'name': name,
      'email': email,
      'vatNumber': vatNumber,
      'address': address,
      'city': city,
      'cap': cap,
      'phoneNumber': phoneNumber,
    };
    final Request $request = Request(
      'POST',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppBranchesUpdatePut({
    int? branchId,
    String? name,
    String? email,
    String? vatNumber,
    String? address,
    String? city,
    String? cap,
    String? phoneNumber,
  }) {
    final String $url = '/api/v1/app/branches/update';
    final Map<String, dynamic> $params = <String, dynamic>{
      'branchId': branchId,
      'name': name,
      'email': email,
      'vatNumber': vatNumber,
      'address': address,
      'city': city,
      'cap': cap,
      'phoneNumber': phoneNumber,
    };
    final Request $request = Request(
      'PUT',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppEventsDeleteDelete({
    int? eventId,
    String? name,
    String? dateEvent,
    String? dateCreation,
    String? eventStatus,
    String? location,
  }) {
    final String $url = '/api/v1/app/events/delete';
    final Map<String, dynamic> $params = <String, dynamic>{
      'eventId': eventId,
      'name': name,
      'dateEvent': dateEvent,
      'dateCreation': dateCreation,
      'eventStatus': eventStatus,
      'location': location,
    };
    final Request $request = Request(
      'DELETE',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppEventsExpencesDeleteDelete({
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
    final String $url = '/api/v1/app/events/expences/delete';
    final Map<String, dynamic> $params = <String, dynamic>{
      'event.eventId': eventEventId,
      'event.name': eventName,
      'event.dateEvent': eventDateEvent,
      'event.dateCreation': eventDateCreation,
      'event.eventStatus': eventEventStatus,
      'event.location': eventLocation,
      'eventExpenceId': eventExpenceId,
      'description': description,
      'amount': amount,
      'dateIntert': dateIntert,
    };
    final Request $request = Request(
      'DELETE',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<List<EventExpence>>> _apiV1AppEventsExpencesFindallGet() {
    final String $url = '/api/v1/app/events/expences/findall';
    final Request $request = Request(
      'GET',
      $url,
      client.baseUrl,
    );
    return client.send<List<EventExpence>, EventExpence>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppEventsExpencesSavePost({
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
    final String $url = '/api/v1/app/events/expences/save';
    final Map<String, dynamic> $params = <String, dynamic>{
      'event.eventId': eventEventId,
      'event.name': eventName,
      'event.dateEvent': eventDateEvent,
      'event.dateCreation': eventDateCreation,
      'event.eventStatus': eventEventStatus,
      'event.location': eventLocation,
      'eventExpenceId': eventExpenceId,
      'description': description,
      'amount': amount,
      'dateIntert': dateIntert,
    };
    final Request $request = Request(
      'POST',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppEventsExpencesUpdatePut({
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
    final String $url = '/api/v1/app/events/expences/update';
    final Map<String, dynamic> $params = <String, dynamic>{
      'event.eventId': eventEventId,
      'event.name': eventName,
      'event.dateEvent': eventDateEvent,
      'event.dateCreation': eventDateCreation,
      'event.eventStatus': eventEventStatus,
      'event.location': eventLocation,
      'eventExpenceId': eventExpenceId,
      'description': description,
      'amount': amount,
      'dateIntert': dateIntert,
    };
    final Request $request = Request(
      'PUT',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<List<Event>>> _apiV1AppEventsFindallGet() {
    final String $url = '/api/v1/app/events/findall';
    final Request $request = Request(
      'GET',
      $url,
      client.baseUrl,
    );
    return client.send<List<Event>, Event>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppEventsSavePost({
    int? eventId,
    String? name,
    String? dateEvent,
    String? dateCreation,
    String? eventStatus,
    String? location,
  }) {
    final String $url = '/api/v1/app/events/save';
    final Map<String, dynamic> $params = <String, dynamic>{
      'eventId': eventId,
      'name': name,
      'dateEvent': dateEvent,
      'dateCreation': dateCreation,
      'eventStatus': eventStatus,
      'location': location,
    };
    final Request $request = Request(
      'POST',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppEventsUpdatePut({
    int? eventId,
    String? name,
    String? dateEvent,
    String? dateCreation,
    String? eventStatus,
    String? location,
  }) {
    final String $url = '/api/v1/app/events/update';
    final Map<String, dynamic> $params = <String, dynamic>{
      'eventId': eventId,
      'name': name,
      'dateEvent': dateEvent,
      'dateCreation': dateCreation,
      'eventStatus': eventStatus,
      'location': location,
    };
    final Request $request = Request(
      'PUT',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppProductsDeleteDelete({
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
    final String $url = '/api/v1/app/products/delete';
    final Map<String, dynamic> $params = <String, dynamic>{
      'supplier.supplierId': supplierSupplierId,
      'supplier.name': supplierName,
      'supplier.vatNumber': supplierVatNumber,
      'supplier.address': supplierAddress,
      'supplier.city': supplierCity,
      'supplier.cap': supplierCap,
      'supplier.phoneNumber': supplierPhoneNumber,
      'supplier.email': supplierEmail,
      'supplier.pec': supplierPec,
      'productId': productId,
      'name': name,
      'unitMeasure': unitMeasure,
      'vatApplied': vatApplied,
      'price': price,
      'description': description,
      'category': category,
    };
    final Request $request = Request(
      'DELETE',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<List<Product>>> _apiV1AppProductsFindallGet() {
    final String $url = '/api/v1/app/products/findall';
    final Request $request = Request(
      'GET',
      $url,
      client.baseUrl,
    );
    return client.send<List<Product>, Product>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppProductsSavePost({
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
    final String $url = '/api/v1/app/products/save';
    final Map<String, dynamic> $params = <String, dynamic>{
      'supplier.supplierId': supplierSupplierId,
      'supplier.name': supplierName,
      'supplier.vatNumber': supplierVatNumber,
      'supplier.address': supplierAddress,
      'supplier.city': supplierCity,
      'supplier.cap': supplierCap,
      'supplier.phoneNumber': supplierPhoneNumber,
      'supplier.email': supplierEmail,
      'supplier.pec': supplierPec,
      'productId': productId,
      'name': name,
      'unitMeasure': unitMeasure,
      'vatApplied': vatApplied,
      'price': price,
      'description': description,
      'category': category,
    };
    final Request $request = Request(
      'POST',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppProductsUpdatePut({
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
    final String $url = '/api/v1/app/products/update';
    final Map<String, dynamic> $params = <String, dynamic>{
      'supplier.supplierId': supplierSupplierId,
      'supplier.name': supplierName,
      'supplier.vatNumber': supplierVatNumber,
      'supplier.address': supplierAddress,
      'supplier.city': supplierCity,
      'supplier.cap': supplierCap,
      'supplier.phoneNumber': supplierPhoneNumber,
      'supplier.email': supplierEmail,
      'supplier.pec': supplierPec,
      'productId': productId,
      'name': name,
      'unitMeasure': unitMeasure,
      'vatApplied': vatApplied,
      'price': price,
      'description': description,
      'category': category,
    };
    final Request $request = Request(
      'PUT',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppStorageDeleteDelete({
    int? storageId,
    String? name,
    String? creationDate,
    String? address,
    String? city,
    int? cap,
  }) {
    final String $url = '/api/v1/app/storage/delete';
    final Map<String, dynamic> $params = <String, dynamic>{
      'storageId': storageId,
      'name': name,
      'creationDate': creationDate,
      'address': address,
      'city': city,
      'cap': cap,
    };
    final Request $request = Request(
      'DELETE',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<List<Storage>>> _apiV1AppStorageFindallGet() {
    final String $url = '/api/v1/app/storage/findall';
    final Request $request = Request(
      'GET',
      $url,
      client.baseUrl,
    );
    return client.send<List<Storage>, Storage>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppStorageSavePost({
    int? storageId,
    String? name,
    String? creationDate,
    String? address,
    String? city,
    int? cap,
  }) {
    final String $url = '/api/v1/app/storage/save';
    final Map<String, dynamic> $params = <String, dynamic>{
      'storageId': storageId,
      'name': name,
      'creationDate': creationDate,
      'address': address,
      'city': city,
      'cap': cap,
    };
    final Request $request = Request(
      'POST',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppStorageUpdatePut({
    int? storageId,
    String? name,
    String? creationDate,
    String? address,
    String? city,
    int? cap,
  }) {
    final String $url = '/api/v1/app/storage/update';
    final Map<String, dynamic> $params = <String, dynamic>{
      'storageId': storageId,
      'name': name,
      'creationDate': creationDate,
      'address': address,
      'city': city,
      'cap': cap,
    };
    final Request $request = Request(
      'PUT',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppSuppliersDeleteDelete({
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
    final String $url = '/api/v1/app/suppliers/delete';
    final Map<String, dynamic> $params = <String, dynamic>{
      'supplierId': supplierId,
      'name': name,
      'vatNumber': vatNumber,
      'address': address,
      'city': city,
      'cap': cap,
      'phoneNumber': phoneNumber,
      'email': email,
      'pec': pec,
    };
    final Request $request = Request(
      'DELETE',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<List<Supplier>>> _apiV1AppSuppliersFindallGet() {
    final String $url = '/api/v1/app/suppliers/findall';
    final Request $request = Request(
      'GET',
      $url,
      client.baseUrl,
    );
    return client.send<List<Supplier>, Supplier>($request);
  }

  @override
  Future<Response<Supplier>> _apiV1AppSuppliersFindbyphoneGet(
      {required String? phone}) {
    final String $url = '/api/v1/app/suppliers/findbyphone';
    final Map<String, dynamic> $params = <String, dynamic>{'phone': phone};
    final Request $request = Request(
      'GET',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<Supplier, Supplier>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppSuppliersSavePost({
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
    final String $url = '/api/v1/app/suppliers/save';
    final Map<String, dynamic> $params = <String, dynamic>{
      'supplierId': supplierId,
      'name': name,
      'vatNumber': vatNumber,
      'address': address,
      'city': city,
      'cap': cap,
      'phoneNumber': phoneNumber,
      'email': email,
      'pec': pec,
    };
    final Request $request = Request(
      'POST',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppSuppliersUpdatePut({
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
    final String $url = '/api/v1/app/suppliers/update';
    final Map<String, dynamic> $params = <String, dynamic>{
      'supplierId': supplierId,
      'name': name,
      'vatNumber': vatNumber,
      'address': address,
      'city': city,
      'cap': cap,
      'phoneNumber': phoneNumber,
      'email': email,
      'pec': pec,
    };
    final Request $request = Request(
      'PUT',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppUsersDeleteDelete({
    int? userId,
    String? name,
    String? lastname,
    String? email,
    String? phoneNumber,
  }) {
    final String $url = '/api/v1/app/users/delete';
    final Map<String, dynamic> $params = <String, dynamic>{
      'userId': userId,
      'name': name,
      'lastname': lastname,
      'email': email,
      'phoneNumber': phoneNumber,
    };
    final Request $request = Request(
      'DELETE',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<List<UserEntity>>> _apiV1AppUsersFindallGet() {
    final String $url = '/api/v1/app/users/findall';
    final Request $request = Request(
      'GET',
      $url,
      client.baseUrl,
    );
    return client.send<List<UserEntity>, UserEntity>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppUsersSavePost({
    int? userId,
    String? name,
    String? lastname,
    String? email,
    String? phoneNumber,
  }) {
    final String $url = '/api/v1/app/users/save';
    final Map<String, dynamic> $params = <String, dynamic>{
      'userId': userId,
      'name': name,
      'lastname': lastname,
      'email': email,
      'phoneNumber': phoneNumber,
    };
    final Request $request = Request(
      'POST',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1AppUsersUpdatePut({
    int? userId,
    String? name,
    String? lastname,
    String? email,
    String? phoneNumber,
  }) {
    final String $url = '/api/v1/app/users/update';
    final Map<String, dynamic> $params = <String, dynamic>{
      'userId': userId,
      'name': name,
      'lastname': lastname,
      'email': email,
      'phoneNumber': phoneNumber,
    };
    final Request $request = Request(
      'PUT',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1WebsiteCustomersDeleteDelete({
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
    final String $url = '/api/v1/website/customers/delete';
    final Map<String, dynamic> $params = <String, dynamic>{
      'customerId': customerId,
      'name': name,
      'lastname': lastname,
      'email': email,
      'phoneNumber': phoneNumber,
      'dob': dob,
      'treatmentPersonalData': treatmentPersonalData,
      'branch20m2': branch20m2,
      'accessCounter': accessCounter,
    };
    final Request $request = Request(
      'DELETE',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<List<Customers>>> _apiV1WebsiteCustomersFindallGet() {
    final String $url = '/api/v1/website/customers/findall';
    final Request $request = Request(
      'GET',
      $url,
      client.baseUrl,
    );
    return client.send<List<Customers>, Customers>($request);
  }

  @override
  Future<Response<Customers>> _apiV1WebsiteCustomersFindbyphoneGet(
      {required String? phone}) {
    final String $url = '/api/v1/website/customers/findbyphone';
    final Map<String, dynamic> $params = <String, dynamic>{'phone': phone};
    final Request $request = Request(
      'GET',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<Customers, Customers>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1WebsiteCustomersSavePost({
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
    final String $url = '/api/v1/website/customers/save';
    final Map<String, dynamic> $params = <String, dynamic>{
      'customerId': customerId,
      'name': name,
      'lastname': lastname,
      'email': email,
      'phoneNumber': phoneNumber,
      'dob': dob,
      'treatmentPersonalData': treatmentPersonalData,
      'branch20m2': branch20m2,
      'accessCounter': accessCounter,
    };
    final Request $request = Request(
      'POST',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1WebsiteCustomersUpdatePut({
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
    final String $url = '/api/v1/website/customers/update';
    final Map<String, dynamic> $params = <String, dynamic>{
      'customerId': customerId,
      'name': name,
      'lastname': lastname,
      'email': email,
      'phoneNumber': phoneNumber,
      'dob': dob,
      'treatmentPersonalData': treatmentPersonalData,
      'branch20m2': branch20m2,
      'accessCounter': accessCounter,
    };
    final Request $request = Request(
      'PUT',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }
}
