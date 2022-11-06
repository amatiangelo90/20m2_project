import 'package:carousel_slider/carousel_slider.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:modal_side_sheet/modal_side_sheet.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:ventimetriquadri/screens/pages/fade_animation.dart';
import 'package:ventimetriquadri/screens/pages/registration_page.dart';
import 'package:ventimetriquadri/screens/utils.dart';


class Home20m2 extends StatefulWidget {
  const Home20m2({Key? key}) : super(key: key);

  static String id = '/';

  @override
  State<Home20m2> createState() => _Home20m2State();
}

class _Home20m2State extends State<Home20m2> {

  @override
  Widget build(BuildContext context) {

    double width = MediaQuery.of(context).size.width;
    double height = MediaQuery.of(context).size.height;

    List<String> carouselMapImage = [
      'images/sala20m2.jpeg',
      'images/photos/squarcio.jpeg',
      'images/photos/mojito.jpg',
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

    return Scaffold(
      appBar: AppBar(
        actions: [
          IconButton(icon: Icon(FontAwesomeIcons.instagram, color: Colors.white, size: 30.0), onPressed: (){
            _launchUrl('https://www.instagram.com/20m2official');
          },
          ),
          SizedBox(width: 10,),
          IconButton(icon: Icon(FontAwesomeIcons.facebookF, color: Colors.white, size: 30.0), onPressed: (){
            _launchUrl('https://www.facebook.com/20m2CisterninoMonopoliLocorotondo');
          },
          ),
          SizedBox(width: 10,),
        ],
        backgroundColor: Color(0xff121212),
      ),
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
              SizedBox(height: 40,),
              Column(
                children: [
                  buildMapWidget('CISTERNINO', 'VIA G. D\'AMICO, 11, 72014 CISTERNINO BR', 'FRANCESCO', '0803218638', 'mattialiuzzi@20m2.it', 'https://www.google.com/maps/place/20m2/@40.7412092,17.4268431,15z/data=!4m2!3m1!1s0x0:0xc70c2384f2cb2a7f?sa=X&ved=2ahUKEwjC-J7zpJj7AhWIxgIHHQEXBSwQ_BJ6BAhuEB8', width, height),
                  buildMapWidget('LOCOROTONDO', 'VIA NARDELLI, 71, 70010 LOCOROTONDO BA', 'ANNALISA', '0809683953', 'mattialiuzzi@20m2.it', 'https://www.google.com/maps/place/Via+Nardelli,+71,+70010+Locorotondo+BA/data=!4m2!3m1!1s0x134652846db56657:0x41fbe1e004dbc47e?sa=X&ved=2ahUKEwjA5qGppZj7AhVM2aQKHXsHBSMQ8gF6BAgSEAE', width, height),
                  buildMapWidget('MONOPOLI', 'VIA GIUSEPPE GARIBALDI, 66, 70043 MONOPOLI BA', 'FABIO', '0802462083', 'mattialiuzzi@20m2.it', 'https://www.google.com/maps/place/Via+Giuseppe+Garibaldi,+66,+70043+Monopoli+BA/data=!4m2!3m1!1s0x13463525e589d68f:0x69373dc55438897e?sa=X&ved=2ahUKEwjc3cC0pZj7AhVE6aQKHYr4D_gQ8gF6BAgQEAE', width, height),
                ],
              )
            ],
          ),
        ),
      ),
      backgroundColor: Color(0xff121212),
      body: SingleChildScrollView(
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
                                  Navigator.pushNamed(context, RegistrationPage.id);
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
                buildAvatarWidget('Daniele', 'https://www.instagram.com/daniele20m2/', 'https://www.facebook.com/daniele.perrini.1', 'Boss', 'images/staff/daniele.jpg', width, height),
              ],
            ),
            SizedBox(height: height * 1/10,),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                buildAvatarWidget('Francesco', 'https://www.instagram.com/francesco_miccolis92/', 'https://www.facebook.com/nocerina', 'Responsabile 20m2 Cisternino', 'images/staff/nocerina.jpeg', width, height),
                buildAvatarWidget('Fabio', 'instagramlink', 'facebooklink', 'Responsabile 20m2 Monopoli', 'images/staff/fabio.jpeg', width, height),
              ],
            ),
            SizedBox(height: height * 1/10,),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                buildAvatarWidget('Annalisa', 'instagramlink', 'facebooklink', 'Responsabile 20m2 Locorotondo', 'images/staff/respo_loco.jpeg', width, height),
              ],
            ),
            SizedBox(height: 40,),
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
            SizedBox(height: 50,),
            Container(width: width, height: 2, color: Colors.white,),
            Container(
              height: height,
              decoration: BoxDecoration(
                image: DecorationImage(
                  colorFilter: ColorFilter.mode(Colors.black.withOpacity(0.5), BlendMode.hardLight),
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
                        k20m2grey, fontSize: 11, fontFamily: 'Dance')),
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
            SizedBox(height: 40,),
            Center(
                child: Image.asset('images/whitenobg.png', height: height * 1/17)
            ),
            Text('20M2 - CHI PRIMA ARRIVA..',
                style: TextStyle(fontWeight: FontWeight.bold, color:
                k20m2grey, fontSize: 11, fontFamily: 'Dance')),
            const Padding(
              padding: EdgeInsets.all(8.0),
              child: Text('PRENOTA UN TAVOLO',
                  style: TextStyle(fontWeight: FontWeight.bold, color:
                  Colors.white, fontSize: 20, fontFamily: 'Dance')),
            ),
            SizedBox(height: 20,),
            SizedBox(
              width: 300,
              height: height * 1/16,

              child: ElevatedButton(onPressed: (){
              },style: ButtonStyle(
                  backgroundColor: MaterialStateProperty.resolveWith((states) => Colors.transparent,),
                  shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                      RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(18.0),
                          side: const BorderSide(color: Colors.white)
                      )
                  )
              ), child: Text('PRENOTA',
                  style: TextStyle(fontWeight: FontWeight.bold, color:
                  Color(0xFFfdfdff), fontSize: height * 1/40, fontFamily: 'Dance')),),
            ),
            SizedBox(height: 80,),
            Center(
                child: Image.asset('images/whitenobg.png', height: height * 1/17)
            ),
            Text('20M2 - GIOVANI E BELLI',
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
            SizedBox(height: 100,),
            Center(
                child: Image.asset('images/whitenobg.png', height: height * 1/10)
            ),
            SizedBox(height: 30,),
            Text('Designed and developed by Angelo Amati',
                style: TextStyle(fontWeight: FontWeight.bold, color:
                k20m2grey, fontSize: 9, fontFamily: 'Dance')),
            SizedBox(height: 30,),
          ],
        ),
      ),
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
}
