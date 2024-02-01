package com.example.note

import android.content.Context
import androidx.annotation.IntegerRes
import androidx.core.content.edit
import androidx.preference.PreferenceManager

object PreferenceUtil {

    private val sharedPreferences = PreferenceManager
        .getDefaultSharedPreferences(App.getContext())

    var viewPagerPosition
        get() = sharedPreferences.getInt(
            VIEWPAGER2_TAB_POSITION,
            App.getContext().getIntRes(
                R.integer.default_tab_position
            )
        )
        set(value) = sharedPreferences.edit{
            putInt(VIEWPAGER2_TAB_POSITION, value)
        }


}

fun Context.getIntRes(@IntegerRes int: Int): Int{
    return resources.getInteger(int)
}

const val VIEWPAGER2_TAB_POSITION = "viewpager2_tab_position"
const val APPBAR_MODE = "appbar_mode"
const val COUNT = "count"