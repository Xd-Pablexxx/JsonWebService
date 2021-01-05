package com.examen.jsonwebservice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.textfield.TextInputEditText
import org.json.JSONArray
import org.json.JSONObject


class JsonArrayRequestPost : Fragment() {
    private lateinit var dato: TextInputEditText
    private lateinit var dato2: TextInputEditText
    private lateinit var btnenviar: Button
    private lateinit var textArray: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root= inflater.inflate(R.layout.fragment_json_array_request_post, container, false)
        findviews(root)
        return root
    }
    fun findviews(root:View)
    {
        dato=root.findViewById(R.id.texto)
        dato2=root.findViewById(R.id.texto2)
        textArray=root.findViewById(R.id.text_JsonArray)
        btnenviar=root.findViewById(R.id.enviar)
        btnenviar.setOnClickListener {
            JsonArrayRequestPost()
        }

    }
    fun JsonArrayRequestPost()
    {


        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this.requireContext())

        val url = "http://ventaskoalito.atspace.cc/Prueba/jsonArrayRequestPost.php"

        val jsonArray = JSONArray()
        val jsonObject = JSONObject()
        jsonObject.put("nombre", dato.text.toString())
        jsonObject.put("edad", dato2.text.toString())
        jsonArray.put(jsonObject)
Log.i("infor",jsonArray.toString())
        // Request a JSONArray response from the provided URL.
        val jsonArrayRequest = object :JsonArrayRequest(
            Request.Method.POST, url, jsonArray,
            Response.Listener { response ->
                Log.i("llego", "Response is: ${response.toString()}")
                textArray.text=response.toString()
            },
            Response.ErrorListener { error ->
                error.printStackTrace()
                Log.e("error", "That didn't work!")
            }
        )
        {

        }

        // Add the request to the RequestQueue.
        queue.add(jsonArrayRequest)
    }

}