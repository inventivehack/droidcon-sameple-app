package com.inventive.hack.halotesting.common.data.cloud;

import android.support.annotation.NonNull;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Realiza la configuración de todos los  clientes que se comunica con el servidor utlizando {@link
 * Retrofit}
 *
 * @see <p>Para más información ver la documentación de <a href="https://square.github.io/retrofit/">Retrofit</a></p>
 */
public abstract class ApiClient<T> {

  public T apiService;

  private String url;

  public ApiClient(String url) {
    this.url = url;
    initRetrofit();
  }

  /**
   * Inicia la configuración del cliente de {@link Retrofit}.
   */
  protected void initRetrofit() {
    Retrofit retrofit = retrofitBuilder();
    apiService = retrofit.create(getApiService());
  }

  /**
   * Crea la configuración del cliente de {@link Retrofit}, aquí se define la url base, como serán
   * manejados los datos,  como trabajara el cliente, si se utilizaran Calls o Rxjava, etc.
   *
   * @return La configuración creada.
   */
  private Retrofit retrofitBuilder() {
    return new Retrofit.Builder().baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(createClient())
        .build();
  }

  /**
   * Crea un cliente con el Interceptor {@link HttpLoggingInterceptor} que permite visualizar el
   * proceso de una petición en Log de la aplicación.
   *
   * @return Cliente Creado.
   * @see <a href="https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor">HttpLoggingInterceptor</a>
   */
  private OkHttpClient createClient() {
    return new OkHttpClient.Builder().addInterceptor(createLoggingInterceptor()).
        addInterceptor(createHeaderInterceptor()).build();
  }

  @NonNull private HttpLoggingInterceptor createLoggingInterceptor() {
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return httpLoggingInterceptor;
  }

  private Interceptor createHeaderInterceptor() {
    return chain -> {
      Request request = chain.request();

      Request newRequest = request.newBuilder()
          .header(ClientConstants.Header.AUTHORIZATION, ClientConstants.Header.VALUE_AUTHORIZATION)
          .method(request.method(), request.body())
          .build();

      return chain.proceed(newRequest);
    };
  }

  /**
   * Obtiene clase con la definición de los Endpoints para el Cliente.
   *
   * @return ApiService con la definición de los Endpoints.
   */
  protected abstract Class<T> getApiService();

  ///**
  // * Obtiene la url base del Cliente.
  // *
  // * @return Url base.
  // */
  //protected abstract String getBaseURL();
}
