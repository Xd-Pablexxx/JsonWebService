package com.examen.jsonwebservice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText


class StringRequestPrueba : Fragment() {

    private lateinit var dato:TextInputEditText
    private lateinit var btnenviar:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root=inflater.inflate(R.layout.fragment_string_request, container, false)
        findviews(root)
        return  root
    }
    fun stringRequest() {

        //Toast.makeText(this.context,dato.text.toString(),Toast.LENGTH_SHORT).show()
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this.requireContext())

        val url = "http://ventaskoalito.atspace.cc/Prueba/stringRequest.php"

        // Request a string response from the provided URL.
        val stringRequest =object :StringRequest(Request.Method.POST,url,
            Response.Listener<String> { response ->
              Snackbar.make(this.requireView(),response.toString(),Snackbar.LENGTH_LONG).show()

            },
            Response.ErrorListener { error ->
                error.printStackTrace()

            })
        {
            override fun getParams(): MutableMap<String, String> {
                var params=HashMap<String,String>()
                params.put("dato",dato.text.toString())
                return params
            }


        }

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
    fun findviews(root:View)
    {
        dato=root.findViewById(R.id.texto)
        btnenviar=root.findViewById(R.id.enviar)
        btnenviar.setOnClickListener {
            stringRequest()
        }

    }

}