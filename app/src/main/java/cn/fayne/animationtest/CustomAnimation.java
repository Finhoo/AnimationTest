package cn.fayne.animationtest;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class CustomAnimation extends Animation {

    //偏移距离
    private float mDistance;
    //移动速度
    private float mVelocity;

    public CustomAnimation(float distance, float velocity) {
        mDistance = distance;
        mVelocity = velocity;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float dis= (float) (Math.sin(interpolatedTime * mVelocity) * mDistance);
        t.getMatrix().setTranslate(dis, 0);
    }
}
