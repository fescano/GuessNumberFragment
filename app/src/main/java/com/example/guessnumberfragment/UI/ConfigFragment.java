package com.example.guessnumberfragment.UI;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.guessnumberfragment.R;
import com.example.guessnumberfragment.data.User;
import com.example.guessnumberfragment.databinding.FragmentConfigBinding;
/**
 * <h1>Proyecto GuessNumberFragment</h1>
 * En este proyecto se realizan las siguientes operaciones
 * <ol>
 *     <li>Crear varios fragment</li>
 *     <li>Enlazar el código con la vista mediante ViewBinding</li>
 *     <li>Enlazar la vista con un POJO mediante Databinding</li>
 *     <li>Crear un Intent y un elemento Bundle para pasar información entre fragments</li>
 *     <li>Ver el ciclo de vida de una Activity</li>
 *     <li>Manejar la pila de fragments</li>
 * </ol>
 *
 * @author Fernando Escaño Martín
 * @version 1.0
 * @see
 * @see android.app.Activity
 * @see android.content.Intent
 * @see android.os.Bundle
 */

/**
 * Clase que maneja el fragment ConfigFragment y muestra la primera pantalla de la Application
 */
public class ConfigFragment extends Fragment {

    //region VARIABLES GLOBALES
    private static final String TAG = "GuessNumberFragment";
    private FragmentConfigBinding binding;
    //endregion

    //region CONSTRUCTOR DE LA CLASE
    public ConfigFragment() {
    }
    //endregion

    //region MÉTODOS
    //region MÉTODOS CALLBACK
    //region CICLO DE VIDA DE LA ACTIVIDAD
    /**
     * Método Callback que se ejecuta cuando se asocia el fragment con la activity
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "ConfigFragment -> onAttach()");
    }
    /**
     * Método Callback que se ejecuta cuandose crea el fragment
     * @param savedInstanceState Bundle que contiene datos de una instancia anterior de este
     *                           fragment
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "ConfigFragment -> onCreate()");
    }

    /**
     * Método Callback que se ejecuta para asociar el layout al fragment
     * @param savedInstanceState Bundle que contiene datos de una instancia anterior de este
     *                           fragment
     * @return Devuelve la vista que se va a reflejar en la ejecución del fragment, puede devolver
     *         NULL si la el fragmento no suministra una interfaz de usuario
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentConfigBinding.inflate(inflater);
        binding.setUser(new User());
        binding.btSend.setOnClickListener(view -> play());
        Log.d(TAG, "ConfigFragment -> onCreateView()");
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "ConfigFragment -> onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "ConfigFragment -> onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "ConfigFragment -> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "ConfigFragment -> onStop()");
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "ConfigFragment -> onDestroyView()");
        super.onDestroyView();
        binding = null;
    }

    /**
     * Método Callback que se ejecuta cuando se quiere destruir el Fragment actual
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ConfigFragment -> onDestroy()");
    }

    /**
     * Método Callback que se ejecuta cuando se deja de asociar el fragment con la activity
     */
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "ConfigFragment -> onDetach()");
    }
    //endregion


    /**
     * Método Callback que se ejecuta al resturar el estado guardado de la vista de este fragment
     * @param savedInstanceState Bundle que contiene datos de una instancia anterior de este
     *                           fragment
     */
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState != null)
            if(binding != null)
                binding.setUser(savedInstanceState.getParcelable(User.KEY));
        Log.d(TAG, "ConfigFragment -> onViewStateRestored");
    }

    /**
     * Método que se ejecuta antes de destruir el fragment y guarda contenido que quieres que se
     * muestre cuando se crea de nuevo el fragment
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(binding != null)
            outState.putParcelable(User.KEY, binding.getUser());
        Log.d(TAG, "ConfigFragment -> onSaveInstanceState()");
    }
    //endregion
    /**
     * Método que comprueba si los EditText no estan vacios y de que uno de ellos solo contiene
     * números, ademas de lanzar PlayFragment mediante un NavHostFragment con un bundle que contiene
     * un POJO de usuario
     */
    public void play() {
        if (!TextUtils.isEmpty(binding.etMessage.getText().toString()) && !TextUtils.isEmpty(binding.etUser.getText().toString())) {
            if (Integer.parseInt(binding.etMessage.getText().toString()) > 0) {
                Bundle bundle = new Bundle();
                binding.getUser().setNumero((int)Math.floor(Math.random()*(100-1+1)+1));
                binding.getUser().setIntentos(0);
                binding.getUser().setNumeroEscrito(0);
                bundle.putParcelable(User.KEY, binding.getUser());
                NavHostFragment.findNavController(this).navigate(R.id.playFragment, bundle);
            } else {
                Toast.makeText(getActivity(), getResources().getString(R.string.menorQueCero), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), getResources().getString(R.string.setnumber), Toast.LENGTH_SHORT).show();
        }
    }
    //endregion
}