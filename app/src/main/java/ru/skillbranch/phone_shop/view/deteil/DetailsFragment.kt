package ru.skillbranch.phone_shop.view.deteil

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import ru.skillbranch.phone_shop.R
import ru.skillbranch.phone_shop.databinding.FragmentDetailsBinding
import ru.skillbranch.phone_shop.deteilviewmodel.DeteilViewModel
import ru.skillbranch.phone_shop.view.main.MainFragmentDirections
import ru.skillbranch.phone_shop.view.mainactivity.MainActivity


class DetailsFragment : Fragment() {
lateinit var binding: FragmentDetailsBinding
    private val aargs: DetailsFragmentArgs by navArgs()
   private val viewModel by lazy { ViewModelProvider(
       this
   ).get(DeteilViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = FragmentDetailsBinding.inflate(layoutInflater)
        setClick()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setData()
        viewModel.event.observe(viewLifecycleOwner){
            (requireActivity() as MainActivity).navController
                .navigate(R.id.action_detailsFragment_to_mainFragment)
        }
        viewModel.eventShowMasseg.observe(viewLifecycleOwner){
            binding.CVdone.visibility = View.VISIBLE
            binding.button.visibility = View.INVISIBLE
            binding.cardView.visibility = View.INVISIBLE
            binding.TVpricea.visibility = View.VISIBLE
            binding.cardView2.visibility = View.INVISIBLE
            binding.TVtitle.visibility = View.INVISIBLE

            Handler(Looper.getMainLooper()).postDelayed({
                (requireActivity() as MainActivity).navController
                    .navigate(R.id.action_detailsFragment_to_mainFragment)
            },3000)
        }
        return binding.root


    }

    private fun setData(){
        viewModel.setDataArgs(aargs.title, aargs.urlImage,aargs.price)

        viewModel.args.observe(viewLifecycleOwner){
            binding.img.load(it.getValue()!!.imgUrl)
            binding.TVtitle.text = it.getValue()!!.title
            binding.TVpricee.text = it.getValue()!!.price
            binding.TVpricea.text =  "price ${it.getValue()!!.price}$"

        }


    }

    private fun setClick(){
        binding.button.setOnClickListener {
            viewModel.eventBack()
        }

        binding.cardView2.setOnClickListener {
            viewModel.eventShowMassege()
        }

        }
    }
