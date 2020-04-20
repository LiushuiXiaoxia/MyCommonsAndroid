package cn.mycommons.simpleandroidbase.sab.widget

import android.support.annotation.LayoutRes
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun RecyclerView.setupLikeListView() {
    layoutManager = LinearLayoutManager(context)
    addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
}

interface IViewModel

abstract class BaseViewHolder<VM : IViewModel>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {

        @JvmStatic
        fun <VH : BaseViewHolder<*>> create(
            viewGroup: ViewGroup,
            @LayoutRes layoutId: Int,
            vhClazz: Class<VH>
        ): VH {
            val inflater = LayoutInflater.from(viewGroup.context)
            val view = inflater.inflate(layoutId, viewGroup, false)
            val constructor = vhClazz.getConstructor(View::class.java)
            return constructor.newInstance(view)
        }
    }

    init {
        itemView.setOnClickListener {
            onItemClickCallback?.onItemClick(viewModel)
        }
    }

    lateinit var viewModel: VM

    var onItemClickCallback: OnItemClickCallback<VM>? = null

    abstract fun bind(model: VM, position: Int)
}

interface OnItemClickCallback<VM : IViewModel> {

    fun onItemClick(model: VM)
}

abstract class BaseRvAdapter<VH : BaseViewHolder<VM>, VM : IViewModel> : RecyclerView.Adapter<VH>() {

    private val allData = mutableListOf<VM>()

    private var onItemClickCallback: OnItemClickCallback<VM>? = null

    override fun getItemCount(): Int = allData.size

    abstract override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.viewModel = allData[position]
        holder.onItemClickCallback = onItemClickCallback
        holder.bind(allData[position], position)
    }

    fun update(list: List<VM>) {
        allData.clear()
        allData.addAll(list)
        notifyDataSetChanged()
    }

    fun add(model: VM) {
        allData.add(model)

        notifyDataSetChanged()
    }

    fun itemClickCallback(callback: (VM) -> Unit) {
        onItemClickCallback = object :
            OnItemClickCallback<VM> {
            override fun onItemClick(model: VM) {
                callback.invoke(model)
            }
        }
    }
}
