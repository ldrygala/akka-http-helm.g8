package $package$.route

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

class HealthCheckRouteTest
    extends WordSpec
    with Matchers
    with ScalatestRouteTest {

  val healthCheckRoute = new HealthCheckRoute()

  "HealthCheck" should {
    "handle /health/alive" in {
      Get("/health/alive") ~> route(healthCheckRoute) ~> check {
        status shouldBe StatusCodes.OK
      }
    }
    "handle /health/ready" in {
      Get("/health/ready") ~> route(healthCheckRoute) ~> check {
        status shouldBe StatusCodes.OK
      }
    }
  }
}
