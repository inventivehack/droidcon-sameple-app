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

    public static final String CAMPAIGN = "/metadata/h5/metadata/campaign-missions";
    public static final String ENEMIES = "/metadata/h5/metadata/enemies";
    public static final String WEAPONS = "/metadata/h5/metadata/weapons";
  }

  /**
   * Paths del Api.
   */
  public static final class Path {
  }

  /**
   * Headers del Api.
   */
  public static final class Header {

    public static final String AUTHORIZATION = "Ocp-Apim-Subscription-Key";
    public static final String VALUE_AUTHORIZATION = "70077eaf30b54ccd8fc9179b183f2f63";

  }

  /**
   * Querys del Api.
   */
  public class Query {
    public static final String SEARCH = "search";
  }
}
