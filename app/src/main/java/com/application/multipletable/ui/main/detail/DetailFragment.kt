package com.application.multipletable.ui.main.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.application.multipletable.R
import com.application.multipletable.data.local.entity.Address
import com.application.multipletable.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    
    private val args: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveBtn.setOnClickListener {
            val city = binding.etCity.text.toString()
            val street = binding.etStreet.text.toString()

            val address = Address(args.userID, city, street)
            viewModel.insert(address)
            //showAddressById(5)
        }

        binding.showBtn.setOnClickListener {

        }

    }

    private fun showAddressById(id: Int){
        viewModel.loadAddressById(id).observe(viewLifecycleOwner, Observer {
                binding.tvCity.text = it.city
                binding.tvStreet.text = it.street
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}