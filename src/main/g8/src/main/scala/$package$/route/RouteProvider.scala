package $package$.route

import akka.http.scaladsl.server.Route

trait RouteProvider {
  def route: Route
}
