package com.examen.jsonwebservice

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import org.json.JSONArray
import org.json.JSONObject


class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var jsonArray:JSONArray
    private lateinit var btn_agregar:Button
    private lateinit var txt_Usuario:TextInputEditText
    private lateinit var txt_Nombre:TextInputEditText
    private lateinit var txt_Apaterno:TextInputEditText
    private lateinit var txt_Amaterno:TextInputEditText
    private lateinit var txt_Email:TextInputEditText
    private lateinit var btn_enviar:ExtendedFloatingActionButton
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        jsonArray= JSONArray()
        findViews(root)
        return root
    }
    fun findViews(root:View)
    {
        btn_agregar=root.findViewById(R.id.btn_agregar)
        btn_enviar=root.findViewById(R.id.btn_enviar)
        txt_Usuario=root.findViewById(R.id.txt_Usuario)
        txt_Nombre=root.findViewById(R.id.txt_Nombre)
        txt_Apaterno=root.findViewById(R.id.txt_Apaterno)
        txt_Amaterno=root.findViewById(R.id.txt_Amaterno)
        txt_Email=root.findViewById(R.id.txt_Email)
        btn_agregar.setOnClickListener(this)
        btn_enviar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.btn_agregar->
            {
                var jsonObject= JSONObject()
                jsonObject.put("Usuario",txt_Usuario.text)
                jsonObject.put("Nombre",txt_Nombre.text)
                jsonObject.put("APaterno",txt_Apaterno.text)
                jsonObject.put("AMaterno",txt_Amaterno.text)
                jsonObject.put("Email",txt_Email.text)
                jsonArray.put(jsonObject)
                Toast.makeText(this.requireContext(),"Exito", Toast.LENGTH_SHORT).show()


            }
            R.id.btn_enviar->
            {
                var bundle=Bundle()
                bundle.putString("Json",jsonArray.toString())
                Navigation.findNavController(p0).navigate(R.id.secondFragment,bundle)

            }
        }
    }
}