package com.convolutionai.flut.config

/***
 * cvhgghgh
 */
 object Configuration {
  import com.typesafe.config.Config
  import com.typesafe.config.ConfigFactory

  val config : Config = ConfigFactory.parseResources("application.conf")

}
