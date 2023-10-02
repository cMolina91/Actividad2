package com.example.actividad2final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //Lista que almacena objetos de tipo modelProducto
    val data = ArrayList<ModelProducto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initSpinner()
    }

    fun agregarCategoriaAbarrote(){
        data.add(ModelProducto(R.drawable.arroz,"Arros", "Tucapel"))
        data.add(ModelProducto(R.drawable.crema, "Crema", "Nestle"))
        data.add(ModelProducto(R.drawable.salsa, "Salsa", "Carozzi"))
    }

    fun agregarCategoriaCarne(){
        data.add(ModelProducto(R.drawable.huachalomo, "Huachalomo", "Buen Corte"))
        data.add(ModelProducto(R.drawable.lomo_liso,"Lomo Liso", "Corte Criollo"))
        data.add(ModelProducto(R.drawable.punta_picana, "Punta Picana", "Gorina"))
    }

    fun agregarCategoriaVerdura(){
        data.add(ModelProducto(R.drawable.lechuga, "Lechuga", "Campo Lindo"))
        data.add(ModelProducto(R.drawable.repollo, "Repollo", "Semillas"))
        data.add(ModelProducto(R.drawable.tomate, "Tomate", "Tierra Buena"))
    }

    fun initRecyclerView(){
        //CardView de producto
        val producto = findViewById<RecyclerView>(R.id.recyclerView_principal)

        producto.layoutManager = LinearLayoutManager(this)
        val adapter = AdapterProducto(data)
        producto.adapter = adapter
    }

    private fun initSpinner(){
        val spinner = resources.getStringArray(R.array.Categoria)
        val spinnerVariedad = findViewById<Spinner>(R.id.spinnerVariedad)


        if(spinnerVariedad != null){
            val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinner)
            spinnerVariedad.adapter = adapter

            spinnerVariedad.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long){
                    when(spinnerVariedad.selectedItem.toString()){
                        "Abarrotes" -> {
                            Toast.makeText(this@MainActivity, "Abarrotes Seleccionados",Toast.LENGTH_SHORT).show()
                            data.clear()
                            agregarCategoriaAbarrote()
                            initRecyclerView()
                        }

                        "Carnes" ->{
                            Toast.makeText(this@MainActivity, "Carnes Seleccionadas", Toast.LENGTH_SHORT).show()
                            data.clear()
                            agregarCategoriaCarne()
                            initRecyclerView()
                        }

                        "Verduras" ->{
                            Toast.makeText(this@MainActivity, "Verduras Seleccionadas", Toast.LENGTH_SHORT).show()
                            data.clear()
                            agregarCategoriaVerdura()
                            initRecyclerView()
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        }
    }
}