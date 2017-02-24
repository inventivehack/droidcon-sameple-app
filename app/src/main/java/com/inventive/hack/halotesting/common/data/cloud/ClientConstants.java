package com.inventive.hack.halotesting.common.data.cloud;

import com.inventive.hack.halotesting.BuildConfig;

/**
 * Constantes para conectarse al API de la aplicación.
 *
 * @see  <p>Para más información ver la documentación del Api.</p>
 */
public class ClientConstants {

  /**
   * Url base del Api.
   */
  public static final String BASE_URL = BuildConfig.BASE_URL;

  /**
   * Rutas de acceso al Api.
   */
  public static final class EndPointApi {
    public static final String LOGIN = "/users/signin/";
    public static final String LOGIN_FACEBOOK = "/users/signup/facebook/";
    public static final String REGISTER = "/users/signup/";
    public static final String RECOVER_PASSWORD = "/users/forgot_password/";
    public static final String PROFILE = "/users/{" + Path.USER_NAME + "}/";
    public static final String PICTURE = "/users/{" + Path.USER_NAME + "}/picture/";

  }

  /**
   * Paths del Api.
   */
  public static final class Path {
    public static final String USER_NAME = "user_name";
  }

  /**
   * Headers del Api.
   */
  public static final class Header {
    public static final String AUTHORIZATION = "Authorization";
  }

  /**
   * Querys del Api.
   */
  public class Query {
    public static final String SEARCH = "search";
  }
}
