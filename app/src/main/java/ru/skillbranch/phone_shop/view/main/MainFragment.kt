package ru.skillbranch.phone_shop.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import coil.load
import ru.skillbranch.phone_shop.databinding.FragmentMainBinding
import ru.skillbranch.phone_shop.pageradapter.VPAdapter
import ru.skillbranch.phone_shop.pageradapter.ViewPagerItem
import ru.skillbranch.phone_shop.view.ViewModel.MainViewModelFactory
import ru.skillbranch.phone_shop.viewmodel.MainViewModel
import ru.skillbranch.phone_shop.viewmodel.Status


class MainFragment() : Fragment() {

    lateinit var binding: FragmentMainBinding

    var HSlist = ArrayList<ViewPagerItem>()
    val viewModel by lazy { ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainBinding.inflate(layoutInflater)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClick()

        setData()


        }

   fun  setClick(){
       binding.FL1.setOnClickListener {
           viewModel.eventNavigationToDeteil(viewModel.getDataBestSeller()?.get(0)!!
               .picture,viewModel.getDataBestSeller()?.get(0)!!.title
               ,viewModel.getDataBestSeller()?.get(0)!!.discount_price.toString())
       }

       binding.FL2.setOnClickListener {
           viewModel.eventNavigationToDeteil(viewModel.getDataBestSeller()?.get(1)!!
               .picture,viewModel.getDataBestSeller()?.get(1)!!.title
               ,viewModel.getDataBestSeller()?.get(1)!!.discount_price.toString())

       }

       binding.FL3.setOnClickListener {
           viewModel.eventNavigationToDeteil(viewModel.getDataBestSeller()?.get(2)!!
               .picture,viewModel.getDataBestSeller()?.get(2)!!.title
               ,viewModel.getDataBestSeller()?.get(2)!!.discount_price.toString())

       }

       binding.FL4.setOnClickListener {
           viewModel.eventNavigationToDeteil(viewModel.getDataBestSeller()?.get(3)!!
               .picture,viewModel.getDataBestSeller()?.get(3)!!.title
               ,viewModel.getDataBestSeller()?.get(3)!!.discount_price.toString())

       }

       binding.TVseeMore.setOnClickListener {
           viewModel.countindexHotSilers()
       }

      /** binding.imgHT.setOnClickListener {
           viewModel.eventNavigationToDeteil(viewModel.getDataHome_store()!![viewModel.indexHotSilers
               .value?:0].picture, viewModel.getDataHome_store()!![viewModel.indexHotSilers.value?:0]
               .title,viewModel.getDataBestSeller()?.get(viewModel.indexHotSilers.value?:0)!!
               .discount_price.toString())
       }**/

                        //set viewModel value
       viewModel.eventNavigation.observe(viewLifecycleOwner) {
           val discription = MainFragmentDirections
               .actionMainFragmentToDetailsFragment(it.getValue()!!.title,it.getValue()!!.imgUrl
                   ,it.getValue()!!.price)
           findNavController().navigate(discription)
       }

   /**    viewModel.indexHotSilers.observe(viewLifecycleOwner){
           if (it == 0) {
               binding.imgHT.load(viewModel.getDataHome_store()?.get(it)?.picture)
               binding.tvHTtitle.text = viewModel.getDataHome_store()?.get(it)?.title
               binding.tvHSsubtitle.text = viewModel.getDataHome_store()?.get(it)?.subtitle
           } else if (it == 1) {
               binding.imgHT.load(viewModel.getDataHome_store()?.get(it)?.picture)
               binding.tvHTtitle.isVisible = false
               binding.tvHTtitle.text = viewModel.getDataHome_store()?.get(it)?.title
               binding.tvHSsubtitle.text = viewModel.getDataHome_store()?.get(it)?.subtitle

           } else if (it == 2) {
               binding.imgHT.load(viewModel.getDataHome_store()?.get(it)?.picture)
               binding.tvHTtitle.isVisible = true
               binding.tvHTtitle.text = viewModel.getDataHome_store()?.get(it)?.title
               binding.tvHSsubtitle.text =
                   viewModel.getDataHome_store()?.get(it)?.subtitle
           }
       }**/
    }





    private fun setData() {

        viewModel.status.observe(viewLifecycleOwner){
            if(it == Status.DONE){
           binding.info.visibility = View.VISIBLE
        }else if(it == Status.ERROR){
            binding.TVEror.visibility = View.VISIBLE
            }
        }


        //title
        viewModel.data.observe(viewLifecycleOwner) {
            binding.tvBSTitle1.text = it.bestSeller.getOrNull(0)?.title
            binding.tvBSTitle2.text = it.bestSeller.getOrNull(1)?.title
            binding.tvBSTitle3.text = it.bestSeller.getOrNull(2)?.title
            binding.tvBSTitle4.text = it.bestSeller.getOrNull(3)?.title

            //image best seilers
            binding.imgBSImage1.load(it.bestSeller.getOrNull(0)?.picture)
            binding.imgBSImage2.load(it.bestSeller.getOrNull(1)?.picture)
            binding.imgBSImage3.load(it.bestSeller.getOrNull(2)?.picture)
            binding.imgBSImage4.load(it.bestSeller.getOrNull(3)?.picture)

            //price without discount "
            binding.tvBSPriceWithoutDiscount1.text =
                it.bestSeller.getOrNull(0)?.discount_price.toString()
            binding.tvBSPriceWithoutDiscount2.text =
                it.bestSeller.getOrNull(1)?.discount_price.toString()
            binding.tvBSPriceWithoutDiscount3.text =
                it.bestSeller.getOrNull(2)?.discount_price.toString()
            binding.tvBSPriceWithoutDiscount4.text =
                it.bestSeller.getOrNull(3)?.discount_price.toString()

            //discount price
            binding.tvBSDiscountPrice1.text =
                it.bestSeller.getOrNull(0)?.discount_price.toString()
            binding.tvBSDiscountPrice2.text =
                it.bestSeller.getOrNull(1)?.discount_price.toString()
            binding.tvBSDiscountPrice3.text =
                it.bestSeller.getOrNull(2)?.discount_price.toString()
            binding.tvBSDiscountPrice4.text =
                it.bestSeller.getOrNull(3)?.discount_price.toString()

            //image hot silers
         //   binding.imgHT.load(it.home_store.get(2)?.picture)
         //   binding.tvHTtitle.text = it.home_store.get(2)?.title
         //   binding.tvHSsubtitle.text = it.home_store.get(2)?.subtitle
            for(i in 0..it.home_store.size - 1){
              HSlist.add(
                  ViewPagerItem(it.home_store[i].picture,
                                it.home_store[i].title,
                                it.home_store[i].subtitle)
              )
            }
            binding.viewPager2.adapter = VPAdapter(HSlist)
            binding.viewPager2.setClipToPadding(false)
            binding.viewPager2.setClipChildren(false)
            binding.viewPager2.setOffscreenPageLimit(2)
            binding.viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER)
        }
    }}