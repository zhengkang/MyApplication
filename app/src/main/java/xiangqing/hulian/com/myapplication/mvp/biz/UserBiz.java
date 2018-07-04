package xiangqing.hulian.com.myapplication.mvp.biz;

import android.content.Context;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.DownloadResponseHandler;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;

import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import xiangqing.hulian.com.myapplication.mvp.bean.User;

/**
 * Created by Administrator on 2018/6/16.
 */

public class UserBiz implements IUserBiz{
    @Override
    public void login(Context context, final String username, final String password, final OnLoginListener onLoginListener) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);

        MyOkHttp.get().post(context, "192.168.1.12", params, new JsonResponseHandler() {
            @Override
            public void onProgress(long currentBytes, long totalBytes) {
                super.onProgress(currentBytes, totalBytes);
            }

            @Override
            public void onSuccess(int statusCode, JSONObject jsonObject) {
                if(jsonObject.optString("code").equals("200")){
                    User user=new User();
                    user.setPassword(password);
                    user.setUsername(username);
                    onLoginListener.loginSuccess(user);
                }else{
                    onLoginListener.loginFailed(jsonObject.optString("msg"));
                }
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                onLoginListener.loginFailed("网络异常");
            }
        });

    }


}
