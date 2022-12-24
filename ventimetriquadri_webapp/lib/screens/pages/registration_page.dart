import 'package:chopper/chopper.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:provider/provider.dart';
import 'package:ventimetriquadri/databundle/data_bundle_notifier.dart';
import 'package:ventimetriquadri/screens/pages/menu_screen.dart';

import '../../output/swagger.models.swagger.dart';


class RegistrationPage extends StatefulWidget {
  const RegistrationPage({Key? key}) : super(key: key);

  static String id = 'menu';

  @override
  State<RegistrationPage> createState() => _RegistrationPageState();
}

class _RegistrationPageState extends State<RegistrationPage> {
  DateTime selectedDate = DateTime(1992);


  @override
  Widget build(BuildContext context) {

    double width = MediaQuery.of(context).size.width;


    return Consumer<DataBundleNotifier>(

      builder: (child, dataBundleNotifier, _){
        return GestureDetector(
          onTap: (){
            FocusScope.of(context).requestFocus(FocusNode());
          },
          child: Scaffold(
            appBar: AppBar(
              actions: [
                GestureDetector(
                  onLongPress: (){
                    Navigator.pushNamed(context, MenuScreen.id);
                  },
                  child: Image.asset('images/whitenobg.png', height: 100),
                )
              ],
              leading: IconButton(
                icon: Icon(Icons.arrow_back_ios),
                onPressed: (){
                  Navigator.of(context).pop();
                },
              ),
              title: const Text(
                'Dati personali' , style: TextStyle(
                  color: Colors.white,
                  fontFamily: 'Dance',
                  fontWeight: FontWeight.bold,
                  fontSize: 19
              ),
              ),
              centerTitle: true,
              elevation: 0,
              backgroundColor: const Color(0xFF121212),
            ),
            backgroundColor: const Color(0xFFfdfdff),
            body: Container(
              width: double.infinity,
              padding: const EdgeInsets.all(8.0),
              child: SingleChildScrollView(
                scrollDirection: Axis.vertical,
                child: AutofillGroup(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.stretch,
                    children: <Widget>[
                      dataBundleNotifier.alreadyRegisteredUser ? Padding(
                        padding: const EdgeInsets.all(5.0),
                        child: Center(
                          child: Text(
                            'Bentornato/a ${dataBundleNotifier.currentUser.name!} 😎' , style: TextStyle(
                              color: Colors.grey.shade700,
                              fontFamily: 'Dance',
                              fontWeight: FontWeight.bold,
                              fontSize: 19
                          ),
                          ),
                        ),
                      ) : const Text(''),
                      Row(
                        children: [
                          Padding(
                            padding: const EdgeInsets.only(right: 2, bottom: 20),
                            child: SizedBox(
                                width: width * 1/11,
                                child: Text(
                                  textAlign: TextAlign.center,
                                  ' +39 ' , style: TextStyle(
                                    color: Colors.grey.shade700,

                                    fontFamily: 'Dance',
                                    fontWeight: FontWeight.bold,
                                    fontSize: 19
                                ),
                                ),),
                          ),
                          Expanded(
                            child: TextFormField(
                              autofillHints: const [AutofillHints.telephoneNumber],
                              style: TextStyle(
                                  color: Colors.grey.shade700,
                                  fontFamily: 'Dance',
                                  fontWeight: FontWeight.bold,
                                  fontSize: 16
                              ),
                              textInputAction: TextInputAction.next,
                              textCapitalization: TextCapitalization.words,
                              maxLength: 10,
                              inputFormatters: [
                                FilteringTextInputFormatter.deny(
                                    RegExp(r'\s')),
                              ],
                              keyboardType: TextInputType.number,
                              onChanged: (phoneNumber) async {
                                if(phoneNumber.length >= 10){
                                  Response apiV1UserFindallGet = await dataBundleNotifier
                                      .getSwaggerClient().apiV1WebsiteCustomersFindbyphoneGet(phone: dataBundleNotifier.phoneController.text);
                                  if(apiV1UserFindallGet.isSuccessful){
                                    if(apiV1UserFindallGet.body != null){
                                      dataBundleNotifier.setCurrentUser(apiV1UserFindallGet.body);
                                      FocusManager.instance.primaryFocus?.unfocus();
                                      Navigator.pushNamed(context, MenuScreen.id);
                                    }
                                  }else{
                                    print(apiV1UserFindallGet.error.toString());
                                  }
                                }
                              },
                              decoration: getInputDecoration('cellulare *'),
                              controller: dataBundleNotifier.phoneController,
                            ),
                          ),
                        ],
                      ),
                      const SizedBox(height: 9,),
                      Row(
                        children: [
                          SizedBox(
                              width: width * 1/11,
                              child: const Icon(Icons.person_outline_rounded, color: Color(0xff121212))),
                          Expanded(
                            child: TextFormField(
                              autofillHints: const [AutofillHints.givenName],
                              style: TextStyle(
                                  color: Colors.grey.shade700,
                                  fontFamily: 'Dance',
                                  fontWeight: FontWeight.bold,
                                  fontSize: 16
                              ),
                              textInputAction: TextInputAction.next,
                              textCapitalization: TextCapitalization.words,
                              onEditingComplete: (){
                              },
                              decoration: getInputDecoration('nome *'),
                              controller: dataBundleNotifier.nameController,
                            ),
                          ),
                        ],
                      ),
                      const SizedBox(height: 9,),
                      Row(
                        children: [
                          SizedBox(
                              width: width * 1/11,
                              child: const Icon(Icons.person_outline_rounded, color: Color(0xff121212))),
                          Expanded(
                            child: TextFormField(
                              autofillHints: const [AutofillHints.familyName],
                              style: TextStyle(
                                  color: Colors.grey.shade700,
                                  fontFamily: 'Dance',
                                  fontWeight: FontWeight.bold,
                                  fontSize: 16
                              ),
                              textInputAction: TextInputAction.next,
                              textCapitalization: TextCapitalization.words,
                              onEditingComplete: (){
                              },
                              decoration: const InputDecoration(
                                  focusedBorder: OutlineInputBorder(
                                    borderRadius: BorderRadius.all(Radius.circular(20.0)),
                                    borderSide: BorderSide(color: Colors.grey, width: 1.3),
                                  ),
                                  labelText: 'cognome *',
                                  enabledBorder: OutlineInputBorder(
                                    borderRadius: BorderRadius.all(Radius.circular(20.0)),
                                    borderSide: BorderSide(color: Colors.grey, width: 1.0),
                                  ),
                                  hintStyle: TextStyle(color: Colors.red),
                                  filled: true,
                                  fillColor: Color(0xfffdfdff),
                                  focusColor: Colors.grey,
                                  border: OutlineInputBorder()),
                              controller: dataBundleNotifier.lastnameController,
                            ),
                          ),
                        ],
                      ),
                      const SizedBox(height: 9,),
                      Row(
                        children: [
                          SizedBox(
                              width: width * 1/11,
                              child: const Icon(Icons.email_outlined, color: Color(0xff121212))),
                          Expanded(
                            child: TextFormField(
                              autofillHints: const [AutofillHints.email],
                              style: TextStyle(
                                  color: Colors.grey.shade700,
                                  fontFamily: 'Dance',
                                  fontWeight: FontWeight.bold,
                                  fontSize: 16
                              ),
                              textInputAction: TextInputAction.next,
                              textCapitalization: TextCapitalization.words,
                              onEditingComplete: (){
                              },
                              decoration: getInputDecoration('email'),
                              controller: dataBundleNotifier.emailController,
                            ),
                          ),
                        ],
                      ),
                      const SizedBox(height: 10,),
                      Row(
                        children: [
                          SizedBox(
                              width: width * 1/11,
                              child: const Icon(FontAwesomeIcons.calendar, color: Color(0xff121212))),
                          Expanded(
                            child: TextFormField(
                              style: TextStyle(
                                  color: Colors.grey.shade700,
                                  fontFamily: 'Dance',
                                  fontWeight: FontWeight.bold,
                                  fontSize: 16
                              ),
                              onTap: (){
                                FocusScope.of(context).requestFocus(FocusNode());
                                dataBundleNotifier.selectDate(context);
                              },
                              textInputAction: TextInputAction.next,
                              textCapitalization: TextCapitalization.words,
                              decoration: getInputDecoration('data di nascita *'),
                              controller: dataBundleNotifier.dobControoler,
                            ),
                          ),
                        ],
                      ),
                      const SizedBox(height: 9,),
                      Row(
                        children: [
                          SizedBox(
                              width: width * 1/11,),
                          Text(
                            '      campo obbligatorio *' , style: TextStyle(
                              color: Colors.grey.shade700,
                              fontFamily: 'Dance',
                              fontWeight: FontWeight.bold,
                              fontSize: 11
                          ),
                          ),
                        ],
                      ),
                      Padding(
                        padding: const EdgeInsets.only(right: 10, left: 10),
                        child: Center(
                          child: Row(
                            children: [
                              Checkbox(
                                fillColor: MaterialStateProperty.resolveWith((states) => Colors.grey.shade700,),
                                activeColor: Colors.blueGrey,
                                value: dataBundleNotifier.checkedValue, onChanged: (val){
                                dataBundleNotifier.turnCheckedValue();
                              },),
                              SizedBox(
                                width: width * 3/4,
                                child: Text(
                                  'Presto il consenso al trattamento dei dati personali',style: TextStyle(
                                    color: Colors.grey.shade700,
                                    fontFamily: 'Dance',
                                    fontWeight: FontWeight.bold,
                                    fontSize: 12
                                ),
                                ),
                              ),
                            ],
                          ),
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: Center(child: Text( dataBundleNotifier.formErrors == 'true' ? dataBundleNotifier.errorFormMessage : '', style: TextStyle(fontFamily: 'Dance', color: Colors.red, fontWeight: FontWeight.bold, fontSize: 16),)),
                      ),
                      SizedBox(
                        width: 300,
                        height: 50,

                        child: ElevatedButton(onPressed: () async {
                          dataBundleNotifier.setErrorFlag('false');
                          dataBundleNotifier.setErrorMessage('');
                          if(dataBundleNotifier.phoneController.text.isEmpty){
                            dataBundleNotifier.setErrorFlag('true');
                            dataBundleNotifier.setErrorMessage('Inserisci il numero di cellulare');
                          }else if(dataBundleNotifier.phoneController.text.length != 10){
                            dataBundleNotifier.setErrorFlag('true');
                            dataBundleNotifier.setErrorMessage('Inserire un numero di cellulare corretto');
                          }else if(!isPhoneNoValid(dataBundleNotifier.phoneController.text)){
                            dataBundleNotifier.setErrorFlag('true');
                            dataBundleNotifier.setErrorMessage('Inserire un numero di cellulare corretto');
                          }else if(dataBundleNotifier.nameController.text.isEmpty){
                            dataBundleNotifier.setErrorFlag('true');
                            dataBundleNotifier.setErrorMessage('Inserisci il nome');
                          }else if(dataBundleNotifier.lastnameController.text.isEmpty){
                            dataBundleNotifier.setErrorFlag('true');
                            dataBundleNotifier.setErrorMessage('Inserisci il cognome');
                          }else if(dataBundleNotifier.dobControoler.text.isEmpty){
                            dataBundleNotifier.setErrorFlag('true');
                            dataBundleNotifier.setErrorMessage('Inserisci la data di nascita');
                          }
                          else{
                            try{
                              Response apiV1WebsiteCustomersSavePost = await dataBundleNotifier.getSwaggerClient().apiV1WebsiteCustomersSavePost(
                                name: dataBundleNotifier.nameController.text,
                                dob: dataBundleNotifier.dobControoler.text,
                                email: dataBundleNotifier.emailController.text,
                                lastname: dataBundleNotifier.lastnameController.text,
                                phone: dataBundleNotifier.phoneController.text,
                                treatmentPersonalData: dataBundleNotifier.checkedValue,
                                customerId: 0,
                              );

                              if(apiV1WebsiteCustomersSavePost.isSuccessful){
                                dataBundleNotifier.setCurrentCustomerId(apiV1WebsiteCustomersSavePost.body);
                                dataBundleNotifier.setCurrentUser(Customer(
                                  customerId: apiV1WebsiteCustomersSavePost.body,
                                  treatmentPersonalData: dataBundleNotifier.checkedValue,
                                  email: dataBundleNotifier.emailController.text,
                                  lastname: dataBundleNotifier.lastnameController.text,
                                  phone: dataBundleNotifier.phoneController.text,
                                  dob: dataBundleNotifier.dobControoler.text,
                                  name: dataBundleNotifier.nameController.text,
                                  accessesList: []

                                ));
                              }
                            }catch(e){
                              print(e.toString());
                            }
                            Navigator.pushNamed(context, MenuScreen.id);
                          }
                        },style: ButtonStyle(
                            backgroundColor: MaterialStateProperty.resolveWith((states) => Color(0xff121212),),
                            shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                                RoundedRectangleBorder(
                                    borderRadius: BorderRadius.circular(18.0),
                                    side: const BorderSide(color: Colors.grey)
                                )
                            )
                        ), child: Text('ACCEDI AL MENU\'',
                            style: TextStyle(fontWeight: FontWeight.bold, color:
                            Colors.white, fontSize: 18, fontFamily: 'Dance')),),
                      ),
                    ],
                  ),
                ),
              ),
            ),
          ),
        );
      },
    );
  }

  bool isPhoneNoValid(String? phoneNo) {
    if (phoneNo == null) return false;
    final regExp = RegExp(r'(^(?:[+0]9)?[0-9]{10,12}$)');
    return regExp.hasMatch(phoneNo);
  }

  getInputDecoration(String s) {
    return InputDecoration(
        focusedBorder: const OutlineInputBorder(
          borderRadius: BorderRadius.all(Radius.circular(20.0)),
          borderSide: BorderSide(color: Colors.grey, width: 1.3),
        ),
        labelText: s,
        enabledBorder: const OutlineInputBorder(
          borderRadius: BorderRadius.all(Radius.circular(20.0)),
          borderSide: BorderSide(color: Colors.grey, width: 1.0),
        ),
        filled: true,
        fillColor: const Color(0xfffdfdff),
        focusColor: Colors.grey,
        border: const OutlineInputBorder());
  }
}
