package erick.jass.calculadoramiltonpro20

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1 = 0.0
    private var num2 = 0.0
    private var operacion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultadoView.text = "0"
        operacion = sinOp


        unoBtn.setOnClickListener { numeroPresionado("1") }
        dosBtn.setOnClickListener { numeroPresionado("2") }
        tresBtn.setOnClickListener { numeroPresionado("3") }
        cuatroBtn.setOnClickListener { numeroPresionado("4") }
        cincoBtn.setOnClickListener { numeroPresionado("5") }
        seisBtn.setOnClickListener { numeroPresionado("6") }
        sieteBtn.setOnClickListener { numeroPresionado("7") }
        ochoBtn.setOnClickListener { numeroPresionado("8") }
        nueveBtn.setOnClickListener { numeroPresionado("9") }
        ceroBtn.setOnClickListener { numeroPresionado("0") }
        puntoBtn.setOnClickListener { numeroPresionado(".") }
        borrarBtn.setOnClickListener { borrarTodo() }
        sumaBtn.setOnClickListener { operationElegida(sum) }
        restaBtn.setOnClickListener { operationElegida(rest) }
        multiBtn.setOnClickListener { operationElegida(multi) }
        divBtn.setOnClickListener { operationElegida(div) }
        equalBtn.setOnClickListener { resolverElegido() }
    }
    companion object
    {
        const val sum = 1
        const val rest = 2
        const val multi = 3
        const val div = 4
        const val sinOp = 0
    }
    private fun numeroPresionado(num: String){
        if(resultadoView.text == "0" && num != ".") {
            resultadoView.text = "$num"
        } else {
            resultadoView.text = "${resultadoView.text}$num"
        }

        if(operacion == sinOp){
            num1 = resultadoView.text.toString().toDouble()
        } else {
            num2 = resultadoView.text.toString().toDouble()
        }
    }

    private fun operationElegida (operacion: Int){
        this.operacion = operacion
        num1 = resultadoView.text.toString().toDouble()

        resultadoView.text = "0"
    }

    private fun resolverElegido(){

        val result = when(operacion) {
            sum -> num1 + num2
            rest -> num1 - num2
            multi -> num1 * num2
            div -> num1 / num2
            else -> 0
        }

        num1 = result as Double

        resultadoView.text = if("$result".endsWith(".0")) { "$result".replace(".0","") } else { "%.2f".format(result) }
    }

    private fun borrarTodo(){
        resultadoView.text = "0"
        num1 = 0.0
        num2 = 0.0
    }
}