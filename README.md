# Parse Gson
Android application for Parsing Json Array Using Gson in Android Kotlin and make Http request using AsyncTask.

# Gson
JSON-“JavaScript Object Notation” is very well structured, light weight and easy to parse. It is the best alternative for XML. For automatic JSON parsing we are going to use [Google GSON](https://github.com/google/gson) library. GSON is open source library which is used to convert JSON data into java objects and vice versa. GSON can work with arbitrary Java objects including pre-existing objects that you do not have source-code of.  It provides two methods fromJson()  -“ convert JSON format to java objects” and  toJson()  – “create JSON from java objects”. In this tutorial we are going to discuss about JSON parsing for JSON Array formats using GSON Library.

# AsyncTask
[Android AsyncTask](https://developer.android.com/reference/android/os/AsyncTask.html)is an abstract class provided by Android which gives us the liberty to perform heavy tasks in the background and keep the UI thread light thus making the application more responsive.

Android application runs on a single thread when launched. Due to this single thread model tasks that take longer time to fetch the response can make the application non-responsive. To avoid this we use android AsyncTask to perform the heavy tasks in background on a dedicated thread and passing the results back to the UI thread. Hence use of AsyncTask in android application keeps the UI thread responsive at all times.

# Add Dependencies
dependencies {

    implementation 'com.google.code.gson:gson:2.8.0'
}

# Parsing Gson Code
    // Parse Json ArrayList Using GSON library
    val listType = object : TypeToken<ArrayList<Bean>>() {}.type
    val beanArrayList: ArrayList<Bean> = GsonBuilder().create().fromJson(result, listType)

GSON 1     |  GSON 2 |
:---------:|:----------:
![](https://github.com/AndroidCodility/ParseGson/blob/master/design/loading.png?raw=true)  |  ![](https://github.com/AndroidCodility/ParseGson/blob/master/design/gson_list.png?raw=true)

# Play Video
[![](https://github.com/AndroidCodility/ParseGson/blob/master/design/gson_video.png?raw=true)](https://youtu.be/L3Lw2klPgfU "Click here to watch")

# Like Facebook Page
[![](https://github.com/AndroidCodility/Barchart-Graph/blob/master/design/fb.png?raw=true)](https://www.facebook.com/androidcodility/ "Click here")
