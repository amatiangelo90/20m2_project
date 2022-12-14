package com.acorp.ventimetriquadri.website;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class PienissimoClient{

    private static final Logger logger = LoggerFactory.getLogger(PienissimoClient.class);

    public void post(String data) {
        try {

            logger.info("Call in POST the following url [https://engine.pienissimo.com/v3/ordini/inserisciClienteMenu] with body request [ " + data + " ]");
            URL url = new URL("https://engine.pienissimo.com/v3/ordini/inserisciClienteMenu");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(data.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            logger.info("Output from Pienissimo server .... \n");
            while ((output = br.readLine()) != null) {
                logger.info(output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
