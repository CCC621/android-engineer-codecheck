/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.code_check

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import jp.co.yumemi.android.code_check.TopActivity.Companion.lastSearchDate
import jp.co.yumemi.android.code_check.databinding.FragmentDetailBinding

/**
 * リポジトリの詳細表示用Fragment
 */
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val args: DetailFragmentArgs by navArgs()
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("検索した日時", lastSearchDate.toString())
        _binding = FragmentDetailBinding.bind(view)
        val item = args.item
        binding?.let {
            it.ownerIconView.load(item.ownerIconUrl)
            it.nameView.text = item.name
            it.languageView.text = item.language
            it.starsView.text = getString(R.string.detail_fragment_stars, item.stargazersCount)
            it.watchersView.text = getString(R.string.detail_fragment_watchers, item.watchersCount)
            it.forksView.text = getString(R.string.detail_fragment_forks, item.forksCount)
            it.openIssuesView.text = getString(R.string.detail_fragment_open_issue, item.openIssuesCount)
        }
    }
}
