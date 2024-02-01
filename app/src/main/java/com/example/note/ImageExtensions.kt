package com.example.note

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImage(month: Int){
    backgroundColor(R.color.md_black_1000)
    Glide.with(this.context)
        .load(
            when(month){
                3,4,5 -> {
                    spring.random()
                }
                6,7,8 -> {
                    summer.random()
                }
                9,10,11 -> {
                    autumn.random()
                }
                12,1,2 -> {
                    winter.random()
                }
                else -> {
                    DEFAULT_SET_IMAGE
                }
            }
        ).error(DEFAULT_SET_IMAGE)
        .placeholder(null)
        .into(this)
}

private val spring = listOf(
    R.drawable.spring_starry_sky_1,
    R.drawable.cherry_brossom_1,
    R.drawable.thunder_1,
    R.drawable.night_1,
    R.drawable.road_1,
    R.drawable.ruins_1,
)

private val summer = listOf(
    R.drawable.summer_starry_sky_1,
    R.drawable.thunder_1,
    R.drawable.night_1,
    R.drawable.road_1,
    R.drawable.ruins_1,
)

private val autumn = listOf(
    R.drawable.autumn_1,
    R.drawable.thunder_1,
    R.drawable.night_1,
    R.drawable.road_1,
    R.drawable.ruins_1,
)

private val winter = listOf(
    R.drawable.winter_starry_sky_1,
    R.drawable.thunder_1,
    R.drawable.night_1,
    R.drawable.road_1,
    R.drawable.ruins_1,
)

private const val DEFAULT_SET_IMAGE = R.drawable.ruins_1