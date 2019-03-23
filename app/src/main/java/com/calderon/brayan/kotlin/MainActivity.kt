package com.calderon.brayan.kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var personas:ArrayList<Persona>? = null
    var lista:RecyclerView? = null
    var layouManager: RecyclerView.LayoutManager? = null
    var adaptador: AdaptadorCustome? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personas = ArrayList()
        personas?.add(Persona(nombre = "Localizar", nacionalidad = "",              foto = R.drawable.ic_localizar_24dp))
        personas?.add(Persona(nombre = "Fabian",    nacionalidad = "Peruana",       foto = R.drawable.imagen2))
        personas?.add(Persona(nombre = "Calderon",  nacionalidad = "Gringa",        foto = R.drawable.imagen3))
        personas?.add(Persona(nombre = "Bastilla",  nacionalidad = "Mexicano",      foto = R.drawable.imagen4))
        personas?.add(Persona(nombre = "Brayan",    nacionalidad = "Colombiana",    foto = R.drawable.imagen1))
        personas?.add(Persona(nombre = "Fabian",    nacionalidad = "Peruana",       foto = R.drawable.imagen2))
        personas?.add(Persona(nombre = "Calderon",  nacionalidad = "Gringa",        foto = R.drawable.imagen3))
        personas?.add(Persona(nombre = "Bastilla",  nacionalidad = "Mexicano",      foto = R.drawable.imagen4))
        personas?.add(Persona(nombre = "Brayan",    nacionalidad = "Colombiana",    foto = R.drawable.imagen1))
        personas?.add(Persona(nombre = "Fabian",    nacionalidad = "Peruana",       foto = R.drawable.imagen2))
        personas?.add(Persona(nombre = "Calderon",  nacionalidad = "Gringa",        foto = R.drawable.imagen3))
        personas?.add(Persona(nombre = "Bastilla",  nacionalidad = "Mexicano",      foto = R.drawable.imagen4))

        lista = findViewById(R.id.recicle)
        layouManager = LinearLayoutManager(this)
        adaptador = AdaptadorCustome(personas!!, object : click{
            override fun onClick(vista: View, posicion: Int) {
                Toast.makeText(applicationContext, personas?.get(posicion)?.nombre, Toast.LENGTH_SHORT).show()
                if(posicion%2==0) {
                    startActivity(Intent(this@MainActivity, Canvas::class.java))
                }else if(posicion%3==0){
                    startActivity(Intent(this@MainActivity, MapsActivity::class.java))
                }

            }
        })
        lista?.layoutManager = layouManager
        lista?.adapter = adaptador
    }

    fun saludo(hg: Int): Int{

        return 5
    }
}