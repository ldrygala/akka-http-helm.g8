package $package$.route

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

class SwaggerSiteRouteTest
    extends WordSpec
    with Matchers
    with ScalatestRouteTest {

  val swaggerRoute = new SwaggerSiteRoute()

  "SwaggerSiteRoute" should {

    "return API doc" in {
      Get("/swagger") ~> route(swaggerRoute) ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`text/html(UTF-8)`
      }
    }
  }
}