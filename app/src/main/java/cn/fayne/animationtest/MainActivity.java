package cn.fayne.animationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button alphaButton;
    private Button rotateButton;
    private Button translateButton;
    private Button scaleButton;
    private Button animationButton;
    private Button customButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        alphaButton = findViewById(R.id.btnAlpha);
        alphaButton.setOnClickListener(this);
        rotateButton = findViewById(R.id.btnRotate);
        rotateButton.setOnClickListener(this);
        translateButton = findViewById(R.id.btnTranslate);
        translateButton.setOnClickListener(this);
        scaleButton = findViewById(R.id.btnScale);
        scaleButton.setOnClickListener(this);
        animationButton = findViewById(R.id.btnAnimationSet);
        animationButton.setOnClickListener(this);
        customButton = findViewById(R.id.btnCustomAnimation);
        customButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAlpha:
                AlphaAnimation alpha = new AlphaAnimation(0, 1);
                alpha.setDuration(2000);
                //alpha.setFillAfter(true); // 设置最终效果不变
                alphaButton.startAnimation(alpha);
                break;
            case R.id.btnRotate:
                RotateAnimation rotate = new RotateAnimation(0, 360, 600, 0);
                rotate.setDuration(2000);
                rotateButton.startAnimation(rotate);
                break;
            case R.id.btnTranslate:
                TranslateAnimation translate = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0.5f);
                translate.setDuration(3000);
                translateButton.startAnimation(translate);
                break;
            case R.id.btnScale:
                ScaleAnimation scale = new ScaleAnimation(1, 0, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scale.setDuration(1000);
                scaleButton.startAnimation(scale);
                break;
            case R.id.btnAnimationSet:
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.setDuration(2000);
                AlphaAnimation another_alpha = new AlphaAnimation(0, 1);
                RotateAnimation another_rotate = new
                        RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animationSet.addAnimation(another_alpha);
                animationSet.addAnimation(another_rotate);
                animationButton.startAnimation(animationSet);
                break;
            case R.id.btnCustomAnimation:
                CustomAnimation customAnimation = new CustomAnimation(30,40);
                customAnimation.setDuration(1000);
                customButton.startAnimation(customAnimation);
                break;
            default:
                break;
        }
    }
}
