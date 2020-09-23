package com.xiaomi.configuration;

/**
 * @author hekun
 */
public class AlipayConfig {
    public static String app_id = "2016100900646744";
    public static String private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCf+3SmOwiyqQUy7FzwVZYGKfcdI5lUXeJUsbri9wYyXsUY/B2GcIqTiHZW/cZawWBYFHkIyr+PKUeSED49ZjJdaPPWDrRSW34nmCpZ/uY00jpuyuhSG6b2pJRF2kKG1JwIPyMyh5w+mc5r3dE9mcizz+HMb30D499yhyvxtoYZqXhkqIZqgesWrw3OpKeRcIo/ismOjW3afKo3Jab8Dik70XIDHDOaiXfQrKkak+3SFdZYQtdBjJe2kvGrPgi0B7uA6JaBpyEvA/6zV0guWvXDlF/TihtxPKZTB9Lh/ozTqoMA+Jrbz5c474QG+40iFUpwtfmwaEmrxaX9/pFOfQ7AgMBAAECggEBAIHE2Se8rcSDIdsUGyfyr/v2uKW+ugMCmg3SZMDCWWHEqUHDh9DJGI2dGIferb927wiSUZy9Y/lhMQkF7KYlA4QCGZ0MLaEElfjO9WxAXK7CHBVg7Kf7MRKGrU06LFfCh529D6apLtBGEPQKCl5ncHPrB09XJX9XIeeCXjhlU2dC8ERDEJyRGYsCmtyLm6KlPxoV+ua/mVSIraRl7QNlUYo2JrAmQOtCk0KQ9CLPoBs/spByOu9wUU8xIOZCA+7nFkdUWtE+pKxPVRmE4b9ECTMZwEf3SpWDB/v9syPcrMKQ7vNh0TdiCfx+n2NFEp//AOTIiXwU3I6jvObWY3eA0gECgYEAurvDfnOazfn/QpRrWQOfvmaONuX3tTpYqG5743rklQmmGADDpMV65rd8ot5HIRJYSj9ISgoyfq58UNbqk4U7FSCGd5J2JzzLIEjmp6AHdWTtz6JpIHVBSOOxU+7fhXgCwMkSvio99M2kXwzWU6g/XXdXK6IFpiSz9z7Av0lOyLsCgYEAsugzupY43yDDLASwscYzZiXE4rBsXEEhl1uSlwuSm6JbmTaU+eD2mygqaIlGaBYwKPHCSlMGu+aZE1VAlNWaG97nbo7d8CKhltgFOd3JRU27hhs+mXm8y+V1hvNJ/w/TEPlnPH6l5ObN8PYKOcLXVln1xXAZokOapeD6CTDWioECgYBWq2N3Q4zsYUZazqxsakQwiUUkseQg123i7zTNRnLlwc63gVNNHOOIRk2xAl4dOXiFLY4N32HEbpQAqV/DDKl5itkeknoIiCz3VR7JWntbv3apUoZcrE+a1yOtA0f3mNYeSLVMUirjfrb17u1jcsnGRefNtqvMi2iELzojDpFklQKBgErR8VBHIuGtwfHWxE6UpUpC4WQshCTQ2EuEcHnazSVpcQVSXltiSb/5vEKbpmZBYUK+WJLcxiQu/DWpoaic7CZbwk3qUcbrtMhw7z6UEmh5acNcAYIN93cOL2iQtpGE/LBMnXAfRyHDpLzxKLWfVo82cCJyD0ZdH3/f5rGRSygBAoGAWqT3ba27fQN6yaS7FTqfJgmZ4QirtxGxvFH9KQ4WVSzy2c5Ku1E54xNq20UK3dhFyuem/fmukTAP3Z7E37JHNz6u2NJoqwZoqRTuV/Svq4QozUv3is6/QrK2lq2OhFLVzDAvY8bSVpjsCOYXRlDWnFOF0VYmzBCRIg6XWxeHfmw=";
    public static String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgn/t0pjsIsqkFMuxc8FWWBin3HSOZVF3iVLG64vcGMl7FGPwdhnCKk4h2Vv3GWsFgWBR5CMq/jylHkhA+PWYyXWjz1g60Ult+J5gqWf7mNNI6bsroUhum9qSURdpChtScCD8jMoecPpnOa93RPZnIs8/hzG99A+Pfcocr8baGGal4ZKiGaoHrFq8NzqSnkXCKP4rJjo1t2nyqNyWm/A4pO9FyAxwzmol30KypGpPt0hXWWELXQYyXtpLxqz4ItAe7gOiWgachLwP+s1dILlr1w5Rf04obcTymUwfS4f6M06qDAPia28+XOO+EBvuNIhVKcLX5sGhJq8Wl/f6RTn0OwIDAQAB";
    public static String notify_url = "http://127.0.0.1:8080/alipayNotify";
    /**
     * //alipay/return
     */
    public static String return_url = "http://127.0.0.1:8080/alipayReturn";
    public static String sign_type = "RSA2";
    public static String char_set = "utf-8";
    public static String gate_way = "https://openapi.alipaydev.com/gateway.do";
    public static String log_path = "E:\\alipay\\alipay_logo.png";
}
