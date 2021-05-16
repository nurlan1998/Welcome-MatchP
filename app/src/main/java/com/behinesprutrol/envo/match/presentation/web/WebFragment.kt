package com.behinesprutrol.envo.match.presentation.web

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.behinesprutrol.envo.match.R
import com.behinesprutrol.envo.match.databinding.FragmentMenuBinding
import com.behinesprutrol.envo.match.databinding.FragmentWebBinding
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class WebFragment : Fragment() {

    private var _binding: FragmentWebBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWebBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
//    private fun getBodyText() {
//        Thread(Runnable {
//            val builder = StringBuilder()
//            try {
//                val url = "https://belfastbar.ru/pab" //your website url
//                val doc: Document = Jsoup.connect(url).get()
//                val body: Element = doc.body()
//                builder.append(body.text())
//            } catch (e: Exception) {
//                builder.append("Error : ").append(e.message).append("\n")
//            }
//            runOnUiThread {
//                Log.i("Result",builder.toString())}
//        }).start()
//    }
}