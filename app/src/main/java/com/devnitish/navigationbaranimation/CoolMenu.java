package com.devnitish.navigationbaranimation;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by Nitish Prasad on 3/3/2018.
 */

public class CoolMenu implements ViewPager.PageTransformer {

    private final String TAG = "coolmenu";

    @Override
    public void transformPage(@NonNull View page, float position) {

        if(position<-1)
            page.setAlpha(0);
        else if(position>1)
            page.setAlpha(0);

        else page.setAlpha(1);

//        page.setTranslationX(-position*page.getWidth());

        if(page.getId() == R.id.menu){
            page.setTranslationX(-position*page.getWidth());
        }

        else if(page.getId() == R.id.content){

            if(position>0) {

                float pos = Math.abs(position);
                float scale = Math.max(.5f, 1 - pos);
                page.setScaleY(scale);
                page.setScaleX(scale);

                float pageWidth = page.getWidth();
                float pageScaleWidth = scale * pageWidth;
                float deltaWidth = pageWidth - pageScaleWidth;

                page.setTranslationX((1 - position) * page.getWidth() - pageScaleWidth - deltaWidth / 2);

//            page.setTranslationX(deltaWidth/2);

                Log.e(TAG, "transformpage : content" + page.getWidth() + " " + deltaWidth
                        + "  " + pageScaleWidth);

            }

            else if(position<0){
                float pos = Math.abs(position);
                float scale = Math.max(.5f, 1 - pos);
                page.setScaleY(scale);
                page.setScaleX(scale);

                float pageWidth = page.getWidth();
                float pageScaleWidth = scale * pageWidth;
                float deltaWidth = pageWidth - pageScaleWidth;

                page.setTranslationX(-position* page.getWidth()-deltaWidth/2);

//            page.setTranslationX(deltaWidth/2);

                Log.e(TAG, "transformpage : content" + page.getWidth() + " " + deltaWidth
                        + "  " + pageScaleWidth);

            }
        }

        else if(page.getId() == R.id.menu2){
            page.setTranslationX(-position*page.getWidth());
            Log.e(TAG, "transformPage: menu 2" );
        }
        else
        Log.e(TAG,"something wrong");
    }
}
