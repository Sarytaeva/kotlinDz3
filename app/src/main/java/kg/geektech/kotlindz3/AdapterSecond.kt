package kg.geektech.kotlindz3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.kotlindz3.databinding.ItemRamBinding
import javax.xml.validation.ValidatorHandler

class AdapterSecond() : RecyclerView.Adapter<AdapterSecond.ViewHolderSecond>() {
    private var listImage = arrayListOf<Int>()
    fun setList(listImage: ArrayList<Int>){
        this.listImage = listImage
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSecond {
        val binding= ItemRamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderSecond(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderSecond, position: Int) {
        holder.bind(listImage[position])

    }
    override fun getItemCount(): Int = listImage.size
    inner class ViewHolderSecond(private  val binding: ItemRamBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            i: Int) {
            binding.image.setImageResource(listImage[adapterPosition])
        }
    }
}