package ru.netology.retrofitwithcoroutinestest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.netology.retrofitwithcoroutinestest.databinding.FragmentPostBinding
import ru.netology.retrofitwithcoroutinestest.viewmodel.PostViewModel

class PostFragment : Fragment() {

    private val viewModel: PostViewModel by viewModels(ownerProducer = ::requireParentFragment)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPostBinding.inflate(inflater, container, false)

        viewModel.data.observe(viewLifecycleOwner) { posts ->
            binding.tvPost.text = posts[0].content
        }

        return binding.root
    }
}