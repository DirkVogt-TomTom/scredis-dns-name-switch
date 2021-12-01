package com.tomtom.navcloud.redistest

import scredis._

import java.net.InetAddress
import scala.concurrent.duration.DurationInt

object RedisTest extends App {
  java.security.Security.setProperty("networkaddress.cache.ttl" , "0")

  val system = akka.actor.ActorSystem("RedisTest")

  // Creates a Redis instance with default configuration.
  // See reference.conf for the complete list of configurable parameters.
  val redis = Redis()


  private val Key = "key"

  implicit val executor = system.dispatcher

  system.scheduler.scheduleAtFixedRate(0.seconds, 1.second) {
    () => {
      redis.set(Key, "Success: This was read from redis.")
      redis.get[String](Key).map(println(_))
    }
  }

}
