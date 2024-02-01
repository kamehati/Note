package com.example.note

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StyleRes
import androidx.appcompat.widget.Toolbar
import com.example.note.databinding.CollapsingAppbarLayoutBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout

class TopAppBarLayout @JvmOverloads constructor (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = -1
) : AppBarLayout(context, attrs, defStyleAttr) {

    private var collapsingAppBarBinding:
            CollapsingAppbarLayoutBinding? = null

    init {
        collapsingAppBarBinding =
            CollapsingAppbarLayoutBinding.inflate(
                LayoutInflater.from(context),
                this,
                true
            )

        stateListAnimator = null


    }

    fun setTextColor(@ColorRes id: Int) {
        collapsingAppBarBinding?.
        collapsingToolbarLayout?.
        textColor(id)
    }


    fun setCollapsingScrimColor(@ColorRes id: Int) {
        collapsingAppBarBinding?.
        collapsingToolbarLayout?.
        setCollapsingScrimColor(id)
    }


    fun setCollapsingToolbarColor(
        @ColorRes colorId: Int? = null,
        @DrawableRes drawableId: Int? = null
    ) {
        collapsingAppBarBinding?.
        collapsingToolbarLayout?.
        setCollapsingToolbarColor(colorId, drawableId)
    }


    fun setTitleAppearance(@StyleRes id: Int) {
        collapsingAppBarBinding?.
        collapsingToolbarLayout?.
        setCollapsedTitleTextAppearance(id)
        collapsingAppBarBinding?.
        collapsingToolbarLayout?.
        setExpandedTitleTextAppearance(id)
    }

    val toolbar: Toolbar
        get() = collapsingAppBarBinding?.toolbar!!

    val collapsingToolbar: CollapsingToolbarLayout?
        get() = collapsingAppBarBinding?.collapsingToolbarLayout

    var title: String?
        get() = collapsingAppBarBinding?.
        collapsingToolbarLayout?.
        title.toString()
        set(value) {
            collapsingAppBarBinding?.
            collapsingToolbarLayout?.
            title = value
        }

    val image: ImageView?
        get() = collapsingAppBarBinding?.image
}