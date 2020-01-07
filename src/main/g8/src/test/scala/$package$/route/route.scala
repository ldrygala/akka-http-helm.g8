package $package$

import akka.http.scaladsl.server.Route

package object route {

  def route(r: RouteProvider): Route = new ApiRoute(Seq(r), Seq.empty).route
  def apiRoute(r: RouteProvider): Route = new ApiRoute(Seq.empty, Seq(r)).route

}
