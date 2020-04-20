package cn.mycommons.simpleandroidbase.sab.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public interface IUiCreator {

    void onCreateBefore();

    void onCreateAfter(@Nullable Bundle savedInstanceState);
}