package com.uti.agriedu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uti.agriedu.databinding.FragmentHamaBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HamaFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View? {
        val binding = FragmentHamaBinding.inflate(layoutInflater)
        binding.tombolKembali.setOnClickListener {
            (requireActivity() as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.frame_layout, Home()).commit()
        }
        binding.HamaKeong.setOnClickListener {
            (requireActivity() as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.frame_layout, FragmentHamaKeong()).commit()
        }
        binding.HamaTikus.setOnClickListener {
            (requireActivity() as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.frame_layout, FragmentHamaTikus()).commit()
        }
        binding.HamaWalang.setOnClickListener {
            (requireActivity() as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.frame_layout, FragmentHamaWalang()).commit()
        }
        binding.HamaBurung.setOnClickListener {
            (requireActivity() as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.frame_layout, HamaBurungFragment()).commit()
        }
        binding.PenggerekBatang .setOnClickListener {
            (requireActivity() as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.frame_layout, PenggerekBatang()).commit()
        }
        
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HamaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}