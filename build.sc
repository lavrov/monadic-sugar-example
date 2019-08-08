import mill._, scalalib._

object example extends ScalaModule {

  def scalaVersion = "2.13.0"

  def scalacOptions = Seq("-deprecation", "-feature")

  def ivyDeps = Agg(
    ivy"com.thoughtworks.dsl::domains-cats:2.0.0-M1+3-1bd1c25a"
  )

  def scalacPluginIvyDeps = Agg(
    ivy"com.thoughtworks.dsl::compilerplugins-bangnotation:1.5.1+2-f737ed69"
  )
}
