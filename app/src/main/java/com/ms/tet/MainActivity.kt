package com.ms.tet

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.ms.tet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        var params = intent.extras
        var continuar = params?.getBoolean("pause")

        if(continuar == true){
            binding.buttonRec.visibility = View.VISIBLE;
        }else{
            binding.buttonRec.visibility = View.INVISIBLE;
        }

        binding.records.setOnClickListener {
            val intent = Intent(this, RecordsActivity::class.java);
            startActivity(intent)
        }

        binding.buttonNovoJogo.setOnClickListener {
            val intent = Intent(this, Table::class.java);
            startActivityForResult(intent, 1);
        }

        binding.buttonRec.setOnClickListener {
            val intent = Intent();
            setResult(Activity.RESULT_OK, intent);
            finish();
        }

        binding.buttonConfigurar.setOnClickListener {
            val intent = Intent(this, Config::class.java);
            startActivityForResult(intent, 3);
        }
    }

}