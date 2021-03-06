package com.ms.tet

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ms.tet.data.entities.RecEntity
import com.ms.tet.databinding.ActivityGamaOverBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class GameOver : AppCompatActivity() {

    lateinit var binding: ActivityGamaOverBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gama_over);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_gama_over);

        var config = getSharedPreferences("${R.string.app_name}_configuracoes", Context.MODE_PRIVATE)

        var pontuacao = intent.extras?.getInt("pontuacao");
        var record = config.getInt("record", 0);

        if (pontuacao != null) {
            if(pontuacao > record){
                config.edit().putInt("record", pontuacao).apply();
            }
        }

        record = config.getInt("record", 0);
        val a = (application as App).db
        GlobalScope.launch {
            val t: String =
                SimpleDateFormat("MMdd_HHmmss").format(Calendar.getInstance().getTime())
            a.dao().insertRec(RecEntity(scoreS = record.toString(), times = t))
        }
        binding.textViewPontuacaoValue.text = pontuacao.toString();
        binding.textViewRecordValue.text = record.toString();

        binding.buttonNovoJogo.setOnClickListener {
            val intent = Intent(this, Table::class.java);
            startActivityForResult(intent, 1);
            finish();
        }


        binding.buttonSair.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java);
            startActivityForResult(intent, 2);
            finish();
        }
    }
}