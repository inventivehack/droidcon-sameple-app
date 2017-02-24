package com.inventive.hack.halotesting.injector;

/**
 * Componente genérico manejar los componentes de una inyección de dependencias.
 */
public interface HasComponent<C> {
  C getComponent();
}
