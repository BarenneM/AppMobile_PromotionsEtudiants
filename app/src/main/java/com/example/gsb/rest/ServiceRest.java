package com.example.gsb.rest;

    import android.util.Log;

    import retrofit2.Retrofit;
    import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceRest {

        private static final String TAG = "ServiceRest";
        private static IServiceRest serviceRest;
        public static IServiceRest getInstance(){
            if(serviceRest == null){
                Log.i(TAG, "========= initServiceRest ========");
                serviceRest = new Retrofit.Builder()
                        .baseUrl(IServiceRest.ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(IServiceRest.class);
            }
            return serviceRest;
        }
    }

