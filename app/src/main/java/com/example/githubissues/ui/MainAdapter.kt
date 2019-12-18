package com.example.githubissues.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.githubissues.databinding.AdapterMainBinding
import com.example.githubissues.model.Issue

class MainAdapter(private val issueList: List<Issue>) : RecyclerView.Adapter<MainAdapter.ViewHolderDefault>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDefault {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AdapterMainBinding.inflate(layoutInflater, parent, false)
        return ViewHolderDefault(binding)
    }

    override fun getItemCount(): Int {
        return issueList.size
    }

    override fun onBindViewHolder(holder: ViewHolderDefault, position: Int) {
        val issue = issueList[position]
        holder.bind(issue, createOnClickListener(issue))
    }

    private fun createOnClickListener(issue: Issue): View.OnClickListener {
        return View.OnClickListener {
            val avatarUrl = issue.user?.avatar_url ?: ""
            val body = issue.body ?: ""
            val title = issue.title ?: ""
            val createdAt = issue.created_at!!
            val htmlUrl = issue.html_url ?: ""

            val direction = MainFragmentDirections.actionMainFragmentToDetailFragment(title, body,avatarUrl, createdAt, htmlUrl)
            it.findNavController().navigate(direction)
        }
    }

    open class ViewHolderDefault(private val binding: AdapterMainBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(issue: Issue, listener: View.OnClickListener){
            binding.apply {
                state.text = issue.state
                title.text = issue.title
                clickListener = listener

            }
        }
    }
}