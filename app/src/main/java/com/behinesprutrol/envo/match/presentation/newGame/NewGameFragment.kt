package com.behinesprutrol.envo.match.presentation.newGame

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.behinesprutrol.envo.match.R
import com.behinesprutrol.envo.match.data.Constants
import com.behinesprutrol.envo.match.data.Question
import com.behinesprutrol.envo.match.databinding.FragmentMenuBinding
import com.behinesprutrol.envo.match.databinding.FragmentNewGameBinding
import kotlinx.android.synthetic.main.fragment_new_game.*


class NewGameFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentNewGameBinding? = null
    private val mBinding get() = _binding!!

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    private var score = 150

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNewGameBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mQuestionList = Constants.getQuestion()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)

        mBinding.tvMenu.setOnClickListener {
            findNavController().navigate(R.id.action_newGameFragment_to_menuFragment)
        }
    }

    private fun setQuestion() {
        val question = mQuestionList!![mCurrentPosition - 1]

        defaultOptionView()

        if (mCurrentPosition == mQuestionList!!.size) {
            mBinding.btnSubmit.text = "Finish"
        } else {
            mBinding.btnSubmit.text = "Submit"
        }

        tvQuestion.text = question.question
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        mBinding.btnSubmit.setOnClickListener(this)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(requireContext(),R.drawable.btn_circle)
        }
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    tv_option_one.isClickable = true
                    tv_option_two.isClickable = true
                    tv_option_three.isClickable = true
                    tv_option_four.isClickable = true

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswer++
                        score += 150
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        mBinding.btnSubmit.text = "Finish"
                    } else {
                        mBinding.btnSubmit.text = "Go to next Question"
                    }
                    mBinding.score.text = score.toString()
                    tv_option_one.isClickable = false
                    tv_option_two.isClickable = false
                    tv_option_three.isClickable = false
                    tv_option_four.isClickable = false
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tv_option_one.background =
                    ContextCompat.getDrawable(requireActivity(), drawableView)
            }
            2 -> {
                tv_option_two.background =
                    ContextCompat.getDrawable(requireActivity(), drawableView)
            }
            3 -> {
                tv_option_three.background =
                    ContextCompat.getDrawable(requireActivity(), drawableView)
            }
            4 -> {
                tv_option_four.background =
                    ContextCompat.getDrawable(requireActivity(), drawableView)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(requireContext(), R.drawable.btn_circle)
    }

}