package com.shayan.assignment.feature.repolist.viewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shayan.assignment.feature.repolist.databinding.RepoListItemBinding
import com.shayan.assignment.feature.repolist.view.OnRepoClickListener
import com.shayan.assignment.model.GithubRepoModel

class RepoListAdapter(
    private val onRepoClickListener: OnRepoClickListener
) : RecyclerView.Adapter<RepoViewHolder>() {

    private var items: List<GithubRepoModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RepoViewHolder(
        RepoListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        onRepoClickListener,
    )

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun updateList(repos: List<GithubRepoModel>) {
        items = repos
        notifyDataSetChanged()
        //TODO: Use DiffUtil instead
    }
}
