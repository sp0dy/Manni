package pro.haichuang.manni;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import java.util.logging.Level;
import okhttp3.OkHttpClient;
import pro.haichuang.manni.util.Utils;

public class MyApp extends Application {

    private String tag = "zy";
    private static MyApp instance;
    private static OkHttpClient sOkHttpClient;


    @Override
    public void onCreate() {
        super.onCreate();
        initOkGo();
        Utils.init(this);
        instance = this;

    }

    private void initOkGo() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //添加cookie
//        ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(getApplicationContext()));

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("okgo");
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        loggingInterceptor.setColorLevel(Level.INFO);
        builder.addInterceptor(loggingInterceptor);
        HttpsUtils.SSLParams sslSocketFactory = HttpsUtils.getSslSocketFactory();
        builder.sslSocketFactory(sslSocketFactory.sSLSocketFactory,sslSocketFactory.trustManager);
//        builder.cookieJar(cookieJar);
        HttpHeaders headers = new HttpHeaders();
        headers.put("commonHeaderKey1", "commonHeaderValue1");    //header不支持中文，不允许有特殊字符
        headers.put("commonHeaderKey2", "commonHeaderValue2");
        HttpParams params = new HttpParams();
        params.put("commonParamsKey1", "commonParamsValue1");     //param支持中文,直接传,不要自己编码
        params.put("commonParamsKey2", "这里支持中文参数");

        sOkHttpClient = builder.build();

        OkGo.getInstance().init(this)
                .setOkHttpClient(sOkHttpClient)
                .setCacheMode(CacheMode.NO_CACHE)
                .setCacheTime(-1);
    }


    public static MyApp getInstance() {
        return instance;
    }

    /**
     * 检测网络是否可用
     *
     * @return
     */
    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnectedOrConnecting();
    }


//    /**
//     * 保存缓存用户信息
//     *
//     * @param user
//     */
//    public void saveUserInfo(final UserInfo user) {
//        if (user != null) {
//            Storage.ClearUserInfo();
//            Storage.saveUsersInfo(user);
//        }
//    }

//    /**
//     * 判断是否登录过了
//     *
//     * @return
//     */
//    public boolean isLogin() {
//        if (TextUtils.isEmpty(Storage.getToken())) {//未登录的uid为-1
//            return false;
//        }
//        return true;
//    }

    /**
     * 取消网络请求
     * @param tag
     */
    public static void cancel(String tag) {
        OkGo.cancelTag(sOkHttpClient, tag);
    }

}
