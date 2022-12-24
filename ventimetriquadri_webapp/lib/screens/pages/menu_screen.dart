import 'dart:math';

import 'package:chopper/chopper.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:ventimetriquadri/output/swagger.swagger.dart';
import '../../databundle/data_bundle_notifier.dart';
import '../../menu/pdf_viewer.dart';
import '../../output/swagger.enums.swagger.dart';

class MenuScreen extends StatefulWidget {
  static String id = 'menudetails';
  @override
  _MenuScreenState createState() => _MenuScreenState();
}

class _MenuScreenState extends State<MenuScreen> {

  late double height;
  late double width;

  Random rnd = Random();

  List<String> listFoodPhotos = [
    "images/photos/polpo.jpg",
    "images/photos/panino20m2.jpg",
    "images/photos/image_2.jpeg",
    "images/photos/image_4.jpeg",
  ];

  @override
  Widget build(BuildContext context) {

    height  = MediaQuery.of(context).size.height;
    width  = MediaQuery.of(context).size.width;
    return GestureDetector(
      onTap: (){
        FocusScope.of(context).requestFocus(FocusNode());
      },
      child: Consumer<DataBundleNotifier>(
        builder: (child, bundleNotifier, _){
          return Scaffold(
            appBar: AppBar(
              leading: IconButton(
                icon: const Icon(Icons.arrow_back_ios),
                onPressed: (){
                  Navigator.of(context).pop();
                },
              ),
              title: const Text('20M2 - PANINI E POI..',
                  style: TextStyle(fontWeight: FontWeight.w500, color:
                  Colors.white, fontSize: 18, fontFamily: 'Dance')),
              backgroundColor: Color(0xff121212),
            ),
            body: Container(
              decoration: BoxDecoration(
                image: DecorationImage(
                  colorFilter: ColorFilter.mode(Colors.black.withOpacity(0.8), BlendMode.hardLight),
                  image: AssetImage(listFoodPhotos[rnd.nextInt(3 - 0)]),
                  fit: BoxFit.cover,
                ),
              ),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: [
                  Card(
                    color: Colors.black.withOpacity(0.5),
                    child: Padding(
                      padding: const EdgeInsets.all(28.0),
                      child: Text('Ciao ${bundleNotifier.currentUser!.name},\n\n Consulta uno dei nostri menu e buon appetito! 😊',
                          textAlign: TextAlign.center,
                          style: const TextStyle(fontWeight: FontWeight.bold, color:
                          Colors.white, fontSize: 18, fontFamily: 'Dance')),
                    ),
                  ),
                  Center(
                    child: Column(
                      children: [
                        Image.asset('images/20m2_logo.png', height: 55),
                        const Text('20M2 - PANINI E POI..',
                            style: TextStyle(fontWeight: FontWeight.w500, color:
                            Colors.white, fontSize: 9, fontFamily: 'Dance'))
                      ],
                    ),
                  ),
                  Column(
                    children: [
                      buildButton('MENU\' CISTERNINO', bundleNotifier, CustomerAccessBranchLocation.cisternino),
                      buildButton('MENU\' LOCOROTONDO', bundleNotifier, CustomerAccessBranchLocation.locorotondo),
                      buildButton('MENU\' MONOPOLI', bundleNotifier, CustomerAccessBranchLocation.monopoli),
                    ],
                  ),
                ],
              ) /* add child content here */,
            ),
          );
        },
      ),
    );
  }

  buildButton(String s, DataBundleNotifier bundleNotifier,
    CustomerAccessBranchLocation branch) {
    return Padding(
      padding: const EdgeInsets.only(bottom: 10),
      child: SizedBox(
        width: width - 30,
        height: 60,

        child: ElevatedButton(onPressed: () async {
          bundleNotifier.setCurrentBranch(branch);

          print('Save client access ${bundleNotifier.currentCustomerId} date ${bundleNotifier.getCurrentDateInFormat()} branch ' + branch.toString());
          try {
            Response apiV1WebsiteCustomeraccessSavePost = await bundleNotifier.getSwaggerClient().apiV1WebsiteCustomeraccessSavePost(
                customerId: bundleNotifier.currentCustomerId,
                accessDate: bundleNotifier.getCurrentDateInFormat(),
                customerAccessId: 0,
                branchLocation: customerAccessBranchLocationToJson(branch));

            print(apiV1WebsiteCustomeraccessSavePost.error);
          } catch (e) {
            print(e.toString());
          }

          Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => PdfViewerPage(),
            ),
          );
        },style: ButtonStyle(
            backgroundColor: MaterialStateProperty.resolveWith((states) => Color(0xff121212)),
            shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(18.0),
                    side: const BorderSide(color: Colors.white)
                )
            )
        ), child: Text(s,
            style: const TextStyle(fontWeight: FontWeight.bold, color:
            Colors.white, fontSize: 25, fontFamily: 'Dance')),),
      ),
    );
  }
}