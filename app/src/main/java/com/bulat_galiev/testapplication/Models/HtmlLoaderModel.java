package com.bulat_galiev.testapplication.Models;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by BulatGaliev on 09.09.16.
 * The class is used to load html code by url
 */
public class HtmlLoaderModel {
    public String loadHtml(String urlString) throws IOException {
        URL url;
        url = new URL(urlString);

//        Opening new connection
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
//            Enable streaming as we don't know the content length
            urlConnection.setChunkedStreamingMode(0);
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            return readStream(in);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }

    //    The method is used to read all chars into one string
    private static String readAll(Reader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int singleInt;
        while ((singleInt = reader.read()) != -1) {
            stringBuilder.append((char) singleInt);
        }
        return stringBuilder.toString();
    }

    //    The method is used to read stream into buffer
    public String readStream(InputStream in) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
            return readAll(bufferedReader);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
