package com.example.liaopenghui.cameramartix;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by liaopenghui on 16/9/1.
 */
public class Rotate3DAnimation  extends Animation {
    private final float mFromDegrees;//开始角度
    private final float mToDegrees;//结束角度
    private int mCenterX;
    private int mCenterY;
    private Camera mCamera;

    public Rotate3DAnimation(float fromDegrees, float toDegrees) {
        mFromDegrees = fromDegrees;
        mToDegrees = toDegrees;
    }

    /**
     * 告诉Animation目标view的大小参数,在这里可以初始化一些相关参数,例如设置druation interpolator 设置动画的参考点.
     * @param width
     * @param height
     * @param parentWidth
     * @param parentHeight
     */
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mCenterX  = width/2;
        mCenterY = height/2;
        mCamera = new Camera();
    }

    /**
     * 用来实现自定义动画效果
     * @param interpolatedTime
     * @param t
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        final float fromDegrees = mFromDegrees;
        float degrees = fromDegrees+(mToDegrees-mFromDegrees)*interpolatedTime;
        Matrix matrix = t.getMatrix();
        mCamera.save();

        mCamera.rotateY(degrees);
        mCamera.getMatrix(matrix);
        mCamera.restore();

        matrix.preTranslate(-mCenterX,-mCenterY);
        matrix.postTranslate(mCenterX,mCenterY);
    }
}
