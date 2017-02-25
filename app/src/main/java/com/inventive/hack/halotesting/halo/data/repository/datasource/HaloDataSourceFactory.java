package com.inventive.hack.halotesting.halo.data.repository.datasource;

/**
 * 24/02/2017.
 */

public class HaloDataSourceFactory {

  public HaloDataSource createCloudDataSource() {
    return new HaloCloudDataSource();
  }

}

