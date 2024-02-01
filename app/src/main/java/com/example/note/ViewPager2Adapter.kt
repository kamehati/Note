package com.example.note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ViewPager2Adapter(
    private val activity: MainActivity,
    var dataSet: List<NoteEntity>
): RecyclerView.Adapter<ViewPager2Adapter.ViewHolder>() {

    init {
        setHasStableIds(true)
    }

    fun swapDataSet(
        dataSet: List<NoteEntity>
    ) {
        this.dataSet = ArrayList(dataSet).sortedBy { it.id }
        notifyDataSetChanged()
    }

    override fun getItemId(position: Int): Long {
        return dataSet[position].id
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater
            .from(activity)
            .inflate(
                R.layout.item_edit_text,
                parent,
                false
            )

        return createViewHolder(view)
    }

    private fun createViewHolder(view: View): ViewHolder{
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.apply {
            editText?.setText(note.content)
            editTextLayout?.apply {

                boxColor(R.color.md_blue_grey_900)
                hintColor(R.color.md_light_blue_200)
                strokeColor(R.color.md_light_blue_200)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    inner class ViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){
        val note
        get() = dataSet[layoutPosition]
        var editText: TextInputEditText? = null
        var editTextLayout: TextInputLayout? = null

        init {
            editText = itemView.findViewById(R.id.edit_text)
            editTextLayout = itemView.findViewById(R.id.edit_text_layout)
            editText?.doOnTextChanged { _, _, _, _ ->
                val text = editText?.text ?: ""
                if(activity.count != 0){
                    val note = updateNote(
                        note.id,
                        text.toString()
                    )
                    activity.checkInsert(note)
                }
            }
        }
    }
}