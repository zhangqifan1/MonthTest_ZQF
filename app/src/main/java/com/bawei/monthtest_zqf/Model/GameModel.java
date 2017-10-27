package com.bawei.monthtest_zqf.Model;

import com.bawei.monthtest_zqf.JavaBean.NewBean;
import com.bawei.monthtest_zqf.OkHttp.OkhttpUtils;
import com.bawei.monthtest_zqf.OkHttp.ResultCallback;
import com.squareup.okhttp.Request;

/**
 * Created by 张祺钒
 * on2017/10/18.
 */

public class GameModel implements IGameModel {


    @Override
    public void getGameBean(final callBack callBack, String path) {
        OkhttpUtils.getAsyn(path, new ResultCallback<NewBean>() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(NewBean response) {
                callBack.setData(response);
            }
        });
    }
    public interface callBack{
        void setData(NewBean gameBean);
    }
}
