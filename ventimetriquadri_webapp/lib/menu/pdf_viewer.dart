import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';
import 'package:pdf_render/pdf_render_widgets.dart';
import 'package:provider/provider.dart';
import 'package:syncfusion_flutter_pdfviewer/pdfviewer.dart';

import '../databundle/data_bundle_notifier.dart';

class PdfViewerPage extends StatefulWidget {
  const PdfViewerPage({Key? key}) : super(key: key);

  @override
  State<PdfViewerPage> createState() => _PdfViewerPageState();
}

class _PdfViewerPageState extends State<PdfViewerPage> {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Consumer<DataBundleNotifier>(
        builder: (child, databundle, _){
          return Scaffold(
            appBar: AppBar(
              leading: IconButton(
                icon: Icon(Icons.arrow_back_ios),
                onPressed: (){
                  Navigator.of(context).pop();
                },
              ),
              actions: [
                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: IconButton(icon: SvgPicture.asset(databundle.currentLanguage == 'ITA' ? 'images/uk.svg' : 'images/ita.svg', width: 40), onPressed: () {
                    databundle.switchCurrentLanguage();
                  },),
                ),

              ],
              elevation: 0,
              backgroundColor: const Color(0xFFc39a6b),
              title: Text('Menu 20m² ${databundle.currentBranch.name}', style: TextStyle(fontFamily: 'Dance', fontWeight: FontWeight.bold),),
            ),
            body: PdfViewer.openAsset(
                databundle.currentLanguage == 'ITA' ? databundle.currentPdfIta : databundle.currentPdfEng,

            ),
          );
        },
      ),
    );
  }
}
