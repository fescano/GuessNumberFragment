package com.example.guessnumberfragment.data;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;

import java.io.Serializable;

/**
 * Clase POJO que contiene información acerca del usuario que maneja la aplicación
 */
public class User implements Serializable, Parcelable {

    //region CAMPOS
    public static final String KEY = "user";
    private String name;
    private int intentosMax;
    private int numero;
    private int intentos;
    private int numeroEscrito;
    //endregion

    //region CONSTRUCTOR
    public User() {
    }
    //endregion

    //region GETTERS Y SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIntentosMax() {
        return intentosMax;
    }

    public void setIntentosMax(int intentosMax) {
        this.intentosMax = intentosMax;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getNumeroEscrito() {
        return numeroEscrito;
    }

    public void setNumeroEscrito(int numeroEscrito) {
        this.numeroEscrito = numeroEscrito;
    }
    //endregion

    //region MÉTODOS DEL BINDINGADAPTER
    @SuppressLint("SetTextI18n")
    @BindingAdapter("android:text")
    public static void setText(TextView view, int value) {
        view.setText(Integer.toString(value));
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static int getText(TextView view) {
        if (view.getText().toString().equals(""))
            return 0;
        else
            return Integer.parseInt(view.getText().toString());
    }
    //endregion

    //region MÉTODOS CREADOS DE LA INTERFAZ PARCELABLE
    protected User(Parcel in) {
        name = in.readString();
        intentosMax = in.readInt();
        numero = in.readInt();
        intentos = in.readInt();
        numeroEscrito = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(intentosMax);
        dest.writeInt(numero);
        dest.writeInt(intentos);
        dest.writeInt(numeroEscrito);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    //endregion
}


