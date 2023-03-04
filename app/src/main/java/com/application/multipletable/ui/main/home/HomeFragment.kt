package com.application.multipletable.ui.main.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.application.multipletable.data.local.entity.Users
import com.application.multipletable.databinding.FragmentHomeBinding
import com.application.multipletable.databinding.MenuBinding
import com.application.multipletable.ui.adapter.CustomAdapter
import com.application.multipletable.ui.adapter.OnItemClickListener
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var menuBinding: MenuBinding
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var adapter: CustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        menuBinding = MenuBinding.bind(binding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CustomAdapter(object : OnItemClickListener{

            override fun onClick(id: Int) {
                viewModel.onItemClick(id, findNavController())
            }

            override fun onLongClick(id: Int) {
                viewModel.deleteUser(id)
            }
        })

        menuBinding.recyclerview.adapter = adapter

        menuBinding.saveBtn.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val email = binding.etEmail.text.toString()

            viewModel.addUser(Users(username,email))
        }

        viewModel.loadAllUser.observe(viewLifecycleOwner, Observer {
            it.let {
              adapter.submitList(it)
            }
        })

//        viewModel.user.observe(viewLifecycleOwner, Observer {
//            menuBinding.recyclerview.adapter = CustomAdapter(object : OnItemClickListener{
//                override fun onClick(id: Int) {
//                    viewModel.onItemClick(it.get(id), findNavController())
//                    Log.d("TES DEBUG", "onClick: ${id}")
//                }
//            })
//        })

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}