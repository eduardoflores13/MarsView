package com.example.marsview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marsview.repo.CameraRepo
import com.example.marsview.repo.RoverRepo
import com.example.marsview.service.RoverService
import kotlinx.android.synthetic.main.activity_informacionrover.*
import retrofit2.http.GET

class informacionrover : AppCompatActivity() {
    lateinit var rcvCamaralist : RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacionrover)

        //Asignar la información a las textviews

        txvnombrerover.text = intent.getStringExtra("NOMBREROVER")!!
        txvfechalanzamientodato.text = intent.getStringExtra("LAUNCHDATE")
        txvfechaaterrizajedato.text = intent.getStringExtra("LANDINGDATE")
        txvestado.text = intent.getStringExtra("STATUS")
        txvfechaultimafoto.text = intent.getStringExtra("MAXDATE")
        txvtotalfotos.text = intent.getStringExtra("TOTALFOTOS")

        val rovername: String = intent.getStringExtra("NOMBREROVER").toString()


        val cameraservice = RoverService.instance
        val camerarepo = CameraRepo(cameraservice, rovername.toLowerCase())
        val cameralistadapter = CamaraListRecyclerViewAdapter()

        val TAG = javaClass.simpleName

        camerarepo.listarCamaras() {
            if(it!=null){
                Log.i(TAG, "Resultado = $it")
                cameralistadapter.listacamaras = it
                cameralistadapter.notifyDataSetChanged()
            }else{
                Log.i(TAG, "Resultado nulo")
            }
        }


        rcvCamaralist = rcvcamaras
        rcvCamaralist.layoutManager = LinearLayoutManager(this)
        rcvCamaralist.adapter = cameralistadapter

        //Button2 es el boton para ver galeria, se olvido cambiar el nombre
        //Para evitar problemas en refactorizacion se dejo así con este comentario para identificarlo
        button2.setOnClickListener{
            val galeria = Intent(this, galeria::class.java)
            galeria.putExtra("NOMBREROVER", rovername.toLowerCase())
            startActivity(galeria)
        }
    }



    fun irAtras(view: View) {
        onBackPressed()
    }

}