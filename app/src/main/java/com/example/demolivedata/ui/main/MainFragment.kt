package com.example.demolivedata.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.demolivedata.R
import com.example.demolivedata.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    val byLazy:String by lazy { "By Lazy" }

    val nonNullString:String =""

    val nullString:String?=null

    lateinit var lateInit:String

    lateinit var mainActivityBinding: MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        mainActivityBinding=DataBindingUtil.inflate(inflater,R.layout.main_fragment,container,false)
        mainActivityBinding.lifecycleOwner=viewLifecycleOwner
        mainActivityBinding.executePendingBindings()
        return mainActivityBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainActivityBinding.model=viewModel


        // handling null value
        nullString?.let {
        setText(it)
        }

        setText(nullString?:return)

        // observing data and binding
        viewModel.liveData.observe(viewLifecycleOwner, Observer {name->
        mainActivityBinding.message.text=name
        })
        // TODO: Use the ViewModel
    }

    fun setText(message:String):String? {
        mainActivityBinding.message.text=message
        return message
    }

}
