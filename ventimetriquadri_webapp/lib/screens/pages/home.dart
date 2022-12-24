import 'package:carousel_slider/carousel_slider.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:provider/provider.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:ventimetriquadri/databundle/data_bundle_notifier.dart';
import 'package:ventimetriquadri/screens/pages/fade_animation.dart';
import 'package:ventimetriquadri/screens/pages/registration_page.dart';
import 'package:ventimetriquadri/screens/utils.dart';
import 'package:web_browser_detect/web_browser_detect.dart';

import 'menu_screen.dart';


class Home20m2 extends StatefulWidget {
  const Home20m2({Key? key}) : super(key: key);

  static String id = '/';

  @override
  State<Home20m2> createState() => _Home20m2State();
}

class _Home20m2State extends State<Home20m2> {

  bool isVisible = true;
  bool firstAccess = true;

  @override
  void initState() {
    try{
      final browser = Browser();
      print('${browser.browser} ${browser.version}');
      if(browser.browser.toString() == 'Chrome'){
        print('oindsadsd');
        setState(() {

        });
      }
    }catch(e){
      print(e.toString());
    }
    super.initState();

  }

  @override
  Widget build(BuildContext context) {

    double width = MediaQuery.of(context).size.width;
    double height = MediaQuery.of(context).size.height;

    List<String> carouselMapImage = [
      'images/photos/mojito.jpg',
      'images/sala20m2.jpeg',
      'images/photos/squarcio.jpeg',
      'images/photos/drink6.jpg'];

    List<String> carouselMapImageGallery1 = [
      'images/photos/image_1.jpeg',
      'images/photos/image_2.jpeg',
      'images/photos/image_3.jpeg',
      'images/photos/image_4.jpeg',
    ];

    List<String> carouselMapImageGallery2 = [
      'images/photos/image_5.jpeg',
      'images/photos/image_6.jpeg',
      'images/photos/image_7.jpeg',
      'images/photos/image_8.jpeg',
    ];

    List<String> carouselMapImageGallery3 = [
      'images/photos/drink1.jpg',
      'images/photos/drink2.jpg',
      'images/photos/drink3.jpg',
      'images/photos/drink4.jpg',
    ];

    return Consumer<DataBundleNotifier>(
      builder: (child, dataBundle, _){
        return Scaffold(
          floatingActionButton: Visibility(
            visible: isVisible,
            child: FadeAnimation(
              delay: firstAccess ? 5 : 0,
              child: FloatingActionButton(
                backgroundColor: k20m2Orange,
                onPressed: () {
                  showDialog(
                    context: context,
                    builder: (BuildContext context) {
                      return AlertDialog(
                        shape: const RoundedRectangleBorder(
                            borderRadius: BorderRadius.all(Radius.circular(20.0))),
                        contentPadding: EdgeInsets.only(top: 30.0),
                        content: Column(
                          mainAxisSize: MainAxisSize.min,
                          children: [
                            Center(
                                child: Image.asset('images/LOGO_20m2.png', height: height * 1/8)
                            ),
                            const Padding(
                              padding: EdgeInsets.all(8.0),
                              child: Text('PRENOTA UN TAVOLO',
                                  style: TextStyle(fontWeight: FontWeight.bold, color:
                                  Colors.black, fontSize: 20, fontFamily: 'Dance')),
                            ),
                            const SizedBox(height: 30,),
                            const Text('SCEGLI IL LOCALE DOVE VUOI PRENOTARE',
                                style: TextStyle(fontWeight: FontWeight.bold, color:
                                Color(0xff121212), fontSize: 12, fontFamily: 'Dance')),
                            Padding(
                              padding: const EdgeInsets.only(left: 20, right: 20),
                              child: Column(
                                children: [
                                  buildReservationButton('20M2 - CISTERNINO', linkPienissimoCisternino, Colors.black, height, Colors.white, Color(0xff121212)),
                                  buildReservationButton('20M2 - LOCOROTONDO', linkPienissimoLocorotondo, Colors.black, height, Colors.white, Color(0xff121212)),
                                  buildReservationButton('20M2 - MONOPOLI', linkPienissimoMonopoli, Colors.black, height, Colors.white, Color(0xff121212)),
                                ],
                              ),
                            ),
                            SizedBox(height: 30,)
                          ],
                        ),
                      );
                    },
                  );
                },
                child: Text('PRENOTA UN TAVOLO', textAlign: TextAlign.center, style: TextStyle(color: Colors.white, fontSize: height * 1/60, fontWeight: FontWeight.bold, fontFamily: 'Anton', letterSpacing: 0.2)),
              ),
            ),
          ) ,
          drawer: Drawer(
            child: SingleChildScrollView(
              scrollDirection: Axis.vertical,
              child: Column(
                children: [
                  Center(
                      child: Image.asset('images/LOGO_20m2.png', height: height * 1/4)
                  ),
                  SizedBox(width: 10,),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      IconButton(icon: Icon(FontAwesomeIcons.instagram, color: Color(0xff121212), size: 30.0), onPressed: (){
                        _launchUrl('https://www.instagram.com/20m2official');
                      },
                      ),
                      SizedBox(width: 10,),
                      IconButton(icon: Icon(FontAwesomeIcons.facebookF, color: Color(0xff121212), size: 30.0), onPressed: (){
                        _launchUrl('https://www.facebook.com/20m2CisterninoMonopoliLocorotondo');
                      },
                      ),
                    ],
                  ),
                  SizedBox(height: 50),
                  Text('20M2 - PANINI E POI..',
                      style: TextStyle(fontWeight: FontWeight.bold, color:
                      Color(0xff121212), fontSize: 11, fontFamily: 'Dance')),
                  const Padding(
                    padding: EdgeInsets.all(8.0),
                    child: Text('MENU\'',
                        style: TextStyle(fontWeight: FontWeight.bold, color:
                        Colors.black, fontSize: 20, fontFamily: 'Dance')),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: SizedBox(
                      width: 300,
                      height: height * 1/16,
                      child: ElevatedButton(onPressed: (){
                        if(dataBundle.currentCustomerId != 0){
                          Navigator.pushNamed(context, MenuScreen.id);
                        }else{
                          Navigator.pushNamed(context, RegistrationPage.id);
                        }
                      },style: ButtonStyle(
                          backgroundColor: MaterialStateProperty.resolveWith((states) => Colors.white,),
                          shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                              RoundedRectangleBorder(
                                  borderRadius: BorderRadius.circular(18.0),
                                  side: const BorderSide(color: Color(0xff121212))
                              )
                          )
                      ), child: Text('MENU\'',
                          style: TextStyle(fontWeight: FontWeight.bold, color:
                          Color(0xff121212), fontSize: height * 1/40, fontFamily: 'Dance')),),
                    ),
                  ),

                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Column(
                      children: [
                        Text('20M2 - BOOKING',
                            style: TextStyle(fontWeight: FontWeight.bold, color:
                            Color(0xff121212), fontSize: 11, fontFamily: 'Dance')),
                        const Padding(
                          padding: EdgeInsets.all(8.0),
                          child: Text('PRENOTA UN TAVOLO',
                              style: TextStyle(fontWeight: FontWeight.bold, color:
                              Colors.black, fontSize: 20, fontFamily: 'Dance')),
                        ),
                        const SizedBox(height: 20,),
                        const Text('SCEGLI IL LOCALE DOVE VUOI PRENOTARE',
                            style: TextStyle(fontWeight: FontWeight.bold, color:
                            Color(0xff121212), fontSize: 12, fontFamily: 'Dance')),
                        buildReservationButton('20M2 - CISTERNINO', linkPienissimoCisternino, Colors.black, height, Colors.white, Color(0xff121212)),
                        buildReservationButton('20M2 - LOCOROTONDO', linkPienissimoLocorotondo, Colors.black, height, Colors.white, Color(0xff121212)),
                        buildReservationButton('20M2 - MONOPOLI', linkPienissimoMonopoli, Colors.black, height, Colors.white, Color(0xff121212)),
                      ],
                    ),
                  ),
                  SizedBox(height: 40,),
                ],
              ),
            ),
          ),
          backgroundColor: const Color(0xff121212),
          body: NestedScrollView(
            floatHeaderSlivers: true,
            body: NotificationListener<UserScrollNotification>(
              onNotification: (notification){
                if(firstAccess){
                  setState(() {
                    firstAccess = false;
                  });
                }
                if(notification.direction == ScrollDirection.reverse){
                  setState(() {
                    isVisible = false;
                  });
                }else if(notification.direction == ScrollDirection.forward){
                  setState(() {
                    isVisible = true;
                  });
                }
                return true;
              },
              child: SingleChildScrollView(
                scrollDirection: Axis.vertical,
                child: Column(
                  children: [
                    Stack(
                      children: [
                        CarouselSlider(
                          options: CarouselOptions(
                            height: height,
                            autoPlay: true,
                            initialPage: 0,
                            autoPlayInterval: Duration(seconds: 7),

                          ),
                          items: [0,1,2,3].map((i) {
                            return Builder(
                              builder: (BuildContext context) {
                                return Container(
                                  width: width,
                                  margin: EdgeInsets.symmetric(horizontal: 2.0),
                                  decoration: BoxDecoration(
                                    color: const Color(0xff121212),
                                    image: DecorationImage(
                                      fit: BoxFit.cover,
                                      colorFilter: ColorFilter.mode(Colors.black.withOpacity(0.7), BlendMode.darken),
                                      image: AssetImage(carouselMapImage[i]!),
                                    ),
                                  ),
                                );
                              },
                            );
                          }).toList(),
                        ),
                        Container(
                          color: Colors.transparent,
                          height: height,
                          child: Column(
                            mainAxisAlignment: MainAxisAlignment.spaceAround,
                            children: [
                              Padding(
                                padding: const EdgeInsets.all(20.0),
                                child: Column(
                                  children: [
                                    FadeAnimation(
                                      delay: 1,
                                      child: Text('WELCOME TO',
                                          style: TextStyle(fontWeight: FontWeight.bold, color:
                                          k20m2Orange, fontSize: 10, fontFamily: 'Dance')),
                                    ),
                                    FadeAnimation(
                                      delay: 4,
                                      child: Center(
                                          child: Image.asset('images/whitenobg.png', height: height * 1/4)
                                      ),
                                    ),
                                    FadeAnimation(
                                      delay: 1.5,
                                      child: Text('CISTERNINO - LOCOROTONDO - MONOPOLI',
                                          style: TextStyle(fontWeight: FontWeight.bold, color:
                                          k20m2Orange, fontSize: 18, fontFamily: 'Dance')),
                                    ),
                                  ],
                                ),
                              ),
                              Padding(
                                padding: EdgeInsets.only(bottom: height * 1/20),
                                child: Column(
                                  children: [
                                    SizedBox(height: 6,),
                                    FadeAnimation(
                                      delay: 2,
                                      child: SizedBox(
                                        width: 300,
                                        height: height * 1/16,

                                        child: ElevatedButton(onPressed: (){
                                          if(dataBundle.currentCustomerId != 0){
                                            Navigator.pushNamed(context, MenuScreen.id);
                                          }else{
                                            Navigator.pushNamed(context, RegistrationPage.id);
                                          }
                                        },style: ButtonStyle(
                                            backgroundColor: MaterialStateProperty.resolveWith((states) => Colors.transparent,),
                                            shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                                                RoundedRectangleBorder(
                                                    borderRadius: BorderRadius.circular(18.0),
                                                    side: const BorderSide(color: Colors.white)
                                                )
                                            )
                                        ), child: Text('MENU\'',
                                            style: TextStyle(fontWeight: FontWeight.bold, color:
                                            Color(0xFFfdfdff), fontSize: height * 1/40, fontFamily: 'Dance')),),
                                      ),
                                    ),
                                    FadeAnimation(
                                      delay: 2,
                                      child: Padding(
                                        padding: const EdgeInsets.all(28.0),
                                        child: Column(
                                          children: [
                                            const Text('SEGUICI SUI NOSTRI CANALI SOCIAL',
                                                style: TextStyle(fontWeight: FontWeight.bold, color:
                                                Colors.white, fontSize: 12, fontFamily: 'Dance')),
                                            Row(
                                              mainAxisAlignment: MainAxisAlignment.center,
                                              children: [
                                                IconButton(icon: Icon(FontAwesomeIcons.instagram, color: Colors.white, size: 30.0), onPressed: (){
                                                  _launchUrl('https://www.instagram.com/20m2official');
                                                },
                                                ),
                                                SizedBox(width: 10,),
                                                IconButton(icon: Icon(FontAwesomeIcons.facebookF, color: Colors.white, size: 30.0), onPressed: (){
                                                  _launchUrl('https://www.facebook.com/20m2CisterninoMonopoliLocorotondo');
                                                },
                                                ),
                                              ],
                                            ),
                                          ],
                                        ),
                                      ),
                                    ),
                                  ],
                                ),
                              ),
                            ],
                          ),
                        ),
                      ],
                    ),
                    Container(width: width, height: 2, color: Colors.white,),
                    SizedBox(height: 30,),
                    Center(
                        child: Image.asset('images/whitenobg.png', height: height * 1/17)
                    ),
                    Text('20M2 - HISTORIE',
                        style: TextStyle(fontWeight: FontWeight.bold, color:
                        k20m2grey, fontSize: 11, fontFamily: 'Dance')),
                    buildContentText('Ciao', 20, width),
                    buildContentText('Siamo due ragazzi che, armati solo della passione per il proprio lavoro, hanno aperto un piccolo cocktail bar, nel centro storico di Cisternino. Un locale piccolo ed accogliente.  Piccolo davvero eh, solo 20 metri quadri. ', 18, width ),
                    buildContentText('Siamo orgogliosi, dopo 10 anni, di poter proporre il nostro concept anche al di fuori delle mura di casa (con una sede a Locorotondo e una a Monopoli). ', 18, width),
                    buildContentText('Siamo soddisfatti finora del lavoro che abbiamo fatto, ma sappiamo che di strada ce n\'è ancora tanta da fare..', 18, width),
                    buildContentText('Siamo Mattia e Daniele, e vi diamo il benvenuto al 20m2.', 18, width),
                    Padding(
                      padding: const EdgeInsets.all(18.0),
                      child: ClipRRect(
                          borderRadius: BorderRadius.circular(20),
                          child: Image.asset('images/mattia_daniele.jpg')),
                    ),
                    SizedBox(height: 30,),

                    Center(
                        child: Image.asset('images/whitenobg.png', height: height * 1/17)
                    ),
                    Text('20M2 - HEROES',
                        style: TextStyle(fontWeight: FontWeight.bold, color:
                        k20m2grey, fontSize: 11, fontFamily: 'Dance')),
                    Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: Text('IL NOSTRO STAFF',
                          style: TextStyle(fontWeight: FontWeight.bold, color:
                          Colors.white, fontSize: 20, fontFamily: 'Dance')),
                    ),

                    SizedBox(height: 20,),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      children: [
                        buildAvatarWidget('Mattia', 'https://www.instagram.com/mattia_20m2/', 'https://www.facebook.com/mattia.liuzzi', 'Boss', 'images/staff/mattia.jpg', width, height),
                        buildAvatarWidget('Daniele', 'https://www.instagram.com/daniele20m2/', 'https://www.facebook.com/daniele.perrini.1', 'Boss', 'images/staff/daniperrini.jpeg', width, height),
                      ],
                    ),
                    SizedBox(height: height * 1/10,),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      children: [
                        buildAvatarWidget('Francesco', 'https://www.instagram.com/francesco_miccolis92/', 'https://www.facebook.com/nocerina', 'Responsabile 20m2 Cisternino', 'images/staff/nocerina.jpeg', width, height),
                      ],
                    ),
                    SizedBox(height: height * 1/10,),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                      children: [
                        buildAvatarWidget('Annalisa', 'https://www.instagram.com/la_solito_a/', 'https://www.facebook.com/annalisa.solito', 'Responsabile 20m2 Locorotondo', 'images/staff/respo_loco.jpeg', width, height),
                        buildAvatarWidget('Fabio', 'https://www.instagram.com/fabio_secundo85/', 'https://www.facebook.com/Fabiosecundo85', 'Responsabile 20m2 Monopoli', 'images/staff/fabio.jpeg', width, height),
                      ],
                    ),

                    SizedBox(height: 150,),
                    Center(
                        child: Image.asset('images/whitenobg.png', height: height * 1/17)
                    ),
                    Text('20M2 - PANINI E POI...',
                        style: TextStyle(fontWeight: FontWeight.bold, color:
                        k20m2grey, fontSize: 11, fontFamily: 'Dance')),
                    Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: Text('MENU\'',
                          style: TextStyle(fontWeight: FontWeight.bold, color:
                          Colors.white, fontSize: 20, fontFamily: 'Dance')),
                    ),
                    SizedBox(height: 40,),
                    SizedBox(
                      width: 300,
                      height: height * 1/16,

                      child: ElevatedButton(onPressed: (){
                        if(dataBundle.currentCustomerId != 0){
                          Navigator.pushNamed(context, MenuScreen.id);
                        }else{
                          Navigator.pushNamed(context, RegistrationPage.id);
                        }

                      },style: ButtonStyle(
                          backgroundColor: MaterialStateProperty.resolveWith((states) => Colors.transparent,),
                          shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                              RoundedRectangleBorder(
                                  borderRadius: BorderRadius.circular(18.0),
                                  side: const BorderSide(color: Colors.white)
                              )
                          )
                      ), child: Text('MENU\'',
                          style: TextStyle(fontWeight: FontWeight.bold, color:
                          const Color(0xFFfdfdff), fontSize: height * 1/40, fontFamily: 'Dance')),),
                    ),
                    SizedBox(height: 150,),
                    Center(
                        child: Image.asset('images/whitenobg.png', height: height * 1/17)
                    ),
                    Text('20M2 - BOOKING',
                        style: TextStyle(fontWeight: FontWeight.bold, color:
                        k20m2grey, fontSize: 11, fontFamily: 'Dance')),
                    const Padding(
                      padding: EdgeInsets.all(8.0),
                      child: Text('PRENOTA UN TAVOLO',
                          style: TextStyle(fontWeight: FontWeight.bold, color:
                          Colors.white, fontSize: 20, fontFamily: 'Dance')),
                    ),
                    const SizedBox(height: 20,),
                    Text('SCEGLI IL LOCALE DOVE VUOI PRENOTARE',
                        style: TextStyle(fontWeight: FontWeight.bold, color:
                        k20m2grey, fontSize: 12, fontFamily: 'Dance')),
                    buildReservationButton('20M2 - CISTERNINO', linkPienissimoCisternino, const Color(0xFFfdfdff), height, Colors.transparent, Colors.white),
                    buildReservationButton('20M2 - LOCOROTONDO', linkPienissimoLocorotondo, Color(0xFFfdfdff), height, Colors.transparent, Colors.white),
                    buildReservationButton('20M2 - MONOPOLI', linkPienissimoMonopoli, const Color(0xFFfdfdff), height, Colors.transparent, Colors.white),
                    SizedBox(height: 150,),

                    Container(width: width, height: 2, color: Colors.white,),
                    Container(
                      height: height,
                      decoration: BoxDecoration(
                        image: DecorationImage(

                          colorFilter: ColorFilter.mode(Colors.grey.shade900.withOpacity(0.6), BlendMode.dstATop),
                          image: const AssetImage("images/catering.jpg"),
                          fit: BoxFit.cover,
                        ),
                      ),
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          Column(
                            children: [
                              const SizedBox(height: 40,),
                              Center(
                                  child: Image.asset('images/whitenobg.png', height: height * 1/17)
                              ),
                              Text('20M2 - THE PARTY MUST GO ON',
                                  style: TextStyle(fontWeight: FontWeight.bold, color:
                                  Colors.grey.shade50, fontSize: 11, fontFamily: 'Dance')),
                              const Padding(
                                padding: EdgeInsets.all(8.0),
                                child: Text('CATERING',
                                    style: TextStyle(fontWeight: FontWeight.bold, color:
                                    Colors.white, fontSize: 20, fontFamily: 'Dance')),
                              ),
                            ],
                          ),
                          Column(
                            children: [
                              const Padding(
                                padding: EdgeInsets.all(8.0),
                                child: Text('PER I TUOI EVENTI PRIVATI, FESTE E RICORRENZE',
                                    style: TextStyle(fontWeight: FontWeight.bold, color:
                                    Colors.white, fontSize: 16, fontFamily: 'Dance')),
                              ),
                              SizedBox(
                                width: 300,
                                height: height * 1/16,

                                child: ElevatedButton(onPressed: (){
                                  _launchUrl('https://api.whatsapp.com/send/?phone=3803268119');
                                },style: ButtonStyle(
                                    backgroundColor: MaterialStateProperty.resolveWith((states) => Colors.transparent,),
                                    shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                                        RoundedRectangleBorder(
                                            borderRadius: BorderRadius.circular(18.0),
                                            side: const BorderSide(color: Colors.white)
                                        )
                                    )
                                ), child: Text('CONTATTACI',
                                    style: TextStyle(fontWeight: FontWeight.bold, color:
                                    Color(0xFFfdfdff), fontSize: height * 1/40, fontFamily: 'Dance')),),
                              ),
                              const SizedBox(height: 70,),
                            ],
                          ),
                        ],
                      ),
                    ),
                    Container(width: width, height: 2, color: Colors.white,),
                    SizedBox(height: 40,),
                    Center(
                        child: Image.asset('images/whitenobg.png', height: height * 1/17)
                    ),
                    Text('20M2 - AROUND THE WORLD',
                        style: TextStyle(fontWeight: FontWeight.bold, color:
                        k20m2grey, fontSize: 11, fontFamily: 'Dance')),
                    const Padding(
                      padding: EdgeInsets.all(8.0),
                      child: Text('DOVE SIAMO?',
                          style: TextStyle(fontWeight: FontWeight.bold, color:
                          Colors.white, fontSize: 20, fontFamily: 'Dance')),
                    ),
                    Column(
                      children: [
                        buildMapWidget('CISTERNINO', 'VIA G. D\'AMICO, 11, 72014 CISTERNINO BR', 'FRANCESCO', '0803218638', 'mattialiuzzi@20m2.it', 'https://www.google.com/maps/place/20m2/@40.7412092,17.4268431,15z/data=!4m2!3m1!1s0x0:0xc70c2384f2cb2a7f?sa=X&ved=2ahUKEwjC-J7zpJj7AhWIxgIHHQEXBSwQ_BJ6BAhuEB8', width, height),
                        buildMapWidget('LOCOROTONDO', 'VIA NARDELLI, 71, 70010 LOCOROTONDO BA', 'ANNALISA', '0809683953', 'mattialiuzzi@20m2.it', 'https://www.google.com/maps/place/Via+Nardelli,+71,+70010+Locorotondo+BA/data=!4m2!3m1!1s0x134652846db56657:0x41fbe1e004dbc47e?sa=X&ved=2ahUKEwjA5qGppZj7AhVM2aQKHXsHBSMQ8gF6BAgSEAE', width, height),
                        buildMapWidget('MONOPOLI', 'VIA GIUSEPPE GARIBALDI, 66, 70043 MONOPOLI BA', 'FABIO', '0802462083', 'mattialiuzzi@20m2.it', 'https://www.google.com/maps/place/Via+Giuseppe+Garibaldi,+66,+70043+Monopoli+BA/data=!4m2!3m1!1s0x13463525e589d68f:0x69373dc55438897e?sa=X&ved=2ahUKEwjc3cC0pZj7AhVE6aQKHYr4D_gQ8gF6BAgQEAE', width, height),
                      ],
                    ),

                    SizedBox(height: 80,),
                    Center(
                        child: Image.asset('images/whitenobg.png', height: height * 1/17)
                    ),
                    Text('20M2 - IT\'S DAMN LONG TIME BETWEEN DRINKS',
                        style: TextStyle(fontWeight: FontWeight.bold, color:
                        k20m2grey, fontSize: 11, fontFamily: 'Dance')),
                    const Padding(
                      padding: EdgeInsets.all(8.0),
                      child: Text('GALLERIA',
                          style: TextStyle(fontWeight: FontWeight.bold, color:
                          Colors.white, fontSize: 20, fontFamily: 'Dance')),
                    ),
                    Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: CarouselSlider(
                        options: CarouselOptions(
                          height: height * 1/3,
                          autoPlay: true,
                          initialPage: 0,
                          autoPlayInterval: Duration(seconds: 4),

                        ),
                        items: [0,1,2,3].map((i) {
                          return Builder(
                            builder: (BuildContext context) {
                              return Container(
                                width: width,
                                margin: EdgeInsets.symmetric(horizontal: 8.0),
                                decoration: BoxDecoration(
                                  color: const Color(0xff121212),
                                  image: DecorationImage(
                                    fit: BoxFit.cover,
                                    colorFilter: ColorFilter.mode(Colors.black.withOpacity(0.1), BlendMode.darken),
                                    image: AssetImage(carouselMapImageGallery1[i]!),
                                  ),
                                ),
                              );
                            },
                          );
                        }).toList(),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: CarouselSlider(
                        options: CarouselOptions(
                          height: height * 1/3,
                          autoPlay: true,
                          reverse: true,
                          initialPage: 0,
                          autoPlayInterval: Duration(seconds: 7),

                        ),
                        items: [0,1,2,3].map((i) {
                          return Builder(
                            builder: (BuildContext context) {
                              return Container(
                                width: width,
                                margin: EdgeInsets.symmetric(horizontal: 8.0),
                                decoration: BoxDecoration(
                                  color: const Color(0xff121212),
                                  image: DecorationImage(
                                    fit: BoxFit.cover,
                                    colorFilter: ColorFilter.mode(Colors.black.withOpacity(0.1), BlendMode.darken),
                                    image: AssetImage(carouselMapImageGallery2[i]!),
                                  ),
                                ),
                              );
                            },
                          );
                        }).toList(),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.all(8.0),
                      child: CarouselSlider(
                        options: CarouselOptions(
                          height: height * 1/3,
                          autoPlay: true,
                          initialPage: 0,
                          autoPlayInterval: Duration(seconds: 8),

                        ),
                        items: [0,1,2,3].map((i) {
                          return Builder(
                            builder: (BuildContext context) {
                              return Container(
                                width: width,
                                margin: EdgeInsets.symmetric(horizontal: 8.0),
                                decoration: BoxDecoration(
                                  color: const Color(0xff121212),
                                  image: DecorationImage(
                                    fit: BoxFit.cover,
                                    colorFilter: ColorFilter.mode(Colors.black.withOpacity(0.1), BlendMode.darken),
                                    image: AssetImage(carouselMapImageGallery3[i]!),
                                  ),
                                ),
                              );
                            },
                          );
                        }).toList(),
                      ),
                    ),
                    SizedBox(height: 170,),
                    Center(
                        child: Image.asset('images/whitenobg.png', height: height * 1/10)
                    ),
                    Text('Designed and developed by Angelo Amati',
                        style: TextStyle(fontWeight: FontWeight.bold, color:
                        k20m2grey, fontSize: 9, fontFamily: 'Dance')),
                    SizedBox(height: 30,),
                  ],
                ),
              ),
            ), headerSliverBuilder: (BuildContext context, bool innerBoxIsScrolled) {
            return [
              SliverAppBar(
                floating: true,
                snap: true,
                actions: [
                  IconButton(icon: Icon(FontAwesomeIcons.instagram, color: Colors.white, size: 30.0), onPressed: (){
                    _launchUrl('https://www.instagram.com/20m2official');
                  },
                  ),
                  const SizedBox(width: 10,),
                  IconButton(icon: const Icon(FontAwesomeIcons.facebookF, color: Colors.white, size: 30.0), onPressed: (){
                    _launchUrl('https://www.facebook.com/20m2CisterninoMonopoliLocorotondo');
                  },
                  ),
                  SizedBox(width: 10,),
                ],
                backgroundColor: const Color(0xff121212),
              ),
            ];
          },
          ),
        );
      },
    );
  }

  buildContentText(String text, double size, double width) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: SizedBox(
        width: width - 20,
        child: Text(text,
            textAlign: TextAlign.center,
            style: TextStyle(fontWeight: FontWeight.bold, color:
            Colors.white, fontSize: size, fontFamily: 'Dance')),
      ),
    );
  }

  Future<void> _launchUrl(String url) async {
    if (!await launchUrl(Uri.parse(url))) {
      throw 'Could not launch $url';
    }
  }

  buildAvatarWidget(String name, String instagramLink, String facebookLink, String position, String photo, double width, double height) {
    return Column(
      children: [
        CircleAvatar(
          backgroundColor: Colors.white,
          radius: width * 1/6 * 1.009,
          child: CircleAvatar(
            radius: width * 1/6,
            backgroundImage: AssetImage(photo),
          ),
        ),
        Padding(
          padding: const EdgeInsets.all(8.0),
          child: Text(name,
              style: TextStyle(fontWeight: FontWeight.bold, color:
              Colors.white, fontSize: width * 1/30, fontFamily: 'Dance')),
        ),
        SizedBox(
          width: width * 1/3,
          child: Text(position,
              textAlign: TextAlign.center,
              style: TextStyle(fontWeight: FontWeight.bold, color:
              k20m2Orange, fontSize: width * 1/40, fontFamily: 'Dance')),
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            IconButton(icon: Icon(FontAwesomeIcons.instagram, color: Colors.white, size: 24.0), onPressed: (){
              _launchUrl(instagramLink);
            },
            ),
            SizedBox(width: 10,),
            IconButton(icon: Icon(FontAwesomeIcons.facebookF, color: Colors.white, size: 24.0), onPressed: (){
              _launchUrl(facebookLink);
            },
            ),
          ],
        ),
      ],
    );
  }

  buildMapWidget(String nameBranch,
      String address,
      String responsable,
      String phone,
      String mail,
      String urlGoogleMaps,
      double width,
      double height) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Container(

        color: const Color(0xff202020),
        child: Padding(
          padding: const EdgeInsets.all(18.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Padding(
                padding: EdgeInsets.all(8.0),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.start,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Row(
                      children: [
                        Text(nameBranch,
                            style: const TextStyle(fontWeight: FontWeight.bold, color:
                            Colors.white, fontSize: 23, fontFamily: 'Dance')),
                        IconButton(
                          icon: const Icon(FontAwesomeIcons.phone, color: Colors.white),
                          onPressed: (){
                            _launchUrl('tel:$phone');
                          },
                        )
                      ],
                    ),
                    const SizedBox(height: 30,),
                    Text(address,
                        style: TextStyle(fontWeight: FontWeight.bold, color:
                        k20m2Orange, fontSize: 18, fontFamily: 'Dance')),
                    const SizedBox(height: 5,),
                    Text('Responsabile: $responsable',
                        style: TextStyle(fontWeight: FontWeight.bold, color:
                        k20m2grey, fontSize: 18, fontFamily: 'Dance')),
                    const SizedBox(height: 5,),
                    Text('Phone: $phone',
                        style: const TextStyle(fontWeight: FontWeight.bold, color:
                        Colors.white, fontSize: 18, fontFamily: 'Dance')),
                    const SizedBox(height: 5,),
                    Text('email: $mail',
                        style: const TextStyle(fontWeight: FontWeight.bold, color:
                        Colors.white, fontSize: 18, fontFamily: 'Dance')),
                  ],
                ),
              ),
              GestureDetector(
                onTap: (){
                  _launchUrl(urlGoogleMaps);
                },
                child: SizedBox(
                    height: width - 30,
                    width: width - 30,
                    child: Image.asset('images/cistemap.JPG')),
              ),
            ],
          ),
        ),

      ),
    );
  }

  buildReservationButton(String name, String linkReservationPienissimo, Color color, double height, Color insideButtonColor, Color borderColor) {
    return Padding(
      padding: const EdgeInsets.only(top: 20),
      child: SizedBox(
        width: 300,
        height: height * 1/16,
        child: ElevatedButton(
          onPressed: (){
            _launchUrl(linkReservationPienissimo);
          },
          style: ButtonStyle(
              backgroundColor: MaterialStateProperty.resolveWith((states) => insideButtonColor,),
              shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                  RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(18.0),
                      side: BorderSide(color: borderColor)
                  )
              )
          ), child: Text(name,
            style: TextStyle(fontWeight: FontWeight.bold, color:
            color, fontSize: height * 1/40, fontFamily: 'Dance')),),
      ),
    );
  }
}
