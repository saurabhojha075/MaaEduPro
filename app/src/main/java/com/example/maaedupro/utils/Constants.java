package com.example.maaedupro.utils;

import android.Manifest;

/**
 * Created by chandrapratapsingh on 6/7/18.
 */

public class Constants {

    public interface Global {

        String DECIMAL_FORMAT_TESTS_PRICE = "##,##,##0";

        String APPOINTMENT_MEDIUM_WALKIN = "Walkin";

        int DISTANCE_IAM_AT_CENTER = 1000; //200 meters distance between user and cec

        int PAGE_SIZE_FOR_TESTS_PACKAGES = 10;

        int PAGE_SIZE_FOR_MY_REPORTS = 20;

        String FILE_DIR_ROOT = "HumainDiagnostics";
        String FILE_DIR_SUB_DOC = FILE_DIR_ROOT + "/Documents";
        String FILE_DIR_SUB_MEDIA = FILE_DIR_ROOT + "/Media";

        String PATTERN_USERNAME = "^(?=.*[a-z])[a-z0-9]{4,16}$"; //"^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z][a-zA-Z0-9._]+(?<![_.])$"; //"^[a-zA-Z0-9._]{3,15}$";
        String PATTERN_EMAIL = "[a-zA-Z0-9._-]+@[a-z0-9]+\\.+[a-z]+";
        String PATTERN_PHONE_NUMBER = "^[6-9]\\d{9}$"; //"^[0-9]{10,15}$"; //
        String PATTERN_PHONE_NUMBERS_ONLY = "^[+]?[0-9]+$";
        String PATTERN_PASSWORD = "^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9!@#$%^&*]{8,16}$"; //"^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?!.*\\s).{8,}$"; //"^(?=.{4,})(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z0-9]).*$";
        String PATTERN_TEXT_ONLY = "[a-zA-Z ]+";
        String PATTERN_NUMBER_ONLY = "[0-9]+";

        String PATTERN_VISA = "^4[0-9]{6,}$";
        String PATTERN_MASTER_CARD = "^5[1-5][0-9]{5,}$";
        String PATTERN_AMERICAN_EXPRESS = "^3[47][0-9]{5,}$";
        String PATTERN_DINERS_CLUB = "^3(?:0[0-5]|[68][0-9])[0-9]{4,}$";
        String PATTERN_DISCOVER = "^6(?:011|5[0-9]{2})[0-9]{3,}$";
        String PATTERN_JCB = "^(?:2131|1800|35[0-9]{3})[0-9]{3,}$";

        String DEVICE_TYPE = "android";
        int DEVICE_TYPE_NUM = 1;

        String COUNTRY_CODE = "+91";

        int FLOW_LAYOUT_ITEM_LENGTH = 12;

        String DOT = " • ";

        long DEFAULT_DELAY_IN_SERVER_CALL = 300;
    }

    public interface AnimationDuration {
        long ANIM_DURATION_SHORT = 250L;
        long ANIM_DURATION_DEFAULT = 300L;
        long ANIM_DURATION_REGULAR = 500L;
        long ANIM_DURATION_LONG = 700L;
    }

    public interface RequestAction {
        int ACTION_LOGIN = 101;
        int ACTION_SIGN_UP = 102;

        int ACTION_GEOCODE = 103;

        int ACTION_SET_LOCATION = 104;
        int ACTION_PLACE_NEW_ORDER = 105;

        int ACTION_OPEN_ORDER_FLOW = 106;
        int ACTION_OPEN_SEARCH_FLOW = 107;
        int ACTION_OPEN_NOTIFICATION_FLOW = 108;
        int ACTION_OPEN_CART_FLOW = 109;

        int ACTION_OPEN_CEC = 110;
        int ACTION_LOCATION_GPS = 111;
    }

    public interface RequestCodes {
        int PERMISSION_LOCATION = 100;

        int LOCATION_PREDICTION_ADAPTER = 101;

        int REQ_PAYMENT = 102;
        int REQ_CODE_SEARCH_SEPARATION = 103;
    }

    public interface RequestArgs {
        String ARG_VIEW_REPORTS = "viewReports";
        String ARG_ORDER_ID = "orderId";
        String ARG_ORDER_STATUS = "orderStatus";
        String ARG_REVIEW_ORDER_PAY_NOW = "reviewOrderPayNow";
        String ARG_REVIEW_ORDER = "argReviewOrder";
        String ARG_REQ_ACTION = "reqAction";
        String ARG_REQ_EXTRA = "reqExtra";
        String ARG_REQ_FRAGMENT = "reqReqFragment";
        String ARG_EXTRA_OBJECT = "argExtraObject";
        String ARG_EXTRA_OBJECT_NOTIFICATION = "argExtraObjectNotification";
        String ARG_EXTRA_1 = "argExtra1";
        String ARG_EXTRA_2 = "argExtra2";
        String ARG_EXTRA_3 = "argExtra3";
        String ARG_EXTRA_4 = "argExtra4";
        String ARG_EXTRA_5 = "argExtra5";
        String ARG_EXTRA_6 = "argExtra6";
        String ARG_EXTRA_7 = "argExtra7";
        String ARG_EXTRA_8 = "argExtra8";

        String ARG_LATITUDE  = "latitude";
        String ARG_LONGITUDE = " longitude";
    }

    public interface RequestFragment {


        /************************************ On-Boarding ****************************************/
        int FRAG_LOGIN = 10001;
        int FRAG_VERIFY_OTP = 10002;


        /******************************* Tests & Packages ****************************************/
        int FRAG_TESTS_PACKAGES = 20001;
        int FRAG_TEST_DETAIL = 20002;
        int FRAG_TEST_PACKAGE_DETAIL = 20003;
        int FRAG_FILTER = 20004;
        int FRAG_FILTER_REPORT = 20005;


        /*********************************** Order ***********************************************/
        int FRAG_BOOK_APPOINTMENT_BOTTOM_SHEET = 30001;
        int FRAG_PERSONAL_FORM = 30003;
        int FRAG_SELECT_SLOT = 30004;
        int FRAG_ORDER_REVIEW = 30005;
        int FRAG_ORDER_SUCCESS = 30006;
        int FRAG_EXTRA_COST_BOTTOM_SHEET = 30007;
        int FRAG_CART = 30008;
        int FRAG_SEARCH_BOTTOM_SHEET = 30009;
        int FRAG_RESCHEDULE_ORDER = 30010;
        int FRAG_LOCATION = 30011;
        int FRAG_ORDER_REPORT = 30012;
        int FRAG_DASHBOARD = 30013;


        /********************************** Profile **********************************************/
        int FRAG_BASIC_PROFILE = 40001;
        int FRAG_NOTIFICATION = 40002;
        int FRAG_FAMILY = 40003;
        int FRAG_MY_BOOKING = 40004;
        int FRAG_MY_REPORT = 40005;
        int FRAG_SAVED_ADDRESS = 40006;
        int FRAG_WALLET = 40007;
        int FRAG_BOOKING_DETAIL = 40008;
        int FRAG_EDIT_PROFILE = 4009;
        int FRAG_WEB_VIEW = 40010;

        int FRAG_TEST1_VIEW =40011;

        int FRAG_REPORT_DETAILS_VIEW =40012;

        int FRAG_DETECT_AT_CENTER = 40013;
        int FRAG_CANCEL_ORDER  = 40014;



        /********************************** Payment **********************************************/
        int FRAG_PAYMENT_OPTIONS = 50001;
        int FRAG_PAYMENT_CARD = 50002;
        int FRAG_PAYMENT_NET_BANKING = 50003;
        int FRAG_LINK_PAYTM_BOTTOM_SHEET = 50004;
    }

    public interface LoginMode {
        String LOGIN_MODE = "login_mode";

        int LOGIN_MODE_NONE = 0;
        int LOGIN_MODE_EMAIL = 1;
        int LOGIN_MODE_PHONE = 2;
    }

    public interface TimeFormats {
        String TIME_ONLY = "hh:mm a";

        String DATE_TIME_1 = "dd-MMM-yyy hh:mm a";
        String DATE_TIME_2 = "dd/MM/yyyy hh:mm a";
        String DATE_TIME_3 = "MM/dd/yyyy HH:mm";

        String DATE_ONLY_1 = "dd MMMM yyyy";
        String DATE_ONLY_2 = "dd/MM/yyyy";
        String DATE_ONLY_3 = "dd-MMM-yyyy";
        String DATE_ONLY_4 = "MMMM dd, yyyy";
        String DATE_ONLY_5 = "dd MMM, yyyy";
        String DATE_ONLY_6 = "EEEE, MMM dd";
        String DATE_ONLY_7 = "EEEE, MMM dd";
        String DATE_ONLY_8 = "dd MMM yyyy";

        String DATE_DOB = "dd/MM/yyyy";
        String DATE_DOB_YEAR = "yyyy-MM-dd";
        String DATE_SLOT = "MM/dd/yyyy";
        String DATE_MONTH_SHORT = "MMM";
        String DATE_YEAR = "yyyy";
        String DATE_MONTH_YEAR = "MMM yyyy";
        String DATE_MONTH_YEAR_2 = "MM/yy";
        String DATE_DAY = "dd";
        String DATE_1="dd MMMM, yyyy";

        String DAY_ONLY = "EEEE";
        String DAY_DATE = "EEEE dd MMM, yyyy";

        String TIME_SERVER_NEW = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

        String TIME_SERVER = "yyyy-MM-dd'T'HH:mm:ss"; //"yyyy-MM-dd'T'HH:mm:ss.SSSZ"; "2019-03-16T08:56:33.072079Z"
        String TIME_SERVER_2 = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
        String TIME_SERVER_3 = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        String TIME_SERVER_4 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

        String TIME_24_HOUR= "kk:mm";
        String TIME_12_HOUR_AMPM ="hh:mm aaa";
    }

    public interface TimeUnits {
        String TIME_FORMAT_AM = "AM";
        String TIME_FORMAT_PM = "PM";
        String TIME_IN_MIN = "mins";
        String TIME_IN_SECONDS = "secs";
        String TIME_IN_HOURS = "hours";
    }

    public interface LocalBroadcastAction {
        String ACTION_APP_UPDATE = "action_app_update";
        String ACTION_LOGOUT = "action_logout";
        String ACTION_SYNC_FCM_TOKEN = "syncFCMToken";
        String ACTION_NEW_NOTIFICATION = "newNotification";
    }

    public interface RuntimePermissions {
        int REQUEST_CODE_RECORD_PERMISSION = 1;

        int REQUEST_CODE_EXTERNAL_STORAGE_PERMISSION = 2;

        String[] LOCATION_PERMISIONS = new String[] {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};

        String[] EXTERNAL_STORAGE_PERMISSIONS = new String[]
                {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

        int REQUEST_CODE_CAMERA_PERMISSION = 3;
        String[] CAMERA_PERMISSIONS = new String[]{Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};

        int REQUEST_CODE_READ_SMS = 4;
        String[] SMS_PERMISSIONS = new String[]{Manifest.permission.RECEIVE_SMS,
                Manifest.permission.READ_SMS};

        int REQUEST_CODE_LOCATION_PERMISSION = 5;
        String[] LOCATION_PERMISSIONS = new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE};

        int REQUEST_CODE_CALENDAR_PERMISSION = 6;
        String[] CALENDAR_PERMISSIONS = new String[]
                {Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR};

        int REQUEST_CODE_READ_PHONE_STATE = 7;
        String[] READ_PHONE_STATE_PERMISSIONS = new String[]
                {Manifest.permission.READ_PHONE_STATE};

        int REQUEST_CODE_FILE_PICKER = 8;
        String[] FILE_PICKER_PERMISSIONS = new String[]
                {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE};

        int REQUEST_CODE_CALL_PHONE_PERMISSION = 9;
        String[] PHONE_CALL_PERMISSIONS = new String[]
                {Manifest.permission.CALL_PHONE};

        String[] FILE_PICKER_AUDIO_PERMISSIONS = new String[]
                {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO};

        int REQUEST_CODE_PLAY_SERVICES_AVAILABILITY_CHECK = 10;

    }

    public interface Prefs {

        String PREFS_USER_TYPE = "prefs_user_type";
        String PREFS_AUTH_TOKEN = "prefs_auth_token";
        String PREFS_USER_ID = "prefs_user_id";
        String PREFS_IS_LOGGED_IN = "prefs_is_logged_in";

        String PREFS_WALLET_BALANCE = "prefsWalletBalance";

        String PREFS_TEST_LOCATION = "prefsSelectedTestLocation";
        String PREFS_ORDER_DETAILS = "prefsOrderDetails";
        String PREFS_PARTIAL_ADDRESS = "prefsPartialAddress";

        String FCM_TOKEN = "FCMToken";
        String IS_FCM_TOKEN_SYNCED = "isFCMTokenSynced";
        String PREFS_EXTRA_CHARGES_SYNC = "prefsExtraChargesSync";
        String PREFS_TYPE_HOME_DELIVERY = "prefsHomeDelivery";
        String PREFS_TYPE_SAME_DAY_DELIVERY = "prefsHomeCollectionSameDay";
        String PREFS_TYPE_OTHER_DAY_DELIVERY = "prefsHomeCollectionLater";
        String PREFS_TYPE_PRIORITY = "prefsOnPriority";

     // String PREFS_TYPE Cache order I am at ceter details
        String PREFS_CACHE_IAM_ATCENTER = "prefsIamAtCenter";
    }


    public interface APIRequestFragments {
        String HEADER_CONTENT_TYPE = "Content-Type";
        String HEADER_APP_VERSION = "app-version";
        String HEADER_DEVICE_TYPE = "device-type";
        String HEADER_AUTHORIZATION = "Authorization";

        String RESPONSE_TYPE_JSON = "application/json";
        String RESPONSE_ALL_TYPE="application/json, text/plain, */*";
        String RESPONSE_TYPE_URL_ENCODED = "application/x-www-form-urlencoded";
        String RESPONSE_TYPE_MULTIPART = "multipart/form-data";

        int CONNECT_TIMEOUT_SECS = 10;

        String KEY_FILE_UPLOAD = "file";
    }

    public interface APIResponseStatus {
        int STATUS_INVALID_CREDENTIALS = 401;

        int ERROR_INTERNET_CONNECTION = 40001;
    }

    public interface APIEndPoints {

        /************************ On-boarding ************************/
        String API_LOGIN = "/login";
        String API_SIGN_UP = "/signup";
        String API_OTP_REQUEST = "otp/request";
        String API_OTP_VERIFY = "otp/verify";
        String API_LOGOUT = "logout";


        /************************ Profile ************************/
        String API_GET_UPDATE_PROFILE = "patient/{id}";
        String API_GET_FAMILY_MEMBER = "patient/{id}/family/";
        String API_ADD_FAMILY_MEMBER = "patient/{id}/family/";
        String API_DELETE_FAMILY_MEMBER = "patient/{id}/family/{memberId}";
        String API_VERIFY_EMAIL = "patient/email-verify";


        /************************ Catalog ************************/
        String API_GET_INDIVIDUAL_TEST_LIST = "individual-test/";
        String API_GET_GROUP_TEST_LIST = "group-test/";
        String API_GET_COMBINED_TEST_LIST = "combined-tests/";
        String API_GET_HEALTH_PACKAGE_LIST = "health-package/";

        String API_GET_INDIVIDUAL_TEST_DETAILS = "individual-test/{id}";
        String API_GET_GROUP_TEST_DETAILS = "group-test/{id}";
        String API_GET_HEALTH_PACKAGE_DETAILS = "health-package/{id}";

        String FETCH_COMBINED_TESTS_PACKAGES_LIST = "getAllTestsAndPackagesList";


        /************************** Order **************************/
        String API_ORDER = "order/";
        String API_GET_ORDER_DETAIL = "order/{id}";
        String API_CANCEL_ORDER = "order/{id}/cancel";
        String API_GET_REPORT_LIST = "combined-reports/";
        String API_GET_REPORT_BY_ORDER = "combined-reports/{orderId}";
        String API_GET_EXTRA_CHARGES = "order/config";
        String API_GET_ORDER_TOKEN ="order/token";


        /***************************Search***********************/
        String API_SEARCH_LIST = "search/tests";
        String API_SEARCH_LIST_NEW = "combined-tests";


        /************************** Saved Address ***************/
        String API_GET_SAVED_ADDRESS_LIST = "address/";
        String API_DELETE_SAVED_ADDRESS = "address/{id}";
        String API_POST_ADDRESS = "address/";


        /***************************Filter***********************/
        String API_FILTER_LIST = "sample/";
        String API_FILTER_RISK_AREA = "riskArea/";


        /************************** CEC List *********************/
        String API_GET_TEST_CENTER_LIST = "cec/";


        /*************************** Time Slot ***********************/
        String API_GET_TIME_SLOTS_HOME = "slot/phlebotomist";
        String API_GET_TIME_SLOTS_CEC = "slot/cec";


        /*************************** Time Slot ***********************/
        String API_GET_PAYMENT_MODES = "payment-mode/";
        String API_GET_PAYMENT_DETAILS = "payment/initiate";
        String API_VERIFY_PAYMENT_DETAILS = "payment/verify";


        /*************************** Feedback ***********************/
        String API_GET_FEEDBACK_OPTIONS = "patient-order-feedback/tags/";
        String API_SUBMIT_FEEDBACK = "patient-order-feedback/";
        String API_SKIP_FEEDBACK = "patient-order-feedback/skip/";


        /*************************** Wallet ***********************/
        String API_GET_WALLET_BALANCE = "wallet/";
        String API_GET_WALLET_TRANSACTIONS = "wallet-history/";


        /*************************** Location ************************/
        String API_GET_SERVICEABLE_STATE = "check-availability";


        /*************************** Location ************************/
        String API_UPLOAD_FILE = "file-upload/";


        /*************************** FCM ************************/
        String API_SYNC_FCM_TOKEN = "devices/";


        /*************************** Geo Code ******************/
        String API_ADDRESS_FROM_LAT_LNG = "https://maps.googleapis.com/maps/api/geocode/json";


        /*************************** Notification ******************/
        String API_GET_NOTIFICATIONS_LIST = "notifications/";

        /*************************** REschedule order ******************/
        String API_RESCHEDULE_ORDER= "order/{orderId}/reschedule";

        /**********  View Invoice   ***/
        String API_VIEW_INVOICE = "order/order-invoice";
    }


    public interface HomeTabs {
        int TAB_COUNT = 4;

        int TAB_HOME = 0;
        int TAB_TESTS = 1;
        int TAB_PROFILE = 2;
        int TAB_HELP = 3;
    }

    public interface FeedbackStates {
        String FEEDBACK_VERY_BAD = "Very bad";
        String FEEDBACK_BAD = "Bad";
        String FEEDBACK_OKAY = "Okay";
        String FEEDBACK_GOOD = "Good";
        String FEEDBACK_VERY_GOOD = "Very Good";

        int FEEDBACK_NUM_VERY_BAD = 1;
        int FEEDBACK_NUM_BAD = 2;
        int FEEDBACK_NUM_OKAY = 3;
        int FEEDBACK_NUM_GOOD = 4;
        int FEEDBACK_NUM_VERY_GOOD = 5;


        String ACTION_IAM_AT_CENTER = "iam_at_center";
        String ACTION_VIEW_REPORTS = "action_view_reports";
        String ACTION_GENERATE_ORDER_TOKEN = "generate_order_token";
        String ACTION_BOOK_NEW_APPOINTMENT = "book_appointment";
        String ACTION_SHOW_BOOKING_DETAIL = "card_detail";
        String ACTION_FEEDBACK_SELECTED = "feedback_rating_selected";
        String ACTION_FEEDBACK_SKIPPED = "feedback_skipped";
        String ACTION_REVIEW_ORDER = "review_order";
        String ACTION_NAVIGATE_TO_CENTER = "navigate_center";
    }

    public interface ProfileFormTabs {
        int TAB_SELF = 0;
        int TAB_SOMEONE_ELSE = 1;
    }

    public interface TestLocationTabs {
        int TAB_HOME_APPOINTMENT = 1;
        int TAB_CEC_APPOINTMENT = 0;
    }


    public interface TestType {
        String TEST_INDIVIDUAL = "individual-test";
        String TEST_GROUP = "group-test";
        String TEST_HEALTH_PACKAGE = "health-package";
        String TEST_COMBINED = "combined-test";
    }

    public interface AddressType {
        String ADDRESS_HOME = "home";
        String ADDRESS_CEC = "cec";
    }

    public interface TestLocation {
        String LOCATION_HOME = "Home Appointment";
        String LOCATION_CEC = "CEC Appointment";
    }


    public interface Gender {
        String M = "m";
        String F = "f";
        String MALE = "Male";
        String FEMALE = "Female";
    }

    public interface OrderByKey {
        String ORDER_BY_POPULARITY_ASC = "popularityOrder:-1";
        String ORDER_BY_POPULARITY_DESC = "popularityOrder:1";
    }

    public interface TestExtraChargesTypes {
        String EXTRA_TYPE_HOME_DELIVERY = "homeDelivery";
        String EXTRA_TYPE_SAME_DAY_DELIVERY = "homeCollectionSameDay";
        String EXTRA_TYPE_OTHER_DAY_DELIVERY = "homeCollectionLater";
        String EXTRA_TYPE_PRIORITY = "onPriority";
    }

    public interface TestExtraCharges {
        float COST_FOR_PRIORITY = 150f;
        float COST_FOR_HOME_DELIVERY = 150f;
        float COST_FOR_SAME_DAY_COLLECTION = 150f;
        float COST_FOR_OTHER_DAY_COLLECTION = 0f;
    }

    public interface PriceUnits {
        String SERVER_PRICE_UNIT_RUPEE = "INR";

        String PRICE_UNIT_RUPEE = "₹";
    }

    public interface ControllerActions {
        int ACTION_GET = 1;
        int ACTION_POST = 2;
        int ACTION_PUT = 3;
        int ACTION_DELETE = 4;

        int ACTION_DB_SAVE = 11;
        int ACTION_DB_UPDATE = 12;

        int ACTION_GET_ON_LOCATION_CHANGE = 21;
    }

    public interface Delimiters {
        String DEL_BULLET_POINT = " • ";
    }

    public interface FilterTypes {
        String FILTER_HEALTH_PACKAGE = "health_package";
        String FILTER_TESTS = "tests";
        String FILTER_REPORTS = "reports";
        String FILTER_RESET = "resetFilter";
    }

    public interface PaymentMode {
        String PAY_MODE_CARD = "card";
        String PAY_MODE_NET_BANKING = "netbanking";
        String PAY_MODE_RAZORPAY = "razorpay";
        String PAY_MODE_PAYTM = "paytm";
        String PAY_MODE_COD = "cod";
        String PAY_MODE_HUMAIN_WALLET = "wallet";
    }

    public interface OrderType {
        String TYPE_ORDER = "order";
    }

    public interface TransactionType {
        String TRANS_TYPE_CASH_BACK = "Cashback";
        String TRANS_TYPE_ADDED_BALANCE = "Added balance";
        String TRANS_TYPE_PAID = "Paid";
    }

    public interface OrderStatus {
        //new status
        String STATUS_ORDER_BOOKING_CONFIRMED = "Booking Confirmed";
        String STATUS_ORDER_TOKEN_OTP_GENERATED = "Token & OTP Generated";
        String STATUS_ORDER_ROOM_ASSIGNED = "Room Assigned";
        String STATUS_ORDER_SAMPLES_COLLECTED = "Samples Collected";
        String STATUS_ORDER_IN_PROCESSING = "In Processing";
        String STATUS_ORDER_REPORTS_READY = "Reports Ready";
        String STATUS_ORDER_BOOKING_COMPLETED = "Booking Completed";
        String STATUS_ORDER_CANCELLED = "Booking Cancelled";
        String STATUS_ORDER_SAMPLE_REJECTION = "Sample Rejected";


        int STATUS_CODE_GENERATE_TOKEN_OTP = 3;
        int STATUS_CODE_ROOM_ASSIGNED = 4;
        int STATUS_CODE_RECEIVED    = 0;
        int STATUS_CODE_UNPAID_ORDER = 2;
        int STATUS_CODE_PAID_ORDER = 5;
        int STATUS_CODE_INPROGRESS = 20;
        int STATUS_CODE_SAMPLES_COLLECTED = 8;
        int STATUS_CODE_SAMPLES_ASSERTED_OR_TEST_CONDUCTED = 21;
        int STATUS_CODE_REPORTS_READY = 23;
        int STATUS_CODE_SIGNED_OFF = 22;
        int STATUS_CODE_CANCELLED = 14;
        int STATUS_CODE_SAMPLE_REJECTION = 25;

        int ORDER_STATUS_NUM_CONFIRMED = 1;
        int ORDER_STATUS_NUM_PHLEBO_ASSIGNED = 2;
        int ORDER_STATUS_NUM_PHLEBO_IN_ROUTE = 4;
        int ORDER_STATUS_NUM_PHLEBO_HAS_REACHED = 6;
        int ORDER_STATUS_NUM_SAMPLE_COLLECTED = 8;
        int ORDER_STATUS_NUM_SAMPLE_AT_LAB = 9;
        int ORDER_STATUS_NUM_PLACE_NEW_ORDER = 20;
    }

    public interface UserType {
        String USER_TYPE_PHLEBO = "Phlebotomist";
        String USER_TYPE_PICKUP_BOY = "Pickup Boy";
        String USER_TYPE_PATIENT = "Patient";
    }

    public interface MediaType {
        String TYPE_VIDEO = "video";
        String TYPE_AUDIO = "audio";
        String TYPE_IMAGE = "image";
        String TYPE_PDF = "pdf";
    }

    public interface NotificationType {
        int NOT_TYPE_ORDER_CONFIRMED = 1;
        int NOT_TYPE_PHLEBO_ASSIGNED = 2;
        int NOT_TYPE_PICKUPBOY_ASSIGNED = 3;
        int NOT_TYPE_PHLEBO_ON_WAY = 4;
        int NOT_TYPE_PICKUPBOY_ON_WAY = 5;
        int NOT_TYPE_PHLEBO_REACHED = 6;
        int NOT_TYPE_PICKUPBOY_REACHED = 7;
        int NOT_TYPE_SAMPLES_COLLECTED = 8;
        int NOT_TYPE_SAMPLES_REACHED_LAB = 9;
        int NOT_TYPE_REPORT_READY = 10;

        int NOT_TYPE_PAYMENT_FAILURE = 11;
        int NOT_TYPE_ORDER_CASHBACK = 12;
        int NOT_TYPE_COD_BALANCE = 13;
        int NOT_TYPE_ORDER_REFUND = 14;
        int NOT_TYPE_DEBIT_AGAINST_ORDER = 15;

        int NOT_TYPE_DEPARTMENT_REPORT_READY = 31;

        int NOT_TYPE_CEC_ORDER_REMINDER = 32;
        int NOT_TYPE_CEC_ORDER_CONFIRMED = 33;
    }

    public interface GoogleAnalytics{
        String SCREEN_NAME = "ScreenName";
        String CATEGORY = "Category";
    }

    public interface TabSelection{
        String TAB_SELECTION_TESTS = "tests";
        String TAB_SELECTION_HEALTH_PACKAGE = "package";
    }

    public interface PatientSelection {
        String ALL_PATIENTS = "AllPatients";
        String SELF_PATIENT = "SelfPatient";
    }

    public interface PaymentChangeSelection {
        int SELECTION_CHANGE = 1;
        int SELECTION_NO_CHANGE = 2;
    }
}