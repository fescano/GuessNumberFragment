package com.example.guessnumberfragment.UI;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.guessnumberfragment.R;
import com.vansuita.materialabout.builder.AboutBuilder;

/**
 * Clase que maneja el fragment AboutUsFragment y muestra una vista con información sobre el creador
 * de la aplicación
 */
public class AboutUsFragment extends Fragment {

    //region VARIABLES GLOBALES
    private static final String TAG = "GuessNumberFragment";
    //endregion

    //region CONSTRUCTOR DE LA CLASE
    public AboutUsFragment() {
    }
    //endregion

    //region MÉTODOS CALLBACK
    //region CICLO DE VIDA DEL FRAGMENT
    /**
     * Método Callback que se ejecuta cuando se asocia el fragment con la activity
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "AboutUsFragment -> onAttach()");
    }

    /**
     * Método Callback que se ejecuta cuandose crea el fragment
     * @param savedInstanceState Bundle que contiene datos de una instancia anterior de este
     *                           fragment
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "AboutUsFragment -> onCreate()");
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
        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                MenuItem item =menu.findItem(R.id.iAboutUs);
                item.setVisible(false);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        Log.d(TAG, "AboutUsFragment -> onCreateView()");
        return AboutBuilder.with(requireActivity())
                .setPhoto(R.mipmap.ic_launcher)
                .setName(getResources().getString(R.string.aboutUsCreator))
                .setSubTitle(getResources().getString(R.string.aboutUsSubTittle))
                .setBrief(getResources().getString(R.string.aboutUsBrief))
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGitHubLink(getResources().getString(R.string.aboutUsCreator))
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "AboutUsFragment -> onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "AboutUsFragment -> onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "AboutUsFragment -> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "AboutUsFragment -> onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "AboutUsFragment -> onDestroyView()");
    }

    /**
     * Método Callback que se ejecuta cuando se quiere destruir el Fragment actual
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "AboutUsFragment -> onDestroy()");
    }

    /**
     * Método Callback que se ejecuta cuando se deja de asociar el fragment con la activity
     */
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "AboutUsFragment -> onDetach()");
    }
    //endregion
    //endregion

}