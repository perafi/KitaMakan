package com.example.kitamakan.service

import com.example.kitamakan.BuildConfig
import com.example.kitamakan.MyApplication
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    companion object {

        fun getClient() : ApiInterface {

            val chuckInterceptor = MyApplication.chuckInterceptor
            //initialized logger
            val okHttpLoggingInterceptor = HttpLoggingInterceptor() // Ini Berfungsin untuk membuat Log

            if (BuildConfig.DEBUG)
                okHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            else
                okHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)

            // Menyamakan Header dengan yang dibutuhkan oleh server
            val interceptor = Interceptor { chain ->

                //initialized auth
                //val basicAuth = Credentials.basic(CredentialsConst().AUTH_USERNAME, CredentialsConst().AUTH_PASSWORD)

                val request = chain.request().newBuilder()
                    .removeHeader("Content-Type")
                    .addHeader( "Content-Type", "application/json")
                    .build()

                return@Interceptor chain.proceed(request)
            }

            // Membungkus Logging dan Header ,, tambahkan juga time out
            val okHttpClient = OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(okHttpLoggingInterceptor)
                .addInterceptor(interceptor)
                .addInterceptor(chuckInterceptor)
                .build()


            //inisialisasi GSON untuk mengubah JSON menjadi String
            val gson = GsonBuilder().create()

            //initialized retrofit
            val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BuildConfig.BASEURL)
                .build()

            val service: ApiInterface = retrofit.create(
                ApiInterface::class.java)

            return service
        }
    }
}