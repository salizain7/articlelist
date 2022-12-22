package com.example.listarticles.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listarticles.`interface`.IArticleItemClickListener
import com.example.listarticles.databinding.ArticleLayoutBinding
import com.example.listarticles.models.Article


class ArticleListAdapter : RecyclerView.Adapter<ArticleListAdapter.ViewHolder>() {
    private var articleList = ArrayList<Article>()
    private var itemClickListener: IArticleItemClickListener? = null

    fun setArticleList(articleList: List<Article>) {
        this.articleList = articleList as ArrayList<Article>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ArticleLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ArticleLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }
    fun setItemClickListenr(itemClickListenr: IArticleItemClickListener) {
        itemClickListener = itemClickListenr
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(holder.itemView)
            .load(articleList[position].media[0].mediameta[0].url)
            .circleCrop()
            .into(holder.binding.image)
        holder.binding.title.text = articleList[position].title
        holder.binding.date.text = articleList[position].published_date
        holder.binding.desc.text = articleList[position].abstract

        holder.itemView.setOnClickListener(View.OnClickListener {
            itemClickListener?.onItemClick(
                position,articleList[position]
            )
        })
    }

    override fun getItemCount(): Int {
        return articleList.size
    }
}