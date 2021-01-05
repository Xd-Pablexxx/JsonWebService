package com.examen.jsonwebservice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley


class JsonArrayRequestPrueba : Fragment() {
    private lateinit var dato: TextView
    private lateinit var btnrecibir: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root= inflater.inflate(R.layout.fragment_json_array_request_prueba, container, false)
        findviews(root)
        return root
    }
    fun JsonObjectRequest()
    {


        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this.requireContext())

        val url = "http://ventaskoalito.atspace.cc/Prueba/jsonArrayRequest.php"

        // Request a JSONObject response from the provided URL.

        val jsonArrayRequest = JsonArrayRequest(url,
            Response.Listener { response ->
                dato.text = response.toString()
            },
            Response.ErrorListener { error ->
                error.printStackTrace()
                Log.e("error", "That didn't work!")
            }
        )

        // Add the request to the RequestQueue.
        queue.add(jsonArrayRequest)
    }
    fun findviews(root:View)
    {
        dato=root.findViewById(R.id.text_JsonArray)
        btnrecibir=root.findViewById(R.id.recibir)
        btnrecibir.setOnClickListener {
            JsonObjectRequest()
        }

    }

}