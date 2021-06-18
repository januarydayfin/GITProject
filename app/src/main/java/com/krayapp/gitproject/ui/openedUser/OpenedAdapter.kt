package com.krayapp.gitproject.ui.openedUser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.krayapp.gitproject.databinding.UserGitRepoTemplateBinding

class OpenedAdapter(val presenter:UserGitRepoPresenter):RecyclerView.Adapter<OpenedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(UserGitRepoTemplateBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position }) }

    override fun getItemCount(): Int =
        presenter.getCount()


    inner class ViewHolder(val binding: UserGitRepoTemplateBinding): RecyclerView.ViewHolder(binding.root), GitRepoView {
        override fun setRepo(repo: String) {
            binding.repoName.text = repo
        }
        override var pos = -1

    }
}