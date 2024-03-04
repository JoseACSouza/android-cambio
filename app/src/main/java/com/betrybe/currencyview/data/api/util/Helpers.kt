package com.betrybe.currencyview.data.api.util
    import com.betrybe.currencyview.data.api.ApiService
    import okhttp3.Interceptor
    import okhttp3.OkHttpClient
    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory

object Helpers {

        private var retrofit: Retrofit? = null

        fun getInstance(): ApiService {
            if (retrofit == null) {
                val headerInterceptor = Interceptor { chain ->
                    val request = chain.request()
                        .newBuilder()
                        .addHeader("apikey", "gKSrABlHD03DgJxz5bn3CKCC0XK4gY01")
                        .build()
                    chain.proceed(request)
                }
                val client = OkHttpClient.Builder().addInterceptor(headerInterceptor).build()
                retrofit = Retrofit.Builder().baseUrl("https://api.apilayer.com/exchangerates_data/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit?.create(ApiService::class.java)!!
        }
    }
