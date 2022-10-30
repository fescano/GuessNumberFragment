package com.example.guessnumberfragment.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guessnumberfragment.R;
import com.example.guessnumberfragment.data.User;
import com.example.guessnumberfragment.databinding.FragmentEndPlayBinding;

/**
 * Clase que maneja el fragment EndPlayFragment y muestra la tercera pantalla de la Application
 */
public class EndPlayFragment extends Fragment {
    //region VARIABLES GLOBALES
    private static final String TAG = "GuessNumberFragment";
    private FragmentEndPlayBinding binding;
    //endregion

    //region CONSTRUCTOR DE LA CLASE
    public EndPlayFragment() {
    }
    //endregion

    //region MÉTODOS
    //region MÉTODOS CALLBACK
    //region CICLO DE VIDA DEL FRAGMENT
    /**
     * Método Callback que se ejecuta cuando se asocia el fragment con la activity
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "EndPlayFragment -> onAttach()");
    }
    /**
     * Método Callback que se ejecuta cuandose crea el fragment
     * @param savedInstanceState Bundle que contiene datos de una instancia anterior de este
     *                           fragment
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "EndPlayFragment -> onCreate()");
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
        binding = FragmentEndPlayBinding.inflate(inflater);
        binding.btFinish.setOnClickListener(view -> restart());
        Log.d(TAG, "EndPlayFragment -> onCreateView()");
        return binding.getRoot();
    }

    /**
     * Método Callback que se ejecuta despues de asociar el layout al fragment
     * @param savedInstanceState Bundle que contiene datos de una instancia anterior de este
     *                           fragment
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null)
            binding.setUser(getArguments().getParcelable(User.KEY));
        fin();
        Log.d(TAG, "EndPlayFragment -> onViewCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "EndPlayFragment -> onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "EndPlayFragment -> onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "EndPlayFragment -> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "EndPlayFragment -> onStop()");
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "EndPlayFragment -> onDestroyView()");
        super.onDestroyView();
        binding = null;
    }

    /**
     * Método Callback que se ejecuta cuando se quiere destruir el Fragment actual
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "EndPlayFragment -> onDestroy()");
    }

    /**
     * Método Callback que se ejecuta cuando se deja de asociar el fragment con la activity
     */
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "EndPlayFragment -> onDetach()");
    }
    //endregion
    //endregion
    /**
     * Este método nos devuelve al primer Fragment, ConfigFragment
     */
    private void restart() {
        NavHostFragment.findNavController(this).navigate(R.id.action_endPlayFragment_to_configFragment);
    }

    /**
     * Este método comprueba las distintas condiciones de victoria para mostrar una vista u otra
     */
    private void fin() {
        if ((binding.getUser().getIntentos() == binding.getUser().getIntentosMax() - 1) && (binding.getUser().getNumero() != binding.getUser().getNumeroEscrito()))
            Texto(1);
        else
            Texto(0);
    }

    /**
     * Este método ajusta la vista de este fragment segun el parámetro recibido: flag
     * @param flag Parámetro de tipo Integer que indica qué vista preparar
     */
    @SuppressLint("SetTextI18n")
    private void Texto(int flag)
    {
        if (flag == 1)
        {
            binding.tvFinalText.setTextColor(requireActivity().getColor(R.color.rojo));
            binding.tvFinalText.setText(R.string.tvFinalTextP);
        }
        else
        {
            binding.tvFinalText.setTextColor(requireActivity().getColor(R.color.verde));
            binding.tvFinalText.setText(R.string.tvFinalTextV);
        }
        binding.tvDesgloseText.setText(binding.getUser().getName() + getString(R.string.tvDesgloseText1)
                + (binding.getUser().getIntentos() + 1) + getString(R.string.tvDesgloseText2) + binding.getUser().getIntentosMax()
                + getString(R.string.tvDesgloseText3)
                + binding.getUser().getNumero());
    }
    //endregion
}