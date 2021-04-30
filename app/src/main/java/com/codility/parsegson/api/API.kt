package com.codility.parsegson.api

import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


/**
 * Created by Govind on 2/12/2018.
 */
class API {

    companion object {
        fun getData(SERVER_URL: String): String {
            var result: String = "";
            try {
                val URL = URL(SERVER_URL)
                val connect = URL.openConnection() as HttpURLConnection

                connect.readTimeout = 8000
                connect.connectTimeout = 8000
                connect.requestMethod = "GET"
                connect.doOutput = true;
                connect.connect();

                val ResponseCode: Int = connect.responseCode;
                Log.d("Tag", "ResponseCode" + ResponseCode)

                if (ResponseCode == 200) {
                    val tempStream: InputStream = connect.inputStream;
                    if (tempStream != null) {
                        result = convertToString(tempStream);
                    }
                }
            } catch (Ex: Exception) {
                Log.d("", "Error in doInBackground " + Ex.message);
            }
            return result
        }

        private fun convertToString(inStream: InputStream): String {
            var result: String = ""
            val isReader = InputStreamReader(inStream)
            var bReader = BufferedReader(isReader)
            var temp_str: String?

            try {

                while (true) {
                    temp_str = bReader.readLine()
                    if (temp_str == null) {
                        break
                    }
                    result += temp_str;
                }
            } catch (Ex: Exception) {
                Log.e("Tag", "Error in ConvertToString " + Ex.printStackTrace())
            }
            return result
        }
    }
}