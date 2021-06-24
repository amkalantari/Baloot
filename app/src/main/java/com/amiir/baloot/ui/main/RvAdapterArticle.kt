package com.amiir.baloot.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.amiir.baloot.databinding.LayoutItemArticleBinding
import com.core.base.BaseHolder
import com.core.dto.ArticleDto


class RvAdapterArticle(private val itemClickCallback: ((ArticleDto) -> Unit)?) :
    PagingDataAdapter<ArticleDto, RvAdapterArticle.Holder>(object :
        DiffUtil.ItemCallback<ArticleDto>() {

        override fun areItemsTheSame(
            oldItem: ArticleDto,
            newItem: ArticleDto
        ): Boolean = oldItem.title == newItem.title

        override fun areContentsTheSame(
            oldItem: ArticleDto,
            newItem: ArticleDto
        ): Boolean = oldItem == newItem
    }) {

    inner class Holder(val binding: LayoutItemArticleBinding) :
        BaseHolder<ArticleDto>(binding) {
        override fun bind(value: ArticleDto, position: Int) {
            binding.item = value
            binding.root.setOnClickListener {
                itemClickCallback?.let { it1 -> it1(value) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutItemArticleBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        getItem(position)?.let {
            holder.bind(it, position)
        }
    }

}