package mx.edu.itson.potros.examenu2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Regalos : AppCompatActivity() {
    var adapter: DetallesAdapter? = null
    var globosAdapter: DetallesAdapter? = null
    var peluchesAdapter: DetallesAdapter? = null
    var regalosAdapter: DetallesAdapter? = null
    var tazasAdapter: DetallesAdapter? = null
    var detalles= ArrayList<Detalles>()
    var globos= ArrayList<Detalles>()
    var peluches= ArrayList<Detalles>()
    var regalos= ArrayList<Detalles>()
    var tazas= ArrayList<Detalles>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        cargarDetalles()

        val title: TextView = findViewById(R.id.titulo)
        var eleccion=0

        val bundle = intent.extras
        if (bundle != null) {
            title.setText(bundle.getString("tipo"))
            eleccion=bundle.getInt("Eleccion")
        }
        adapter=DetallesAdapter(this, detalles)
        globosAdapter=DetallesAdapter(this, globos)
        peluchesAdapter=DetallesAdapter(this, peluches)
        regalosAdapter=DetallesAdapter(this, regalos)
        tazasAdapter=DetallesAdapter(this, tazas)

        if(eleccion==1){
            var gridDetalles: GridView = findViewById(R.id.movies_catalogo)
            gridDetalles.adapter=adapter
        }
        if(eleccion==2){
            var gridGlobos: GridView = findViewById(R.id.movies_catalogo)
            gridGlobos.adapter=globosAdapter
        }
        if(eleccion==3){
            var gridPeluches: GridView = findViewById(R.id.movies_catalogo)
            gridPeluches.adapter=peluchesAdapter
        }
        if(eleccion==4){
            var gridRegalos: GridView = findViewById(R.id.movies_catalogo)
            gridRegalos.adapter=regalosAdapter
        }
        if(eleccion==5){
            var gridTazas: GridView = findViewById(R.id.movies_catalogo)
            gridTazas.adapter=tazasAdapter
        }

    }

    fun cargarDetalles(){
        detalles.add(Detalles(R.drawable.cumplebotanas, "$280"))
        detalles.add(Detalles(R.drawable.cumplecheve, "$320"))
        detalles.add(Detalles(R.drawable.cumpleescolar, "$330"))
        detalles.add(Detalles(R.drawable.cumplepaletas, "$190"))
        detalles.add(Detalles(R.drawable.cumplesnack, "$150"))
        detalles.add(Detalles(R.drawable.cumplevinos, "$360"))

        globos.add(Detalles(R.drawable.globoamor, "$240"))
        globos.add(Detalles(R.drawable.globocumple, "$820"))
        globos.add(Detalles(R.drawable.globofestejo, "$260"))
        globos.add(Detalles(R.drawable.globonum, "$760"))
        globos.add(Detalles(R.drawable.globoregalo, "$450"))
        globos.add(Detalles(R.drawable.globos, "$240"))

        peluches.add(Detalles(R.drawable.peluchemario, "$320"))
        peluches.add(Detalles(R.drawable.pelucheminecraft, "$320"))
        peluches.add(Detalles(R.drawable.peluchepeppa, "$290"))
        peluches.add(Detalles(R.drawable.peluches, "$400"))
        peluches.add(Detalles(R.drawable.peluchesony, "$330"))
        peluches.add(Detalles(R.drawable.peluchestich, "$280"))
        peluches.add(Detalles(R.drawable.peluchevarios, "$195"))

        regalos.add(Detalles(R.drawable.regaloazul, "$80"))
        regalos.add(Detalles(R.drawable.regalobebe, "$290"))
        regalos.add(Detalles(R.drawable.regalocajas, "$140"))
        regalos.add(Detalles(R.drawable.regalocolores, "$85"))
        regalos.add(Detalles(R.drawable.regalos, "$300"))
        regalos.add(Detalles(R.drawable.regalovarios, "$75"))

        tazas.add(Detalles(R.drawable.tazaabuela, "$120"))
        tazas.add(Detalles(R.drawable.tazalove, "$120"))
        tazas.add(Detalles(R.drawable.tazaquiero, "$260"))
        tazas.add(Detalles(R.drawable.tazas, "$280"))
    }

    class DetallesAdapter: BaseAdapter {
        var detalles=ArrayList<Detalles>()
        var context : Context? = null

        constructor(context: Context, detalles:ArrayList<Detalles>):super(){
            this.detalles=detalles
            this.context=context
        }

        override fun getCount(): Int {
            return detalles.size
        }

        override fun getItem(position: Int): Any {
            return detalles[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var detalle=detalles[position]
            var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista=inflator.inflate(R.layout.activity_detalle_regalos, null)
            var image: ImageView =vista.findViewById(R.id.iv_regalo_imagen)
            var precio: TextView =vista.findViewById(R.id.tv_regalo_precio)

            image.setImageResource(detalle.image)
            precio.setText(detalle.precio)

            image.setOnClickListener(){
                val intento = Intent(context,DetalleRegalos::class.java)
                intento.putExtra("precio", detalle.precio)
                intento.putExtra("imagen", detalle.image)
                context!!.startActivity(intento)
            }
            return vista
        }


    }
}