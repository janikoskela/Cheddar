HSL Journey Planner Library
===========

Java client library called Cheddar for the use of HSL's (Helsinki Regional Transport Authority) [Journey planner interface (v2)](http://developer.reittiopas.fi/pages/en/home.php). 

Usage
-
Usage requires an account which can be requested [here](http://developer.reittiopas.fi/pages/en/account-request.php).

What can this thing do?
-
 - [Geocoding](http://developer.reittiopas.fi/pages/en/http-get-interface-version-2.php#geocode): returns the coordinates and the names of the POIs, stops and addresses
 - [Routing between two coordinate points](http://developer.reittiopas.fi/pages/en/http-get-interface-version-2.php#route)
 - [Line information](http://developer.reittiopas.fi/pages/en/http-get-interface-version-2.php#lines)

 Features
 -
  - Validates all request parameters before the request is sent. Throws IllegalArgumentException if parameter is invalid.
