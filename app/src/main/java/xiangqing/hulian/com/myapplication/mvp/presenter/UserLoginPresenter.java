package xiangqing.hulian.com.myapplication.mvp.presenter;

import android.content.Context;

import xiangqing.hulian.com.myapplication.mvp.bean.User;
import xiangqing.hulian.com.myapplication.mvp.biz.OnLoginListener;
import xiangqing.hulian.com.myapplication.mvp.biz.UserBiz;
import xiangqing.hulian.com.myapplication.mvp.view.IUserLoginView;

/**
 * Created by Administrator on 2018/6/16.
 */

public class UserLoginPresenter {
    private UserBiz userBiz;
    private IUserLoginView iUserLoginView;
    private Context context;

    public UserLoginPresenter(Context context,IUserLoginView iUserLoginView){
        this.iUserLoginView=iUserLoginView;
        this.context=context;
        userBiz=new UserBiz();
    }

    public void login(){
        iUserLoginView.showLoading();
        userBiz.login(context, iUserLoginView.getUserName(), iUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(User user) {
                iUserLoginView.toMainActivity(user);
                iUserLoginView.hideLoading();
            }

            @Override
            public void loginFailed(String string) {
                iUserLoginView.showFailedError(string);
                iUserLoginView.hideLoading();
            }
        });
    }

    public void clear(){
        iUserLoginView.clearUserName();
        iUserLoginView.clearPassword();
    }

}
