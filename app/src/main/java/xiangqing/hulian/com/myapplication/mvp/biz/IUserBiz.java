package xiangqing.hulian.com.myapplication.mvp.biz;

import android.content.Context;

/**
 * Created by Administrator on 2018/6/16.
 */

public interface IUserBiz {
    public void login(Context context,String username, String password, OnLoginListener onLoginListener);
}
