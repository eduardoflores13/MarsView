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

        //Guardar los valores en variable para poder traducir las fechas
        var fechaLanzamiento:String? = intent.getStringExtra("LAUNCHDATE")
        var fechaAterrizaje:String? = intent.getStringExtra("LANDINGDATE")
        var estado:String? = intent.getStringExtra("STATUS")
        var ultimaFecha:String? = intent.getStringExtra("MAXDATE")

        //Asignar la información a las textviews
        txvnombrerover.text = intent.getStringExtra("NOMBREROVER")!!
        txvfechalanzamientodato.text = fechaEspaniol(fechaLanzamiento)
        txvfechaaterrizajedato.text = fechaEspaniol(fechaAterrizaje)
        txvestado.text = traducirEstado(estado)
        txvfechaultimafoto.text = fechaEspaniol(ultimaFecha)
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

        btnatras2.setOnClickListener {
            onBackPressed()
        }

    }

    fun fechaEspaniol(fechaingles : String?): String {
        val listaFecha = fechaingles?.split("-")
        var fechaEspaniol = listaFecha?.get(2) + "/" + listaFecha?.get(1) + "/" + listaFecha?.get(0)
        return fechaEspaniol
    }

    fun traducirEstado(estadoingles : String?): String {
        if (estadoingles == "active"){
            return "Activo"
        }else{
            return "Completado"
        }
    }

}