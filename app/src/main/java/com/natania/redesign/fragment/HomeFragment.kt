package com.natania.redesign.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.natania.redesign.R
import com.natania.redesign.adapter.AdapterCategory
import com.natania.redesign.adapter.AdapterTerlaris
import com.natania.redesign.adapter.AdapterVirus
import com.natania.redesign.model.ModelCategory
import com.natania.redesign.model.ModelTerlaris
import com.natania.redesign.model.ModelVirus
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private val virus = ArrayList<ModelVirus>()
    private val Laris = ArrayList<ModelTerlaris>()
    private val category = ArrayList<ModelCategory>()

    companion object {
        fun defultFragment(): HomeFragment {
            val homefragment = HomeFragment()
            var bundle = Bundle()
            homefragment.arguments = bundle
            return homefragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    val imageContentSlider = intArrayOf(
        R.drawable.bts1,
        R.drawable.bts2,
        R.drawable.bts3

    )
    val imageContentListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            imageView.setImageResource(imageContentSlider[position])


        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val carouselView = is_main as CarouselView
        carouselView.setImageListener(imageContentListener)
        carouselView.setPageCount(imageContentSlider.count())
        rv_virus.setHasFixedSize(true)
        virus.addAll(getDataVirus())
        showRecyclerVirus()

        Laris.addAll(getDataLaris())
        showRecyclerTerlaris()

        category.addAll(getDataCategory())
        showRecyclerCategory()
    }

    private fun showRecyclerCategory() {
        rv_category.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val listCategory = AdapterCategory(category)
        rv_category.adapter = listCategory
    }

    private fun getDataCategory(): Collection<ModelCategory> {
        val dataTitle = resources.getStringArray(R.array.category)
        val dataPhoto = resources.obtainTypedArray(R.array.img_category)

        val category = ArrayList<ModelCategory>()

        for (position in dataTitle.indices) {
            val listPhoto3 = ModelCategory(
                dataTitle[position],
                dataPhoto.getResourceId(position, -1)

            )
            category.add(listPhoto3)
        }
        return category
    }



    private fun showRecyclerTerlaris() {
        rv_terlaris.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val listTerlaris = AdapterTerlaris(Laris)
        rv_terlaris.adapter = listTerlaris
    }

    private fun getDataLaris(): Collection<ModelTerlaris> {
        val dataTitle = resources.getStringArray(R.array.terlaris)
        val dataPrice = resources.getStringArray(R.array.price_terlaris)
        val dataPhoto = resources.obtainTypedArray(R.array.img_terlaris)

        val laris = ArrayList<ModelTerlaris>()

        for (position in dataTitle.indices) {
            val listPhoto2 = ModelTerlaris(
                dataTitle[position],
                dataPrice[position],
                dataPhoto.getResourceId(position, -1)

            )
            Laris.add(listPhoto2)
        }
        return laris
    }

    private fun showRecyclerVirus() {
        rv_virus.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val listVirus = AdapterVirus(virus)
        rv_virus.adapter = listVirus
    }

    private fun getDataVirus(): Collection<ModelVirus> {
        val dataTitle = resources.getStringArray(R.array.virus)
        val dataPrice = resources.getStringArray(R.array.price_virus)
        val dataPhoto = resources.obtainTypedArray(R.array.img_virus)

        val virus = ArrayList<ModelVirus>()

        for (position in dataTitle.indices) {
            val listPhoto1 = ModelVirus(
                dataTitle[position],
                dataPrice[position],
                dataPhoto.getResourceId(position, -1)

            )
            virus.add(listPhoto1)
        }
        return virus
    }
}
