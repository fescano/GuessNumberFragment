package com.example.guessnumberfragment.UI;

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
import android.widget.Toast;

import com.example.guessnumberfragment.R;
import com.example.guessnumberfragment.data.User;
import com.example.guessnumberfragment.databinding.FragmentPlayBinding;

/**
 * Clase que maneja el fragment PlayFragment y muestra la segunda pantalla de la Application
 */
public class PlayFragment extends Fragment {
    //region VARIABLES GLOBALES
    private static final String TAG = "GuessNumberFragment";
    private FragmentPlayBinding binding;
    //endregion

    //region CONSTRUCTOR DE LA CLASE
    public PlayFragment() {
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
        Log.d(TAG, "PlayFragment -> onAttach()");
    }
    /**
     * Método Callback que se ejecuta cuandose crea el fragment
     * @param savedInstanceState Bundle que contiene datos de una instancia anterior de este
     *                           fragment
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "PlayFragment -> onCreate()");
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
        binding = FragmentPlayBinding.inflate(inflater);
        binding.btRetry.setEnabled(false);
        binding.btInput.setOnClickListener(view -> guess());
        binding.btRetry.setOnClickListener(view -> clear());
        Log.d(TAG, "PlayFragment -> onCreateView()");
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
        if (getArguments() == null)
        {
            binding.btInput.setEnabled(false);
            binding.etInput.setEnabled(false);
            binding.btRetry.setEnabled(false);
            binding.setUser(new User());
        }
        else
            binding.setUser(getArguments().getParcelable(User.KEY));
        Log.d(TAG, String.valueOf(binding.getUser().getNumero()));
        Log.d(TAG, "PlayFragment -> onViewCreated()");
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "PlayFragment -> onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "PlayFragment -> onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "PlayFragment -> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "PlayFragment -> onStop()");
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "PlayFragment -> onDestroyView()");
        super.onDestroyView();
        binding = null;
    }

    /**
     * Método Callback que se ejecuta cuando se quiere destruir el Fragment actual
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "PlayFragment -> onDestroy()");
    }

    /**
     * Método Callback que se ejecuta cuando se deja de asociar el fragment con la activity
     */
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "PlayFragment -> onDetach()");
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
        if(savedInstanceState != null) //Si vengo de u ncambio de configuracion, recupero el estado del fragment
            if(binding != null) // Si existe la vista del fragment
                binding.setUser(savedInstanceState.getParcelable(User.KEY));
        Log.d(TAG, "PlayFragment -> onViewStateRestored()");
    }

    /**
     * Método que se ejecuta antes de destruir el fragment y guarda contenido que quieres que se
     * muestre cuando se crea de nuevo el fragment
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(binding != null) //Solo cuando existe la vista la guardo
            outState.putParcelable(User.KEY, binding.getUser());
        Log.d(TAG, "PlayFragment -> onSaveInstanceState()");
    }
    //endregion
    /**
     * Este método recoge y comprueba si el número escrito por el usuario es el número correcto
     * y si no ha gastado todos sus intentos, si se cumple alguna de las condiciones, adivina el
     * número o gasta sus intentos, llama a un método auxiliar startEnding() para lanzar el
     * último fragment
     */
    private void guess() {
        binding.btInput.setEnabled(false);
        binding.etInput.setEnabled(false);
        binding.btRetry.setEnabled(true);
        if (binding.getUser().getIntentos() == (binding.getUser().getIntentosMax()- 1))
        {
            if (binding.etInput.getText().toString().equals(""))
                binding.getUser().setNumeroEscrito(0);
            else
                binding.getUser().setNumeroEscrito(Integer.parseInt(binding.etInput.getText().toString()));
            startEnding();
            return;
        }
        if (binding.etInput.getText().toString().equals(""))
        {
            binding.getUser().setNumeroEscrito(0);
            binding.getUser().setIntentos(binding.getUser().getIntentos() + 1);
            Toast.makeText(getActivity(), getResources().getString(R.string.intentosRestantes) + ((binding.getUser().getIntentosMax()) - binding.getUser().getIntentos()), Toast.LENGTH_SHORT).show();
        }
        else
        {
            binding.getUser().setNumeroEscrito(Integer.parseInt(binding.etInput.getText().toString()));
            if (binding.getUser().getNumeroEscrito() != binding.getUser().getNumero())
            {
                if (binding.getUser().getNumeroEscrito() > binding.getUser().getNumero())
                    binding.tvMessage.setText(getResources().getString(R.string.tvMessageMayor));
                else if (binding.getUser().getNumeroEscrito() < binding.getUser().getNumero())
                    binding.tvMessage.setText(getResources().getString(R.string.tvMessageMenor));
                binding.getUser().setIntentos(binding.getUser().getIntentos() + 1);
                Toast.makeText(getActivity(), getResources().getString(R.string.intentosRestantes) + ((binding.getUser().getIntentosMax()) - binding.getUser().getIntentos()), Toast.LENGTH_SHORT).show();
            }
            else
                startEnding();
        }
    }

    /**
     * Este método vacía los textos de la vista y habilita e inhabilita los botones
     */
    private void clear() {
        binding.etInput.setText("");
        binding.tvMessage.setText("");
        binding.btInput.setEnabled(true);
        binding.etInput.setEnabled(true);
        binding.btRetry.setEnabled(false);
    }

    /**
     * Este método lanza EndPlayFragment con un bundle que contiene el usuario
     */
    private void startEnding()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable(User.KEY, binding.getUser());
        NavHostFragment.findNavController(this).navigate(R.id.endPlayFragment, bundle);
        setArguments(null);
    }
    //endregion
}