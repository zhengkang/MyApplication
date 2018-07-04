package xiangqing.hulian.com.myapplication.mvp.view;

import xiangqing.hulian.com.myapplication.mvp.bean.User;

/**
 * Created by Administrator on 2018/6/16.
 */

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError(String string);
}
