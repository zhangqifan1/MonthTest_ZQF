package com.bawei.monthtest_zqf.Presenter;

import android.content.Context;

import com.bawei.monthtest_zqf.JavaBean.NewBean;
import com.bawei.monthtest_zqf.Model.GameModel;
import com.bawei.monthtest_zqf.Model.IGameModel;
import com.bawei.monthtest_zqf.View.IGameView;


/**
 * Created by 张祺钒
 * on2017/10/18.
 */

public class Presenter {
    private IGameModel gameModel;
    private IGameView gameView;
    private Context context;

    public Presenter(IGameView gameView, Context context) {
        this.gameView = gameView;
        this.context = context;
        gameModel=new GameModel();
    }

    public void getData(String path){
        gameModel.getGameBean(new GameModel.callBack() {
            @Override
            public void setData(NewBean gameBean) {
                gameView.setGameBean(gameBean);
            }
        }, path);
    }
}
