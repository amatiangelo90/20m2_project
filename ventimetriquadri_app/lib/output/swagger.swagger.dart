import 'swagger.models.swagger.dart';
import 'package:chopper/chopper.dart';

import 'client_mapping.dart';
import 'dart:async';
import 'package:chopper/chopper.dart' as chopper;
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
            'http://servicedbacorp741w.com:8080/ventimetriquadriservice');
    return _$Swagger(newClient);
  }

  ///delete
  ///@param userId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  ///@param dob
  ///@param treatmentPersonalData
  Future<chopper.Response> apiV1UserDeleteDelete({
    int? userId,
    String? name,
    String? lastname,
    String? email,
    String? phoneNumber,
    String? dob,
    bool? treatmentPersonalData,
  }) {
    return _apiV1UserDeleteDelete(
        userId: userId,
        name: name,
        lastname: lastname,
        email: email,
        phoneNumber: phoneNumber,
        dob: dob,
        treatmentPersonalData: treatmentPersonalData);
  }

  ///delete
  ///@param userId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  ///@param dob
  ///@param treatmentPersonalData
  @Delete(path: '/api/v1/user/delete')
  Future<chopper.Response> _apiV1UserDeleteDelete({
    @Query('userId') int? userId,
    @Query('name') String? name,
    @Query('lastname') String? lastname,
    @Query('email') String? email,
    @Query('phoneNumber') String? phoneNumber,
    @Query('dob') String? dob,
    @Query('treatmentPersonalData') bool? treatmentPersonalData,
  });

  ///retrieveAll
  Future<chopper.Response<List<User20m2>>> apiV1UserFindallGet() {
    generatedMapping.putIfAbsent(User20m2, () => User20m2.fromJsonFactory);

    return _apiV1UserFindallGet();
  }

  ///retrieveAll
  @Get(path: '/api/v1/user/findall')
  Future<chopper.Response<List<User20m2>>> _apiV1UserFindallGet();

  ///retrieveByPhone
  ///@param phone phone
  Future<chopper.Response<User20m2>> apiV1UserFindbyphoneGet(
      {required String? phone}) {
    generatedMapping.putIfAbsent(User20m2, () => User20m2.fromJsonFactory);

    return _apiV1UserFindbyphoneGet(phone: phone);
  }

  ///retrieveByPhone
  ///@param phone phone
  @Get(path: '/api/v1/user/findbyphone')
  Future<chopper.Response<User20m2>> _apiV1UserFindbyphoneGet(
      {@Query('phone') required String? phone});

  ///save
  ///@param userId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  ///@param dob
  ///@param treatmentPersonalData
  Future<chopper.Response> apiV1UserSavePost({
    int? userId,
    String? name,
    String? lastname,
    String? email,
    String? phoneNumber,
    String? dob,
    bool? treatmentPersonalData,
  }) {
    return _apiV1UserSavePost(
        userId: userId,
        name: name,
        lastname: lastname,
        email: email,
        phoneNumber: phoneNumber,
        dob: dob,
        treatmentPersonalData: treatmentPersonalData);
  }

  ///save
  ///@param userId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  ///@param dob
  ///@param treatmentPersonalData
  @Post(
    path: '/api/v1/user/save',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1UserSavePost({
    @Query('userId') int? userId,
    @Query('name') String? name,
    @Query('lastname') String? lastname,
    @Query('email') String? email,
    @Query('phoneNumber') String? phoneNumber,
    @Query('dob') String? dob,
    @Query('treatmentPersonalData') bool? treatmentPersonalData,
  });

  ///update
  ///@param userId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  ///@param dob
  ///@param treatmentPersonalData
  Future<chopper.Response> apiV1UserUpdatePut({
    int? userId,
    String? name,
    String? lastname,
    String? email,
    String? phoneNumber,
    String? dob,
    bool? treatmentPersonalData,
  }) {
    return _apiV1UserUpdatePut(
        userId: userId,
        name: name,
        lastname: lastname,
        email: email,
        phoneNumber: phoneNumber,
        dob: dob,
        treatmentPersonalData: treatmentPersonalData);
  }

  ///update
  ///@param userId
  ///@param name
  ///@param lastname
  ///@param email
  ///@param phoneNumber
  ///@param dob
  ///@param treatmentPersonalData
  @Put(
    path: '/api/v1/user/update',
    optionalBody: true,
  )
  Future<chopper.Response> _apiV1UserUpdatePut({
    @Query('userId') int? userId,
    @Query('name') String? name,
    @Query('lastname') String? lastname,
    @Query('email') String? email,
    @Query('phoneNumber') String? phoneNumber,
    @Query('dob') String? dob,
    @Query('treatmentPersonalData') bool? treatmentPersonalData,
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
