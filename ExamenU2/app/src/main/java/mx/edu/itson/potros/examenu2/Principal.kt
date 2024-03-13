package mx.edu.itson.potros.examenu2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val button : Button = findViewById(R.id.btn_detalles)

        button.setOnClickListener(){
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("Tipo", "Detalles")
            intent.putExtra("Eleccion", 1)
            startActivity(intent)
        }

        val button1 : Button = findViewById(R.id.btn_globos)

        button1.setOnClickListener(){
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("Tipo", "Globos")
            intent.putExtra("Eleccion", 2)
            startActivity(intent)
        }

        val button2 : Button = findViewById(R.id.btn_peluches)

        button2.setOnClickListener(){
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("Tipo", "Peluches")
            intent.putExtra("Eleccion", 3)
            startActivity(intent)
        }

        val button3 : Button = findViewById(R.id.btn_regalos)

        button3.setOnClickListener(){
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("Tipo", "Regalos")
            intent.putExtra("Eleccion", 4)
            startActivity(intent)
        }

        val button4 : Button = findViewById(R.id.btn_tazas)

        button4.setOnClickListener(){
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("Tipo", "Tazas")
            intent.putExtra("Eleccion", 5)
            startActivity(intent)
        }
    }
}