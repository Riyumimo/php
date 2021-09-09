package com.example.crudphp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var buttonCreate : MaterialButton
    private val api by lazy { ApiRetrofit().endPoint }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        supportActionBar!!.title="Catatan Baru"
        setupView()
        setupListener()

    }

    private fun setupView(){
        editText=findViewById(R.id.edit_note)
        buttonCreate= findViewById(R.id.button_create)
    }

    private fun setupListener(){
        buttonCreate.setOnClickListener {
        if (editText.text.toString().isNotEmpty()){

            api.Crate(editText.text.toString())
                .enqueue(object : Callback<SubmitModel>{
                    override fun onResponse(
                        call: Call<SubmitModel>,
                        response: Response<SubmitModel>
                    ) {
                       if (response.isSuccessful){
                           val submit = response.body()
                           Toast.makeText(applicationContext,submit!!.message,Toast.LENGTH_SHORT).show()
                               finish()
                       }
                    }

                    override fun onFailure(call: Call<SubmitModel>, t: Throwable) {
                        Toast.makeText(applicationContext,"Error",Toast.LENGTH_SHORT).show()
                    }

                })
            /*Log.e("CreateActivity",editText.text.toString())*/
        }else{

                Toast.makeText(applicationContext, "Catatan Tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}