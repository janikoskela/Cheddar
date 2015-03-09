HSL Journey Planner Client
===========

Simple java client library for the use of HSL's (Helsinki Regional Transport Authority) [Journey planner interface (v2)](http://developer.reittiopas.fi/pages/en/home.php). Creates requests, optionally validates them and finally sends them to HSL's API. Upon receiving response library maps the response into classes which are then easy to use.

Getting started
-
Usage requires an account which can be requested [here](http://developer.reittiopas.fi/pages/en/account-request.php). Once account is created use libs main file (JourneyPlanner.java) to set account credentials. Main file can also create requests. Once one has created request and set valid credentials request can be executed. When request is executed its parameters will be validated, IllegalArgumentException is thrown if validation errors are found. If request parameters are valid library will send the request via HTTP protocol and parse response. Responses are mapped into classes depending on the request type.

Supported API calls
-
 - [Geocoding](http://developer.reittiopas.fi/pages/en/http-get-interface-version-2.php#geocode): returns the coordinates and the names of the POIs, stops and addresses
 - [Routing between two coordinate points](http://developer.reittiopas.fi/pages/en/http-get-interface-version-2.php#route)
 - [Line information](http://developer.reittiopas.fi/pages/en/http-get-interface-version-2.php#lines)
