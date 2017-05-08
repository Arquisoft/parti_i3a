package default

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Users10000Simulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8080")
		.inferHtmlResources()
		.acceptHeader("text/css,*/*;q=0.1")
		.acceptEncodingHeader("gzip, deflate, sdch")
		.acceptLanguageHeader("es-ES,es;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Origin" -> "http://localhost:8080",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_5 = Map("Accept" -> "image/webp,image/*,*/*;q=0.8")

    val uri1 = "http://localhost:8080/dashboard_i3a"

	val scn = scenario("Users10Simulation")
		.exec(http("request_login_screen")
			.post("/dashboard_i3a/dashboard")
			.headers(headers_0)
			.formParam("login", "mal")
			.formParam("password", "mal")
			.resources(http("request_bad_login")
			.get("/dashboard_i3a/css/error.css")))
		.pause(5)
		.exec(http("request_go_back_login_screen")
			.get("/dashboard_i3a/css/login.css"))
		.pause(9)
		.exec(http("request_good_login")
			.post("/dashboard_i3a/dashboard")
			.headers(headers_0)
			.formParam("login", "pablo@example.com")
			.formParam("password", "asdf")
			.resources(http("request_dashboard_screen")
			.get("/dashboard_i3a/css/dashboard.css"),
            http("request_dashboard_screen_images")
			.get("/dashboard_i3a/u.jpg")
			.headers(headers_5)))
		.pause(5)
		.exec(http("request_refresh_dashboard_1")
			.post("/dashboard_i3a/dashboard")
			.headers(headers_0)
			.formParam("login", "pablo@example.com")
			.formParam("password", "asdf")
			.resources(http("request_refresh_dashboard_1_stylesheets")
			.get("/dashboard_i3a/css/dashboard.css"),
            http("request_refresh_dashboard_1_images")
			.get("/dashboard_i3a/u.jpg")
			.headers(headers_5)))
		.pause(5)
		.exec(http("request_refresh_dashboard_1")
			.post("/dashboard_i3a/dashboard")
			.headers(headers_0)
			.formParam("login", "pablo@example.com")
			.formParam("password", "asdf")
			.resources(http("request_refresh_dashboard_2_stylesheets")
			.get("/dashboard_i3a/css/dashboard.css"),
            http("request_refresh_dashboard_2_images")
			.get("/dashboard_i3a/u.jpg")
			.headers(headers_5)))
		.pause(7)
		.exec(http("request_refresh_dashboard_3")
			.post("/dashboard_i3a/dashboard")
			.headers(headers_0)
			.formParam("login", "pablo@example.com")
			.formParam("password", "asdf")
			.resources(http("request_refresh_dashboard_3_stylesheets")
			.get("/dashboard_i3a/css/dashboard.css"),
            http("request_refresh_dashboard_3_images")
			.get("/dashboard_i3a/u.jpg")
			.headers(headers_5)))
		.pause(7)
		.exec(http("request_refresh_dashboard_4")
			.post("/dashboard_i3a/dashboard")
			.headers(headers_0)
			.formParam("login", "pablo@example.com")
			.formParam("password", "asdf")
			.resources(http("request_refresh_dashboard_4_stylesheets")
			.get("/dashboard_i3a/css/dashboard.css"),
            http("request_refresh_dashboard_4_images")
			.get("/dashboard_i3a/u.jpg")
			.headers(headers_5)))

	setUp(scn.inject(atOnceUsers(10000))).protocols(httpProtocol)
}