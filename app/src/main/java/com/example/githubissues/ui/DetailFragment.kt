package com.example.githubissues.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.githubissues.R
import com.example.githubissues.databinding.FragmentDetailBinding
import com.example.githubissues.util.DateHandler
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerFragment
import java.util.*

class DetailFragment : DaggerFragment() {

    lateinit var bind : FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        bindView()
        setHasOptionsMenu(true)
        return bind.root
    }

    private fun bindView(){
        bind.apply {
            val dateConverted = DateHandler().getRelativeDate(context!!, args.createdAt, Date())
            createdAtVar = String.format(context!!.getString(R.string.published), dateConverted)
            clickListener = createOnClickListener(args.htmlUrl)
            titleVar = args.title
            bodyVar = args.body
        }

        Picasso.get()
            .load(args.avatarUrl)
            .resize(96, 96)
            .centerCrop()
            .placeholder(R.drawable.user_placeholder)
            .error(R.drawable.user_placeholder)
            .into(bind.avatar)

    }

    private fun createOnClickListener(url: String): View.OnClickListener {
        return View.OnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }
}