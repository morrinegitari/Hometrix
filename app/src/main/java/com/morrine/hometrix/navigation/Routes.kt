package com.morrine.hometrix.navigation

const val ROUT_HOME = "home"
const val ROUT_ABOUT = "about"
const val ROUT_SPLASH = "splash"
const val ROUT_BOOKING = "booking"
const val ROUT_DASHBOARD = "dashboard"
const val ROUT_DASHBOARD2 = "dashboard2"
const val ROUT_LANDLORDUPLOAD = "landlordupload"
const val ROUT_SPLASH2 = "splash2"
const val ROUT_APARTMENT = "apartment"
const val ROUT_BEDROOM1 = "bedrooom1"
const val ROUT_BEDSITTER = "bedsitter"
const val ROUT_BEDROOM3 = "bedrooom3"
const val ROUT_BEDROOM2 = "bedrooom2"
const val ROUT_SHOP = "shop"
const val ROUT_SINGLEFAMILY = "singlefamily"
const val ROUT_SINGLEROOM = "singleroom"
//authentication
const val ROUT_REGISTER = "Register"
const val ROUT_LOGIN = "Login"

//Products

const val ROUT_ADD_PRODUCT = "add_product"
const val ROUT_PRODUCT_LIST = "product_list"
const val ROUT_EDIT_PRODUCT = "edit_product/{productId}"

// ✅ Helper function for navigation
fun editProductRoute(productId: Int) = "edit_product/$productId"

//BEDSITTER
const val ROUT_ADD_BEDSITTER = "add_bedsitter"
const val ROUT_EDIT_BEDSITTER = "edit_bedsitter/{bedsitterId}"

// ✅ Helper function for navigation
fun editBedsitterRoute(bedsitterId: Int) = "edit_bedsitter/$bedsitterId"


