package com.example.note

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Build
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.Slider
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

fun BottomNavigationView.backgroundTintListColor(@ColorRes id: Int) {
    backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context,id))
}

fun BottomNavigationView.backgroundColor(
    @ColorRes colorId: Int? = null,
    @DrawableRes drawableId: Int? = null
) {
    if (colorId != null){
        setBackgroundColor(ContextCompat.getColor(context,colorId))
    } else if(drawableId != null){
        background = ContextCompat.getDrawable(context, drawableId)
    }

}

fun BottomNavigationView.itemIconColor(@ColorRes id: Int) {
    itemIconTintList = ColorStateList.valueOf(ContextCompat.getColor(context,id))
}

fun BottomNavigationView.itemTextColor(@ColorRes id: Int) {
    itemTextColor = ColorStateList.valueOf(ContextCompat.getColor(context,id))
    itemTextAppearanceInactive
}


fun BottomNavigationView.itemRippleColor(@ColorRes id: Int) {
    itemRippleColor = ColorStateList.valueOf(ContextCompat.getColor(context,id))
}

fun BottomNavigationView.itemRipple() {
    itemBackground = ContextCompat.getDrawable(context!!, R.drawable.round_selector)
}


fun BottomNavigationView.activeItemColor(@ColorRes id: Int) {
    itemActiveIndicatorColor = ColorStateList.valueOf(ContextCompat.getColor(context,id))
    isItemActiveIndicatorEnabled
}


fun FrameLayout.backGroundColor(@ColorRes id: Int) {
    setBackgroundColor(ContextCompat.getColor(context,id))
}


fun AppCompatImageView.backGroundColor(@ColorRes id: Int) {
    imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context,id))
}


fun MaterialButton.backgroundColor(@ColorRes id: Int) {
    backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context,id))
}


fun MaterialButton.textColor(@ColorRes id: Int) {
    setTextColor(ContextCompat.getColor(context,id))
}


fun MaterialButton.strokeColor(@ColorRes id: Int) {
    setStrokeColorResource(id)
}


fun MaterialButton.iconColor(@ColorRes id: Int) {
    setIconTintResource(id)
}


fun MaterialButton.rippleColor(@ColorRes id: Int) {
    setRippleColorResource(id)
}

fun Button.textColor(@ColorRes id: Int) {
    setTextColor(ContextCompat.getColor(context,id))
}


fun Toolbar.backgroundColor(
    @ColorRes colorId: Int? = null,
    @DrawableRes drawableId: Int? = null
) {
    if(colorId != null){
        setBackgroundColor(ContextCompat.getColor(context,colorId))
    } else if(drawableId != null){
        background = ContextCompat.getDrawable(context, drawableId)
    }
}


fun MaterialTextView.textColor(@ColorRes id: Int) {
    setTextColor(ContextCompat.getColor(context,id))
}


fun CollapsingToolbarLayout.setCollapsingScrimColor(@ColorRes id: Int) {
    setContentScrimColor(ContextCompat.getColor(context,id))
}


fun CollapsingToolbarLayout.setCollapsingToolbarColor(
    @ColorRes colorId: Int? = null,
    @DrawableRes drawableId: Int? = null
) {
    if(colorId != null){
        setBackgroundColor(ContextCompat.getColor(context,colorId))
    } else if(drawableId != null){
        background = ContextCompat.getDrawable(context, drawableId)
    }
}


fun MaterialCardView.strokeColor(@ColorRes id: Int) {
    setStrokeColor(ColorStateList.valueOf(ContextCompat.getColor(context,id)))
}


fun CoordinatorLayout.backgroundColor(
    @ColorRes colorId: Int? = null,
    @DrawableRes drawableId: Int? = null
) {
    if(colorId != null){
        setBackgroundColor(ContextCompat.getColor(context,colorId))
    } else if(drawableId != null){
        background = ContextCompat.getDrawable(context, drawableId)
    }
}


fun TabLayout.backgroundColor(
    @ColorRes colorId: Int? = null,
    @DrawableRes drawableId: Int? = null
) {
    if(colorId != null){
        setBackgroundColor(ContextCompat.getColor(context,colorId))
    } else if(drawableId != null){
        background = ContextCompat.getDrawable(context, drawableId)
    }
}


fun TabLayout.selectedTabIndicatorColor(
    @ColorRes id: Int? = null
) {
    if(id != null){
        setSelectedTabIndicatorColor(
            ContextCompat.getColor(context,id)
        )
    } else {
        setSelectedTabIndicator(null)
    }
}

fun TabLayout.tabTextColor(
    @ColorRes unSelected: Int,
    @ColorRes selected: Int
) {
    setTabTextColors(
        ContextCompat.getColor(context,unSelected),
        ContextCompat.getColor(context,selected)
    )
}


fun TabLayout.rippleColor(@ColorRes id: Int) {
    setTabRippleColorResource(id)
}

fun View.backgroundColor(@ColorRes id: Int) {
    setBackgroundColor(ContextCompat.getColor(context, id))
}


fun SeekBar.seekbarColor(
    @ColorRes tintColor: Int,
    @ColorRes progressColor: Int
) {

    thumbTintList = ColorStateList.valueOf(ContextCompat.getColor(context,tintColor))

    progressTintList = ColorStateList.valueOf(ContextCompat.getColor(context,tintColor))

    progressBackgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context,progressColor))
}


fun TextView.textColor(@ColorRes id: Int) {
    setTextColor(ContextCompat.getColor(context,id))
}


fun FloatingActionButton.backgroundColor(
    @ColorRes backgroundColor: Int,
    @ColorRes iconColor: Int
) {

    backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context,backgroundColor))

    imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context,iconColor))
}


fun AppCompatImageView.iconColor(@ColorRes id: Int) {
    imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context,id))
}

fun Snackbar.backgroundColor(@ColorRes id: Int): Snackbar {
    setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context,id)))
    return this
}

fun Snackbar.textColor(@ColorRes id: Int): Snackbar {
    setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context,id)))
    return this
}

fun FragmentActivity.statusBarColor(@ColorRes id: Int) {
    window.statusBarColor = ContextCompat.getColor(baseContext,id)
}

fun FragmentActivity.navigationBarColor(@ColorRes id: Int) {
    window.navigationBarColor = ContextCompat.getColor(baseContext,id)
}

fun ImageButton.iconColor(@ColorRes id: Int) {
    setColorFilter(
        ContextCompat.getColor(context, id),
        PorterDuff.Mode.SRC_IN
    )
}

fun FragmentContainerView.backgroundColor(@ColorRes id: Int) {
    setBackgroundColor(ContextCompat.getColor(context,id))
}

fun FrameLayout.backgroundColor(@ColorRes id: Int) {
    setBackgroundColor(ContextCompat.getColor(context,id))
}

fun ImageView.iconColor(@ColorRes id: Int) {
    imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context,id))
}

fun Slider.seekBarColor(
    @ColorRes tintColor: Int,
    @ColorRes progressColor: Int
) {

    thumbTintList = ColorStateList.valueOf(ContextCompat.getColor(context,tintColor))

    trackTintList = ColorStateList.valueOf(ContextCompat.getColor(context,progressColor))
}

fun NumberPicker.backgroundColor(@ColorRes id: Int){

}

@RequiresApi(Build.VERSION_CODES.O)
fun MenuItem.iconColor(@ColorRes id: Int, activity: FragmentActivity){
    iconTintList = ColorStateList.valueOf(ContextCompat.getColor(activity,id))
}

fun TextInputLayout.hintColor(@ColorRes id: Int){
    hintTextColor = ColorStateList.valueOf(ContextCompat.getColor(context,id))
}

fun TextInputLayout.boxColor(@ColorRes id: Int){
    boxBackgroundColor = ContextCompat.getColor(context,id)
}

fun TextInputLayout.strokeColor(@ColorRes id: Int){
    boxStrokeColor = ContextCompat.getColor(context,id)
}

fun TextInputLayout.endIconColor(@ColorRes id: Int){
    setEndIconTintList(ColorStateList.valueOf(ContextCompat.getColor(context,id)))
}

fun TextInputLayout.endIconVisible(isVisible: Boolean = false){
    isEndIconVisible = isVisible
}

fun Chip.backgroundColor(
    @ColorRes id1: Int,@ColorRes textId1: Int,
    @ColorRes id2: Int,@ColorRes textId2: Int
){
    if(isChecked){
        chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(context,id1))
        setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context,textId1)))
    } else {
        chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(context,id2))
        setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context,textId2)))
    }
}

fun CollapsingToolbarLayout.textColor(@ColorRes id: Int){

    setCollapsedTitleTextColor(ContextCompat.getColor(context,id))
    setExpandedTitleColor(ContextCompat.getColor(context,id))
}


fun ViewPager2.backgroundColor(
    @ColorRes colorId: Int? = null,
    @DrawableRes drawableId: Int? = null
) {
    if(colorId != null){
        setBackgroundColor(ContextCompat.getColor(context,colorId))
    } else if(drawableId != null){
        background = ContextCompat.getDrawable(context, drawableId)
    }
}