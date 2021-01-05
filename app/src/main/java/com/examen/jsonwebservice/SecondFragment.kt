package com.examen.jsonwebservice

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.TextView

import org.json.JSONArray


class SecondFragment : Fragment() {

    private lateinit var root: View
    private lateinit var formato_Json:TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root= inflater.inflate(R.layout.fragment_second, container, false)
        val bundle: Bundle?=arguments
        formato_Json=root.findViewById(R.id.formato_Json)
        var texto:CharSequence="["
        var dato=bundle!!.getString("Json")!!


        var jsonArray: JSONArray = JSONArray(dato)

        for (i in 0..jsonArray.length()-1)
        {
            texto= TextUtils.concat(texto,"{")
            var jsonObject=jsonArray.getJSONObject(i)


            var susuario= SpannableString(jsonObject.getString("Usuario"))
            var samaterno= SpannableString(jsonObject.getString("AMaterno"))
            var sapaterno= SpannableString(jsonObject.getString("APaterno"))
            var snombre= SpannableString(jsonObject.getString("Nombre"))


            var semail= SpannableString(jsonObject.getString("Email"))
            susuario.setSpan(ForegroundColorSpan(Color.rgb(45,152,98)),0,  susuario.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            snombre.setSpan(ForegroundColorSpan(Color.rgb(45,152,98)),0,snombre.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            sapaterno.setSpan(ForegroundColorSpan(Color.rgb(45,152,98)),0,sapaterno.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            samaterno.setSpan(ForegroundColorSpan(Color.rgb(45,152,98)),0,samaterno.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            semail.setSpan(ForegroundColorSpan(Color.rgb(45,152,98)),0,semail.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            var ssusuario= SpannableString("Usuario")
            var ssnombre= SpannableString("Nombre")
            var ssapaterno= SpannableString("APaterno")
            var ssamaterno= SpannableString("AMaterno")
            var ssemail= SpannableString("Email")
            ssusuario.setSpan(ForegroundColorSpan(Color.rgb(59,195,205)),0,"Usuario".length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            ssnombre.setSpan(ForegroundColorSpan(Color.rgb(59,195,205)),0,"Nombre".length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            ssapaterno.setSpan(ForegroundColorSpan(Color.rgb(59,195,205)),0,"APaterno".length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            ssamaterno.setSpan(ForegroundColorSpan(Color.rgb(59,195,205)),0,"AMaterno".length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            ssemail.setSpan(ForegroundColorSpan(Color.rgb(59,195,205)),0,"Email".length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            texto= TextUtils.concat(texto,ssusuario,":",susuario,",",ssnombre,":",snombre,",",ssapaterno,":",sapaterno,",",ssamaterno,":",samaterno,",",ssemail,":",semail,"}")


        }
        texto= TextUtils.concat(texto,"]")
        formato_Json.text=texto
        return root
    }


}