package com.morrine.hometrix.navigation

const val ROUT_HOME = "home"
const val ROUT_ABOUT = "about"
const val ROUT_SPLASH = "splash"
const val ROUT_HOMETRIXSPLASH = "hometrixsplash"
const val ROUT_DASHBOARD = "dashboard"
const val ROUT_DASHBOARD2 = "dashboard2"
const val ROUT_LANDLORDUPLOAD = "landlordupload"
const val ROUT_SPLASH2 = "splash2"
const val ROUT_UPLOADPROPERTY = "uploadproperty"
const val ROUT_CHAT = "Chat"

//authentication
const val ROUT_REGISTER = "Register"
const val ROUT_LOGIN = "Login"



//BEDSITTER
const val ROUT_ADD_BEDSITTER = "add_bedsitter"
const val ROUT_EDIT_BEDSITTER = "edit_bedsitter/{bedsitterId}"

// ✅ Helper function for navigation
fun editBedsitterRoute(bedsitterId: Int) = "edit_bedsitter/$bedsitterId"

//Task
const val ROUT_UPLOAD_BOOKING = "upload_booking"
const val ROUT_VIEW_BOOKING = "view_booking"

//landlords
const val ROUT_RENTAL_HISTORY = "rental_history"
const val ROUT_NOTIFICATIONS = "notifications"
const val ROUT_REPORTSANALYTICS = "reportsanalytics"
const val ROUT_PROFILE_SETTINGS = "profile_settings"
const val ROUT_TENANT_INQUIRIES = "tenant_inquiries"
const val ROUT_MANAGE_LISTINGS = "manage_listings"

//tenants
const val ROUT_TENANTSPROFILE = "tenantsprofile"
const val ROUT_TENANTINQUIRY = "tenantinquiry"
const val ROUT_TENANTBOOKING = "tenantbooking"
const val ROUT_VIEWBOOKING = "viewbooking"
const val ROUT_BROWSEPROPERTIES = "browseproperties"

const val ROUT_ADD_PROPERTY = "addproperty"
const val ROUT_PROPERTYLIST = "propertylist"
const val ROUT_EDIT_PROPERTY = "edit_property/{propertyId}"

// ✅ Helper function for navigation
fun editPropertyRoute(propertyId: Int) = "edit_property/$propertyId"

//myproperty
const val ROUT_ADDMYPROPERTY = "addmyproperty"
const val ROUT_MYPROPERTYLIST = "mypropertylist"
const val ROUT_EDITMYPROPERTY = "edit_myproperty/{mypropertyId}"

// ✅ Helper function for navigation
fun editMypropertyRoute(mypropertyId: Int) = "edit_myproperty/$mypropertyId"

//Task
const val ROUT_UPLOAD_TASK = "upload_task"
const val ROUT_VIEW_TASK = "view_task"

//Products6

const val ROUT_ADD_PRODUCT = "add_product"
const val ROUT_PRODUCT_LIST = "product_list"
const val ROUT_EDIT_PRODUCT = "edit_product/{productId}"

// ✅ Helper function for navigation
fun editProductRoute(productId: Int) = "edit_product/$productId"










