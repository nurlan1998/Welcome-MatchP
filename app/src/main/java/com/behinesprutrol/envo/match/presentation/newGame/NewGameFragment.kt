package com.behinesprutrol.envo.match.presentation.newGame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.behinesprutrol.envo.match.R
import com.behinesprutrol.envo.match.data.Question
import com.behinesprutrol.envo.match.databinding.FragmentMenuBinding
import com.behinesprutrol.envo.match.databinding.FragmentNewGameBinding


class NewGameFragment : Fragment() {

    private var _binding: FragmentNewGameBinding? = null
    private val mBinding get() = _binding!!

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswer: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentNewGameBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}