package com.example.aspect.aspectjtest001;

/**
 * Created by 10961957 on 2016/9/23.
 */
public final class ParamConstants {

    //    公共参数
//    imei	imei
//    外部机型	model
//    应用版本号	appVersion
//    应用包名	apppkgName
//    用户id	userid
//    分辨率	pixel
//    emmcid	e
//    系统版本	sysversion
//    内部机型名	product
    public static final String PARAM_COMMON_IMEI = "imei";
    public static final String PARAM_COMMON_MODEL = "model";
    public static final String PARAM_COMMON_APPVERSIONCODE = "app_version_code";
    public static final String PARAM_COMMON_APPVERSIONNAME = "app_version_name";
    public static final String PARAM_COMMON_APPPKGNAME = "app_package";
    public static final String PARAM_COMMON_USERID = "userid";
    public static final String PARAM_COMMON_PIXEL = "pixel";
    public static final String PARAM_COMMON_E = "e";
    public static final String PARAM_COMMON_SYSVERSION = "sysversion";
    public static final String PARAM_COMMON_PRODUCT = "product";
    //国家码
    public static final String PARAM_KEY_CUSTOMIZE = "cm";

    public static final String PARAM_TEST_REPORTTYPE = "report_type";
    public static final String PARAM_TEST_INTERCEPTPIERCE = "intercept_pierce";

    //    可选业务参数
//    开机时间	elapsedtime
//    网络类型	nt
//    sim卡1插卡时间	st1
//    sim卡2插卡时间	st2
//    sim卡1插卡类型	sn1
//    sim卡2插卡类型	sn2
//    主卡副卡	ms
    public static final String PARAM_OPTIONAL_ELAPSEDTIME = "elapsedtime";
    public static final String PARAM_OPTIONAL_NT = "nt";
    public static final String PARAM_OPTIONAL_ST1 = "st1";
    public static final String PARAM_OPTIONAL_ST2 = "st2";
    public static final String PARAM_OPTIONAL_SN1 = "sn1";
    public static final String PARAM_OPTIONAL_SN2 = "sn2";
    public static final String PARAM_OPTIONAL_MS = "ms";
    //运营商
    public static final String PARAM_OPTIONAL_NON = "non";

    // sdk版本 key	sdkversion
    public static final String PARAM_GLOBAL_MS = "sdkversion";
    public static final String PARAM_GLOBAL_AD = "appId";
    public static final String PARAM_GLOBAL_DATA = "data";

    //事件json参数
    public static final String PARAM_TRACE_SESSIONID = "session_id";
    public static final String PARAM_TRACE_COMMON = "common";
    public static final String PARAM_TRACE_SESSION = "session";
    public static final String PARAM_TRACE_EVENT_TIME = "event_time";
    public static final String PARAM_TRACE_EVENT_ID = "event_id";
    public static final String PARAM_TRACE_TRACE = "trace_id";
    public static final String PARAM_TRACE_PARAMS = "params";
    public static final String PARAM_PIERCE_TRACE_PARAMS = "preparams";
    public static final String PARAM_IS_INTERCEPT = "isIntercept";

    //路径事件，实时，非实时
    public static final String PARAM_TRACE_EVENT_TYPE = "event_type";


    //网络类型
    public static final String PARAM_SINGLE_NET_TYPE = "nt";
    //事件开始时间
    public static final String PARAM_SINGLE_START_TIME = "start_time";
    //时长
    public static final String PARAM_SINGLE_DURATION = "duration";
    //事件tasks
    public static final String PARAM_SINGLE_INFO = "tasks";

    private ParamConstants() {

    }
}
