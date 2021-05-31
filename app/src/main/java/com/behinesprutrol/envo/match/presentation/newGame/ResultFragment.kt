package com.behinesprutrol.envo.match.presentation.newGame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.behinesprutrol.envo.match.R
import com.behinesprutrol.envo.match.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val mBinding get() = _binding!!
    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.tvScore.text = "Your Score is ${args.correct} out of ${args.total}"

        mBinding.btnFinish.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_menuFragment)
        }
    }
}