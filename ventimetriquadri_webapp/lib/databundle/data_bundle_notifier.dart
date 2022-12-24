import 'dart:math';

import 'package:flutter/cupertino.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import '../output/swagger.models.swagger.dart';
import '../output/swagger.swagger.dart';

class DataBundleNotifier extends ChangeNotifier{

  String baseUrlHttps = 'https://servicedbacorp741w.com:8444/ventimetriquadriservice';
  //String baseUrlHttp = 'http://servicedbacorp741w.com:8080/ventimetriquadriservice';
  String baseUrlHttp = 'http://localhost:8080/ventimetriquadriservice';

  String pdfItaCisternino = 'assets/MENU CISTERNINO 2023.pdf';
  String pdfEnCisternino = 'assets/MENU-CISTERNINO-2022_GIUGNO-INGLESE.pdf';
  String pdfItaLocorotondo = 'assets/MENU LOCOROTONDO 2023.pdf';
  String pdfEngLocorotondo = 'assets/MENU-LOCOROTONDO-2022_GIUGNO-INGLESE.pdf';
  String pdfItaMonopoli = 'assets/MENU MONOPOLI 2023.pdf';
  String pdfEngMonopoli = 'assets/MENU-MONOPOLI-2022_GIUGNO-INGLESE.pdf';

  String currentPdfIta = '';
  String currentPdfEng = '';

  TextEditingController nameController = TextEditingController();
  TextEditingController lastnameController = TextEditingController();
  TextEditingController emailController = TextEditingController();
  TextEditingController phoneController = TextEditingController();
  TextEditingController dobControoler = TextEditingController();

  CustomerAccessBranchLocation currentBranch = CustomerAccessBranchLocation.cisternino;

  DateFormat dateFormat = DateFormat("yyyy-MM-dd");

  Customer currentUser = Customer();

  DateTime currentDate = DateTime(1990, 05, 19, 0,0,0,0,0);
  DateTime now = DateTime.now();

  bool checkedValue = false;

  bool accessAlreadyDone = false;

  String currentLanguage = 'ITA';

  String formErrors = 'false';

  String errorFormMessage = '';

  void switchCurrentLanguage(){
    if(currentLanguage == 'ITA'){
      currentLanguage = 'ENG';
    }else{
      currentLanguage = 'ITA';
    }
    notifyListeners();
  }

  void setCurrentBranch(CustomerAccessBranchLocation branch){
    currentBranch = branch;
    switch(branch){
      case CustomerAccessBranchLocation.cisternino:
        currentPdfIta = pdfItaCisternino;
        currentPdfEng = pdfEnCisternino;
        break;
      case CustomerAccessBranchLocation.locorotondo:
        currentPdfIta = pdfItaLocorotondo;
        currentPdfEng = pdfEngLocorotondo;
        break;
      case CustomerAccessBranchLocation.monopoli:
        currentPdfIta = pdfItaMonopoli;
        currentPdfEng = pdfEngMonopoli;
        break;
    }
    notifyListeners();
  }

  void turnCheckedValue(){
    if(checkedValue){
      checkedValue = false;
    }else{
      checkedValue = true;
    }
    notifyListeners();
  }

  void setCurrentUser(Customer customer){
    currentCustomerId = customer.customerId!.toInt();
    currentUser = customer;
    alreadyRegisteredUser = true;
    emailController.text = currentUser.email!;
    nameController.text = currentUser.name!;
    lastnameController.text = currentUser.lastname!;
    dobControoler.text = currentUser.dob!;
    checkedValue = currentUser.treatmentPersonalData!;
    notifyListeners();
  }

  bool alreadyRegisteredUser = false;

  Swagger getSwaggerClient(){
    if(kIsWeb){
      print('Web application run');
      return Swagger.create(
          baseUrl: baseUrlHttps
      );
    }else{
      print('App application run');
      return Swagger.create(
          baseUrl: baseUrlHttp
      );
    }
  }

  void setErrorFlag(String value) {
    formErrors = value;
    notifyListeners();
  }

  void setErrorMessage(String s) {
    errorFormMessage = s;
    notifyListeners();
  }

  int currentCustomerId = 0;

  void setCurrentCustomerId(int body) {
    currentCustomerId = body;
    notifyListeners();
  }

  String getCurrentDateInFormat(){
    return dateFormat.format(now);
  }

  Future<void> selectDate(BuildContext context) async {
    final DateTime? picked = await showDatePicker(
        initialDatePickerMode: DatePickerMode.year,
        builder: (BuildContext context, Widget? child) {
          return Theme(
            data: ThemeData.light().copyWith(
              dialogTheme: const DialogTheme(
                  shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.all(Radius.circular(16)))),
              primaryColor: const Color(0xFF121212),
              accentColor: const Color(0xFF121212),
              colorScheme: ColorScheme.light(primary: const Color(0xFF121212)),
              buttonTheme: const ButtonThemeData(
                  textTheme: ButtonTextTheme.primary
              ),
            ),
            child: child!,
          );
        },
        context: context,
        locale: const Locale("it", "IT"),
        initialDate: currentDate,
        firstDate: DateTime(1930),
        lastDate: DateTime(DateTime.now().year - 18));
    if (picked != null && picked != currentDate) {
      setDate(picked);
    }
  }

  void setDate(DateTime picked) {
    currentDate = picked;
    dobControoler.text = dateFormat.format(picked);
    notifyListeners();
  }

}