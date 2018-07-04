package xiangqing.hulian.com.myapplication.mvp.biz;

import xiangqing.hulian.com.myapplication.mvp.bean.User;

/**
 * Created by Administrator on 2018/6/16.
 */

public interface OnLoginListener {
    public void loginSuccess(User user);
    public void loginFailed(String string);
}
