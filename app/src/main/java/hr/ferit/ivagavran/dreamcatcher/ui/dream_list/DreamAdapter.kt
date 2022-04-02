package hr.ferit.ivagavran.dreamcatcher.ui.dream_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.ivagavran.dreamcatcher.R
import hr.ferit.ivagavran.dreamcatcher.databinding.ItemDreamBinding
import hr.ferit.ivagavran.dreamcatcher.model.Dream
import hr.ferit.ivagavran.dreamcatcher.utils.getColorResource
import java.text.SimpleDateFormat

class DreamAdapter : RecyclerView.Adapter<DreamViewHolder>() {
    private val dreams = mutableListOf<Dream>()
    var onDreamSelectedListener: OnDreamEventListener? = null

    fun setDreams(dreams: List<Dream>) {
        this.dreams.clear()
        this.dreams.addAll(dreams)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DreamViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dream, parent, false)
        return DreamViewHolder(view)
    }

    override fun onBindViewHolder(holder: DreamViewHolder, position: Int) {
        val dream = dreams[position]
        holder.bind(dream)
        onDreamSelectedListener?.let { listener ->
            holder.itemView.setOnLongClickListener { listener.onDreamLongPress(dream) }
        }
    }

    override fun getItemCount(): Int = dreams.count()
}

class DreamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val dateDisplayFormat = SimpleDateFormat("yyyy-MM-dd")

    fun bind(dream: Dream) {

        val binding = ItemDreamBinding.bind(itemView)
        dream?.let {
            binding.itemDreamDescription.text = dream.description
            binding.itemDreamColor.setBackgroundResource(
                binding.itemDreamColor.context.resources.getColorResource(dream.color)
            )
            binding.itemDateAddedInput.text = dateDisplayFormat.format(it.dateAdded)
        }
    }
}