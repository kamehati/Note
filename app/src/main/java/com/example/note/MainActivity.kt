package com.example.note

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.doOnAttach
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.note.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager2: ViewPager2
    private lateinit var viewPager2Adapter: ViewPager2Adapter

    private val noteViewModel by viewModel<NoteViewModel>()
    private val list = listOf(createNote(1L), createNote(2L))
    var count = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager2 = binding.viewPager2
        viewPager2Adapter = ViewPager2Adapter(this, listOf())
        viewPager2.adapter = viewPager2Adapter

        noteViewModel
            .getNote()
            .observe(this){
                viewPager2Adapter.swapDataSet(
                    if(it.isNotEmpty()){
                        if(it.size >= 2) it
                        else it + createNote(it.last().id + 1L,"")
                    } else {
                        list
                    }
                )
        }
        if(runBlocking {noteViewModel.getSavedContent()}.isEmpty()){
            insertNotes(list)
        }

        setViewPager2()
        setAppBarLayout()
        setUpDateTextAndImage()
        setUpFloatingButton()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setUpDateTextAndImage(){
        val now = LocalDate.now()
        val year = now.year
        val month = now.month.value
        val day = now.dayOfMonth
        val week = now.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
        val date = "$year/$month/$day($week)"
        binding.dateText.apply {
            text = date
            setTextAppearance(R.style.TextViewBody1)
        }
        binding.appBarLayout.image?.setImage(month)
    }

    private fun setAppBarLayout(){
        val appBarLayout = binding.appBarLayout
        appBarLayout.apply {
            setSupportActionBar(toolbar)
            setExpanded(true, true)
            title = resources.getString(R.string.app_name)
            setCollapsingScrimColor(R.color.md_grey_925)
            setTitleAppearance(R.style.TextViewHeadline5)

        }
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setViewPager2(){
        viewPager2.apply {
            backgroundColor(drawableId = R.drawable.shadow_border)


            doOnAttach {
                setCurrentItem(PreferenceUtil.viewPagerPosition, false)
            }


            registerOnPageChangeCallback(
                object : ViewPager2.OnPageChangeCallback() {

                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)

                        if(PreferenceUtil.viewPagerPosition != position){
                            PreferenceUtil.viewPagerPosition = position
                        }
                    }
                }
            )

            setPageTransformer {page, position ->
                page.also {
                    if(abs(position) >= 1f){
                        it.alpha = 0f
                        return@setPageTransformer
                    }
                    val scale = (1 - abs(position) / 2).coerceAtLeast(MIN_SCALE)
                    it.scaleX = scale
                    it.scaleY = scale
                    it.alpha = (1 - abs(position)).coerceAtLeast(MIN_ALPHA)
                    it.translationX = (1 - scale) * it.width / 2 * if(position > 0) -1 else 1
                }
            }
        }
    }

    private fun setUpFloatingButton(){
        binding.floatingButton.apply {
            backgroundColor(
                R.color.md_light_blue_600,
                R.color.md_white_1000
            )
            setOnClickListener {
                val listNote = runBlocking { noteViewModel.getSavedContent() }
                val lastNote = listNote.maxByOrNull { it.id }!!

                viewPager2Adapter.swapDataSet(listNote)

                if(lastNote.content.isNotEmpty()){
                    lifecycleScope.launch(IO){
                        noteViewModel.checkInsertNote(
                            createNote(lastNote.id + 1L)
                        )
                        noteViewModel.forceReload()
                    }
                }
            }
        }
    }

    fun checkInsert(note: NoteEntity) {

        lifecycleScope.launch(IO){
            noteViewModel.checkInsertNote(note)
        }
    }

    private fun insertNotes(notes: List<NoteEntity>){
        lifecycleScope.launch(IO){
            noteViewModel.apply {
                insertNotes(notes)
                forceReload()
            }
        }
    }

    override fun onResume() {
        super.onResume()

        count = 1
        noteViewModel.forceReload()
    }

    override fun onPause() {
        super.onPause()
        noteViewModel.apply {
            val notes = runBlocking {getSavedContent()}
            if(notes.last().content.isNotEmpty()){
                insertNote(createNote())
            } else {
                if(notes.size > 2){
                    var index = 0
                    var list = listOf<NoteEntity>()
                    while (
                        notes.size - index > 2 &&
                        notes[notes.lastIndex - index].content.isEmpty()
                    ){
                        if(notes[notes.lastIndex - index - 1].content.isEmpty()){
                            list = list + notes[notes.lastIndex - index]
                        }
                        index++
                    }
                    if(list.isNotEmpty()){
                        deleteNote(list)
                        if(PreferenceUtil.viewPagerPosition > notes.lastIndex - index){
                            PreferenceUtil.viewPagerPosition = notes.lastIndex - index
                        }
                    }
                }
            }

        }
    }
}

private const val MIN_SCALE = 0.85f
private const val MIN_ALPHA = 0.5f