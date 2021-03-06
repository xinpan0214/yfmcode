//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.2.
//


package com.pro.view;

import android.content.Context;
import android.util.AttributeSet;
import com.pro.hsh.R.layout;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedNotifier;


/**
 * We use @SuppressWarning here because our java code
 * generator doesn't know that there is no need
 * to import OnXXXListeners from View as we already
 * are in a View.
 * 
 */
@SuppressWarnings("unused")
public final class CategoryView_grid_item_
    extends CategoryView_grid_item
    implements HasViews
{

    private boolean alreadyInflated_ = false;
    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    public CategoryView_grid_item_(Context context) {
        super(context);
        init_();
    }

    public CategoryView_grid_item_(Context context, AttributeSet attrs) {
        super(context, attrs);
        init_();
    }

    public static CategoryView_grid_item build(Context context) {
        CategoryView_grid_item_ instance = new CategoryView_grid_item_(context);
        instance.onFinishInflate();
        return instance;
    }

    /**
     * The mAlreadyInflated_ hack is needed because of an Android bug
     * which leads to infinite calls of onFinishInflate()
     * when inflating a layout with a parent and using
     * the <merge /> tag.
     * 
     */
    @Override
    public void onFinishInflate() {
        if (!alreadyInflated_) {
            alreadyInflated_ = true;
            inflate(getContext(), layout.fragment_category_grid_item, this);
            onViewChangedNotifier_.notifyViewChanged(this);
        }
        super.onFinishInflate();
    }

    private void init_() {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
    }

    public static CategoryView_grid_item build(Context context, AttributeSet attrs) {
        CategoryView_grid_item_ instance = new CategoryView_grid_item_(context, attrs);
        instance.onFinishInflate();
        return instance;
    }

}
