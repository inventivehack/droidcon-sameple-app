package com.inventive.hack.halotesting.common.data.exception;

/**
 * Interfaz para el manejo de errores de la capa de datos, mayormente son errores obtenidos del
 * servidor.
 */
public interface ErrorHandling {

  /**
   * Tipo de error 400.
   */
  int RESPONSE_NETWORK = 1;
  /**
   * Tipo de error 401.
   */
  int AUTHENTICATION = 2;
  /**
   * Tipo de error 403.
   */
  int ACCESS_DENIED = 3;
  /**
   * Tipo de error 404.
   */
  int NOT_FOUND = 4;
  /**
   * Error de Conexión.
   */
  int NETWORK = 5;
  /**
   * Tipo de error desconocido.
   */
  int UNKNOWN = 6;

  /**
   * Obtiene el tipo de error.
   */
  int getTypeError();

  /**
   * Obtiene el mensaje del error.
   */
  String getMessageError();

  /**
   * Convierte un el {@link String} con formato json obtenido del servidor al presentarse un error
   * a un objeto de java {@link T}.
   *
   * @param type Clase del objeto a convertir.
   * @param json es el json origen.
   * @return objeto con los datos del json
   */
  <T> T getErrorBodyAs(Class<T> type, String json);
}
