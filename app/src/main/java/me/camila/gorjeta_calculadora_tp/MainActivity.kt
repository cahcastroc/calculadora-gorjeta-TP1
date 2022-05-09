package me.camila.gorjeta_calculadora_tp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),  SeekBar.OnSeekBarChangeListener {


        var pontoFinalSeekBar = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //----------------------Inputs
        val txtTotalConta = this.findViewById<EditText>(R.id.txtTotalConta)

        val lblTotalFinal = this.findViewById<TextView>(R.id.lblTotalFinal)

         val lblTotalPorPessoa = this.findViewById<TextView>(R.id.lblTotalPorPessoa)

        val btEnviar = this.findViewById<Button>(R.id.btEnviar)

        val txtPessoas = this.findViewById<EditText>(R.id.txtPessoas)
        val lblValorGorjeta = this.findViewById<TextView>(R.id.lblValorGorjeta)



        btEnviar.setOnClickListener {

            if(txtTotalConta.text.isNotBlank() && txtPessoas.text.isNotBlank()) {

                val totalConta = txtTotalConta.text.toString().toDouble()
                val pessoas = txtPessoas.text.toString().toInt()

                val gorjeta = (pontoFinalSeekBar * totalConta)/100

                    lblValorGorjeta. text = gorjeta.toString()

                val totalFinal = (totalConta + gorjeta)

                lblTotalFinal.text =  totalFinal.toString()

                lblTotalPorPessoa.text = ((totalConta + gorjeta)/pessoas).toString()

            } else {

                txtTotalConta.error = getString(R.string.insira_o_valor)
                txtPessoas.error = getString(R.string.insira_quantas_pessoas)

            }
        }


        val skGorjeta = this.findViewById<SeekBar>(R.id.skGorjeta)
         skGorjeta?.setOnSeekBarChangeListener(this)

        //------------------------
    }

    override fun onProgressChanged(seekBar: SeekBar?, progresso: Int, usuario: Boolean) {
        val lblPorcentagem = findViewById<TextView>(R.id.lblPorcentagem)
        lblPorcentagem.text = "$progresso %"
        pontoFinalSeekBar = progresso

    }



    override fun onStartTrackingTouch(seekbar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekbar: SeekBar?) {

    }

}



