package xiangqing.hulian.com.myapplication.mvp.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xiangqing.hulian.com.myapplication.R;
import xiangqing.hulian.com.myapplication.mvp.bean.User;
import xiangqing.hulian.com.myapplication.mvp.presenter.UserLoginPresenter;

public class UserLoginActivity extends Activity implements IUserLoginView {

    @Bind(R.id.t_username)
    EditText tUsername;
    @Bind(R.id.t_password)
    EditText tPassword;

    @Bind(R.id.progressbar)
    ProgressBar progressbar;

    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.b_login, R.id.b_clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.b_login:
                userLoginPresenter.login();
                break;
            case R.id.b_clear:
                userLoginPresenter.clear();
                break;
        }
    }

    @Override
    public String getUserName() {
        return tUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return tPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        tUsername.setText("");
    }

    @Override
    public void clearPassword() {
        tPassword.setText("");
    }

    @Override
    public void showLoading() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressbar.setVisibility(View.GONE);

    }

    @Override
    public void toMainActivity(User user) {

    }

    @Override
    public void showFailedError(String string) {
        Toast.makeText(this, "string", Toast.LENGTH_SHORT).show();
    }
}
