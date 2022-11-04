package com.example.assignment_5_lesson_6_problem2

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_5_lesson_6_problem2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rc = findViewById<RecyclerView>(R.id.recyclerView)

        findViewById<ImageButton>(R.id.eletronic).setOnClickListener {
            Toast.makeText(this, "You have chosen the Electronic category of shopping", Toast.LENGTH_LONG).show()
            findViewById<LinearLayout>(R.id.selectionView).visibility = View.GONE
            rc.visibility = View.VISIBLE
        }


        rc.visibility = View.GONE

        var items = ArrayList<Product>()
        items.add(Product("Apple iPhone 11 Pro, 64GB",459.0, "Space Gray",R.drawable.phone,"id1","This phone is unlocked and compatible with any carrier of choice on GSM and CDMA networks (e.g. AT&T, T-Mobile, Sprint, Verizon, US Cellular, Cricket, Metro, Tracfone, Mint Mobile, etc.)."))
        items.add(Product("Fire HD 10 tablet, 1080p Full HD, 32 GB", 74.0, "Black", R.drawable.tablet, "id2", "Fast and responsive - powerful octa-core processor and 3 GB RAM. 50% more RAM than previous generation.\n" +
                "Long-lasting 12-hour battery and 32 or 64 GB internal storage. Add up to 1 TB with microSD (sold separately)."))
        items.add(Product("Insignia 50-inch Class F30 Series LED 4K UHD Smart Fire TV", 249.0,"Black", R.drawable.tv, "id3", "4K Ultra HD (2160p resolution) - Enjoy breathtaking 4K movies and TV shows at 4 times the resolution of Full HD, and upscale your current content to Ultra HD-level picture quality."))
        items.add(Product("HP DeskJet 2755e Wireless Color All-in-One Printer with Bonus 6 Months Instant Ink with HP+", 84.0, "White",R.drawable.printer, "id4", "Print up to 700 pages a month. Ink ships to you automatically so you never run out. After 6 months, monthly fee applies unless cancelled, and you'll save up to 50% on ink."))
        items.add(Product("HP DeskJet 2755e Wireless Color All-in-One Printer with Bonus 6 Months Instant Ink with HP+", 84.0, "White",R.drawable.printer, "id4", "Print up to 700 pages a month. Ink ships to you automatically so you never run out. After 6 months, monthly fee applies unless cancelled, and you'll save up to 50% on ink."))


        rc.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter( baseContext, items)
        rc.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}