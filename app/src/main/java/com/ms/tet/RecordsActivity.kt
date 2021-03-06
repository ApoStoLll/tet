package com.ms.tet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ms.tet.adapters.RecsAdapter
import kotlinx.android.synthetic.main.activity_records.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecordsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_records)
        GlobalScope.launch(Dispatchers.IO) {
            val data = (application as App).db.dao().getAll()
            withContext(Dispatchers.Main){
                val adapter = RecsAdapter(data)
                recycler.adapter = adapter
                recycler.layoutManager = LinearLayoutManager(this@RecordsActivity)
            }
        }
    }
}