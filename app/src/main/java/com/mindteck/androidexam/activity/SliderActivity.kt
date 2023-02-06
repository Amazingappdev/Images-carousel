package com.mindteck.androidexam.activity

import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.mindteck.androidexam.R
import com.mindteck.androidexam.adapter.ItemListAdapter
import com.mindteck.androidexam.adapter.ViewPagerAdapter
import com.mindteck.androidexam.model.ItemListModel

class SliderActivity : AppCompatActivity() {
    // on below line we are creating variable for view pager,
    // viewpager adapter and the image list.
    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var imageList: List<Int>

    // creating variables for recyclerView
    lateinit var labelListview: RecyclerView


    lateinit var itemListAdapter: ItemListAdapter
    lateinit var itemList: ArrayList<ItemListModel>

    // creating variable for searchView
    lateinit var searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.slideractivity)
        // finding id
        viewPager = findViewById(R.id.idViewPager)
        labelListview = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.idSV)

        // our image list and adding data to it.
        // here also we can set image from server to list change variable according to requirement
        imageList = ArrayList<Int>()
        imageList = imageList + R.drawable.imgindflag
        imageList = imageList + R.drawable.imgindflag
        imageList = imageList + R.drawable.imgindflag
        imageList = imageList + R.drawable.imgindflag
        imageList = imageList + R.drawable.imgindflag
        // use Picasso to set image



        // on below line we are initializing our view
        // pager adapter and adding image list to it.
        viewPagerAdapter = ViewPagerAdapter(this@SliderActivity, imageList)

        // on below line we are setting
        // adapter to our view pager.
        viewPager.adapter = viewPagerAdapter



        itemList = ArrayList()
        labelListview.layoutManager = LinearLayoutManager(this)
        itemListAdapter = ItemListAdapter(itemList)
        labelListview.adapter = itemListAdapter
        // on below line we are adding data to our list
        // note  to add data from server  call the method dataFromServer()
        itemList.add(ItemListModel("Label1", R.drawable.imgindflag))
        itemList.add(ItemListModel("Label2", R.drawable.imgindflag))
        itemList.add(ItemListModel("Label3", R.drawable.imgindflag))
        itemList.add(ItemListModel("Label4", R.drawable.imgindflag))
        itemList.add(ItemListModel("Label5", R.drawable.imgindflag))
        // on below line we are initializing our adapter


        itemListAdapter.notifyDataSetChanged()


        // on below line we are adding on query
        // listener for our search view.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // on below line we are checking
                // if query exist or not.
               // filter(query)
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                // if query text is change in that case we
                // are filtering our adapter with
                // new text on below line.
                filter(newText)
                return false
            }
        })
    }

    fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist: ArrayList<ItemListModel> = ArrayList()

        // running a for loop to compare elements.
        for (item in itemList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.itemName.toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            itemListAdapter.filterList(filteredlist)
        }
    }


    // data from serve

    fun dataFromServer()
    {
        // data from your Json parse string
        var itemName :String=""
        var itemImagePath :String

        // here change the variable itemImage int to String and save your path of image and pass here
        itemList.add(ItemListModel(itemName,3))

    }

}
