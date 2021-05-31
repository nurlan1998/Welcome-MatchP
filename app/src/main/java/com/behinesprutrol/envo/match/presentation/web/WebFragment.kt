package com.behinesprutrol.envo.match.presentation.web

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.behinesprutrol.envo.match.R
import com.behinesprutrol.envo.match.databinding.FragmentMenuBinding
import com.behinesprutrol.envo.match.databinding.FragmentWebBinding
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class WebFragment : Fragment() {

    private var _binding: FragmentWebBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var webView: WebView

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
        getBodyText()
        webView = mBinding.webView
    }
    private fun getBodyText() {
        mBinding.progressBar.visibility = View.VISIBLE
        Thread(Runnable {
            val builder = StringBuilder()
            try {
                val url = "https://rutafagre.ru/event" //your website url
                val doc: Document = Jsoup.connect(url).get()
                val body: Element = doc.body()
                builder.append(body.text())
            } catch (e: Exception) {
                mBinding.progressBar.visibility = View.INVISIBLE
                builder.append("Error : ").append(e.message).append("\n")
            }
            activity?.runOnUiThread {
                if(builder.toString().isEmpty()){
                    findNavController().navigate(R.id.action_webFragment_to_menuFragment)
                }else{
                    webView.webViewClient = WebViewClient()
                    webView.settings.domStorageEnabled = true
                    webView.settings.javaScriptEnabled = true
                    webView.settings.builtInZoomControls = true
                    webView.loadUrl(builder.toString())
                    mBinding.progressBar.visibility = View.INVISIBLE
                    webView.canGoBack()
                    webView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
                        if(keyCode == KeyEvent.KEYCODE_BACK
                            && event.action == MotionEvent.ACTION_UP
                            && webView.canGoBack()) {
                            webView.goBack()
                            return@OnKeyListener true
                        }
                        false
                    })
                }
                Log.i("Result",builder.toString())}
        }).start()
    }
}